package com.beyontec.mol.resource;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.SmartValidator;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.beyontec.mol.entity.Claim;
import com.beyontec.mol.exception.ErrorCode;
import com.beyontec.mol.exception.ValidationException;
import com.beyontec.mol.modal.DMSDocumentMetadata;
import com.beyontec.mol.modal.DMSDocumentMetadataDTO;
import com.beyontec.mol.service.ClaimService;
import com.beyontec.mol.service.DMSService;
import com.beyontec.mol.util.DMSConstants;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/dms")
public class DMSResource {

	@Autowired
	SmartValidator validator;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private DMSService dmsService;

	@Autowired
	private ClaimService claimService;

	@PostMapping(value = "/upload-multiple", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> uploadMultiple(@RequestPart(value = "metadata", required = true) String metaDataJson,
			@RequestPart(value = "documents", required = true) MultipartFile[] documents, HttpServletRequest request)
			throws Exception {

		DMSDocumentMetadataDTO documentMetadataDTO = null;
		try {
			documentMetadataDTO = objectMapper.readValue(metaDataJson, DMSDocumentMetadataDTO.class);
		} catch (IOException e) {
            throw new ValidationException(ErrorCode.MALFORMED_JSON_EXCEPTION);
		}

		if (StringUtils.isEmpty(documentMetadataDTO.getEntityRefId())
				|| StringUtils.isEmpty(documentMetadataDTO.getEntityRefType())) {
            throw new ValidationException(ErrorCode.MISSING_MANDATORY_FIELDS);
		}

		List<DMSDocumentMetadata> documentMetadataList = dmsService.uploadDocument(documentMetadataDTO, documents,
				request.getHeader(HttpHeaders.AUTHORIZATION));
		if (documentMetadataList.size() > 0) {
			Claim claim = new Claim();
			claim.setComplaintNumber(documentMetadataDTO.getEntityRefId());
			claimService.addDocumentDetails(claim, documentMetadataList);
			return new ResponseEntity<>(documentMetadataList, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(documentMetadataList, HttpStatus.NOT_FOUND);
	}

	@GetMapping(value = "/metadata", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DMSDocumentMetadata>> getMetadata(
			@RequestParam(value = "entityRefId", required = true) String entityRefId,
			@RequestParam(value = "entityRefType", required = true) String entityRefType, HttpServletRequest request)
			throws Exception {

		DMSDocumentMetadataDTO documentMetadataDTO = new DMSDocumentMetadataDTO(entityRefId, entityRefType);
		List<DMSDocumentMetadata> results = dmsService.getDocumentList(documentMetadataDTO,
				request.getHeader(HttpHeaders.AUTHORIZATION));
		return new ResponseEntity<>(results, HttpStatus.OK);
	}

	@GetMapping(value = "/document/{id}")
	public ResponseEntity<byte[]> downloadDocument(@PathVariable("id") String gridFSId, HttpServletRequest request)
			throws Exception {

		Map<String, Object> documentDetails = dmsService.getDocument(gridFSId,
				request.getHeader(HttpHeaders.AUTHORIZATION));
		return new ResponseEntity<>((byte[]) documentDetails.get(DMSConstants.DOCUMENT),
				(HttpHeaders) documentDetails.get(DMSConstants.HTTP_HEADER), HttpStatus.OK);
	}

	@DeleteMapping(value = "/document/{id}")
	public ResponseEntity<?> deleteDocument(@PathVariable("id") String gridFSId, HttpServletRequest request)
			throws Exception {

		boolean isDeleted = dmsService.deleteDocument(gridFSId, request.getHeader(HttpHeaders.AUTHORIZATION));
		return isDeleted ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

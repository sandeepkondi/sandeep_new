package com.beyontec.mol.service;

import java.io.File;
import java.net.ConnectException;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.beyontec.mol.exception.ErrorCode;
import com.beyontec.mol.exception.ValidationException;
import com.beyontec.mol.modal.DMSDocumentMetadata;
import com.beyontec.mol.modal.DMSDocumentMetadataDTO;
import com.beyontec.mol.util.DMSConstants;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class DMSService {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private RestTemplate restTemplate;

	@Value("${dms.uri}")
	private String dmsBaseUrl;

    public DMSDocumentMetadata generateDocument(DMSDocumentMetadataDTO documentMetadataDTO,
                                                Map<String, String> data,
                                                String template,
                                                String authHeader) throws Exception {
        
        HttpHeaders headers = getHttpHeaders(authHeader);
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add(DMSConstants.METADATA, objectMapper.writeValueAsString(documentMetadataDTO));
        body.add(DMSConstants.DATA, objectMapper.writeValueAsString(data));
        body.add(DMSConstants.TEMPLATE, template);

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
        ResponseEntity<String> response = null;
        try {
            response = restTemplate.postForEntity(dmsBaseUrl + DMSConstants.GENERATE_DOCUMENT,
                                                  requestEntity,
                    String.class);
        } catch (Exception ex) {
            handleException(ex);
        }

        return objectMapper.readValue(response.getBody(), DMSDocumentMetadata.class);
    }

    public Map<String, Object> generateDownloadDocument(Map<String, Object> data,
                                                        String template,
                                                        String authHeader) throws Exception {

        HttpHeaders headers = getHttpHeaders(authHeader);
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add(DMSConstants.DATA, objectMapper.writeValueAsString(data));
        body.add(DMSConstants.TEMPLATE, template);

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
        ResponseEntity<byte[]> response = null;
        try {
            response = restTemplate.postForEntity(dmsBaseUrl + DMSConstants.GENERATE_DOWNLOAD_DOCUMENT,
                                                  requestEntity,
                                                  byte[].class);
        } catch (Exception ex) {
            handleException(ex);
        }

        Map<String, Object> documentDetails = new HashMap<>();
        documentDetails.put(DMSConstants.HTTP_HEADER, response.getHeaders());
        documentDetails.put(DMSConstants.DOCUMENT, response.getBody());

        return documentDetails;
    }

	public List<DMSDocumentMetadata> getDocumentList(DMSDocumentMetadataDTO documentMetadataDTO, String authHeader)
			throws Exception {

        String url = MessageFormat.format(dmsBaseUrl + DMSConstants.GET_DOCUMENT_LIST,
                                          documentMetadataDTO.getEntityRefId(),
                                          documentMetadataDTO.getEntityRefType());

		ResponseEntity<String> response = null;
		try {
			response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<Object>(getHttpHeaders(authHeader)),
					String.class);
        } catch (Exception ex) {
			handleException(ex);
		}

        return Arrays.asList(objectMapper.readValue(response.getBody(), DMSDocumentMetadata[].class));
	}

	public Map<String, Object> getDocument(String gridFSId, String authHeader) throws Exception {

		String url = MessageFormat.format(dmsBaseUrl + DMSConstants.GET_DOCUMENT_CONTENT, gridFSId);

		ResponseEntity<byte[]> response = null;
		try {
			response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<Object>(getHttpHeaders(authHeader)),
					byte[].class);
		} catch (Exception ex) {
			handleException(ex);
		}

		Map<String, Object> documentDetails = new HashMap<>();
		documentDetails.put(DMSConstants.HTTP_HEADER, response.getHeaders());
		documentDetails.put(DMSConstants.DOCUMENT, response.getBody());
		
		return documentDetails;
	}

	public boolean deleteDocument(String gridFSId, String authHeader) throws Exception {

		String url = MessageFormat.format(dmsBaseUrl + DMSConstants.DELETE_DOCUMENT_CONTENT, gridFSId);

		try {
			restTemplate.exchange(url, HttpMethod.DELETE, new HttpEntity<Object>(getHttpHeaders(authHeader)),
					String.class);
		} catch (Exception ex) {
			handleException(ex);
		}

		return true;
	}

	public List<DMSDocumentMetadata> uploadDocument(DMSDocumentMetadataDTO documentMetadataDTO,
			MultipartFile[] documents, String authHeader) throws Exception {

		FileSystemResource[] fileSystemResources = new FileSystemResource[documents.length];

		int index = 0;
		for (MultipartFile document : documents) {

            File file = new File(System.getProperty("java.io.tmpdir")
                                 + File.separator
                                 + document.getOriginalFilename());
            document.transferTo(file);
			fileSystemResources[index] = new FileSystemResource(file);
			index++;
		}

		return uploadDocument(documentMetadataDTO, fileSystemResources, authHeader);
	}

	public DMSDocumentMetadata uploadDocument(DMSDocumentMetadataDTO documentMetadataDTO, FileSystemResource document,
			String authHeader) throws Exception {

		List<DMSDocumentMetadata> dmsDocumentMetadatas = uploadDocument(documentMetadataDTO,
				new FileSystemResource[] { document }, authHeader);
        return (dmsDocumentMetadatas != null && !dmsDocumentMetadatas.isEmpty()) ? dmsDocumentMetadatas.get(0) : null;
	}

	private List<DMSDocumentMetadata> uploadDocument(DMSDocumentMetadataDTO documentMetadataDTO,
			FileSystemResource[] documents, String authHeader) throws Exception {

		HttpHeaders headers = getHttpHeaders(authHeader);
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);

		MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
		body.add(DMSConstants.METADATA, objectMapper.writeValueAsString(documentMetadataDTO));
		for (FileSystemResource document : documents) {
			body.add(DMSConstants.DOCUMENTS, document);
		}

		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
		ResponseEntity<String> response = null;
		try {
			response = restTemplate.postForEntity(dmsBaseUrl + DMSConstants.UPLOAD_DOCUMENTS_URI, requestEntity,
					String.class);
		} catch (Exception ex) {
			handleException(ex);
		}

        return Arrays.asList(objectMapper.readValue(response.getBody(), DMSDocumentMetadata[].class));
	}

	private HttpHeaders getHttpHeaders(String authHeader) {

		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.AUTHORIZATION, authHeader);

		return headers;
	}

    private void handleException(Exception ex) throws Exception {

        if (ex.getCause() instanceof ConnectException) {
            throw new ValidationException(ErrorCode.DMS_UNAVAILABLE);
        } else if (ex instanceof HttpClientErrorException) {
            throwAppException(objectMapper.readTree(((HttpClientErrorException) ex).getResponseBodyAsString()));
        } else if (ex instanceof HttpServerErrorException) {
            throwAppException(objectMapper.readTree(((HttpServerErrorException) ex).getResponseBodyAsString()));
        } else {
            throw new ValidationException(ErrorCode.SERVER_ERROR_DMS);
		}
	}

    private void throwAppException(JsonNode exNode) throws Exception {

        if (StringUtils.isEmpty(exNode.get("code"))
            || StringUtils.isEmpty(ErrorCode.get(exNode.get("code").toString()))) {
            throw new ValidationException(ErrorCode.SERVER_ERROR_DMS);
        }
        throw new ValidationException(ErrorCode.get(exNode.get("code").toString()));
    }
}
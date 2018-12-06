package com.beyontec.mol.resource;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.beyontec.mol.entity.Claim;
import com.beyontec.mol.exception.ErrorCode;
import com.beyontec.mol.exception.ValidationException;
import com.beyontec.mol.modal.ClaimDTO;
import com.beyontec.mol.modal.ClaimFieldListingDTO;
import com.beyontec.mol.modal.ClaimListingDTO;
import com.beyontec.mol.modal.ClaimReason;
import com.beyontec.mol.modal.ClaimRegistartionListingDTO;
import com.beyontec.mol.modal.ClaimRegistrationResponse;
import com.beyontec.mol.modal.ClaimsSearchCriteria;
import com.beyontec.mol.modal.NewEstimate;
import com.beyontec.mol.modal.PagedResult;
import com.beyontec.mol.modal.PaginatedRequest;
import com.beyontec.mol.modal.PaymentDTO;
import com.beyontec.mol.modal.PaymentDetails;
import com.beyontec.mol.modal.PaymentListingDTO;
import com.beyontec.mol.modal.ResponseDTO;
import com.beyontec.mol.modal.UpdateClaimDTO;
import com.beyontec.mol.service.ClaimPaymentService;
import com.beyontec.mol.service.ClaimService;
import com.beyontec.mol.service.ClaimServiceAsync;
import com.beyontec.mol.util.AppConstants;
import com.beyontec.mol.util.CustomDateDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

@RestController
@RequestMapping("/api/claims")
public class ClaimResource {

	@Value("${date.format}")
	private String dateFormat;

	@Autowired
	private ClaimService claimService;

    @Autowired private ClaimServiceAsync claimServiceAsync;

	@Autowired
	private ClaimPaymentService claimPaymentService;

	@PostMapping(value = "/export")
    public ResponseEntity<ByteArrayResource> exportClaims(@RequestBody List<String> ids) throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {

        byte[] excelByteArray = claimService.exportClaims(ids);

		return ResponseEntity.ok().contentLength(excelByteArray.length)
                             .header(HttpHeaders.CONTENT_DISPOSITION,
                                     MessageFormat.format(AppConstants.ATTACHMENT,
                                                          AppConstants.CLAIMS_FILENAME
                                                                                   + AppConstants.EXCEL_FILE_EXTENSION))
                             .header(HttpHeaders.CONTENT_TYPE, AppConstants.EXCEL_CONTENT_TYPE)
				.body(new ByteArrayResource(excelByteArray));
	}

	@PostMapping(value = "/search")
    public ResponseEntity<PagedResult<ClaimListingDTO>> searchClaims(@RequestBody ClaimsSearchCriteria claimsSearchCriteria,
			PaginatedRequest paginatedRequest) {

		Date fromDate = claimsSearchCriteria.getFromDate();
		Date toDate = claimsSearchCriteria.getToDate();
		if (fromDate != null && toDate != null && fromDate.after(toDate)) {
            throw new ValidationException(ErrorCode.INVALID_DATES);
		}
		return ResponseEntity.ok(claimService.findAllClaimsBySearchCriteria(claimsSearchCriteria, paginatedRequest));
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, value = "/getclaim")
    public ResponseEntity<ClaimRegistartionListingDTO> getClaimById(@RequestParam("claimNo") String claimId,
                                                                    HttpServletRequest request)
			throws ParseException {
		ClaimRegistartionListingDTO claimRegistartionListing = claimService.getClaimRegistartionListingDTO(claimId,
				request.getLocale());
		return ResponseEntity.ok(claimRegistartionListing);
	}

	@PostMapping(value = "/create")
    public ResponseEntity<ClaimRegistrationResponse> createClaim(@RequestPart("claimInfo") String claimInfo,
			@RequestPart("documents") MultipartFile[] documents, HttpServletRequest request) throws Exception {

		ObjectMapper mapper = new ObjectMapper();
		SimpleModule module = new SimpleModule();
		module.addDeserializer(Date.class, new CustomDateDeserializer(dateFormat));
		mapper.registerModule(module);
		ClaimDTO claimDTO = mapper.readValue(claimInfo, ClaimDTO.class);

		Map<String, Object> map = claimService.createClaim(claimDTO, documents, request.getRemoteAddr(),
				request.getLocale(), request.getHeader(HttpHeaders.AUTHORIZATION));
		ClaimRegistrationResponse claimRegistrationResponse = (ClaimRegistrationResponse) map.get("claimResponse");
		if (map.get("errorDetails") != null) {
			Map<ErrorCode, Object[]> errorDetails = (Map<ErrorCode, Object[]>) map.get("errorDetails");
			throw new ValidationException(errorDetails);
		}

		Claim claim = (Claim) map.get("claim");
        claimServiceAsync.addClaimEntries(claim, request.getLocale());
		return ResponseEntity.ok(claimRegistrationResponse);
	}

	@PostMapping(value = "/update")
    public ResponseEntity<ResponseDTO> updateClaim(@RequestPart("claimInfo") String claimInfo,
			@RequestPart("documents") MultipartFile[] documents, HttpServletRequest request) throws Exception {

		ObjectMapper mapper = new ObjectMapper();
		UpdateClaimDTO updateClaimDTO = mapper.readValue(claimInfo, UpdateClaimDTO.class);

		return ResponseEntity.ok(claimService.updateClaim(updateClaimDTO, documents, request.getLocale(),
				request.getHeader(HttpHeaders.AUTHORIZATION)));
	}

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, value = "/searchParams")
    public ResponseEntity<ClaimFieldListingDTO> getClaimCriteriaDetails() {
        return ResponseEntity.ok(claimService.getSearchCriteriaValues());
	}

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, value = "/payment")
    public ResponseEntity<PaymentListingDTO> getPaymentDetails(@RequestParam("claimNo") String claimNo,
                                               @RequestHeader("userGroupId") String userGroupId) {
        return ResponseEntity.ok(claimService.getPayemntListingDTO(claimNo, userGroupId));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, value = "/actions")
    public ResponseEntity<List<String>> getClaimActions(@RequestParam("claimNo") String claimId,
                                                        HttpServletRequest request) {

		List<String> actions = claimService.getActions(claimId, request.getLocale());
		return ResponseEntity.ok(actions);
	}

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, value = "/{action}/reasons")
    public ResponseEntity<Set<String>> getClaimActionReasons(@PathVariable("action") String action) {

		Set<String> claimActionReasons = claimService.getClaimActionReasons(action);
		return ResponseEntity.ok(claimActionReasons);
	}

	@PostMapping(value = "/reopen")
    public ResponseEntity<ResponseDTO> reopenClaim(@RequestParam("claimNo") String claimNo,
                                                   @RequestBody ClaimReason claimReason,
			HttpServletRequest request) {
		return ResponseEntity.ok(new ResponseDTO(claimService.reopenClaim(claimNo, claimReason)));
	}

	@PostMapping(value = "/close")
    public ResponseEntity<ResponseDTO> closeClaim(@RequestParam("claimNo") String claimNo,
                                                  @RequestBody ClaimReason claimReason,
			HttpServletRequest request) {
		return ResponseEntity.ok(new ResponseDTO(claimService.closeClaim(claimNo, claimReason)));
	}

	@PostMapping(value = "/decline")
    public ResponseEntity<ResponseDTO> declineClaim(@RequestParam("claimNo") String claimNo,
                                                    @RequestBody ClaimReason claimReason,
			HttpServletRequest request) {
		return ResponseEntity.ok(new ResponseDTO(claimService.declineClaim(claimNo, claimReason)));
	}

	@PostMapping(value = "/reason")
    public ResponseEntity<ResponseDTO> updateClaimReason(@RequestParam("claimNo") String claimNo,
			@RequestBody ClaimReason claimReason, HttpServletRequest request) {
		return ResponseEntity.ok(new ResponseDTO(claimService.updateClaimReason(claimNo, claimReason)));
	}

    @PostMapping(value = "/approve-payment/accept")
    public ResponseEntity<ResponseDTO> acceptPaymentApproval(@RequestParam("claimNo") String claimNo,
                                                   @RequestHeader("userGroupId") String userGroupId) {
        return ResponseEntity.ok(new ResponseDTO(claimPaymentService.acceptPaymentApproval(claimNo, userGroupId)));
    }

    @PostMapping(value = "/approve-payment/reject")
    public ResponseEntity<ResponseDTO> rejectPaymentApproval(@RequestParam("claimNo") String claimNo,
                                                   @RequestHeader("userGroupId") String userGroupId) {
        return ResponseEntity.ok(new ResponseDTO(claimPaymentService.rejectPaymentApproval(claimNo, userGroupId)));
    }

    @PostMapping(value = "/approve-payment/edit")
    public ResponseEntity<ResponseDTO> updatePaymentApproval(@RequestBody PaymentDetails paymentDetails,
                                                   @RequestParam("claimNo") String claimNo) {
        return ResponseEntity.ok(new ResponseDTO(claimPaymentService.updatePaymentDetails(claimNo, paymentDetails)));
    }

    @PostMapping(value = "/review-payment/accept")
    public ResponseEntity<ResponseDTO> acceptPaymentReview(@RequestParam("claimNo") String claimNo,
                                                 @RequestHeader("userGroupId") String userGroupId) {
        return ResponseEntity.ok(new ResponseDTO(claimPaymentService.acceptPaymentReview(claimNo, userGroupId)));
    }

    @PostMapping(value = "/review-payment/reject")
    public ResponseEntity<ResponseDTO> rejectPaymentReview(@RequestParam("claimNo") String claimNo,
                                                 @RequestHeader("userGroupId") String userGroupId) {
        return ResponseEntity.ok(new ResponseDTO(claimPaymentService.rejectPaymentReview(claimNo, userGroupId)));
    }

    @PostMapping(value = "/review-payment/edit")
    public ResponseEntity<ResponseDTO> updatePaymentReview(@RequestBody PaymentDetails paymentDetails,
                                                 @RequestParam("claimNo") String claimNo) {
        return ResponseEntity.ok(new ResponseDTO(claimPaymentService.updatePaymentDetails(claimNo, paymentDetails)));
    }
    

    @PostMapping(value = "/new-estimate")
    public ResponseEntity<ResponseDTO> addNewEstimate(@RequestParam("claimNo") String claimNo,
                                                      NewEstimate newEstimate) {
    	
    	return ResponseEntity.ok(new ResponseDTO(claimPaymentService.addNewEstimate(claimNo, newEstimate)));
    }
    
    @PostMapping(value = "/payment/create")
    public ResponseEntity<ResponseDTO> createPayment(@RequestBody PaymentDTO paymentDTO, HttpServletRequest request) {

		return ResponseEntity.ok(new ResponseDTO(claimPaymentService.createPayment(paymentDTO,  request.getLocale())));
	}
}

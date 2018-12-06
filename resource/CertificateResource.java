package com.beyontec.mol.resource;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.beyontec.mol.entity.CertificateDetails;
import com.beyontec.mol.entity.PolicyHistory;
import com.beyontec.mol.entity.UpdateCertificateDetails;
import com.beyontec.mol.exception.ApplicationException;
import com.beyontec.mol.exception.ErrorCode;
import com.beyontec.mol.modal.AcknowledgementDTO;
import com.beyontec.mol.modal.BatchResponseDTO;
import com.beyontec.mol.modal.CancelCertificateDTO;
import com.beyontec.mol.modal.CertificateDTO;
import com.beyontec.mol.modal.CertificateExportCriteria;
import com.beyontec.mol.modal.CertificateResponseDTO;
import com.beyontec.mol.modal.CertificateSearchCriteria;
import com.beyontec.mol.modal.PaginatedRequest;
import com.beyontec.mol.modal.ResponseDTO;
import com.beyontec.mol.modal.UpdateCertificateDetailsDTO;
import com.beyontec.mol.modal.UpdateCertificateResponseDTO;
import com.beyontec.mol.modal.ViewCertificateDTO;
import com.beyontec.mol.service.BatchService;
import com.beyontec.mol.service.CertificateService;
import com.beyontec.mol.service.CertificateServiceAsync;
import com.beyontec.mol.util.AppConstants;
import com.beyontec.mol.util.DMSConstants;

@RestController
@RequestMapping("/api/certificate")
public class CertificateResource extends BaseResource {

    @Autowired private CertificateService certificateService;
    @Autowired private CertificateServiceAsync certificateServiceAsync;
    @Autowired private BatchService batchService;

	@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<CertificateResponseDTO> generateCertificate(@Valid @RequestBody CertificateDTO certificateDTO,
                                                                      HttpServletRequest request) throws Exception {

        String clientIpAddress = getClientIpAddress(request);
        CertificateDetails certificateDetails = certificateService.captureCertificateDetails(certificateDTO,
                                                                                             clientIpAddress);
        Map<String, Object> result = certificateService.createCertificate(certificateDetails,
                                                                          request.getHeader(HttpHeaders.AUTHORIZATION),
                                                                          request.getLocale());
		if (result.get(AppConstants.ERRORS) != null) {
            ApplicationException appException = (ApplicationException) result.get(AppConstants.ERRORS);
            throw appException;
		}

        PolicyHistory masterPolicy = (PolicyHistory) result.get(CertificateService.CERT_RESULT_KEY_MASTER_POLICY);
        certificateServiceAsync.addCertificateEntries(certificateDetails,
                                                      result.get(AppConstants.CERTIFICATE_NO).toString(),
                                                      masterPolicy,
                                                      request.getLocale());
        return ResponseEntity.ok(new CertificateResponseDTO(result.get(AppConstants.CERTIFICATE_NO).toString(),
                                                            (String) result.get(CertificateService.CERT_RESULT_KEY_APPROVAL_DATE),
                                                            (String) result.get(CertificateService.CERT_RESULT_KEY_EXPIRY_DATE)));
	}

	@RequestMapping(value = "/cancel", method = RequestMethod.POST)
	public ResponseEntity<ResponseDTO> cancelCertificate(@Valid @RequestBody CancelCertificateDTO cancelCertificateDTO,
                                                         HttpServletRequest httpServletRequest) throws Exception {

                String clientIpAddress = getClientIpAddress(httpServletRequest);
        ApplicationException ae = certificateService.cancelCertificate(cancelCertificateDTO,
                                                                       httpServletRequest.getLocale(),
                                                                       clientIpAddress);
		if (ae.hasError()) { throw ae; }

        certificateServiceAsync.cancelCertificateEntries(cancelCertificateDTO, httpServletRequest.getLocale());
		return ResponseEntity.ok(new ResponseDTO(true));
	}

	@GetMapping(value = "/download")
    public ResponseEntity<byte[]> downloadCertificate(@RequestParam("certificateNo") String certificateNo,
                                                      @RequestParam("emiratesId") String emiratesId,
                                                      @RequestParam("labourReferenceNo") String labourReferenceNo) throws Exception {

        Map<String, Object> documentDetails = certificateService.downloadCertificate(certificateNo,
                                                                                     emiratesId,
                                                                                     labourReferenceNo);

        return ResponseEntity.ok()
                             .headers((HttpHeaders) documentDetails.get(DMSConstants.HTTP_HEADER))
                             .header(HttpHeaders.CONTENT_DISPOSITION,
                                     MessageFormat.format(AppConstants.ATTACHMENT,
                                                          documentDetails.get(AppConstants.FILE_NAME)))
                             .body((byte[]) documentDetails.get(DMSConstants.DOCUMENT));
	}

	@GetMapping(value = "/view")
    public ResponseEntity<List<ViewCertificateDTO>> viewCertificate(@RequestParam("certificateNo") String certificateNo,
                                                                                      @RequestParam("emiratesId") String emiratesId,
                                                                                      @RequestParam("labourReferenceNo") String labourReferenceNo) throws Exception {

        List<ViewCertificateDTO> viewCertificateDetails = certificateService.viewCertificate(certificateNo,
                                                                                                               emiratesId,
                                                                                                               labourReferenceNo);
        return ResponseEntity.ok(viewCertificateDetails);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/acknowledge")
    public ResponseEntity<ResponseDTO> acknowledgeCertificate(@RequestBody AcknowledgementDTO acknowledgementDTO) throws Exception {
        return ResponseEntity.ok(new ResponseDTO(certificateService.acknowledgeCertificate(acknowledgementDTO)));
    }

    @GetMapping(value = "/payload")
    public ResponseEntity<CertificateDTO> payloadCertificate(@RequestParam("certificateNo") String certificateNo) throws Exception {
        return ResponseEntity.ok(certificateService.payloadCertificate(certificateNo));
    }

    @PostMapping(value = "/batch/{id}")
    public ResponseEntity<BatchResponseDTO> batchProcessCertificate(@PathVariable("id") long batchId,
                                                        WebRequest request) throws Exception {
        return ResponseEntity.ok(new BatchResponseDTO(batchService.startProcess(batchId,
                                                                                request.getHeader(HttpHeaders.AUTHORIZATION),
                                                                                request.getLocale())));
    }
    
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UpdateCertificateResponseDTO update(@RequestBody UpdateCertificateDetailsDTO updateCertificateDTO,
                                               HttpServletRequest request) {
        String clientIpAddress = getClientIpAddress(request);
        Map<String, Object> map = certificateService.captureUpdateCertificateDetails(updateCertificateDTO,
                                                                                     clientIpAddress);
        UpdateCertificateDetails updateCertificateDetails = (UpdateCertificateDetails) map.get("updateCertificate");

            Map<ErrorCode, Object[]> errorDetails = (Map<ErrorCode, Object[]>) map.get("errorDetails");
        if (errorDetails.size() > 0) {
            throw new com.beyontec.mol.exception.ValidationException(errorDetails);
        }
        Map<String, Object> result = certificateService.update(updateCertificateDetails,
                                                               request.getHeader(HttpHeaders.AUTHORIZATION),
                                                               request.getLocale(),
                                                               false);
        if (result.get(AppConstants.ERRORS) != null) {
            throw (ApplicationException) result.get(AppConstants.ERRORS);
        }

        certificateServiceAsync.update(updateCertificateDetails, request.getLocale());
        return new UpdateCertificateResponseDTO(true,
                                                (String) result.get(AppConstants.CERTIFICATE_NO));
    }

    @PutMapping(value = "/batch/{id}")
    public BatchResponseDTO update(@PathVariable("id") Long batchId, WebRequest request) {
        String updateResponse = batchService.update(batchId,
                                                    request.getHeader(HttpHeaders.AUTHORIZATION),
                                                    request.getLocale());
        BatchResponseDTO batchResponseDTO = new BatchResponseDTO(updateResponse);
        return batchResponseDTO;
    }

    @GetMapping(value = "/customer-category")
    public ResponseEntity<?> getCustomerCategory() throws Exception {
        return ResponseEntity.ok(certificateService.getCustomerCategory());
    }

    @PostMapping(value = "/search")
    public ResponseEntity<?> searchCertificate(@RequestBody CertificateSearchCriteria certificateSearchCriteria,
                                               PaginatedRequest paginatedRequest) {

        return ResponseEntity.ok(certificateService.searchCertificate(certificateSearchCriteria,
                                                                      paginatedRequest));
    }

    @PostMapping(value = "/export")
    public ResponseEntity<Map<String, Object>> exportCertificates(@RequestBody CertificateExportCriteria certificateExportCriteria) throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {

        byte[] excelByteArray = certificateService.exportCertificates(certificateExportCriteria);
        HashMap<String, Object> map = new HashMap<>();
        map.put("byteArray", excelByteArray);
        return ResponseEntity.ok(map);
    }
}

package com.beyontec.mol.resource;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beyontec.mol.modal.PoolInsurerClaimDetailsDTO;
import com.beyontec.mol.modal.PoolInsurerClaimExportdDTO;
import com.beyontec.mol.modal.PoolInsurerClaimIndividualDTO;
import com.beyontec.mol.modal.PoolInsurerClaimIndividualExportdDTO;
import com.beyontec.mol.modal.PoolInsurerCrtIndividualDTO;
import com.beyontec.mol.modal.PoolInsurerSearchCriteria;
import com.beyontec.mol.modal.PoolInsurerSearchDTO;
import com.beyontec.mol.modal.PoolInsurerUwDetailsDTO;
import com.beyontec.mol.modal.ResponseDTO;
import com.beyontec.mol.service.PoolInsurerService;
import com.beyontec.mol.util.AppConstants;
import com.beyontec.mol.util.DMSConstants;

@RestController
@RequestMapping("/api/poolInsurer")
public class PoolInsurerResource {

    @Autowired
    private PoolInsurerService poolInsurerService;

    @RequestMapping(value = "/searchCount", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PoolInsurerSearchDTO> searchPoolInsurerCount(@RequestParam("batchId") String batchId) {
        return ResponseEntity.ok(poolInsurerService.searchPoolInsurerCount(batchId));
    }

    @RequestMapping(value = "/searchUnderwritingDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PoolInsurerUwDetailsDTO>> searchUnderwritingDetails(@RequestParam("batchId") Long batchId,
                                                                               @RequestParam("transactionType") Long transactionType,
                                                                               @RequestParam("productId") Long productId) {
        return ResponseEntity.ok(poolInsurerService.searchUnderwritingDetails(batchId, transactionType, productId));
    }

    @RequestMapping(value = "/searchClaimDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PoolInsurerClaimDetailsDTO>> searchClaimDetails(@RequestParam("batchId") Long batchId,
                                                                         @RequestParam("transactionType") Long transactionType,
                                                                         @RequestParam("productId") Long productId) {
        return ResponseEntity.ok(poolInsurerService.searchClaimDetails(batchId, transactionType, productId));
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PoolInsurerSearchDTO> searchCertAndClaimDetails(@RequestBody PoolInsurerSearchCriteria poolInsurerSearchCriteria) {
        return ResponseEntity.ok(poolInsurerService.searchCertAndClaimDetails(poolInsurerSearchCriteria));
    }

    @RequestMapping(value = "/approve", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> approveUwAndClaims(@RequestParam("batchId") Long batchId) {
        return ResponseEntity.ok(new ResponseDTO(poolInsurerService.approveUwAndClaims(batchId)));
    }

    @RequestMapping(value = "/viewOverallClaims", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PoolInsurerClaimExportdDTO>> viewOverallClaims(@RequestBody PoolInsurerSearchCriteria searchCriteria) {
        return ResponseEntity.ok(poolInsurerService.viewOverallClaims(searchCriteria));
    }

    @RequestMapping(value = "/viewInsuranceClaims", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PoolInsurerClaimIndividualExportdDTO>> viewInsuranceClaims(@RequestBody PoolInsurerClaimIndividualDTO searchCriteria) {
        return ResponseEntity.ok(poolInsurerService.viewInsuranceClaims(searchCriteria));
    }

    @RequestMapping(value = "/viewOverallCertificates", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> viewOverallCertificates(@RequestParam("batchId") long batchId,
                                                                       @RequestParam("productId") long productId) {
        return ResponseEntity.ok(poolInsurerService.viewOverallCerts(batchId, productId));
    }

    @RequestMapping(value = "/viewParticipantCertificates", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> viewParticipantCertificates(@RequestParam("batchId") Long batchId,
                                                                           @RequestParam("partyId") String partyId,
                                                                           @RequestParam("productId") long productId) {
        return ResponseEntity.ok(poolInsurerService.viewParticipantCertificates(batchId, partyId, productId));
    }

    @RequestMapping(value = "/printOverallCertificates", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<byte[]> printOverallCertificates(@RequestBody PoolInsurerSearchCriteria searchCriteria,
                                                           HttpServletRequest request) throws Exception {
        return downloadPdf(poolInsurerService.printOverallCertificates(searchCriteria,
                                                                       request.getHeader(HttpHeaders.AUTHORIZATION)));
    }

    @RequestMapping(value = "/printInsuranceCertificates", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<byte[]> printInsuranceCertificates(@RequestBody PoolInsurerCrtIndividualDTO searchCriteria,
                                                      HttpServletRequest request) throws Exception {
        return downloadPdf(poolInsurerService.printInsuranceCertificates(searchCriteria,
                                                                  request.getHeader(HttpHeaders.AUTHORIZATION)));
    }

    @RequestMapping(value = "/printOverallClaims", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<byte[]> printOverallClaims(@RequestBody PoolInsurerSearchCriteria searchCriteria,
                                                     HttpServletRequest request) throws Exception {
        return downloadPdf(poolInsurerService.printOverallClaims(searchCriteria,
                                                                 request.getHeader(HttpHeaders.AUTHORIZATION)));
    }

    @RequestMapping(value = "/printInsuranceClaims", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<byte[]> printInsuranceClaims(@RequestBody PoolInsurerClaimIndividualDTO searchCriteria,
                                                       HttpServletRequest request) throws Exception {
        return downloadPdf(poolInsurerService.printInsuranceClaims(searchCriteria,
                                                                   request.getHeader(HttpHeaders.AUTHORIZATION)));
    }

    @RequestMapping(value = "/exportOverallCertificates", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<byte[]> exportOverallCertificates(@RequestParam("batchId") long batchId,
                                                            @RequestParam("productId") long productId) throws Exception {
        return downloadExcel(poolInsurerService.exportOverallCertificates(batchId, productId),
                             AppConstants.POOLINSURER_OVERALL_CERTS_FILENAME);
    }

    @RequestMapping(value = "/exportParticipantCertificates", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<byte[]> exportParticipantCertificates(@RequestParam("batchId") long batchId,
                                                                @RequestParam("partyId") String partyId,
                                                                @RequestParam("productId") long productId) throws Exception {
        return downloadExcel(poolInsurerService.exportInsuranceCertificates(batchId, partyId, productId),
                             AppConstants.POOLINSURER_INSURANCE_CERTS_FILENAME);
    }

    @RequestMapping(value = "/exportOverallClaims", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<byte[]> exportOverallClaims(@RequestBody PoolInsurerSearchCriteria searchCriteria) throws Exception {
        return downloadExcel(poolInsurerService.exportOverallClaims(searchCriteria),
                             AppConstants.POOLINSURER_OVERALL_CLAIMS_FILENAME);
    }

    @RequestMapping(value = "/exportInsuranceClaims", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<byte[]> exportInsuranceClaims(@RequestBody PoolInsurerClaimIndividualDTO searchCriteria) throws Exception {
        return downloadExcel(poolInsurerService.exportInsuranceClaims(searchCriteria),
                             AppConstants.POOLINSURER_INSURANCE_CLAIMS_FILENAME);
    }

    private ResponseEntity<byte[]> downloadExcel(byte[] excelByteArray, String filename) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentLength(excelByteArray.length);
        headers.add(HttpHeaders.CONTENT_TYPE, AppConstants.EXCEL_CONTENT_TYPE);
        headers.add(HttpHeaders.CONTENT_DISPOSITION,
                    MessageFormat.format(AppConstants.ATTACHMENT, filename + AppConstants.EXCEL_FILE_EXTENSION));

        return ResponseEntity.ok().headers(headers).body(excelByteArray);
    }

    private ResponseEntity<byte[]> downloadPdf(Map<String, Object> documentDetails) {

        return ResponseEntity.ok()
                             .headers((HttpHeaders) documentDetails.get(DMSConstants.HTTP_HEADER))
                             .header(HttpHeaders.CONTENT_DISPOSITION,
                                     MessageFormat.format(AppConstants.ATTACHMENT,
                                                          documentDetails.get(AppConstants.FILE_NAME)))
                             .body((byte[]) documentDetails.get(DMSConstants.DOCUMENT));
    }

}

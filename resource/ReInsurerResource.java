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
import org.springframework.web.bind.annotation.RestController;

import com.beyontec.mol.modal.PagedResult;
import com.beyontec.mol.modal.PaginatedRequest;
import com.beyontec.mol.modal.ReInsurerClaimDTO;
import com.beyontec.mol.modal.ReInsurerClaimExportDTO;
import com.beyontec.mol.modal.ReInsurerClaimParticipantDTO;
import com.beyontec.mol.modal.ReInsurerClaimParticipantExportDTO;
import com.beyontec.mol.modal.ReInsurerCountDTO;
import com.beyontec.mol.modal.ReInsurerSearchCriteria;
import com.beyontec.mol.modal.ReInsurerUwDTO;
import com.beyontec.mol.modal.ReInsurerUwExportDTO;
import com.beyontec.mol.modal.ReInsurerUwParticipantDTO;
import com.beyontec.mol.service.ReInsurerService;
import com.beyontec.mol.util.AppConstants;
import com.beyontec.mol.util.DMSConstants;

@RestController
@RequestMapping("/api/reinsurer")
public class ReInsurerResource {
    @Autowired private ReInsurerService reInsurerService;

    @RequestMapping(value = "/searchCount", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ReInsurerCountDTO> searchReInsurerCount(@RequestBody ReInsurerSearchCriteria searchCriteria) {
        return ResponseEntity.ok(reInsurerService.searchReInsurerCount(searchCriteria));
    }

    @RequestMapping(value = "/searchUws", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PagedResult<ReInsurerUwDTO>> searchReInsurerUws(@RequestBody ReInsurerSearchCriteria searchCriteria,
                                                                          PaginatedRequest paginatedRequest) {
        return ResponseEntity.ok(reInsurerService.searchReInsurerUws(searchCriteria, paginatedRequest));
    }

    @RequestMapping(value = "/searchClaims", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PagedResult<ReInsurerClaimDTO>> searchReInsurerClaims(@RequestBody ReInsurerSearchCriteria searchCriteria,
                                                                                PaginatedRequest paginatedRequest) {
        return ResponseEntity.ok(reInsurerService.searchReInsurerClaims(searchCriteria, paginatedRequest));
    }

    @RequestMapping(value = "/viewOverallUws", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ReInsurerUwExportDTO>> viewOverallUws(@RequestBody ReInsurerSearchCriteria searchCriteria) {
        return ResponseEntity.ok(reInsurerService.viewOverallUws(searchCriteria));
    }

    @RequestMapping(value = "/viewParticipantUws", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ReInsurerUwExportDTO>> viewParticipantUws(@RequestBody ReInsurerUwParticipantDTO searchCriteria) {
        return ResponseEntity.ok(reInsurerService.viewParticipantUws(searchCriteria));
    }

    @RequestMapping(value = "/viewOverallClaims", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ReInsurerClaimExportDTO>> viewOverallClaims(@RequestBody ReInsurerSearchCriteria searchCriteria) {
        return ResponseEntity.ok(reInsurerService.viewOverallClaims(searchCriteria));
    }

    @RequestMapping(value = "/viewParticipantClaims", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ReInsurerClaimParticipantExportDTO>> viewParticipantClaims(@RequestBody ReInsurerClaimParticipantDTO searchCriteria) {
        return ResponseEntity.ok(reInsurerService.viewParticipantClaims(searchCriteria));
    }

    @RequestMapping(value = "/printOverallUws", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<byte[]> printOverallUws(@RequestBody ReInsurerSearchCriteria searchCriteria,
                                                  HttpServletRequest request) throws Exception {
        return downloadPdf(reInsurerService.printOverallUws(searchCriteria,
                                                            request.getHeader(HttpHeaders.AUTHORIZATION)));
    }

    @RequestMapping(value = "/printParticipantUws", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<byte[]> printParticipantUws(@RequestBody ReInsurerUwParticipantDTO searchCriteria,
                                                     HttpServletRequest request) throws Exception {
        return downloadPdf(reInsurerService.printParticipantUws(searchCriteria,
                                                                request.getHeader(HttpHeaders.AUTHORIZATION)));
    }

    @RequestMapping(value = "/printOverallClaims", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<byte[]> printOverallClaims(@RequestBody ReInsurerSearchCriteria searchCriteria,
                                                     HttpServletRequest request) throws Exception {
        return downloadPdf(reInsurerService.printOverallClaims(searchCriteria,
                                                               request.getHeader(HttpHeaders.AUTHORIZATION)));
    }

    @RequestMapping(value = "/printParticipantClaims", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<byte[]> printParticipantClaims(@RequestBody ReInsurerClaimParticipantDTO searchCriteria,
                                                     HttpServletRequest request) throws Exception {
        return downloadPdf(reInsurerService.printParticipantUws(searchCriteria,
                                                                request.getHeader(HttpHeaders.AUTHORIZATION)));
    }

    @RequestMapping(value = "/exportOverallUws", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<byte[]> exportOverallUws(@RequestBody ReInsurerSearchCriteria searchCriteria) throws Exception {
        return downloadExcel(reInsurerService.exportOverallUws(searchCriteria),
                             AppConstants.REINSURER_OVERALL_UWS_FILENAME);
    }

    @RequestMapping(value = "/exportParticipantUws", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<byte[]> exportParticipantUws(@RequestBody ReInsurerUwParticipantDTO searchCriteria) throws Exception {
        return downloadExcel(reInsurerService.exportParticipantUws(searchCriteria),
                             AppConstants.REINSURER_PARTICIPANT_UWS_FILENAME);
    }

    @RequestMapping(value = "/exportOverallClaims", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<byte[]> exportOverallClaims(@RequestBody ReInsurerSearchCriteria searchCriteria) throws Exception {
        return downloadExcel(reInsurerService.exportOverallClaims(searchCriteria),
                             AppConstants.REINSURER_OVERALL_CLAIMS_FILENAME);
    }

    @RequestMapping(value = "/exportParticipantClaims", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<byte[]> exportParticipantClaims(@RequestBody ReInsurerClaimParticipantDTO searchCriteria) throws Exception {
        return downloadExcel(reInsurerService.exportParticipantClaims(searchCriteria),
                             AppConstants.REINSURER_PARTICIPANT_CLAIMS_FILENAME);
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

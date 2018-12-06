package com.beyontec.mol.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beyontec.mol.config.CommonConfig;
import com.beyontec.mol.exception.ErrorCode;
import com.beyontec.mol.exception.ValidationException;
import com.beyontec.mol.modal.PagedResult;
import com.beyontec.mol.modal.PaginatedRequest;
import com.beyontec.mol.modal.ReInsurerClaimDTO;
import com.beyontec.mol.modal.ReInsurerClaimExportDTO;
import com.beyontec.mol.modal.ReInsurerClaimParticipantDTO;
import com.beyontec.mol.modal.ReInsurerClaimParticipantExportDTO;
import com.beyontec.mol.modal.ReInsurerClaimShareDTO;
import com.beyontec.mol.modal.ReInsurerCountDTO;
import com.beyontec.mol.modal.ReInsurerSearchCriteria;
import com.beyontec.mol.modal.ReInsurerUwDTO;
import com.beyontec.mol.modal.ReInsurerUwExportDTO;
import com.beyontec.mol.modal.ReInsurerUwParticipantDTO;
import com.beyontec.mol.modal.ReInsurerUwShareDTO;
import com.beyontec.mol.util.AppConstants;
import com.beyontec.mol.util.DMSConstants;
import com.beyontec.mol.util.DateUtil;
import com.beyontec.mol.util.ReportGeneratorUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ReInsurerService extends BaseService {

    @Autowired private ModelMapper modelMapper;
    @Autowired private DMSService dmsService;
    @Autowired private ReportGeneratorUtil reportGeneratorUtil;

    public ReInsurerCountDTO searchReInsurerCount(ReInsurerSearchCriteria searchCriteria) {

        validateSearchCriteria(searchCriteria);
        return mockCountDetails();
    }

    public PagedResult<ReInsurerUwDTO> searchReInsurerUws(ReInsurerSearchCriteria searchCriteria,
                                                          PaginatedRequest paginatedRequest) {

        validateSearchCriteria(searchCriteria);
        return mockSearchReInsurerUws();
    }

    public PagedResult<ReInsurerClaimDTO> searchReInsurerClaims(ReInsurerSearchCriteria searchCriteria,
                                                                PaginatedRequest paginatedRequest) {

        validateSearchCriteria(searchCriteria);
        return mockSearchReInsurerClaims();
    }

    public List<ReInsurerUwExportDTO> viewOverallUws(ReInsurerSearchCriteria searchCriteria) {

        validateSearchCriteria(searchCriteria);
        return mockOverallUws();
    }

    public List<ReInsurerUwExportDTO> viewParticipantUws(ReInsurerUwParticipantDTO searchCriteria) {

        validateSearchCriteria(searchCriteria);
        return mockParticiapantUws();
    }

    public List<ReInsurerClaimExportDTO> viewOverallClaims(ReInsurerSearchCriteria searchCriteria) {

        validateSearchCriteria(searchCriteria);
        return mockOverallClaims();
    }

    public List<ReInsurerClaimParticipantExportDTO> viewParticipantClaims(ReInsurerClaimParticipantDTO searchCriteria) {

        validateSearchCriteria(searchCriteria);
        return mockParticipantClaims();
    }

    public Map<String, Object> printOverallUws(ReInsurerSearchCriteria searchCriteria,
                                               String authHeader) throws Exception {
        return generatePDF(mockOverallUws(), DMSConstants.TEMPLATE_REINSURER_OVERALL_UWS, authHeader);
    }

    public Map<String, Object> printParticipantUws(ReInsurerUwParticipantDTO searchCriteria,
                                                   String authHeader) throws Exception {
        return generatePDF(mockParticiapantUws(), DMSConstants.TEMPLATE_REINSURER_PARTICIPANT_UWS, authHeader);
    }

    public Map<String, Object> printOverallClaims(ReInsurerSearchCriteria searchCriteria,
                                               String authHeader) throws Exception {
        return generatePDF(mockOverallClaims(), DMSConstants.TEMPLATE_REINSURER_OVERALL_CLAIMS, authHeader);
    }

    public Map<String, Object> printParticipantUws(ReInsurerClaimParticipantDTO searchCriteria,
                                               String authHeader) throws Exception {
        return generatePDF(mockParticipantClaims(), DMSConstants.TEMPLATE_REINSURER_PARTICIPANT_CLAIMS, authHeader);
    }

    public byte[] exportOverallUws(ReInsurerSearchCriteria searchCriteria) throws Exception {
        return reportGeneratorUtil.generateExcel(null,
                                                 AppConstants.REINSURER_OVERALL_UW_COLUMN_HEADERS,
                                           AppConstants.REINSURER_OVERALL_UW_COLUMN_FIELDS,
                                           mockOverallUws(),
                                           AppConstants.REINSURER_OVERALL_UWS_FILENAME);
    }

    public byte[] exportParticipantUws(ReInsurerUwParticipantDTO searchCriteria) throws Exception {
        return reportGeneratorUtil.generateExcel(null,
                                                 AppConstants.REINSURER_OVERALL_UW_COLUMN_HEADERS,
                                           AppConstants.REINSURER_OVERALL_UW_COLUMN_FIELDS,
                                           mockParticiapantUws(),
                                           AppConstants.REINSURER_PARTICIPANT_UWS_FILENAME);
    }

    public byte[] exportOverallClaims(ReInsurerSearchCriteria searchCriteria) throws Exception {
        return reportGeneratorUtil.generateExcel(null,
                                                 AppConstants.REINSURER_OVERALL_CLAIM_COLUMN_HEADERS,
                                           AppConstants.REINSURER_OVERALL_CLAIM_COLUMN_FIELDS,
                                           mockOverallClaims(),
                                           AppConstants.REINSURER_OVERALL_CLAIMS_FILENAME);
    }

    public byte[] exportParticipantClaims(ReInsurerClaimParticipantDTO searchCriteria) throws Exception {
        return reportGeneratorUtil.generateExcel(null,
                                                 AppConstants.REINSURER_PARTICIPANT_CLAIM_COLUMN_HEADERS,
                                           AppConstants.REINSURER_PARTICIPANT_CLAIM_COLUMN_FIELDS,
                                           mockParticipantClaims(),
                                           AppConstants.REINSURER_PARTICIPANT_CLAIMS_FILENAME);
    }

    private Map<String, Object> generatePDF(List<?> inputList,
                                            String template,
                                            String authHeader) throws Exception {

        String lists = new ObjectMapper().writeValueAsString(inputList);
        Map<String, Object> inputMap = new HashMap<>();
        inputMap.put(template, new ObjectMapper().readValue(lists, List.class));
        Map<String, Object> documentDetails = dmsService.generateDownloadDocument(inputMap,
                                                                                  template,
                                                                                  authHeader);
        documentDetails.put(AppConstants.FILE_NAME, template + AppConstants.PDF_FILE_EXTENSION);
        return documentDetails;
    }

    private void validateSearchCriteria(ReInsurerSearchCriteria searchCriteria) {

        if (StringUtils.isBlank(searchCriteria.getFromDate())
            && !StringUtils.isBlank(searchCriteria.getToDate())) {
            throw new ValidationException(ErrorCode.EMPTY_REINSURER_FROM_DATE);
        } else if (!StringUtils.isBlank(searchCriteria.getFromDate())
                   && StringUtils.isBlank(searchCriteria.getToDate())) {
            throw new ValidationException(ErrorCode.EMPTY_REINSURER_TO_DATE);
        } else if (!StringUtils.isBlank(searchCriteria.getFromDate())
                   && DateUtil.convert(searchCriteria.getFromDate()) == null) {
            throw new ValidationException(ErrorCode.REINSURER_FROM_DATE_FORMAT_INVALID,
                                          CommonConfig.DATE_FORMAT.toPattern());
        } else if (!StringUtils.isBlank(searchCriteria.getToDate())
                   && DateUtil.convert(searchCriteria.getToDate()) == null) {
            throw new ValidationException(ErrorCode.REINSURER_TO_DATE_FORMAT_INVALID,
                                          CommonConfig.DATE_FORMAT.toPattern());
        }
    }

    //TODO: these mock methods should remove while implementing data layer
    private ReInsurerCountDTO mockCountDetails() {

        ReInsurerCountDTO reInsurer = new ReInsurerCountDTO();
        reInsurer.setTotalCertificates(150000D);
        reInsurer.setTotalPremium(180000000D);

        ReInsurerUwShareDTO uwShare = new ReInsurerUwShareDTO();
        uwShare.setSharePercent(34D);
        uwShare.setRetentionPercent(20D);
        uwShare.setQsPercent(80D);
        uwShare.setQsCommissionPercent(15D);
        uwShare.setDicShareAmount(6120000D);
        uwShare.setRetentionAmount(1224000D);
        uwShare.setQsAmount(4896000D);
        uwShare.setQsCommissionAmount(734400D);
        reInsurer.setDicUwShare(uwShare);
        
        reInsurer.setTotalClaims(200D);
        reInsurer.setTotalClaimsPaid(460000D);
        reInsurer.setDicClaimShare(modelMapper.map(uwShare, ReInsurerClaimShareDTO.class));
        return reInsurer;
    }

    private PagedResult<ReInsurerUwDTO> mockSearchReInsurerUws() {

        List<ReInsurerUwDTO> uwList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {

            ReInsurerUwDTO uw = new ReInsurerUwDTO();
            uw.setQsParticipant("Participant" + i);
            uw.setQsPercentage(20D);
            uw.setQsAmount(979000D);
            uwList.add(uw);
        }
        return new PagedResult<>(uwList, 10L);
    }

    private PagedResult<ReInsurerClaimDTO> mockSearchReInsurerClaims() {

        List<ReInsurerClaimDTO> claimList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {

            ReInsurerClaimDTO claim = new ReInsurerClaimDTO();
            claim.setQsParticipant("Participant" + i);
            claim.setQsPercentage(20D);
            claim.setQsAmount(979000D);
            claimList.add(claim);
        }
        return new PagedResult<>(claimList, 10L);
    }

    private List<ReInsurerUwExportDTO> mockOverallUws() {

        List<ReInsurerUwExportDTO> uwExportList = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            ReInsurerUwExportDTO uwExport = new ReInsurerUwExportDTO();
            uwExport.setCertificateNo("1001/2018/00000000102" + i);
            uwExport.setInsuredName("Insured Name" + i);
            uwExport.setSponserName("Sponser Name" + i);
            uwExport.setFromDate(DateUtil.toString(DateUtil.extendDate(new Date(), i - 10, i - 10)));
            uwExport.setToDate(DateUtil.toString(DateUtil.extendDate(new Date(), i - 5, i - 10)));
            uwExport.setTotalPremium(120D);
            uwExport.setRetentionAmount(24D);
            uwExport.setQuotaAmount(96D);
            uwExport.setRiCommission(14.4D);
            uwExportList.add(uwExport);
        }

        return uwExportList;
    }

    private List<ReInsurerUwExportDTO> mockParticiapantUws() {

        List<ReInsurerUwExportDTO> uwExportList = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            ReInsurerUwExportDTO uwExport = new ReInsurerUwExportDTO();
            uwExport.setCertificateNo("1001/2018/00000000102" + i);
            uwExport.setInsuredName("Insured Name" + i);
            uwExport.setSponserName("Sponser Name" + i);
            uwExport.setFromDate(DateUtil.toString(DateUtil.extendDate(new Date(), i - 10, i - 10)));
            uwExport.setToDate(DateUtil.toString(DateUtil.extendDate(new Date(), i - 5, i - 10)));
            uwExport.setTotalPremium(new Double(120 * i));
            uwExport.setRetentionAmount(new Double(24 * i));
            uwExport.setQuotaAmount(new Double(96 * i));
            uwExport.setRiCommission(new Double(14.4 * i));
            uwExportList.add(uwExport);
        }

        return uwExportList;
    }

    private List<ReInsurerClaimExportDTO> mockOverallClaims() {

        List<ReInsurerClaimExportDTO> claimExportList = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            ReInsurerClaimExportDTO claimExport = new ReInsurerClaimExportDTO();
            claimExport.setClaimNo("Claim0" + i);
            claimExport.setCertificateNo("1001/2018/00000000102" + i);
            claimExport.setInsuredName("Insured Name" + i);
            claimExport.setSponserName("Sponser Name" + i);
            claimExport.setFromDate(DateUtil.toString(DateUtil.extendDate(new Date(), i - 10, i - 10)));
            claimExport.setToDate(DateUtil.toString(DateUtil.extendDate(new Date(), i - 5, i - 10)));
            claimExport.setTotalAmount(new Double(5000 * i));
            claimExport.setParticipantAmount(new Double(340 * i));
            claimExportList.add(claimExport);
        }

        return claimExportList;
    }

    private List<ReInsurerClaimParticipantExportDTO> mockParticipantClaims() {

        List<ReInsurerClaimParticipantExportDTO> claimExportList = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            ReInsurerClaimParticipantExportDTO claimExport = new ReInsurerClaimParticipantExportDTO();
            claimExport.setClaimNo("Claim0" + i);
            claimExport.setCertificateNo("1001/2018/00000000102" + i);
            claimExport.setInsuredName("Insured Name" + i);
            claimExport.setSponserName("Sponser Name" + i);
            claimExport.setFromDate(DateUtil.toString(DateUtil.extendDate(new Date(), i - 10, i - 10)));
            claimExport.setToDate(DateUtil.toString(DateUtil.extendDate(new Date(), i - 5, i - 10)));
            claimExport.setTotalAmount(new Double(5000 * i));
            claimExport.setRetentionShare(new Double(340 * i));
            claimExport.setQsShare(new Double(544 * i));
            claimExportList.add(claimExport);
        }

        return claimExportList;
    }
}

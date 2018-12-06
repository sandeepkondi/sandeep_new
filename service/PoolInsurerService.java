package com.beyontec.mol.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.beyontec.mol.config.CommonConfig;
import com.beyontec.mol.entity.BsdsBatchHdr;
import com.beyontec.mol.exception.ApplicationException;
import com.beyontec.mol.exception.ErrorCode;
import com.beyontec.mol.exception.ValidationException;
import com.beyontec.mol.modal.ConfigDTO;
import com.beyontec.mol.modal.ExcelCustomField;
import com.beyontec.mol.modal.InsurerProcessDTO;
import com.beyontec.mol.modal.PoolInsurerClaimDetailsDTO;
import com.beyontec.mol.modal.PoolInsurerClaimExportdDTO;
import com.beyontec.mol.modal.PoolInsurerClaimIndividualDTO;
import com.beyontec.mol.modal.PoolInsurerClaimIndividualExportdDTO;
import com.beyontec.mol.modal.PoolInsurerCountDTO;
import com.beyontec.mol.modal.PoolInsurerCrtExportDTO;
import com.beyontec.mol.modal.PoolInsurerCrtIndividualDTO;
import com.beyontec.mol.modal.PoolInsurerIndividualCrtExportDTO;
import com.beyontec.mol.modal.PoolInsurerSearchCriteria;
import com.beyontec.mol.modal.PoolInsurerSearchDTO;
import com.beyontec.mol.modal.PoolInsurerUwDetailsDTO;
import com.beyontec.mol.modal.ViewParticipantCertificate;
import com.beyontec.mol.repository.BsdsBatchHdrRepository;
import com.beyontec.mol.repository.UdsIdDefinitionRepository;
import com.beyontec.mol.util.AppConstants;
import com.beyontec.mol.util.CustomDateSerializer;
import com.beyontec.mol.util.DMSConstants;
import com.beyontec.mol.util.DateUtil;
import com.beyontec.mol.util.JWTUtil;
import com.beyontec.mol.util.ReportGeneratorUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

@Service
public class PoolInsurerService extends BaseService {

    @Autowired private DMSService dmsService;
    @Autowired private BsdsBatchHdrRepository bsdsBatchHdrRepository;
    @Autowired private ReportGeneratorUtil reportGeneratorUtil;
    @Autowired private UdsIdDefinitionRepository udsIdDefinitionRepo;

    private void validatePoolInsurerSearchCriteria(PoolInsurerSearchCriteria searchCriteria) {
        if (org.apache.commons.lang3.StringUtils.isBlank(searchCriteria.getFromDate())
            && !org.apache.commons.lang3.StringUtils.isBlank(searchCriteria.getToDate())) {
            throw new ValidationException(ErrorCode.EMPTY_POOL_INSURER_FROM_DATE);
        } else if (!org.apache.commons.lang3.StringUtils.isBlank(searchCriteria.getFromDate())
                   && org.apache.commons.lang3.StringUtils.isBlank(searchCriteria.getToDate())) {
            throw new ValidationException(ErrorCode.EMPTY_POOL_INSURER_TO_DATE);
        } else if (!org.apache.commons.lang3.StringUtils.isBlank(searchCriteria.getFromDate())
                   && DateUtil.convert(searchCriteria.getFromDate()) == null) {
            throw new ValidationException(ErrorCode.POOL_INSURER_FROM_DATE_FORMAT_INVALID,
                                          CommonConfig.DATE_FORMAT.toPattern());
        } else if (!org.apache.commons.lang3.StringUtils.isBlank(searchCriteria.getToDate())
                   && DateUtil.convert(searchCriteria.getToDate()) == null) {
            throw new ValidationException(ErrorCode.POOL_INSURER_TO_DATE_FORMAT_INVALID,
                                          CommonConfig.DATE_FORMAT.toPattern());
        }
    }

    public PoolInsurerSearchDTO searchPoolInsurerCount(String batchId) {

        List<PoolInsurerCountDTO> poolInsurerCountDetails = invokeRepo(() -> bsdsBatchHdrRepository.getCount(batchId),
                                                                       "bsdsBatchHdrRepository.getCount(bbhSgsId)");
        String isEngLocale = LocaleContextHolder.getLocale().getLanguage().equals(AppConstants.ENGLISH) ? "true"
                                                                                                        : "false";
        List<ConfigDTO> processTypes = invokeRepo(() -> udsIdDefinitionRepo.getinsurerProcessType(isEngLocale),
                                                  "udsIdDefinitionRepo.getinsurerProcessType()");
        PoolInsurerSearchDTO responseDTO = new PoolInsurerSearchDTO();
        responseDTO.setBatchId(batchId);
        responseDTO.setSections(poolInsurerCountDetails);
        responseDTO.setSubSections(processTypes);
        return responseDTO;
    }

    public List<PoolInsurerClaimExportdDTO> viewOverallClaims(PoolInsurerSearchCriteria poolInsurerSearchCriteria) {
        validatePoolInsurerSearchCriteria(poolInsurerSearchCriteria);
        return mockViewOverallClaims();
    }

    public List<PoolInsurerClaimIndividualExportdDTO> viewInsuranceClaims(PoolInsurerClaimIndividualDTO poolInsurerSearchCriteria) {
        return mockViewInsuranceClaims();
    }

    public Map<String, Object> viewOverallCerts(long batchId, long productId) {
        Map<String, Object> viewOverallCertsMap = new HashMap<>();
        viewOverallCertsMap.put("overAllCerts",
                                bsdsBatchHdrRepository.getOverallCerts(batchId,
                                                                       productId,
                                                                       CommonConfig.DATE_FORMAT.toPattern()));
        viewOverallCertsMap.put("insurerProcessDTO", getInsureProcess(batchId));
        return viewOverallCertsMap;
    }

    public Map<String, Object> viewParticipantCertificates(long batchId, String partyId, long productId) {
        Map<String, Object> viewParticipantCertificatesMap = new HashMap<>();
        InsurerProcessDTO insurerProcessDTO = getInsureProcess(batchId);
        viewParticipantCertificatesMap.put("viewParticipantCertificate",
                                           new ViewParticipantCertificate(insurerProcessDTO.getBatchNo(),
                                                                          insurerProcessDTO.getProcessId(),
                                                                          insurerProcessDTO.getProcessName(),
                                                                          insurerProcessDTO.getFromDate(),
                                                                          insurerProcessDTO.getToDate(),
                                                                          insurerProcessDTO.getStatus(),
                                                                          insurerProcessDTO.getStatusDesc(),
                                                                          bsdsBatchHdrRepository.getParticipantCertificates(CommonConfig.DATE_FORMAT.toPattern(),
                                                                                                                            batchId,
                                                                                                                            productId,
                                                                                                                            partyId)
                                                                                                .get(0)
                                                                                                .getPoolInsurerName()));

        viewParticipantCertificatesMap.put("PoolInsurerIndividualCrtExportDTOList",
                                           bsdsBatchHdrRepository.getParticipantCertificates(CommonConfig.DATE_FORMAT.toPattern(),
                                                                                             batchId,
                                                                                             productId,
                                                                                             partyId));

        return viewParticipantCertificatesMap;
    }

    public Map<String, Object> printOverallCertificates(PoolInsurerSearchCriteria searchCriteria,
                                                        String authHeader) throws Exception {
        return generatePDF(mockViewOverallCertificates(), DMSConstants.TEMPLATE_POOLINSURER_OVERALL_CERTS, authHeader);
    }

    public Map<String, Object> printInsuranceCertificates(PoolInsurerCrtIndividualDTO searchCriteria,
                                                          String authHeader) throws Exception {
        return generatePDF(mockViewInsuranceCertificates(),
                           DMSConstants.TEMPLATE_POOLINSURER_INSURANCE_CERTS,
                           authHeader);
    }

    public Map<String, Object> printOverallClaims(PoolInsurerSearchCriteria searchCriteria,
                                                  String authHeader) throws Exception {
        return generatePDF(mockViewOverallClaims(), DMSConstants.TEMPLATE_POOLINSURER_OVERALL_CLAIMS, authHeader);
    }

    public Map<String, Object> printInsuranceClaims(PoolInsurerClaimIndividualDTO searchCriteria,
                                                    String authHeader) throws Exception {
        return generatePDF(mockViewInsuranceClaims(), DMSConstants.TEMPLATE_POOLINSURER_INSURANCE_CLAIMS, authHeader);
    }

    public byte[] exportOverallCertificates(long batchId, long productId) throws Exception {

        List<ExcelCustomField> customFields = new ArrayList<>();
        InsurerProcessDTO insurerProcessDTO = getInsureProcess(batchId);
        customFields.add(new ExcelCustomField(2, 3, "Process", "UW & Claims Process"));
        customFields.add(new ExcelCustomField(4, 3, "From Date", insurerProcessDTO.getFromDate()));
        customFields.add(new ExcelCustomField(4, 6, "To Date", insurerProcessDTO.getToDate()));

        return reportGeneratorUtil.generateExcel(customFields,
                                                 AppConstants.POOLINSURER_OVERALL_CERT_COLUMN_HEADERS,
                                                 AppConstants.POOLINSURER_OVERALL_CERT_COLUMN_FIELDS,
                                                 bsdsBatchHdrRepository.getOverallCerts(batchId,
                                                                                        productId,
                                                                                        CommonConfig.DATE_FORMAT.toPattern()),
                                                 AppConstants.POOLINSURER_OVERALL_CERTS_FILENAME);
    }

    private InsurerProcessDTO getInsureProcess(long batchId) {
        List<InsurerProcessDTO> insurerProcessList = bsdsBatchHdrRepository.getInsurerProcess(CommonConfig.DATE_FORMAT.toPattern(),
                                                                                              null,
                                                                                              null,
                                                                                              null,
                                                                                              Long.toString(batchId),
                                                                                              null,
                                                                                              LocaleContextHolder.getLocale()
                                                                                                                 .getLanguage()
                                                                                                                 .equals(AppConstants.ENGLISH) ? "true"
                                                                                                                                               : "false",
                                                                                              null);
        return insurerProcessList.get(0);
    }

    public byte[] exportInsuranceCertificates(long batchId, String partyId, long productId) throws Exception {

        List<PoolInsurerIndividualCrtExportDTO> PoolInsurerIndividualCrtExportDTOList = bsdsBatchHdrRepository.getParticipantCertificates(CommonConfig.DATE_FORMAT.toPattern(),
                                                                                                                                          batchId,
                                                                                                                                          productId,
                                                                                                                                          partyId);
        List<ExcelCustomField> customFields = new ArrayList<>();
        InsurerProcessDTO insurerProcessDTO = getInsureProcess(batchId);
        customFields.add(new ExcelCustomField(2, 3, "Process", "UW & Claims Process"));
        customFields.add(new ExcelCustomField(2,
                                              6,
                                              "Pool Insurer name",
                                              PoolInsurerIndividualCrtExportDTOList.get(0).getPoolInsurerName()));
        customFields.add(new ExcelCustomField(4, 3, "From Date", insurerProcessDTO.getFromDate()));
        customFields.add(new ExcelCustomField(4, 6, "To Date", insurerProcessDTO.getToDate()));

        return reportGeneratorUtil.generateExcel(customFields,
                                                 AppConstants.POOLINSURER_INSURANCE_CERT_COLUMN_HEADERS,
                                           AppConstants.POOLINSURER_INSURANCE_CERT_COLUMN_FIELDS,
                                                 PoolInsurerIndividualCrtExportDTOList,
                                           AppConstants.POOLINSURER_INSURANCE_CERTS_FILENAME);
    }

    public byte[] exportOverallClaims(PoolInsurerSearchCriteria searchCriteria) throws Exception {
        return reportGeneratorUtil.generateExcel(null,
                                                 AppConstants.POOLINSURER_OVERALL_CLAIM_COLUMN_HEADERS,
                                           AppConstants.POOLINSURER_OVERALL_CLAIM_COLUMN_FIELDS,
                                           mockViewOverallClaims(),
                                           AppConstants.POOLINSURER_OVERALL_CLAIMS_FILENAME);
    }

    public byte[] exportInsuranceClaims(PoolInsurerClaimIndividualDTO searchCriteria) throws Exception {
        return reportGeneratorUtil.generateExcel(null,
                                                 AppConstants.POOLINSURER_INSURANCE_CLAIM_COLUMN_HEADERS,
                                           AppConstants.POOLINSURER_INSURANCE_CLAIM_COLUMN_FIELDS,
                                           mockViewInsuranceClaims(),
                                           AppConstants.POOLINSURER_INSURANCE_CLAIMS_FILENAME);
    }

    private Map<String, Object> generatePDF(List<?> inputList,
                                            String template,
                                            String authHeader) throws Exception {

        ObjectMapper oMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(Date.class, new CustomDateSerializer(CommonConfig.DATE_FORMAT.toPattern()));
        oMapper.registerModule(module);

        String lists = oMapper.writeValueAsString(inputList);
        Map<String, Object> inputMap = new HashMap<>();
        inputMap.put(template, new ObjectMapper().readValue(lists, List.class));
        Map<String, Object> documentDetails = dmsService.generateDownloadDocument(inputMap,
                                                                                  template,
                                                                                  authHeader);
        documentDetails.put(AppConstants.FILE_NAME, template + AppConstants.PDF_FILE_EXTENSION);
        return documentDetails;
    }

    //TODO: this logic should be change after implement data layer
    private List<PoolInsurerClaimExportdDTO> mockViewOverallClaims() {

        List<PoolInsurerClaimExportdDTO> claimExportList = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            PoolInsurerClaimExportdDTO poolInsurerClaimExportDTO = new PoolInsurerClaimExportdDTO();
            poolInsurerClaimExportDTO.setClaimNo("CLM/22/86");
            poolInsurerClaimExportDTO.setCertificateNo("C1/55/88888");
            poolInsurerClaimExportDTO.setInsuredName("AAA");
            poolInsurerClaimExportDTO.setSponsorName("SPONSOR1");
            poolInsurerClaimExportDTO.setCertificateFromDate(new Date());
            poolInsurerClaimExportDTO.setCertificateToDate(new Date());
            poolInsurerClaimExportDTO.setClaimAmount(500000);
            poolInsurerClaimExportDTO.setOurShare(12000);
            poolInsurerClaimExportDTO.setPoolInsurerShare(15000);
            poolInsurerClaimExportDTO.setRetroCedentShare(12000);
            poolInsurerClaimExportDTO.setNetShareofPoolInsurer(150000);

            claimExportList.add(poolInsurerClaimExportDTO);
        }

        return claimExportList;
    }

    //TODO: this method should be remove after implement data layer
    private List<PoolInsurerClaimIndividualExportdDTO> mockViewInsuranceClaims() {
        List<PoolInsurerClaimIndividualExportdDTO> claimExportList = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
        PoolInsurerClaimIndividualExportdDTO poolInsurerClaimExportDTO = new PoolInsurerClaimIndividualExportdDTO();
        poolInsurerClaimExportDTO.setPoolInsurerName("Alliance Insurance");
        poolInsurerClaimExportDTO.setClaimNo("CLM/22/86");
        poolInsurerClaimExportDTO.setCertificateNo("C1/55/88888");
        poolInsurerClaimExportDTO.setInsuredName("AAA");
        poolInsurerClaimExportDTO.setSponsorName("SPONSOR1");
        poolInsurerClaimExportDTO.setCertificateFromDate(new Date());
        poolInsurerClaimExportDTO.setCertificateToDate(new Date());
        poolInsurerClaimExportDTO.setClaimAmount(500000);
        poolInsurerClaimExportDTO.setOurShare(12000);
        poolInsurerClaimExportDTO.setPoolInsurerShare(15000);
        poolInsurerClaimExportDTO.setRetroCedentShare(12000);
        poolInsurerClaimExportDTO.setNetShareofPoolInsurer(150000);
            claimExportList.add(poolInsurerClaimExportDTO);
        }
        return claimExportList;
    }

    //TODO: this method should be remove after implement data layer
    private List<PoolInsurerCrtExportDTO> mockViewOverallCertificates() {

        List<PoolInsurerCrtExportDTO> certExportList = new ArrayList<>();
        /* for (int i = 1; i < 5; i++) {
         * PoolInsurerCrtExportDTO poolInsurerCertmDownloadDTO = null;
         * poolInsurerCertmDownloadDTO.setCertificateNo("C1/555/6695");
         * poolInsurerCertmDownloadDTO.setInsuredName("DIC");
         * poolInsurerCertmDownloadDTO.setSponsorName("Sponsor1");
         * poolInsurerCertmDownloadDTO.setCertificateFromDate(new Date());
         * poolInsurerCertmDownloadDTO.setCertificateToDate(new Date());
         * poolInsurerCertmDownloadDTO.setTotalPremium(120);
         * poolInsurerCertmDownloadDTO.setOurSharePremium(12);
         * poolInsurerCertmDownloadDTO.setPoolInsurerPremium(150);
         * poolInsurerCertmDownloadDTO.setLeaderFee(28.5);
         * poolInsurerCertmDownloadDTO.setRetroCedentcommission(15);
         * poolInsurerCertmDownloadDTO.setRetroCedentcommission(3);
         * poolInsurerCertmDownloadDTO.setNetPremium(16);
         * certExportList.add(poolInsurerCertmDownloadDTO);
         * } */

        return certExportList;
    }

    //TODO: this method should be remove after implement data layer
    private List<PoolInsurerIndividualCrtExportDTO> mockViewInsuranceCertificates() {

        List<PoolInsurerIndividualCrtExportDTO> certExportList = new ArrayList<>();
        /* for (int i = 1; i < 5; i++) {
         * PoolInsurerIndividualCrtExportDTO poolInsurerCertmDownloadDTO = null;
         * poolInsurerCertmDownloadDTO.setPoolInsurerName("Alliance Insurance");
         * poolInsurerCertmDownloadDTO.setCertificateNo("C1/555/6695");
         * poolInsurerCertmDownloadDTO.setInsuredName("DIC");
         * poolInsurerCertmDownloadDTO.setSponsorName("Sponsor1");
         * poolInsurerCertmDownloadDTO.setCertificateFromDate(new Date());
         * poolInsurerCertmDownloadDTO.setCertificateToDate(new Date());
         * poolInsurerCertmDownloadDTO.setTotalPremium(120);
         * poolInsurerCertmDownloadDTO.setOurSharePremium(12);
         * poolInsurerCertmDownloadDTO.setPoolInsurerPremium(150);
         * poolInsurerCertmDownloadDTO.setLeaderFee(28.5);
         * poolInsurerCertmDownloadDTO.setRetroCedentcommission(15);
         * poolInsurerCertmDownloadDTO.setRetroCedentcommission(3);
         * poolInsurerCertmDownloadDTO.setNetPremium(16);
         * certExportList.add(poolInsurerCertmDownloadDTO);
         * } */
        return certExportList;
    }

    @Transactional
    public List<PoolInsurerUwDetailsDTO> searchUnderwritingDetails(Long batchId, Long transactionType, Long productId) {

        return bsdsBatchHdrRepository.getUnderwritingDetails(batchId, transactionType, productId);
    }

    @Transactional
    public List<PoolInsurerClaimDetailsDTO> searchClaimDetails(Long batchId, Long transactionType, Long productId) {

        return bsdsBatchHdrRepository.getClaimDetails(batchId, transactionType, productId);
    }

    @Transactional
    public PoolInsurerSearchDTO searchCertAndClaimDetails(PoolInsurerSearchCriteria searchCriteria) {

        validatePoolInsurerSearchCriteria(searchCriteria);
        BsdsBatchHdr process = new BsdsBatchHdr();
        process.setType(AppConstants.UNDERWRITING_TYPE);
        process.setFromDate(DateUtil.convert(searchCriteria.getFromDate()));
        process.setToDate(DateUtil.convert(searchCriteria.getToDate()));
        process.setCreatedUser(JWTUtil.getUserId());
        process.setCreatedDate(DateUtil.now());
        process.setStatus(AppConstants.UNDERWRITING_PEN_STATUS);
        process.setTransactionDate(DateUtil.now());

        // insert batch details to BSDS_BATCH_HDR table
        invokeRepo(() -> bsdsBatchHdrRepository.save(process), "bsdsBatchHdrRepository.save(process)");

        // Call BLK_BATCH_PROCESS.BLP_POP_HDR(BBH_SGS_ID) procedure
        bsdsBatchHdrRepository.populateBatchDetails(process.getBbhSgsId());

        return searchPoolInsurerCount(String.valueOf(process.getBbhSgsId()));
    }

    @Transactional
    public Boolean approveUwAndClaims(Long batchId) {

        if (null == batchId) {
            throw new ApplicationException(ErrorCode.BATCH_ID_REQUIRED);
        }

        List<PoolInsurerCountDTO> poolInsurerCountDetails = invokeRepo(() -> bsdsBatchHdrRepository.getCount(batchId.toString()),
                                                                       "bsdsBatchHdrRepository.getCount(bbhSgsId)");
        if (poolInsurerCountDetails.isEmpty()) {
            throw new ApplicationException(ErrorCode.BATCH_NOT_AVAILABLE);
        }

        // Call BLK_BATCH_PROCESS.BLP_BATCH_APPROVAL(BBH_SGS_ID, LOGIN_USER) procedure
        bsdsBatchHdrRepository.populateUwAndClaimsApproveDetails(batchId, JWTUtil.getUserId());
        return true;
    }
}

package com.beyontec.mol.service;

import static java.util.Arrays.asList;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.beyontec.mol.config.CommonConfig;
import com.beyontec.mol.config.UdsIdDefConfig;
import com.beyontec.mol.entity.CertificateCancellation;
import com.beyontec.mol.entity.CertificateDetails;
import com.beyontec.mol.entity.CertificateDetails.STATUS;
import com.beyontec.mol.entity.CoverageHistory;
import com.beyontec.mol.entity.CoverageMain;
import com.beyontec.mol.entity.CoverageSmiHistory;
import com.beyontec.mol.entity.CoverageSmiMain;
import com.beyontec.mol.entity.CustomerDetailsMain;
import com.beyontec.mol.entity.Installment;
import com.beyontec.mol.entity.InstallmentHistory;
import com.beyontec.mol.entity.PolicyHistory;
import com.beyontec.mol.entity.PolicyMain;
import com.beyontec.mol.entity.PrintDocument;
import com.beyontec.mol.entity.PrintDocumentTemplate;
import com.beyontec.mol.entity.ProductAppBusType;
import com.beyontec.mol.entity.RiskAdditionalHistory;
import com.beyontec.mol.entity.RiskAdditionalMain;
import com.beyontec.mol.entity.RiskHistory;
import com.beyontec.mol.entity.RiskMain;
import com.beyontec.mol.entity.Tax;
import com.beyontec.mol.entity.TaxHistory;
import com.beyontec.mol.entity.UdsIdDefinition;
import com.beyontec.mol.entity.UpdateCertificateDetails;
import com.beyontec.mol.exception.ApplicationException;
import com.beyontec.mol.exception.ErrorCode;
import com.beyontec.mol.exception.ErrorDetail;
import com.beyontec.mol.exception.ResponseStatusCode;
import com.beyontec.mol.exception.ValidationException;
import com.beyontec.mol.modal.AcknowledgementDTO;
import com.beyontec.mol.modal.CancelCertificateDTO;
import com.beyontec.mol.modal.CertificateDTO;
import com.beyontec.mol.modal.CertificateExportCriteria;
import com.beyontec.mol.modal.CertificateListingDTO;
import com.beyontec.mol.modal.CertificateSearchCriteria;
import com.beyontec.mol.modal.CustomerCategoryDTO;
import com.beyontec.mol.modal.DMSDocumentMetadata;
import com.beyontec.mol.modal.DMSDocumentMetadataDTO;
import com.beyontec.mol.modal.ExportCertificateDetails;
import com.beyontec.mol.modal.PagedResult;
import com.beyontec.mol.modal.PaginatedRequest;
import com.beyontec.mol.modal.Premium;
import com.beyontec.mol.modal.TotalTax;
import com.beyontec.mol.modal.UpdateCertificateDetailsDTO;
import com.beyontec.mol.modal.ViewCertificateDTO;
import com.beyontec.mol.modal.ViewCertificateDetailDTO;
import com.beyontec.mol.repository.CertificateCancellationRepository;
import com.beyontec.mol.repository.CertificateDAO;
import com.beyontec.mol.repository.CertificateDetailsRepository;
import com.beyontec.mol.repository.CoverageHistoryRepository;
import com.beyontec.mol.repository.CoverageMainRepository;
import com.beyontec.mol.repository.CoverageSmiHistoryRepository;
import com.beyontec.mol.repository.CoverageSmiMainRepository;
import com.beyontec.mol.repository.InstallmentHistoryRepository;
import com.beyontec.mol.repository.InstallmentRepository;
import com.beyontec.mol.repository.PolicyHistoryRepository;
import com.beyontec.mol.repository.PolicyMainRepository;
import com.beyontec.mol.repository.PrintDocumentRepository;
import com.beyontec.mol.repository.PrintDocumentTemplateRepository;
import com.beyontec.mol.repository.ProductAppBusTypeRepository;
import com.beyontec.mol.repository.RiskAdditionalHistoryRepository;
import com.beyontec.mol.repository.RiskAdditionalMainRepository;
import com.beyontec.mol.repository.RiskHistoryRepository;
import com.beyontec.mol.repository.RiskMainRepository;
import com.beyontec.mol.repository.TaxHistoryRepository;
import com.beyontec.mol.repository.TaxRepository;
import com.beyontec.mol.repository.UdsIdDefinitionRepository;
import com.beyontec.mol.repository.UpdateCertificateRepository;
import com.beyontec.mol.util.AppConstants;
import com.beyontec.mol.util.CertificateCancellationConstants;
import com.beyontec.mol.util.CustomDateSerializer;
import com.beyontec.mol.util.DMSConstants;
import com.beyontec.mol.util.DateUtil;
import com.beyontec.mol.util.ReportGeneratorUtil;
import com.beyontec.mol.util.TokenGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

@Service
public class CertificateService extends BaseService {

    @Autowired private CertificateDetailsRepository certificateDetailsRepository;

    @Autowired private PolicyHistoryRepository policyHistoryRepository;

    @Autowired private CertificateCancellationRepository certificateCancellationRepository;

    @Autowired private ProductAppBusTypeRepository productAppBusTypeRepo;

    @Autowired private PolicyMainRepository policyMainRepo;

    @Autowired private RiskMainRepository riskMainRepo;

    @Autowired private RiskHistoryRepository riskHistoryRepo;

    @Autowired private RiskAdditionalMainRepository riskAdditionalMainRepo;

    @Autowired private RiskAdditionalHistoryRepository riskAdditionalHistoryRepo;

    @Autowired private CoverageMainRepository coverageMainRepo;

    @Autowired private CoverageHistoryRepository coverageHistoryRepo;

    @Autowired private CoverageSmiMainRepository coverageSmiMainRepo;

    @Autowired private CoverageSmiHistoryRepository coverageSmiHistoryRepo;

    @Autowired private TaxRepository taxRepo;

    @Autowired private TaxHistoryRepository taxHistoryRepo;

    @Autowired private InstallmentRepository installmentRepo;

    @Autowired private InstallmentHistoryRepository installmentHistoryRepo;

    @Autowired private PrintDocumentRepository printDocumentRepo;

    @Autowired private PrintDocumentTemplateRepository printDocumentTemplateRepo;

    @Autowired private UpdateCertificateRepository updateCertificateRepository;

    @Autowired private DMSService dmsService;

    @Autowired private ModelMapper modelMapper;

    @Autowired private TokenGenerator tokenGenerator;

    @Value("${date.format}") private String dateFormat;
    @Autowired private CertificateDAO certificateDAO;

    @Autowired private UdsIdDefinitionRepository udsIdDefinitionRepository;

    @Autowired private ReportGeneratorUtil reportGeneratorUtil;

    @Autowired private CustomerService customerService;

    @Transactional
    public CertificateDetails captureCertificateDetails(CertificateDTO certificate, String clientIpAddress) {
        CertificateDetails certificateDetails = invokeModelMapper(() -> modelMapper.map(certificate,
                                                                                        CertificateDetails.class),
                                                                  "modelMapper.map(certificate, CertificateDetails.class)");

        certificateDetails.setRequestType(certificateDetails.getTransactionType());
        certificateDetails.setReqInDate(DateUtil.now());
        certificateDetails.setServerIpAddress(CommonConfig.getServerIpAddress());
        certificateDetails.setClientIpAddress(clientIpAddress);
        CertificateDetails createdCertificateDetails = invokeRepo(() -> certificateDetailsRepository.save(certificateDetails),
                                                                  "certificateDetailsRepository.save(certificateDetails)");
        return createdCertificateDetails;
    }

    public static final String CERT_RESULT_KEY_MASTER_POLICY = "masterPolicy";
    public static final String CERT_RESULT_KEY_EXPIRY_DATE = "expiryDate";
    public static final String CERT_RESULT_KEY_APPROVAL_DATE = "approvalDate";

    @Transactional
    public Map<String, Object> createCertificate(CertificateDetails certificateDetails,
                                                 String authHeader,
                                                 Locale locale) throws Exception {
        try {
            return addCertificate(certificateDetails, authHeader, locale);
        } catch (Exception e) {
            captureCertificateErrDetails(certificateDetails,
                                         ErrorCode.UNHANDLED_EXCEPTION,
                                         CertificateDetails.STATUS.SYSTEM_ERR,
                                         locale,
                                         e);
            Map<String, Object> result = new HashMap<>(1);
            ApplicationException ae = new ApplicationException(ResponseStatusCode.UNKNOWN_ERROR,
                                                               ErrorCode.UNHANDLED_EXCEPTION,
                                                               e);
            result.put(AppConstants.ERRORS, ae);
            return result;
        }
    }

    private Map<String, Object> addCertificate(CertificateDetails certificateDetails,
                                               String authHeader,
                                               Locale locale) throws Exception {

        List<CertificateDetails> generatedCertByLabourRefNoAndTxnType = invokeRepo(() -> certificateDetailsRepository.findGeneratedCertByLabourRefNoAndTxnType(certificateDetails.getLabourReferenceNo(),
                                                                                                                                                               certificateDetails.getTransactionType()),
                                                                                   "certificateDetailsRepository.findGeneratedCertByLabourRefNo(certificate.getLabourReferenceNo(), certificateDetails.getTransactionType())");

        List<CertificateDetails> certByPassNoTxnTypeNation = invokeRepo(() -> certificateDetailsRepository.findCertByPassNoTxnTypeNation(certificateDetails.getPassportNo(),
                                                                                                                                                   certificateDetails.getTransactionType(),
                                                                                                                                                   certificateDetails.getNationality()),
                                                                                  "certificateDetailsRepository.findCertByPassNoTxnTypeNation(certificateDetails.getPassportNo(), certificateDetails.getTransactionType(), certificateDetails.getNationality())");

        List<CertificateDetails> generatedCertByEmiratesIdAndTxnType = invokeRepo(() -> certificateDetailsRepository.findGeneratedCertByEmiratesIdAndTxnType(certificateDetails.getEmiratesId(),
                                                                                                                                                             certificateDetails.getTransactionType()),
                                                                                  "certificateDetailsRepository.findGeneratedCertByEmiratesIdAndTxnType(certificateDetails.getEmiratesId(), certificateDetails.getTransactionType())");
        PolicyHistory masterPolicy = getMasterPolicy(certificateDetails, false);
        PolicyMain previousPolicy = getPreviousPolicy(certificateDetails.getPreviousPolicyNo());
        ApplicationException appException = certificateDetails.validate(generatedCertByLabourRefNoAndTxnType,
                                                                        certByPassNoTxnTypeNation,
                                                                        generatedCertByEmiratesIdAndTxnType,
                                                                        masterPolicy,
                                                                        previousPolicy);

        Map<String, Object> result = new HashMap<>();
        if (appException.hasError()) {
            result.put(AppConstants.ERRORS, appException);
            captureCertificateErrDetails(certificateDetails,
                                         appException,
                                         CertificateDetails.STATUS.VALIDATION_ERR,
                                         locale);
            return result;
        }

        result.put(CERT_RESULT_KEY_MASTER_POLICY, masterPolicy);
        String certificateNo = getPolicyNo(certificateDetails, masterPolicy);
        certificateDetails.setCertificateNumber(certificateNo);
        result.put(AppConstants.CERTIFICATE_NO, certificateNo);

        Date extendedExpiryDate = certificateDetails.getExtendedExpiryDate(masterPolicy.getProductId());
        certificateDetails.setExpiryDate(extendedExpiryDate);
        certificateDetails.setCompanyId(masterPolicy.getCompanyId());
        result.put(CERT_RESULT_KEY_EXPIRY_DATE, DateUtil.toString(extendedExpiryDate));
        result.put(CERT_RESULT_KEY_APPROVAL_DATE, DateUtil.toString(certificateDetails.getVisaApprovalDate()));

        captureCertificateSuccessRes(certificateDetails, locale);

        return result;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void createCertificateEntries(CertificateDetails certificateDetails,
                                         String authHeader,
                                         Locale locale) throws Exception {

        Map<String, Object> result = addCertificate(certificateDetails, authHeader, locale);
        if (result.get(AppConstants.ERRORS) != null) {

            ApplicationException appException = (ApplicationException) result.get(AppConstants.ERRORS);

            StringBuilder errorMessages = new StringBuilder("");
            for (ErrorDetail errorDetail : appException.getErrors()) {

                String errMsg = getErrorMessage(errorDetail.getCode(), errorDetail.getDataArr(), locale);
                errorMessages.append(StringUtils.isEmpty(errorMessages.toString()) ? "" : ", ");
                errorMessages.append(errMsg);
            }
            certificateDetails.setErrMsg(errorMessages.toString());
            certificateDetails.setBatchProcessStatus(AppConstants.ERROR_BATCH);
            invokeRepo(() -> certificateDetailsRepository.save(certificateDetails),
                       "certificateDetailsRepository.save(certificateDetails)");
        } else {

            PolicyHistory masterPolicy = (PolicyHistory) result.get(CertificateService.CERT_RESULT_KEY_MASTER_POLICY);
            addCertificateEntries(certificateDetails,
                                  result.get(AppConstants.CERTIFICATE_NO).toString(),
                                  masterPolicy,
                                  locale,
                                  true);
        }
    }

    private void captureCertificateSuccessRes(CertificateDetails certificateDetails, Locale locale) {
        certificateDetails.setStatus(CertificateDetails.STATUS.SUCCESS.getValue());
        certificateDetails.setRespId(ErrorCode.CERTIFICATE_ISSUED.getCode());

        String responseMsg = getErrorMessage(ErrorCode.CERTIFICATE_ISSUED, locale);
        certificateDetails.setRespMsg(responseMsg);

        invokeRepo(() -> certificateDetailsRepository.save(certificateDetails),
                   "certificateDetailsRepository.save(certificateDetails)");
    }

    private void captureCertificateErrDetails(CertificateDetails certificateDetails,
                                              ApplicationException appException,
                                              STATUS certificateDetailsStatus,
                                              Locale locale) {
        certificateDetails.setErrType(certificateDetailsStatus.getValue());
        certificateDetails.setStatus(certificateDetailsStatus.getValue());

        String errCodes = appException.getErrors()
                                      .stream()
                                      .map(error -> error.getCode())
                                      .collect(Collectors.joining(CommonConfig.DELIMITER_COMMA));
        certificateDetails.setErrId(errCodes);

        String errMsgs = appException.getErrors()
                                     .stream()
                                     .map(error -> getErrorMessage(error.getCode(), error.getDataArr(), locale))
                                     .collect(Collectors.joining(CommonConfig.DELIMITER_COMMA));
        certificateDetails.setErrMsg(errMsgs);

        if (appException.getErrorCode() != null) {
            certificateDetails.setErrId(errCodes + appException.getErrorCode().getCode());
            certificateDetails.setErrMsg(errMsgs + getErrorMessage(appException.getErrorCode(), locale));
        }
        invokeRepo(() -> certificateDetailsRepository.save(certificateDetails),
                   "certificateDetailsRepository.save(certificateDetails)");
    }

    private void captureCertificateErrDetails(CertificateDetails certificateDetails,
                                              ErrorCode errCode,
                                              CertificateDetails.STATUS certificateDetailsStatus,
                                              Locale locale,
                                              Exception e) {
        certificateDetails.setErrId(errCode.getCode());
        certificateDetails.setErrType(certificateDetailsStatus.getValue());

        String errMsg = getErrorMessage(errCode, locale) + ". Exception: " + getErrorMessage(e, locale);
        certificateDetails.setErrMsg(errMsg);
        certificateDetails.setStatus(certificateDetailsStatus.getValue());
        invokeRepo(() -> certificateDetailsRepository.save(certificateDetails),
                   "certificateDetailsRepository.save(certificateDetails)");
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addCertificateEntries(CertificateDetails certificateDetails,
                                      String certificateNo,
                                      PolicyHistory masterPolicy,
                                      Locale locale) throws Exception {
        addCertificateEntries(certificateDetails, certificateNo, masterPolicy, locale, false);
    }

    private void addCertificateEntries(CertificateDetails certificateDetails,
                                       String certificateNo,
                                       PolicyHistory masterPolicy,
                                       Locale locale,
                                       boolean isBatchProcess) throws Exception {
        // Create Certificate Policy
        PolicyMain certificatePolicyMain = createCertificatePolicyMain(certificateDetails, masterPolicy);
        createCertificatePolicyHistory(certificatePolicyMain);

        // Create Risk
        RiskMain riskMain = createRiskMain(certificateDetails, masterPolicy, certificatePolicyMain);
        createRiskHistory(riskMain);

        // Create Risk Additional
        RiskAdditionalMain riskAdditionalMain = createRiskAdditionalMain(riskMain,
                                                                         certificateDetails,
                                                                         certificatePolicyMain);
        createRiskAdditionalHistory(riskAdditionalMain);

        // Create Coverage
        List<CoverageMain> coverages = createCoverages(certificateDetails, masterPolicy, riskMain);
        createCoveragesHistory(coverages);

        // Create Coverage SMI
        List<CoverageSmiMain> coverageSmis = createCoverageSmis(certificateDetails, masterPolicy, riskMain);
        createCoverageSmisHistory(coverageSmis);

        // Create Tax
        List<Tax> taxes = createTaxes(masterPolicy, certificatePolicyMain, riskMain);
        createTaxHistories(certificatePolicyMain, taxes);

        // Create Installment
        Installment installment = createInstallment(certificatePolicyMain);
        createInstallmentHistory(certificatePolicyMain, installment);

        // Create Print Documents
        createPrintDocuments(certificateDetails, certificatePolicyMain);

        certificateDetails.setMasterPolicyNo(masterPolicy.getNumber());
        certificateDetails.setMasterAmdVerNo(masterPolicy.getAmendmentVersionNumber());
        certificateDetails.setStatus(CertificateDetails.STATUS.SUCCESS.getValue());
        if (isBatchProcess) {
            certificateDetails.setBatchProcessStatus(AppConstants.COMPLETED_BATCH);
        }
        invokeRepo(() -> certificateDetailsRepository.save(certificateDetails),
                   "certificateDetailsRepository.save(certificateDetails)");
        certificateDetailsRepository.populateIDS(certificatePolicyMain.getSgsId().longValue(),
                                                 certificatePolicyMain.getAmendmentVersionNumber().longValue());
    }

    private PolicyMain createCertificatePolicyMain(CertificateDetails certificateDetails,
                                                   PolicyHistory masterPolicy) {
        PolicyMain certificatePolicyMain = new PolicyMain();
        certificatePolicyMain.loadDefaults();
        certificatePolicyMain.loadFromUdsIdDefinition();
        certificatePolicyMain.loadFromMasterPolicy(masterPolicy);

        // Load from Certificate Details
        certificatePolicyMain.loadFromCertificateDetails(certificateDetails);

        // Load from Customer Details
        CustomerDetailsMain customerDetailsMain = customerService.getCustomerDetails(certificateDetails, masterPolicy);
        certificatePolicyMain.loadFromCustomerDetails(customerDetailsMain);

        // Load from Product App Bus Type
        ProductAppBusType productAppBusType = invokeRepo(() -> productAppBusTypeRepo.findByCompanyAndProduct(CommonConfig.COMPANY_ID,
                                                                                                             masterPolicy.getProductId()),
                                                         "productAppBusTypeRepo.findByCompanyAndProduct(CommonConfig.COMPANY_ID, masterPolicy.getProductId())");
        certificatePolicyMain.loadFromProductAppBusType(productAppBusType);

        return invokeRepo(() -> policyMainRepo.save(certificatePolicyMain),
                                                             "policyMainRepo.save(certificatePolicyMain)");
    }

    private void createCertificatePolicyHistory(PolicyMain certificatePolicyMain) {
        PolicyHistory certificatePolicyHistory = invokeModelMapper(() -> modelMapper.map(certificatePolicyMain,
                                                                                         PolicyHistory.class),
                                                                   "modelMapper.map(certificatePolicyMain, PolicyHistory.class)");
        certificatePolicyHistory.loadDefaults();
        invokeRepo(() -> policyHistoryRepository.save(certificatePolicyHistory),
                   "policyHistoryRepository.save(certificatePolicyHistory)");
    }

    private RiskMain createRiskMain(CertificateDetails certificateDetails,
                                    PolicyHistory masterPolicy,
                                    PolicyMain policyMain) {
        RiskMain riskMain = new RiskMain();
        riskMain.loadDefaults();
        riskMain.loadFromCertificateDetails(certificateDetails);
        riskMain.loadFromPolicyMain(policyMain);

        String riskType = UdsIdDefConfig.getRiskType(certificateDetails.getEmployeeCategory());
        RiskHistory masterRisk = riskHistoryRepo.findMasterRisk(masterPolicy.getSgsId(),
                                                                masterPolicy.getAmendmentVersionNumber(),
                                                                riskType);
        riskMain.loadFromMasterRisk(masterRisk);

        RiskMain createdRiskMain = invokeRepo(() -> riskMainRepo.save(riskMain), "riskMainRepo.save(riskMain)");
        return createdRiskMain;
    }

    private void createRiskHistory(RiskMain riskMain) {
        RiskHistory riskHistory = invokeModelMapper(() -> modelMapper.map(riskMain, RiskHistory.class),
                                                    "modelMapper.map(riskMain, RiskHistory.class)");
        riskHistory.loadDefaults();
        invokeRepo(() -> riskHistoryRepo.save(riskHistory), "riskHistoryRepo.save(riskHistory)");
    }

    private RiskAdditionalMain createRiskAdditionalMain(RiskMain riskMain,
                                                        CertificateDetails certificateDetails,
                                                        PolicyMain certificatePolicy) {
        RiskAdditionalMain riskAdditionalMain = new RiskAdditionalMain();
        riskAdditionalMain.loadDefaults();
        riskAdditionalMain.loadFromRiskMain(riskMain);
        riskAdditionalMain.loadFromCertificatePolicy(certificatePolicy);
        riskAdditionalMain.loadFromCertificateDetails(certificateDetails);

        RiskAdditionalMain createdRiskAdditionalMain = invokeRepo(() -> riskAdditionalMainRepo.save(riskAdditionalMain),
                                                                  "riskAdditionalMainRepo.save(riskAdditionalMain)");
        return createdRiskAdditionalMain;
    }

    private void createRiskAdditionalHistory(RiskAdditionalMain riskAdditionalMain) {
        RiskAdditionalHistory riskAdditionalHistory = invokeModelMapper(() -> modelMapper.map(riskAdditionalMain,
                                                                                              RiskAdditionalHistory.class),
                                                                        "modelMapper.map(riskAdditionalMain, RiskAdditionalHistory.class)");
        riskAdditionalHistory.loadDefaults();
        riskAdditionalHistory.loadFromRiskAdditionalMain(riskAdditionalMain);
        invokeRepo(() -> riskAdditionalHistoryRepo.save(riskAdditionalHistory),
                   "riskAdditionalHistoryRepo.save(riskAdditionalHistory)");
    }

    private List<CoverageMain> createCoverages(CertificateDetails certificateDetails,
                                               PolicyHistory masterPolicy,
                                               RiskMain certificateRisk) {
        String riskType = UdsIdDefConfig.getRiskType(certificateDetails.getEmployeeCategory());
        List<CoverageHistory> masterCoverages = invokeRepo(() -> coverageHistoryRepo.findMasterCoverages(masterPolicy.getSgsId(),
                                                                                                         masterPolicy.getAmendmentVersionNumber(),
                                                                                                         riskType),
                                                           "coverageHistoryRepo.findMasterCoverages(masterPolicy.getSgsId(), masterPolicy.getAmendmentVersionNumber(), riskType)");
        List<CoverageMain> coverages = masterCoverages.stream().map(masterCoverage -> {
            CoverageMain coverageMain = new CoverageMain();
            coverageMain.loadDefaults();
            coverageMain.loadFromCertificateRisk(certificateRisk);
            coverageMain.loadFromMasterCoverage(masterCoverage);
            return coverageMain;
        }).collect(Collectors.toList());
        List<CoverageMain> createdCoverages = invokeRepo(() -> coverageMainRepo.save(coverages),
                                                         "coverageMainRepo.save(coverages)");
        return createdCoverages;
    }

    private void createCoveragesHistory(List<CoverageMain> coverages) {
        List<CoverageHistory> coveragesHistory = coverages.stream().map(coverage -> {
            CoverageHistory coverageHistory = invokeModelMapper(() -> modelMapper.map(coverage, CoverageHistory.class),
                                                                "modelMapper.map(coverage, CoverageHistory.class)");
            coverageHistory.loadDefaults();
            return coverageHistory;
        }).collect(Collectors.toList());
        invokeRepo(() -> coverageHistoryRepo.save(coveragesHistory), "coverageHistoryRepo.save(coveragesHistory)");
    }

    private List<CoverageSmiMain> createCoverageSmis(CertificateDetails certificateDetails,
                                                     PolicyHistory masterPolicy,
                                                     RiskMain certificateRisk) {
        String riskType = UdsIdDefConfig.getRiskType(certificateDetails.getEmployeeCategory());
        List<CoverageSmiHistory> masterCoverageSmis = invokeRepo(() -> coverageSmiHistoryRepo.findMasterCoverageSmis(masterPolicy.getSgsId(),
                                                                                                                     masterPolicy.getAmendmentVersionNumber(),
                                                                                                                     riskType),
                                                                 "coverageSmiHistoryRepo.findMasterCoverageSmis(masterPolicy.getSgsId(), masterPolicy.getAmendmentVersionNumber(), riskType)");
        List<CoverageSmiMain> coverageSmis = masterCoverageSmis.stream().map(masterCoverageSmi -> {
            CoverageSmiMain coverageSmiMain = new CoverageSmiMain();
            coverageSmiMain.loadDefaults();
            coverageSmiMain.loadFromCertificateRisk(certificateRisk);
            coverageSmiMain.loadFromMasterCoverage(masterCoverageSmi);
            return coverageSmiMain;
        }).collect(Collectors.toList());
        List<CoverageSmiMain> createdCoverageSmis = invokeRepo(() -> coverageSmiMainRepo.save(coverageSmis),
                                                               "coverageSmiMainRepo.save(coverageSmis)");
        return createdCoverageSmis;
    }

    private void createCoverageSmisHistory(List<CoverageSmiMain> coverageSmis) {
        List<CoverageSmiHistory> coverageSmisHistory = coverageSmis.stream().map(coverageSmi -> {
            CoverageSmiHistory coverageSmiHistory = invokeModelMapper(() -> modelMapper.map(coverageSmi,
                                                                                            CoverageSmiHistory.class),
                                                                      "modelMapper.map(coverageSmi, CoverageSmiHistory.class)");
            coverageSmiHistory.loadDefaults();
            return coverageSmiHistory;
        }).collect(Collectors.toList());
        invokeRepo(() -> coverageSmiHistoryRepo.save(coverageSmisHistory),
                   "coverageSmiHistoryRepo.save(coverageSmisHistory)");
    }

    private List<Tax> createTaxes(PolicyHistory masterPolicy, PolicyMain certificatePolicy, RiskMain certificateRisk) {
        List<TaxHistory> masterTaxes = invokeRepo(() -> taxHistoryRepo.findMasterTaxes(masterPolicy.getSgsId(),
                                                                                       masterPolicy.getAmendmentVersionNumber()),
                                                  "taxHistoryRepo.findMasterTax(masterPolicy.getSgsId(), masterPolicy.getAmendmentVersionNumber())");

        Premium premium = invokeRepo(() -> coverageSmiMainRepo.findCertificatePremium(certificatePolicy.getSgsId(),
                                                                                         certificatePolicy.getAmendmentVersionNumber()),
                                     "coverageSmiHistoryRepo.findCertificatePremium(certificatePolicy.getSgsId(), certificatePolicy.getAmendmentVersionNumber())");

        List<Tax> taxes = masterTaxes.stream().map(masterTax -> {
            Tax tax = new Tax();
            tax.loadDefaults();
            tax.loadFromCertificatePolicy(certificatePolicy);
            tax.loadFromCertificateRisk(certificateRisk);
            tax.loadFromMasterTax(masterTax);
            tax.setSourceAmount(premium.getAmount());
            tax.setSourceAmountBc(premium.getAmountBc());
            return tax;
        }).collect(Collectors.toList());

        List<Tax> createdTaxes = invokeRepo(() -> taxRepo.save(taxes), "taxRepo.save(taxes)");
        return createdTaxes;
    }

    private void createTaxHistories(PolicyMain certificatePolicyMain, List<Tax> taxes) {
        Premium premiumHistory = invokeRepo(() -> coverageSmiHistoryRepo.findMasterPremium(certificatePolicyMain.getSgsId(),
                                                                                           certificatePolicyMain.getAmendmentVersionNumber()),
                                            "coverageSmiHistoryRepo.premiumHistory(certificatePolicyMain.getSgsId(), certificatePolicyMain.getAmendmentVersionNumber())");
        List<TaxHistory> taxHistories = taxes.stream().map(tax -> {
            TaxHistory taxHistory = invokeModelMapper(() -> modelMapper.map(tax, TaxHistory.class),
                                                      "modelMapper.map(tax, TaxHistory.class)");
            taxHistory.loadDefaults();
            taxHistory.setSourceAmount(premiumHistory.getAmount());
            taxHistory.setSourceAmountBc(premiumHistory.getAmountBc());
            return taxHistory;
        }).collect(Collectors.toList());
        invokeRepo(() -> taxHistoryRepo.save(taxHistories), "taxHistoryRepo.save(taxHistories)");
    }

    private Installment createInstallment(PolicyMain certificatePolicy) {
        Installment installment = new Installment();
        installment.loadDefaults();
        installment.loadFromCertificatePolicy(certificatePolicy);
        installment.loadFromUdsIdDef();

        Premium premium = invokeRepo(() -> coverageSmiMainRepo.findCertificatePremium(certificatePolicy.getSgsId(),
                                                                                         certificatePolicy.getAmendmentVersionNumber()),
                                     "coverageSmiHistoryRepo.findCertificatePremium(certificatePolicy.getSgsId(), certificatePolicy.getAmendmentVersionNumber())");
        TotalTax totalTax = invokeRepo(() -> taxRepo.getTotalTax(certificatePolicy.getSgsId(),
                                                                 certificatePolicy.getAmendmentVersionNumber()),
                                       "taxRepo.getTotalTax(certificatePolicy.getSgsId(), certificatePolicy.getAmendmentVersionNumber())");
        installment.setInstallmentAmount(premium.getAmount().add(totalTax.getAmount()));
        installment.setInstallmentAmountBc(premium.getAmountBc().add(totalTax.getAmountBc()));
        installment.setTcfAmount(totalTax.getAmount());
        installment.setTcfAmountBc(totalTax.getAmountBc());
        Installment createdInstallment = invokeRepo(() -> installmentRepo.save(installment),
                                                    "installmentRepo.save(installment)");
        return createdInstallment;
    }

    private void createInstallmentHistory(PolicyMain certificatePolicy,
                                          Installment installment) {
        InstallmentHistory installmentHistory = invokeModelMapper(() -> modelMapper.map(installment,
                                                                                        InstallmentHistory.class),
                                                                  "modelMapper.map(installment, InstallmentHistory.class)");
        installmentHistory.loadDefaults();
        installmentHistory.loadFromUdsIdDef();

        Premium premiumHistory = invokeRepo(() -> coverageSmiHistoryRepo.findMasterPremium(certificatePolicy.getSgsId(),
                                                                                           certificatePolicy.getAmendmentVersionNumber()),
                                            "coverageSmiHistoryRepo.premiumHistory(certificatePolicyMain.getSgsId(), certificatePolicyMain.getAmendmentVersionNumber())");
        TotalTax totalTaxHistory = invokeRepo(() -> taxHistoryRepo.getTotalTaxHistory(certificatePolicy.getSgsId(),
                                                                                      certificatePolicy.getAmendmentVersionNumber()),
                                              "taxHistoryRepo.getTotalTaxHistory(certificatePolicy.getSgsId(), certificatePolicy.getAmendmentVersionNumber())");
        installmentHistory.setInstallmentAmount(premiumHistory.getAmount().add(totalTaxHistory.getAmount()));
        installmentHistory.setInstallmentAmountBc(premiumHistory.getAmountBc().add(totalTaxHistory.getAmountBc()));
        installmentHistory.setTcfAmount(totalTaxHistory.getAmount());
        installmentHistory.setTcfAmountBc(totalTaxHistory.getAmountBc());
        invokeRepo(() -> installmentHistoryRepo.save(installmentHistory),
                   "installmentHistoryRepo.save(installmentHistory)");
    }

    private void createPrintDocuments(CertificateDetails certificateDetails, PolicyMain certificatePolicy) {
        List<PrintDocumentTemplate> templates = invokeRepo(() -> printDocumentTemplateRepo.findTemplatesByProductId(certificatePolicy.getCompanyId(),
                                                                                                                    certificatePolicy.getProductId()),
                                                           "printDocumentTemplateRepo.findTemplatesByProductId(certificatePolicy.getCompanyId(), certificatePolicy.getProductId())");
        List<PrintDocument> docs = templates.stream().map(template -> {
            PrintDocument printDocument = new PrintDocument();
            printDocument.loadDefaults();
            printDocument.loadFromCertificateDetails(certificateDetails);
            printDocument.loadFromCertificatePolicy(certificatePolicy);
            printDocument.loadFromTemplate(template);
            return printDocument;
        }).collect(Collectors.toList());
        invokeRepo(() -> printDocumentRepo.save(docs), "printDocumentRepo.save(docs)");
    }

    @Transactional
    public ApplicationException cancelCertificate(CancelCertificateDTO cancelCertificateDTO,
                                                  Locale locale,
                                                  String clientIpAddress) throws Exception {
        CertificateCancellation certificateCancellation = modelMapper.map(cancelCertificateDTO,
                                                                          CertificateCancellation.class);
        try {
            return cancelCertificate(cancelCertificateDTO, certificateCancellation, locale, clientIpAddress);
        } catch (Exception e) {
            ApplicationException ae = null;
            if (ae instanceof ApplicationException) {
                ae = (ApplicationException) e;
            } else {
                ae = new ApplicationException(ResponseStatusCode.UNKNOWN_ERROR,
                                              ErrorCode.UNHANDLED_EXCEPTION,
                                              e);
            }
            certificateCancellation.setRequestStatus(CertificateCancellationConstants.CERTIFICATE_CANCEL_SYSTEM_ERROR_STATUS);
            certificateCancellation.setErrorType(CertificateCancellationConstants.CERTIFICATE_CANCEL_SYSTEM_ERROR_TYPE);
            certificateCancellation.setErrorId(CertificateCancellationConstants.CERTIFICATE_CANCEL_SYSTEM_ERROR_ID);
            String errMsg = "Exception: " + getErrorMessage(e, locale);
            certificateCancellation.setErrorMessage(errMsg);
            certificateCancellation.setResponseMessage(getErrorMessage(ErrorCode.CERTIFICATE_CANCEL_FAILED, locale));
            invokeRepo(() -> certificateCancellationRepository.save(certificateCancellation),
                       "certificateCancellationRepository.save(certificateCancellation)");
            return ae;
        }
    }

    private ApplicationException cancelCertificate(CancelCertificateDTO cancelCertificateDTO,
                                                   CertificateCancellation certificateCancellation,
                                                   Locale locale,
                                                   String clientIpAddress) throws Exception {
        PolicyMain certificatePolicyMain = invokeRepo(() -> policyMainRepo.findByNumber(cancelCertificateDTO.getCertificateNo()),
                                                      "policyMainRepo.findByNumber(cancelCertificateDTO.getCertificateNo())");
        ApplicationException ae = validateCancelCertificate(cancelCertificateDTO, certificatePolicyMain);

        certificateCancellation.setServerIpAddress(CommonConfig.getServerIpAddress());
        certificateCancellation.setClientIpAddress(clientIpAddress);
        certificateCancellation.setRequestIncomingDate(DateUtil.now());
        certificateCancellation.setResponseDate(DateUtil.now());

        if (certificatePolicyMain != null) {
            certificateCancellation.setUlmSgsId(certificatePolicyMain.getSgsId());
            certificateCancellation.setUlmNo(certificatePolicyMain.getNumber());
            certificateCancellation.setCompanyId(certificatePolicyMain.getCompanyId());
        }

        if (!ae.hasError()) {
            certificateCancellation
                                   .setRequestStatus(CertificateCancellationConstants.CERTIFICATE_CANCEL_SUCCESS_STATUS);
            certificateCancellation
                                   .setResponseId(CertificateCancellationConstants.CERTIFICATE_CANCEL_SUCCESS_RESPOND_ID);
            certificateCancellation.setResponseMessage(getErrorMessage(ErrorCode.CERTIFICATE_CANCEL_SUCCESS, locale));
        } else {

            certificateCancellation.setRequestStatus(CertificateCancellationConstants.CERTIFICATE_CANCEL_ERROR_STATUS);
            certificateCancellation.setErrorType(CertificateCancellationConstants.CERTIFICATE_CANCEL_ERROR_TYPE);
            certificateCancellation.setErrorId(CertificateCancellationConstants.CERTIFICATE_CANCEL_ERROR_ID);

            String errorMessage = ae.getErrors().stream().map(error -> {
                return getErrorMessage(error.getCode(), error.getDataArr(), locale);
            }).collect(Collectors.joining(CommonConfig.DELIMITER_COMMA));
            certificateCancellation.setErrorMessage(errorMessage);
            certificateCancellation.setResponseMessage(getErrorMessage(ErrorCode.CERTIFICATE_CANCEL_FAILED, locale));
        }
        certificateCancellationRepository.save(certificateCancellation);
        return ae;
    }

    private ApplicationException validateCancelCertificate(CancelCertificateDTO cancelCertificateDTO,
                                                           PolicyMain certificatePolicyMain) {
        ApplicationException ae = cancelCertificateDTO.validate();
        if (certificatePolicyMain == null && !StringUtils.isEmpty(cancelCertificateDTO.getCertificateNo())) {
            ae.appendErr(ErrorCode.CERTIFICATE_NOT_AVAILABLE);
            return ae;
        }
        if (certificatePolicyMain == null) {
            return ae;
        }

        if (certificatePolicyMain.getStatus().equals("CAN")) {
            ae.appendErr(ErrorCode.ALREADY_CANCELLED_CERTIFICATE);
        }

        if (cancelCertificateDTO.getCancelledDate() == null) {
            return ae;
        }
        if (cancelCertificateDTO.getCancelledDate().compareTo(certificatePolicyMain.getFromDate()) < 0) {
            ae.appendErr(ErrorCode.CANCEL_LESS_VISA_APPROVAL);
        }
        if (cancelCertificateDTO.getCancelledDate().compareTo(certificatePolicyMain.getExpiryDate()) > 0) {
            ae.appendErr(ErrorCode.CANCEL_OUT_OF_CERTIFICATE);
        }

        return ae;
    }

    public Map<String, Object> downloadCertificate(String certificateNo,
                                                   String emiratesId,
                                                   String labourReferenceNo) throws Exception {

        OAuth2AccessToken accessToken = tokenGenerator.getAccessToken();
        String authHeader = accessToken.getTokenType() + " " + accessToken.getValue();

        List<DMSDocumentMetadata> documentMetadataList = null;
        CertificateDetails certificateDetails = null;
        UpdateCertificateDetails updateCertificateDetails = getUpdateCertificateDetails(certificateNo,
                                                                                        emiratesId,
                                                                                        labourReferenceNo);
        DMSDocumentMetadata documentMetadata = null;
        if (updateCertificateDetails != null) {

            certificateDetails = modelMapper.map(updateCertificateDetails, CertificateDetails.class);
            PolicyHistory masterPolicy = getMasterPolicy(certificateDetails, false);

            DMSDocumentMetadataDTO documentMetadataDTO = new DMSDocumentMetadataDTO(
                                                                                    certificateDetails.getCertificateNumber(),
                                                                                    DMSConstants.REF_TYPE_CERTIFICATE);
            documentMetadata = generateCertificate(authHeader,
                                                       documentMetadataList,
                                                       certificateDetails,
                                                       masterPolicy,
                                                       documentMetadataDTO);
        }

        else {
            certificateDetails = getCertificateDetails(certificateNo, emiratesId, labourReferenceNo);
            PolicyHistory masterPolicy = getMasterPolicy(certificateDetails, false);

            DMSDocumentMetadataDTO documentMetadataDTO = new DMSDocumentMetadataDTO(
                                                                                    certificateDetails.getCertificateNumber(),
                                                                                    DMSConstants.REF_TYPE_CERTIFICATE);
            try {
                documentMetadataList = dmsService.getDocumentList(documentMetadataDTO,
                                                              authHeader);
            } catch (ValidationException ex) {
                // Ignore
            }

            if (documentMetadataList == null || documentMetadataList.isEmpty()) {

                documentMetadata = generateCertificate(authHeader,
                                                 documentMetadataList,
                                                 certificateDetails,
                                                 masterPolicy,
                                                 documentMetadataDTO);
            } else {
                documentMetadata = documentMetadataList.get(0);
            }
        }

        Map<String, Object> documentDetails = dmsService.getDocument(documentMetadata.getGridFSId(),
                                                                     authHeader);
        documentDetails.put(AppConstants.FILE_NAME,
                            certificateDetails.getCertificateNumber() + AppConstants.PDF_FILE_EXTENSION);

        return documentDetails;
    }

    private DMSDocumentMetadata generateCertificate(String authHeader,
                                                List<DMSDocumentMetadata> documentMetadataList,
                                                CertificateDetails certificateDetails,
                                                PolicyHistory masterPolicy,
                                                DMSDocumentMetadataDTO documentMetadataDTO) {
        try {
            // Generate certificate and upload it to DMS
            return generateCertificate(certificateDetails,
                                masterPolicy,
                                authHeader);

        } catch (Exception ex) {
            throw new ValidationException(ErrorCode.UNABLE_TO_DOWNLOAD_CERTIFICATE);
        }
    }

    private ViewCertificateDTO getCodifiedDetails(String[] label, String uidType, String value) {

        String enValue = "";
        String arValue = "";
        if (!StringUtils.isEmpty(value)) {
            UdsIdDefinition def = UdsIdDefConfig.getUdsIdDefinitionDetails(uidType,
                                                                           value);
            if (!StringUtils.isEmpty(def)) {
                enValue = def.getUID_DESC();
                arValue = def.getUID_DESC_1();
            }
        }
        return getViewCertificateEntries(label, enValue, arValue);
    }

    public List<ViewCertificateDTO> viewCertificate(String certificateNo,
                                                    String emiratesId,
                                                    String labourReferenceNo) throws Exception {

        List<ViewCertificateDTO> viewCertificateDetails = new ArrayList<>();
        CertificateDetails certificateDetails = null;

        UpdateCertificateDetails updateCertificateDetails = getUpdateCertificateDetails(certificateNo,
                                                                                        emiratesId,
                                                                                        labourReferenceNo);
        if (updateCertificateDetails != null) {
            certificateDetails = modelMapper.map(updateCertificateDetails, CertificateDetails.class);
        } else {
            certificateDetails = getCertificateDetails(certificateNo, emiratesId, labourReferenceNo);
        }

        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        PolicyMain policyMain = policyMainRepo.findByNumber(certificateDetails.getCertificateNumber());
        PolicyHistory masterPolicy = getMasterPolicy(certificateDetails);
        List<Object[]> divDeptNames = policyHistoryRepository.getDivDeptName(policyMain.getDivnId(),
                                                                             policyMain.getDepartmentId());

        viewCertificateDetails.add(getViewCertificateEntries(AppConstants.DIVISION,
                                                             divDeptNames.get(0)[0],
                                                             divDeptNames.get(0)[1]));
        viewCertificateDetails.add(getViewCertificateEntries(AppConstants.DEPARTMENT,
                                                             divDeptNames.get(0)[2],
                                                             divDeptNames.get(0)[3]));
        viewCertificateDetails.add(getViewCertificateEntries(AppConstants.CERTIFICATE_NUMBER,
                                                             certificateDetails.getCertificateNumber(),
                                                             certificateDetails.getCertificateNumber()));
        viewCertificateDetails.add(getViewCertificateEntries(AppConstants.EMPLOYER_NAME,
                                                             certificateDetails.getEmployerNameEn(),
                                                             certificateDetails.getEmployerNameAr()));
        viewCertificateDetails.add(getViewCertificateEntries(AppConstants.EMPLOYER_LICENSE_NO,
                                                             certificateDetails.getEmployerLicenseNo(),
                                                             certificateDetails.getEmployerLicenseNo()));

        if (UdsIdDefConfig.isCodifiedValue(UdsIdDefConfig.ID_TYPE_EST_CLASS_TYPE,
                                           certificateDetails.getEstablishmentClassfication(),
                                           new ApplicationException())) {
            viewCertificateDetails.add(
                                       getCodifiedDetails(AppConstants.ESTABLISHMENT_CLASSIFICATION,
                                                          UdsIdDefConfig.ID_TYPE_EST_CLASS_TYPE,
                                                          certificateDetails.getEstablishmentClassfication()));
        } else {
            viewCertificateDetails.add(getViewCertificateEntries(AppConstants.ESTABLISHMENT_CLASSIFICATION,
                                                                 certificateDetails.getEstablishmentClassfication(),
                                                                 certificateDetails.getEstablishmentClassfication()));
        }

        viewCertificateDetails.add(getViewCertificateEntries(AppConstants.ESTABLISHMENT_CARD_NO,
                                                             certificateDetails.getEstablishmentCardNo(),
                                                             certificateDetails.getEstablishmentCardNo()));
        viewCertificateDetails.add(getViewCertificateEntries(AppConstants.EMPLOYEE_NAME,
                                                             certificateDetails.getWorkerNameEn(),
                                                             certificateDetails.getWorkerNameAr()));
        viewCertificateDetails.add(
                                   getCodifiedDetails(AppConstants.NATIONALITY,
                                                      UdsIdDefConfig.ID_TYPE_COUNTRY,
                                                      certificateDetails.getNationality()));
        viewCertificateDetails.add(getViewCertificateEntries(AppConstants.DATE_OF_BIRTH,
                                                             formatter.format(certificateDetails.getDateOfBirth()),
                                                             formatter.format(certificateDetails.getDateOfBirth())));
        viewCertificateDetails.add(
                                   getCodifiedDetails(AppConstants.GENDER,
                                                      UdsIdDefConfig.ID_TYPE_GENDER,
                                                      certificateDetails.getGender()));
        viewCertificateDetails.add(getViewCertificateEntries(AppConstants.EMIRATES_ID,
                                                             certificateDetails.getEmiratesId(),
                                                             certificateDetails.getEmiratesId()));
        viewCertificateDetails.add(
                                   getCodifiedDetails(AppConstants.MARITAL_STATUS,
                                                      UdsIdDefConfig.ID_TYPE_MARITAL_STATUS,
                                                      certificateDetails.getMaritalStatus()));
        viewCertificateDetails.add(getViewCertificateEntries(AppConstants.PASSPORT_NO,
                                                             certificateDetails.getPassportNo(),
                                                             certificateDetails.getPassportNo()));
        viewCertificateDetails.add(
                                   getCodifiedDetails(AppConstants.PASSPORT_TYPE,
                                                      UdsIdDefConfig.ID_TYPE_PASSPORT_TYPE,
                                                      certificateDetails.getPassportType()));
        viewCertificateDetails.add(getViewCertificateEntries(AppConstants.LABOUR_REFERENCE_NO,
                                                             certificateDetails.getLabourReferenceNo(),
                                                             certificateDetails.getLabourReferenceNo()));

        //job id
        if (!StringUtils.isEmpty(certificateDetails.getMohreJobId())) {
            viewCertificateDetails.add(
                                       getCodifiedDetails(AppConstants.ENSCO_MOHRE,
                                                          UdsIdDefConfig.ID_TYPE_MOHRE_JOB_ID,
                                                          certificateDetails.getMohreJobId()));
        } else if (!StringUtils.isEmpty(certificateDetails.getEnscoJobId())) {
            viewCertificateDetails.add(
                                       getCodifiedDetails(AppConstants.ENSCO_MOHRE,
                                                          UdsIdDefConfig.ID_TYPE_ENSCO_JOB_ID,
                                                          certificateDetails.getEnscoJobId()));
        }

        viewCertificateDetails.add(
                                   getCodifiedDetails(AppConstants.INDUSTRY,
                                                      UdsIdDefConfig.ID_TYPE_INDUS_TYPE,
                                                      certificateDetails.getIndustry()));

        //policy period
        String policyPeriodEn = formatter.format(certificateDetails.getVisaApprovalDate())
                                + " "
                                + getErrorMessage(ErrorCode.TO, Locale.ENGLISH)
                                + " "
                                + formatter.format(certificateDetails.getVisaExpirationDate());
        String policyPeriodAr = formatter.format(certificateDetails.getVisaApprovalDate())
                                + " "
                                + getErrorMessage(ErrorCode.TO, new Locale("ar"))
                                + " "
                                + formatter.format(certificateDetails.getVisaExpirationDate());
        viewCertificateDetails.add(getViewCertificateEntries(AppConstants.POLICY_PERIOD,
                                                             policyPeriodEn,
                                                             policyPeriodAr));

        viewCertificateDetails.add(
                                   getCodifiedDetails(AppConstants.EMPLOYEE_CATEGORY,
                                                      UdsIdDefConfig.ID_TYPE_EMP_CATG,
                                                      certificateDetails.getEmployeeCategory()));

        // coverages
        Map<String, Map<String, Map<String, List<String>>>> coverages = getCoverges(masterPolicy);
        viewCertificateDetails.add(getViewCertificateEntries(AppConstants.COVERS,
                                                             getCoveragesList(coverages.get(AppConstants.ENGLISH)),
                                                             getCoveragesList(coverages.get(AppConstants.ARABIC))));

        //premium
        BigDecimal premiumAmount = coverageSmiMainRepo.findCertificatePremium(policyMain.getSgsId(),
                                                                                 policyMain.getAmendmentVersionNumber())
                                                         .getAmount();
        viewCertificateDetails.add(getViewCertificateEntries(AppConstants.PREMIUM,
                                                             premiumAmount,
                                                             premiumAmount));

        return viewCertificateDetails;
    }

    private ViewCertificateDTO getViewCertificateEntries(String[] label, Object enValue, Object arValue) {

        ViewCertificateDTO viewCertificateDTO = new ViewCertificateDTO();
        viewCertificateDTO.setEn(new ViewCertificateDetailDTO(label[0], (enValue == null ? "" : enValue)));
        viewCertificateDTO.setAr(new ViewCertificateDetailDTO(label[1], (arValue == null ? "" : arValue)));
        return viewCertificateDTO;
    }

    private Map<String, Map<String, Map<String, List<String>>>> getCoverges(PolicyHistory masterPolicy) {

        List<Object[]> coverageDetails = coverageHistoryRepo.findCertificateCoverages(masterPolicy.getSgsId(),
                                                                                      masterPolicy.getAmendmentVersionNumber());

        Map<String, Map<String, Map<String, List<String>>>> coverages = new HashMap<>();
        coverages.put(AppConstants.ENGLISH, getCoverageSections(3, 4, 0, coverageDetails));
        coverages.put(AppConstants.ARABIC, getCoverageSections(5, 6, 1, coverageDetails));
        return coverages;
    }

    private List<String> getCoveragesList(Map<String, Map<String, List<String>>> coverages) {

        List<String> coveragesList = new ArrayList<>();

        for (Map.Entry<String, Map<String, List<String>>> headingEntry : coverages.entrySet()) {

            if (coverages.size() > 1 && headingEntry.getKey() != null) {
                coveragesList.add("<b>" + headingEntry.getKey() + "</b>");
            }
            for (Map.Entry<String, List<String>> subHeadingEntry : headingEntry.getValue().entrySet()) {
                if (subHeadingEntry.getKey() != null) {
                    coveragesList.add(subHeadingEntry.getKey());
                }
                coveragesList.addAll(subHeadingEntry.getValue());
            }
        }

        return coveragesList;
    }

    private Map<String, Map<String, List<String>>> getCoverageSections(int headingIndex,
                                                                       int subHeadingIndex,
                                                                       int coverageIndex,
                                                                       List<Object[]> coverageDetails) {

        Map<String, Map<String, List<String>>> coverageSections = new HashMap<>();
        int index = 1;
        for (Object[] coverage : coverageDetails) {

            String heading = coverage[headingIndex] == null ? null : coverage[headingIndex].toString();
            Map<String, List<String>> existSubHeading = coverageSections.get(heading);
            if (existSubHeading == null) {
                index = 1;
                existSubHeading = new HashMap<>();
                coverageSections.put(heading, existSubHeading);
            }

            String subHeading = coverage[subHeadingIndex] == null ? null : coverage[subHeadingIndex].toString();
            List<String> existCoverages = existSubHeading.get(subHeading);
            if (existCoverages == null) {
                existCoverages = new ArrayList<>();
                existSubHeading.put(subHeading, existCoverages);
            }

            if (coverage[coverageIndex] != null) {
                existCoverages.add(index + " - " + coverage[coverageIndex].toString());
                existSubHeading.put(subHeading, existCoverages);
                index++;
            }
        }
        return coverageSections;
    }

    public boolean acknowledgeCertificate(AcknowledgementDTO acknowledgementDTO) throws Exception {

        Map<ErrorCode, Object[]> errors = new HashMap<>();
        Date visaApproveDate = null;
        Date visaExpiryDate = null;

        if (StringUtils.isEmpty(acknowledgementDTO.getCertificateNo())) {
            errors.put(ErrorCode.CERTIFICATE_NO_MISSING, null);
        }

        if (StringUtils.isEmpty(acknowledgementDTO.getVisaApprovalDate())) {
            errors.put(ErrorCode.VISA_APPROVAL_DATE_MISSING, null);
        }

        if (StringUtils.isEmpty(acknowledgementDTO.getVisaExpirationDate())) {
            errors.put(ErrorCode.VISA_EXPIRY_DATE_MISSING, null);
        }

        if (!errors.containsKey(ErrorCode.VISA_APPROVAL_DATE_MISSING)) {
            visaApproveDate = DateUtil.convert(acknowledgementDTO.getVisaApprovalDate());
            if (visaApproveDate == null) {
                errors.put(ErrorCode.CERTIFICATE_VISA_APPROVAL_DATE_FORMAT_INVALID,
                           new Object[] { CommonConfig.DATE_FORMAT.toPattern() });
            }
        }

        if (!errors.containsKey(ErrorCode.VISA_EXPIRY_DATE_MISSING)) {
            visaExpiryDate = DateUtil.convert(acknowledgementDTO.getVisaExpirationDate());
            if (visaExpiryDate == null) {
                errors.put(ErrorCode.CERTIFICATE_VISA_EXPIRATION_DATE_FORMAT_INVALID,
                           new Object[] { CommonConfig.DATE_FORMAT.toPattern() });
            }
        }

        if (errors.size() > 0) {
            throw new ValidationException(errors);
        }

        CertificateDetails certificateDetails = certificateDetailsRepository.findByCertificateNumber(acknowledgementDTO.getCertificateNo());

        if (certificateDetails == null) {
            throw new ValidationException(ErrorCode.ACK_CERTIFICATE_DOES_NOT_EXIST);
        }

        boolean result = (certificateDetails.getVisaApprovalDate().compareTo(visaApproveDate) == 0
                          && certificateDetails.getExpiryDate().compareTo(visaExpiryDate) == 0);

        if (result) {
            if (AppConstants.ACK_SENT.equals(certificateDetails.getAcknowledgeFlag())) {
                throw new ValidationException(ErrorCode.ACKNOWLEDGEMENT_ALREADY_SENT);
            }
            certificateDetails.setAcknowledgeFlag(AppConstants.ACK_SENT);
            certificateDetailsRepository.save(certificateDetails);
            return true;
        }
        throw new ValidationException(ErrorCode.ACK_CERTIFICATE_DOES_NOT_EXIST);
    }

    public CertificateDTO payloadCertificate(String certificateNo) throws Exception {

        CertificateDetails certificateDetails = certificateDetailsRepository.findByCertificateNumber(certificateNo);
        if (certificateDetails == null) {
            throw new ValidationException(ErrorCode.CERTIFICATE_DOES_NOT_EXIST);
        }
        return modelMapper.map(certificateDetails, CertificateDTO.class);
    }

    private Map<String, String> getEmployerAddress(CertificateDetails certificateDetails) {

        CustomerDetailsMain customerDetails = customerService.getCustomerDetails(certificateDetails);
        String addressEn = "";
        String addressAr = "";

        if (!StringUtils.isEmpty(customerDetails)) {

            if (!StringUtils.isEmpty(customerDetails.getPinCode())) {
                addressEn = "PO Box " + customerDetails.getPinCode();
            }

            if (!StringUtils.isEmpty(customerDetails.getAddress1())) {
                addressEn += StringUtils.isEmpty(addressEn) ? "" : ", ";
                addressEn += customerDetails.getAddress1();
            }

            if (!StringUtils.isEmpty(customerDetails.getAddress2())) {
                addressEn += StringUtils.isEmpty(addressEn) ? "" : ", ";
                addressEn += customerDetails.getAddress2();
            }

            if (!StringUtils.isEmpty(customerDetails.getAddress3())) {
                addressEn += StringUtils.isEmpty(addressEn) ? "" : ", ";
                addressEn += customerDetails.getAddress3();
            }

            if (!StringUtils.isEmpty(customerDetails.getAddress4())) {
                addressEn += StringUtils.isEmpty(addressEn) ? "" : ", ";
                addressEn += customerDetails.getAddress4();
            }

            if (!StringUtils.isEmpty(customerDetails.getCity())) {
                addressEn += StringUtils.isEmpty(addressEn) ? "" : ", ";
                addressEn += customerDetails.getCity();
            }

            if (!StringUtils.isEmpty(customerDetails.getState())) {
                addressEn += StringUtils.isEmpty(addressEn) ? "" : ", ";
                addressEn += customerDetails.getState();
            }

            if (!StringUtils.isEmpty(customerDetails.getCountryId())) {
                String country = UdsIdDefConfig.getUdsIdDefinitionDetails(UdsIdDefConfig.ID_TYPE_COUNTRY,
                                                                          customerDetails.getCountryId())
                                               .getUID_DESC();
                if (!StringUtils.isEmpty(country)) {
                    addressEn += StringUtils.isEmpty(addressEn) ? "" : ", ";
                    addressEn += country;
                }
            }

            if (!StringUtils.isEmpty(customerDetails.getPinCode())) {
                addressAr = customerDetails.getPinCode() + " صندوق بريد";
            }

            if (!StringUtils.isEmpty(customerDetails.getAddress1Bl())) {
                addressAr += StringUtils.isEmpty(addressAr) ? "" : ", ";
                addressAr += customerDetails.getAddress1Bl();
            }

            if (!StringUtils.isEmpty(customerDetails.getAddress2Bl())) {
                addressAr += StringUtils.isEmpty(addressAr) ? "" : ", ";
                addressAr += customerDetails.getAddress2Bl();
            }

            if (!StringUtils.isEmpty(customerDetails.getAddress3Bl())) {
                addressAr += StringUtils.isEmpty(addressAr) ? "" : ", ";
                addressAr += customerDetails.getAddress3Bl();
            }

            if (!StringUtils.isEmpty(customerDetails.getAddress4Bl())) {
                addressAr += StringUtils.isEmpty(addressAr) ? "" : ", ";
                addressAr += customerDetails.getAddress4Bl();
            }

            if (!StringUtils.isEmpty(customerDetails.getCityBl())) {
                addressAr += StringUtils.isEmpty(addressAr) ? "" : ", ";
                addressAr += customerDetails.getCityBl();
            }

            if (!StringUtils.isEmpty(customerDetails.getStateBl())) {
                addressAr += StringUtils.isEmpty(addressAr) ? "" : ", ";
                addressAr += customerDetails.getStateBl();
            }

            if (!StringUtils.isEmpty(customerDetails.getCountryId())) {
                String country = UdsIdDefConfig.getUdsIdDefinitionDetails(UdsIdDefConfig.ID_TYPE_COUNTRY,
                                                                          customerDetails.getCountryId())
                                               .getUID_DESC_1();
                if (!StringUtils.isEmpty(country)) {
                    addressAr += StringUtils.isEmpty(addressAr) ? "" : ", ";
                    addressAr += country;
                }
            }
        }

        Map<String, String> address = new HashMap<>();
        address.put(AppConstants.ENGLISH, addressEn);
        address.put(AppConstants.ARABIC, addressAr);

        return address;

    }

    private CertificateDetails getCertificateDetails(String certificateNo,
                                                     String emiratesId,
                                                     String labourReferenceNo) {
        if (StringUtils.isEmpty(certificateNo)
            && StringUtils.isEmpty(emiratesId)
            && StringUtils.isEmpty(labourReferenceNo)) {
            throw new ValidationException(ErrorCode.ALL_FIELDS_MISSING);
        }

        CertificateDetails certificateDetails = null;
        if (!StringUtils.isEmpty(certificateNo)) {

            certificateDetails = certificateDetailsRepository.findByCertificateNumber(certificateNo);
            if (!StringUtils.isEmpty(certificateDetails)) {
                return certificateDetails;
            }
        }

        if (!StringUtils.isEmpty(emiratesId)) {

            certificateDetails = certificateDetailsRepository.findByEmiratesIdAndCertificateNumberNotNull(emiratesId);
            if (!StringUtils.isEmpty(certificateDetails)) {
                return certificateDetails;
            }
        }

        if (!StringUtils.isEmpty(labourReferenceNo)) {

            certificateDetails = certificateDetailsRepository.findByLabourReferenceNoAndCertificateNumberNotNull(labourReferenceNo);
            if (!StringUtils.isEmpty(certificateDetails)) {
                return certificateDetails;
            }
        }

        throw new ValidationException(ErrorCode.CERTIFICATE_NOT_EXIST);
    }

    private UpdateCertificateDetails getUpdateCertificateDetails(String certificateNo,
                                                                 String emiratesId,
                                                                 String labourReferenceNo) {
        if (StringUtils.isEmpty(certificateNo)
            && StringUtils.isEmpty(emiratesId)
            && StringUtils.isEmpty(labourReferenceNo)) {
            throw new ValidationException(ErrorCode.ALL_FIELDS_MISSING);
        }

        UpdateCertificateDetails certificateDetails = null;
        if (!StringUtils.isEmpty(certificateNo)) {

            certificateDetails = updateCertificateRepository.findFirstByCertificateNumberAndErrorTypeOrderBySgsIdDesc(certificateNo,
                                                                                                                       null);
            if (!StringUtils.isEmpty(certificateDetails)) {
                return certificateDetails;
            }
        }

        if (!StringUtils.isEmpty(emiratesId)) {

            certificateDetails = updateCertificateRepository.findFirstByEmiratesIdAndCertificateNumberNotNullOrderBySgsIdDesc(emiratesId);
            if (!StringUtils.isEmpty(certificateDetails)) {
                return certificateDetails;
            }
        }

        if (!StringUtils.isEmpty(labourReferenceNo)) {

            certificateDetails = updateCertificateRepository.findFirstByLabourReferenceNoAndCertificateNumberNotNullOrderBySgsIdDesc(labourReferenceNo);
            if (!StringUtils.isEmpty(certificateDetails)) {
                return certificateDetails;
            }
        }

        return null;
    }

    private String getPolicyNo(CertificateDetails certificateDetails, PolicyHistory masterPolicy) {
        return invokeRepo(() -> policyMainRepo.generateCertificatePolicyNumber(CommonConfig.COMPANY_ID,
                                                                                                         CommonConfig.BTYPE_POLICY,
                                                                                                         masterPolicy.getProductId(),
                                                                                                         certificateDetails.getVisaApprovalDate()),
                                                    "policyMainRepo.generateCertificatePolicyNumber(CommonConfig.COMPANY_ID, CommonConfig.BTYPE_POLICY, masterPolicy.getProductId(), certificateDetails.getVisaApprovalDate())");
    }

    @SuppressWarnings("unchecked")
    private DMSDocumentMetadata generateCertificate(CertificateDetails certificateDetails,
                                                    PolicyHistory masterPolicy,
                                                    String authHeader) throws Exception {

        ObjectMapper oMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(Date.class, new CustomDateSerializer(dateFormat));

        oMapper.registerModule(module);
        Map<String, String> certificateMap = oMapper.convertValue(certificateDetails, Map.class);

        // worker category
        String empCategValue = UdsIdDefConfig.getUdsIdDefinitionValue(UdsIdDefConfig.ID_TYPE_EMP_CATG,
                                                                      certificateDetails.getEmployeeCategory());
        String workerCategoryEn = "Covered Expat Worker";
        String workerCategoryAr = "العامل المؤمن له";
        if (CommonConfig.EMP_CATEG_DOMESTIC.equals(empCategValue)) {
            workerCategoryEn = "Covered Domestic Worker";
            workerCategoryAr = "العامل المساعد المؤمن له";
        }
        certificateMap.put("workerCategoryEn", workerCategoryEn);
        certificateMap.put("workerCategoryAr", workerCategoryAr);

        // employer address
        Map<String, String> address = getEmployerAddress(certificateDetails);
        certificateMap.put("employerAddressEn", address.get(AppConstants.ENGLISH));
        certificateMap.put("employerAddressAr", address.get(AppConstants.ARABIC));

        CoverageHistory sumInsured = invokeRepo(() -> coverageHistoryRepo.findSumInsured(masterPolicy.getSgsId(),
                                                                                         masterPolicy.getAmendmentVersionNumber()),
                                                "coverageHistoryRepo.findSumInsured(masterPolicy.getSgsId(), masterPolicy.getAmendmentVersionNumber())");
        certificateMap.put("coverageLimit", String.valueOf(sumInsured.getSiLimit()));

        // coverages
        Map<String, Map<String, Map<String, List<String>>>> coverages = getCoverges(masterPolicy);
        List<String> coveragesEn = getCoveragesList(coverages.get(AppConstants.ENGLISH));
        List<String> coveragesAr = getCoveragesList(coverages.get(AppConstants.ARABIC));
        certificateMap.put("coveragesEn",
                           String.join("\n", coveragesEn));
        certificateMap.put("coveragesAr",
                           String.join("\n", coveragesAr));

        DMSDocumentMetadataDTO documentMetadataDTO = new DMSDocumentMetadataDTO(certificateDetails.getCertificateNumber(),
                                                                                DMSConstants.REF_TYPE_CERTIFICATE);
        return dmsService.generateDocument(documentMetadataDTO,
                                           certificateMap,
                                           DMSConstants.TEMPLATE_CERTIFICATE,
                                           authHeader);
    }

    private PolicyHistory getMasterPolicy(CertificateDetails certificateDetails) {
        return getMasterPolicy(certificateDetails, true);
    }

    private PolicyHistory getMasterPolicy(CertificateDetails certificateDetails, boolean throwIfNotFound) {

        if (StringUtils.isEmpty(certificateDetails.getEmployeeCategory())) {
            return null;
        }

        String riskType = UdsIdDefConfig.getRiskType(certificateDetails.getEmployeeCategory());
        PolicyHistory masterPolicy = null;

        if (certificateDetails.getVisaApprovalDate() != null) {
            masterPolicy = invokeRepo(() -> policyHistoryRepository.findMasterPolicy(riskType,
                                                                                     certificateDetails.getVisaApprovalDate()),
                                      "policyHistoryRepository.findMasterPolicy(riskTypeDefinition.getUID_VALUE(), certificateDTO.getVisaApprovalDate())");
        }
        if (masterPolicy != null) {
            return masterPolicy;
        }
        if (throwIfNotFound) {
            throw new ApplicationException(ResponseStatusCode.NOT_FOUND,
                                           ErrorCode.MASTER_POLICY_NOT_FOUND,
                                           certificateDetails.getEmployeeCategory(),
                                           certificateDetails.getVisaApprovalDateStr());
        }
        return null;
    }

    @Transactional
    public Map<String, Object> captureUpdateCertificateDetails(UpdateCertificateDetailsDTO updateCertDto,
                                                                    String clientIpAddress) {
        Date endorsementDate = null;
        Map<String, Object> map = new HashMap<>();
        Map<ErrorCode, Object[]> errorDetails = new HashMap<>();
        UpdateCertificateDetails updateCertificate = invokeModelMapper(
                                                                       () -> modelMapper.map(updateCertDto,
                                                                                             UpdateCertificateDetails.class),
                                                                       "modelMapper.map(updatecert, UpdateCertDetails.class)");

        if (!StringUtils.isEmpty(updateCertDto.getCertificateNumber())) {
            updateCertificate.setPolicyNo(updateCertDto.getCertificateNumber());
        } else {
            updateCertificate.setPolicyNo(" ");
        }

        if (!StringUtils.isEmpty(updateCertDto.getEndorsementDate())) {
            endorsementDate = DateUtil.convert(updateCertDto.getEndorsementDate());
            if (endorsementDate == null) {
                errorDetails.put(ErrorCode.ENDORSEMENT_DATE_FORMAT_INVALID, new Object[] { dateFormat });
            }

        }
        updateCertificate.setAmendEffectFrom(endorsementDate);
        updateCertificate.setAmendDate(DateUtil.now());
        updateCertificate.setRequestType(updateCertificate.getTransactionType());
        updateCertificate.setReqInDate(DateUtil.now());
        updateCertificate.setServerIpAddress(CommonConfig.getServerIpAddress());
        updateCertificate.setCompanyId(CommonConfig.COMPANY_ID);
        updateCertificate.setClientIpAddress(clientIpAddress);
        UpdateCertificateDetails createdCertificateDetails = invokeRepo(() -> updateCertificateRepository.save(updateCertificate),
                                                                        "certificateUpdateRepository.save(updateCertificate)");

        map.put("errorDetails", errorDetails);
        map.put("updateCertificate", createdCertificateDetails);
        return map;
    }

    @Transactional
    public Map<String, Object> update(UpdateCertificateDetails updateCertificateDetails,
                                      String authHeader,
                                      Locale locale,
                                      boolean isBatchUpdate) {
        try {
            return updateCertificate(updateCertificateDetails, locale, isBatchUpdate);
        } catch (Exception e) {
            captureUpdateCertificateErrDetails(updateCertificateDetails,
                                               ErrorCode.UNHANDLED_EXCEPTION,
                                               CertificateDetails.STATUS.SYSTEM_ERR,
                                               locale,
                                               isBatchUpdate,
                                               e);
            Map<String, Object> result = new HashMap<>(1);
            ApplicationException ae = new ApplicationException(ResponseStatusCode.UNKNOWN_ERROR,
                                                               ErrorCode.UNHANDLED_EXCEPTION,
                                                               e);
            result.put(AppConstants.ERRORS, ae);
            return result;
        }
    }

    private Map<String, Object> updateCertificate(UpdateCertificateDetails updateCertificateDetails,
                                                  Locale locale,
                                                  boolean isBatchUpdate) throws Exception {

        CertificateDetails latestCertificateDetails = invokeModelMapper(() -> modelMapper.map(updateCertificateDetails,
                                                                                              CertificateDetails.class),
                                                                        "modelMapper.map(updateCertificateDetails,, CertificateDetails.class)");

        latestCertificateDetails.setIntermSalary(updateCertificateDetails.getIntermSalary());

        PolicyHistory masterPolicy = getMasterPolicy(latestCertificateDetails, false);
        PolicyMain originalPolicy = null;
        if (org.apache.commons.lang3.StringUtils.isNotBlank(updateCertificateDetails.getCertificateNumber())) {
            originalPolicy = invokeRepo(() -> policyMainRepo.findByNumber(updateCertificateDetails.getCertificateNumber()),
                                    "policyMainRepo.findByNumber(updateCertificateDetails.getCertificateNumber()");
        }
        CertificateDetails originalCertificateDetails = invokeRepo(() -> certificateDetailsRepository.findByCertificateNumberAndStatus(updateCertificateDetails.getCertificateNumber(), CertificateDetails.STATUS.SUCCESS.getValue()),
                                                                   "certificateDetailsRepository.findByCertificateNumberAndStatus(updateCertificateDetails.getCertificateNumber(), CertificateDetails.STATUS.SUCCESS.getValue())");
        ApplicationException appException = updateCertificateDetails.validate(originalCertificateDetails,
                                                                              latestCertificateDetails,
                                                                              masterPolicy,
                                                                              originalPolicy);
        Map<String, Object> result = new HashMap<>();
        if (appException.hasError()) {
            result.put(AppConstants.ERRORS, appException);
            captureUpdateCertificateErrDetails(updateCertificateDetails,
                                               appException,
                                               CertificateDetails.STATUS.VALIDATION_ERR,
                                               locale);
            return result;
        }
        return updateCertificate(latestCertificateDetails,
                                   locale,
                                   masterPolicy,
                                   updateCertificateDetails,
                                   isBatchUpdate);
    }

    private void captureUpdateCertificateErrDetails(UpdateCertificateDetails updateCertificateDetails,
                                                    ErrorCode errCode,
                                                    CertificateDetails.STATUS certificateDetailsStatus,
                                                    Locale locale,
                                                    boolean isBatchUpdate,
                                                    Exception e) {
        updateCertificateDetails.setErrorId(errCode.getCode());
        updateCertificateDetails.setErrorType(certificateDetailsStatus.getValue());

        String errMsg = getErrorMessage(errCode, locale) + ". Exception: " + getErrorMessage(e, locale);
        updateCertificateDetails.setErrorMessage(errMsg);
        updateCertificateDetails.setStatus(certificateDetailsStatus.getValue());
        if (isBatchUpdate) {
            updateCertificateDetails.setBatchProcessStatus(AppConstants.ERROR_BATCH);
        }
        invokeRepo(() -> updateCertificateRepository.save(updateCertificateDetails),
                   "certificateUpdateRepository.save(updateCertificate)");
    }

    private Map<String, Object> updateCertificate(CertificateDetails latestCertificateDetails,
                                                   Locale locale,
                                                   PolicyHistory masterPolicy,
                                                   UpdateCertificateDetails updateCertificateDetails,
                                                    boolean isBatchUpdate) throws Exception {
        Map<String, Object> result = new HashMap<>();

        result.put(CERT_RESULT_KEY_MASTER_POLICY, masterPolicy);
        result.put(AppConstants.CERTIFICATE_NO, updateCertificateDetails.getCertificateNumber());

        Date extendedExpiryDate = latestCertificateDetails.getExtendedExpiryDate(masterPolicy.getProductId());
        latestCertificateDetails.setExpiryDate(extendedExpiryDate);
        updateCertificateDetails.setExpiryDate(extendedExpiryDate);
        updateCertificateDetails.setCompanyId(masterPolicy.getCompanyId());
        result.put(CERT_RESULT_KEY_EXPIRY_DATE, DateUtil.toString(extendedExpiryDate));
        result.put(CERT_RESULT_KEY_APPROVAL_DATE, DateUtil.toString(latestCertificateDetails.getVisaApprovalDate()));

        if (isBatchUpdate) {
            updateCertificateDetails.setBatchProcessStatus(AppConstants.COMPLETED_BATCH);
        }
        captureUpdateCertificateSuccessRes(updateCertificateDetails, locale);
        return result;
    }

    private void captureUpdateCertificateSuccessRes(UpdateCertificateDetails updateCertificateDetails, Locale locale) {
        updateCertificateDetails.setStatus(CertificateDetails.STATUS.SUCCESS.getValue());
        updateCertificateDetails.setResponseId(ErrorCode.CERTIFICATE_ISSUED.getCode());

        String responseMsg = getErrorMessage(ErrorCode.CERTIFICATE_ISSUED, locale);
        updateCertificateDetails.setResponseMessage(responseMsg);

        invokeRepo(() -> updateCertificateRepository.save(updateCertificateDetails),
                   "certificateUpdateRepository.save(updateCertificate)");
    }

    private void captureUpdateCertificateErrDetails(UpdateCertificateDetails updateCertificateDetails,
                                                    ApplicationException appException,
                                                    STATUS certificateDetailsStatus,
                                                    Locale locale) {
        updateCertificateDetails.setErrorType(certificateDetailsStatus.getValue());
        updateCertificateDetails.setStatus(certificateDetailsStatus.getValue());

        String errCodes = appException.getErrors()
                                      .stream()
                                      .map(error -> error.getCode())
                                      .collect(Collectors.joining(CommonConfig.DELIMITER_COMMA));
        updateCertificateDetails.setErrorId(errCodes);

        String errMsgs = appException.getErrors()
                                     .stream()
                                     .map(error -> getErrorMessage(error.getCode(), error.getDataArr(), locale))
                                     .collect(Collectors.joining(CommonConfig.DELIMITER_COMMA));
        updateCertificateDetails.setErrorMessage(errMsgs);

        if (appException.getErrorCode() != null) {
            updateCertificateDetails.setErrorId(errCodes + appException.getErrorCode().getCode());
            updateCertificateDetails.setErrorMessage(errMsgs + getErrorMessage(appException.getErrorCode(), locale));
        }
        invokeRepo(() -> updateCertificateRepository.save(updateCertificateDetails),
                   "certificateUpdateRepository.save(updateCertificate)");
    }



    @Transactional
    public PagedResult<CertificateListingDTO> searchCertificate(CertificateSearchCriteria certificateSearchCriteria,
                                  PaginatedRequest paginatedRequest) {
        List<CertificateListingDTO> certificateListingDTO = certificateDAO.searchCertificate(certificateSearchCriteria, paginatedRequest);
        return new PagedResult<CertificateListingDTO>(certificateListingDTO,
                                                      certificateDAO.getCertificateCount(certificateSearchCriteria));

    }

    @Transactional
    public List<CustomerCategoryDTO> getCustomerCategory() {

        List<UdsIdDefinition> def = invokeRepo(() -> udsIdDefinitionRepository.findCustomerCategory(),
                                               "udsIdDefinitionRepository.findCustomerCategory()");
        List<CustomerCategoryDTO> CustomerCategoryDTOList = new ArrayList<>();
        for (UdsIdDefinition udsIdDef : def) {
            CustomerCategoryDTO customerCategoryDTO = new CustomerCategoryDTO();
            customerCategoryDTO.setId(udsIdDef.getUID_ID());
            customerCategoryDTO.setDescription(udsIdDef.getUID_DESC());
            CustomerCategoryDTOList.add(customerCategoryDTO);
        }
        return CustomerCategoryDTOList;
    }

    private PolicyMain getPreviousPolicy(String previousPolicyNo) {
        if (org.apache.commons.lang3.StringUtils.isBlank(previousPolicyNo)) {
            return null;
        }

        return invokeRepo(() -> policyMainRepo.findByNumber(previousPolicyNo),
                                               "policyMainRepo.findByNumber(previousPolicyNo)");
    }

    @Transactional
    public byte[] exportCertificates(CertificateExportCriteria certificateExportCriteria) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException, IOException {

        if (null == certificateExportCriteria) {
            throw new ValidationException(ErrorCode.CERTIFICATE_EXPORT_CRITERIA_REQUIRED);
        }

        if (certificateExportCriteria.isExportAll() && null == certificateExportCriteria.getSearchCriteria()) {
            throw new ValidationException(ErrorCode.CERTIFICATE_SEARCH_CRITERIA_REQUIRED);
        }

        if (certificateExportCriteria.isExportAll()
            && null != certificateExportCriteria.getSearchCriteria()
            && null == certificateExportCriteria.getDeSelectedCertificateNumbers()) {
            throw new ValidationException(ErrorCode.DESELECTED_CERTIFICATE_NUMBERS_REQUIRED);
        }

        if (!certificateExportCriteria.isExportAll() && null == certificateExportCriteria.getCertificateNumbers()) {
            throw new ValidationException(ErrorCode.EXPORT_CERTIFICATE_NUMBERS_REQUIRED);
        }

        CertificateSearchCriteria searchCriteria = certificateExportCriteria.getSearchCriteria();
        Date certCreationFromDate = (null == searchCriteria.getCertificateCreationFromDate()) ? new Date()
                                                                                              : searchCriteria.getCertificateCreationFromDate();
        Date certCreationToDate = (null == searchCriteria.getCertificationCreationToDate()) ? new Date()
                                                                                            : searchCriteria.getCertificationCreationToDate();
        String customerCategoryId = (!StringUtils.isEmpty(searchCriteria.getCustomerCategoryId())) ? searchCriteria.getCustomerCategoryId()
                                                                                                   : null;
        String certNo = (!StringUtils.isEmpty(searchCriteria.getCertificateNo())) ? searchCriteria.getCertificateNo()
                                                                                  : null;
        List<String> selectedCerts = (!certificateExportCriteria.isExportAll()
                                      && !certificateExportCriteria.getCertificateNumbers()
                                                                .isEmpty()) ? certificateExportCriteria.getCertificateNumbers()
                                                                               : new ArrayList<>(asList(" "));
        List<String> deSelectedCerts = (certificateExportCriteria.isExportAll()
                                        && !certificateExportCriteria.getDeSelectedCertificateNumbers()
                                                                  .isEmpty()) ? certificateExportCriteria.getDeSelectedCertificateNumbers()
                                                                                 : new ArrayList<>(asList(" "));
        String exportAllFlag = (certificateExportCriteria.isExportAll()) ? "true" : null;

        List<ExportCertificateDetails> certificateDetails = invokeRepo(() -> policyMainRepo.getExportCertificateDetails(CommonConfig.DATE_FORMAT.toPattern(),
                                                                           DateUtil.toString(certCreationFromDate),
                                                                           DateUtil.toString(certCreationToDate),
                                                                           customerCategoryId,
                                                                           certNo,
                                                                           exportAllFlag,
                                                                           selectedCerts,
                                                                           deSelectedCerts),
                          "policyMainRepo.getExportCertificateDetails()");

        return reportGeneratorUtil.generateExcel(null,
                                                 AppConstants.CERTIFICATES_COLUMN_HEADERS,
                                           AppConstants.CERTIFICATES_COLUMN_FIELDS,
                                           certificateDetails,
                                           AppConstants.CERTIFICATES_FILENAME);
    }

}

package com.beyontec.mol.service;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.beyontec.mol.config.UdsIdDefConfig;
import com.beyontec.mol.entity.Claim;
import com.beyontec.mol.entity.ClaimAdditionalDetails;
import com.beyontec.mol.entity.ClaimHistoryEstimation;
import com.beyontec.mol.entity.ClaimTransactionClaim;
import com.beyontec.mol.entity.ClaimTransactionClaimantDetails;
import com.beyontec.mol.entity.ClaimTransactionEstimation;
import com.beyontec.mol.entity.ClaimTransactionFNOL;
import com.beyontec.mol.entity.ClaimTransactionRisk;
import com.beyontec.mol.entity.ClaimWorkingEstimation;
import com.beyontec.mol.entity.PolicyMain;
import com.beyontec.mol.entity.UploadDocumentEntity;
import com.beyontec.mol.exception.ErrorCode;
import com.beyontec.mol.exception.ValidationException;
import com.beyontec.mol.modal.ClaimDTO;
import com.beyontec.mol.modal.ClaimDetails;
import com.beyontec.mol.modal.ClaimFieldListingDTO;
import com.beyontec.mol.modal.ClaimListingDTO;
import com.beyontec.mol.modal.ClaimReason;
import com.beyontec.mol.modal.ClaimRegistartionListingDTO;
import com.beyontec.mol.modal.ClaimRegistrationResponse;
import com.beyontec.mol.modal.ClaimsSearchCriteria;
import com.beyontec.mol.modal.DMSDocumentMetadata;
import com.beyontec.mol.modal.DMSDocumentMetadataDTO;
import com.beyontec.mol.modal.GeneralDetails;
import com.beyontec.mol.modal.LossDetails;
import com.beyontec.mol.modal.PagedResult;
import com.beyontec.mol.modal.PaginatedRequest;
import com.beyontec.mol.modal.PaymentDetails;
import com.beyontec.mol.modal.PaymentEstimateDetails;
import com.beyontec.mol.modal.PaymentListingDTO;
import com.beyontec.mol.modal.PolicyRisk;
import com.beyontec.mol.modal.PriorClaims;
import com.beyontec.mol.modal.ResponseDTO;
import com.beyontec.mol.modal.SponsorDetails;
import com.beyontec.mol.modal.UpdateClaimDTO;
import com.beyontec.mol.modal.WorkerInfo;
import com.beyontec.mol.repository.ClaimAdditionalDeatilsRepository;
import com.beyontec.mol.repository.ClaimDAO;
import com.beyontec.mol.repository.ClaimEstimationHistoryRepository;
import com.beyontec.mol.repository.ClaimFnolDetailsRepository;
import com.beyontec.mol.repository.ClaimTransactionClaimDetailsRepository;
import com.beyontec.mol.repository.ClaimTransactionEstimationRepository;
import com.beyontec.mol.repository.ClaimTransactionRiskRepository;
import com.beyontec.mol.repository.ClaimTransactionSettlementRepository;
import com.beyontec.mol.repository.ClaimWorkingDetailsRepository;
import com.beyontec.mol.repository.ClaimsRepository;
import com.beyontec.mol.repository.InsuredDetailsDataRepository;
import com.beyontec.mol.repository.PolicyMainRepository;
import com.beyontec.mol.repository.PolicyRepository;
import com.beyontec.mol.repository.UdsIdDefinitionRepository;
import com.beyontec.mol.repository.UploadDocumentRepository;
import com.beyontec.mol.repository.UserRepository;
import com.beyontec.mol.util.AppConstants;
import com.beyontec.mol.util.ClaimConstants;
import com.beyontec.mol.util.ClaimEnumConstants;
import com.beyontec.mol.util.DMSConstants;
import com.beyontec.mol.util.JWTUtil;
import com.beyontec.mol.util.ReportGeneratorUtil;

@Service
public class ClaimService {

	ModelMapper modelMapper = new ModelMapper();
	ClaimTransactionFNOL fnolData = null;
	PolicyRisk policyData = null;
	List<Object[]> policyDatalist = null;
	Long cliamFnolSgsId;
	String companyId;
	String createdUser;
	ClaimWorkingEstimation workingEstm;

	private final MessageSource messageSource;

	@Autowired
	public ClaimService(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@Autowired
	private ClaimsRepository claimsRepository;

	@Autowired
	private ClaimAdditionalDeatilsRepository claimAdditionalDeatilsRepository;

	@Autowired
	private ClaimDAO claimDAO;

	@Autowired
	private PolicyRepository policyRepository;

	@Autowired
	private ClaimFnolDetailsRepository claimFnolDetailsRepository;

	@Autowired
	private ClaimTransactionClaimDetailsRepository claimDetailsRepository;

	@Autowired
	private InsuredDetailsDataRepository insuredDetailsDataRepository;

	@Autowired
	private ClaimTransactionRiskRepository claimTransactionRiskRepository;

	@Autowired
	private ClaimWorkingDetailsRepository claimWorkingDetailsRepository;

	@Autowired
	private ClaimTransactionEstimationRepository claimTransactionEstimationRepository;

	@Autowired
	private ClaimEstimationHistoryRepository claimEstimationHistoryRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UploadDocumentRepository uploadDocumentRepository;

	@Autowired
	private UdsIdDefinitionRepository udsIdDefinitionRepository;
	
	@Autowired
	private ClaimTransactionSettlementRepository claimTransactionSettlementRepository;

	@Autowired
	private DMSService dmsService;

    @Autowired PolicyMainRepository policyMainRepo;

    @Autowired private ReportGeneratorUtil reportGeneratorUtil;

	@Value("${claim.fileTypes}")
	private String claimFileTypes;

	@Value("${date.format}")
	private String dateFormat;

	@Transactional(readOnly = true)
    public byte[] exportClaims(List<String> ids) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException, IOException {

        List<ClaimListingDTO> claimList = claimDAO.getClaimByClaimId(ids);
        return reportGeneratorUtil.generateExcel(null,
                                                 AppConstants.CLAIMS_COLUMN_HEADERS,
                                           AppConstants.CLAIMS_COLUMN_FIELDS,
                                           claimList,
                                           AppConstants.CLAIMS_FILENAME);
	}

	@Transactional(readOnly = true)
	public PagedResult<ClaimListingDTO> findAllClaimsBySearchCriteria(ClaimsSearchCriteria claimsSearchCriteria,
			PaginatedRequest paginatedRequest) {

		List<ClaimListingDTO> claims = claimDAO.searchClaims(claimsSearchCriteria, paginatedRequest);
		return new PagedResult<ClaimListingDTO>(claims, claimDAO.getClaimsCount(claimsSearchCriteria));
	}

	@Transactional(readOnly = true)
	public ClaimRegistartionListingDTO getClaimRegistartionListingDTO(String claimNo, Locale locale)
			throws ParseException {

		String sponsorName = null;
		String TradeLiceNo = null;
		String establishCliassification = null;
		String industry = null;
		String certificateNo = null;

		ClaimRegistartionListingDTO claimRegistartionListingDTO = new ClaimRegistartionListingDTO();
		ClaimTransactionClaim ctdsLevelC = claimDetailsRepository.findByClaimNo(claimNo);
		certificateNo = claimFnolDetailsRepository.getCertificateNo(ctdsLevelC.getFnolSgsId());
		Claim claim = claimsRepository.findByComplaintNumberAndErrorType(claimNo, null);
		String insuredId = claimFnolDetailsRepository.getInsuredId(ctdsLevelC.getFnolSgsId());
		List<Object[]> policyFromAndToDate = claimFnolDetailsRepository
				.getPolicyFromAndToDate(ctdsLevelC.getFnolSgsId());

        List<Object[]> udsCustomerDtlsList = claimsRepository.getUdsCustomer(insuredId);
        if (!StringUtils.isEmpty(udsCustomerDtlsList) && udsCustomerDtlsList.size() > 0) {
            Object[] udsCustomerDtls = udsCustomerDtlsList.get(0);

            if (!StringUtils.isEmpty(udsCustomerDtls)) {

                if (!StringUtils.isEmpty(udsCustomerDtls[0])) {
                    sponsorName = udsCustomerDtls[0].toString();
                }
                if (!StringUtils.isEmpty(udsCustomerDtls[1])) {
                    TradeLiceNo = udsCustomerDtls[1].toString();
                }
                if (!StringUtils.isEmpty(udsCustomerDtls[2])) {
                    establishCliassification = udsCustomerDtls[2].toString();
                }
                if (!StringUtils.isEmpty(udsCustomerDtls[3])) {
                    industry = udsCustomerDtls[3].toString();
                }
            }
        }

		String employeeName = insuredDetailsDataRepository.getInsuredName(ctdsLevelC.getFnolSgsId());

		ClaimDetails claimDetails = new ClaimDetails();

		if (!StringUtils.isEmpty(ctdsLevelC.getPolicyNo())) {
			claimDetails.setCertificateNo(ctdsLevelC.getPolicyNo());
		}
		if (!StringUtils.isEmpty(ctdsLevelC.getClaimNo())) {
			claimDetails.setClaimNo(ctdsLevelC.getClaimNo());
		}
		if (!StringUtils.isEmpty(claim.getClaimStatus())) {
			claimDetails.setClaimStatus(claimsRepository.getClaimStatusDesc(ctdsLevelC.getClaimStatus()));
		}
		if (!StringUtils.isEmpty(ctdsLevelC.getLossDate())) {
			claimDetails.setLossDate(ctdsLevelC.getLossDate());
		}
		if (!StringUtils.isEmpty(ctdsLevelC.getCreatedDate())) {
			claimDetails.setCreatedDate(ctdsLevelC.getCreatedDate());
		}
		if (!StringUtils.isEmpty(ctdsLevelC.getProductId())) {
			claimDetails.setProductName(claimsRepository.getProductNameDesc(Integer.parseInt(ctdsLevelC.getProductId())));
		}
		if (!StringUtils.isEmpty(employeeName)) {
			claimDetails.setInsuredName(employeeName);
		}

		if (!StringUtils.isEmpty(sponsorName)) {
			claimDetails.setSponsorName(sponsorName);

		}
		claimRegistartionListingDTO.setClaimDetails(claimDetails);

		GeneralDetails generalDetails = new GeneralDetails();
			
				generalDetails.setMasterPolicyNo(claimsRepository.getMasterPolicyNo(ctdsLevelC.getPolicyNo()));
			if (!StringUtils.isEmpty(ctdsLevelC.getPolicyNo())) {
				generalDetails.setCertificateNo(ctdsLevelC.getPolicyNo());
			}
			if (policyFromAndToDate != null && policyFromAndToDate.size() > 0) {
				Object[] obj = policyFromAndToDate.get(0);

				Date fromDate = (Date) obj[0];
				SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
				Date d = f.parse(fromDate.toString());
				SimpleDateFormat f2 = new SimpleDateFormat(dateFormat);

				Date toDate = (Date) obj[1];
				Date d1 = f.parse(toDate.toString());
				SimpleDateFormat f3 = new SimpleDateFormat(dateFormat);

				String certificatePeriod = f2.format(d) + " " + getErrorMessage(ErrorCode.TO, locale) + " "
						+ f3.format(d1);
				generalDetails.setCertificatePeriod(certificatePeriod);
			}
			if (!StringUtils.isEmpty(ctdsLevelC.getProductId())) {
				
				generalDetails.setProductName(claimsRepository.getProductNameDesc(Integer.parseInt(ctdsLevelC.getProductId())));
		}
		claimRegistartionListingDTO.setGeneralDetails(generalDetails);

		SponsorDetails sponsorDetails = new SponsorDetails();
		
			if (sponsorName != null) {
				sponsorDetails.setSponsorName(sponsorName);
			}
			if (!StringUtils.isEmpty(TradeLiceNo)) {
				sponsorDetails.setTradeLicenseNo(TradeLiceNo);
			}
			if (!StringUtils.isEmpty(establishCliassification)) {
				sponsorDetails.setEstabClassification(establishCliassification);
			}
			if (!StringUtils.isEmpty(industry)) {
				sponsorDetails.setIndustry(industry);
		}
		claimRegistartionListingDTO.setSponsorDetails(sponsorDetails);

		WorkerInfo workerInfo = new WorkerInfo();
		List<Object[]> workerInfoList = claimsRepository.getWorkerInfo(certificateNo);
		if (workerInfo != null && workerInfoList.size() > 0) {
			Object[] obj = workerInfoList.get(0);
			if (obj[0] != null) {
				workerInfo.setEmiratesId(obj[0].toString());
			}
			if (obj[1] != null) {
				workerInfo.setLabourRefNo(obj[1].toString());
			}
			if (obj[2] != null) {
				workerInfo.setName(obj[2].toString());
			}
			if (obj[3] != null) {
				workerInfo.setDob(new Date(((Timestamp) obj[3]).getTime()));
			}
			if (obj[4] != null) {
				workerInfo.setGender(claimsRepository.getGender(obj[4].toString()));
			}
			if (obj[5] != null) {
				workerInfo.setPassportNo(obj[5].toString());
			}
			if (obj[6] != null) {
				workerInfo.setEmployeeCategory(claimsRepository.getEmployeeCategory(obj[6].toString()));
			}
			if (obj[7] != null) {
				workerInfo.setDesignation(claimsRepository.getDesignationDesc(obj[7].toString()));
			}
			
		}
		claimRegistartionListingDTO.setWorkerInfo(workerInfo);

		LossDetails lossDetails = new LossDetails();
		if (!StringUtils.isEmpty(ctdsLevelC.getCreatedDate())) {
			lossDetails.setCreatedDate(ctdsLevelC.getCreatedDate());
		}
        if (!StringUtils.isEmpty(claim.getClaimLossDate())) {
			lossDetails.setLossDate(ctdsLevelC.getLossDate());
		}
		if (!StringUtils.isEmpty(claim.getClaimReason())) {
			lossDetails.setClaimReason(ctdsLevelC.getClaimReason());
		}
		if (!StringUtils.isEmpty(claimFnolDetailsRepository.getClaimDescription(claimNo))) {
			lossDetails.setClaimDescription(claimFnolDetailsRepository.getClaimDescription(claimNo));
		}
		if (!StringUtils.isEmpty(claimTransactionEstimationRepository.getPaymentType(ctdsLevelC.getFnolSgsId()))) {
			 String id =
			 claimTransactionEstimationRepository.getPaymentType(ctdsLevelC.getFnolSgsId());
			 lossDetails.setPaymentType(claimsRepository.getDescription(id));
		}
		claimRegistartionListingDTO.setLossDetails(lossDetails);

		List<PriorClaims> priorClaimslist = new ArrayList<>();

		List<String> priorClaimNolist = claimFnolDetailsRepository.getPriorClaimNo(certificateNo, claimNo);

		for (String priorClaimNo : priorClaimNolist) {
			PriorClaims priorClaim = new PriorClaims();
			priorClaim.setClaimNo(priorClaimNo);
			priorClaimslist.add(priorClaim);
		}

		List<BigDecimal> priorPaidAmountlist = claimFnolDetailsRepository.getPaidAmount(certificateNo, claimNo);
		for (int i = 0; i < priorClaimslist.size(); i++) {
			for (BigDecimal priorPaidAmount : priorPaidAmountlist) {
				PriorClaims priorClaim = priorClaimslist.get(i);
				priorClaim.setPaidamount(priorPaidAmount);
			}
		}

		List<String> priorClaimStatusList = claimFnolDetailsRepository.getStatus(certificateNo, claimNo);
		for (int i = 0; i < priorClaimslist.size(); i++) {
			for (String priorClaimStatus : priorClaimStatusList) {
				PriorClaims priorClaim = priorClaimslist.get(i);
				priorClaim.setStatus(priorClaimStatus);
			}
		}
		claimRegistartionListingDTO.setPriorClaims(priorClaimslist);

		return claimRegistartionListingDTO;
	}

	@Transactional
	public Map<String, Object> createClaim(ClaimDTO claimDTO, MultipartFile[] documents, String ipAddress,
			Locale locale, String authHeader) throws Exception {

        Date claimLaunchDate = null;

        Map<String, Object> map = new HashMap<>();
        Map<ErrorCode, Object[]> errorDetails = validateCreateClaimRequest(claimDTO, documents);

        if (!StringUtils.isEmpty(claimDTO.getClaimLaunchDate())) {
            SimpleDateFormat f = new SimpleDateFormat(dateFormat);
            try {
                claimLaunchDate = f.parse(claimDTO.getClaimLaunchDate());
            } catch (ParseException e) {

                errorDetails.put(ErrorCode.CLAIM_LAUNCH_DATE_FORMAT_INVALID,
                                 new Object[] { dateFormat });
            }
        }

		Claim claim = modelMapper.map(claimDTO, Claim.class);
        if (!StringUtils.isEmpty(claimLaunchDate)) {

            claim.setClaimLossDate(claimLaunchDate);
        }
		claim.setCompanyId(claimsRepository.getCompanyId());
		claim.setRequestIncomingDate(new Date());
		claim.setRequestIncomingIp(ipAddress);
		claim.setResponseDate(new Date());
		claim.setCodifiedType(ClaimConstants.CLAIM_CODIFIED_TYPE);

		int count = claimsRepository.getPolicyCount(claimDTO.getCertificateNo());
		if(!errorDetails.containsKey(ErrorCode.EMPTY_CERTIFICATE_FIELD) && count == 0) {
			errorDetails.put(ErrorCode.WORKER_NO_POLICY, null);
		}
		
		String claimStatus = claimsRepository.getCertificateStatus(claimDTO.getCertificateNo());
        if (count > 0 && claimStatus != null && claimStatus.equals("CAN")) {

            PolicyMain policyMain = policyMainRepo.findByNumber(claimDTO.getCertificateNo());
            if (!StringUtils.isEmpty(policyMain) && !claimLaunchDate.before(policyMain.getCancelDate())) {
                errorDetails.put(ErrorCode.CERTIFICATE_ALREADY_CANCELLED, new Object[] { policyMain.getCancelDate() });
            }
        }
		
		List<Object[]> policyFromAndTodate = claimsRepository.getPolicyDates(claimDTO.getCertificateNo());
		Date fromDate = null;
		Date toDate = null;
		if(policyFromAndTodate != null && policyFromAndTodate.size()>0) {
			Object[] obj = policyFromAndTodate.get(0);
			 fromDate = new Date(((Timestamp) obj[0]).getTime());
			 toDate = new Date(((Timestamp) obj[1]).getTime());
		}

		if (!StringUtils.isEmpty(claimDTO.getPayeeType())) {

			String payeetype = claimsRepository.getPayeeType(claimDTO.getPayeeType());
			if (StringUtils.isEmpty(payeetype)) {
				errorDetails.put(ErrorCode.INVALID_INPUT_TYPE, new Object[] { "payeeType", claimDTO.getPayeeType() });
			}
		}

		if (!StringUtils.isEmpty(claimDTO.getClaimPaymentType())) {

			int paymentTypeCount = claimsRepository.getPaymentType(claimDTO.getClaimPaymentType());
			if (paymentTypeCount == 0) {
				errorDetails.put(ErrorCode.INVALID_PAYEE_TYPE,
						new Object[] { "claimPaymentType", claimDTO.getClaimPaymentType() });
			}
		}

        if (claim.getClaimLossDate() != null
            && fromDate != null
            && toDate != null
            && !errorDetails.containsKey(ErrorCode.CLAIM_LAUNCH_DATE_FORMAT_INVALID)
            && !(claim.getClaimLossDate().before(toDate) && claim.getClaimLossDate().after(fromDate))) {

            final SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
            errorDetails.put(ErrorCode.INVALID_LAUNCH_DATE,
                             new Object[] { formatter.format(fromDate.getTime()), formatter.format(toDate.getTime()) });
        }

		if (errorDetails.size() == 0) {

            claim.setClaimStatus(Claim.STATUS.SUCCESS.getValue());
            claim.setRespondeId(ErrorCode.CLAIM_CREATED.getCode());
			claim.setResponseMessage(getErrorMessage(ErrorCode.CLAIM_CREATED, locale));
		} else {

            claim.setClaimStatus(Claim.STATUS.SYSTEM_ERR.getValue());
            claim.setErrorType(Claim.STATUS.SYSTEM_ERR.getValue());
            claim.setErrorId(ErrorCode.CLAIM_CREATION_FAILED.getCode());

			String errorMessage = "";
			for (Map.Entry<ErrorCode, Object[]> entry : errorDetails.entrySet()) {

				if (!StringUtils.isEmpty(errorMessage)) {
					errorMessage += ", ";
				}
				errorMessage += messageSource.getMessage(entry.getKey().getCode(), entry.getValue(), locale);
			}

			claim.setErrorMessage(errorMessage);
            claim.setRespondeId(ErrorCode.CLAIM_CREATION_FAILED.getCode());
			claim.setResponseMessage(getErrorMessage(ErrorCode.CLAIM_CREATION_FAILED, locale));
		}

		claimsRepository.save(claim);

		if (errorDetails.size() == 0 && documents.length > 0) {

			// Generate certificate and upload it to DMS
			DMSDocumentMetadataDTO documentMetadataDTO = new DMSDocumentMetadataDTO(claim.getComplaintNumber(),
					DMSConstants.REF_TYPE_CLAIM);
			List<DMSDocumentMetadata> documentMetadataList = dmsService.uploadDocument(documentMetadataDTO, documents,
					authHeader);

			addDocumentDetails(claim, documentMetadataList);
		}

		map.put("claimResponse", modelMapper.map(claim, ClaimRegistrationResponse.class));
		if (errorDetails.size() > 0) {
			map.put("errorDetails", errorDetails);
		}
		map.put("claim", claim);

		return map;
	}

	@Transactional
	public ResponseDTO updateClaim(UpdateClaimDTO updateClaimDTO, MultipartFile[] documents, Locale locale,
			String authHeader) throws Exception {

		Map<ErrorCode, Object[]> errorDetails = validateUpdateClaimRequest(updateClaimDTO, documents);

		if (errorDetails.size() > 0) {
			throw new ValidationException(errorDetails);
		}

		Claim claim = claimsRepository.findByComplaintNumberAndErrorType(updateClaimDTO.getComplaintNumber(), null);

		List<DMSDocumentMetadata> documentMetadataList = null;
		if (documents.length > 0) {
			DMSDocumentMetadataDTO documentMetadataDTO = new DMSDocumentMetadataDTO(claim.getComplaintNumber(),
					DMSConstants.REF_TYPE_CLAIM);
			documentMetadataList = dmsService.uploadDocument(documentMetadataDTO, documents, authHeader);
			addDocumentDetails(claim, documentMetadataList);
		}

		addNotes(claim, updateClaimDTO.getNotes());

		return new ResponseDTO(true);
	}

	private Map<ErrorCode, Object[]> validateCreateClaimRequest(ClaimDTO claimDTO, MultipartFile[] documents) {

		Map<ErrorCode, Object[]> errorDetails = new HashMap<>();

		if (StringUtils.isEmpty(claimDTO.getComplaintNumber()) || claimDTO.getComplaintNumber().trim().isEmpty()) {
			errorDetails.put(ErrorCode.EMPTY_COMPALINT_FIELD, null);
		}
		if (StringUtils.isEmpty(claimDTO.getCertificateNo()) || claimDTO.getCertificateNo().trim().isEmpty()) {
			errorDetails.put(ErrorCode.EMPTY_CERTIFICATE_FIELD, null);
		}

		if (StringUtils.isEmpty(claimDTO.getEmployerName()) || claimDTO.getEmployerName().trim().isEmpty()) {
			errorDetails.put(ErrorCode.EMPTY_EMPLOYER_NAME_FIELD, null);
		}
		
		if (StringUtils.isEmpty(claimDTO.getEmployerLicenseNo()) || claimDTO.getEmployerLicenseNo().trim().isEmpty()) {
			errorDetails.put(ErrorCode.EMPTY_EMPLOYER_LICENSE_FIELD, null);
		}
		if (StringUtils.isEmpty(claimDTO.getClaimReason()) || claimDTO.getClaimReason().trim().isEmpty()) {
			errorDetails.put(ErrorCode.EMPTY_CLAIM_REASON_FIELD, null);
		}
		if (StringUtils.isEmpty(claimDTO.getClaimDescription()) || claimDTO.getClaimDescription().trim().isEmpty()) {
			errorDetails.put(ErrorCode.EMPTY_CLAIM_DESCRIPTION_FIELD, null);
		}
		if (StringUtils.isEmpty(claimDTO.getClaimPaymentType()) || claimDTO.getClaimPaymentType().trim().isEmpty()) {
			errorDetails.put(ErrorCode.EMPTY_PAYMENT_FIELD, null);
		}
		if (StringUtils.isEmpty(claimDTO.getPayeeType()) || claimDTO.getPayeeType().trim().isEmpty()) {
			errorDetails.put(ErrorCode.EMPTY_PAYEETYPE_FIELD, null);
		}
		if (StringUtils.isEmpty(claimDTO.getPaymentAmount()) || claimDTO.getPaymentAmount().trim().isEmpty()) {
			errorDetails.put(ErrorCode.EMPTY_CLAIM_AMOUNT_FIELD, null);
		}
		if (StringUtils.isEmpty(claimDTO.getPayeePhoneNumber()) || claimDTO.getPayeePhoneNumber().trim().isEmpty()) {
			errorDetails.put(ErrorCode.EMPTY_PHONE_FIELD, null);
		}
		if (StringUtils.isEmpty(claimDTO.getPayeeEmail()) || claimDTO.getPayeeEmail().trim().isEmpty()) {
			errorDetails.put(ErrorCode.EMPTY_EMAIL_FIELD, null);
		}
		
		Claim claim = claimsRepository.findByComplaintNumberAndErrorType(claimDTO.getComplaintNumber(), null);
		if (claim != null) {
			errorDetails.put(ErrorCode.ALREADY_CREATED_CLAIM, null);
		}

		ClaimTransactionFNOL fnol = claimFnolDetailsRepository.findByFnolRefNo(claimDTO.getEmiratesId());
		if (fnol != null) {
			if (fnol.getCLF_FNOL_TYP().equals(ClaimConstants.CLAIM_POLICY_REPATRIATION)) {
				errorDetails.put(ErrorCode.WORKER_EXIST_POLICY_REPATRIATION, null);
			}
		}

		for (MultipartFile document : documents) {

			String[] fileDetails = document.getOriginalFilename().split("\\.");
			String fileExt = fileDetails[fileDetails.length - 1];
			if (!Arrays.asList(claimFileTypes.replaceAll(", ", ",").split(",")).contains(fileExt)) {
				errorDetails.put(ErrorCode.INVALID_CLAIM_DOCUMENT,
						new Object[] { document.getOriginalFilename(), claimFileTypes });
			}
		}

		return errorDetails;
	}

	private Map<ErrorCode, Object[]> validateUpdateClaimRequest(UpdateClaimDTO updateClaimDTO,
			MultipartFile[] documents) {

		Map<ErrorCode, Object[]> errorDetails = new HashMap<>();

		if (StringUtils.isEmpty(updateClaimDTO.getComplaintNumber())) {
			errorDetails.put(ErrorCode.COMPLAINT_NUMBER_MISSING, null);
        } else {

            Claim claim = claimsRepository.findByComplaintNumberAndErrorType(updateClaimDTO.getComplaintNumber(), null);
            if (claim == null) {
                errorDetails.put(ErrorCode.CLAIM_DOES_NOT_EXIST, null);
            }

            for (MultipartFile document : documents) {

                String[] fileDetails = document.getOriginalFilename().split("\\.");
                String fileExt = fileDetails[fileDetails.length - 1];
                if (!Arrays.asList(claimFileTypes.replaceAll(", ", ",").split(",")).contains(fileExt)) {
                    errorDetails.put(ErrorCode.INVALID_CLAIM_DOCUMENT,
                                     new Object[] { document.getOriginalFilename(), claimFileTypes });
                }
            }
        }

		return errorDetails;
	}

	public void addDocumentDetails(Claim claim, List<DMSDocumentMetadata> documentMetadataList) {

        if (claim.getSgsId() == null || claim.getSgsId() == 0) {
			claim = claimsRepository.findByComplaintNumberAndErrorType(claim.getComplaintNumber(), null);
			if (claim == null) {
                throw new ValidationException(ErrorCode.CLAIM_DOES_NOT_EXIST);
			}
		}

		for (DMSDocumentMetadata document : documentMetadataList) {

			ClaimAdditionalDetails claimAdditionalDetails = new ClaimAdditionalDetails();
			claimAdditionalDetails.setClaim(claim);
			claimAdditionalDetails.setType("D");
			claimAdditionalDetails.setDocumentPath(document.getGridFSId());
			claimAdditionalDeatilsRepository.save(claimAdditionalDetails);
		}
	}

	private void addNotes(Claim claim, String notes) {

		if (!StringUtils.isEmpty(notes)) {

			ClaimAdditionalDetails claimAdditionalDetails = new ClaimAdditionalDetails();
			claimAdditionalDetails.setClaim(claim);
			claimAdditionalDetails.setType(ClaimConstants.CLAIM_DOCUMNET_TYPE);
			claimAdditionalDetails.setNotes(notes);
			claimAdditionalDeatilsRepository.save(claimAdditionalDetails);
		}
	}

    @Transactional(propagation = Propagation.REQUIRES_NEW)
	public void addClaimEntries(Claim claim) throws Exception {
		fnolData = saveClaimTransactionalFnol(claim);
		saveClaimaint(claim, fnolData);
		String partyId = savePartyDetails(fnolData);
		Long riskfnolSgsID = saveRiskDetails(fnolData);
		saveClaimWorkingEstimation(claim, riskfnolSgsID, partyId);
		saveClaimTransactionEstimation();
		saveCalimHistortyEstimation();
		// saveDocumnetUploadDetails(claim, icadPath);
	}

	private ClaimTransactionFNOL saveClaimTransactionalFnol(Claim claim) throws ParseException {
		fnolData = new ClaimTransactionFNOL();
		policyData = new PolicyRisk();
		policyDatalist = policyRepository.getPolicyRiskDate(claim.getCertificateNo());
		if (policyDatalist != null && policyDatalist.size() > 0) {
			Object[] policyDataArray = policyDatalist.get(0);
			if (policyDataArray[0] != null) {
				policyData.setCompanyId(policyDataArray[0].toString());
			}
			if (policyDataArray[1] != null) {
				policyData.setPolicyNo(policyDataArray[1].toString());
			}
			if (policyDataArray[2] != null) {
				policyData.setPolicySgsId(policyDataArray[2].toString());
			}
			if (policyDataArray[3] != null) {
				policyData.setCustomerId(policyDataArray[3].toString());
			}
			if (policyDataArray[4] != null) {
				policyData.setProductId(policyDataArray[4].toString());
			}
			if (policyDataArray[5] != null) {
				policyData.setCobId(policyDataArray[5].toString());
			}
			if (policyDataArray[6] != null) {
				policyData.setPolicyEffectiveFrom(new Date(((Timestamp) policyDataArray[6]).getTime()));
			}
			if (policyDataArray[7] != null) {
				policyData.setPolicyEffectiveTo(new Date(((Timestamp) policyDataArray[7]).getTime()));
			}
			if (policyDataArray[8] != null) {
				policyData.setDivisionID(policyDataArray[8].toString());
			}
			if (policyDataArray[9] != null) {
				policyData.setDepartmentId(policyDataArray[9].toString());
			}
			if (policyDataArray[10] != null) {
				policyData.setInsuredId(policyDataArray[10].toString());
			}
			if (policyDataArray[11] != null) {
				policyData.setMasterPolicyNo(policyDataArray[11].toString());
			}
			if (policyDataArray[12] != null) {
				policyData.setMasterPolicyEffectiveFrom(new Date(((Timestamp) policyDataArray[12]).getTime()));
			}
			if (policyDataArray[13] != null) {
				policyData.setMasterPolicyEffectiveTo(new Date(((Timestamp) policyDataArray[13]).getTime()));
			}
			if (policyDataArray[14] != null) {
				policyData.setReportedDivisionID(policyDataArray[14].toString());
			}
			if (policyDataArray[15] != null) {
				policyData.setRiskId(policyDataArray[15].toString());
			}
			if (policyDataArray[16] != null) {
				policyData.setRiskEffectiveFrom(new Date(((Timestamp) policyDataArray[16]).getTime()));
			}
			if (policyDataArray[17] != null) {
				policyData.setRiskEffectiveTo(new Date(((Timestamp) policyDataArray[17]).getTime()));
			}
			if (policyDataArray[18] != null) {
				policyData.setRiskType(policyDataArray[18].toString());
			}
			if (policyDataArray[19] != null) {
				System.out.println(policyDataArray[19]);
				policyData.setFlex7(policyDataArray[19].toString());
			}
			if (policyDataArray[20] != null) {
				policyData.setRiskAmendmentVerNo(Integer.parseInt(policyDataArray[20].toString()));
			}
		}

		if (policyData != null) {
			fnolData = modelMapper.map(policyData, ClaimTransactionFNOL.class);
			fnolData.setCLF_REP_BY_ID(policyData.getInsuredId());
		}

		fnolData.setFnolRefNo(claim.getComplaintNumber());
		fnolData.setGroupId(claim.getGroupId());
		fnolData.setClaimReason(claim.getClaimReason());
		fnolData.setRemarks(claim.getRemarks());
		fnolData.setClaimReason2(claim.getClaimReason2());
        fnolData.setLossIntimationDate(claim.getClaimLossDate());
        fnolData.setLossDate(claim.getClaimLossDate());
		fnolData.setLossDescription(claim.getClaimDescription());
        fnolData.setLossDiscoveryDate(claim.getClaimLossDate());
		fnolData.setCLF_CLC_NO(claim.getComplaintNumber());

		companyId = claimsRepository.getCompanyId();
		fnolData.setCompanyId(companyId);

		fnolData.setCreatedDate(new Date());
		fnolData.setClaimantcustomerYN(ClaimConstants.CLAIM_CLF_CLMNT_CUST_YN);
		fnolData.setReportedBy(claimsRepository.getReportedBy());
		fnolData.setFnolStatus(ClaimConstants.CLAIM_FNOL_STATUS);
		fnolData.setCLF_REP_MTHD(ClaimConstants.CLAIM_CLF_REP_MTHD);
		fnolData.setCLF_REP_BY(ClaimConstants.CLAIM_CLF_REP_BY);
		createdUser = claimsRepository.getCreatedUser(companyId);
		if (createdUser != null) {
			fnolData.setCreatedUser(createdUser);
		}

		ClaimTransactionFNOL savedClaimFnol = claimFnolDetailsRepository.save(fnolData);
		cliamFnolSgsId = savedClaimFnol.getFnolSgsId();
		return savedClaimFnol;
	}

	private void saveClaimaint(Claim claim, ClaimTransactionFNOL claimtransactionalFnol) {
		ClaimTransactionClaim claimDetails = new ClaimTransactionClaim();
		if (policyData != null) {
			claimDetails = modelMapper.map(policyData, ClaimTransactionClaim.class);
			claimDetails.setCLC_REP_DIVN_ID(policyData.getReportedDivisionID());
		}
		claimDetails.setFnol(claimtransactionalFnol);
		claimDetails.setCompanyId(companyId);

		claimDetails.setClaimNo(claim.getComplaintNumber());
		claimDetails.setFnolNo(claim.getComplaintNumber());
        claimDetails.setClaimIntimationDate(claim.getClaimLossDate());
        claimDetails.setLossDate(claim.getClaimLossDate());
        claimDetails.setDiscoveryDate(claim.getClaimLossDate());
		claimDetails.setLossDescription(claim.getClaimDescription());
		claimDetails.setCreatedDate(new Date());
		claimDetails.setClaimReason(claim.getClaimReason());
		claimDetails.setClaimReason2(claim.getClaimReason2());
		claimDetails.setGroupId(claim.getGroupId());
		claimDetails.setRemarks(claim.getRemarks());

		claimDetails.setClaimStatus(ClaimConstants.CLAIM_FNOL_STATUS);
		claimDetails.setCloseReasonId(null);
		if (createdUser != null) {
			claimDetails.setCreatedUser(createdUser);
		}

		claimDetails.setCreatedDate(new Date());

		claimDetailsRepository.save(claimDetails);
	}

	private String savePartyDetails(ClaimTransactionFNOL fnol) throws ParseException {
		ClaimTransactionClaimantDetails partyDetails = new ClaimTransactionClaimantDetails();
		List<Object[]> insuredDetailslist = insuredDetailsDataRepository.getInsuredData(policyData.getInsuredId());
		if (insuredDetailslist != null && insuredDetailslist.size() > 0) {
			Object[] insuredDeatilsArray = insuredDetailslist.get(0);
			if (insuredDeatilsArray != null) {
				if (insuredDeatilsArray[0] != null) {
					partyDetails.setFirstName(insuredDeatilsArray[0].toString());
				}
				if (insuredDeatilsArray[1] != null) {
					partyDetails.setLastName(insuredDeatilsArray[1].toString());
				}
				if (insuredDeatilsArray[2] != null) {
					partyDetails.setName(insuredDeatilsArray[2].toString());
				}
				if (insuredDeatilsArray[3] != null) {
					partyDetails.setAddress1(insuredDeatilsArray[3].toString());
				}
				if (insuredDeatilsArray[4] != null) {
					partyDetails.setAddress2(insuredDeatilsArray[4].toString());
				}
				if (insuredDeatilsArray[5] != null) {
					partyDetails.setAddress3(insuredDeatilsArray[5].toString());
				}
				if (insuredDeatilsArray[6] != null) {
					partyDetails.setAddress4(insuredDeatilsArray[6].toString());
				}
				if (insuredDeatilsArray[7] != null) {
					partyDetails.setPincode(insuredDeatilsArray[7].toString());
				}
				if (insuredDeatilsArray[8] != null) {
					partyDetails.setCity(insuredDeatilsArray[8].toString());
				}
				if (insuredDeatilsArray[9] != null) {
					partyDetails.setState(insuredDeatilsArray[9].toString());
				}
				if (insuredDeatilsArray[10] != null) {
					partyDetails.setCountryId(insuredDeatilsArray[10].toString());
				}
				if (insuredDeatilsArray[11] != null) {
					partyDetails.setPhoneNo(insuredDeatilsArray[11].toString());
				}
				if (insuredDeatilsArray[12] != null) {
					partyDetails.setMobileNo(insuredDeatilsArray[12].toString());
				}
				if (insuredDeatilsArray[13] != null) {
					partyDetails.setEmailId(insuredDeatilsArray[13].toString());
				}
				if (insuredDeatilsArray[14] != null) {
					partyDetails.setDob(new Date(((Timestamp) insuredDeatilsArray[14]).getTime()));
				}
				if (insuredDeatilsArray[15] != null) {
					partyDetails.setGender(insuredDeatilsArray[15].toString());
				}
				if (insuredDeatilsArray[16] != null) {
					partyDetails.setNationality(insuredDeatilsArray[16].toString());
				}
				if (insuredDeatilsArray[17] != null) {
					partyDetails.setPrefixName(insuredDeatilsArray[17].toString());
				}
			}
		}

		partyDetails.setMiddleName(null);
		partyDetails.setPartyId(policyData.getInsuredId());
		partyDetails.setFnol(fnol);
		partyDetails.setPartyType(ClaimConstants.CLAIM_PARTY_TYPE);
		partyDetails.setLanguage(ClaimConstants.CLAIM_DEFAULT_LANGUAGE);
		partyDetails.setRecordType(ClaimConstants.CLAIM_RECORD_TYP);
		partyDetails.setReportedByClaimantYN(ClaimConstants.CLAIM_CLF_REP_BY_CLMNT_YN);
		partyDetails.setOtherLanguage(ClaimConstants.CLAIM_OTHER_LANGUAGE);
		partyDetails.setCreatedDate(new Date());
		if (createdUser != null) {
			partyDetails.setCreatedUser(createdUser);
		}
		insuredDetailsDataRepository.save(partyDetails);
		return partyDetails.getPartyId();
	}

	private Long saveRiskDetails(ClaimTransactionFNOL claimFnol) {
		ClaimTransactionRisk claimRisk = new ClaimTransactionRisk();
		claimRisk.setFnolSgsId(cliamFnolSgsId);
		if (policyData != null) {
			claimRisk.setRiskId(policyData.getRiskId());
			claimRisk.setRiskType(policyData.getRiskType());
			claimRisk.setPolicyNo(policyData.getPolicyNo());
			claimRisk.setRiskCOB(policyData.getCobId());
			claimRisk.setRiskEffectiveFrom(policyData.getRiskEffectiveFrom());
			claimRisk.setRiskEffectiveTo(policyData.getRiskEffectiveTo());
			claimRisk.setCLR_RISK_AMND_IDX(policyData.getRiskAmendmentVerNo());
			claimRisk.setEmiratesId(policyData.getFlex7());
			if (claimFnol != null) {
				claimRisk.setEmployeeName(claimsRepository.getCustomerName(claimFnol.getPolicyNo()));
			}
		}
		claimRisk.setCompanyId(companyId);

		claimTransactionRiskRepository.save(claimRisk);
		return claimRisk.getFnolSgsId();

	}

	private void saveClaimWorkingEstimation(Claim claim, Long riskfnolSgsID, String partyId) {
		workingEstm = new ClaimWorkingEstimation();
		workingEstm.setFnolSgsId(cliamFnolSgsId);
		workingEstm.setRevisionSerialNo(ClaimConstants.CLAIM_DEFAULT_REVISION_SERIAL_NO);
		if (policyData.getRiskId() != null) {
			workingEstm.setRiskId(policyData.getRiskId());
		}
		
		List<Object[]> cudsResultList = claimWorkingDetailsRepository.getCUDS_EST_DEFNData(fnolData.getFnolSgsId(),
				riskfnolSgsID, claim.getPayeeType(), claim.getClaimPaymentType());
		if (cudsResultList != null && cudsResultList.size() > 0) {
			Object[] cudsResult = cudsResultList.get(0);
			workingEstm.setCoverId(cudsResult[1].toString());
			workingEstm.setSmiId(cudsResult[2].toString());
			workingEstm.setLossId(cudsResult[3].toString());
			workingEstm.setEstimateType(cudsResult[0].toString());
			workingEstm.setEstimatedAmount(Double.parseDouble(cudsResult[4].toString()));
			workingEstm.setOutstandingAmountBCEst(Double.parseDouble(cudsResult[4].toString()));
		}
		workingEstm.setEstimatedDate(new Date());
		workingEstm.setEstimateLevel(ClaimConstants.CLAIM_CLE_EST_LVL);
		workingEstm.setApproveFlag(ClaimConstants.CLAIM_APPROVE_FLAG);
		workingEstm.setCloseFlag(null);
		workingEstm.setCloseDate(null);
		workingEstm.setApproveDate(new Date());
		if (createdUser != null) {
			workingEstm.setCreatedUser(createdUser);
		}
		workingEstm.setOutstandingAmount(claim.getPaymentAmount());
		workingEstm.setSettlementRefsgsId(0); // CTDS_LEVEL_S=>CLS_SGS_ID
		workingEstm.setEstimateDescription(null);
		workingEstm.setEstimateType(claim.getPayeeType());
		workingEstm.setExchangeRate(ClaimConstants.CLAIM_EXCHANGE_RATE);
		workingEstm.setCurrencyId(ClaimConstants.CLAIM_CURRENCY_ID);
		workingEstm.setCloseReasonID(null);
		workingEstm.setLosstype(claim.getClaimPaymentType());
		workingEstm.setCLE_EXP_PARTY_ID(partyId);
		workingEstm.setApproveStatus(ClaimConstants.CLAIM_APPROVE_STATUS);
		workingEstm.setCLE_APU(ClaimConstants.CLAIM_CLE_APU);
		workingEstm.setType(ClaimConstants.CLAIM_CLE_TYP);
		workingEstm.setEstimateDescription("Initial Reserve");
		workingEstm.setLosstype(claimsRepository.getLossType(claim.getClaimPaymentType()));
		workingEstm.setOutstandingAmountBC(claim.getPaymentAmount());
		if (createdUser != null) {
			workingEstm.setCLE_ASSIGN_APU(createdUser);
		}
		workingEstm.setUpdatedUser(null);
		workingEstm.setUpdatedDate(new Date());
		workingEstm.setCompanyId(companyId);
		if (policyData.getInsuredId() != null) {
			workingEstm.setCustomerId(policyData.getInsuredId());
		}

		claimWorkingDetailsRepository.save(workingEstm);
	}

	private void saveClaimTransactionEstimation() {

		ClaimTransactionEstimation claimTransactionEstimation = modelMapper.map(workingEstm,
				ClaimTransactionEstimation.class);
		claimTransactionEstimationRepository.save(claimTransactionEstimation);
	}

	private void saveCalimHistortyEstimation() {

		ClaimHistoryEstimation claimHistoryEstimation = modelMapper.map(workingEstm, ClaimHistoryEstimation.class);
		claimHistoryEstimation.setOldEstimatedAmount(ClaimConstants.CLAIM_OLD_ESTMT_AMT);
		claimEstimationHistoryRepository.save(claimHistoryEstimation);
	}

	private void saveDocumnetUploadDetails(Claim claim, String icadPath) {
		UploadDocumentEntity uploadDoc = new UploadDocumentEntity();
		uploadDoc.setFnolSgsId(cliamFnolSgsId);
		uploadDoc.setTLD_TXN_SREF_NO(ClaimConstants.CLAIM_TLD_TXN_SREF_NO);
		uploadDoc.setIsMandatory(ClaimConstants.CLAIM_DOCUMENT_IS_MANDATORY);
		uploadDoc.setUploadedDate(new Date());
		uploadDoc.setComplaintNo(claim.getComplaintNumber());
		uploadDoc.setCreatedDate(new Date());
		uploadDoc.setFolderName(icadPath);
		uploadDoc.setTLD_VER_NO(ClaimConstants.CLAIM_TLD_VER_NO);
		uploadDoc.setTLD_APPRV_STATUS(ClaimConstants.CLAIM_TLD_APPRV_STATUS);
		uploadDoc.setApprovedDate(new Date());
		uploadDoc.setRecordType(ClaimConstants.CLAIM_RECORD_TYP);

		uploadDoc.setSerialNo(0); // should be incremental
		uploadDoc.setDocumentStatus(ClaimConstants.CLAIM_DOCUMENT_STATUS);
		uploadDoc.setModuleType(ClaimConstants.CLAIM_MODULE_TYP);
		uploadDoc.setUploadedUser("");// have to confirm
		uploadDoc.setDocumentId("");
		uploadDoc.setDocumentType(""); // name of the document
		// TLD_CRU, TLD_APU, TLD_DOC_ID, TLD_DOC_DESC, TLD_DOC_NAME, TLD_TYP
		uploadDocumentRepository.save(uploadDoc);
	}

	@Transactional
    public ClaimFieldListingDTO getSearchCriteriaValues() {

        String companyId = JWTUtil.getCompanyId();
		List<Object[]> departmentDetails = claimsRepository.getDepartmentDetails(companyId);
		List<Object[]> divisionDetails = claimsRepository.getDivisionDetails(companyId);
		List<Object[]> statusTypes = claimsRepository.getStatusDetails();
		List<Object[]> workerTypes = claimsRepository.getWorkerTypes();
		List<Object[]> sponsorTypes = claimsRepository.getSponsorTypes();
		ClaimFieldListingDTO claimFieldsData = new ClaimFieldListingDTO();

		if (departmentDetails != null && departmentDetails.size() != 0) {
			Map<String, String> department = new HashMap<String, String>();

			for (Object[] details : departmentDetails) {
				department.put((String) details[0], (String) details[1]);
			}
			claimFieldsData.setDepartment(department);
		}

		if (divisionDetails != null && divisionDetails.size() != 0) {
			Map<String, String> division = new HashMap<String, String>();

			for (Object[] details : divisionDetails) {
				division.put((String) details[0], (String) details[1]);
			}
			claimFieldsData.setDivision(division);
		}

		if (statusTypes != null && statusTypes.size() != 0) {
			Map<String, String> status = new HashMap<String, String>();

			for (Object[] details : statusTypes) {
				status.put((String) details[0], (String) details[1]);
			}
			claimFieldsData.setStatusTypes(status);
		}

		if (workerTypes != null && workerTypes.size() != 0) {
			Map<String, String> employee = new HashMap<String, String>();

			for (Object[] details : workerTypes) {
				employee.put((String) details[0], (String) details[1]);
			}
			claimFieldsData.setWorkerTypes(employee);
		}

		if (sponsorTypes != null && sponsorTypes.size() != 0) {
			Map<String, String> sponsor = new HashMap<String, String>();

			for (Object[] details : sponsorTypes) {
				sponsor.put((String) details[0], (String) details[1]);
			}
			claimFieldsData.setSponsorTypes(sponsor);
		}

		return claimFieldsData;
	}

	private String getErrorMessage(ErrorCode errorCode, Object[] args, Locale locale) {
		return messageSource.getMessage(errorCode.getCode(), args, locale);
	}

	private String getErrorMessage(ErrorCode errorCode, Locale locale) {
		return getErrorMessage(errorCode, null, locale);
	}

    public PaymentListingDTO getPayemntListingDTO(String claimNo, String userGroupId) {

        String loginUserId = JWTUtil.getUserId();
		String sponsorName = null;
		PaymentListingDTO paymentListingDTO = new PaymentListingDTO();
		ClaimTransactionClaim ctdsLevelC = claimDetailsRepository.findByClaimNo(claimNo);
		Claim claim = claimsRepository.findByComplaintNumberAndErrorType(claimNo, null);

		String employeeName = insuredDetailsDataRepository.getInsuredName(ctdsLevelC.getFnolSgsId());
		String insuredId = claimFnolDetailsRepository.getInsuredId(ctdsLevelC.getFnolSgsId());
		sponsorName = claimFnolDetailsRepository.getSponsorName(Integer.parseInt(insuredId));

		ClaimDetails claimDetails = new ClaimDetails();

		if (!StringUtils.isEmpty(ctdsLevelC.getPolicyNo())) {
			claimDetails.setCertificateNo(ctdsLevelC.getPolicyNo());
		}
		if (!StringUtils.isEmpty(ctdsLevelC.getClaimNo())) {
			claimDetails.setClaimNo(ctdsLevelC.getClaimNo());
		}
		if (!StringUtils.isEmpty(claim.getClaimStatus())) {
			claimDetails.setClaimStatus(claimsRepository.getClaimStatusDesc(ctdsLevelC.getClaimStatus()));
		}
		if (!StringUtils.isEmpty(ctdsLevelC.getLossDate())) {
			claimDetails.setLossDate(ctdsLevelC.getLossDate());
		}
		if (!StringUtils.isEmpty(ctdsLevelC.getCreatedDate())) {
			claimDetails.setCreatedDate(ctdsLevelC.getCreatedDate());
		}
		if (!StringUtils.isEmpty(ctdsLevelC.getProductId())) {
            claimDetails.setProductName(claimsRepository.getProductNameDesc(Integer.parseInt(ctdsLevelC.getProductId())));
		}
		if (!StringUtils.isEmpty(employeeName)) {
			claimDetails.setInsuredName(employeeName);
		}

		if (!StringUtils.isEmpty(sponsorName)) {
			claimDetails.setSponsorName(sponsorName);

		}
		paymentListingDTO.setClaimDetails(claimDetails);

		int revisionNo = claimTransactionEstimationRepository.getLatestRevisionNo(ctdsLevelC.getFnolSgsId());
		ClaimTransactionEstimation paymentestmt = claimTransactionEstimationRepository
				.findByFnolSgsIdAndRevisionSerialNo(ctdsLevelC.getFnolSgsId(), revisionNo);

		PaymentEstimateDetails paymentDetails = new PaymentEstimateDetails();
		if (paymentestmt != null) {
            paymentDetails.setCover(claimsRepository.getCoverDesc(paymentestmt.getCoverId()));
            paymentDetails.setLossType(UdsIdDefConfig.getUdsIdDefinitionDesc(UdsIdDefConfig.ID_TYPE_PAYMENT_TYPE,
                                                                             paymentestmt.getLossId()));
			paymentDetails.setDate(paymentestmt.getEstimatedDate());
            paymentDetails.setAmount(claim.getPaymentAmount());
            paymentDetails.setSettled((double) 0);
            paymentDetails.setOutstandingAmount(claim.getPaymentAmount());
		}
		
		PaymentDetails paymentReview = new PaymentDetails();
        PaymentDetails paymentApprove = new PaymentDetails();
		
		int serialRevisionNo = claimTransactionEstimationRepository.getLatestRevisionNo(ctdsLevelC.getFnolSgsId());
		List<Object[]> getPaymentEstimateDetails = claimTransactionEstimationRepository.getPaymentDetails(ctdsLevelC.getFnolSgsId(), serialRevisionNo);

		if (getPaymentEstimateDetails != null && getPaymentEstimateDetails.size()>0) {

			paymentReview.setRequestedPersonName(claimsRepository.getPaymentRequestedPerson());
            paymentApprove.setRequestedPersonName(claimsRepository.getPaymentRequestedPerson());
			Object[] obj = getPaymentEstimateDetails.get(0);
			if (obj != null) {
				if (obj[0] != null) {
                    paymentReview.setCover(claimsRepository.getCoverDesc(obj[0].toString()));
                    paymentApprove.setCover(claimsRepository.getCoverDesc(obj[0].toString()));
				}
				if (obj[1] != null) {
                    paymentReview.setAmount(claimsRepository.getSettledAmount(paymentestmt.getFnolSgsId()));
                    paymentApprove.setAmount(claimsRepository.getSettledAmount(paymentestmt.getFnolSgsId()));
				}
			}
		}

		List<Object[]> PaymentDetails = claimTransactionSettlementRepository
				.getPaymentDetails(ctdsLevelC.getFnolSgsId());
		if (PaymentDetails != null && PaymentDetails.size()>0) {
			Object[] obj = PaymentDetails.get(0);
			if (obj != null) {
				if (obj[0] != null) {
                    paymentReview.setSettledAmount((double) 0);

                    paymentApprove.setSettledAmount(claimsRepository.getSettledAmount(paymentestmt.getFnolSgsId()));
				}
				if (obj[1] != null) {
					if (paymentestmt != null) {
						if (!StringUtils.isEmpty(paymentestmt.getOutstandingAmount())) {
                            paymentReview.setOutstandingAmount(claimsRepository.getSettledAmount(paymentestmt.getFnolSgsId()));
                            paymentApprove.setOutstandingAmount(paymentestmt.getOutstandingAmount());
						}
					}
				}
			}

		}
        int reviewCount = claimWorkingDetailsRepository.getReviewUserCount(loginUserId, userGroupId, claimNo);
		if(reviewCount >= 1) {
			paymentListingDTO.setReview(true);
		}else {
			paymentListingDTO.setReview(false);
		}
        int approveCount = claimWorkingDetailsRepository.getApproverUserCount(loginUserId, userGroupId, claimNo);
		if(approveCount >= 1) {
			paymentListingDTO.setApprove(true);
		}else {
			paymentListingDTO.setApprove(false);
		}
		paymentListingDTO.setPaymentReview(paymentReview);
        paymentListingDTO.setPaymentApproval(paymentApprove);

		paymentListingDTO.setPaymentEstimateDetails(paymentDetails);
		return paymentListingDTO;
	}

	public List<String> getActions(String claimNo, Locale locale) {
		String claimStatus = claimDetailsRepository.getClaimStatus(claimNo);
		List<String> claimActions = new ArrayList<>();
		if (claimStatus.equals("CS")) {
			claimActions.add(getErrorMessage(ErrorCode.DECLINE_CLAIM, locale));
			claimActions.add(getErrorMessage(ErrorCode.CLOSE_CLAIM, locale));
		}
		if (claimStatus.equals("CL")) {
			claimActions.add(getErrorMessage(ErrorCode.RE_OPEN_CLAIM, locale));
		}
		if (claimStatus.equals("RO")) {
			claimActions.add(getErrorMessage(ErrorCode.CLOSE_CLAIM, locale));
		}
		if (claimStatus.equals("CD")) {
			
		}
		return claimActions;
	}

	@Transactional
	public Set<String> getClaimActionReasons(String action) {

		String actionType = (ClaimEnumConstants.CLOSE.toString().equals(action))
				? ClaimEnumConstants.CLOSE_REASON_TYPE.toString()
				: ClaimEnumConstants.REOPEN_OR_DECLINE_REASON_TYPE.toString();
		Set<String> reasons = udsIdDefinitionRepository.findUidDescByType(actionType);
		return reasons;
	}

	@Transactional
	public boolean reopenClaim(String claimNo, ClaimReason claimReason) {

		updateClaimStatus(claimNo, claimReason, ClaimEnumConstants.REOPEN.toString(), false);
		return true;
	}

	@Transactional
	public boolean closeClaim(String claimNo, ClaimReason claimReason) {

		updateClaimStatus(claimNo, claimReason, ClaimEnumConstants.CLOSE.toString(), false);
		return true;
	}

	@Transactional
	public boolean declineClaim(String claimNo, ClaimReason claimReason) {

		updateClaimStatus(claimNo, claimReason, ClaimEnumConstants.DECLINE.toString(), false);
		return true;
	}

	@Transactional
	public boolean updateClaimReason(String claimNo, ClaimReason claimReason) {

		updateClaimStatus(claimNo, claimReason, null, true);
		return true;
	}

	private void updateClaimStatus(String claimNo, ClaimReason claimReason, String action,
			boolean isUpdateClaimReason) {

		Long fnolSgsId = null;
		String claimRsn = claimReason.getReason();
		String claimRsnDesc = claimReason.getReasonDesc();
		String fnolStatus;
		String closeFlag;
		String approveFlag;

		if (ClaimEnumConstants.REOPEN.toString().equals(action)) {
			fnolStatus = ClaimEnumConstants.REOPEN_FNOL_STATUS.toString();
			closeFlag = ClaimEnumConstants.REOPEN_CLOSE_FLAG.toString();
			approveFlag = ClaimEnumConstants.REOPEN_APPROVE_FLAG.toString();
		} else if (ClaimEnumConstants.DECLINE.toString().equals(action)) {
			fnolStatus = ClaimEnumConstants.DECLINE_FNOL_STATUS.toString();
			closeFlag = ClaimEnumConstants.DECLINE_CLOSE_FLAG.toString();
			approveFlag = ClaimEnumConstants.DECLINE_APPROVE_FLAG.toString();
		} else {
			fnolStatus = ClaimEnumConstants.CLOSE_FNOL_STATUS.toString();
			closeFlag = ClaimEnumConstants.CLOSE_CLOSE_FLAG.toString();
			approveFlag = ClaimEnumConstants.CLOSE_APPROVE_FLAG.toString();
		}

		// check claim exists in CTDS_LEVEL_FNOL table and update fnol status for
		// reopen/decline/close claim or update claim reason
		ClaimTransactionFNOL claimTransactionFNOL = claimFnolDetailsRepository.findByClaimNo(claimNo);
		if (null != claimTransactionFNOL) {

			if (!isUpdateClaimReason) {
				fnolSgsId = claimTransactionFNOL.getFnolSgsId();
				claimTransactionFNOL.setFnolStatus(fnolStatus);
				claimFnolDetailsRepository.save(claimTransactionFNOL);
			} else {
				claimTransactionFNOL.setClaimReason(claimRsn);
				claimTransactionFNOL.setLossDescription(claimRsnDesc);
				claimFnolDetailsRepository.save(claimTransactionFNOL);
			}
		} else {
            throw new ValidationException(ErrorCode.CLAIM_DOES_NOT_EXIST);
		}

		// check claim exists in CTDS_LEVEL_E table and update fnol status for
		// reopen/decline/close claim or update claim reason
		ClaimTransactionClaim claimTransactionClaim = claimDetailsRepository.findByClaimNo(claimNo);
		if (null != claimTransactionClaim) {

			if (!isUpdateClaimReason) {
				claimTransactionClaim.setClaimStatus(fnolStatus);
				claimDetailsRepository.save(claimTransactionClaim);
			} else {
				claimTransactionClaim.setClaimReason(claimRsn);
				claimTransactionClaim.setLossDescription(claimRsnDesc);
				claimDetailsRepository.save(claimTransactionClaim);
			}
		}

		// check close flag, approve flag and claim reason while re-open/decline/close
		// claim or update claim reason in claims table
		if (!isUpdateClaimReason) {

			// CWDS_LEVEL_E table
			ClaimWorkingEstimation claimWorkingEstimation = claimWorkingDetailsRepository.findByFnolSgsId(fnolSgsId);
			if (null != claimWorkingEstimation) {

				claimWorkingEstimation.setCloseFlag(closeFlag);
				claimWorkingEstimation.setApproveFlag(approveFlag);
				updateClaimReason(claimWorkingEstimation, null, null, action, claimRsn);
				claimWorkingDetailsRepository.save(claimWorkingEstimation);
			}

			// CTDS_LEVEL_E table
			ClaimTransactionEstimation claimTransactionEstimation = claimTransactionEstimationRepository
					.findByEstimateSgsId(claimWorkingEstimation.getEstimateSgsId());
			if (null != claimTransactionEstimation) {

				claimTransactionEstimation.setCloseFlag(closeFlag);
				claimTransactionEstimation.setApproveFlag(approveFlag);
				updateClaimReason(null, claimTransactionEstimation, null, action, claimRsn);
				claimTransactionEstimationRepository.save(claimTransactionEstimation);
			}

			// CHDS_LEVEL_E table
			ClaimHistoryEstimation claimHistoryEstimation = claimEstimationHistoryRepository.findByFnolSgsId(fnolSgsId);
			if (null != claimHistoryEstimation) {

				claimHistoryEstimation.setCloseFlag(closeFlag);
				claimHistoryEstimation.setApproveFlag(approveFlag);
				updateClaimReason(null, null, claimHistoryEstimation, action, claimRsn);
				claimEstimationHistoryRepository.save(claimHistoryEstimation);
			}

		} else {

			Claim claim = claimsRepository.findByComplaintNumber(claimNo);
			if (null != claim) {

				claim.setClaimReason(claimRsn);
				claim.setClaimDescription(claimRsnDesc);
				claimsRepository.save(claim);
			}
		}

	}

	/*
	 * update close reason id in CWDS_LEVEL_E and CTDS_LEVEL_E while closing claim
	 * and update reason in CWDS_LEVEL_E, CTDS_LEVEL_E and CHDS_LEVEL_E while
	 * re-open or decline claim
	 */
	private void updateClaimReason(ClaimWorkingEstimation claimWorkingEstimation,
			ClaimTransactionEstimation claimTransactionEstimation, ClaimHistoryEstimation claimHistoryEstimation,
			String status, String reason) {

		if (ClaimEnumConstants.CLOSE.toString().equals(status) && null != reason && null == claimHistoryEstimation) {

			String id = udsIdDefinitionRepository.findIdByType(ClaimEnumConstants.CLOSE_REASON_TYPE.toString(), reason);
			if (null != claimWorkingEstimation) {

				claimWorkingEstimation.setCloseReasonID(id);
			} else {

				claimTransactionEstimation.setCloseReasonID(id);
			}
		} else if (reason != null) {

			if (null != claimWorkingEstimation) {

				claimWorkingEstimation.setEstimateDescription(reason);
			} else if (null != claimTransactionEstimation) {

				claimTransactionEstimation.setEstimateDescription(reason);
			} else {

				claimHistoryEstimation.setEstimateDescription(reason);
			}
		}
	}
	
}

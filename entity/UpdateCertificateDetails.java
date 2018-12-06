package com.beyontec.mol.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.SequenceGenerator;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.beyontec.mol.config.CommonConfig;
import com.beyontec.mol.exception.ApplicationException;
import com.beyontec.mol.exception.ErrorCode;
import com.beyontec.mol.util.CryptoUtil;
import com.beyontec.mol.util.DateUtil;

@Entity
@Table(name = "IDS_UPD_CERT_DTLS")
@NamedStoredProcedureQuery(name = "updateCertificate", procedureName = "UWP_AMND_PRCS", parameters = {
                                                                                                 @StoredProcedureParameter(mode = ParameterMode.IN, name = "P_IUCD_SGS_ID", type = Long.class) })
@EntityListeners(AuditingEntityListener.class)
public class UpdateCertificateDetails {

    public enum STATUS {
        SUCCESS("A"),
        VALIDATION_ERR("DE"),
        SYSTEM_ERR("E");

        private String value;

        STATUS(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }


    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sgs_id_generator")
    @SequenceGenerator(name = "sgs_id_generator", sequenceName = "SEQ_IUCD_SGS_ID", allocationSize = 1)
	@Id
	@Column(name = "IUCD_SGS_ID")
	private long sgsId;

	@Column(name = "IUCD_COMP_ID")
	private String companyId;

	@Column(name = "IUCD_TYP")
	private String requestType;

	@Column(name = "IUCD_NAME")
	private String workerNameEn;

	@Column(name = "IUCD_NAME_BL")
	private String workerNameAr;

	@Column(name = "IUCD_DOB")
	private Date dateOfBirth;

	@Column(name = "IUCD_GENDER")
	private String gender;

	@Column(name = "IUCD_NATIONALITY")
	private String nationality;

	@Column(name = "IUCD_COB")
	private String countryOfBirth;

	@Column(name = "IUCD_EMIRATES_ID")
	private String emiratesId;

	@Column(name = "IUCD_PP_TYP")
	private String passportType;

	@Column(name = "IUCD_PP_NO")
	private String passportNo;

	@Column(name = "IUCD_RELIGION")
	private String religion;

	@Column(name = "IUCD_MARITAL_STATUS")
	private String maritalStatus;

	@Column(name = "IUCD_DESIG_ID")
	private String designationId;

	@Column(name = "IUCD_CATG_ID")
	private String employeeCategory;

	@Column(name = "IUCD_MOL_REF_NO")
	private String molRefNo;

	@Column(name = "IUCD_VAA_TYP")
	private String vaaId;

	@Column(name = "IUCD_VISA_APD")
	private Date visaApprovalDate;

	@Column(name = "IUCD_VISA_EXPD")
	private Date visaExpirationDate;

	@Column(name = "IUCD_AMND_EFF_FMD")
	private Date amendEffectFrom;

	@Column(name = "IUCD_AMND_DATE")
	private Date amendDate;

	@Column(name = "IUCD_PROF_ID")
	private String profId;

	@Column(name = "IUCD_SALARY_1")
	private double salary1;

	@Column(name = "IUCD_EMPL_LICN_NO")
	private String employerLicenseNo;

	@Column(name = "IUCD_EMPL_NAME")
	private String employerNameEn;

	@Column(name = "IUCD_EMPL_NAME_BL")
	private String employerNameAr;

	@Column(name = "IUCD_EMPL_CLASS_TYP")
	private String establishmentClassfication;

	@Column(name = "IUCD_EMPL_INDUST_TYP")
	private String industry;

	@Column(name = "IUCD_EMPL_ESTB_CARD_NO")
	private String establishmentCardNo;

	@Column(name = "IUCD_STATUS")
	private String status;

	@Column(name = "IUCD_ERR_TYP")
	private String errorType;

	@Column(name = "IUCD_ERR_ID")
	private String errorId;

	@Column(name = "IUCD_ERR_MSG")
	private String errorMessage;

	@Column(name = "IUCD_CRD")
	private Date reqInDate;

	@Column(name = "IUCD_RESP_ID")
	private String responseId;

	@Column(name = "IUCD_RESP_MSG")
	private String responseMessage;

	@Column(name = "IUCD_RESPD")
	private Date respDate;

	@Column(name = "IUCD_MST_NO")
	private String masterPolicyNo;

	@Column(name = "IUCD_MST_AMND_VER_NO")
	private long masterAmdVerNo;

	@Column(name = "IUCD_DOC_PATH")
	private String documentPath;

	@Column(name = "IUCD_DOC_GEND")
	private Date documentGenDate;

	@Column(name = "IUCD_POL_NO")
	private String policyNo;

	@Column(name = "IUCD_JOB_ID")
	private String mohreJobId;

	@Column(name = "IUCD_JOB_ID_1")
	private String enscoJobId;

	@Column(name = "IUCD_PREV_POL_NO")
	private String previousPolicyNo;

	@Column(name = "IUCD_ULM_NO")
    private String certificateNumber;

	@Column(name = "IUCD_TRAN_TYP")
	private String transactionType;

	@Column(name = "IUCD_LC_REF_NO")
	private String labourReferenceNo;

	@Column(name = "IUCD_FILE_NO")
	private String fileNo;

	@Column(name = "IUCD_REQ_IPADDR")
	private String clientIpAddress;

	@Column(name = "IUCD_PRC_IPADDR")
	private String serverIpAddress;

	@Column(name = "IUCD_BATCH_ID")
	private long batchId;

	@Column(name = "IUCD_BATCH_PRC_FLAG")
	private String batchProcessStatus;

	@Column(name = "IUCD_EXPD")
	private Date expiryDate;

	@Column(name = "IUCD_ACK_FLAG")
	private String acknowledgeFlag;

	@Column(name = "IUCD_SALARY")
	private String salary;

    @Transient private String intermSalary;

	public long getSgsId() {
		return sgsId;
	}

	public void setSgsId(long sgsId) {
		this.sgsId = sgsId;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getWorkerNameEn() {
		return workerNameEn;
	}

	public void setWorkerNameEn(String workerNameEn) {
		this.workerNameEn = workerNameEn;
	}

	public String getWorkerNameAr() {
		return workerNameAr;
	}

	public void setWorkerNameAr(String workerNameAr) {
		this.workerNameAr = workerNameAr;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getCountryOfBirth() {
		return countryOfBirth;
	}

	public void setCountryOfBirth(String countryOfBirth) {
		this.countryOfBirth = countryOfBirth;
	}

	public String getEmiratesId() {
		return emiratesId;
	}

	public void setEmiratesId(String emiratesId) {
		this.emiratesId = emiratesId;
	}

	public String getPassportType() {
		return passportType;
	}

	public void setPassportType(String passportType) {
		this.passportType = passportType;
	}

	public String getPassportNo() {
		return passportNo;
	}

	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getDesignationId() {
		return designationId;
	}

	public void setDesignationId(String designationId) {
		this.designationId = designationId;
	}

	public String getEmployeeCategory() {
		return employeeCategory;
	}

	public void setEmployeeCategory(String employeeCategory) {
		this.employeeCategory = employeeCategory;
	}

	public String getMolRefNo() {
		return molRefNo;
	}

	public void setMolRefNo(String molRefNo) {
		this.molRefNo = molRefNo;
	}

	public String getVaaId() {
		return vaaId;
	}

	public void setVaaId(String vaaId) {
		this.vaaId = vaaId;
	}

	public Date getVisaApprovalDate() {
		return visaApprovalDate;
	}

	public void setVisaApprovalDate(Date visaApprovalDate) {
		this.visaApprovalDate = visaApprovalDate;
	}

	public Date getVisaExpirationDate() {
		return visaExpirationDate;
	}

	public void setVisaExpirationDate(Date visaExpirationDate) {
		this.visaExpirationDate = visaExpirationDate;
	}

	public Date getAmendEffectFrom() {
		return amendEffectFrom;
	}

	public void setAmendEffectFrom(Date amendEffectFrom) {
		this.amendEffectFrom = amendEffectFrom;
	}

	public Date getAmendDate() {
		return amendDate;
	}

	public void setAmendDate(Date amendDate) {
		this.amendDate = amendDate;
	}

	public String getProfId() {
		return profId;
	}

	public void setProfId(String profId) {
		this.profId = profId;
	}

	public double getSalary1() {
		return salary1;
	}

	public void setSalary1(double salary1) {
		this.salary1 = salary1;
	}

	public String getEmployerLicenseNo() {
		return employerLicenseNo;
	}

	public void setEmployerLicenseNo(String employerLicenseNo) {
		this.employerLicenseNo = employerLicenseNo;
	}

	public String getEmployerNameEn() {
		return employerNameEn;
	}

	public void setEmployerNameEn(String employerNameEn) {
		this.employerNameEn = employerNameEn;
	}

	public String getEmployerNameAr() {
		return employerNameAr;
	}

	public void setEmployerNameAr(String employerNameAr) {
		this.employerNameAr = employerNameAr;
	}

	public String getEstablishmentClassfication() {
		return establishmentClassfication;
	}

	public void setEstablishmentClassfication(String establishmentClassfication) {
		this.establishmentClassfication = establishmentClassfication;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getEstablishmentCardNo() {
		return establishmentCardNo;
	}

	public void setEstablishmentCardNo(String establishmentCardNo) {
		this.establishmentCardNo = establishmentCardNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorType() {
		return errorType;
	}

	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}

	public String getErrorId() {
		return errorId;
	}

	public void setErrorId(String errorId) {
		this.errorId = errorId;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Date getReqInDate() {
		return reqInDate;
	}

	public void setReqInDate(Date reqInDate) {
		this.reqInDate = reqInDate;
	}

	public String getResponseId() {
		return responseId;
	}

	public void setResponseId(String responseId) {
		this.responseId = responseId;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public Date getRespDate() {
		return respDate;
	}

	public void setRespDate(Date respDate) {
		this.respDate = respDate;
	}

	public String getMasterPolicyNo() {
		return masterPolicyNo;
	}

	public void setMasterPolicyNo(String masterPolicyNo) {
		this.masterPolicyNo = masterPolicyNo;
	}

	public long getMasterAmdVerNo() {
		return masterAmdVerNo;
	}

	public void setMasterAmdVerNo(long masterAmdVerNo) {
		this.masterAmdVerNo = masterAmdVerNo;
	}

	public String getDocumentPath() {
		return documentPath;
	}

	public void setDocumentPath(String documentPath) {
		this.documentPath = documentPath;
	}

	public Date getDocumentGenDate() {
		return documentGenDate;
	}

	public void setDocumentGenDate(Date documentGenDate) {
		this.documentGenDate = documentGenDate;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getMohreJobId() {
		return mohreJobId;
	}

	public void setMohreJobId(String mohreJobId) {
		this.mohreJobId = mohreJobId;
	}

	public String getEnscoJobId() {
		return enscoJobId;
	}

	public void setEnscoJobId(String enscoJobId) {
		this.enscoJobId = enscoJobId;
	}

	public String getPreviousPolicyNo() {
		return previousPolicyNo;
	}

	public void setPreviousPolicyNo(String previousPolicyNo) {
		this.previousPolicyNo = previousPolicyNo;
	}

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getLabourReferenceNo() {
		return labourReferenceNo;
	}

	public void setLabourReferenceNo(String labourReferenceNo) {
		this.labourReferenceNo = labourReferenceNo;
	}

	public String getFileNo() {
		return fileNo;
	}

	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}

	public String getClientIpAddress() {
		return clientIpAddress;
	}

	public void setClientIpAddress(String clientIpAddress) {
		this.clientIpAddress = clientIpAddress;
	}

	public String getServerIpAddress() {
		return serverIpAddress;
	}

	public void setServerIpAddress(String serverIpAddress) {
		this.serverIpAddress = serverIpAddress;
	}

	public long getBatchId() {
		return batchId;
	}

	public void setBatchId(long batchId) {
		this.batchId = batchId;
	}

	public String getBatchProcessStatus() {
		return batchProcessStatus;
	}

	public void setBatchProcessStatus(String batchProcessStatus) {
		this.batchProcessStatus = batchProcessStatus;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getAcknowledgeFlag() {
		return acknowledgeFlag;
	}

	public void setAcknowledgeFlag(String acknowledgeFlag) {
		this.acknowledgeFlag = acknowledgeFlag;
	}

	public String getSalary() {
        return CryptoUtil.decrypt(this.salary);
	}

	public void setSalary(String salary) {
        this.intermSalary = salary;
        try {
            new BigDecimal(salary);
            this.salary = CryptoUtil.encrypt(salary);
        } catch (Exception e) { /* Ignored */ }
    }

    public String getIntermSalary() {
        return intermSalary;
    }

    public void setIntermSalary(String intermSalary) {
        this.intermSalary = intermSalary;
    }

    private void validateMandatories(ApplicationException appException) {
        // @formatter:off
		if (StringUtils.isBlank(this.certificateNumber)) {
			appException.appendErr(ErrorCode.CERTIFICATE_NO_MANDATORTY);
			
		}
		
		if(this.amendEffectFrom == null) {
		    appException.appendErr(ErrorCode.ENDORSEMENT_NO_MANDATORTY);
		}
	
		// @formatter:on
    }

    private void validateEndorsementDatePattern(ApplicationException ae) {

        String allowedDatePattern = CommonConfig.DATE_FORMAT.toPattern();
        if (this.amendEffectFrom == null) {
            ae.appendErr(ErrorCode.ENDORSEMENT_DATE_FORMAT_INVALID, allowedDatePattern);
        }
    }

    private void validateDates(ApplicationException ae) {

        validateEndorsementDatePattern(ae);

        // Validate endorsement date remaining validations
    }

    public ApplicationException validate(CertificateDetails originalCertificateDetails,
                                         CertificateDetails latestCertificateDetails,
                                         PolicyHistory masterPolicy,
                                         PolicyMain originalPolicy) {
        ApplicationException ae = latestCertificateDetails.validate(masterPolicy);
        validateMandatories(ae);
        //validateDates(ae);

        if (ae.containsErr(ErrorCode.CERTIFICATE_NO_MANDATORTY)) {
            return ae;
        }

        if (originalCertificateDetails == null) {
            ae.appendErr(ErrorCode.INVALID_CERTIFICATE_NUMBER);
            return ae;
        }

        if (originalPolicy == null) {
            ae.appendErr(ErrorCode.POLICY_NOT_FOUND);
            return ae;
        }

        if (originalPolicy.getStatus().equals("CAN")) {
            ae.appendErr(ErrorCode.CANCELLED_CERTIFICATE_CANNOT_UPDATE);
            return ae;
        }

        if (StringUtils.isBlank(latestCertificateDetails.getEmployeeCategory())) { return ae; }
        String originalEmployeeCategory = originalCertificateDetails.getEmployeeCategory();
        if (!latestCertificateDetails.getEmployeeCategory().equals(originalEmployeeCategory)) {
            ae.appendErr(ErrorCode.EMPLOYEE_CATEGORY_MODIFY);
        }
        
        if (this.amendEffectFrom == null ) { return ae; }
        
        if (originalPolicy.getAmendmentFromDate() != null
            && DateUtil.isLessThan(this.amendEffectFrom, originalPolicy.getAmendmentFromDate())) {
            ae.appendErr(ErrorCode.ENDORSEMENT_DATE_INVALID, originalPolicy.getAmendmentFromDate());
        }

        if (DateUtil.isNotBetWeen(this.amendEffectFrom, originalPolicy.getFromDate(), originalPolicy.getExpiryDate())) {
            ae.appendErr(ErrorCode.INVALID_ENDORSEMENT_DATE);
        }
        return ae;
    }
}

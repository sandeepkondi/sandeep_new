package com.beyontec.mol.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

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

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.beyontec.mol.config.CommonConfig;
import com.beyontec.mol.config.UdsIdDefConfig;
import com.beyontec.mol.exception.ApplicationException;
import com.beyontec.mol.exception.ErrorCode;
import com.beyontec.mol.exception.ResponseStatusCode;
import com.beyontec.mol.util.AppConstants;
import com.beyontec.mol.util.CryptoUtil;
import com.beyontec.mol.util.DateUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "IDS_CERT_DTLS")
@NamedStoredProcedureQuery(name = "populateIDS", procedureName = "UWP_APPROVE", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_ULM_SGS_ID", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_ULM_AMND_VER_NO", type = Long.class) })
@EntityListeners(AuditingEntityListener.class)
public class CertificateDetails {
	public enum STATUS {
		SUCCESS("A"), VALIDATION_ERR("DE"), SYSTEM_ERR("E");

		private String value;

		STATUS(String value) {
			this.value = value;
		}

		public String getValue() {
			return this.value;
		}
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "icd_sgs_id_generator")
    @SequenceGenerator(sequenceName = "SEQ_ICD_SGS_ID", name = "icd_sgs_id_generator", allocationSize = 1)
	@Column(name = "ICD_SGS_ID")
	private Long sgsId;

	@Column(name = "ICD_COMP_ID")
	private String companyId;

	@Column(name = "ICD_TYP")
	private String requestType;

	@Column(name = "ICD_NAME")
	private String workerNameEn;

	@Column(name = "ICD_NAME_BL")
	private String workerNameAr;

	@Column(name = "ICD_DOB")
	private Date dateOfBirth;

	@Column(name = "ICD_GENDER")
	private String gender;

	@Column(name = "ICD_NATIONALITY")
	private String nationality;

	@Column(name = "ICD_COB")
	private String countryOfBirth;

	@Column(name = "ICD_EMIRATES_ID")
	private String emiratesId;

	@Column(name = "ICD_PP_TYP")
	private String passportType;

	@Column(name = "ICD_PP_NO")
	private String passportNo;

	@Column(name = "ICD_MARITAL_STATUS")
	private String maritalStatus;

	@Column(name = "ICD_CATG_ID")
	private String employeeCategory;

	@Column(name = "ICD_VISA_APD")
	private Date visaApprovalDate;

	@Column(name = "ICD_VISA_EXPD")
	private Date visaExpirationDate;

	@Column(name = "ICD_SALARY")
    private String salary;

    @Transient
    private String intermSalary;

	@Column(name = "ICD_EMPL_LICN_NO")
	private String employerLicenseNo;

	@Column(name = "ICD_EMPL_NAME")
	private String employerNameEn;

	@Column(name = "ICD_EMPL_NAME_BL")
	private String employerNameAr;

	@Column(name = "ICD_EMPL_CLASS_TYP")
	private String establishmentClassfication;

	@Column(name = "ICD_EMPL_INDUST_TYP")
	private String industry;

	@Column(name = "ICD_EMPL_ESTB_CARD_NO")
	private String establishmentCardNo;

	@Column(name = "ICD_DOC_PATH")
	private String documentPath;

	@Column(name = "ICD_DOC_GEND")
	private Date documentGenDate;

	@Column(name = "ICD_STATUS")
	private String status;

	@Column(name = "ICD_ERR_TYP")
	private String errType;

	@Column(name = "ICD_ERR_ID")
	private String errId;

	@Column(name = "ICD_ERR_MSG")
	private String errMsg;

	@Column(name = "ICD_CRD")
	private Date reqInDate;

	@Column(name = "ICD_RESP_ID")
	private String respId;

	@Column(name = "ICD_RESP_MSG")
	private String respMsg;

	@Column(name = "ICD_RESPD")
	private String respDate;

	@Column(name = "ICD_MST_NO")
	private String masterPolicyNo;

	@Column(name = "ICD_MST_AMND_VER_NO")
	private Long masterAmdVerNo;

    @Column(name = "ICD_EXPD") private Date expiryDate;
    @Column(name = "ICD_PRC_IPADDR") private String serverIpAddress;
    @Column(name = "ICD_REQ_IPADDR") private String clientIpAddress;

	// @formatter:off
	@Column(name = "ICD_JOB_ID")
	private String mohreJobId;
	@Column(name = "ICD_JOB_ID_1")
	private String enscoJobId;
	@Column(name = "ICD_LC_REF_NO")
	private String labourReferenceNo;
	@Column(name = "ICD_PREV_POL_NO")
	private String previousPolicyNo;
	@Column(name = "ICD_TRAN_TYP")
	private String transactionType;
	@Column(name = "ICD_FILE_NO")
	private String fileNo;
	@Column(name = "ICD_ULM_NO")
	private String certificateNumber;
	@Column(name = "ICD_BATCH_ID ")
	private Long batchId;
	@Column(name = "ICD_BATCH_PRC_FLAG")
	private String batchProcessStatus;
	@Column(name = "ICD_ACK_FLAG ")
	private String acknowledgeFlag;

	@Override
	public String toString() {
		return "CertificateDetails [sgsId=" + sgsId + ", companyId=" + companyId + ", requestType=" + requestType
				+ ", workerNameEn=" + workerNameEn + ", workerNameAr=" + workerNameAr + ", dateOfBirth=" + dateOfBirth
				+ ", gender=" + gender + ", nationality=" + nationality + ", countryOfBirth=" + countryOfBirth
				+ ", emiratesId=" + emiratesId + ", passportType=" + passportType + ", passportNo=" + passportNo
				+ ", maritalStatus=" + maritalStatus + ", employeeCategory=" + employeeCategory + ", visaApprovalDate="
				+ visaApprovalDate + ", visaExpirationDate=" + visaExpirationDate + ", salary=" + salary
				+ ", employerLicenseNo=" + employerLicenseNo + ", employerNameEn=" + employerNameEn
				+ ", employerNameAr=" + employerNameAr + ", establishmentClassfication=" + establishmentClassfication
				+ ", industry=" + industry + ", establishmentCardNo=" + establishmentCardNo + ", documentPath="
				+ documentPath + ", documentGenDate=" + documentGenDate + ", status=" + status + ", errType=" + errType
				+ ", errId=" + errId + ", errMsg=" + errMsg + ", reqInDate=" + reqInDate + ", respId=" + respId
				+ ", respMsg=" + respMsg + ", respDate=" + respDate + ", masterPolicyNo=" + masterPolicyNo
				+ ", masterAmdVerNo=" + masterAmdVerNo + "]";
	}
	// @formatter:on

	public Long getSgsId() {
		return sgsId;
	}

	public void setSgsId(Long sgsId) {
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

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getEmployeeCategory() {
		return employeeCategory;
	}

	public void setEmployeeCategory(String employeeCategory) {
		this.employeeCategory = employeeCategory;
	}

	public Date getVisaApprovalDate() {
		return visaApprovalDate;
	}

    public String getVisaApprovalDateStr() {
        return DateUtil.toString(getVisaApprovalDate());
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrType() {
		return errType;
	}

	public void setErrType(String errType) {
		this.errType = errType;
	}

	public String getErrId() {
		return errId;
	}

	public void setErrId(String errId) {
		this.errId = errId;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public Date getReqInDate() {
		return reqInDate;
	}

	public void setReqInDate(Date reqInDate) {
		this.reqInDate = reqInDate;
	}

	public String getRespId() {
		return respId;
	}

	public void setRespId(String respId) {
		this.respId = respId;
	}

	public String getRespMsg() {
		return respMsg;
	}

	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}

	public String getRespDate() {
		return respDate;
	}

	public void setRespDate(String respDate) {
		this.respDate = respDate;
	}

	public String getMasterPolicyNo() {
		return masterPolicyNo;
	}

	public void setMasterPolicyNo(String masterPolicyNo) {
		this.masterPolicyNo = masterPolicyNo;
	}

	public Long getMasterAmdVerNo() {
		return masterAmdVerNo;
	}

	public void setMasterAmdVerNo(Long masterAmdVerNo) {
		this.masterAmdVerNo = masterAmdVerNo;
	}

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
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

    public String getLabourReferenceNo() {
        return labourReferenceNo;
    }

    public void setLabourReferenceNo(String labourReferenceNo) {
        this.labourReferenceNo = labourReferenceNo;
    }

    public String getPreviousPolicyNo() {
        return previousPolicyNo;
    }

    public void setPreviousPolicyNo(String previousPolicyNo) {
        this.previousPolicyNo = previousPolicyNo;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getFileNo() {
        return fileNo;
    }

    public void setFileNo(String fileNo) {
        this.fileNo = fileNo;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Long getBatchId() {
        return batchId;
    }

    public void setBatchId(Long batchId) {
        this.batchId = batchId;
    }

    public String getBatchProcessStatus() {
        return batchProcessStatus;
    }

    public void setBatchProcessStatus(String batchProcessStatus) {
        this.batchProcessStatus = batchProcessStatus;
    }

    public String getIntermSalary() {
        return intermSalary;
    }

    public void setIntermSalary(String intermSalary) {
        this.intermSalary = intermSalary;
    }

    public String getAcknowledgeFlag() {
        return acknowledgeFlag;
    }

    public void setAcknowledgeFlag(String acknowledgeFlag) {
        this.acknowledgeFlag = acknowledgeFlag;
    }

    public String getServerIpAddress() {
        return serverIpAddress;
    }

    public void setServerIpAddress(String serverIpAddress) {
        this.serverIpAddress = serverIpAddress;
    }

    public String getClientIpAddress() {
        return clientIpAddress;
    }

    public void setClientIpAddress(String clientIpAddress) {
        this.clientIpAddress = clientIpAddress;
    }

    @JsonIgnore
    public Long getVisaPeriod() {
        return DateUtil.getNumberOfDaysBetween(this.visaApprovalDate, this.visaExpirationDate);
    }


    public ApplicationException validate(PolicyHistory masterPolicy) {
        return validate(null, null, null, masterPolicy, null);
    }
    public ApplicationException validate(List<CertificateDetails> generatedCertsByLabourRefNoAndTxnType,
                                         List<CertificateDetails> certByPassNoTxnTypeNation,
                                         List<CertificateDetails> generatedCertsByEmiratesIdAndTxnType,
                                         PolicyHistory masterPolicy,
                                         PolicyMain previousPolicy) {
        ApplicationException ae = new ApplicationException(ResponseStatusCode.INVALID_REQUEST);
        validateMandatories(ae);
        validateNumbers(ae);
        validateByTxnType(ae, previousPolicy);
        validateByEmployeeCateg(ae);
        validateDates(ae);
        validateCodifiedFields(ae);
        validateDuplicates(ae,
                           generatedCertsByLabourRefNoAndTxnType,
                           certByPassNoTxnTypeNation,
                           generatedCertsByEmiratesIdAndTxnType);

        if (masterPolicy == null && StringUtils.isNotBlank(this.employeeCategory)) {
            ae.appendErr(ErrorCode.MASTER_POLICY_NOT_FOUND, this.getEmployeeCategory(), this.getVisaApprovalDateStr());
        }
        return ae;
    }

    private void validateMandatories(ApplicationException appException) {
        // @formatter:off
        if (StringUtils.isBlank(this.workerNameEn))      { appException.appendErr(ErrorCode.EMPTY_MANDATORY_FIELD, "Worker Name En"); }
        if (StringUtils.isBlank(this.workerNameAr))      { appException.appendErr(ErrorCode.EMPTY_MANDATORY_FIELD, "Worker Name Ar"); }
        if (StringUtils.isBlank(this.gender))            { appException.appendErr(ErrorCode.EMPTY_MANDATORY_FIELD, "Gender"); }
        if (StringUtils.isBlank(this.nationality))       { appException.appendErr(ErrorCode.EMPTY_MANDATORY_FIELD, "Nationality"); }
        if (StringUtils.isBlank(this.countryOfBirth))    { appException.appendErr(ErrorCode.EMPTY_MANDATORY_FIELD, "Country of Birth"); }
        if (StringUtils.isBlank(this.passportType))      { appException.appendErr(ErrorCode.EMPTY_MANDATORY_FIELD, "Passport Type"); }
        if (StringUtils.isBlank(this.passportNo))        { appException.appendErr(ErrorCode.EMPTY_MANDATORY_FIELD, "Passport Number"); }
        if (StringUtils.isBlank(this.maritalStatus))     { appException.appendErr(ErrorCode.EMPTY_MANDATORY_FIELD, "Marital Status"); }
        if (StringUtils.isBlank(this.employeeCategory))  { appException.appendErr(ErrorCode.EMPTY_MANDATORY_FIELD, "Employee Category"); }
        if (StringUtils.isBlank(this.employerLicenseNo)) { appException.appendErr(ErrorCode.EMPTY_MANDATORY_FIELD, "Employer License Number"); }
        if (StringUtils.isBlank(this.employerNameEn))    { appException.appendErr(ErrorCode.EMPTY_MANDATORY_FIELD, "Employer Name En"); }
        if (StringUtils.isBlank(this.employerNameAr))    { appException.appendErr(ErrorCode.EMPTY_MANDATORY_FIELD, "Employer Name Ar"); }
        if (StringUtils.isBlank(this.transactionType))   { appException.appendErr(ErrorCode.EMPTY_MANDATORY_FIELD, "Transaction Type"); }
        // @formatter:on
    }

    private void validateNumbers(ApplicationException ae) {
        if (this.intermSalary != null && !NumberUtils.isParsable((this.intermSalary))) {
            ae.appendErr(ErrorCode.NOT_A_DIGIT, "Salary");
        }
    }

    private void validateByTxnType(ApplicationException ae, PolicyMain previousPolicy) {
        if (StringUtils.isBlank(this.transactionType))  { return; }
        boolean isValidTxnType = UdsIdDefConfig.isCodifiedValue(UdsIdDefConfig.ID_TYPE_TRAN_TYPE, this.transactionType, ae);
        if (! isValidTxnType) { return; }

        String txnTypeValue = UdsIdDefConfig.getUdsIdDefinitionValue(UdsIdDefConfig.ID_TYPE_TRAN_TYPE, this.transactionType);
        if (! CommonConfig.TXN_TYPE_RENEWAL.equals(txnTypeValue)) { return; }

        if (StringUtils.isBlank(this.previousPolicyNo)) { return; }
        if (previousPolicy == null) { ae.appendErr(ErrorCode.PREVIOUS_POLICY_INVALID); }
    }

    private void validateByEmployeeCateg(ApplicationException ae) {
        if (StringUtils.isBlank(this.employeeCategory)) { return; }

        boolean isValidEmpCateg = UdsIdDefConfig.isCodifiedValue(UdsIdDefConfig.ID_TYPE_EMP_CATG, this.employeeCategory, ae);
        if (!isValidEmpCateg) { return; }

        String empCategValue = UdsIdDefConfig.getUdsIdDefinitionValue(UdsIdDefConfig.ID_TYPE_EMP_CATG, this.employeeCategory);
        if (CommonConfig.EMP_CATEG_DOMESTIC.equals(empCategValue)) {
            validateForDomesticEmp(ae);
        } else if (CommonConfig.EMP_CATEG_INSTITUTIONAL.equals(empCategValue)) {
            validateForInstitutionalEmp(ae);
        }
    }

    private void validateForDomesticEmp(ApplicationException ae) {
        // Validate file number
        if (StringUtils.isBlank(this.fileNo)) {
            ae.appendErr(ErrorCode.EMPTY_MANDATORY_FIELD, "File Number");
        }

        // Validate mohre job ID
        if (StringUtils.isBlank(this.mohreJobId)) {
            ae.appendErr(ErrorCode.EMPTY_MANDATORY_FIELD,
                                   UdsIdDefConfig.getIdTypeDispName(UdsIdDefConfig.ID_TYPE_MOHRE_JOB_ID));
        }
    }

    private void validateForInstitutionalEmp(ApplicationException ae) {
        // Validate labour ref no. and est card no.
        if (StringUtils.isBlank(this.labourReferenceNo)) {
            ae.appendErr(ErrorCode.EMPTY_MANDATORY_FIELD, "Labour Reference Number");
        }
        if (StringUtils.isBlank(this.establishmentCardNo)) {
            ae.appendErr(ErrorCode.EMPTY_MANDATORY_FIELD, "Establishment Card Number");
        }

        // Validate est classification
        if (StringUtils.isBlank(this.establishmentClassfication)) {
            ae.appendErr(ErrorCode.EMPTY_MANDATORY_FIELD, UdsIdDefConfig.getIdTypeDispName(UdsIdDefConfig.ID_TYPE_EST_CLASS_TYPE));
        }

//        Removed validation as per the client request
//        else {
//            UdsIdDefConfig.isCodifiedValue(UdsIdDefConfig.ID_TYPE_EST_CLASS_TYPE, this.establishmentClassfication, appException);
//        }

        // Validate industry
        if (StringUtils.isBlank(this.industry)) {
            ae.appendErr(ErrorCode.EMPTY_MANDATORY_FIELD, UdsIdDefConfig.getIdTypeDispName(UdsIdDefConfig.ID_TYPE_INDUS_TYPE));
        }

        // Validate mohre job ID & ensco job ID
        if (StringUtils.isBlank(this.mohreJobId) && StringUtils.isBlank(this.enscoJobId)) {
            String errMsgData = UdsIdDefConfig.getIdTypeDispName(UdsIdDefConfig.ID_TYPE_MOHRE_JOB_ID)
                                + " / "
                                + UdsIdDefConfig.getIdTypeDispName(UdsIdDefConfig.ID_TYPE_ENSCO_JOB_ID);
            ae.appendErr(ErrorCode.EMPTY_MANDATORY_FIELD, errMsgData);
            return;
        }
    }

    private void validateDates(ApplicationException ae) {
        validateDatesPattern(ae);

        // Validate Employee Date of Birth
        if (ae.containsErr(ErrorCode.CERTIFICATE_DOB_FORMAT_INVALID)) { return; }
        if (DateUtil.isNotPast(this.dateOfBirth)) {
            ae.appendErr(ErrorCode.CERT_DOB_GREATER_THAN_EQ_TO_CURRENT_DATE);
            return;
        }

        // Validate Visa Approval Date
        if (ae.containsErr(ErrorCode.CERTIFICATE_VISA_APPROVAL_DATE_FORMAT_INVALID)) { return; }
        boolean isDobGreaterThanVisaAppDate = DateUtil.isGreaterThan(this.dateOfBirth, this.visaApprovalDate);
        if (isDobGreaterThanVisaAppDate) {
            ae.appendErr(ErrorCode.DOB_GREATER_VISA_APPROVAL);
        }

        // Validate Visa Expiry Date
        if (ae.containsErr(ErrorCode.CERTIFICATE_VISA_EXPIRATION_DATE_FORMAT_INVALID)) { return; }
        boolean isVisaAppDateGreaterThanVisaExpDate = DateUtil.isGreaterThan(this.visaApprovalDate, this.visaExpirationDate);
        if (isVisaAppDateGreaterThanVisaExpDate) {
            ae.appendErr(ErrorCode.CERT_VISA_APP_DATE_GREATER_THAN_EQ_TO_VISA_EXP_DATE);
        }
    }

    private void validateDatesPattern(ApplicationException ae) {
        String allowedDatePattern = CommonConfig.DATE_FORMAT.toPattern();
        if (this.dateOfBirth == null) {
            ae.appendErr(ErrorCode.CERTIFICATE_DOB_FORMAT_INVALID, allowedDatePattern);
        }

        if (this.visaApprovalDate == null) {
            ae.appendErr(ErrorCode.CERTIFICATE_VISA_APPROVAL_DATE_FORMAT_INVALID, allowedDatePattern);
        }

        if (this.visaExpirationDate == null) {
            ae.appendErr(ErrorCode.CERTIFICATE_VISA_EXPIRATION_DATE_FORMAT_INVALID, allowedDatePattern);
        }
    }

    private void validateCodifiedFields(ApplicationException ae) {
        // @formatter:off
        if (StringUtils.isNotBlank(this.gender))          { UdsIdDefConfig.isCodifiedValue(UdsIdDefConfig.ID_TYPE_GENDER, this.gender, ae); }
        if (StringUtils.isNotBlank(this.nationality))     { UdsIdDefConfig.isCodifiedValue(UdsIdDefConfig.ID_TYPE_NATIONALITY, this.nationality, ae); }
        if (StringUtils.isNotBlank(this.countryOfBirth))  { UdsIdDefConfig.isCodifiedValue(UdsIdDefConfig.ID_TYPE_COUNTRY, this.countryOfBirth, ae); }
        if (StringUtils.isNotBlank(this.maritalStatus))   { UdsIdDefConfig.isCodifiedValue(UdsIdDefConfig.ID_TYPE_MARITAL_STATUS, this.maritalStatus, ae); }
        if (StringUtils.isNotBlank(this.passportType))    { UdsIdDefConfig.isCodifiedValue(UdsIdDefConfig.ID_TYPE_PASSPORT_TYPE, this.passportType, ae); }
        if (StringUtils.isNotBlank(this.mohreJobId))      { UdsIdDefConfig.isCodifiedValue(UdsIdDefConfig.ID_TYPE_MOHRE_JOB_ID, this.mohreJobId, ae); }
        if (StringUtils.isNotBlank(this.industry))        { UdsIdDefConfig.isCodifiedValue(UdsIdDefConfig.ID_TYPE_INDUS_TYPE, this.industry, ae); }
        if (StringUtils.isNotBlank(this.enscoJobId))      { UdsIdDefConfig.isCodifiedValue(UdsIdDefConfig.ID_TYPE_ENSCO_JOB_ID, this.enscoJobId, ae); }
        // @formatter:on
    }

    private void validateDuplicates(ApplicationException ae,
                                    List<CertificateDetails> generatedCertsByLabourRefNoAndTxnType,
                                    List<CertificateDetails> certByPassNoTxnTypeNation,
                                    List<CertificateDetails> generatedCertsByEmiratesIdAndTxnType) {

        CertificateDetails lrnCertificate = null;
        CertificateDetails ppCertificate = null;
        if (CollectionUtils.isNotEmpty(generatedCertsByLabourRefNoAndTxnType)) {
            ae.appendErr(ErrorCode.CERTIFICATE_DUPLICATE, "Labour Reference Number");
            lrnCertificate = generatedCertsByLabourRefNoAndTxnType.get(0);
        }

        if (CollectionUtils.isNotEmpty(certByPassNoTxnTypeNation)) {
            ae.appendErr(ErrorCode.CERTIFICATE_DUPLICATE, "Passport Number");
            ppCertificate = certByPassNoTxnTypeNation.get(0);
        }

        if (CollectionUtils.isNotEmpty(generatedCertsByEmiratesIdAndTxnType)) {
            ae.appendErr(ErrorCode.CERTIFICATE_DUPLICATE, "Emirates ID");
        }

        if (lrnCertificate != null
                   && ppCertificate != null
                   && lrnCertificate.getCertificateNumber().equals(ppCertificate.getCertificateNumber())) {
            ae.appendErr(ErrorCode.ERROR_DETAILS, getErrorDetails(lrnCertificate), "");
        }
        
    }

    private LinkedHashMap<String, Object> getErrorDetails(CertificateDetails certificateDetails) {

        LinkedHashMap<String, Object> errorDetails = new LinkedHashMap<>();
        errorDetails.put(AppConstants.CERTIFICATE_NO, certificateDetails.getCertificateNumber());
        errorDetails.put(AppConstants.APPROVAL_DATE, DateUtil.toString(certificateDetails.getVisaApprovalDate()));
        errorDetails.put(AppConstants.EXPIRY_DATE, DateUtil.toString(certificateDetails.getExpiryDate()));
        return errorDetails;
    }

    public Date getExtendedExpiryDate(String productId) {
        UdsProduct product = CommonConfig.getProduct(productId);
        if (product != null) { return product.extendDate(this.visaExpirationDate); }
        return this.visaExpirationDate;
    }
}

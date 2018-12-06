package com.beyontec.mol.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "IDS_CLM_DTLS")
@EntityListeners(AuditingEntityListener.class)
public class Claim {

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

	@Id
	@Column(name = "ICD_SGS_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sgs_id_generator")
    @SequenceGenerator(name = "sgs_id_generator", sequenceName = " SEQ_ICD_SGS_ID_01", allocationSize = 1)
	private Long sgsId;

	@Column(name = "ICD_COMP_ID")
	private String companyId;
	
	@Column(name = "ICD_CERT_NO")
	private String certificateNo;

	@Column(name = "ICD_TYP")
	private String codifiedType;

	@Column(name = "ICD_CMPLNT_NO")
	private String complaintNumber;

	@Column(name = "ICD_EMPL_NAME")
	private String employerName;

	@Column(name = "ICD_EMPL_LICN_NO")
	private String employerLicenseNo;

	@Column(name = "ICD_LOSSD")
    private Date claimLossDate;

	@Column(name = "ICD_EMIRATES_ID")
	private String emiratesId;

	@Column(name = "ICD_VISA_REF_NO")
	private String visaReferenceNo;

	@Column(name = "ICD_CLM_RSN")
	private String claimReason;

	@Column(name = "ICD_CLM_DESC")
	private String claimDescription;

	@Column(name = "ICD_LOSS_TYP")
	private String claimPaymentType;

	@Column(name = "ICD_PAYEE_TYP")
	private String payeeType;

	@Column(name = "ICD_PAY_AMT")
    private Double paymentAmount;

	@Column(name = "ICD_PAYEE_PHONE")
	private String payeePhoneNumber;

	@Column(name = "ICD_PAYEE_EMAIL")
	private String payeeEmail;

	@Column(name = "ICD_STATUS")
	private String claimStatus;

	@Column(name = "ICD_ERR_TYP")
	private String errorType;

	@Column(name = "ICD_ERR_ID")
	private String errorId;

	@Column(name = "ICD_ERR_MSG")
	private String errorMessage;

	@Column(name = "ICD_CRD")
	private Date requestIncomingDate;

	@Column(name = "ICD_CRIP")
	private String requestIncomingIp;

	@Column(name = "ICD_RESP_ID")
	private String respondeId;

	@Column(name = "ICD_RESP_MSG")
	private String responseMessage;

	@Column(name = "ICD_RESPD")
	private Date responseDate;

	@Column(name = "ICD_CLM_RSN_2")
	private String claimReason2;

	@Column(name = "ICD_GROUP_ID")
	private String groupId;

	@Column(name = "ICD_REMARKS")
	private String remarks;

	public String getClaimReason2() {
		return claimReason2;
	}

	public void setClaimReason2(String claimReason2) {
		this.claimReason2 = claimReason2;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public Long getSgsId() {
		return sgsId;
	}

	public void setSgsId(Long sgsId) {
		this.sgsId = sgsId;
	}

	public String getCodifiedType() {
		return codifiedType;
	}

	public void setCodifiedType(String codifiedType) {
		this.codifiedType = codifiedType;
	}

	public String getComplaintNumber() {
		return complaintNumber;
	}

	public void setComplaintNumber(String complaintNumber) {
		this.complaintNumber = complaintNumber;
	}

	public String getEmployerName() {
		return employerName;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

    public Date getClaimLossDate() {
        return claimLossDate;
    }

    public void setClaimLossDate(Date claimLossDate) {
        this.claimLossDate = claimLossDate;
    }

    public String getEmiratesId() {
		return emiratesId;
	}

	public void setEmiratesId(String emiratesId) {
		this.emiratesId = emiratesId;
	}

	public String getVisaReferenceNo() {
		return visaReferenceNo;
	}

	public void setVisaReferenceNo(String visaReferenceNo) {
		this.visaReferenceNo = visaReferenceNo;
	}

	public String getClaimReason() {
		return claimReason;
	}

	public void setClaimReason(String claimReason) {
		this.claimReason = claimReason;
	}

	public String getClaimDescription() {
		return claimDescription;
	}

	public void setClaimDescription(String claimDescription) {
		this.claimDescription = claimDescription;
	}

	public String getPayeeType() {
		return payeeType;
	}

	public void setPayeeType(String payeeType) {
		this.payeeType = payeeType;
	}

	public String getPayeePhoneNumber() {
		return payeePhoneNumber;
	}

	public void setPayeePhoneNumber(String payeePhoneNumber) {
		this.payeePhoneNumber = payeePhoneNumber;
	}

	public String getPayeeEmail() {
		return payeeEmail;
	}

	public void setPayeeEmail(String payeeEmail) {
		this.payeeEmail = payeeEmail;
	}

	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
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

	public Date getRequestIncomingDate() {
		return requestIncomingDate;
	}

	public void setRequestIncomingDate(Date requestIncomingDate) {
		this.requestIncomingDate = requestIncomingDate;
	}

	public String getRequestIncomingIp() {
		return requestIncomingIp;
	}

	public void setRequestIncomingIp(String requestIncomingIp) {
		this.requestIncomingIp = requestIncomingIp;
	}

	public String getRespondeId() {
		return respondeId;
	}

	public void setRespondeId(String respondeId) {
		this.respondeId = respondeId;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public Date getResponseDate() {
		return responseDate;
	}

	public void setResponseDate(Date responseDate) {
		this.responseDate = responseDate;
	}

	public String getEmployerLicenseNo() {
		return employerLicenseNo;
	}

	public void setEmployerLicenseNo(String employerLicenseNo) {
		this.employerLicenseNo = employerLicenseNo;
	}

	public String getClaimPaymentType() {
		return claimPaymentType;
	}

	public void setClaimPaymentType(String claimPaymentType) {
		this.claimPaymentType = claimPaymentType;
	}

    public Double getPaymentAmount() {
		return paymentAmount;
	}

    public void setPaymentAmount(Double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getCertificateNo() {
		return certificateNo;
	}

	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo;
	}
	
}
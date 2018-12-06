package com.beyontec.mol.modal;

import org.hibernate.validator.constraints.NotBlank;

public class ClaimDTO {

	@NotBlank
	private String complaintNumber;

	@NotBlank
	private String employerName;

	@NotBlank
	private String employerLicenseNo;

    private String claimLaunchDate;

	private String emiratesId;

	private String visaReferenceNo;
	
	@NotBlank
	private String certificateNo;

	@NotBlank
	private String claimReason;

	private String claimReason2;

	@NotBlank
	private String claimDescription;

	@NotBlank
	private String claimPaymentType;

	@NotBlank
	private String payeeType;

	@NotBlank
	private String paymentAmount;

	@NotBlank
	private String payeePhoneNumber;

	@NotBlank
	private String payeeEmail;

	private String groupId;

	private String remarks;
	

	public String getCertificateNo() {
		return certificateNo;
	}

	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo;
	}

    public String getClaimLaunchDate() {
        return claimLaunchDate;
    }

    public void setClaimLaunchDate(String claimLaunchDate) {
        this.claimLaunchDate = claimLaunchDate;
    }

    public String getEmployerName() {
		return employerName;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

	public String getComplaintNumber() {
		return complaintNumber;
	}

	public void setComplaintNumber(String complaintNumber) {
		this.complaintNumber = complaintNumber;
	}

	public String getEmployerLicenseNo() {
		return employerLicenseNo;
	}

	public void setEmployerLicenseNo(String employerLicenseNo) {
		this.employerLicenseNo = employerLicenseNo;
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

	public String getClaimPaymentType() {
		return claimPaymentType;
	}

	public void setClaimPaymentType(String claimPaymentType) {
		this.claimPaymentType = claimPaymentType;
	}

	public String getClaimReason2() {
		return claimReason2;
	}

	public void setClaimReason2(String claimReason2) {
		this.claimReason2 = claimReason2;
	}

	public String getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(String paymentAmount) {
		this.paymentAmount = paymentAmount;
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

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getPayeeEmail() {
		return payeeEmail;
	}

	public void setPayeeEmail(String payeeEmail) {
		this.payeeEmail = payeeEmail;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}

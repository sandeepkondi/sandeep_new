package com.beyontec.mol.modal;

import java.util.Date;

import com.beyontec.mol.util.CustomDateDeserializer;
import com.beyontec.mol.util.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class CertificateDTO {

	@Override
	public String toString() {
		return "Certificate [workerNameEn=" + workerNameEn + ", workerNameAr=" + workerNameAr + ", dateOfBirth="
				+ dateOfBirth + ", gender=" + gender + ", nationality=" + nationality + ", countryOfBirth="
				+ countryOfBirth + ", passportType=" + passportType + ", passportNo=" + passportNo + ", maritalStatus="
				+ maritalStatus + ", employeeCategory=" + employeeCategory + ", labourReferenceNo=" + labourReferenceNo
				+ ", visaApprovalDate=" + visaApprovalDate + ", visaExpirationDate=" + visaExpirationDate + ", salary="
				+ salary + ", emiratesId=" + emiratesId + ", employerLicenseNo=" + employerLicenseNo
				+ ", employerNameEn=" + employerNameEn + ", employerNameAr=" + employerNameAr
				+ ", establishmentClassfication=" + establishmentClassfication + ", industry=" + industry
				+ ", establishmentCardNo=" + establishmentCardNo + ", documentPath=" + documentPath + "]";
	}

	private String workerNameEn;

	private String workerNameAr;

	@JsonSerialize(using = CustomDateSerializer.class)
	@JsonDeserialize(using = CustomDateDeserializer.class)
	private Date dateOfBirth;

	private String gender;

	private String nationality;

	private String countryOfBirth;

	private String passportType;

	private String passportNo;

	private String maritalStatus;

	private String employeeCategory;

	private String labourReferenceNo;

	@JsonSerialize(using = CustomDateSerializer.class)
	@JsonDeserialize(using = CustomDateDeserializer.class)
	private Date visaApprovalDate;

	@JsonSerialize(using = CustomDateSerializer.class)
	@JsonDeserialize(using = CustomDateDeserializer.class)
	private Date visaExpirationDate;

    private String salary;

	private String emiratesId;

	private String employerLicenseNo;

	private String employerNameEn;

	private String employerNameAr;

	private String establishmentClassfication;

	private String industry;

	private String establishmentCardNo;

	private String documentPath;

	private String mohreJobId;

	private String enscoJobId;

	private String fileNo;

	private String previousPolicyNo;

	private String transactionType;

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

	public String getLabourReferenceNo() {
		return labourReferenceNo;
	}

	public void setLabourReferenceNo(String labourReferenceNo) {
		this.labourReferenceNo = labourReferenceNo;
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

    public String getSalary() {
		return salary;
	}

    public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getEmiratesId() {
		return emiratesId;
	}

	public void setEmiratesId(String emiratesId) {
		this.emiratesId = emiratesId;
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

	public String getFileNo() {
		return fileNo;
	}

	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
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
}
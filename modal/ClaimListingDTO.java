package com.beyontec.mol.modal;

import java.util.Date;

import com.beyontec.mol.util.CustomDateDeserializer;
import com.beyontec.mol.util.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class ClaimListingDTO {

	private String claimNo;
	private String certificateNo;
	private String emiratesId;
	private String batchNo;
    @JsonSerialize(using = CustomDateSerializer.class) @JsonDeserialize(using = CustomDateDeserializer.class)
	private Date claimLaunchDate;
	private String employee;
	private String employeeType;
	private String employerName;
	private String claimStatus;
	
	public String getClaimNo() {
		return claimNo;
	}

	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}

	public String getCertificateNo() {
		return certificateNo;
	}

	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo;
	}

	public String getEmiratesId() {
		return emiratesId;
	}

	public void setEmiratesId(String emiratesId) {
		this.emiratesId = emiratesId;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public Date getClaimLaunchDate() {
		return claimLaunchDate;
	}

	public void setClaimLaunchDate(Date claimLaunchDate) {
		this.claimLaunchDate = claimLaunchDate;
	}

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

	public String getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}

	public String getEmployerName() {
		return employerName;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	@Override
	public String toString() {
		return "ClaimListingDTO [claimNo=" + claimNo + ", certificateNo=" + certificateNo + ", emiratesId=" + emiratesId
				+ ", batchNo=" + batchNo + ", claimLaunchDate=" + claimLaunchDate + ", employee=" + employee
				+ ", employeeType=" + employeeType + ", employerName=" + employerName + ", claimStatus=" + claimStatus
				+ "]";
	}

}

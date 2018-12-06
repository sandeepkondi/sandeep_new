package com.beyontec.mol.modal;

import java.util.Date;

import com.beyontec.mol.util.CustomDateDeserializer;
import com.beyontec.mol.util.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class ClaimDetails {

	private String claimNo;
	private String certificateNo;
	private String insuredName;
	private String sponsorName;
	private String ClaimStatus;

	@JsonSerialize(using = CustomDateSerializer.class)
	@JsonDeserialize(using = CustomDateDeserializer.class)
	private Date lossDate;

	@JsonSerialize(using = CustomDateSerializer.class)
	@JsonDeserialize(using = CustomDateDeserializer.class)
	private Date createdDate;
	private String productName;

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

	public String getInsuredName() {
		return insuredName;
	}

	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}

	public String getSponsorName() {
		return sponsorName;
	}

	public void setSponsorName(String sponsorName) {
		this.sponsorName = sponsorName;
	}

	public String getClaimStatus() {
		return ClaimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		ClaimStatus = claimStatus;
	}

	public Date getLossDate() {
		return lossDate;
	}

	public void setLossDate(Date lossDate) {
		this.lossDate = lossDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
}

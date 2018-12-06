package com.beyontec.mol.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CTDS_LEVEL_SP")
public class ClaimPaymentParty {

	@Id
	@Column(name = "CLSP_CLS_SGS_ID")
	private Long settlementSgsId;
	@Column(name = "CLSP_CLF_SGS_ID")
	private Long fnolSgsId;
	@Column(name = "CLSP_CLE_SGS_ID")
	private Long estimateSgsId;
	@Column(name = "CLSP_PAYEE_NAME")
	private String payeeName;
	@Column(name = "CLSP_PAYEE_ENT_TYP")
	private String payeeEntryType;
	@Column(name = "CLSP_MAIN_PAYEE")
	private String mainPayeeYN;
	@Column(name = "CLSP_DISP_ORD_NO")
	private int displayOrderNo;
	@Column(name = "CLSP_PAY_OPTION")
	private String paymentOption;
	@Column(name = "CLSP_CUST_TYP")
	private String customerType;
	@Column(name = "CLSP_ADDRESS1")
	private String address1;
	@Column(name = "CLSP_ADDRESS2")
	private String address2;
	@Column(name = "CLSP_ADDRESS3")
	private String address3;
	@Column(name = "CLSP_ADDRESS4")
	private String address;
	@Column(name = "CLSP_PIN_CODE")
	private String pincode;
	@Column(name = "CLSP_CITY")
	private String city;
	@Column(name = "CLSP_STATE")
	private String state;
	@Column(name = "CLSP_COUNTRY_ID")
	private String countryId;
	@Column(name = "CLSP_SSN_ID")
	private String CLSP_SSN_ID;
	@Column(name = "CLSP_PAYEE_ID")
	private String payeeId;
	@Column(name = "CLSP_COMP_ID")
	private String companyId;

	public Long getSettlementSgsId() {
		return settlementSgsId;
	}

	public void setSettlementSgsId(Long settlementSgsId) {
		this.settlementSgsId = settlementSgsId;
	}

	public Long getFnolSgsId() {
		return fnolSgsId;
	}

	public void setFnolSgsId(Long fnolSgsId) {
		this.fnolSgsId = fnolSgsId;
	}

	public Long getEstimateSgsId() {
		return estimateSgsId;
	}

	public void setEstimateSgsId(Long estimateSgsId) {
		this.estimateSgsId = estimateSgsId;
	}

	public String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}

	public String getPayeeEntryType() {
		return payeeEntryType;
	}

	public void setPayeeEntryType(String payeeEntryType) {
		this.payeeEntryType = payeeEntryType;
	}

	public String getMainPayeeYN() {
		return mainPayeeYN;
	}

	public void setMainPayeeYN(String mainPayeeYN) {
		this.mainPayeeYN = mainPayeeYN;
	}

	public int getDisplayOrderNo() {
		return displayOrderNo;
	}

	public void setDisplayOrderNo(int displayOrderNo) {
		this.displayOrderNo = displayOrderNo;
	}

	public String getPaymentOption() {
		return paymentOption;
	}

	public void setPaymentOption(String paymentOption) {
		this.paymentOption = paymentOption;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getCLSP_SSN_ID() {
		return CLSP_SSN_ID;
	}

	public void setCLSP_SSN_ID(String cLSP_SSN_ID) {
		CLSP_SSN_ID = cLSP_SSN_ID;
	}

	public String getPayeeId() {
		return payeeId;
	}

	public void setPayeeId(String payeeId) {
		this.payeeId = payeeId;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

}

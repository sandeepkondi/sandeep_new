package com.beyontec.mol.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CTDS_LEVEL_C")
public class ClaimTransactionClaim {

	@Id
	@Column(name = "CLC_CLF_SGS_ID")
	private Long fnolSgsId;

	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "CLC_CLF_SGS_ID")
	private ClaimTransactionFNOL fnol;

	@Column(name = "CLC_NO", nullable = false)
	private String claimNo;

	@Column(name = "CLC_CLF_NO")
	private String fnolNo;

	@Column(name = "CLC_CID")
	private Date claimIntimationDate;

	@Column(name = "CLC_CLD")
	private Date lossDate;

	@Column(name = "CLC_CDD")
	private Date discoveryDate;

	@Column(name = "CLC_LOSS_DESC")
	private String lossDescription;

	@Column(name = "CLC_ULM_SGS_ID")
	private int policySgsId;

	@Column(name = "CLC_ULM_NO")
	private String policyNo;

	@Column(name = "CLC_STATUS")
	private String claimStatus;

	@Column(name = "CLC_CUST_ID")
	private String customerId;

	@Column(name = "CLC_PROD_ID")
	private String productId;

	@Column(name = "CLC_LOSS_LOC")
	private String lossLocation;

	@Column(name = "CLC_CLOSE_YN")
	private String closeYN;

	@Column(name = "CLC_CLOSE_RSN_ID")
	private String closeReasonId;

	@Column(name = "CLC_CLOSE_RSN_REMARKS")
	private String closeReasonRemarks;

	private String CLC_TP_TYP;
	private String CLC_TL_TYP;
	private String CLC_CAT_CODE;
	private String CLC_CAT_NUMBER;
	@Column(name = "CLC_CRU")
	private String createdUser;

	@Column(name = "CLC_CRD")
	private Date createdDate;

	@Column(name = "CLC_HANDLER_ID")
	private String userLoginId;

	private String CLC_SPL_ACCESS_YN;

	@Column(name = "CLC_LEGAL_YN")
	private String litigation;

	private int CLC_LINK_REF_ID;
	private String CLC_AUTH_REP_RECD;
	private String CLC_AUTH_REP_ORDD;
	private Date CLC_CATD;
	private String CLC_AUTH_REP_NO;
	private String CLC_CLOS_REOP_TYP;
	private int CLC_XS_AMT;
	private String CLC_XS_REC_YN;
	private String CLC_REP_DIVN_ID;
	private String CLC_INS_FAULT_YN;

	@Column(name = "CLC_POLICE_ID")
	private String policeId;

	private String CLC_ACC_TYP_DESC;

	@Column(name = "CLC_COINS_FLAG")
	private String coInsuranceFlag;

	private String CLC_CAUSE_OF_ACC;
	private String CLC_INS_CLM_NO;
	private Date CLC_CIID;

	@Column(name = "CLC_GROUP_ID")
	private String groupId;

	@Column(name = "CLC_CLM_REASON_2")
	private String claimReason2;

	@Column(name = "CLC_REMARKS")
	private String remarks;

	public ClaimTransactionFNOL getFnol() {
		return fnol;
	}

	public void setFnol(ClaimTransactionFNOL fnol) {
		this.fnol = fnol;
	}

	@Column(name = "CLC_COMP_ID")
	private String companyId;

	@Column(name = "CLC_DIVN_ID")
	private String divisionId;

	@Column(name = "CLC_DEPT_ID")
	private String departmentId;

	private String CLC_CED_CLM_REF;

	@Column(name = "CLC_CLM_REASON")
	private String claimReason;

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getClaimReason2() {
		return claimReason2;
	}

	public void setClaimReason2(String claimReason2) {
		this.claimReason2 = claimReason2;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Long getFnolSgsId() {
		return fnolSgsId;
	}

	public void setFnolSgsId(Long fnolSgsId) {
		this.fnolSgsId = fnolSgsId;
	}

	public String getClaimNo() {
		return claimNo;
	}

	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}

	public String getFnolNo() {
		return fnolNo;
	}

	public void setFnolNo(String fnolNo) {
		this.fnolNo = fnolNo;
	}

	public Date getClaimIntimationDate() {
		return claimIntimationDate;
	}

	public void setClaimIntimationDate(Date claimIntimationDate) {
		this.claimIntimationDate = claimIntimationDate;
	}

	public Date getLossDate() {
		return lossDate;
	}

	public void setLossDate(Date lossDate) {
		this.lossDate = lossDate;
	}

	public Date getDiscoveryDate() {
		return discoveryDate;
	}

	public void setDiscoveryDate(Date discoveryDate) {
		this.discoveryDate = discoveryDate;
	}

	public String getLossDescription() {
		return lossDescription;
	}

	public void setLossDescription(String lossDescription) {
		this.lossDescription = lossDescription;
	}

	public int getPolicySgsId() {
		return policySgsId;
	}

	public void setPolicySgsId(int policySgsId) {
		this.policySgsId = policySgsId;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getLossLocation() {
		return lossLocation;
	}

	public void setLossLocation(String lossLocation) {
		this.lossLocation = lossLocation;
	}

	public String getCloseYN() {
		return closeYN;
	}

	public void setCloseYN(String closeYN) {
		this.closeYN = closeYN;
	}

	public String getCloseReasonId() {
		return closeReasonId;
	}

	public void setCloseReasonId(String closeReasonId) {
		this.closeReasonId = closeReasonId;
	}

	public String getCloseReasonRemarks() {
		return closeReasonRemarks;
	}

	public void setCloseReasonRemarks(String closeReasonRemarks) {
		this.closeReasonRemarks = closeReasonRemarks;
	}

	public String getCLC_TP_TYP() {
		return CLC_TP_TYP;
	}

	public void setCLC_TP_TYP(String cLC_TP_TYP) {
		CLC_TP_TYP = cLC_TP_TYP;
	}

	public String getCLC_TL_TYP() {
		return CLC_TL_TYP;
	}

	public void setCLC_TL_TYP(String cLC_TL_TYP) {
		CLC_TL_TYP = cLC_TL_TYP;
	}

	public String getCLC_CAT_CODE() {
		return CLC_CAT_CODE;
	}

	public void setCLC_CAT_CODE(String cLC_CAT_CODE) {
		CLC_CAT_CODE = cLC_CAT_CODE;
	}

	public String getCLC_CAT_NUMBER() {
		return CLC_CAT_NUMBER;
	}

	public void setCLC_CAT_NUMBER(String cLC_CAT_NUMBER) {
		CLC_CAT_NUMBER = cLC_CAT_NUMBER;
	}

	public String getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getUserLoginId() {
		return userLoginId;
	}

	public void setUserLoginId(String userLoginId) {
		this.userLoginId = userLoginId;
	}

	public String getCLC_SPL_ACCESS_YN() {
		return CLC_SPL_ACCESS_YN;
	}

	public void setCLC_SPL_ACCESS_YN(String cLC_SPL_ACCESS_YN) {
		CLC_SPL_ACCESS_YN = cLC_SPL_ACCESS_YN;
	}

	public String getLitigation() {
		return litigation;
	}

	public void setLitigation(String litigation) {
		this.litigation = litigation;
	}

	public int getCLC_LINK_REF_ID() {
		return CLC_LINK_REF_ID;
	}

	public void setCLC_LINK_REF_ID(int cLC_LINK_REF_ID) {
		CLC_LINK_REF_ID = cLC_LINK_REF_ID;
	}

	public String getCLC_AUTH_REP_RECD() {
		return CLC_AUTH_REP_RECD;
	}

	public void setCLC_AUTH_REP_RECD(String cLC_AUTH_REP_RECD) {
		CLC_AUTH_REP_RECD = cLC_AUTH_REP_RECD;
	}

	public String getCLC_AUTH_REP_ORDD() {
		return CLC_AUTH_REP_ORDD;
	}

	public void setCLC_AUTH_REP_ORDD(String cLC_AUTH_REP_ORDD) {
		CLC_AUTH_REP_ORDD = cLC_AUTH_REP_ORDD;
	}

	public Date getCLC_CATD() {
		return CLC_CATD;
	}

	public void setCLC_CATD(Date cLC_CATD) {
		CLC_CATD = cLC_CATD;
	}

	public String getCLC_AUTH_REP_NO() {
		return CLC_AUTH_REP_NO;
	}

	public void setCLC_AUTH_REP_NO(String cLC_AUTH_REP_NO) {
		CLC_AUTH_REP_NO = cLC_AUTH_REP_NO;
	}

	public String getCLC_CLOS_REOP_TYP() {
		return CLC_CLOS_REOP_TYP;
	}

	public void setCLC_CLOS_REOP_TYP(String cLC_CLOS_REOP_TYP) {
		CLC_CLOS_REOP_TYP = cLC_CLOS_REOP_TYP;
	}

	public int getCLC_XS_AMT() {
		return CLC_XS_AMT;
	}

	public void setCLC_XS_AMT(int cLC_XS_AMT) {
		CLC_XS_AMT = cLC_XS_AMT;
	}

	public String getCLC_XS_REC_YN() {
		return CLC_XS_REC_YN;
	}

	public void setCLC_XS_REC_YN(String cLC_XS_REC_YN) {
		CLC_XS_REC_YN = cLC_XS_REC_YN;
	}

	public String getCLC_REP_DIVN_ID() {
		return CLC_REP_DIVN_ID;
	}

	public void setCLC_REP_DIVN_ID(String cLC_REP_DIVN_ID) {
		CLC_REP_DIVN_ID = cLC_REP_DIVN_ID;
	}

	public String getCLC_INS_FAULT_YN() {
		return CLC_INS_FAULT_YN;
	}

	public void setCLC_INS_FAULT_YN(String cLC_INS_FAULT_YN) {
		CLC_INS_FAULT_YN = cLC_INS_FAULT_YN;
	}

	public String getPoliceId() {
		return policeId;
	}

	public void setPoliceId(String policeId) {
		this.policeId = policeId;
	}

	public String getCLC_ACC_TYP_DESC() {
		return CLC_ACC_TYP_DESC;
	}

	public void setCLC_ACC_TYP_DESC(String cLC_ACC_TYP_DESC) {
		CLC_ACC_TYP_DESC = cLC_ACC_TYP_DESC;
	}

	public String getCoInsuranceFlag() {
		return coInsuranceFlag;
	}

	public void setCoInsuranceFlag(String coInsuranceFlag) {
		this.coInsuranceFlag = coInsuranceFlag;
	}

	public String getCLC_CAUSE_OF_ACC() {
		return CLC_CAUSE_OF_ACC;
	}

	public void setCLC_CAUSE_OF_ACC(String cLC_CAUSE_OF_ACC) {
		CLC_CAUSE_OF_ACC = cLC_CAUSE_OF_ACC;
	}

	public String getCLC_INS_CLM_NO() {
		return CLC_INS_CLM_NO;
	}

	public void setCLC_INS_CLM_NO(String cLC_INS_CLM_NO) {
		CLC_INS_CLM_NO = cLC_INS_CLM_NO;
	}

	public Date getCLC_CIID() {
		return CLC_CIID;
	}

	public void setCLC_CIID(Date cLC_CIID) {
		CLC_CIID = cLC_CIID;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(String divisionId) {
		this.divisionId = divisionId;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getCLC_CED_CLM_REF() {
		return CLC_CED_CLM_REF;
	}

	public void setCLC_CED_CLM_REF(String cLC_CED_CLM_REF) {
		CLC_CED_CLM_REF = cLC_CED_CLM_REF;
	}

	public String getClaimReason() {
		return claimReason;
	}

	public void setClaimReason(String claimReason) {
		this.claimReason = claimReason;
	}

}

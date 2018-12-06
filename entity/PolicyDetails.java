package com.beyontec.mol.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "UTDS_LEVEL_M")
@EntityListeners(AuditingEntityListener.class)
public class PolicyDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/*
	 * @OneToMany(fetch = FetchType.LAZY, mappedBy = "policy") private
	 * Set<RiskDetails> risk;
	 * 
	 * @OneToMany(fetch = FetchType.LAZY, mappedBy = "policy") private Set<Coverage>
	 * coverage;
	 */

	private String ULM_TYP;
	private String ULM_NO;
	private String ULM_PRV_LINK_NO;
	private String ULM_PRV_LINK_VER_NO;
	private String ULM_LVL1_NO;
	private String ULM_LVL1_ITR_NO;
	private String ULM_LVL2_NO;
	private String ULM_LVL2_ITR_NO;
	private String ULM_COMP_ID;
	// private String ULM_DIVN_ID;
	@Column(name = "ULM_DIVN_ID")
	private String division;

	// private String ULM_DEPT_ID;
	@Column(name = "ULM_DEPT_ID")
	private String department;

	// private String ULM_PROD_ID;
	@Column(name = "ULM_PROD_ID")
	private String productType;

	private String ULM_ISSUE_DATE;
	private String ULM_FMD;
	private String ULM_TOD;
	private String ULM_PERIOD_UNIT;
	private String ULM_PERIOD;
	private String ULM_VALID_DAYS;
	private String ULM_PREM_CALC_TYP;
	private String ULM_AGENT_ID;
	private String ULM_BSRC_ID;
	private String ULM_BTYP_ID;
	private String ULM_STATUS;
	private String ULM_AMND_NO;
	private String ULM_AMND_VER_NO;
	private String ULM_CUST_ID;
	private String ULM_ADDR_REF_ID;
	private String ULM_CONT_REF_ID;
	private String ULM_INSRD_ID;
	private String ULM_INSRD_NAME;
	private String ULM_CVR_NOTE_NO;
	private String ULM_CVR_NOTE_DATE;
	private String ULM_CVR_NOTE_BOOK_ID;
	private String ULM_OP_POL_NO;
	private String ULM_PRV_POL_NO;
	private String ULM_REC_TYP;
	private String ULM_CUST_ACC_ID;
	private String ULM_SGS_ID;
	private String ULM_ITR_NO;
	private String ULM_ITR_VER_NO;
	private String ULM_PERIOD_TYP;
	private String ULM_CUST_PRV_ADD_YRS;
	private String ULM_PAYOR_ID;
	private String ULM_PAYOR_ADDR_REF_ID;
	private String ULM_BILL_TYP;
	private String ULM_UI_INST_ID;
	private String ULM_PAYOR_TYP;
	private String ULM_APD;
	private String ULM_PRV_INSURED_YN;
	private String ULM_PRV_INSURED_NAME;
	private String ULM_TERM;
	private String ULM_CRU;
	private String ULM_CRD;
	private String ULM_PRIORITY;
	private String ULM_DUE_ON;
	private String ULM_AC_PROC_YN;
	private String ULM_AMND_TYP;
	private String ULM_AMND_SUB_TYP;
	private String ULM_AMND_FMD;
	private String ULM_AMND_TOD;
	private String ULM_AMND_REMARKS;
	private String ULM_CUST_TYP;
	private String ULM_LVL1_SGS_ID;
	private String ULM_LVL2_SGS_ID;
	private String ULM_LVL3_SGS_ID;
	private String ULM_LVL3_NO;
	private String ULM_SRC_SGS_ID;
	private String ULM_SRS_AMND_VER_NO;
	private String ULM_LVL3_ITR_NO;
	private String ULM_SRC_AMND_VER_NO;
	private String ULM_CRU_ROLE;
	private String ULM_REN_SEQ_NO;
	private String ULM_FLT_YN;
	private String ULM_OSE_AMND_VER_NO;
	private String ULM_OSE_YN;
	private String ULM_OSE_ORD_NO;
	private String ULM_OSE_REF_SGS_ID;
	private String ULM_PRM_CURR;
	private String ULM_PRM_CURR_ID;
	private String ULM_PRM_CURR_X_RATE;
	private String ULM_MST_REF_NO;
	private String ULM_MST_REF_SGS_ID;
	private String ULM_MST_REF_AMND_VER_NO;
	private String ULM_AMND_RSN;
	private String ULM_CARRIER_ID;
	private String ULM_TMPL_TYP;
	private String ULM_TMPL_ID;
	private String ULM_CANCEL_PC_TYP;
	private String ULM_LVL1_TYP;
	private String ULM_LVL2_TYP;
	private String ULM_EXPD;
	private String ULM_RATE_LVL;
	private String ULM_COMM_CURR_ID;
	private String ULM_COMM_CURR;
	private String ULM_CANCEL_DT;
	private String ULM_REINS_DT;
	private String ULM_FCL;
	private String ULM_FCL_BC;
	private String ULM_EQ_TYP;
	private String ULM_DEP_PREM;
	private String ULM_DEP_PREM_BC;
	private String ULM_ACNT_REF_NO;
	private String ULM_INS_POL_NO;
	private String ULM_INS_LA_NO;
	private String ULM_ENDT_INST_TYP;
	private String ULM_CARRIER_BR_ID;
	private String ULM_INSINT_DESC;
	private String ULM_POL_ACNT_YEAR;
	private String ULM_WAIVE_FEE_YN;
	private String ULM_RET_MP_YN;
	private String ULM_COVER_NOTE_TOD;
	private String ULM_APU;
	private String ULM_CARRIER_STATE;
	private String ULM_CARRIER_GRP_ID;
	private String ULM_UPLOAD_SRC;
	private String ULM_DNR_REASON;
	private String ULM_CAN_PAYEE;
	private String ULM_CRW_NO;
	private String ULM_DECL_PRD_TYP;
	private String ULM_CARRIER_ZIP_CODE;
	private String ULM_NAT_OF_BUS;
	private String ULM_CLASS_FACTOR;
	private String ULM_RATE_FRZ;
	private String ULM_SA_FACTOR;
	private String ULM_DESC1;
	private String ULM_ACCT_CUST_LVL;
	private String ULM_TTY_REQ_YN;
	private String ULM_CO_LAST_NAME;
	private String ULM_CO_FIRST_NAME;
	private String ULM_CO_MIDDLE_NAME;
	private String ULM_OR_ADDRINT_YN;
	private String ULM_ORG_TOD;
	private String ULM_REN_ORG_SGS_ID;
	private String ULM_SUB_DATE;
	private String ULM_NL_DESC;
	private String ULM_NL_FMD;
	private String ULM_NL_TOD;
	private String ULM_PPW_DAYS;
	private String ULM_BC_ID;
	private String ULM_EXP_DT_CHG;
	private String ULM_EQTY_DT;

	// private String ULM_CNAME;
	@Column(name = "ULM_CNAME")
	private String customerName;

	// private String ULM_CADDR_1;
	@Column(name = "ULM_CADDR_1")
	private String customerAddress1;

	// private String ULM_CADDR_2;

	@Column(name = "ULM_CADDR_2")
	private String customerAddress2;

	// private String ULM_CADDR_3;
	@Column(name = "ULM_CADDR_3")
	private String customerAddress3;

	// private String ULM_CADDR_4;
	@Column(name = "ULM_CADDR_4")
	private String customerAddress4;

	private String ULM_CCITY;
	private String ULM_CSTATE;
	private String ULM_CCOUNTRY;
	private String ULM_REN_PAYOR_TYP;
	private String ULM_ACNT_REF2_NO;
	private String ULM_REN_PAYOR_ID;
	private String ULM_INT_SHARE_PERC;
	private String ULM_BAT_ID;
	private String ULM_SHARE_PERC;
	private String ULM_L1_AGT_ID;
	private String ULM_L2_AGT_ID;
	private String ULM_L3_AGT_ID;
	private String ULM_L4_AGT_ID;
	private String ULM_L5_AGT_ID;
	private String ULM_PERIOD_CATG_TYP;
	private String ULM_PERIOD_MONTHS;
	private String ULM_PERIOD_DAYS;
	private String ULM_SUB_STATUS;
	private String ULM_RISK_TYP;
	private String ULM_CFIRST_NAME;
	private String ULM_CMIDDLE_NAME;
	private String ULM_CLAST_NAME;
	private String ULM_INSR_HO_YN;
	private String ULM_PRE_DISC_YN;
	private String ULM_EFT_DISC_YN;
	private String ULM_PRIOR_DISC_YN;
	private String ULM_PROG_TYP;
	private String ULM_CO_APPL_YN;
	private String ULM_CO_INSR_YN;
	private String ULM_NAMED_NON_OW_YN;
	private String ULM_INSR_SUFFIX;
	private String ULM_CO_SUFFIX;
	private String ULM_PD_FUL_DISC_YN;
	private String ULM_REIN_FEE_YN;
	private String ULM_MAN_REN_YN;
	private String ULM_REN_DISC_YN;
	private String ULM_DEP_PREM_YN;
	private String ULM_FLAT_CAN_YN;
	private String ULM_FLEX_01;
	private String ULM_FLEX_02;
	private String ULM_FLEX_03;
	private String ULM_FLEX_04;
	private String ULM_FLEX_05;
	private String ULM_RISK_ADD_1;
	private String ULM_RISK_ADD_2;
	private String ULM_RISK_ADD_3;
	private String ULM_RISK_ADD_4;
	private String ULM_RISK_PIN_CODE;
	private String ULM_RISK_CITY;
	private String ULM_RISK_STATE;
	private String ULM_RISK_COUNTRY;
	private String ULM_RSK_ADD_SAME_YN;
	private String ULM_PREFIX_NAME;
	private String ULM_PREFIX_NAME_BL;
	private String ULM_CNAME_BL;
	private String ULM_CFIRST_NAME_BL;
	private String ULM_CLAST_NAME_BL;
	private String ULM_REN_TPI_STS;
	private String ULM_CPY_PHONE_NO;
	private String ULM_CPY_MOBILE_NO;
	private String ULM_CFAX_NO;
	private String ULM_CPY_EMAIL_ID;
	private String ULM_CR_LEVEL;
	private String ULM_CR_EXP_ALLOWED;
	private String ULM_PUN_DMG_YN;
	private String ULM_ESIGN_NO;
	private String ULM_NATIONALITY;
	private String ULM_OCCUPATION;
	private String ULM_O_CUST_ID;
	private String ULM_CWK_PHONE_NO;
	private String ULM_POST_DOC;
	private String ULM_QUOT_COND_ACCEPT_YN;
	private String ULM_POL_SRC;
	private String ULM_PRV_EXP_DT;
	private String ULM_HOME_TYP;
	private String ULM_CADDR_5;
	private String ULM_PDOACM_YN;
	private String ULM_LBOACM_YN;
	private String ULM_RATE_DATE;
	private String ULM_CUST_DESC;
	private String ULM_AC_SCORE;
	private String ULM_DNR_REMARKS;
	private String ULM_EPRINT_YN;
	private String ULM_REMARKS_BL_YN;
	private String ULM_FRCOMP_ID;
	private String ULM_REFF_YN;
	private String ULM_DECL_USR;
	private String ULM_DECL_DT;
	private String ULM_REN_POL_NO;
	private String ULM_AGT_ADDR_1;
	private String ULM_AGT_ADDR_2;
	private String ULM_AGT_ADDR_3;
	private String ULM_AGT_ADDR_4;
	private String ULM_AGT_PIN_CODE;
	private String ULM_AGT_CITY;
	private String ULM_AGT_STATE;
	private String ULM_AGT_COUNTRY;
	private String ULM_AGT_PHONE_NO;
	private String ULM_COINS_FLAG;
	private String ULM_SI_CURR;
	private String ULM_SI_CURR_ID;
	private String ULM_PREM;
	private String ULM_PREM_BC;
	private String ULM_SI_X_RATE;
	private String ULM_SI_LIMIT;
	private String ULM_SI_LIMIT_BC;
	private String ULM_NB_TYP;
	private String ULM_COMM_X_RATE;
	private String ULM_COMM;
	private String ULM_COMM_BC;
	private String ULM_AE_ID;
	private String ULM_SM_ID;
	private String ULM_RISK_BUSS_DESC;
	private String ULM_RISK_OCC;
	private String ULM_RISK_OCC_DESC;
	private String ULM_RISK_COUNT;
	private String ULM_COMM_DISC_PER;
	private String ULM_COMM_DISC_RATE_PER;
	private String ULM_CUST_POL_TYP;
	private String ULM_CR_SCORE;
	private String ULM_PRV_FM_DT;
	private String ULM_INS_AMND_NO;
	private String ULM_NCF_STATUS;
	private String ULM_NCF_MSG;
	private String ULM_CCF_FLAG;
	private String ULM_FLEX_06;
	private String ULM_FLEX_07;
	private String ULM_FLEX_08;
	private String ULM_FLEX_09;
	private String ULM_FLEX_10;
	private String ULM_TLICN_NO;
	private String ULM_POC_PREFIX;
	private String ULM_POC_FNAME;
	private String ULM_POC_MNAME;
	private String ULM_POC_LNAME;
	private String ULM_POC_ADDR1;
	private String ULM_POC_ADDR2;
	private String ULM_POC_PINCODE;
	private String ULM_POC_CITY;
	private String ULM_POC_STATE;
	private String ULM_POC_COUNTRY;
	private String ULM_POC_MBL_NO;
	private String ULM_POC_PHONE_NO;
	private String ULM_POC_EMAIL;
	private String ULM_WAIVE_INSP_YN;
	private String ULM_NPT_FEE_AMT;
	private String ULM_NPT_FEE_AMT_BC;
	private String ULM_NPT_FINFEE_AMT;
	private String ULM_NPT_FINFEE_AMT_BC;
	private String ULM_NPT_COMM_AMT;
	private String ULM_NPT_COMM_AMT_BC;
	private String ULM_TOT_HOUR;
	private String ULM_ENTITY_TYP;
	private String ULM_DISCLOSURE_YN;
	private String ULM_SCHEME_TYP;
	private String ULM_AGNT_END_NO;
	private String ULM_GLOBAL_END_NO;
	private String ULM_CAN_PAY_MODE;
	private String ULM_CO_DOB;
	private String ULM_HMH_PAYPLAN;
	private String ULM_DP_DT;
	private String ULM_CO_SSN;
	private String ULM_UW_TYP;
	private String ULM_PREM_INV_TYP;
	private String ULM_SPL_ACPT_YN;
	private String ULM_POL_TYP;
	private String ULM_CUST_AGE;
	private String ULM_C_LICN_ISS_DT;
	private String ULM_C_LICN_EXP_DT;
	private String ULM_C_GENDER;
	private String ULM_C_DOB;
	private String ULM_C_IDENTIFICATION_ID1;
	private String ULM_CMIDDLE_NAME_BL;
	private String ULM_INSRD_NAME_BL;
	private String ULM_INDEM_PERD;
	private String ULM_INDEM_UNIT;
	private String ULM_PCVR_YN;
	private String ULM_DFLT_TO_INSRD;
	private String ULM_PROMO_CODE;
	private String ULM_SCHD_TEMP_TYP;
	private String ULM_SCHEME_NAME;
	private String ULM_EXISTING_CUST;
	private String ULM_SCHEME_TYPE;
	private String ULM_FLEX_15;
	private String ULM_C_IDENTIFICATION_ID2;
	private String ULM_C_IDENTIFICATION_ID3;
	private String ULM_PRV_INSR_POL_NO;
	private String ULM_CUST_VAT_TYP;
	private String ULM_CUST_VAT_YN;
	private String ULM_CUST_TAX_ID;
	private String ULM_NB_VAT_AMT;
	private String ULM_NB_VAT_AMT_BC;
	private String ULM_NB_PARTY_VAT_YN;
	private String ULM_NB_PARTY_VAT_TYP;
	private String ULM_NB_PARTY_VAT_ID;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/*
	 * public Set<RiskDetails> getRisk() { return risk; } public void
	 * setRisk(Set<RiskDetails> risk) { this.risk = risk; } public Set<Coverage>
	 * getCoverage() { return coverage; } public void setCoverage(Set<Coverage>
	 * coverage) { this.coverage = coverage; }
	 */
	public String getULM_TYP() {
		return ULM_TYP;
	}

	public void setULM_TYP(String uLM_TYP) {
		ULM_TYP = uLM_TYP;
	}

	public String getULM_NO() {
		return ULM_NO;
	}

	public void setULM_NO(String uLM_NO) {
		ULM_NO = uLM_NO;
	}

	public String getULM_PRV_LINK_NO() {
		return ULM_PRV_LINK_NO;
	}

	public void setULM_PRV_LINK_NO(String uLM_PRV_LINK_NO) {
		ULM_PRV_LINK_NO = uLM_PRV_LINK_NO;
	}

	public String getULM_PRV_LINK_VER_NO() {
		return ULM_PRV_LINK_VER_NO;
	}

	public void setULM_PRV_LINK_VER_NO(String uLM_PRV_LINK_VER_NO) {
		ULM_PRV_LINK_VER_NO = uLM_PRV_LINK_VER_NO;
	}

	public String getULM_LVL1_NO() {
		return ULM_LVL1_NO;
	}

	public void setULM_LVL1_NO(String uLM_LVL1_NO) {
		ULM_LVL1_NO = uLM_LVL1_NO;
	}

	public String getULM_LVL1_ITR_NO() {
		return ULM_LVL1_ITR_NO;
	}

	public void setULM_LVL1_ITR_NO(String uLM_LVL1_ITR_NO) {
		ULM_LVL1_ITR_NO = uLM_LVL1_ITR_NO;
	}

	public String getULM_LVL2_NO() {
		return ULM_LVL2_NO;
	}

	public void setULM_LVL2_NO(String uLM_LVL2_NO) {
		ULM_LVL2_NO = uLM_LVL2_NO;
	}

	public String getULM_LVL2_ITR_NO() {
		return ULM_LVL2_ITR_NO;
	}

	public void setULM_LVL2_ITR_NO(String uLM_LVL2_ITR_NO) {
		ULM_LVL2_ITR_NO = uLM_LVL2_ITR_NO;
	}

	public String getULM_COMP_ID() {
		return ULM_COMP_ID;
	}

	public void setULM_COMP_ID(String uLM_COMP_ID) {
		ULM_COMP_ID = uLM_COMP_ID;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getULM_ISSUE_DATE() {
		return ULM_ISSUE_DATE;
	}

	public void setULM_ISSUE_DATE(String uLM_ISSUE_DATE) {
		ULM_ISSUE_DATE = uLM_ISSUE_DATE;
	}

	public String getULM_FMD() {
		return ULM_FMD;
	}

	public void setULM_FMD(String uLM_FMD) {
		ULM_FMD = uLM_FMD;
	}

	public String getULM_TOD() {
		return ULM_TOD;
	}

	public void setULM_TOD(String uLM_TOD) {
		ULM_TOD = uLM_TOD;
	}

	public String getULM_PERIOD_UNIT() {
		return ULM_PERIOD_UNIT;
	}

	public void setULM_PERIOD_UNIT(String uLM_PERIOD_UNIT) {
		ULM_PERIOD_UNIT = uLM_PERIOD_UNIT;
	}

	public String getULM_PERIOD() {
		return ULM_PERIOD;
	}

	public void setULM_PERIOD(String uLM_PERIOD) {
		ULM_PERIOD = uLM_PERIOD;
	}

	public String getULM_VALID_DAYS() {
		return ULM_VALID_DAYS;
	}

	public void setULM_VALID_DAYS(String uLM_VALID_DAYS) {
		ULM_VALID_DAYS = uLM_VALID_DAYS;
	}

	public String getULM_PREM_CALC_TYP() {
		return ULM_PREM_CALC_TYP;
	}

	public void setULM_PREM_CALC_TYP(String uLM_PREM_CALC_TYP) {
		ULM_PREM_CALC_TYP = uLM_PREM_CALC_TYP;
	}

	public String getULM_AGENT_ID() {
		return ULM_AGENT_ID;
	}

	public void setULM_AGENT_ID(String uLM_AGENT_ID) {
		ULM_AGENT_ID = uLM_AGENT_ID;
	}

	public String getULM_BSRC_ID() {
		return ULM_BSRC_ID;
	}

	public void setULM_BSRC_ID(String uLM_BSRC_ID) {
		ULM_BSRC_ID = uLM_BSRC_ID;
	}

	public String getULM_BTYP_ID() {
		return ULM_BTYP_ID;
	}

	public void setULM_BTYP_ID(String uLM_BTYP_ID) {
		ULM_BTYP_ID = uLM_BTYP_ID;
	}

	public String getULM_STATUS() {
		return ULM_STATUS;
	}

	public void setULM_STATUS(String uLM_STATUS) {
		ULM_STATUS = uLM_STATUS;
	}

	public String getULM_AMND_NO() {
		return ULM_AMND_NO;
	}

	public void setULM_AMND_NO(String uLM_AMND_NO) {
		ULM_AMND_NO = uLM_AMND_NO;
	}

	public String getULM_AMND_VER_NO() {
		return ULM_AMND_VER_NO;
	}

	public void setULM_AMND_VER_NO(String uLM_AMND_VER_NO) {
		ULM_AMND_VER_NO = uLM_AMND_VER_NO;
	}

	public String getULM_CUST_ID() {
		return ULM_CUST_ID;
	}

	public void setULM_CUST_ID(String uLM_CUST_ID) {
		ULM_CUST_ID = uLM_CUST_ID;
	}

	public String getULM_ADDR_REF_ID() {
		return ULM_ADDR_REF_ID;
	}

	public void setULM_ADDR_REF_ID(String uLM_ADDR_REF_ID) {
		ULM_ADDR_REF_ID = uLM_ADDR_REF_ID;
	}

	public String getULM_CONT_REF_ID() {
		return ULM_CONT_REF_ID;
	}

	public void setULM_CONT_REF_ID(String uLM_CONT_REF_ID) {
		ULM_CONT_REF_ID = uLM_CONT_REF_ID;
	}

	public String getULM_INSRD_ID() {
		return ULM_INSRD_ID;
	}

	public void setULM_INSRD_ID(String uLM_INSRD_ID) {
		ULM_INSRD_ID = uLM_INSRD_ID;
	}

	public String getULM_INSRD_NAME() {
		return ULM_INSRD_NAME;
	}

	public void setULM_INSRD_NAME(String uLM_INSRD_NAME) {
		ULM_INSRD_NAME = uLM_INSRD_NAME;
	}

	public String getULM_CVR_NOTE_NO() {
		return ULM_CVR_NOTE_NO;
	}

	public void setULM_CVR_NOTE_NO(String uLM_CVR_NOTE_NO) {
		ULM_CVR_NOTE_NO = uLM_CVR_NOTE_NO;
	}

	public String getULM_CVR_NOTE_DATE() {
		return ULM_CVR_NOTE_DATE;
	}

	public void setULM_CVR_NOTE_DATE(String uLM_CVR_NOTE_DATE) {
		ULM_CVR_NOTE_DATE = uLM_CVR_NOTE_DATE;
	}

	public String getULM_CVR_NOTE_BOOK_ID() {
		return ULM_CVR_NOTE_BOOK_ID;
	}

	public void setULM_CVR_NOTE_BOOK_ID(String uLM_CVR_NOTE_BOOK_ID) {
		ULM_CVR_NOTE_BOOK_ID = uLM_CVR_NOTE_BOOK_ID;
	}

	public String getULM_OP_POL_NO() {
		return ULM_OP_POL_NO;
	}

	public void setULM_OP_POL_NO(String uLM_OP_POL_NO) {
		ULM_OP_POL_NO = uLM_OP_POL_NO;
	}

	public String getULM_PRV_POL_NO() {
		return ULM_PRV_POL_NO;
	}

	public void setULM_PRV_POL_NO(String uLM_PRV_POL_NO) {
		ULM_PRV_POL_NO = uLM_PRV_POL_NO;
	}

	public String getULM_REC_TYP() {
		return ULM_REC_TYP;
	}

	public void setULM_REC_TYP(String uLM_REC_TYP) {
		ULM_REC_TYP = uLM_REC_TYP;
	}

	public String getULM_CUST_ACC_ID() {
		return ULM_CUST_ACC_ID;
	}

	public void setULM_CUST_ACC_ID(String uLM_CUST_ACC_ID) {
		ULM_CUST_ACC_ID = uLM_CUST_ACC_ID;
	}

	public String getULM_SGS_ID() {
		return ULM_SGS_ID;
	}

	public void setULM_SGS_ID(String uLM_SGS_ID) {
		ULM_SGS_ID = uLM_SGS_ID;
	}

	public String getULM_ITR_NO() {
		return ULM_ITR_NO;
	}

	public void setULM_ITR_NO(String uLM_ITR_NO) {
		ULM_ITR_NO = uLM_ITR_NO;
	}

	public String getULM_ITR_VER_NO() {
		return ULM_ITR_VER_NO;
	}

	public void setULM_ITR_VER_NO(String uLM_ITR_VER_NO) {
		ULM_ITR_VER_NO = uLM_ITR_VER_NO;
	}

	public String getULM_PERIOD_TYP() {
		return ULM_PERIOD_TYP;
	}

	public void setULM_PERIOD_TYP(String uLM_PERIOD_TYP) {
		ULM_PERIOD_TYP = uLM_PERIOD_TYP;
	}

	public String getULM_CUST_PRV_ADD_YRS() {
		return ULM_CUST_PRV_ADD_YRS;
	}

	public void setULM_CUST_PRV_ADD_YRS(String uLM_CUST_PRV_ADD_YRS) {
		ULM_CUST_PRV_ADD_YRS = uLM_CUST_PRV_ADD_YRS;
	}

	public String getULM_PAYOR_ID() {
		return ULM_PAYOR_ID;
	}

	public void setULM_PAYOR_ID(String uLM_PAYOR_ID) {
		ULM_PAYOR_ID = uLM_PAYOR_ID;
	}

	public String getULM_PAYOR_ADDR_REF_ID() {
		return ULM_PAYOR_ADDR_REF_ID;
	}

	public void setULM_PAYOR_ADDR_REF_ID(String uLM_PAYOR_ADDR_REF_ID) {
		ULM_PAYOR_ADDR_REF_ID = uLM_PAYOR_ADDR_REF_ID;
	}

	public String getULM_BILL_TYP() {
		return ULM_BILL_TYP;
	}

	public void setULM_BILL_TYP(String uLM_BILL_TYP) {
		ULM_BILL_TYP = uLM_BILL_TYP;
	}

	public String getULM_UI_INST_ID() {
		return ULM_UI_INST_ID;
	}

	public void setULM_UI_INST_ID(String uLM_UI_INST_ID) {
		ULM_UI_INST_ID = uLM_UI_INST_ID;
	}

	public String getULM_PAYOR_TYP() {
		return ULM_PAYOR_TYP;
	}

	public void setULM_PAYOR_TYP(String uLM_PAYOR_TYP) {
		ULM_PAYOR_TYP = uLM_PAYOR_TYP;
	}

	public String getULM_APD() {
		return ULM_APD;
	}

	public void setULM_APD(String uLM_APD) {
		ULM_APD = uLM_APD;
	}

	public String getULM_PRV_INSURED_YN() {
		return ULM_PRV_INSURED_YN;
	}

	public void setULM_PRV_INSURED_YN(String uLM_PRV_INSURED_YN) {
		ULM_PRV_INSURED_YN = uLM_PRV_INSURED_YN;
	}

	public String getULM_PRV_INSURED_NAME() {
		return ULM_PRV_INSURED_NAME;
	}

	public void setULM_PRV_INSURED_NAME(String uLM_PRV_INSURED_NAME) {
		ULM_PRV_INSURED_NAME = uLM_PRV_INSURED_NAME;
	}

	public String getULM_TERM() {
		return ULM_TERM;
	}

	public void setULM_TERM(String uLM_TERM) {
		ULM_TERM = uLM_TERM;
	}

	public String getULM_CRU() {
		return ULM_CRU;
	}

	public void setULM_CRU(String uLM_CRU) {
		ULM_CRU = uLM_CRU;
	}

	public String getULM_CRD() {
		return ULM_CRD;
	}

	public void setULM_CRD(String uLM_CRD) {
		ULM_CRD = uLM_CRD;
	}

	public String getULM_PRIORITY() {
		return ULM_PRIORITY;
	}

	public void setULM_PRIORITY(String uLM_PRIORITY) {
		ULM_PRIORITY = uLM_PRIORITY;
	}

	public String getULM_DUE_ON() {
		return ULM_DUE_ON;
	}

	public void setULM_DUE_ON(String uLM_DUE_ON) {
		ULM_DUE_ON = uLM_DUE_ON;
	}

	public String getULM_AC_PROC_YN() {
		return ULM_AC_PROC_YN;
	}

	public void setULM_AC_PROC_YN(String uLM_AC_PROC_YN) {
		ULM_AC_PROC_YN = uLM_AC_PROC_YN;
	}

	public String getULM_AMND_TYP() {
		return ULM_AMND_TYP;
	}

	public void setULM_AMND_TYP(String uLM_AMND_TYP) {
		ULM_AMND_TYP = uLM_AMND_TYP;
	}

	public String getULM_AMND_SUB_TYP() {
		return ULM_AMND_SUB_TYP;
	}

	public void setULM_AMND_SUB_TYP(String uLM_AMND_SUB_TYP) {
		ULM_AMND_SUB_TYP = uLM_AMND_SUB_TYP;
	}

	public String getULM_AMND_FMD() {
		return ULM_AMND_FMD;
	}

	public void setULM_AMND_FMD(String uLM_AMND_FMD) {
		ULM_AMND_FMD = uLM_AMND_FMD;
	}

	public String getULM_AMND_TOD() {
		return ULM_AMND_TOD;
	}

	public void setULM_AMND_TOD(String uLM_AMND_TOD) {
		ULM_AMND_TOD = uLM_AMND_TOD;
	}

	public String getULM_AMND_REMARKS() {
		return ULM_AMND_REMARKS;
	}

	public void setULM_AMND_REMARKS(String uLM_AMND_REMARKS) {
		ULM_AMND_REMARKS = uLM_AMND_REMARKS;
	}

	public String getULM_CUST_TYP() {
		return ULM_CUST_TYP;
	}

	public void setULM_CUST_TYP(String uLM_CUST_TYP) {
		ULM_CUST_TYP = uLM_CUST_TYP;
	}

	public String getULM_LVL1_SGS_ID() {
		return ULM_LVL1_SGS_ID;
	}

	public void setULM_LVL1_SGS_ID(String uLM_LVL1_SGS_ID) {
		ULM_LVL1_SGS_ID = uLM_LVL1_SGS_ID;
	}

	public String getULM_LVL2_SGS_ID() {
		return ULM_LVL2_SGS_ID;
	}

	public void setULM_LVL2_SGS_ID(String uLM_LVL2_SGS_ID) {
		ULM_LVL2_SGS_ID = uLM_LVL2_SGS_ID;
	}

	public String getULM_LVL3_SGS_ID() {
		return ULM_LVL3_SGS_ID;
	}

	public void setULM_LVL3_SGS_ID(String uLM_LVL3_SGS_ID) {
		ULM_LVL3_SGS_ID = uLM_LVL3_SGS_ID;
	}

	public String getULM_LVL3_NO() {
		return ULM_LVL3_NO;
	}

	public void setULM_LVL3_NO(String uLM_LVL3_NO) {
		ULM_LVL3_NO = uLM_LVL3_NO;
	}

	public String getULM_SRC_SGS_ID() {
		return ULM_SRC_SGS_ID;
	}

	public void setULM_SRC_SGS_ID(String uLM_SRC_SGS_ID) {
		ULM_SRC_SGS_ID = uLM_SRC_SGS_ID;
	}

	public String getULM_SRS_AMND_VER_NO() {
		return ULM_SRS_AMND_VER_NO;
	}

	public void setULM_SRS_AMND_VER_NO(String uLM_SRS_AMND_VER_NO) {
		ULM_SRS_AMND_VER_NO = uLM_SRS_AMND_VER_NO;
	}

	public String getULM_LVL3_ITR_NO() {
		return ULM_LVL3_ITR_NO;
	}

	public void setULM_LVL3_ITR_NO(String uLM_LVL3_ITR_NO) {
		ULM_LVL3_ITR_NO = uLM_LVL3_ITR_NO;
	}

	public String getULM_SRC_AMND_VER_NO() {
		return ULM_SRC_AMND_VER_NO;
	}

	public void setULM_SRC_AMND_VER_NO(String uLM_SRC_AMND_VER_NO) {
		ULM_SRC_AMND_VER_NO = uLM_SRC_AMND_VER_NO;
	}

	public String getULM_CRU_ROLE() {
		return ULM_CRU_ROLE;
	}

	public void setULM_CRU_ROLE(String uLM_CRU_ROLE) {
		ULM_CRU_ROLE = uLM_CRU_ROLE;
	}

	public String getULM_REN_SEQ_NO() {
		return ULM_REN_SEQ_NO;
	}

	public void setULM_REN_SEQ_NO(String uLM_REN_SEQ_NO) {
		ULM_REN_SEQ_NO = uLM_REN_SEQ_NO;
	}

	public String getULM_FLT_YN() {
		return ULM_FLT_YN;
	}

	public void setULM_FLT_YN(String uLM_FLT_YN) {
		ULM_FLT_YN = uLM_FLT_YN;
	}

	public String getULM_OSE_AMND_VER_NO() {
		return ULM_OSE_AMND_VER_NO;
	}

	public void setULM_OSE_AMND_VER_NO(String uLM_OSE_AMND_VER_NO) {
		ULM_OSE_AMND_VER_NO = uLM_OSE_AMND_VER_NO;
	}

	public String getULM_OSE_YN() {
		return ULM_OSE_YN;
	}

	public void setULM_OSE_YN(String uLM_OSE_YN) {
		ULM_OSE_YN = uLM_OSE_YN;
	}

	public String getULM_OSE_ORD_NO() {
		return ULM_OSE_ORD_NO;
	}

	public void setULM_OSE_ORD_NO(String uLM_OSE_ORD_NO) {
		ULM_OSE_ORD_NO = uLM_OSE_ORD_NO;
	}

	public String getULM_OSE_REF_SGS_ID() {
		return ULM_OSE_REF_SGS_ID;
	}

	public void setULM_OSE_REF_SGS_ID(String uLM_OSE_REF_SGS_ID) {
		ULM_OSE_REF_SGS_ID = uLM_OSE_REF_SGS_ID;
	}

	public String getULM_PRM_CURR() {
		return ULM_PRM_CURR;
	}

	public void setULM_PRM_CURR(String uLM_PRM_CURR) {
		ULM_PRM_CURR = uLM_PRM_CURR;
	}

	public String getULM_PRM_CURR_ID() {
		return ULM_PRM_CURR_ID;
	}

	public void setULM_PRM_CURR_ID(String uLM_PRM_CURR_ID) {
		ULM_PRM_CURR_ID = uLM_PRM_CURR_ID;
	}

	public String getULM_PRM_CURR_X_RATE() {
		return ULM_PRM_CURR_X_RATE;
	}

	public void setULM_PRM_CURR_X_RATE(String uLM_PRM_CURR_X_RATE) {
		ULM_PRM_CURR_X_RATE = uLM_PRM_CURR_X_RATE;
	}

	public String getULM_MST_REF_NO() {
		return ULM_MST_REF_NO;
	}

	public void setULM_MST_REF_NO(String uLM_MST_REF_NO) {
		ULM_MST_REF_NO = uLM_MST_REF_NO;
	}

	public String getULM_MST_REF_SGS_ID() {
		return ULM_MST_REF_SGS_ID;
	}

	public void setULM_MST_REF_SGS_ID(String uLM_MST_REF_SGS_ID) {
		ULM_MST_REF_SGS_ID = uLM_MST_REF_SGS_ID;
	}

	public String getULM_MST_REF_AMND_VER_NO() {
		return ULM_MST_REF_AMND_VER_NO;
	}

	public void setULM_MST_REF_AMND_VER_NO(String uLM_MST_REF_AMND_VER_NO) {
		ULM_MST_REF_AMND_VER_NO = uLM_MST_REF_AMND_VER_NO;
	}

	public String getULM_AMND_RSN() {
		return ULM_AMND_RSN;
	}

	public void setULM_AMND_RSN(String uLM_AMND_RSN) {
		ULM_AMND_RSN = uLM_AMND_RSN;
	}

	public String getULM_CARRIER_ID() {
		return ULM_CARRIER_ID;
	}

	public void setULM_CARRIER_ID(String uLM_CARRIER_ID) {
		ULM_CARRIER_ID = uLM_CARRIER_ID;
	}

	public String getULM_TMPL_TYP() {
		return ULM_TMPL_TYP;
	}

	public void setULM_TMPL_TYP(String uLM_TMPL_TYP) {
		ULM_TMPL_TYP = uLM_TMPL_TYP;
	}

	public String getULM_TMPL_ID() {
		return ULM_TMPL_ID;
	}

	public void setULM_TMPL_ID(String uLM_TMPL_ID) {
		ULM_TMPL_ID = uLM_TMPL_ID;
	}

	public String getULM_CANCEL_PC_TYP() {
		return ULM_CANCEL_PC_TYP;
	}

	public void setULM_CANCEL_PC_TYP(String uLM_CANCEL_PC_TYP) {
		ULM_CANCEL_PC_TYP = uLM_CANCEL_PC_TYP;
	}

	public String getULM_LVL1_TYP() {
		return ULM_LVL1_TYP;
	}

	public void setULM_LVL1_TYP(String uLM_LVL1_TYP) {
		ULM_LVL1_TYP = uLM_LVL1_TYP;
	}

	public String getULM_LVL2_TYP() {
		return ULM_LVL2_TYP;
	}

	public void setULM_LVL2_TYP(String uLM_LVL2_TYP) {
		ULM_LVL2_TYP = uLM_LVL2_TYP;
	}

	public String getULM_EXPD() {
		return ULM_EXPD;
	}

	public void setULM_EXPD(String uLM_EXPD) {
		ULM_EXPD = uLM_EXPD;
	}

	public String getULM_RATE_LVL() {
		return ULM_RATE_LVL;
	}

	public void setULM_RATE_LVL(String uLM_RATE_LVL) {
		ULM_RATE_LVL = uLM_RATE_LVL;
	}

	public String getULM_COMM_CURR_ID() {
		return ULM_COMM_CURR_ID;
	}

	public void setULM_COMM_CURR_ID(String uLM_COMM_CURR_ID) {
		ULM_COMM_CURR_ID = uLM_COMM_CURR_ID;
	}

	public String getULM_COMM_CURR() {
		return ULM_COMM_CURR;
	}

	public void setULM_COMM_CURR(String uLM_COMM_CURR) {
		ULM_COMM_CURR = uLM_COMM_CURR;
	}

	public String getULM_CANCEL_DT() {
		return ULM_CANCEL_DT;
	}

	public void setULM_CANCEL_DT(String uLM_CANCEL_DT) {
		ULM_CANCEL_DT = uLM_CANCEL_DT;
	}

	public String getULM_REINS_DT() {
		return ULM_REINS_DT;
	}

	public void setULM_REINS_DT(String uLM_REINS_DT) {
		ULM_REINS_DT = uLM_REINS_DT;
	}

	public String getULM_FCL() {
		return ULM_FCL;
	}

	public void setULM_FCL(String uLM_FCL) {
		ULM_FCL = uLM_FCL;
	}

	public String getULM_FCL_BC() {
		return ULM_FCL_BC;
	}

	public void setULM_FCL_BC(String uLM_FCL_BC) {
		ULM_FCL_BC = uLM_FCL_BC;
	}

	public String getULM_EQ_TYP() {
		return ULM_EQ_TYP;
	}

	public void setULM_EQ_TYP(String uLM_EQ_TYP) {
		ULM_EQ_TYP = uLM_EQ_TYP;
	}

	public String getULM_DEP_PREM() {
		return ULM_DEP_PREM;
	}

	public void setULM_DEP_PREM(String uLM_DEP_PREM) {
		ULM_DEP_PREM = uLM_DEP_PREM;
	}

	public String getULM_DEP_PREM_BC() {
		return ULM_DEP_PREM_BC;
	}

	public void setULM_DEP_PREM_BC(String uLM_DEP_PREM_BC) {
		ULM_DEP_PREM_BC = uLM_DEP_PREM_BC;
	}

	public String getULM_ACNT_REF_NO() {
		return ULM_ACNT_REF_NO;
	}

	public void setULM_ACNT_REF_NO(String uLM_ACNT_REF_NO) {
		ULM_ACNT_REF_NO = uLM_ACNT_REF_NO;
	}

	public String getULM_INS_POL_NO() {
		return ULM_INS_POL_NO;
	}

	public void setULM_INS_POL_NO(String uLM_INS_POL_NO) {
		ULM_INS_POL_NO = uLM_INS_POL_NO;
	}

	public String getULM_INS_LA_NO() {
		return ULM_INS_LA_NO;
	}

	public void setULM_INS_LA_NO(String uLM_INS_LA_NO) {
		ULM_INS_LA_NO = uLM_INS_LA_NO;
	}

	public String getULM_ENDT_INST_TYP() {
		return ULM_ENDT_INST_TYP;
	}

	public void setULM_ENDT_INST_TYP(String uLM_ENDT_INST_TYP) {
		ULM_ENDT_INST_TYP = uLM_ENDT_INST_TYP;
	}

	public String getULM_CARRIER_BR_ID() {
		return ULM_CARRIER_BR_ID;
	}

	public void setULM_CARRIER_BR_ID(String uLM_CARRIER_BR_ID) {
		ULM_CARRIER_BR_ID = uLM_CARRIER_BR_ID;
	}

	public String getULM_INSINT_DESC() {
		return ULM_INSINT_DESC;
	}

	public void setULM_INSINT_DESC(String uLM_INSINT_DESC) {
		ULM_INSINT_DESC = uLM_INSINT_DESC;
	}

	public String getULM_POL_ACNT_YEAR() {
		return ULM_POL_ACNT_YEAR;
	}

	public void setULM_POL_ACNT_YEAR(String uLM_POL_ACNT_YEAR) {
		ULM_POL_ACNT_YEAR = uLM_POL_ACNT_YEAR;
	}

	public String getULM_WAIVE_FEE_YN() {
		return ULM_WAIVE_FEE_YN;
	}

	public void setULM_WAIVE_FEE_YN(String uLM_WAIVE_FEE_YN) {
		ULM_WAIVE_FEE_YN = uLM_WAIVE_FEE_YN;
	}

	public String getULM_RET_MP_YN() {
		return ULM_RET_MP_YN;
	}

	public void setULM_RET_MP_YN(String uLM_RET_MP_YN) {
		ULM_RET_MP_YN = uLM_RET_MP_YN;
	}

	public String getULM_COVER_NOTE_TOD() {
		return ULM_COVER_NOTE_TOD;
	}

	public void setULM_COVER_NOTE_TOD(String uLM_COVER_NOTE_TOD) {
		ULM_COVER_NOTE_TOD = uLM_COVER_NOTE_TOD;
	}

	public String getULM_APU() {
		return ULM_APU;
	}

	public void setULM_APU(String uLM_APU) {
		ULM_APU = uLM_APU;
	}

	public String getULM_CARRIER_STATE() {
		return ULM_CARRIER_STATE;
	}

	public void setULM_CARRIER_STATE(String uLM_CARRIER_STATE) {
		ULM_CARRIER_STATE = uLM_CARRIER_STATE;
	}

	public String getULM_CARRIER_GRP_ID() {
		return ULM_CARRIER_GRP_ID;
	}

	public void setULM_CARRIER_GRP_ID(String uLM_CARRIER_GRP_ID) {
		ULM_CARRIER_GRP_ID = uLM_CARRIER_GRP_ID;
	}

	public String getULM_UPLOAD_SRC() {
		return ULM_UPLOAD_SRC;
	}

	public void setULM_UPLOAD_SRC(String uLM_UPLOAD_SRC) {
		ULM_UPLOAD_SRC = uLM_UPLOAD_SRC;
	}

	public String getULM_DNR_REASON() {
		return ULM_DNR_REASON;
	}

	public void setULM_DNR_REASON(String uLM_DNR_REASON) {
		ULM_DNR_REASON = uLM_DNR_REASON;
	}

	public String getULM_CAN_PAYEE() {
		return ULM_CAN_PAYEE;
	}

	public void setULM_CAN_PAYEE(String uLM_CAN_PAYEE) {
		ULM_CAN_PAYEE = uLM_CAN_PAYEE;
	}

	public String getULM_CRW_NO() {
		return ULM_CRW_NO;
	}

	public void setULM_CRW_NO(String uLM_CRW_NO) {
		ULM_CRW_NO = uLM_CRW_NO;
	}

	public String getULM_DECL_PRD_TYP() {
		return ULM_DECL_PRD_TYP;
	}

	public void setULM_DECL_PRD_TYP(String uLM_DECL_PRD_TYP) {
		ULM_DECL_PRD_TYP = uLM_DECL_PRD_TYP;
	}

	public String getULM_CARRIER_ZIP_CODE() {
		return ULM_CARRIER_ZIP_CODE;
	}

	public void setULM_CARRIER_ZIP_CODE(String uLM_CARRIER_ZIP_CODE) {
		ULM_CARRIER_ZIP_CODE = uLM_CARRIER_ZIP_CODE;
	}

	public String getULM_NAT_OF_BUS() {
		return ULM_NAT_OF_BUS;
	}

	public void setULM_NAT_OF_BUS(String uLM_NAT_OF_BUS) {
		ULM_NAT_OF_BUS = uLM_NAT_OF_BUS;
	}

	public String getULM_CLASS_FACTOR() {
		return ULM_CLASS_FACTOR;
	}

	public void setULM_CLASS_FACTOR(String uLM_CLASS_FACTOR) {
		ULM_CLASS_FACTOR = uLM_CLASS_FACTOR;
	}

	public String getULM_RATE_FRZ() {
		return ULM_RATE_FRZ;
	}

	public void setULM_RATE_FRZ(String uLM_RATE_FRZ) {
		ULM_RATE_FRZ = uLM_RATE_FRZ;
	}

	public String getULM_SA_FACTOR() {
		return ULM_SA_FACTOR;
	}

	public void setULM_SA_FACTOR(String uLM_SA_FACTOR) {
		ULM_SA_FACTOR = uLM_SA_FACTOR;
	}

	public String getULM_DESC1() {
		return ULM_DESC1;
	}

	public void setULM_DESC1(String uLM_DESC1) {
		ULM_DESC1 = uLM_DESC1;
	}

	public String getULM_ACCT_CUST_LVL() {
		return ULM_ACCT_CUST_LVL;
	}

	public void setULM_ACCT_CUST_LVL(String uLM_ACCT_CUST_LVL) {
		ULM_ACCT_CUST_LVL = uLM_ACCT_CUST_LVL;
	}

	public String getULM_TTY_REQ_YN() {
		return ULM_TTY_REQ_YN;
	}

	public void setULM_TTY_REQ_YN(String uLM_TTY_REQ_YN) {
		ULM_TTY_REQ_YN = uLM_TTY_REQ_YN;
	}

	public String getULM_CO_LAST_NAME() {
		return ULM_CO_LAST_NAME;
	}

	public void setULM_CO_LAST_NAME(String uLM_CO_LAST_NAME) {
		ULM_CO_LAST_NAME = uLM_CO_LAST_NAME;
	}

	public String getULM_CO_FIRST_NAME() {
		return ULM_CO_FIRST_NAME;
	}

	public void setULM_CO_FIRST_NAME(String uLM_CO_FIRST_NAME) {
		ULM_CO_FIRST_NAME = uLM_CO_FIRST_NAME;
	}

	public String getULM_CO_MIDDLE_NAME() {
		return ULM_CO_MIDDLE_NAME;
	}

	public void setULM_CO_MIDDLE_NAME(String uLM_CO_MIDDLE_NAME) {
		ULM_CO_MIDDLE_NAME = uLM_CO_MIDDLE_NAME;
	}

	public String getULM_OR_ADDRINT_YN() {
		return ULM_OR_ADDRINT_YN;
	}

	public void setULM_OR_ADDRINT_YN(String uLM_OR_ADDRINT_YN) {
		ULM_OR_ADDRINT_YN = uLM_OR_ADDRINT_YN;
	}

	public String getULM_ORG_TOD() {
		return ULM_ORG_TOD;
	}

	public void setULM_ORG_TOD(String uLM_ORG_TOD) {
		ULM_ORG_TOD = uLM_ORG_TOD;
	}

	public String getULM_REN_ORG_SGS_ID() {
		return ULM_REN_ORG_SGS_ID;
	}

	public void setULM_REN_ORG_SGS_ID(String uLM_REN_ORG_SGS_ID) {
		ULM_REN_ORG_SGS_ID = uLM_REN_ORG_SGS_ID;
	}

	public String getULM_SUB_DATE() {
		return ULM_SUB_DATE;
	}

	public void setULM_SUB_DATE(String uLM_SUB_DATE) {
		ULM_SUB_DATE = uLM_SUB_DATE;
	}

	public String getULM_NL_DESC() {
		return ULM_NL_DESC;
	}

	public void setULM_NL_DESC(String uLM_NL_DESC) {
		ULM_NL_DESC = uLM_NL_DESC;
	}

	public String getULM_NL_FMD() {
		return ULM_NL_FMD;
	}

	public void setULM_NL_FMD(String uLM_NL_FMD) {
		ULM_NL_FMD = uLM_NL_FMD;
	}

	public String getULM_NL_TOD() {
		return ULM_NL_TOD;
	}

	public void setULM_NL_TOD(String uLM_NL_TOD) {
		ULM_NL_TOD = uLM_NL_TOD;
	}

	public String getULM_PPW_DAYS() {
		return ULM_PPW_DAYS;
	}

	public void setULM_PPW_DAYS(String uLM_PPW_DAYS) {
		ULM_PPW_DAYS = uLM_PPW_DAYS;
	}

	public String getULM_BC_ID() {
		return ULM_BC_ID;
	}

	public void setULM_BC_ID(String uLM_BC_ID) {
		ULM_BC_ID = uLM_BC_ID;
	}

	public String getULM_EXP_DT_CHG() {
		return ULM_EXP_DT_CHG;
	}

	public void setULM_EXP_DT_CHG(String uLM_EXP_DT_CHG) {
		ULM_EXP_DT_CHG = uLM_EXP_DT_CHG;
	}

	public String getULM_EQTY_DT() {
		return ULM_EQTY_DT;
	}

	public void setULM_EQTY_DT(String uLM_EQTY_DT) {
		ULM_EQTY_DT = uLM_EQTY_DT;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress1() {
		return customerAddress1;
	}

	public void setCustomerAddress1(String customerAddress1) {
		this.customerAddress1 = customerAddress1;
	}

	public String getCustomerAddress2() {
		return customerAddress2;
	}

	public void setCustomerAddress2(String customerAddress2) {
		this.customerAddress2 = customerAddress2;
	}

	public String getCustomerAddress3() {
		return customerAddress3;
	}

	public void setCustomerAddress3(String customerAddress3) {
		this.customerAddress3 = customerAddress3;
	}

	public String getCustomerAddress4() {
		return customerAddress4;
	}

	public void setCustomerAddress4(String customerAddress4) {
		this.customerAddress4 = customerAddress4;
	}

	public String getULM_CCITY() {
		return ULM_CCITY;
	}

	public void setULM_CCITY(String uLM_CCITY) {
		ULM_CCITY = uLM_CCITY;
	}

	public String getULM_CSTATE() {
		return ULM_CSTATE;
	}

	public void setULM_CSTATE(String uLM_CSTATE) {
		ULM_CSTATE = uLM_CSTATE;
	}

	public String getULM_CCOUNTRY() {
		return ULM_CCOUNTRY;
	}

	public void setULM_CCOUNTRY(String uLM_CCOUNTRY) {
		ULM_CCOUNTRY = uLM_CCOUNTRY;
	}

	public String getULM_REN_PAYOR_TYP() {
		return ULM_REN_PAYOR_TYP;
	}

	public void setULM_REN_PAYOR_TYP(String uLM_REN_PAYOR_TYP) {
		ULM_REN_PAYOR_TYP = uLM_REN_PAYOR_TYP;
	}

	public String getULM_ACNT_REF2_NO() {
		return ULM_ACNT_REF2_NO;
	}

	public void setULM_ACNT_REF2_NO(String uLM_ACNT_REF2_NO) {
		ULM_ACNT_REF2_NO = uLM_ACNT_REF2_NO;
	}

	public String getULM_REN_PAYOR_ID() {
		return ULM_REN_PAYOR_ID;
	}

	public void setULM_REN_PAYOR_ID(String uLM_REN_PAYOR_ID) {
		ULM_REN_PAYOR_ID = uLM_REN_PAYOR_ID;
	}

	public String getULM_INT_SHARE_PERC() {
		return ULM_INT_SHARE_PERC;
	}

	public void setULM_INT_SHARE_PERC(String uLM_INT_SHARE_PERC) {
		ULM_INT_SHARE_PERC = uLM_INT_SHARE_PERC;
	}

	public String getULM_BAT_ID() {
		return ULM_BAT_ID;
	}

	public void setULM_BAT_ID(String uLM_BAT_ID) {
		ULM_BAT_ID = uLM_BAT_ID;
	}

	public String getULM_SHARE_PERC() {
		return ULM_SHARE_PERC;
	}

	public void setULM_SHARE_PERC(String uLM_SHARE_PERC) {
		ULM_SHARE_PERC = uLM_SHARE_PERC;
	}

	public String getULM_L1_AGT_ID() {
		return ULM_L1_AGT_ID;
	}

	public void setULM_L1_AGT_ID(String uLM_L1_AGT_ID) {
		ULM_L1_AGT_ID = uLM_L1_AGT_ID;
	}

	public String getULM_L2_AGT_ID() {
		return ULM_L2_AGT_ID;
	}

	public void setULM_L2_AGT_ID(String uLM_L2_AGT_ID) {
		ULM_L2_AGT_ID = uLM_L2_AGT_ID;
	}

	public String getULM_L3_AGT_ID() {
		return ULM_L3_AGT_ID;
	}

	public void setULM_L3_AGT_ID(String uLM_L3_AGT_ID) {
		ULM_L3_AGT_ID = uLM_L3_AGT_ID;
	}

	public String getULM_L4_AGT_ID() {
		return ULM_L4_AGT_ID;
	}

	public void setULM_L4_AGT_ID(String uLM_L4_AGT_ID) {
		ULM_L4_AGT_ID = uLM_L4_AGT_ID;
	}

	public String getULM_L5_AGT_ID() {
		return ULM_L5_AGT_ID;
	}

	public void setULM_L5_AGT_ID(String uLM_L5_AGT_ID) {
		ULM_L5_AGT_ID = uLM_L5_AGT_ID;
	}

	public String getULM_PERIOD_CATG_TYP() {
		return ULM_PERIOD_CATG_TYP;
	}

	public void setULM_PERIOD_CATG_TYP(String uLM_PERIOD_CATG_TYP) {
		ULM_PERIOD_CATG_TYP = uLM_PERIOD_CATG_TYP;
	}

	public String getULM_PERIOD_MONTHS() {
		return ULM_PERIOD_MONTHS;
	}

	public void setULM_PERIOD_MONTHS(String uLM_PERIOD_MONTHS) {
		ULM_PERIOD_MONTHS = uLM_PERIOD_MONTHS;
	}

	public String getULM_PERIOD_DAYS() {
		return ULM_PERIOD_DAYS;
	}

	public void setULM_PERIOD_DAYS(String uLM_PERIOD_DAYS) {
		ULM_PERIOD_DAYS = uLM_PERIOD_DAYS;
	}

	public String getULM_SUB_STATUS() {
		return ULM_SUB_STATUS;
	}

	public void setULM_SUB_STATUS(String uLM_SUB_STATUS) {
		ULM_SUB_STATUS = uLM_SUB_STATUS;
	}

	public String getULM_RISK_TYP() {
		return ULM_RISK_TYP;
	}

	public void setULM_RISK_TYP(String uLM_RISK_TYP) {
		ULM_RISK_TYP = uLM_RISK_TYP;
	}

	public String getULM_CFIRST_NAME() {
		return ULM_CFIRST_NAME;
	}

	public void setULM_CFIRST_NAME(String uLM_CFIRST_NAME) {
		ULM_CFIRST_NAME = uLM_CFIRST_NAME;
	}

	public String getULM_CMIDDLE_NAME() {
		return ULM_CMIDDLE_NAME;
	}

	public void setULM_CMIDDLE_NAME(String uLM_CMIDDLE_NAME) {
		ULM_CMIDDLE_NAME = uLM_CMIDDLE_NAME;
	}

	public String getULM_CLAST_NAME() {
		return ULM_CLAST_NAME;
	}

	public void setULM_CLAST_NAME(String uLM_CLAST_NAME) {
		ULM_CLAST_NAME = uLM_CLAST_NAME;
	}

	public String getULM_INSR_HO_YN() {
		return ULM_INSR_HO_YN;
	}

	public void setULM_INSR_HO_YN(String uLM_INSR_HO_YN) {
		ULM_INSR_HO_YN = uLM_INSR_HO_YN;
	}

	public String getULM_PRE_DISC_YN() {
		return ULM_PRE_DISC_YN;
	}

	public void setULM_PRE_DISC_YN(String uLM_PRE_DISC_YN) {
		ULM_PRE_DISC_YN = uLM_PRE_DISC_YN;
	}

	public String getULM_EFT_DISC_YN() {
		return ULM_EFT_DISC_YN;
	}

	public void setULM_EFT_DISC_YN(String uLM_EFT_DISC_YN) {
		ULM_EFT_DISC_YN = uLM_EFT_DISC_YN;
	}

	public String getULM_PRIOR_DISC_YN() {
		return ULM_PRIOR_DISC_YN;
	}

	public void setULM_PRIOR_DISC_YN(String uLM_PRIOR_DISC_YN) {
		ULM_PRIOR_DISC_YN = uLM_PRIOR_DISC_YN;
	}

	public String getULM_PROG_TYP() {
		return ULM_PROG_TYP;
	}

	public void setULM_PROG_TYP(String uLM_PROG_TYP) {
		ULM_PROG_TYP = uLM_PROG_TYP;
	}

	public String getULM_CO_APPL_YN() {
		return ULM_CO_APPL_YN;
	}

	public void setULM_CO_APPL_YN(String uLM_CO_APPL_YN) {
		ULM_CO_APPL_YN = uLM_CO_APPL_YN;
	}

	public String getULM_CO_INSR_YN() {
		return ULM_CO_INSR_YN;
	}

	public void setULM_CO_INSR_YN(String uLM_CO_INSR_YN) {
		ULM_CO_INSR_YN = uLM_CO_INSR_YN;
	}

	public String getULM_NAMED_NON_OW_YN() {
		return ULM_NAMED_NON_OW_YN;
	}

	public void setULM_NAMED_NON_OW_YN(String uLM_NAMED_NON_OW_YN) {
		ULM_NAMED_NON_OW_YN = uLM_NAMED_NON_OW_YN;
	}

	public String getULM_INSR_SUFFIX() {
		return ULM_INSR_SUFFIX;
	}

	public void setULM_INSR_SUFFIX(String uLM_INSR_SUFFIX) {
		ULM_INSR_SUFFIX = uLM_INSR_SUFFIX;
	}

	public String getULM_CO_SUFFIX() {
		return ULM_CO_SUFFIX;
	}

	public void setULM_CO_SUFFIX(String uLM_CO_SUFFIX) {
		ULM_CO_SUFFIX = uLM_CO_SUFFIX;
	}

	public String getULM_PD_FUL_DISC_YN() {
		return ULM_PD_FUL_DISC_YN;
	}

	public void setULM_PD_FUL_DISC_YN(String uLM_PD_FUL_DISC_YN) {
		ULM_PD_FUL_DISC_YN = uLM_PD_FUL_DISC_YN;
	}

	public String getULM_REIN_FEE_YN() {
		return ULM_REIN_FEE_YN;
	}

	public void setULM_REIN_FEE_YN(String uLM_REIN_FEE_YN) {
		ULM_REIN_FEE_YN = uLM_REIN_FEE_YN;
	}

	public String getULM_MAN_REN_YN() {
		return ULM_MAN_REN_YN;
	}

	public void setULM_MAN_REN_YN(String uLM_MAN_REN_YN) {
		ULM_MAN_REN_YN = uLM_MAN_REN_YN;
	}

	public String getULM_REN_DISC_YN() {
		return ULM_REN_DISC_YN;
	}

	public void setULM_REN_DISC_YN(String uLM_REN_DISC_YN) {
		ULM_REN_DISC_YN = uLM_REN_DISC_YN;
	}

	public String getULM_DEP_PREM_YN() {
		return ULM_DEP_PREM_YN;
	}

	public void setULM_DEP_PREM_YN(String uLM_DEP_PREM_YN) {
		ULM_DEP_PREM_YN = uLM_DEP_PREM_YN;
	}

	public String getULM_FLAT_CAN_YN() {
		return ULM_FLAT_CAN_YN;
	}

	public void setULM_FLAT_CAN_YN(String uLM_FLAT_CAN_YN) {
		ULM_FLAT_CAN_YN = uLM_FLAT_CAN_YN;
	}

	public String getULM_FLEX_01() {
		return ULM_FLEX_01;
	}

	public void setULM_FLEX_01(String uLM_FLEX_01) {
		ULM_FLEX_01 = uLM_FLEX_01;
	}

	public String getULM_FLEX_02() {
		return ULM_FLEX_02;
	}

	public void setULM_FLEX_02(String uLM_FLEX_02) {
		ULM_FLEX_02 = uLM_FLEX_02;
	}

	public String getULM_FLEX_03() {
		return ULM_FLEX_03;
	}

	public void setULM_FLEX_03(String uLM_FLEX_03) {
		ULM_FLEX_03 = uLM_FLEX_03;
	}

	public String getULM_FLEX_04() {
		return ULM_FLEX_04;
	}

	public void setULM_FLEX_04(String uLM_FLEX_04) {
		ULM_FLEX_04 = uLM_FLEX_04;
	}

	public String getULM_FLEX_05() {
		return ULM_FLEX_05;
	}

	public void setULM_FLEX_05(String uLM_FLEX_05) {
		ULM_FLEX_05 = uLM_FLEX_05;
	}

	public String getULM_RISK_ADD_1() {
		return ULM_RISK_ADD_1;
	}

	public void setULM_RISK_ADD_1(String uLM_RISK_ADD_1) {
		ULM_RISK_ADD_1 = uLM_RISK_ADD_1;
	}

	public String getULM_RISK_ADD_2() {
		return ULM_RISK_ADD_2;
	}

	public void setULM_RISK_ADD_2(String uLM_RISK_ADD_2) {
		ULM_RISK_ADD_2 = uLM_RISK_ADD_2;
	}

	public String getULM_RISK_ADD_3() {
		return ULM_RISK_ADD_3;
	}

	public void setULM_RISK_ADD_3(String uLM_RISK_ADD_3) {
		ULM_RISK_ADD_3 = uLM_RISK_ADD_3;
	}

	public String getULM_RISK_ADD_4() {
		return ULM_RISK_ADD_4;
	}

	public void setULM_RISK_ADD_4(String uLM_RISK_ADD_4) {
		ULM_RISK_ADD_4 = uLM_RISK_ADD_4;
	}

	public String getULM_RISK_PIN_CODE() {
		return ULM_RISK_PIN_CODE;
	}

	public void setULM_RISK_PIN_CODE(String uLM_RISK_PIN_CODE) {
		ULM_RISK_PIN_CODE = uLM_RISK_PIN_CODE;
	}

	public String getULM_RISK_CITY() {
		return ULM_RISK_CITY;
	}

	public void setULM_RISK_CITY(String uLM_RISK_CITY) {
		ULM_RISK_CITY = uLM_RISK_CITY;
	}

	public String getULM_RISK_STATE() {
		return ULM_RISK_STATE;
	}

	public void setULM_RISK_STATE(String uLM_RISK_STATE) {
		ULM_RISK_STATE = uLM_RISK_STATE;
	}

	public String getULM_RISK_COUNTRY() {
		return ULM_RISK_COUNTRY;
	}

	public void setULM_RISK_COUNTRY(String uLM_RISK_COUNTRY) {
		ULM_RISK_COUNTRY = uLM_RISK_COUNTRY;
	}

	public String getULM_RSK_ADD_SAME_YN() {
		return ULM_RSK_ADD_SAME_YN;
	}

	public void setULM_RSK_ADD_SAME_YN(String uLM_RSK_ADD_SAME_YN) {
		ULM_RSK_ADD_SAME_YN = uLM_RSK_ADD_SAME_YN;
	}

	public String getULM_PREFIX_NAME() {
		return ULM_PREFIX_NAME;
	}

	public void setULM_PREFIX_NAME(String uLM_PREFIX_NAME) {
		ULM_PREFIX_NAME = uLM_PREFIX_NAME;
	}

	public String getULM_PREFIX_NAME_BL() {
		return ULM_PREFIX_NAME_BL;
	}

	public void setULM_PREFIX_NAME_BL(String uLM_PREFIX_NAME_BL) {
		ULM_PREFIX_NAME_BL = uLM_PREFIX_NAME_BL;
	}

	public String getULM_CNAME_BL() {
		return ULM_CNAME_BL;
	}

	public void setULM_CNAME_BL(String uLM_CNAME_BL) {
		ULM_CNAME_BL = uLM_CNAME_BL;
	}

	public String getULM_CFIRST_NAME_BL() {
		return ULM_CFIRST_NAME_BL;
	}

	public void setULM_CFIRST_NAME_BL(String uLM_CFIRST_NAME_BL) {
		ULM_CFIRST_NAME_BL = uLM_CFIRST_NAME_BL;
	}

	public String getULM_CLAST_NAME_BL() {
		return ULM_CLAST_NAME_BL;
	}

	public void setULM_CLAST_NAME_BL(String uLM_CLAST_NAME_BL) {
		ULM_CLAST_NAME_BL = uLM_CLAST_NAME_BL;
	}

	public String getULM_REN_TPI_STS() {
		return ULM_REN_TPI_STS;
	}

	public void setULM_REN_TPI_STS(String uLM_REN_TPI_STS) {
		ULM_REN_TPI_STS = uLM_REN_TPI_STS;
	}

	public String getULM_CPY_PHONE_NO() {
		return ULM_CPY_PHONE_NO;
	}

	public void setULM_CPY_PHONE_NO(String uLM_CPY_PHONE_NO) {
		ULM_CPY_PHONE_NO = uLM_CPY_PHONE_NO;
	}

	public String getULM_CPY_MOBILE_NO() {
		return ULM_CPY_MOBILE_NO;
	}

	public void setULM_CPY_MOBILE_NO(String uLM_CPY_MOBILE_NO) {
		ULM_CPY_MOBILE_NO = uLM_CPY_MOBILE_NO;
	}

	public String getULM_CFAX_NO() {
		return ULM_CFAX_NO;
	}

	public void setULM_CFAX_NO(String uLM_CFAX_NO) {
		ULM_CFAX_NO = uLM_CFAX_NO;
	}

	public String getULM_CPY_EMAIL_ID() {
		return ULM_CPY_EMAIL_ID;
	}

	public void setULM_CPY_EMAIL_ID(String uLM_CPY_EMAIL_ID) {
		ULM_CPY_EMAIL_ID = uLM_CPY_EMAIL_ID;
	}

	public String getULM_CR_LEVEL() {
		return ULM_CR_LEVEL;
	}

	public void setULM_CR_LEVEL(String uLM_CR_LEVEL) {
		ULM_CR_LEVEL = uLM_CR_LEVEL;
	}

	public String getULM_CR_EXP_ALLOWED() {
		return ULM_CR_EXP_ALLOWED;
	}

	public void setULM_CR_EXP_ALLOWED(String uLM_CR_EXP_ALLOWED) {
		ULM_CR_EXP_ALLOWED = uLM_CR_EXP_ALLOWED;
	}

	public String getULM_PUN_DMG_YN() {
		return ULM_PUN_DMG_YN;
	}

	public void setULM_PUN_DMG_YN(String uLM_PUN_DMG_YN) {
		ULM_PUN_DMG_YN = uLM_PUN_DMG_YN;
	}

	public String getULM_ESIGN_NO() {
		return ULM_ESIGN_NO;
	}

	public void setULM_ESIGN_NO(String uLM_ESIGN_NO) {
		ULM_ESIGN_NO = uLM_ESIGN_NO;
	}

	public String getULM_NATIONALITY() {
		return ULM_NATIONALITY;
	}

	public void setULM_NATIONALITY(String uLM_NATIONALITY) {
		ULM_NATIONALITY = uLM_NATIONALITY;
	}

	public String getULM_OCCUPATION() {
		return ULM_OCCUPATION;
	}

	public void setULM_OCCUPATION(String uLM_OCCUPATION) {
		ULM_OCCUPATION = uLM_OCCUPATION;
	}

	public String getULM_O_CUST_ID() {
		return ULM_O_CUST_ID;
	}

	public void setULM_O_CUST_ID(String uLM_O_CUST_ID) {
		ULM_O_CUST_ID = uLM_O_CUST_ID;
	}

	public String getULM_CWK_PHONE_NO() {
		return ULM_CWK_PHONE_NO;
	}

	public void setULM_CWK_PHONE_NO(String uLM_CWK_PHONE_NO) {
		ULM_CWK_PHONE_NO = uLM_CWK_PHONE_NO;
	}

	public String getULM_POST_DOC() {
		return ULM_POST_DOC;
	}

	public void setULM_POST_DOC(String uLM_POST_DOC) {
		ULM_POST_DOC = uLM_POST_DOC;
	}

	public String getULM_QUOT_COND_ACCEPT_YN() {
		return ULM_QUOT_COND_ACCEPT_YN;
	}

	public void setULM_QUOT_COND_ACCEPT_YN(String uLM_QUOT_COND_ACCEPT_YN) {
		ULM_QUOT_COND_ACCEPT_YN = uLM_QUOT_COND_ACCEPT_YN;
	}

	public String getULM_POL_SRC() {
		return ULM_POL_SRC;
	}

	public void setULM_POL_SRC(String uLM_POL_SRC) {
		ULM_POL_SRC = uLM_POL_SRC;
	}

	public String getULM_PRV_EXP_DT() {
		return ULM_PRV_EXP_DT;
	}

	public void setULM_PRV_EXP_DT(String uLM_PRV_EXP_DT) {
		ULM_PRV_EXP_DT = uLM_PRV_EXP_DT;
	}

	public String getULM_HOME_TYP() {
		return ULM_HOME_TYP;
	}

	public void setULM_HOME_TYP(String uLM_HOME_TYP) {
		ULM_HOME_TYP = uLM_HOME_TYP;
	}

	public String getULM_CADDR_5() {
		return ULM_CADDR_5;
	}

	public void setULM_CADDR_5(String uLM_CADDR_5) {
		ULM_CADDR_5 = uLM_CADDR_5;
	}

	public String getULM_PDOACM_YN() {
		return ULM_PDOACM_YN;
	}

	public void setULM_PDOACM_YN(String uLM_PDOACM_YN) {
		ULM_PDOACM_YN = uLM_PDOACM_YN;
	}

	public String getULM_LBOACM_YN() {
		return ULM_LBOACM_YN;
	}

	public void setULM_LBOACM_YN(String uLM_LBOACM_YN) {
		ULM_LBOACM_YN = uLM_LBOACM_YN;
	}

	public String getULM_RATE_DATE() {
		return ULM_RATE_DATE;
	}

	public void setULM_RATE_DATE(String uLM_RATE_DATE) {
		ULM_RATE_DATE = uLM_RATE_DATE;
	}

	public String getULM_CUST_DESC() {
		return ULM_CUST_DESC;
	}

	public void setULM_CUST_DESC(String uLM_CUST_DESC) {
		ULM_CUST_DESC = uLM_CUST_DESC;
	}

	public String getULM_AC_SCORE() {
		return ULM_AC_SCORE;
	}

	public void setULM_AC_SCORE(String uLM_AC_SCORE) {
		ULM_AC_SCORE = uLM_AC_SCORE;
	}

	public String getULM_DNR_REMARKS() {
		return ULM_DNR_REMARKS;
	}

	public void setULM_DNR_REMARKS(String uLM_DNR_REMARKS) {
		ULM_DNR_REMARKS = uLM_DNR_REMARKS;
	}

	public String getULM_EPRINT_YN() {
		return ULM_EPRINT_YN;
	}

	public void setULM_EPRINT_YN(String uLM_EPRINT_YN) {
		ULM_EPRINT_YN = uLM_EPRINT_YN;
	}

	public String getULM_REMARKS_BL_YN() {
		return ULM_REMARKS_BL_YN;
	}

	public void setULM_REMARKS_BL_YN(String uLM_REMARKS_BL_YN) {
		ULM_REMARKS_BL_YN = uLM_REMARKS_BL_YN;
	}

	public String getULM_FRCOMP_ID() {
		return ULM_FRCOMP_ID;
	}

	public void setULM_FRCOMP_ID(String uLM_FRCOMP_ID) {
		ULM_FRCOMP_ID = uLM_FRCOMP_ID;
	}

	public String getULM_REFF_YN() {
		return ULM_REFF_YN;
	}

	public void setULM_REFF_YN(String uLM_REFF_YN) {
		ULM_REFF_YN = uLM_REFF_YN;
	}

	public String getULM_DECL_USR() {
		return ULM_DECL_USR;
	}

	public void setULM_DECL_USR(String uLM_DECL_USR) {
		ULM_DECL_USR = uLM_DECL_USR;
	}

	public String getULM_DECL_DT() {
		return ULM_DECL_DT;
	}

	public void setULM_DECL_DT(String uLM_DECL_DT) {
		ULM_DECL_DT = uLM_DECL_DT;
	}

	public String getULM_REN_POL_NO() {
		return ULM_REN_POL_NO;
	}

	public void setULM_REN_POL_NO(String uLM_REN_POL_NO) {
		ULM_REN_POL_NO = uLM_REN_POL_NO;
	}

	public String getULM_AGT_ADDR_1() {
		return ULM_AGT_ADDR_1;
	}

	public void setULM_AGT_ADDR_1(String uLM_AGT_ADDR_1) {
		ULM_AGT_ADDR_1 = uLM_AGT_ADDR_1;
	}

	public String getULM_AGT_ADDR_2() {
		return ULM_AGT_ADDR_2;
	}

	public void setULM_AGT_ADDR_2(String uLM_AGT_ADDR_2) {
		ULM_AGT_ADDR_2 = uLM_AGT_ADDR_2;
	}

	public String getULM_AGT_ADDR_3() {
		return ULM_AGT_ADDR_3;
	}

	public void setULM_AGT_ADDR_3(String uLM_AGT_ADDR_3) {
		ULM_AGT_ADDR_3 = uLM_AGT_ADDR_3;
	}

	public String getULM_AGT_ADDR_4() {
		return ULM_AGT_ADDR_4;
	}

	public void setULM_AGT_ADDR_4(String uLM_AGT_ADDR_4) {
		ULM_AGT_ADDR_4 = uLM_AGT_ADDR_4;
	}

	public String getULM_AGT_PIN_CODE() {
		return ULM_AGT_PIN_CODE;
	}

	public void setULM_AGT_PIN_CODE(String uLM_AGT_PIN_CODE) {
		ULM_AGT_PIN_CODE = uLM_AGT_PIN_CODE;
	}

	public String getULM_AGT_CITY() {
		return ULM_AGT_CITY;
	}

	public void setULM_AGT_CITY(String uLM_AGT_CITY) {
		ULM_AGT_CITY = uLM_AGT_CITY;
	}

	public String getULM_AGT_STATE() {
		return ULM_AGT_STATE;
	}

	public void setULM_AGT_STATE(String uLM_AGT_STATE) {
		ULM_AGT_STATE = uLM_AGT_STATE;
	}

	public String getULM_AGT_COUNTRY() {
		return ULM_AGT_COUNTRY;
	}

	public void setULM_AGT_COUNTRY(String uLM_AGT_COUNTRY) {
		ULM_AGT_COUNTRY = uLM_AGT_COUNTRY;
	}

	public String getULM_AGT_PHONE_NO() {
		return ULM_AGT_PHONE_NO;
	}

	public void setULM_AGT_PHONE_NO(String uLM_AGT_PHONE_NO) {
		ULM_AGT_PHONE_NO = uLM_AGT_PHONE_NO;
	}

	public String getULM_COINS_FLAG() {
		return ULM_COINS_FLAG;
	}

	public void setULM_COINS_FLAG(String uLM_COINS_FLAG) {
		ULM_COINS_FLAG = uLM_COINS_FLAG;
	}

	public String getULM_SI_CURR() {
		return ULM_SI_CURR;
	}

	public void setULM_SI_CURR(String uLM_SI_CURR) {
		ULM_SI_CURR = uLM_SI_CURR;
	}

	public String getULM_SI_CURR_ID() {
		return ULM_SI_CURR_ID;
	}

	public void setULM_SI_CURR_ID(String uLM_SI_CURR_ID) {
		ULM_SI_CURR_ID = uLM_SI_CURR_ID;
	}

	public String getULM_PREM() {
		return ULM_PREM;
	}

	public void setULM_PREM(String uLM_PREM) {
		ULM_PREM = uLM_PREM;
	}

	public String getULM_PREM_BC() {
		return ULM_PREM_BC;
	}

	public void setULM_PREM_BC(String uLM_PREM_BC) {
		ULM_PREM_BC = uLM_PREM_BC;
	}

	public String getULM_SI_X_RATE() {
		return ULM_SI_X_RATE;
	}

	public void setULM_SI_X_RATE(String uLM_SI_X_RATE) {
		ULM_SI_X_RATE = uLM_SI_X_RATE;
	}

	public String getULM_SI_LIMIT() {
		return ULM_SI_LIMIT;
	}

	public void setULM_SI_LIMIT(String uLM_SI_LIMIT) {
		ULM_SI_LIMIT = uLM_SI_LIMIT;
	}

	public String getULM_SI_LIMIT_BC() {
		return ULM_SI_LIMIT_BC;
	}

	public void setULM_SI_LIMIT_BC(String uLM_SI_LIMIT_BC) {
		ULM_SI_LIMIT_BC = uLM_SI_LIMIT_BC;
	}

	public String getULM_NB_TYP() {
		return ULM_NB_TYP;
	}

	public void setULM_NB_TYP(String uLM_NB_TYP) {
		ULM_NB_TYP = uLM_NB_TYP;
	}

	public String getULM_COMM_X_RATE() {
		return ULM_COMM_X_RATE;
	}

	public void setULM_COMM_X_RATE(String uLM_COMM_X_RATE) {
		ULM_COMM_X_RATE = uLM_COMM_X_RATE;
	}

	public String getULM_COMM() {
		return ULM_COMM;
	}

	public void setULM_COMM(String uLM_COMM) {
		ULM_COMM = uLM_COMM;
	}

	public String getULM_COMM_BC() {
		return ULM_COMM_BC;
	}

	public void setULM_COMM_BC(String uLM_COMM_BC) {
		ULM_COMM_BC = uLM_COMM_BC;
	}

	public String getULM_AE_ID() {
		return ULM_AE_ID;
	}

	public void setULM_AE_ID(String uLM_AE_ID) {
		ULM_AE_ID = uLM_AE_ID;
	}

	public String getULM_SM_ID() {
		return ULM_SM_ID;
	}

	public void setULM_SM_ID(String uLM_SM_ID) {
		ULM_SM_ID = uLM_SM_ID;
	}

	public String getULM_RISK_BUSS_DESC() {
		return ULM_RISK_BUSS_DESC;
	}

	public void setULM_RISK_BUSS_DESC(String uLM_RISK_BUSS_DESC) {
		ULM_RISK_BUSS_DESC = uLM_RISK_BUSS_DESC;
	}

	public String getULM_RISK_OCC() {
		return ULM_RISK_OCC;
	}

	public void setULM_RISK_OCC(String uLM_RISK_OCC) {
		ULM_RISK_OCC = uLM_RISK_OCC;
	}

	public String getULM_RISK_OCC_DESC() {
		return ULM_RISK_OCC_DESC;
	}

	public void setULM_RISK_OCC_DESC(String uLM_RISK_OCC_DESC) {
		ULM_RISK_OCC_DESC = uLM_RISK_OCC_DESC;
	}

	public String getULM_RISK_COUNT() {
		return ULM_RISK_COUNT;
	}

	public void setULM_RISK_COUNT(String uLM_RISK_COUNT) {
		ULM_RISK_COUNT = uLM_RISK_COUNT;
	}

	public String getULM_COMM_DISC_PER() {
		return ULM_COMM_DISC_PER;
	}

	public void setULM_COMM_DISC_PER(String uLM_COMM_DISC_PER) {
		ULM_COMM_DISC_PER = uLM_COMM_DISC_PER;
	}

	public String getULM_COMM_DISC_RATE_PER() {
		return ULM_COMM_DISC_RATE_PER;
	}

	public void setULM_COMM_DISC_RATE_PER(String uLM_COMM_DISC_RATE_PER) {
		ULM_COMM_DISC_RATE_PER = uLM_COMM_DISC_RATE_PER;
	}

	public String getULM_CUST_POL_TYP() {
		return ULM_CUST_POL_TYP;
	}

	public void setULM_CUST_POL_TYP(String uLM_CUST_POL_TYP) {
		ULM_CUST_POL_TYP = uLM_CUST_POL_TYP;
	}

	public String getULM_CR_SCORE() {
		return ULM_CR_SCORE;
	}

	public void setULM_CR_SCORE(String uLM_CR_SCORE) {
		ULM_CR_SCORE = uLM_CR_SCORE;
	}

	public String getULM_PRV_FM_DT() {
		return ULM_PRV_FM_DT;
	}

	public void setULM_PRV_FM_DT(String uLM_PRV_FM_DT) {
		ULM_PRV_FM_DT = uLM_PRV_FM_DT;
	}

	public String getULM_INS_AMND_NO() {
		return ULM_INS_AMND_NO;
	}

	public void setULM_INS_AMND_NO(String uLM_INS_AMND_NO) {
		ULM_INS_AMND_NO = uLM_INS_AMND_NO;
	}

	public String getULM_NCF_STATUS() {
		return ULM_NCF_STATUS;
	}

	public void setULM_NCF_STATUS(String uLM_NCF_STATUS) {
		ULM_NCF_STATUS = uLM_NCF_STATUS;
	}

	public String getULM_NCF_MSG() {
		return ULM_NCF_MSG;
	}

	public void setULM_NCF_MSG(String uLM_NCF_MSG) {
		ULM_NCF_MSG = uLM_NCF_MSG;
	}

	public String getULM_CCF_FLAG() {
		return ULM_CCF_FLAG;
	}

	public void setULM_CCF_FLAG(String uLM_CCF_FLAG) {
		ULM_CCF_FLAG = uLM_CCF_FLAG;
	}

	public String getULM_FLEX_06() {
		return ULM_FLEX_06;
	}

	public void setULM_FLEX_06(String uLM_FLEX_06) {
		ULM_FLEX_06 = uLM_FLEX_06;
	}

	public String getULM_FLEX_07() {
		return ULM_FLEX_07;
	}

	public void setULM_FLEX_07(String uLM_FLEX_07) {
		ULM_FLEX_07 = uLM_FLEX_07;
	}

	public String getULM_FLEX_08() {
		return ULM_FLEX_08;
	}

	public void setULM_FLEX_08(String uLM_FLEX_08) {
		ULM_FLEX_08 = uLM_FLEX_08;
	}

	public String getULM_FLEX_09() {
		return ULM_FLEX_09;
	}

	public void setULM_FLEX_09(String uLM_FLEX_09) {
		ULM_FLEX_09 = uLM_FLEX_09;
	}

	public String getULM_FLEX_10() {
		return ULM_FLEX_10;
	}

	public void setULM_FLEX_10(String uLM_FLEX_10) {
		ULM_FLEX_10 = uLM_FLEX_10;
	}

	public String getULM_TLICN_NO() {
		return ULM_TLICN_NO;
	}

	public void setULM_TLICN_NO(String uLM_TLICN_NO) {
		ULM_TLICN_NO = uLM_TLICN_NO;
	}

	public String getULM_POC_PREFIX() {
		return ULM_POC_PREFIX;
	}

	public void setULM_POC_PREFIX(String uLM_POC_PREFIX) {
		ULM_POC_PREFIX = uLM_POC_PREFIX;
	}

	public String getULM_POC_FNAME() {
		return ULM_POC_FNAME;
	}

	public void setULM_POC_FNAME(String uLM_POC_FNAME) {
		ULM_POC_FNAME = uLM_POC_FNAME;
	}

	public String getULM_POC_MNAME() {
		return ULM_POC_MNAME;
	}

	public void setULM_POC_MNAME(String uLM_POC_MNAME) {
		ULM_POC_MNAME = uLM_POC_MNAME;
	}

	public String getULM_POC_LNAME() {
		return ULM_POC_LNAME;
	}

	public void setULM_POC_LNAME(String uLM_POC_LNAME) {
		ULM_POC_LNAME = uLM_POC_LNAME;
	}

	public String getULM_POC_ADDR1() {
		return ULM_POC_ADDR1;
	}

	public void setULM_POC_ADDR1(String uLM_POC_ADDR1) {
		ULM_POC_ADDR1 = uLM_POC_ADDR1;
	}

	public String getULM_POC_ADDR2() {
		return ULM_POC_ADDR2;
	}

	public void setULM_POC_ADDR2(String uLM_POC_ADDR2) {
		ULM_POC_ADDR2 = uLM_POC_ADDR2;
	}

	public String getULM_POC_PINCODE() {
		return ULM_POC_PINCODE;
	}

	public void setULM_POC_PINCODE(String uLM_POC_PINCODE) {
		ULM_POC_PINCODE = uLM_POC_PINCODE;
	}

	public String getULM_POC_CITY() {
		return ULM_POC_CITY;
	}

	public void setULM_POC_CITY(String uLM_POC_CITY) {
		ULM_POC_CITY = uLM_POC_CITY;
	}

	public String getULM_POC_STATE() {
		return ULM_POC_STATE;
	}

	public void setULM_POC_STATE(String uLM_POC_STATE) {
		ULM_POC_STATE = uLM_POC_STATE;
	}

	public String getULM_POC_COUNTRY() {
		return ULM_POC_COUNTRY;
	}

	public void setULM_POC_COUNTRY(String uLM_POC_COUNTRY) {
		ULM_POC_COUNTRY = uLM_POC_COUNTRY;
	}

	public String getULM_POC_MBL_NO() {
		return ULM_POC_MBL_NO;
	}

	public void setULM_POC_MBL_NO(String uLM_POC_MBL_NO) {
		ULM_POC_MBL_NO = uLM_POC_MBL_NO;
	}

	public String getULM_POC_PHONE_NO() {
		return ULM_POC_PHONE_NO;
	}

	public void setULM_POC_PHONE_NO(String uLM_POC_PHONE_NO) {
		ULM_POC_PHONE_NO = uLM_POC_PHONE_NO;
	}

	public String getULM_POC_EMAIL() {
		return ULM_POC_EMAIL;
	}

	public void setULM_POC_EMAIL(String uLM_POC_EMAIL) {
		ULM_POC_EMAIL = uLM_POC_EMAIL;
	}

	public String getULM_WAIVE_INSP_YN() {
		return ULM_WAIVE_INSP_YN;
	}

	public void setULM_WAIVE_INSP_YN(String uLM_WAIVE_INSP_YN) {
		ULM_WAIVE_INSP_YN = uLM_WAIVE_INSP_YN;
	}

	public String getULM_NPT_FEE_AMT() {
		return ULM_NPT_FEE_AMT;
	}

	public void setULM_NPT_FEE_AMT(String uLM_NPT_FEE_AMT) {
		ULM_NPT_FEE_AMT = uLM_NPT_FEE_AMT;
	}

	public String getULM_NPT_FEE_AMT_BC() {
		return ULM_NPT_FEE_AMT_BC;
	}

	public void setULM_NPT_FEE_AMT_BC(String uLM_NPT_FEE_AMT_BC) {
		ULM_NPT_FEE_AMT_BC = uLM_NPT_FEE_AMT_BC;
	}

	public String getULM_NPT_FINFEE_AMT() {
		return ULM_NPT_FINFEE_AMT;
	}

	public void setULM_NPT_FINFEE_AMT(String uLM_NPT_FINFEE_AMT) {
		ULM_NPT_FINFEE_AMT = uLM_NPT_FINFEE_AMT;
	}

	public String getULM_NPT_FINFEE_AMT_BC() {
		return ULM_NPT_FINFEE_AMT_BC;
	}

	public void setULM_NPT_FINFEE_AMT_BC(String uLM_NPT_FINFEE_AMT_BC) {
		ULM_NPT_FINFEE_AMT_BC = uLM_NPT_FINFEE_AMT_BC;
	}

	public String getULM_NPT_COMM_AMT() {
		return ULM_NPT_COMM_AMT;
	}

	public void setULM_NPT_COMM_AMT(String uLM_NPT_COMM_AMT) {
		ULM_NPT_COMM_AMT = uLM_NPT_COMM_AMT;
	}

	public String getULM_NPT_COMM_AMT_BC() {
		return ULM_NPT_COMM_AMT_BC;
	}

	public void setULM_NPT_COMM_AMT_BC(String uLM_NPT_COMM_AMT_BC) {
		ULM_NPT_COMM_AMT_BC = uLM_NPT_COMM_AMT_BC;
	}

	public String getULM_TOT_HOUR() {
		return ULM_TOT_HOUR;
	}

	public void setULM_TOT_HOUR(String uLM_TOT_HOUR) {
		ULM_TOT_HOUR = uLM_TOT_HOUR;
	}

	public String getULM_ENTITY_TYP() {
		return ULM_ENTITY_TYP;
	}

	public void setULM_ENTITY_TYP(String uLM_ENTITY_TYP) {
		ULM_ENTITY_TYP = uLM_ENTITY_TYP;
	}

	public String getULM_DISCLOSURE_YN() {
		return ULM_DISCLOSURE_YN;
	}

	public void setULM_DISCLOSURE_YN(String uLM_DISCLOSURE_YN) {
		ULM_DISCLOSURE_YN = uLM_DISCLOSURE_YN;
	}

	public String getULM_SCHEME_TYP() {
		return ULM_SCHEME_TYP;
	}

	public void setULM_SCHEME_TYP(String uLM_SCHEME_TYP) {
		ULM_SCHEME_TYP = uLM_SCHEME_TYP;
	}

	public String getULM_AGNT_END_NO() {
		return ULM_AGNT_END_NO;
	}

	public void setULM_AGNT_END_NO(String uLM_AGNT_END_NO) {
		ULM_AGNT_END_NO = uLM_AGNT_END_NO;
	}

	public String getULM_GLOBAL_END_NO() {
		return ULM_GLOBAL_END_NO;
	}

	public void setULM_GLOBAL_END_NO(String uLM_GLOBAL_END_NO) {
		ULM_GLOBAL_END_NO = uLM_GLOBAL_END_NO;
	}

	public String getULM_CAN_PAY_MODE() {
		return ULM_CAN_PAY_MODE;
	}

	public void setULM_CAN_PAY_MODE(String uLM_CAN_PAY_MODE) {
		ULM_CAN_PAY_MODE = uLM_CAN_PAY_MODE;
	}

	public String getULM_CO_DOB() {
		return ULM_CO_DOB;
	}

	public void setULM_CO_DOB(String uLM_CO_DOB) {
		ULM_CO_DOB = uLM_CO_DOB;
	}

	public String getULM_HMH_PAYPLAN() {
		return ULM_HMH_PAYPLAN;
	}

	public void setULM_HMH_PAYPLAN(String uLM_HMH_PAYPLAN) {
		ULM_HMH_PAYPLAN = uLM_HMH_PAYPLAN;
	}

	public String getULM_DP_DT() {
		return ULM_DP_DT;
	}

	public void setULM_DP_DT(String uLM_DP_DT) {
		ULM_DP_DT = uLM_DP_DT;
	}

	public String getULM_CO_SSN() {
		return ULM_CO_SSN;
	}

	public void setULM_CO_SSN(String uLM_CO_SSN) {
		ULM_CO_SSN = uLM_CO_SSN;
	}

	public String getULM_UW_TYP() {
		return ULM_UW_TYP;
	}

	public void setULM_UW_TYP(String uLM_UW_TYP) {
		ULM_UW_TYP = uLM_UW_TYP;
	}

	public String getULM_PREM_INV_TYP() {
		return ULM_PREM_INV_TYP;
	}

	public void setULM_PREM_INV_TYP(String uLM_PREM_INV_TYP) {
		ULM_PREM_INV_TYP = uLM_PREM_INV_TYP;
	}

	public String getULM_SPL_ACPT_YN() {
		return ULM_SPL_ACPT_YN;
	}

	public void setULM_SPL_ACPT_YN(String uLM_SPL_ACPT_YN) {
		ULM_SPL_ACPT_YN = uLM_SPL_ACPT_YN;
	}

	public String getULM_POL_TYP() {
		return ULM_POL_TYP;
	}

	public void setULM_POL_TYP(String uLM_POL_TYP) {
		ULM_POL_TYP = uLM_POL_TYP;
	}

	public String getULM_CUST_AGE() {
		return ULM_CUST_AGE;
	}

	public void setULM_CUST_AGE(String uLM_CUST_AGE) {
		ULM_CUST_AGE = uLM_CUST_AGE;
	}

	public String getULM_C_LICN_ISS_DT() {
		return ULM_C_LICN_ISS_DT;
	}

	public void setULM_C_LICN_ISS_DT(String uLM_C_LICN_ISS_DT) {
		ULM_C_LICN_ISS_DT = uLM_C_LICN_ISS_DT;
	}

	public String getULM_C_LICN_EXP_DT() {
		return ULM_C_LICN_EXP_DT;
	}

	public void setULM_C_LICN_EXP_DT(String uLM_C_LICN_EXP_DT) {
		ULM_C_LICN_EXP_DT = uLM_C_LICN_EXP_DT;
	}

	public String getULM_C_GENDER() {
		return ULM_C_GENDER;
	}

	public void setULM_C_GENDER(String uLM_C_GENDER) {
		ULM_C_GENDER = uLM_C_GENDER;
	}

	public String getULM_C_DOB() {
		return ULM_C_DOB;
	}

	public void setULM_C_DOB(String uLM_C_DOB) {
		ULM_C_DOB = uLM_C_DOB;
	}

	public String getULM_C_IDENTIFICATION_ID1() {
		return ULM_C_IDENTIFICATION_ID1;
	}

	public void setULM_C_IDENTIFICATION_ID1(String uLM_C_IDENTIFICATION_ID1) {
		ULM_C_IDENTIFICATION_ID1 = uLM_C_IDENTIFICATION_ID1;
	}

	public String getULM_CMIDDLE_NAME_BL() {
		return ULM_CMIDDLE_NAME_BL;
	}

	public void setULM_CMIDDLE_NAME_BL(String uLM_CMIDDLE_NAME_BL) {
		ULM_CMIDDLE_NAME_BL = uLM_CMIDDLE_NAME_BL;
	}

	public String getULM_INSRD_NAME_BL() {
		return ULM_INSRD_NAME_BL;
	}

	public void setULM_INSRD_NAME_BL(String uLM_INSRD_NAME_BL) {
		ULM_INSRD_NAME_BL = uLM_INSRD_NAME_BL;
	}

	public String getULM_INDEM_PERD() {
		return ULM_INDEM_PERD;
	}

	public void setULM_INDEM_PERD(String uLM_INDEM_PERD) {
		ULM_INDEM_PERD = uLM_INDEM_PERD;
	}

	public String getULM_INDEM_UNIT() {
		return ULM_INDEM_UNIT;
	}

	public void setULM_INDEM_UNIT(String uLM_INDEM_UNIT) {
		ULM_INDEM_UNIT = uLM_INDEM_UNIT;
	}

	public String getULM_PCVR_YN() {
		return ULM_PCVR_YN;
	}

	public void setULM_PCVR_YN(String uLM_PCVR_YN) {
		ULM_PCVR_YN = uLM_PCVR_YN;
	}

	public String getULM_DFLT_TO_INSRD() {
		return ULM_DFLT_TO_INSRD;
	}

	public void setULM_DFLT_TO_INSRD(String uLM_DFLT_TO_INSRD) {
		ULM_DFLT_TO_INSRD = uLM_DFLT_TO_INSRD;
	}

	public String getULM_PROMO_CODE() {
		return ULM_PROMO_CODE;
	}

	public void setULM_PROMO_CODE(String uLM_PROMO_CODE) {
		ULM_PROMO_CODE = uLM_PROMO_CODE;
	}

	public String getULM_SCHD_TEMP_TYP() {
		return ULM_SCHD_TEMP_TYP;
	}

	public void setULM_SCHD_TEMP_TYP(String uLM_SCHD_TEMP_TYP) {
		ULM_SCHD_TEMP_TYP = uLM_SCHD_TEMP_TYP;
	}

	public String getULM_SCHEME_NAME() {
		return ULM_SCHEME_NAME;
	}

	public void setULM_SCHEME_NAME(String uLM_SCHEME_NAME) {
		ULM_SCHEME_NAME = uLM_SCHEME_NAME;
	}

	public String getULM_EXISTING_CUST() {
		return ULM_EXISTING_CUST;
	}

	public void setULM_EXISTING_CUST(String uLM_EXISTING_CUST) {
		ULM_EXISTING_CUST = uLM_EXISTING_CUST;
	}

	public String getULM_SCHEME_TYPE() {
		return ULM_SCHEME_TYPE;
	}

	public void setULM_SCHEME_TYPE(String uLM_SCHEME_TYPE) {
		ULM_SCHEME_TYPE = uLM_SCHEME_TYPE;
	}

	public String getULM_FLEX_15() {
		return ULM_FLEX_15;
	}

	public void setULM_FLEX_15(String uLM_FLEX_15) {
		ULM_FLEX_15 = uLM_FLEX_15;
	}

	public String getULM_C_IDENTIFICATION_ID2() {
		return ULM_C_IDENTIFICATION_ID2;
	}

	public void setULM_C_IDENTIFICATION_ID2(String uLM_C_IDENTIFICATION_ID2) {
		ULM_C_IDENTIFICATION_ID2 = uLM_C_IDENTIFICATION_ID2;
	}

	public String getULM_C_IDENTIFICATION_ID3() {
		return ULM_C_IDENTIFICATION_ID3;
	}

	public void setULM_C_IDENTIFICATION_ID3(String uLM_C_IDENTIFICATION_ID3) {
		ULM_C_IDENTIFICATION_ID3 = uLM_C_IDENTIFICATION_ID3;
	}

	public String getULM_PRV_INSR_POL_NO() {
		return ULM_PRV_INSR_POL_NO;
	}

	public void setULM_PRV_INSR_POL_NO(String uLM_PRV_INSR_POL_NO) {
		ULM_PRV_INSR_POL_NO = uLM_PRV_INSR_POL_NO;
	}

	public String getULM_CUST_VAT_TYP() {
		return ULM_CUST_VAT_TYP;
	}

	public void setULM_CUST_VAT_TYP(String uLM_CUST_VAT_TYP) {
		ULM_CUST_VAT_TYP = uLM_CUST_VAT_TYP;
	}

	public String getULM_CUST_VAT_YN() {
		return ULM_CUST_VAT_YN;
	}

	public void setULM_CUST_VAT_YN(String uLM_CUST_VAT_YN) {
		ULM_CUST_VAT_YN = uLM_CUST_VAT_YN;
	}

	public String getULM_CUST_TAX_ID() {
		return ULM_CUST_TAX_ID;
	}

	public void setULM_CUST_TAX_ID(String uLM_CUST_TAX_ID) {
		ULM_CUST_TAX_ID = uLM_CUST_TAX_ID;
	}

	public String getULM_NB_VAT_AMT() {
		return ULM_NB_VAT_AMT;
	}

	public void setULM_NB_VAT_AMT(String uLM_NB_VAT_AMT) {
		ULM_NB_VAT_AMT = uLM_NB_VAT_AMT;
	}

	public String getULM_NB_VAT_AMT_BC() {
		return ULM_NB_VAT_AMT_BC;
	}

	public void setULM_NB_VAT_AMT_BC(String uLM_NB_VAT_AMT_BC) {
		ULM_NB_VAT_AMT_BC = uLM_NB_VAT_AMT_BC;
	}

	public String getULM_NB_PARTY_VAT_YN() {
		return ULM_NB_PARTY_VAT_YN;
	}

	public void setULM_NB_PARTY_VAT_YN(String uLM_NB_PARTY_VAT_YN) {
		ULM_NB_PARTY_VAT_YN = uLM_NB_PARTY_VAT_YN;
	}

	public String getULM_NB_PARTY_VAT_TYP() {
		return ULM_NB_PARTY_VAT_TYP;
	}

	public void setULM_NB_PARTY_VAT_TYP(String uLM_NB_PARTY_VAT_TYP) {
		ULM_NB_PARTY_VAT_TYP = uLM_NB_PARTY_VAT_TYP;
	}

	public String getULM_NB_PARTY_VAT_ID() {
		return ULM_NB_PARTY_VAT_ID;
	}

	public void setULM_NB_PARTY_VAT_ID(String uLM_NB_PARTY_VAT_ID) {
		ULM_NB_PARTY_VAT_ID = uLM_NB_PARTY_VAT_ID;
	}

}

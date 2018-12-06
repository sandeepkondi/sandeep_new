package com.beyontec.mol.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.MappedSuperclass;

@Inheritance
@MappedSuperclass
public class PolicyBase {
    //@formatter:off
    @Column(name = "ULM_TYP")                   protected String type;
    @Column(name = "ULM_NO")                    protected String number;
    @Column(name = "ULM_PRV_LINK_NO")           protected String previousLinkNumber;
    @Column(name = "ULM_PRV_LINK_VER_NO")       protected Long previousLinkVersionNumber;
    @Column(name = "ULM_LVL1_NO")               protected String level1Number;
    @Column(name = "ULM_LVL1_ITR_NO")           protected String level1ItrNumber;
    @Column(name = "ULM_LVL2_NO")               protected String level2Number;
    @Column(name = "ULM_LVL2_ITR_NO")           protected String level2ItrNumber;
    @Column(name = "ULM_COMP_ID")               protected String companyId;
    @Column(name = "ULM_DIVN_ID")               protected String divnId;
    @Column(name = "ULM_DEPT_ID")               protected String departmentId;
    @Column(name = "ULM_PROD_ID")               protected String productId;
    @Column(name = "ULM_ISSUE_DATE")            protected Date issuedDate;
    @Column(name = "ULM_FMD")                   protected Date fromDate;
    @Column(name = "ULM_TOD")                   protected Date toDate;
    @Column(name = "ULM_PERIOD_UNIT")           protected String periodUnit;
    @Column(name = "ULM_PERIOD")                protected Long period;
    @Column(name = "ULM_VALID_DAYS")            protected Long validDays;
    @Column(name = "ULM_PREM_CALC_TYP")         protected String premiumCalculationType;
    @Column(name = "ULM_AGENT_ID")              protected String agentId;
    @Column(name = "ULM_BSRC_ID")               protected String bSourceId;
    @Column(name = "ULM_BTYP_ID")               protected String bTypeId;
    @Column(name = "ULM_STATUS")                protected String status;
    @Column(name = "ULM_AMND_NO")               protected String amendmentNumber;
    @Column(name = "ULM_CUST_ID")               protected String customerId;
    @Column(name = "ULM_ADDR_REF_ID")           protected String addressReferenceId;
    @Column(name = "ULM_CONT_REF_ID")           protected String contactReferenceId;
    @Column(name = "ULM_INSRD_ID")              protected String insuredId;
    @Column(name = "ULM_INSRD_NAME")            protected String insuredName;
    @Column(name = "ULM_CVR_NOTE_NO")           protected String cvrNoteNumber;
    @Column(name = "ULM_CVR_NOTE_DATE")         protected Date cvrNoteDate;
    @Column(name = "ULM_CVR_NOTE_BOOK_ID")      protected String cvrNoteBookId;
    @Column(name = "ULM_OP_POL_NO")             protected String opPolNumber;
    @Column(name = "ULM_PRV_POL_NO")            protected String prvPolNumber;
    @Column(name = "ULM_REC_TYP")               protected String recordType;
    @Column(name = "ULM_CUST_ACC_ID")           protected String customerAccountId;
    @Column(name = "ULM_ITR_NO")                protected String itrNumber;
    @Column(name = "ULM_ITR_VER_NO")            protected Long itrVersionNumber;
    @Column(name = "ULM_PERIOD_TYP")            protected String periodType;
    @Column(name = "ULM_CUST_PRV_ADD_YRS")      protected Long customerPreviousAddYears;
    @Column(name = "ULM_PAYOR_ID")              protected String payorId;
    @Column(name = "ULM_PAYOR_ADDR_REF_ID")     protected String payorAddressRefId;
    @Column(name = "ULM_BILL_TYP")              protected String billType;
    @Column(name = "ULM_UI_INST_ID")            protected String uiInstId;
    @Column(name = "ULM_PAYOR_TYP")             protected String payorType;
    @Column(name = "ULM_APD")                   protected Date approvalDate;
    @Column(name = "ULM_PRV_INSURED_YN")        protected String previousInsuredYn;
    @Column(name = "ULM_PRV_INSURED_NAME")      protected String previousInsuredName;
    @Column(name = "ULM_TERM")                  protected String term;
    @Column(name = "ULM_CRU")                   protected String createdUser;
    @Column(name = "ULM_CRD")                   protected Date createdDate;
    @Column(name = "ULM_PRIORITY")              protected Long priority;
    @Column(name = "ULM_DUE_ON")                protected Date dueOn;
    @Column(name = "ULM_AC_PROC_YN")            protected String acProcYn;
    @Column(name = "ULM_AMND_TYP")              protected String amendmentType;
    @Column(name = "ULM_AMND_SUB_TYP")          protected String amendmentSubType;
    @Column(name = "ULM_AMND_FMD")              protected Date amendmentFromDate;
    @Column(name = "ULM_AMND_TOD")              protected Date amendmentToDate;
    @Column(name = "ULM_AMND_REMARKS")          protected String amendmentRemarks;
    @Column(name = "ULM_CUST_TYP")              protected String customerType;
    @Column(name = "ULM_LVL1_SGS_ID")           protected Long level1SgsId;
    @Column(name = "ULM_LVL2_SGS_ID")           protected Long level2SgsId;
    @Column(name = "ULM_LVL3_SGS_ID")           protected Long level3SgsId;
    @Column(name = "ULM_LVL3_NO")               protected String level3Number;
    @Column(name = "ULM_SRC_SGS_ID")            protected Long sourceSgsId;
    @Column(name = "ULM_SRS_AMND_VER_NO")       protected Long srsAmendmentVersionNumber;
    @Column(name = "ULM_LVL3_ITR_NO")           protected String level3ItrNumber;
    @Column(name = "ULM_SRC_AMND_VER_NO")       protected Long srcAmendmentVersionNumber;
    @Column(name = "ULM_CRU_ROLE")              protected String cruRole;
    @Column(name = "ULM_REN_SEQ_NO")            protected Long renSequenceNumber;
    @Column(name = "ULM_FLT_YN")                protected String fltYn;
    @Column(name = "ULM_OSE_AMND_VER_NO")       protected Long oseAmendmentVersionNumber;
    @Column(name = "ULM_OSE_YN")                protected String oseYn;
    @Column(name = "ULM_OSE_ORD_NO")            protected Long oseOrderNumber;
    @Column(name = "ULM_OSE_REF_SGS_ID")        protected Long oseReferenceSgsId;
    @Column(name = "ULM_PRM_CURR")              protected String prmCurr;
    @Column(name = "ULM_PRM_CURR_ID")           protected String prmCurrId;
    @Column(name = "ULM_PRM_CURR_X_RATE")       protected Long prmCurrXRate;
    @Column(name = "ULM_MST_REF_NO")            protected String mstRefNumber;
    @Column(name = "ULM_MST_REF_SGS_ID")        protected Long mstRefSgsId;
    @Column(name = "ULM_MST_REF_AMND_VER_NO")   protected Long mstRefAmendmentVersionNumber;
    @Column(name = "ULM_AMND_RSN")              protected String amendmentReason;
    @Column(name = "ULM_CARRIER_ID")            protected String carrierId;
    @Column(name = "ULM_TMPL_TYP")              protected String templateType;
    @Column(name = "ULM_TMPL_ID")               protected Long templateId;
    @Column(name = "ULM_CANCEL_PC_TYP")         protected String cancelPcType;
    @Column(name = "ULM_LVL1_TYP")              protected String level1Type;
    @Column(name = "ULM_LVL2_TYP")              protected String level2Type;
    @Column(name = "ULM_EXPD")                  protected Date expiryDate;
    @Column(name = "ULM_RATE_LVL")              protected String rateLevel;
    @Column(name = "ULM_COMM_CURR_ID")          protected String commCurrId;
    @Column(name = "ULM_COMM_CURR")             protected String commCurr;
    @Column(name = "ULM_CANCEL_DT")             protected Date cancelDate;
    @Column(name = "ULM_REINS_DT")              protected Date reinsureDate;
    @Column(name = "ULM_FCL")                   protected Long fcl;
    @Column(name = "ULM_FCL_BC")                protected Long fclBc;
    @Column(name = "ULM_EQ_TYP")                protected String eqType;
    @Column(name = "ULM_DEP_PREM")              protected Long depPrem;
    @Column(name = "ULM_DEP_PREM_BC")           protected Long depPremBc;
    @Column(name = "ULM_ACNT_REF_NO")           protected String accountRefNumber;
    @Column(name = "ULM_INS_POL_NO")            protected String insurancePolNumber;
    @Column(name = "ULM_INS_LA_NO")             protected String insuranceLaNumber;
    @Column(name = "ULM_ENDT_INST_TYP")         protected String endtInstType;
    @Column(name = "ULM_CARRIER_BR_ID")         protected String carrierBrId;
    @Column(name = "ULM_INSINT_DESC")           protected String insintDesc;
    @Column(name = "ULM_POL_ACNT_YEAR")         protected Long polAcntYear;
    @Column(name = "ULM_WAIVE_FEE_YN")          protected String waiveFeeYn;
    @Column(name = "ULM_RET_MP_YN")             protected String retMpYn;
    @Column(name = "ULM_COVER_NOTE_TOD")        protected Date coverNoteToDate;
    @Column(name = "ULM_APU")                   protected String apu;
    @Column(name = "ULM_CARRIER_STATE")         protected String carrierState;
    @Column(name = "ULM_CARRIER_GRP_ID")        protected String carrierGroupId;
    @Column(name = "ULM_UPLOAD_SRC")            protected String uploadSource;
    @Column(name = "ULM_DNR_REASON")            protected String dnrReason;
    @Column(name = "ULM_CAN_PAYEE")             protected String canPayee;
    @Column(name = "ULM_CRW_NO")                protected String crewNumber;
    @Column(name = "ULM_DECL_PRD_TYP")          protected String declPeriodType;
    @Column(name = "ULM_CARRIER_ZIP_CODE")      protected String carrierZipCode;
    @Column(name = "ULM_NAT_OF_BUS")            protected String nationalityOfBus;
    @Column(name = "ULM_CLASS_FACTOR")          protected String classFactor;
    @Column(name = "ULM_RATE_FRZ")              protected String rateFrz;
    @Column(name = "ULM_SA_FACTOR")             protected Long factor;
    @Column(name = "ULM_DESC1")                 protected String desc1;
    @Column(name = "ULM_ACCT_CUST_LVL")         protected String accountCustomerLevel;
    @Column(name = "ULM_TTY_REQ_YN")            protected String ttyReqYn;
    @Column(name = "ULM_CO_LAST_NAME")          protected String coLastName;
    @Column(name = "ULM_CO_FIRST_NAME")         protected String coFirstName;
    @Column(name = "ULM_CO_MIDDLE_NAME")        protected String coMiddleName;
    @Column(name = "ULM_OR_ADDRINT_YN")         protected String orAddrintYn;
    @Column(name = "ULM_ORG_TOD")               protected Date orgToDate;
    @Column(name = "ULM_REN_ORG_SGS_ID")        protected Long renOrgSgsId;
    @Column(name = "ULM_SUB_DATE")              protected Date subDate;
    @Column(name = "ULM_NL_DESC")               protected String nlDesc;
    @Column(name = "ULM_NL_FMD")                protected Date nlFromDate;
    @Column(name = "ULM_NL_TOD")                protected Date nlToDate;
    @Column(name = "ULM_PPW_DAYS")              protected Long ppwDays;
    @Column(name = "ULM_BC_ID")                 protected String bcId;
    @Column(name = "ULM_EXP_DT_CHG")            protected String expDateChg;
    @Column(name = "ULM_EQTY_DT")               protected Date eqtyDate;
    @Column(name = "ULM_CNAME")                 protected String cName;
    @Column(name = "ULM_CADDR_1")               protected String cAddress1;
    @Column(name = "ULM_CADDR_2")               protected String cAddress2;
    @Column(name = "ULM_CADDR_3")               protected String cAddress3;
    @Column(name = "ULM_CADDR_4")               protected String cAddress4;
    @Column(name = "ULM_CPIN_CODE")             protected String cPinCode;
    @Column(name = "ULM_CCITY")                 protected String cCity;
    @Column(name = "ULM_CSTATE")                protected String cState;
    @Column(name = "ULM_CCOUNTRY")              protected String cCountry;
    @Column(name = "ULM_REN_PAYOR_TYP")         protected String renPayorType;
    @Column(name = "ULM_ACNT_REF2_NO")          protected String accountRef2Number;
    @Column(name = "ULM_REN_PAYOR_ID")          protected String renPayorId;
    @Column(name = "ULM_INT_SHARE_PERC")        protected Long intSharePerc;
    @Column(name = "ULM_BAT_ID")                protected String batId;
    @Column(name = "ULM_SHARE_PERC")            protected Long sharePerc;
    @Column(name = "ULM_L1_AGT_ID")             protected String l1AgtId;
    @Column(name = "ULM_L2_AGT_ID")             protected String l2AgtId;
    @Column(name = "ULM_L3_AGT_ID")             protected String l3AgtId;
    @Column(name = "ULM_L4_AGT_ID")             protected String l4AgtId;
    @Column(name = "ULM_L5_AGT_ID")             protected String l5AgtId;
    @Column(name = "ULM_PERIOD_CATG_TYP")       protected String periodCatgType;
    @Column(name = "ULM_PERIOD_MONTHS")         protected Long periodMonths;
    @Column(name = "ULM_PERIOD_DAYS")           protected Long periodDays;
    @Column(name = "ULM_SUB_STATUS")            protected String subStatus;
    @Column(name = "ULM_RISK_TYP")              protected String riskType;
    @Column(name = "ULM_CFIRST_NAME")           protected String cFirstName;
    @Column(name = "ULM_CMIDDLE_NAME")          protected String cMiddleName;
    @Column(name = "ULM_CLAST_NAME")            protected String cLastName;
    @Column(name = "ULM_INSR_HO_YN")            protected String insrHoYn;
    @Column(name = "ULM_PRE_DISC_YN")           protected String previousDiscYn;
    @Column(name = "ULM_EFT_DISC_YN")           protected String eftDiscYn;
    @Column(name = "ULM_PRIOR_DISC_YN")         protected String priorDiscYn;
    @Column(name = "ULM_PROG_TYP")              protected String programType;
    @Column(name = "ULM_CO_APPL_YN")            protected String coApplYn;
    @Column(name = "ULM_CO_INSR_YN")            protected String coInsrYn;
    @Column(name = "ULM_NAMED_NON_OW_YN")       protected String namedNonOwYn;
    @Column(name = "ULM_INSR_SUFFIX")           protected String insrSuffix;
    @Column(name = "ULM_CO_SUFFIX")             protected String coSuffix;
    @Column(name = "ULM_PD_FUL_DISC_YN")        protected String pdFulDiscYn;
    @Column(name = "ULM_REIN_FEE_YN")           protected String reinFeeYn;
    @Column(name = "ULM_MAN_REN_YN")            protected String manRenYn;
    @Column(name = "ULM_REN_DISC_YN")           protected String renDiscYn;
    @Column(name = "ULM_DEP_PREM_YN")           protected String depPremYn;
    @Column(name = "ULM_FLAT_CAN_YN")           protected String flatCanYn;
    @Column(name = "ULM_FLEX_01")               protected String flex01;
    @Column(name = "ULM_FLEX_02")               protected String flex02;
    @Column(name = "ULM_FLEX_03")               protected String flex03;
    @Column(name = "ULM_FLEX_04")               protected String flex04;
    @Column(name = "ULM_FLEX_05")               protected String flex05;
    @Column(name = "ULM_RISK_ADD_1")            protected String riskAddress1;
    @Column(name = "ULM_RISK_ADD_2")            protected String riskAddress2;
    @Column(name = "ULM_RISK_ADD_3")            protected String riskAddress3;
    @Column(name = "ULM_RISK_ADD_4")            protected String riskAddress4;
    @Column(name = "ULM_RISK_PIN_CODE")         protected String riskPinCode;
    @Column(name = "ULM_RISK_CITY")             protected String riskCity;
    @Column(name = "ULM_RISK_STATE")            protected String riskState;
    @Column(name = "ULM_RISK_COUNTRY")          protected String riskCountry;
    @Column(name = "ULM_RSK_ADD_SAME_YN")       protected String riskAddressSameYn;
    @Column(name = "ULM_PREFIX_NAME")           protected String prefixName;
    @Column(name = "ULM_PREFIX_NAME_BL")        protected String prefixNameBl;
    @Column(name = "ULM_CNAME_BL")              protected String cNameBl;
    @Column(name = "ULM_CFIRST_NAME_BL")        protected String cFirstNameBl;
    @Column(name = "ULM_CLAST_NAME_BL")         protected String cLastNameBl;
    @Column(name = "ULM_REN_TPI_STS")           protected String renTpiSts;
    @Column(name = "ULM_CPY_PHONE_NO")          protected String cpyPhoneNumber;
    @Column(name = "ULM_CPY_MOBILE_NO")         protected String cpyMobileNumber;
    @Column(name = "ULM_CFAX_NO")               protected String cFaxNumber;
    @Column(name = "ULM_CPY_EMAIL_ID")          protected String cpyEmailId;
    @Column(name = "ULM_CR_LEVEL")              protected String crLevel;
    @Column(name = "ULM_CR_EXP_ALLOWED")        protected String crExpAllowed;
    @Column(name = "ULM_PUN_DMG_YN")            protected String punDmgYn;
    @Column(name = "ULM_ESIGN_NO")              protected String eSignNumber;
    @Column(name = "ULM_NATIONALITY")           protected String nationality;
    @Column(name = "ULM_OCCUPATION")            protected String occupation;
    @Column(name = "ULM_O_CUST_ID")             protected String oCustId;
    @Column(name = "ULM_CWK_PHONE_NO")          protected String cwkPhoneNumber;
    @Column(name = "ULM_POST_DOC")              protected String postDoc;
    @Column(name = "ULM_QUOT_COND_ACCEPT_YN")   protected String quotCondAcceptYn;
    @Column(name = "ULM_POL_SRC")               protected String polSource;
    @Column(name = "ULM_PRV_EXP_DT")            protected Date previousExpiryDate;
    @Column(name = "ULM_HOME_TYP")              protected String homeType;
    @Column(name = "ULM_CADDR_5")               protected String cAddress5;
    @Column(name = "ULM_PDOACM_YN")             protected String pdOacmYn;
    @Column(name = "ULM_LBOACM_YN")             protected String lbOacmYn;
    @Column(name = "ULM_RATE_DATE")             protected Date rateDate;
    @Column(name = "ULM_CUST_DESC")             protected String custDesc;
    @Column(name = "ULM_AC_SCORE")              protected Long acSource;
    @Column(name = "ULM_DNR_REMARKS")           protected String dnrRemarks;
    @Column(name = "ULM_EPRINT_YN")             protected String ePrintYn;
    @Column(name = "ULM_REMARKS_BL_YN")         protected String remarksBlYn;
    @Column(name = "ULM_FRCOMP_ID")             protected String frCompId;
    @Column(name = "ULM_REFF_YN")               protected String reffYn;
    @Column(name = "ULM_DECL_USR")              protected String declUser;
    @Column(name = "ULM_DECL_DT")               protected Date declDate;
    @Column(name = "ULM_REN_POL_NO")            protected String renPolNumber;
    @Column(name = "ULM_AGT_ADDR_1")            protected String agtAddress1;
    @Column(name = "ULM_AGT_ADDR_2")            protected String agtAddress2;
    @Column(name = "ULM_AGT_ADDR_3")            protected String agtAddress3;
    @Column(name = "ULM_AGT_ADDR_4")            protected String agtAddress4;
    @Column(name = "ULM_AGT_PIN_CODE")          protected String agtPinCode;
    @Column(name = "ULM_AGT_CITY")              protected String agtCity;
    @Column(name = "ULM_AGT_STATE")             protected String agtState;
    @Column(name = "ULM_AGT_COUNTRY")           protected String agtCountry;
    @Column(name = "ULM_AGT_PHONE_NO")          protected String agtPhoneNumber;
    @Column(name = "ULM_COINS_FLAG")            protected String coinsFlag;
    @Column(name = "ULM_SI_CURR")               protected String siCurr;
    @Column(name = "ULM_SI_CURR_ID")            protected String siCurrId;
    @Column(name = "ULM_PREM")                  protected Long prem;
    @Column(name = "ULM_PREM_BC")               protected Long premBc;
    @Column(name = "ULM_SI_X_RATE")             protected Long siXRate;
    @Column(name = "ULM_SI_LIMIT")              protected Long siLimit;
    @Column(name = "ULM_SI_LIMIT_BC")           protected Long siLimitBc;
    @Column(name = "ULM_NB_TYP")                protected String nbType;
    @Column(name = "ULM_COMM_X_RATE")           protected Long commXRate;
    @Column(name = "ULM_COMM")                  protected Long comm;
    @Column(name = "ULM_COMM_BC")               protected Long commBc;
    @Column(name = "ULM_AE_ID")                 protected String aeId;
    @Column(name = "ULM_SM_ID")                 protected String smId;
    @Column(name = "ULM_RISK_BUSS_DESC")        protected String riskBussDesc;
    @Column(name = "ULM_RISK_OCC")              protected String riskOcc;
    @Column(name = "ULM_RISK_OCC_DESC")         protected String riskOccDesc;
    @Column(name = "ULM_RISK_COUNT")            protected Long riskCount;
    @Column(name = "ULM_COMM_DISC_PER")         protected Long commDiscPer;
    @Column(name = "ULM_COMM_DISC_RATE_PER")    protected Long commDiscRatePer;
    @Column(name = "ULM_CUST_POL_TYP")          protected String custPolType;
    @Column(name = "ULM_CR_SCORE")              protected String crScore;
    @Column(name = "ULM_PRV_FM_DT")             protected Date previousFromDate;
    @Column(name = "ULM_INS_AMND_NO")           protected String insAmendmentNumber;
    @Column(name = "ULM_NCF_STATUS")            protected String ncfStatus;
    @Column(name = "ULM_NCF_MSG")               protected String ncfMessage;
    @Column(name = "ULM_CCF_FLAG")              protected String ccfFlag;
    @Column(name = "ULM_FLEX_06")               protected String flex06;
    @Column(name = "ULM_FLEX_07")               protected String flex07;
    @Column(name = "ULM_FLEX_08")               protected String flex08;
    @Column(name = "ULM_FLEX_09")               protected String flex09;
    @Column(name = "ULM_FLEX_10")               protected String flex10;
    @Column(name = "ULM_TLICN_NO")              protected String tlicnNumber;
    @Column(name = "ULM_POC_PREFIX")            protected String pocPrefix;
    @Column(name = "ULM_POC_FNAME")             protected String pocFirstName;
    @Column(name = "ULM_POC_MNAME")             protected String pocMiddleName;
    @Column(name = "ULM_POC_LNAME")             protected String pocLastName;
    @Column(name = "ULM_POC_ADDR1")             protected String pocAddress1;
    @Column(name = "ULM_POC_ADDR2")             protected String pocAddress2;
    @Column(name = "ULM_POC_PINCODE")           protected String pocPincode;
    @Column(name = "ULM_POC_CITY")              protected String pocCity;
    @Column(name = "ULM_POC_STATE")             protected String pocState;
    @Column(name = "ULM_POC_COUNTRY")           protected String pocCountry;
    @Column(name = "ULM_POC_MBL_NO")            protected String pocMobileNumber;
    @Column(name = "ULM_POC_PHONE_NO")          protected String pocPhoneNumber;
    @Column(name = "ULM_POC_EMAIL")             protected String pocEmail;
    @Column(name = "ULM_WAIVE_INSP_YN")         protected String waiveInspYn;
    @Column(name = "ULM_NPT_FEE_AMT")           protected Long nptFeeAmount;
    @Column(name = "ULM_NPT_FEE_AMT_BC")        protected Long nptFeeAmountBc;
    @Column(name = "ULM_NPT_FINFEE_AMT")        protected Long nptFinFeeAmount;
    @Column(name = "ULM_NPT_FINFEE_AMT_BC")     protected Long nptFinFeeAmountBc;
    @Column(name = "ULM_NPT_COMM_AMT")          protected Long nptCommAmount;
    @Column(name = "ULM_NPT_COMM_AMT_BC")       protected Long nptCommAmountBc;
    @Column(name = "ULM_TOT_HOUR")              protected Long totHour;
    @Column(name = "ULM_ENTITY_TYP")            protected String entityType;
    @Column(name = "ULM_DISCLOSURE_YN")         protected String disclosureYn;
    @Column(name = "ULM_SCHEME_TYP")            protected String schemeTyp;
    @Column(name = "ULM_AGNT_END_NO")           protected String agentEndNumber;
    @Column(name = "ULM_GLOBAL_END_NO")         protected String globalEndNumber;
    @Column(name = "ULM_CAN_PAY_MODE")          protected String canPayMode;
    @Column(name = "ULM_CO_DOB")                protected Date coDateOfBirth;
    @Column(name = "ULM_HMH_PAYPLAN")           protected String hmhPayPlan;
    @Column(name = "ULM_DP_DT")                 protected Date dpDate;
    @Column(name = "ULM_CO_SSN")                protected String coSsn;
    @Column(name = "ULM_UW_TYP")                protected String uwType;
    @Column(name = "ULM_PREM_INV_TYP")          protected String premInvType;
    @Column(name = "ULM_SPL_ACPT_YN")           protected String splAcptYn;
    @Column(name = "ULM_POL_TYP")               protected String polType;
    @Column(name = "ULM_CUST_AGE")              protected Long custAge;
    @Column(name = "ULM_C_LICN_ISS_DT")         protected Date cLicenseIssuedDate;
    @Column(name = "ULM_C_LICN_EXP_DT")         protected Date cLicenseExpiryDate;
    @Column(name = "ULM_C_GENDER")              protected String cGender;
    @Column(name = "ULM_C_DOB")                 protected Date cDateOfBirth;
    @Column(name = "ULM_C_IDENTIFICATION_ID1")  protected String cIdentificationId1;
    @Column(name = "ULM_CMIDDLE_NAME_BL")       protected String cMiddleNameBl;
    @Column(name = "ULM_INSRD_NAME_BL")         protected String insuredNameBl;
    @Column(name = "ULM_INDEM_PERD")            protected Long indemPeriod;
    @Column(name = "ULM_INDEM_UNIT")            protected String indecUnit;
    @Column(name = "ULM_PCVR_YN")               protected String pcvrYn;
    @Column(name = "ULM_DFLT_TO_INSRD")         protected String dfltToInsured;
    @Column(name = "ULM_PROMO_CODE")            protected String promoCode;
    @Column(name = "ULM_SCHD_TEMP_TYP")         protected String schdTempType;
    @Column(name = "ULM_SCHEME_NAME")           protected String schemeName;
    @Column(name = "ULM_EXISTING_CUST")         protected String existingCustomer;
    @Column(name = "ULM_SCHEME_TYPE")           protected String schemeType;
    @Column(name = "ULM_FLEX_15")               protected String flex15;
    @Column(name = "ULM_C_IDENTIFICATION_ID2")  protected String cIdentificationId2;
    @Column(name = "ULM_C_IDENTIFICATION_ID3")  protected String cIdentificationId3;
    @Column(name = "ULM_PRV_INSR_POL_NO")       protected String previousInsrPolNumber;
    @Column(name = "ULM_CUST_VAT_TYP")          protected String custVatType;
    @Column(name = "ULM_CUST_VAT_YN")           protected String custVatYn;
    @Column(name = "ULM_CUST_TAX_ID")           protected String custTaxId;
    @Column(name = "ULM_NB_VAT_AMT")            protected Long nbVatAmount;
    @Column(name = "ULM_NB_VAT_AMT_BC")         protected Long nbVatAmountBc;
    @Column(name = "ULM_NB_PARTY_VAT_YN")       protected String nbPartyVatYn;
    @Column(name = "ULM_NB_PARTY_VAT_TYP")      protected String nbPartyVatType;
    @Column(name = "ULM_NB_PARTY_VAT_ID")       protected String nbPartyVatId;
    //@formatter:on

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPreviousLinkNumber() {
        return previousLinkNumber;
    }

    public void setPreviousLinkNumber(String previousLinkNumber) {
        this.previousLinkNumber = previousLinkNumber;
    }

    public Long getPreviousLinkVersionNumber() {
        return previousLinkVersionNumber;
    }

    public void setPreviousLinkVersionNumber(Long previousLinkVersionNumber) {
        this.previousLinkVersionNumber = previousLinkVersionNumber;
    }

    public String getLevel1Number() {
        return level1Number;
    }

    public void setLevel1Number(String level1Number) {
        this.level1Number = level1Number;
    }

    public String getLevel1ItrNumber() {
        return level1ItrNumber;
    }

    public void setLevel1ItrNumber(String level1ItrNumber) {
        this.level1ItrNumber = level1ItrNumber;
    }

    public String getLevel2Number() {
        return level2Number;
    }

    public void setLevel2Number(String level2Number) {
        this.level2Number = level2Number;
    }

    public String getLevel2ItrNumber() {
        return level2ItrNumber;
    }

    public void setLevel2ItrNumber(String level2ItrNumber) {
        this.level2ItrNumber = level2ItrNumber;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getDivnId() {
        return divnId;
    }

    public void setDivnId(String divnId) {
        this.divnId = divnId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getPeriodUnit() {
        return periodUnit;
    }

    public void setPeriodUnit(String periodUnit) {
        this.periodUnit = periodUnit;
    }

    public Long getPeriod() {
        return period;
    }

    public void setPeriod(Long period) {
        this.period = period;
    }

    public Long getValidDays() {
        return validDays;
    }

    public void setValidDays(Long validDays) {
        this.validDays = validDays;
    }

    public String getPremiumCalculationType() {
        return premiumCalculationType;
    }

    public void setPremiumCalculationType(String premiumCalculationType) {
        this.premiumCalculationType = premiumCalculationType;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getbSourceId() {
        return bSourceId;
    }

    public void setbSourceId(String bSourceId) {
        this.bSourceId = bSourceId;
    }

    public String getbTypeId() {
        return bTypeId;
    }

    public void setbTypeId(String bTypeId) {
        this.bTypeId = bTypeId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAmendmentNumber() {
        return amendmentNumber;
    }

    public void setAmendmentNumber(String amendmentNumber) {
        this.amendmentNumber = amendmentNumber;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getAddressReferenceId() {
        return addressReferenceId;
    }

    public void setAddressReferenceId(String addressReferenceId) {
        this.addressReferenceId = addressReferenceId;
    }

    public String getContactReferenceId() {
        return contactReferenceId;
    }

    public void setContactReferenceId(String contactReferenceId) {
        this.contactReferenceId = contactReferenceId;
    }

    public String getInsuredId() {
        return insuredId;
    }

    public void setInsuredId(String insuredId) {
        this.insuredId = insuredId;
    }

    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }

    public String getCvrNoteNumber() {
        return cvrNoteNumber;
    }

    public void setCvrNoteNumber(String cvrNoteNumber) {
        this.cvrNoteNumber = cvrNoteNumber;
    }

    public Date getCvrNoteDate() {
        return cvrNoteDate;
    }

    public void setCvrNoteDate(Date cvrNoteDate) {
        this.cvrNoteDate = cvrNoteDate;
    }

    public String getCvrNoteBookId() {
        return cvrNoteBookId;
    }

    public void setCvrNoteBookId(String cvrNoteBookId) {
        this.cvrNoteBookId = cvrNoteBookId;
    }

    public String getOpPolNumber() {
        return opPolNumber;
    }

    public void setOpPolNumber(String opPolNumber) {
        this.opPolNumber = opPolNumber;
    }

    public String getPrvPolNumber() {
        return prvPolNumber;
    }

    public void setPrvPolNumber(String prvPolNumber) {
        this.prvPolNumber = prvPolNumber;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getCustomerAccountId() {
        return customerAccountId;
    }

    public void setCustomerAccountId(String customerAccountId) {
        this.customerAccountId = customerAccountId;
    }

    public String getItrNumber() {
        return itrNumber;
    }

    public void setItrNumber(String itrNumber) {
        this.itrNumber = itrNumber;
    }

    public Long getItrVersionNumber() {
        return itrVersionNumber;
    }

    public void setItrVersionNumber(Long itrVersionNumber) {
        this.itrVersionNumber = itrVersionNumber;
    }

    public String getPeriodType() {
        return periodType;
    }

    public void setPeriodType(String periodType) {
        this.periodType = periodType;
    }

    public Long getCustomerPreviousAddYears() {
        return customerPreviousAddYears;
    }

    public void setCustomerPreviousAddYears(Long customerPreviousAddYears) {
        this.customerPreviousAddYears = customerPreviousAddYears;
    }

    public String getPayorId() {
        return payorId;
    }

    public void setPayorId(String payorId) {
        this.payorId = payorId;
    }

    public String getPayorAddressRefId() {
        return payorAddressRefId;
    }

    public void setPayorAddressRefId(String payorAddressRefId) {
        this.payorAddressRefId = payorAddressRefId;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public String getUiInstId() {
        return uiInstId;
    }

    public void setUiInstId(String uiInstId) {
        this.uiInstId = uiInstId;
    }

    public String getPayorType() {
        return payorType;
    }

    public void setPayorType(String payorType) {
        this.payorType = payorType;
    }

    public Date getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }

    public String getPreviousInsuredYn() {
        return previousInsuredYn;
    }

    public void setPreviousInsuredYn(String previousInsuredYn) {
        this.previousInsuredYn = previousInsuredYn;
    }

    public String getPreviousInsuredName() {
        return previousInsuredName;
    }

    public void setPreviousInsuredName(String previousInsuredName) {
        this.previousInsuredName = previousInsuredName;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
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

    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }

    public Date getDueOn() {
        return dueOn;
    }

    public void setDueOn(Date dueOn) {
        this.dueOn = dueOn;
    }

    public String getAcProcYn() {
        return acProcYn;
    }

    public void setAcProcYn(String acProcYn) {
        this.acProcYn = acProcYn;
    }

    public String getAmendmentType() {
        return amendmentType;
    }

    public void setAmendmentType(String amendmentType) {
        this.amendmentType = amendmentType;
    }

    public String getAmendmentSubType() {
        return amendmentSubType;
    }

    public void setAmendmentSubType(String amendmentSubType) {
        this.amendmentSubType = amendmentSubType;
    }

    public Date getAmendmentFromDate() {
        return amendmentFromDate;
    }

    public void setAmendmentFromDate(Date amendmentFromDate) {
        this.amendmentFromDate = amendmentFromDate;
    }

    public Date getAmendmentToDate() {
        return amendmentToDate;
    }

    public void setAmendmentToDate(Date amendmentToDate) {
        this.amendmentToDate = amendmentToDate;
    }

    public String getAmendmentRemarks() {
        return amendmentRemarks;
    }

    public void setAmendmentRemarks(String amendmentRemarks) {
        this.amendmentRemarks = amendmentRemarks;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public Long getLevel1SgsId() {
        return level1SgsId;
    }

    public void setLevel1SgsId(Long level1SgsId) {
        this.level1SgsId = level1SgsId;
    }

    public Long getLevel2SgsId() {
        return level2SgsId;
    }

    public void setLevel2SgsId(Long level2SgsId) {
        this.level2SgsId = level2SgsId;
    }

    public Long getLevel3SgsId() {
        return level3SgsId;
    }

    public void setLevel3SgsId(Long level3SgsId) {
        this.level3SgsId = level3SgsId;
    }

    public String getLevel3Number() {
        return level3Number;
    }

    public void setLevel3Number(String level3Number) {
        this.level3Number = level3Number;
    }

    public Long getSourceSgsId() {
        return sourceSgsId;
    }

    public void setSourceSgsId(Long sourceSgsId) {
        this.sourceSgsId = sourceSgsId;
    }

    public Long getSrsAmendmentVersionNumber() {
        return srsAmendmentVersionNumber;
    }

    public void setSrsAmendmentVersionNumber(Long srsAmendmentVersionNumber) {
        this.srsAmendmentVersionNumber = srsAmendmentVersionNumber;
    }

    public String getLevel3ItrNumber() {
        return level3ItrNumber;
    }

    public void setLevel3ItrNumber(String level3ItrNumber) {
        this.level3ItrNumber = level3ItrNumber;
    }

    public Long getSrcAmendmentVersionNumber() {
        return srcAmendmentVersionNumber;
    }

    public void setSrcAmendmentVersionNumber(Long srcAmendmentVersionNumber) {
        this.srcAmendmentVersionNumber = srcAmendmentVersionNumber;
    }

    public String getCruRole() {
        return cruRole;
    }

    public void setCruRole(String cruRole) {
        this.cruRole = cruRole;
    }

    public Long getRenSequenceNumber() {
        return (renSequenceNumber == null) ? 0L : renSequenceNumber;
    }

    public void setRenSequenceNumber(Long renSequenceNumber) {
        this.renSequenceNumber = renSequenceNumber;
    }

    public String getFltYn() {
        return fltYn;
    }

    public void setFltYn(String fltYn) {
        this.fltYn = fltYn;
    }

    public Long getOseAmendmentVersionNumber() {
        return oseAmendmentVersionNumber;
    }

    public void setOseAmendmentVersionNumber(Long oseAmendmentVersionNumber) {
        this.oseAmendmentVersionNumber = oseAmendmentVersionNumber;
    }

    public String getOseYn() {
        return oseYn;
    }

    public void setOseYn(String oseYn) {
        this.oseYn = oseYn;
    }

    public Long getOseOrderNumber() {
        return oseOrderNumber;
    }

    public void setOseOrderNumber(Long oseOrderNumber) {
        this.oseOrderNumber = oseOrderNumber;
    }

    public Long getOseReferenceSgsId() {
        return oseReferenceSgsId;
    }

    public void setOseReferenceSgsId(Long oseReferenceSgsId) {
        this.oseReferenceSgsId = oseReferenceSgsId;
    }

    public String getPrmCurr() {
        return prmCurr;
    }

    public void setPrmCurr(String prmCurr) {
        this.prmCurr = prmCurr;
    }

    public String getPrmCurrId() {
        return prmCurrId;
    }

    public void setPrmCurrId(String prmCurrId) {
        this.prmCurrId = prmCurrId;
    }

    public Long getPrmCurrXRate() {
        return prmCurrXRate;
    }

    public void setPrmCurrXRate(Long prmCurrXRate) {
        this.prmCurrXRate = prmCurrXRate;
    }

    public String getMstRefNumber() {
        return mstRefNumber;
    }

    public void setMstRefNumber(String mstRefNumber) {
        this.mstRefNumber = mstRefNumber;
    }

    public Long getMstRefSgsId() {
        return mstRefSgsId;
    }

    public void setMstRefSgsId(Long mstRefSgsId) {
        this.mstRefSgsId = mstRefSgsId;
    }

    public Long getMstRefAmendmentVersionNumber() {
        return mstRefAmendmentVersionNumber;
    }

    public void setMstRefAmendmentVersionNumber(Long mstRefAmendmentVersionNumber) {
        this.mstRefAmendmentVersionNumber = mstRefAmendmentVersionNumber;
    }

    public String getAmendmentReason() {
        return amendmentReason;
    }

    public void setAmendmentReason(String amendmentReason) {
        this.amendmentReason = amendmentReason;
    }

    public String getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(String carrierId) {
        this.carrierId = carrierId;
    }

    public String getTemplateType() {
        return templateType;
    }

    public void setTemplateType(String templateType) {
        this.templateType = templateType;
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public String getCancelPcType() {
        return cancelPcType;
    }

    public void setCancelPcType(String cancelPcType) {
        this.cancelPcType = cancelPcType;
    }

    public String getLevel1Type() {
        return level1Type;
    }

    public void setLevel1Type(String level1Type) {
        this.level1Type = level1Type;
    }

    public String getLevel2Type() {
        return level2Type;
    }

    public void setLevel2Type(String level2Type) {
        this.level2Type = level2Type;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getRateLevel() {
        return rateLevel;
    }

    public void setRateLevel(String rateLevel) {
        this.rateLevel = rateLevel;
    }

    public String getCommCurrId() {
        return commCurrId;
    }

    public void setCommCurrId(String commCurrId) {
        this.commCurrId = commCurrId;
    }

    public String getCommCurr() {
        return commCurr;
    }

    public void setCommCurr(String commCurr) {
        this.commCurr = commCurr;
    }

    public Date getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(Date cancelDate) {
        this.cancelDate = cancelDate;
    }

    public Date getReinsureDate() {
        return reinsureDate;
    }

    public void setReinsureDate(Date reinsureDate) {
        this.reinsureDate = reinsureDate;
    }

    public Long getFcl() {
        return fcl;
    }

    public void setFcl(Long fcl) {
        this.fcl = fcl;
    }

    public Long getFclBc() {
        return fclBc;
    }

    public void setFclBc(Long fclBc) {
        this.fclBc = fclBc;
    }

    public String getEqType() {
        return eqType;
    }

    public void setEqType(String eqType) {
        this.eqType = eqType;
    }

    public Long getDepPrem() {
        return depPrem;
    }

    public void setDepPrem(Long depPrem) {
        this.depPrem = depPrem;
    }

    public Long getDepPremBc() {
        return depPremBc;
    }

    public void setDepPremBc(Long depPremBc) {
        this.depPremBc = depPremBc;
    }

    public String getAccountRefNumber() {
        return accountRefNumber;
    }

    public void setAccountRefNumber(String accountRefNumber) {
        this.accountRefNumber = accountRefNumber;
    }

    public String getInsurancePolNumber() {
        return insurancePolNumber;
    }

    public void setInsurancePolNumber(String insurancePolNumber) {
        this.insurancePolNumber = insurancePolNumber;
    }

    public String getInsuranceLaNumber() {
        return insuranceLaNumber;
    }

    public void setInsuranceLaNumber(String insuranceLaNumber) {
        this.insuranceLaNumber = insuranceLaNumber;
    }

    public String getEndtInstType() {
        return endtInstType;
    }

    public void setEndtInstType(String endtInstType) {
        this.endtInstType = endtInstType;
    }

    public String getCarrierBrId() {
        return carrierBrId;
    }

    public void setCarrierBrId(String carrierBrId) {
        this.carrierBrId = carrierBrId;
    }

    public String getInsintDesc() {
        return insintDesc;
    }

    public void setInsintDesc(String insintDesc) {
        this.insintDesc = insintDesc;
    }

    public Long getPolAcntYear() {
        return polAcntYear;
    }

    public void setPolAcntYear(Long polAcntYear) {
        this.polAcntYear = polAcntYear;
    }

    public String getWaiveFeeYn() {
        return waiveFeeYn;
    }

    public void setWaiveFeeYn(String waiveFeeYn) {
        this.waiveFeeYn = waiveFeeYn;
    }

    public String getRetMpYn() {
        return retMpYn;
    }

    public void setRetMpYn(String retMpYn) {
        this.retMpYn = retMpYn;
    }

    public Date getCoverNoteToDate() {
        return coverNoteToDate;
    }

    public void setCoverNoteToDate(Date coverNoteToDate) {
        this.coverNoteToDate = coverNoteToDate;
    }

    public String getApu() {
        return apu;
    }

    public void setApu(String apu) {
        this.apu = apu;
    }

    public String getCarrierState() {
        return carrierState;
    }

    public void setCarrierState(String carrierState) {
        this.carrierState = carrierState;
    }

    public String getCarrierGroupId() {
        return carrierGroupId;
    }

    public void setCarrierGroupId(String carrierGroupId) {
        this.carrierGroupId = carrierGroupId;
    }

    public String getUploadSource() {
        return uploadSource;
    }

    public void setUploadSource(String uploadSource) {
        this.uploadSource = uploadSource;
    }

    public String getDnrReason() {
        return dnrReason;
    }

    public void setDnrReason(String dnrReason) {
        this.dnrReason = dnrReason;
    }

    public String getCanPayee() {
        return canPayee;
    }

    public void setCanPayee(String canPayee) {
        this.canPayee = canPayee;
    }

    public String getCrewNumber() {
        return crewNumber;
    }

    public void setCrewNumber(String crewNumber) {
        this.crewNumber = crewNumber;
    }

    public String getDeclPeriodType() {
        return declPeriodType;
    }

    public void setDeclPeriodType(String declPeriodType) {
        this.declPeriodType = declPeriodType;
    }

    public String getCarrierZipCode() {
        return carrierZipCode;
    }

    public void setCarrierZipCode(String carrierZipCode) {
        this.carrierZipCode = carrierZipCode;
    }

    public String getNationalityOfBus() {
        return nationalityOfBus;
    }

    public void setNationalityOfBus(String nationalityOfBus) {
        this.nationalityOfBus = nationalityOfBus;
    }

    public String getClassFactor() {
        return classFactor;
    }

    public void setClassFactor(String classFactor) {
        this.classFactor = classFactor;
    }

    public String getRateFrz() {
        return rateFrz;
    }

    public void setRateFrz(String rateFrz) {
        this.rateFrz = rateFrz;
    }

    public Long getFactor() {
        return factor;
    }

    public void setFactor(Long factor) {
        this.factor = factor;
    }

    public String getDesc1() {
        return desc1;
    }

    public void setDesc1(String desc1) {
        this.desc1 = desc1;
    }

    public String getAccountCustomerLevel() {
        return accountCustomerLevel;
    }

    public void setAccountCustomerLevel(String accountCustomerLevel) {
        this.accountCustomerLevel = accountCustomerLevel;
    }

    public String getTtyReqYn() {
        return ttyReqYn;
    }

    public void setTtyReqYn(String ttyReqYn) {
        this.ttyReqYn = ttyReqYn;
    }

    public String getCoLastName() {
        return coLastName;
    }

    public void setCoLastName(String coLastName) {
        this.coLastName = coLastName;
    }

    public String getCoFirstName() {
        return coFirstName;
    }

    public void setCoFirstName(String coFirstName) {
        this.coFirstName = coFirstName;
    }

    public String getCoMiddleName() {
        return coMiddleName;
    }

    public void setCoMiddleName(String coMiddleName) {
        this.coMiddleName = coMiddleName;
    }

    public String getOrAddrintYn() {
        return orAddrintYn;
    }

    public void setOrAddrintYn(String orAddrintYn) {
        this.orAddrintYn = orAddrintYn;
    }

    public Date getOrgToDate() {
        return orgToDate;
    }

    public void setOrgToDate(Date orgToDate) {
        this.orgToDate = orgToDate;
    }

    public Long getRenOrgSgsId() {
        return renOrgSgsId;
    }

    public void setRenOrgSgsId(Long renOrgSgsId) {
        this.renOrgSgsId = renOrgSgsId;
    }

    public Date getSubDate() {
        return subDate;
    }

    public void setSubDate(Date subDate) {
        this.subDate = subDate;
    }

    public String getNlDesc() {
        return nlDesc;
    }

    public void setNlDesc(String nlDesc) {
        this.nlDesc = nlDesc;
    }

    public Date getNlFromDate() {
        return nlFromDate;
    }

    public void setNlFromDate(Date nlFromDate) {
        this.nlFromDate = nlFromDate;
    }

    public Date getNlToDate() {
        return nlToDate;
    }

    public void setNlToDate(Date nlToDate) {
        this.nlToDate = nlToDate;
    }

    public Long getPpwDays() {
        return ppwDays;
    }

    public void setPpwDays(Long ppwDays) {
        this.ppwDays = ppwDays;
    }

    public String getBcId() {
        return bcId;
    }

    public void setBcId(String bcId) {
        this.bcId = bcId;
    }

    public String getExpDateChg() {
        return expDateChg;
    }

    public void setExpDateChg(String expDateChg) {
        this.expDateChg = expDateChg;
    }

    public Date getEqtyDate() {
        return eqtyDate;
    }

    public void setEqtyDate(Date eqtyDate) {
        this.eqtyDate = eqtyDate;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcAddress1() {
        return cAddress1;
    }

    public void setcAddress1(String cAddress1) {
        this.cAddress1 = cAddress1;
    }

    public String getcAddress2() {
        return cAddress2;
    }

    public void setcAddress2(String cAddress2) {
        this.cAddress2 = cAddress2;
    }

    public String getcAddress3() {
        return cAddress3;
    }

    public void setcAddress3(String cAddress3) {
        this.cAddress3 = cAddress3;
    }

    public String getcAddress4() {
        return cAddress4;
    }

    public void setcAddress4(String cAddress4) {
        this.cAddress4 = cAddress4;
    }

    public String getcPinCode() {
        return cPinCode;
    }

    public void setcPinCode(String cPinCode) {
        this.cPinCode = cPinCode;
    }

    public String getcCity() {
        return cCity;
    }

    public void setcCity(String cCity) {
        this.cCity = cCity;
    }

    public String getcState() {
        return cState;
    }

    public void setcState(String cState) {
        this.cState = cState;
    }

    public String getcCountry() {
        return cCountry;
    }

    public void setcCountry(String cCountry) {
        this.cCountry = cCountry;
    }

    public String getRenPayorType() {
        return renPayorType;
    }

    public void setRenPayorType(String renPayorType) {
        this.renPayorType = renPayorType;
    }

    public String getAccountRef2Number() {
        return accountRef2Number;
    }

    public void setAccountRef2Number(String accountRef2Number) {
        this.accountRef2Number = accountRef2Number;
    }

    public String getRenPayorId() {
        return renPayorId;
    }

    public void setRenPayorId(String renPayorId) {
        this.renPayorId = renPayorId;
    }

    public Long getIntSharePerc() {
        return intSharePerc;
    }

    public void setIntSharePerc(Long intSharePerc) {
        this.intSharePerc = intSharePerc;
    }

    public String getBatId() {
        return batId;
    }

    public void setBatId(String batId) {
        this.batId = batId;
    }

    public Long getSharePerc() {
        return sharePerc;
    }

    public void setSharePerc(Long sharePerc) {
        this.sharePerc = sharePerc;
    }

    public String getL1AgtId() {
        return l1AgtId;
    }

    public void setL1AgtId(String l1AgtId) {
        this.l1AgtId = l1AgtId;
    }

    public String getL2AgtId() {
        return l2AgtId;
    }

    public void setL2AgtId(String l2AgtId) {
        this.l2AgtId = l2AgtId;
    }

    public String getL3AgtId() {
        return l3AgtId;
    }

    public void setL3AgtId(String l3AgtId) {
        this.l3AgtId = l3AgtId;
    }

    public String getL4AgtId() {
        return l4AgtId;
    }

    public void setL4AgtId(String l4AgtId) {
        this.l4AgtId = l4AgtId;
    }

    public String getL5AgtId() {
        return l5AgtId;
    }

    public void setL5AgtId(String l5AgtId) {
        this.l5AgtId = l5AgtId;
    }

    public String getPeriodCatgType() {
        return periodCatgType;
    }

    public void setPeriodCatgType(String periodCatgType) {
        this.periodCatgType = periodCatgType;
    }

    public Long getPeriodMonths() {
        return periodMonths;
    }

    public void setPeriodMonths(Long periodMonths) {
        this.periodMonths = periodMonths;
    }

    public Long getPeriodDays() {
        return periodDays;
    }

    public void setPeriodDays(Long periodDays) {
        this.periodDays = periodDays;
    }

    public String getSubStatus() {
        return subStatus;
    }

    public void setSubStatus(String subStatus) {
        this.subStatus = subStatus;
    }

    public String getRiskType() {
        return riskType;
    }

    public void setRiskType(String riskType) {
        this.riskType = riskType;
    }

    public String getcFirstName() {
        return cFirstName;
    }

    public void setcFirstName(String cFirstName) {
        this.cFirstName = cFirstName;
    }

    public String getcMiddleName() {
        return cMiddleName;
    }

    public void setcMiddleName(String cMiddleName) {
        this.cMiddleName = cMiddleName;
    }

    public String getcLastName() {
        return cLastName;
    }

    public void setcLastName(String cLastName) {
        this.cLastName = cLastName;
    }

    public String getInsrHoYn() {
        return insrHoYn;
    }

    public void setInsrHoYn(String insrHoYn) {
        this.insrHoYn = insrHoYn;
    }

    public String getPreviousDiscYn() {
        return previousDiscYn;
    }

    public void setPreviousDiscYn(String previousDiscYn) {
        this.previousDiscYn = previousDiscYn;
    }

    public String getEftDiscYn() {
        return eftDiscYn;
    }

    public void setEftDiscYn(String eftDiscYn) {
        this.eftDiscYn = eftDiscYn;
    }

    public String getPriorDiscYn() {
        return priorDiscYn;
    }

    public void setPriorDiscYn(String priorDiscYn) {
        this.priorDiscYn = priorDiscYn;
    }

    public String getProgramType() {
        return programType;
    }

    public void setProgramType(String programType) {
        this.programType = programType;
    }

    public String getCoApplYn() {
        return coApplYn;
    }

    public void setCoApplYn(String coApplYn) {
        this.coApplYn = coApplYn;
    }

    public String getCoInsrYn() {
        return coInsrYn;
    }

    public void setCoInsrYn(String coInsrYn) {
        this.coInsrYn = coInsrYn;
    }

    public String getNamedNonOwYn() {
        return namedNonOwYn;
    }

    public void setNamedNonOwYn(String namedNonOwYn) {
        this.namedNonOwYn = namedNonOwYn;
    }

    public String getInsrSuffix() {
        return insrSuffix;
    }

    public void setInsrSuffix(String insrSuffix) {
        this.insrSuffix = insrSuffix;
    }

    public String getCoSuffix() {
        return coSuffix;
    }

    public void setCoSuffix(String coSuffix) {
        this.coSuffix = coSuffix;
    }

    public String getPdFulDiscYn() {
        return pdFulDiscYn;
    }

    public void setPdFulDiscYn(String pdFulDiscYn) {
        this.pdFulDiscYn = pdFulDiscYn;
    }

    public String getReinFeeYn() {
        return reinFeeYn;
    }

    public void setReinFeeYn(String reinFeeYn) {
        this.reinFeeYn = reinFeeYn;
    }

    public String getManRenYn() {
        return manRenYn;
    }

    public void setManRenYn(String manRenYn) {
        this.manRenYn = manRenYn;
    }

    public String getRenDiscYn() {
        return renDiscYn;
    }

    public void setRenDiscYn(String renDiscYn) {
        this.renDiscYn = renDiscYn;
    }

    public String getDepPremYn() {
        return depPremYn;
    }

    public void setDepPremYn(String depPremYn) {
        this.depPremYn = depPremYn;
    }

    public String getFlatCanYn() {
        return flatCanYn;
    }

    public void setFlatCanYn(String flatCanYn) {
        this.flatCanYn = flatCanYn;
    }

    public String getFlex01() {
        return flex01;
    }

    public void setFlex01(String flex01) {
        this.flex01 = flex01;
    }

    public String getFlex02() {
        return flex02;
    }

    public void setFlex02(String flex02) {
        this.flex02 = flex02;
    }

    public String getFlex03() {
        return flex03;
    }

    public void setFlex03(String flex03) {
        this.flex03 = flex03;
    }

    public String getFlex04() {
        return flex04;
    }

    public void setFlex04(String flex04) {
        this.flex04 = flex04;
    }

    public String getFlex05() {
        return flex05;
    }

    public void setFlex05(String flex05) {
        this.flex05 = flex05;
    }

    public String getRiskAddress1() {
        return riskAddress1;
    }

    public void setRiskAddress1(String riskAddress1) {
        this.riskAddress1 = riskAddress1;
    }

    public String getRiskAddress2() {
        return riskAddress2;
    }

    public void setRiskAddress2(String riskAddress2) {
        this.riskAddress2 = riskAddress2;
    }

    public String getRiskAddress3() {
        return riskAddress3;
    }

    public void setRiskAddress3(String riskAddress3) {
        this.riskAddress3 = riskAddress3;
    }

    public String getRiskAddress4() {
        return riskAddress4;
    }

    public void setRiskAddress4(String riskAddress4) {
        this.riskAddress4 = riskAddress4;
    }

    public String getRiskPinCode() {
        return riskPinCode;
    }

    public void setRiskPinCode(String riskPinCode) {
        this.riskPinCode = riskPinCode;
    }

    public String getRiskCity() {
        return riskCity;
    }

    public void setRiskCity(String riskCity) {
        this.riskCity = riskCity;
    }

    public String getRiskState() {
        return riskState;
    }

    public void setRiskState(String riskState) {
        this.riskState = riskState;
    }

    public String getRiskCountry() {
        return riskCountry;
    }

    public void setRiskCountry(String riskCountry) {
        this.riskCountry = riskCountry;
    }

    public String getRiskAddressSameYn() {
        return riskAddressSameYn;
    }

    public void setRiskAddressSameYn(String riskAddressSameYn) {
        this.riskAddressSameYn = riskAddressSameYn;
    }

    public String getPrefixName() {
        return prefixName;
    }

    public void setPrefixName(String prefixName) {
        this.prefixName = prefixName;
    }

    public String getPrefixNameBl() {
        return prefixNameBl;
    }

    public void setPrefixNameBl(String prefixNameBl) {
        this.prefixNameBl = prefixNameBl;
    }

    public String getcNameBl() {
        return cNameBl;
    }

    public void setcNameBl(String cNameBl) {
        this.cNameBl = cNameBl;
    }

    public String getcFirstNameBl() {
        return cFirstNameBl;
    }

    public void setcFirstNameBl(String cFirstNameBl) {
        this.cFirstNameBl = cFirstNameBl;
    }

    public String getcLastNameBl() {
        return cLastNameBl;
    }

    public void setcLastNameBl(String cLastNameBl) {
        this.cLastNameBl = cLastNameBl;
    }

    public String getRenTpiSts() {
        return renTpiSts;
    }

    public void setRenTpiSts(String renTpiSts) {
        this.renTpiSts = renTpiSts;
    }

    public String getCpyPhoneNumber() {
        return cpyPhoneNumber;
    }

    public void setCpyPhoneNumber(String cpyPhoneNumber) {
        this.cpyPhoneNumber = cpyPhoneNumber;
    }

    public String getCpyMobileNumber() {
        return cpyMobileNumber;
    }

    public void setCpyMobileNumber(String cpyMobileNumber) {
        this.cpyMobileNumber = cpyMobileNumber;
    }

    public String getcFaxNumber() {
        return cFaxNumber;
    }

    public void setcFaxNumber(String cFaxNumber) {
        this.cFaxNumber = cFaxNumber;
    }

    public String getCpyEmailId() {
        return cpyEmailId;
    }

    public void setCpyEmailId(String cpyEmailId) {
        this.cpyEmailId = cpyEmailId;
    }

    public String getCrLevel() {
        return crLevel;
    }

    public void setCrLevel(String crLevel) {
        this.crLevel = crLevel;
    }

    public String getCrExpAllowed() {
        return crExpAllowed;
    }

    public void setCrExpAllowed(String crExpAllowed) {
        this.crExpAllowed = crExpAllowed;
    }

    public String getPunDmgYn() {
        return punDmgYn;
    }

    public void setPunDmgYn(String punDmgYn) {
        this.punDmgYn = punDmgYn;
    }

    public String geteSignNumber() {
        return eSignNumber;
    }

    public void seteSignNumber(String eSignNumber) {
        this.eSignNumber = eSignNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getoCustId() {
        return oCustId;
    }

    public void setoCustId(String oCustId) {
        this.oCustId = oCustId;
    }

    public String getCwkPhoneNumber() {
        return cwkPhoneNumber;
    }

    public void setCwkPhoneNumber(String cwkPhoneNumber) {
        this.cwkPhoneNumber = cwkPhoneNumber;
    }

    public String getPostDoc() {
        return postDoc;
    }

    public void setPostDoc(String postDoc) {
        this.postDoc = postDoc;
    }

    public String getQuotCondAcceptYn() {
        return quotCondAcceptYn;
    }

    public void setQuotCondAcceptYn(String quotCondAcceptYn) {
        this.quotCondAcceptYn = quotCondAcceptYn;
    }

    public String getPolSource() {
        return polSource;
    }

    public void setPolSource(String polSource) {
        this.polSource = polSource;
    }

    public Date getPreviousExpiryDate() {
        return previousExpiryDate;
    }

    public void setPreviousExpiryDate(Date previousExpiryDate) {
        this.previousExpiryDate = previousExpiryDate;
    }

    public String getHomeType() {
        return homeType;
    }

    public void setHomeType(String homeType) {
        this.homeType = homeType;
    }

    public String getcAddress5() {
        return cAddress5;
    }

    public void setcAddress5(String cAddress5) {
        this.cAddress5 = cAddress5;
    }

    public String getPdOacmYn() {
        return pdOacmYn;
    }

    public void setPdOacmYn(String pdOacmYn) {
        this.pdOacmYn = pdOacmYn;
    }

    public String getLbOacmYn() {
        return lbOacmYn;
    }

    public void setLbOacmYn(String lbOacmYn) {
        this.lbOacmYn = lbOacmYn;
    }

    public Date getRateDate() {
        return rateDate;
    }

    public void setRateDate(Date rateDate) {
        this.rateDate = rateDate;
    }

    public String getCustDesc() {
        return custDesc;
    }

    public void setCustDesc(String custDesc) {
        this.custDesc = custDesc;
    }

    public Long getAcSource() {
        return acSource;
    }

    public void setAcSource(Long acSource) {
        this.acSource = acSource;
    }

    public String getDnrRemarks() {
        return dnrRemarks;
    }

    public void setDnrRemarks(String dnrRemarks) {
        this.dnrRemarks = dnrRemarks;
    }

    public String getePrintYn() {
        return ePrintYn;
    }

    public void setePrintYn(String ePrintYn) {
        this.ePrintYn = ePrintYn;
    }

    public String getRemarksBlYn() {
        return remarksBlYn;
    }

    public void setRemarksBlYn(String remarksBlYn) {
        this.remarksBlYn = remarksBlYn;
    }

    public String getFrCompId() {
        return frCompId;
    }

    public void setFrCompId(String frCompId) {
        this.frCompId = frCompId;
    }

    public String getReffYn() {
        return reffYn;
    }

    public void setReffYn(String reffYn) {
        this.reffYn = reffYn;
    }

    public String getDeclUser() {
        return declUser;
    }

    public void setDeclUser(String declUser) {
        this.declUser = declUser;
    }

    public Date getDeclDate() {
        return declDate;
    }

    public void setDeclDate(Date declDate) {
        this.declDate = declDate;
    }

    public String getRenPolNumber() {
        return renPolNumber;
    }

    public void setRenPolNumber(String renPolNumber) {
        this.renPolNumber = renPolNumber;
    }

    public String getAgtAddress1() {
        return agtAddress1;
    }

    public void setAgtAddress1(String agtAddress1) {
        this.agtAddress1 = agtAddress1;
    }

    public String getAgtAddress2() {
        return agtAddress2;
    }

    public void setAgtAddress2(String agtAddress2) {
        this.agtAddress2 = agtAddress2;
    }

    public String getAgtAddress3() {
        return agtAddress3;
    }

    public void setAgtAddress3(String agtAddress3) {
        this.agtAddress3 = agtAddress3;
    }

    public String getAgtAddress4() {
        return agtAddress4;
    }

    public void setAgtAddress4(String agtAddress4) {
        this.agtAddress4 = agtAddress4;
    }

    public String getAgtPinCode() {
        return agtPinCode;
    }

    public void setAgtPinCode(String agtPinCode) {
        this.agtPinCode = agtPinCode;
    }

    public String getAgtCity() {
        return agtCity;
    }

    public void setAgtCity(String agtCity) {
        this.agtCity = agtCity;
    }

    public String getAgtState() {
        return agtState;
    }

    public void setAgtState(String agtState) {
        this.agtState = agtState;
    }

    public String getAgtCountry() {
        return agtCountry;
    }

    public void setAgtCountry(String agtCountry) {
        this.agtCountry = agtCountry;
    }

    public String getAgtPhoneNumber() {
        return agtPhoneNumber;
    }

    public void setAgtPhoneNumber(String agtPhoneNumber) {
        this.agtPhoneNumber = agtPhoneNumber;
    }

    public String getCoinsFlag() {
        return coinsFlag;
    }

    public void setCoinsFlag(String coinsFlag) {
        this.coinsFlag = coinsFlag;
    }

    public String getSiCurr() {
        return siCurr;
    }

    public void setSiCurr(String siCurr) {
        this.siCurr = siCurr;
    }

    public String getSiCurrId() {
        return siCurrId;
    }

    public void setSiCurrId(String siCurrId) {
        this.siCurrId = siCurrId;
    }

    public Long getPrem() {
        return prem;
    }

    public void setPrem(Long prem) {
        this.prem = prem;
    }

    public Long getPremBc() {
        return premBc;
    }

    public void setPremBc(Long premBc) {
        this.premBc = premBc;
    }

    public Long getSiXRate() {
        return siXRate;
    }

    public void setSiXRate(Long siXRate) {
        this.siXRate = siXRate;
    }

    public Long getSiLimit() {
        return siLimit;
    }

    public void setSiLimit(Long siLimit) {
        this.siLimit = siLimit;
    }

    public Long getSiLimitBc() {
        return siLimitBc;
    }

    public void setSiLimitBc(Long siLimitBc) {
        this.siLimitBc = siLimitBc;
    }

    public String getNbType() {
        return nbType;
    }

    public void setNbType(String nbType) {
        this.nbType = nbType;
    }

    public Long getCommXRate() {
        return commXRate;
    }

    public void setCommXRate(Long commXRate) {
        this.commXRate = commXRate;
    }

    public Long getComm() {
        return comm;
    }

    public void setComm(Long comm) {
        this.comm = comm;
    }

    public Long getCommBc() {
        return commBc;
    }

    public void setCommBc(Long commBc) {
        this.commBc = commBc;
    }

    public String getAeId() {
        return aeId;
    }

    public void setAeId(String aeId) {
        this.aeId = aeId;
    }

    public String getSmId() {
        return smId;
    }

    public void setSmId(String smId) {
        this.smId = smId;
    }

    public String getRiskBussDesc() {
        return riskBussDesc;
    }

    public void setRiskBussDesc(String riskBussDesc) {
        this.riskBussDesc = riskBussDesc;
    }

    public String getRiskOcc() {
        return riskOcc;
    }

    public void setRiskOcc(String riskOcc) {
        this.riskOcc = riskOcc;
    }

    public String getRiskOccDesc() {
        return riskOccDesc;
    }

    public void setRiskOccDesc(String riskOccDesc) {
        this.riskOccDesc = riskOccDesc;
    }

    public Long getRiskCount() {
        return riskCount;
    }

    public void setRiskCount(Long riskCount) {
        this.riskCount = riskCount;
    }

    public Long getCommDiscPer() {
        return commDiscPer;
    }

    public void setCommDiscPer(Long commDiscPer) {
        this.commDiscPer = commDiscPer;
    }

    public Long getCommDiscRatePer() {
        return commDiscRatePer;
    }

    public void setCommDiscRatePer(Long commDiscRatePer) {
        this.commDiscRatePer = commDiscRatePer;
    }

    public String getCustPolType() {
        return custPolType;
    }

    public void setCustPolType(String custPolType) {
        this.custPolType = custPolType;
    }

    public String getCrScore() {
        return crScore;
    }

    public void setCrScore(String crScore) {
        this.crScore = crScore;
    }

    public Date getPreviousFromDate() {
        return previousFromDate;
    }

    public void setPreviousFromDate(Date previousFromDate) {
        this.previousFromDate = previousFromDate;
    }

    public String getInsAmendmentNumber() {
        return insAmendmentNumber;
    }

    public void setInsAmendmentNumber(String insAmendmentNumber) {
        this.insAmendmentNumber = insAmendmentNumber;
    }

    public String getNcfStatus() {
        return ncfStatus;
    }

    public void setNcfStatus(String ncfStatus) {
        this.ncfStatus = ncfStatus;
    }

    public String getNcfMessage() {
        return ncfMessage;
    }

    public void setNcfMessage(String ncfMessage) {
        this.ncfMessage = ncfMessage;
    }

    public String getCcfFlag() {
        return ccfFlag;
    }

    public void setCcfFlag(String ccfFlag) {
        this.ccfFlag = ccfFlag;
    }

    public String getFlex06() {
        return flex06;
    }

    public void setFlex06(String flex06) {
        this.flex06 = flex06;
    }

    public String getFlex07() {
        return flex07;
    }

    public void setFlex07(String flex07) {
        this.flex07 = flex07;
    }

    public String getFlex08() {
        return flex08;
    }

    public void setFlex08(String flex08) {
        this.flex08 = flex08;
    }

    public String getFlex09() {
        return flex09;
    }

    public void setFlex09(String flex09) {
        this.flex09 = flex09;
    }

    public String getFlex10() {
        return flex10;
    }

    public void setFlex10(String flex10) {
        this.flex10 = flex10;
    }

    public String getTlicnNumber() {
        return tlicnNumber;
    }

    public void setTlicnNumber(String tlicnNumber) {
        this.tlicnNumber = tlicnNumber;
    }

    public String getPocPrefix() {
        return pocPrefix;
    }

    public void setPocPrefix(String pocPrefix) {
        this.pocPrefix = pocPrefix;
    }

    public String getPocFirstName() {
        return pocFirstName;
    }

    public void setPocFirstName(String pocFirstName) {
        this.pocFirstName = pocFirstName;
    }

    public String getPocMiddleName() {
        return pocMiddleName;
    }

    public void setPocMiddleName(String pocMiddleName) {
        this.pocMiddleName = pocMiddleName;
    }

    public String getPocLastName() {
        return pocLastName;
    }

    public void setPocLastName(String pocLastName) {
        this.pocLastName = pocLastName;
    }

    public String getPocAddress1() {
        return pocAddress1;
    }

    public void setPocAddress1(String pocAddress1) {
        this.pocAddress1 = pocAddress1;
    }

    public String getPocAddress2() {
        return pocAddress2;
    }

    public void setPocAddress2(String pocAddress2) {
        this.pocAddress2 = pocAddress2;
    }

    public String getPocPincode() {
        return pocPincode;
    }

    public void setPocPincode(String pocPincode) {
        this.pocPincode = pocPincode;
    }

    public String getPocCity() {
        return pocCity;
    }

    public void setPocCity(String pocCity) {
        this.pocCity = pocCity;
    }

    public String getPocState() {
        return pocState;
    }

    public void setPocState(String pocState) {
        this.pocState = pocState;
    }

    public String getPocCountry() {
        return pocCountry;
    }

    public void setPocCountry(String pocCountry) {
        this.pocCountry = pocCountry;
    }

    public String getPocMobileNumber() {
        return pocMobileNumber;
    }

    public void setPocMobileNumber(String pocMobileNumber) {
        this.pocMobileNumber = pocMobileNumber;
    }

    public String getPocPhoneNumber() {
        return pocPhoneNumber;
    }

    public void setPocPhoneNumber(String pocPhoneNumber) {
        this.pocPhoneNumber = pocPhoneNumber;
    }

    public String getPocEmail() {
        return pocEmail;
    }

    public void setPocEmail(String pocEmail) {
        this.pocEmail = pocEmail;
    }

    public String getWaiveInspYn() {
        return waiveInspYn;
    }

    public void setWaiveInspYn(String waiveInspYn) {
        this.waiveInspYn = waiveInspYn;
    }

    public Long getNptFeeAmount() {
        return nptFeeAmount;
    }

    public void setNptFeeAmount(Long nptFeeAmount) {
        this.nptFeeAmount = nptFeeAmount;
    }

    public Long getNptFeeAmountBc() {
        return nptFeeAmountBc;
    }

    public void setNptFeeAmountBc(Long nptFeeAmountBc) {
        this.nptFeeAmountBc = nptFeeAmountBc;
    }

    public Long getNptFinFeeAmount() {
        return nptFinFeeAmount;
    }

    public void setNptFinFeeAmount(Long nptFinFeeAmount) {
        this.nptFinFeeAmount = nptFinFeeAmount;
    }

    public Long getNptFinFeeAmountBc() {
        return nptFinFeeAmountBc;
    }

    public void setNptFinFeeAmountBc(Long nptFinFeeAmountBc) {
        this.nptFinFeeAmountBc = nptFinFeeAmountBc;
    }

    public Long getNptCommAmount() {
        return nptCommAmount;
    }

    public void setNptCommAmount(Long nptCommAmount) {
        this.nptCommAmount = nptCommAmount;
    }

    public Long getNptCommAmountBc() {
        return nptCommAmountBc;
    }

    public void setNptCommAmountBc(Long nptCommAmountBc) {
        this.nptCommAmountBc = nptCommAmountBc;
    }

    public Long getTotHour() {
        return totHour;
    }

    public void setTotHour(Long totHour) {
        this.totHour = totHour;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getDisclosureYn() {
        return disclosureYn;
    }

    public void setDisclosureYn(String disclosureYn) {
        this.disclosureYn = disclosureYn;
    }

    public String getSchemeTyp() {
        return schemeTyp;
    }

    public void setSchemeTyp(String schemeTyp) {
        this.schemeTyp = schemeTyp;
    }

    public String getAgentEndNumber() {
        return agentEndNumber;
    }

    public void setAgentEndNumber(String agentEndNumber) {
        this.agentEndNumber = agentEndNumber;
    }

    public String getGlobalEndNumber() {
        return globalEndNumber;
    }

    public void setGlobalEndNumber(String globalEndNumber) {
        this.globalEndNumber = globalEndNumber;
    }

    public String getCanPayMode() {
        return canPayMode;
    }

    public void setCanPayMode(String canPayMode) {
        this.canPayMode = canPayMode;
    }

    public Date getCoDateOfBirth() {
        return coDateOfBirth;
    }

    public void setCoDateOfBirth(Date coDateOfBirth) {
        this.coDateOfBirth = coDateOfBirth;
    }

    public String getHmhPayPlan() {
        return hmhPayPlan;
    }

    public void setHmhPayPlan(String hmhPayPlan) {
        this.hmhPayPlan = hmhPayPlan;
    }

    public Date getDpDate() {
        return dpDate;
    }

    public void setDpDate(Date dpDate) {
        this.dpDate = dpDate;
    }

    public String getCoSsn() {
        return coSsn;
    }

    public void setCoSsn(String coSsn) {
        this.coSsn = coSsn;
    }

    public String getUwType() {
        return uwType;
    }

    public void setUwType(String uwType) {
        this.uwType = uwType;
    }

    public String getPremInvType() {
        return premInvType;
    }

    public void setPremInvType(String premInvType) {
        this.premInvType = premInvType;
    }

    public String getSplAcptYn() {
        return splAcptYn;
    }

    public void setSplAcptYn(String splAcptYn) {
        this.splAcptYn = splAcptYn;
    }

    public String getPolType() {
        return polType;
    }

    public void setPolType(String polType) {
        this.polType = polType;
    }

    public Long getCustAge() {
        return custAge;
    }

    public void setCustAge(Long custAge) {
        this.custAge = custAge;
    }

    public Date getcLicenseIssuedDate() {
        return cLicenseIssuedDate;
    }

    public void setcLicenseIssuedDate(Date cLicenseIssuedDate) {
        this.cLicenseIssuedDate = cLicenseIssuedDate;
    }

    public Date getcLicenseExpiryDate() {
        return cLicenseExpiryDate;
    }

    public void setcLicenseExpiryDate(Date cLicenseExpiryDate) {
        this.cLicenseExpiryDate = cLicenseExpiryDate;
    }

    public String getcGender() {
        return cGender;
    }

    public void setcGender(String cGender) {
        this.cGender = cGender;
    }

    public Date getcDateOfBirth() {
        return cDateOfBirth;
    }

    public void setcDateOfBirth(Date cDateOfBirth) {
        this.cDateOfBirth = cDateOfBirth;
    }

    public String getcIdentificationId1() {
        return cIdentificationId1;
    }

    public void setcIdentificationId1(String cIdentificationId1) {
        this.cIdentificationId1 = cIdentificationId1;
    }

    public String getcMiddleNameBl() {
        return cMiddleNameBl;
    }

    public void setcMiddleNameBl(String cMiddleNameBl) {
        this.cMiddleNameBl = cMiddleNameBl;
    }

    public String getInsuredNameBl() {
        return insuredNameBl;
    }

    public void setInsuredNameBl(String insuredNameBl) {
        this.insuredNameBl = insuredNameBl;
    }

    public Long getIndemPeriod() {
        return indemPeriod;
    }

    public void setIndemPeriod(Long indemPeriod) {
        this.indemPeriod = indemPeriod;
    }

    public String getIndecUnit() {
        return indecUnit;
    }

    public void setIndecUnit(String indecUnit) {
        this.indecUnit = indecUnit;
    }

    public String getPcvrYn() {
        return pcvrYn;
    }

    public void setPcvrYn(String pcvrYn) {
        this.pcvrYn = pcvrYn;
    }

    public String getDfltToInsured() {
        return dfltToInsured;
    }

    public void setDfltToInsured(String dfltToInsured) {
        this.dfltToInsured = dfltToInsured;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    public String getSchdTempType() {
        return schdTempType;
    }

    public void setSchdTempType(String schdTempType) {
        this.schdTempType = schdTempType;
    }

    public String getSchemeName() {
        return schemeName;
    }

    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName;
    }

    public String getExistingCustomer() {
        return existingCustomer;
    }

    public void setExistingCustomer(String existingCustomer) {
        this.existingCustomer = existingCustomer;
    }

    public String getSchemeType() {
        return schemeType;
    }

    public void setSchemeType(String schemeType) {
        this.schemeType = schemeType;
    }

    public String getFlex15() {
        return flex15;
    }

    public void setFlex15(String flex15) {
        this.flex15 = flex15;
    }

    public String getcIdentificationId2() {
        return cIdentificationId2;
    }

    public void setcIdentificationId2(String cIdentificationId2) {
        this.cIdentificationId2 = cIdentificationId2;
    }

    public String getcIdentificationId3() {
        return cIdentificationId3;
    }

    public void setcIdentificationId3(String cIdentificationId3) {
        this.cIdentificationId3 = cIdentificationId3;
    }

    public String getPreviousInsrPolNumber() {
        return previousInsrPolNumber;
    }

    public void setPreviousInsrPolNumber(String previousInsrPolNumber) {
        this.previousInsrPolNumber = previousInsrPolNumber;
    }

    public String getCustVatType() {
        return custVatType;
    }

    public void setCustVatType(String custVatType) {
        this.custVatType = custVatType;
    }

    public String getCustVatYn() {
        return custVatYn;
    }

    public void setCustVatYn(String custVatYn) {
        this.custVatYn = custVatYn;
    }

    public String getCustTaxId() {
        return custTaxId;
    }

    public void setCustTaxId(String custTaxId) {
        this.custTaxId = custTaxId;
    }

    public Long getNbVatAmount() {
        return nbVatAmount;
    }

    public void setNbVatAmount(Long nbVatAmount) {
        this.nbVatAmount = nbVatAmount;
    }

    public Long getNbVatAmountBc() {
        return nbVatAmountBc;
    }

    public void setNbVatAmountBc(Long nbVatAmountBc) {
        this.nbVatAmountBc = nbVatAmountBc;
    }

    public String getNbPartyVatYn() {
        return nbPartyVatYn;
    }

    public void setNbPartyVatYn(String nbPartyVatYn) {
        this.nbPartyVatYn = nbPartyVatYn;
    }

    public String getNbPartyVatType() {
        return nbPartyVatType;
    }

    public void setNbPartyVatType(String nbPartyVatType) {
        this.nbPartyVatType = nbPartyVatType;
    }

    public String getNbPartyVatId() {
        return nbPartyVatId;
    }

    public void setNbPartyVatId(String nbPartyVatId) {
        this.nbPartyVatId = nbPartyVatId;
    }
}

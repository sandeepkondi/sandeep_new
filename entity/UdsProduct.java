package com.beyontec.mol.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.beyontec.mol.util.DateUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "UDS_PRODUCT")
@EntityListeners(AuditingEntityListener.class)
public class UdsProduct {

    @Embeddable
    public static class UdsProductId implements Serializable {
        private static final long serialVersionUID = 1L;
        private String UP_COMP_ID;
        public String UP_PROD_ID;
    }

    @EmbeddedId
    private UdsProductId id;

	private String UP_AGT_SHR_TCF_YN;
	private String UP_AKA_ID;
	private String UP_APD;
	private String UP_APPL_CUST_TYP;
	private String UP_APPRV_STATUS;
	private String UP_APU;
	private String UP_BRK_DRCT_BILL_FLAG;
	private String UP_BR_VAL_REQ_AT;
	private String UP_BUSINESS_LINE;
	private String UP_CALC_TCF_AT;
	private String UP_CARRIER_ID;
	private String UP_CARRIER_STATE;
	private String UP_CLASS_ID;
	private String UP_CLM_CUR_TYP;
	private String UP_COLL_ON_STAGE;
	private String UP_COMM_BASIS;
	private String UP_COMM_CALC_AT;
	private String UP_COMM_CUR_TYP;
	private String UP_COMM_RATE;
	private String UP_COMM_STRUCTURE;
	private String UP_COMM_VAT_YN;
	private String UP_COND_TYP;
	private String UP_CRD;
	private String UP_CRU;
	private String UP_DATETIME_TYP;
	private String UP_DISP_SEQ;
	private String UP_DOC_GEN_AT;
	private String UP_DOC_TYP;
	private String UP_DOWN_PAY_YN;
	private String UP_ENDT_INST_TYP;
	private String UP_EQ_DAYS;
	private String UP_EQ_PREM;
	private String UP_EXP_IMP_REF;
	private String UP_EXT_NO_DAYS;
	private String UP_EXT_NO_MONTH;
	private String UP_EXT_PERIOD_YN;
	private String UP_FLEXI_01;
	private String UP_FLEXI_02;
	private String UP_FLEXI_03;
	private String UP_FLEXI_04;
	private String UP_FLEXI_05;
	private String UP_FLEXI_06;
	private String UP_FLEXI_07;
	private String UP_FLEXI_08;
	private String UP_FLEXI_09;
	private String UP_FLEXI_10;
	private String UP_FMD;
	private String UP_HIER_COMM_YN;
	private String UP_HR_APPL_YN;
	private String UP_INST_FEE_LVL;
	private String UP_INST_INTRV_TYP;
	private String UP_INST_ROUND_DEC;
	private String UP_INST_ROUND_TYP;
	private String UP_LINK_PROD_ID;
	private String UP_LOSS_LIMIT_YN;
	private String UP_MIN_PREM_AT;
	private String UP_NO_RKTYP;
	private String UP_POL_RK_DATA_YN;
	private String UP_POP_PCS_AT;
	private String UP_PREM_CALC_LOGIC;
	private String UP_PREM_CALC_TYP;
	private String UP_PREM_VAT_YN;
	private String UP_PROD_NAME;
	private String UP_PROD_NAME_1;
	private String UP_PROD_NAME_2;
	private String UP_PROD_NAME_3;
	private String UP_PROD_NAME_4;
	private String UP_PROD_TYP;
	private String UP_QR_TYP;
	private String UP_QT_START_RESTRICT_YN;
	private String UP_QT_VALID_DAYS;
	private String UP_REC_TYP;
	private String UP_REN_PREM_RECALC;
	private String UP_REN_PROC_INI_DAYS;
	private String UP_RI_CUR_TYP;
	private String UP_RNWL_PERIOD;
	private String UP_ROUND_DEC;
	private String UP_ROUND_TYP;
	private String UP_RP_TITLE;
	private String UP_SHOW_DEC_PREM_YN;
	private String UP_SHOW_DEC_SI_YN;
	private String UP_SHOW_PAYOR;
	private String UP_START_QUOT_TYP;
	private String UP_TAX_CHG_ALLOC;
	private String UP_TOD;
	private String UP_TPA_COMM_YN;
	private String UP_TP_ROUND_DEC;
	private String UP_TP_ROUND_TYP;
	private String UP_TYP_FLAG;
	private String UP_UPLOAD_TYP;
	private String UP_UW_CUR_TYP;
	private String UP_VER_NO;

    @JsonIgnore
    public UdsProductId getId() {
		if (id != null) { return id; }
		id = new UdsProductId();
		return id;
	}

    public void setId(UdsProductId id) {
		this.id = id;
	}

	public String getUP_AGT_SHR_TCF_YN() {
		return UP_AGT_SHR_TCF_YN;
	}

	public void setUP_AGT_SHR_TCF_YN(String uP_AGT_SHR_TCF_YN) {
		UP_AGT_SHR_TCF_YN = uP_AGT_SHR_TCF_YN;
	}

	public String getUP_AKA_ID() {
		return UP_AKA_ID;
	}

	public void setUP_AKA_ID(String uP_AKA_ID) {
		UP_AKA_ID = uP_AKA_ID;
	}

	public String getUP_APD() {
		return UP_APD;
	}

	public void setUP_APD(String uP_APD) {
		UP_APD = uP_APD;
	}

	public String getUP_APPL_CUST_TYP() {
		return UP_APPL_CUST_TYP;
	}

	public void setUP_APPL_CUST_TYP(String uP_APPL_CUST_TYP) {
		UP_APPL_CUST_TYP = uP_APPL_CUST_TYP;
	}

	public String getUP_APPRV_STATUS() {
		return UP_APPRV_STATUS;
	}

	public void setUP_APPRV_STATUS(String uP_APPRV_STATUS) {
		UP_APPRV_STATUS = uP_APPRV_STATUS;
	}

	public String getUP_APU() {
		return UP_APU;
	}

	public void setUP_APU(String uP_APU) {
		UP_APU = uP_APU;
	}

	public String getUP_BRK_DRCT_BILL_FLAG() {
		return UP_BRK_DRCT_BILL_FLAG;
	}

	public void setUP_BRK_DRCT_BILL_FLAG(String uP_BRK_DRCT_BILL_FLAG) {
		UP_BRK_DRCT_BILL_FLAG = uP_BRK_DRCT_BILL_FLAG;
	}

	public String getUP_BR_VAL_REQ_AT() {
		return UP_BR_VAL_REQ_AT;
	}

	public void setUP_BR_VAL_REQ_AT(String uP_BR_VAL_REQ_AT) {
		UP_BR_VAL_REQ_AT = uP_BR_VAL_REQ_AT;
	}

	public String getUP_BUSINESS_LINE() {
		return UP_BUSINESS_LINE;
	}

	public void setUP_BUSINESS_LINE(String uP_BUSINESS_LINE) {
		UP_BUSINESS_LINE = uP_BUSINESS_LINE;
	}

	public String getUP_CALC_TCF_AT() {
		return UP_CALC_TCF_AT;
	}

	public void setUP_CALC_TCF_AT(String uP_CALC_TCF_AT) {
		UP_CALC_TCF_AT = uP_CALC_TCF_AT;
	}

	public String getUP_CARRIER_ID() {
		return UP_CARRIER_ID;
	}

	public void setUP_CARRIER_ID(String uP_CARRIER_ID) {
		UP_CARRIER_ID = uP_CARRIER_ID;
	}

	public String getUP_CARRIER_STATE() {
		return UP_CARRIER_STATE;
	}

	public void setUP_CARRIER_STATE(String uP_CARRIER_STATE) {
		UP_CARRIER_STATE = uP_CARRIER_STATE;
	}

	public String getUP_CLASS_ID() {
		return UP_CLASS_ID;
	}

	public void setUP_CLASS_ID(String uP_CLASS_ID) {
		UP_CLASS_ID = uP_CLASS_ID;
	}

	public String getUP_CLM_CUR_TYP() {
		return UP_CLM_CUR_TYP;
	}

	public void setUP_CLM_CUR_TYP(String uP_CLM_CUR_TYP) {
		UP_CLM_CUR_TYP = uP_CLM_CUR_TYP;
	}

	public String getUP_COLL_ON_STAGE() {
		return UP_COLL_ON_STAGE;
	}

	public void setUP_COLL_ON_STAGE(String uP_COLL_ON_STAGE) {
		UP_COLL_ON_STAGE = uP_COLL_ON_STAGE;
	}

	public String getUP_COMM_BASIS() {
		return UP_COMM_BASIS;
	}

	public void setUP_COMM_BASIS(String uP_COMM_BASIS) {
		UP_COMM_BASIS = uP_COMM_BASIS;
	}

	public String getUP_COMM_CALC_AT() {
		return UP_COMM_CALC_AT;
	}

	public void setUP_COMM_CALC_AT(String uP_COMM_CALC_AT) {
		UP_COMM_CALC_AT = uP_COMM_CALC_AT;
	}

	public String getUP_COMM_CUR_TYP() {
		return UP_COMM_CUR_TYP;
	}

	public void setUP_COMM_CUR_TYP(String uP_COMM_CUR_TYP) {
		UP_COMM_CUR_TYP = uP_COMM_CUR_TYP;
	}

	public String getUP_COMM_RATE() {
		return UP_COMM_RATE;
	}

	public void setUP_COMM_RATE(String uP_COMM_RATE) {
		UP_COMM_RATE = uP_COMM_RATE;
	}

	public String getUP_COMM_STRUCTURE() {
		return UP_COMM_STRUCTURE;
	}

	public void setUP_COMM_STRUCTURE(String uP_COMM_STRUCTURE) {
		UP_COMM_STRUCTURE = uP_COMM_STRUCTURE;
	}

	public String getUP_COMM_VAT_YN() {
		return UP_COMM_VAT_YN;
	}

	public void setUP_COMM_VAT_YN(String uP_COMM_VAT_YN) {
		UP_COMM_VAT_YN = uP_COMM_VAT_YN;
	}

	public String getUP_COMP_ID() {
        return getId().UP_COMP_ID;
	}

	public void setUP_COMP_ID(String uP_COMP_ID) {
        getId().UP_COMP_ID = uP_COMP_ID;
	}

	public String getUP_COND_TYP() {
		return UP_COND_TYP;
	}

	public void setUP_COND_TYP(String uP_COND_TYP) {
		UP_COND_TYP = uP_COND_TYP;
	}

	public String getUP_CRD() {
		return UP_CRD;
	}

	public void setUP_CRD(String uP_CRD) {
		UP_CRD = uP_CRD;
	}

	public String getUP_CRU() {
		return UP_CRU;
	}

	public void setUP_CRU(String uP_CRU) {
		UP_CRU = uP_CRU;
	}

	public String getUP_DATETIME_TYP() {
		return UP_DATETIME_TYP;
	}

	public void setUP_DATETIME_TYP(String uP_DATETIME_TYP) {
		UP_DATETIME_TYP = uP_DATETIME_TYP;
	}

	public String getUP_DISP_SEQ() {
		return UP_DISP_SEQ;
	}

	public void setUP_DISP_SEQ(String uP_DISP_SEQ) {
		UP_DISP_SEQ = uP_DISP_SEQ;
	}

	public String getUP_DOC_GEN_AT() {
		return UP_DOC_GEN_AT;
	}

	public void setUP_DOC_GEN_AT(String uP_DOC_GEN_AT) {
		UP_DOC_GEN_AT = uP_DOC_GEN_AT;
	}

	public String getUP_DOC_TYP() {
		return UP_DOC_TYP;
	}

	public void setUP_DOC_TYP(String uP_DOC_TYP) {
		UP_DOC_TYP = uP_DOC_TYP;
	}

	public String getUP_DOWN_PAY_YN() {
		return UP_DOWN_PAY_YN;
	}

	public void setUP_DOWN_PAY_YN(String uP_DOWN_PAY_YN) {
		UP_DOWN_PAY_YN = uP_DOWN_PAY_YN;
	}

	public String getUP_ENDT_INST_TYP() {
		return UP_ENDT_INST_TYP;
	}

	public void setUP_ENDT_INST_TYP(String uP_ENDT_INST_TYP) {
		UP_ENDT_INST_TYP = uP_ENDT_INST_TYP;
	}

	public String getUP_EQ_DAYS() {
		return UP_EQ_DAYS;
	}

	public void setUP_EQ_DAYS(String uP_EQ_DAYS) {
		UP_EQ_DAYS = uP_EQ_DAYS;
	}

	public String getUP_EQ_PREM() {
		return UP_EQ_PREM;
	}

	public void setUP_EQ_PREM(String uP_EQ_PREM) {
		UP_EQ_PREM = uP_EQ_PREM;
	}

	public String getUP_EXP_IMP_REF() {
		return UP_EXP_IMP_REF;
	}

	public void setUP_EXP_IMP_REF(String uP_EXP_IMP_REF) {
		UP_EXP_IMP_REF = uP_EXP_IMP_REF;
	}

	public String getUP_EXT_NO_DAYS() {
		return UP_EXT_NO_DAYS;
	}

	public void setUP_EXT_NO_DAYS(String uP_EXT_NO_DAYS) {
		UP_EXT_NO_DAYS = uP_EXT_NO_DAYS;
	}

	public String getUP_EXT_NO_MONTH() {
		return UP_EXT_NO_MONTH;
	}

	public void setUP_EXT_NO_MONTH(String uP_EXT_NO_MONTH) {
		UP_EXT_NO_MONTH = uP_EXT_NO_MONTH;
	}

	public String getUP_EXT_PERIOD_YN() {
		return UP_EXT_PERIOD_YN;
	}

	public void setUP_EXT_PERIOD_YN(String uP_EXT_PERIOD_YN) {
		UP_EXT_PERIOD_YN = uP_EXT_PERIOD_YN;
	}

	public String getUP_FLEXI_01() {
		return UP_FLEXI_01;
	}

	public void setUP_FLEXI_01(String uP_FLEXI_01) {
		UP_FLEXI_01 = uP_FLEXI_01;
	}

	public String getUP_FLEXI_02() {
		return UP_FLEXI_02;
	}

	public void setUP_FLEXI_02(String uP_FLEXI_02) {
		UP_FLEXI_02 = uP_FLEXI_02;
	}

	public String getUP_FLEXI_03() {
		return UP_FLEXI_03;
	}

	public void setUP_FLEXI_03(String uP_FLEXI_03) {
		UP_FLEXI_03 = uP_FLEXI_03;
	}

	public String getUP_FLEXI_04() {
		return UP_FLEXI_04;
	}

	public void setUP_FLEXI_04(String uP_FLEXI_04) {
		UP_FLEXI_04 = uP_FLEXI_04;
	}

	public String getUP_FLEXI_05() {
		return UP_FLEXI_05;
	}

	public void setUP_FLEXI_05(String uP_FLEXI_05) {
		UP_FLEXI_05 = uP_FLEXI_05;
	}

	public String getUP_FLEXI_06() {
		return UP_FLEXI_06;
	}

	public void setUP_FLEXI_06(String uP_FLEXI_06) {
		UP_FLEXI_06 = uP_FLEXI_06;
	}

	public String getUP_FLEXI_07() {
		return UP_FLEXI_07;
	}

	public void setUP_FLEXI_07(String uP_FLEXI_07) {
		UP_FLEXI_07 = uP_FLEXI_07;
	}

	public String getUP_FLEXI_08() {
		return UP_FLEXI_08;
	}

	public void setUP_FLEXI_08(String uP_FLEXI_08) {
		UP_FLEXI_08 = uP_FLEXI_08;
	}

	public String getUP_FLEXI_09() {
		return UP_FLEXI_09;
	}

	public void setUP_FLEXI_09(String uP_FLEXI_09) {
		UP_FLEXI_09 = uP_FLEXI_09;
	}

	public String getUP_FLEXI_10() {
		return UP_FLEXI_10;
	}

	public void setUP_FLEXI_10(String uP_FLEXI_10) {
		UP_FLEXI_10 = uP_FLEXI_10;
	}

	public String getUP_FMD() {
		return UP_FMD;
	}

	public void setUP_FMD(String uP_FMD) {
		UP_FMD = uP_FMD;
	}

	public String getUP_HIER_COMM_YN() {
		return UP_HIER_COMM_YN;
	}

	public void setUP_HIER_COMM_YN(String uP_HIER_COMM_YN) {
		UP_HIER_COMM_YN = uP_HIER_COMM_YN;
	}

	public String getUP_HR_APPL_YN() {
		return UP_HR_APPL_YN;
	}

	public void setUP_HR_APPL_YN(String uP_HR_APPL_YN) {
		UP_HR_APPL_YN = uP_HR_APPL_YN;
	}

	public String getUP_INST_FEE_LVL() {
		return UP_INST_FEE_LVL;
	}

	public void setUP_INST_FEE_LVL(String uP_INST_FEE_LVL) {
		UP_INST_FEE_LVL = uP_INST_FEE_LVL;
	}

	public String getUP_INST_INTRV_TYP() {
		return UP_INST_INTRV_TYP;
	}

	public void setUP_INST_INTRV_TYP(String uP_INST_INTRV_TYP) {
		UP_INST_INTRV_TYP = uP_INST_INTRV_TYP;
	}

	public String getUP_INST_ROUND_DEC() {
		return UP_INST_ROUND_DEC;
	}

	public void setUP_INST_ROUND_DEC(String uP_INST_ROUND_DEC) {
		UP_INST_ROUND_DEC = uP_INST_ROUND_DEC;
	}

	public String getUP_INST_ROUND_TYP() {
		return UP_INST_ROUND_TYP;
	}

	public void setUP_INST_ROUND_TYP(String uP_INST_ROUND_TYP) {
		UP_INST_ROUND_TYP = uP_INST_ROUND_TYP;
	}

	public String getUP_LINK_PROD_ID() {
		return UP_LINK_PROD_ID;
	}

	public void setUP_LINK_PROD_ID(String uP_LINK_PROD_ID) {
		UP_LINK_PROD_ID = uP_LINK_PROD_ID;
	}

	public String getUP_LOSS_LIMIT_YN() {
		return UP_LOSS_LIMIT_YN;
	}

	public void setUP_LOSS_LIMIT_YN(String uP_LOSS_LIMIT_YN) {
		UP_LOSS_LIMIT_YN = uP_LOSS_LIMIT_YN;
	}

	public String getUP_MIN_PREM_AT() {
		return UP_MIN_PREM_AT;
	}

	public void setUP_MIN_PREM_AT(String uP_MIN_PREM_AT) {
		UP_MIN_PREM_AT = uP_MIN_PREM_AT;
	}

	public String getUP_NO_RKTYP() {
		return UP_NO_RKTYP;
	}

	public void setUP_NO_RKTYP(String uP_NO_RKTYP) {
		UP_NO_RKTYP = uP_NO_RKTYP;
	}

	public String getUP_POL_RK_DATA_YN() {
		return UP_POL_RK_DATA_YN;
	}

	public void setUP_POL_RK_DATA_YN(String uP_POL_RK_DATA_YN) {
		UP_POL_RK_DATA_YN = uP_POL_RK_DATA_YN;
	}

	public String getUP_POP_PCS_AT() {
		return UP_POP_PCS_AT;
	}

	public void setUP_POP_PCS_AT(String uP_POP_PCS_AT) {
		UP_POP_PCS_AT = uP_POP_PCS_AT;
	}

	public String getUP_PREM_CALC_LOGIC() {
		return UP_PREM_CALC_LOGIC;
	}

	public void setUP_PREM_CALC_LOGIC(String uP_PREM_CALC_LOGIC) {
		UP_PREM_CALC_LOGIC = uP_PREM_CALC_LOGIC;
	}

	public String getUP_PREM_CALC_TYP() {
		return UP_PREM_CALC_TYP;
	}

	public void setUP_PREM_CALC_TYP(String uP_PREM_CALC_TYP) {
		UP_PREM_CALC_TYP = uP_PREM_CALC_TYP;
	}

	public String getUP_PREM_VAT_YN() {
		return UP_PREM_VAT_YN;
	}

	public void setUP_PREM_VAT_YN(String uP_PREM_VAT_YN) {
		UP_PREM_VAT_YN = uP_PREM_VAT_YN;
	}

	public String getUP_PROD_ID() {
        return getId().UP_PROD_ID;
	}

	public void setUP_PROD_ID(String uP_PROD_ID) {
        getId().UP_PROD_ID = uP_PROD_ID;
	}

	public String getUP_PROD_NAME() {
		return UP_PROD_NAME;
	}

	public void setUP_PROD_NAME(String uP_PROD_NAME) {
		UP_PROD_NAME = uP_PROD_NAME;
	}

	public String getUP_PROD_NAME_1() {
		return UP_PROD_NAME_1;
	}

	public void setUP_PROD_NAME_1(String uP_PROD_NAME_1) {
		UP_PROD_NAME_1 = uP_PROD_NAME_1;
	}

	public String getUP_PROD_NAME_2() {
		return UP_PROD_NAME_2;
	}

	public void setUP_PROD_NAME_2(String uP_PROD_NAME_2) {
		UP_PROD_NAME_2 = uP_PROD_NAME_2;
	}

	public String getUP_PROD_NAME_3() {
		return UP_PROD_NAME_3;
	}

	public void setUP_PROD_NAME_3(String uP_PROD_NAME_3) {
		UP_PROD_NAME_3 = uP_PROD_NAME_3;
	}

	public String getUP_PROD_NAME_4() {
		return UP_PROD_NAME_4;
	}

	public void setUP_PROD_NAME_4(String uP_PROD_NAME_4) {
		UP_PROD_NAME_4 = uP_PROD_NAME_4;
	}

	public String getUP_PROD_TYP() {
		return UP_PROD_TYP;
	}

	public void setUP_PROD_TYP(String uP_PROD_TYP) {
		UP_PROD_TYP = uP_PROD_TYP;
	}

	public String getUP_QR_TYP() {
		return UP_QR_TYP;
	}

	public void setUP_QR_TYP(String uP_QR_TYP) {
		UP_QR_TYP = uP_QR_TYP;
	}

	public String getUP_QT_START_RESTRICT_YN() {
		return UP_QT_START_RESTRICT_YN;
	}

	public void setUP_QT_START_RESTRICT_YN(String uP_QT_START_RESTRICT_YN) {
		UP_QT_START_RESTRICT_YN = uP_QT_START_RESTRICT_YN;
	}

	public String getUP_QT_VALID_DAYS() {
		return UP_QT_VALID_DAYS;
	}

	public void setUP_QT_VALID_DAYS(String uP_QT_VALID_DAYS) {
		UP_QT_VALID_DAYS = uP_QT_VALID_DAYS;
	}

	public String getUP_REC_TYP() {
		return UP_REC_TYP;
	}

	public void setUP_REC_TYP(String uP_REC_TYP) {
		UP_REC_TYP = uP_REC_TYP;
	}

	public String getUP_REN_PREM_RECALC() {
		return UP_REN_PREM_RECALC;
	}

	public void setUP_REN_PREM_RECALC(String uP_REN_PREM_RECALC) {
		UP_REN_PREM_RECALC = uP_REN_PREM_RECALC;
	}

	public String getUP_REN_PROC_INI_DAYS() {
		return UP_REN_PROC_INI_DAYS;
	}

	public void setUP_REN_PROC_INI_DAYS(String uP_REN_PROC_INI_DAYS) {
		UP_REN_PROC_INI_DAYS = uP_REN_PROC_INI_DAYS;
	}

	public String getUP_RI_CUR_TYP() {
		return UP_RI_CUR_TYP;
	}

	public void setUP_RI_CUR_TYP(String uP_RI_CUR_TYP) {
		UP_RI_CUR_TYP = uP_RI_CUR_TYP;
	}

	public String getUP_RNWL_PERIOD() {
		return UP_RNWL_PERIOD;
	}

	public void setUP_RNWL_PERIOD(String uP_RNWL_PERIOD) {
		UP_RNWL_PERIOD = uP_RNWL_PERIOD;
	}

	public String getUP_ROUND_DEC() {
		return UP_ROUND_DEC;
	}

	public void setUP_ROUND_DEC(String uP_ROUND_DEC) {
		UP_ROUND_DEC = uP_ROUND_DEC;
	}

	public String getUP_ROUND_TYP() {
		return UP_ROUND_TYP;
	}

	public void setUP_ROUND_TYP(String uP_ROUND_TYP) {
		UP_ROUND_TYP = uP_ROUND_TYP;
	}

	public String getUP_RP_TITLE() {
		return UP_RP_TITLE;
	}

	public void setUP_RP_TITLE(String uP_RP_TITLE) {
		UP_RP_TITLE = uP_RP_TITLE;
	}

	public String getUP_SHOW_DEC_PREM_YN() {
		return UP_SHOW_DEC_PREM_YN;
	}

	public void setUP_SHOW_DEC_PREM_YN(String uP_SHOW_DEC_PREM_YN) {
		UP_SHOW_DEC_PREM_YN = uP_SHOW_DEC_PREM_YN;
	}

	public String getUP_SHOW_DEC_SI_YN() {
		return UP_SHOW_DEC_SI_YN;
	}

	public void setUP_SHOW_DEC_SI_YN(String uP_SHOW_DEC_SI_YN) {
		UP_SHOW_DEC_SI_YN = uP_SHOW_DEC_SI_YN;
	}

	public String getUP_SHOW_PAYOR() {
		return UP_SHOW_PAYOR;
	}

	public void setUP_SHOW_PAYOR(String uP_SHOW_PAYOR) {
		UP_SHOW_PAYOR = uP_SHOW_PAYOR;
	}

	public String getUP_START_QUOT_TYP() {
		return UP_START_QUOT_TYP;
	}

	public void setUP_START_QUOT_TYP(String uP_START_QUOT_TYP) {
		UP_START_QUOT_TYP = uP_START_QUOT_TYP;
	}

	public String getUP_TAX_CHG_ALLOC() {
		return UP_TAX_CHG_ALLOC;
	}

	public void setUP_TAX_CHG_ALLOC(String uP_TAX_CHG_ALLOC) {
		UP_TAX_CHG_ALLOC = uP_TAX_CHG_ALLOC;
	}

	public String getUP_TOD() {
		return UP_TOD;
	}

	public void setUP_TOD(String uP_TOD) {
		UP_TOD = uP_TOD;
	}

	public String getUP_TPA_COMM_YN() {
		return UP_TPA_COMM_YN;
	}

	public void setUP_TPA_COMM_YN(String uP_TPA_COMM_YN) {
		UP_TPA_COMM_YN = uP_TPA_COMM_YN;
	}

	public String getUP_TP_ROUND_DEC() {
		return UP_TP_ROUND_DEC;
	}

	public void setUP_TP_ROUND_DEC(String uP_TP_ROUND_DEC) {
		UP_TP_ROUND_DEC = uP_TP_ROUND_DEC;
	}

	public String getUP_TP_ROUND_TYP() {
		return UP_TP_ROUND_TYP;
	}

	public void setUP_TP_ROUND_TYP(String uP_TP_ROUND_TYP) {
		UP_TP_ROUND_TYP = uP_TP_ROUND_TYP;
	}

	public String getUP_TYP_FLAG() {
		return UP_TYP_FLAG;
	}

	public void setUP_TYP_FLAG(String uP_TYP_FLAG) {
		UP_TYP_FLAG = uP_TYP_FLAG;
	}

	public String getUP_UPLOAD_TYP() {
		return UP_UPLOAD_TYP;
	}

	public void setUP_UPLOAD_TYP(String uP_UPLOAD_TYP) {
		UP_UPLOAD_TYP = uP_UPLOAD_TYP;
	}

	public String getUP_UW_CUR_TYP() {
		return UP_UW_CUR_TYP;
	}

	public void setUP_UW_CUR_TYP(String uP_UW_CUR_TYP) {
		UP_UW_CUR_TYP = uP_UW_CUR_TYP;
	}

	public String getUP_VER_NO() {
		return UP_VER_NO;
	}

	public void setUP_VER_NO(String uP_VER_NO) {
		UP_VER_NO = uP_VER_NO;
	}

    public Date extendDate(Date date) {
        boolean shouldExtendPeriod = BooleanUtils.toBoolean(this.UP_EXT_PERIOD_YN);
        if (!shouldExtendPeriod) { return date; }
        int noOfMonthsToExt = NumberUtils.toInt(this.UP_EXT_NO_MONTH);
        int noOfDaysToExt = NumberUtils.toInt(this.UP_EXT_NO_DAYS);
        return DateUtil.extendDate(date, noOfMonthsToExt, noOfDaysToExt);
    }

}

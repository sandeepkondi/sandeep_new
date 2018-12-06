package com.beyontec.mol.entity;

import javax.persistence.Embeddable;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Embeddable
//@Entity
@Table(name = "UTDS_LEVEL_TCF")
@EntityListeners(AuditingEntityListener.class)
public class TaxDetails {

	private String ULTCF_TYP;
	private String ULTCF_MST_ID;
	private String ULTCF_RATE;
	private String ULTCF_RATE_PER;
	private String ULTCF_ORD_NO;
	private String ULTCF_APPL_ORD_NO;
	private String ULTCF_CUST_SHARE_PERC;
	private String ULTCF_CUST_SHARE_TCF;
	private String ULTCF_REC_TYP;
	private String ULTCF_ULM_SGS_ID;
	private String ULTCF_AMND_VER_NO;
	private String ULTCF_SUB_TYP;
	private String ULTCF_ID;
	private String ULTCF_AMT;
	private String ULTCF_ULR_ID;
	private String ULTCF_ADJ_AMT;
	private String ULTCF_UBD_SGS_ID;
	private String ULTCF_IDFR;
	private String ULTCF_UBH_BR_ID;
	private String ULTCF_FMD;
	private String ULTCF_TOD;
	private String ULTCF_AMND_FMD;
	private String ULTCF_AMND_TOD;
	private String ULTCF_AMT_BC;
	private String ULTCF_ADJ_AMT_BC;
	private String ULTCF_CUST_SHARE_TCF_BC;
	private String ULTCF_CUR_ID;
	private String ULTCF_CUR_X_RATE;
	private String ULTCF_INST_MODE;
	private String ULTCF_ADJ_RATE;
	private String ULTCF_ADJ_RATE_PER;
	private String ULTCF_ADJ_RATE_MOD_YN;
	private String ULTCF_SRC_AMT;
	private String ULTCF_SRC_AMT_BC;
	private String ULTCF_COMP_ID;

	public String getULTCF_TYP() {
		return ULTCF_TYP;
	}

	public void setULTCF_TYP(String uLTCF_TYP) {
		ULTCF_TYP = uLTCF_TYP;
	}

	public String getULTCF_MST_ID() {
		return ULTCF_MST_ID;
	}

	public void setULTCF_MST_ID(String uLTCF_MST_ID) {
		ULTCF_MST_ID = uLTCF_MST_ID;
	}

	public String getULTCF_RATE() {
		return ULTCF_RATE;
	}

	public void setULTCF_RATE(String uLTCF_RATE) {
		ULTCF_RATE = uLTCF_RATE;
	}

	public String getULTCF_RATE_PER() {
		return ULTCF_RATE_PER;
	}

	public void setULTCF_RATE_PER(String uLTCF_RATE_PER) {
		ULTCF_RATE_PER = uLTCF_RATE_PER;
	}

	public String getULTCF_ORD_NO() {
		return ULTCF_ORD_NO;
	}

	public void setULTCF_ORD_NO(String uLTCF_ORD_NO) {
		ULTCF_ORD_NO = uLTCF_ORD_NO;
	}

	public String getULTCF_APPL_ORD_NO() {
		return ULTCF_APPL_ORD_NO;
	}

	public void setULTCF_APPL_ORD_NO(String uLTCF_APPL_ORD_NO) {
		ULTCF_APPL_ORD_NO = uLTCF_APPL_ORD_NO;
	}

	public String getULTCF_CUST_SHARE_PERC() {
		return ULTCF_CUST_SHARE_PERC;
	}

	public void setULTCF_CUST_SHARE_PERC(String uLTCF_CUST_SHARE_PERC) {
		ULTCF_CUST_SHARE_PERC = uLTCF_CUST_SHARE_PERC;
	}

	public String getULTCF_CUST_SHARE_TCF() {
		return ULTCF_CUST_SHARE_TCF;
	}

	public void setULTCF_CUST_SHARE_TCF(String uLTCF_CUST_SHARE_TCF) {
		ULTCF_CUST_SHARE_TCF = uLTCF_CUST_SHARE_TCF;
	}

	public String getULTCF_REC_TYP() {
		return ULTCF_REC_TYP;
	}

	public void setULTCF_REC_TYP(String uLTCF_REC_TYP) {
		ULTCF_REC_TYP = uLTCF_REC_TYP;
	}

	public String getULTCF_ULM_SGS_ID() {
		return ULTCF_ULM_SGS_ID;
	}

	public void setULTCF_ULM_SGS_ID(String uLTCF_ULM_SGS_ID) {
		ULTCF_ULM_SGS_ID = uLTCF_ULM_SGS_ID;
	}

	public String getULTCF_AMND_VER_NO() {
		return ULTCF_AMND_VER_NO;
	}

	public void setULTCF_AMND_VER_NO(String uLTCF_AMND_VER_NO) {
		ULTCF_AMND_VER_NO = uLTCF_AMND_VER_NO;
	}

	public String getULTCF_SUB_TYP() {
		return ULTCF_SUB_TYP;
	}

	public void setULTCF_SUB_TYP(String uLTCF_SUB_TYP) {
		ULTCF_SUB_TYP = uLTCF_SUB_TYP;
	}

	public String getULTCF_ID() {
		return ULTCF_ID;
	}

	public void setULTCF_ID(String uLTCF_ID) {
		ULTCF_ID = uLTCF_ID;
	}

	public String getULTCF_AMT() {
		return ULTCF_AMT;
	}

	public void setULTCF_AMT(String uLTCF_AMT) {
		ULTCF_AMT = uLTCF_AMT;
	}

	public String getULTCF_ULR_ID() {
		return ULTCF_ULR_ID;
	}

	public void setULTCF_ULR_ID(String uLTCF_ULR_ID) {
		ULTCF_ULR_ID = uLTCF_ULR_ID;
	}

	public String getULTCF_ADJ_AMT() {
		return ULTCF_ADJ_AMT;
	}

	public void setULTCF_ADJ_AMT(String uLTCF_ADJ_AMT) {
		ULTCF_ADJ_AMT = uLTCF_ADJ_AMT;
	}

	public String getULTCF_UBD_SGS_ID() {
		return ULTCF_UBD_SGS_ID;
	}

	public void setULTCF_UBD_SGS_ID(String uLTCF_UBD_SGS_ID) {
		ULTCF_UBD_SGS_ID = uLTCF_UBD_SGS_ID;
	}

	public String getULTCF_IDFR() {
		return ULTCF_IDFR;
	}

	public void setULTCF_IDFR(String uLTCF_IDFR) {
		ULTCF_IDFR = uLTCF_IDFR;
	}

	public String getULTCF_UBH_BR_ID() {
		return ULTCF_UBH_BR_ID;
	}

	public void setULTCF_UBH_BR_ID(String uLTCF_UBH_BR_ID) {
		ULTCF_UBH_BR_ID = uLTCF_UBH_BR_ID;
	}

	public String getULTCF_FMD() {
		return ULTCF_FMD;
	}

	public void setULTCF_FMD(String uLTCF_FMD) {
		ULTCF_FMD = uLTCF_FMD;
	}

	public String getULTCF_TOD() {
		return ULTCF_TOD;
	}

	public void setULTCF_TOD(String uLTCF_TOD) {
		ULTCF_TOD = uLTCF_TOD;
	}

	public String getULTCF_AMND_FMD() {
		return ULTCF_AMND_FMD;
	}

	public void setULTCF_AMND_FMD(String uLTCF_AMND_FMD) {
		ULTCF_AMND_FMD = uLTCF_AMND_FMD;
	}

	public String getULTCF_AMND_TOD() {
		return ULTCF_AMND_TOD;
	}

	public void setULTCF_AMND_TOD(String uLTCF_AMND_TOD) {
		ULTCF_AMND_TOD = uLTCF_AMND_TOD;
	}

	public String getULTCF_AMT_BC() {
		return ULTCF_AMT_BC;
	}

	public void setULTCF_AMT_BC(String uLTCF_AMT_BC) {
		ULTCF_AMT_BC = uLTCF_AMT_BC;
	}

	public String getULTCF_ADJ_AMT_BC() {
		return ULTCF_ADJ_AMT_BC;
	}

	public void setULTCF_ADJ_AMT_BC(String uLTCF_ADJ_AMT_BC) {
		ULTCF_ADJ_AMT_BC = uLTCF_ADJ_AMT_BC;
	}

	public String getULTCF_CUST_SHARE_TCF_BC() {
		return ULTCF_CUST_SHARE_TCF_BC;
	}

	public void setULTCF_CUST_SHARE_TCF_BC(String uLTCF_CUST_SHARE_TCF_BC) {
		ULTCF_CUST_SHARE_TCF_BC = uLTCF_CUST_SHARE_TCF_BC;
	}

	public String getULTCF_CUR_ID() {
		return ULTCF_CUR_ID;
	}

	public void setULTCF_CUR_ID(String uLTCF_CUR_ID) {
		ULTCF_CUR_ID = uLTCF_CUR_ID;
	}

	public String getULTCF_CUR_X_RATE() {
		return ULTCF_CUR_X_RATE;
	}

	public void setULTCF_CUR_X_RATE(String uLTCF_CUR_X_RATE) {
		ULTCF_CUR_X_RATE = uLTCF_CUR_X_RATE;
	}

	public String getULTCF_INST_MODE() {
		return ULTCF_INST_MODE;
	}

	public void setULTCF_INST_MODE(String uLTCF_INST_MODE) {
		ULTCF_INST_MODE = uLTCF_INST_MODE;
	}

	public String getULTCF_ADJ_RATE() {
		return ULTCF_ADJ_RATE;
	}

	public void setULTCF_ADJ_RATE(String uLTCF_ADJ_RATE) {
		ULTCF_ADJ_RATE = uLTCF_ADJ_RATE;
	}

	public String getULTCF_ADJ_RATE_PER() {
		return ULTCF_ADJ_RATE_PER;
	}

	public void setULTCF_ADJ_RATE_PER(String uLTCF_ADJ_RATE_PER) {
		ULTCF_ADJ_RATE_PER = uLTCF_ADJ_RATE_PER;
	}

	public String getULTCF_ADJ_RATE_MOD_YN() {
		return ULTCF_ADJ_RATE_MOD_YN;
	}

	public void setULTCF_ADJ_RATE_MOD_YN(String uLTCF_ADJ_RATE_MOD_YN) {
		ULTCF_ADJ_RATE_MOD_YN = uLTCF_ADJ_RATE_MOD_YN;
	}

	public String getULTCF_SRC_AMT() {
		return ULTCF_SRC_AMT;
	}

	public void setULTCF_SRC_AMT(String uLTCF_SRC_AMT) {
		ULTCF_SRC_AMT = uLTCF_SRC_AMT;
	}

	public String getULTCF_SRC_AMT_BC() {
		return ULTCF_SRC_AMT_BC;
	}

	public void setULTCF_SRC_AMT_BC(String uLTCF_SRC_AMT_BC) {
		ULTCF_SRC_AMT_BC = uLTCF_SRC_AMT_BC;
	}

	public String getULTCF_COMP_ID() {
		return ULTCF_COMP_ID;
	}

	public void setULTCF_COMP_ID(String uLTCF_COMP_ID) {
		ULTCF_COMP_ID = uLTCF_COMP_ID;
	}

}

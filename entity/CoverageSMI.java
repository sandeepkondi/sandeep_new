package com.beyontec.mol.entity;

import javax.persistence.Embeddable;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Embeddable
//@Entity
@Table(name = "UTDS_LEVEL_CS")
@EntityListeners(AuditingEntityListener.class)
public class CoverageSMI {

	private String ULCS_ULR_ID;
	private String ULCS_ULC_MST_ID;
	private String ULCS_ULS_MST_ID;
	private String ULCS_SI;
	private String ULCS_PREM;
	private String ULCS_REC_TYP;
	private String ULCS_ULM_SGS_ID;
	private String ULCS_AMND_VER_NO;
	private String ULCS_ANNUAL_PREM;
	private String ULCS_UE_PREM;
	private String ULCS_PR_PREM;
	private String ULCS_ACNT_FLAG;
	private String ULCS_RATE_PER;
	private String ULCS_MOD_RATE;
	private String ULCS_RATE;
	private String ULCS_AMND_FMD;
	private String ULCS_AMND_TOD;
	private String ULCS_TXN_PREM;
	private String ULCS_FMD;
	private String ULCS_TOD;
	private String ULCS_ULR_TYP;
	private String ULCS_OSE_YN;
	private String ULCS_SINGLE_LIMIT;
	private String ULCS_SI_BC;
	private String ULCS_SINGLE_LIMIT_BC;
	private String ULCS_PREM_BC;
	private String ULCS_ANNUAL_PREM_BC;
	private String ULCS_UE_PREM_BC;
	private String ULCS_PR_PREM_BC;
	private String ULCS_TXN_PREM_BC;
	private String ULCS_CUR_ID;
	private String ULCS_CUR_X_RATE;
	private String ULCS_SI_RATE;
	private String ULCS_ULC_OPT_ID;
	private String ULCS_COMP_ID;

	public String getULCS_ULR_ID() {
		return ULCS_ULR_ID;
	}

	public void setULCS_ULR_ID(String uLCS_ULR_ID) {
		ULCS_ULR_ID = uLCS_ULR_ID;
	}

	public String getULCS_ULC_MST_ID() {
		return ULCS_ULC_MST_ID;
	}

	public void setULCS_ULC_MST_ID(String uLCS_ULC_MST_ID) {
		ULCS_ULC_MST_ID = uLCS_ULC_MST_ID;
	}

	public String getULCS_ULS_MST_ID() {
		return ULCS_ULS_MST_ID;
	}

	public void setULCS_ULS_MST_ID(String uLCS_ULS_MST_ID) {
		ULCS_ULS_MST_ID = uLCS_ULS_MST_ID;
	}

	public String getULCS_SI() {
		return ULCS_SI;
	}

	public void setULCS_SI(String uLCS_SI) {
		ULCS_SI = uLCS_SI;
	}

	public String getULCS_PREM() {
		return ULCS_PREM;
	}

	public void setULCS_PREM(String uLCS_PREM) {
		ULCS_PREM = uLCS_PREM;
	}

	public String getULCS_REC_TYP() {
		return ULCS_REC_TYP;
	}

	public void setULCS_REC_TYP(String uLCS_REC_TYP) {
		ULCS_REC_TYP = uLCS_REC_TYP;
	}

	public String getULCS_ULM_SGS_ID() {
		return ULCS_ULM_SGS_ID;
	}

	public void setULCS_ULM_SGS_ID(String uLCS_ULM_SGS_ID) {
		ULCS_ULM_SGS_ID = uLCS_ULM_SGS_ID;
	}

	public String getULCS_AMND_VER_NO() {
		return ULCS_AMND_VER_NO;
	}

	public void setULCS_AMND_VER_NO(String uLCS_AMND_VER_NO) {
		ULCS_AMND_VER_NO = uLCS_AMND_VER_NO;
	}

	public String getULCS_ANNUAL_PREM() {
		return ULCS_ANNUAL_PREM;
	}

	public void setULCS_ANNUAL_PREM(String uLCS_ANNUAL_PREM) {
		ULCS_ANNUAL_PREM = uLCS_ANNUAL_PREM;
	}

	public String getULCS_UE_PREM() {
		return ULCS_UE_PREM;
	}

	public void setULCS_UE_PREM(String uLCS_UE_PREM) {
		ULCS_UE_PREM = uLCS_UE_PREM;
	}

	public String getULCS_PR_PREM() {
		return ULCS_PR_PREM;
	}

	public void setULCS_PR_PREM(String uLCS_PR_PREM) {
		ULCS_PR_PREM = uLCS_PR_PREM;
	}

	public String getULCS_ACNT_FLAG() {
		return ULCS_ACNT_FLAG;
	}

	public void setULCS_ACNT_FLAG(String uLCS_ACNT_FLAG) {
		ULCS_ACNT_FLAG = uLCS_ACNT_FLAG;
	}

	public String getULCS_RATE_PER() {
		return ULCS_RATE_PER;
	}

	public void setULCS_RATE_PER(String uLCS_RATE_PER) {
		ULCS_RATE_PER = uLCS_RATE_PER;
	}

	public String getULCS_MOD_RATE() {
		return ULCS_MOD_RATE;
	}

	public void setULCS_MOD_RATE(String uLCS_MOD_RATE) {
		ULCS_MOD_RATE = uLCS_MOD_RATE;
	}

	public String getULCS_RATE() {
		return ULCS_RATE;
	}

	public void setULCS_RATE(String uLCS_RATE) {
		ULCS_RATE = uLCS_RATE;
	}

	public String getULCS_AMND_FMD() {
		return ULCS_AMND_FMD;
	}

	public void setULCS_AMND_FMD(String uLCS_AMND_FMD) {
		ULCS_AMND_FMD = uLCS_AMND_FMD;
	}

	public String getULCS_AMND_TOD() {
		return ULCS_AMND_TOD;
	}

	public void setULCS_AMND_TOD(String uLCS_AMND_TOD) {
		ULCS_AMND_TOD = uLCS_AMND_TOD;
	}

	public String getULCS_TXN_PREM() {
		return ULCS_TXN_PREM;
	}

	public void setULCS_TXN_PREM(String uLCS_TXN_PREM) {
		ULCS_TXN_PREM = uLCS_TXN_PREM;
	}

	public String getULCS_FMD() {
		return ULCS_FMD;
	}

	public void setULCS_FMD(String uLCS_FMD) {
		ULCS_FMD = uLCS_FMD;
	}

	public String getULCS_TOD() {
		return ULCS_TOD;
	}

	public void setULCS_TOD(String uLCS_TOD) {
		ULCS_TOD = uLCS_TOD;
	}

	public String getULCS_ULR_TYP() {
		return ULCS_ULR_TYP;
	}

	public void setULCS_ULR_TYP(String uLCS_ULR_TYP) {
		ULCS_ULR_TYP = uLCS_ULR_TYP;
	}

	public String getULCS_OSE_YN() {
		return ULCS_OSE_YN;
	}

	public void setULCS_OSE_YN(String uLCS_OSE_YN) {
		ULCS_OSE_YN = uLCS_OSE_YN;
	}

	public String getULCS_SINGLE_LIMIT() {
		return ULCS_SINGLE_LIMIT;
	}

	public void setULCS_SINGLE_LIMIT(String uLCS_SINGLE_LIMIT) {
		ULCS_SINGLE_LIMIT = uLCS_SINGLE_LIMIT;
	}

	public String getULCS_SI_BC() {
		return ULCS_SI_BC;
	}

	public void setULCS_SI_BC(String uLCS_SI_BC) {
		ULCS_SI_BC = uLCS_SI_BC;
	}

	public String getULCS_SINGLE_LIMIT_BC() {
		return ULCS_SINGLE_LIMIT_BC;
	}

	public void setULCS_SINGLE_LIMIT_BC(String uLCS_SINGLE_LIMIT_BC) {
		ULCS_SINGLE_LIMIT_BC = uLCS_SINGLE_LIMIT_BC;
	}

	public String getULCS_PREM_BC() {
		return ULCS_PREM_BC;
	}

	public void setULCS_PREM_BC(String uLCS_PREM_BC) {
		ULCS_PREM_BC = uLCS_PREM_BC;
	}

	public String getULCS_ANNUAL_PREM_BC() {
		return ULCS_ANNUAL_PREM_BC;
	}

	public void setULCS_ANNUAL_PREM_BC(String uLCS_ANNUAL_PREM_BC) {
		ULCS_ANNUAL_PREM_BC = uLCS_ANNUAL_PREM_BC;
	}

	public String getULCS_UE_PREM_BC() {
		return ULCS_UE_PREM_BC;
	}

	public void setULCS_UE_PREM_BC(String uLCS_UE_PREM_BC) {
		ULCS_UE_PREM_BC = uLCS_UE_PREM_BC;
	}

	public String getULCS_PR_PREM_BC() {
		return ULCS_PR_PREM_BC;
	}

	public void setULCS_PR_PREM_BC(String uLCS_PR_PREM_BC) {
		ULCS_PR_PREM_BC = uLCS_PR_PREM_BC;
	}

	public String getULCS_TXN_PREM_BC() {
		return ULCS_TXN_PREM_BC;
	}

	public void setULCS_TXN_PREM_BC(String uLCS_TXN_PREM_BC) {
		ULCS_TXN_PREM_BC = uLCS_TXN_PREM_BC;
	}

	public String getULCS_CUR_ID() {
		return ULCS_CUR_ID;
	}

	public void setULCS_CUR_ID(String uLCS_CUR_ID) {
		ULCS_CUR_ID = uLCS_CUR_ID;
	}

	public String getULCS_CUR_X_RATE() {
		return ULCS_CUR_X_RATE;
	}

	public void setULCS_CUR_X_RATE(String uLCS_CUR_X_RATE) {
		ULCS_CUR_X_RATE = uLCS_CUR_X_RATE;
	}

	public String getULCS_SI_RATE() {
		return ULCS_SI_RATE;
	}

	public void setULCS_SI_RATE(String uLCS_SI_RATE) {
		ULCS_SI_RATE = uLCS_SI_RATE;
	}

	public String getULCS_ULC_OPT_ID() {
		return ULCS_ULC_OPT_ID;
	}

	public void setULCS_ULC_OPT_ID(String uLCS_ULC_OPT_ID) {
		ULCS_ULC_OPT_ID = uLCS_ULC_OPT_ID;
	}

	public String getULCS_COMP_ID() {
		return ULCS_COMP_ID;
	}

	public void setULCS_COMP_ID(String uLCS_COMP_ID) {
		ULCS_COMP_ID = uLCS_COMP_ID;
	}

}

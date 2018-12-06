package com.beyontec.mol.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "UTDS_LEVEL_R")
@EntityListeners(AuditingEntityListener.class)
public class RiskDetails {
	
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String ULR_ID; 
	private String ULR_RISK_TYP;
	private Date ULR_FMD;
	private Date ULR_TOD;
	private String ULR_REC_TYP;
	private int ULR_ULM_SGS_ID;
	private int ULR_AMND_VER_NO;
	private String ULR_ADDL_ENTITY_YN;
	private String ULR_CUR_ID;
	private int ULR_CUR_X_RATE;
	private Date ULR_AMND_FMD;
	private Date ULR_AMND_TOD;
	private String ULR_OSE_YN;
	private String ULR_FLEX_01;
	private String ULR_FLEX_02;
	private String ULR_FLEX_03;
	private String ULR_FLEX_04;
	private String ULR_FLEX_05;
	private String ULR_FLEX_06;
	private String ULR_FLEX_07;
	private String ULR_FLEX_08;
	private String ULR_FLEX_09;
	private String ULR_FLEX_10;
	private String ULR_FLEX_01_DESC;
	private String ULR_FLEX_02_DESC;
	private String ULR_FLEX_03_DESC;
	private String ULR_FLEX_04_DESC;
	private String ULR_FLEX_05_DESC;
	private String ULR_FLEX_06_DESC;
	private String ULR_FLEX_07_DESC;
	private String ULR_FLEX_08_DESC;
	private String ULR_FLEX_09_DESC;
	private String ULR_FLEX_10_DESC;
	private String ULR_COMP_ID;
		
	/* @ManyToOne
	    @JoinColumn(name="policy_id", nullable=false)
	 private PolicyDetails policy;*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getULR_ID() {
		return ULR_ID;
	}

	public void setULR_ID(String uLR_ID) {
		ULR_ID = uLR_ID;
	}

	public String getULR_RISK_TYP() {
		return ULR_RISK_TYP;
	}

	public void setULR_RISK_TYP(String uLR_RISK_TYP) {
		ULR_RISK_TYP = uLR_RISK_TYP;
	}

	public Date getULR_FMD() {
		return ULR_FMD;
	}

	public void setULR_FMD(Date uLR_FMD) {
		ULR_FMD = uLR_FMD;
	}

	public Date getULR_TOD() {
		return ULR_TOD;
	}

	public void setULR_TOD(Date uLR_TOD) {
		ULR_TOD = uLR_TOD;
	}

	public String getULR_REC_TYP() {
		return ULR_REC_TYP;
	}

	public void setULR_REC_TYP(String uLR_REC_TYP) {
		ULR_REC_TYP = uLR_REC_TYP;
	}

	public int getULR_ULM_SGS_ID() {
		return ULR_ULM_SGS_ID;
	}

	public void setULR_ULM_SGS_ID(int uLR_ULM_SGS_ID) {
		ULR_ULM_SGS_ID = uLR_ULM_SGS_ID;
	}

	public int getULR_AMND_VER_NO() {
		return ULR_AMND_VER_NO;
	}

	public void setULR_AMND_VER_NO(int uLR_AMND_VER_NO) {
		ULR_AMND_VER_NO = uLR_AMND_VER_NO;
	}

	public String getULR_ADDL_ENTITY_YN() {
		return ULR_ADDL_ENTITY_YN;
	}

	public void setULR_ADDL_ENTITY_YN(String uLR_ADDL_ENTITY_YN) {
		ULR_ADDL_ENTITY_YN = uLR_ADDL_ENTITY_YN;
	}

	public String getULR_CUR_ID() {
		return ULR_CUR_ID;
	}

	public void setULR_CUR_ID(String uLR_CUR_ID) {
		ULR_CUR_ID = uLR_CUR_ID;
	}

	public int getULR_CUR_X_RATE() {
		return ULR_CUR_X_RATE;
	}

	public void setULR_CUR_X_RATE(int uLR_CUR_X_RATE) {
		ULR_CUR_X_RATE = uLR_CUR_X_RATE;
	}

	public Date getULR_AMND_FMD() {
		return ULR_AMND_FMD;
	}

	public void setULR_AMND_FMD(Date uLR_AMND_FMD) {
		ULR_AMND_FMD = uLR_AMND_FMD;
	}

	public Date getULR_AMND_TOD() {
		return ULR_AMND_TOD;
	}

	public void setULR_AMND_TOD(Date uLR_AMND_TOD) {
		ULR_AMND_TOD = uLR_AMND_TOD;
	}

	public String getULR_OSE_YN() {
		return ULR_OSE_YN;
	}

	public void setULR_OSE_YN(String uLR_OSE_YN) {
		ULR_OSE_YN = uLR_OSE_YN;
	}

	public String getULR_FLEX_01() {
		return ULR_FLEX_01;
	}

	public void setULR_FLEX_01(String uLR_FLEX_01) {
		ULR_FLEX_01 = uLR_FLEX_01;
	}

	public String getULR_FLEX_02() {
		return ULR_FLEX_02;
	}

	public void setULR_FLEX_02(String uLR_FLEX_02) {
		ULR_FLEX_02 = uLR_FLEX_02;
	}

	public String getULR_FLEX_03() {
		return ULR_FLEX_03;
	}

	public void setULR_FLEX_03(String uLR_FLEX_03) {
		ULR_FLEX_03 = uLR_FLEX_03;
	}

	public String getULR_FLEX_04() {
		return ULR_FLEX_04;
	}

	public void setULR_FLEX_04(String uLR_FLEX_04) {
		ULR_FLEX_04 = uLR_FLEX_04;
	}

	public String getULR_FLEX_05() {
		return ULR_FLEX_05;
	}

	public void setULR_FLEX_05(String uLR_FLEX_05) {
		ULR_FLEX_05 = uLR_FLEX_05;
	}

	public String getULR_FLEX_06() {
		return ULR_FLEX_06;
	}

	public void setULR_FLEX_06(String uLR_FLEX_06) {
		ULR_FLEX_06 = uLR_FLEX_06;
	}

	public String getULR_FLEX_07() {
		return ULR_FLEX_07;
	}

	public void setULR_FLEX_07(String uLR_FLEX_07) {
		ULR_FLEX_07 = uLR_FLEX_07;
	}

	public String getULR_FLEX_08() {
		return ULR_FLEX_08;
	}

	public void setULR_FLEX_08(String uLR_FLEX_08) {
		ULR_FLEX_08 = uLR_FLEX_08;
	}

	public String getULR_FLEX_09() {
		return ULR_FLEX_09;
	}

	public void setULR_FLEX_09(String uLR_FLEX_09) {
		ULR_FLEX_09 = uLR_FLEX_09;
	}

	public String getULR_FLEX_10() {
		return ULR_FLEX_10;
	}

	public void setULR_FLEX_10(String uLR_FLEX_10) {
		ULR_FLEX_10 = uLR_FLEX_10;
	}

	public String getULR_FLEX_01_DESC() {
		return ULR_FLEX_01_DESC;
	}

	public void setULR_FLEX_01_DESC(String uLR_FLEX_01_DESC) {
		ULR_FLEX_01_DESC = uLR_FLEX_01_DESC;
	}

	public String getULR_FLEX_02_DESC() {
		return ULR_FLEX_02_DESC;
	}

	public void setULR_FLEX_02_DESC(String uLR_FLEX_02_DESC) {
		ULR_FLEX_02_DESC = uLR_FLEX_02_DESC;
	}

	public String getULR_FLEX_03_DESC() {
		return ULR_FLEX_03_DESC;
	}

	public void setULR_FLEX_03_DESC(String uLR_FLEX_03_DESC) {
		ULR_FLEX_03_DESC = uLR_FLEX_03_DESC;
	}

	public String getULR_FLEX_04_DESC() {
		return ULR_FLEX_04_DESC;
	}

	public void setULR_FLEX_04_DESC(String uLR_FLEX_04_DESC) {
		ULR_FLEX_04_DESC = uLR_FLEX_04_DESC;
	}

	public String getULR_FLEX_05_DESC() {
		return ULR_FLEX_05_DESC;
	}

	public void setULR_FLEX_05_DESC(String uLR_FLEX_05_DESC) {
		ULR_FLEX_05_DESC = uLR_FLEX_05_DESC;
	}

	public String getULR_FLEX_06_DESC() {
		return ULR_FLEX_06_DESC;
	}

	public void setULR_FLEX_06_DESC(String uLR_FLEX_06_DESC) {
		ULR_FLEX_06_DESC = uLR_FLEX_06_DESC;
	}

	public String getULR_FLEX_07_DESC() {
		return ULR_FLEX_07_DESC;
	}

	public void setULR_FLEX_07_DESC(String uLR_FLEX_07_DESC) {
		ULR_FLEX_07_DESC = uLR_FLEX_07_DESC;
	}

	public String getULR_FLEX_08_DESC() {
		return ULR_FLEX_08_DESC;
	}

	public void setULR_FLEX_08_DESC(String uLR_FLEX_08_DESC) {
		ULR_FLEX_08_DESC = uLR_FLEX_08_DESC;
	}

	public String getULR_FLEX_09_DESC() {
		return ULR_FLEX_09_DESC;
	}

	public void setULR_FLEX_09_DESC(String uLR_FLEX_09_DESC) {
		ULR_FLEX_09_DESC = uLR_FLEX_09_DESC;
	}

	public String getULR_FLEX_10_DESC() {
		return ULR_FLEX_10_DESC;
	}

	public void setULR_FLEX_10_DESC(String uLR_FLEX_10_DESC) {
		ULR_FLEX_10_DESC = uLR_FLEX_10_DESC;
	}

	public String getULR_COMP_ID() {
		return ULR_COMP_ID;
	}

	public void setULR_COMP_ID(String uLR_COMP_ID) {
		ULR_COMP_ID = uLR_COMP_ID;
	}
	

}

package com.beyontec.mol.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "UTDS_LEVEL_C")
@EntityListeners(AuditingEntityListener.class)
public class CoverageDetails {

	@Id
	@GeneratedValue
	private Long id;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	private String ULC_ULR_ID;
	private String ULC_MST_ID;
	private Date ULC_FMD;
	private Date ULC_TOD;
	private int ULC_SI_LIMIT;
	private String ULC_REC_TYP;
	private int ULC_ULM_SGS_ID;
	private int ULC_AMND_VER_NO;
	private Date ULC_AMND_FMD;
	private Date ULC_AMND_TOD;
	private String ULC_OSE_YN;
	private int ULC_SINGLE_LIMIT;
	private int ULC_SI_LIMIT_BC;
	private int ULC_SINGLE_LIMIT_BC;
	private String ULC_OPT_ID;
	private String ULC_COMP_ID;

	/*@ManyToOne
	@JoinColumn(name = "policy_id", nullable = false)
	private PolicyDetails policy;
*/
	
	public String getULC_ULR_ID() {
		return ULC_ULR_ID;
	}

	public void setULC_ULR_ID(String uLC_ULR_ID) {
		ULC_ULR_ID = uLC_ULR_ID;
	}

	public String getULC_MST_ID() {
		return ULC_MST_ID;
	}

	public void setULC_MST_ID(String uLC_MST_ID) {
		ULC_MST_ID = uLC_MST_ID;
	}

	public Date getULC_FMD() {
		return ULC_FMD;
	}

	public void setULC_FMD(Date uLC_FMD) {
		ULC_FMD = uLC_FMD;
	}

	public Date getULC_TOD() {
		return ULC_TOD;
	}

	public void setULC_TOD(Date uLC_TOD) {
		ULC_TOD = uLC_TOD;
	}

	public int getULC_SI_LIMIT() {
		return ULC_SI_LIMIT;
	}

	public void setULC_SI_LIMIT(int uLC_SI_LIMIT) {
		ULC_SI_LIMIT = uLC_SI_LIMIT;
	}

	public String getULC_REC_TYP() {
		return ULC_REC_TYP;
	}

	public void setULC_REC_TYP(String uLC_REC_TYP) {
		ULC_REC_TYP = uLC_REC_TYP;
	}

	public int getULC_ULM_SGS_ID() {
		return ULC_ULM_SGS_ID;
	}

	public void setULC_ULM_SGS_ID(int uLC_ULM_SGS_ID) {
		ULC_ULM_SGS_ID = uLC_ULM_SGS_ID;
	}

	public int getULC_AMND_VER_NO() {
		return ULC_AMND_VER_NO;
	}

	public void setULC_AMND_VER_NO(int uLC_AMND_VER_NO) {
		ULC_AMND_VER_NO = uLC_AMND_VER_NO;
	}

	public Date getULC_AMND_FMD() {
		return ULC_AMND_FMD;
	}

	public void setULC_AMND_FMD(Date uLC_AMND_FMD) {
		ULC_AMND_FMD = uLC_AMND_FMD;
	}

	public Date getULC_AMND_TOD() {
		return ULC_AMND_TOD;
	}

	public void setULC_AMND_TOD(Date uLC_AMND_TOD) {
		ULC_AMND_TOD = uLC_AMND_TOD;
	}

	public String getULC_OSE_YN() {
		return ULC_OSE_YN;
	}

	public void setULC_OSE_YN(String uLC_OSE_YN) {
		ULC_OSE_YN = uLC_OSE_YN;
	}

	public int getULC_SINGLE_LIMIT() {
		return ULC_SINGLE_LIMIT;
	}

	public void setULC_SINGLE_LIMIT(int uLC_SINGLE_LIMIT) {
		ULC_SINGLE_LIMIT = uLC_SINGLE_LIMIT;
	}

	public int getULC_SI_LIMIT_BC() {
		return ULC_SI_LIMIT_BC;
	}

	public void setULC_SI_LIMIT_BC(int uLC_SI_LIMIT_BC) {
		ULC_SI_LIMIT_BC = uLC_SI_LIMIT_BC;
	}

	public int getULC_SINGLE_LIMIT_BC() {
		return ULC_SINGLE_LIMIT_BC;
	}

	public void setULC_SINGLE_LIMIT_BC(int uLC_SINGLE_LIMIT_BC) {
		ULC_SINGLE_LIMIT_BC = uLC_SINGLE_LIMIT_BC;
	}

	public String getULC_OPT_ID() {
		return ULC_OPT_ID;
	}

	public void setULC_OPT_ID(String uLC_OPT_ID) {
		ULC_OPT_ID = uLC_OPT_ID;
	}

	public String getULC_COMP_ID() {
		return ULC_COMP_ID;
	}

	public void setULC_COMP_ID(String uLC_COMP_ID) {
		ULC_COMP_ID = uLC_COMP_ID;
	}

}

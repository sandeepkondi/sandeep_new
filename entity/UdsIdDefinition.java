package com.beyontec.mol.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.beyontec.mol.modal.ConfigDTO;

@Entity
@Table(name = "UDS_ID_DEFN")

@SqlResultSetMappings({
    @SqlResultSetMapping(
                      name = "insurerProcessTypeRsMapping",
                      classes = @ConstructorResult(
                                                   targetClass = ConfigDTO.class,
                                                   columns = {
                                                             @ColumnResult(name = "UID_ID", type = String.class),
                                                             @ColumnResult(name = "TYPE_NAME", type = String.class)
                                                   })
                      )
})

@NamedNativeQueries({
    @NamedNativeQuery(
                      name = "getinsurerProcessType",
                      resultSetMapping = "insurerProcessTypeRsMapping",
                      query = "SELECT UID_ID UID_ID, "
                             + "CASE WHEN :isEngLocale = 'true' "
                             + "THEN UID_DESC ELSE UID_DESC_1 "
                             + "END AS TYPE_NAME "
                             + "FROM UDS_ID_DEFN "
                             + "WHERE UID_ID_TYP = 'BBD_TRAN_TYP'"
                      )
})
@EntityListeners(AuditingEntityListener.class)
public class UdsIdDefinition {

    @EmbeddedId private UdsIdDefinitionId id;

	private String UID_MODULE_TYP;
	private String UID_UP_PROD_ID;
	private String UID_USER_MOD_YN;
	private String UID_SHORT_DESC;
	private String UID_DESC;
	private String UID_LONG_DESC;
	private String UID_VALUE;
	private Date UID_FMD;
	private Date UID_TOD;
	private String UID_CRU;
	private Date UID_CRD;
	private String UID_DISP_SEQ;
	private String UID_RISK_TYP;
	private String UID_FOR_SYS_YN;
	private String UID_SHORT_DESC_1;
	private String UID_SHORT_DESC_2;
	private String UID_SHORT_DESC_3;
	private String UID_SHORT_DESC_4;
	private String UID_DESC_1;
	private String UID_DESC_2;
	private String UID_DESC_3;
	private String UID_DESC_4;
	private String UID_LONG_DESC_1;
	private String UID_LONG_DESC_2;
	private String UID_LONG_DESC_3;
	private String UID_LONG_DESC_4;
	private String UID_VER_NO;
	private String UID_APU;
	private String UID_APPRV_STATUS;
	private String UID_APD;
	private String UID_REC_TYP;
	private String UID_EXP_IMP_REF;

    @Embeddable
    public static class UdsIdDefinitionId implements Serializable {
        private static final long serialVersionUID = 1L;


        @Column(name = "UID_COMP_ID") public String companyId;
        @Column(name = "UID_ID_TYP") public String idType;
        @Column(name = "UID_ID") public String id;
    }

    public String getCompanyId() {
        return id.companyId;
    }

    public void setCompanyId(String companyId) {
        this.id.companyId = companyId;
    }

    public String getUID_MODULE_TYP() {
		return UID_MODULE_TYP;
	}

	public void setUID_MODULE_TYP(String uID_MODULE_TYP) {
		UID_MODULE_TYP = uID_MODULE_TYP;
	}

	public String getUID_UP_PROD_ID() {
		return UID_UP_PROD_ID;
	}

	public void setUID_UP_PROD_ID(String uID_UP_PROD_ID) {
		UID_UP_PROD_ID = uID_UP_PROD_ID;
	}

	public String getUID_USER_MOD_YN() {
		return UID_USER_MOD_YN;
	}

	public void setUID_USER_MOD_YN(String uID_USER_MOD_YN) {
		UID_USER_MOD_YN = uID_USER_MOD_YN;
	}

	public String getUID_ID_TYP() {
        return id.idType;
	}

	public void setUID_ID_TYP(String uID_ID_TYP) {
        id.idType = uID_ID_TYP;
	}

	public String getUID_ID() {
        return id.id;
	}

	public void setUID_ID(String uID_ID) {
        id.id = uID_ID;
	}

	public String getUID_SHORT_DESC() {
		return UID_SHORT_DESC;
	}

	public void setUID_SHORT_DESC(String uID_SHORT_DESC) {
		UID_SHORT_DESC = uID_SHORT_DESC;
	}

	public String getUID_DESC() {
		return UID_DESC;
	}

	public void setUID_DESC(String uID_DESC) {
		UID_DESC = uID_DESC;
	}

	public String getUID_LONG_DESC() {
		return UID_LONG_DESC;
	}

	public void setUID_LONG_DESC(String uID_LONG_DESC) {
		UID_LONG_DESC = uID_LONG_DESC;
	}

	public String getUID_VALUE() {
		return UID_VALUE;
	}

	public void setUID_VALUE(String uID_VALUE) {
		UID_VALUE = uID_VALUE;
	}

	public Date getUID_FMD() {
		return UID_FMD;
	}

	public void setUID_FMD(Date uID_FMD) {
		UID_FMD = uID_FMD;
	}

	public Date getUID_TOD() {
		return UID_TOD;
	}

	public void setUID_TOD(Date uID_TOD) {
		UID_TOD = uID_TOD;
	}

	public String getUID_CRU() {
		return UID_CRU;
	}

	public void setUID_CRU(String uID_CRU) {
		UID_CRU = uID_CRU;
	}

	public Date getUID_CRD() {
		return UID_CRD;
	}

	public void setUID_CRD(Date uID_CRD) {
		UID_CRD = uID_CRD;
	}

	public String getUID_DISP_SEQ() {
		return UID_DISP_SEQ;
	}

	public void setUID_DISP_SEQ(String uID_DISP_SEQ) {
		UID_DISP_SEQ = uID_DISP_SEQ;
	}

	public String getUID_RISK_TYP() {
		return UID_RISK_TYP;
	}

	public void setUID_RISK_TYP(String uID_RISK_TYP) {
		UID_RISK_TYP = uID_RISK_TYP;
	}

	public String getUID_FOR_SYS_YN() {
		return UID_FOR_SYS_YN;
	}

	public void setUID_FOR_SYS_YN(String uID_FOR_SYS_YN) {
		UID_FOR_SYS_YN = uID_FOR_SYS_YN;
	}

	public String getUID_SHORT_DESC_1() {
		return UID_SHORT_DESC_1;
	}

	public void setUID_SHORT_DESC_1(String uID_SHORT_DESC_1) {
		UID_SHORT_DESC_1 = uID_SHORT_DESC_1;
	}

	public String getUID_SHORT_DESC_2() {
		return UID_SHORT_DESC_2;
	}

	public void setUID_SHORT_DESC_2(String uID_SHORT_DESC_2) {
		UID_SHORT_DESC_2 = uID_SHORT_DESC_2;
	}

	public String getUID_SHORT_DESC_3() {
		return UID_SHORT_DESC_3;
	}

	public void setUID_SHORT_DESC_3(String uID_SHORT_DESC_3) {
		UID_SHORT_DESC_3 = uID_SHORT_DESC_3;
	}

	public String getUID_SHORT_DESC_4() {
		return UID_SHORT_DESC_4;
	}

	public void setUID_SHORT_DESC_4(String uID_SHORT_DESC_4) {
		UID_SHORT_DESC_4 = uID_SHORT_DESC_4;
	}

	public String getUID_DESC_1() {
		return UID_DESC_1;
	}

	public void setUID_DESC_1(String uID_DESC_1) {
		UID_DESC_1 = uID_DESC_1;
	}

	public String getUID_DESC_2() {
		return UID_DESC_2;
	}

	public void setUID_DESC_2(String uID_DESC_2) {
		UID_DESC_2 = uID_DESC_2;
	}

	public String getUID_DESC_3() {
		return UID_DESC_3;
	}

	public void setUID_DESC_3(String uID_DESC_3) {
		UID_DESC_3 = uID_DESC_3;
	}

	public String getUID_DESC_4() {
		return UID_DESC_4;
	}

	public void setUID_DESC_4(String uID_DESC_4) {
		UID_DESC_4 = uID_DESC_4;
	}

	public String getUID_LONG_DESC_1() {
		return UID_LONG_DESC_1;
	}

	public void setUID_LONG_DESC_1(String uID_LONG_DESC_1) {
		UID_LONG_DESC_1 = uID_LONG_DESC_1;
	}

	public String getUID_LONG_DESC_2() {
		return UID_LONG_DESC_2;
	}

	public void setUID_LONG_DESC_2(String uID_LONG_DESC_2) {
		UID_LONG_DESC_2 = uID_LONG_DESC_2;
	}

	public String getUID_LONG_DESC_3() {
		return UID_LONG_DESC_3;
	}

	public void setUID_LONG_DESC_3(String uID_LONG_DESC_3) {
		UID_LONG_DESC_3 = uID_LONG_DESC_3;
	}

	public String getUID_LONG_DESC_4() {
		return UID_LONG_DESC_4;
	}

	public void setUID_LONG_DESC_4(String uID_LONG_DESC_4) {
		UID_LONG_DESC_4 = uID_LONG_DESC_4;
	}

	public String getUID_VER_NO() {
		return UID_VER_NO;
	}

	public void setUID_VER_NO(String uID_VER_NO) {
		UID_VER_NO = uID_VER_NO;
	}

	public String getUID_APU() {
		return UID_APU;
	}

	public void setUID_APU(String uID_APU) {
		UID_APU = uID_APU;
	}

	public String getUID_APPRV_STATUS() {
		return UID_APPRV_STATUS;
	}

	public void setUID_APPRV_STATUS(String uID_APPRV_STATUS) {
		UID_APPRV_STATUS = uID_APPRV_STATUS;
	}

	public String getUID_APD() {
		return UID_APD;
	}

	public void setUID_APD(String uID_APD) {
		UID_APD = uID_APD;
	}

	public String getUID_REC_TYP() {
		return UID_REC_TYP;
	}

	public void setUID_REC_TYP(String uID_REC_TYP) {
		UID_REC_TYP = uID_REC_TYP;
	}

	public String getUID_EXP_IMP_REF() {
		return UID_EXP_IMP_REF;
	}

	public void setUID_EXP_IMP_REF(String uID_EXP_IMP_REF) {
		UID_EXP_IMP_REF = uID_EXP_IMP_REF;
	}

    public UdsIdDefinitionId getId() {
        return id;
    }

    public void setId(UdsIdDefinitionId id) {
        this.id = id;
    }
}

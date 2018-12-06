package com.beyontec.mol.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CTDS_LEVEL_FNOL")
public class ClaimTransactionFNOL {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clf_sgs_id_generator")
    @SequenceGenerator(name = "clf_sgs_id_generator", sequenceName = "SEQ_CLF_SGS_ID", allocationSize = 1)
    @Column(name = "CLF_SGS_ID")
    private Long fnolSgsId;

    @Column(name = "CLF_COMP_ID")
    private String companyId;

    @Column(name = "CLF_ULM_NO")
    private String policyNo;

    @Column(name = "CLF_CUST_ID")
    private String customerId;

    @Column(name = "CLF_REFNO")
    private String fnolRefNo;

    @Column(name = "CLF_CID")
    private Date lossIntimationDate;

    @Column(name = "CLF_CLD")
    private Date lossDate;

    @Column(name = "CLF_LOSS_DESC")
    private String lossDescription;

    @Column(name = "CLF_LOSS_LOC")
    private String lossLocation;

    @Column(name = "CLF_CDD")
    private Date lossDiscoveryDate;

    @Column(name = "CLF_COL_TYP")
    private String lossType;

    @Column(name = "CLF_CLMNT_CUST_YN")
    private String claimantcustomerYN;

    @Column(name = "CLF_REP_BY_CUST_YN")
    private String reportedBy;

    @Column(name = "CLF_STATUS")
    private String fnolStatus;

    @Column(name = "CLF_PROD_ID")
    private String productId;

    @Column(name = "CLF_COB_ID")
    private String cobId;

    private int CLF_ULM_REN_COUNT;

    @Column(name = "CLF_POL_FMD")
    private Date policyEffectiveFrom;

    @Column(name = "CLF_POL_TOD")
    private Date policyEffectiveTo;

    @Column(name = "CLF_CLC_NO")
    private String claimNo;

    @Column(name = "CLF_CARRIER_ID")
    private String PolicyCarrierId;

    @Column(name = "CLF_LOSS_STATE")
    private String lossState;
    private String CLF_FNOL_TYP;
    private String CLF_ULM_INS_LA_NO;

    @Column(name = "CLF_CRU")
    private String createdUser;

    @Column(name = "CLF_CRD")
    private Date createdDate;
    private String CLF_REP_MTHD;
    private String CLF_REP_MTHD_DESC;
    private String CLF_REP_BY;
    private String CLF_REP_BY_DESC;
    private String CLF_REP_BY_ID;
    private String CLF_ACNT_REF_NO;

    @Column(name = "CLF_DIVN_ID")
    private String divisionId;

    @Column(name = "CLF_DEPT_ID")
    private String departmentId;
    private String CLF_SPL_ACCESS_YN;
    private int CLF_LINK_REF_ID;
    private String CLF_CARRIER_STATE;

    @Column(name = "CLF_LOSS_LOC_DESC")
    private String lossLocatiobDesc;

    @Column(name = "CLF_LOSS_CITY")
    private String lossCity;

    @Column(name = "CLF_INSRD_ID")
    private String insuredId;
    private String CLF_SRC_TYP;

    @Column(name = "CLF_MPOL_NO")
    private String masterPolicyNo;

    @Column(name = "CLF_MPOL_FMD")
    private Date MasterpolicyEffectiveFrom;

    @Column(name = "CLF_MPOL_TOD")
    private Date MasterpolicyEffectiveTo;

    private float CLF_XS_AMT;
    private String CLF_XS_REC_YN;

    @Column(name = "CLF_REP_DIVN_ID")
    private String reportedDivisionId;

    private String CLF_INS_FAULT_YN;
    private String CLF_POLICE_ID;
    private String CLF_POL_REP_NO;
    private String CLF_TICO_COL_TYP;
    private String CLF_ACC_TYP_DESC;
    private String CLF_CAUSE_OF_ACC;
    private String CLF_REPORT_TYP;
    private float CLF_XS_AMT_BC;
    private Date CLF_CIID;
    private String CLF_CASH_CALL_YN;
    private String CLF_INS_COMP_ID;
    private String CLF_INS_COMP_NAME;
    private String CLF_INS_COMP_APPR_YN;
    private String CLF_INS_COMP_APPR_USER;
    private Date CLF_INS_COMP_APPR_DATE;
    private String CLF_INS_COMP_REMARKS;
    @Column(name = "CLF_CLM_REASON")
    private String claimReason;
   // CLF_REC_TYP
    @Column(name = "CLF_GROUP_ID")
    private String groupId;
    @Column(name = "CLF_CLM_REASON_2")
    private String claimReason2;
    @Column(name = "CLF_REMARKS")
    private String remarks;
    
    public String getClaimReason() {
		return claimReason;
	}

	public void setClaimReason(String claimReason) {
		this.claimReason = claimReason;
	}

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

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFnolRefNo() {
        return fnolRefNo;
    }

    public void setFnolRefNo(String fnolRefNo) {
        this.fnolRefNo = fnolRefNo;
    }

    public Date getLossIntimationDate() {
        return lossIntimationDate;
    }

    public void setLossIntimationDate(Date lossIntimationDate) {
        this.lossIntimationDate = lossIntimationDate;
    }

    public Date getLossDate() {
        return lossDate;
    }

    public void setLossDate(Date lossDate) {
        this.lossDate = lossDate;
    }

    public String getLossDescription() {
        return lossDescription;
    }

    public void setLossDescription(String lossDescription) {
        this.lossDescription = lossDescription;
    }

    public String getLossLocation() {
        return lossLocation;
    }

    public void setLossLocation(String lossLocation) {
        this.lossLocation = lossLocation;
    }

    public Date getLossDiscoveryDate() {
        return lossDiscoveryDate;
    }

    public void setLossDiscoveryDate(Date lossDiscoveryDate) {
        this.lossDiscoveryDate = lossDiscoveryDate;
    }

    public String getLossType() {
        return lossType;
    }

    public void setLossType(String lossType) {
        this.lossType = lossType;
    }

    public String getClaimantcustomerYN() {
        return claimantcustomerYN;
    }

    public void setClaimantcustomerYN(String claimantcustomerYN) {
        this.claimantcustomerYN = claimantcustomerYN;
    }

    public String getReportedBy() {
        return reportedBy;
    }

    public void setReportedBy(String reportedBy) {
        this.reportedBy = reportedBy;
    }

    public String getFnolStatus() {
        return fnolStatus;
    }

    public void setFnolStatus(String fnolStatus) {
        this.fnolStatus = fnolStatus;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCobId() {
        return cobId;
    }

    public void setCobId(String cobId) {
        this.cobId = cobId;
    }

    public int getCLF_ULM_REN_COUNT() {
        return CLF_ULM_REN_COUNT;
    }

    public void setCLF_ULM_REN_COUNT(int cLF_ULM_REN_COUNT) {
        CLF_ULM_REN_COUNT = cLF_ULM_REN_COUNT;
    }

    public Date getPolicyEffectiveFrom() {
        return policyEffectiveFrom;
    }

    public void setPolicyEffectiveFrom(Date policyEffectiveFrom) {
        this.policyEffectiveFrom = policyEffectiveFrom;
    }

    public Date getPolicyEffectiveTo() {
        return policyEffectiveTo;
    }

    public void setPolicyEffectiveTo(Date policyEffectiveTo) {
        this.policyEffectiveTo = policyEffectiveTo;
    }

    public String getCLF_CLC_NO() {
        return claimNo;
    }

    public void setCLF_CLC_NO(String cLF_CLC_NO) {
        claimNo = cLF_CLC_NO;
    }

    public String getPolicyCarrierId() {
        return PolicyCarrierId;
    }

    public void setPolicyCarrierId(String policyCarrierId) {
        PolicyCarrierId = policyCarrierId;
    }

    public String getLossState() {
        return lossState;
    }

    public void setLossState(String lossState) {
        this.lossState = lossState;
    }

    public String getCLF_FNOL_TYP() {
        return CLF_FNOL_TYP;
    }

    public void setCLF_FNOL_TYP(String cLF_FNOL_TYP) {
        CLF_FNOL_TYP = cLF_FNOL_TYP;
    }

    public String getCLF_ULM_INS_LA_NO() {
        return CLF_ULM_INS_LA_NO;
    }

    public void setCLF_ULM_INS_LA_NO(String cLF_ULM_INS_LA_NO) {
        CLF_ULM_INS_LA_NO = cLF_ULM_INS_LA_NO;
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

    public String getCLF_REP_MTHD() {
        return CLF_REP_MTHD;
    }

    public void setCLF_REP_MTHD(String cLF_REP_MTHD) {
        CLF_REP_MTHD = cLF_REP_MTHD;
    }

    public String getCLF_REP_MTHD_DESC() {
        return CLF_REP_MTHD_DESC;
    }

    public void setCLF_REP_MTHD_DESC(String cLF_REP_MTHD_DESC) {
        CLF_REP_MTHD_DESC = cLF_REP_MTHD_DESC;
    }

    public String getCLF_REP_BY() {
        return CLF_REP_BY;
    }

    public void setCLF_REP_BY(String cLF_REP_BY) {
        CLF_REP_BY = cLF_REP_BY;
    }

    public String getCLF_REP_BY_DESC() {
        return CLF_REP_BY_DESC;
    }

    public void setCLF_REP_BY_DESC(String cLF_REP_BY_DESC) {
        CLF_REP_BY_DESC = cLF_REP_BY_DESC;
    }

    public String getCLF_REP_BY_ID() {
        return CLF_REP_BY_ID;
    }

    public void setCLF_REP_BY_ID(String cLF_REP_BY_ID) {
        CLF_REP_BY_ID = cLF_REP_BY_ID;
    }

    public String getCLF_ACNT_REF_NO() {
        return CLF_ACNT_REF_NO;
    }

    public void setCLF_ACNT_REF_NO(String cLF_ACNT_REF_NO) {
        CLF_ACNT_REF_NO = cLF_ACNT_REF_NO;
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

    public String getCLF_SPL_ACCESS_YN() {
        return CLF_SPL_ACCESS_YN;
    }

    public void setCLF_SPL_ACCESS_YN(String cLF_SPL_ACCESS_YN) {
        CLF_SPL_ACCESS_YN = cLF_SPL_ACCESS_YN;
    }

    public int getCLF_LINK_REF_ID() {
        return CLF_LINK_REF_ID;
    }

    public void setCLF_LINK_REF_ID(int cLF_LINK_REF_ID) {
        CLF_LINK_REF_ID = cLF_LINK_REF_ID;
    }

    public String getCLF_CARRIER_STATE() {
        return CLF_CARRIER_STATE;
    }

    public void setCLF_CARRIER_STATE(String cLF_CARRIER_STATE) {
        CLF_CARRIER_STATE = cLF_CARRIER_STATE;
    }

    public String getLossLocatiobDesc() {
        return lossLocatiobDesc;
    }

    public void setLossLocatiobDesc(String lossLocatiobDesc) {
        this.lossLocatiobDesc = lossLocatiobDesc;
    }

    public String getLossCity() {
        return lossCity;
    }

    public void setLossCity(String lossCity) {
        this.lossCity = lossCity;
    }

    public String getInsuredId() {
        return insuredId;
    }

    public void setInsuredId(String insuredId) {
        this.insuredId = insuredId;
    }

    public String getCLF_SRC_TYP() {
        return CLF_SRC_TYP;
    }

    public void setCLF_SRC_TYP(String cLF_SRC_TYP) {
        CLF_SRC_TYP = cLF_SRC_TYP;
    }

    public String getMasterPolicyNo() {
        return masterPolicyNo;
    }

    public void setMasterPolicyNo(String masterPolicyNo) {
        this.masterPolicyNo = masterPolicyNo;
    }

    public Date getMasterpolicyEffectiveFrom() {
        return MasterpolicyEffectiveFrom;
    }

    public void setMasterpolicyEffectiveFrom(Date masterpolicyEffectiveFrom) {
        MasterpolicyEffectiveFrom = masterpolicyEffectiveFrom;
    }

    public Date getMasterpolicyEffectiveTo() {
        return MasterpolicyEffectiveTo;
    }

    public void setMasterpolicyEffectiveTo(Date masterpolicyEffectiveTo) {
        MasterpolicyEffectiveTo = masterpolicyEffectiveTo;
    }

    public float getCLF_XS_AMT() {
        return CLF_XS_AMT;
    }

    public void setCLF_XS_AMT(float cLF_XS_AMT) {
        CLF_XS_AMT = cLF_XS_AMT;
    }

    public String getCLF_XS_REC_YN() {
        return CLF_XS_REC_YN;
    }

    public void setCLF_XS_REC_YN(String cLF_XS_REC_YN) {
        CLF_XS_REC_YN = cLF_XS_REC_YN;
    }

    public String getReportedDivisionId() {
        return reportedDivisionId;
    }

    public void setReportedDivisionId(String reportedDivisionId) {
        this.reportedDivisionId = reportedDivisionId;
    }

    public String getCLF_INS_FAULT_YN() {
        return CLF_INS_FAULT_YN;
    }

    public void setCLF_INS_FAULT_YN(String cLF_INS_FAULT_YN) {
        CLF_INS_FAULT_YN = cLF_INS_FAULT_YN;
    }

    public String getCLF_POLICE_ID() {
        return CLF_POLICE_ID;
    }

    public void setCLF_POLICE_ID(String cLF_POLICE_ID) {
        CLF_POLICE_ID = cLF_POLICE_ID;
    }

    public String getCLF_POL_REP_NO() {
        return CLF_POL_REP_NO;
    }

    public void setCLF_POL_REP_NO(String cLF_POL_REP_NO) {
        CLF_POL_REP_NO = cLF_POL_REP_NO;
    }

    public String getCLF_TICO_COL_TYP() {
        return CLF_TICO_COL_TYP;
    }

    public void setCLF_TICO_COL_TYP(String cLF_TICO_COL_TYP) {
        CLF_TICO_COL_TYP = cLF_TICO_COL_TYP;
    }

    public String getCLF_ACC_TYP_DESC() {
        return CLF_ACC_TYP_DESC;
    }

    public void setCLF_ACC_TYP_DESC(String cLF_ACC_TYP_DESC) {
        CLF_ACC_TYP_DESC = cLF_ACC_TYP_DESC;
    }

    public String getCLF_CAUSE_OF_ACC() {
        return CLF_CAUSE_OF_ACC;
    }

    public void setCLF_CAUSE_OF_ACC(String cLF_CAUSE_OF_ACC) {
        CLF_CAUSE_OF_ACC = cLF_CAUSE_OF_ACC;
    }

    public String getCLF_REPORT_TYP() {
        return CLF_REPORT_TYP;
    }

    public void setCLF_REPORT_TYP(String cLF_REPORT_TYP) {
        CLF_REPORT_TYP = cLF_REPORT_TYP;
    }

    public float getCLF_XS_AMT_BC() {
        return CLF_XS_AMT_BC;
    }

    public void setCLF_XS_AMT_BC(float cLF_XS_AMT_BC) {
        CLF_XS_AMT_BC = cLF_XS_AMT_BC;
    }

    public Date getCLF_CIID() {
        return CLF_CIID;
    }

    public void setCLF_CIID(Date cLF_CIID) {
        CLF_CIID = cLF_CIID;
    }

    public String getCLF_CASH_CALL_YN() {
        return CLF_CASH_CALL_YN;
    }

    public void setCLF_CASH_CALL_YN(String cLF_CASH_CALL_YN) {
        CLF_CASH_CALL_YN = cLF_CASH_CALL_YN;
    }

    public String getCLF_INS_COMP_ID() {
        return CLF_INS_COMP_ID;
    }

    public void setCLF_INS_COMP_ID(String cLF_INS_COMP_ID) {
        CLF_INS_COMP_ID = cLF_INS_COMP_ID;
    }

    public String getCLF_INS_COMP_NAME() {
        return CLF_INS_COMP_NAME;
    }

    public void setCLF_INS_COMP_NAME(String cLF_INS_COMP_NAME) {
        CLF_INS_COMP_NAME = cLF_INS_COMP_NAME;
    }

    public String getCLF_INS_COMP_APPR_YN() {
        return CLF_INS_COMP_APPR_YN;
    }

    public void setCLF_INS_COMP_APPR_YN(String cLF_INS_COMP_APPR_YN) {
        CLF_INS_COMP_APPR_YN = cLF_INS_COMP_APPR_YN;
    }

    public String getCLF_INS_COMP_APPR_USER() {
        return CLF_INS_COMP_APPR_USER;
    }

    public void setCLF_INS_COMP_APPR_USER(String cLF_INS_COMP_APPR_USER) {
        CLF_INS_COMP_APPR_USER = cLF_INS_COMP_APPR_USER;
    }

    public Date getCLF_INS_COMP_APPR_DATE() {
        return CLF_INS_COMP_APPR_DATE;
    }

    public void setCLF_INS_COMP_APPR_DATE(Date cLF_INS_COMP_APPR_DATE) {
        CLF_INS_COMP_APPR_DATE = cLF_INS_COMP_APPR_DATE;
    }

    public String getCLF_INS_COMP_REMARKS() {
        return CLF_INS_COMP_REMARKS;
    }

    public void setCLF_INS_COMP_REMARKS(String cLF_INS_COMP_REMARKS) {
        CLF_INS_COMP_REMARKS = cLF_INS_COMP_REMARKS;
    }

}

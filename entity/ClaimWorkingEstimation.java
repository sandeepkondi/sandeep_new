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
@Table(name = "CWDS_LEVEL_E")
public class ClaimWorkingEstimation {

    @Id
    @Column(name = "CLE_SGS_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cle_sgs_id_generator")
    @SequenceGenerator(name = "cle_sgs_id_generator", sequenceName = "SEQ_CLE_SGS_ID", allocationSize = 1)
    private Long estimateSgsId;

    @Column(name = "CLE_CLF_SGS_ID")
    private Long fnolSgsId;

    @Column(name = "CLE_SR_NO")
    private int revisionSerialNo;

    @Column(name = "CLE_RISK_ID")
    private String riskId;

    @Column(name = "CLE_CVR_ID")
    private String coverId;

    @Column(name = "CLE_SMI_ID")
    private String smiId;

    @Column(name = "CLE_LOSS_ID")
    private String lossId;

    @Column(name = "CLE_EST_TYP")
    private String estimateType;

    @Column(name = "CLE_EST_LVL")
    private String estimateLevel;

    @Column(name = "CLE_ESTD")
    private Date estimatedDate;

    @Column(name = "CLE_EST_AMT")
    private double estimatedAmount;

    @Column(name = "CLE_CUST_ID")
    private String CustomerId;

    @Column(name = "CLE_APPRV_FLAG")
    private String approveFlag;

    @Column(name = "CLE_CLOSE_FLAG")
    private String closeFlag;

    @Column(name = "CLE_CLOSE_D")
    private Date closeDate;

    @Column(name = "CLE_CRU")
    private String createdUser;

    @Column(name = "CLE_OS_AMT")
    private double outstandingAmount;

    @Column(name = "CLE_CLS_SGS_ID")
    private int settlementRefsgsId;

    @Column(name = "CLE_DESC")
    private String estimateDescription;

    @Column(name = "CLE_TYP")
    private String type;

    private String CLE_TP_VEH_REF;
    private String CLE_TP_POL_REF;
    private String CLE_CUST_CATG_ID;

    @Column(name = "CLE_CUR_X_RATE")
    private int exchangeRate;

    @Column(name = "CLE_CUR_ID")
    private String currencyId;

    @Column(name = "CLE_OS_AMT_BC")
    private Double outstandingAmountBC;

    @Column(name = "CLE_EST_AMT_BC")
    private double outstandingAmountBCEst;

    @Column(name = "CLE_CLOSE_RSN_ID")
    private String closeReasonID;
    private String CLE_CLL_REFNO;

    @Column(name = "CLE_LOSS_TYP")
    private String losstype;
    private String CLE_EXP_PARTY_ID;

    @Column(name = "CLE_APPRV_STATUS")
    private String approveStatus;

    private String CLE_APU;

    @Column(name = "CLE_APD")
    private Date approveDate;

    private String CLE_ASSIGN_APU;

    @Column(name = "CLE_UPU")
    private String updatedUser;

    @Column(name = "CLE_UPD")
    private Date updatedDate;
    private String CLE_REF_SGS_ID;
    private String CLE_REF_NO;

    @Column(name = "CLE_COMP_ID")
    private String companyId;
    private String CLE_ASSIGN_RVU;

    @Column(name = "CLE_ESCAL_LVL")
    private String escalationlevel;
    private String CLE_INS_COMP_APPR_YN;

    public Long getEstimateSgsId() {
        return estimateSgsId;
    }

    public void setEstimateSgsId(Long estimateSgsId) {
        this.estimateSgsId = estimateSgsId;
    }

    public Long getFnolSgsId() {
        return fnolSgsId;
    }

    public void setFnolSgsId(Long fnolSgsId) {
        this.fnolSgsId = fnolSgsId;
    }

    public int getRevisionSerialNo() {
        return revisionSerialNo;
    }

    public void setRevisionSerialNo(int revisionSerialNo) {
        this.revisionSerialNo = revisionSerialNo;
    }

    public String getRiskId() {
        return riskId;
    }

    public void setRiskId(String riskId) {
        this.riskId = riskId;
    }

    public String getCoverId() {
        return coverId;
    }

    public void setCoverId(String coverId) {
        this.coverId = coverId;
    }

    public String getSmiId() {
        return smiId;
    }

    public void setSmiId(String smiId) {
        this.smiId = smiId;
    }

    public String getLossId() {
        return lossId;
    }

    public void setLossId(String lossId) {
        this.lossId = lossId;
    }

    public String getEstimateType() {
        return estimateType;
    }

    public void setEstimateType(String estimateType) {
        this.estimateType = estimateType;
    }

    public String getEstimateLevel() {
        return estimateLevel;
    }

    public void setEstimateLevel(String estimateLevel) {
        this.estimateLevel = estimateLevel;
    }

    public Date getEstimatedDate() {
        return estimatedDate;
    }

    public void setEstimatedDate(Date estimatedDate) {
        this.estimatedDate = estimatedDate;
    }

   

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String customerId) {
        CustomerId = customerId;
    }

    public String getApproveFlag() {
        return approveFlag;
    }

    public void setApproveFlag(String approveFlag) {
        this.approveFlag = approveFlag;
    }

    public String getCloseFlag() {
        return closeFlag;
    }

    public void setCloseFlag(String closeFlag) {
        this.closeFlag = closeFlag;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public double getEstimatedAmount() {
		return estimatedAmount;
	}

	public void setEstimatedAmount(double estimatedAmount) {
		this.estimatedAmount = estimatedAmount;
	}

	public double getOutstandingAmount() {
		return outstandingAmount;
	}

	public void setOutstandingAmount(double outstandingAmount) {
		this.outstandingAmount = outstandingAmount;
	}

	public int getSettlementRefsgsId() {
        return settlementRefsgsId;
    }

    public void setSettlementRefsgsId(int settlementRefsgsId) {
        this.settlementRefsgsId = settlementRefsgsId;
    }

    public String getEstimateDescription() {
        return estimateDescription;
    }

    public void setEstimateDescription(String estimateDescription) {
        this.estimateDescription = estimateDescription;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCLE_TP_VEH_REF() {
        return CLE_TP_VEH_REF;
    }

    public void setCLE_TP_VEH_REF(String cLE_TP_VEH_REF) {
        CLE_TP_VEH_REF = cLE_TP_VEH_REF;
    }

    public String getCLE_TP_POL_REF() {
        return CLE_TP_POL_REF;
    }

    public void setCLE_TP_POL_REF(String cLE_TP_POL_REF) {
        CLE_TP_POL_REF = cLE_TP_POL_REF;
    }

    public String getCLE_CUST_CATG_ID() {
        return CLE_CUST_CATG_ID;
    }

    public void setCLE_CUST_CATG_ID(String cLE_CUST_CATG_ID) {
        CLE_CUST_CATG_ID = cLE_CUST_CATG_ID;
    }

    public int getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(int exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public Double getOutstandingAmountBC() {
        return outstandingAmountBC;
    }

    public void setOutstandingAmountBC(Double outstandingAmountBC) {
        this.outstandingAmountBC = outstandingAmountBC;
    }

    public double getOutstandingAmountBCEst() {
		return outstandingAmountBCEst;
	}

	public void setOutstandingAmountBCEst(double outstandingAmountBCEst) {
		this.outstandingAmountBCEst = outstandingAmountBCEst;
	}

	public String getCloseReasonID() {
        return closeReasonID;
    }

    public void setCloseReasonID(String closeReasonID) {
        this.closeReasonID = closeReasonID;
    }

    public String getCLE_CLL_REFNO() {
        return CLE_CLL_REFNO;
    }

    public void setCLE_CLL_REFNO(String cLE_CLL_REFNO) {
        CLE_CLL_REFNO = cLE_CLL_REFNO;
    }

    public String getLosstype() {
        return losstype;
    }

    public void setLosstype(String losstype) {
        this.losstype = losstype;
    }

    public String getCLE_EXP_PARTY_ID() {
        return CLE_EXP_PARTY_ID;
    }

    public void setCLE_EXP_PARTY_ID(String cLE_EXP_PARTY_ID) {
        CLE_EXP_PARTY_ID = cLE_EXP_PARTY_ID;
    }

    public String getApproveStatus() {
        return approveStatus;
    }

    public void setApproveStatus(String approveStatus) {
        this.approveStatus = approveStatus;
    }

    public String getCLE_APU() {
        return CLE_APU;
    }

    public void setCLE_APU(String cLE_APU) {
        CLE_APU = cLE_APU;
    }

    public Date getApproveDate() {
        return approveDate;
    }

    public void setApproveDate(Date approveDate) {
        this.approveDate = approveDate;
    }

    public String getCLE_ASSIGN_APU() {
        return CLE_ASSIGN_APU;
    }

    public void setCLE_ASSIGN_APU(String cLE_ASSIGN_APU) {
        CLE_ASSIGN_APU = cLE_ASSIGN_APU;
    }

    public String getUpdatedUser() {
        return updatedUser;
    }

    public void setUpdatedUser(String updatedUser) {
        this.updatedUser = updatedUser;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getCLE_REF_SGS_ID() {
        return CLE_REF_SGS_ID;
    }

    public void setCLE_REF_SGS_ID(String cLE_REF_SGS_ID) {
        CLE_REF_SGS_ID = cLE_REF_SGS_ID;
    }

    public String getCLE_REF_NO() {
        return CLE_REF_NO;
    }

    public void setCLE_REF_NO(String cLE_REF_NO) {
        CLE_REF_NO = cLE_REF_NO;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCLE_ASSIGN_RVU() {
        return CLE_ASSIGN_RVU;
    }

    public void setCLE_ASSIGN_RVU(String cLE_ASSIGN_RVU) {
        CLE_ASSIGN_RVU = cLE_ASSIGN_RVU;
    }

    public String getEscalationlevel() {
        return escalationlevel;
    }

    public void setEscalationlevel(String escalationlevel) {
        this.escalationlevel = escalationlevel;
    }

    public String getCLE_INS_COMP_APPR_YN() {
        return CLE_INS_COMP_APPR_YN;
    }

    public void setCLE_INS_COMP_APPR_YN(String cLE_INS_COMP_APPR_YN) {
        CLE_INS_COMP_APPR_YN = cLE_INS_COMP_APPR_YN;
    }

}

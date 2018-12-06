package com.beyontec.mol.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.beyontec.mol.config.CommonConfig;

@Entity
@Table(name = "UDS_ENDORSE_DEFN")
public class EndorsementDefinition {

    @Embeddable
    public static class EndorsementDefinitionId implements Serializable {
        public static final long serialVersionUID = 1L;

        public EndorsementDefinitionId() {}
        public EndorsementDefinitionId(String typeId) {
            this.typeId = typeId;
            this.companyId = CommonConfig.COMPANY_ID;
        }

        // @formatter:off
        @Column(name = "UED_UE_TYP_ID")        private String typeId;
        @Column(name = "UED_COMP_ID")          private String companyId;
        // @formatter:on

        public String getTypeId() {
            return typeId;
        }

        public void setTypeId(String typeId) {
            this.typeId = typeId;
        }

        public String getCompanyId() {
            return companyId;
        }

        public void setCompanyId(String companyId) {
            this.companyId = companyId;
        }
    }

    // @formatter:off
    @EmbeddedId private EndorsementDefinitionId id;

    @Column(name = "UED_STYP_ID")          private String sTypeId;
    @Column(name = "UED_REASON_ID")        private String reasonId;

    @Column(name = "UED_END_TYP")          private String endorsementType;
    @Column(name = "UED_MODULE_TYP")       private String moduleType;
    @Column(name = "UED_PREM_CALC_TYP")    private String premiumCalcType;
    @Column(name = "UED_ACCESS_TYP")       private String accessType;
    @Column(name = "UED_REC_TYP")          private String recordType;

    @Column(name = "UED_DESC")             private String description;
    @Column(name = "UED_SHORT_DESC")       private String shortDescription;
    @Column(name = "UED_PRINT_DESC")       private String printDescription;


    @Column(name = "UED_ACNT_GEN_FLAG")    private String acntGenFlag;
    @Column(name = "UED_UEPREM_CALC_FLAG") private String uePremiumCalcFlag;

    @Column(name = "UED_CRU")              private String createdUser ;
    @Column(name = "UED_APU")              private String approvalUser;

    @Column(name = "UED_APPRV_STATUS")     private String approvalStatus;

    @Column(name = "UED_VER_NO")           private Long versioNumber;
    @Column(name = "UED_EXP_IMP_REF")      private Long expImpRef;

    @Column(name = "UED_CRD")              private Date createdDate;
    @Column(name = "UED_FMD")              private Date fromDate;
    @Column(name = "UED_TOD")              private Date toDate;
    @Column(name = "UED_APD")              private Date approvalDate;

    @Column(name = "UED_OFFER_YN")     @Convert(converter = BooleanAttributeConverter.class) private boolean isOffer;
    @Column(name = "UED_SHOW_RISK_YN") @Convert(converter = BooleanAttributeConverter.class) private boolean shouldShowRisk;
    @Column(name = "UED_TRAN_CUST_YN") @Convert(converter = BooleanAttributeConverter.class) private boolean isTxnCust;
    @Column(name = "UED_EXTN_YN")      @Convert(converter = BooleanAttributeConverter.class) private boolean isExtn;
    @Column(name = "UED_PREM_CALC_YN") @Convert(converter = BooleanAttributeConverter.class) private boolean shouldCalcPremium;
    // @formatter:on

    public EndorsementDefinitionId getId() {
        if (id != null) { return id; }
        id = new EndorsementDefinitionId();
        return id;
    }

    public String getsTypeId() {
        return sTypeId;
    }

    public void setsTypeId(String sTypeId) {
        this.sTypeId = sTypeId;
    }

    public String getTypeId() {
        return getId().getTypeId();
    }

    public void setTypeId(String typeId) {
        getId().setTypeId(typeId);
    }

    public String getReasonId() {
        return reasonId;
    }

    public void setReasonId(String reasonId) {
        this.reasonId = reasonId;
    }

    public String getCompanyId() {
        return getId().getCompanyId();
    }

    public void setCompanyId(String companyId) {
        getId().setCompanyId(companyId);
    }

    public String getModuleType() {
        return moduleType;
    }

    public void setModuleType(String moduleType) {
        this.moduleType = moduleType;
    }

    public String getEndorsementType() {
        return endorsementType;
    }

    public void setEndorsementType(String endorsementType) {
        this.endorsementType = endorsementType;
    }

    public String getPremiumCalcType() {
        return premiumCalcType;
    }

    public void setPremiumCalcType(String premiumCalcType) {
        this.premiumCalcType = premiumCalcType;
    }

    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getPrintDescription() {
        return printDescription;
    }

    public void setPrintDescription(String printDescription) {
        this.printDescription = printDescription;
    }

    public String getAcntGenFlag() {
        return acntGenFlag;
    }

    public void setAcntGenFlag(String acntGenFlag) {
        this.acntGenFlag = acntGenFlag;
    }

    public String getUePremiumCalcFlag() {
        return uePremiumCalcFlag;
    }

    public void setUePremiumCalcFlag(String uePremiumCalcFlag) {
        this.uePremiumCalcFlag = uePremiumCalcFlag;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public String getApprovalUser() {
        return approvalUser;
    }

    public void setApprovalUser(String approvalUser) {
        this.approvalUser = approvalUser;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public Long getVersioNumber() {
        return versioNumber;
    }

    public void setVersioNumber(Long versioNumber) {
        this.versioNumber = versioNumber;
    }

    public Long getExpImpRef() {
        return expImpRef;
    }

    public void setExpImpRef(Long expImpRef) {
        this.expImpRef = expImpRef;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
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

    public Date getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }

    public boolean isOffer() {
        return isOffer;
    }

    public void setOffer(boolean isOffer) {
        this.isOffer = isOffer;
    }

    public boolean isShouldShowRisk() {
        return shouldShowRisk;
    }

    public void setShouldShowRisk(boolean shouldShowRisk) {
        this.shouldShowRisk = shouldShowRisk;
    }

    public boolean isTxnCust() {
        return isTxnCust;
    }

    public void setTxnCust(boolean isTxnCust) {
        this.isTxnCust = isTxnCust;
    }

    public boolean isExtn() {
        return isExtn;
    }

    public void setExtn(boolean isExtn) {
        this.isExtn = isExtn;
    }

    public boolean isShouldCalcPremium() {
        return shouldCalcPremium;
    }

    public void setShouldCalcPremium(boolean shouldCalcPremium) {
        this.shouldCalcPremium = shouldCalcPremium;
    }
}

package com.beyontec.mol.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "UDS_PROD_APPL_BUSTYP")
@EntityListeners(AuditingEntityListener.class)
public class ProductAppBusType {
    //@formatter: off
    @Id
    @Column(name = "UPAB_SGS_ID")          private Long sgsId;

    @Column(name = "UPAB_CONFIG_NAME")     private String configName;
    @Column(name = "UPAB_UP_PROD_ID")      private String upProductId;
    @Column(name = "UPAB_COMP_ID")         private String companyId;
    @Column(name = "UPAB_MOD_TYP")         private String modType;
    @Column(name = "UPAB_BUS_TYP")         private String busType;
    @Column(name = "UPAB_BUS_SRC")         private String busSource;
    @Column(name = "UPAB_FUNC_ID")         private String functionId;
    @Column(name = "UPAB_CRU")             private String createdUser;
    @Column(name = "UPAB_CRD")             private Date createdDate;
    @Column(name = "UPAB_SMI_RISK_LVL_YN") private String smiRiskLevelYn;
    @Column(name = "UPAB_AUG_GROUP_TYP")   private String augGroupType;
    @Column(name = "UPAB_POL_TYP")         private String policyType;
    @Column(name = "UPAB_IN_RISK_LVL")     private String inRiskLevel;
    @Column(name = "UPAB_DFLT_POL_YN")     private String dfltPolicyYn;
    @Column(name = "UPAB_BSRC_ID")         private String bSourceId;
    @Column(name = "UPAB_SHOW_CVR_IN")     private String showCvrIn;
    @Column(name = "UPAB_MC_TYP")          private String mcType;
    @Column(name = "UPAB_SHOW_XS_IN")      private String showXsIn;
    @Column(name = "UPAB_CONFIG_NAME_1")   private String configName1;
    @Column(name = "UPAB_CONFIG_NAME_2")   private String configName2;
    @Column(name = "UPAB_CONFIG_NAME_3")   private String configName3;
    @Column(name = "UPAB_CONFIG_NAME_4")   private String configName4;
    @Column(name = "UPAB_BROK_MAND_YN")    private String brokMandatoryYn;
    @Column(name = "UPAB_FMD")             private Date fromDate;
    @Column(name = "UPAB_TOD")             private Date toDate;
    @Column(name = "UPAB_VER_NO")          private Long versionNumber;
    @Column(name = "UPAB_APU")             private String apu;
    @Column(name = "UPAB_APPRV_STATUS")    private String apprvStatus;
    @Column(name = "UPAB_APD")             private Date approvalDate;
    @Column(name = "UPAB_REC_TYP")         private String recordType;
    @Column(name = "UPAB_EXP_IMP_REF")     private Long expImpRef;
    //@formatter: on

    public Long getSgsId() {
        return sgsId;
    }

    public void setSgsId(Long sgsId) {
        this.sgsId = sgsId;
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }

    public String getUpProductId() {
        return upProductId;
    }

    public void setUpProductId(String upProductId) {
        this.upProductId = upProductId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getModType() {
        return modType;
    }

    public void setModType(String modType) {
        this.modType = modType;
    }

    public String getBusType() {
        return busType;
    }

    public void setBusType(String busType) {
        this.busType = busType;
    }

    public String getBusSource() {
        return busSource;
    }

    public void setBusSource(String busSource) {
        this.busSource = busSource;
    }

    public String getFunctionId() {
        return functionId;
    }

    public void setFunctionId(String functionId) {
        this.functionId = functionId;
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

    public String getSmiRiskLevelYn() {
        return smiRiskLevelYn;
    }

    public void setSmiRiskLevelYn(String smiRiskLevelYn) {
        this.smiRiskLevelYn = smiRiskLevelYn;
    }

    public String getAugGroupType() {
        return augGroupType;
    }

    public void setAugGroupType(String augGroupType) {
        this.augGroupType = augGroupType;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public String getInRiskLevel() {
        return inRiskLevel;
    }

    public void setInRiskLevel(String inRiskLevel) {
        this.inRiskLevel = inRiskLevel;
    }

    public String getDfltPolicyYn() {
        return dfltPolicyYn;
    }

    public void setDfltPolicyYn(String dfltPolicyYn) {
        this.dfltPolicyYn = dfltPolicyYn;
    }

    public String getbSourceId() {
        return bSourceId;
    }

    public void setbSourceId(String bSourceId) {
        this.bSourceId = bSourceId;
    }

    public String getShowCvrIn() {
        return showCvrIn;
    }

    public void setShowCvrIn(String showCvrIn) {
        this.showCvrIn = showCvrIn;
    }

    public String getMcType() {
        return mcType;
    }

    public void setMcType(String mcType) {
        this.mcType = mcType;
    }

    public String getShowXsIn() {
        return showXsIn;
    }

    public void setShowXsIn(String showXsIn) {
        this.showXsIn = showXsIn;
    }

    public String getConfigName1() {
        return configName1;
    }

    public void setConfigName1(String configName1) {
        this.configName1 = configName1;
    }

    public String getConfigName2() {
        return configName2;
    }

    public void setConfigName2(String configName2) {
        this.configName2 = configName2;
    }

    public String getConfigName3() {
        return configName3;
    }

    public void setConfigName3(String configName3) {
        this.configName3 = configName3;
    }

    public String getConfigName4() {
        return configName4;
    }

    public void setConfigName4(String configName4) {
        this.configName4 = configName4;
    }

    public String getBrokMandatoryYn() {
        return brokMandatoryYn;
    }

    public void setBrokMandatoryYn(String brokMandatoryYn) {
        this.brokMandatoryYn = brokMandatoryYn;
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

    public Long getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(Long versionNumber) {
        this.versionNumber = versionNumber;
    }

    public String getApu() {
        return apu;
    }

    public void setApu(String apu) {
        this.apu = apu;
    }

    public String getApprvStatus() {
        return apprvStatus;
    }

    public void setApprvStatus(String apprvStatus) {
        this.apprvStatus = apprvStatus;
    }

    public Date getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public Long getExpImpRef() {
        return expImpRef;
    }

    public void setExpImpRef(Long expImpRef) {
        this.expImpRef = expImpRef;
    }
}

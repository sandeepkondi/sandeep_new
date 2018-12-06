package com.beyontec.mol.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.MappedSuperclass;

@Inheritance
@MappedSuperclass
public class RiskBase {
    // @formatter:off
    @Column(name = "ULR_ACCT_CUST_ID")       protected String acctCustomerId;
    @Column(name = "ULR_ADDL_ENTITY_YN")     protected String additionalEntityYn;
    @Column(name = "ULR_AMND_FMD")           protected Date amendmentFromDate;
    @Column(name = "ULR_AMND_TOD")           protected Date amendmentToDate;
    @Column(name = "ULR_COMP_ID")            protected String companyId;
    @Column(name = "ULR_CUR_ID")             protected String curId;
    @Column(name = "ULR_CUR_NCD_LVL")        protected Long curNcdLevel;
    @Column(name = "ULR_CUR_X_RATE")         protected Long curXRate;
    @Column(name = "ULR_CVR_OPT")            protected String cvrOpt;
    @Column(name = "ULR_DIST_HA")            protected Long distHa;
    @Column(name = "ULR_DIST_HW")            protected Long distHw;
    @Column(name = "ULR_DIST_WA")            protected Long distWa;
    @Column(name = "ULR_FLEX_01")            protected String flex01;
    @Column(name = "ULR_FLEX_01_DESC")       protected String flex01Desc;
    @Column(name = "ULR_FLEX_02")            protected String flex02;
    @Column(name = "ULR_FLEX_02_DESC")       protected String flex02Desc;
    @Column(name = "ULR_FLEX_03")            protected String flex03;
    @Column(name = "ULR_FLEX_03_DESC")       protected String flex03Desc;
    @Column(name = "ULR_FLEX_04")            protected String flex04;
    @Column(name = "ULR_FLEX_04_DESC")       protected String flex04Desc;
    @Column(name = "ULR_FLEX_05")            protected String flex05;
    @Column(name = "ULR_FLEX_05_DESC")       protected String flex05Desc;
    @Column(name = "ULR_FLEX_06")            protected String flex06;
    @Column(name = "ULR_FLEX_06_DESC")       protected String flex06Desc;
    @Column(name = "ULR_FLEX_07")            protected String flex07;
    @Column(name = "ULR_FLEX_07_DESC")       protected String flex07Desc;
    @Column(name = "ULR_FLEX_08")            protected String flex08;
    @Column(name = "ULR_FLEX_08_DESC")       protected String flex08Desc;
    @Column(name = "ULR_FLEX_09")            protected String flex09;
    @Column(name = "ULR_FLEX_09_DESC")       protected String flex09Desc;
    @Column(name = "ULR_FLEX_10")            protected String flex10;
    @Column(name = "ULR_FLEX_10_DESC")       protected String flex10Desc;
    @Column(name = "ULR_FMD")                protected Date fromDate;
    @Column(name = "ULR_GRP_ID")             protected String groupId;
    @Column(name = "ULR_ID")                 protected String id;
    @Column(name = "ULR_INF_GUARD")          protected String infGaurd;
    @Column(name = "ULR_INSPECTION_YN")      protected String inspectionYn;
    @Column(name = "ULR_ISO_YN")             protected String isoYn;
    @Column(name = "ULR_LIMIT")              protected Long limit;
    @Column(name = "ULR_LIMIT_BC")           protected Long limitBc;
    @Column(name = "ULR_MAIL_ADDR_YN")       protected String mailAddressYn;
    @Column(name = "ULR_MOD_RATE")           protected Long modRate;
    @Column(name = "ULR_NCD_PROT_REN_CNT")   protected Long ncdProtRenCnt;
    @Column(name = "ULR_NCD_PROT_YN")        protected String ncdProtYn;
    @Column(name = "ULR_NO_OF_RAE")          protected Long numberOfRae;
    @Column(name = "ULR_NO_OF_RAE_INT")      protected Long numberOfRaeInt;
    @Column(name = "ULR_NO_OF_RAE_LP")       protected Long numberOfRaeLp;
    @Column(name = "ULR_OFCL_YN")            protected String ofclYn;
    @Column(name = "ULR_OSE_AMND_VER_NO")    protected Long oseAmendmentVersionNumber;
    @Column(name = "ULR_OSE_ORD_NO")         protected Long oseOrderNumber;
    @Column(name = "ULR_OSE_REF_SGS_ID")     protected Long oseRefSgsId;
    @Column(name = "ULR_OSE_YN")             protected String oseYn;
    @Column(name = "ULR_PML_RATE")           protected Long pmlRate;
    @Column(name = "ULR_PRV_CHG_LOSS")       protected Long prvChangeLoss;
    @Column(name = "ULR_PRV_CLM_FR_YRS")     protected Long prvClaimFrYrs;
    @Column(name = "ULR_PRV_CLM_YN")         protected String prvClaimYn;
    @Column(name = "ULR_QR_YN")              protected String qrYn;
    @Column(name = "ULR_RATE_PER")           protected Long ratePer;
    @Column(name = "ULR_REC_STATUS")         protected String recordStatus;
    @Column(name = "ULR_REC_TYP")            protected String recordType;
    @Column(name = "ULR_REF_ULR_ID")         protected String refUrlId;
    @Column(name = "ULR_REN_CNT")            protected Long renCount;
    @Column(name = "ULR_REPLC_AGENCY")       protected String replcAgency;
    @Column(name = "ULR_REPLC_AGENCY_EMAIL") protected String replcAgencyEmail;
    @Column(name = "ULR_REPLC_VEH_YN")       protected String replcVehYn;
    @Column(name = "ULR_RISK_TYP")           protected String riskType;
    @Column(name = "ULR_RI_BASIS")           protected String riBasis;
    @Column(name = "ULR_SINGLE_LIMIT")       protected Long singleLimit;
    @Column(name = "ULR_SPL_ACPT_YN")        protected String splAcptYn;
    @Column(name = "ULR_TOD")                protected Date toDate;
    @Column(name = "ULR_TOT_LOSS_YN")        protected String totLossYn;
    @Column(name = "ULR_VAL_STS")            protected String valSts;
    // @formatter:on

    public String getAcctCustomerId() {
        return acctCustomerId;
    }

    public void setAcctCustomerId(String acctCustomerId) {
        this.acctCustomerId = acctCustomerId;
    }

    public String getAdditionalEntityYn() {
        return additionalEntityYn;
    }

    public void setAdditionalEntityYn(String additionalEntityYn) {
        this.additionalEntityYn = additionalEntityYn;
    }

    public Date getAmendmentFromDate() {
        return amendmentFromDate;
    }

    public void setAmendmentFromDate(Date amendmentFromDate) {
        this.amendmentFromDate = amendmentFromDate;
    }

    public Date getAmendmentToDate() {
        return amendmentToDate;
    }

    public void setAmendmentToDate(Date amendmentToDate) {
        this.amendmentToDate = amendmentToDate;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCurId() {
        return curId;
    }

    public void setCurId(String curId) {
        this.curId = curId;
    }

    public Long getCurNcdLevel() {
        return curNcdLevel;
    }

    public void setCurNcdLevel(Long curNcdLevel) {
        this.curNcdLevel = curNcdLevel;
    }

    public Long getCurXRate() {
        return curXRate;
    }

    public void setCurXRate(Long curXRate) {
        this.curXRate = curXRate;
    }

    public String getCvrOpt() {
        return cvrOpt;
    }

    public void setCvrOpt(String cvrOpt) {
        this.cvrOpt = cvrOpt;
    }

    public Long getDistHa() {
        return distHa;
    }

    public void setDistHa(Long distHa) {
        this.distHa = distHa;
    }

    public Long getDistHw() {
        return distHw;
    }

    public void setDistHw(Long distHw) {
        this.distHw = distHw;
    }

    public Long getDistWa() {
        return distWa;
    }

    public void setDistWa(Long distWa) {
        this.distWa = distWa;
    }

    public String getFlex01() {
        return flex01;
    }

    public void setFlex01(String flex01) {
        this.flex01 = flex01;
    }

    public String getFlex01Desc() {
        return flex01Desc;
    }

    public void setFlex01Desc(String flex01Desc) {
        this.flex01Desc = flex01Desc;
    }

    public String getFlex02() {
        return flex02;
    }

    public void setFlex02(String flex02) {
        this.flex02 = flex02;
    }

    public String getFlex02Desc() {
        return flex02Desc;
    }

    public void setFlex02Desc(String flex02Desc) {
        this.flex02Desc = flex02Desc;
    }

    public String getFlex03() {
        return flex03;
    }

    public void setFlex03(String flex03) {
        this.flex03 = flex03;
    }

    public String getFlex03Desc() {
        return flex03Desc;
    }

    public void setFlex03Desc(String flex03Desc) {
        this.flex03Desc = flex03Desc;
    }

    public String getFlex04() {
        return flex04;
    }

    public void setFlex04(String flex04) {
        this.flex04 = flex04;
    }

    public String getFlex04Desc() {
        return flex04Desc;
    }

    public void setFlex04Desc(String flex04Desc) {
        this.flex04Desc = flex04Desc;
    }

    public String getFlex05() {
        return flex05;
    }

    public void setFlex05(String flex05) {
        this.flex05 = flex05;
    }

    public String getFlex05Desc() {
        return flex05Desc;
    }

    public void setFlex05Desc(String flex05Desc) {
        this.flex05Desc = flex05Desc;
    }

    public String getFlex06() {
        return flex06;
    }

    public void setFlex06(String flex06) {
        this.flex06 = flex06;
    }

    public String getFlex06Desc() {
        return flex06Desc;
    }

    public void setFlex06Desc(String flex06Desc) {
        this.flex06Desc = flex06Desc;
    }

    public String getFlex07() {
        return flex07;
    }

    public void setFlex07(String flex07) {
        this.flex07 = flex07;
    }

    public String getFlex07Desc() {
        return flex07Desc;
    }

    public void setFlex07Desc(String flex07Desc) {
        this.flex07Desc = flex07Desc;
    }

    public String getFlex08() {
        return flex08;
    }

    public void setFlex08(String flex08) {
        this.flex08 = flex08;
    }

    public String getFlex08Desc() {
        return flex08Desc;
    }

    public void setFlex08Desc(String flex08Desc) {
        this.flex08Desc = flex08Desc;
    }

    public String getFlex09() {
        return flex09;
    }

    public void setFlex09(String flex09) {
        this.flex09 = flex09;
    }

    public String getFlex09Desc() {
        return flex09Desc;
    }

    public void setFlex09Desc(String flex09Desc) {
        this.flex09Desc = flex09Desc;
    }

    public String getFlex10() {
        return flex10;
    }

    public void setFlex10(String flex10) {
        this.flex10 = flex10;
    }

    public String getFlex10Desc() {
        return flex10Desc;
    }

    public void setFlex10Desc(String flex10Desc) {
        this.flex10Desc = flex10Desc;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInfGaurd() {
        return infGaurd;
    }

    public void setInfGaurd(String infGaurd) {
        this.infGaurd = infGaurd;
    }

    public String getInspectionYn() {
        return inspectionYn;
    }

    public void setInspectionYn(String inspectionYn) {
        this.inspectionYn = inspectionYn;
    }

    public String getIsoYn() {
        return isoYn;
    }

    public void setIsoYn(String isoYn) {
        this.isoYn = isoYn;
    }

    public Long getLimit() {
        return limit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }

    public Long getLimitBc() {
        return limitBc;
    }

    public void setLimitBc(Long limitBc) {
        this.limitBc = limitBc;
    }

    public String getMailAddressYn() {
        return mailAddressYn;
    }

    public void setMailAddressYn(String mailAddressYn) {
        this.mailAddressYn = mailAddressYn;
    }

    public Long getModRate() {
        return modRate;
    }

    public void setModRate(Long modRate) {
        this.modRate = modRate;
    }

    public Long getNcdProtRenCnt() {
        return ncdProtRenCnt;
    }

    public void setNcdProtRenCnt(Long ncdProtRenCnt) {
        this.ncdProtRenCnt = ncdProtRenCnt;
    }

    public String getNcdProtYn() {
        return ncdProtYn;
    }

    public void setNcdProtYn(String ncdProtYn) {
        this.ncdProtYn = ncdProtYn;
    }

    public Long getNumberOfRae() {
        return numberOfRae;
    }

    public void setNumberOfRae(Long numberOfRae) {
        this.numberOfRae = numberOfRae;
    }

    public Long getNumberOfRaeInt() {
        return numberOfRaeInt;
    }

    public void setNumberOfRaeInt(Long numberOfRaeInt) {
        this.numberOfRaeInt = numberOfRaeInt;
    }

    public Long getNumberOfRaeLp() {
        return numberOfRaeLp;
    }

    public void setNumberOfRaeLp(Long numberOfRaeLp) {
        this.numberOfRaeLp = numberOfRaeLp;
    }

    public String getOfclYn() {
        return ofclYn;
    }

    public void setOfclYn(String ofclYn) {
        this.ofclYn = ofclYn;
    }

    public Long getOseAmendmentVersionNumber() {
        return oseAmendmentVersionNumber;
    }

    public void setOseAmendmentVersionNumber(Long oseAmendmentVersionNumber) {
        this.oseAmendmentVersionNumber = oseAmendmentVersionNumber;
    }

    public Long getOseOrderNumber() {
        return oseOrderNumber;
    }

    public void setOseOrderNumber(Long oseOrderNumber) {
        this.oseOrderNumber = oseOrderNumber;
    }

    public Long getOseRefSgsId() {
        return oseRefSgsId;
    }

    public void setOseRefSgsId(Long oseRefSgsId) {
        this.oseRefSgsId = oseRefSgsId;
    }

    public String getOseYn() {
        return oseYn;
    }

    public void setOseYn(String oseYn) {
        this.oseYn = oseYn;
    }

    public Long getPmlRate() {
        return pmlRate;
    }

    public void setPmlRate(Long pmlRate) {
        this.pmlRate = pmlRate;
    }

    public Long getPrvChangeLoss() {
        return prvChangeLoss;
    }

    public void setPrvChangeLoss(Long prvChangeLoss) {
        this.prvChangeLoss = prvChangeLoss;
    }

    public Long getPrvClaimFrYrs() {
        return prvClaimFrYrs;
    }

    public void setPrvClaimFrYrs(Long prvClaimFrYrs) {
        this.prvClaimFrYrs = prvClaimFrYrs;
    }

    public String getPrvClaimYn() {
        return prvClaimYn;
    }

    public void setPrvClaimYn(String prvClaimYn) {
        this.prvClaimYn = prvClaimYn;
    }

    public String getQrYn() {
        return qrYn;
    }

    public void setQrYn(String qrYn) {
        this.qrYn = qrYn;
    }

    public Long getRatePer() {
        return ratePer;
    }

    public void setRatePer(Long ratePer) {
        this.ratePer = ratePer;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getRefUrlId() {
        return refUrlId;
    }

    public void setRefUrlId(String refUrlId) {
        this.refUrlId = refUrlId;
    }

    public Long getRenCount() {
        return renCount;
    }

    public void setRenCount(Long renCount) {
        this.renCount = renCount;
    }

    public String getReplcAgency() {
        return replcAgency;
    }

    public void setReplcAgency(String replcAgency) {
        this.replcAgency = replcAgency;
    }

    public String getReplcAgencyEmail() {
        return replcAgencyEmail;
    }

    public void setReplcAgencyEmail(String replcAgencyEmail) {
        this.replcAgencyEmail = replcAgencyEmail;
    }

    public String getReplcVehYn() {
        return replcVehYn;
    }

    public void setReplcVehYn(String replcVehYn) {
        this.replcVehYn = replcVehYn;
    }

    public String getRiskType() {
        return riskType;
    }

    public void setRiskType(String riskType) {
        this.riskType = riskType;
    }

    public String getRiBasis() {
        return riBasis;
    }

    public void setRiBasis(String riBasis) {
        this.riBasis = riBasis;
    }

    public Long getSingleLimit() {
        return singleLimit;
    }

    public void setSingleLimit(Long singleLimit) {
        this.singleLimit = singleLimit;
    }

    public String getSplAcptYn() {
        return splAcptYn;
    }

    public void setSplAcptYn(String splAcptYn) {
        this.splAcptYn = splAcptYn;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getTotLossYn() {
        return totLossYn;
    }

    public void setTotLossYn(String totLossYn) {
        this.totLossYn = totLossYn;
    }

    public String getValSts() {
        return valSts;
    }

    public void setValSts(String valSts) {
        this.valSts = valSts;
    }
}

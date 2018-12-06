package com.beyontec.mol.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.MappedSuperclass;

@Inheritance
@MappedSuperclass
public class CoverageSmiBase {
    // @formatter:off
    @Column(name = "ULCS_SI_RATE")             protected Long siRate;
    @Column(name = "ULCS_SI")                  protected Long si;
    @Column(name = "ULCS_MIN_SI")              protected Long minSi;
    @Column(name = "ULCS_MAX_SI")              protected Long maxSi;
    @Column(name = "ULCS_SI_BC")               protected Long siBc;
    @Column(name = "ULCS_MIN_SI_BC")           protected Long minSiBc;
    @Column(name = "ULCS_MAX_SI_BC")           protected Long maxSiBc;

    @Column(name = "ULCS_PREM")                protected BigDecimal premium;
    @Column(name = "ULCS_ANNUAL_PREM")         protected Long annualPremium;
    @Column(name = "ULCS_UE_PREM")             protected Long uePremium;
    @Column(name = "ULCS_PR_PREM")             protected Long prPremium;
    @Column(name = "ULCS_TXN_PREM")            protected Long transactionPremium;
    @Column(name = "ULCS_PREM_BC")             protected BigDecimal premiumBc;
    @Column(name = "ULCS_ANNUAL_PREM_BC")      protected Long annualPremiumBc;
    @Column(name = "ULCS_UE_PREM_BC")          protected Long uePremiumBc;
    @Column(name = "ULCS_PR_PREM_BC")          protected Long prPremiumBc;
    @Column(name = "ULCS_TXN_PREM_BC")         protected Long transactionPremiumBc;
    @Column(name = "ULCS_MPREM_YN")            protected String mPremiumYn;
    @Column(name = "ULCS_MOD_TXN_PREM")        protected Long modTxnPremium;
    @Column(name = "ULCS_MOD_TXN_PREM_BC")     protected Long modTxnPremiumBc;

    @Column(name = "ULCS_ORG_UE_PREM")         protected Long orgUePremium;
    @Column(name = "ULCS_ORG_UE_PREM_BC")      protected Long orgUePremiumBc;
    @Column(name = "ULCS_ORG_SI")              protected Long orgSi;
    @Column(name = "ULCS_ORG_SINGLE_LIMIT")    protected Long orgSingleLimit;
    @Column(name = "ULCS_ORG_SI_BC")           protected Long orgSiBc;
    @Column(name = "ULCS_ORG_SINGLE_LIMIT_BC") protected Long orgSingleLimitBc;
    @Column(name = "ULCS_ORG_TXN_PREM")        protected Long orgTxnPremium;
    @Column(name = "ULCS_ORG_TXN_PREM_BC")     protected Long orgTxnPremiumBc;

    @Column(name = "ULCS_REC_TYP")             protected String recordType;
    @Column(name = "ULCS_ACNT_FLAG")           protected String accountFlag;

    @Column(name = "ULCS_RATE_PER")            protected Long ratePer;
    @Column(name = "ULCS_MOD_RATE")            protected Long modRate;
    @Column(name = "ULCS_RATE")                protected Long rate;

    @Column(name = "ULCS_AMND_FMD")            protected Date amendmentFromDate;
    @Column(name = "ULCS_AMND_TOD")            protected Date amendmentToDate;
    @Column(name = "ULCS_FMD")                 protected Date fromDate;
    @Column(name = "ULCS_TOD")                 protected Date toDate;

    @Column(name = "ULCS_URH_SGS_ID")          protected Long urhSgsId;
    @Column(name = "ULCS_URD_SGS_ID")          protected Long urdSgsId;

    @Column(name = "ULCS_ULR_TYP")             protected String ulrType;

    @Column(name = "ULCS_OSE_AMND_VER_NO")     protected Long oseAmendmentVersionNumber;
    @Column(name = "ULCS_OSE_YN")              protected String oseYn;
    @Column(name = "ULCS_OSE_ORD_NO")          protected Long oseOrderNumber;
    @Column(name = "ULCS_OSE_REF_SGS_ID")      protected Long oseRefSgsId;

    @Column(name = "ULCS_SINGLE_LIMIT")        protected Long singleLimit;
    @Column(name = "ULCS_SINGLE_LIMIT_BC")     protected Long singleLimitBc;

    @Column(name = "ULCS_CUR_ID")              protected String curId;
    @Column(name = "ULCS_CUR_X_RATE")          protected Long curXRate;

    @Column(name = "ULCS_RK_DATA_CHNG_YN")     protected String rkDataChangeYn;

    @Column(name = "ULCS_CSL_YN")              protected String cslYn;

    @Column(name = "ULCS_FLEX_01")             protected String flex01;
    @Column(name = "ULCS_FLEX_02")             protected String flex02;
    @Column(name = "ULCS_FLEX_03")             protected String flex03;
    @Column(name = "ULCS_FLEX_04")             protected String flex04;
    @Column(name = "ULCS_FLEX_05")             protected String flex05;
    @Column(name = "ULCS_FLEX_06")             protected String flex06;
    @Column(name = "ULCS_FLEX_07")             protected String flex07;
    @Column(name = "ULCS_FLEX_08")             protected String flex08;
    @Column(name = "ULCS_FLEX_09")             protected String flex09;
    @Column(name = "ULCS_FLEX_10")             protected String flex10;
    @Column(name = "ULCS_FLEX_11")             protected String flex11;
    @Column(name = "ULCS_FLEX_12")             protected String flex12;
    @Column(name = "ULCS_FLEX_13")             protected String flex13;
    @Column(name = "ULCS_FLEX_14")             protected String flex14;
    @Column(name = "ULCS_FLEX_15")             protected String flex15;
    @Column(name = "ULCS_FLEX_16")             protected String flex16;
    @Column(name = "ULCS_FLEX_17")             protected String flex17;
    @Column(name = "ULCS_FLEX_18")             protected String flex18;
    @Column(name = "ULCS_FLEX_19")             protected String flex19;
    @Column(name = "ULCS_FLEX_20")             protected String flex20;

    @Column(name = "ULCS_MULTIPLIER")          protected Long multiplier;
    @Column(name = "ULCS_BENEFIT_TYP")         protected String benefitType;
    @Column(name = "ULCS_CLASS_ID")            protected String classId;
    @Column(name = "ULCS_REF_ULR_ID")          protected String refUlrId;

    @Column(name = "ULCS_LOSS_LIMIT")          protected Long lossLimit;
    @Column(name = "ULCS_LOSS_LIMIT_BC")       protected Long lossLimitBc;

    @Column(name = "ULCS_PCVR_GRP")            protected String pCvrGroup;
    @Column(name = "ULCS_INT_CVR_YN")          protected String intCvrYn;
    @Column(name = "ULCS_ADD_SI")              protected String addSi;
    // @formatter:on

    public Long getSiRate() {
        return siRate;
    }

    public void setSiRate(Long siRate) {
        this.siRate = siRate;
    }

    public Long getSi() {
        return si;
    }

    public void setSi(Long si) {
        this.si = si;
    }

    public Long getMinSi() {
        return minSi;
    }

    public void setMinSi(Long minSi) {
        this.minSi = minSi;
    }

    public Long getMaxSi() {
        return maxSi;
    }

    public void setMaxSi(Long maxSi) {
        this.maxSi = maxSi;
    }

    public Long getSiBc() {
        return siBc;
    }

    public void setSiBc(Long siBc) {
        this.siBc = siBc;
    }

    public Long getMinSiBc() {
        return minSiBc;
    }

    public void setMinSiBc(Long minSiBc) {
        this.minSiBc = minSiBc;
    }

    public Long getMaxSiBc() {
        return maxSiBc;
    }

    public void setMaxSiBc(Long maxSiBc) {
        this.maxSiBc = maxSiBc;
    }

    public BigDecimal getPremium() {
        return premium;
    }

    public void setPremium(BigDecimal premium) {
        this.premium = premium;
    }

    public Long getAnnualPremium() {
        return annualPremium;
    }

    public void setAnnualPremium(Long annualPremium) {
        this.annualPremium = annualPremium;
    }

    public Long getUePremium() {
        return uePremium;
    }

    public void setUePremium(Long uePremium) {
        this.uePremium = uePremium;
    }

    public Long getPrPremium() {
        return prPremium;
    }

    public void setPrPremium(Long prPremium) {
        this.prPremium = prPremium;
    }

    public Long getTransactionPremium() {
        return transactionPremium;
    }

    public void setTransactionPremium(Long transactionPremium) {
        this.transactionPremium = transactionPremium;
    }

    public BigDecimal getPremiumBc() {
        return premiumBc;
    }

    public void setPremiumBc(BigDecimal premiumBc) {
        this.premiumBc = premiumBc;
    }

    public Long getAnnualPremiumBc() {
        return annualPremiumBc;
    }

    public void setAnnualPremiumBc(Long annualPremiumBc) {
        this.annualPremiumBc = annualPremiumBc;
    }

    public Long getUePremiumBc() {
        return uePremiumBc;
    }

    public void setUePremiumBc(Long uePremiumBc) {
        this.uePremiumBc = uePremiumBc;
    }

    public Long getPrPremiumBc() {
        return prPremiumBc;
    }

    public void setPrPremiumBc(Long prPremiumBc) {
        this.prPremiumBc = prPremiumBc;
    }

    public Long getTransactionPremiumBc() {
        return transactionPremiumBc;
    }

    public void setTransactionPremiumBc(Long transactionPremiumBc) {
        this.transactionPremiumBc = transactionPremiumBc;
    }

    public String getmPremiumYn() {
        return mPremiumYn;
    }

    public void setmPremiumYn(String mPremiumYn) {
        this.mPremiumYn = mPremiumYn;
    }

    public Long getModTxnPremium() {
        return modTxnPremium;
    }

    public void setModTxnPremium(Long modTxnPremium) {
        this.modTxnPremium = modTxnPremium;
    }

    public Long getModTxnPremiumBc() {
        return modTxnPremiumBc;
    }

    public void setModTxnPremiumBc(Long modTxnPremiumBc) {
        this.modTxnPremiumBc = modTxnPremiumBc;
    }

    public Long getOrgUePremium() {
        return orgUePremium;
    }

    public void setOrgUePremium(Long orgUePremium) {
        this.orgUePremium = orgUePremium;
    }

    public Long getOrgUePremiumBc() {
        return orgUePremiumBc;
    }

    public void setOrgUePremiumBc(Long orgUePremiumBc) {
        this.orgUePremiumBc = orgUePremiumBc;
    }

    public Long getOrgSi() {
        return orgSi;
    }

    public void setOrgSi(Long orgSi) {
        this.orgSi = orgSi;
    }

    public Long getOrgSingleLimit() {
        return orgSingleLimit;
    }

    public void setOrgSingleLimit(Long orgSingleLimit) {
        this.orgSingleLimit = orgSingleLimit;
    }

    public Long getOrgSiBc() {
        return orgSiBc;
    }

    public void setOrgSiBc(Long orgSiBc) {
        this.orgSiBc = orgSiBc;
    }

    public Long getOrgSingleLimitBc() {
        return orgSingleLimitBc;
    }

    public void setOrgSingleLimitBc(Long orgSingleLimitBc) {
        this.orgSingleLimitBc = orgSingleLimitBc;
    }

    public Long getOrgTxnPremium() {
        return orgTxnPremium;
    }

    public void setOrgTxnPremium(Long orgTxnPremium) {
        this.orgTxnPremium = orgTxnPremium;
    }

    public Long getOrgTxnPremiumBc() {
        return orgTxnPremiumBc;
    }

    public void setOrgTxnPremiumBc(Long orgTxnPremiumBc) {
        this.orgTxnPremiumBc = orgTxnPremiumBc;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getAccountFlag() {
        return accountFlag;
    }

    public void setAccountFlag(String accountFlag) {
        this.accountFlag = accountFlag;
    }

    public Long getRatePer() {
        return ratePer;
    }

    public void setRatePer(Long ratePer) {
        this.ratePer = ratePer;
    }

    public Long getModRate() {
        return modRate;
    }

    public void setModRate(Long modRate) {
        this.modRate = modRate;
    }

    public Long getRate() {
        return rate;
    }

    public void setRate(Long rate) {
        this.rate = rate;
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

    public Long getUrhSgsId() {
        return urhSgsId;
    }

    public void setUrhSgsId(Long urhSgsId) {
        this.urhSgsId = urhSgsId;
    }

    public Long getUrdSgsId() {
        return urdSgsId;
    }

    public void setUrdSgsId(Long urdSgsId) {
        this.urdSgsId = urdSgsId;
    }

    public String getUlrType() {
        return ulrType;
    }

    public void setUlrType(String ulrType) {
        this.ulrType = ulrType;
    }

    public Long getOseAmendmentVersionNumber() {
        return oseAmendmentVersionNumber;
    }

    public void setOseAmendmentVersionNumber(Long oseAmendmentVersionNumber) {
        this.oseAmendmentVersionNumber = oseAmendmentVersionNumber;
    }

    public String getOseYn() {
        return oseYn;
    }

    public void setOseYn(String oseYn) {
        this.oseYn = oseYn;
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

    public Long getSingleLimit() {
        return singleLimit;
    }

    public void setSingleLimit(Long singleLimit) {
        this.singleLimit = singleLimit;
    }

    public Long getSingleLimitBc() {
        return singleLimitBc;
    }

    public void setSingleLimitBc(Long singleLimitBc) {
        this.singleLimitBc = singleLimitBc;
    }

    public String getCurId() {
        return curId;
    }

    public void setCurId(String curId) {
        this.curId = curId;
    }

    public Long getCurXRate() {
        return curXRate;
    }

    public void setCurXRate(Long curXRate) {
        this.curXRate = curXRate;
    }

    public String getRkDataChangeYn() {
        return rkDataChangeYn;
    }

    public void setRkDataChangeYn(String rkDataChangeYn) {
        this.rkDataChangeYn = rkDataChangeYn;
    }

    public String getCslYn() {
        return cslYn;
    }

    public void setCslYn(String cslYn) {
        this.cslYn = cslYn;
    }

    public String getFlex01() {
        return flex01;
    }

    public void setFlex01(String flex01) {
        this.flex01 = flex01;
    }

    public String getFlex02() {
        return flex02;
    }

    public void setFlex02(String flex02) {
        this.flex02 = flex02;
    }

    public String getFlex03() {
        return flex03;
    }

    public void setFlex03(String flex03) {
        this.flex03 = flex03;
    }

    public String getFlex04() {
        return flex04;
    }

    public void setFlex04(String flex04) {
        this.flex04 = flex04;
    }

    public String getFlex05() {
        return flex05;
    }

    public void setFlex05(String flex05) {
        this.flex05 = flex05;
    }

    public String getFlex06() {
        return flex06;
    }

    public void setFlex06(String flex06) {
        this.flex06 = flex06;
    }

    public String getFlex07() {
        return flex07;
    }

    public void setFlex07(String flex07) {
        this.flex07 = flex07;
    }

    public String getFlex08() {
        return flex08;
    }

    public void setFlex08(String flex08) {
        this.flex08 = flex08;
    }

    public String getFlex09() {
        return flex09;
    }

    public void setFlex09(String flex09) {
        this.flex09 = flex09;
    }

    public String getFlex10() {
        return flex10;
    }

    public void setFlex10(String flex10) {
        this.flex10 = flex10;
    }

    public String getFlex11() {
        return flex11;
    }

    public void setFlex11(String flex11) {
        this.flex11 = flex11;
    }

    public String getFlex12() {
        return flex12;
    }

    public void setFlex12(String flex12) {
        this.flex12 = flex12;
    }

    public String getFlex13() {
        return flex13;
    }

    public void setFlex13(String flex13) {
        this.flex13 = flex13;
    }

    public String getFlex14() {
        return flex14;
    }

    public void setFlex14(String flex14) {
        this.flex14 = flex14;
    }

    public String getFlex15() {
        return flex15;
    }

    public void setFlex15(String flex15) {
        this.flex15 = flex15;
    }

    public String getFlex16() {
        return flex16;
    }

    public void setFlex16(String flex16) {
        this.flex16 = flex16;
    }

    public String getFlex17() {
        return flex17;
    }

    public void setFlex17(String flex17) {
        this.flex17 = flex17;
    }

    public String getFlex18() {
        return flex18;
    }

    public void setFlex18(String flex18) {
        this.flex18 = flex18;
    }

    public String getFlex19() {
        return flex19;
    }

    public void setFlex19(String flex19) {
        this.flex19 = flex19;
    }

    public String getFlex20() {
        return flex20;
    }

    public void setFlex20(String flex20) {
        this.flex20 = flex20;
    }

    public Long getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(Long multiplier) {
        this.multiplier = multiplier;
    }

    public String getBenefitType() {
        return benefitType;
    }

    public void setBenefitType(String benefitType) {
        this.benefitType = benefitType;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getRefUlrId() {
        return refUlrId;
    }

    public void setRefUlrId(String refUlrId) {
        this.refUlrId = refUlrId;
    }

    public Long getLossLimit() {
        return lossLimit;
    }

    public void setLossLimit(Long lossLimit) {
        this.lossLimit = lossLimit;
    }

    public Long getLossLimitBc() {
        return lossLimitBc;
    }

    public void setLossLimitBc(Long lossLimitBc) {
        this.lossLimitBc = lossLimitBc;
    }

    public String getpCvrGroup() {
        return pCvrGroup;
    }

    public void setpCvrGroup(String pCvrGroup) {
        this.pCvrGroup = pCvrGroup;
    }

    public String getIntCvrYn() {
        return intCvrYn;
    }

    public void setIntCvrYn(String intCvrYn) {
        this.intCvrYn = intCvrYn;
    }

    public String getAddSi() {
        return addSi;
    }

    public void setAddSi(String addSi) {
        this.addSi = addSi;
    }
}

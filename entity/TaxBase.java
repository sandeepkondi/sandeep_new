package com.beyontec.mol.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.MappedSuperclass;

@Inheritance
@MappedSuperclass
public class TaxBase {
    // @formatter:off
    @Column(name = "ULTCF_TYP")               protected String type;
    @Column(name = "ULTCF_RATE")              protected BigDecimal rate;
    @Column(name = "ULTCF_RATE_PER")          protected BigDecimal ratePer;
    @Column(name = "ULTCF_ORD_NO")            protected Long orderNumber;
    @Column(name = "ULTCF_APPL_ORD_NO")       protected Long applicationOrderNo;
    @Column(name = "ULTCF_CUST_SHARE_PERC")   protected Long custSharePercentage;
    @Column(name = "ULTCF_CUST_SHARE_TCF")    protected Long custShareTcf;
    @Column(name = "ULTCF_REC_TYP")           protected String recordType;
    @Column(name = "ULTCF_SUB_TYP")           protected String subType;
    @Column(name = "ULTCF_AMT")               protected BigDecimal amount;
    @Column(name = "ULTCF_ADJ_AMT")           protected BigDecimal adjAmount;
    @Column(name = "ULTCF_UBD_SGS_ID")        protected Long ubdSgsId;
    @Column(name = "ULTCF_IDFR")              protected String idfr;
    @Column(name = "ULTCF_UBH_BR_ID")         protected String ubhBrId;
    @Column(name = "ULTCF_FMD")               protected Date fromDate;
    @Column(name = "ULTCF_TOD")               protected Date toDate;
    @Column(name = "ULTCF_AMND_FMD")          protected Date amendmentFromDate;
    @Column(name = "ULTCF_AMND_TOD")          protected Date amendmentToDate;
    @Column(name = "ULTCF_AMT_BC")            protected BigDecimal amountBc;
    @Column(name = "ULTCF_ADJ_AMT_BC")        protected BigDecimal adjAmountBc;
    @Column(name = "ULTCF_CUST_SHARE_TCF_BC") protected Long custShareTcfBc;
    @Column(name = "ULTCF_CUR_ID")            protected String curId;
    @Column(name = "ULTCF_CUR_X_RATE")        protected Long curXRate;
    @Column(name = "ULTCF_INST_MODE")         protected String instMode;
    @Column(name = "ULTCF_ADJ_RATE")          protected BigDecimal adjRate;
    @Column(name = "ULTCF_ADJ_RATE_PER")      protected BigDecimal adjRatePer;
    @Column(name = "ULTCF_ADJ_RATE_MOD_YN")   protected String adjRateModeYn;
    @Column(name = "ULTCF_SRC_AMT")           protected BigDecimal sourceAmount;
    @Column(name = "ULTCF_SRC_AMT_BC")        protected BigDecimal sourceAmountBc;
    // @formatter:on

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getRatePer() {
        return ratePer;
    }

    public void setRatePer(BigDecimal ratePer) {
        this.ratePer = ratePer;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Long getApplicationOrderNo() {
        return applicationOrderNo;
    }

    public void setApplicationOrderNo(Long applicationOrderNo) {
        this.applicationOrderNo = applicationOrderNo;
    }

    public Long getCustSharePercentage() {
        return custSharePercentage;
    }

    public void setCustSharePercentage(Long custSharePercentage) {
        this.custSharePercentage = custSharePercentage;
    }

    public Long getCustShareTcf() {
        return custShareTcf;
    }

    public void setCustShareTcf(Long custShareTcf) {
        this.custShareTcf = custShareTcf;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAdjAmount() {
        return adjAmount;
    }

    public void setAdjAmount(BigDecimal adjAmount) {
        this.adjAmount = adjAmount;
    }

    public Long getUbdSgsId() {
        return ubdSgsId;
    }

    public void setUbdSgsId(Long ubdSgsId) {
        this.ubdSgsId = ubdSgsId;
    }

    public String getIdfr() {
        return idfr;
    }

    public void setIdfr(String idfr) {
        this.idfr = idfr;
    }

    public String getUbhBrId() {
        return ubhBrId;
    }

    public void setUbhBrId(String ubhBrId) {
        this.ubhBrId = ubhBrId;
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

    public BigDecimal getAmountBc() {
        return amountBc;
    }

    public void setAmountBc(BigDecimal amountBc) {
        this.amountBc = amountBc;
    }

    public BigDecimal getAdjAmountBc() {
        return adjAmountBc;
    }

    public void setAdjAmountBc(BigDecimal adjAmountBc) {
        this.adjAmountBc = adjAmountBc;
    }

    public Long getCustShareTcfBc() {
        return custShareTcfBc;
    }

    public void setCustShareTcfBc(Long custShareTcfBc) {
        this.custShareTcfBc = custShareTcfBc;
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

    public String getInstMode() {
        return instMode;
    }

    public void setInstMode(String instMode) {
        this.instMode = instMode;
    }

    public BigDecimal getAdjRate() {
        return adjRate;
    }

    public void setAdjRate(BigDecimal adjRate) {
        this.adjRate = adjRate;
    }

    public BigDecimal getAdjRatePer() {
        return adjRatePer;
    }

    public void setAdjRatePer(BigDecimal adjRatePer) {
        this.adjRatePer = adjRatePer;
    }

    public String getAdjRateModeYn() {
        return adjRateModeYn;
    }

    public void setAdjRateModeYn(String adjRateModeYn) {
        this.adjRateModeYn = adjRateModeYn;
    }

    public BigDecimal getSourceAmount() {
        return sourceAmount;
    }

    public void setSourceAmount(BigDecimal sourceAmount) {
        this.sourceAmount = sourceAmount;
    }

    public BigDecimal getSourceAmountBc() {
        return sourceAmountBc;
    }

    public void setSourceAmountBc(BigDecimal sourceAmountBc) {
        this.sourceAmountBc = sourceAmountBc;
    }
}

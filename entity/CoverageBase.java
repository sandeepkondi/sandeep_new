package com.beyontec.mol.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.MappedSuperclass;

@Inheritance
@MappedSuperclass
public class CoverageBase {
    // @formatter:off
    @Column(name = "ULC_FMD")             protected Date fromDate;
    @Column(name = "ULC_TOD")             protected Date toDate;
    @Column(name = "ULC_NA_FMD")          protected Date naFromDate;
    @Column(name = "ULC_NA_TOD")          protected Date naToDate;
    @Column(name = "ULC_SI_LIMIT")        protected Long siLimit;
    @Column(name = "ULC_REC_TYP")         protected String recordType;
    @Column(name = "ULC_UBD_SGS_ID")      protected Long ubdSgsId;
    @Column(name = "ULC_UBH_BR_ID")       protected String ubhBrId;
    @Column(name = "ULC_IDFR")            protected String idFr;
    @Column(name = "ULC_AMND_FMD")        protected Date amendmentFromDate;
    @Column(name = "ULC_AMND_TOD")        protected Date amendmentToDate;
    @Column(name = "ULC_COL_TYP")         protected String colType;
    @Column(name = "ULC_REPL_COST")       protected Long replCost;
    @Column(name = "ULC_COINS_PERC")      protected Long coinsPerc;
    @Column(name = "ULC_OSE_AMND_VER_NO") protected Long oseAmendmentVersionNumber;
    @Column(name = "ULC_OSE_YN")          protected String oseYn;
    @Column(name = "ULC_OSE_ORD_NO")      protected Long oseOrderNumber;
    @Column(name = "ULC_OSE_REF_SGS_ID")  protected Long oseRefSgsId;
    @Column(name = "ULC_SINGLE_LIMIT")    protected Long singleLimit;
    @Column(name = "ULC_SI_LIMIT_BC")     protected Long siLimitBc;
    @Column(name = "ULC_SINGLE_LIMIT_BC") protected Long singleLimitBc;
    @Column(name = "ULC_CSL_YN")          protected String cslYn;
    @Column(name = "ULC_RI_LIMIT")        protected Long riLimit;
    @Column(name = "ULC_RI_LIMIT_BC")     protected Long riLimitBc;
    @Column(name = "ULC_AO_RB_TYP")       protected String aoRbType;
    @Column(name = "ULC_CLASS_ID")        protected String classId;
    @Column(name = "ULC_SYMBOL")          protected String symbol;
    @Column(name = "ULC_SI_RATE")         protected Long siRate;
    @Column(name = "ULC_REF_ULR_ID")      protected String refUlrId;
    @Column(name = "ULC_MST_NAME")        protected String masterName;
    @Column(name = "ULC_MST_NAME_BL")     protected String masterNameBl;
    @Column(name = "ULC_LOSS_LIMIT")      protected Long lossLimit;
    @Column(name = "ULC_LOSS_LIMIT_BC")   protected Long lossLimitBc;
    @Column(name = "ULC_PCVR_GRP")        protected String pcvrGroup;
    @Column(name = "ULC_MAND_YN")         protected String mandYn;
    @Column(name = "ULC_ADD_SI")          protected String addSi;
    // @formatter:on

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

    public Date getNaFromDate() {
        return naFromDate;
    }

    public void setNaFromDate(Date naFromDate) {
        this.naFromDate = naFromDate;
    }

    public Date getNaToDate() {
        return naToDate;
    }

    public void setNaToDate(Date naToDate) {
        this.naToDate = naToDate;
    }

    public Long getSiLimit() {
        return siLimit;
    }

    public void setSiLimit(Long siLimit) {
        this.siLimit = siLimit;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public Long getUbdSgsId() {
        return ubdSgsId;
    }

    public void setUbdSgsId(Long ubdSgsId) {
        this.ubdSgsId = ubdSgsId;
    }

    public String getUbhBrId() {
        return ubhBrId;
    }

    public void setUbhBrId(String ubhBrId) {
        this.ubhBrId = ubhBrId;
    }

    public String getIdFr() {
        return idFr;
    }

    public void setIdFr(String idFr) {
        this.idFr = idFr;
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

    public String getColType() {
        return colType;
    }

    public void setColType(String colType) {
        this.colType = colType;
    }

    public Long getReplCost() {
        return replCost;
    }

    public void setReplCost(Long replCost) {
        this.replCost = replCost;
    }

    public Long getCoinsPerc() {
        return coinsPerc;
    }

    public void setCoinsPerc(Long coinsPerc) {
        this.coinsPerc = coinsPerc;
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

    public Long getSiLimitBc() {
        return siLimitBc;
    }

    public void setSiLimitBc(Long siLimitBc) {
        this.siLimitBc = siLimitBc;
    }

    public Long getSingleLimitBc() {
        return singleLimitBc;
    }

    public void setSingleLimitBc(Long singleLimitBc) {
        this.singleLimitBc = singleLimitBc;
    }

    public String getCslYn() {
        return cslYn;
    }

    public void setCslYn(String cslYn) {
        this.cslYn = cslYn;
    }

    public Long getRiLimit() {
        return riLimit;
    }

    public void setRiLimit(Long riLimit) {
        this.riLimit = riLimit;
    }

    public Long getRiLimitBc() {
        return riLimitBc;
    }

    public void setRiLimitBc(Long riLimitBc) {
        this.riLimitBc = riLimitBc;
    }

    public String getAoRbType() {
        return aoRbType;
    }

    public void setAoRbType(String aoRbType) {
        this.aoRbType = aoRbType;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Long getSiRate() {
        return siRate;
    }

    public void setSiRate(Long siRate) {
        this.siRate = siRate;
    }

    public String getRefUlrId() {
        return refUlrId;
    }

    public void setRefUlrId(String refUlrId) {
        this.refUlrId = refUlrId;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    public String getMasterNameBl() {
        return masterNameBl;
    }

    public void setMasterNameBl(String masterNameBl) {
        this.masterNameBl = masterNameBl;
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

    public String getPcvrGroup() {
        return pcvrGroup;
    }

    public void setPcvrGroup(String pcvrGroup) {
        this.pcvrGroup = pcvrGroup;
    }

    public String getMandYn() {
        return mandYn;
    }

    public void setMandYn(String mandYn) {
        this.mandYn = mandYn;
    }

    public String getAddSi() {
        return addSi;
    }

    public void setAddSi(String addSi) {
        this.addSi = addSi;
    }
}

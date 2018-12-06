package com.beyontec.mol.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Inheritance;
import javax.persistence.MappedSuperclass;

import com.beyontec.mol.config.UdsIdDefConfig;
import com.beyontec.mol.util.DateUtil;

@Inheritance
@MappedSuperclass
public class InstallmentBase {

    @Embeddable
    private static class InstallmentBaseId implements Serializable {
        private static final long serialVersionUID = 1L;

        // @formatter:off
        @Column(name = "ULI_ULM_SGS_ID")      protected Long ulmSgsId;
        @Column(name = "ULI_AMND_VER_NO")     protected Long amendmentVersionNumber;
        @Column(name = "ULI_ULM_AMND_NO")     protected String ulmAmendmentNumber;
        @Column(name = "ULI_INST_ID")         protected String installmentId;
        @Column(name = "ULI_ACCT_CUST_ID")    protected String accountCustId;
        @Column(name = "ULI_COMP_ID")         protected String companyId;
        // @formatter:on
    }

    // @formatter:off
    @EmbeddedId private InstallmentBaseId id;

    @Column(name = "ULI_INST_NO")         protected Long installmentNumber;
    @Column(name = "ULI_BILL_DATE")       protected Date billDate;
    @Column(name = "ULI_DUE_DATE")        protected Date dueDate;
    @Column(name = "ULI_INST_AMT")        protected BigDecimal installmentAmount;
    @Column(name = "ULI_COMM_AMT")        protected Long commAmount;
    @Column(name = "ULI_PAID_AMT")        protected Long paidAmount;
    @Column(name = "ULI_PAID_FLAG")       protected String paidFlag;
    @Column(name = "ULI_COMM_ADJ_AMT")    protected Long commAdjAmount;
    @Column(name = "ULI_SHRT_ADJ_AMT")    protected Long shortAdjAmount;
    @Column(name = "ULI_OTH_ADJ_AMT")     protected Long otherAdjAmount;
    @Column(name = "ULI_REC_TYP")         protected String recordType;
    @Column(name = "ULI_INST_FEE")        protected Long installmentFee;
    @Column(name = "ULI_IFEE_FLAG")       protected String iFeeFlag;
    @Column(name = "ULI_STAMT_ID")        protected String statementId;
    @Column(name = "ULI_CUR_ID")          protected String curId;
    @Column(name = "ULI_CUR_X_RATE")      protected Long curXRate;
    @Column(name = "ULI_INST_AMT_BC")     protected BigDecimal installmentAmountBc;
    @Column(name = "ULI_PAID_AMT_BC")     protected Long paidAmountBc;
    @Column(name = "ULI_SHRT_ADJ_AMT_BC") protected Long shortAdjAmountBc;
    @Column(name = "ULI_OTH_ADJ_AMT_BC")  protected Long otherAdjAmountBc;
    @Column(name = "ULI_INST_FEE_BC")     protected Long installmentFeeBc;
    @Column(name = "ULI_COMM_AMT_BC")     protected Long commAmountBc;
    @Column(name = "ULI_COMM_ADJ_AMT_BC") protected Long commAdjAmountBc;
    @Column(name = "ULI_TCF_AMT")         protected BigDecimal tcfAmount;
    @Column(name = "ULI_TCF_AMT_BC")      protected BigDecimal tcfAmountBc;
    // @formatter:on

    public InstallmentBaseId getId() {
        if (id != null) { return id; }
        id = new InstallmentBaseId();
        return id;
    }

    public Long getUlmSgsId() {
        return getId().ulmSgsId;
    }

    public void setUlmSgsId(Long ulmSgsId) {
        getId().ulmSgsId = ulmSgsId;
    }

    public Long getAmendmentVersionNumber() {
        return getId().amendmentVersionNumber;
    }

    public void setAmendmentVersionNumber(Long amendmentVersionNumber) {
        getId().amendmentVersionNumber = amendmentVersionNumber;
    }

    public String getUlmAmendmentNumber() {
        return getId().ulmAmendmentNumber;
    }

    public void setUlmAmendmentNumber(String ulmAmendmentNumber) {
        getId().ulmAmendmentNumber = ulmAmendmentNumber;
    }

    public String getInstallmentId() {
        return getId().installmentId;
    }

    public void setInstallmentId(String installmentId) {
        getId().installmentId = installmentId;
    }

    public String getAccountCustId() {
        return getId().accountCustId;
    }

    public void setAccountCustId(String accountCustId) {
        getId().accountCustId = accountCustId;
    }

    public String getCompanyId() {
        return getId().companyId;
    }

    public void setCompanyId(String companyId) {
        getId().companyId = companyId;
    }

    public Long getInstallmentNumber() {
        return installmentNumber;
    }

    public void setInstallmentNumber(Long installmentNumber) {
        this.installmentNumber = installmentNumber;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public BigDecimal getInstallmentAmount() {
        return installmentAmount;
    }

    public void setInstallmentAmount(BigDecimal installmentAmount) {
        this.installmentAmount = installmentAmount;
    }

    public Long getCommAmount() {
        return commAmount;
    }

    public void setCommAmount(Long commAmount) {
        this.commAmount = commAmount;
    }

    public Long getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Long paidAmount) {
        this.paidAmount = paidAmount;
    }

    public String getPaidFlag() {
        return paidFlag;
    }

    public void setPaidFlag(String paidFlag) {
        this.paidFlag = paidFlag;
    }

    public Long getCommAdjAmount() {
        return commAdjAmount;
    }

    public void setCommAdjAmount(Long commAdjAmount) {
        this.commAdjAmount = commAdjAmount;
    }

    public Long getShortAdjAmount() {
        return shortAdjAmount;
    }

    public void setShortAdjAmount(Long shortAdjAmount) {
        this.shortAdjAmount = shortAdjAmount;
    }

    public Long getOtherAdjAmount() {
        return otherAdjAmount;
    }

    public void setOtherAdjAmount(Long otherAdjAmount) {
        this.otherAdjAmount = otherAdjAmount;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public Long getInstallmentFee() {
        return installmentFee;
    }

    public void setInstallmentFee(Long installmentFee) {
        this.installmentFee = installmentFee;
    }

    public String getiFeeFlag() {
        return iFeeFlag;
    }

    public void setiFeeFlag(String iFeeFlag) {
        this.iFeeFlag = iFeeFlag;
    }

    public String getStatementId() {
        return statementId;
    }

    public void setStatementId(String statementId) {
        this.statementId = statementId;
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

    public BigDecimal getInstallmentAmountBc() {
        return installmentAmountBc;
    }

    public void setInstallmentAmountBc(BigDecimal installmentAmountBc) {
        this.installmentAmountBc = installmentAmountBc;
    }

    public Long getPaidAmountBc() {
        return paidAmountBc;
    }

    public void setPaidAmountBc(Long paidAmountBc) {
        this.paidAmountBc = paidAmountBc;
    }

    public Long getShortAdjAmountBc() {
        return shortAdjAmountBc;
    }

    public void setShortAdjAmountBc(Long shortAdjAmountBc) {
        this.shortAdjAmountBc = shortAdjAmountBc;
    }

    public Long getOtherAdjAmountBc() {
        return otherAdjAmountBc;
    }

    public void setOtherAdjAmountBc(Long otherAdjAmountBc) {
        this.otherAdjAmountBc = otherAdjAmountBc;
    }

    public Long getInstallmentFeeBc() {
        return installmentFeeBc;
    }

    public void setInstallmentFeeBc(Long installmentFeeBc) {
        this.installmentFeeBc = installmentFeeBc;
    }

    public Long getCommAmountBc() {
        return commAmountBc;
    }

    public void setCommAmountBc(Long commAmountBc) {
        this.commAmountBc = commAmountBc;
    }

    public Long getCommAdjAmountBc() {
        return commAdjAmountBc;
    }

    public void setCommAdjAmountBc(Long commAdjAmountBc) {
        this.commAdjAmountBc = commAdjAmountBc;
    }

    public BigDecimal getTcfAmount() {
        return tcfAmount;
    }

    public void setTcfAmount(BigDecimal tcfAmount) {
        this.tcfAmount = tcfAmount;
    }

    public BigDecimal getTcfAmountBc() {
        return tcfAmountBc;
    }

    public void setTcfAmountBc(BigDecimal tcfAmountBc) {
        this.tcfAmountBc = tcfAmountBc;
    }

    public void loadFromUdsIdDef() {
        String noOfDaysToAddStr = UdsIdDefConfig.getUdsIdDefinitionValue(UdsIdDefConfig.ID_TYPE_DEFAULT_DATA,
                                                                       UdsIdDefConfig.ID_DEFAULT_INTALL_DUE_DATE);
        int noOfDaysToAdd = Integer.valueOf(noOfDaysToAddStr);
        this.dueDate = DateUtil.addDays(this.billDate, noOfDaysToAdd);
    }
}

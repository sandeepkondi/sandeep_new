package com.beyontec.mol.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.beyontec.mol.config.CommonConfig;

@Entity
@Table(name = "UHDS_LEVEL_TCF")
@EntityListeners(AuditingEntityListener.class)
public class TaxHistory extends TaxBase {

    @Embeddable
    private static class TaxHistoryId implements Serializable {
        private static final long serialVersionUID = 1L;

        // @formatter:off
        @Column(name = "ULTCF_ULM_SGS_ID")        private Long ulmSgsId;
        @Column(name = "ULTCF_AMND_VER_NO")       private Long amendmentVersionNo;
        @Column(name = "ULTCF_MST_ID")            private String masterId;
        @Column(name = "ULTCF_COMP_ID")           private String companyId;
        @Column(name = "ULTCF_ID")                private String taxId;
        @Column(name = "ULTCF_ULR_ID")            private String riskId;
        // @formatter:on
    }

    @EmbeddedId private TaxHistoryId id;

    private TaxHistoryId getId() {
        if (id != null) { return id; }
        id = new TaxHistoryId();
        return id;
    }

    public Long getUlmSgsId() {
        return getId().ulmSgsId;
    }

    public void setUlmSgsId(Long ulmSgsId) {
        getId().ulmSgsId = ulmSgsId;
    }

    public String getMasterId() {
        return getId().masterId;
    }

    public void setMasterId(String masterId) {
        getId().masterId = masterId;
    }

    public String getCompanyId() {
        return getId().companyId;
    }

    public void setCompanyId(String companyId) {
        getId().companyId = companyId;
    }

    public String getTaxId() {
        return getId().taxId;
    }

    public void setTaxId(String taxId) {
        getId().taxId = taxId;
    }

    public String getRiskId() {
        return getId().riskId;
    }

    public void setRiskId(String riskId) {
        getId().riskId = riskId;
    }

    public Long getAmendmentVersionNo() {
        return getId().amendmentVersionNo;
    }

    public void setAmendmentVersionNo(Long amendmentVersionNo) {
        getId().amendmentVersionNo = amendmentVersionNo;
    }

    public void loadDefaults() {
        this.recordType = CommonConfig.RECORD_TYPE_I;
    }

    // @formatter:off
    public BigDecimal getCalculatedAmount()      { return getCalculatedAmount(ratePer, rate, sourceAmount);         }
    public BigDecimal getCalculatedAdjAmount()   { return getCalculatedAmount(adjRatePer, adjRate, sourceAmount);   }
    public BigDecimal getCalculatedAmountBc()    { return getCalculatedAmount(ratePer, rate, sourceAmountBc);       }
    public BigDecimal getCalculatedAdjAmountBc() { return getCalculatedAmount(adjRatePer, adjRate, sourceAmountBc); }
    // @formatter:on

    private BigDecimal getCalculatedAmount(BigDecimal ratePer, BigDecimal rate, BigDecimal sourceAmount) {
        // TODO : round off based on Product config when data type changed to decimal
        return (BigDecimal.ONE.equals(ratePer)) ? rate : sourceAmount.multiply(rate.divide(ratePer));
    }
}

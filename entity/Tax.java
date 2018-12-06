package com.beyontec.mol.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.beyontec.mol.config.CommonConfig;

@Entity
@Table(name = "UPDS_LEVEL_TCF")
@EntityListeners(AuditingEntityListener.class)
public class Tax extends TaxBase {

    @Embeddable
    private static class TaxId implements Serializable {
        private static final long serialVersionUID = 1L;

        // @formatter:off
        @Column(name = "ULTCF_ULM_SGS_ID")        private Long ulmSgsId;
        @Column(name = "ULTCF_MST_ID")            private String masterId;
        @Column(name = "ULTCF_COMP_ID")           private String companyId;
        @Column(name = "ULTCF_ID")                private String taxId;
        @Column(name = "ULTCF_ULR_ID")            private String riskId;
        // @formatter:on
    }

    @EmbeddedId private TaxId id;

    @Column(name = "ULTCF_AMND_VER_NO") private Long amendmentVersionNo;

    private TaxId getId() {
        if (id != null) { return id; }
        id = new TaxId();
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
        return amendmentVersionNo;
    }

    public void setAmendmentVersionNo(Long amendmentVersionNo) {
        this.amendmentVersionNo = amendmentVersionNo;
    }

    public void loadDefaults() {
        this.recordType = CommonConfig.RECORD_TYPE_N;
    }

    public void loadFromMasterTax(TaxHistory masterTax) {
        this.setMasterId(masterTax.getMasterId());
        this.setTaxId(masterTax.getTaxId());

        this.type = masterTax.type;
        this.rate = masterTax.rate;
        this.ratePer = masterTax.ratePer;
        this.orderNumber = masterTax.orderNumber;
        this.applicationOrderNo = masterTax.applicationOrderNo;
        this.subType = masterTax.subType;
        this.curId = masterTax.curId;
        this.curXRate = masterTax.curXRate;
        this.adjRate = masterTax.adjRate;
        this.adjRatePer = masterTax.adjRatePer;

        this.amount = masterTax.getCalculatedAmount();
        this.amountBc = masterTax.getCalculatedAmountBc();
        this.adjAmount = masterTax.getCalculatedAdjAmount();
        this.adjAmountBc = masterTax.getCalculatedAdjAmountBc();
    }

    public void loadFromCertificatePolicy(PolicyMain certificatePolicy) {
        this.setUlmSgsId(certificatePolicy.getSgsId());
        this.setAmendmentVersionNo(certificatePolicy.getAmendmentVersionNumber());
        this.setCompanyId(certificatePolicy.getCompanyId());

        this.fromDate = certificatePolicy.getFromDate();
        this.toDate = certificatePolicy.getToDate();
        this.amendmentFromDate = certificatePolicy.getAmendmentFromDate();
        this.amendmentToDate = certificatePolicy.amendmentToDate;
    }

    public void loadFromCertificateRisk(RiskMain certificateRisk) {
        this.setRiskId(certificateRisk.getId());
    }
}

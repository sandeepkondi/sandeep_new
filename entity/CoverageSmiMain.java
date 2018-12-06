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
@Table(name = "UPDS_LEVEL_CS")
@EntityListeners(AuditingEntityListener.class)
public class CoverageSmiMain extends CoverageSmiBase {

    @Embeddable
    private static class CoverageSmiMainId implements Serializable {
        private static final long serialVersionUID = 1L;

        // @formatter:off
        @Column(name = "ULCS_ULM_SGS_ID")          protected Long ulmSgsId;
        @Column(name = "ULCS_ULR_ID")              protected String riskId;
        @Column(name = "ULCS_ULS_MST_ID")          protected String masterId;
        @Column(name = "ULCS_ULC_MST_ID")          protected String coverageMasterId;
        @Column(name = "ULCS_ULC_OPT_ID")          protected String optId;
        @Column(name = "ULCS_COMP_ID")             protected String companyId;
        // @formatter:on
    }

    @EmbeddedId private CoverageSmiMainId id;

    @Column(name = "ULCS_AMND_VER_NO") protected Long amendmentVersionNumber;

    private CoverageSmiMainId getId() {
        if (id != null) { return id; }
        id = new CoverageSmiMainId();
        return id;
    }

    public String getMasterId() {
        return getId().masterId;
    }

    public void setMasterId(String masterId) {
        getId().masterId = masterId;
    }

    public Long getUlmSgsId() {
        return getId().ulmSgsId;
    }

    public void setUlmSgsId(Long ulmSgsId) {
        getId().ulmSgsId = ulmSgsId;
    }

    public Long getAmendmentVersionNumber() {
        return amendmentVersionNumber;
    }

    public void setAmendmentVersionNumber(Long amendmentVersionNumber) {
        this.amendmentVersionNumber = amendmentVersionNumber;
    }

    public String getRiskId() {
        return getId().riskId;
    }

    public void setRiskId(String riskId) {
        getId().riskId = riskId;
    }

    public String getCompanyId() {
        return getId().companyId;
    }

    public void setCompanyId(String companyId) {
        getId().companyId = companyId;
    }

    public String getCoverageMasterId() {
        return getId().coverageMasterId;
    }

    public void setCoverageMasterId(String coverageMasterId) {
        getId().coverageMasterId = coverageMasterId;
    }

    public String getOptId() {
        return getId().optId;
    }

    public void setOptId(String optId) {
        getId().optId = optId;
    }

    private void loadCommonDefaults() {
        this.oseYn = CommonConfig.FLAG_NO;
        this.setOptId("1");
    }

    public void loadDefaults() {
        loadCommonDefaults();
        this.recordType = CommonConfig.RECORD_TYPE_N;
    }

    public void loadFromCertificateRisk(RiskMain certificateRisk) {
        this.setUlmSgsId(certificateRisk.getUlmSgsId());
        this.setAmendmentVersionNumber(certificateRisk.getAmendmentVersionNumber());
        this.setRiskId(certificateRisk.getId());
        this.setCompanyId(certificateRisk.companyId);

        this.amendmentFromDate = certificateRisk.getAmendmentFromDate();
        this.amendmentToDate = certificateRisk.getAmendmentToDate();
        this.fromDate = certificateRisk.fromDate;
        this.toDate = certificateRisk.toDate;
        this.ulrType = certificateRisk.riskType;
    }

    public void loadFromMasterCoverage(CoverageSmiHistory masterCoverageSmi) {
        this.setMasterId(masterCoverageSmi.getMasterId());
        this.setCoverageMasterId(masterCoverageSmi.getCoverageMasterId());

        this.si = masterCoverageSmi.si;
        this.premium = masterCoverageSmi.premium;
        this.annualPremium = masterCoverageSmi.annualPremium;
        this.uePremium = masterCoverageSmi.uePremium;
        this.prPremium = masterCoverageSmi.prPremium;
        this.accountFlag = masterCoverageSmi.accountFlag;
        this.ratePer = masterCoverageSmi.ratePer;
        this.modRate = masterCoverageSmi.modRate;
        this.rate = masterCoverageSmi.rate;
        this.transactionPremium = masterCoverageSmi.transactionPremium;
        this.singleLimit = masterCoverageSmi.singleLimit;
        this.siBc = masterCoverageSmi.siBc;
        this.singleLimitBc = masterCoverageSmi.singleLimitBc;
        this.premiumBc = masterCoverageSmi.premiumBc;
        this.annualPremiumBc = masterCoverageSmi.annualPremiumBc;
        this.uePremiumBc = masterCoverageSmi.uePremiumBc;
        this.prPremiumBc = masterCoverageSmi.prPremiumBc;
        this.transactionPremiumBc = masterCoverageSmi.transactionPremiumBc;
        this.curId = masterCoverageSmi.curId;
        this.curXRate = masterCoverageSmi.curXRate;
        this.siRate = masterCoverageSmi.siRate;
    }
}

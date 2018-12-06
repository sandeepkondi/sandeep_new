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
@Table(name = "UPDS_LEVEL_C")
@EntityListeners(AuditingEntityListener.class)
public class CoverageMain extends CoverageBase {

    @Embeddable
    private static class CoverageMainId implements Serializable {
        private static final long serialVersionUID = 1L;

        // @formatter:off
        @Column(name = "ULC_ULM_SGS_ID")  private Long ulmSgsId;
        @Column(name = "ULC_ULR_ID")      private String riskId;
        @Column(name = "ULC_MST_ID")      private String masterId;
        @Column(name = "ULC_OPT_ID")      protected String optId;
        @Column(name = "ULC_COMP_ID")     private String companyId;
        // @formatter:on
    }

    @EmbeddedId protected CoverageMainId id;

    @Column(name = "ULC_AMND_VER_NO") private Long amendmentVersionNumber;

    private CoverageMainId getId() {
        if (id != null) { return id; }
        id = new CoverageMainId();
        return id;
    }

    public String getMasterId() {
        return getId().masterId;
    }

    public void setMasterId(String masterId) {
        this.getId().masterId = masterId;
    }

    public Long getUlmSgsId() {
        return getId().ulmSgsId;
    }

    public void setUlmSgsId(Long ulmSgsId) {
        this.getId().ulmSgsId = ulmSgsId;
    }

    public String getRiskId() {
        return getId().riskId;
    }

    public void setRiskId(String riskId) {
        this.getId().riskId = riskId;
    }

    public String getCompanyId() {
        return getId().companyId;
    }

    public void setCompanyId(String companyId) {
        this.getId().companyId = companyId;
    }

    public String getOptId() {
        return getId().optId;
    }

    public void setOptId(String optId) {
        getId().optId = optId;
    }

    public Long getAmendmentVersionNumber() {
        return amendmentVersionNumber;
    }

    public void setAmendmentVersionNumber(Long amendmentVersionNumber) {
        this.amendmentVersionNumber = amendmentVersionNumber;
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
        this.setRiskId(certificateRisk.getId());
        this.setUlmSgsId(certificateRisk.getUlmSgsId());
        this.setAmendmentVersionNumber(certificateRisk.getAmendmentVersionNumber());
        this.setCompanyId(certificateRisk.getCompanyId());

        this.fromDate = certificateRisk.getFromDate();
        this.toDate = certificateRisk.getToDate();
        this.amendmentFromDate = certificateRisk.getAmendmentFromDate();
        this.amendmentToDate = certificateRisk.getAmendmentToDate();
    }

    public void loadFromMasterCoverage(CoverageHistory masterCoverage) {
        this.setMasterId(masterCoverage.getMasterId());
        this.siLimit = masterCoverage.siLimit;
        this.siLimitBc = masterCoverage.siLimitBc;
        this.singleLimit = masterCoverage.singleLimit;
        this.singleLimitBc = masterCoverage.singleLimitBc;
        this.masterName = masterCoverage.masterName;
        this.masterNameBl = masterCoverage.masterNameBl;
    }
}

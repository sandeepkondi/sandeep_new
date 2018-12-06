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
@Table(name = "UHDS_LEVEL_C")
@EntityListeners(AuditingEntityListener.class)
public class CoverageHistory extends CoverageBase {

    @Embeddable
    private static class CoverageHistoryId implements Serializable {
        private static final long serialVersionUID = 1L;

        // @formatter:off
        @Column(name = "ULC_ULM_SGS_ID")  private Long ulmSgsId;
        @Column(name = "ULC_AMND_VER_NO") private Long amendmentVersionNumber;
        @Column(name = "ULC_ULR_ID")      private String riskId;
        @Column(name = "ULC_MST_ID")      private String masterId;
        @Column(name = "ULC_OPT_ID")      protected String optId;
        @Column(name = "ULC_COMP_ID")     private String companyId;
        // @formatter:on
    }

    @EmbeddedId protected CoverageHistoryId id;

    private CoverageHistoryId getId() {
        if (id != null) { return id; }
        id = new CoverageHistoryId();
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

    public Long getAmendmentVersionNumber() {
        return getId().amendmentVersionNumber;
    }

    public void setAmendmentVersionNumber(Long amendmentVersionNumber) {
        getId().amendmentVersionNumber = amendmentVersionNumber;
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

    public void loadDefaults() {
        this.recordType = CommonConfig.RECORD_TYPE_I;
    }
}

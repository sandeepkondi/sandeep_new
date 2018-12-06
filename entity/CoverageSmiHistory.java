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
@Table(name = "UHDS_LEVEL_CS")
@EntityListeners(AuditingEntityListener.class)
public class CoverageSmiHistory extends CoverageSmiBase {

    @Embeddable
    private static class CoverageSmiHistoryId implements Serializable {
        private static final long serialVersionUID = 1L;

        // @formatter:off
        @Column(name = "ULCS_ULM_SGS_ID")          protected Long ulmSgsId;
        @Column(name = "ULCS_AMND_VER_NO")         protected Long amendmentVersionNumber;
        @Column(name = "ULCS_ULR_ID")              protected String riskId;
        @Column(name = "ULCS_ULS_MST_ID")          protected String masterId;
        @Column(name = "ULCS_ULC_MST_ID")          protected String coverageMasterId;
        @Column(name = "ULCS_ULC_OPT_ID")          protected String optId;
        @Column(name = "ULCS_COMP_ID")             protected String companyId;
        // @formatter:on
    }

    @EmbeddedId private CoverageSmiHistoryId id;

    private CoverageSmiHistoryId getId() {
        if (id != null) { return id; }
        id = new CoverageSmiHistoryId();
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
        return getId().amendmentVersionNumber;
    }

    public void setAmendmentVersionNumber(Long amendmentVersionNumber) {
        getId().amendmentVersionNumber = amendmentVersionNumber;
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

    public void loadDefaults() {
        this.recordType = CommonConfig.RECORD_TYPE_I;
    }
}

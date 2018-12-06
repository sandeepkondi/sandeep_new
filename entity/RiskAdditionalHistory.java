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
@Table(name = "UHDS_LEVEL_RMBR")
@EntityListeners(AuditingEntityListener.class)
public class RiskAdditionalHistory extends RiskAdditionalBase {

    @Embeddable
    public static class RiskAdditionalHistoryId implements Serializable {
        private static final long serialVersionUID = 1L;

        @Column(name = "ULRMB_ULM_SGS_ID") private Long ulmSgsId;
        @Column(name = "ULRMB_AMND_VER_NO") private Long amendmentVersionNumber;

        public Long getUlmSgsId() {
            return ulmSgsId;
        }

        public void setUlmSgsId(Long ulmSgsId) {
            this.ulmSgsId = ulmSgsId;
        }

        public Long getAmendmentVersionNumber() {
            return amendmentVersionNumber;
        }

        public void setAmendmentVersionNumber(Long amendmentVersionNumber) {
            this.amendmentVersionNumber = amendmentVersionNumber;
        }
    }

    @EmbeddedId private RiskAdditionalHistoryId policyForeignId;

    private RiskAdditionalHistoryId getPolicyForeignId() {
        if (policyForeignId != null) { return policyForeignId; }
        policyForeignId = new RiskAdditionalHistoryId();
        return policyForeignId;
    }

    public Long getUlmSgsId() {
        return getPolicyForeignId().getUlmSgsId();
    }

    public void setUlmSgsId(Long ulmSgsId) {
        getPolicyForeignId().setUlmSgsId(ulmSgsId);
    }

    public Long getAmendmentVersionNumber() {
        return getPolicyForeignId().getAmendmentVersionNumber();
    }

    public void setAmendmentVersionNumber(Long amendmentVersionNumber) {
        getPolicyForeignId().setAmendmentVersionNumber(amendmentVersionNumber);
    }

    public void loadDefaults() {
        this.recordType = CommonConfig.RECORD_TYPE_I;
    }

    public void loadFromRiskAdditionalMain(RiskAdditionalMain riskAdditionalMain) {
        this.setSalary(riskAdditionalMain.getSalary());
        this.setSalaryBc(riskAdditionalMain.getSalaryBc());
    }
}

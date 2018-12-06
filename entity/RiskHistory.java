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
@Table(name = "UHDS_LEVEL_R")
@EntityListeners(AuditingEntityListener.class)
public class RiskHistory extends RiskBase {

    @Embeddable
    private static class RiskHistoryId implements Serializable {
        private static final long serialVersionUID = 1L;

        @Column(name = "ULR_ULM_SGS_ID")  private Long ulmSgsId;
        @Column(name = "ULR_AMND_VER_NO") private Long amendmentVersionNumber;

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

    @EmbeddedId private RiskHistoryId policyForeignId;

    private RiskHistoryId getPolicyForeignId() {
        if (policyForeignId != null) { return policyForeignId; }
        policyForeignId = new RiskHistoryId();
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
}

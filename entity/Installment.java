package com.beyontec.mol.entity;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.beyontec.mol.config.CommonConfig;

@Entity
@Table(name = "UPDS_LEVEL_I")
@EntityListeners(AuditingEntityListener.class)
public class Installment extends InstallmentBase {

    private void loadCommonDefaults() {
        this.installmentNumber = 1L;
    }

    public void loadDefaults() {
        loadCommonDefaults();
        this.recordType = CommonConfig.RECORD_TYPE_N;
    }

    public void loadFromCertificatePolicy(PolicyMain certificatePolicy) {
        this.setUlmSgsId(certificatePolicy.getSgsId());
        this.setAmendmentVersionNumber(certificatePolicy.getAmendmentVersionNumber());
        this.setUlmAmendmentNumber(certificatePolicy.getAmendmentNumber());
        this.setInstallmentId(certificatePolicy.getUiInstId());
        this.setAccountCustId(certificatePolicy.getCustomerAccountId());
        this.setCompanyId(certificatePolicy.getCompanyId());

        this.billDate = certificatePolicy.getFromDate();
        this.curId = certificatePolicy.getPrmCurrId();
        this.curXRate = certificatePolicy.getPrmCurrXRate();
    }
}

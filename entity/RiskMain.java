package com.beyontec.mol.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.beyontec.mol.config.CommonConfig;
import com.beyontec.mol.config.UdsIdDefConfig;

@Entity
@Table(name = "UPDS_LEVEL_R")
@EntityListeners(AuditingEntityListener.class)
public class RiskMain extends RiskBase {
    private static final String DEFAULT_ID = "1";

    @Id @Column(name = "ULR_ULM_SGS_ID") private Long ulmSgsId;

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

    private void loadCommonDefaults() {
        this.id = DEFAULT_ID;
        this.additionalEntityYn = CommonConfig.FLAG_NO;
        this.oseYn = CommonConfig.FLAG_NO;
        this.oseAmendmentVersionNumber = CommonConfig.DEFAULT_VERSION_NUMBER;
    }

    public void loadDefaults() {
        loadCommonDefaults();
        this.recordType = CommonConfig.RECORD_TYPE_N;
    }

    public void loadFromCertificateDetails(CertificateDetails certificateDetails) {
        this.riskType = UdsIdDefConfig.getRiskType(certificateDetails.getEmployeeCategory());

        this.flex01 = certificateDetails.getWorkerNameEn();
        this.flex01Desc = certificateDetails.getWorkerNameEn();

        this.flex02 = certificateDetails.getEmiratesId();
        this.flex02Desc = certificateDetails.getEmiratesId();

        this.flex03 = certificateDetails.getEmployeeCategory();
        this.flex03Desc = certificateDetails.getEmployeeCategory();
    }

    public void loadFromPolicyMain(PolicyMain policyMain) {
        this.fromDate = policyMain.getFromDate();
        this.toDate = policyMain.getToDate();
        this.ulmSgsId = policyMain.getSgsId();
        this.amendmentVersionNumber = policyMain.getAmendmentVersionNumber();
        this.amendmentFromDate = policyMain.getAmendmentFromDate();
        this.amendmentToDate = policyMain.getAmendmentToDate();
        this.companyId = policyMain.getCompanyId();
    }

    public void loadFromMasterRisk(RiskHistory masterRisk) {
        this.curId = masterRisk.getCurId();
        this.curXRate = masterRisk.getCurXRate();
    }
}

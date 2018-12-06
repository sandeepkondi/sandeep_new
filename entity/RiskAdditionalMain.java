package com.beyontec.mol.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.beyontec.mol.config.CommonConfig;
import com.beyontec.mol.util.DateUtil;

@Entity
@Table(name = "UPDS_LEVEL_RMBR")
@EntityListeners(AuditingEntityListener.class)
public class RiskAdditionalMain extends RiskAdditionalBase {

    @Id @Column(name = "ULRMB_ULM_SGS_ID") private Long ulmSgsId;

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

    private void loadCommonDefaults() {
        this.oseYn = CommonConfig.FLAG_NO;
    }

    public void loadDefaults() {
        loadCommonDefaults();
        this.recordType = CommonConfig.RECORD_TYPE_N;
    }

    public void loadFromRiskMain(RiskMain riskMain) {
        this.ulmSgsId = riskMain.getUlmSgsId();
        this.ulrId = riskMain.getId();
        this.id = riskMain.getId();
        this.amendmentVersionNumber = riskMain.getAmendmentVersionNumber();
        this.end = riskMain.getFromDate();
        this.exd = riskMain.getToDate();
        this.companyId = riskMain.companyId;
    }

    public void loadFromCertificateDetails(CertificateDetails certificateDetails) {
        this.name = certificateDetails.getWorkerNameEn();
        this.nameBl = certificateDetails.getWorkerNameAr();
        this.dateOfBirth = certificateDetails.getDateOfBirth();
        this.category = certificateDetails.getEmployeeCategory();
        this.designation = certificateDetails.getMohreJobId();
        this.nationality = certificateDetails.getNationality();
        this.setSalary(certificateDetails.getSalary());
        this.setSalaryBc(certificateDetails.getSalary());
        this.age = (long) DateUtil.getAge(certificateDetails.getDateOfBirth());
        this.maritalStatus = certificateDetails.getMaritalStatus();
        this.gender = certificateDetails.getGender();
        this.cardId = certificateDetails.getLabourReferenceNo();
        this.licenseRefNumber = certificateDetails.getLabourReferenceNo();
        this.passportType = certificateDetails.getPassportType();
        this.passport = certificateDetails.getPassportNo();
        this.nationality = certificateDetails.getNationality();
        this.emirateId = certificateDetails.getEmiratesId();
        this.countryOfBirth = certificateDetails.getCountryOfBirth();
        this.fileNumber = certificateDetails.getFileNo();
        this.designation1 = certificateDetails.getEnscoJobId();
    }

    public void loadFromCertificatePolicy(PolicyMain certificatePolicy) {
        this.sponserId = certificatePolicy.getInsuredId();
    }
}

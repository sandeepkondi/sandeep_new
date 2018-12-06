package com.beyontec.mol.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CTDS_LEVEL_R")
public class ClaimTransactionRisk {

    @Id
    @Column(name = "CLR_CLF_SGS_ID")
    private Long fnolSgsId;

    @Column(name = "CLR_RISK_ID")
    private String riskId;

    @Column(name = "CLR_RISK_TYP")
    private String riskType;

    @Column(name = "CLR_ULM_NO")
    private String policyNo;

    @Column(name = "CLR_RISK_COB")
    private String riskCOB;

    @Column(name = "CLR_RISK_FMD")
    private Date riskEffectiveFrom;

    @Column(name = "CLR_RISK_TOD")
    private Date riskEffectiveTo;

    @Column(name = "CLR_RISK_AMND_IDX")
    private int CLR_RISK_AMND_IDX;

    @Column(name = "CLR_RISK_FLEX1")
    private String employeeName;

    @Column(name = "CLR_RISK_FLEX2")
    private String workPermitNo;

    @Column(name = "CLR_RISK_FLEX3")
    private String Name;

    @Column(name = "CLR_RISK_FLEX4")
    private String DOB;

    @Column(name = "CLR_RISK_FLEX5")
    private String Gender;

    @Column(name = "CLR_RISK_FLEX6")
    private String PassportNo;

    @Column(name = "CLR_RISK_FLEX7")
    private String emiratesId;

    @Column(name = "CLR_RISK_FLEX8")
    private String employeeDesignation;

    private String CLR_RISK_FLEX9;
    private String CLR_RISK_FLEX10;

    private String CLR_TOT_LOSS_YN;
    private String CLR_TOT_LOSS_REMARKS;
    private int CLR_RISK_CUR_X_RATE;

    @Column(name = "CLR_RISK_CUR_ID")
    private String RiskCurrency;

    @Column(name = "CLR_RISK_FLEXDESC1")
    private String emiratesIdDesc;

    @Column(name = "CLR_RISK_FLEXDESC2")
    private String workPermitNoDesc;

    @Column(name = "CLR_RISK_FLEXDESC3")
    private String NameDesc;

    @Column(name = "CLR_RISK_FLEXDESC4")
    private String DOBDesc;

    @Column(name = "CLR_RISK_FLEXDESC5")
    private String genderDesc;

    @Column(name = "CLR_RISK_FLEXDESC6")
    private String passportNoDesc;

    @Column(name = "CLR_RISK_FLEXDESC7")
    private String employeeCategoryDesc;

    @Column(name = "CLR_RISK_FLEXDESC8")
    private String employeeDesignationDesc;
    private String CLR_RISK_FLEXDESC9;
    private String CLR_RISK_FLEXDESC10;
    private String CLR_SRC_TYP;
    private String CLR_CONFIRM_YN;
    private String CLR_VALID_YN;

    @Column(name = "CLR_COMP_ID")
    private String CompanyId;

    public Long getFnolSgsId() {
        return fnolSgsId;
    }

    public void setFnolSgsId(Long fnolSgsId) {
        this.fnolSgsId = fnolSgsId;
    }

    public String getRiskId() {
        return riskId;
    }

    public void setRiskId(String riskId) {
        this.riskId = riskId;
    }

    public String getRiskType() {
        return riskType;
    }

    public void setRiskType(String riskType) {
        this.riskType = riskType;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getRiskCOB() {
        return riskCOB;
    }

    public void setRiskCOB(String riskCOB) {
        this.riskCOB = riskCOB;
    }

    public Date getRiskEffectiveFrom() {
        return riskEffectiveFrom;
    }

    public void setRiskEffectiveFrom(Date riskEffectiveFrom) {
        this.riskEffectiveFrom = riskEffectiveFrom;
    }

    public Date getRiskEffectiveTo() {
        return riskEffectiveTo;
    }

    public void setRiskEffectiveTo(Date riskEffectiveTo) {
        this.riskEffectiveTo = riskEffectiveTo;
    }

    public int getCLR_RISK_AMND_IDX() {
        return CLR_RISK_AMND_IDX;
    }

    public void setCLR_RISK_AMND_IDX(int cLR_RISK_AMND_IDX) {
        CLR_RISK_AMND_IDX = cLR_RISK_AMND_IDX;
    }

    public String getEmiratesId() {
        return emiratesId;
    }

    public void setEmiratesId(String emiratesId) {
        this.emiratesId = emiratesId;
    }

    public String getWorkPermitNo() {
        return workPermitNo;
    }

    public void setWorkPermitNo(String workPermitNo) {
        this.workPermitNo = workPermitNo;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String dOB) {
        DOB = dOB;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getPassportNo() {
        return PassportNo;
    }

    public void setPassportNo(String passportNo) {
        PassportNo = passportNo;
    }

    public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeDesignation() {
        return employeeDesignation;
    }

    public void setEmployeeDesignation(String employeeDesignation) {
        this.employeeDesignation = employeeDesignation;
    }

    public String getCLR_RISK_FLEX9() {
        return CLR_RISK_FLEX9;
    }

    public void setCLR_RISK_FLEX9(String cLR_RISK_FLEX9) {
        CLR_RISK_FLEX9 = cLR_RISK_FLEX9;
    }

    public String getCLR_RISK_FLEX10() {
        return CLR_RISK_FLEX10;
    }

    public void setCLR_RISK_FLEX10(String cLR_RISK_FLEX10) {
        CLR_RISK_FLEX10 = cLR_RISK_FLEX10;
    }

    public String getCLR_TOT_LOSS_YN() {
        return CLR_TOT_LOSS_YN;
    }

    public void setCLR_TOT_LOSS_YN(String cLR_TOT_LOSS_YN) {
        CLR_TOT_LOSS_YN = cLR_TOT_LOSS_YN;
    }

    public String getCLR_TOT_LOSS_REMARKS() {
        return CLR_TOT_LOSS_REMARKS;
    }

    public void setCLR_TOT_LOSS_REMARKS(String cLR_TOT_LOSS_REMARKS) {
        CLR_TOT_LOSS_REMARKS = cLR_TOT_LOSS_REMARKS;
    }

    public int getCLR_RISK_CUR_X_RATE() {
        return CLR_RISK_CUR_X_RATE;
    }

    public void setCLR_RISK_CUR_X_RATE(int cLR_RISK_CUR_X_RATE) {
        CLR_RISK_CUR_X_RATE = cLR_RISK_CUR_X_RATE;
    }

    public String getRiskCurrency() {
        return RiskCurrency;
    }

    public void setRiskCurrency(String riskCurrency) {
        RiskCurrency = riskCurrency;
    }

    public String getEmiratesIdDesc() {
        return emiratesIdDesc;
    }

    public void setEmiratesIdDesc(String emiratesIdDesc) {
        this.emiratesIdDesc = emiratesIdDesc;
    }

    public String getWorkPermitNoDesc() {
        return workPermitNoDesc;
    }

    public void setWorkPermitNoDesc(String workPermitNoDesc) {
        this.workPermitNoDesc = workPermitNoDesc;
    }

    public String getNameDesc() {
        return NameDesc;
    }

    public void setNameDesc(String nameDesc) {
        NameDesc = nameDesc;
    }

    public String getDOBDesc() {
        return DOBDesc;
    }

    public void setDOBDesc(String dOBDesc) {
        DOBDesc = dOBDesc;
    }

    public String getGenderDesc() {
        return genderDesc;
    }

    public void setGenderDesc(String genderDesc) {
        this.genderDesc = genderDesc;
    }

    public String getPassportNoDesc() {
        return passportNoDesc;
    }

    public void setPassportNoDesc(String passportNoDesc) {
        this.passportNoDesc = passportNoDesc;
    }

    public String getEmployeeCategoryDesc() {
        return employeeCategoryDesc;
    }

    public void setEmployeeCategoryDesc(String employeeCategoryDesc) {
        this.employeeCategoryDesc = employeeCategoryDesc;
    }

    public String getEmployeeDesignationDesc() {
        return employeeDesignationDesc;
    }

    public void setEmployeeDesignationDesc(String employeeDesignationDesc) {
        this.employeeDesignationDesc = employeeDesignationDesc;
    }

    public String getCLR_RISK_FLEXDESC9() {
        return CLR_RISK_FLEXDESC9;
    }

    public void setCLR_RISK_FLEXDESC9(String cLR_RISK_FLEXDESC9) {
        CLR_RISK_FLEXDESC9 = cLR_RISK_FLEXDESC9;
    }

    public String getCLR_RISK_FLEXDESC10() {
        return CLR_RISK_FLEXDESC10;
    }

    public void setCLR_RISK_FLEXDESC10(String cLR_RISK_FLEXDESC10) {
        CLR_RISK_FLEXDESC10 = cLR_RISK_FLEXDESC10;
    }

    public String getCLR_SRC_TYP() {
        return CLR_SRC_TYP;
    }

    public void setCLR_SRC_TYP(String cLR_SRC_TYP) {
        CLR_SRC_TYP = cLR_SRC_TYP;
    }

    public String getCLR_CONFIRM_YN() {
        return CLR_CONFIRM_YN;
    }

    public void setCLR_CONFIRM_YN(String cLR_CONFIRM_YN) {
        CLR_CONFIRM_YN = cLR_CONFIRM_YN;
    }

    public String getCLR_VALID_YN() {
        return CLR_VALID_YN;
    }

    public void setCLR_VALID_YN(String cLR_VALID_YN) {
        CLR_VALID_YN = cLR_VALID_YN;
    }

    public String getCompanyId() {
        return CompanyId;
    }

    public void setCompanyId(String companyId) {
        CompanyId = companyId;
    }

}

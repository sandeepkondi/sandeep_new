package com.beyontec.mol.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang3.StringUtils;

import com.beyontec.mol.util.CryptoUtil;

@Inheritance
@MappedSuperclass
public class RiskAdditionalBase {
    // @formatter:off
    @Column(name = "ULRMB_ULR_ID")              protected String ulrId;
    @Column(name = "ULRMB_PIN_CODE")            protected String pinCode;
    @Column(name = "ULRMB_ADDRESS_1")           protected String address1;
    @Column(name = "ULRMB_ADDRESS_2")           protected String address2;
    @Column(name = "ULRMB_ADDRESS_3")           protected String address3;
    @Column(name = "ULRMB_ADDRESS_4")           protected String address4;
    @Column(name = "ULRMB_CITY")                protected String city;
    @Column(name = "ULRMB_STATE")               protected String state;
    @Column(name = "ULRMB_COUNTRY")             protected String country;
    @Column(name = "ULRMB_ID")                  protected String id;
    @Column(name = "ULRMB_FIRST_NAME")          protected String firstName;
    @Column(name = "ULRMB_MIDDL_NAME")          protected String middleName;
    @Column(name = "ULRMB_LAST_NAME")           protected String lastName;
    @Column(name = "ULRMB_NAME")                protected String name;
    @Column(name = "ULRMB_DOB")                 protected Date dateOfBirth;
    @Column(name = "ULRMB_REGN_DT")             protected Date regnDate;
    @Column(name = "ULRMB_OCC")                 protected String occupation;
    @Column(name = "ULRMB_CATG")                protected String category;
    @Column(name = "ULRMB_GROUP")               protected String group;
    @Column(name = "ULRMB_ID_1")                protected String id1;
    @Column(name = "ULRMB_ID_2")                protected String id2;
    @Column(name = "ULRMB_NO_OF_DPNDS")         protected Long numberOfDependents;
    @Column(name = "ULRMB_DESIG")               protected String designation;
    @Column(name = "ULRMB_NATIONALITY")         protected String nationality;
    @Column(name = "ULRMB_RELN")                protected String relation;
    @Column(name = "ULRMB_PY_CARE_UNIT")        protected String pyCareUnit;
    @Column(name = "ULRMB_PARTICP_ID")          protected String participantId;
    @Column(name = "ULRMB_SERVICE_ID")          protected String serviceId;
    @Column(name = "ULRMB_CVR_TYP_ID")          protected String cvrTypeId;
    @Column(name = "ULRMB_END")                 protected Date end;
    @Column(name = "ULRMB_EXD")                 protected Date exd;
    @Column(name = "ULRMB_OSE_AMND_VER_NO")     protected Long oseAmendmentVersionNumber;
    @Column(name = "ULRMB_OSE_YN")              protected String oseYn;
    @Column(name = "ULRMB_OSE_ORD_NO")          protected Long oseOrderNumber;
    @Column(name = "ULRMB_OSE_REF_SGS_ID")      protected Long oseRefSgsId;
    @Column(name = "ULRMB_REC_TYP")             protected String recordType;
    @Column(name = "ULRMB_EMP_ID")              protected String empId;
    @Column(name = "ULRMB_AS")                  protected Long as;
    @Column(name = "ULRMB_SALARY")              protected String salary;
    @Column(name = "ULRMB_MED_STATUS")          protected String medicalStatus;
    @Column(name = "ULRMB_PRMB_ID")             protected String prmbId;
    @Column(name = "ULRMB_SI_BC")               protected Long siBc;
    @Column(name = "ULRMB_SI")                  protected Long si;
    @Column(name = "ULRMB_SALARY_BC")           protected String salaryBc;
    @Column(name = "ULRMB_DESIG_NAME")          protected String designationName;
    @Column(name = "ULRMB_CLASS_ID")            protected String classId;
    @Column(name = "ULRMB_AGE")                 protected Long age;
    @Column(name = "ULRMB_REC_STATUS")          protected String recordStatus;
    @Column(name = "ULRMB_MAR_STATUS")          protected String maritalStatus;
    @Column(name = "ULRMB_ORG_SALARY")          protected Long orgSalary;
    @Column(name = "ULRMB_ORG_SALARY_BC")       protected Long orgSalaryBc;
    @Column(name = "ULRMB_ORG_SI")              protected Long orgSi;
    @Column(name = "ULRMB_ORG_SI_BC")           protected Long orgSiBc;
    @Column(name = "ULRMB_MEM_COUNT")           protected Long memCount;
    @Column(name = "ULRMB_EMP_TYP")             protected String empType;
    @Column(name = "ULRMB_DEPARTMENT")          protected String department;
    @Column(name = "ULRMB_LOCATION")            protected String location;
    @Column(name = "ULRMB_EST_MON_WAGES")       protected Long estimatedMonthlyWages;
    @Column(name = "ULRMB_GENDER")              protected String gender;
    @Column(name = "ULRMB_CARD_ID")             protected String cardId;
    @Column(name = "ULRMB_PASSPORT")            protected String passport;
    @Column(name = "ULRMB_NATIONAL_ID")         protected String nationalityId;
    @Column(name = "ULRMB_IQAMANO")             protected String iqamaNumber;
    @Column(name = "ULRMB_SPONSER_ID")          protected String sponserId;
    @Column(name = "ULRMB_BILL_MODE")           protected String billMode;
    @Column(name = "ULRMB_VIP")                 protected String vip;
    @Column(name = "ULRMB_STATUS")              protected String status;
    @Column(name = "ULRMB_MEM_NAME")            protected String memName;
    @Column(name = "ULRMB_CVR_DT")              protected Date cvrDate;
    @Column(name = "ULRMB_MEM_ID")              protected String memId;
    @Column(name = "ULRMB_AGE_FROM")            protected Long ageFrom;
    @Column(name = "ULRMB_AGE_TO")              protected Long ageTo;
    @Column(name = "ULRMB_DEF_CATG")            protected String defCategory;
    @Column(name = "ULRMB_EMP_NOTE")            protected String empNote;
    @Column(name = "ULRMB_COMP_ID")             protected String companyId;
    @Column(name = "ULRMB_COB")                 protected String countryOfBirth;
    @Column(name = "ULRMB_EMIRATE_VISA_ISSUED") protected String emirateVisaIssued;
    @Column(name = "ULRMB_EMIRATES_ID")         protected String emirateId;
    @Column(name = "ULRMB_LOAD_ABOVE_FCL")      protected String loadAboveFcl;
    @Column(name = "ULRMB_LOAD_GROSS_RATE")     protected String loadGrossRate;
    @Column(name = "ULRMB_LOAD_NET_RATE")       protected String loadNetRate;
    @Column(name = "ULRMB_LOAD_TOT_SI")         protected String loadTotSi;
    @Column(name = "ULRMB_LOADED_GROSS_RATE")   protected Long loadedGrossRate;
    @Column(name = "ULRMB_LOADED_NET_RATE")     protected Long loadedNetRate;
    @Column(name = "ULRMB_LOADING_TYP")         protected String loadingType;
    @Column(name = "ULRMB_NAME_BL")             protected String nameBl;
    @Column(name = "ULRMB_PP_TYP")              protected String passportType;
    @Column(name = "ULRMB_PROF_ID")             protected String profId;
    @Column(name = "ULRMB_RELIGION")            protected String religion;
    @Column(name = "ULRMB_VAA")                 protected String vaa;
    @Column(name = "ULRMB_LC_REF_NO")           protected String licenseRefNumber;
    @Column(name = "ULRMB_FILE_NO")             protected String fileNumber;
    @Column(name = "ULRMB_DESIG_1")             protected String designation1;
    // @formatter:on

    public String getUlrId() {
        return ulrId;
    }

    public void setUlrId(String ulrId) {
        this.ulrId = ulrId;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getAddress4() {
        return address4;
    }

    public void setAddress4(String address4) {
        this.address4 = address4;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getRegnDate() {
        return regnDate;
    }

    public void setRegnDate(Date regnDate) {
        this.regnDate = regnDate;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getId1() {
        return id1;
    }

    public void setId1(String id1) {
        this.id1 = id1;
    }

    public String getId2() {
        return id2;
    }

    public void setId2(String id2) {
        this.id2 = id2;
    }

    public Long getNumberOfDependents() {
        return numberOfDependents;
    }

    public void setNumberOfDependents(Long numberOfDependents) {
        this.numberOfDependents = numberOfDependents;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getPyCareUnit() {
        return pyCareUnit;
    }

    public void setPyCareUnit(String pyCareUnit) {
        this.pyCareUnit = pyCareUnit;
    }

    public String getParticipantId() {
        return participantId;
    }

    public void setParticipantId(String participantId) {
        this.participantId = participantId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getCvrTypeId() {
        return cvrTypeId;
    }

    public void setCvrTypeId(String cvrTypeId) {
        this.cvrTypeId = cvrTypeId;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Date getExd() {
        return exd;
    }

    public void setExd(Date exd) {
        this.exd = exd;
    }

    public Long getOseAmendmentVersionNumber() {
        return oseAmendmentVersionNumber;
    }

    public void setOseAmendmentVersionNumber(Long oseAmendmentVersionNumber) {
        this.oseAmendmentVersionNumber = oseAmendmentVersionNumber;
    }

    public String getOseYn() {
        return oseYn;
    }

    public void setOseYn(String oseYn) {
        this.oseYn = oseYn;
    }

    public Long getOseOrderNumber() {
        return oseOrderNumber;
    }

    public void setOseOrderNumber(Long oseOrderNumber) {
        this.oseOrderNumber = oseOrderNumber;
    }

    public Long getOseRefSgsId() {
        return oseRefSgsId;
    }

    public void setOseRefSgsId(Long oseRefSgsId) {
        this.oseRefSgsId = oseRefSgsId;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public Long getAs() {
        return as;
    }

    public void setAs(Long as) {
        this.as = as;
    }

    public String getSalary() {
        return CryptoUtil.decrypt(this.salary);
    }

    public void setSalary(String salary) {
        if (StringUtils.isBlank(salary)) { return; }
        this.salary = CryptoUtil.encrypt(salary);
    }

    public String getMedicalStatus() {
        return medicalStatus;
    }

    public void setMedicalStatus(String medicalStatus) {
        this.medicalStatus = medicalStatus;
    }

    public String getPrmbId() {
        return prmbId;
    }

    public void setPrmbId(String prmbId) {
        this.prmbId = prmbId;
    }

    public Long getSiBc() {
        return siBc;
    }

    public void setSiBc(Long siBc) {
        this.siBc = siBc;
    }

    public Long getSi() {
        return si;
    }

    public void setSi(Long si) {
        this.si = si;
    }

    public String getSalaryBc() {
        return CryptoUtil.decrypt(this.salaryBc);
    }

    public void setSalaryBc(String salaryBc) {
        if (StringUtils.isBlank(salaryBc)) { return; }
        this.salaryBc = CryptoUtil.encrypt(salaryBc);
    }

    public String getDesignationName() {
        return designationName;
    }

    public void setDesignationName(String designationName) {
        this.designationName = designationName;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Long getOrgSalary() {
        return orgSalary;
    }

    public void setOrgSalary(Long orgSalary) {
        this.orgSalary = orgSalary;
    }

    public Long getOrgSalaryBc() {
        return orgSalaryBc;
    }

    public void setOrgSalaryBc(Long orgSalaryBc) {
        this.orgSalaryBc = orgSalaryBc;
    }

    public Long getOrgSi() {
        return orgSi;
    }

    public void setOrgSi(Long orgSi) {
        this.orgSi = orgSi;
    }

    public Long getOrgSiBc() {
        return orgSiBc;
    }

    public void setOrgSiBc(Long orgSiBc) {
        this.orgSiBc = orgSiBc;
    }

    public Long getMemCount() {
        return memCount;
    }

    public void setMemCount(Long memCount) {
        this.memCount = memCount;
    }

    public String getEmpType() {
        return empType;
    }

    public void setEmpType(String empType) {
        this.empType = empType;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getEstimatedMonthlyWages() {
        return estimatedMonthlyWages;
    }

    public void setEstimatedMonthlyWages(Long estimatedMonthlyWages) {
        this.estimatedMonthlyWages = estimatedMonthlyWages;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getNationalityId() {
        return nationalityId;
    }

    public void setNationalityId(String nationalityId) {
        this.nationalityId = nationalityId;
    }

    public String getIqamaNumber() {
        return iqamaNumber;
    }

    public void setIqamaNumber(String iqamaNumber) {
        this.iqamaNumber = iqamaNumber;
    }

    public String getSponserId() {
        return sponserId;
    }

    public void setSponserId(String sponserId) {
        this.sponserId = sponserId;
    }

    public String getBillMode() {
        return billMode;
    }

    public void setBillMode(String billMode) {
        this.billMode = billMode;
    }

    public String getVip() {
        return vip;
    }

    public void setVip(String vip) {
        this.vip = vip;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMemName() {
        return memName;
    }

    public void setMemName(String memName) {
        this.memName = memName;
    }

    public Date getCvrDate() {
        return cvrDate;
    }

    public void setCvrDate(Date cvrDate) {
        this.cvrDate = cvrDate;
    }

    public String getMemId() {
        return memId;
    }

    public void setMemId(String memId) {
        this.memId = memId;
    }

    public Long getAgeFrom() {
        return ageFrom;
    }

    public void setAgeFrom(Long ageFrom) {
        this.ageFrom = ageFrom;
    }

    public Long getAgeTo() {
        return ageTo;
    }

    public void setAgeTo(Long ageTo) {
        this.ageTo = ageTo;
    }

    public String getDefCategory() {
        return defCategory;
    }

    public void setDefCategory(String defCategory) {
        this.defCategory = defCategory;
    }

    public String getEmpNote() {
        return empNote;
    }

    public void setEmpNote(String empNote) {
        this.empNote = empNote;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCountryOfBirth() {
        return countryOfBirth;
    }

    public void setCountryOfBirth(String countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
    }

    public String getEmirateVisaIssued() {
        return emirateVisaIssued;
    }

    public void setEmirateVisaIssued(String emirateVisaIssued) {
        this.emirateVisaIssued = emirateVisaIssued;
    }

    public String getEmirateId() {
        return emirateId;
    }

    public void setEmirateId(String emirateId) {
        this.emirateId = emirateId;
    }

    public String getLoadAboveFcl() {
        return loadAboveFcl;
    }

    public void setLoadAboveFcl(String loadAboveFcl) {
        this.loadAboveFcl = loadAboveFcl;
    }

    public String getLoadGrossRate() {
        return loadGrossRate;
    }

    public void setLoadGrossRate(String loadGrossRate) {
        this.loadGrossRate = loadGrossRate;
    }

    public String getLoadNetRate() {
        return loadNetRate;
    }

    public void setLoadNetRate(String loadNetRate) {
        this.loadNetRate = loadNetRate;
    }

    public String getLoadTotSi() {
        return loadTotSi;
    }

    public void setLoadTotSi(String loadTotSi) {
        this.loadTotSi = loadTotSi;
    }

    public Long getLoadedGrossRate() {
        return loadedGrossRate;
    }

    public void setLoadedGrossRate(Long loadedGrossRate) {
        this.loadedGrossRate = loadedGrossRate;
    }

    public Long getLoadedNetRate() {
        return loadedNetRate;
    }

    public void setLoadedNetRate(Long loadedNetRate) {
        this.loadedNetRate = loadedNetRate;
    }

    public String getLoadingType() {
        return loadingType;
    }

    public void setLoadingType(String loadingType) {
        this.loadingType = loadingType;
    }

    public String getNameBl() {
        return nameBl;
    }

    public void setNameBl(String nameBl) {
        this.nameBl = nameBl;
    }

    public String getPassportType() {
        return passportType;
    }

    public void setPassportType(String passportType) {
        this.passportType = passportType;
    }

    public String getProfId() {
        return profId;
    }

    public void setProfId(String profId) {
        this.profId = profId;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getVaa() {
        return vaa;
    }

    public void setVaa(String vaa) {
        this.vaa = vaa;
    }

    public String getLicenseRefNumber() {
        return licenseRefNumber;
    }

    public void setLicenseRefNumber(String licenseRefNumber) {
        this.licenseRefNumber = licenseRefNumber;
    }

    public String getFileNumber() {
        return fileNumber;
    }

    public void setFileNumber(String fileNumber) {
        this.fileNumber = fileNumber;
    }

    public String getDesignation1() {
        return designation1;
    }

    public void setDesignation1(String designation1) {
        this.designation1 = designation1;
    }
}

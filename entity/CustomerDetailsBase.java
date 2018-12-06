package com.beyontec.mol.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.MappedSuperclass;

@Inheritance
@MappedSuperclass
public class CustomerDetailsBase {
    // @formatter:off
    @Column(name = "UCD_ADDRESS_1")               protected  String address1;
    @Column(name = "UCD_ADDRESS_1_BL")            protected  String address1Bl;
    @Column(name = "UCD_ADDRESS_2")               protected  String address2;
    @Column(name = "UCD_ADDRESS_2_BL")            protected  String address2Bl;
    @Column(name = "UCD_ADDRESS_3")               protected  String address3;
    @Column(name = "UCD_ADDRESS_3_BL")            protected  String address3Bl;
    @Column(name = "UCD_ADDRESS_4")               protected  String address4;
    @Column(name = "UCD_ADDRESS_4_BL")            protected  String address4Bl;
    @Column(name = "UCD_AE_ID")                   protected  String aeId;
    @Column(name = "UCD_APD")                     protected  Date approvalDate;
    @Column(name = "UCD_APPRV_STATUS")            protected  String approvalStatus;
    @Column(name = "UCD_APU")                     protected  String apu;
    @Column(name = "UCD_BAT_ID")                  protected  String batId;
    @Column(name = "UCD_BLACKLISTED_YN")          protected  String blacklistedYn;
    @Column(name = "UCD_BUS_TYP")                 protected  String busType;
    @Column(name = "UCD_CASH_YN")                 protected  String cashYn;
    @Column(name = "UCD_CITY")                    protected  String city;
    @Column(name = "UCD_CITY_BL")                 protected  String cityBl;
    @Column(name = "UCD_CLASS")                   protected  String customerClass;
    @Column(name = "UCD_CLASS_ID")                protected  String classId;
    @Column(name = "UCD_COMPANY_DBA")             protected  String companyDba;
    @Column(name = "UCD_COMP_ID")                 protected  String companyId;
    @Column(name = "UCD_COMP_NO")                 protected  String companyNumber;
    @Column(name = "UCD_COMP_TYP")                protected  String companyType;
    @Column(name = "UCD_COUNTRY_ID")              protected  String countryId;
    @Column(name = "UCD_CRD")                     protected  Date createdDate;
    @Column(name = "UCD_CREDIT_DAYS")             protected  Long creditDays;
    @Column(name = "UCD_CREDIT_LIMIT")            protected  Long creditLimit;
    @Column(name = "UCD_CRU")                     protected  String createdUser;
    @Column(name = "UCD_CUST_CATG_ID")            protected  String categoryId;
    @Column(name = "UCD_CUST_DESC")               protected  String desc;
    @Column(name = "UCD_CUST_GRP")                protected  String group;
    @Column(name = "UCD_CUST_PREF_LANG")          protected  String preferredLanguage;
    @Column(name = "UCD_CUST_REGION")             protected  String region;
    @Column(name = "UCD_CUST_TAX_ID")             protected  String taxId;
    @Column(name = "UCD_CUST_TAX_TYP")            protected  String taxType;
    @Column(name = "UCD_CUST_TYP")                protected  String type;
    @Column(name = "UCD_CUST_VAT_TYP")            protected  String vatType;
    @Column(name = "UCD_DIVN_ID")                 protected  String divnId;
    @Column(name = "UCD_DOB")                     protected  Date dateOfBirth;
    @Column(name = "UCD_EXP_IMP_REF")             protected  Long expImpRef;
    @Column(name = "UCD_FAX_NO")                  protected  String faxNumber;
    @Column(name = "UCD_FIRST_NAME")              protected  String firstName;
    @Column(name = "UCD_FIRST_NAME_BL")           protected  String firstNameBl;
    @Column(name = "UCD_FLEET_SIZE")              protected  Long fleetSize;
    @Column(name = "UCD_FMD")                     protected  Date fromDate;
    @Column(name = "UCD_GENDER")                  protected  String gender;
    @Column(name = "UCD_HOLDING_COMP_ID")         protected  String holdingCompanyId;
    @Column(name = "UCD_HOLD_SUBSI_TYP")          protected  String holdingSubsidiaryType;
    @Column(name = "UCD_IDENTIFICATION_ID1")      protected  String id1;
    @Column(name = "UCD_IDENTIFICATION_ID2")      protected  String id2;
    @Column(name = "UCD_IDENTIFICATION_ID3")      protected  String id3;
    @Column(name = "UCD_IDENTIFICATION_ID_TYP1")  protected  String idType1;
    @Column(name = "UCD_IDENTIFICATION_ID_TYP2")  protected  String idType2;
    @Column(name = "UCD_IND_TYP")                 protected  String indType;
    @Column(name = "UCD_INSRD_APPL_YN")           protected  String insuredApplYn;
    @Column(name = "UCD_KYC_REQD_YN")             protected  String kycRequiredYn;
    @Column(name = "UCD_KYC_STATUS")              protected  String kycStatus;
    @Column(name = "UCD_LAST_NAME")               protected  String lastName;
    @Column(name = "UCD_LAST_NAME_BL")            protected  String lastNameBl;
    @Column(name = "UCD_LICN_EXP_DT")             protected  Date licenseExpiryDate;
    @Column(name = "UCD_LICN_ISSUED_AT")          protected  String licenseIssuedAt;
    @Column(name = "UCD_LICN_ISS_DT")             protected  Date licenseIssuedDate;
    @Column(name = "UCD_LOGIN_ID")                protected  String loginId;
    @Column(name = "UCD_LOGIN_PWD")               protected  String loginPassword;
    @Column(name = "UCD_MARITAL_STATUS")          protected  String maritalStatus;
    @Column(name = "UCD_MIDDLE_NAME")             protected  String middleName;
    @Column(name = "UCD_MIDDLE_NAME_BL")          protected  String middleNameBl;
    @Column(name = "UCD_NAME")                    protected  String name;
    @Column(name = "UCD_NAME_BL")                 protected  String nameBl;
    @Column(name = "UCD_NATIONALITY")             protected  String nationality;
    @Column(name = "UCD_NATIONALITY_BL")          protected  String nationalityBl;
    @Column(name = "UCD_OCCUPATION")              protected  String occupation;
    @Column(name = "UCD_OCCUPATION_BL")           protected  String occupationBl;
    @Column(name = "UCD_PARTY_ID")                protected  String partyId;
    @Column(name = "UCD_PIN_CODE")                protected  String pinCode;
    @Column(name = "UCD_PREFIX_NAME")             protected  String prefixName;
    @Column(name = "UCD_PREFIX_NAME_BL")          protected  String prefixNameBl;
    @Column(name = "UCD_PY_EMAIL_ID")             protected  String pyEmailId;
    @Column(name = "UCD_PY_MOBILE_NO")            protected  String pyMobileNumber;
    @Column(name = "UCD_PY_PHONE_NO")             protected  String pyPhoneNumber;
    @Column(name = "UCD_PY_STATE")                protected  String pyState;
    @Column(name = "UCD_REC_TYP")                 protected  String recordType;
    @Column(name = "UCD_RELN_MANAGER")            protected  String relnManager;
    @Column(name = "UCD_REPORTING_SOURCE")        protected  String reportingSource;
    @Column(name = "UCD_SOURCE")                  protected  String source;
    @Column(name = "UCD_SRC_REF_ID")              protected  String sourceRefId;
    @Column(name = "UCD_STATE")                   protected  String state;
    @Column(name = "UCD_STATE_BL")                protected  String stateBl;
    @Column(name = "UCD_STATUS")                  protected  String status;
    @Column(name = "UCD_SUFIX_NAME")              protected  String sufixName;
    @Column(name = "UCD_SUFIX_NAME_BL")           protected  String sufixNameBl;
    @Column(name = "UCD_TAX_APPL_YN")             protected  String taxApplYn;
    @Column(name = "UCD_TOD")                     protected  Date toDate;
    @Column(name = "UCD_VER_NO")                  protected  Long versionNumber;
    @Column(name = "UCD_WEBSITE_URL")             protected  String websiteUrl;
    // @formatter:on

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress1Bl() {
        return address1Bl;
    }

    public void setAddress1Bl(String address1Bl) {
        this.address1Bl = address1Bl;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress2Bl() {
        return address2Bl;
    }

    public void setAddress2Bl(String address2Bl) {
        this.address2Bl = address2Bl;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getAddress3Bl() {
        return address3Bl;
    }

    public void setAddress3Bl(String address3Bl) {
        this.address3Bl = address3Bl;
    }

    public String getAddress4() {
        return address4;
    }

    public void setAddress4(String address4) {
        this.address4 = address4;
    }

    public String getAddress4Bl() {
        return address4Bl;
    }

    public void setAddress4Bl(String address4Bl) {
        this.address4Bl = address4Bl;
    }

    public String getAeId() {
        return aeId;
    }

    public void setAeId(String aeId) {
        this.aeId = aeId;
    }

    public Date getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getApu() {
        return apu;
    }

    public void setApu(String apu) {
        this.apu = apu;
    }

    public String getBatId() {
        return batId;
    }

    public void setBatId(String batId) {
        this.batId = batId;
    }

    public String getBlacklistedYn() {
        return blacklistedYn;
    }

    public void setBlacklistedYn(String blacklistedYn) {
        this.blacklistedYn = blacklistedYn;
    }

    public String getBusType() {
        return busType;
    }

    public void setBusType(String busType) {
        this.busType = busType;
    }

    public String getCashYn() {
        return cashYn;
    }

    public void setCashYn(String cashYn) {
        this.cashYn = cashYn;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityBl() {
        return cityBl;
    }

    public void setCityBl(String cityBl) {
        this.cityBl = cityBl;
    }

    public String getCustomerClass() {
        return customerClass;
    }

    public void setCustomerClass(String customerClass) {
        this.customerClass = customerClass;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getCompanyDba() {
        return companyDba;
    }

    public void setCompanyDba(String companyDba) {
        this.companyDba = companyDba;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyNumber() {
        return companyNumber;
    }

    public void setCompanyNumber(String companyNumber) {
        this.companyNumber = companyNumber;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Long getCreditDays() {
        return creditDays;
    }

    public void setCreditDays(Long creditDays) {
        this.creditDays = creditDays;
    }

    public Long getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Long creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getPreferredLanguage() {
        return preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVatType() {
        return vatType;
    }

    public void setVatType(String vatType) {
        this.vatType = vatType;
    }

    public String getDivnId() {
        return divnId;
    }

    public void setDivnId(String divnId) {
        this.divnId = divnId;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getExpImpRef() {
        return expImpRef;
    }

    public void setExpImpRef(Long expImpRef) {
        this.expImpRef = expImpRef;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstNameBl() {
        return firstNameBl;
    }

    public void setFirstNameBl(String firstNameBl) {
        this.firstNameBl = firstNameBl;
    }

    public Long getFleetSize() {
        return fleetSize;
    }

    public void setFleetSize(Long fleetSize) {
        this.fleetSize = fleetSize;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHoldingCompanyId() {
        return holdingCompanyId;
    }

    public void setHoldingCompanyId(String holdingCompanyId) {
        this.holdingCompanyId = holdingCompanyId;
    }

    public String getHoldingSubsidiaryType() {
        return holdingSubsidiaryType;
    }

    public void setHoldingSubsidiaryType(String holdingSubsidiaryType) {
        this.holdingSubsidiaryType = holdingSubsidiaryType;
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

    public String getId3() {
        return id3;
    }

    public void setId3(String id3) {
        this.id3 = id3;
    }

    public String getIdType1() {
        return idType1;
    }

    public void setIdType1(String idType1) {
        this.idType1 = idType1;
    }

    public String getIdType2() {
        return idType2;
    }

    public void setIdType2(String idType2) {
        this.idType2 = idType2;
    }

    public String getIndType() {
        return indType;
    }

    public void setIndType(String indType) {
        this.indType = indType;
    }

    public String getInsuredApplYn() {
        return insuredApplYn;
    }

    public void setInsuredApplYn(String insuredApplYn) {
        this.insuredApplYn = insuredApplYn;
    }

    public String getKycRequiredYn() {
        return kycRequiredYn;
    }

    public void setKycRequiredYn(String kycRequiredYn) {
        this.kycRequiredYn = kycRequiredYn;
    }

    public String getKycStatus() {
        return kycStatus;
    }

    public void setKycStatus(String kycStatus) {
        this.kycStatus = kycStatus;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastNameBl() {
        return lastNameBl;
    }

    public void setLastNameBl(String lastNameBl) {
        this.lastNameBl = lastNameBl;
    }

    public Date getLicenseExpiryDate() {
        return licenseExpiryDate;
    }

    public void setLicenseExpiryDate(Date licenseExpiryDate) {
        this.licenseExpiryDate = licenseExpiryDate;
    }

    public String getLicenseIssuedAt() {
        return licenseIssuedAt;
    }

    public void setLicenseIssuedAt(String licenseIssuedAt) {
        this.licenseIssuedAt = licenseIssuedAt;
    }

    public Date getLicenseIssuedDate() {
        return licenseIssuedDate;
    }

    public void setLicenseIssuedDate(Date licenseIssuedDate) {
        this.licenseIssuedDate = licenseIssuedDate;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getMiddleNameBl() {
        return middleNameBl;
    }

    public void setMiddleNameBl(String middleNameBl) {
        this.middleNameBl = middleNameBl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameBl() {
        return nameBl;
    }

    public void setNameBl(String nameBl) {
        this.nameBl = nameBl;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNationalityBl() {
        return nationalityBl;
    }

    public void setNationalityBl(String nationalityBl) {
        this.nationalityBl = nationalityBl;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getOccupationBl() {
        return occupationBl;
    }

    public void setOccupationBl(String occupationBl) {
        this.occupationBl = occupationBl;
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getPrefixName() {
        return prefixName;
    }

    public void setPrefixName(String prefixName) {
        this.prefixName = prefixName;
    }

    public String getPrefixNameBl() {
        return prefixNameBl;
    }

    public void setPrefixNameBl(String prefixNameBl) {
        this.prefixNameBl = prefixNameBl;
    }

    public String getPyEmailId() {
        return pyEmailId;
    }

    public void setPyEmailId(String pyEmailId) {
        this.pyEmailId = pyEmailId;
    }

    public String getPyMobileNumber() {
        return pyMobileNumber;
    }

    public void setPyMobileNumber(String pyMobileNumber) {
        this.pyMobileNumber = pyMobileNumber;
    }

    public String getPyPhoneNumber() {
        return pyPhoneNumber;
    }

    public void setPyPhoneNumber(String pyPhoneNumber) {
        this.pyPhoneNumber = pyPhoneNumber;
    }

    public String getPyState() {
        return pyState;
    }

    public void setPyState(String pyState) {
        this.pyState = pyState;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getRelnManager() {
        return relnManager;
    }

    public void setRelnManager(String relnManager) {
        this.relnManager = relnManager;
    }

    public String getReportingSource() {
        return reportingSource;
    }

    public void setReportingSource(String reportingSource) {
        this.reportingSource = reportingSource;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSourceRefId() {
        return sourceRefId;
    }

    public void setSourceRefId(String sourceRefId) {
        this.sourceRefId = sourceRefId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStateBl() {
        return stateBl;
    }

    public void setStateBl(String stateBl) {
        this.stateBl = stateBl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSufixName() {
        return sufixName;
    }

    public void setSufixName(String sufixName) {
        this.sufixName = sufixName;
    }

    public String getSufixNameBl() {
        return sufixNameBl;
    }

    public void setSufixNameBl(String sufixNameBl) {
        this.sufixNameBl = sufixNameBl;
    }

    public String getTaxApplYn() {
        return taxApplYn;
    }

    public void setTaxApplYn(String taxApplYn) {
        this.taxApplYn = taxApplYn;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Long getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(Long versionNumber) {
        this.versionNumber = versionNumber;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }
}

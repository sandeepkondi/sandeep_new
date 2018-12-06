package com.beyontec.mol.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UDS_COMPANY")
public class Company {

    @Id
    @Column(name = "UC_COMP_ID") private String id;

    @Column(name = "UC_COMP_NAME") private String name;

    @Column(name = "UC_COMP_NAME_1") private String name1;
    @Column(name = "UC_COMP_NAME_2") private String name2;
    @Column(name = "UC_COMP_NAME_3") private String name3;
    @Column(name = "UC_COMP_NAME_4") private String name4;

    @Column(name = "UC_COMP_DISP_NAME") private String displayName;
    @Column(name = "UC_COMP_DISP_NAME_1") private String displayName1;
    @Column(name = "UC_COMP_DISP_NAME_2") private String displayName2;
    @Column(name = "UC_COMP_DISP_NAME_3") private String displayName3;
    @Column(name = "UC_COMP_DISP_NAME_4") private String displayName4;

    @Column(name = "UC_COMP_CEO_NAME") private String ceoName;
    @Column(name = "UC_COMP_CEO_NAME_1") private String ceoName1;
    @Column(name = "UC_COMP_CEO_NAME_2") private String ceoName2;
    @Column(name = "UC_COMP_CEO_NAME_3") private String ceoName3;
    @Column(name = "UC_COMP_CEO_NAME_4") private String ceoName4;

    @Column(name = "UC_ADDRESS_1") private String address1;
    @Column(name = "UC_ADDRESS_2") private String address2;
    @Column(name = "UC_ADDRESS_3") private String address3;
    @Column(name = "UC_ADDRESS_4") private String address4;
    @Column(name = "UC_PIN_CODE") private String pinCode;
    @Column(name = "UC_CITY") private String city;
    @Column(name = "UC_STATE") private String state;
    @Column(name = "UC_COUNTRY_ID") private String countryId;

    @Column(name = "UC_PHONE_NO") private String phoneNumber;
    @Column(name = "UC_FAX_NO") private String faxNumber;
    @Column(name = "UC_EMAIL_ID") private String emailId;
    @Column(name = "UC_WEBSITE_URL") private String websiteUrl;

    @Column(name = "UC_FLEXI_01") private String flexi1;
    @Column(name = "UC_FLEXI_02") private String flexi2;
    @Column(name = "UC_FLEXI_03") private String flexi3;
    @Column(name = "UC_FLEXI_04") private String flexi4;
    @Column(name = "UC_FLEXI_05") private String flexi5;

    @Column(name = "UC_FMD") private Date fromDate;
    @Column(name = "UC_TOD") private Date toDate;
    @Column(name = "UC_REGT_DATE") private Date registeredDate;

    @Column(name = "UC_BROK_LICN_NO") private String brokerageLicenseNumber;
    @Column(name = "UC_CONSULT_LICN_NO") private String consultantLicenseNumber;
    @Column(name = "UC_TRADE_LICN_NO") private String tradeLicenseNumber;

    @Column(name = "UC_HADD_NO") private String haddNumber;
    @Column(name = "UC_APPL_URL") private String applicationUrl;

    @Column(name = "UC_VER_NO") private int versionNumber;

    @Column(name = "UC_APU") private String apu;
    @Column(name = "UC_APPRV_STATUS") private String approvalStatus;

    @Column(name = "UC_APD") private Date approvalDate;

    @Column(name = "UC_REC_TYP") private String recType;

    @Column(name = "UC_EXP_IMP_REF") private Integer expImpRef;

    @Column(name = "UC_CRD") private Date createdDate;

    @Column(name = "UC_CRU") private String createdUser;
    @Column(name = "UC_VAT_REG_ID") private String vatRegNumber;
    @Column(name = "UC_AKA_ID") private String akaId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getName3() {
        return name3;
    }

    public void setName3(String name3) {
        this.name3 = name3;
    }

    public String getName4() {
        return name4;
    }

    public void setName4(String name4) {
        this.name4 = name4;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName1() {
        return displayName1;
    }

    public void setDisplayName1(String displayName1) {
        this.displayName1 = displayName1;
    }

    public String getDisplayName2() {
        return displayName2;
    }

    public void setDisplayName2(String displayName2) {
        this.displayName2 = displayName2;
    }

    public String getDisplayName3() {
        return displayName3;
    }

    public void setDisplayName3(String displayName3) {
        this.displayName3 = displayName3;
    }

    public String getDisplayName4() {
        return displayName4;
    }

    public void setDisplayName4(String displayName4) {
        this.displayName4 = displayName4;
    }

    public String getCeoName() {
        return ceoName;
    }

    public void setCeoName(String ceoName) {
        this.ceoName = ceoName;
    }

    public String getCeoName1() {
        return ceoName1;
    }

    public void setCeoName1(String ceoName1) {
        this.ceoName1 = ceoName1;
    }

    public String getCeoName2() {
        return ceoName2;
    }

    public void setCeoName2(String ceoName2) {
        this.ceoName2 = ceoName2;
    }

    public String getCeoName3() {
        return ceoName3;
    }

    public void setCeoName3(String ceoName3) {
        this.ceoName3 = ceoName3;
    }

    public String getCeoName4() {
        return ceoName4;
    }

    public void setCeoName4(String ceoName4) {
        this.ceoName4 = ceoName4;
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

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
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

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getFlexi1() {
        return flexi1;
    }

    public void setFlexi1(String flexi1) {
        this.flexi1 = flexi1;
    }

    public String getFlexi2() {
        return flexi2;
    }

    public void setFlexi2(String flexi2) {
        this.flexi2 = flexi2;
    }

    public String getFlexi3() {
        return flexi3;
    }

    public void setFlexi3(String flexi3) {
        this.flexi3 = flexi3;
    }

    public String getFlexi4() {
        return flexi4;
    }

    public void setFlexi4(String flexi4) {
        this.flexi4 = flexi4;
    }

    public String getFlexi5() {
        return flexi5;
    }

    public void setFlexi5(String flexi5) {
        this.flexi5 = flexi5;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    public String getBrokerageLicenseNumber() {
        return brokerageLicenseNumber;
    }

    public void setBrokerageLicenseNumber(String brokerageLicenseNumber) {
        this.brokerageLicenseNumber = brokerageLicenseNumber;
    }

    public String getConsultantLicenseNumber() {
        return consultantLicenseNumber;
    }

    public void setConsultantLicenseNumber(String consultantLicenseNumber) {
        this.consultantLicenseNumber = consultantLicenseNumber;
    }

    public String getTradeLicenseNumber() {
        return tradeLicenseNumber;
    }

    public void setTradeLicenseNumber(String tradeLicenseNumber) {
        this.tradeLicenseNumber = tradeLicenseNumber;
    }

    public String getHaddNumber() {
        return haddNumber;
    }

    public void setHaddNumber(String haddNumber) {
        this.haddNumber = haddNumber;
    }

    public String getApplicationUrl() {
        return applicationUrl;
    }

    public void setApplicationUrl(String applicationUrl) {
        this.applicationUrl = applicationUrl;
    }

    public int getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(int versionNumber) {
        this.versionNumber = versionNumber;
    }

    public String getApu() {
        return apu;
    }

    public void setApu(String apu) {
        this.apu = apu;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public Date getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }

    public String getRecType() {
        return recType;
    }

    public void setRecType(String recType) {
        this.recType = recType;
    }

    public int getExpImpRef() {
        return expImpRef;
    }

    public void setExpImpRef(int expImpRef) {
        this.expImpRef = expImpRef;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public String getVatRegNumber() {
        return vatRegNumber;
    }

    public void setVatRegNumber(String vatRegNumber) {
        this.vatRegNumber = vatRegNumber;
    }

    public String getAkaId() {
        return akaId;
    }

    public void setAkaId(String akaId) {
        this.akaId = akaId;
    }
}


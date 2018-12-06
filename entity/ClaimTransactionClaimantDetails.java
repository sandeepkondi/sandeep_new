package com.beyontec.mol.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CTDS_LEVEL_CP")
public class ClaimTransactionClaimantDetails {
    @Id
    @Column(name = "CLCP_CLF_SGS_ID")
    private Long fnolSgsId;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "CLCP_CLF_SGS_ID")
    private ClaimTransactionFNOL fnol;

    @Column(name = "CLCP_FIRST_NAME")
    private String firstName;

    @Column(name = "CLCP_MIDDLE_NAME")
    private String middleName;

    @Column(name = "CLCP_LAST_NAME")
    private String lastName;

    @Column(name = "CLCP_ADDRESS1")
    private String address1;

    @Column(name = "CLCP_ADDRESS2")
    private String address2;

    @Column(name = "CLCP_ADDRESS3")
    private String address3;

    @Column(name = "CLCP_ADDRESS4")
    private String address4;

    @Column(name = "CLCP_PIN_CODE")
    private String pincode;

    @Column(name = "CLCP_CITY")
    private String city;

    @Column(name = "CLCP_STATE")
    private String state;

    @Column(name = "CLCP_COUNTRY_ID")
    private String countryId;

    @Column(name = "CLCP_PY_PHONE_NO")
    private String phoneNo;

    @Column(name = "CLCP_PY_MOBILE_NO")
    private String mobileNo;

    @Column(name = "CLCP_ID")
    private String partyId;

    @Column(name = "CLCP_TYP")
    private String partyType;

    @Column(name = "CLCP_EMAIL_ID")
    private String emailId;

    @Column(name = "CLCP_NAME")
    private String name;

    private String CLCP_PYC_REF_ID;
    private String CLCP_ALC_REF_ID;

    @Column(name = "CLCP_DFLT_LANG")
    private String language;

    private String CLCP_LCN_NO;
    private String CLCP_TIME_CONTACT;
    private String CLCP_OTH_TYP;

    @Column(name = "CLCP_REC_TYP")
    private String recordType;

    @Column(name = "CLF_REP_BY_CLMNT_YN")
    private String reportedByClaimantYN;

    @Column(name = "CLF_LEGAL_REP_YN")
    private String legalreportedYN;

    private String CLF_REF_PARTY_ID;
    private String CLCP_LANG_NAME;
    private String CLCP_ALC_ID;
    private String CLCP_ALC_REF_ID_2;
    private String CLCP_ALC_ID_2;
    private String CLCP_SSN_ID;

    @Column(name = "CLCP_DOB")
    private Date dob;

    private String CLCP_MEDCARE_YN;
    private String CLCP_INV_REQD_YN;
    private String CLCP_REASON_INV;
    private String CLCP_CMS_AFFSENT_YN;
    private Date CLCP_CMS_SENT_DT;
    private Date CLCP_CMS_RECD_DT;
    private String CLCP_CLIEN_RECD_YN;
    private Date CLCP_CLL_RECD_DT;

    @Column(name = "CLCP_GENDER")
    private String gender;
    private String CLCP_ALC_REF_DESC_2;
    private String CLCP_ALC_REF_DESC;
    private String CLCP_TYP_DESC;
    private String CLCP_PY_EXTN_NO;
    private String CLCP_AL_EXTN_NO;
    private String CLCP_AL_EXTN_NO_2;
    private String CLCP_PYC_REF_DESC;
    private String CLCP_DBA_NAME;
    private String CLCP_CON_FNAME;
    private String CLCP_CON_MNAME;
    private String CLCP_CON_LNAME;

    @Column(name = "CLCP_CRD")
    private Date createdDate;

    private Date CLCP_INVD;
    private String CLCP_CUST_TYP;
    private String CLCP_REC_STATUS;

    @Column(name = "CLCP_CRU")
    private String createdUser;

    private String CLCP_RELN;

    @Column(name = "CLCP_NATIONALITY")
    private String nationality;

    @Column(name = "CLCP_OTH_LANG")
    private String otherLanguage;

    private int CLCP_AMT;
    private String CLCP_INJ_TYP;
    private String CLCP_FLEX_01;
    private String CLCP_FLEX_02;
    private String CLCP_FLEX_03;
    private String CLCP_FLEX_04;
    private String CLCP_FLEX_05;
    private String CLCP_FLEX_01_DESC;
    private String CLCP_FLEX_02_DESC;
    private String CLCP_FLEX_03_DESC;
    private String CLCP_FLEX_04_DESC;
    private String CLCP_FLEX_05_DESC;

    public ClaimTransactionFNOL getFnol() {
        return fnol;
    }

    public void setFnol(ClaimTransactionFNOL fnol) {
        this.fnol = fnol;
    }

    @Column(name = "CLCP_NAME_PREFIX")
    private String prefixName;

    public Long getFnolSgsId() {
        return fnolSgsId;
    }

    public void setFnolSgsId(Long fnolSgsId) {
        this.fnolSgsId = fnolSgsId;
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

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
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

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public String getPartyType() {
        return partyType;
    }

    public void setPartyType(String partyType) {
        this.partyType = partyType;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCLCP_PYC_REF_ID() {
        return CLCP_PYC_REF_ID;
    }

    public void setCLCP_PYC_REF_ID(String cLCP_PYC_REF_ID) {
        CLCP_PYC_REF_ID = cLCP_PYC_REF_ID;
    }

    public String getCLCP_ALC_REF_ID() {
        return CLCP_ALC_REF_ID;
    }

    public void setCLCP_ALC_REF_ID(String cLCP_ALC_REF_ID) {
        CLCP_ALC_REF_ID = cLCP_ALC_REF_ID;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCLCP_LCN_NO() {
        return CLCP_LCN_NO;
    }

    public void setCLCP_LCN_NO(String cLCP_LCN_NO) {
        CLCP_LCN_NO = cLCP_LCN_NO;
    }

    public String getCLCP_TIME_CONTACT() {
        return CLCP_TIME_CONTACT;
    }

    public void setCLCP_TIME_CONTACT(String cLCP_TIME_CONTACT) {
        CLCP_TIME_CONTACT = cLCP_TIME_CONTACT;
    }

    public String getCLCP_OTH_TYP() {
        return CLCP_OTH_TYP;
    }

    public void setCLCP_OTH_TYP(String cLCP_OTH_TYP) {
        CLCP_OTH_TYP = cLCP_OTH_TYP;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getReportedByClaimantYN() {
        return reportedByClaimantYN;
    }

    public void setReportedByClaimantYN(String reportedByClaimantYN) {
        this.reportedByClaimantYN = reportedByClaimantYN;
    }

    public String getLegalreportedYN() {
        return legalreportedYN;
    }

    public void setLegalreportedYN(String legalreportedYN) {
        this.legalreportedYN = legalreportedYN;
    }

    public String getCLF_REF_PARTY_ID() {
        return CLF_REF_PARTY_ID;
    }

    public void setCLF_REF_PARTY_ID(String cLF_REF_PARTY_ID) {
        CLF_REF_PARTY_ID = cLF_REF_PARTY_ID;
    }

    public String getCLCP_LANG_NAME() {
        return CLCP_LANG_NAME;
    }

    public void setCLCP_LANG_NAME(String cLCP_LANG_NAME) {
        CLCP_LANG_NAME = cLCP_LANG_NAME;
    }

    public String getCLCP_ALC_ID() {
        return CLCP_ALC_ID;
    }

    public void setCLCP_ALC_ID(String cLCP_ALC_ID) {
        CLCP_ALC_ID = cLCP_ALC_ID;
    }

    public String getCLCP_ALC_REF_ID_2() {
        return CLCP_ALC_REF_ID_2;
    }

    public void setCLCP_ALC_REF_ID_2(String cLCP_ALC_REF_ID_2) {
        CLCP_ALC_REF_ID_2 = cLCP_ALC_REF_ID_2;
    }

    public String getCLCP_ALC_ID_2() {
        return CLCP_ALC_ID_2;
    }

    public void setCLCP_ALC_ID_2(String cLCP_ALC_ID_2) {
        CLCP_ALC_ID_2 = cLCP_ALC_ID_2;
    }

    public String getCLCP_SSN_ID() {
        return CLCP_SSN_ID;
    }

    public void setCLCP_SSN_ID(String cLCP_SSN_ID) {
        CLCP_SSN_ID = cLCP_SSN_ID;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getCLCP_MEDCARE_YN() {
        return CLCP_MEDCARE_YN;
    }

    public void setCLCP_MEDCARE_YN(String cLCP_MEDCARE_YN) {
        CLCP_MEDCARE_YN = cLCP_MEDCARE_YN;
    }

    public String getCLCP_INV_REQD_YN() {
        return CLCP_INV_REQD_YN;
    }

    public void setCLCP_INV_REQD_YN(String cLCP_INV_REQD_YN) {
        CLCP_INV_REQD_YN = cLCP_INV_REQD_YN;
    }

    public String getCLCP_REASON_INV() {
        return CLCP_REASON_INV;
    }

    public void setCLCP_REASON_INV(String cLCP_REASON_INV) {
        CLCP_REASON_INV = cLCP_REASON_INV;
    }

    public String getCLCP_CMS_AFFSENT_YN() {
        return CLCP_CMS_AFFSENT_YN;
    }

    public void setCLCP_CMS_AFFSENT_YN(String cLCP_CMS_AFFSENT_YN) {
        CLCP_CMS_AFFSENT_YN = cLCP_CMS_AFFSENT_YN;
    }

    public Date getCLCP_CMS_SENT_DT() {
        return CLCP_CMS_SENT_DT;
    }

    public void setCLCP_CMS_SENT_DT(Date cLCP_CMS_SENT_DT) {
        CLCP_CMS_SENT_DT = cLCP_CMS_SENT_DT;
    }

    public Date getCLCP_CMS_RECD_DT() {
        return CLCP_CMS_RECD_DT;
    }

    public void setCLCP_CMS_RECD_DT(Date cLCP_CMS_RECD_DT) {
        CLCP_CMS_RECD_DT = cLCP_CMS_RECD_DT;
    }

    public String getCLCP_CLIEN_RECD_YN() {
        return CLCP_CLIEN_RECD_YN;
    }

    public void setCLCP_CLIEN_RECD_YN(String cLCP_CLIEN_RECD_YN) {
        CLCP_CLIEN_RECD_YN = cLCP_CLIEN_RECD_YN;
    }

    public Date getCLCP_CLL_RECD_DT() {
        return CLCP_CLL_RECD_DT;
    }

    public void setCLCP_CLL_RECD_DT(Date cLCP_CLL_RECD_DT) {
        CLCP_CLL_RECD_DT = cLCP_CLL_RECD_DT;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCLCP_ALC_REF_DESC_2() {
        return CLCP_ALC_REF_DESC_2;
    }

    public void setCLCP_ALC_REF_DESC_2(String cLCP_ALC_REF_DESC_2) {
        CLCP_ALC_REF_DESC_2 = cLCP_ALC_REF_DESC_2;
    }

    public String getCLCP_ALC_REF_DESC() {
        return CLCP_ALC_REF_DESC;
    }

    public void setCLCP_ALC_REF_DESC(String cLCP_ALC_REF_DESC) {
        CLCP_ALC_REF_DESC = cLCP_ALC_REF_DESC;
    }

    public String getCLCP_TYP_DESC() {
        return CLCP_TYP_DESC;
    }

    public void setCLCP_TYP_DESC(String cLCP_TYP_DESC) {
        CLCP_TYP_DESC = cLCP_TYP_DESC;
    }

    public String getCLCP_PY_EXTN_NO() {
        return CLCP_PY_EXTN_NO;
    }

    public void setCLCP_PY_EXTN_NO(String cLCP_PY_EXTN_NO) {
        CLCP_PY_EXTN_NO = cLCP_PY_EXTN_NO;
    }

    public String getCLCP_AL_EXTN_NO() {
        return CLCP_AL_EXTN_NO;
    }

    public void setCLCP_AL_EXTN_NO(String cLCP_AL_EXTN_NO) {
        CLCP_AL_EXTN_NO = cLCP_AL_EXTN_NO;
    }

    public String getCLCP_AL_EXTN_NO_2() {
        return CLCP_AL_EXTN_NO_2;
    }

    public void setCLCP_AL_EXTN_NO_2(String cLCP_AL_EXTN_NO_2) {
        CLCP_AL_EXTN_NO_2 = cLCP_AL_EXTN_NO_2;
    }

    public String getCLCP_PYC_REF_DESC() {
        return CLCP_PYC_REF_DESC;
    }

    public void setCLCP_PYC_REF_DESC(String cLCP_PYC_REF_DESC) {
        CLCP_PYC_REF_DESC = cLCP_PYC_REF_DESC;
    }

    public String getCLCP_DBA_NAME() {
        return CLCP_DBA_NAME;
    }

    public void setCLCP_DBA_NAME(String cLCP_DBA_NAME) {
        CLCP_DBA_NAME = cLCP_DBA_NAME;
    }

    public String getCLCP_CON_FNAME() {
        return CLCP_CON_FNAME;
    }

    public void setCLCP_CON_FNAME(String cLCP_CON_FNAME) {
        CLCP_CON_FNAME = cLCP_CON_FNAME;
    }

    public String getCLCP_CON_MNAME() {
        return CLCP_CON_MNAME;
    }

    public void setCLCP_CON_MNAME(String cLCP_CON_MNAME) {
        CLCP_CON_MNAME = cLCP_CON_MNAME;
    }

    public String getCLCP_CON_LNAME() {
        return CLCP_CON_LNAME;
    }

    public void setCLCP_CON_LNAME(String cLCP_CON_LNAME) {
        CLCP_CON_LNAME = cLCP_CON_LNAME;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getCLCP_INVD() {
        return CLCP_INVD;
    }

    public void setCLCP_INVD(Date cLCP_INVD) {
        CLCP_INVD = cLCP_INVD;
    }

    public String getCLCP_CUST_TYP() {
        return CLCP_CUST_TYP;
    }

    public void setCLCP_CUST_TYP(String cLCP_CUST_TYP) {
        CLCP_CUST_TYP = cLCP_CUST_TYP;
    }

    public String getCLCP_REC_STATUS() {
        return CLCP_REC_STATUS;
    }

    public void setCLCP_REC_STATUS(String cLCP_REC_STATUS) {
        CLCP_REC_STATUS = cLCP_REC_STATUS;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public String getCLCP_RELN() {
        return CLCP_RELN;
    }

    public void setCLCP_RELN(String cLCP_RELN) {
        CLCP_RELN = cLCP_RELN;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getOtherLanguage() {
        return otherLanguage;
    }

    public void setOtherLanguage(String otherLanguage) {
        this.otherLanguage = otherLanguage;
    }

    public int getCLCP_AMT() {
        return CLCP_AMT;
    }

    public void setCLCP_AMT(int cLCP_AMT) {
        CLCP_AMT = cLCP_AMT;
    }

    public String getCLCP_INJ_TYP() {
        return CLCP_INJ_TYP;
    }

    public void setCLCP_INJ_TYP(String cLCP_INJ_TYP) {
        CLCP_INJ_TYP = cLCP_INJ_TYP;
    }

    public String getCLCP_FLEX_01() {
        return CLCP_FLEX_01;
    }

    public void setCLCP_FLEX_01(String cLCP_FLEX_01) {
        CLCP_FLEX_01 = cLCP_FLEX_01;
    }

    public String getCLCP_FLEX_02() {
        return CLCP_FLEX_02;
    }

    public void setCLCP_FLEX_02(String cLCP_FLEX_02) {
        CLCP_FLEX_02 = cLCP_FLEX_02;
    }

    public String getCLCP_FLEX_03() {
        return CLCP_FLEX_03;
    }

    public void setCLCP_FLEX_03(String cLCP_FLEX_03) {
        CLCP_FLEX_03 = cLCP_FLEX_03;
    }

    public String getCLCP_FLEX_04() {
        return CLCP_FLEX_04;
    }

    public void setCLCP_FLEX_04(String cLCP_FLEX_04) {
        CLCP_FLEX_04 = cLCP_FLEX_04;
    }

    public String getCLCP_FLEX_05() {
        return CLCP_FLEX_05;
    }

    public void setCLCP_FLEX_05(String cLCP_FLEX_05) {
        CLCP_FLEX_05 = cLCP_FLEX_05;
    }

    public String getCLCP_FLEX_01_DESC() {
        return CLCP_FLEX_01_DESC;
    }

    public void setCLCP_FLEX_01_DESC(String cLCP_FLEX_01_DESC) {
        CLCP_FLEX_01_DESC = cLCP_FLEX_01_DESC;
    }

    public String getCLCP_FLEX_02_DESC() {
        return CLCP_FLEX_02_DESC;
    }

    public void setCLCP_FLEX_02_DESC(String cLCP_FLEX_02_DESC) {
        CLCP_FLEX_02_DESC = cLCP_FLEX_02_DESC;
    }

    public String getCLCP_FLEX_03_DESC() {
        return CLCP_FLEX_03_DESC;
    }

    public void setCLCP_FLEX_03_DESC(String cLCP_FLEX_03_DESC) {
        CLCP_FLEX_03_DESC = cLCP_FLEX_03_DESC;
    }

    public String getCLCP_FLEX_04_DESC() {
        return CLCP_FLEX_04_DESC;
    }

    public void setCLCP_FLEX_04_DESC(String cLCP_FLEX_04_DESC) {
        CLCP_FLEX_04_DESC = cLCP_FLEX_04_DESC;
    }

    public String getCLCP_FLEX_05_DESC() {
        return CLCP_FLEX_05_DESC;
    }

    public void setCLCP_FLEX_05_DESC(String cLCP_FLEX_05_DESC) {
        CLCP_FLEX_05_DESC = cLCP_FLEX_05_DESC;
    }

    public String getPrefixName() {
        return prefixName;
    }

    public void setPrefixName(String prefixName) {
        this.prefixName = prefixName;
    }

    @Override
    public String toString() {
        return "ClaimTransactionClaimantDetails [fnolSgsId=" + fnolSgsId + ", firstName=" + firstName + ", middleName="
                + middleName + ", lastName=" + lastName + ", address1=" + address1 + ", address2=" + address2
                + ", address3=" + address3 + ", address4=" + address4 + ", pincode=" + pincode + ", city=" + city
                + ", state=" + state + ", countryId=" + countryId + ", phoneNo=" + phoneNo + ", mobileNo=" + mobileNo
                + ", partyId=" + partyId + ", partyType=" + partyType + ", emailId=" + emailId + ", name=" + name
                + ", CLCP_PYC_REF_ID=" + CLCP_PYC_REF_ID + ", CLCP_ALC_REF_ID=" + CLCP_ALC_REF_ID + ", language="
                + language + ", CLCP_LCN_NO=" + CLCP_LCN_NO + ", CLCP_TIME_CONTACT=" + CLCP_TIME_CONTACT
                + ", CLCP_OTH_TYP=" + CLCP_OTH_TYP + ", recordType=" + recordType + ", reportedByClaimantYN="
                + reportedByClaimantYN + ", legalreportedYN=" + legalreportedYN + ", CLF_REF_PARTY_ID="
                + CLF_REF_PARTY_ID + ", CLCP_LANG_NAME=" + CLCP_LANG_NAME + ", CLCP_ALC_ID=" + CLCP_ALC_ID
                + ", CLCP_ALC_REF_ID_2=" + CLCP_ALC_REF_ID_2 + ", CLCP_ALC_ID_2=" + CLCP_ALC_ID_2 + ", CLCP_SSN_ID="
                + CLCP_SSN_ID + ", dob=" + dob + ", CLCP_MEDCARE_YN=" + CLCP_MEDCARE_YN + ", CLCP_INV_REQD_YN="
                + CLCP_INV_REQD_YN + ", CLCP_REASON_INV=" + CLCP_REASON_INV + ", CLCP_CMS_AFFSENT_YN="
                + CLCP_CMS_AFFSENT_YN + ", CLCP_CMS_SENT_DT=" + CLCP_CMS_SENT_DT + ", CLCP_CMS_RECD_DT="
                + CLCP_CMS_RECD_DT + ", CLCP_CLIEN_RECD_YN=" + CLCP_CLIEN_RECD_YN + ", CLCP_CLL_RECD_DT="
                + CLCP_CLL_RECD_DT + ", gender=" + gender + ", CLCP_ALC_REF_DESC_2=" + CLCP_ALC_REF_DESC_2
                + ", CLCP_ALC_REF_DESC=" + CLCP_ALC_REF_DESC + ", CLCP_TYP_DESC=" + CLCP_TYP_DESC + ", CLCP_PY_EXTN_NO="
                + CLCP_PY_EXTN_NO + ", CLCP_AL_EXTN_NO=" + CLCP_AL_EXTN_NO + ", CLCP_AL_EXTN_NO_2=" + CLCP_AL_EXTN_NO_2
                + ", CLCP_PYC_REF_DESC=" + CLCP_PYC_REF_DESC + ", CLCP_DBA_NAME=" + CLCP_DBA_NAME + ", CLCP_CON_FNAME="
                + CLCP_CON_FNAME + ", CLCP_CON_MNAME=" + CLCP_CON_MNAME + ", CLCP_CON_LNAME=" + CLCP_CON_LNAME
                + ", createdDate=" + createdDate + ", CLCP_INVD=" + CLCP_INVD + ", CLCP_CUST_TYP=" + CLCP_CUST_TYP
                + ", CLCP_REC_STATUS=" + CLCP_REC_STATUS + ", createdUser=" + createdUser + ", CLCP_RELN=" + CLCP_RELN
                + ", nationality=" + nationality + ", otherLanguage=" + otherLanguage + ", CLCP_AMT=" + CLCP_AMT
                + ", CLCP_INJ_TYP=" + CLCP_INJ_TYP + ", CLCP_FLEX_01=" + CLCP_FLEX_01 + ", CLCP_FLEX_02=" + CLCP_FLEX_02
                + ", CLCP_FLEX_03=" + CLCP_FLEX_03 + ", CLCP_FLEX_04=" + CLCP_FLEX_04 + ", CLCP_FLEX_05=" + CLCP_FLEX_05
                + ", CLCP_FLEX_01_DESC=" + CLCP_FLEX_01_DESC + ", CLCP_FLEX_02_DESC=" + CLCP_FLEX_02_DESC
                + ", CLCP_FLEX_03_DESC=" + CLCP_FLEX_03_DESC + ", CLCP_FLEX_04_DESC=" + CLCP_FLEX_04_DESC
                + ", CLCP_FLEX_05_DESC=" + CLCP_FLEX_05_DESC + ", prefixName=" + prefixName + "]";
    }
}

package com.beyontec.mol.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "ads_user")
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Column(name = "AU_COMP_ID")
    private String companyId;

    @Id
    @Column(name = "AU_ID")
    private String userId;

    @Column(name = "AU_FIRST_NAME")
    private String firstName;

    @Column(name = "AU_MIDDLE_NAME")
    private String middleName;

    @Column(name = "AU_LAST_NAME")
    private String lastName;

    @Column(name = "AU_NAME")
    private String name;

    @Column(name = "AU_PW_PROFILE")
    private String pwdProfile;

    @Column(name = "AU_PASSWORD")
    private String password;

    @Column(name = "AU_EMP_ID")
    private String employeeId;

    @Column(name = "AU_AUG_ID")
    private String AU_AUG_ID;

    @Column(name = "AU_REPORTING_USER_ID")
    private String reportingUserId;

    @Column(name = "AU_REPORTING_AUG_ID")
    private String AU_REPORTING_AUG_ID;

    @Column(name = "AU_DOB")
    private Date dateOfBirth;

    @Column(name = "AU_MAIL_ID")
    private String mailId;

    @Column(name = "AU_MOBILE_NO")
    private String mobileNumber;

    @Column(name = "AU_PHONE_NO")
    private String phoneNumber;

    @Column(name = "AU_ENTRY_DATE")
    private Date entryDate;

    @Column(name = "AU_EXIT_DATE")
    private Date exitDate;

    @Column(name = "AU_ACTING_USER")
    private String actingUser;

    @Column(name = "AU_ACTING_ST_DATE")
    private String actingStartingDate;

    @Column(name = "AU_ACTING_END_DATE")
    private String actingEndDate;

    @Column(name = "AU_FAVOURITE_QUES")
    private String favouriteQuestions;

    @Column(name = "AU_FAVOURITE_ANS")
    private String favouriteAnswers;

    @Column(name = "AU_STS_FLAG")
    private String AU_STS_FLAG;

    @Column(name = "AU_CRU")
    private String AU_CRU;

    @Column(name = "AU_CRD")
    private Date AU_CRD;

    @Column(name = "AU_DESIG_ID")
    private String designationId;

    @Column(name = "AU_FIRST_LOGIN_YN")
    private String isFirstLogin;

    @Column(name = "AU_DFLT_WKB")
    private String AU_DFLT_WKB;

    @Column(name = "AU_DFLT_LANG")
    private String AU_DFLT_LANG;

    @Column(name = "AU_DFLT_MODULE_TYP")
    private String AU_DFLT_MODULE_TYP;

    @Column(name = "AU_TYP")
    private String AU_TYP;

    @Column(name = "AU_LINK_ID")
    private String linkId;

    @Column(name = "AU_ESIGN")
    private String AU_ESIGN;

    @Column(name = "AU_SESSION_STATE")
    private String AU_SESSION_STATE;

    @Column(name = "AU_SUB_TYP")
    private String AU_SUB_TYP;

    @Column(name = "AU_FIRST_NAME_1")
    private String firstName1;

    @Column(name = "AU_FIRST_NAME_2")
    private String firstName2;

    @Column(name = "AU_FIRST_NAME_3")
    private String firstName3;

    @Column(name = "AU_FIRST_NAME_4")
    private String firstName4;

    @Column(name = "AU_MIDDLE_NAME_1")
    private String middleName1;

    @Column(name = "AU_MIDDLE_NAME_2")
    private String middleName2;

    @Column(name = "AU_MIDDLE_NAME_3")
    private String middleName3;

    @Column(name = "AU_MIDDLE_NAME_4")
    private String middleName4;

    @Column(name = "AU_LAST_NAME_1")
    private String lastName1;

    @Column(name = "AU_LAST_NAME_2")
    private String lastName2;

    @Column(name = "AU_LAST_NAME_3")
    private String lastName3;

    @Column(name = "AU_LAST_NAME_4")
    private String lastName4;

    @Column(name = "AU_NAME_1")
    private String name1;

    @Column(name = "AU_NAME_2")
    private String name2;

    @Column(name = "AU_NAME_3")
    private String name3;

    @Column(name = "AU_NAME_4")
    private String name4;

    @Column(name = "AU_HELP_MSG_YN")
    private String AU_HELP_MSG_YN;

    @Column(name = "AU_LINK_RNK_ID")
    private String AU_LINK_RNK_ID;

    @Column(name = "AU_SESS_NOTO_YN")
    private String AU_SESS_NOTO_YN;

    @Column(name = "AU_ESIGN_FONT")
    private String AU_ESIGN_FONT;

    @Column(name = "AU_ESIGN_NO")
    private String AU_ESIGN_NO;

    @Column(name = "AU_GADGET_POS")
    private String AU_GADGET_POS;

    @Column(name = "AU_DB_FLAG")
    private String AU_DB_FLAG;

    @Column(name = "AU_UPU")
    private String AU_UPU;

    @Column(name = "AU_UPD")
    private Date AU_UPD;

    @Column(name = "AU_POOL_ID")
    private String AU_POOL_ID;

    @Column(name = "AU_LOGIN_ID")
    private String loginId;

    @Column(name = "AU_FMD")
    private Date AU_FMD;

    @Column(name = "AU_TOD")
    private Date AU_TOD;

    @Column(name = "AU_VER_NO")
    private String AU_VER_NO;

    @Column(name = "AU_APU")
    private String AU_APU;

    @Column(name = "AU_APPRV_STATUS")
    private String AU_APPRV_STATUS;

    @Column(name = "AU_APD")
    private Date AU_APD;

    @Column(name = "AU_REC_TYP")
    private String AU_REC_TYP;

    @Column(name = "AU_EXP_IMP_REF")
    private String AU_EXP_IMP_REF;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "ads_user_roles",
    joinColumns = { @JoinColumn(name = "AUR_AU_ID") },
    inverseJoinColumns = { @JoinColumn(name = "AUR_AUG_ID") })
    private Set<UserGroup> userGroups;

    public Set<UserGroup> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(Set<UserGroup> userGroups) {
        this.userGroups = userGroups;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
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

    public String getPwdProfile() {
        return pwdProfile;
    }

    public void setPwdProfile(String pwdProfile) {
        this.pwdProfile = pwdProfile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getAU_AUG_ID() {
        return AU_AUG_ID;
    }

    public void setAU_AUG_ID(String aU_AUG_ID) {
        AU_AUG_ID = aU_AUG_ID;
    }

    public String getReportingUserId() {
        return reportingUserId;
    }

    public void setReportingUserId(String reportingUserId) {
        this.reportingUserId = reportingUserId;
    }

    public String getAU_REPORTING_AUG_ID() {
        return AU_REPORTING_AUG_ID;
    }

    public void setAU_REPORTING_AUG_ID(String aU_REPORTING_AUG_ID) {
        AU_REPORTING_AUG_ID = aU_REPORTING_AUG_ID;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Date getExitDate() {
        return exitDate;
    }

    public void setExitDate(Date exitDate) {
        this.exitDate = exitDate;
    }

    public String getActingUser() {
        return actingUser;
    }

    public void setActingUser(String actingUser) {
        this.actingUser = actingUser;
    }

    public String getActingStartingDate() {
        return actingStartingDate;
    }

    public void setActingStartingDate(String actingStartingDate) {
        this.actingStartingDate = actingStartingDate;
    }

    public String getActingEndDate() {
        return actingEndDate;
    }

    public void setActingEndDate(String actingEndDate) {
        this.actingEndDate = actingEndDate;
    }

    public String getFavouriteQuestions() {
        return favouriteQuestions;
    }

    public void setFavouriteQuestions(String favouriteQuestions) {
        this.favouriteQuestions = favouriteQuestions;
    }

    public String getFavouriteAnswers() {
        return favouriteAnswers;
    }

    public void setFavouriteAnswers(String favouriteAnswers) {
        this.favouriteAnswers = favouriteAnswers;
    }

    public String getAU_STS_FLAG() {
        return AU_STS_FLAG;
    }

    public void setAU_STS_FLAG(String aU_STS_FLAG) {
        AU_STS_FLAG = aU_STS_FLAG;
    }

    public String getAU_CRU() {
        return AU_CRU;
    }

    public void setAU_CRU(String aU_CRU) {
        AU_CRU = aU_CRU;
    }

    public Date getAU_CRD() {
        return AU_CRD;
    }

    public void setAU_CRD(Date aU_CRD) {
        AU_CRD = aU_CRD;
    }

    public String getDesignationId() {
        return designationId;
    }

    public void setDesignationId(String designationId) {
        this.designationId = designationId;
    }

    public String getLoginStatus() {
        return isFirstLogin;
    }

    public void setLoginStatus(String isFirstLogin) {
        this.isFirstLogin = isFirstLogin;
    }

    public String getAU_DFLT_WKB() {
        return AU_DFLT_WKB;
    }

    public void setAU_DFLT_WKB(String aU_DFLT_WKB) {
        AU_DFLT_WKB = aU_DFLT_WKB;
    }

    public String getAU_DFLT_LANG() {
        return AU_DFLT_LANG;
    }

    public void setAU_DFLT_LANG(String aU_DFLT_LANG) {
        AU_DFLT_LANG = aU_DFLT_LANG;
    }

    public String getAU_DFLT_MODULE_TYP() {
        return AU_DFLT_MODULE_TYP;
    }

    public void setAU_DFLT_MODULE_TYP(String aU_DFLT_MODULE_TYP) {
        AU_DFLT_MODULE_TYP = aU_DFLT_MODULE_TYP;
    }

    public String getAU_TYP() {
        return AU_TYP;
    }

    public void setAU_TYP(String aU_TYP) {
        AU_TYP = aU_TYP;
    }

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    public String getAU_ESIGN() {
        return AU_ESIGN;
    }

    public void setAU_ESIGN(String aU_ESIGN) {
        AU_ESIGN = aU_ESIGN;
    }

    public String getAU_SESSION_STATE() {
        return AU_SESSION_STATE;
    }

    public void setAU_SESSION_STATE(String aU_SESSION_STATE) {
        AU_SESSION_STATE = aU_SESSION_STATE;
    }

    public String getAU_SUB_TYP() {
        return AU_SUB_TYP;
    }

    public void setAU_SUB_TYP(String aU_SUB_TYP) {
        AU_SUB_TYP = aU_SUB_TYP;
    }

    public String getFirstName1() {
        return firstName1;
    }

    public void setFirstName1(String firstName1) {
        this.firstName1 = firstName1;
    }

    public String getFirstName2() {
        return firstName2;
    }

    public void setFirstName2(String firstName2) {
        this.firstName2 = firstName2;
    }

    public String getFirstName3() {
        return firstName3;
    }

    public void setFirstName3(String firstName3) {
        this.firstName3 = firstName3;
    }

    public String getFirstName4() {
        return firstName4;
    }

    public void setFirstName4(String firstName4) {
        this.firstName4 = firstName4;
    }

    public String getMiddleName1() {
        return middleName1;
    }

    public void setMiddleName1(String middleName1) {
        this.middleName1 = middleName1;
    }

    public String getMiddleName2() {
        return middleName2;
    }

    public void setMiddleName2(String middleName2) {
        this.middleName2 = middleName2;
    }

    public String getMiddleName3() {
        return middleName3;
    }

    public void setMiddleName3(String middleName3) {
        this.middleName3 = middleName3;
    }

    public String getMiddleName4() {
        return middleName4;
    }

    public void setMiddleName4(String middleName4) {
        this.middleName4 = middleName4;
    }

    public String getLastName1() {
        return lastName1;
    }

    public void setLastName1(String lastName1) {
        this.lastName1 = lastName1;
    }

    public String getLastName2() {
        return lastName2;
    }

    public void setLastName2(String lastName2) {
        this.lastName2 = lastName2;
    }

    public String getLastName3() {
        return lastName3;
    }

    public void setLastName3(String lastName3) {
        this.lastName3 = lastName3;
    }

    public String getLastName4() {
        return lastName4;
    }

    public void setLastName4(String lastName4) {
        this.lastName4 = lastName4;
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

    public String getAU_HELP_MSG_YN() {
        return AU_HELP_MSG_YN;
    }

    public void setAU_HELP_MSG_YN(String aU_HELP_MSG_YN) {
        AU_HELP_MSG_YN = aU_HELP_MSG_YN;
    }

    public String getAU_LINK_RNK_ID() {
        return AU_LINK_RNK_ID;
    }

    public void setAU_LINK_RNK_ID(String aU_LINK_RNK_ID) {
        AU_LINK_RNK_ID = aU_LINK_RNK_ID;
    }

    public String getAU_SESS_NOTO_YN() {
        return AU_SESS_NOTO_YN;
    }

    public void setAU_SESS_NOTO_YN(String aU_SESS_NOTO_YN) {
        AU_SESS_NOTO_YN = aU_SESS_NOTO_YN;
    }

    public String getAU_ESIGN_FONT() {
        return AU_ESIGN_FONT;
    }

    public void setAU_ESIGN_FONT(String aU_ESIGN_FONT) {
        AU_ESIGN_FONT = aU_ESIGN_FONT;
    }

    public String getAU_ESIGN_NO() {
        return AU_ESIGN_NO;
    }

    public void setAU_ESIGN_NO(String aU_ESIGN_NO) {
        AU_ESIGN_NO = aU_ESIGN_NO;
    }

    public String getAU_GADGET_POS() {
        return AU_GADGET_POS;
    }

    public void setAU_GADGET_POS(String aU_GADGET_POS) {
        AU_GADGET_POS = aU_GADGET_POS;
    }

    public String getAU_DB_FLAG() {
        return AU_DB_FLAG;
    }

    public void setAU_DB_FLAG(String aU_DB_FLAG) {
        AU_DB_FLAG = aU_DB_FLAG;
    }

    public String getAU_UPU() {
        return AU_UPU;
    }

    public void setAU_UPU(String aU_UPU) {
        AU_UPU = aU_UPU;
    }

    public Date getAU_UPD() {
        return AU_UPD;
    }

    public void setAU_UPD(Date aU_UPD) {
        AU_UPD = aU_UPD;
    }

    public String getAU_POOL_ID() {
        return AU_POOL_ID;
    }

    public void setAU_POOL_ID(String aU_POOL_ID) {
        AU_POOL_ID = aU_POOL_ID;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public Date getAU_FMD() {
        return AU_FMD;
    }

    public void setAU_FMD(Date aU_FMD) {
        AU_FMD = aU_FMD;
    }

    public Date getAU_TOD() {
        return AU_TOD;
    }

    public void setAU_TOD(Date aU_TOD) {
        AU_TOD = aU_TOD;
    }

    public String getAU_VER_NO() {
        return AU_VER_NO;
    }

    public void setAU_VER_NO(String aU_VER_NO) {
        AU_VER_NO = aU_VER_NO;
    }

    public String getAU_APU() {
        return AU_APU;
    }

    public void setAU_APU(String aU_APU) {
        AU_APU = aU_APU;
    }

    public String getAU_APPRV_STATUS() {
        return AU_APPRV_STATUS;
    }

    public void setAU_APPRV_STATUS(String aU_APPRV_STATUS) {
        AU_APPRV_STATUS = aU_APPRV_STATUS;
    }

    public Date getAU_APD() {
        return AU_APD;
    }

    public void setAU_APD(Date aU_APD) {
        AU_APD = aU_APD;
    }

    public String getAU_REC_TYP() {
        return AU_REC_TYP;
    }

    public void setAU_REC_TYP(String aU_REC_TYP) {
        AU_REC_TYP = aU_REC_TYP;
    }

    public String getAU_EXP_IMP_REF() {
        return AU_EXP_IMP_REF;
    }

    public void setAU_EXP_IMP_REF(String aU_EXP_IMP_REF) {
        AU_EXP_IMP_REF = aU_EXP_IMP_REF;
    }

}

package com.beyontec.mol.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TDS_LEVEL_D")
public class UploadDocumentEntity {
    @Id
    @Column(name = "TLD_SGS_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tld_sgs_id_generator")
    @SequenceGenerator(name = "tld_sgs_id_generator", sequenceName = "SEQ_TLD_SGS_ID", allocationSize = 1)
    private int documentSgsId;

    @Column(name = "TLD_TXN_REF_NO")
    private Long fnolSgsId;

    private int TLD_TXN_SREF_NO;
    private String TLD_LVL_TYP;
    private String TLD_LVL_ID;

    @Column(name = "TLD_SR_NO")
    private int serialNo;

    @Column(name = "TLD_DOC_ID")
    private String documentId;

    @Column(name = "TLD_DOC_DESC")
    private String documentType;

    @Column(name = "TLD_MAND_YN")
    private String isMandatory;

    @Column(name = "TLD_DOC_STATUS")
    private String documentStatus;

    @Column(name = "TLD_RECD_DT")
    private Date uploadedDate;

    @Column(name = "TLD_DOC_NAME")
    private String documentName;

    @Column(name = "TLD_TYP")
    private String uploadedByType;

    @Column(name = "TLD_MOD_TYP")
    private String moduleType;

    @Column(name = "TLD_TXN_REF")
    private String complaintNo;

    private String TLD_PARTY_TYP;
    private String TLD_PARTY_ID;

    @Column(name = "TLD_REMARKS")
    private String remarks;
    private String TLD_PARTY_NAME;

    @Column(name = "TLD_CRU")
    private String uploadedUser;

    @Column(name = "TLD_CRD")
    private Date createdDate;

    private String TLD_STYP;
    private String TLD_STYP_DESC;

    @Column(name = "TLD_COMP_ID")
    private String compantId;

    private Date TLD_PMD;
    private String TLD_ULC_MST_ID;
    private String TLD_CLE_CUST_ID;
    private String TLD_AUG_ID;
    private String TLD_CASE_NAME;
    private String TLD_CASE_REF;
    private String TLD_PROCESSED;

    @Column(name = "TLD_FOLDER_NAME")
    private String folderName;
    private int TLD_VER_NO;
    private String TLD_APU;
    private String TLD_APPRV_STATUS;

    @Column(name = "TLD_APD")
    private Date approvedDate;

    @Column(name = "TLD_REC_TYP")
    private String recordType;
    private int TLD_EXP_IMP_REF;
    private Date TLD_FMD;
    private Date TLD_TOD;

    public int getDocumentSgsId() {
        return documentSgsId;
    }

    public void setDocumentSgsId(int documentSgsId) {
        this.documentSgsId = documentSgsId;
    }

    public Long getFnolSgsId() {
        return fnolSgsId;
    }

    public void setFnolSgsId(Long fnolSgsId) {
        this.fnolSgsId = fnolSgsId;
    }

    public int getTLD_TXN_SREF_NO() {
        return TLD_TXN_SREF_NO;
    }

    public void setTLD_TXN_SREF_NO(int tLD_TXN_SREF_NO) {
        TLD_TXN_SREF_NO = tLD_TXN_SREF_NO;
    }

    public String getTLD_LVL_TYP() {
        return TLD_LVL_TYP;
    }

    public void setTLD_LVL_TYP(String tLD_LVL_TYP) {
        TLD_LVL_TYP = tLD_LVL_TYP;
    }

    public String getTLD_LVL_ID() {
        return TLD_LVL_ID;
    }

    public void setTLD_LVL_ID(String tLD_LVL_ID) {
        TLD_LVL_ID = tLD_LVL_ID;
    }

    public int getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getIsMandatory() {
        return isMandatory;
    }

    public void setIsMandatory(String isMandatory) {
        this.isMandatory = isMandatory;
    }

    public String getDocumentStatus() {
        return documentStatus;
    }

    public void setDocumentStatus(String documentStatus) {
        this.documentStatus = documentStatus;
    }

    public Date getUploadedDate() {
        return uploadedDate;
    }

    public void setUploadedDate(Date uploadedDate) {
        this.uploadedDate = uploadedDate;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getUploadedByType() {
        return uploadedByType;
    }

    public void setUploadedByType(String uploadedByType) {
        this.uploadedByType = uploadedByType;
    }

    public String getModuleType() {
        return moduleType;
    }

    public void setModuleType(String moduleType) {
        this.moduleType = moduleType;
    }

    public String getComplaintNo() {
        return complaintNo;
    }

    public void setComplaintNo(String complaintNo) {
        this.complaintNo = complaintNo;
    }

    public String getTLD_PARTY_TYP() {
        return TLD_PARTY_TYP;
    }

    public void setTLD_PARTY_TYP(String tLD_PARTY_TYP) {
        TLD_PARTY_TYP = tLD_PARTY_TYP;
    }

    public String getTLD_PARTY_ID() {
        return TLD_PARTY_ID;
    }

    public void setTLD_PARTY_ID(String tLD_PARTY_ID) {
        TLD_PARTY_ID = tLD_PARTY_ID;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getTLD_PARTY_NAME() {
        return TLD_PARTY_NAME;
    }

    public void setTLD_PARTY_NAME(String tLD_PARTY_NAME) {
        TLD_PARTY_NAME = tLD_PARTY_NAME;
    }

    public String getUploadedUser() {
        return uploadedUser;
    }

    public void setUploadedUser(String uploadedUser) {
        this.uploadedUser = uploadedUser;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getTLD_STYP() {
        return TLD_STYP;
    }

    public void setTLD_STYP(String tLD_STYP) {
        TLD_STYP = tLD_STYP;
    }

    public String getTLD_STYP_DESC() {
        return TLD_STYP_DESC;
    }

    public void setTLD_STYP_DESC(String tLD_STYP_DESC) {
        TLD_STYP_DESC = tLD_STYP_DESC;
    }

    public String getCompantId() {
        return compantId;
    }

    public void setCompantId(String compantId) {
        this.compantId = compantId;
    }

    public Date getTLD_PMD() {
        return TLD_PMD;
    }

    public void setTLD_PMD(Date tLD_PMD) {
        TLD_PMD = tLD_PMD;
    }

    public String getTLD_ULC_MST_ID() {
        return TLD_ULC_MST_ID;
    }

    public void setTLD_ULC_MST_ID(String tLD_ULC_MST_ID) {
        TLD_ULC_MST_ID = tLD_ULC_MST_ID;
    }

    public String getTLD_CLE_CUST_ID() {
        return TLD_CLE_CUST_ID;
    }

    public void setTLD_CLE_CUST_ID(String tLD_CLE_CUST_ID) {
        TLD_CLE_CUST_ID = tLD_CLE_CUST_ID;
    }

    public String getTLD_AUG_ID() {
        return TLD_AUG_ID;
    }

    public void setTLD_AUG_ID(String tLD_AUG_ID) {
        TLD_AUG_ID = tLD_AUG_ID;
    }

    public String getTLD_CASE_NAME() {
        return TLD_CASE_NAME;
    }

    public void setTLD_CASE_NAME(String tLD_CASE_NAME) {
        TLD_CASE_NAME = tLD_CASE_NAME;
    }

    public String getTLD_CASE_REF() {
        return TLD_CASE_REF;
    }

    public void setTLD_CASE_REF(String tLD_CASE_REF) {
        TLD_CASE_REF = tLD_CASE_REF;
    }

    public String getTLD_PROCESSED() {
        return TLD_PROCESSED;
    }

    public void setTLD_PROCESSED(String tLD_PROCESSED) {
        TLD_PROCESSED = tLD_PROCESSED;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public int getTLD_VER_NO() {
        return TLD_VER_NO;
    }

    public void setTLD_VER_NO(int tLD_VER_NO) {
        TLD_VER_NO = tLD_VER_NO;
    }

    public String getTLD_APU() {
        return TLD_APU;
    }

    public void setTLD_APU(String tLD_APU) {
        TLD_APU = tLD_APU;
    }

    public String getTLD_APPRV_STATUS() {
        return TLD_APPRV_STATUS;
    }

    public void setTLD_APPRV_STATUS(String tLD_APPRV_STATUS) {
        TLD_APPRV_STATUS = tLD_APPRV_STATUS;
    }

    public Date getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public int getTLD_EXP_IMP_REF() {
        return TLD_EXP_IMP_REF;
    }

    public void setTLD_EXP_IMP_REF(int tLD_EXP_IMP_REF) {
        TLD_EXP_IMP_REF = tLD_EXP_IMP_REF;
    }

    public Date getTLD_FMD() {
        return TLD_FMD;
    }

    public void setTLD_FMD(Date tLD_FMD) {
        TLD_FMD = tLD_FMD;
    }

    public Date getTLD_TOD() {
        return TLD_TOD;
    }

    public void setTLD_TOD(Date tLD_TOD) {
        TLD_TOD = tLD_TOD;
    }

}

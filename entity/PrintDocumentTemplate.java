package com.beyontec.mol.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "UDS_DOC_PRN_TPL")
@EntityListeners(AuditingEntityListener.class)
public class PrintDocumentTemplate {
    // @formatter:off
    @Id
    @Column(name = "UDPT_TPL_ID")                                   private String tplId;

    @Column(name = "UDPT_TPL_NAME")                                 private String tplName;
    @Column(name = "UDPT_TPL_TYP")                                  private String tplType;
    @Column(name = "UDPT_TPL_MOD")                                  private String tplModule;
    @Column(name = "UDPT_PARAM_IDENT")                              private String paramId;
    @Column(name = "UDT_PROD_ID")                                   private String productId;
    @Column(name = "UDT_TEXT", columnDefinition = "CLOB")           private String text;
    @Column(name = "UDT_FMD")                                       private Date fromDate;
    @Column(name = "UDT_TOD")                                       private Date toDate;
    @Column(name = "UDPT_COMP_ID")                                  private String companyId;
    @Column(name = "UDPT_COB_ID")                                   private String cobId;
    @Column(name = "UDPT_TPL_LVL")                                  private String level;
    @Column(name = "UDPT_TPL_FOR")                                  private String templateFor;
    @Column(name = "UDPT_TPL_DOC_ID")                               private String documentId;
    @Column(name = "UDPT_DFLT_REP_YN")                              private String defaultRepYn;
    @Column(name = "UDPT_TMPL_ID")                                  private String templateId;
    @Column(name = "UDPT_DISP_SEQ")                                 private Long displaySeq;
    @Column(name = "UDPT_APPRV_REQ_YN")                             private String approvalReqYn;
    @Column(name = "UDPT_GEN_DOC_FOR")                              private String genDocFor;
    @Column(name = "UDPT_OP_FMT")                                   private String opFmt;
    @Column(name = "UDPT_TPL_NAME_1")                               private String tplName1;
    @Column(name = "UDPT_TPL_NAME_2")                               private String tplName2;
    @Column(name = "UDPT_TPL_NAME_3")                               private String tplName3;
    @Column(name = "UDPT_TPL_NAME_4")                               private String tplName4;
    @Column(name = "UDPT_GEN_BY_REC")                               private String genByRec;
    @Column(name = "UDPT_DESC_YN")                                  private String descYn;
    @Column(name = "UDPT_SHOWIN_PCS_YN")                            private String showInPcsYn;
    @Column(name = "UDPT_PCS_PRNT_NAME")                            private String pcsPrintName;
    @Column(name = "UDPT_ESIGN_TYP")                                private String eSignType;
    @Column(name = "UDPT_DELIVERY_TYP")                             private String deliveryType;
    @Column(name = "UDPT_EDIT_FLAG")                                private String editFlag;
    @Column(name = "UDPT_CRU")                                      private String createdUser;
    @Column(name = "UDPT_CRD")                                      private Date createdDate;
    @Column(name = "UDPT_VER_NO")                                   private Long versionNo;
    @Column(name = "UDPT_APU")                                      private String approvalUser;
    @Column(name = "UDPT_APPRV_STATUS")                             private String approvalStatus;
    @Column(name = "UDPT_APD")                                      private Date approvalDate;
    @Column(name = "UDPT_REC_TYP")                                  private String recordType;
    @Column(name = "UDPT_EXP_IMP_REF")                              private Long expImpRef;
    @Column(name = "UDPT_FORMS_YN")                                 private String formsYn;
    @Column(name = "UDPT_CCLT_REP_YN")                              private String ccltRepYn;
    @Column(name = "UDPT_DWHLT_REP_YN")                             private String dwhltRepYn;
    // @formatter:on

    public String getTplId() {
        return tplId;
    }

    public void setTplId(String tplId) {
        this.tplId = tplId;
    }

    public String getTplName() {
        return tplName;
    }

    public void setTplName(String tplName) {
        this.tplName = tplName;
    }

    public String getTplType() {
        return tplType;
    }

    public void setTplType(String tplType) {
        this.tplType = tplType;
    }

    public String getTplModule() {
        return tplModule;
    }

    public void setTplModule(String tplModule) {
        this.tplModule = tplModule;
    }

    public String getParamId() {
        return paramId;
    }

    public void setParamId(String paramId) {
        this.paramId = paramId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCobId() {
        return cobId;
    }

    public void setCobId(String cobId) {
        this.cobId = cobId;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getTemplateFor() {
        return templateFor;
    }

    public void setTemplateFor(String templateFor) {
        this.templateFor = templateFor;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getDefaultRepYn() {
        return defaultRepYn;
    }

    public void setDefaultRepYn(String defaultRepYn) {
        this.defaultRepYn = defaultRepYn;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public Long getDisplaySeq() {
        return displaySeq;
    }

    public void setDisplaySeq(Long displaySeq) {
        this.displaySeq = displaySeq;
    }

    public String getApprovalReqYn() {
        return approvalReqYn;
    }

    public void setApprovalReqYn(String approvalReqYn) {
        this.approvalReqYn = approvalReqYn;
    }

    public String getGenDocFor() {
        return genDocFor;
    }

    public void setGenDocFor(String genDocFor) {
        this.genDocFor = genDocFor;
    }

    public String getOpFmt() {
        return opFmt;
    }

    public void setOpFmt(String opFmt) {
        this.opFmt = opFmt;
    }

    public String getTplName1() {
        return tplName1;
    }

    public void setTplName1(String tplName1) {
        this.tplName1 = tplName1;
    }

    public String getTplName2() {
        return tplName2;
    }

    public void setTplName2(String tplName2) {
        this.tplName2 = tplName2;
    }

    public String getTplName3() {
        return tplName3;
    }

    public void setTplName3(String tplName3) {
        this.tplName3 = tplName3;
    }

    public String getTplName4() {
        return tplName4;
    }

    public void setTplName4(String tplName4) {
        this.tplName4 = tplName4;
    }

    public String getGenByRec() {
        return genByRec;
    }

    public void setGenByRec(String genByRec) {
        this.genByRec = genByRec;
    }

    public String getDescYn() {
        return descYn;
    }

    public void setDescYn(String descYn) {
        this.descYn = descYn;
    }

    public String getShowInPcsYn() {
        return showInPcsYn;
    }

    public void setShowInPcsYn(String showInPcsYn) {
        this.showInPcsYn = showInPcsYn;
    }

    public String getPcsPrintName() {
        return pcsPrintName;
    }

    public void setPcsPrintName(String pcsPrintName) {
        this.pcsPrintName = pcsPrintName;
    }

    public String geteSignType() {
        return eSignType;
    }

    public void seteSignType(String eSignType) {
        this.eSignType = eSignType;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getEditFlag() {
        return editFlag;
    }

    public void setEditFlag(String editFlag) {
        this.editFlag = editFlag;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Long getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(Long versionNo) {
        this.versionNo = versionNo;
    }

    public String getApprovalUser() {
        return approvalUser;
    }

    public void setApprovalUser(String approvalUser) {
        this.approvalUser = approvalUser;
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

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public Long getExpImpRef() {
        return expImpRef;
    }

    public void setExpImpRef(Long expImpRef) {
        this.expImpRef = expImpRef;
    }

    public String getFormsYn() {
        return formsYn;
    }

    public void setFormsYn(String formsYn) {
        this.formsYn = formsYn;
    }

    public String getCcltRepYn() {
        return ccltRepYn;
    }

    public void setCcltRepYn(String ccltRepYn) {
        this.ccltRepYn = ccltRepYn;
    }

    public String getDwhltRepYn() {
        return dwhltRepYn;
    }

    public void setDwhltRepYn(String dwhltRepYn) {
        this.dwhltRepYn = dwhltRepYn;
    }
}

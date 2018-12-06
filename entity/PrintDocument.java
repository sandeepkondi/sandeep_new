package com.beyontec.mol.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.beyontec.mol.config.CommonConfig;
import com.beyontec.mol.util.DateUtil;

@Entity
@Table(name = "TDS_PRINT_DOCS")
@EntityListeners(AuditingEntityListener.class)
public class PrintDocument {
    // @formatter:off
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sgs_id_generator")
    @SequenceGenerator(name="sgs_id_generator", sequenceName = "SEQ_TPD_SGS_ID", allocationSize = 1)
    @Column(name = "TPD_SGS_ID")            protected Long id;

    @Column(name = "TPD_COMP_ID")           private String companyId;
    @Column(name = "TPD_MOD_ID")            private String moduleId;
    @Column(name = "TPD_TXN_TYP")           private String transactionType;
    @Column(name = "TPD_TXN_REF_NO")        private Long transactionRefNo;
    @Column(name = "TPD_TXN_SREF_NO")       private Long transactionSRefNo;
    @Column(name = "TPD_ATTRI_TYP")         private String attributeType;
    @Column(name = "TPD_ATTRI_ID")          private String attributeId;
    @Column(name = "TDP_PRINT_DESC")        private String printDescription;
    @Column(name = "TPD_UDPT_TPL_ID")       private String udptTemplateId;
    @Column(name = "TPD_2_CUST_YN")         private String custYn;
    @Column(name = "TPD_2_AGENT_YN")        private String agentYn;
    @Column(name = "TPD_2_MORT_YN")         private String mortYn;
    @Column(name = "TPD_2_ADDLINS_YN")      private String addlinsYn;
    @Column(name = "TPD_2_SURV_YN")         private String survYn;
    @Column(name = "TPD_2_GARAGE_YN")       private String garageYn;
    @Column(name = "TPD_2_LEGAL_YN")        private String legalYn;
    @Column(name = "TPD_2_INVEST_YN")       private String investYn;
    @Column(name = "TPD_2_TPINS_YN")        private String tPinsYn;
    @Column(name = "TDP_DISP_SEQ")          private Long displaySeq;
    @Column(name = "TPD_CRD")               private Date createdDate;
    @Column(name = "TPD_CRU")               private String createdUser;
    @Column(name = "TPD_TXN_STYP")          private String transactionSType;
    @Column(name = "TPD_RECEP_TYP")         private String recepType;
    @Column(name = "TPD_PRINT_YN")          private String printYn;
    @Column(name = "TPD_UDPT_TPL_FOR")      private String udptTemplateFor;
    @Column(name = "TPD_UDPT_TPL_DOC_ID")   private String udptTemplateDocId;
    @Column(name = "TPD_OVR_TPL_DOC_ID")    private String ovrTemplateDocId;
    @Column(name = "TPD_UPLOAD_TPL_DOC_ID") private String uploadTemplateDocId;
    @Column(name = "TPD_UDPT_TPL_TYP")      private String udptTemplateType;
    @Column(name = "TPD_PROD_ID")           private String productId;
    @Column(name = "TPD_TMPL_ID")           private String templateId;
    @Column(name = "TPD_MAND_YN")           private String mandatoryYn;
    @Column(name = "TPD_PRN_GRP_ID")        private String printGroupId;
    @Column(name = "TPD_UPD_ID")            private String updId;
    @Column(name = "TPD_OP_FMT")            private String opFmt;
    @Column(name = "TPD_APU")               private String approvalUser;
    @Column(name = "TPD_APD")               private Date approvalDate;
    @Column(name = "TPD_BATCH_ID")          private String batchId;
    @Column(name = "TPD_ENTITY_ID")         private String entityId;
    @Column(name = "TPD_DOC_DESC")          private String documentDesc;
    @Column(name = "TPD_SHOWIN_PCS_YN")     private String showInPcsYn;
    @Column(name = "TPD_PCS_PRNT_NAME")     private String pcsPrintName;
    @Column(name = "TPD_REGEN_YN")          private String regenerateYn;
    @Column(name = "TPD_ESIGN_STS")         private String eSignSts;
    @Column(name = "TPD_READ_YN")           private String readYn;
    @Column(name = "TPD_EPRINT_YN")         private String ePrintYn;
    @Column(name = "TPD_SPL_DOC_ID")        private String splDocId;
    @Column(name = "TPD_DELIVERY_TYP")      private String deliveryType;
    @Column(name = "TPD_EDIT_FLAG")         private String editFlag;
    @Column(name = "TPD_HIDE_YN")           private String hideYn;
    @Column(name = "TPD_CARRIER_ID")        private String carrierId;
    @Column(name = "TPD_PP_PRINT_YN")       private String passportPrintYn;
    @Column(name = "TPD_PRD")               private Date period;

    // TODO: uncomment when column is added in the DB
//    @Column(name = "TPD_DMS_REF")           private String dmsRef;
    // @formatter:on

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Long getTransactionRefNo() {
        return transactionRefNo;
    }

    public void setTransactionRefNo(Long transactionRefNo) {
        this.transactionRefNo = transactionRefNo;
    }

    public Long getTransactionSRefNo() {
        return transactionSRefNo;
    }

    public void setTransactionSRefNo(Long transactionSRefNo) {
        this.transactionSRefNo = transactionSRefNo;
    }

    public String getAttributeType() {
        return attributeType;
    }

    public void setAttributeType(String attributeType) {
        this.attributeType = attributeType;
    }

    public String getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(String attributeId) {
        this.attributeId = attributeId;
    }

    public String getPrintDescription() {
        return printDescription;
    }

    public void setPrintDescription(String printDescription) {
        this.printDescription = printDescription;
    }

    public String getUdptTemplateId() {
        return udptTemplateId;
    }

    public void setUdptTemplateId(String udptTemplateId) {
        this.udptTemplateId = udptTemplateId;
    }

    public String getCustYn() {
        return custYn;
    }

    public void setCustYn(String custYn) {
        this.custYn = custYn;
    }

    public String getAgentYn() {
        return agentYn;
    }

    public void setAgentYn(String agentYn) {
        this.agentYn = agentYn;
    }

    public String getMortYn() {
        return mortYn;
    }

    public void setMortYn(String mortYn) {
        this.mortYn = mortYn;
    }

    public String getAddlinsYn() {
        return addlinsYn;
    }

    public void setAddlinsYn(String addlinsYn) {
        this.addlinsYn = addlinsYn;
    }

    public String getSurvYn() {
        return survYn;
    }

    public void setSurvYn(String survYn) {
        this.survYn = survYn;
    }

    public String getGarageYn() {
        return garageYn;
    }

    public void setGarageYn(String garageYn) {
        this.garageYn = garageYn;
    }

    public String getLegalYn() {
        return legalYn;
    }

    public void setLegalYn(String legalYn) {
        this.legalYn = legalYn;
    }

    public String getInvestYn() {
        return investYn;
    }

    public void setInvestYn(String investYn) {
        this.investYn = investYn;
    }

    public String gettPinsYn() {
        return tPinsYn;
    }

    public void settPinsYn(String tPinsYn) {
        this.tPinsYn = tPinsYn;
    }

    public Long getDisplaySeq() {
        return displaySeq;
    }

    public void setDisplaySeq(Long displaySeq) {
        this.displaySeq = displaySeq;
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

    public String getTransactionSType() {
        return transactionSType;
    }

    public void setTransactionSType(String transactionSType) {
        this.transactionSType = transactionSType;
    }

    public String getRecepType() {
        return recepType;
    }

    public void setRecepType(String recepType) {
        this.recepType = recepType;
    }

    public String getPrintYn() {
        return printYn;
    }

    public void setPrintYn(String printYn) {
        this.printYn = printYn;
    }

    public String getUdptTemplateFor() {
        return udptTemplateFor;
    }

    public void setUdptTemplateFor(String udptTemplateFor) {
        this.udptTemplateFor = udptTemplateFor;
    }

    public String getUdptTemplateDocId() {
        return udptTemplateDocId;
    }

    public void setUdptTemplateDocId(String udptTemplateDocId) {
        this.udptTemplateDocId = udptTemplateDocId;
    }

    public String getOvrTemplateDocId() {
        return ovrTemplateDocId;
    }

    public void setOvrTemplateDocId(String ovrTemplateDocId) {
        this.ovrTemplateDocId = ovrTemplateDocId;
    }

    public String getUploadTemplateDocId() {
        return uploadTemplateDocId;
    }

    public void setUploadTemplateDocId(String uploadTemplateDocId) {
        this.uploadTemplateDocId = uploadTemplateDocId;
    }

    public String getUdptTemplateType() {
        return udptTemplateType;
    }

    public void setUdptTemplateType(String udptTemplateType) {
        this.udptTemplateType = udptTemplateType;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getMandatoryYn() {
        return mandatoryYn;
    }

    public void setMandatoryYn(String mandatoryYn) {
        this.mandatoryYn = mandatoryYn;
    }

    public String getPrintGroupId() {
        return printGroupId;
    }

    public void setPrintGroupId(String printGroupId) {
        this.printGroupId = printGroupId;
    }

    public String getUpdId() {
        return updId;
    }

    public void setUpdId(String updId) {
        this.updId = updId;
    }

    public String getOpFmt() {
        return opFmt;
    }

    public void setOpFmt(String opFmt) {
        this.opFmt = opFmt;
    }

    public String getApprovalUser() {
        return approvalUser;
    }

    public void setApprovalUser(String approvalUser) {
        this.approvalUser = approvalUser;
    }

    public Date getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public String getDocumentDesc() {
        return documentDesc;
    }

    public void setDocumentDesc(String documentDesc) {
        this.documentDesc = documentDesc;
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

    public String getRegenerateYn() {
        return regenerateYn;
    }

    public void setRegenerateYn(String regenerateYn) {
        this.regenerateYn = regenerateYn;
    }

    public String geteSignSts() {
        return eSignSts;
    }

    public void seteSignSts(String eSignSts) {
        this.eSignSts = eSignSts;
    }

    public String getReadYn() {
        return readYn;
    }

    public void setReadYn(String readYn) {
        this.readYn = readYn;
    }

    public String getePrintYn() {
        return ePrintYn;
    }

    public void setePrintYn(String ePrintYn) {
        this.ePrintYn = ePrintYn;
    }

    public String getSplDocId() {
        return splDocId;
    }

    public void setSplDocId(String splDocId) {
        this.splDocId = splDocId;
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

    public String getHideYn() {
        return hideYn;
    }

    public void setHideYn(String hideYn) {
        this.hideYn = hideYn;
    }

    public String getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(String carrierId) {
        this.carrierId = carrierId;
    }

    public String getPassportPrintYn() {
        return passportPrintYn;
    }

    public void setPassportPrintYn(String passportPrintYn) {
        this.passportPrintYn = passportPrintYn;
    }

    public Date getPeriod() {
        return period;
    }

    public void setPeriod(Date period) {
        this.period = period;
    }

    // TODO: uncomment when column is added in the DB
//    public String getDmsRef() {
//        return dmsRef;
//    }
//
//    public void setDmsRef(String dmsRef) {
//        this.dmsRef = dmsRef;
//    }

    public void loadDefaults() {
        this.moduleId = CommonConfig.MODULE_ID_01;
        this.transactionType = CommonConfig.TXN_TYPE_P;
        this.recepType = "C";
        this.printYn = this.regenerateYn = this.ePrintYn = CommonConfig.FLAG_NO;
        this.udptTemplateFor = "PP";
        this.createdDate = this.approvalDate = DateUtil.now();
    }

    public void loadFromCertificatePolicy(PolicyMain certificatePolicy) {
        this.companyId = certificatePolicy.getCompanyId();
        this.transactionRefNo = certificatePolicy.getSgsId();
        this.transactionSRefNo = certificatePolicy.getAmendmentVersionNumber();
        this.createdUser = certificatePolicy.getCreatedUser();
        this.productId = certificatePolicy.getProductId();
        this.approvalUser = certificatePolicy.getApu();
        this.entityId = certificatePolicy.getCustomerId();
    }

    public void loadFromCertificateDetails(CertificateDetails certificateDetails) {
        // TODO: uncomment when column is added in the DB
//        this.dmsRef = certificateDetails.getDocumentPath();
    }

    public void loadFromTemplate(PrintDocumentTemplate template) {
        this.setUdptTemplateId(template);

        this.printDescription = template.getTplName();
        this.displaySeq = template.getDisplaySeq();
        this.udptTemplateDocId = template.getDocumentId();
        this.udptTemplateType = template.getTplType();
        this.templateId = template.getTplId();
        this.mandatoryYn = template.getDefaultRepYn();
        this.opFmt = template.getOpFmt();
    }

    private void setUdptTemplateId(PrintDocumentTemplate template) {
        this.udptTemplateId = template.getTplId() + "_" + this.transactionRefNo + "_" + this.transactionSRefNo;
    }
}

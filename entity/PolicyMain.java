package com.beyontec.mol.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.SequenceGenerator;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.beyontec.mol.config.CommonConfig;
import com.beyontec.mol.config.UdsIdDefConfig;
import com.beyontec.mol.modal.CancelCertificateDTO;
import com.beyontec.mol.modal.ExportCertificateDetails;
import com.beyontec.mol.util.DateUtil;

@Entity
@Table(name = "UPDS_LEVEL_M")
//@formatter:off
@SqlResultSetMappings({
    @SqlResultSetMapping(
                      name = "exportCertificatesRsMapping",
                      classes = @ConstructorResult(
                                                   targetClass = ExportCertificateDetails.class,
                                                   columns = {
                                                              @ColumnResult(name = "CERTIFICATE_NO", type = String.class),
                                                              @ColumnResult(name = "SPONSER_NAME", type = String.class),
                                                              @ColumnResult(name = "LICENSE_NO", type = String.class),
                                                              @ColumnResult(name = "EST_CLASS_ID", type = String.class),
                                                              @ColumnResult(name = "INDUSTRY", type = String.class),
                                                              @ColumnResult(name = "EST_CARD_NO", type = String.class),
                                                              @ColumnResult(name = "FILE_NO", type = String.class),
                                                              @ColumnResult(name = "WORKER_NAME", type = String.class),
                                                              @ColumnResult(name = "DOB", type = Date.class),
                                                              @ColumnResult(name = "GENDER", type = String.class),
                                                              @ColumnResult(name = "NATIONALITY", type = String.class),
                                                              @ColumnResult(name = "COB", type = String.class),
                                                              @ColumnResult(name = "PASSPORT_TYPE", type = String.class),
                                                              @ColumnResult(name = "PASSPORT_NO", type = String.class),
                                                              @ColumnResult(name = "MARITAL_STATUS", type = String.class),
                                                              @ColumnResult(name = "MOHRE_ID", type = String.class),
                                                              @ColumnResult(name = "ENSCO_JOB_ID", type = String.class),
                                                              @ColumnResult(name = "CAT_ID", type = String.class),
                                                              @ColumnResult(name = "LABOR_REF_NO", type = String.class),
                                                              @ColumnResult(name = "FROM_DATE", type = Date.class),
                                                              @ColumnResult(name = "TO_DATE", type = Date.class),
                                                              @ColumnResult(name = "EMIRATES_ID", type = String.class),
                                                              @ColumnResult(name = "APD_DATE", type = Date.class),
                                                              @ColumnResult(name = "PREMIUM", type = BigDecimal.class),
                                                              @ColumnResult(name = "CO_PREMIUM", type = BigDecimal.class)
                                                   })
                      )
})

@NamedStoredProcedureQueries(
  @NamedStoredProcedureQuery(name = "generate_certificate_policy_number",
                             procedureName = "UWP_DIC_DOC_NO_GEN",
                             parameters = {
                                           @StoredProcedureParameter(mode = ParameterMode.IN, name = "P_UDDH_COMP_ID", type = String.class),
                                           @StoredProcedureParameter(mode = ParameterMode.IN, name = "P_UDDH_TYP", type = String.class),
                                           @StoredProcedureParameter(mode = ParameterMode.IN, name = "P_UDDH_PROD_ID", type = String.class),
                                           @StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_DOC_NO", type = String.class),
                                           @StoredProcedureParameter(mode = ParameterMode.IN, name = "P_PARAM_DT_1", type = Date.class),
                             })
  )

@NamedNativeQueries({
    @NamedNativeQuery(
                      name = "getExportCertificates",
                      resultSetMapping = "exportCertificatesRsMapping",
                      query = "SELECT  M.ULM_NO CERTIFICATE_NO, "
                      + "              CERT.ICD_EMPL_NAME SPONSER_NAME, "
                      + "              CERT.ICD_EMPL_LICN_NO LICENSE_NO, "
                      + "              CERT.ICD_EMPL_CLASS_TYP EST_CLASS_ID, "
                      + "              (SELECT UID_DESC FROM UDS_ID_DEFN WHERE UID_ID_TYP = 'EMPL_IND_TYP' AND UID_ID = CERT.ICD_EMPL_INDUST_TYP) INDUSTRY, "
                      + "              CERT.ICD_EMPL_ESTB_CARD_NO EST_CARD_NO, "
                      + "              CERT.ICD_FILE_NO FILE_NO, "
                      + "              CERT.ICD_NAME WORKER_NAME, "
                      + "              CERT.ICD_DOB DOB, "
                      + "              (SELECT UID_DESC FROM UDS_ID_DEFN WHERE UID_ID_TYP = 'GENDER' AND UID_ID = CERT.ICD_GENDER) GENDER, "
                      + "              (SELECT UID_DESC FROM UDS_ID_DEFN WHERE UID_ID_TYP = 'COUNTRY' AND UID_ID = CERT.ICD_NATIONALITY) NATIONALITY, "
                      + "              (SELECT UID_DESC FROM UDS_ID_DEFN WHERE UID_ID_TYP = 'COUNTRY' AND UID_ID = CERT.ICD_COB) COB, "
                      + "              (SELECT UID_DESC FROM UDS_ID_DEFN WHERE UID_ID_TYP = 'PP_TYP' AND UID_ID = CERT.ICD_PP_TYP) PASSPORT_TYPE, "
                      + "              CERT.ICD_PP_NO PASSPORT_NO, "
                      + "              (SELECT UID_DESC FROM UDS_ID_DEFN WHERE UID_ID_TYP = 'MARITAL_STS' AND UID_ID = CERT.ICD_MARITAL_STATUS) MARITAL_STATUS, " 
                      + "              (SELECT UID_DESC FROM UDS_ID_DEFN WHERE UID_ID_TYP = 'JOB_ID_1' AND UID_ID = CERT.ICD_JOB_ID) MOHRE_ID, "
                      + "              (SELECT UID_DESC FROM UDS_ID_DEFN WHERE UID_ID_TYP = 'JOB_ID_2' AND UID_ID = CERT.ICD_JOB_ID_1) ENSCO_JOB_ID, "
                      + "              (SELECT UID_DESC FROM UDS_ID_DEFN WHERE UID_ID_TYP = 'EMP_CATG_TYP' AND UID_ID = CERT.ICD_CATG_ID) CAT_ID, "
                      + "              CERT.ICD_LC_REF_NO LABOR_REF_NO, "
                      + "              M.ULM_FMD FROM_DATE, "
                      + "              M.ULM_TOD TO_DATE, "
                      + "              CERT.ICD_EMIRATES_ID EMIRATES_ID, "
                      + "              M.ULM_APD APD_DATE, "
                      + "              (SELECT SUM(ULCS_TXN_PREM) FROM UHDS_LEVEL_CS WHERE ULCS_ULC_MST_ID = '*' AND ULCS_ULM_SGS_ID = M.ULM_SGS_ID AND ULCS_AMND_VER_NO = M.ULM_AMND_VER_NO) PREMIUM, "
                      + "              NVL ( (SELECT SUM(ULIC_SHARE_PREM_BC) FROM UHDS_LEVEL_IC WHERE ULIC_ULM_SGS_ID = M.ULM_SGS_ID AND ULIC_AMND_VER_NO = M.ULM_AMND_VER_NO), 0 ) CO_PREMIUM "
                      + "      FROM UPDS_LEVEL_M M, IDS_CERT_DTLS CERT "
                      + "      WHERE M.ULM_NO = CERT.ICD_ULM_NO "
                      + "      AND TRUNC(ULM_APD) BETWEEN NVL(TO_DATE(:certCreationFromDate, :dateFormat), TRUNC(ULM_APD)) AND NVL(TO_DATE(:certCreationToDate, :dateFormat), TRUNC(ULM_APD)) "
                      + "      AND (:customerCategoryId IS NULL OR CERT.ICD_CATG_ID = :customerCategoryId) "
                      + "      AND (:certNo IS NULL OR UPPER(M.ULM_NO) LIKE UPPER(concat('%', concat(:certNo, '%')))) "
                      + "      AND (:exportAll IS NULL OR M.ULM_NO NOT IN :deSelectedCert) "
                      + "      AND (:exportAll IS NOT NULL OR M.ULM_NO IN :selectedCert) "
                      )
})
//@formatter:on
@EntityListeners(AuditingEntityListener.class)
public class PolicyMain extends PolicyBase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sgs_id_generator")
    @SequenceGenerator(name = "sgs_id_generator", sequenceName = "SEQ_ULM_SGS_ID", allocationSize = 1)
    @Column(name = "ULM_SGS_ID") private Long sgsId;

    @Column(name = "ULM_AMND_VER_NO") private Long amendmentVersionNumber;

    public Long getSgsId() {
        return sgsId;
    }

    public void setSgsId(Long sgsId) {
        this.sgsId = sgsId;
    }

    public Long getAmendmentVersionNumber() {
        return amendmentVersionNumber;
    }

    public void setAmendmentVersionNumber(Long amendmentVersionNumber) {
        this.amendmentVersionNumber = amendmentVersionNumber;
    }

    public void loadDefaults() {
        loadCommonDefaults();
        this.recordType = CommonConfig.RECORD_TYPE_N;
        this.amendmentVersionNumber = CommonConfig.DEFAULT_VERSION_NUMBER;
    }

    private static final String BTYPE_ID_POLICY = "C";
    private static final String DEFAULT_STATUS = "CTP";
    private static final String DEFAULT_TEMPLATE_TYPE = "D";

    private void loadCommonDefaults() {
        this.type = CommonConfig.BTYPE_POLICY;
        this.bTypeId = BTYPE_ID_POLICY;
        this.status = DEFAULT_STATUS;
        this.itrVersionNumber = CommonConfig.DEFAULT_VERSION_NUMBER;
        this.fltYn = CommonConfig.FLAG_NO;
        this.oseYn = CommonConfig.FLAG_NO;
        this.templateType = DEFAULT_TEMPLATE_TYPE;
        this.approvalDate = DateUtil.now();
        this.createdDate = DateUtil.now();
    }

    public void loadFromMasterPolicy(PolicyHistory masterPolicy) {
        this.companyId = masterPolicy.companyId;
        this.divnId = masterPolicy.divnId;
        this.departmentId = masterPolicy.departmentId;
        this.productId = masterPolicy.productId;
        this.periodUnit = masterPolicy.periodUnit;
        this.premiumCalculationType = masterPolicy.premiumCalculationType;
        this.bSourceId = masterPolicy.bSourceId;
        this.customerId = masterPolicy.customerId;
        this.addressReferenceId = masterPolicy.addressReferenceId;
        this.contactReferenceId = masterPolicy.contactReferenceId;
        this.customerAccountId = masterPolicy.customerAccountId;
        this.periodType = masterPolicy.periodType;
        this.payorId = masterPolicy.payorId;
        this.payorAddressRefId = masterPolicy.payorAddressRefId;
        this.uiInstId = masterPolicy.uiInstId;
        this.payorType = masterPolicy.payorType;
        this.term = masterPolicy.term;
        this.customerType = masterPolicy.customerType;
        this.prmCurr = masterPolicy.prmCurr;
        this.prmCurrId = masterPolicy.prmCurrId;
        this.prmCurrXRate = masterPolicy.prmCurrXRate;
        this.eqType = masterPolicy.eqType;

        this.cName = masterPolicy.cName;
        this.cFirstName = masterPolicy.cFirstName;
        this.cMiddleName = masterPolicy.cMiddleName;
        this.cLastName = masterPolicy.cLastName;
        this.cAddress1 = masterPolicy.cAddress1;
        this.cAddress2 = masterPolicy.cAddress2;
        this.cAddress3 = masterPolicy.cAddress3;
        this.cAddress4 = masterPolicy.cAddress4;
        this.cPinCode = masterPolicy.cPinCode;
        this.cCity = masterPolicy.cCity;
        this.cState = masterPolicy.cState;
        this.cCountry = masterPolicy.cCountry;

        this.prefixName = masterPolicy.prefixName;
        this.prefixNameBl = masterPolicy.prefixNameBl;

        this.cNameBl = masterPolicy.cNameBl;
        this.cFirstNameBl = masterPolicy.cFirstNameBl;
        this.cLastNameBl = masterPolicy.cLastNameBl;

        this.cpyPhoneNumber = masterPolicy.cpyPhoneNumber;
        this.cpyMobileNumber = masterPolicy.cpyMobileNumber;
        this.cFaxNumber = masterPolicy.cFaxNumber;
        this.cpyEmailId = masterPolicy.cpyEmailId;

        this.siCurr = masterPolicy.siCurr;
        this.siCurrId = masterPolicy.siCurrId;
        this.siXRate = masterPolicy.siXRate;

        this.mstRefNumber = masterPolicy.number;
        this.mstRefSgsId = masterPolicy.getSgsId();
        this.mstRefAmendmentVersionNumber = masterPolicy.getAmendmentVersionNumber();
    }

    private static final String SUFFIX_ITR_NO = "/0";
    public void loadFromCertificateDetails(CertificateDetails certificateDetails) {
        this.issuedDate = certificateDetails.getReqInDate();
        this.fromDate = certificateDetails.getVisaApprovalDate();
        this.toDate = certificateDetails.getVisaExpirationDate();
        this.expiryDate = certificateDetails.getExpiryDate();
        this.period = certificateDetails.getVisaPeriod();
        this.polType = certificateDetails.getRequestType();

        this.number = this.level2Number = certificateDetails.getCertificateNumber();
        this.level2ItrNumber = this.itrNumber = certificateDetails.getCertificateNumber() + SUFFIX_ITR_NO;
        this.globalEndNumber = certificateDetails.getLabourReferenceNo();
    }

    public void loadFromCustomerDetails(CustomerDetailsMain customerDetails) {
        this.insuredId = String.valueOf(customerDetails.getId());
        this.insuredName = customerDetails.getName();
    }

    public void loadFromUdsIdDefinition() {
        String defaultCreatedUser = UdsIdDefConfig.getUdsIdDefinitionValue(UdsIdDefConfig.ID_TYPE_DEFAULT_DATA,
                                                                           UdsIdDefConfig.ID_DEFAULT_CREATED_USER);
        this.createdUser = defaultCreatedUser;
        this.apu = defaultCreatedUser;
    }

    public void loadFromPrevPolicy(PolicyMain prevCertificatePolicy) {
        if (prevCertificatePolicy == null) {
            return;
        }

        this.renPolNumber = prevCertificatePolicy.number;
        this.renOrgSgsId = prevCertificatePolicy.getSgsId();
        this.renSequenceNumber = prevCertificatePolicy.getRenSequenceNumber() + 1;
    }

    public void loadFromProductAppBusType(ProductAppBusType productAppBusType) {
        this.templateId = productAppBusType.getSgsId();
    }

    public void amendNumbers(String amendNo, String level3No) {
        setAmendmentNumber(amendNo);
        setLevel3Number(level3No);
    }

    public void amendVersionNumbers() {
        setSrcAmendmentVersionNumber(getAmendmentVersionNumber());
        this.amendmentVersionNumber += 1;
    }

    public void amendDates(Date amendFromDate) {
        setAmendmentFromDate(amendFromDate);

        Date oldToDate = getToDate();
        setAmendmentToDate(oldToDate);
        setOrgToDate(oldToDate);

        Date latestToDate = DateUtil.addDays(amendFromDate, -1);
        setToDate(latestToDate);
        setExpiryDate(latestToDate);
        setEqtyDate(latestToDate);
    }

    public void amendEndorsementDefn(EndorsementDefinition endorsementDefinition) {
        setAmendmentType(endorsementDefinition.getTypeId());
        setAmendmentSubType(endorsementDefinition.getsTypeId());
        setAmendmentReason(endorsementDefinition.getReasonId());
    }

    public void amendCancellation(CancelCertificateDTO cancelCertificateDetails,
                                  EndorsementDefinition endorsementDefn) {
        setCancelDate(cancelCertificateDetails.getCancelledDate());
        setCanPayee(getCustomerId());
        setCancelPcType(endorsementDefn.getPremiumCalcType());
    }
}

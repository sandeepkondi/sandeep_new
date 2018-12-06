package com.beyontec.mol.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.beyontec.mol.config.CommonConfig;
import com.beyontec.mol.entity.CertificateDetails;
import com.beyontec.mol.modal.CertificateExportCriteria;
import com.beyontec.mol.modal.CertificateListingDTO;
import com.beyontec.mol.modal.CertificateSearchCriteria;
import com.beyontec.mol.modal.PaginatedRequest;
import com.beyontec.mol.util.CustomDateSerializer;
import com.beyontec.mol.util.DateUtil;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

@Repository
public class CertificateDAO {

    @PersistenceContext protected EntityManager entityManager;
    @Value("${date.format}") private String dateFormat;

    @SuppressWarnings("unchecked")
    public List<CertificateListingDTO> searchCertificate(CertificateSearchCriteria certificateSearchCriteria,
                                                PaginatedRequest paginatedRequest) {

        String selectQuery = getCertificateSearchQuery().append(generateCloseQuery(certificateSearchCriteria))
                                                 .toString();
        Query query = entityManager.createNativeQuery(selectQuery);

        setQueryParameters(query, certificateSearchCriteria);
        query.setFirstResult((paginatedRequest.getOffset()) * paginatedRequest.getLimit());
        query.setMaxResults(paginatedRequest.getLimit());

        List<Object[]> certificateDetails = query.getResultList();
        return generateCertificateListingDTO(certificateDetails);
    }

    public long getCertificateCount(CertificateSearchCriteria certificateSearchCriteria) {

        String selectQuery = getCertificateSearchQuery().append(generateCloseQuery(certificateSearchCriteria))
                                                        .toString();
        Query query = entityManager.createNativeQuery(selectQuery);
        setQueryParameters(query, certificateSearchCriteria);
        return query.getResultList().size();
    }

    private void setQueryParameters(Query query, CertificateSearchCriteria certificateSearchCriteria) {

        if (!StringUtils.isEmpty(certificateSearchCriteria.getCustomerCategoryId())) {
            query.setParameter("customerCategoryId", certificateSearchCriteria.getCustomerCategoryId());
        }
    }

    private List<CertificateListingDTO> generateCertificateListingDTO(List<Object[]> results) {

        List<CertificateDetails> certificateDetails = new ArrayList<>();
        List<CertificateListingDTO> certificateListingDTO = new ArrayList<>();
        for (Object[] obj : results) {
            CertificateDetails certificateDetail = new CertificateDetails();
            certificateDetail.setCertificateNumber((String) obj[0]);
            certificateDetail.setEmployerNameEn((String) obj[1]);
            certificateDetail.setWorkerNameEn((String) obj[2]);
            certificateDetail.setLabourReferenceNo((String) obj[3]);
            certificateDetail.setEmployeeCategory((String) obj[4]);
            certificateDetail.setVisaApprovalDate((Date) obj[5]);
            certificateDetail.setVisaExpirationDate((Date) obj[6]);
            certificateDetails.add(certificateDetail);
            ObjectMapper oMapper = new ObjectMapper();
            oMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            SimpleModule module = new SimpleModule();
            module.addSerializer(Date.class, new CustomDateSerializer(dateFormat));
            oMapper.registerModule(module);
            CertificateListingDTO certificateDTO = oMapper.convertValue(certificateDetail,
                                                                        CertificateListingDTO.class);
            certificateListingDTO.add(certificateDTO);
        }
        return certificateListingDTO;
    }

    private StringBuffer getCertificateSearchQuery() {

        return new StringBuffer()

                                 .append("SELECT M.ULM_NO certificateNumber, \n")
                                 .append("       CERT.ICD_EMPL_NAME sponsorName, \n")
                                 .append("       CERT.ICD_NAME employeeName, \n")
                                 .append("       CERT.ICD_LC_REF_NO labourNumber, \n")
                                 .append("       (SELECT UID_DESC FROM UDS_ID_DEFN WHERE UID_ID_TYP = 'EMP_CATG_TYP' AND UID_ID = CERT.ICD_CATG_ID) workerType, \n")
                                 .append("       M.ULM_FMD visaFromDate, \n")
                                 .append("       M.ULM_TOD visaToDate \n")
                                 .append("FROM UPDS_LEVEL_M M, IDS_CERT_DTLS CERT \n")
                                 .append("WHERE CERT.ICD_ULM_NO = M.ULM_NO");

    }

    private StringBuffer generateCloseQuery(CertificateSearchCriteria certificateSearchCriteria) {

        StringBuffer closeQuery = new StringBuffer();
        if (null != certificateSearchCriteria.getCertificateCreationFromDate()) {
            closeQuery.append(" AND TRUNC(M.ULM_APD) >= NVL(TO_DATE('"
                              + DateUtil.toString(certificateSearchCriteria.getCertificateCreationFromDate())
                              + "',  '"
                              + CommonConfig.DATE_FORMAT.toPattern()
                              + "'), TRUNC(M.ULM_APD))");
        } else {
            closeQuery.append(" AND TRUNC(M.ULM_APD) >= NVL(TO_DATE('"
                              + DateUtil.toString(new Date())
                              + "',  '"
                              + CommonConfig.DATE_FORMAT.toPattern()
                              + "'), TRUNC(M.ULM_APD))");
        }

        if (null != certificateSearchCriteria.getCertificationCreationToDate()) {
            closeQuery.append(" AND TRUNC(M.ULM_APD) <= NVL(TO_DATE('"
                              + DateUtil.toString(certificateSearchCriteria.getCertificationCreationToDate())
                              + "',  '"
                              + CommonConfig.DATE_FORMAT.toPattern()
                              + "'), TRUNC(M.ULM_APD))");
        } else {
            closeQuery.append(" AND TRUNC(M.ULM_APD) <= NVL(TO_DATE('"
                              + DateUtil.toString(new Date())
                              + "',  '"
                              + CommonConfig.DATE_FORMAT.toPattern()
                              + "'), TRUNC(M.ULM_APD))");
        }

        if (!StringUtils.isEmpty(certificateSearchCriteria.getCertificateNo())) {
            closeQuery.append(" AND UPPER(M.ULM_NO) LIKE UPPER('%"
                              + certificateSearchCriteria.getCertificateNo()
                              + "%')");
        }

        if (!StringUtils.isEmpty(certificateSearchCriteria.getCustomerCategoryId())) {
            closeQuery.append(" AND CERT.ICD_CATG_ID = :customerCategoryId");
        }

        return closeQuery;
    }

    @SuppressWarnings("unchecked")
    public List<Object[]> searchCertificate(CertificateExportCriteria certificateExportCriteria) {

        StringBuffer selectQuery = getExportCertificateQuery();
        if (!certificateExportCriteria.isExportAll() && null != certificateExportCriteria.getCertificateNumbers()) {
            selectQuery.append(" AND M.ULM_NO IN :selectCertificates");
            String exportCertificateQuery = selectQuery.toString();
            Query query = entityManager.createNativeQuery(exportCertificateQuery);
            query.setParameter("selectCertificates", certificateExportCriteria.getCertificateNumbers());
            List<Object[]> certificateDetails = query.getResultList();
            return certificateDetails;
        }

        if (!CollectionUtils.isEmpty(certificateExportCriteria.getDeSelectedCertificateNumbers())) {
            selectQuery.append(" AND M.ULM_NO NOT IN :deSelectCertificates");
        }
        String exportCertificateQuery = selectQuery.append(generateCloseQuery(certificateExportCriteria.getSearchCriteria()))
                                                   .toString();
        Query query = entityManager.createNativeQuery(exportCertificateQuery);
        if (!CollectionUtils.isEmpty(certificateExportCriteria.getDeSelectedCertificateNumbers())) {
            query.setParameter("deSelectCertificates", certificateExportCriteria.getDeSelectedCertificateNumbers());
        }
        setQueryParameters(query, certificateExportCriteria.getSearchCriteria());
        List<Object[]> certificateDetails = query.getResultList();
        return certificateDetails;
    }

    private StringBuffer getExportCertificateQuery() {

        return new StringBuffer()

                                 .append("SELECT M.ULM_NO CERTIFICATENO, \n")
                                 .append("       CERT.ICD_EMPL_NAME SPONSERNAME, \n")
                                 .append("       CERT.ICD_EMPL_LICN_NO LICENSENO, \n")
                                 .append("       CERT.ICD_EMPL_CLASS_TYP EST_CLASS_ID, \n")
                                 .append("       (SELECT UID_DESC FROM UDS_ID_DEFN WHERE UID_ID_TYP = 'EMPL_IND_TYP' AND UID_ID = CERT.ICD_EMPL_INDUST_TYP) INDUSTRY, \n")
                                 .append("       CERT.ICD_EMPL_ESTB_CARD_NO EST_CARD_NO, \n")
                                 .append("       CERT.ICD_FILE_NO FILE_NO, \n")
                                 .append("       CERT.ICD_NAME WORKER_NAME, \n")
                                 .append("       CERT.ICD_DOB DOB, \n")
                                 .append("       (SELECT UID_DESC FROM UDS_ID_DEFN WHERE UID_ID_TYP = 'GENDER' AND UID_ID = CERT.ICD_GENDER) GENDER, \n")
                                 .append("       (SELECT UID_DESC FROM UDS_ID_DEFN WHERE UID_ID_TYP = 'COUNTRY' AND UID_ID = CERT.ICD_NATIONALITY) NATIONALITY, \n")
                                 .append("       (SELECT UID_DESC FROM UDS_ID_DEFN WHERE UID_ID_TYP = 'COUNTRY' AND UID_ID = CERT.ICD_COB) COB, \n")
                                 .append("       (SELECT UID_DESC FROM UDS_ID_DEFN WHERE UID_ID_TYP = 'PP_TYP' AND UID_ID = CERT.ICD_PP_TYP) PASSPORT_TYPE, \n")
                                 .append("       CERT.ICD_PP_NO PASSPORT_NO, \n")
                                 .append("       (SELECT UID_DESC FROM UDS_ID_DEFN WHERE UID_ID_TYP = 'MARITAL_STS' AND UID_ID = CERT.ICD_MARITAL_STATUS) MARITAL_STATUS, \n")
                                 .append("       (SELECT UID_DESC FROM UDS_ID_DEFN WHERE UID_ID_TYP = 'JOB_ID_1' AND UID_ID = CERT.ICD_JOB_ID) MOHRE_ID, \n")
                                 .append("       (SELECT UID_DESC FROM UDS_ID_DEFN WHERE UID_ID_TYP = 'JOB_ID_2' AND UID_ID = CERT.ICD_JOB_ID_1) ENSCO_JOB_ID, \n")
                                 .append("       (SELECT UID_DESC FROM UDS_ID_DEFN WHERE UID_ID_TYP = 'EMP_CATG_TYP' AND UID_ID = CERT.ICD_CATG_ID) CAT_ID, \n")
                                 .append("       CERT.ICD_LC_REF_NO LABOR_REF_NO, \n")
                                 .append("       M.ULM_FMD FROM_DATE, \n")
                                 .append("       M.ULM_TOD TO_DATE, \n")
                                 .append("       CERT.ICD_EMIRATES_ID EMIRATES_ID, \n")
                                 .append("       M.ULM_APD APD_DATE, \n")
                                 .append("       (SELECT SUM(ULCS_TXN_PREM) FROM UHDS_LEVEL_CS WHERE ULCS_ULC_MST_ID = '*' AND ULCS_ULM_SGS_ID = M.ULM_SGS_ID AND ULCS_AMND_VER_NO = M.ULM_AMND_VER_NO) PREMIUM, \n")
                                 .append("       NVL ( (SELECT SUM(ULIC_SHARE_PREM_BC) FROM UHDS_LEVEL_IC WHERE ULIC_ULM_SGS_ID = M.ULM_SGS_ID AND ULIC_AMND_VER_NO = M.ULM_AMND_VER_NO), 0 ) CO_PREMIUM \n")
                                 .append("FROM UPDS_LEVEL_M M, IDS_CERT_DTLS CERT \n")
                                 .append("WHERE M.ULM_NO = CERT.ICD_ULM_NO");

    }
}

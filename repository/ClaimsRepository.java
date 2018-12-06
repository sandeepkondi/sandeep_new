package com.beyontec.mol.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.beyontec.mol.entity.Claim;

@Repository
public interface ClaimsRepository extends JpaRepository<Claim, Long> {

    List<Claim> findAllByClaimLossDateBetween(Date fromDate, Date toDate, Pageable pageable);

    Claim findByComplaintNumber(String ids);

    Claim findByComplaintNumberAndErrorType(String id, String errorType);

    Claim findByEmiratesId(String emiratedId);

    @Query(value = "select UID_ID from uds_id_defn where uid_id_typ='CL_REP_BY'", nativeQuery = true)
    public String getReportedBy();

    @Query(value = "SELECT UID_ID,UID_DESC FROM uds_id_defn WHERE UID_ID_TYP='STATUS' AND UID_MODULE_TYP='02'", nativeQuery = true)
    public List<Object[]> getClfStatus();

    @Query(value = "SELECT UID_ID,UID_DESC FROM uds_id_defn WHERE UID_ID_TYP='CL_REP_MTD'", nativeQuery = true)
    public List<Object[]> getClfRepMthd();

    @Query(value = "SELECT UID_ID,UID_DESC FROM uds_id_defn WHERE UID_ID_TYP='CL_REP_BY'", nativeQuery = true)
    public List<String> getClfRepBy();

    @Query(value = "select uc_comp_id from uds_company", nativeQuery = true)
    public String getCompanyId();

    @Query(value = "SELECT UID_VALUE FROM UDS_ID_DEFN WHERE UID_COMP_ID =?1 AND UID_ID_TYP = 'DFLT_DATA' AND UID_ID = 'CLF_CRU'", nativeQuery = true)
    public String getCreatedUser(String companyId);

    @Query(value = "SELECT UID_VALUE FROM UDS_ID_DEFN WHERE UID_COMP_ID =?1 AND UID_ID_TYP = 'DFLT_DATA' AND UID_ID = 'CLCP_CRU'", nativeQuery = true)
    public String getCreatedUserForCtdsLevelC(String companyId);

    @Query(value = "SELECT UID_VALUE FROM UDS_ID_DEFN WHERE UID_COMP_ID =?1 AND UID_ID_TYP = 'DFLT_DATA' AND UID_ID = 'CLCP_CRU'", nativeQuery = true)
    public String getCreatedUserForctdsLevelCp(String companyId);

    @Query(value = "SELECT UID_LONG_DESC FROM uds_id_defn WHERE UID_ID_TYP='ICAD_PATH'", nativeQuery = true)
    public String getDocumentPath();

    @Query(value = "SELECT UID_ID,UID_DESC FROM uds_id_defn WHERE UID_ID_TYP='ICAD_TYP'", nativeQuery = true)
    public List<Object[]> getIcadTyp();

    @Query(value = "SELECT UDD_UD_DIVN_ID,UDD_DEPT_DISP_NAME FROM UDS_DEPT_DTL WHERE UDD_UC_COMP_ID=?1", nativeQuery = true)
    public List<Object[]> getDepartmentDetails(String companyId);

    @Query(value = "SELECT UD_DIVN_ID,UD_DIVN_DISP_NAME FROM UDS_DIVISION WHERE UD_UC_COMP_ID=?1", nativeQuery = true)
    public List<Object[]> getDivisionDetails(String companyId);

    @Query(value = "SELECT UID_ID,UID_DESC from uds_id_defn where uid_id_typ='STATUS' AND UID_MODULE_TYP='02'", nativeQuery = true)
    public List<Object[]> getStatusDetails();

    @Query(value = "SELECT UPR_RISK_TYP_ID,UPR_RISK_TYP_NAME FROM UDS_PROD_RISK", nativeQuery = true)
    public List<Object[]> getWorkerTypes();

    @Query(value = "SELECT ULM_INSRD_ID,(SELECT UCD_NAME FROM UDS_CUSTOMER_DTLS WHERE UCD_ID = ULM_INSRD_ID) SPONSOR " + 
    		"FROM UPDS_LEVEL_M WHERE ULM_INSRD_ID IS NOT NULL", nativeQuery = true)
    public List<Object[]> getSponsorTypes();
    
    @Query(value = "select uid_id from uds_id_defn where uid_id_typ ='CED_CLM_PAY_TYP' and UID_ID=?1", nativeQuery = true)
    public String getPayeeType(String payeeType);
    
    @Query(value = "select count(*) from uds_id_defn where uid_id_typ='LOSS_TYP' and UID_ID=?1", nativeQuery = true)
    public int getPaymentType(String payementType);
    
    @Query(value = "SELECT UCD_NAME, UCD_IDENTIFICATION_ID1, UCD_IDENTIFICATION_ID2, UCD_IND_TYP FROM UDS_CUSTOMER_DTLS WHERE UCD_ID =?1", nativeQuery = true)
    public List<Object[]> getUdsCustomer(String insuredId);
    
    @Query(value = "SELECT UID_DESC FROM UDS_ID_DEFN where UID_ID = ?1 and uid_id_typ='LOSS_TYP'", nativeQuery = true)
    public String getDescription(String id);
    
    @Query(value = "SELECT ULRMB_EMIRATES_ID, ULRMB_NAME, ULRMB_DOB, ULRMB_GENDER ,  ULRMB_PASSPORT,ULRMB_CATG, ULRMB_DESIG, ULRMB_LC_REF_NO FROM UHDS_LEVEL_RMBR WHERE ULRMB_EMIRATES_ID =?1 ", nativeQuery = true)
    public List<Object[]> getWorkerInformation(String emiratesId);
    
    @Query(value = "SELECT CLS_PAY_AMT FROM CTDS_LEVEL_S WHERE CLS_CLF_SGS_ID=?1 AND  CLS_SR_NO = (select MAX(CLS_SR_NO) from CTDS_LEVEL_S WHERE CLS_CLF_SGS_ID=?1)", nativeQuery = true)
    public Double getSettledAmount(Long fnolSgsId);
    
    @Query(value = "SELECT ILM_POL_FMD, ILM_POL_TOD FROM IDS_LEVEL_M WHERE ILM_NO=?1", nativeQuery = true)
    public List<Object[]> getPolicyDates(String certificateNo);

    @Query(value = "select count(*) from ids_level_m where ILM_NO=?1", nativeQuery = true)
    public int getPolicyCount(String certificateNo);
    
    @Query(value = "SELECT CLR_RISK_FLEX1 FROM CTDS_LEVEL_R WHERE CLR_CLF_SGS_ID=?1", nativeQuery = true)
    public String getEmiratesId(Long fnolSgsId);
    
    
    @Query(value = "SELECT ILM_MPOL_NO FROM IDS_LEVEL_M WHERE ILM_NO=?1", nativeQuery = true)
    public String getMasterPolicyNo(String certificateNo);
    
    @Query(value = "SELECT AU_AUG_ID FROM ADS_USER WHERE AU_LOGIN_ID=?1", nativeQuery = true)
    public String getUserGroupId(String loginId);
    
    @Query(value = "select au_id from ads_user where AU_LOGIN_ID=?1", nativeQuery = true)
    public String getAuId(String loginId);
    
    @Query(value = "select UCD_NAME FROM UDS_CUSTOMER_DTLS  WHERE UCD_ID=?1", nativeQuery = true)
    public String getPayeeName(int customerId);
    
    @Query(value = "SELECT UID_DESC FROM UDS_ID_DEFN WHERE UID_ID =?1 AND UID_ID_TYP='STATUS'", nativeQuery = true)
    public String getClaimStatusDesc(String status);
    
    @Query(value = "SELECT UID_DESC FROM UDS_ID_DEFN WHERE UID_UP_PROD_ID=?1", nativeQuery = true)
    public String getProductName();
    
    @Query(value = "SELECT ULRMB_EMIRATES_ID, ULRMB_LC_REF_NO, ULRMB_NAME, ULRMB_DOB, ULRMB_GENDER , ULRMB_PASSPORT, ULRMB_CATG, ULRMB_DESIG FROM UpDS_LEVEL_RMBR RMBR , upds_level_M WHERE ULRMB_ULM_SGS_ID =ulm_sgs_id AND ULRMB_AMND_VER_NO =ulm_AMND_VER_NO AND ulm_no =?1", nativeQuery = true)
    public List<Object[]> getWorkerInfo(String certificateNo);
    
    @Query(value = "SELECT UID_DESC FROM UDS_ID_DEFN WHERE UID_ID_TYP='GENDER' AND UID_ID=?1", nativeQuery = true)
    public String getGender(String uidId);
    
    @Query(value = "SELECT UID_DESC FROM UDS_ID_DEFN WHERE UID_ID_TYP='EMP_CATG_TYP' AND UID_ID=?1", nativeQuery = true)
    public String getEmployeeCategory(String uidId);
    
    @Query(value = "SELECT ULM_STATUS FROM UPDS_LEVEL_M WHERE ULM_NO=?1", nativeQuery = true)
    public String getCertificateStatus(String certificateNo);
    
    @Query(value = "select UP_PROD_NAME FROM UDS_PRODUCT WHERE UP_PROD_ID=?1", nativeQuery = true)
    public String getProductNameDesc(int productId);
    
    @Query(value = "SELECT UID_DESC FROM UDS_ID_DEFN WHERE UID_ID_TYP='JOB_ID_1' AND UID_ID=?1", nativeQuery = true)
    public String getDesignationDesc(String uidId);
    
    @Query(value = "select UID_DESC from uds_id_defn where uid_id_typ='DFLT_DATA' and UID_ID='CLC_CRU'", nativeQuery = true)
    public String getPaymentRequestedPerson();
    
    @Query(value = "select UID_ID from uds_id_defn where uid_id_typ='LOSS_TYP' and UID_DESC=?1", nativeQuery = true)
    public List<String> getLossId(String paymentType);
    
    @Query(value = "select ILR_FLEX1 from ids_level_R WHERE ILR_ILM_NO=?1", nativeQuery = true)
    public String getCustomerName(String certificateNo);
    
    @Query(value = "select uid_value from uds_id_defn where uid_id=?1", nativeQuery = true)
    public String getLossType(String paymentType);

    @Query(value = "select uid_desc from uds_id_defn where uid_id = :coverId", nativeQuery = true)
    public String getCoverDesc(@Param("coverId") String coverId);

    @Query(value = "SELECT CLF_PROD_ID FROM CTDS_LEVEL_FNOL WHERE CLF_SGS_ID = :fnolSgsId", nativeQuery = true)
    public String getProductId(@Param("fnolSgsId") Long fnolSgsId);
}

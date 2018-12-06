package com.beyontec.mol.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.beyontec.mol.entity.ClaimTransactionFNOL;

@Repository
public interface ClaimFnolDetailsRepository extends JpaRepository<ClaimTransactionFNOL, Long> {

    ClaimTransactionFNOL findByFnolRefNo(String claimNo);

    ClaimTransactionFNOL findByClaimNo(String claimNo);

    @Query(value = "SELECT UID_VALUE FROM UDS_ID_DEFN WHERE UID_COMP_ID = ? AND UID_ID_TYP = 'DFLT_DATA' AND UID_ID = 'DFLT_CLC_CRU'", nativeQuery = true)
    public String getCreatedUser(String compantId);
    
    @Query(value = "select clf_insrd_id FROM ctds_level_fnol WHERE CLf_sgs_id =?1", nativeQuery = true)
    public String getInsuredId(Long clfSgsId);
    
    @Query(value = "SELECT UCD_NAME FROM UDS_CUSTOMER_DTLS WHERE UCD_ID =?1", nativeQuery = true)
    public String getSponsorName(int insuredId);
    
    @Query(value = "SELECT CLF_LOSS_DESC FROM CTDS_LEVEL_FNOL where CLF_REFNO = ?1", nativeQuery = true)
    public String getClaimDescription(String claimNo);
    
    @Query(value = "SELECT CLC_NO FROM CTDS_LEVEL_C WHERE CLC_ULM_NO =?1 AND EXISTS (SELECT 1 FROM CTDS_LEVEL_C B WHERE B.CLC_ULM_NO=CLC_ULM_NO AND B.CLC_NO=CLC_NO ) AND CLC_NO NOT IN ?2", nativeQuery = true)
    public List<String> getPriorClaimNo(String certificateNo, String claimNo);
    
    @Query(value = "SELECT SUM(CLS_PAY_AMT) FROM CTDS_LEVEL_S , CTDS_LEVEL_C A WHERE CLS_CLF_SGS_ID=A.CLC_CLF_SGS_ID AND A.CLC_ULM_NO=?1 AND EXISTS (SELECT 1 FROM CTDS_LEVEL_C B WHERE B.CLC_CLF_SGS_ID=CLC_CLF_SGS_ID ) AND CLC_NO NOT IN ?2", nativeQuery = true)
    public List<BigDecimal> getPaidAmount(String certificateNo, String claimNo);
    
    @Query(value = "SELECT CLC_STATUS FROM CTDS_LEVEL_C WHERE CLC_ULM_NO =?1 AND EXISTS (SELECT 1 FROM CTDS_LEVEL_C B WHERE B.CLC_ULM_NO=CLC_ULM_NO AND B.CLC_NO=CLC_NO ) AND CLC_NO NOT IN ?2", nativeQuery = true)
    public List<String> getStatus(String certificateNo, String claimNo);
    
    @Query(value = "SELECT CLF_ULM_NO FROM CTDS_LEVEL_FNOL WHERE CLF_SGS_ID = ?1", nativeQuery = true)
    
    public String getCertificateNo(Long fnolSgsId);

    @Query(value = "SELECT CLF_SGS_ID FROM CTDS_LEVEL_FNOL where CLF_CLC_NO = ?1", nativeQuery = true)
    public Long getFnolSgsId(String claimNo);
    
    @Query(value = "SELECT CLF_POL_FMD,CLF_POL_TOD FROM CTDS_LEVEL_FNOL WHERE CLF_SGS_ID = ?1", nativeQuery = true)
    public List<Object[]> getPolicyFromAndToDate(Long fnolSgsId);

}

package com.beyontec.mol.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.beyontec.mol.entity.ClaimWorkingEstimation;

@Repository
public interface ClaimWorkingDetailsRepository extends JpaRepository<ClaimWorkingEstimation, Long>{
    
    @Query(value = "SELECT CED_EST_TYP, CED_ULC_ID, CED_ULS_ID, CED_LOSS_ID, CED_DFLT_RATE FROM CUDS_EST_DEFN WHERE CED_PROD_ID= (SELECT CLF_PROD_ID FROM CTDS_LEVEL_FNOL WHERE CLF_SGS_ID =?1) AND CED_RISK_TYP=(SELECT CLR_RISK_TYP FROM CTDS_LEVEL_R WHERE CLR_CLF_SGS_ID =?2) AND (CED_EST_TYP=?3 OR CED_EST_TYP='C') AND CED_LOSS_ID =?4", nativeQuery = true)
    public List<Object[]> getCUDS_EST_DEFNData(Long fnolSgsId, Long riskfnolSgsId, String payeeType, String lossType);

    ClaimWorkingEstimation findByFnolSgsId(Long fnolSgsId);
    
    @Query(value = "SELECT MAX(CLE_SR_NO) from CTDS_LEVEL_E WHERE CLE_CLF_SGS_ID = ?1", nativeQuery = true)
    public int getLatestSerialRevisionNo(long fnolSgsId);
    
    public ClaimWorkingEstimation findByFnolSgsIdAndRevisionSerialNo(long fnolSgsId, int serialNo);
    
    @Query(value = "select count(*) from wtds_level_a where WLA_TXNU=?1 AND WLA_TXN_REF_NO = ?3 and  WLA_MODULE=02 and WLA_TXN_AUG_ID=?2 and WLA_ACT_ID=(SELECT UID_ID FROM UDS_ID_DEFN WHERE UID_ID_TYP = 'WB_ACT_TYP' AND UID_MODULE_TYP =02 AND UID_DESC = 'Settlement Request Review')", nativeQuery = true)
    public int getReviewUserCount(String loginAU_ID, String userGroupId, String claimNo);
    
    @Query(value = "select count(*) from wtds_level_a where WLA_TXNU=?1 AND WLA_TXN_REF_NO = ?3 and WLA_MODULE=02 and WLA_TXN_AUG_ID=?2 and WLA_ACT_ID=(SELECT UID_ID FROM UDS_ID_DEFN WHERE UID_ID_TYP = 'WB_ACT_TYP' AND UID_MODULE_TYP =02 AND UID_DESC = 'Settlement Request Approval')", nativeQuery = true)
    public int getApproverUserCount(String loginAU_ID, String userGroupId, String claimNo);

}

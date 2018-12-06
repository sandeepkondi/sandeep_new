package com.beyontec.mol.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.beyontec.mol.entity.ClaimTransactionSettlement;
import com.beyontec.mol.modal.PaymentReviewAndApproveUser;

@Repository
public interface ClaimTransactionSettlementRepository extends JpaRepository<ClaimTransactionSettlement, Long> {

    @Query(value = "select * from ctds_level_s where CLS_CLF_SGS_ID = ?1 and CLS_SR_NO = (select max(CLS_SR_NO) from ctds_level_s where CLS_CLF_SGS_ID = ?1)", nativeQuery = true)
    ClaimTransactionSettlement findByFnolSgsId(Long fnolSgsId);

    @Query(value = "select CED_ULC_ID from CUDS_EST_DEFN where CED_EST_TYP_DESC = ?1", nativeQuery = true)
    public int getCoverIdByCoverDesc(String coverDesc);
    
    @Query(value = "SELECT UID_VALUE FROM UDS_ID_DEFN WHERE UID_COMP_ID = ?1 AND UID_ID_TYP = 'DFLT_DATA' AND UID_ID = 'CLE_CRU'", nativeQuery = true)
    public String getCreatedUser(String companyId);
    

    @Query(name = "getAssignedUser", nativeQuery = true)
    public PaymentReviewAndApproveUser getAssignedUser(@Param("amount") Double amount,
                                                     @Param("userId") String userId,
                                                     @Param("coverId") String coverId,
                                                     @Param("productId") String productId,
                                                     @Param("escalationType") String escalationType);

    @Query(value = "SELECT (SELECT AU_AUG_ID FROM ADS_USER WHERE AU_ID = CEUE_ESCAL_AU_ID AND AU_COMP_ID = CEUE_COMP_ID) "
                   + "FROM CUDS_EST_USR_ESCALATION "
                   + "WHERE CEUE_TYP = 'P' "
                   + "AND CEUE_ESCAL_AU_ID = :approveUserId "
                   + "AND CEUE_ESCAL_TYP = 'A' "
                   + "AND :amount BETWEEN CEUE_ESCAL_AMT_FM AND "
                   + "CEUE_ESCAL_AMT_TO AND (CEUE_AU_ID, CEUE_AUG_ID) IN (SELECT AU_ID , AU_AUG_ID FROM ADS_USER WHERE AU_ID = :createdUserId) "
                   + "AND CEUE_CVR_ID =:coverId "
                   + "AND (CEUE_COB_ID, CEUE_PROD_ID) IN (SELECT UPAC_UC_COB_ID, UPAC_UP_PROD_ID FROM UDS_PROD_APPL_COB WHERE UPAC_UP_PROD_ID = :productId AND UPAC_COMP_ID = CEUE_COMP_ID) "
                   + "AND CEUE_PROD_ID = :productId", nativeQuery = true)
    public String getAssignApproveUserGroupId(@Param("amount") Double amount,
                                                    @Param("createdUserId") String createdUserId,
                                                    @Param("approveUserId") String approveUserId,
                                                    @Param("coverId") String coverId,
                                                    @Param("productId") String productId);

    @Query(value = "SELECT CLS_PAY_AMT, CLS_OS_AMT, CLS_APPRV_FLAG, CLS_RVD FROM CTDS_LEVEL_S WHERE CLS_CLF_SGS_ID=?1 AND CLS_SR_NO=(select MAX(CLS_SR_NO) from CTDS_LEVEL_S WHERE CLS_CLF_SGS_ID=?1)", nativeQuery = true)
    public List<Object[]> getPaymentDetails(Long fnolSgsID);
     
    @Query(value = "select UID_ID from UDS_ID_DEFN where UID_ID_TYP = 'WB_ACT_TYP' AND UID_SHORT_DESC='Settlement Request Review' AND UID_MODULE_TYP=02", nativeQuery = true)
    public String getReviewerActivityId();
    
    @Query(value = "select UID_ID from UDS_ID_DEFN where UID_ID_TYP = 'WB_ACT_TYP' AND UID_SHORT_DESC='Settlement Request Approval' AND UID_MODULE_TYP=02", nativeQuery = true)
    public String getApproverActivityId();
    
    @Query(value = "select AU_ID FROM ADS_USER WHERE AU_LOGIN_ID=?1", nativeQuery = true)
    public String getReviewerId(String loginId);
    
    
}

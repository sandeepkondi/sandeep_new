package com.beyontec.mol.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.beyontec.mol.entity.CoverageHistory;

@Repository
public interface CoverageHistoryRepository extends CoverageBaseRepository<CoverageHistory> {

    @Query(value = "SELECT * "
                   + "FROM UHDS_LEVEL_C "
                   + "WHERE ULC_ULM_SGS_ID = :masterPolicySgsId "
                   + "AND ULC_AMND_VER_NO = :masterPolicyAmndVerNo "
                   + "AND ULC_ULR_ID = (SELECT ULR_ID "
                   + "                     FROM UHDS_LEVEL_R "
                   + "                     WHERE ULR_ULM_SGS_ID = ULC_ULM_SGS_ID "
                   + "                     AND ULR_AMND_VER_NO = ULC_AMND_VER_NO "
                   + "                     AND ULR_RISK_TYP = :riskType)", nativeQuery = true)
    List<CoverageHistory> findMasterCoverages(@Param("masterPolicySgsId") Long masterPolicySgsId,
                                              @Param("masterPolicyAmndVerNo") Long masterPolicyAmndVerNo,
                                              @Param("riskType") String riskType);

    @Query(value = "SELECT C.ULC_MST_NAME, "
                   + "C.ULC_MST_NAME_BL, "
                   + "UPC_UW_GRP, "
                   + "UID_SHORT_DESC, "
                   + "UID_LONG_DESC, "
                   + "UID_SHORT_DESC_1, "
                   + "UID_LONG_DESC_1 "
                   + "FROM UHDS_LEVEL_C C, UHDS_LEVEL_M, UDS_PROD_COVERAGE, UDS_ID_DEFN "
                   + "WHERE ULC_ULM_SGS_ID = :masterPolicySgsId "
                   + "AND ULC_AMND_VER_NO = :masterPolicyAmndVerNo "
                   + "AND ULC_ULM_SGS_ID = ULM_SGS_ID "
                   + "AND ULC_AMND_VER_NO = ULM_AMND_VER_NO "
                   + "AND ULC_MST_ID = UPC_ID "
                   + "AND UID_ID_TYP = 'UPC_UW_GRP' "
                   + "AND UID_ID = UPC_UW_GRP "
                   + "AND UID_COMP_ID = UPC_COMP_ID "
                   + "ORDER BY UID_DISP_SEQ, UPC_DISP_SEQ", nativeQuery = true)
    List<Object[]> findCertificateCoverages(@Param("masterPolicySgsId") Long masterPolicySgsId,
                                                   @Param("masterPolicyAmndVerNo") Long masterPolicyAmndVerNo);

    @Query(value = "SELECT * "
                   + "FROM UHDS_LEVEL_C "
                   + "WHERE ULC_ULM_SGS_ID = :masterPolicySgsId "
                   + "AND ULC_AMND_VER_NO = :masterPolicyAmndVerNo "
                   + "AND EXISTS (SELECT 1 "
                   + "              FROM UHDS_LEVEL_M"
                   + "                 , UDS_PROD_COVERAGE "
                   + "              WHERE ULM_SGS_ID = ULC_ULM_SGS_ID "
                   + "              AND ULM_AMND_VER_NO = ULC_AMND_VER_NO "
                   + "              AND ULM_PROD_ID = UPC_UP_PROD_ID "
                   + "              AND UPC_DISP_SEQ = 1 "
                   + "              AND ULC_MST_ID = UPC_ID)", nativeQuery = true)
    CoverageHistory findSumInsured(@Param("masterPolicySgsId") Long masterPolicySgsId,
                                   @Param("masterPolicyAmndVerNo") Long masterPolicyAmndVerNo);
}

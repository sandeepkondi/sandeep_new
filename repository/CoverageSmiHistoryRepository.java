package com.beyontec.mol.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.beyontec.mol.entity.CoverageSmiHistory;
import com.beyontec.mol.modal.Premium;

@Repository
public interface CoverageSmiHistoryRepository extends CoverageSmiBaseRepository<CoverageSmiHistory> {

    @Query(value = "SELECT new com.beyontec.mol.modal.Premium(SUM(csmih.transactionPremium), SUM(csmih.transactionPremiumBc)) "
                   + "FROM CoverageSmiHistory csmih "
                   + "WHERE csmih.id.ulmSgsId = :ulmSgsId "
                   + "AND csmih.id.amendmentVersionNumber = :amdVerNo "
                   + "AND csmih.id.riskId <> '*' "
                   + "AND csmih.id.masterId = '*'")
    Premium findMasterPremium(@Param("ulmSgsId") Long ulmSgsId, @Param("amdVerNo") Long amdVerNo);

    @Query(value = "SELECT * FROM UHDS_LEVEL_CS "
                   + "WHERE ULCS_ULM_SGS_ID = :masterPolicySgsId "
                   + "AND ULCS_AMND_VER_NO = :masterPolicyAmndVerNo "
                   + "AND ULCS_ULR_ID = (SELECT ULR_ID FROM UHDS_LEVEL_R "
                   + "                      WHERE ULR_ULM_SGS_ID = ULCS_ULM_SGS_ID "
                   + "                      AND ULR_AMND_VER_NO = ULCS_AMND_VER_NO "
                   + "                      AND ULR_RISK_TYP = :riskType)", nativeQuery = true)
    List<CoverageSmiHistory> findMasterCoverageSmis(@Param("masterPolicySgsId") Long masterPolicySgsId,
                                                    @Param("masterPolicyAmndVerNo") Long masterPolicyAmndVerNo,
                                                    @Param("riskType") String riskType);
}

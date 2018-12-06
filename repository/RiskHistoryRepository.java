package com.beyontec.mol.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.beyontec.mol.entity.RiskHistory;

@Repository
public interface RiskHistoryRepository extends RiskBaseRepository<RiskHistory> {

    @Query(value = "SELECT rh FROM RiskHistory rh "
                   + "WHERE rh.policyForeignId.ulmSgsId = :ulmSgsId "
                   + "AND rh.policyForeignId.amendmentVersionNumber = :amdVersionNo "
                   + "AND rh.riskType = :riskType ")
    RiskHistory findMasterRisk(@Param("ulmSgsId") Long ulmSgsId,
                               @Param("amdVersionNo") Long amdVersionNo,
                               @Param("riskType") String riskType);
}

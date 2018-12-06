package com.beyontec.mol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.beyontec.mol.entity.ClaimTransactionRisk;

public interface ClaimTransactionRiskRepository extends JpaRepository<ClaimTransactionRisk, Long>{

	@Query(value = "SELECT CLR_RISK_ID FROM CTDS_LEVEL_R WHERE CLR_CLF_SGS_ID =?1", nativeQuery = true)
	public String getRiskID(Long fnolSgsId);
}

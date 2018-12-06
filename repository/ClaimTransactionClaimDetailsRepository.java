package com.beyontec.mol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.beyontec.mol.entity.ClaimTransactionClaim;

@Repository
public interface ClaimTransactionClaimDetailsRepository extends JpaRepository<ClaimTransactionClaim, Long>{
	
	ClaimTransactionClaim findByClaimNo(String claimNo);
	
	@Query(value = "SELECT CLC_STATUS FROM CTDS_LEVEL_C WHERE CLC_CLF_NO =?1", nativeQuery = true)
	public String getClaimStatus(String cliamNo);

}

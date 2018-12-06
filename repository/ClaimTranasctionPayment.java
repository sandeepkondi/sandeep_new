package com.beyontec.mol.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.beyontec.mol.entity.Claim;

@Repository
public interface ClaimTranasctionPayment extends JpaRepository<Claim, Long>{

	@Query(value = "SELECT CLS_PAY_AMT, CLS_OS_AMT FROM CTDS_LEVEL_S WHERE CLS_CLF_SGS_ID=?1 AND CLS_CLE_SGS_ID=?2", nativeQuery = true)
	public List<Object[]> getPaymentDetails(int fnolSgsId);
}

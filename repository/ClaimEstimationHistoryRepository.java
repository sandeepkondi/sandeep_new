package com.beyontec.mol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.beyontec.mol.entity.ClaimHistoryEstimation;

@Repository
public interface ClaimEstimationHistoryRepository extends JpaRepository<ClaimHistoryEstimation, Long>{

    @Query(value = "select * from CHDS_LEVEL_E where CLE_CLF_SGS_ID=?1 and CLE_SR_NO = (select MAX(CLE_SR_NO) from CHDS_LEVEL_E WHERE CLE_CLF_SGS_ID=?1)", nativeQuery = true)
	ClaimHistoryEstimation findByFnolSgsId(Long fnolSgsId);
	
	public ClaimHistoryEstimation findByFnolSgsIdAndRevisionSerialNo(Long fnolSgsId, int serialNo);
	
	@Query(value = "select MAX(CLE_SR_NO) from CHDS_LEVEL_E WHERE CLE_CLF_SGS_ID=?", nativeQuery=true)
	public int getLatestRevisionNo(Long fnolSgsID);
	
}

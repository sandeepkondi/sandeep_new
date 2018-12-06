package com.beyontec.mol.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.beyontec.mol.entity.ClaimTransactionEstimation;

@Repository
public interface ClaimTransactionEstimationRepository extends JpaRepository<ClaimTransactionEstimation, Long> {
	
	@Query(value = "SELECT CLE_LOSS_ID FROM CTDS_LEVEL_E WHERE CLE_CLF_SGS_ID = ?1", nativeQuery = true)
	public String getPaymentType(Long fnolSgsId);
	
	public List<ClaimTransactionEstimation> findByFnolSgsId(int sgsId);
	
	@Query(value = "select MAX(CLE_SR_NO) from CTDS_LEVEL_E WHERE CLE_CLF_SGS_ID=?", nativeQuery=true)
	public int getLatestRevisionNo(Long fnolSgsID);
	
	public ClaimTransactionEstimation findByFnolSgsIdAndRevisionSerialNo(Long fnolSgsId, int serialNo);

	public ClaimTransactionEstimation findByEstimateSgsId(Long estimateSgsId);

    public ClaimTransactionEstimation findByFnolSgsId(Long fnolSgsId);

	@Modifying
	@Query(value = "UPDATE CTDS_LEVEL_E E SET E.CLE_OS_AMT=?1, E.CLE_CLS_SGS_ID=?2, E.CLE_SR_NO=?3  WHERE E.CLE_SGS_ID=?4", nativeQuery = true)
    public void updateClaimEstimation(double outstandingAmt, Long sgsId, int revisionNo, Long estimateSgsId);
	
	@Query(value = "SELECT CLE_CVR_ID, CLE_EST_AMT FROM CTDS_LEVEL_E WHERE CLE_CLF_SGS_ID=?1 AND CLE_SR_NO=?2", nativeQuery = true)
	public List<Object[]> getPaymentDetails(Long fnolSgsID, int revisionSerialNo);

    @Query(value = "SELECT CLE_EST_AMT FROM CTDS_LEVEL_E WHERE CLE_CLF_SGS_ID = ?1 AND CLE_SR_NO = (SELECT MAX(CLE_SR_NO) from CTDS_LEVEL_E WHERE CLE_CLF_SGS_ID = ?1)", nativeQuery = true)
    public double getEstimateAmount(Long fnolSgsID);
	
}

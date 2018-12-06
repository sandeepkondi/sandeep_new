package com.beyontec.mol.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.beyontec.mol.entity.BsdsBatchHdr;
import com.beyontec.mol.modal.InsurerProcessDTO;
import com.beyontec.mol.modal.PoolInsurerClaimDetailsDTO;
import com.beyontec.mol.modal.PoolInsurerCountDTO;
import com.beyontec.mol.modal.PoolInsurerCrtExportDTO;
import com.beyontec.mol.modal.PoolInsurerIndividualCrtExportDTO;
import com.beyontec.mol.modal.PoolInsurerUwDetailsDTO;

@Repository
public interface BsdsBatchHdrRepository extends JpaRepository<BsdsBatchHdr, Long> {

    @Query(name = "getPoolInsurerCount", nativeQuery = true)
    List<PoolInsurerCountDTO> getCount(@Param("batchId") String batchId);

    @Query(name = "getPoolInsurerUnderwritingData", nativeQuery = true)
    List<PoolInsurerUwDetailsDTO> getUnderwritingDetails(@Param("batchId") Long batchId,
                                        @Param("transactionType") Long transactionType,
                                        @Param("prodId") Long prodId);

    @Query(name = "getPoolInsurerClaimData", nativeQuery = true)
    List<PoolInsurerClaimDetailsDTO> getClaimDetails(@Param("batchId") Long batchId,
                                              @Param("transactionType") Long transactionType,
                                              @Param("prodId") Long prodId);

    @Query(name = "getInsurerProcess", nativeQuery = true)
    List<InsurerProcessDTO> getInsurerProcess(@Param("dateFormat") String dateFormat,
                                              @Param("fromDate") String fromDate,
                                              @Param("toDate") String toDate,
                                              @Param("processId") String processId,
                                              @Param("batchId") String batchId,
                                              @Param("status") String status,
                                              @Param("isEngLocale") String isEngLocale,
                                              Pageable pageable);

    @Procedure(name = "populateBatchDetails")
    void populateBatchDetails(@Param("P_BATCH_ID") long batchId);

    @Query(name = "getOverallCerts", nativeQuery = true)
    List<PoolInsurerCrtExportDTO> getOverallCerts(@Param("batchId") long batchId,
                                                  @Param("productId") long productId,
                                                  @Param("dateFormat") String dateFormat);

    @Query(name = "getParticipantCertificates", nativeQuery = true)
    List<PoolInsurerIndividualCrtExportDTO> getParticipantCertificates(@Param("dateFormat") String dateFormat,
                                                                       @Param("batchId") long batchId,
                                                                       @Param("productId") long productId,
                                                                       @Param("partyId") String partyId);

    @Procedure(name = "populateUwAndClaimsApproveDetails")
    void populateUwAndClaimsApproveDetails(@Param("P_BATCH_ID") Long batchId, @Param("P_USER_ID") String userId);
}

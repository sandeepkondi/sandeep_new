package com.beyontec.mol.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.beyontec.mol.entity.UpdateCertificateDetails;

@Repository
public interface UpdateCertificateRepository extends JpaRepository<UpdateCertificateDetails, Long>{

    @Query(value = "SELECT uc FROM UpdateCertificateDetails uc "
                   + "WHERE uc.batchProcessStatus = :batchStatus "
                   + "AND uc.batchId = :batchId)")
    List<UpdateCertificateDetails> getBatchStatusEntries(@Param("batchId") long batchId,
                                                   @Param("batchStatus") String batchStatus);

    @Query(value = "SELECT COUNT(*) FROM UpdateCertificateDetails uc "
                   + "WHERE uc.batchId = :batchId)")
    Long getTotalBatchCount(@Param("batchId") long batchId);

    @Query(value = "SELECT COUNT(*) FROM UpdateCertificateDetails uc "
                   + "WHERE uc.batchProcessStatus IS NULL "
                   + "AND uc.batchId = :batchId)")
    Long getUnInitiatedCount(@Param("batchId") long batchId);

    @Query(value = "SELECT COUNT(*) FROM UpdateCertificateDetails uc "
                   + "WHERE uc.batchProcessStatus = :batchStatus "
                   + "AND uc.batchId = :batchId)")
    Long getBatchStatusCount(@Param("batchId") long batchId, @Param("batchStatus") String batchStatus);

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE UpdateCertificateDetails uc "
                   + "SET uc.batchProcessStatus = :batchStatus "
                   + "WHERE uc.batchProcessStatus IS NULL "
                   + "AND uc.batchId = :batchId")
    void setBatchStatus(@Param("batchId") long batchId, @Param("batchStatus") String batchStatus);

    @Procedure(name = "updateCertificate")
    void updateCertificate(@Param("P_IUCD_SGS_ID") long sgsId);

    UpdateCertificateDetails findFirstByCertificateNumberAndErrorTypeOrderBySgsIdDesc(String certificateNumber,
                                                                                       String errorType);

    UpdateCertificateDetails findFirstByEmiratesIdAndCertificateNumberNotNullOrderBySgsIdDesc(String emiratesId);
    
    UpdateCertificateDetails findFirstByLabourReferenceNoAndCertificateNumberNotNullOrderBySgsIdDesc(String visaRefNo);

}

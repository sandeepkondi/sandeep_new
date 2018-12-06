package com.beyontec.mol.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.beyontec.mol.entity.CertificateDetails;

@Repository
public interface CertificateDetailsRepository extends JpaRepository<CertificateDetails, Long> {

    CertificateDetails findByEmiratesIdAndCertificateNumberNotNull(String emiratesId);

	CertificateDetails findByLabourReferenceNoAndCertificateNumberAndErrType(String visaRefNo, String certificateNo,
			String errorType);

	CertificateDetails findByCertificateNumber(String certificateNumber);

    CertificateDetails findByCertificateNumberAndStatus(String certificateNumber, String status);

    CertificateDetails findByLabourReferenceNoAndCertificateNumberNotNull(String visaRefNo);

	CertificateDetails findByLabourReferenceNoAndEmiratesIdAndErrType(String visaRefNo, String emiratesId,
			String errorType);

	@Procedure(name = "populateIDS")
	void populateIDS(@Param("P_ULM_SGS_ID") long sgsId, @Param("P_ULM_AMND_VER_NO") long amendVerNo);

    @Query(value = "SELECT c FROM CertificateDetails c "
                   + "WHERE c.labourReferenceNo = :labourReferenceNo "
                   + "AND c.transactionType = :txnType "
                   + "AND c.certificateNumber IS NOT NULL")
    List<CertificateDetails> findGeneratedCertByLabourRefNoAndTxnType(@Param("labourReferenceNo") String labourReferenceNo,
                                                                      @Param("txnType") String txnType);

    @Query(value = "SELECT c FROM CertificateDetails c "
                   + "WHERE c.passportNo = :passportNo "
                   + "AND c.transactionType = :txnType "
                   + "AND c.nationality = :nationality "
                   + "AND c.certificateNumber IS NOT NULL")
    List<CertificateDetails> findCertByPassNoTxnTypeNation(@Param("passportNo") String passportNo,
                                                           @Param("txnType") String txnType,
                                                           @Param("nationality") String nationality);

    @Query(value = "SELECT c FROM CertificateDetails c "
                   + "WHERE c.emiratesId = :emiratesId "
                   + "AND c.transactionType = :txnType "
                   + "AND c.certificateNumber IS NOT NULL")
    List<CertificateDetails> findGeneratedCertByEmiratesIdAndTxnType(@Param("emiratesId") String emiratesId,
                                                                     @Param("txnType") String txnType);

    @Query(value = "SELECT c FROM CertificateDetails c "
                   + "WHERE c.batchProcessStatus = :batchStatus "
                   + "AND c.batchId = :batchId)")
    List<CertificateDetails> getBatchStatusEntries(@Param("batchId") long batchId,
                                                   @Param("batchStatus") String batchStatus);

    @Query(value = "SELECT COUNT(*) FROM CertificateDetails c "
                   + "WHERE c.batchId = :batchId)")
    Long getTotalBatchCount(@Param("batchId") long batchId);

    @Query(value = "SELECT COUNT(*) FROM CertificateDetails c "
                   + "WHERE c.batchProcessStatus IS NULL "
                   + "AND c.batchId = :batchId)")
    Long getNotInitiatedBatchCount(@Param("batchId") long batchId);

    @Query(value = "SELECT COUNT(*) FROM CertificateDetails c "
                   + "WHERE c.batchProcessStatus = :batchStatus "
                   + "AND c.batchId = :batchId)")
    Long getBatchStatusCount(@Param("batchId") long batchId, @Param("batchStatus") String batchStatus);

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE CertificateDetails c "
                   + "SET c.batchProcessStatus = :batchStatus "
                   + "WHERE c.batchProcessStatus IS NULL "
                   + "AND c.batchId = :batchId")
    void setBatchStatus(@Param("batchId") long batchId, @Param("batchStatus") String batchStatus);
    
    @Query(value = "SELECT ICD_CATG_ID FROM IDS_CERT_DTLS WHERE ICD_ULM_NO = :certificateNo", nativeQuery = true)
    public String getEmployeeCategory(@Param("certificateNo") String certificateNo);

    @Query(value = "SELECT ULM_APD, ULM_FMD, ULM_TOD, "
                   + "     (SELECT SUM(ULCS_TXN_PREM) FROM UHDS_LEVEL_CS WHERE ULCS_ULC_MST_ID = '*' AND ULCS_ULM_SGS_ID = ULM_SGS_ID AND ULCS_AMND_VER_NO = ULM_AMND_VER_NO), "
                   + "     NVL ( (SELECT SUM(ULIC_SHARE_PREM_BC) FROM UHDS_LEVEL_IC WHERE ULIC_ULM_SGS_ID = ULM_SGS_ID AND ULIC_AMND_VER_NO = ULM_AMND_VER_NO), 0 ) "
                   + "     FROM UHDS_LEVEL_M"
                   + "     WHERE ULM_NO IN ?1 ", nativeQuery = true)
    List<Object[]> findCertApdAndPremium(List<String> certificateNumbers);

    List<CertificateDetails> findByCertificateNumberIn(List<String> certificateNumbers);
}

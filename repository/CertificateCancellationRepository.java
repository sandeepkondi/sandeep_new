package com.beyontec.mol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beyontec.mol.entity.CertificateCancellation;

@Repository
public interface CertificateCancellationRepository extends JpaRepository<CertificateCancellation, Long> {

    CertificateCancellation findByCertificateNoAndErrorType(String certificateNo, String errorType);
}

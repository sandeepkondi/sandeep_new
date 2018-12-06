package com.beyontec.mol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beyontec.mol.entity.ClaimPaymentParty;

@Repository
public interface ClaimTransactionPaymentPartyRepository extends JpaRepository<ClaimPaymentParty, Long>{

}

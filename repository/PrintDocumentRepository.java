package com.beyontec.mol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beyontec.mol.entity.PrintDocument;

@Repository
public interface PrintDocumentRepository extends JpaRepository<PrintDocument, Long> {

}

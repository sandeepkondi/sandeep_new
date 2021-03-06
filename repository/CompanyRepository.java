package com.beyontec.mol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beyontec.mol.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {

}

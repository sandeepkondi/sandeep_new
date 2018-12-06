package com.beyontec.mol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.beyontec.mol.entity.CoverageBase;

@NoRepositoryBean
public interface CoverageBaseRepository<T extends CoverageBase> extends JpaRepository<T, Long> {

}

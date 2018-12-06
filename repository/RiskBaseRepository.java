package com.beyontec.mol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.beyontec.mol.entity.RiskBase;

@NoRepositoryBean
public interface RiskBaseRepository<T extends RiskBase> extends JpaRepository<T, Long> {
}

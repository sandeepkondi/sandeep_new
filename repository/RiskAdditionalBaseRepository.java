package com.beyontec.mol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.beyontec.mol.entity.RiskAdditionalBase;

@NoRepositoryBean
public interface RiskAdditionalBaseRepository<T extends RiskAdditionalBase> extends JpaRepository<T, Long> {
}

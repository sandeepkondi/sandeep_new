package com.beyontec.mol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.beyontec.mol.entity.PolicyBase;

@NoRepositoryBean
public interface PolicyBaseRepository<T extends PolicyBase> extends JpaRepository<T, Long> {
}

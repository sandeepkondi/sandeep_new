package com.beyontec.mol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.beyontec.mol.entity.CoverageSmiBase;

@NoRepositoryBean
public interface CoverageSmiBaseRepository<T extends CoverageSmiBase> extends JpaRepository<T, Long> {

}

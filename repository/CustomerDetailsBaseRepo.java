package com.beyontec.mol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.beyontec.mol.entity.CustomerDetailsBase;

@NoRepositoryBean
public interface CustomerDetailsBaseRepo<T extends CustomerDetailsBase> extends JpaRepository<T, String> {
}

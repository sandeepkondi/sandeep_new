package com.beyontec.mol.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.beyontec.mol.entity.InstallmentBase;

@NoRepositoryBean
public interface InstallmentBaseRepository<T extends InstallmentBase> extends JpaRepository<T, Serializable> {

}

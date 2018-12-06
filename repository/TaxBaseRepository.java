package com.beyontec.mol.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.beyontec.mol.entity.TaxBase;

@NoRepositoryBean
public interface TaxBaseRepository<T extends TaxBase> extends JpaRepository<T, Serializable> {

}

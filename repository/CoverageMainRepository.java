package com.beyontec.mol.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.beyontec.mol.entity.CoverageMain;

@Repository
public interface CoverageMainRepository extends CoverageBaseRepository<CoverageMain> {

    @Query("SELECT c FROM CoverageMain c WHERE c.id.ulmSgsId = :ulmSgsId")
    List<CoverageMain> findByUlmSgsId(@Param("ulmSgsId") Long ulmSgsId);
}


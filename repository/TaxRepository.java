package com.beyontec.mol.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.beyontec.mol.entity.Tax;
import com.beyontec.mol.modal.TotalTax;

@Repository
public interface TaxRepository extends TaxBaseRepository<Tax> {

    @Query(value = "SELECT new com.beyontec.mol.modal.TotalTax(SUM(t.adjAmount), SUM(t.adjAmountBc)) "
                   + "FROM Tax t "
                   + "WHERE t.id.ulmSgsId  = :ulmSgsId "
                   + "AND t.amendmentVersionNo = :amdVerNo ")
    TotalTax getTotalTax(@Param("ulmSgsId") Long ulmSgsId, @Param("amdVerNo") Long amdVerNo);

    @Query(value = "SELECT t FROM Tax t WHERE t.id.ulmSgsId = :ulmSgsId")
    List<Tax> findByUlmSgsId(@Param("ulmSgsId") Long ulmSgsId);
}

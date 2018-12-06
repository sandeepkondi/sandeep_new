package com.beyontec.mol.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.beyontec.mol.entity.TaxHistory;
import com.beyontec.mol.modal.TotalTax;

@Repository
public interface TaxHistoryRepository extends TaxBaseRepository<TaxHistory> {

    @Query(value = "SELECT new com.beyontec.mol.modal.TotalTax(SUM(th.adjAmount), SUM(th.adjAmountBc)) "
                   + "FROM TaxHistory th "
                   + "WHERE th.id.ulmSgsId  = :ulmSgsId "
                   + "AND th.id.amendmentVersionNo = :amdVerNo ")
    TotalTax getTotalTaxHistory(@Param("ulmSgsId") Long ulmSgsId, @Param("amdVerNo") Long amdVerNo);

    @Query(value = "SELECT * FROM UHDS_LEVEL_TCF "
                   + "WHERE ULTCF_ULM_SGS_ID = :mstPolicySgsId "
                   + "AND ULTCF_AMND_VER_NO = :mstPolicyAmdVerNo", nativeQuery = true)
    List<TaxHistory> findMasterTaxes(@Param("mstPolicySgsId") Long mstPolicySgsId,
                                     @Param("mstPolicyAmdVerNo") Long mstPolicyAmdVerNo);
}

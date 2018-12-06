package com.beyontec.mol.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.beyontec.mol.entity.CoverageSmiMain;
import com.beyontec.mol.modal.Premium;

@Repository
public interface CoverageSmiMainRepository extends CoverageSmiBaseRepository<CoverageSmiMain> {

    @Query(value = "SELECT c FROM CoverageSmiMain c WHERE c.id.ulmSgsId = :ulmSgsId")
    List<CoverageSmiMain> findByUlmSgsId(@Param("ulmSgsId") Long ulmSgsId);

    @Query(value = "SELECT new com.beyontec.mol.modal.Premium(SUM(csmim.transactionPremium), SUM(csmim.transactionPremiumBc)) "
                   + "FROM CoverageSmiMain csmim "
                   + "WHERE csmim.id.ulmSgsId = :ulmSgsId "
                   + "AND csmim.amendmentVersionNumber = :amdVerNo "
                   + "AND csmim.id.riskId <> '*' "
                   + "AND csmim.id.coverageMasterId = '*'")
    Premium findCertificatePremium(@Param("ulmSgsId") Long ulmSgsId, @Param("amdVerNo") Long amdVerNo);
}

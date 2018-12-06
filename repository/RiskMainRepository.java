
package com.beyontec.mol.repository;


import org.springframework.stereotype.Repository;

import com.beyontec.mol.entity.RiskMain;

@Repository
public interface RiskMainRepository extends RiskBaseRepository<RiskMain> {

    RiskMain findByUlmSgsId(long ulmSgsId);
}

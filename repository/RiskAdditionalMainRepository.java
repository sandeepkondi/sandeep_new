package com.beyontec.mol.repository;


import org.springframework.stereotype.Repository;

import com.beyontec.mol.entity.RiskAdditionalMain;

@Repository
public interface RiskAdditionalMainRepository extends RiskAdditionalBaseRepository<RiskAdditionalMain> {

    RiskAdditionalMain findByUlmSgsId(Long ulmSgsId);
}

package com.beyontec.mol.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.beyontec.mol.entity.CustomerDetailsMain;

@Repository
public interface CustomerDetailsMainRepository extends CustomerDetailsBaseRepo<CustomerDetailsMain> {

    @Query(value = "SELECT cd FROM CustomerDetailsMain cd "
                   + "WHERE cd.companyId = :companyId "
                   + "AND cd.idType1 = :idType "
                   + "AND cd.id1 = :id")
    CustomerDetailsMain findByIdTypeAndId(@Param("companyId") String companyId, @Param("idType") String idType, @Param("id") String id);

    CustomerDetailsMain findByName(String name);
}

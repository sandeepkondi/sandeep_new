package com.beyontec.mol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.beyontec.mol.entity.ProductAppBusType;

public interface ProductAppBusTypeRepository extends JpaRepository<ProductAppBusType, Long> {

    @Query(value = "SELECT pabt FROM ProductAppBusType pabt "
                   + "WHERE pabt.companyId = :companyId "
                   + "AND pabt.upProductId = :productId "
                   + "AND pabt.modType = '01' "
                   + "AND pabt.busType = 'D' "
                   + "AND pabt.functionId = 'FQ' "
                   + "AND pabt.augGroupType = 'E' "
                   + "AND pabt.policyType = 'C' ")
    ProductAppBusType findByCompanyAndProduct(@Param("companyId") String companyId,
                                              @Param("productId") String productId);
}

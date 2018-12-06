package com.beyontec.mol.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.beyontec.mol.entity.UdsProduct;

@Repository
public interface UdsProductRepository extends JpaRepository<UdsProduct, Long> {

    @Query("SELECT p FROM UdsProduct p WHERE p.id.UP_COMP_ID = :companyId")
    List<UdsProduct> findByCompanyId(@Param("companyId") String companyId);

    @Query(value = "SELECT DISTINCT P.* "
                   + "FROM UDS_PRODUCT P, UPDS_LEVEL_M M "
                   + "WHERE P.UP_PROD_ID = M.ULM_PROD_ID AND P.UP_COMP_ID = M.ULM_COMP_ID "
                   + "ORDER BY P.UP_PROD_NAME ASC", nativeQuery = true)
    List<UdsProduct> getWorkerTypes();
}

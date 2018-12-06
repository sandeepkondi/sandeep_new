package com.beyontec.mol.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.beyontec.mol.entity.PrintDocumentTemplate;

@Repository
public interface PrintDocumentTemplateRepository extends JpaRepository<PrintDocumentTemplate, String> {

    @Query(value = "SELECT * FROM UDS_DOC_PRN_TPL "
                   + "WHERE UDPT_COMP_ID = :companyId "
                   + "AND UDPT_TPL_MOD = '01' "
                   + "AND UDT_PROD_ID = :productId "
                   + "AND UDPT_TPL_FOR = 'PP' "
                   + "AND EXISTS (SELECT 1 FROM UDS_DOC_PRN_APPL_LEVEL "
                   + "              WHERE UDPAL_COMP_ID = UDPT_COMP_ID "
                   + "              AND UDPAL_TPL_ID = UDPT_TPL_ID "
                   + "              AND UDPAL_PROD_ID = UDT_PROD_ID "
                   + "              AND UDPAL_BTYP_ID = 'C') "
                   + "AND EXISTS (SELECT 1 FROM UDS_DOCPRN_RECP_MAP "
                   + "              WHERE UDRM_UDPT_TPL_ID = UDPT_TPL_ID "
                   + "              AND UDRM_COMP_ID = UDPT_COMP_ID "
                   + "              AND UDRM_MOD_TYP = UDPT_TPL_MOD "
                   + "              AND UDRM_TXN_TYP = 'P' "
                   + "              AND UDRM_TXN_STYP = '*' "
                   + "              AND UDRM_PROD_ID = UDT_PROD_ID "
                   + "              AND UDRM_RECEP_TYP = 'C' "
                   + "              AND UDRM_TPL_FOR = UDPT_TPL_FOR)", nativeQuery = true)
    List<PrintDocumentTemplate> findTemplatesByProductId(@Param("companyId") String companyId,
                                                         @Param("productId") String productId);
}

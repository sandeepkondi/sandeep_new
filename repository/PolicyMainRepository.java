package com.beyontec.mol.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.beyontec.mol.entity.PolicyMain;
import com.beyontec.mol.modal.ExportCertificateDetails;

@Repository
public interface PolicyMainRepository extends PolicyBaseRepository<PolicyMain> {

    @Query(value = "SELECT p FROM PolicyMain p WHERE p.number = :prevPolicyNumber AND p.status = :status")
    public PolicyMain findByPrevPolicyNo(@Param("prevPolicyNumber") String prevPolicyNumber,
                                         @Param("status") String status);

    public PolicyMain findByNumber(String certificateNo);

    @Procedure(name = "generate_certificate_policy_number")
    String generateCertificatePolicyNumber(@Param("P_UDDH_COMP_ID") String companyId,
                                           @Param("P_UDDH_TYP") String bTypeId,
                                           @Param("P_UDDH_PROD_ID") String productId,
                                           @Param("P_PARAM_DT_1") Date visaApprovalDate);

    @Query(name = "getExportCertificates", nativeQuery = true)
    List<ExportCertificateDetails> getExportCertificateDetails(@Param("dateFormat") String dateFormat,
                                                               @Param("certCreationFromDate") String certCreationFromDate,
                                                               @Param("certCreationToDate") String certCreationToDate,
                                                               @Param("customerCategoryId") String customerCategoryId,
                                                               @Param("certNo") String certNo,
                                                               @Param("exportAll") String exportAllFlag,
                                                               @Param("selectedCert") List<String> selectedCert,
                                                               @Param("deSelectedCert") List<String> deSelectedCert);
}

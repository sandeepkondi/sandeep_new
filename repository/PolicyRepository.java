package com.beyontec.mol.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.beyontec.mol.entity.PolicyDetails;

@Repository
public interface PolicyRepository extends JpaRepository<PolicyDetails, Long> {

	PolicyDetails findById(String id);

	List<PolicyDetails> findAll();

	@SuppressWarnings("unchecked")
	PolicyDetails save(PolicyDetails policy);

	@Query(value = "SELECT ILM_COMP_ID AS companyId, ILM_NO AS policyNo, ILM_SGS_ID AS policySgsId, ILM_CUST_ID AS customerId, ILM_PROD_ID AS productId, (SELECT UPAC_UC_COB_ID AS cobId FROM UDS_PROD_APPL_COB WHERE UPAC_UP_PROD_ID=ILM_PROD_ID)COB_ID, ILM_POL_FMD AS policyEffectiveFrom, ILM_POL_TOD AS policyEffectiveTo, ILM_DIVN_ID AS divisionID, ILM_DEPT_ID AS departmentId, ILM_INSRD_ID AS insuredId, ILM_MPOL_NO AS masterPolicyNo, ILM_MPOL_FMD AS masterPolicyEffectiveFrom, ILM_MPOL_TOD AS masterPolicyEffectiveTo, ILM_DIVN_ID AS reportedDivisionID, ILR_RISK_ID AS riskId, ILR_EFF_FMD AS riskEffectiveFrom, ILR_EFF_TOD AS riskEffectiveTo, ILR_RISK_TYP AS riskType, ILR_FLEX7 AS flex7, ILR_END_IDX AS riskAmendmentVerNo FROM IDS_LEVEL_M, IDS_LEVEL_R A WHERE ILM_NO= ILR_ILM_NO AND ILM_END_IDX = ILR_END_IDX AND ILM_NO =?1 AND ILM_END_IDX = (SELECT MAX(ILR_END_IDX) FROM IDS_LEVEL_R WHERE ILR_ILM_NO = A.ILR_ILM_NO AND ILR_END_IDX = A.ILR_END_IDX AND ILR_RISK_ID = A.ILR_RISK_ID)", nativeQuery = true)
	List<Object[]> getPolicyRiskDate(String certificateNo);

}

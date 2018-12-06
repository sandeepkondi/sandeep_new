package com.beyontec.mol.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.beyontec.mol.entity.UdsIdDefinition;
import com.beyontec.mol.modal.ConfigDTO;

@Repository
public interface UdsIdDefinitionRepository extends JpaRepository<UdsIdDefinition, Long> {

	UdsIdDefinition findById(String id);

    @Query(value = "SELECT uid FROM UdsIdDefinition uid WHERE uid.id.companyId = :companyId")
    List<UdsIdDefinition> findByCompanyId(@Param("companyId") String companyId);

	@Query(value = "SELECT UID_VALUE FROM UDS_ID_DEFN WHERE UID_COMP_ID =?1 AND  UID_ID_TYP = 'MAP_ULR_RISK_TYP' AND UID_ID= ?2", nativeQuery = true)
	UdsIdDefinition findRiskTypeByEmpCategoryId(String companyId,String uid);

	// This query is for --ELN
	@Query(value = "SELECT UID_VALUE FROM UDS_ID_DEFN WHERE UID_COMP_ID =?1 AND UID_ID_TYP = 'DFLT_DATA' AND UID_ID='DFLT_UCD_ID_TYP1'", nativeQuery = true)
	UdsIdDefinition findCustomerDetails(String companyId);

	// This query is for --ESTC
	@Query(value = "SELECT UID_VALUE FROM UDS_ID_DEFN WHERE UID_COMP_ID =?1 AND UID_ID_TYP ='DFLT_DATA' AND UID_ID='DFLT_UCD_ID_TYP2'", nativeQuery = true)
	UdsIdDefinition findCustomerDetailsDefault(String companyId);

	
	// This query is TO GET ULM_CRU
	@Query(value = "SELECT UID_VALUE FROM UDS_ID_DEFN WHERE UID_COMP_ID =?1 AND  UID_ID_TYP ='DFLT_DATA' AND UID_ID='DFLT_ULM_CRU'", nativeQuery = true)
	UdsIdDefinition findCreatedUser(String companyId);

	//This query is ULI_DUE_DATE NEEDS TO BE CALUCLATED FROM ULI_BILL_DATE + UID_VALUE
	@Query(value = "SELECT UID_VALUE FROM UDS_ID_DEFN WHERE UID_COMP_ID =?1 AND UID_ID_TYP = 'DFLT_DATA' AND UID_ID = 'DFLT_ULI_DUE_DATE'", nativeQuery = true)
	UdsIdDefinition findDueDate(String companyId);

	// This query to get claim action reason id by reason type and description
	@Query(value = "SELECT UID_ID FROM UDS_ID_DEFN WHERE UID_ID_TYP = ?1 AND UID_DESC = ?2", nativeQuery = true)
	String findIdByType(String type, String reason);

	// This query is for getting claim action reasons by type of action
	@Query(value = "SELECT UID_DESC FROM UDS_ID_DEFN WHERE UID_ID_TYP = ?1", nativeQuery = true)
	Set<String> findUidDescByType(String action);

    // This query is for getting work basket activities
    @Query(value = "SELECT UID_DESC FROM UDS_ID_DEFN WHERE UID_ID_TYP = 'WB_ACT_TYP' AND UID_MODULE_TYP =02 AND (UID_DESC = ?1 OR UID_DESC = ?2)", nativeQuery = true)
    List<String> findWorkBasketActivities(String reviewActivityDesc, String approveActivityDesc);

    // This query is for getting certificate customer category
    @Query(value = "SELECT * FROM UDS_ID_DEFN WHERE UID_ID_TYP = 'EMP_CATG_TYP'", nativeQuery = true)
    List<UdsIdDefinition> findCustomerCategory();

    @Query(value = "SELECT * FROM "
                   + "(SELECT * FROM UDS_ID_DEFN "
                   + "WHERE UID_COMP_ID = ?1 AND UID_ID_TYP = ?2 "
                   + "AND (?3 IS NULL OR UPPER(UID_DESC) LIKE UPPER(concat('%', concat(?3, '%')))) "
                   + "AND (?4 IS NULL OR UID_DESC_1 LIKE concat('%', concat(?4, '%'))) "
                   + "ORDER BY UID_DESC ASC) "
                   + "WHERE (?6 = 'true' OR ROWNUM <= ?5)", nativeQuery = true)
    List<UdsIdDefinition> findConfigByType(String companyId,
                                           String uidType,
                                           String engDesc,
                                           String arabDesc,
                                           int limit,
                                           String isRetrieveAll);

    @Query(name = "getinsurerProcessType", nativeQuery = true)
    List<ConfigDTO> getinsurerProcessType(@Param("isEngLocale") String isEngLocale);
}

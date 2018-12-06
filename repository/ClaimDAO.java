package com.beyontec.mol.repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.beyontec.mol.modal.ClaimListingDTO;
import com.beyontec.mol.modal.ClaimsSearchCriteria;
import com.beyontec.mol.modal.PaginatedRequest;

@Repository
public class ClaimDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<ClaimListingDTO > searchClaims(ClaimsSearchCriteria claimsSearchCriteria, PaginatedRequest paginatedRequest) {

        String selectQuery = getClaimQuery().append(generateCloseQuery(claimsSearchCriteria)).toString();

		Query query = entityManager.createNativeQuery(selectQuery);

		if(claimsSearchCriteria.getFromDate() != null) {
			query.setParameter("fromDate", new SimpleDateFormat("dd/MMM/yyyy").format(claimsSearchCriteria.getFromDate()));
		}

		if(claimsSearchCriteria.getToDate() != null) {
			query.setParameter("toDate", new SimpleDateFormat("dd/MMM/yyyy").format(claimsSearchCriteria.getToDate()));
		}

		if(claimsSearchCriteria.getClaimLaunchDate() != null) {
			query.setParameter("claimLauchDate", new SimpleDateFormat("dd/MMM/yyyy").format(claimsSearchCriteria.getClaimLaunchDate()));
		}
		query.setFirstResult((paginatedRequest.getOffset()) * paginatedRequest.getLimit());
		query.setMaxResults(paginatedRequest.getLimit());

		List<Object[]> results = query.getResultList();
		List<ClaimListingDTO> claimListing = new ArrayList<>();

		for (Object[] obj : results) {
			ClaimListingDTO listDto = new ClaimListingDTO();
			listDto.setClaimNo((String) obj[0]);
			listDto.setCertificateNo((String) obj[1]);
			listDto.setBatchNo((String) obj[2]);
			listDto.setClaimLaunchDate((Date) obj[3]);
			listDto.setEmployee((String) obj[4]);
			listDto.setEmiratesId((String) obj[5]);
			listDto.setEmployeeType((String) obj[6]);
			listDto.setEmployerName((String) obj[7]);
			listDto.setClaimStatus((String) obj[8]);
			claimListing.add(listDto);
		}
		return claimListing;
    }

    public long getClaimsCount(ClaimsSearchCriteria claimsSearchCriteria) {

    	String selectQuery = getClaimQuery().append(generateCloseQuery(claimsSearchCriteria)).toString();
		Query query = entityManager.createNativeQuery(selectQuery);

		if (claimsSearchCriteria.getFromDate() != null) {
			query.setParameter("fromDate", new SimpleDateFormat("dd/MMM/yyyy").format(claimsSearchCriteria.getFromDate()));
		}

		if (claimsSearchCriteria.getToDate() != null) {
			query.setParameter("toDate", new SimpleDateFormat("dd/MMM/yyyy").format(claimsSearchCriteria.getToDate()));
		}

		if (claimsSearchCriteria.getClaimLaunchDate() != null) {
			query.setParameter("claimLauchDate", new SimpleDateFormat("dd/MMM/yyyy").format(claimsSearchCriteria.getClaimLaunchDate()));
		}

		return query.getResultList().size();
    }

    private StringBuffer getClaimQuery() {

    	StringBuffer claimQuery = new StringBuffer()
    			.append(" SELECT CLC.CLC_NO AS claimNo,                  \n")
				.append("        CLC.CLC_ULM_NO AS certificateNo,        \n")
				.append("        CLC.CLC_GROUP_ID AS batchNo,            \n")
				.append("        CLC.CLC_CLD AS claimLaunchDate,         \n")
				.append("        CLR.CLR_RISK_FLEX1 AS employeeName,     \n")
				.append("        CLR.CLR_RISK_FLEX7 AS emiratesId,       \n")
				.append("        (SELECT PROD.UPR_RISK_TYP_NAME FROM UDS_PROD_RISK PROD WHERE PROD.UPR_UP_PROD_ID = CLC.CLC_PROD_ID AND PROD.UPR_RISK_TYP_ID = CLR.CLR_RISK_TYP) as employeeType,  \n")
				.append("        (SELECT CUS.UCD_NAME FROM UDS_CUSTOMER_DTLS CUS WHERE CUS.UCD_ID = FNOL.CLF_INSRD_ID) as employeerName,         \n")
				.append("        (SELECT UDS.UID_DESC FROM UDS_ID_DEFN UDS WHERE UDS.UID_ID = CLC.CLC_STATUS AND UDS.UID_ID_TYP='STATUS' AND UDS.UID_MODULE_TYP='02') AS status  \n")
				.append("FROM CTDS_LEVEL_FNOL FNOL, CTDS_LEVEL_C CLC, CTDS_LEVEL_R CLR WHERE CLR_CLF_SGS_ID = CLC_CLF_SGS_ID AND CLF_SGS_ID = CLC_CLF_SGS_ID");

		return claimQuery;
    }
 // crating where query based on search criteria
    private StringBuffer generateCloseQuery(ClaimsSearchCriteria claimsSearchCriteria) {

    	StringBuffer closeQuery = new StringBuffer();
		Date fromDate = claimsSearchCriteria.getFromDate();
		Date toDate = claimsSearchCriteria.getToDate();

		if (!StringUtils.isEmpty(claimsSearchCriteria.getCertificateNo())) {
			closeQuery.append(" AND UPPER(CLC.CLC_ULM_NO) LIKE UPPER('%" + claimsSearchCriteria.getCertificateNo() + "%')");
		}

		if (!StringUtils.isEmpty(claimsSearchCriteria.getBatchNo())) {
			closeQuery.append(" AND UPPER(CLC.CLC_GROUP_ID) LIKE UPPER('%" + claimsSearchCriteria.getBatchNo() + "%')");
		}

		if (!StringUtils.isEmpty(claimsSearchCriteria.getEmployeeType())) {
			closeQuery.append(" AND CLR.CLR_RISK_TYP = '"+ claimsSearchCriteria.getEmployeeType() + "'");
		}

		if (!StringUtils.isEmpty(claimsSearchCriteria.getEmployee())) {
			closeQuery.append(" AND UPPER(CLR.CLR_RISK_FLEX1) LIKE UPPER('%" + claimsSearchCriteria.getEmployee() + "%')");
		}

		if (!StringUtils.isEmpty(claimsSearchCriteria.getEmployerName())) {
			closeQuery.append(" AND FNOL.CLF_INSRD_ID = '" + claimsSearchCriteria.getEmployerName() +"'");
		}

		if (!StringUtils.isEmpty(claimsSearchCriteria.getClaimStatus())) {
			closeQuery.append(" AND CLC.CLC_STATUS = '" + claimsSearchCriteria.getClaimStatus() +"'");
		}

		if (!StringUtils.isEmpty(claimsSearchCriteria.getEmiratesId())) {
			closeQuery.append(" AND UPPER(CLR.CLR_RISK_FLEX7) LIKE UPPER('%" + claimsSearchCriteria.getEmiratesId() + "%')");
		}

		if (!StringUtils.isEmpty(claimsSearchCriteria.getClaimNo())) {
			closeQuery.append(" AND UPPER(CLC.CLC_NO) LIKE UPPER('%" + claimsSearchCriteria.getClaimNo() + "%')");
		}

		if (!StringUtils.isEmpty(claimsSearchCriteria.getDepartment())) {
			closeQuery.append(" AND FNOL.CLF_DEPT_ID = '" + claimsSearchCriteria.getDepartment() +"'");
		}

		if (!StringUtils.isEmpty(claimsSearchCriteria.getDivision())) {
			closeQuery.append(" AND FNOL.CLF_DIVN_ID = '" + claimsSearchCriteria.getDivision() +"'");
		}

		if (fromDate != null && toDate != null) {
			closeQuery.append(" AND CLC.CLC_CLD BETWEEN :fromDate AND :toDate");
		} else if (fromDate != null) {
			closeQuery.append(" AND CLC.CLC_CLD >= :fromDate");

		} else if (toDate != null) {
			closeQuery.append(" AND CLC.CLC_CLD <= :toDate");
		}

		if (claimsSearchCriteria.getClaimLaunchDate() != null) {
			closeQuery.append(" AND CLC.CLC_CLD = :claimLauchDate");
		}
      	return closeQuery;
    }

    @SuppressWarnings("unchecked")
	public List<ClaimListingDTO> getClaimByClaimId(List<String> ids) {

		StringBuffer claimQuery = getClaimQuery();
		if (ids != null && ids.size() > 0) {
			claimQuery.append(" AND CLC.CLC_NO in :ids");
		}

		Query query = entityManager.createNativeQuery(claimQuery.toString());

		if (ids != null && ids.size() > 0) {
			query.setParameter("ids", ids);
		}

		List<Object[]> claims = query.getResultList();
		List<ClaimListingDTO> claimListing = new ArrayList<>();

		for (Object[] obj : claims) {
			ClaimListingDTO listDto = new ClaimListingDTO();
			listDto.setClaimNo((String) obj[0]);
			listDto.setCertificateNo((String) obj[1]);
			listDto.setBatchNo((String) obj[2]);
			listDto.setClaimLaunchDate((Date) obj[3]);
			listDto.setEmployee((String) obj[4]);
			listDto.setEmiratesId((String) obj[5]);
			listDto.setEmployeeType((String) obj[6]);
			listDto.setEmployerName((String) obj[7]);
			listDto.setClaimStatus((String) obj[8]);
			claimListing.add(listDto);
		}
		return claimListing;
	}
}
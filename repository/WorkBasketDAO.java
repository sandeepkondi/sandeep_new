package com.beyontec.mol.repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.beyontec.mol.modal.PaginatedRequest;
import com.beyontec.mol.modal.WorkBasketDTO;
import com.beyontec.mol.modal.WorkBasketSearchCriteria;
import com.beyontec.mol.util.ClaimEnumConstants;
import com.beyontec.mol.util.CustomDateSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

@Repository
public class WorkBasketDAO {

    @PersistenceContext protected EntityManager entityManager;
    @Value("${date.format}") private String dateFormat;

    @SuppressWarnings("unchecked")
    public List<WorkBasketDTO> searchWorkBasket(WorkBasketSearchCriteria workBasketSearchCriteria,
                                                String username,
                                                PaginatedRequest paginatedRequest) {

        String selectQuery = getWorkBasketQuery().append(generateCloseQuery(workBasketSearchCriteria))
                                                 .toString();
        Query query = entityManager.createNativeQuery(selectQuery);

        setQueryParameters(query, username, workBasketSearchCriteria);
        query.setFirstResult((paginatedRequest.getOffset()) * paginatedRequest.getLimit());
        query.setMaxResults(paginatedRequest.getLimit());

        List<Object[]> results = query.getResultList();
        return generateWorkBasketDTO(results);
    }

    public long getWorkBasketClaimsCount(WorkBasketSearchCriteria workBasketSearchCriteria, String username) {

        String selectQuery = getWorkBasketQuery().append(generateCloseQuery(workBasketSearchCriteria))
                                                 .toString();
        Query query = entityManager.createNativeQuery(selectQuery);
        setQueryParameters(query, username, workBasketSearchCriteria);
        return query.getResultList().size();
    }

    @SuppressWarnings("unchecked")
    public List<WorkBasketDTO> searchWorkBasketByClaimNumbers(List<String> claimNumbers,
                                                              String username,
                                                              String userGroupId) {

        StringBuffer workBasketQuery = getWorkBasketQuery();
        if (claimNumbers != null && !claimNumbers.isEmpty()) {
            workBasketQuery.append(" AND CLC.CLC_NO in :claimNumbers");
        }

        Query query = entityManager.createNativeQuery(workBasketQuery.toString());
        query.setParameter("username", username);
        query.setParameter("userGroupId", userGroupId);
        query.setParameter("reviewActivityDesc", ClaimEnumConstants.PAYMENT_REVIEW_DESC.toString());
        query.setParameter("approveActivityDesc", ClaimEnumConstants.PAYMENT_APPROVE_DESC.toString());
        if (claimNumbers != null && !claimNumbers.isEmpty()) {
            query.setParameter("claimNumbers", claimNumbers);
        }

        List<Object[]> results = query.getResultList();
        return generateWorkBasketDTO(results);
    }

    private void setQueryParameters(Query query, String username, WorkBasketSearchCriteria workBasketSearchCriteria) {

        query.setParameter("username", username);
        query.setParameter("reviewActivityDesc", ClaimEnumConstants.PAYMENT_REVIEW_DESC.toString());
        query.setParameter("approveActivityDesc", ClaimEnumConstants.PAYMENT_APPROVE_DESC.toString());
        if (!StringUtils.isEmpty(workBasketSearchCriteria.getUserGroupId())) {
            query.setParameter("userGroupId", workBasketSearchCriteria.getUserGroupId());
        }
        if (!StringUtils.isEmpty(workBasketSearchCriteria.getActivity())) {
            query.setParameter("activity", workBasketSearchCriteria.getActivity());
        }
        if (null != workBasketSearchCriteria.getLossDate()) {
            query.setParameter("claimLossDate",
                               new SimpleDateFormat("dd/MMM/yyyy").format(workBasketSearchCriteria.getLossDate()));
        }
        if (null != workBasketSearchCriteria.getApprovedDate()) {
            query.setParameter("claimApprovedDate",
                               new SimpleDateFormat("dd/MMM/yyyy").format(workBasketSearchCriteria.getApprovedDate()));
        }
    }

    private List<WorkBasketDTO> generateWorkBasketDTO(List<Object[]> results) {

        List<WorkBasketDTO> workBasketDTO = new ArrayList<>();
        List<WorkBasketSearchCriteria> workBasket = new ArrayList<>();
        for (Object[] obj : results) {
            WorkBasketSearchCriteria claimDetails = new WorkBasketSearchCriteria();
            claimDetails.setClaimNo((String) obj[0]);
            claimDetails.setWorkerName((String) obj[1]);
            claimDetails.setActivity((String) obj[2]);
            claimDetails.setLossDate((Date) obj[3]);
            claimDetails.setApprovedDate((Date) obj[4]);
            workBasket.add(claimDetails);
            ObjectMapper oMapper = new ObjectMapper();
            SimpleModule module = new SimpleModule();
            module.addSerializer(Date.class, new CustomDateSerializer(dateFormat));
            oMapper.registerModule(module);
            WorkBasketDTO workBasketClaims = oMapper.convertValue(claimDetails, WorkBasketDTO.class);
            workBasketDTO.add(workBasketClaims);
        }
        return workBasketDTO;
    }

    private StringBuffer getWorkBasketQuery() {

        StringBuffer workBasketQuery = new StringBuffer()

                                                         .append("SELECT CLC.CLC_NO AS claimNo,         \n")
                                                         .append("       CLCP.CLCP_NAME AS workerName, \n")
                                                         .append("       UIDDEFN.UID_DESC AS activity, \n")
                                                         .append("       CLC.CLC_CLD AS lossDate,          \n")
                                                         .append("       CLS.CLS_APPRVD AS approvedDate    \n")
                                                         .append("FROM CTDS_LEVEL_C CLC, CTDS_LEVEL_CP CLCP, UDS_ID_DEFN UIDDEFN, CTDS_LEVEL_S CLS, WTDS_LEVEL_A WLA \n")
                                                         .append("WHERE WLA_TXNU = :username \n")
                                                         .append("AND (WLA_ACT_ID = (SELECT UID_ID FROM UDS_ID_DEFN WHERE  UID_ID_TYP = 'WB_ACT_TYP' AND UID_MODULE_TYP = 02 AND UID_DESC = :reviewActivityDesc) ")
                                                         .append("OR WLA_ACT_ID = (SELECT UID_ID FROM UDS_ID_DEFN WHERE  UID_ID_TYP = 'WB_ACT_TYP' AND UID_MODULE_TYP = 02 AND UID_DESC = :approveActivityDesc)) \n")
                                                         .append("AND WLA_TXN_AUG_ID = :userGroupId \n")
                                                         .append("AND CLC_CLF_SGS_ID = WLA_TXN_REF \n")
                                                         .append("AND CLCP_CLF_SGS_ID = WLA_TXN_REF \n")
                                                         .append("AND UID_ID_TYP = 'WB_ACT_TYP' AND UID_ID = WLA_ACT_ID \n")
                                                         .append("AND CLS_CLF_SGS_ID = WLA_TXN_REF AND CLS_SR_NO = (SELECT MAX(CLS_SR_NO) FROM CTDS_LEVEL_S WHERE CLS_CLF_SGS_ID = WLA.WLA_TXN_REF)");
        return workBasketQuery;
    }

    private StringBuffer generateCloseQuery(WorkBasketSearchCriteria workBasketSearchCriteria) {

        StringBuffer closeQuery = new StringBuffer();
        if (!StringUtils.isEmpty(workBasketSearchCriteria.getClaimNo())) {
            closeQuery.append(" AND UPPER(CLC.CLC_NO) LIKE UPPER('%"
                              + workBasketSearchCriteria.getClaimNo()
                              + "%')");
        }

        if (!StringUtils.isEmpty(workBasketSearchCriteria.getWorkerName())) {
            closeQuery.append(" AND UPPER(CLCP.CLCP_NAME) LIKE UPPER('%"
                              + workBasketSearchCriteria.getWorkerName()
                              + "%')");
        }

        if (!StringUtils.isEmpty(workBasketSearchCriteria.getActivity())) {
            closeQuery.append(" AND UIDDEFN.UID_DESC = :activity");
        }

        if (null != workBasketSearchCriteria.getLossDate()) {
            closeQuery.append(" AND CLC.CLC_CLD = :claimLossDate");
        }

        if (null != workBasketSearchCriteria.getApprovedDate()) {
            closeQuery.append(" AND CLS.CLS_APPRVD = :claimApprovedDate");
        }

        return closeQuery;
    }
}

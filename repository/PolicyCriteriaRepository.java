package com.beyontec.mol.repository;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.beyontec.mol.entity.PolicyDetails;
import com.beyontec.mol.modal.PagedResult;
import com.beyontec.mol.modal.PaginatedRequest;
import com.beyontec.mol.modal.Policy;
import com.beyontec.mol.modal.PolicySearchCriteria;

@Repository
public class PolicyCriteriaRepository {

	@Autowired
	private ModelMapper modelMapper;

	@PersistenceContext
	private EntityManager entityManager;

	public PagedResult<Policy> policyCriteriaSearch(PolicySearchCriteria policySearchCriteria, PaginatedRequest paginatedRequest)
			throws ParseException {
		
		System.out.println(paginatedRequest.getLimit());
		System.out.println(paginatedRequest.getOffset());

		PagedResult<Policy> pagedResult = null;

		List<PolicyDetails> policyDetailsList = searchPolicies(policySearchCriteria, paginatedRequest);

		List<Policy> policyList = new ArrayList<Policy>();

		for (PolicyDetails policyDetails : policyDetailsList) {
			Policy policy = convertToEntity(policyDetails);
			policyList.add(policy);

		}

		if (policyList != null && policySearchCriteria != null) {
			pagedResult = new PagedResult<Policy>(policyList, new Long(getClaimCount(policySearchCriteria)));

		}

		return pagedResult;
	}

	private Policy convertToEntity(PolicyDetails policyDetails) throws ParseException {

		Policy policy = modelMapper.map(policyDetails, Policy.class);
		return policy;
	}

	public int getClaimCount(PolicySearchCriteria policySearchCriteria) {
		Criteria criteria = getCriteria(policySearchCriteria);
		return criteria.list().size();
	}

	@SuppressWarnings("unchecked")
	public List<PolicyDetails> searchPolicies(PolicySearchCriteria policySearchCriteria, PaginatedRequest paginatedRequest) {

		Criteria criteria = getCriteria(policySearchCriteria);
		criteria.setFirstResult((paginatedRequest.getOffset() - 1) * paginatedRequest.getLimit());
		criteria.setMaxResults(paginatedRequest.getLimit());

		return criteria.list();
	}

	private Criteria getCriteria(PolicySearchCriteria policySearchCriteria) {

		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(PolicyDetails.class);

		if (!StringUtils.isEmpty(policySearchCriteria.getMasterPolicyNo())) {
			criteria.add(
					Restrictions.like("masterPolicyNo", policySearchCriteria.getMasterPolicyNo(), MatchMode.ANYWHERE));
		}
		if (!StringUtils.isEmpty(policySearchCriteria.getCustomerName())) {
			criteria.add(Restrictions.like("customerName", policySearchCriteria.getCustomerName(), MatchMode.ANYWHERE));
		}

		if (!StringUtils.isEmpty(policySearchCriteria.getProductType())) {
			criteria.add(Restrictions.like("productType", policySearchCriteria.getProductType(), MatchMode.ANYWHERE));
		}

		if (!StringUtils.isEmpty(policySearchCriteria.getSelectPolicyType())) {
			criteria.add(Restrictions.like("selectPolicyType", policySearchCriteria.getSelectPolicyType(),
					MatchMode.ANYWHERE));
		}

		return criteria;
	}
}

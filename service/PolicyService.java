package com.beyontec.mol.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.beyontec.mol.entity.PolicyDetails;
import com.beyontec.mol.modal.PagedResult;
import com.beyontec.mol.modal.PaginatedRequest;
import com.beyontec.mol.modal.Policy;
import com.beyontec.mol.modal.PolicySearchCriteria;
import com.beyontec.mol.repository.PolicyCriteriaRepository;
import com.beyontec.mol.repository.PolicyRepository;

@Service
public class PolicyService {
	
	
	@Autowired
	private PolicyCriteriaRepository policyCriteriaRepository;

	@Autowired
	private PolicyRepository policyRepository;


	@Transactional(readOnly = true)
	public List<PolicyDetails> findAll() {
		return policyRepository.findAll();
	}

	
	@Transactional(readOnly = true)
	public PagedResult<Policy> policyCriteriaSearch(PolicySearchCriteria policySearchCriteria,PaginatedRequest paginatedRequest) throws ParseException {

		PagedResult<Policy> pageResult = policyCriteriaRepository.policyCriteriaSearch(policySearchCriteria,paginatedRequest);
		return pageResult;

	}

}

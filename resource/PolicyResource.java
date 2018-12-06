package com.beyontec.mol.resource;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beyontec.mol.entity.PolicyDetails;
import com.beyontec.mol.modal.PagedResult;
import com.beyontec.mol.modal.PaginatedRequest;
import com.beyontec.mol.modal.Policy;
import com.beyontec.mol.modal.PolicySearchCriteria;
import com.beyontec.mol.service.PolicyService;

@RestController
@RequestMapping("/api")
public class PolicyResource {

	@Autowired
	private PolicyService policyService;

	//@ResponseStatus(code=HttpStatus.BAD_REQUEST, reason = "Some parameters are invalid")
	@GetMapping(path = "/policies", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<PolicyDetails>> findAll() throws ParseException {
		List<PolicyDetails> policyList = policyService.findAll();
		return ResponseEntity.ok(policyList);
	}

	//@ResponseStatus(code=HttpStatus.BAD_REQUEST, reason = "Some parameters are invalid")
	@SuppressWarnings("rawtypes")
	@PostMapping(path = "/search/policy", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<PagedResult> policyCriteriaSearch(@Valid @RequestBody PolicySearchCriteria policySearchCriteria,PaginatedRequest paginatedRequest) throws ParseException {
		PagedResult<Policy> policyDTO =  policyService.policyCriteriaSearch(policySearchCriteria,paginatedRequest);
		return ResponseEntity.ok(policyDTO);
	}


}

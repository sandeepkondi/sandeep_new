package com.beyontec.mol.resource;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.beyontec.mol.modal.InsurerProcessDTO;
import com.beyontec.mol.modal.InsurerProcessSearchCriteria;
import com.beyontec.mol.modal.PagedResult;
import com.beyontec.mol.modal.PaginatedRequest;
import com.beyontec.mol.service.InsurerService;

@RestController
@RequestMapping("/api/insurer")
public class InsurerResource {

    @Autowired InsurerService insurerService;

    @RequestMapping(value = "/searchProcess", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PagedResult<InsurerProcessDTO>> searchInsurerProcess(@RequestBody InsurerProcessSearchCriteria searchCriteria,
                                                                               PaginatedRequest paginatedRequest,
                                                                               HttpServletRequest request) {
        return ResponseEntity.ok(insurerService.searchInsurerProcess(searchCriteria,
                                                                     paginatedRequest,
                                                                     request.getLocale()));
    }
}

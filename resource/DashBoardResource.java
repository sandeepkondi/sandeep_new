package com.beyontec.mol.resource;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.beyontec.mol.modal.ActivePolicy;
import com.beyontec.mol.modal.DashBoard;
import com.beyontec.mol.modal.DashBoardSearchCriteria;
import com.beyontec.mol.service.DashBoardService;

@RestController
@RequestMapping("/api/dashboard")
public class DashBoardResource {
    @Autowired private DashBoardService dashBoardService;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DashBoard> get(@RequestBody DashBoardSearchCriteria searchCriteria,
                                         HttpServletRequest request) {
        return ResponseEntity.ok(dashBoardService.get(searchCriteria, request.getLocale()));
    }

    @GetMapping(value = "/activePolicy")
    public ResponseEntity<List<ActivePolicy>> getActivePolicy(HttpServletRequest request) {
        return ResponseEntity.ok(dashBoardService.getActivePolicy(request.getLocale()));
    }
}

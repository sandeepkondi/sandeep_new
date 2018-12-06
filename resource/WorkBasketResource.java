package com.beyontec.mol.resource;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beyontec.mol.modal.PaginatedRequest;
import com.beyontec.mol.modal.WorkBasketSearchCriteria;
import com.beyontec.mol.service.WorkBasketService;
import com.beyontec.mol.util.AppConstants;

@RestController
@RequestMapping("/api/work-basket")
public class WorkBasketResource {

    @Autowired private WorkBasketService workBasketService;

    @PostMapping(value = "/search")
    public ResponseEntity<?> searchWorkBasketDetails(@RequestBody WorkBasketSearchCriteria workBasketSearchCriteria,
                                                     PaginatedRequest paginatedRequest) {

        return ResponseEntity.ok(workBasketService.searchWorkBasket(workBasketSearchCriteria, paginatedRequest));
    }

    @PostMapping(value = "/export")
    public ResponseEntity<?> exportWorkbasket(@RequestBody List<String> claimNumbers,
                                              @RequestHeader("userGroupId") String userGroupId) throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {

        byte[] excelByteArray = workBasketService.exportWorkbasket(claimNumbers, userGroupId);

        return ResponseEntity.ok()
                             .contentLength(excelByteArray.length)
                             .header(HttpHeaders.CONTENT_DISPOSITION,
                                     MessageFormat.format(AppConstants.ATTACHMENT,
                                                          AppConstants.WORKBASKET_FILENAME
                                                                                   + AppConstants.EXCEL_FILE_EXTENSION))
                             .header(HttpHeaders.CONTENT_TYPE, AppConstants.EXCEL_CONTENT_TYPE)
                             .body(new ByteArrayResource(excelByteArray));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, value = "/activities")
    public ResponseEntity<?> getWorkBasketActivities() {

        List<String> workBasketActivities = workBasketService.getWorkBasketActivities();
        return ResponseEntity.ok(workBasketActivities);
    }
}

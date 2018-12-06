package com.beyontec.mol.service;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.beyontec.mol.modal.PagedResult;
import com.beyontec.mol.modal.PaginatedRequest;
import com.beyontec.mol.modal.WorkBasketDTO;
import com.beyontec.mol.modal.WorkBasketSearchCriteria;
import com.beyontec.mol.repository.UdsIdDefinitionRepository;
import com.beyontec.mol.repository.WorkBasketDAO;
import com.beyontec.mol.util.AppConstants;
import com.beyontec.mol.util.ClaimEnumConstants;
import com.beyontec.mol.util.JWTUtil;
import com.beyontec.mol.util.ReportGeneratorUtil;
import com.beyontec.mol.util.UserRoleValidationUtil;

@Service
public class WorkBasketService extends BaseService {

    @Autowired private WorkBasketDAO workBasketDAO;

    @Autowired private UserRoleValidationUtil userRoleValidationUtil;

    @Autowired private UdsIdDefinitionRepository udsIdDefinitionRepository;

    @Autowired private ReportGeneratorUtil reportGeneratorUtil;

    @Transactional
    public PagedResult<WorkBasketDTO> searchWorkBasket(WorkBasketSearchCriteria workBasketSearchCriteria,
                                                       PaginatedRequest paginatedRequest) {

        List<WorkBasketDTO> workBasket = workBasketDAO.searchWorkBasket(workBasketSearchCriteria,
                                                                        JWTUtil.getUserId(),
                                                                        paginatedRequest);
        return new PagedResult<WorkBasketDTO>(workBasket,
                                              workBasketDAO.getWorkBasketClaimsCount(workBasketSearchCriteria,
                                                                                     JWTUtil.getUserId()));
    }

    @Transactional
    public byte[] exportWorkbasket(List<String> claimNumbers,
                                   String userGroupId) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException, IOException {

        // validate user has valid group id
        userRoleValidationUtil.validateUserGroupId(userGroupId);

        List<WorkBasketDTO> workBasketList = workBasketDAO.searchWorkBasketByClaimNumbers(claimNumbers,
                                                                                      JWTUtil.getUserId(),
                                                                                      userGroupId);
        return reportGeneratorUtil.generateExcel(null,
                                                 AppConstants.WORKBASKET_COLUMN_HEADERS,
                                           AppConstants.WORKBASKET_COLUMN_FIELDS,
                                           workBasketList,
                                           AppConstants.WORKBASKET_FILENAME);
    }

    public List<String> getWorkBasketActivities() {

        return invokeRepo(() -> udsIdDefinitionRepository.findWorkBasketActivities(ClaimEnumConstants.PAYMENT_REVIEW_DESC.toString(),
                                                                                   ClaimEnumConstants.PAYMENT_APPROVE_DESC.toString()),
                          "udsIdDefinitionRepository.findWorkBasketActivities(ClaimConstants.PAYMENT_REVIEW_DESC.toString(), ClaimConstants.PAYMENT_APPROVE_DESC.toString()");
    }
}

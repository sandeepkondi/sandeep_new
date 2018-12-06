package com.beyontec.mol.service;

import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.beyontec.mol.config.CommonConfig;
import com.beyontec.mol.exception.ErrorCode;
import com.beyontec.mol.exception.ValidationException;
import com.beyontec.mol.modal.InsurerProcessDTO;
import com.beyontec.mol.modal.InsurerProcessSearchCriteria;
import com.beyontec.mol.modal.PagedResult;
import com.beyontec.mol.modal.PaginatedRequest;
import com.beyontec.mol.repository.BsdsBatchHdrRepository;
import com.beyontec.mol.util.AppConstants;
import com.beyontec.mol.util.DateUtil;

@Service
public class InsurerService extends BaseService {

    @Autowired BsdsBatchHdrRepository bsdsBatchHdrRepo;

    public PagedResult<InsurerProcessDTO> searchInsurerProcess(InsurerProcessSearchCriteria searchCriteria,
                                                               PaginatedRequest paginatedRequest,
                                                               Locale locale) {
        validateSearchCriteria(searchCriteria);

        String isEngLocale = (locale.getLanguage().equals(AppConstants.ENGLISH)) ? "true" : "false";
        List<InsurerProcessDTO> insurerProcesses = getInsurerProcess(searchCriteria,
                                                                     isEngLocale,
                                                                     new PageRequest(paginatedRequest.getOffset(),
                                                                                     paginatedRequest.getLimit()));
        long insurerProcessCount = getInsurerProcess(searchCriteria, isEngLocale, null).size();
        return new PagedResult<>(insurerProcesses, insurerProcessCount);
    }

    private List<InsurerProcessDTO> getInsurerProcess(InsurerProcessSearchCriteria searchCriteria,
                                                      String isEngLocale,
                                                      PageRequest pageRequest) {

        return invokeRepo(() -> bsdsBatchHdrRepo.getInsurerProcess(CommonConfig.DATE_FORMAT.toPattern(),
                                                                   validateStr(searchCriteria.getFromDate()),
                                                                   validateStr(searchCriteria.getToDate()),
                                                                   validateStr(searchCriteria.getProcess()),
                                                                   validateStr(searchCriteria.getBatchId()),
                                                                   validateStr(searchCriteria.getStatus()),
                                                                   isEngLocale,
                                                                   pageRequest),
                          "bsdsBatchHdrRepo.getInsurerProcess()");
    }

    private String validateStr(String str) {
        if (StringUtils.isNotEmpty(str) && str.equalsIgnoreCase("*")) { return null; }
        if (StringUtils.isNotEmpty(str)) { return str; }
        return null;
    }

    private void validateSearchCriteria(InsurerProcessSearchCriteria searchCriteria) {

        if (StringUtils.isNotBlank(searchCriteria.getFromDate())
            && DateUtil.convert(searchCriteria.getFromDate()) == null) {
            throw new ValidationException(ErrorCode.INSURER_PROCESS_FROM_DATE_FORMAT_INVALID,
                                          CommonConfig.DATE_FORMAT.toPattern());
        } else if (StringUtils.isNotBlank(searchCriteria.getToDate())
                   && DateUtil.convert(searchCriteria.getToDate()) == null) {
            throw new ValidationException(ErrorCode.INSURER_PROCESS_TO_DATE_FORMAT_INVALID,
                                          CommonConfig.DATE_FORMAT.toPattern());
        }
    }
}

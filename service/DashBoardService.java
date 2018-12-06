package com.beyontec.mol.service;

import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beyontec.mol.config.CommonConfig;
import com.beyontec.mol.exception.ErrorCode;
import com.beyontec.mol.exception.ValidationException;
import com.beyontec.mol.modal.ActivePolicy;
import com.beyontec.mol.modal.DashBoard;
import com.beyontec.mol.modal.DashBoardCoInsurerSummary;
import com.beyontec.mol.modal.DashBoardSearchCriteria;
import com.beyontec.mol.modal.DashBoardWorkerSummary;
import com.beyontec.mol.repository.PolicyHistoryRepository;
import com.beyontec.mol.util.AppConstants;
import com.beyontec.mol.util.DateUtil;

@Service
public class DashBoardService extends BaseService {
    @Autowired private PolicyHistoryRepository policyHistoryRepo;

    public DashBoard get(DashBoardSearchCriteria searchCriteria, Locale locale) {

        // set default value if empty
        if (StringUtils.isBlank(searchCriteria.getFromDate())
                   && !StringUtils.isBlank(searchCriteria.getToDate())) {
            throw new ValidationException(ErrorCode.EMPTY_DASHBOARD_FROM_DATE);
        } else if (!StringUtils.isBlank(searchCriteria.getFromDate())
                   && StringUtils.isBlank(searchCriteria.getToDate())) {
            throw new ValidationException(ErrorCode.EMPTY_DASHBOARD_TO_DATE);
        } else if (!StringUtils.isBlank(searchCriteria.getFromDate())
                   && DateUtil.convert(searchCriteria.getFromDate()) == null) {
            throw new ValidationException(ErrorCode.DASHBOARD_FROM_DATE_FORMAT_INVALID,
                                          CommonConfig.DATE_FORMAT.toPattern());
        } else if (!StringUtils.isBlank(searchCriteria.getToDate())
                   && DateUtil.convert(searchCriteria.getToDate()) == null) {
            throw new ValidationException(ErrorCode.DASHBOARD_TO_DATE_FORMAT_INVALID,
                                          CommonConfig.DATE_FORMAT.toPattern());
        } else {
            if (StringUtils.isBlank(searchCriteria.getToDate())) {
                searchCriteria.setToDate(DateUtil.toString(DateUtil.now()));
            }
            if (StringUtils.isBlank(searchCriteria.getFromDate())) {
                searchCriteria.setFromDate(DateUtil.toString(DateUtil.extendDate(DateUtil.convert(searchCriteria.getToDate()),
                                                                                 -1,
                                                                                 0)));
            }
        }
        searchCriteria.setWorkerType(StringUtils.isBlank(searchCriteria.getWorkerType()) ? "*"
                                                                                             : searchCriteria.getWorkerType());
        searchCriteria.setJobTitle(StringUtils.isBlank(searchCriteria.getJobTitle()) ? "*"
                                                                                     : searchCriteria.getJobTitle());
        searchCriteria.setNationality(StringUtils.isBlank(searchCriteria.getNationality()) ? "*"
                                                                                           : searchCriteria.getNationality());
        searchCriteria.setGender(StringUtils.isBlank(searchCriteria.getGender()) ? "*" : searchCriteria.getGender());
        searchCriteria.setIndustry(StringUtils.isBlank(searchCriteria.getIndustry()) ? "*"
                                                                                     : searchCriteria.getIndustry());
        
        // fetch worker summary
        List<DashBoardWorkerSummary> workerSummarySplitUps = invokeRepo(() -> policyHistoryRepo.getDashBoardWorkerSummarySplitUps(CommonConfig.DATE_FORMAT.toPattern(),
                                                                                                                                  searchCriteria.getFromDate(),
                                                                                                                                  searchCriteria.getToDate(),
                                                                                                                                  searchCriteria.getWorkerType(),
                                                                                                                                  searchCriteria.getJobTitle(),
                                                                                                                                  searchCriteria.getNationality(),
                                                                                                                                  searchCriteria.getGender(),
                                                                                                                                  searchCriteria.getIndustry()),
                                                                        "policyHistoryRepo.getDashBoardWorkerSummarySplitUps(searchCriteria.getFromDate(), searchCriteria.getToDate())");

        // fetch co-insurer summary
        List<DashBoardCoInsurerSummary> coInsurerSummarySplitUps = invokeRepo(() -> policyHistoryRepo.getDashBoardCoInsurerSummarySplitUps(CommonConfig.DATE_FORMAT.toPattern(),
                                                                                                                                           searchCriteria.getFromDate(),
                                                                                                                                           searchCriteria.getToDate(),
                                                                                                                                           searchCriteria.getWorkerType(),
                                                                                                                                           searchCriteria.getJobTitle(),
                                                                                                                                           searchCriteria.getNationality(),
                                                                                                                                           searchCriteria.getGender(),
                                                                                                                                           searchCriteria.getIndustry()),
                                                                           "policyHistoryRepo.getDashBoardCoInsurerSummarySplitUps()");

        // prepare data by grouping the category
        return new DashBoard(workerSummarySplitUps, coInsurerSummarySplitUps, locale);
    }

    public List<ActivePolicy> getActivePolicy(Locale locale) {
        List<ActivePolicy> activePolicies = policyHistoryRepo.getActivePolicy();
        activePolicies.forEach(activePolicy -> activePolicy.setWorkerType(locale.getLanguage()
                                                                                  .equals(AppConstants.ENGLISH) ? activePolicy.getWorkerTypeEn()
                                                                                                                : activePolicy.getWorkerTypeAr()));
        return activePolicies;
    }
}

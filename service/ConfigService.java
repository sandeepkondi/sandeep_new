package com.beyontec.mol.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beyontec.mol.config.CommonConfig;
import com.beyontec.mol.config.UdsIdDefConfig;
import com.beyontec.mol.entity.UdsIdDefinition;
import com.beyontec.mol.entity.UdsProduct;
import com.beyontec.mol.repository.UdsIdDefinitionRepository;
import com.beyontec.mol.repository.UdsProductRepository;
import com.beyontec.mol.util.AppConstants;

@Service
public class ConfigService extends BaseService {
    @Autowired private UdsProductRepository udsProductRepo;
    @Autowired private UdsIdDefinitionRepository udsIdDefinitionRepo;

    public List<UdsProduct> getAllUdsProducts() {
        List<UdsProduct> udsProducts = invokeRepo(() -> udsProductRepo.findByCompanyId(CommonConfig.COMPANY_ID),
                                                  "udsProductRepo.findByCompanyId(CommonConfig.COMPANY_ID)");
        return udsProducts;
    }

    public List<UdsIdDefinition> getConfigByType(String type,
                                                 Integer limit,
                                                 String searchStr,
                                                 boolean isEnglishLocale) {

        String isRetrieveAll = (null == limit) ? "true" : "false";
        int totalConfig = (null == limit) ? 0 : limit.intValue();
        String engDesc = (isEnglishLocale && StringUtils.isNotBlank(searchStr)) ? searchStr : null;
        String arabDesc = (!isEnglishLocale && StringUtils.isNotBlank(searchStr)) ? searchStr : null;
        return udsIdDefinitionRepo.findConfigByType(CommonConfig.COMPANY_ID,
                                                    getConfigType(type),
                                                    engDesc,
                                                    arabDesc,
                                                    totalConfig,
                                                    isRetrieveAll);
    }

    public List<UdsProduct> getWorkerTypes() {
        return udsProductRepo.getWorkerTypes();
    }

    private String getConfigType(String type) {
        switch (type.trim().toUpperCase()) {
            case AppConstants.MOHRE_JOB_CONFIG:
                return UdsIdDefConfig.ID_TYPE_MOHRE_JOB_ID;
            case AppConstants.GENDER_CONFIG:
                return UdsIdDefConfig.ID_TYPE_GENDER;
            case AppConstants.NATIONALITY_CONFIG:
                return UdsIdDefConfig.ID_TYPE_NATIONALITY;
            case AppConstants.INDUSTRY_CONFIG:
                return UdsIdDefConfig.ID_TYPE_INDUS_TYPE;
            case AppConstants.INSURER_PROCESS_CONFIG:
                return UdsIdDefConfig.ID_TYPE_INSURER_PROCESS_TYPE;
            case AppConstants.INSURER_PROCESS_STATUS_CONFIG:
                return UdsIdDefConfig.ID_TYPE_INSURER_PROCESS_STATUS_TYPE;
            default:
                return null;
        }
    }
}

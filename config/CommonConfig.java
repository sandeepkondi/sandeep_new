package com.beyontec.mol.config;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.beyontec.mol.entity.Company;
import com.beyontec.mol.entity.UdsIdDefinition;
import com.beyontec.mol.entity.UdsProduct;
import com.beyontec.mol.repository.CompanyRepository;
import com.beyontec.mol.repository.UdsIdDefinitionRepository;
import com.beyontec.mol.repository.UdsProductRepository;
import com.beyontec.mol.service.BaseService;
import com.beyontec.mol.util.DateUtil;

@Component
public class CommonConfig extends BaseService implements InitializingBean {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommonConfig.class);

    // Date configs
    @Value("${date.format}") private String dateFormat;
	public static SimpleDateFormat DATE_FORMAT;
    public static DateTimeFormatter DATE_TIME_FORMATTER;
    public static Date DATE_ORIGIN;

    // Company configs
    public static Company COMPANY;
    public static String COMPANY_ID;

    // UDS ID Definition configs
    public static Map<String, Map<String, UdsIdDefinition>> udsIdTypeIdIndex = new HashMap<>();

    // Defaults
    public static final String FLAG_NO = "N";

    public static final String RECORD_TYPE_N = "N";
    public static final String RECORD_TYPE_I = "I";
    public static final String RECORD_TYPE_U = "U";

    public static final Long DEFAULT_VERSION_NUMBER = 0L;

    public static final String BTYPE_POLICY = "P";

    public static final String PREFERRED_LANG_EN = "en";

    public static final String MODULE_ID_01 = "01";

    public static final String TXN_TYPE_P = "P";

    public static final String EMP_CATEG_DOMESTIC = "D";
    public static final String EMP_CATEG_INSTITUTIONAL = "I";

    public static final String TXN_TYPE_NEW = "DIC.*.*.UW_TXN_TYP.1";
    public static final String TXN_TYPE_RENEWAL = "DIC.*.*.UW_TXN_TYP.2";

    public static final CharSequence DELIMITER_COMMA = ",";

    @Autowired private CompanyRepository companyRepo;
    @Autowired private UdsIdDefinitionRepository udsIdDefinitionRepo;
    @Autowired private UdsProductRepository productRepo;

	@Override
	public void afterPropertiesSet() throws Exception {
		loadDateConfigs();
        loadCompanyConfigs();
        loadUdsIdDefinitionConfigs();
        loadProductConfig();
	}

    private void loadCompanyConfigs() {
        List<Company> companies = invokeRepo(() -> companyRepo.findAll(), "companyRepo.findAll()");

        // Only one company will be present in the DB and the table will not be empty
        COMPANY = companies.get(0);
        COMPANY_ID = COMPANY.getId();
    }

    private void loadDateConfigs() {
        DATE_FORMAT = new SimpleDateFormat(dateFormat);
		DATE_FORMAT.setLenient(false);

        DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(dateFormat, Locale.ENGLISH);

        Date now = DateUtil.now();
        DATE_ORIGIN = DateUtil.setYears(now, 1);
    }

    private void loadUdsIdDefinitionConfigs() {
        List<UdsIdDefinition> udsIdDefinitions = invokeRepo(() -> udsIdDefinitionRepo.findByCompanyId(COMPANY_ID),
                                                            "udsIdDefinitionRepo.findByCompanyId(COMPANY_ID)");

        udsIdDefinitions.forEach(udsIdDefinition -> {
            String idType = udsIdDefinition.getUID_ID_TYP();
            Map<String, UdsIdDefinition> idIndex = udsIdTypeIdIndex.get(idType);

            if (idIndex == null) {
                idIndex = new HashMap<>();
                udsIdTypeIdIndex.put(idType, idIndex);
            }
            idIndex.put(udsIdDefinition.getUID_ID(), udsIdDefinition);
        });
    }

    private static Map<String, UdsProduct> productIdProductIndex = new HashMap<>();
    private void loadProductConfig() {
        List<UdsProduct> products = productRepo.findByCompanyId(COMPANY_ID);
        if (CollectionUtils.isEmpty(products)) { return; }
        products.forEach(product -> productIdProductIndex.put(product.getUP_PROD_ID(), product));
    }
    public static UdsProduct getProduct(String productId) { return productIdProductIndex.get(productId); }

    public static String getServerIpAddress() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {
            LOGGER.error("Unable to get Server IP Address. Exception: " + e.getMessage(), e);
            return null;
        }
    }
}

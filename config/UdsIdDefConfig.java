package com.beyontec.mol.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.beyontec.mol.entity.UdsIdDefinition;
import com.beyontec.mol.exception.ApplicationException;
import com.beyontec.mol.exception.ErrorCode;
import com.beyontec.mol.exception.ResponseStatusCode;
import com.beyontec.mol.exception.ValidationException;

public class UdsIdDefConfig {

    public static final String ID_TYPE_RISK_TYPE = "MAP_ULR_RISK_TYP";
    public static final String ID_TYPE_EMP_CATG = "EMP_CATG_TYP";
    public static final String ID_TYPE_TRAN_TYPE = "UW_TXN_TYP";
    public static final String ID_TYPE_MOHRE_JOB_ID = "JOB_ID_1";
    public static final String ID_TYPE_ENSCO_JOB_ID = "JOB_ID_2";
    public static final String ID_TYPE_EST_CLASS_TYPE = "EMPL_EST_CLASS_TYP";
    public static final String ID_TYPE_INDUS_TYPE = "EMPL_IND_TYP";
    public static final String ID_TYPE_COUNTRY = "COUNTRY";
    public static final String ID_TYPE_GENDER = "GENDER";
    public static final String ID_TYPE_NATIONALITY = "NATIONALITY";
    public static final String ID_TYPE_MARITAL_STATUS = "MARITAL_STS";
    public static final String ID_TYPE_PASSPORT_TYPE = "PP_TYP";
    public static final String ID_TYPE_PAYMENT_TYPE = "LOSS_TYP";
    public static final String ID_TYPE_CANCELATION_TYPE = "FT04_RSN";
    public static final String ID_TYPE_INSURER_PROCESS_TYPE = "BBH_TYP";
    public static final String ID_TYPE_INSURER_PROCESS_STATUS_TYPE = "BBH_STATUS";

    public static final String ID_TYPE_DEFAULT_DATA = "DFLT_DATA";

    public static final String ID_DEFAULT_CUST_ID_TYPE1 = "DFLT_UCD_ID_TYP1";
    public static final String ID_DEFAULT_CUST_ID_TYPE2 = "DFLT_UCD_ID_TYP2";
    public static final String ID_DEFAULT_CUST_CATEGORY_ID = "DFLT_UCD_CUST_CATG_ID";
    public static final String ID_DEFAULT_INTALL_DUE_DATE = "DFLT_ULI_DUE_DATE";
    public static final String ID_DEFAULT_CREATED_USER = "DFLT_ULM_CRU";

    private static Map<String, UdsIdDefinition> getUdsIdDefinitions(String idType, ApplicationException ae) {
        Map<String, UdsIdDefinition> udsIdDef = CommonConfig.udsIdTypeIdIndex.get(idType);
        if (udsIdDef != null) { return udsIdDef; }
        if (ae == null) {
            throw new ApplicationException(ResponseStatusCode.NOT_FOUND,
                                           ErrorCode.UDS_ID_DEFS_NOT_FOUND,
                                           getIdTypeDispName(idType));
        }
        ae.appendErr(ErrorCode.UDS_ID_DEFS_NOT_FOUND, getIdTypeDispName(idType));
        return new HashMap<>(0);
    }

    public static UdsIdDefinition getUdsIdDefinition(String idType, String id) { return getUdsIdDefinition(idType, id, null); }

    public static UdsIdDefinition getUdsIdDefinition(String idType, String id, ApplicationException ae) {
        UdsIdDefinition udsIdDefinition = getUdsIdDefinitions(idType, ae).get(id);
        if (udsIdDefinition != null) { return udsIdDefinition; }

        Map<ErrorCode, Object[]> errorDetails = new HashMap<>();
        errorDetails.put(ErrorCode.UDS_ID_DEF_NOT_FOUND, new Object[] { getIdTypeDispName(idType), getIdDispName(id) });
        throw new ValidationException(errorDetails);
//        throw new ApplicationException(ResponseStatusCode.NOT_FOUND,
//                                       ErrorCode.UDS_ID_DEF_NOT_FOUND,
//                                       getIdTypeDispName(idType),
//                                       getIdDispName(id));
    }

    public static UdsIdDefinition getUdsIdDefinitionDetails(String idType, String id) {
        return getUdsIdDefinition(idType, id);
    }

    public static String getUdsIdDefinitionDesc(String idType, String id) {
        if (StringUtils.isBlank(idType) || StringUtils.isBlank(id)) { return null; }
        return getUdsIdDefinition(idType, id).getUID_DESC();
    }

    public static String getUdsIdDefinitionValue(String idType, String id) {
        return getUdsIdDefinition(idType, id).getUID_VALUE();
    }
    public static String getRiskType(String udsIdDefId)     { return getUdsIdDefinitionValue(ID_TYPE_RISK_TYPE, udsIdDefId); }

    public static boolean isCodifiedValue(String idType, String value, ApplicationException ae) {
        Set<String> udsIdDefinitions = getUdsIdDefinitions(idType, ae).keySet();
        return isCodifiedValue(udsIdDefinitions, idType, value, ae);
    }

    private static boolean isCodifiedValue(Set<? extends Object> udsIdDefinitions,
                                           String idType,
                                           Object value,
                                           ApplicationException ae) {
        if (udsIdDefinitions.contains(value)) { return true; }
        if (ae == null) {
            throw new ApplicationException(ResponseStatusCode.INVALID_REQUEST,
                                           ErrorCode.INVALID_CODIFIED_VALUE,
                                           getIdTypeDispName(idType));
        }
        ae.appendErr(ErrorCode.INVALID_CODIFIED_VALUE, getIdTypeDispName(idType));
        return false;
    }

    public static String getIdTypeDispName(String udsIdDefType) {
        switch (udsIdDefType) {
            // @formatter:off
            case ID_TYPE_RISK_TYPE        : return "Risk Type";
            case ID_TYPE_EMP_CATG         : return "Employee Category";
            case ID_TYPE_TRAN_TYPE        : return "Transaction Type";
            case ID_TYPE_MOHRE_JOB_ID     : return "MOHRE Job ID";
            case ID_TYPE_ENSCO_JOB_ID     : return "ENSCO Job ID";
            case ID_TYPE_EST_CLASS_TYPE   : return "Establishment Class Type";
            case ID_TYPE_INDUS_TYPE       : return "Industry Type";
            case ID_TYPE_DEFAULT_DATA     : return "Default Data";
            case ID_TYPE_CANCELATION_TYPE : return "Cancelation Type";
            default                       : return udsIdDefType;
            // @formatter:on
        }
    }

    public static String getIdDispName(String udsIdDefId) {
        String defaultPrefix = "Default ";
        switch (udsIdDefId) {
            // @formatter:off
            case ID_DEFAULT_CUST_ID_TYPE1   : return defaultPrefix + "Customer ID Type 1";
            case ID_DEFAULT_CUST_ID_TYPE2   : return defaultPrefix + "Customer ID Type 2";
            case ID_DEFAULT_CUST_CATEGORY_ID: return defaultPrefix + "Customer Category ID";
            case ID_DEFAULT_INTALL_DUE_DATE : return defaultPrefix + "Installment Due Date";
            case ID_DEFAULT_CREATED_USER    : return defaultPrefix + "Created User";
            default                         : return udsIdDefId;
            // @formatter:on

        }
    }
}

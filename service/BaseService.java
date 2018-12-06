package com.beyontec.mol.service;

import java.util.List;
import java.util.Locale;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import com.beyontec.mol.config.CommonConfig;
import com.beyontec.mol.exception.ApplicationException;
import com.beyontec.mol.exception.ErrorCode;
import com.beyontec.mol.exception.ResponseStatusCode;
import com.beyontec.mol.exception.ValidationException;

public class BaseService {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseService.class);

    @Autowired private MessageSource messageSource;
    @Autowired private EntityManager em;

    protected <RESULT> RESULT invokeRepo(boolean throughWhenNotFound, Supplier<RESULT> action, String entityName) {
        RESULT result = invokeRepo(action, entityName);
        if (! throughWhenNotFound) { return result; }

        if (result == null) { throwNotFound(entityName); }
        if (result instanceof List && CollectionUtils.isEmpty((List<RESULT>) result)) {
            throwNotFound(entityName);
        }
        return result;
    }

    private void throwNotFound(String entityName) {
        throw new ApplicationException(ResponseStatusCode.NOT_FOUND,
                                       ErrorCode.ENTITY_NOT_FOUND_WITH_ENTITY_NAME,
                                       entityName);
    }

    protected <RESULT> RESULT invokeRepo(Supplier<RESULT> action, String operation) {
        try {
            LOGGER.debug(operation);
            return action.get();
        } catch (Exception e) {
            LOGGER.error(operation);
            LOGGER.error(e.getMessage());
            throw new ApplicationException(ErrorCode.PERSIST_ERROR, operation, e);
        }
    }

    protected <RESULT> RESULT invokeRepo(Supplier<RESULT> action, String operation, boolean isDetachEntity) {
        RESULT result = invokeRepo(action, operation);
        if (! isDetachEntity) { return result; }
        if (result instanceof List) {
            detachEntities((List<RESULT>) result);
        } else {
            detachEntities(result);
        }
        return result;
    }

    protected <RESULT> RESULT invokeModelMapper(Supplier<RESULT> action, String operation) {
        try {
            LOGGER.debug(operation);
            return action.get();
        } catch (Exception e) {
            LOGGER.error(operation);
            LOGGER.error(e.getMessage());
            throw new ApplicationException(ErrorCode.MODEL_MAPPER_ERROR, operation, e);
        }
    }

    protected <RESULT> void detachEntities(List<RESULT> results) {
        if (CollectionUtils.isEmpty(results)) { return; }
        results.forEach((entity) -> detachEntities(entity));
    }

    protected <RESULT> void detachEntities(RESULT result) {
        if (result == null) { return; }
        try {
            em.detach(result);
        } catch (Exception e) {
            throw new ApplicationException(e.getMessage(), e, ErrorCode.PERSIST_ERROR);
        }
    }

    protected String getErrorMessage(ErrorCode errorCode, Object[] args, Locale locale) {
        return getErrorMessage(errorCode.getCode(), args, locale);
    }

    protected String getErrorMessage(String errorCode, Object[] args, Locale locale) {
        return messageSource.getMessage(errorCode, args, "", locale);
    }

    protected String getErrorMessage(ErrorCode errorCode, Locale locale) {
        return getErrorMessage(errorCode, null, locale);
    }

    protected String getErrorMessage(String errorCode, Locale locale) {
        Object[] args = null;
        return getErrorMessage(errorCode, args, locale);
    }

    protected String getErrorMessage(Exception e, Locale locale) {

        if (e instanceof ValidationException) {
            return ((ValidationException) e).getErrorDetails()
                                            .entrySet()
                                            .stream()
                                            .map(error -> getErrorMessage(error.getKey(),
                                                                          error.getValue(),
                                                                          locale))
                                            .collect(Collectors.joining(CommonConfig.DELIMITER_COMMA));
        }

        if (! (e instanceof ApplicationException)) { return e.getMessage(); }

        ApplicationException ae = (ApplicationException) e;
        String errorMessage = "";
        errorMessage += ae.getErrors()
                                .stream()
                                .map((error) -> getErrorMessage(error.getCode(), error.getDataArr(), locale))
                                .collect(Collectors.joining(CommonConfig.DELIMITER_COMMA));
        if (ae.getErrorCode() != null) { errorMessage += getErrorMessage(ae.getErrorCode(), locale); }
        return errorMessage;
    }
}

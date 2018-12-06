package com.beyontec.mol.resource;

import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;


public abstract class BaseResource {

    protected String getErrorMessage(Errors errors) {
        return errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(","));
    }

    protected String getClientIpAddress(HttpServletRequest httpServletRequest) {
        String forwardedFor = httpServletRequest.getHeader("X-Forwarded-For");
        if (StringUtils.isNotBlank(forwardedFor)) { return forwardedFor; }

        return httpServletRequest.getRemoteAddr();
    }
}

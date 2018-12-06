package com.beyontec.mol.exception;

import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = OAuthExceptionSerializer.class)
public class OAuthException extends OAuth2Exception {

    private static final long serialVersionUID = 6078010989267403023L;

    public OAuthException(String msg) {
        super(msg);
    }
}

package com.beyontec.mol.exception;

public enum ResponseStatusCode {

    OK,
    CREATED,
    UPDATED,
    DELETED,

    INVALID_REQUEST,
    NOT_AUTHENTICATED,
    ACCESS_DENIED,
    NOT_FOUND,
    DUPLICATE,
    UNSUPPORTED_FILE_FORMAT,
    VALIDATION_FAILED,
    UNKNOWN_ERROR;
}

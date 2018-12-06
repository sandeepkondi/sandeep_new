package com.beyontec.mol.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class ApplicationException extends RuntimeException {
    private static final long serialVersionUID = -4371491428087549416L;

    private ErrorCode code;

    private List<ErrorDetail> errors = new ArrayList<>();
    private ResponseStatusCode responseStatusCode;

    public ApplicationException() {}
    public ApplicationException(ErrorCode code) {
        super();
        this.code = code;
    }

    public ApplicationException(String message, Throwable cause, ErrorCode code) {
        super(message, cause);
        this.code = code;
    }

    public ApplicationException(String message, ErrorCode code) {
        super(message);
        this.code = code;
    }

    public ApplicationException(Throwable cause, ErrorCode code) {
        super(cause);
        this.code = code;
    }

    public ApplicationException(ResponseStatusCode responseStatusCode) {
        this.responseStatusCode = responseStatusCode;
    }

    public ApplicationException(ResponseStatusCode responseStatusCode, ErrorCode errCode, Throwable cause) {
        super(cause);
        this.responseStatusCode = responseStatusCode;
        appendErr(errCode);
    }

    public ApplicationException(ResponseStatusCode responseStatusCode, ErrorCode errCode, Object... data) {
        this(responseStatusCode, errCode, null, null, data);
    }

    public ApplicationException(ResponseStatusCode responseStatusCode,
                                ErrorCode errCode,
                                String message,
                                Throwable cause,
                                Object... data) {
        super(message, cause);
        this.responseStatusCode = responseStatusCode;
        appendErr(errCode, data);
    }

    public ApplicationException(ErrorCode errorCode, String causeContext, Throwable cause) {
        super(cause);
        ErrorDetail errorDetail = appendErr(errorCode, causeContext);
        errorDetail.setCauseContext(causeContext + " | " + cause.getMessage());
    }

    public ErrorCode getErrorCode() {
        return this.code;
    }

    public List<ErrorDetail> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorDetail> errors) {
        this.errors = errors;
    }

    public ResponseStatusCode getResponseStatusCode() {
        return responseStatusCode;
    }

    public void setResponseStatusCode(ResponseStatusCode responseStatusCode) {
        this.responseStatusCode = responseStatusCode;
    }

    private ErrorDetail appendErr(ErrorDetail error) {
        this.errors.add(error);
        return error;
    }

    public ErrorDetail appendErr(ErrorCode code, LinkedHashMap<String, Object> details, Object... data) {
        return appendErr(new ErrorDetail(code.getCode(), Arrays.asList(data), details));
    }

    public ErrorDetail appendErr(ErrorCode code, Object... data) {
        return appendErr(new ErrorDetail(code.getCode(), Arrays.asList(data)));
    }
    public ErrorDetail appendErr(ErrorCode code)                      { return appendErr(new ErrorDetail(code.getCode())); }

    public int getErrCount()  { return errors.size(); }
    public boolean hasError() { return getErrCount() > 0; }

    public boolean containsErr(ErrorCode errorCode) {
        return this.errors.stream().filter(error -> error.getCode().equals(errorCode.getCode())).findAny().isPresent();
    }

    @Override public String getMessage() { return errors.toString(); }
}

package com.beyontec.mol.exception;

import java.util.HashMap;
import java.util.Map;

public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = -4371491428087549416L;

	private final Map<ErrorCode, Object[]> errorDetails;

	public ValidationException(Map<ErrorCode, Object[]> errorDetails) {
		super();
		this.errorDetails = errorDetails;
	}

    public ValidationException(ErrorCode errorCode) {
        super();
        Map<ErrorCode, Object[]> errorDetails = new HashMap<>();
        errorDetails.put(errorCode, null);
        this.errorDetails = errorDetails;
    }

    public ValidationException(ErrorCode errorCode, Object... data) {
        super();
        Map<ErrorCode, Object[]> errorDetails = new HashMap<>();
        errorDetails.put(errorCode, data);
        this.errorDetails = errorDetails;
    }

	public ValidationException(String message, Throwable cause, Map<ErrorCode, Object[]> errorDetails) {
		super(message, cause);
		this.errorDetails = errorDetails;
	}

	public ValidationException(String message, Map<ErrorCode, Object[]> errorDetails) {
		super(message);
		this.errorDetails = errorDetails;
	}

	public ValidationException(Throwable cause, Map<ErrorCode, Object[]> errorDetails) {
		super(cause);
		this.errorDetails = errorDetails;
	}

	public Map<ErrorCode, Object[]> getErrorDetails() {
		return this.errorDetails;
	}
}

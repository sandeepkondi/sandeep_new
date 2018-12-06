package com.beyontec.mol.exception;

import java.util.List;

public class ErrorDetailResponse {

	private List<ErrorDetail> errors;

	public ErrorDetailResponse() {

	}

	public ErrorDetailResponse(List<ErrorDetail> errors) {
		this.errors = errors;
	}

	public List<ErrorDetail> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorDetail> errors) {
		this.errors = errors;
	}

}

package com.beyontec.mol.exception;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class ErrorDetail {

    @JsonInclude(Include.NON_EMPTY) private String code;
    @JsonInclude(Include.NON_EMPTY) private String message;
    private List<Object> data = new ArrayList<>();
    @JsonInclude(Include.NON_EMPTY) private LinkedHashMap<String, Object> details;

    private String causeContext;

    public ErrorDetail() {}
    public ErrorDetail(String code) {
        this.code = code;
    }

    public ErrorDetail(String code, String message) {
        this(code);
        this.message = message;
    }

    public ErrorDetail(String code, List<Object> data) {
        this(code);
        this.data = data;
    }

    public ErrorDetail(String code, List<Object> data, LinkedHashMap<String, Object> details) {
        this(code);
        this.data = data;
        this.details = details;
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

    @JsonIgnore
    public List<Object> getData() {
        return data;
    }

    @JsonIgnore
    public Object[] getDataArr() {
        return getData().toArray();
    }

    public void setData(List<Object> data) {
        this.data = data;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @JsonIgnore
    public String getCauseContext() {
        return causeContext;
    }

    @JsonIgnore
    public void setCauseContext(String causeContext) {
        this.causeContext = causeContext;
    }

    public LinkedHashMap<String, Object> getDetails() {
        return details;
    }

    public void setDetails(LinkedHashMap<String, Object> details) {
        this.details = details;
    }
    @Override
    public String toString() {
        StringBuilder errMsg = new StringBuilder().append(this.code).append(": ").append(this.message);
        if (StringUtils.isBlank(causeContext)) { return errMsg.toString(); }
        return errMsg.append(" | Cause Context: ").append(this.causeContext).toString();
    }
}

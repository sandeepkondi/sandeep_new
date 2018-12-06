package com.beyontec.mol.modal;

import java.util.Date;

import com.beyontec.mol.util.CustomDateDeserializer;
import com.beyontec.mol.util.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class CertificateSearchCriteria {

    private String certificateNo;

    private String customerCategoryId;

    @JsonSerialize(using = CustomDateSerializer.class) @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date certificateCreationFromDate;

    @JsonSerialize(using = CustomDateSerializer.class) @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date certificateCreationToDate;

    public String getCertificateNo() {
        return certificateNo;
    }

    public void setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo;
    }

    public Date getCertificateCreationFromDate() {
        return certificateCreationFromDate;
    }

    public void setCertificateCreationFromDate(Date certificateCreationFromDate) {
        this.certificateCreationFromDate = certificateCreationFromDate;
    }

    public Date getCertificationCreationToDate() {
        return certificateCreationToDate;
    }

    public void setCertificateCreationToDate(Date certificateCreationToDate) {
        this.certificateCreationToDate = certificateCreationToDate;
    }

    public String getCustomerCategoryId() {
        return customerCategoryId;
    }

    public void setCustomerCategoryId(String customerCategoryId) {
        this.customerCategoryId = customerCategoryId;
    }
}

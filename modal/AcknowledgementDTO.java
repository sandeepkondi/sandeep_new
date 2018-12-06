package com.beyontec.mol.modal;

public class AcknowledgementDTO {

    private String certificateNo;
    private String visaApprovalDate;
    private String visaExpirationDate;

    public String getCertificateNo() {
        return certificateNo;
    }

    public void setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo;
    }

    public String getVisaApprovalDate() {
        return visaApprovalDate;
    }

    public void setVisaApprovalDate(String visaApprovalDate) {
        this.visaApprovalDate = visaApprovalDate;
    }

    public String getVisaExpirationDate() {
        return visaExpirationDate;
    }

    public void setVisaExpirationDate(String visaExpirationDate) {
        this.visaExpirationDate = visaExpirationDate;
    }

}

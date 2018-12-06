package com.beyontec.mol.modal;

public class CertificateResponseDTO {

	private String certificateNo;
    private String approvalDate;
    private String expiryDate;

    public CertificateResponseDTO(String certificateNo, String approvalDate, String expiryDate) {
		this.certificateNo = certificateNo;
        this.expiryDate = expiryDate;
        this.approvalDate = approvalDate;
	}

	public String getCertificateNo() {
		return certificateNo;
	}

	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo;
	}

    public String getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(String approvalDate) {
        this.approvalDate = approvalDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
}

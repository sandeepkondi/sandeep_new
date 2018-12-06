package com.beyontec.mol.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "IDS_CERT_CANC_DTLS")
@EntityListeners(AuditingEntityListener.class)
public class CertificateCancellation {

	@Column(name = "ICCD_COMP_ID")
	private String companyId;

	@Id
	@Column(name = "ICCD_SGS_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "iccd_sgs_id_generator")
    @SequenceGenerator(sequenceName = "SEQ_ICCD_SGS_ID", name = "iccd_sgs_id_generator", allocationSize = 1)
	private int sgsId;

	@Column(name = "ICCD_CANC_TYP")
	private String cancelType;

	@Column(name = "ICCD_CERT_NO")
	private String certificateNo;

	@Column(name = "ICCD_LC_REF_NO")
	private String labourReferenceNo;

	@Column(name = "ICCD_CAN_EFF_DT")
	private Date cancelledDate;

	@Column(name = "ICCD_CAN_RSN")
	private String cancelReason;

	@Column(name = "ICCD_STATUS")
	private String requestStatus;

	@Column(name = "ICCD_ERR_TYP")
	private String errorType;

	@Column(name = "ICCD_ERR_ID")
	private String errorId;

	@Column(name = "ICCD_ERR_MSG")
	private String errorMessage;

	@Column(name = "ICCD_CRD")
	private Date requestIncomingDate;

	@Column(name = "ICCD_RESP_ID")
	private String responseId;

	@Column(name = "ICCD_RESP_MSG")
	private String responseMessage;

	@Column(name = "ICCD_RESPD")
	private Date responseDate;

	@Column(name = "ICCD_ULM_SGS_ID")
	private Long ulmSgsId;

	@Column(name = "ICCD_AMND_VER_NO")
	private int amndVerNo;

	@Column(name = "ICCD_ULM_NO")
	private String ulmNo;

	@Column(name = "ICCD_PRC_IPADDR") private String serverIpAddress;
    @Column(name = "ICCD_REQ_IPADDR") private String clientIpAddress;

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public int getSgsId() {
		return sgsId;
	}

	public void setSgsId(int sgsId) {
		this.sgsId = sgsId;
	}

	public String getCancelType() {
		return cancelType;
	}

	public void setCancelType(String cancelType) {
		this.cancelType = cancelType;
	}

	public String getCertificateNo() {
		return certificateNo;
	}

	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo;
	}

	public String getLabourReferenceNo() {
		return labourReferenceNo;
	}

	public void setLabourReferenceNo(String labourReferenceNo) {
		this.labourReferenceNo = labourReferenceNo;
	}

	public Date getCancelledDate() {
		return cancelledDate;
	}

	public void setCancelledDate(Date cancelledDate) {
		this.cancelledDate = cancelledDate;
	}

	public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	public String getErrorType() {
		return errorType;
	}

	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}

	public String getErrorId() {
		return errorId;
	}

	public void setErrorId(String errorId) {
		this.errorId = errorId;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Date getRequestIncomingDate() {
		return requestIncomingDate;
	}

	public void setRequestIncomingDate(Date requestIncomingDate) {
		this.requestIncomingDate = requestIncomingDate;
	}

	public String getResponseId() {
		return responseId;
	}

	public void setResponseId(String responseId) {
		this.responseId = responseId;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public Date getResponseDate() {
		return responseDate;
	}

	public void setResponseDate(Date responseDate) {
		this.responseDate = responseDate;
	}

	public Long getUlmSgsId() {
		return ulmSgsId;
	}

	public void setUlmSgsId(Long ulmSgsId) {
		this.ulmSgsId = ulmSgsId;
	}

	public int getAmndVerNo() {
		return amndVerNo;
	}

	public void setAmndVerNo(int amndVerNo) {
		this.amndVerNo = amndVerNo;
	}

	public String getUlmNo() {
		return ulmNo;
	}

	public void setUlmNo(String ulmNo) {
		this.ulmNo = ulmNo;
	}

    
    public String getServerIpAddress() {
        return serverIpAddress;
    }

    public void setServerIpAddress(String serverIpAddress) {
        this.serverIpAddress = serverIpAddress;
    }

    public String getClientIpAddress() {
        return clientIpAddress;
    }

    public void setClientIpAddress(String clientIpAddress) {
        this.clientIpAddress = clientIpAddress;
    }
}

package com.beyontec.mol.modal;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.beyontec.mol.config.CommonConfig;
import com.beyontec.mol.config.UdsIdDefConfig;
import com.beyontec.mol.exception.ApplicationException;
import com.beyontec.mol.exception.ErrorCode;
import com.beyontec.mol.exception.ResponseStatusCode;
import com.beyontec.mol.util.DateUtil;

public class CancelCertificateDTO extends EndorsementDetails {

	private String cancelType;

	private String certificateNo;

	private Date cancelledDate;

    private String tempCancelledDate;

	private String cancelReason;

	private String labourReferenceNo;

	public String getCertificateNo() {
		return certificateNo;
	}

	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo;
	}

	public Date getCancelledDate() {
		return cancelledDate;
	}

    public void setCancelledDate(String cancelledDate) {
        this.tempCancelledDate = cancelledDate;
        try {
            this.cancelledDate = DateUtil.convert(cancelledDate);
        } catch (Exception e) { /* Ignored */}
	}

	public String getCancelType() {
		return cancelType;
	}

	public void setCancelType(String cancelType) {
		this.cancelType = cancelType;
	}

	public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	public String getLabourReferenceNo() {
		return labourReferenceNo;
	}

	public void setLabourReferenceNo(String labourReferenceNo) {
		this.labourReferenceNo = labourReferenceNo;
	}

    public ApplicationException validate() {
        ApplicationException ae = new ApplicationException(ResponseStatusCode.INVALID_REQUEST);
        validateMandatories(ae);
        validateDates(ae);

        if (StringUtils.isBlank(this.cancelType)) { return ae; }

        if (StringUtils.isNotBlank(this.cancelType)) { UdsIdDefConfig.isCodifiedValue(UdsIdDefConfig.ID_TYPE_CANCELATION_TYPE, this.cancelType, ae); }

        return ae;
    }

    private void validateMandatories(ApplicationException ae) {
        // @formatter:off
        if (StringUtils.isBlank(this.cancelType))    { ae.appendErr(ErrorCode.EMPTY_MANDATORY_FIELD_CANCEL_CERTIFICATE, "Cancel Type"); }
        if (StringUtils.isBlank(this.certificateNo)) { ae.appendErr(ErrorCode.EMPTY_MANDATORY_FIELD_CANCEL_CERTIFICATE, "Certificate Number"); }
        if (StringUtils.isBlank(this.cancelReason))  { ae.appendErr(ErrorCode.EMPTY_MANDATORY_FIELD_CANCEL_CERTIFICATE, "Cancel Reason"); }
        // @formatter:on
    }

    private void validateDates(ApplicationException ae) {
        // cancelledDate is not mandatory, if tempCancelledDate is null no need to validate. Refer setter method
        if (this.tempCancelledDate == null) { return; }
        // if cancelledDate is not null, then the given date is processed successfully. Refer setter method
        if (this.cancelledDate != null) { return; }

        // execution comed here when input is given but not processed successfully in setter
        ae.appendErr(ErrorCode.DATE_INVALID, "Cancelled", CommonConfig.DATE_FORMAT.toPattern());
    }
}

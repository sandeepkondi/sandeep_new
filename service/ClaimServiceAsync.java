package com.beyontec.mol.service;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.beyontec.mol.entity.Claim;
import com.beyontec.mol.exception.ApplicationException;
import com.beyontec.mol.exception.ErrorCode;
import com.beyontec.mol.exception.ErrorDetail;
import com.beyontec.mol.repository.ClaimsRepository;

@Service
public class ClaimServiceAsync extends BaseService {

    @Autowired private ClaimService service;

    @Autowired private ClaimsRepository claimsRepository;

    @Async
    @Transactional
    public void addClaimEntries(Claim claim, Locale locale) throws Exception {
        try {
            service.addClaimEntries(claim);
        } catch (Exception e) {
            captureClaimErrDetails(claim,
                                         ErrorCode.UNHANDLED_EXCEPTION,
                                   Claim.STATUS.SYSTEM_ERR,
                                         locale,
                                         e);
        }
    }

    private void captureClaimErrDetails(Claim claim,
                                              ErrorCode errCode,
                                        Claim.STATUS claimStatus,
                                              Locale locale,
                                              Exception e) {
        claim.setErrorId(errCode.getCode());
        claim.setErrorType(claimStatus.getValue());

        StringBuilder errorMessages = new StringBuilder("");
        errorMessages.append(e.getMessage());
        if (e instanceof ApplicationException) {

            ApplicationException appException = (ApplicationException) e;
            errorMessages = new StringBuilder("");

            for (ErrorDetail errorDetail : appException.getErrors()) {

                String errMsg = getErrorMessage(errorDetail.getCode(), errorDetail.getDataArr(), locale);
                errorMessages.append(StringUtils.isEmpty(errorMessages.toString()) ? "" : ", ");
                errorMessages.append(errMsg);
            }
        }

        String errMsg = getErrorMessage(errCode, locale) + ". Exception: " + errorMessages.toString();
        claim.setErrorMessage(errMsg);
        claim.setClaimStatus(claimStatus.getValue());
        invokeRepo(() -> claimsRepository.save(claim),
                   "claimsRepository.save(claim)");
    }
}

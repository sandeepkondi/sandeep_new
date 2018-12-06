package com.beyontec.mol.service;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.beyontec.mol.entity.CertificateCancellation;
import com.beyontec.mol.entity.CertificateDetails;
import com.beyontec.mol.entity.PolicyHistory;
import com.beyontec.mol.entity.UpdateCertificateDetails;
import com.beyontec.mol.exception.ErrorCode;
import com.beyontec.mol.modal.CancelCertificateDTO;
import com.beyontec.mol.repository.CertificateCancellationRepository;
import com.beyontec.mol.repository.CertificateDetailsRepository;
import com.beyontec.mol.repository.UpdateCertificateRepository;
import com.beyontec.mol.service.EndorsementServiceFactory.ENDORSEMENT_SERVICE_TYPE;
import com.beyontec.mol.util.AppConstants;
import com.beyontec.mol.util.CertificateCancellationConstants;

@Service
public class CertificateServiceAsync extends BaseService {
    @Autowired private EndorsementServiceFactory endorsementServiceFactory;

    @Autowired private CertificateService service;

    @Autowired private CertificateDetailsRepository certificateDetailsRepo;
    @Autowired private CertificateCancellationRepository certificateCancellationRepo;
    @Autowired private UpdateCertificateRepository updateCertificateRepository;

    @Async
    @Transactional
    public void addCertificateEntries(CertificateDetails certificateDetails,
                                      String certificateNo,
                                      PolicyHistory masterPolicy,
                                      Locale locale) throws Exception {
        try {
            service.addCertificateEntries(certificateDetails, certificateNo, masterPolicy, locale);
        } catch (Exception e) {
            captureCertificateErrDetails(certificateDetails,
                                         ErrorCode.UNHANDLED_EXCEPTION,
                                         CertificateDetails.STATUS.SYSTEM_ERR,
                                         locale,
                                         false,
                                         e);
        }
    }

    @Async
    @Transactional
    public void createCertificateEntries(CertificateDetails certificateDetails,
                                         String authHeader,
                                         Locale locale) throws Exception {
        try {
            service.createCertificateEntries(certificateDetails, authHeader, locale);
        } catch (Exception e) {
            captureCertificateErrDetails(certificateDetails,
                                         ErrorCode.UNHANDLED_EXCEPTION,
                                         CertificateDetails.STATUS.SYSTEM_ERR,
                                         locale,
                                         true,
                                         e);
        }
    }

    private void captureCertificateErrDetails(CertificateDetails certificateDetails,
                                              ErrorCode errCode,
                                              CertificateDetails.STATUS certificateDetailsStatus,
                                              Locale locale,
                                              boolean isBatchProcess,
                                              Exception e) {
        certificateDetails.setErrId(errCode.getCode());
        certificateDetails.setErrType(certificateDetailsStatus.getValue());

        String errMsg = getErrorMessage(errCode, locale) + ". Exception: " + getErrorMessage(e, locale);
        certificateDetails.setErrMsg(errMsg);

        certificateDetails.setStatus(certificateDetailsStatus.getValue());
        if (isBatchProcess) {
            certificateDetails.setBatchProcessStatus(AppConstants.ERROR_BATCH);
        }
        invokeRepo(() -> certificateDetailsRepo.save(certificateDetails),
                   "certificateDetailsRepository.save(certificateDetails)");
    }

    @Async
    @Transactional
    public void cancelCertificateEntries(CancelCertificateDTO cancelCertificateDTO, Locale locale) {
        try {
            EndorsementService<CancelCertificateDTO> cancelEndorsement = (EndorsementService<CancelCertificateDTO>) endorsementServiceFactory.getService(ENDORSEMENT_SERVICE_TYPE.CANCEL);
            cancelEndorsement.amend(cancelCertificateDTO);
        } catch (Exception e) {
            CertificateCancellation certificateCancellation = invokeRepo(() -> certificateCancellationRepo.findByCertificateNoAndErrorType(cancelCertificateDTO.getCertificateNo(),
                                                                                                                                           null),
                                                                         "certificateCancellationRepo.findByCertificateNo(cancelCertificateDTO.getCertificateNo())");
            certificateCancellation.setErrorId(ErrorCode.UNHANDLED_CANCEL_CERTIFICATE_EXCEPTION.getCode());
            String errorMessage = getErrorMessage(ErrorCode.UNHANDLED_CANCEL_CERTIFICATE_EXCEPTION, locale)
                                  + ". Exception: "
                                  + getErrorMessage(e, locale);
            certificateCancellation.setErrorMessage(errorMessage);

            certificateCancellation.setErrorType(CertificateCancellationConstants.CERTIFICATE_CANCEL_SYSTEM_ERROR_TYPE);

            certificateCancellation.setResponseId(ErrorCode.CERTIFICATE_CANCEL_FAILED.getCode());
            String responseMessage = getErrorMessage(ErrorCode.CERTIFICATE_CANCEL_FAILED, locale);
            certificateCancellation.setResponseMessage(responseMessage);

            certificateCancellation.setRequestStatus(CertificateCancellationConstants.CERTIFICATE_CANCEL_SYSTEM_ERROR_STATUS);

            invokeRepo(() -> certificateCancellationRepo.save(certificateCancellation),
                       "certificateCancellationRepo.save(certificateCancellation)");
        }
    }

    @Async
    @Transactional
    public void update(UpdateCertificateDetails updateCertificateDetails, Locale locale) {
        try {
            invokeRepo(() -> {
                updateCertificateRepository.updateCertificate(updateCertificateDetails.getSgsId());
                return true;
            }, "");
        } catch (Exception e) {
            captureUpdateCertificateErrDetails(updateCertificateDetails,
                                               ErrorCode.UNHANDLED_EXCEPTION,
                                               UpdateCertificateDetails.STATUS.SYSTEM_ERR,
                                               locale,
                                               false,
                                               e);
        }
    }

    @Async
    @Transactional
    public void batchUpdate(UpdateCertificateDetails updateCertificateDetails, Locale locale, String authHeader) {
        try {
            service.update(updateCertificateDetails, authHeader, locale, true);
        } catch (Exception e) {
            captureUpdateCertificateErrDetails(updateCertificateDetails,
                                               ErrorCode.UNHANDLED_EXCEPTION,
                                               UpdateCertificateDetails.STATUS.SYSTEM_ERR,
                                               locale,
                                               true,
                                               e);
        }

    }

    private void captureUpdateCertificateErrDetails(UpdateCertificateDetails updateCertificateDetails,
                                                    ErrorCode errCode,
                                                    UpdateCertificateDetails.STATUS certificateDetailsStatus,
                                                    Locale locale,
                                                    boolean isBatchProcess,
                                                    Exception e) {
        updateCertificateDetails.setErrorId(errCode.getCode());
        updateCertificateDetails.setErrorType(certificateDetailsStatus.getValue());

        String errMsg = getErrorMessage(errCode, locale) + ". Exception: " + getErrorMessage(e, locale);
        updateCertificateDetails.setErrorMessage(errMsg);

        updateCertificateDetails.setResponseId(ErrorCode.CERTIFICATE_UPDATE_PROCESS_FAILED.getCode());
        String responseMessage = getErrorMessage(ErrorCode.CERTIFICATE_UPDATE_PROCESS_FAILED, locale);
        updateCertificateDetails.setResponseMessage(responseMessage);

        updateCertificateDetails.setStatus(certificateDetailsStatus.getValue());
        if (isBatchProcess) {
            updateCertificateDetails.setBatchProcessStatus(AppConstants.ERROR_BATCH);
        }

        invokeRepo(() -> updateCertificateRepository.save(updateCertificateDetails),
                   "updateCertificateRepository.save(updateCertificateDetails))");
    }
}

package com.beyontec.mol.service;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.beyontec.mol.entity.CertificateDetails;
import com.beyontec.mol.entity.UpdateCertificateDetails;
import com.beyontec.mol.exception.ErrorCode;
import com.beyontec.mol.exception.ValidationException;
import com.beyontec.mol.repository.CertificateDetailsRepository;
import com.beyontec.mol.repository.UpdateCertificateRepository;
import com.beyontec.mol.util.AppConstants;

@Service
public class BatchService extends BaseService {

    @Autowired private CertificateServiceAsync certificateServiceAsync;

    @Autowired private CertificateDetailsRepository certificateDetailsRepository;

    @Autowired private UpdateCertificateRepository updateCertificateRepository;

    @Transactional
    public String startProcess(long batchId, String authHeader, Locale locale) {

        if (StringUtils.isEmpty(batchId)) {
            throw new ValidationException(ErrorCode.BATCH_ID_MISSING);
        }
        
        if (certificateDetailsRepository.getTotalBatchCount(batchId) == 0) {
            throw new ValidationException(ErrorCode.NO_BATCH_TO_PROCESS);
        }

        if (certificateDetailsRepository.getNotInitiatedBatchCount(batchId) == 0) {

            if (certificateDetailsRepository.getBatchStatusCount(batchId, AppConstants.INPROGRESS_BATCH) == 0) {
                throw new ValidationException(ErrorCode.ALL_BATCH_PROCESSED);
            }
            throw new ValidationException(ErrorCode.FEW_BATCH_INPROGRESS);
        }

        certificateDetailsRepository.setBatchStatus(batchId, AppConstants.INPROGRESS_BATCH);
        List<CertificateDetails> openCertificates = certificateDetailsRepository.getBatchStatusEntries(batchId,
                                                                                                       AppConstants.INPROGRESS_BATCH);
        for (CertificateDetails certificateDetails : openCertificates) {
            try {
                certificateServiceAsync.createCertificateEntries(certificateDetails, authHeader, locale);
            } catch (Exception e) {}
        }

        return getErrorMessage(ErrorCode.BATCH_PROCESS_INITIATED, locale);
    }

    @Transactional
    public String update(Long batchId, String authHeader, Locale locale) {
        validateUpdate(batchId);

        updateCertificateRepository.setBatchStatus(batchId, AppConstants.INPROGRESS_BATCH);
        List<UpdateCertificateDetails> openCertificates = updateCertificateRepository.getBatchStatusEntries(batchId,
                                                                                                            AppConstants.INPROGRESS_BATCH);

        for (UpdateCertificateDetails updateCertificateDetails : openCertificates) {
            certificateServiceAsync.batchUpdate(updateCertificateDetails, locale, authHeader);
            certificateServiceAsync.update(updateCertificateDetails, locale);
        }

        return getErrorMessage(ErrorCode.BATCH_PROCESS_INITIATED, locale);
    }

    private void validateUpdate(Long batchId) {
        // Checking for valid Batch Id
        if (batchId == null) {
            throw new ValidationException(ErrorCode.BATCH_ID_MISSING);
        }
        Long count = invokeRepo(() -> updateCertificateRepository.getTotalBatchCount(batchId),
                                "updateCertificateRepository.getTotalBatchCount(batchId)");
        if (count == 0) {
            throw new ValidationException(ErrorCode.NO_BATCH_TO_PROCESS);
        }

        // Checking if the batch records are already processed
        boolean isNotInProgressAlready = invokeRepo(() -> updateCertificateRepository.getUnInitiatedCount(batchId),
                                                 "updateCertificateRepository.getUnInitiatedCount(batchId)") != 0;
        if (isNotInProgressAlready) { return; } // Batch records has to be processed freshly

        if (updateCertificateRepository.getBatchStatusCount(batchId, AppConstants.INPROGRESS_BATCH) == 0) {
            throw new ValidationException(ErrorCode.ALL_BATCH_PROCESSED);
        }
        throw new ValidationException(ErrorCode.FEW_BATCH_INPROGRESS);
    }
}

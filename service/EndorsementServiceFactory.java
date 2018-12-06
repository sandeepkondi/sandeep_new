package com.beyontec.mol.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.beyontec.mol.modal.CancelCertificateDTO;

@Component
public class EndorsementServiceFactory {
    public static enum ENDORSEMENT_SERVICE_TYPE { CANCEL }

    @Autowired @Qualifier(value = "endorsementCancelService") private EndorsementService<CancelCertificateDTO> endorsementCancelService;

    public EndorsementService<? extends CancelCertificateDTO> getService(ENDORSEMENT_SERVICE_TYPE serviceType) {
        if (serviceType == ENDORSEMENT_SERVICE_TYPE.CANCEL) {
            return endorsementCancelService;
        }
        return null;
    }
}

package com.beyontec.mol.service;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.beyontec.mol.entity.CoverageSmiHistory;
import com.beyontec.mol.entity.EndorsementDefinition;
import com.beyontec.mol.entity.PolicyMain;
import com.beyontec.mol.entity.TaxHistory;
import com.beyontec.mol.modal.CancelCertificateDTO;

@Service(value = "endorsementCancelService")
public class EndorsementCancelServiceImpl extends EndorsementServiceTemplate<CancelCertificateDTO>
implements EndorsementService<CancelCertificateDTO> {

    @Override
    String getCertificateNo(CancelCertificateDTO cancelCertificateDetails) {
        return cancelCertificateDetails.getCertificateNo();
    }

    // @formatter:off
    @Override String getEndorsementStatus()     { return "CAN"; }
    @Override String getAmendType()             { return "E"; }
    @Override String getLevel3Type()            { return "EQ"; }
    @Override String getEndorsementDefnIdType() { return "FT04"; }
    // @formatter:on

    @Override
    String getAmendRemarks(CancelCertificateDTO cancelCertificateDetails) {
        return cancelCertificateDetails.getCancelReason();
    }

    @Override
    Date getAmendEffectDate(CancelCertificateDTO cancelCertificateDetails) {
        return cancelCertificateDetails.getCancelledDate();
    }

    @Override
    void updatePolicySpecificToEndorseType(CancelCertificateDTO cancelCertificateDetails,
                                           PolicyMain policy,
                                           EndorsementDefinition endorsementDefn) {
        policy.amendCancellation(cancelCertificateDetails, endorsementDefn);
    }

    @Override
    void createCovrgSmiHistorySpecificToEndorType(CoverageSmiHistory coverageSmiHistory) {
        coverageSmiHistory.setPremium(BigDecimal.ZERO);
        coverageSmiHistory.setPremiumBc(BigDecimal.ZERO);

        coverageSmiHistory.setUePremium(0L);
        coverageSmiHistory.setUePremiumBc(0L);

        coverageSmiHistory.setPrPremium(0L);
        coverageSmiHistory.setPrPremiumBc(0L);

        coverageSmiHistory.setAnnualPremium(0L);
        coverageSmiHistory.setAnnualPremiumBc(0L);

        coverageSmiHistory.setTransactionPremium(0L);
        coverageSmiHistory.setTransactionPremiumBc(0L);

        coverageSmiHistory.setModTxnPremium(0L);
        coverageSmiHistory.setModTxnPremiumBc(0L);
    }

    @Override
    void createTaxHistorySpecificToEndorType(TaxHistory taxHistory) {
        taxHistory.setAmount(BigDecimal.ZERO);
        taxHistory.setAmountBc(BigDecimal.ZERO);

        taxHistory.setAdjAmount(BigDecimal.ZERO);
        taxHistory.setAdjAmountBc(BigDecimal.ZERO);

        taxHistory.setSourceAmount(BigDecimal.ZERO);
        taxHistory.setSourceAmountBc(BigDecimal.ZERO);
    }
}

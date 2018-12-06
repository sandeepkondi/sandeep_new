package com.beyontec.mol.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.beyontec.mol.config.CommonConfig;
import com.beyontec.mol.entity.CoverageHistory;
import com.beyontec.mol.entity.CoverageMain;
import com.beyontec.mol.entity.CoverageSmiHistory;
import com.beyontec.mol.entity.CoverageSmiMain;
import com.beyontec.mol.entity.EndorsementDefinition;
import com.beyontec.mol.entity.EndorsementDefinition.EndorsementDefinitionId;
import com.beyontec.mol.entity.PolicyHistory;
import com.beyontec.mol.entity.PolicyMain;
import com.beyontec.mol.entity.RiskAdditionalHistory;
import com.beyontec.mol.entity.RiskAdditionalMain;
import com.beyontec.mol.entity.RiskHistory;
import com.beyontec.mol.entity.RiskMain;
import com.beyontec.mol.entity.Tax;
import com.beyontec.mol.entity.TaxHistory;
import com.beyontec.mol.repository.CoverageHistoryRepository;
import com.beyontec.mol.repository.CoverageMainRepository;
import com.beyontec.mol.repository.CoverageSmiHistoryRepository;
import com.beyontec.mol.repository.CoverageSmiMainRepository;
import com.beyontec.mol.repository.EndorsementDefinitionRepository;
import com.beyontec.mol.repository.PolicyHistoryRepository;
import com.beyontec.mol.repository.PolicyMainRepository;
import com.beyontec.mol.repository.RiskAdditionalHistoryRepository;
import com.beyontec.mol.repository.RiskAdditionalMainRepository;
import com.beyontec.mol.repository.RiskHistoryRepository;
import com.beyontec.mol.repository.RiskMainRepository;
import com.beyontec.mol.repository.TaxHistoryRepository;
import com.beyontec.mol.repository.TaxRepository;
import com.beyontec.mol.util.DateUtil;

public abstract class EndorsementServiceTemplate<T> extends BaseService {
    @Autowired private EndorsementDefinitionRepository endorsementDefnRepo;

    @Autowired private PolicyMainRepository policyRepo;
    @Autowired private PolicyHistoryRepository policyHistoryRepo;

    @Autowired private RiskMainRepository riskRepo;
    @Autowired private RiskHistoryRepository riskHistoryRepo;

    @Autowired private RiskAdditionalMainRepository riskAdditionalRepo;
    @Autowired private RiskAdditionalHistoryRepository riskAdditionalHistoryRepo;

    @Autowired private CoverageMainRepository coverageRepo;
    @Autowired private CoverageHistoryRepository coverageHistoryRepo;

    @Autowired private CoverageSmiMainRepository coverageSmiRepo;
    @Autowired private CoverageSmiHistoryRepository coverageSmiHistoryRepo;

    @Autowired private TaxRepository taxRepo;
    @Autowired private TaxHistoryRepository taxHistoryRepo;

    @Autowired private ModelMapper modelMapper;

    abstract String getCertificateNo(T endorsementDetails);
    abstract String getEndorsementStatus();
    abstract String getAmendType();
    abstract String getLevel3Type();
    abstract String getEndorsementDefnIdType();
    abstract String getAmendRemarks(T endorsementDetails);

    abstract Date getAmendEffectDate(T endorsementDetails);

    abstract void updatePolicySpecificToEndorseType(T endorsementDetails,
                                                    PolicyMain policy,
                                                    EndorsementDefinition endorsementDefn);

    abstract void createCovrgSmiHistorySpecificToEndorType(CoverageSmiHistory coverageSmiHistory);

    abstract void createTaxHistorySpecificToEndorType(TaxHistory taxHistory);

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void amend(T endorsementDetails) {
        PolicyMain policy = updatePolicy(endorsementDetails);
        createPolicyHistory(policy);

        RiskMain risk = updateRisk(policy);
        createRiskHistory(risk);

        RiskAdditionalMain riskAdditional = updateRiskAdditional(risk);
        createRiskAdditionalHistory(riskAdditional);

        List<CoverageMain> coverages = updateCoverages(risk);
        createCoveragesHistory(coverages);

        List<CoverageSmiMain> coverageSmis = updateCoverageSmis(risk);
        createCoverageSmisHistory(coverageSmis);

        List<Tax> taxes = updateTaxes(policy);
        createTaxesHistory(taxes);
    }

    private EndorsementDefinition getEndorsementDefn() {
        String idType = getEndorsementDefnIdType();
        EndorsementDefinitionId id = new EndorsementDefinitionId(idType);
        EndorsementDefinition endorsementDefinition = invokeRepo(true,
                                                                 () -> endorsementDefnRepo.findById(id),
                                                                 EndorsementDefinition.class.getName());
        return endorsementDefinition;
    }

    private String getAmendNo(PolicyMain policy, String amendType) {
        return new StringBuilder().append(policy.getNumber())
                                  .append("/")
                                  .append(amendType)
                                  .append("/")
                                  .append(policy.getAmendmentVersionNumber())
                                  .toString();
    }

    private PolicyMain updatePolicy(T endorsementDetails) {
        String certificateNo = getCertificateNo(endorsementDetails);
        PolicyMain policy = invokeRepo(() -> policyRepo.findByNumber(certificateNo),
                                       "policyRepo.findByNumber(certificateNo)");

        String amendNo = getAmendNo(policy, getAmendType());
        String level3No = getAmendNo(policy, getLevel3Type());
        policy.amendNumbers(amendNo, level3No);

        policy.amendVersionNumbers();

        Date amendEffectDate = getAmendEffectDate(endorsementDetails);
        policy.amendDates(amendEffectDate);

        // Set by Endorsement defn
        EndorsementDefinition endorsementDefinition = getEndorsementDefn();
        policy.amendEndorsementDefn(endorsementDefinition);

        // update the policy fields those are specific to the given endorsement type
        updatePolicySpecificToEndorseType(endorsementDetails, policy, endorsementDefinition);

        policy.setLevel3SgsId(policy.getSgsId());
        policy.setSourceSgsId(policy.getSgsId());
        policy.setStatus(getEndorsementStatus());
        policy.setAmendmentRemarks(getAmendRemarks(endorsementDetails));
        policy.setApprovalDate(DateUtil.now());

        PolicyMain updatedPolicy = invokeRepo(() -> policyRepo.save(policy), "policyRepo.save(policy)");
        return updatedPolicy;
    }

    private void createPolicyHistory(PolicyMain policy) {
        PolicyHistory policyHistory = invokeModelMapper(() -> modelMapper.map(policy, PolicyHistory.class),
                                                        "modelMapper.map(policy, PolicyHistory.class)");
        policyHistory.setRecordType(CommonConfig.RECORD_TYPE_U);
        invokeRepo(() -> policyHistoryRepo.save(policyHistory), "policyHistoryRepo.save(policyHistory)");
    }

    private RiskMain updateRisk(PolicyMain policy) {
        RiskMain risk = invokeRepo(() -> riskRepo.findByUlmSgsId(policy.getSgsId()),
                                   "riskRepo.findByUlmSgsId(policy.getSgsId())");
        risk.setFromDate(policy.getFromDate());
        risk.setToDate(policy.getToDate());
        risk.setAmendmentVersionNumber(policy.getAmendmentVersionNumber());
        risk.setAmendmentFromDate(policy.getFromDate());
        risk.setAmendmentToDate(policy.getAmendmentToDate());

        RiskMain updatedRisk = invokeRepo(() -> riskRepo.save(risk), "riskRepo.save(risk)");
        return updatedRisk;
    }

    private void createRiskHistory(RiskMain risk) {
        RiskHistory riskHistory = invokeModelMapper(() -> modelMapper.map(risk, RiskHistory.class),
                                                    "modelMapper.map(risk, RiskHistory.class)");
        riskHistory.setRecordType(CommonConfig.RECORD_TYPE_U);
        invokeRepo(() -> riskHistoryRepo.save(riskHistory), "riskHistoryRepo.save(riskHistory)");
    }

    private RiskAdditionalMain updateRiskAdditional(RiskMain risk) {
        RiskAdditionalMain riskAdditional = invokeRepo(() -> riskAdditionalRepo.findByUlmSgsId(risk.getUlmSgsId()),
                                                       "riskAdditionalRepo.findByUlmSgsId(risk.getUlmSgsId())");
        riskAdditional.setAmendmentVersionNumber(risk.getAmendmentVersionNumber());
        riskAdditional.setEnd(risk.getFromDate());
        riskAdditional.setExd(risk.getToDate());

        RiskAdditionalMain updatedRiskAdditional = invokeRepo(() -> riskAdditionalRepo.save(riskAdditional),
                                                              "riskAdditionalRepo.save(riskAdditional)");
        return updatedRiskAdditional;
    }

    private void createRiskAdditionalHistory(RiskAdditionalMain riskAdditional) {
        RiskAdditionalHistory riskAdditionalHistory = invokeModelMapper(() -> modelMapper.map(riskAdditional,
                                                                                              RiskAdditionalHistory.class),
                                                                        "modelMapper.map(riskAdditional, RiskAdditionalHistory.class)");
        riskAdditionalHistory.setRecordType(CommonConfig.RECORD_TYPE_U);
        invokeRepo(() -> riskAdditionalHistoryRepo.save(riskAdditionalHistory),
                   "riskAdditionalHistoryRepo.save(riskAdditionalHistory)");
    }

    private List<CoverageMain> updateCoverages(RiskMain risk) {
        List<CoverageMain> coverages = invokeRepo(() -> coverageRepo.findByUlmSgsId(risk.getUlmSgsId()),
                                                  "coverageRepo.findByUlmSgsId(risk.getUlmSgsId())");
        coverages.forEach(coverage -> {
            coverage.setFromDate(risk.getFromDate());
            coverage.setToDate(risk.getToDate());
            coverage.setAmendmentVersionNumber(risk.getAmendmentVersionNumber());
            coverage.setAmendmentFromDate(risk.getAmendmentFromDate());
            coverage.setAmendmentToDate(risk.getAmendmentToDate());
        });
        List<CoverageMain> updatedCoverages = invokeRepo(() -> coverageRepo.save(coverages),
                                                         "coverageRepo.save(coverages)");
        return updatedCoverages;
    }

    private void createCoveragesHistory(List<CoverageMain> coverages) {
        List<CoverageHistory> coveragesHistory = coverages.stream()
                                                          .map(coverage -> {
                                                              CoverageHistory coverageHistory = invokeModelMapper(() -> modelMapper.map(coverage,
                                                                                                                                        CoverageHistory.class),
                                                                                                                  "modelMapper.map(coverage, CoverageHistory.class)");
                                                              coverageHistory.setRecordType(CommonConfig.RECORD_TYPE_U);
                                                              return coverageHistory;
                                                          })
                                                          .collect(Collectors.toList());
        invokeRepo(() -> coverageHistoryRepo.save(coveragesHistory), "coverageHistoryRepo.save(coveragesHistory)");
    }

    private List<CoverageSmiMain> updateCoverageSmis(RiskMain risk) {
        List<CoverageSmiMain> coverageSmis = invokeRepo(() -> coverageSmiRepo.findByUlmSgsId(risk.getUlmSgsId()),
                                                        "coverageSmiRepo.findByUlmSgsId(risk.getUlmSgsId())");
        coverageSmis.forEach(coverageSmi -> {
            coverageSmi.setAmendmentVersionNumber(risk.getAmendmentVersionNumber());
            coverageSmi.setAmendmentFromDate(risk.getAmendmentFromDate());
            coverageSmi.setAmendmentToDate(risk.getAmendmentToDate());
            coverageSmi.setFromDate(risk.getFromDate());
            coverageSmi.setToDate(risk.getToDate());
        });
        List<CoverageSmiMain> updatedCoverageSmis = invokeRepo(() -> coverageSmiRepo.save(coverageSmis),
                                                               "coverageSmiRepo.save(coverageSmis)");
        return updatedCoverageSmis;
    }

    private void createCoverageSmisHistory(List<CoverageSmiMain> coverageSmis) {
        List<CoverageSmiHistory> coverageSmisHistory = coverageSmis.stream()
                                                                   .map(coverageSmi -> {
                                                                       CoverageSmiHistory coverageSmiHistory = invokeModelMapper(() -> modelMapper.map(coverageSmi,
                                                                                                                                                       CoverageSmiHistory.class),
                                                                                                                                 "modelMapper.map(coverageSmi, CoverageSmiHistory.class)");
                                                                       coverageSmiHistory.setRecordType(CommonConfig.RECORD_TYPE_U);
                                                                       createCovrgSmiHistorySpecificToEndorType(coverageSmiHistory);
                                                                       return coverageSmiHistory;
                                                                   })
                                                                   .collect(Collectors.toList());
        invokeRepo(() -> coverageSmiHistoryRepo.save(coverageSmisHistory),
                   "coverageSmiHistoryRepo.save(coverageSmisHistory)");
    }

    private List<Tax> updateTaxes(PolicyMain policy) {
        List<Tax> taxes = invokeRepo(() -> taxRepo.findByUlmSgsId(policy.getSgsId()),
                                     "taxRepo.findByUlmSgsId(policy.getSgsId())");
        taxes.forEach(tax -> {
            tax.setAmendmentVersionNo(policy.getAmendmentVersionNumber());
            tax.setAmendmentFromDate(policy.getAmendmentFromDate());
            tax.setAmendmentToDate(policy.getAmendmentToDate());

            tax.setFromDate(policy.getFromDate());
            tax.setToDate(policy.getToDate());
        });
        List<Tax> updatedTaxes = invokeRepo(() -> taxRepo.save(taxes), "taxRepo.save(taxes)");
        return updatedTaxes;
    }

    private void createTaxesHistory(List<Tax> taxes) {
        List<TaxHistory> taxesHistory = taxes.stream().map(tax -> {
            TaxHistory taxHistory = invokeModelMapper(() -> modelMapper.map(tax, TaxHistory.class),
                                                      "modelMapper.map(tax, TaxHistory.class)");
            taxHistory.setRecordType(CommonConfig.RECORD_TYPE_U);
            createTaxHistorySpecificToEndorType(taxHistory);
            return taxHistory;
        }).collect(Collectors.toList());
        invokeRepo(() -> taxHistoryRepo.save(taxesHistory), "taxHistoryRepo.save(taxesHistory)");
    }
}

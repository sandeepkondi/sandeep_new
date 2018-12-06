package com.beyontec.mol.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.beyontec.mol.entity.ClaimHistoryEstimation;
import com.beyontec.mol.entity.ClaimPaymentParty;
import com.beyontec.mol.entity.ClaimTransactionClaimantDetails;
import com.beyontec.mol.entity.ClaimTransactionEstimation;
import com.beyontec.mol.entity.ClaimTransactionFNOL;
import com.beyontec.mol.entity.ClaimTransactionSettlement;
import com.beyontec.mol.entity.ClaimWorkingEstimation;
import com.beyontec.mol.entity.WorkBasketTransactionActivity;
import com.beyontec.mol.exception.ErrorCode;
import com.beyontec.mol.exception.ValidationException;
import com.beyontec.mol.modal.NewEstimate;
import com.beyontec.mol.modal.PaymentDTO;
import com.beyontec.mol.modal.PaymentDetails;
import com.beyontec.mol.modal.PaymentReviewAndApproveUser;
import com.beyontec.mol.repository.ClaimEstimationHistoryRepository;
import com.beyontec.mol.repository.ClaimFnolDetailsRepository;
import com.beyontec.mol.repository.ClaimTransactionEstimationRepository;
import com.beyontec.mol.repository.ClaimTransactionPaymentPartyRepository;
import com.beyontec.mol.repository.ClaimTransactionRiskRepository;
import com.beyontec.mol.repository.ClaimTransactionSettlementRepository;
import com.beyontec.mol.repository.ClaimWorkingDetailsRepository;
import com.beyontec.mol.repository.ClaimsRepository;
import com.beyontec.mol.repository.InsuredDetailsDataRepository;
import com.beyontec.mol.repository.UdsIdDefinitionRepository;
import com.beyontec.mol.repository.UserRepository;
import com.beyontec.mol.repository.WorkBasketTransactionActivityRepository;
import com.beyontec.mol.util.ClaimConstants;
import com.beyontec.mol.util.ClaimEnumConstants;
import com.beyontec.mol.util.JWTUtil;
import com.beyontec.mol.util.UserRoleValidationUtil;

@Service
public class ClaimPaymentService extends BaseService {

    @Autowired private ClaimTransactionEstimationRepository claimTransactionEstimationRepository;

    @Autowired private ClaimWorkingDetailsRepository claimWorkingDetailsRepository;

    @Autowired private ClaimFnolDetailsRepository claimFnolDetailsRepository;

    @Autowired private UserRepository userRepository;

    @Autowired private ClaimTransactionSettlementRepository claimTransactionSettlementRepo;

    @Autowired private ClaimsRepository claimsRepository;

    @Autowired private InsuredDetailsDataRepository insuredDetailsDataRepository;

    @Autowired private ClaimTransactionPaymentPartyRepository claimTransactionPaymentPartyRepository;

    @Autowired private ClaimEstimationHistoryRepository claimEstimationHistoryRepository;

    @Autowired private ClaimTransactionRiskRepository claimTransactionRiskRepository;

    @Autowired private WorkBasketTransactionActivityRepository workbasketTransactionActivityRepository;

    @Autowired private UdsIdDefinitionRepository udsIdDefinitionRepository;

    @Autowired private UserRoleValidationUtil userRoleValidationUtil;

    String companyId;

    @Autowired ModelMapper modelMapper;

    @Transactional
    public boolean createPayment(PaymentDTO paymentDTO, Locale locale) {

        String logedinUser = JWTUtil.getUserId();
        Map<ErrorCode, Object[]> errorDetails = validatePaymentCreate(paymentDTO);
        if (errorDetails.size() > 0) {

            throw new ValidationException(errorDetails);
        }

        ClaimTransactionFNOL claim = claimFnolDetailsRepository.findByClaimNo(paymentDTO.getComplaintNumber());
        if (errorDetails.size() == 0 && claim != null) {

            Map<String, Object> response = storeSettlement(paymentDTO, logedinUser, claim);
            ClaimTransactionSettlement claimTransactionSettlement = (ClaimTransactionSettlement) response.get("settlement");
            storeSettlementParty(claimTransactionSettlement, paymentDTO);
            ClaimTransactionEstimation estimation = updateClaimTransactionEstimation(claimTransactionSettlement);
            updateClaimTransactionHistory(claimTransactionSettlement);
            storeWorkbasketTransactionActivity(claim,
                                               estimation,
                                               claimTransactionSettlement,
                                               response.get("reviewUserGroupId").toString(),
                                               response.get("approveUserGroupId").toString());
            return true;

        } else {

            return false;
        }
    }

    private Map<String, Object> storeSettlement(PaymentDTO paymentDTO,
                                                String logedinUser,
                                                ClaimTransactionFNOL claim) {
        Map<String, Object> response = new HashMap<>();
        int serialRevisionNo = claimTransactionEstimationRepository.getLatestRevisionNo(claim.getFnolSgsId());
        ClaimTransactionEstimation claimEstimation = claimTransactionEstimationRepository
                                                                                         .findByFnolSgsIdAndRevisionSerialNo(claim.getFnolSgsId(),
                                                                                                                             serialRevisionNo);

        ClaimTransactionSettlement settlement = new ClaimTransactionSettlement();
        if (claimEstimation != null) {

            settlement = modelMapper.map(claimEstimation, ClaimTransactionSettlement.class);
            settlement.setEstimateSerialNo(claimEstimation.getRevisionSerialNo());
            settlement.setPayeeName(paymentDTO.getPayeeName());

            if (paymentDTO.getPayee().equals(ClaimConstants.PAYEE_TYPE)) {
                settlement.setAccountCustId(claimEstimation.getCustomerId());
            }
        }

        settlement.setPaymentCreatedDate(new Date());
        if (!StringUtils.isEmpty(paymentDTO.getPaymentAmount())) {
            settlement.setSettledAmount(Double.parseDouble(paymentDTO.getPaymentAmount()));
        }

        settlement.setApproveFlag(ClaimConstants.PAYMENT_APPROVE_FLAG);
        settlement.setPaidFlag(ClaimConstants.PAYMENT_PAID_FLAG);
        if (!StringUtils.isEmpty(paymentDTO.getPaymentAmount())) {
            settlement.setPaymentAmountBC((Double.parseDouble(paymentDTO.getPaymentAmount())));
        }
        settlement.setCurrencyId(ClaimConstants.CLAIM_CURRENCY_ID);
        settlement.setCurrentXrate(ClaimConstants.PAYMENT_CUR_X_RATE);

        companyId = claimsRepository.getCompanyId();
        settlement.setCreatedUser(claimTransactionSettlementRepo.getCreatedUser(companyId));
        settlement.setCreatedDate(new Date());
        if (!StringUtils.isEmpty(paymentDTO.getPaymentAmount())) {
            PaymentReviewAndApproveUser approverDetails = claimTransactionSettlementRepo.getAssignedUser((Double.parseDouble(paymentDTO.getPaymentAmount())),
                                                                                            settlement.getCreatedUser(),
                                                                                            settlement.getCoverId(),
                                                                                            claim.getProductId(),
                                                                                            "A");
            if (null != approverDetails && !StringUtils.isEmpty(approverDetails.getUserId())) {
                settlement.setApprover(approverDetails.getUserId());
            }
            String approverGroupId = (null != approverDetails
                                      && !StringUtils.isEmpty(approverDetails.getUserGroupId())) ? approverDetails.getUserGroupId()
                                                                                                 : "";
            response.put("approveUserGroupId", approverGroupId);
        }
        settlement.setSettledType(ClaimConstants.PAYMENT_SETL_TYP);

        if (!StringUtils.isEmpty(paymentDTO.getPaymentAmount())) {
            PaymentReviewAndApproveUser reviewerDetails = claimTransactionSettlementRepo.getAssignedUser((Double.parseDouble(paymentDTO.getPaymentAmount())),
                                                                                            settlement.getCreatedUser(),
                                                                                            settlement.getCoverId(),
                                                                                            claim.getProductId(),
                                                                                            "R");
            if (null != reviewerDetails && !StringUtils.isEmpty(reviewerDetails.getUserId())) {
                settlement.setAssignReviewUser(reviewerDetails.getUserId());
            }
            String reviewerGroupId = (null != reviewerDetails
                                      && !StringUtils.isEmpty(reviewerDetails.getUserGroupId())) ? reviewerDetails.getUserGroupId()
                                                                                                 : "";
            response.put("reviewUserGroupId", reviewerGroupId);
        }
        if (!StringUtils.isEmpty(settlement.getAssignReviewUser())) {

            settlement.setReviewerId(claimTransactionSettlementRepo.getReviewerId(logedinUser));
        }
        settlement.setCompanyId(companyId);

        response.put("settlement", claimTransactionSettlementRepo.save(settlement));

        return response;

    }

    private void storeSettlementParty(ClaimTransactionSettlement claimTransactionSettlement,
                                      PaymentDTO paymentDto) {

        ClaimTransactionClaimantDetails partyDetails = insuredDetailsDataRepository
                                                                                   .findByFnolSgsId(claimTransactionSettlement.getFnolSgsId());
        ClaimPaymentParty claimPaymentParty = new ClaimPaymentParty();

        if (partyDetails != null) {

            claimPaymentParty = modelMapper.map(partyDetails, ClaimPaymentParty.class);
            claimPaymentParty.setPayeeId(partyDetails.getPartyId());
        }
        claimPaymentParty.setSettlementSgsId(claimTransactionSettlement.getSgsId());
        claimPaymentParty.setEstimateSgsId(claimTransactionSettlement.getEstimateSgsId());
        claimPaymentParty.setFnolSgsId(claimTransactionSettlement.getFnolSgsId());
        claimPaymentParty.setCompanyId(claimTransactionSettlement.getCompanyId());

        claimPaymentParty.setCustomerType(ClaimConstants.PAYMENT_CUSTOMER_TYP);
        if (!StringUtils.isEmpty(paymentDto.getPayeeName())) {
            claimPaymentParty.setPayeeName(paymentDto.getPayeeName());
        }

        claimPaymentParty.setPayeeEntryType(ClaimConstants.PAYMENT_ENTRY_TYP);
        claimPaymentParty.setMainPayeeYN(ClaimConstants.PAYMENT_MAIN_PAYEE);
        claimPaymentParty.setDisplayOrderNo(0);

        claimTransactionPaymentPartyRepository.save(claimPaymentParty);
    }

    private ClaimTransactionEstimation updateClaimTransactionEstimation(ClaimTransactionSettlement settlement) {
        int serialRevisionNo = claimTransactionEstimationRepository.getLatestRevisionNo(settlement.getFnolSgsId());
        ClaimTransactionEstimation claimEstimation = claimTransactionEstimationRepository
                                                                                         .findByFnolSgsIdAndRevisionSerialNo(settlement.getFnolSgsId(),
                                                                                                                             serialRevisionNo);

        int updatedserialRevisionNo = claimEstimation.getRevisionSerialNo() + 1;
        Long settlementSgsId = settlement.getSgsId();
        claimEstimation.setRefSgsId(settlementSgsId);
        double outStandingAmount = claimEstimation.getOutstandingAmount() - settlement.getSettledAmount();
        if (outStandingAmount < 0) {
            throw new ValidationException(ErrorCode.PAYMENT_EXCEED, claimEstimation.getOutstandingAmount());
        }
        claimEstimation.setEstimateDescription("Settlement Confirmation");
        claimEstimation.setSettlementRefsgsId(settlementSgsId);
        claimEstimation.setRevisionSerialNo(updatedserialRevisionNo);
        claimEstimation.setOutstandingAmount(outStandingAmount);

        return claimEstimation;

    }

    private void updateClaimTransactionHistory(ClaimTransactionSettlement settlement) {
        int serialRevisionNo = invokeRepo(() -> claimEstimationHistoryRepository.getLatestRevisionNo(settlement.getFnolSgsId()),
                                          "claimEstimationHistoryRepository.getLatestRevisionNo(settlement.getFnolSgsId())");
        ClaimHistoryEstimation claimHistoryEstimation = invokeRepo(() -> claimEstimationHistoryRepository.findByFnolSgsIdAndRevisionSerialNo(settlement.getFnolSgsId(),
                                                                                                                                             serialRevisionNo),
                                                                   "claimEstimationHistoryRepository.findByFnolSgsIdAndRevisionSerialNo(settlement.getFnolSgsId(), serialRevisionNo)",
                                                                   true);

        claimHistoryEstimation.setRevisionSerialNo(claimHistoryEstimation.getRevisionSerialNo() + 1);
        claimHistoryEstimation.setSettlementRefsgsId(settlement.getSgsId());
        claimHistoryEstimation.setOutstandingAmount(claimHistoryEstimation.getOutstandingAmount()
                                                    - settlement.getSettledAmount());
        claimHistoryEstimation.setEstimateDescription("Settlement Confirmation");

        invokeRepo(() -> claimEstimationHistoryRepository.save(claimHistoryEstimation),
                   "claimEstimationHistoryRepository.save(claimHistoryEstimation)");

    }

    private void storeWorkbasketTransactionActivity(ClaimTransactionFNOL fnol,
                                                    ClaimTransactionEstimation estimation,
                                                    ClaimTransactionSettlement settlement,
                                                    String reviewUserGroupId,
                                                    String approveUserGroupId) {

        WorkBasketTransactionActivity workbasketTransactionActivity = new WorkBasketTransactionActivity();

        workbasketTransactionActivity.setModule(ClaimConstants.PAYMENT_MODULE);
        workbasketTransactionActivity.setUpdatedDate(new Date());

        workbasketTransactionActivity.setCustomerId(fnol.getCustomerId());
        workbasketTransactionActivity.setProductId(fnol.getProductId());
        workbasketTransactionActivity.setFnolSgsId(fnol.getFnolSgsId());
        workbasketTransactionActivity.setFnolRef(fnol.getFnolRefNo());

        workbasketTransactionActivity.setClaimRef(fnol.getCLF_CLC_NO());
        workbasketTransactionActivity.setLevel1Ref(fnol.getFnolSgsId());

        if (!StringUtils.isEmpty(settlement.getAssignReviewUser())) {
            String activityId = claimTransactionSettlementRepo.getReviewerActivityId();
            workbasketTransactionActivity.setActivityId(activityId);
            workbasketTransactionActivity.setAssignedUser(settlement.getAssignReviewUser());
        } else {
            String activityId = claimTransactionSettlementRepo.getApproverActivityId();
            workbasketTransactionActivity.setActivityId(activityId);
            workbasketTransactionActivity.setAssignedUser(settlement.getApprover());
        }

        workbasketTransactionActivity.setLevel2Ref(claimTransactionRiskRepository.getRiskID(fnol.getFnolSgsId()));

        if (estimation != null) {
            if (!StringUtils.isEmpty(estimation.getEstimateSgsId())) {
                workbasketTransactionActivity.setLevel3Ref(estimation.getEstimateSgsId());
            }
            if (!StringUtils.isEmpty(estimation.getCustomerId())) {
                workbasketTransactionActivity.setLevel6Ref(estimation.getCustomerId());
            }
        }

        if (!StringUtils.isEmpty(settlement.getCreatedUser())) {
            workbasketTransactionActivity.setCreatedUser(settlement.getCreatedUser());
        }

        if (!StringUtils.isEmpty(reviewUserGroupId)) {
            workbasketTransactionActivity.setAssignedGroupId(reviewUserGroupId);
        } else if (!StringUtils.isEmpty(approveUserGroupId)) {
            workbasketTransactionActivity.setAssignedGroupId(approveUserGroupId);
        }

        workbasketTransactionActivityRepository.save(workbasketTransactionActivity);

    }

    @Transactional
    public boolean acceptPaymentApproval(String claimNo, String userGroupId) {

        // validate user has valid group id and has permission to approve the payment
        userRoleValidationUtil.validateUserGroupId(userGroupId);
        userRoleValidationUtil.validateUserPermission(claimNo, userGroupId, false);

        Long fnolSgsId = getFnolSgsId(claimNo);
        String userName = JWTUtil.getUserId();

        ClaimTransactionSettlement claimTransactionSettlement = invokeRepo(() -> claimTransactionSettlementRepo.findByFnolSgsId(fnolSgsId),
                                                                           "claimTransactionSettlementRepo.findByFnolSgsId(fnolSgsId)");
        if (null != claimTransactionSettlement) {
            claimTransactionSettlement.setApproveFlag(ClaimEnumConstants.ACCEPT_PAYMENT_APPROVE_FLAG.toString());
            claimTransactionSettlement.setApprovedDate(new Date());
            claimTransactionSettlement.setApproveUser(userName);
            claimTransactionSettlement.setPaidFlag(ClaimEnumConstants.ACCEPT_PAYMENT_PAID_FLAG.toString());
        }

        String approveActivityId = invokeRepo(() -> udsIdDefinitionRepository.findIdByType(ClaimEnumConstants.WORK_BASKET_ACTIVITY_TYPE.toString(),
                                                                                           ClaimEnumConstants.PAYMENT_APPROVE_DESC.toString()),
                                              "udsIdDefinitionRepository.findIdByType(ClaimConstants.WORK_BASKET_ACTIVITY_TYPE.toString(),ClaimConstants.PAYMENT_APPROVE_DESC.toString()");
        List<WorkBasketTransactionActivity> workbasketTransactionActivityList = invokeRepo(() -> workbasketTransactionActivityRepository.findByFnolSgsIdAndActivityId(fnolSgsId,
                                                                                                                                                                      approveActivityId,
                                                                                                                                                                      userGroupId),
                                                                                           "WorkbasketTransactionActivityRepository.findByFnolSgsId(fnolSgsId, reviewActivityId, userGroupId)");
        if (!workbasketTransactionActivityList.isEmpty()) {
            WorkBasketTransactionActivity workbasketTransactionActivity = workbasketTransactionActivityList.get(0);
            String approveAcceptActivityId = invokeRepo(() -> udsIdDefinitionRepository.findIdByType(ClaimEnumConstants.WORK_BASKET_ACTIVITY_TYPE.toString(),
                                                                                                     ClaimEnumConstants.PAYMENT_APPROVE_ACCEPT_DESC.toString()),
                                                        "udsIdDefinitionRepository.findIdByType(ClaimConstants.WORK_BASKET_ACTIVITY_TYPE.toString(),ClaimConstants.PAYMENT_APPROVE_ACCEPT_DESC.toString()");
            workbasketTransactionActivity.setActivityId(approveAcceptActivityId);
            invokeRepo(() -> workbasketTransactionActivityRepository.save(workbasketTransactionActivity),
                       "workbasketTransactionActivityRepository.save(workbasketTransactionActivity)");
            saveClaimTransactionSettlement(claimTransactionSettlement);
        }
        return true;
    }

    @Transactional
    public boolean rejectPaymentApproval(String claimNo, String userGroupId) {

        // validate user has valid group id and has permission to approve the payment
        userRoleValidationUtil.validateUserGroupId(userGroupId);
        userRoleValidationUtil.validateUserPermission(claimNo, userGroupId, false);

        // Update approval flag to 'C' and paid flag to 'C'
        Long fnolSgsId = getFnolSgsId(claimNo);
        ClaimTransactionSettlement claimTransactionSettlement = invokeRepo(() -> claimTransactionSettlementRepo.findByFnolSgsId(fnolSgsId),
                                                                           "claimTransactionSettlementRepo.findByFnolSgsId(fnolSgsId)",
                                                                           true);
        if (null != claimTransactionSettlement) {

            claimTransactionSettlement.setApproveFlag(ClaimEnumConstants.REJECT_PAYMENT_APPROVE_FLAG.toString());
            claimTransactionSettlement.setLinkSerialNo(claimTransactionSettlement.getSgsId());
            claimTransactionSettlement.setPaidFlag(ClaimEnumConstants.REJECT_PAYMENT_PAID_FLAG.toString());

            String approveActivityId = invokeRepo(() -> udsIdDefinitionRepository.findIdByType(ClaimEnumConstants.WORK_BASKET_ACTIVITY_TYPE.toString(),
                                                                                               ClaimEnumConstants.PAYMENT_APPROVE_DESC.toString()),
                                                  "udsIdDefinitionRepository.findIdByType(ClaimConstants.WORK_BASKET_ACTIVITY_TYPE.toString(),ClaimConstants.PAYMENT_APPROVE_DESC.toString()");
            List<WorkBasketTransactionActivity> workbasketTransactionActivityList = invokeRepo(() -> workbasketTransactionActivityRepository.findByFnolSgsIdAndActivityId(fnolSgsId,
                                                                                                                                                                          approveActivityId,
                                                                                                                                                                          userGroupId),
                                                                                               "WorkbasketTransactionActivityRepository.findByFnolSgsId(fnolSgsId, reviewActivityId, userGroupId)");
            if (!workbasketTransactionActivityList.isEmpty()) {
                WorkBasketTransactionActivity workbasketTransactionActivity = workbasketTransactionActivityList.get(0);
                String approveRejectActivityId = invokeRepo(() -> udsIdDefinitionRepository.findIdByType(ClaimEnumConstants.WORK_BASKET_ACTIVITY_TYPE.toString(),
                                                                                                         ClaimEnumConstants.PAYMENT_APPROVE_REJECT_DESC.toString()),
                                                            "udsIdDefinitionRepository.findIdByType(ClaimConstants.WORK_BASKET_ACTIVITY_TYPE.toString(),ClaimConstants.PAYMENT_APPROVE_REJECT_DESC.toString()");
                workbasketTransactionActivity.setActivityId(approveRejectActivityId);
                invokeRepo(() -> workbasketTransactionActivityRepository.save(workbasketTransactionActivity),
                           "workbasketTransactionActivityRepository.save(workbasketTransactionActivity)");

                saveClaimTransactionSettlement(claimTransactionSettlement);

                // Insert new data with revised serial revision number
                claimTransactionSettlement.setSgsId(null);
                claimTransactionSettlement.setRevisionSerialNo(claimTransactionSettlement.getRevisionSerialNo() + 1);
                saveClaimTransactionSettlement(claimTransactionSettlement);
            }
        }

        return true;
    }

    @Transactional
    public boolean acceptPaymentReview(String claimNo, String userGroupId) {

        // validate user has valid group id and has permission to review the payment
        userRoleValidationUtil.validateUserGroupId(userGroupId);
        userRoleValidationUtil.validateUserPermission(claimNo, userGroupId, true);

        Long fnolSgsId = getFnolSgsId(claimNo);

        ClaimTransactionSettlement claimTransactionSettlement = invokeRepo(() -> claimTransactionSettlementRepo.findByFnolSgsId(fnolSgsId),
                                                                           "claimTransactionSettlementRepo.findByFnolSgsId(fnolSgsId)");
        if (null != claimTransactionSettlement) {
            claimTransactionSettlement.setApproveFlag("N");
            claimTransactionSettlement.setPaidFlag("N");
            claimTransactionSettlement.setReviewedDate(new Date());

            String reviewActivityId = invokeRepo(() -> udsIdDefinitionRepository.findIdByType(ClaimEnumConstants.WORK_BASKET_ACTIVITY_TYPE.toString(),
                                                                                              ClaimEnumConstants.PAYMENT_REVIEW_DESC.toString()),
                                                 "udsIdDefinitionRepository.findIdByType(ClaimConstants.WORK_BASKET_ACTIVITY_TYPE.toString(),ClaimConstants.PAYMENT_REVIEW_DESC.toString()");

            List<WorkBasketTransactionActivity> workbasketTransactionActivityList = invokeRepo(() -> workbasketTransactionActivityRepository.findByFnolSgsIdAndActivityId(fnolSgsId,
                                                                                                                                                                          reviewActivityId,
                                                                                                                                                                          userGroupId),
                                                                                               "WorkbasketTransactionActivityRepository.findByFnolSgsId(fnolSgsId), reviewActivityId, userGroupId",
                                                                                               true);
            if (!workbasketTransactionActivityList.isEmpty()) {
                WorkBasketTransactionActivity workbasketTransactionActivity = workbasketTransactionActivityList.get(0);
                workbasketTransactionActivity.setUpdatedDate(new Date());
                workbasketTransactionActivity.setUpdatedUser(JWTUtil.getUserId());
                String reviewAcceptActivityId = invokeRepo(() -> udsIdDefinitionRepository.findIdByType(ClaimEnumConstants.WORK_BASKET_ACTIVITY_TYPE.toString(),
                                                                                                        ClaimEnumConstants.PAYMENT_REVIEW_ACCEPT_DESC.toString()),
                                                           "udsIdDefinitionRepository.findIdByType(ClaimConstants.WORK_BASKET_ACTIVITY_TYPE.toString(),ClaimConstants.PAYMENT_REVIEW_ACCEPT_DESC.toString()");
                workbasketTransactionActivity.setActivityId(reviewAcceptActivityId);
                invokeRepo(() -> workbasketTransactionActivityRepository.save(workbasketTransactionActivity),
                           "workbasketTransactionActivityRepository.save(workbasketTransactionActivity)");

                String approveActivityId = invokeRepo(() -> udsIdDefinitionRepository.findIdByType(ClaimEnumConstants.WORK_BASKET_ACTIVITY_TYPE.toString(),
                                                                                                   ClaimEnumConstants.PAYMENT_APPROVE_DESC.toString()),
                                                      "udsIdDefinitionRepository.findIdByType(ClaimConstants.WORK_BASKET_ACTIVITY_TYPE.toString(),ClaimConstants.PAYMENT_APPROVE_DESC.toString()");

                workbasketTransactionActivity.setActivityId(approveActivityId);
                workbasketTransactionActivity.setAssignedUser(claimTransactionSettlement.getApprover());
                String approverGroupId = claimTransactionSettlementRepo.getAssignApproveUserGroupId(claimTransactionSettlement.getPaymentAmountBC(),
                                                                                       claimTransactionSettlement.getCreatedUser(),
                                                                                       claimTransactionSettlement.getApprover(),
                                                                                       claimTransactionSettlement.getCoverId(),
                                                                                       claimsRepository.getProductId(fnolSgsId));
                workbasketTransactionActivity.setAssignedGroupId(approverGroupId);
                workbasketTransactionActivity.setActivitySGSId(null);
                invokeRepo(() -> workbasketTransactionActivityRepository.save(workbasketTransactionActivity),
                           "workbasketTransactionActivityRepository.save(workbasketTransactionActivity)");
                saveClaimTransactionSettlement(claimTransactionSettlement);
            }
        }

        return true;
    }

    @Transactional
    public boolean rejectPaymentReview(String claimNo, String userGroupId) {

        // validate user has valid group id and has permission to review the payment
        userRoleValidationUtil.validateUserGroupId(userGroupId);
        userRoleValidationUtil.validateUserPermission(claimNo, userGroupId, true);

        Long fnolSgsId = getFnolSgsId(claimNo);
        String reviewActivityId = invokeRepo(() -> udsIdDefinitionRepository.findIdByType(ClaimEnumConstants.WORK_BASKET_ACTIVITY_TYPE.toString(),
                                                                                          ClaimEnumConstants.PAYMENT_REVIEW_DESC.toString()),
                                             "udsIdDefinitionRepository.findIdByType(ClaimConstants.WORK_BASKET_ACTIVITY_TYPE.toString(),ClaimConstants.PAYMENT_REVIEW_DESC.toString()");
        List<WorkBasketTransactionActivity> workbasketTransactionActivityList = invokeRepo(() -> workbasketTransactionActivityRepository.findByFnolSgsIdAndActivityId(fnolSgsId,
                                                                                                                                                                      reviewActivityId,
                                                                                                                                                                      userGroupId),
                                                                                           "WorkbasketTransactionActivityRepository.findByFnolSgsId(fnolSgsId, reviewActivityId, userGroupId)");
        if (!workbasketTransactionActivityList.isEmpty()) {
            WorkBasketTransactionActivity workbasketTransactionActivity = workbasketTransactionActivityList.get(0);
            String reviewRejectActivityId = invokeRepo(() -> udsIdDefinitionRepository.findIdByType(ClaimEnumConstants.WORK_BASKET_ACTIVITY_TYPE.toString(),
                                                                                                    ClaimEnumConstants.PAYMENT_REVIEW_REJECT_DESC.toString()),
                                                       "udsIdDefinitionRepository.findIdByType(ClaimConstants.WORK_BASKET_ACTIVITY_TYPE.toString(),ClaimConstants.PAYMENT_REVIEW_REJECT_DESC.toString()");
            workbasketTransactionActivity.setActivityId(reviewRejectActivityId);
            invokeRepo(() -> workbasketTransactionActivityRepository.save(workbasketTransactionActivity),
                       "workbasketTransactionActivityRepository.save(workbasketTransactionActivity)");
        }
        return true;
    }

    @Transactional
    public boolean updatePaymentDetails(String claimNo, PaymentDetails paymentDetails) {

        Long fnolSgsId = getFnolSgsId(claimNo);
        ClaimTransactionSettlement claimTransactionSettlement = invokeRepo(() -> claimTransactionSettlementRepo.findByFnolSgsId(fnolSgsId),
                                                                           "claimTransactionSettlementRepo.findByFnolSgsId(fnolSgsId)",
                                                                           true);
        if (null != claimTransactionSettlement) {

            claimTransactionSettlement.setSettledAmount(paymentDetails.getSettledAmount());
            saveClaimTransactionSettlement(claimTransactionSettlement);

            ClaimTransactionEstimation claimTransactionEstimation = invokeRepo(() -> claimTransactionEstimationRepository.findByFnolSgsId(fnolSgsId),
                                                                               "claimTransactionEstimationRepository.findByFnolSgsId(fnolSgsId)",
                                                                               true);
            if (null != claimTransactionEstimation) {
                double outstandingAmount = claimTransactionEstimation.getEstimatedAmount()
                                           - claimTransactionSettlement.getSettledAmount();
                claimTransactionEstimation.setOutstandingAmount(outstandingAmount);
                invokeRepo(() -> claimTransactionEstimationRepository.save(claimTransactionEstimation),
                           "claimTransactionEstimationRepository.save(claimTransactionEstimation)");
            }
        }
        return true;
    }

    private Long getFnolSgsId(String claimNo) {

        Long fnolSgsId = invokeRepo(() -> claimFnolDetailsRepository.getFnolSgsId(claimNo),
                                    "claimFnolDetailsRepository.getFnolSgsId(claimNo)");
        if (null == fnolSgsId) {
            throw new ValidationException(ErrorCode.CLAIM_DOES_NOT_EXIST);
        }
        return fnolSgsId;
    }

    private void saveClaimTransactionSettlement(ClaimTransactionSettlement claimTransactionSettlement) {

        invokeRepo(() -> claimTransactionSettlementRepo.save(claimTransactionSettlement),
                   "claimTransactionSettlementRepo.save(claimTransactionSettlement)");
    }

    private Map<ErrorCode, Object[]> validatePaymentCreate(PaymentDTO paymentDTO) {

        Map<ErrorCode, Object[]> errorDetails = new HashMap<>();

        if (StringUtils.isEmpty(paymentDTO.getComplaintNumber()) || paymentDTO.getComplaintNumber().trim().isEmpty()) {
            errorDetails.put(ErrorCode.EMPTY_COMPALINT_FIELD, null);
        }
        if (org.apache.commons.lang3.StringUtils.isBlank(paymentDTO.getPaymentAmount())) {
            errorDetails.put(ErrorCode.EMPTY_PAYMENT_AMOUNT, null);

        } else {
            try {
                Double.parseDouble(paymentDTO.getPaymentAmount());
                if (Double.parseDouble(paymentDTO.getPaymentAmount()) == 0.0) {
                    errorDetails.put(ErrorCode.EMPTY_PAYMENT_AMOUNT, null);
                }
            } catch (NumberFormatException e) {
                errorDetails.put(ErrorCode.PAYMENT_AMOUNT, null);
            }

        }
        if (StringUtils.isEmpty(paymentDTO.getPayeeName()) || paymentDTO.getPayeeName().trim().isEmpty()) {
            errorDetails.put(ErrorCode.EMPTY_PAYEE_NAME, null);
        }

        if (!StringUtils.isEmpty(paymentDTO.getPayee()) && paymentDTO.getPayee().equals("W")) {
            if (StringUtils.isEmpty(paymentDTO.getWorkerPhoneNo()) || paymentDTO.getWorkerPhoneNo().trim().isEmpty()) {
                errorDetails.put(ErrorCode.EMPTY_PHONE_FIELD, null);
            }
        }

        return errorDetails;
    }

    public boolean addNewEstimate(String claimNo, NewEstimate newEstimate) {

        boolean flag = false;

        long fnolSgsId = claimFnolDetailsRepository.getFnolSgsId(claimNo);
        int serialRevisionNo = claimWorkingDetailsRepository.getLatestSerialRevisionNo(fnolSgsId);
        ClaimWorkingEstimation workingEstimate = invokeRepo(() -> claimWorkingDetailsRepository.findByFnolSgsIdAndRevisionSerialNo(fnolSgsId,
                                                                                                                                   serialRevisionNo),
                                                            "claimWorkingDetailsRepository.findByFnolSgsIdAndRevisionSerialNo(fnolSgsId, serialRevisionNo)",
                                                            true);

        workingEstimate.setRevisionSerialNo(workingEstimate.getRevisionSerialNo() + 1);
        workingEstimate.setCoverId(newEstimate.getCover());
        workingEstimate.setLosstype(newEstimate.getLossType());
        workingEstimate.setUpdatedDate(newEstimate.getDate());
        workingEstimate.setEstimatedAmount(newEstimate.getAmount());
        workingEstimate.setOutstandingAmount(newEstimate.getOutstandingAmount());

        invokeRepo(() -> claimWorkingDetailsRepository.save(workingEstimate),
                   "claimWorkingDetailsRepository.save(workingEstimate)");

        flag = true;

        return flag;

    }
}

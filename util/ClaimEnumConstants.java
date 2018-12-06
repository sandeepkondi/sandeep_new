package com.beyontec.mol.util;

public enum ClaimEnumConstants {
    CLAIM_NO("CLAIM NO"), 
    CERTIFICATE_NO("CERTIFICATE NO"), 
    EMIRATES_ID("EMIRATED ID"), 
    BATCH_NO("BATCH NO"), 
    CLAIM_LAUNCH_DATE("CLAIM LAUNCH DATE"),
    EMPLOYEE("EMPLOYEE"), 
    EMPLOYEE_TYPE("EMPLOYEE TYPE"), 
    EMPLOYEER_NAME("EMPLOYEER NAME"), 
    CLAIM_STATUS("CLAIM STATUS"), 
    CLOSE_REASON_TYPE("CLM_CLOS_RSN"), 
    REOPEN_OR_DECLINE_REASON_TYPE("CLM_EST_REV_RSN"), 
    WORK_BASKET_ACTIVITY_TYPE("WB_ACT_TYP"),
    REOPEN("reopen"), 
    DECLINE("decline"), 
    CLOSE("close"),
    REOPEN_FNOL_STATUS("RO"), 
    REOPEN_CLOSE_FLAG("A"), 
    REOPEN_APPROVE_FLAG("N"), 
    DECLINE_FNOL_STATUS("CD"), 
    DECLINE_CLOSE_FLAG("AC"), 
    DECLINE_APPROVE_FLAG("CL"), 
    CLOSE_FNOL_STATUS("CL"), 
    CLOSE_CLOSE_FLAG("C"), 
    CLOSE_APPROVE_FLAG("CL"),
    ACCEPT_PAYMENT_APPROVE_FLAG("A"),
    ACCEPT_PAYMENT_PAID_FLAG("P"),
    REJECT_PAYMENT_APPROVE_FLAG("C"),
    REJECT_PAYMENT_PAID_FLAG("C"),
    WORKER_NAME("WORKER NAME"),
    ACTIVITY("ACTIVITY"),
    LOSS_DATE("LOSS DATE"),
    APPROVED_DATE("APPROVED_DATE"),
    PAYMENT_REVIEW_ACCEPT_DESC("Settlement Request Review - Approved"),
    PAYMENT_REVIEW_REJECT_DESC("Settlement Request Review - Rejected"),
    PAYMENT_REVIEW_DESC("Settlement Request Review"),
    PAYMENT_APPROVE_DESC("Settlement Request Approval"),
    PAYMENT_APPROVE_ACCEPT_DESC("Settlement Request Approval - Approved"),
    PAYMENT_APPROVE_REJECT_DESC("Settlement Request Approval - Rejected"),
    REVIEW("review"),
    APPROVE("approve");

    private final String name;

    private ClaimEnumConstants(String s) {
        name = s;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
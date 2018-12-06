package com.beyontec.mol.util;

public final class AppConstants {
	
	public static final String CERTIFICATE_NO = "certificateNo";
	public static final String ERRORS = "errors";
	public static final String DOCUMENT_PATH = "documentPath";
    public static final String FILE_NAME = "fileName";
    public static final String PDF_FILE_EXTENSION = ".pdf";
    public static final String PDF_CONTENT_TYPE = "application/pdf";
    public static final String EXCEL_FILE_EXTENSION = ".xlsx";
    public static final String EXCEL_CONTENT_TYPE = "application/vnd.ms-excel";
    public static final String ATTACHMENT = "attachment; filename= \"{0}\"";
    public static final String ENGLISH = "en";
    public static final String ARABIC = "ar";

    //batch process
    public static final String INPROGRESS_BATCH = "INPROGRESS";
    public static final String ERROR_BATCH = "ERRORS";
    public static final String COMPLETED_BATCH = "COMPLETED";

    //acknowledgement
    public static final String ACK_SENT = "SENT";

    //view certificate
    public static final String[] DIVISION = new String[] { "Division", "قطاع" };
    public static final String[] DEPARTMENT = new String[] { "Department", "قسم، أقسام" };
    public static final String[] CERTIFICATE_NUMBER = new String[] { "Certificate No", "شهادة رقم" };
    public static final String[] EMPLOYER_NAME = new String[] { "Employer Name", "اسم الموظف" };
    public static final String[] EMPLOYER_LICENSE_NO = new String[] { "Employer License No", "رخصة صاحب العمل" };
    public static final String[] ESTABLISHMENT_CLASSIFICATION = new String[] { "Establishment Classification",
                                                                               "تصنيف المؤسسة" };
    public static final String[] ESTABLISHMENT_CARD_NO = new String[] { "Establishment Card No", "رقم بطاقة المنشأة" };
    public static final String[] EMPLOYEE_NAME = new String[] { "Employee Name", "اسم الموظف" };
    public static final String[] NATIONALITY = new String[] { "Nationality", "جنسية" };
    public static final String[] DATE_OF_BIRTH = new String[] { "DOB", "تاريخ الميلاد" };
    public static final String[] GENDER = new String[] { "Gender", "جنس" };
    public static final String[] EMIRATES_ID = new String[] { "Emirates ID", "هوية الإمارات" };
    public static final String[] MARITAL_STATUS = new String[] { "Marital Status", "الحالة الحالة الإجتماعية" };
    public static final String[] PASSPORT_NO = new String[] { "Passport No", "رقم جواز السفر" };
    public static final String[] PASSPORT_TYPE = new String[] { "Passport Type", "نوع جواز السفر" };
    public static final String[] LABOUR_REFERENCE_NO = new String[] { "Labour Reference No", "مرجع العمل" };
    public static final String[] ENSCO_MOHRE = new String[] { "ENSCO/MOHRE", "ENSCO/MOHRE" };
    public static final String[] INDUSTRY = new String[] { "Industry", "صناعة" };
    public static final String[] POLICY_PERIOD = new String[] { "Policy Period", "فترة السياسة" };
    public static final String[] EMPLOYEE_CATEGORY = new String[] { "Employee Category", "فئة الموظف" };
    public static final String[] COVERS = new String[] { "Covers", "أغلفة" };
    public static final String[] PREMIUM = new String[] { "Premium", "علاوة" };

    //error details
    public static final String APPROVAL_DATE = "approvalDate";
    public static final String EXPIRY_DATE = "expiryDate";

    //config
    public static final String MOHRE_JOB_CONFIG = "MOHREJOB";
    public static final String GENDER_CONFIG = "GENDER";
    public static final String NATIONALITY_CONFIG = "NATIONALITY";
    public static final String INDUSTRY_CONFIG = "INDUSTRY";
    public static final String INSURER_PROCESS_CONFIG = "INSURERPROCESS";
    public static final String INSURER_PROCESS_STATUS_CONFIG = "INSURERPROCESSSTATUS";

    //dashboard
    public static final String[] DASHBOARD_SUMMARY_TITLE = new String[] { "Production - {0}", "{0} - إنتاج" };
    public static final String[] DASHBOARD_POOL_MEMBER_TITLE = new String[] { "{0} Pool Member Premium",
                                                                              "بركة عضو بريميوم  {0}" };
    // UW & Claims insurer
    public static final String UNDERWRITING_TYPE = "01";
    public static final String UNDERWRITING_PEN_STATUS = "PEN";

    // export details for re insurer
    public static final String[] REINSURER_OVERALL_UW_COLUMN_HEADERS = new String[] { "Certificate No",
                                                                                      "Insured Name",
                                                                                      "Sponser Name",
                                                                                      "Certificate From Date",
                                                                                      "Certificate To Date",
                                                                                      "Total Premium",
                                                                                      "Retention Amount",
                                                                                      "Quota Amount",
                                                                                      "RI Commission" };
    public static final String[] REINSURER_OVERALL_UW_COLUMN_FIELDS = new String[] { "certificateNo",
                                                                                      "insuredName",
                                                                                      "sponserName",
                                                                                      "fromDate",
                                                                                      "toDate",
                                                                                      "totalPremium",
                                                                                      "retentionAmount",
                                                                                      "quotaAmount",
                                                                                      "riCommission" };
    public static final String REINSURER_OVERALL_UWS_FILENAME = "reinsurer_overall_uws";
    public static final String REINSURER_PARTICIPANT_UWS_FILENAME = "reinsurer_participant_uws";
    public static final String[] REINSURER_OVERALL_CLAIM_COLUMN_HEADERS = new String[] { "Claim No",
                                                                                         "Certificate No",
                                                                                         "Insured Name",
                                                                                         "Sponser Name",
                                                                                         "Certificate From Date",
                                                                                         "Certificate To Date",
                                                                                         "Claims Total Amount",
                                                                                         "Claims RI Participants Amount" };
    public static final String[] REINSURER_OVERALL_CLAIM_COLUMN_FIELDS = new String[] { "claimNo",
                                                                                        "certificateNo",
                                                                                        "insuredName",
                                                                                        "sponserName",
                                                                                        "fromDate",
                                                                                        "toDate",
                                                                                        "totalAmount",
                                                                                        "participantAmount" };
    public static final String REINSURER_OVERALL_CLAIMS_FILENAME = "reinsurer_overall_claims";
    public static final String[] REINSURER_PARTICIPANT_CLAIM_COLUMN_HEADERS = new String[] { "Claim No",
                                                                                             "Certificate No",
                                                                                             "Insured Name",
                                                                                             "Sponser Name",
                                                                                             "Certificate From Date",
                                                                                             "Certificate To Date",
                                                                                             "Claims Total Amount",
                                                                                             "Claims Retention Share",
                                                                                             "Claims RI QS Share" };
    public static final String[] REINSURER_PARTICIPANT_CLAIM_COLUMN_FIELDS = new String[] { "claimNo",
                                                                                            "certificateNo",
                                                                                            "insuredName",
                                                                                            "sponserName",
                                                                                            "fromDate",
                                                                                            "toDate",
                                                                                            "totalAmount",
                                                                                            "retentionShare",
                                                                                            "qsShare" };
    public static final String REINSURER_PARTICIPANT_CLAIMS_FILENAME = "reinsurer_participant_claims";

    // export details for pool insurer
    public static final String[] POOLINSURER_OVERALL_CERT_COLUMN_HEADERS = new String[] { "Certificate No.",
                                                                                          "Insured Name ",
                                                                                          "Sponser Name",
                                                                                          "Certificate From Date",
                                                                                          "Certificate To Date",
                                                                                          "Total Premium",
                                                                                          "Our Share Premium",
                                                                                          "Pool Insurer Premium",
                                                                                          "Pool Insurer VAT",
                                                                                          "Leader Fee",
                                                                                          "Leader fee VAT",
                                                                                          "Retro Cedent Premium",
                                                                                          "Retro VAT",
                                                                                          "Retro Cedent Commission",
                                                                                          "Retro Commission VAT",
                                                                                          "Net Premium" };
    public static final String[] POOLINSURER_OVERALL_CERT_COLUMN_FIELDS = new String[] { "certificateNo",
                                                                                         "insuredName",
                                                                                         "sponsorName",
                                                                                         "certificateFromDate",
                                                                                         "certificateToDate",
                                                                                         "totalPremium",
                                                                                         "ourSharePremium",
                                                                                         "poolInsurerPremium",
                                                                                         "poolInsurerVAT",
                                                                                         "leaderFee",
                                                                                         "leaderfeeVAT",
                                                                                         "retroCedentPremium",
                                                                                         "retroVAT",
                                                                                         "retroCedentcommission",
                                                                                         "retroCommissionVAT",
                                                                                         "netPremium" };
    public static final String POOLINSURER_OVERALL_CERTS_FILENAME = "poolinsurer_overall_certificates";
    public static final String[] POOLINSURER_INSURANCE_CERT_COLUMN_HEADERS = new String[] { "Pool Insurer Name",
                                                                                            "certificateNo",
                                                                                            "insuredName",
                                                                                            "sponsorName",
                                                                                            "certificateFromDate",
                                                                                            "certificateToDate",
                                                                                            "totalPremium",
                                                                                            "ourSharePremium",
                                                                                            "poolInsurerPremium",
                                                                                            "poolInsurerVAT",
                                                                                            "leaderFee",
                                                                                            "leaderfeeVAT",
                                                                                            "retroCedentPremium",
                                                                                            "retroVAT",
                                                                                            "retroCedentcommission",
                                                                                            "retroCommissionVAT",
                                                                                            "netPremium" };
    public static final String[] POOLINSURER_INSURANCE_CERT_COLUMN_FIELDS = new String[] { "poolInsurerName",
                                                                                           "certificateNo",
                                                                                           "insuredName",
                                                                                           "sponsorName",
                                                                                           "certificateFromDate",
                                                                                           "certificateToDate",
                                                                                           "totalPremium",
                                                                                           "ourSharePremium",
                                                                                           "poolInsurerPremium",
                                                                                           "poolInsurerVAT",
                                                                                           "leaderFee",
                                                                                           "leaderfeeVAT",
                                                                                           "retroCedentPremium",
                                                                                           "retroVAT",
                                                                                           "retroCedentcommission",
                                                                                           "retroCommissionVAT",
                                                                                           "netPremium" };
    public static final String POOLINSURER_INSURANCE_CERTS_FILENAME = "poolinsurer_insurance_certificates";
    public static final String[] POOLINSURER_OVERALL_CLAIM_COLUMN_HEADERS = new String[] { "Claim No.",
                                                                                           "Certificate No.",
                                                                                           "Insured Name ",
                                                                                           "Sponser Name",
                                                                                           "Certificate From Date",
                                                                                           "Certificate To Date",
                                                                                           "Total Claim Amount",
                                                                                           "Our Share",
                                                                                           "Pool Insurer Share",
                                                                                           "Retro Cedent Share",
                                                                                           "Net Share of Pool Insurer" };
    public static final String[] POOLINSURER_OVERALL_CLAIM_COLUMN_FIELDS = new String[] { "claimNo",
                                                                                          "certificateNo",
                                                                                          "insuredName",
                                                                                          "sponsorName",
                                                                                          "certificateFromDate",
                                                                                          "certificateToDate",
                                                                                          "claimAmount",
                                                                                          "ourShare",
                                                                                          "poolInsurerShare",
                                                                                          "retroCedentShare",
                                                                                          "netShareofPoolInsurer" };
    public static final String POOLINSURER_OVERALL_CLAIMS_FILENAME = "poolinsurer_overall_claims";
    public static final String[] POOLINSURER_INSURANCE_CLAIM_COLUMN_HEADERS = new String[] { "Pool Insurer Name ",
                                                                                             "Claim No.",
                                                                                             "Certificate No.",
                                                                                             "Insured Name ",
                                                                                             "Sponser Name",
                                                                                             "Certificate From Date",
                                                                                             "Certificate To Date",
                                                                                             "Total Claim Amount",
                                                                                             "Our Share ",
                                                                                             "Pool Insurer ",
                                                                                             "Retro Cedent Share",
                                                                                             "Net Share of Pool Insurer" };
    public static final String[] POOLINSURER_INSURANCE_CLAIM_COLUMN_FIELDS = new String[] { "poolInsurerName",
                                                                                            "claimNo",
                                                                                            "certificateNo",
                                                                                            "insuredName",
                                                                                            "sponsorName",
                                                                                            "certificateFromDate",
                                                                                            "certificateToDate",
                                                                                            "claimAmount",
                                                                                            "ourShare",
                                                                                            "poolInsurerShare",
                                                                                            "retroCedentShare",
                                                                                            "netShareofPoolInsurer" };
    public static final String POOLINSURER_INSURANCE_CLAIMS_FILENAME = "poolinsurer_insurance_claims";

    // export details for certificates
    public static final String[] CERTIFICATES_COLUMN_HEADERS = new String[] { "Certificate No.",
                                                                              "Sponser Name",
                                                                              "Sponser Licence No.",
                                                                              "Establishment Classification",
                                                                              "Industry",
                                                                              "Establishment Card No.",
                                                                              "File No",
                                                                              "Employee Name",
                                                                              "Date Of Birth",
                                                                              "Gender",
                                                                              "Nationality",
                                                                              "Country Of Birth",
                                                                              "Passport Type",
                                                                              "Passport No.",
                                                                              "Marital Status",
                                                                              "MOHRE JOB ID",
                                                                              "ENSCO JOB ID",
                                                                              "Employee Category",
                                                                              "Labour Reference No.",
                                                                              "Visa Approved Date",
                                                                              "Visa Expired Date",
                                                                              "Emirates ID",
                                                                              "Approval Date",
                                                                              "Premium",
                                                                              "Co Insurer Premium" };
    public static final String[] CERTIFICATES_COLUMN_FIELDS = new String[] { "certificateNo",
                                                                             "sponserName",
                                                                             "sponserLicenseNo",
                                                                             "estClassification",
                                                                             "industry",
                                                                             "estCardNo",
                                                                             "fileNo",
                                                                             "employeeName",
                                                                             "dob",
                                                                             "gender",
                                                                             "nationality",
                                                                             "cob",
                                                                             "passportType",
                                                                             "passportNo",
                                                                             "maritalStatus",
                                                                             "mohreJobId",
                                                                             "enscoJobId",
                                                                             "employeeCategory",
                                                                             "labourRefNo",
                                                                             "visaApprovedDate",
                                                                             "visaExpiredDate",
                                                                             "emiratesId",
                                                                             "approvalDate",
                                                                             "premium",
                                                                             "coInsurerPremium" };
    public static final String CERTIFICATES_FILENAME = "certificate_list";

    // export details for claims
    public static final String[] CLAIMS_COLUMN_HEADERS = new String[] { "Claim No.",
                                                                        "Certificate No.",
                                                                        "Emirates Id",
                                                                        "Batch No.",
                                                                        "Claim Launch Date",
                                                                        "Employee",
                                                                        "Employee Type",
                                                                        "Employer Name",
                                                                        "Claim Status" };
    public static final String[] CLAIMS_COLUMN_FIELDS = new String[] { "claimNo",
                                                                       "certificateNo",
                                                                       "emiratesId",
                                                                       "batchNo",
                                                                       "claimLaunchDate",
                                                                       "employee",
                                                                       "employeeType",
                                                                       "employerName",
                                                                       "claimStatus" };
    public static final String CLAIMS_FILENAME = "claim_list";

    // export details for workbasket
    public static final String[] WORKBASKET_COLUMN_HEADERS = new String[] { "Claim No.",
                                                                            "Worker Name",
                                                                            "Activity",
                                                                            "Loss Date",
                                                                            "Approved Date" };
    public static final String[] WORKBASKET_COLUMN_FIELDS = new String[] { "claimNo",
                                                                           "workerName",
                                                                           "activity",
                                                                           "lossDate",
                                                                           "approvedDate" };
    public static final String WORKBASKET_FILENAME = "workbasket_list";
}

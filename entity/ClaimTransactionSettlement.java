package com.beyontec.mol.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.beyontec.mol.modal.PaymentReviewAndApproveUser;

@Entity
@Table(name = "CTDS_LEVEL_S")

@SqlResultSetMappings({
    @SqlResultSetMapping(
                      name = "assignedUserRsMapping",
                      classes = @ConstructorResult(
                                                   targetClass = PaymentReviewAndApproveUser.class,
                                                   columns = {
                                                              @ColumnResult(name = "USER_ID", type = String.class),
                                                              @ColumnResult(name = "USER_GROUP_ID", type = String.class)
                                                   })
                      )
})

@NamedNativeQueries({
    @NamedNativeQuery(
                      name = "getAssignedUser",
                      resultSetMapping = "assignedUserRsMapping",
                      query = "SELECT DISTINCT CEUE_ESCAL_AU_ID USER_ID, "
                      + "(SELECT AU_AUG_ID FROM ADS_USER WHERE AU_ID = CEUE_ESCAL_AU_ID AND AU_COMP_ID = CEUE_COMP_ID) USER_GROUP_ID "
                      + "FROM CUDS_EST_USR_ESCALATION "
                      + "WHERE CEUE_TYP = 'P' "
                      + "AND CEUE_ESCAL_TYP = :escalationType "
                      + "AND :amount BETWEEN CEUE_ESCAL_AMT_FM AND CEUE_ESCAL_AMT_TO "
                      + "AND (CEUE_AU_ID, CEUE_AUG_ID) IN (SELECT AU_ID , AU_AUG_ID FROM ADS_USER WHERE AU_ID = :userId) "
                      + "AND CEUE_CVR_ID =:coverId "
                      + "AND (CEUE_COB_ID, CEUE_PROD_ID) IN (SELECT UPAC_UC_COB_ID, UPAC_UP_PROD_ID FROM UDS_PROD_APPL_COB WHERE UPAC_UP_PROD_ID = :productId AND UPAC_COMP_ID = CEUE_COMP_ID) "
                      + "AND CEUE_PROD_ID = :productId "
                      )
})
//@formatter:on
@EntityListeners(AuditingEntityListener.class)
public class ClaimTransactionSettlement {

	@Id
	@Column(name = "CLS_SGS_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sgs_id_generator")
	@SequenceGenerator(name = "sgs_id_generator", sequenceName = "SEQ_CLS_SGS_ID", allocationSize = 1)
	private Long sgsId;

	@Column(name = "CLS_CLF_SGS_ID")
	private Long fnolSgsId;

	@Column(name = "CLS_CLE_SGS_ID")
	private Long estimateSgsId;

	@Column(name = "CLS_SR_NO")
	private int revisionSerialNo;

	@Column(name = "CLS_RISK_ID")
	private String riskId;

	@Column(name = "CLS_CVR_ID")
	private String coverId;

	@Column(name = "CLS_SMI_ID")
	private String smiId;

	@Column(name = "CLS_LOSS_ID")
	private String lossId;

	@Column(name = "CLS_EST_TYP")
	private String estimateType;

	@Column(name = "CLS_CUST_ID")
	private String customerId;

	@Column(name = "CLS_PAYD")
	private Date paymentCreatedDate;

	@Column(name = "CLS_PAY_AMT")
	private double settledAmount;

	@Column(name = "CLS_XS_AMT")
	private double xsAmount;

	private String CLS_INSTU_ID;

	@Column(name = "CLS_APPRV_FLAG")
	private String approveFlag;

	@Column(name = "CLS_APPRVD")
	private Date approvedDate;

	@Column(name = "CLS_ARU")
	private String approveUser;

	@Column(name = "CLS_PAID_FLAG")
	private String paidFlag;

	@Column(name = "CLS_PAY_REF")
	private String payeeRef;

	@Column(name = "CLS_OS_AMT")
	private double outstandingAmount;

	@Column(name = "CLS_PAYEE_NAME")
	private String payeeName;

	@Column(name = "CLS_CUST_CATG_ID")
	private String customerCatageoryID;

	@Column(name = "CLS_REMARKS")
	private String remarks;

	@Column(name = "CLS_CLE_SR_NO")
	private float estimateSerialNo;

	private double CLS_OS_AMT_BC;

	private double CLS_XS_AMT_BC;

	@Column(name = "CLS_PAY_AMT_BC")
	private double paymentAmountBC;

	@Column(name = "CLS_CUR_X_RATE")
	private int currentXrate;

	@Column(name = "CLS_CUR_ID")
	private String currencyId;

	private int CLS_REP_PAY_SGS_ID;

	@Column(name = "CLS_LINK_SR_NO")
	private Long linkSerialNo;

	@Column(name = "CLS_CRU")
	private String createdUser;

	@Column(name = "CLS_CRD")
	private Date createdDate;

	@Column(name = "CLS_ASSIGN_APU")
	private String approver;

	@Column(name = "CLS_SETL_TYP")
	private String settledType;

	@Column(name = "CLS_ACCT_CUST_ID")
	private String accountCustId;

	private String CLS_ACCT_REF_NO;

	private String CLS_CRU_AUG_ID;

	@Column(name = "CLS_ASSIGN_RVU")
	private String assignReviewUser;

	@Column(name = "CLS_RVU")
	private String reviewerId;

	@Column(name = "CLS_RVD")
	private Date reviewedDate;

	private int CLS_RECOV_EXP;

	private int CLS_RECOV_CHGS;

	private String CLS_AC_PROC_YN;

	@Column(name = "CLS_TOT_LOSS_TYP")
	private String lossType;

	private String CLS_PAY_TYP;

	private String CLS_REF_NO;

	@Column(name = "CLS_COMP_ID")
	private String companyId;

	private int CLS_SETTL_LVL;

	private int CLS_VAT_ADJ_AMT_BC;

	private String CLS_VAT_YN;

	private int CLS_VAT_RATE;

	private int CLS_VAT_RATE_PER;

	private int CLS_VAT_AMT;

	private int CLS_VAT_AMT_BC;

	private int CLS_VAT_ADJ_AMT;

	public Long getSgsId() {
		return sgsId;
	}

	public void setSgsId(Long sgsId) {
		this.sgsId = sgsId;
	}

	public Long getFnolSgsId() {
		return fnolSgsId;
	}

	public void setFnolSgsId(Long fnolSgsId) {
		this.fnolSgsId = fnolSgsId;
	}

	public Long getEstimateSgsId() {
		return estimateSgsId;
	}

	public void setEstimateSgsId(Long estimateSgsId) {
		this.estimateSgsId = estimateSgsId;
	}

	public int getRevisionSerialNo() {
		return revisionSerialNo;
	}

	public void setRevisionSerialNo(int revisionSerialNo) {
		this.revisionSerialNo = revisionSerialNo;
	}

	public String getRiskId() {
		return riskId;
	}

	public void setRiskId(String riskId) {
		this.riskId = riskId;
	}

	public String getCoverId() {
		return coverId;
	}

	public void setCoverId(String coverId) {
		this.coverId = coverId;
	}

	public String getSmiId() {
		return smiId;
	}

	public void setSmiId(String smiId) {
		this.smiId = smiId;
	}

	public String getLossId() {
		return lossId;
	}

	public void setLossId(String lossId) {
		this.lossId = lossId;
	}

	public String getEstimateType() {
		return estimateType;
	}

	public void setEstimateType(String estimateType) {
		this.estimateType = estimateType;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Date getPaymentCreatedDate() {
		return paymentCreatedDate;
	}

	public void setPaymentCreatedDate(Date paymentCreatedDate) {
		this.paymentCreatedDate = paymentCreatedDate;
	}

	public double getSettledAmount() {
		return settledAmount;
	}

	public void setSettledAmount(double settledAmount) {
		this.settledAmount = settledAmount;
	}

	public double getXsAmount() {
		return xsAmount;
	}

	public void setXsAmount(double xsAmount) {
		this.xsAmount = xsAmount;
	}

	public String getCLS_INSTU_ID() {
		return CLS_INSTU_ID;
	}

	public void setCLS_INSTU_ID(String cLS_INSTU_ID) {
		CLS_INSTU_ID = cLS_INSTU_ID;
	}

	public String getApproveFlag() {
		return approveFlag;
	}

	public void setApproveFlag(String approveFlag) {
		this.approveFlag = approveFlag;
	}

	public Date getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}

	public String getApproveUser() {
		return approveUser;
	}

	public void setApproveUser(String approveUser) {
		this.approveUser = approveUser;
	}

	public String getPaidFlag() {
		return paidFlag;
	}

	public void setPaidFlag(String paidFlag) {
		this.paidFlag = paidFlag;
	}

	public String getPayeeRef() {
		return payeeRef;
	}

	public void setPayeeRef(String payeeRef) {
		this.payeeRef = payeeRef;
	}

	public double getOutstandingAmount() {
		return outstandingAmount;
	}

	public void setOutstandingAmount(double outstandingAmount) {
		this.outstandingAmount = outstandingAmount;
	}

	public String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}

	public String getCustomerCatageoryID() {
		return customerCatageoryID;
	}

	public void setCustomerCatageoryID(String customerCatageoryID) {
		this.customerCatageoryID = customerCatageoryID;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public float getEstimateSerialNo() {
		return estimateSerialNo;
	}

	public void setEstimateSerialNo(float estimateSerialNo) {
		this.estimateSerialNo = estimateSerialNo;
	}

	public double getCLS_OS_AMT_BC() {
		return CLS_OS_AMT_BC;
	}

	public void setCLS_OS_AMT_BC(double cLS_OS_AMT_BC) {
		CLS_OS_AMT_BC = cLS_OS_AMT_BC;
	}

	public double getCLS_XS_AMT_BC() {
		return CLS_XS_AMT_BC;
	}

	public void setCLS_XS_AMT_BC(double cLS_XS_AMT_BC) {
		CLS_XS_AMT_BC = cLS_XS_AMT_BC;
	}

	public String getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}

	public int getCLS_REP_PAY_SGS_ID() {
		return CLS_REP_PAY_SGS_ID;
	}

	public void setCLS_REP_PAY_SGS_ID(int cLS_REP_PAY_SGS_ID) {
		CLS_REP_PAY_SGS_ID = cLS_REP_PAY_SGS_ID;
	}

	public Long getLinkSerialNo() {
		return linkSerialNo;
	}

	public void setLinkSerialNo(Long linkSerialNo) {
		this.linkSerialNo = linkSerialNo;
	}

	public String getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getApprover() {
		return approver;
	}

	public void setApprover(String approver) {
		this.approver = approver;
	}

	public String getCLS_ACCT_REF_NO() {
		return CLS_ACCT_REF_NO;
	}

	public void setCLS_ACCT_REF_NO(String cLS_ACCT_REF_NO) {
		CLS_ACCT_REF_NO = cLS_ACCT_REF_NO;
	}

	public String getCLS_CRU_AUG_ID() {
		return CLS_CRU_AUG_ID;
	}

	public void setCLS_CRU_AUG_ID(String cLS_CRU_AUG_ID) {
		CLS_CRU_AUG_ID = cLS_CRU_AUG_ID;
	}

	public double getPaymentAmountBC() {
		return paymentAmountBC;
	}

	public void setPaymentAmountBC(double paymentAmountBC) {
		this.paymentAmountBC = paymentAmountBC;
	}

	public int getCurrentXrate() {
		return currentXrate;
	}

	public void setCurrentXrate(int currentXrate) {
		this.currentXrate = currentXrate;
	}

	public String getSettledType() {
		return settledType;
	}

	public void setSettledType(String settledType) {
		this.settledType = settledType;
	}

	public String getAccountCustId() {
		return accountCustId;
	}

	public void setAccountCustId(String accountCustId) {
		this.accountCustId = accountCustId;
	}

	public String getAssignReviewUser() {
		return assignReviewUser;
	}

	public void setAssignReviewUser(String assignReviewUser) {
		this.assignReviewUser = assignReviewUser;
	}

	public String getReviewerId() {
		return reviewerId;
	}

	public void setReviewerId(String reviewerId) {
		this.reviewerId = reviewerId;
	}

	public Date getReviewedDate() {
		return reviewedDate;
	}

	public void setReviewedDate(Date reviewedDate) {
		this.reviewedDate = reviewedDate;
	}

	public int getCLS_RECOV_EXP() {
		return CLS_RECOV_EXP;
	}

	public void setCLS_RECOV_EXP(int cLS_RECOV_EXP) {
		CLS_RECOV_EXP = cLS_RECOV_EXP;
	}

	public int getCLS_RECOV_CHGS() {
		return CLS_RECOV_CHGS;
	}

	public void setCLS_RECOV_CHGS(int cLS_RECOV_CHGS) {
		CLS_RECOV_CHGS = cLS_RECOV_CHGS;
	}

	public String getCLS_AC_PROC_YN() {
		return CLS_AC_PROC_YN;
	}

	public void setCLS_AC_PROC_YN(String cLS_AC_PROC_YN) {
		CLS_AC_PROC_YN = cLS_AC_PROC_YN;
	}

	public String getLossType() {
		return lossType;
	}

	public void setLossType(String lossType) {
		this.lossType = lossType;
	}

	public String getCLS_PAY_TYP() {
		return CLS_PAY_TYP;
	}

	public void setCLS_PAY_TYP(String cLS_PAY_TYP) {
		CLS_PAY_TYP = cLS_PAY_TYP;
	}

	public String getCLS_REF_NO() {
		return CLS_REF_NO;
	}

	public void setCLS_REF_NO(String cLS_REF_NO) {
		CLS_REF_NO = cLS_REF_NO;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public int getCLS_SETTL_LVL() {
		return CLS_SETTL_LVL;
	}

	public void setCLS_SETTL_LVL(int cLS_SETTL_LVL) {
		CLS_SETTL_LVL = cLS_SETTL_LVL;
	}

	public int getCLS_VAT_ADJ_AMT_BC() {
		return CLS_VAT_ADJ_AMT_BC;
	}

	public void setCLS_VAT_ADJ_AMT_BC(int cLS_VAT_ADJ_AMT_BC) {
		CLS_VAT_ADJ_AMT_BC = cLS_VAT_ADJ_AMT_BC;
	}

	public String getCLS_VAT_YN() {
		return CLS_VAT_YN;
	}

	public void setCLS_VAT_YN(String cLS_VAT_YN) {
		CLS_VAT_YN = cLS_VAT_YN;
	}

	public int getCLS_VAT_RATE() {
		return CLS_VAT_RATE;
	}

	public void setCLS_VAT_RATE(int cLS_VAT_RATE) {
		CLS_VAT_RATE = cLS_VAT_RATE;
	}

	public int getCLS_VAT_RATE_PER() {
		return CLS_VAT_RATE_PER;
	}

	public void setCLS_VAT_RATE_PER(int cLS_VAT_RATE_PER) {
		CLS_VAT_RATE_PER = cLS_VAT_RATE_PER;
	}

	public int getCLS_VAT_AMT() {
		return CLS_VAT_AMT;
	}

	public void setCLS_VAT_AMT(int cLS_VAT_AMT) {
		CLS_VAT_AMT = cLS_VAT_AMT;
	}

	public int getCLS_VAT_AMT_BC() {
		return CLS_VAT_AMT_BC;
	}

	public void setCLS_VAT_AMT_BC(int cLS_VAT_AMT_BC) {
		CLS_VAT_AMT_BC = cLS_VAT_AMT_BC;
	}

	public int getCLS_VAT_ADJ_AMT() {
		return CLS_VAT_ADJ_AMT;
	}

	public void setCLS_VAT_ADJ_AMT(int cLS_VAT_ADJ_AMT) {
		CLS_VAT_ADJ_AMT = cLS_VAT_ADJ_AMT;
	}

}

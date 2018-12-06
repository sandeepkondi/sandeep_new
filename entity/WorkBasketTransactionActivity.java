package com.beyontec.mol.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "WTDS_LEVEL_A")
public class WorkBasketTransactionActivity {

	@Id
	@Column(name = "WLA_SGS_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sgs_id_generator")
    @SequenceGenerator(name = "sgs_id_generator", sequenceName = "SEQ_WLA_SGS_ID", allocationSize = 1)
	private Long activitySGSId;
	
	@Column(name = "WLA_COMP_ID")
	private String companyId;
	@Column(name = "WLA_MODULE")
	private String module;
	@Column(name = "WLA_ACT_ID")
	private String activityId;
	@Column(name = "WLA_PROCESS_ID")
	private String WLA_PROCESS_ID;
	@Column(name = "WLA_CUST_ID")
	private String customerId;
	@Column(name = "WLA_PROD_ID")
	private String productId;
	@Column(name = "WLA_TXN_REF")
	private Long fnolSgsId;
	@Column(name = "WLA_TXN_SREF")
	private int WLA_TXN_SREF;
	@Column(name = "WLA_TXN_REF_NO")
	private String fnolRef;
	@Column(name = "WLA_TXN_SREF_NO")
	private String claimRef;
	@Column(name = "WLA_TXNU")
	private String assignedUser;
	@Column(name = "WLA_CRU")
	private String createdUser;
	@Column(name = "WAL_CRD")
	private Date createdDate;
	@Column(name = "WLA_UPU")
	private String updatedUser;
	@Column(name = "WLA_UPD")
	private Date updatedDate;
	@Column(name = "WLA_ACT_FMD")
	private Date activityFrom;
	@Column(name = "WLA_ACT_DUED")
	private Date activiityDueDate;
	@Column(name = "WLA_ACT_COMD")
	private Date activityCompletedDate;
	@Column(name = "WLA_STATUS")
	private String activityStatus;
	@Column(name = "WLA_NLM_SGS_ID")
	private int WLA_NLM_SGS_ID;
	@Column(name = "WLA_UBH_BR_ID")
	private String WLA_UBH_BR_ID;
	@Column(name = "WLA_VFLEX_01")
	private String WLA_VFLEX_01;
	@Column(name = "WLA_VFLEX_02")
	private String WLA_VFLEX_02;
	@Column(name = "WLA_VFLEX_03")
	private String WLA_VFLEX_03;
	@Column(name = "WLA_VFLEX_04")
	private String WLA_VFLEX_04;
	@Column(name = "WLA_VFLEX_05")
	private String WLA_VFLEX_05;
	@Column(name = "WLA_DFLEX_01")
	private Date WLA_DFLEX_01;
	@Column(name = "WLA_DFLEX_02")
	private Date WLA_DFLEX_02;
	@Column(name = "WLA_DFLEX_03")
	private Date WLA_DFLEX_03;
	@Column(name = "WLA_DFLEX_04")
	private Date WLA_DFLEX_04;
	@Column(name = "WLA_DFLEX_05")
	private Date WLA_DFLEX_05;
	@Column(name = "WLA_NFLEX_01")
	private int WLA_NFLEX_01;
	@Column(name = "WLA_NFLEX_02")
	private int WLA_NFLEX_02;
	@Column(name = "WLA_LEVEL1_REF")
	private Long level1Ref;
	@Column(name = "WLA_LEVEL2_REF")
	private String level2Ref;
	@Column(name = "WLA_LEVEL3_REF")
	private Long level3Ref;
	@Column(name = "WLA_LEVEL4_REF")
	private int WLA_LEVEL4_REF;
	@Column(name = "WLA_LEVEL5_REF")
	private int WLA_LEVEL5_REF;
	@Column(name = "WLA_LEVEL6_REF")
	private String level6Ref;
	@Column(name = "WLA_LEVEL7_REF")
	private String WLA_LEVEL7_REF;
	@Column(name = "WLA_REF_TYP")
	private String WLA_REF_TYP;
	@Column(name = "WLA_LEVEL8_REF")
	private int WLA_LEVEL8_REF;
	@Column(name = "WLA_TXN_AUG_ID")
	private String assignedGroupId;
	@Column(name = "WLA_ACTU")
	private String actedUserOnTheTransaction;
	@Column(name = "WLA_USED_FOR")
	private String WLA_USED_FOR;
	@Column(name = "WLA_DIVN_ID")
	private String WLA_DIVN_ID;
	@Column(name = "WLA_EREF_SGS_ID")
	private int WLA_EREF_SGS_ID;

	public Long getActivitySGSId() {
		return activitySGSId;
	}

	public void setActivitySGSId(Long activitySGSId) {
		this.activitySGSId = activitySGSId;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	public String getWLA_PROCESS_ID() {
		return WLA_PROCESS_ID;
	}

	public void setWLA_PROCESS_ID(String wLA_PROCESS_ID) {
		WLA_PROCESS_ID = wLA_PROCESS_ID;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Long getFnolSgsId() {
		return fnolSgsId;
	}

	public void setFnolSgsId(Long fnolSgsId) {
		this.fnolSgsId = fnolSgsId;
	}

	public int getWLA_TXN_SREF() {
		return WLA_TXN_SREF;
	}

	public void setWLA_TXN_SREF(int wLA_TXN_SREF) {
		WLA_TXN_SREF = wLA_TXN_SREF;
	}

	public String getFnolRef() {
		return fnolRef;
	}

	public void setFnolRef(String fnolRef) {
		this.fnolRef = fnolRef;
	}

	public String getClaimRef() {
		return claimRef;
	}

	public void setClaimRef(String claimRef) {
		this.claimRef = claimRef;
	}

	public String getAssignedUser() {
		return assignedUser;
	}

	public void setAssignedUser(String assignedUser) {
		this.assignedUser = assignedUser;
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

	public String getUpdatedUser() {
		return updatedUser;
	}

	public void setUpdatedUser(String updatedUser) {
		this.updatedUser = updatedUser;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Date getActivityFrom() {
		return activityFrom;
	}

	public void setActivityFrom(Date activityFrom) {
		this.activityFrom = activityFrom;
	}

	public Date getActiviityDueDate() {
		return activiityDueDate;
	}

	public void setActiviityDueDate(Date activiityDueDate) {
		this.activiityDueDate = activiityDueDate;
	}

	public Date getActivityCompletedDate() {
		return activityCompletedDate;
	}

	public void setActivityCompletedDate(Date activityCompletedDate) {
		this.activityCompletedDate = activityCompletedDate;
	}

	public String getActivityStatus() {
		return activityStatus;
	}

	public void setActivityStatus(String activityStatus) {
		this.activityStatus = activityStatus;
	}

	public int getWLA_NLM_SGS_ID() {
		return WLA_NLM_SGS_ID;
	}

	public void setWLA_NLM_SGS_ID(int wLA_NLM_SGS_ID) {
		WLA_NLM_SGS_ID = wLA_NLM_SGS_ID;
	}

	public String getWLA_UBH_BR_ID() {
		return WLA_UBH_BR_ID;
	}

	public void setWLA_UBH_BR_ID(String wLA_UBH_BR_ID) {
		WLA_UBH_BR_ID = wLA_UBH_BR_ID;
	}

	public String getWLA_VFLEX_01() {
		return WLA_VFLEX_01;
	}

	public void setWLA_VFLEX_01(String wLA_VFLEX_01) {
		WLA_VFLEX_01 = wLA_VFLEX_01;
	}

	public String getWLA_VFLEX_02() {
		return WLA_VFLEX_02;
	}

	public void setWLA_VFLEX_02(String wLA_VFLEX_02) {
		WLA_VFLEX_02 = wLA_VFLEX_02;
	}

	public String getWLA_VFLEX_03() {
		return WLA_VFLEX_03;
	}

	public void setWLA_VFLEX_03(String wLA_VFLEX_03) {
		WLA_VFLEX_03 = wLA_VFLEX_03;
	}

	public String getWLA_VFLEX_04() {
		return WLA_VFLEX_04;
	}

	public void setWLA_VFLEX_04(String wLA_VFLEX_04) {
		WLA_VFLEX_04 = wLA_VFLEX_04;
	}

	public String getWLA_VFLEX_05() {
		return WLA_VFLEX_05;
	}

	public void setWLA_VFLEX_05(String wLA_VFLEX_05) {
		WLA_VFLEX_05 = wLA_VFLEX_05;
	}

	public Date getWLA_DFLEX_01() {
		return WLA_DFLEX_01;
	}

	public void setWLA_DFLEX_01(Date wLA_DFLEX_01) {
		WLA_DFLEX_01 = wLA_DFLEX_01;
	}

	public Date getWLA_DFLEX_02() {
		return WLA_DFLEX_02;
	}

	public void setWLA_DFLEX_02(Date wLA_DFLEX_02) {
		WLA_DFLEX_02 = wLA_DFLEX_02;
	}

	public Date getWLA_DFLEX_03() {
		return WLA_DFLEX_03;
	}

	public void setWLA_DFLEX_03(Date wLA_DFLEX_03) {
		WLA_DFLEX_03 = wLA_DFLEX_03;
	}

	public Date getWLA_DFLEX_04() {
		return WLA_DFLEX_04;
	}

	public void setWLA_DFLEX_04(Date wLA_DFLEX_04) {
		WLA_DFLEX_04 = wLA_DFLEX_04;
	}

	public Date getWLA_DFLEX_05() {
		return WLA_DFLEX_05;
	}

	public void setWLA_DFLEX_05(Date wLA_DFLEX_05) {
		WLA_DFLEX_05 = wLA_DFLEX_05;
	}

	public int getWLA_NFLEX_01() {
		return WLA_NFLEX_01;
	}

	public void setWLA_NFLEX_01(int wLA_NFLEX_01) {
		WLA_NFLEX_01 = wLA_NFLEX_01;
	}

	public int getWLA_NFLEX_02() {
		return WLA_NFLEX_02;
	}

	public void setWLA_NFLEX_02(int wLA_NFLEX_02) {
		WLA_NFLEX_02 = wLA_NFLEX_02;
	}

	public Long getLevel1Ref() {
		return level1Ref;
	}

	public void setLevel1Ref(Long level1Ref) {
		this.level1Ref = level1Ref;
	}

	public String getLevel2Ref() {
		return level2Ref;
	}

	public void setLevel2Ref(String level2Ref) {
		this.level2Ref = level2Ref;
	}

	public Long getLevel3Ref() {
		return level3Ref;
	}

	public void setLevel3Ref(Long level3Ref) {
		this.level3Ref = level3Ref;
	}

	public int getWLA_LEVEL4_REF() {
		return WLA_LEVEL4_REF;
	}

	public void setWLA_LEVEL4_REF(int wLA_LEVEL4_REF) {
		WLA_LEVEL4_REF = wLA_LEVEL4_REF;
	}

	public int getWLA_LEVEL5_REF() {
		return WLA_LEVEL5_REF;
	}

	public void setWLA_LEVEL5_REF(int wLA_LEVEL5_REF) {
		WLA_LEVEL5_REF = wLA_LEVEL5_REF;
	}

	public String getLevel6Ref() {
		return level6Ref;
	}

	public void setLevel6Ref(String level6Ref) {
		this.level6Ref = level6Ref;
	}

	public String getWLA_LEVEL7_REF() {
		return WLA_LEVEL7_REF;
	}

	public void setWLA_LEVEL7_REF(String wLA_LEVEL7_REF) {
		WLA_LEVEL7_REF = wLA_LEVEL7_REF;
	}

	public String getWLA_REF_TYP() {
		return WLA_REF_TYP;
	}

	public void setWLA_REF_TYP(String wLA_REF_TYP) {
		WLA_REF_TYP = wLA_REF_TYP;
	}

	public int getWLA_LEVEL8_REF() {
		return WLA_LEVEL8_REF;
	}

	public void setWLA_LEVEL8_REF(int wLA_LEVEL8_REF) {
		WLA_LEVEL8_REF = wLA_LEVEL8_REF;
	}

	public String getAssignedGroupId() {
		return assignedGroupId;
	}

	public void setAssignedGroupId(String assignedGroupId) {
		this.assignedGroupId = assignedGroupId;
	}

	public String getActedUserOnTheTransaction() {
		return actedUserOnTheTransaction;
	}

	public void setActedUserOnTheTransaction(String actedUserOnTheTransaction) {
		this.actedUserOnTheTransaction = actedUserOnTheTransaction;
	}

	public String getWLA_USED_FOR() {
		return WLA_USED_FOR;
	}

	public void setWLA_USED_FOR(String wLA_USED_FOR) {
		WLA_USED_FOR = wLA_USED_FOR;
	}

	public String getWLA_DIVN_ID() {
		return WLA_DIVN_ID;
	}

	public void setWLA_DIVN_ID(String wLA_DIVN_ID) {
		WLA_DIVN_ID = wLA_DIVN_ID;
	}

	public int getWLA_EREF_SGS_ID() {
		return WLA_EREF_SGS_ID;
	}

	public void setWLA_EREF_SGS_ID(int wLA_EREF_SGS_ID) {
		WLA_EREF_SGS_ID = wLA_EREF_SGS_ID;
	}

}

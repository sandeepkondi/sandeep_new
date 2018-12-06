package com.beyontec.mol.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

//@Entity
//@Table(name = "NTDS_LEVEL_M")
public class NTDS_LEVEL_M {
	
	@Id
	@Column(name = "NLM_SGS_ID")
	private Long nlmSeqSgsId;
	@Column(name = "NLM_REF")
	private Long nlmRef;
	@Column(name = "NLM_COMP_ID")
	private String companyId;
	@Column(name = "NLM_FOR")
	private String NLM_FOR;
	@Column(name = "NLM_FOR_REF")
	private String NLM_FOR_REF;
	@Column(name = "NLM_MODULE")
	private String module;
	@Column(name = "NLM_LEVEL1_REF")
	private Long level1Ref;
	@Column(name = "NLM_LEVEL2_REF")
	private String level2Ref;
	@Column(name = "NLM_LEVEL3_REF")
	private Long level3Ref;
	@Column(name = "NLM_LEVEL4_REF")
	private Long NLM_LEVEL4_REF;
	@Column(name = "NLM_LEVEL5_REF")
	private Long NLM_LEVEL5_REF;
	@Column(name = "NLM_TYP")
	private String nlmType;
	@Column(name = "NLM_ACCESS_TYP")
	private String accessType;
	@Column(name = "NLM_DESC")
	private String description;
	@Column(name = "NLM_STATUS")
	private String status;
	@Column(name = "NLM_PRIORITY")
	private String NLM_PRIORITY;
	@Column(name = "NLM_TXD")
	private Date createdDate;
	@Column(name = "NLM_DUD")
	private Date dueDate;
	@Column(name = "NLM_ACD")
	private Date NLM_ACD;
	@Column(name = "NLM_REMIND_YN")
	private String remainderYN;
	@Column(name = "NLM_TXU")
	private String createduser;
	@Column(name = "NLM_TXG")
	private String createdGroup;
	@Column(name = "NLM_ASU")
	private String assigneduser;
	@Column(name = "NLM_ASG")
	private String assignedGroup;
	@Column(name = "NLM_REF_SGS_ID")
	private Long reviewRefSgsId;
	@Column(name = "NTDS_TXN_REF")
	private String NTDS_TXN_REF;
	@Column(name = "NLM_REMIND_HRS")
	private String remainderHRS;
	@Column(name = "NLM_FOLL_UP_YN")
	private String followUpYN;
	@Column(name = "NLM_FOLL_UP_HRS")
	private String followUpHRS;
	@Column(name = "NLM_UBD_SGS_ID")
	private Long NLM_UBD_SGS_ID;
	@Column(name = "NLM_IDFR")
	private String NLM_IDFR;
	@Column(name = "NLM_UBH_BR_ID")
	private String NLM_UBH_BR_ID;
	@Column(name = "NLM_SUBJECT")
	private String subjectId;
	@Column(name = "NLM_REF_DESC")
	private String NLM_REF_DESC;
	@Column(name = "NLM_ACCESS_ENT")
	private String NLM_ACCESS_ENT;
	@Column(name = "NLM_TXN_LINK_REF")
	private String NLM_TXN_LINK_REF;
	@Column(name = "NLM_SUBJECT_ID")
	private String NLM_SUBJECT_ID;
	@Column(name = "NLM_LEVEL6_REF")
	private String level6;
	@Column(name = "NLM_LEVEL7_REF")
	private String NLM_LEVEL7_REF;
	@Column(name = "NLM_REF_TYP")
	private String NLM_REF_TYP;
	@Column(name = "NLM_LEVEL8_REF")
	private Long NLM_LEVEL8_REF;
	@Column(name = "NLM_CLS_FLAG")
	private String NLM_CLS_FLAG;
	@Column(name = "NLM_ULC_MST_ID")
	private String NLM_ULC_MST_ID;
	@Column(name = "NLM_ULS_ID")
	private String NLM_ULS_ID;
	@Column(name = "NLM_SPL_HAND_YN")
	private String NLM_SPL_HAND_YN;
	@Column(name = "NLM_SRC_SGS_ID")
	private Long NLM_SRC_SGS_ID;
	@Column(name = "NLM_GRP_SGS_ID")
	private Long NLM_GRP_SGS_ID;
	@Column(name = "NLM_DRAFT_YN")
	private String NLM_DRAFT_YN;
	@Column(name = "NLM_CRU")
	private String createdUser;
	@Column(name = "NLM_CRD")
	private Date nlmCreatedDate;
	@Column(name = "NLM_FMD")
	private Date NLM_FMD;
	@Column(name = "NLM_TOD")
	private Date NLM_TOD;
	@Column(name = "NLM_VER_NO")
	private Long NLM_VER_NO;
	@Column(name = "NLM_APU")
	private String NLM_APU;
	@Column(name = "NLM_APPRV_STATUS")
	private String NLM_APPRV_STATUS;
	@Column(name = "NLM_APD")
	private Date NLM_APD;
	@Column(name = "NLM_REC_TYP")
	private String recordType;
	@Column(name = "NLM_EXP_IMP_REF")
	private Long NLM_EXP_IMP_REF;
	@Column(name = "NLM_CALL_PLAN_TYP")
	private String NLM_CALL_PLAN_TYP;
	@Column(name = "NLM_CALL_DT")
	private Date NLM_CALL_DT;
	@Column(name = "NLM_CALL_TYP")
	private String NLM_CALL_TYP;
	@Column(name = "NLM_CLOSE_DT")
	private Date closeDate;
	@Column(name = "NLM_FORMAT_DESC")
	private String NLM_FORMAT_DESC;
	@Column(name = "NLM_CASE_REF")
	private String NLM_CASE_REF;


}

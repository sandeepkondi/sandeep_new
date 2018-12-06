package com.beyontec.mol.entity;

import javax.persistence.Column;
import javax.persistence.Id;

//@Entity
//@Table(name = "NTDS_LEVEL_USER")
public class NTDS_LEVEL_USER {
	
	@Id
	@Column(name = "NLU_NLM_SGS_ID")
	private Long nluAgsId;

	@Column(name = "NLU_USER_TYP")
	private String userType;

	@Column(name = "NLU_USER_ID")
	private String userId;

	@Column(name = "NLU_STATUS")
	private String status;

	@Column(name = "NLU_AUG_ID")
	private String groupId;

	@Column(name = "NLU_COMP_ID")
	private String companyId;


}

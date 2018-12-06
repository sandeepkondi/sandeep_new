package com.beyontec.mol.entity;

import java.io.Serializable;

public class ClaimHistoryID implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	private Long estimateSgsId;
	private Long fnolSgsId;
	private int revisionSerialNo;
	
	public Long getEstimateSgsId() {
		return estimateSgsId;
	}
	public void setEstimateSgsId(Long estimateSgsId) {
		this.estimateSgsId = estimateSgsId;
	}
	public Long getFnolSgsId() {
		return fnolSgsId;
	}
	public void setFnolSgsId(Long fnolSgsId) {
		this.fnolSgsId = fnolSgsId;
	}
	public int getRevisionSerialNo() {
		return revisionSerialNo;
	}
	public void setRevisionSerialNo(int revisionSerialNo) {
		this.revisionSerialNo = revisionSerialNo;
	}
	
}
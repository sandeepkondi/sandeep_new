package com.beyontec.mol.modal;

import java.util.Map;

public class ClaimFieldListingDTO {

	private Map<String, String> department;
	private Map<String, String> division;
	private Map<String, String> statusTypes;
	private Map<String, String> workerTypes;
	private Map<String, String> sponsorTypes;

	public Map<String, String> getDepartment() {
		return department;
	}

	public void setDepartment(Map<String, String> department) {
		this.department = department;
	}

	public Map<String, String> getDivision() {
		return division;
	}

	public void setDivision(Map<String, String> division) {
		this.division = division;
	}

	public Map<String, String> getStatusTypes() {
		return statusTypes;
	}

	public void setStatusTypes(Map<String, String> statusTypes) {
		this.statusTypes = statusTypes;
	}

	public Map<String, String> getWorkerTypes() {
		return workerTypes;
	}

	public void setWorkerTypes(Map<String, String> workerTypes) {
		this.workerTypes = workerTypes;
	}

	public Map<String, String> getSponsorTypes() {
		return sponsorTypes;
	}

	public void setSponsorTypes(Map<String, String> sponsorTypes) {
		this.sponsorTypes = sponsorTypes;
	}
}

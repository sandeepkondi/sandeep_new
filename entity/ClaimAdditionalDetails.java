package com.beyontec.mol.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "IDS_CLM_ADDL_DTLS")
@EntityListeners(AuditingEntityListener.class)
public class ClaimAdditionalDetails {

	@Id
	@Column(name = "ICAD_SGS_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "icad_sgs_id_generator")
    @SequenceGenerator(name = "icad_sgs_id_generator", sequenceName = "SEQ_ICAD_SGS_ID", allocationSize = 1)
	private long id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ICAD_ICD_SGS_ID")
	private Claim claim;

	@Column(name = "ICAD_TYP")
	private String type;

	@Column(name = "ICAD_NOTES")
	private String notes;

	@Column(name = "ICAD_PATH")
	private String documentPath;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Claim getClaim() {
		return claim;
	}

	public void setClaim(Claim claim) {
		this.claim = claim;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getDocumentPath() {
		return documentPath;
	}

	public void setDocumentPath(String documentPath) {
		this.documentPath = documentPath;
	}

}

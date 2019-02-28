package com.vme.precast.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import coliseum.jpa.domain.BaseEntity;

@Entity
@Table(name = "SUBCONTRACTOR")
public class SubContractor extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	private String panNumber;

	private Double retentionPercent;

	private Double tdsPercent;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public Double getRetentionPercent() {
		return retentionPercent;
	}

	public void setRetentionPercent(Double retentionPercent) {
		this.retentionPercent = retentionPercent;
	}

	public Double getTdsPercent() {
		return tdsPercent;
	}

	public void setTdsPercent(Double tdsPercent) {
		this.tdsPercent = tdsPercent;
	}
}

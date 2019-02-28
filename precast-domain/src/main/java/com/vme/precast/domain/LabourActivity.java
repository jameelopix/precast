package com.vme.precast.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import coliseum.jpa.domain.BaseEntity;

@Entity
public class LabourActivity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	private CastingActivity castingActivity;

	@OneToOne
	private SubContractor subContractor;

	private String natureOfWork;

	private Double quantity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CastingActivity getCastingActivity() {
		return castingActivity;
	}

	public void setCastingActivity(CastingActivity castingActivity) {
		this.castingActivity = castingActivity;
	}

	public SubContractor getSubContractor() {
		return subContractor;
	}

	public void setSubContractor(SubContractor subContractor) {
		this.subContractor = subContractor;
	}

	public String getNatureOfWork() {
		return natureOfWork;
	}

	public void setNatureOfWork(String natureOfWork) {
		this.natureOfWork = natureOfWork;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

}

package com.vme.precast.labouractivity.api;

import coliseum.service.BaseDTO;

public class LabourActivityDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	private Long id;

	private Long castingActivityId;

	private Long subContractorId;

	private String natureOfWork;

	private Double quantity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCastingActivityId() {
		return castingActivityId;
	}

	public void setCastingActivityId(Long castingActivityId) {
		this.castingActivityId = castingActivityId;
	}

	public Long getSubContractorId() {
		return subContractorId;
	}

	public void setSubContractorId(Long subContractorId) {
		this.subContractorId = subContractorId;
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

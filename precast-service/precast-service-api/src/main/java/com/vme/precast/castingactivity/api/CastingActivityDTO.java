package com.vme.precast.castingactivity.api;

import java.util.Date;
import java.util.Set;

import coliseum.service.BaseDTO;

public class CastingActivityDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	private Long id;

	private Long elementId;

//	@JsonSerialize(using = CustomDateSerializer.class)
	private Date castedDate;

	private Double actualConcentreQuantity;

	private Set<Long> labourActivityIds;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getElementId() {
		return elementId;
	}

	public void setElementId(Long elementId) {
		this.elementId = elementId;
	}

	public Date getCastedDate() {
		return castedDate;
	}

	public void setCastedDate(Date castedDate) {
		this.castedDate = castedDate;
	}

	public Double getActualConcentreQuantity() {
		return actualConcentreQuantity;
	}

	public void setActualConcentreQuantity(Double actualConcentreQuantity) {
		this.actualConcentreQuantity = actualConcentreQuantity;
	}

	public Set<Long> getLabourActivityIds() {
		return labourActivityIds;
	}

	public void setLabourActivityIds(Set<Long> labourActivityIds) {
		this.labourActivityIds = labourActivityIds;
	}
}

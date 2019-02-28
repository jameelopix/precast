package com.vme.precast.steelitem.api;

import java.io.Serializable;

public class SteelItemDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private Long rawMaterialId;

	private Double theoryQuantity;

	private Double actualQuantity;

	private Long elementId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRawMaterialId() {
		return rawMaterialId;
	}

	public void setRawMaterialId(Long rawMaterialId) {
		this.rawMaterialId = rawMaterialId;
	}

	public Double getTheoryQuantity() {
		return theoryQuantity;
	}

	public void setTheoryQuantity(Double theoryQuantity) {
		this.theoryQuantity = theoryQuantity;
	}

	public Double getActualQuantity() {
		return actualQuantity;
	}

	public void setActualQuantity(Double actualQuantity) {
		this.actualQuantity = actualQuantity;
	}

	public Long getElementId() {
		return elementId;
	}

	public void setElementId(Long elementId) {
		this.elementId = elementId;
	}

}
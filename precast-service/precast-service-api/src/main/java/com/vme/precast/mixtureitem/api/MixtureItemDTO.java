package com.vme.precast.mixtureitem.api;

import coliseum.service.BaseDTO;

public class MixtureItemDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	private Long id;

	private Long rawMaterialId;

	private Double quantity;

	private Long mixtureId;

	public Long getRawMaterialId() {
		return rawMaterialId;
	}

	public void setRawMaterialId(Long rawMaterialId) {
		this.rawMaterialId = rawMaterialId;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Long getMixtureId() {
		return mixtureId;
	}

	public void setMixtureId(Long mixtureId) {
		this.mixtureId = mixtureId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
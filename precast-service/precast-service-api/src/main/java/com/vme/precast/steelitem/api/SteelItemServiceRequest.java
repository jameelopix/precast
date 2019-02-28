package com.vme.precast.steelitem.api;

import javax.validation.Valid;

import coliseum.service.BaseServiceRequest;

public class SteelItemServiceRequest extends BaseServiceRequest {

	private static final long serialVersionUID = 1L;

	@Valid
	private SteelItemDTO steelItemDTO;

	private SteelItemSearchDTO steelItemSearchDTO;

	public SteelItemDTO getSteelItemDTO() {
		return steelItemDTO;
	}

	public void setSteelItemDTO(SteelItemDTO steelItemDTO) {
		this.steelItemDTO = steelItemDTO;
	}

	public SteelItemSearchDTO getSteelItemSearchDTO() {
		return steelItemSearchDTO;
	}

	public void setSteelItemSearchDTO(SteelItemSearchDTO steelItemSearchDTO) {
		this.steelItemSearchDTO = steelItemSearchDTO;
	}
}

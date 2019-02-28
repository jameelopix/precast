package com.vme.precast.mixtureitem.api;

import java.util.List;

import coliseum.service.BaseServiceResponse;

public class MixtureItemServiceResponse extends BaseServiceResponse {

	private static final long serialVersionUID = 1L;

	private List<MixtureItemDTO> mixtureItemDTOs;

	public List<MixtureItemDTO> getMixtureItemDTOs() {
		return mixtureItemDTOs;
	}

	public void setMixtureItemDTOs(List<MixtureItemDTO> mixtureItemDTOs) {
		this.mixtureItemDTOs = mixtureItemDTOs;
	}
}
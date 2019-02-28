package com.vme.precast.steelitem.api;

import java.util.List;

import coliseum.service.BaseServiceResponse;

public class SteelItemServiceResponse extends BaseServiceResponse {

	private static final long serialVersionUID = 1L;

	private List<SteelItemDTO> steelItemDTOs;

	public List<SteelItemDTO> getSteelItemDTOs() {
		return steelItemDTOs;
	}

	public void setSteelItemDTOs(List<SteelItemDTO> steelItemDTOs) {
		this.steelItemDTOs = steelItemDTOs;
	}

}
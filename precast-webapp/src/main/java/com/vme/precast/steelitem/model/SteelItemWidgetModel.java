package com.vme.precast.steelitem.model;

import java.util.List;

import javax.validation.Valid;

import com.vme.precast.steelitem.api.SteelItemDTO;
import com.vme.precast.steelitem.api.SteelItemSearchDTO;

import coliseum.web.BaseWidgetModel;

public class SteelItemWidgetModel extends BaseWidgetModel {

	private static final long serialVersionUID = 1L;

	@Valid
	private SteelItemDTO steelItemDTO;

	private SteelItemSearchDTO steelItemSearchDTO;

	private List<SteelItemDTO> steelItemDTOs;

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

	public List<SteelItemDTO> getSteelItemDTOs() {
		return steelItemDTOs;
	}

	public void setSteelItemDTOs(List<SteelItemDTO> steelItemDTOs) {
		this.steelItemDTOs = steelItemDTOs;
	}
}

package com.vme.precast.mixtureitem.model;

import java.util.List;

import com.vme.precast.mixtureitem.api.MixtureItemDTO;
import com.vme.precast.mixtureitem.api.MixtureItemSearchDTO;

import coliseum.web.BaseWidgetModel;

public class MixtureItemWidgetModel extends BaseWidgetModel {

	private static final long serialVersionUID = 1L;

	private MixtureItemDTO mixtureItemDTO;

	private MixtureItemSearchDTO mixtureItemSearchDTO;

	private List<MixtureItemDTO> mixtureItemDTOs;

	public MixtureItemDTO getMixtureItemDTO() {
		return mixtureItemDTO;
	}

	public void setMixtureItemDTO(MixtureItemDTO mixtureItemDTO) {
		this.mixtureItemDTO = mixtureItemDTO;
	}

	public MixtureItemSearchDTO getMixtureItemSearchDTO() {
		return mixtureItemSearchDTO;
	}

	public void setMixtureItemSearchDTO(MixtureItemSearchDTO mixtureItemSearchDTO) {
		this.mixtureItemSearchDTO = mixtureItemSearchDTO;
	}

	public List<MixtureItemDTO> getMixtureItemDTOs() {
		return mixtureItemDTOs;
	}

	public void setMixtureItemDTOs(List<MixtureItemDTO> mixtureItemDTOs) {
		this.mixtureItemDTOs = mixtureItemDTOs;
	}

}

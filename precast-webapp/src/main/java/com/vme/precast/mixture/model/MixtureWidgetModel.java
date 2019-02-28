package com.vme.precast.mixture.model;

import java.util.List;

import com.vme.precast.mixture.api.MixtureDTO;
import com.vme.precast.mixture.api.MixtureSearchDTO;

import coliseum.web.BaseWidgetModel;

public class MixtureWidgetModel extends BaseWidgetModel {

	private static final long serialVersionUID = 1L;

	private MixtureDTO mixtureDTO;

	private MixtureSearchDTO mixtureSearchDTO;

	private List<MixtureDTO> mixtureDTOs;

	public MixtureDTO getMixtureDTO() {
		return mixtureDTO;
	}

	public void setMixtureDTO(MixtureDTO mixtureDTO) {
		this.mixtureDTO = mixtureDTO;
	}

	public List<MixtureDTO> getMixtureDTOs() {
		return mixtureDTOs;
	}

	public void setMixtureDTOs(List<MixtureDTO> mixtureDTOs) {
		this.mixtureDTOs = mixtureDTOs;
	}

	public MixtureSearchDTO getMixtureSearchDTO() {
		return mixtureSearchDTO;
	}

	public void setMixtureSearchDTO(MixtureSearchDTO mixtureSearchDTO) {
		this.mixtureSearchDTO = mixtureSearchDTO;
	}

}

package com.vme.precast.castingactivity.model;

import java.util.List;

import com.vme.precast.castingactivity.api.CastingActivityDTO;
import com.vme.precast.castingactivity.api.CastingActivitySearchDTO;

import coliseum.web.BaseWidgetModel;

public class CastingActivityWidgetModel extends BaseWidgetModel {

	private static final long serialVersionUID = 1L;

	private CastingActivityDTO castingActivityDTO;

	private CastingActivitySearchDTO castingActivitySearchDTO;

	private List<CastingActivityDTO> castingActivityDTOs;

	public CastingActivityDTO getCastingActivityDTO() {
		return castingActivityDTO;
	}

	public void setCastingActivityDTO(CastingActivityDTO castingActivityDTO) {
		this.castingActivityDTO = castingActivityDTO;
	}

	public List<CastingActivityDTO> getCastingActivityDTOs() {
		return castingActivityDTOs;
	}

	public void setCastingActivityDTOs(List<CastingActivityDTO> castingActivityDTOs) {
		this.castingActivityDTOs = castingActivityDTOs;
	}

	public CastingActivitySearchDTO getCastingActivitySearchDTO() {
		return castingActivitySearchDTO;
	}

	public void setCastingActivitySearchDTO(CastingActivitySearchDTO castingActivitySearchDTO) {
		this.castingActivitySearchDTO = castingActivitySearchDTO;
	}

}

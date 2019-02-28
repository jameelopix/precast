package com.vme.precast.castingactivity.api;

import java.util.List;

import coliseum.service.BaseServiceResponse;

public class CastingActivityServiceResponse extends BaseServiceResponse {

	private static final long serialVersionUID = 1L;

	private List<CastingActivityDTO> castingActivityDTOs;

	public List<CastingActivityDTO> getCastingActivityDTOs() {
		return castingActivityDTOs;
	}

	public void setCastingActivityDTOs(List<CastingActivityDTO> castingActivityDTOs) {
		this.castingActivityDTOs = castingActivityDTOs;
	}
}
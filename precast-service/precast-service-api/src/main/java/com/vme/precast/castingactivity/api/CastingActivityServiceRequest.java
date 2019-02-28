package com.vme.precast.castingactivity.api;

import coliseum.service.BaseServiceRequest;

public class CastingActivityServiceRequest extends BaseServiceRequest {

	private static final long serialVersionUID = 1L;

	private CastingActivityDTO castingActivityDTO;

	private CastingActivitySearchDTO castingActivitySearchDTO;

	public CastingActivitySearchDTO getCastingActivitySearchDTO() {
		return castingActivitySearchDTO;
	}

	public void setCastingActivitySearchDTO(CastingActivitySearchDTO castingActivitySearchDTO) {
		this.castingActivitySearchDTO = castingActivitySearchDTO;
	}

	public CastingActivityDTO getCastingActivityDTO() {
		return castingActivityDTO;
	}

	public void setCastingActivityDTO(CastingActivityDTO castingActivityDTO) {
		this.castingActivityDTO = castingActivityDTO;
	}
}

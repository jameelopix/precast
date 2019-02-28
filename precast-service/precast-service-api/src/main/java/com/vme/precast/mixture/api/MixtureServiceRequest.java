package com.vme.precast.mixture.api;

import coliseum.service.BaseServiceRequest;

public class MixtureServiceRequest extends BaseServiceRequest {

	private static final long serialVersionUID = 1L;

	private MixtureDTO mixtureDTO;

	private MixtureSearchDTO mixtureSearchDTO;

	public MixtureDTO getMixtureDTO() {
		return mixtureDTO;
	}

	public void setMixtureDTO(MixtureDTO mixtureDTO) {
		this.mixtureDTO = mixtureDTO;
	}

	public MixtureSearchDTO getMixtureSearchDTO() {
		return mixtureSearchDTO;
	}

	public void setMixtureSearchDTO(MixtureSearchDTO mixtureSearchDTO) {
		this.mixtureSearchDTO = mixtureSearchDTO;
	}
}

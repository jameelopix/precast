package com.vme.precast.mixture.api;

import java.util.List;

import coliseum.service.BaseServiceResponse;

public class MixtureServiceResponse extends BaseServiceResponse {

	private static final long serialVersionUID = 1L;

	private List<MixtureDTO> mixtureDTOs;

	public List<MixtureDTO> getMixtureDTOs() {
		return mixtureDTOs;
	}

	public void setMixtureDTOs(List<MixtureDTO> mixtureDTOs) {
		this.mixtureDTOs = mixtureDTOs;
	}

}
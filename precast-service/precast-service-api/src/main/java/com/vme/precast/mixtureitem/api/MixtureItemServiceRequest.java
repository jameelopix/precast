package com.vme.precast.mixtureitem.api;

import coliseum.service.BaseServiceRequest;

public class MixtureItemServiceRequest extends BaseServiceRequest {

	private static final long serialVersionUID = 1L;

	private MixtureItemDTO mixtureItemDTO;

	private MixtureItemSearchDTO mixtureItemSearchDTO;

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
}

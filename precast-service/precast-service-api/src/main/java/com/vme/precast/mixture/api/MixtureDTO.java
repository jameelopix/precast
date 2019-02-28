package com.vme.precast.mixture.api;

import java.util.Set;

import com.vme.precast.mixtureitem.api.MixtureItemDTO;

import coliseum.service.BaseDTO;

public class MixtureDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String code;

	private Set<MixtureItemDTO> mixtureItemDTOs;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Set<MixtureItemDTO> getMixtureItemDTOs() {
		return mixtureItemDTOs;
	}

	public void setMixtureItemDTOs(Set<MixtureItemDTO> mixtureItemDTOs) {
		this.mixtureItemDTOs = mixtureItemDTOs;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
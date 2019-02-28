package com.vme.precast.elementtype.api;

import java.util.List;

import coliseum.service.BaseServiceResponse;

public class ElementTypeServiceResponse extends BaseServiceResponse {

	private static final long serialVersionUID = 1L;

	private List<ElementTypeDTO> elementTypeDTOs;

	public List<ElementTypeDTO> getElementTypeDTOs() {
		return elementTypeDTOs;
	}

	public void setElementTypeDTOs(List<ElementTypeDTO> elementTypeDTOs) {
		this.elementTypeDTOs = elementTypeDTOs;
	}

}
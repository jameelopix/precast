package com.vme.precast.element.api;

import java.util.List;

import coliseum.service.BaseServiceResponse;

public class ElementServiceResponse extends BaseServiceResponse {

	private static final long serialVersionUID = 1L;

	private List<ElementDTO> elementDTOs;

	public List<ElementDTO> getElementDTOs() {
		return elementDTOs;
	}

	public void setElementDTOs(List<ElementDTO> elementDTOs) {
		this.elementDTOs = elementDTOs;
	}
}
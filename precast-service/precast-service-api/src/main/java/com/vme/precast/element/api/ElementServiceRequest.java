package com.vme.precast.element.api;

import coliseum.service.BaseServiceRequest;

public class ElementServiceRequest extends BaseServiceRequest {

	private static final long serialVersionUID = 1L;

	private ElementDTO elementDTO;

	private ElementSearchDTO elementSearchDTO;

	public ElementDTO getElementDTO() {
		return elementDTO;
	}

	public void setElementDTO(ElementDTO elementDTO) {
		this.elementDTO = elementDTO;
	}

	public ElementSearchDTO getElementSearchDTO() {
		return elementSearchDTO;
	}

	public void setElementSearchDTO(ElementSearchDTO elementSearchDTO) {
		this.elementSearchDTO = elementSearchDTO;
	}
}

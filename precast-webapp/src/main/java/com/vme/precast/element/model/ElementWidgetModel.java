package com.vme.precast.element.model;

import java.util.List;

import com.vme.precast.element.api.ElementDTO;
import com.vme.precast.element.api.ElementSearchDTO;

import coliseum.web.BaseWidgetModel;

public class ElementWidgetModel extends BaseWidgetModel {

	private static final long serialVersionUID = 1L;

	private ElementDTO elementDTO;

	private ElementSearchDTO elementSearchDTO;

	private List<ElementDTO> elementDTOs;

	public List<ElementDTO> getElementDTOs() {
		return elementDTOs;
	}

	public void setElementDTOs(List<ElementDTO> elementDTOs) {
		this.elementDTOs = elementDTOs;
	}

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

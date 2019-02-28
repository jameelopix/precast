package com.vme.precast.elementtype.model;

import java.util.List;

import com.vme.precast.elementtype.api.ElementTypeDTO;
import com.vme.precast.elementtype.api.ElementTypeSearchDTO;

import coliseum.web.BaseWidgetModel;

public class ElementTypeWidgetModel extends BaseWidgetModel {

	private static final long serialVersionUID = 1L;

	private ElementTypeDTO elementTypeDTO;

	private ElementTypeSearchDTO elementTypeSearchDTO;

	private List<ElementTypeDTO> elementTypeDTOs;

	public ElementTypeDTO getElementTypeDTO() {
		return elementTypeDTO;
	}

	public void setElementTypeDTO(ElementTypeDTO elementTypeDTO) {
		this.elementTypeDTO = elementTypeDTO;
	}

	public ElementTypeSearchDTO getElementTypeSearchDTO() {
		return elementTypeSearchDTO;
	}

	public void setElementTypeSearchDTO(ElementTypeSearchDTO elementTypeSearchDTO) {
		this.elementTypeSearchDTO = elementTypeSearchDTO;
	}

	public List<ElementTypeDTO> getElementTypeDTOs() {
		return elementTypeDTOs;
	}

	public void setElementTypeDTOs(List<ElementTypeDTO> elementTypeDTOs) {
		this.elementTypeDTOs = elementTypeDTOs;
	}
}

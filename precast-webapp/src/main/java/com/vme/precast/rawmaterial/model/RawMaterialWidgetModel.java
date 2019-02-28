package com.vme.precast.rawmaterial.model;

import java.util.List;

import javax.validation.Valid;

import com.vme.precast.rawmaterial.api.RawMaterialDTO;
import com.vme.precast.rawmaterial.api.RawMaterialSearchDTO;

import coliseum.web.BaseWidgetModel;

public class RawMaterialWidgetModel extends BaseWidgetModel {

	private static final long serialVersionUID = 1L;

	@Valid
	private RawMaterialDTO rawMaterialDTO;

	private RawMaterialSearchDTO rawMaterialSearchDTO;

	private List<RawMaterialDTO> rawMaterialDTOs;

	public RawMaterialDTO getRawMaterialDTO() {
		return rawMaterialDTO;
	}

	public void setRawMaterialDTO(RawMaterialDTO rawMaterialDTO) {
		this.rawMaterialDTO = rawMaterialDTO;
	}

	public List<RawMaterialDTO> getRawMaterialDTOs() {
		return rawMaterialDTOs;
	}

	public void setRawMaterialDTOs(List<RawMaterialDTO> rawMaterialDTOs) {
		this.rawMaterialDTOs = rawMaterialDTOs;
	}

	public RawMaterialSearchDTO getRawMaterialSearchDTO() {
		return rawMaterialSearchDTO;
	}

	public void setRawMaterialSearchDTO(RawMaterialSearchDTO rawMaterialSearchDTO) {
		this.rawMaterialSearchDTO = rawMaterialSearchDTO;
	}

}

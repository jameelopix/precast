package com.vme.precast.rawmaterial.api;

import java.util.List;

import coliseum.service.BaseServiceResponse;

public class RawMaterialServiceResponse extends BaseServiceResponse {

	private static final long serialVersionUID = 1L;

	private List<RawMaterialDTO> rawMaterialDTOs;

	public List<RawMaterialDTO> getRawMaterialDTOs() {
		return rawMaterialDTOs;
	}

	public void setRawMaterialDTOs(List<RawMaterialDTO> rawMaterialDTOs) {
		this.rawMaterialDTOs = rawMaterialDTOs;
	}
}
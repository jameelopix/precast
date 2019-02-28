package com.vme.precast.rawmaterial.api;

import coliseum.service.BaseServiceRequest;

public class RawMaterialServiceRequest extends BaseServiceRequest {

	private static final long serialVersionUID = 1L;

	private RawMaterialDTO rawMaterialDTO;

	private RawMaterialSearchDTO rawMaterialSearchDTO;

	public RawMaterialDTO getRawMaterialDTO() {
		return rawMaterialDTO;
	}

	public void setRawMaterialDTO(RawMaterialDTO rawMaterialDTO) {
		this.rawMaterialDTO = rawMaterialDTO;
	}

	public RawMaterialSearchDTO getRawMaterialSearchDTO() {
		return rawMaterialSearchDTO;
	}

	public void setRawMaterialSearchDTO(RawMaterialSearchDTO rawMaterialSearchDTO) {
		this.rawMaterialSearchDTO = rawMaterialSearchDTO;
	}
}

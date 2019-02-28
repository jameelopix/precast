package com.vme.precast.subcontractor.api;

import java.util.List;

import coliseum.service.BaseServiceResponse;

public class SubContractorServiceResponse extends BaseServiceResponse {

	private static final long serialVersionUID = 1L;

	private List<SubContractorDTO> subContractorDTOs;

	public List<SubContractorDTO> getSubContractorDTOs() {
		return subContractorDTOs;
	}

	public void setSubContractorDTOs(List<SubContractorDTO> subContractorDTOs) {
		this.subContractorDTOs = subContractorDTOs;
	}
}
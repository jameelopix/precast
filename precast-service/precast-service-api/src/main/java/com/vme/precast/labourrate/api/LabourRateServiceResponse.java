package com.vme.precast.labourrate.api;

import java.util.List;

import coliseum.service.BaseServiceResponse;

public class LabourRateServiceResponse extends BaseServiceResponse {

	private static final long serialVersionUID = 1L;

	private List<LabourRateDTO> labourRateDTOs;

	public List<LabourRateDTO> getLabourRateDTOs() {
		return labourRateDTOs;
	}

	public void setLabourRateDTOs(List<LabourRateDTO> labourRateDTOs) {
		this.labourRateDTOs = labourRateDTOs;
	}
}
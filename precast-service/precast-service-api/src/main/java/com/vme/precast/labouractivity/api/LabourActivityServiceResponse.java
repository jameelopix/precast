package com.vme.precast.labouractivity.api;

import java.util.List;

import coliseum.service.BaseServiceResponse;

public class LabourActivityServiceResponse extends BaseServiceResponse {

	private static final long serialVersionUID = 1L;

	private List<LabourActivityDTO> labourActivityDTOs;

	public List<LabourActivityDTO> getLabourActivityDTOs() {
		return labourActivityDTOs;
	}

	public void setLabourActivityDTOs(List<LabourActivityDTO> labourActivityDTOs) {
		this.labourActivityDTOs = labourActivityDTOs;
	}
}
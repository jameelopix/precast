package com.vme.precast.labouractivity.api;

import coliseum.service.BaseServiceRequest;

public class LabourActivityServiceRequest extends BaseServiceRequest {

	private static final long serialVersionUID = 1L;

	private LabourActivityDTO labourActivityDTO;

	private LabourActivitySearchDTO labourActivitySearchDTO;

	public LabourActivityDTO getLabourActivityDTO() {
		return labourActivityDTO;
	}

	public void setLabourActivityDTO(LabourActivityDTO labourActivityDTO) {
		this.labourActivityDTO = labourActivityDTO;
	}

	public LabourActivitySearchDTO getLabourActivitySearchDTO() {
		return labourActivitySearchDTO;
	}

	public void setLabourActivitySearchDTO(LabourActivitySearchDTO labourActivitySearchDTO) {
		this.labourActivitySearchDTO = labourActivitySearchDTO;
	}
}

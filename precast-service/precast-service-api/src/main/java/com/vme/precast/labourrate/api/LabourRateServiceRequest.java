package com.vme.precast.labourrate.api;

import coliseum.service.BaseServiceRequest;

public class LabourRateServiceRequest extends BaseServiceRequest {

	private static final long serialVersionUID = 1L;

	private LabourRateDTO labourRateDTO;

	private LabourRateSearchDTO labourRateSearchDTO;

	public LabourRateDTO getLabourRateDTO() {
		return labourRateDTO;
	}

	public void setLabourRateDTO(LabourRateDTO labourRateDTO) {
		this.labourRateDTO = labourRateDTO;
	}

	public LabourRateSearchDTO getLabourRateSearchDTO() {
		return labourRateSearchDTO;
	}

	public void setLabourRateSearchDTO(LabourRateSearchDTO labourRateSearchDTO) {
		this.labourRateSearchDTO = labourRateSearchDTO;
	}
}

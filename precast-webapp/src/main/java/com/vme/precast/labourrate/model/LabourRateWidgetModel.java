package com.vme.precast.labourrate.model;

import java.util.List;

import com.vme.precast.labourrate.api.LabourRateDTO;
import com.vme.precast.labourrate.api.LabourRateSearchDTO;

import coliseum.web.BaseWidgetModel;

public class LabourRateWidgetModel extends BaseWidgetModel {

	private static final long serialVersionUID = 1L;

	private LabourRateDTO labourRateDTO;

	private LabourRateSearchDTO labourRateSearchDTO;

	private List<LabourRateDTO> labourRateDTOs;

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

	public List<LabourRateDTO> getLabourRateDTOs() {
		return labourRateDTOs;
	}

	public void setLabourRateDTOs(List<LabourRateDTO> labourRateDTOs) {
		this.labourRateDTOs = labourRateDTOs;
	}
}

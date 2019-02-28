package com.vme.precast.labouractivity.model;

import java.util.List;

import com.vme.precast.labouractivity.api.LabourActivityDTO;
import com.vme.precast.labouractivity.api.LabourActivitySearchDTO;

import coliseum.web.BaseWidgetModel;

public class LabourActivityWidgetModel extends BaseWidgetModel {

	private static final long serialVersionUID = 1L;

	private LabourActivityDTO labourActivityDTO;

	private LabourActivitySearchDTO labourActivitySearchDTO;

	private List<LabourActivityDTO> labourActivityDTOs;

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

	public List<LabourActivityDTO> getLabourActivityDTOs() {
		return labourActivityDTOs;
	}

	public void setLabourActivityDTOs(List<LabourActivityDTO> labourActivityDTOs) {
		this.labourActivityDTOs = labourActivityDTOs;
	}
}

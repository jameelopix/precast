package com.vme.precast.subcontractor.model;

import java.util.List;

import javax.validation.Valid;

import com.vme.precast.subcontractor.api.SubContractorDTO;
import com.vme.precast.subcontractor.api.SubContractorSearchDTO;

import coliseum.web.BaseWidgetModel;

public class SubContractorWidgetModel extends BaseWidgetModel {

	private static final long serialVersionUID = 1L;

	@Valid
	private SubContractorDTO subContractorDTO;

	private SubContractorSearchDTO subContractorSearchDTO;

	private List<SubContractorDTO> subContractorDTOs;

	public SubContractorDTO getSubContractorDTO() {
		return subContractorDTO;
	}

	public void setSubContractorDTO(SubContractorDTO subContractorDTO) {
		this.subContractorDTO = subContractorDTO;
	}

	public SubContractorSearchDTO getSubContractorSearchDTO() {
		return subContractorSearchDTO;
	}

	public void setSubContractorSearchDTO(SubContractorSearchDTO subContractorSearchDTO) {
		this.subContractorSearchDTO = subContractorSearchDTO;
	}

	public List<SubContractorDTO> getSubContractorDTOs() {
		return subContractorDTOs;
	}

	public void setSubContractorDTOs(List<SubContractorDTO> subContractorDTOs) {
		this.subContractorDTOs = subContractorDTOs;
	}

}

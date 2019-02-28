package com.vme.precast.workdetail.api;

import javax.validation.Valid;

import coliseum.service.BaseServiceRequest;

public class WorkDetailServiceRequest extends BaseServiceRequest {

	private static final long serialVersionUID = 1L;

	@Valid
	private WorkDetailDTO workDetailDTO;

	private WorkDetailSearchDTO workDetailSearchDTO;

	public WorkDetailDTO getWorkDetailDTO() {
		return workDetailDTO;
	}

	public void setWorkDetailDTO(WorkDetailDTO workDetailDTO) {
		this.workDetailDTO = workDetailDTO;
	}

	public WorkDetailSearchDTO getWorkDetailSearchDTO() {
		return workDetailSearchDTO;
	}

	public void setWorkDetailSearchDTO(WorkDetailSearchDTO workDetailSearchDTO) {
		this.workDetailSearchDTO = workDetailSearchDTO;
	}
}

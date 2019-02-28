package com.vme.precast.workdetail.api;

import java.util.List;

import coliseum.service.BaseServiceResponse;

public class WorkDetailServiceResponse extends BaseServiceResponse {

	private static final long serialVersionUID = 1L;

	private List<WorkDetailDTO> workDetailDTOs;

	public List<WorkDetailDTO> getWorkDetailDTOs() {
		return workDetailDTOs;
	}

	public void setWorkDetailDTOs(List<WorkDetailDTO> workDetailDTOs) {
		this.workDetailDTOs = workDetailDTOs;
	}
}
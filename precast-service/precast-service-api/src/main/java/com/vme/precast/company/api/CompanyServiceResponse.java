package com.vme.precast.company.api;

import java.util.List;

import coliseum.service.BaseServiceResponse;

public class CompanyServiceResponse extends BaseServiceResponse {

	private static final long serialVersionUID = 1L;

	private List<CompanyDTO> companyDTOs;

	public List<CompanyDTO> getCompanyDTOs() {
		return companyDTOs;
	}

	public void setCompanyDTOs(List<CompanyDTO> companyDTOs) {
		this.companyDTOs = companyDTOs;
	}
}
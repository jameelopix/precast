package com.vme.precast.company.api;

import coliseum.service.BaseServiceRequest;

public class CompanyServiceRequest extends BaseServiceRequest {

	private static final long serialVersionUID = 1L;

	private CompanyDTO companyDTO;

	private CompanySearchDTO companySearchDTO;

	public CompanySearchDTO getCompanySearchDTO() {
		return companySearchDTO;
	}

	public void setCompanySearchDTO(CompanySearchDTO companySearchDTO) {
		this.companySearchDTO = companySearchDTO;
	}

	public CompanyDTO getCompanyDTO() {
		return companyDTO;
	}

	public void setCompanyDTO(CompanyDTO companyDTO) {
		this.companyDTO = companyDTO;
	}
}

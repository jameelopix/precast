package com.vme.precast.company.controller;

import java.util.List;

import com.vme.precast.company.api.CompanyDTO;
import com.vme.precast.company.api.CompanySearchDTO;

import coliseum.web.BaseWidgetModel;

public class CompanyWidgetModel extends BaseWidgetModel {

	private static final long serialVersionUID = 1L;

	private CompanyDTO companyDTO;

	private CompanySearchDTO companySearchDTO;

	private List<CompanyDTO> companyDTOs;

	public List<CompanyDTO> getCompanyDTOs() {
		return companyDTOs;
	}

	public void setCompanyDTOs(List<CompanyDTO> companyDTOs) {
		this.companyDTOs = companyDTOs;
	}

	public CompanyDTO getCompanyDTO() {
		return companyDTO;
	}

	public void setCompanyDTO(CompanyDTO companyDTO) {
		this.companyDTO = companyDTO;
	}

	public CompanySearchDTO getCompanySearchDTO() {
		return companySearchDTO;
	}

	public void setCompanySearchDTO(CompanySearchDTO companySearchDTO) {
		this.companySearchDTO = companySearchDTO;
	}
}

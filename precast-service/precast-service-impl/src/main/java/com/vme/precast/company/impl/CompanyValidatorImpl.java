package com.vme.precast.company.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.company.api.CompanyDTO;
import com.vme.precast.company.api.CompanyServiceRequest;
import com.vme.precast.company.api.CompanyValidator;
import com.vme.precast.domain.Company;
import com.vme.precast.repository.CompanyRepo;

import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;
import coliseum.service.ErrorDTO;

public class CompanyValidatorImpl implements CompanyValidator {

	@Autowired
	private CompanyRepo companyRepo;

	@Override
	public ErrorDTO checkCompanyDuplicate(CompanyServiceRequest companyServiceRequest) {
		ErrorDTO errorDTO = null;
		CompanyDTO companyDTO = companyServiceRequest.getCompanyDTO();

		SearchObject searchObject = new SearchObject();
		List<Filter> filters = new ArrayList<>();
		createEqualFilter(filters, CompanyDTO.NAME, companyDTO.getName());
		createEqualFilter(filters, CompanyDTO.DISABLED, false);
		if (CollectionUtils.isNotEmpty(filters)) {
			searchObject.setFilters(filters);
		}
		List<Company> companies = companyRepo.search(searchObject);

		if (CollectionUtils.isNotEmpty(companies)) {
			for (Company company : companies) {
				if (!company.getId().equals(companyDTO.getId())) {
					errorDTO = new ErrorDTO("ERR101", "Company already exists!!!");
					break;
				}
			}
		}
		return errorDTO;
	}
}
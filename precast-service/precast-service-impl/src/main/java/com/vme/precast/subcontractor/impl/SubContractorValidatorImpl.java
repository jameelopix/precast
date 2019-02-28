package com.vme.precast.subcontractor.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.domain.SubContractor;
import com.vme.precast.repository.SubContractorRepo;
import com.vme.precast.subcontractor.api.SubContractorDTO;
import com.vme.precast.subcontractor.api.SubContractorServiceRequest;
import com.vme.precast.subcontractor.api.SubContractorValidator;

import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;
import coliseum.service.ErrorDTO;

public class SubContractorValidatorImpl implements SubContractorValidator {

	@Autowired
	private SubContractorRepo subContractorRepo;

	@Override
	public ErrorDTO checkSubContractorDuplicate(SubContractorServiceRequest subContractorServiceRequest) {
		ErrorDTO errorDTO = null;
		SubContractorDTO subContractorDTO = subContractorServiceRequest.getSubContractorDTO();

		SearchObject searchObject = new SearchObject();
		List<Filter> filters = new ArrayList<>();
		createEqualFilter(filters, SubContractorDTO.NAME, subContractorDTO.getName());
		if (CollectionUtils.isNotEmpty(filters)) {
			searchObject.setFilters(filters);
		}
		List<SubContractor> companies = subContractorRepo.search(searchObject);

		if (CollectionUtils.isNotEmpty(companies)) {
			for (SubContractor company : companies) {
				if (!company.getId().equals(subContractorDTO.getId())) {
					errorDTO = new ErrorDTO("ERR110", "SubContractor already exists!!!");
					break;
				}
			}
		}
		return errorDTO;
	}
}
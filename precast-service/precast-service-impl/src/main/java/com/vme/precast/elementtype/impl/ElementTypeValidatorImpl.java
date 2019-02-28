package com.vme.precast.elementtype.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.domain.ElementType;
import com.vme.precast.elementtype.api.ElementTypeDTO;
import com.vme.precast.elementtype.api.ElementTypeServiceRequest;
import com.vme.precast.elementtype.api.ElementTypeValidator;
import com.vme.precast.repository.ElementTypeRepo;

import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;
import coliseum.service.ErrorDTO;

public class ElementTypeValidatorImpl implements ElementTypeValidator {

	@Autowired
	private ElementTypeRepo elementTypeRepo;

	@Override
	public ErrorDTO checkElementTypeDuplicate(ElementTypeServiceRequest elementTypeServiceRequest) {
		ErrorDTO errorDTO = null;
		ElementTypeDTO elementTypeDTO = elementTypeServiceRequest.getElementTypeDTO();

		SearchObject searchObject = new SearchObject();
		List<Filter> filters = new ArrayList<>();
		createEqualFilter(filters, ElementTypeDTO.NAME, elementTypeDTO.getName());
		createEqualFilter(filters, ElementTypeDTO.PROJECTID, elementTypeDTO.getProjectId());
		if (CollectionUtils.isNotEmpty(filters)) {
			searchObject.setFilters(filters);
		}
		List<ElementType> companies = elementTypeRepo.search(searchObject);

		if (CollectionUtils.isNotEmpty(companies)) {
			for (ElementType company : companies) {
				if (!company.getId().equals(elementTypeDTO.getId())) {
					errorDTO = new ErrorDTO("ERR110", "ElementType already exists!!!");
					break;
				}
			}
		}
		return errorDTO;
	}
}
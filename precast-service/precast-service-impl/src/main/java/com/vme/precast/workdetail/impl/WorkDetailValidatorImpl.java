package com.vme.precast.workdetail.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.domain.WorkDetail;
import com.vme.precast.repository.WorkDetailRepo;
import com.vme.precast.workdetail.api.WorkDetailDTO;
import com.vme.precast.workdetail.api.WorkDetailServiceRequest;
import com.vme.precast.workdetail.api.WorkDetailValidator;

import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;
import coliseum.service.ErrorDTO;

public class WorkDetailValidatorImpl implements WorkDetailValidator {

	@Autowired
	private WorkDetailRepo workDetailRepo;

	@Override
	public ErrorDTO checkWorkDetailDuplicate(WorkDetailServiceRequest workDetailServiceRequest) {
		ErrorDTO errorDTO = null;
		WorkDetailDTO workDetailDTO = workDetailServiceRequest.getWorkDetailDTO();

		SearchObject searchObject = new SearchObject();
		List<Filter> filters = new ArrayList<>();
		createEqualFilter(filters, WorkDetailDTO.PROJECTID, workDetailDTO.getProjectId());
		createEqualFilter(filters, WorkDetailDTO.ELEMENTTYPEID, workDetailDTO.getElementTypeId());
		createEqualFilter(filters, WorkDetailDTO.WORKNATURE, workDetailDTO.getWorkNature());
		createEqualFilter(filters, WorkDetailDTO.WORKDESC, workDetailDTO.getWorkDesc());
		if (CollectionUtils.isNotEmpty(filters)) {
			searchObject.setFilters(filters);
		}
		List<WorkDetail> companies = workDetailRepo.search(searchObject);

		if (CollectionUtils.isNotEmpty(companies)) {
			for (WorkDetail company : companies) {
				if (!company.getId().equals(workDetailDTO.getId())) {
					errorDTO = new ErrorDTO("ERR110", "WorkDetail already exists!!!");
					break;
				}
			}
		}
		return errorDTO;
	}
}
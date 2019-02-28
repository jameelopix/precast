package com.vme.precast.project.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.domain.Project;
import com.vme.precast.project.api.ProjectDTO;
import com.vme.precast.project.api.ProjectServiceRequest;
import com.vme.precast.project.api.ProjectValidator;
import com.vme.precast.repository.ProjectRepo;

import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;
import coliseum.service.ErrorDTO;

public class ProjectValidatorImpl implements ProjectValidator {

	@Autowired
	private ProjectRepo projectRepo;

	@Override
	public ErrorDTO checkProjectDuplicate(ProjectServiceRequest projectServiceRequest) {
		ErrorDTO errorDTO = null;
		ProjectDTO projectDTO = projectServiceRequest.getProjectDTO();

		SearchObject searchObject = new SearchObject();
		List<Filter> filters = new ArrayList<>();
		createEqualFilter(filters, ProjectDTO.CODE, projectDTO.getCode());
		if (CollectionUtils.isNotEmpty(filters)) {
			searchObject.setFilters(filters);
		}
		List<Project> companies = projectRepo.search(searchObject);

		if (CollectionUtils.isNotEmpty(companies)) {
			for (Project company : companies) {
				if (!company.getId().equals(projectDTO.getId())) {
					errorDTO = new ErrorDTO("ERR110", "Project already exists!!!");
					break;
				}
			}
		}
		return errorDTO;
	}
}
package com.vme.precast.project.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.domain.Project;
import com.vme.precast.project.api.ProjectDTO;
import com.vme.precast.project.api.ProjectSearchDTO;
import com.vme.precast.project.api.ProjectServiceRequest;
import com.vme.precast.project.api.ProjectValidator;
import com.vme.precast.repository.ProjectRepo;

import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;
import coliseum.service.ErrorDTO;
import coliseum.service.FilterUtils;

public class ProjectValidatorImpl implements ProjectValidator {
    @Autowired
    ProjectRepo projectRepo;

    @Override
    public ErrorDTO checkProjectDuplicate(ProjectServiceRequest projectServiceRequest) {
        ErrorDTO errorDTO = null;
        ProjectDTO projectDTO = projectServiceRequest.getProjectDTO();

        SearchObject searchObject = new SearchObject();
        List<Filter> filters = new ArrayList<>();
        FilterUtils.createEqualFilter(filters, ProjectSearchDTO.CODE, projectDTO.getCode());
        if (CollectionUtils.isNotEmpty(filters)) {
            searchObject.setFilters(filters);
        }
        List<Project> projectList = projectRepo.search(searchObject);

        if (CollectionUtils.isNotEmpty(projectList)) {
            for (Project company : projectList) {
                if (!company.getId().equals(projectDTO.getId())) {
                    errorDTO = new ErrorDTO("ERR_PR_100", "Project Code already exists!!!");
                    break;
                }
            }
        }
        return errorDTO;
    }
}
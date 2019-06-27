package com.vme.precast.project.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.domain.Project;
import com.vme.precast.project.api.ProjectComponent;
import com.vme.precast.project.api.ProjectDTO;
import com.vme.precast.project.api.ProjectSearchDTO;
import com.vme.precast.project.api.ProjectServiceRequest;
import com.vme.precast.project.api.ProjectServiceResponse;
import com.vme.precast.repository.ProjectRepo;

import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;
import coliseum.service.ConversionUtility;
import coliseum.service.FilterUtils;

public class ProjectComponentImpl implements ProjectComponent {
    @Autowired
    ProjectRepo projectRepo;

    @Autowired
    ConversionUtility conversionUtility;

    @Override
    public ProjectServiceResponse createProject(ProjectServiceRequest projectServiceRequest) {
        ProjectDTO projectDTO = projectServiceRequest.getProjectDTO();
        Project project = (Project) conversionUtility.convert(projectDTO, ProjectDTO.class, Project.class);
        projectRepo.save(project);
        return null;
    }

    @Override
    public ProjectServiceResponse getProjects(ProjectServiceRequest projectServiceRequest) {
        List<Project> projectList = new ArrayList<>();
        List<Filter> filters = new ArrayList<>();
        SearchObject searchObject = new SearchObject();

        ProjectSearchDTO projectSearchDTO = projectServiceRequest.getProjectSearchDTO();
        if (projectSearchDTO != null) {
            List<Long> ids = projectSearchDTO.getIdList();
            List<String> nameList = projectSearchDTO.getNameList();
            List<String> codeList = projectSearchDTO.getCodeList();

            FilterUtils.createEqualFilter(filters, ProjectSearchDTO.ID, ids);
            FilterUtils.createEqualFilter(filters, ProjectSearchDTO.NAME, nameList);
            FilterUtils.createEqualFilter(filters, ProjectSearchDTO.CODE, codeList);

            if (CollectionUtils.isNotEmpty(filters)) {
                searchObject.setFilters(filters);
            }
        }
        searchObject.setPageIndex(projectServiceRequest.getPageIndex());
        searchObject.setRecordstoFetch(projectServiceRequest.getRecordstoFetch());
        projectList = projectRepo.search(searchObject);

        List<ProjectDTO> projectDTOList = new ArrayList<>();
        for (Project target : projectList) {
            projectDTOList.add((ProjectDTO) conversionUtility.convert(target, Project.class, ProjectDTO.class));
        }
        ProjectServiceResponse projectServiceResponse = new ProjectServiceResponse();
        projectServiceResponse.setProjectDTOList(projectDTOList);
        return projectServiceResponse;
    }

    @Override
    public ProjectServiceResponse updateProject(ProjectServiceRequest projectServiceRequest) {
        ProjectDTO source = projectServiceRequest.getProjectDTO();

        Project target = projectRepo.findById(source.getId()).get();
        target.setName(source.getName());
        target.setCode(source.getCode());
        projectRepo.save(target);
        return null;
    }

    @Override
    public ProjectServiceResponse deleteProject(ProjectServiceRequest projectServiceRequest) {
        ProjectDTO projectDTO = projectServiceRequest.getProjectDTO();
        projectRepo.deleteById(projectDTO.getId());
        return null;
    }
}
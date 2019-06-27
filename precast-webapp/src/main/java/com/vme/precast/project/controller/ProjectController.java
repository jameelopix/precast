package com.vme.precast.project.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vme.precast.project.api.ProjectDTO;
import com.vme.precast.project.api.ProjectService;
import com.vme.precast.project.api.ProjectServiceRequest;
import com.vme.precast.project.api.ProjectServiceResponse;

@Controller
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @RequestMapping(value = "deleteProject", method = RequestMethod.POST)
    @ResponseBody
    public ProjectClientModel deleteProject(@RequestBody ProjectClientModel projectClientModel) {
        ProjectServiceRequest projectServiceRequest = new ProjectServiceRequest();
        for (Long id : projectClientModel.getIdsToDelete()) {
            ProjectDTO projectDTO = new ProjectDTO();
            projectDTO.setId(id);
            projectServiceRequest.setProjectDTO(projectDTO);
            projectService.deleteProject(projectServiceRequest);
        }
        return null;
    }

    @RequestMapping(value = "createProject", method = RequestMethod.POST)
    @ResponseBody
    public ProjectClientModel createProject(@Valid @RequestBody ProjectClientModel projectClientModel) {
        return this.constructClientModel(projectService.createProject(this.constructServiceRequest(projectClientModel)));
    }

    @RequestMapping(value = "updateProject", method = RequestMethod.POST)
    @ResponseBody
    public ProjectClientModel updateProject(@Valid @RequestBody ProjectClientModel projectClientModel) {
        return this.constructClientModel(projectService.updateProject(this.constructServiceRequest(projectClientModel)));
    }

    @RequestMapping(value = "getProject", method = RequestMethod.POST)
    @ResponseBody
    public ProjectClientModel getProject(@RequestBody ProjectClientModel projectClientModel) {
        return this.constructClientModel(projectService.getProjects(this.constructServiceRequest(projectClientModel)));
    }

    private ProjectClientModel constructClientModel(ProjectServiceResponse projectServiceResponse) {
        ProjectClientModel projectClientModel = null;
        if (projectServiceResponse != null) {
            projectClientModel = new ProjectClientModel();
            projectClientModel.setProjectDTOList(projectServiceResponse.getProjectDTOList());
            projectClientModel.setTotalRecords(projectServiceResponse.getTotalRecords());
        }
        return projectClientModel;
    }

    private ProjectServiceRequest constructServiceRequest(ProjectClientModel projectClientModel) {
        ProjectServiceRequest projectServiceRequest = new ProjectServiceRequest();
        projectServiceRequest.setProjectDTO(projectClientModel.getProjectDTO());
        projectServiceRequest.setProjectSearchDTO(projectClientModel.getProjectSearchDTO());
        projectServiceRequest.setRecordstoFetch(projectClientModel.getRecordstoFetch());
        projectServiceRequest.setPageIndex(projectClientModel.getPageIndex());
        return projectServiceRequest;
    }
}
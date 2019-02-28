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
import com.vme.precast.project.model.ProjectWidgetModel;

@Controller
public class ProjectController {

	@Autowired
	ProjectService projectService;

	@RequestMapping(value = "deleteProject", method = RequestMethod.POST)
	@ResponseBody
	public ProjectWidgetModel deleteProject(@RequestBody ProjectWidgetModel widgetModel) {
		ProjectServiceRequest serviceRequest = new ProjectServiceRequest();
		for (Long id : widgetModel.getIdsToDelete()) {
			ProjectDTO projectDTO = new ProjectDTO();
			projectDTO.setId(id);
			serviceRequest.setProjectDTO(projectDTO);
			projectService.deleteProject(serviceRequest);
		}
		return null;
	}

	@RequestMapping(value = "estimateProject", method = RequestMethod.POST)
	@ResponseBody
	public ProjectWidgetModel estimateProject(@RequestBody ProjectWidgetModel widgetModel) {
		ProjectServiceRequest serviceRequest = new ProjectServiceRequest();
		if (widgetModel.getProjectId() != null) {
			ProjectDTO projectDTO = new ProjectDTO();
			projectDTO.setId(widgetModel.getProjectId());
			serviceRequest.setProjectDTO(projectDTO);
			projectService.estimateProject(serviceRequest);
		}
		return null;
	}

	@RequestMapping(value = "createProject", method = RequestMethod.POST)
	@ResponseBody
	public ProjectWidgetModel createProject(@Valid @RequestBody ProjectWidgetModel widgetModel) {
		return this.constructWidgetModel(projectService.createProject(this.constructServiceRequest(widgetModel)));
	}

	@RequestMapping(value = "updateProject", method = RequestMethod.POST)
	@ResponseBody
	public ProjectWidgetModel updateProject(@Valid @RequestBody ProjectWidgetModel widgetModel) {
		return this.constructWidgetModel(projectService.updateProject(this.constructServiceRequest(widgetModel)));
	}

	@RequestMapping(value = "getProject", method = RequestMethod.POST)
	@ResponseBody
	public ProjectWidgetModel getProject(@RequestBody ProjectWidgetModel widgetModel) {
		return this.constructWidgetModel(projectService.getProjects(this.constructServiceRequest(widgetModel)));
	}

	private ProjectWidgetModel constructWidgetModel(ProjectServiceResponse serviceResponse) {
		ProjectWidgetModel widgetModel = new ProjectWidgetModel();
		widgetModel.setProjectDTOs(serviceResponse.getProjectDTOs());
		widgetModel.setTotalRecords(serviceResponse.getTotalRecords());
		return widgetModel;
	}

	private ProjectServiceRequest constructServiceRequest(ProjectWidgetModel widgetModel) {
		ProjectServiceRequest serviceRequest = new ProjectServiceRequest();
		serviceRequest.setProjectDTO(widgetModel.getProjectDTO());
		serviceRequest.setProjectSearchDTO(widgetModel.getProjectSearchDTO());
		serviceRequest.setRecordstoFetch(widgetModel.getRecordstoFetch());
		serviceRequest.setPageIndex(widgetModel.getPageIndex());
		return serviceRequest;
	}
}

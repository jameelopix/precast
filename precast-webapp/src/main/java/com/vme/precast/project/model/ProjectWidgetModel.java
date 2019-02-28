package com.vme.precast.project.model;

import java.util.List;

import javax.validation.Valid;

import com.vme.precast.project.api.ProjectDTO;
import com.vme.precast.project.api.ProjectSearchDTO;

import coliseum.web.BaseWidgetModel;

public class ProjectWidgetModel extends BaseWidgetModel {

	private static final long serialVersionUID = 1L;

	@Valid
	private ProjectDTO projectDTO;

	private ProjectSearchDTO projectSearchDTO;

	private Long projectId;

	private List<ProjectDTO> projectDTOs;

	public ProjectDTO getProjectDTO() {
		return projectDTO;
	}

	public void setProjectDTO(ProjectDTO projectDTO) {
		this.projectDTO = projectDTO;
	}

	public List<ProjectDTO> getProjectDTOs() {
		return projectDTOs;
	}

	public void setProjectDTOs(List<ProjectDTO> projectDTOs) {
		this.projectDTOs = projectDTOs;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public ProjectSearchDTO getProjectSearchDTO() {
		return projectSearchDTO;
	}

	public void setProjectSearchDTO(ProjectSearchDTO projectSearchDTO) {
		this.projectSearchDTO = projectSearchDTO;
	}

}

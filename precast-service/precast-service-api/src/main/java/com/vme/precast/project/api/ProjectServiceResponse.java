package com.vme.precast.project.api;

import java.util.List;

import coliseum.service.BaseServiceResponse;

public class ProjectServiceResponse extends BaseServiceResponse {

	private static final long serialVersionUID = 1L;

	private List<ProjectDTO> projectDTOs;

	public List<ProjectDTO> getProjectDTOs() {
		return projectDTOs;
	}

	public void setProjectDTOs(List<ProjectDTO> projectDTOs) {
		this.projectDTOs = projectDTOs;
	}
}
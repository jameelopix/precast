package com.vme.precast.elementtype.api;

import com.vme.precast.project.api.ProjectDTO;

import coliseum.service.BaseDTO;

public class ElementTypeDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	private Long projectId;

	private ProjectDTO projectDTO;

	private String name;

	public static String ID = "id";
	public static String PROJECTID = "projectId";
	public static String PROJECTDTO = "projectDTO";
	public static String NAME = "name";

	public Long getProjectId() {
		return projectId;
	}

	public ProjectDTO getProjectDTO() {
		return projectDTO;
	}

	public String getName() {
		return name;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public void setProjectDTO(ProjectDTO projectDTO) {
		this.projectDTO = projectDTO;
	}

	public void setName(String name) {
		this.name = name;
	}
}

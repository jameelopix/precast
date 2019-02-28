package com.vme.precast.workdetail.api;

import com.vme.precast.elementtype.api.ElementTypeDTO;
import com.vme.precast.project.api.ProjectDTO;

import coliseum.service.BaseDTO;

public class WorkDetailDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	private Long projectId;

	private ProjectDTO projectDTO;

	private Long elementTypeId;

	private ElementTypeDTO elementTypeDTO;

	private String workNature;

	private String workDesc;

	public static String ID = "id";
	public static String PROJECTID = "projectId";
	public static String ELEMENTTYPEID = "elementTypeId";
	public static String WORKNATURE = "workNature";
	public static String WORKDESC = "workDesc";

	public Long getProjectId() {
		return projectId;
	}

	public ProjectDTO getProjectDTO() {
		return projectDTO;
	}

	public Long getElementTypeId() {
		return elementTypeId;
	}

	public ElementTypeDTO getElementTypeDTO() {
		return elementTypeDTO;
	}

	public String getWorkNature() {
		return workNature;
	}

	public String getWorkDesc() {
		return workDesc;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public void setProjectDTO(ProjectDTO projectDTO) {
		this.projectDTO = projectDTO;
	}

	public void setElementTypeId(Long elementTypeId) {
		this.elementTypeId = elementTypeId;
	}

	public void setElementTypeDTO(ElementTypeDTO elementTypeDTO) {
		this.elementTypeDTO = elementTypeDTO;
	}

	public void setWorkNature(String workNature) {
		this.workNature = workNature;
	}

	public void setWorkDesc(String workDesc) {
		this.workDesc = workDesc;
	}
}

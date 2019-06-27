package com.vme.precast.elementtype.api;

import com.vme.precast.project.api.ProjectDTO;

import coliseum.service.BaseDTO;

public class ElementTypeDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private ProjectDTO projectDTO;
    private Long projectDTOId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProjectDTO getProjectDTO() {
        return projectDTO;
    }

    public void setProjectDTO(ProjectDTO projectDTO) {
        this.projectDTO = projectDTO;
    }

    public Long getProjectDTOId() {
        return projectDTOId;
    }

    public void setProjectDTOId(Long projectDTOId) {
        this.projectDTOId = projectDTOId;
    }
}
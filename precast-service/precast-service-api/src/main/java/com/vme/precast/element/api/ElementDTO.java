package com.vme.precast.element.api;

import com.vme.precast.elementtype.api.ElementTypeDTO;
import com.vme.precast.project.api.ProjectDTO;

import coliseum.service.BaseDTO;

public class ElementDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private String floor;
    private ProjectDTO projectDTO;
    private Long projectDTOId;
    private ElementTypeDTO elementTypeDTO;
    private Long elementTypeDTOId;

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

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
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

    public ElementTypeDTO getElementTypeDTO() {
        return elementTypeDTO;
    }

    public void setElementTypeDTO(ElementTypeDTO elementTypeDTO) {
        this.elementTypeDTO = elementTypeDTO;
    }

    public Long getElementTypeDTOId() {
        return elementTypeDTOId;
    }

    public void setElementTypeDTOId(Long elementTypeDTOId) {
        this.elementTypeDTOId = elementTypeDTOId;
    }

}
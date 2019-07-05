package com.vme.precast.element.api;

import java.util.List;

import com.vme.precast.elementtype.api.ElementTypeDTO;
import com.vme.precast.project.api.ProjectDTO;

import coliseum.service.BaseSearchDTO;

public class ElementSearchDTO extends BaseSearchDTO {

    private static final long serialVersionUID = 1L;
    private List<Long> idList;
    private List<String> nameList;
    private List<String> floorList;
    private List<ProjectDTO> projectDTOList;
    private List<Long> projectIdList;
    private List<ElementTypeDTO> elementTypeDTOList;
    private List<Long> elementTypeIdList;
    
    private Boolean projectNeeded;
    private Boolean elementTypeNeeded;

    public static String ID = "id";
    public static String NAME = "name";
    public static String FLOOR = "floor";
    public static String PROJECT = "project";
    public static String PROJECTID = "project.Id";
    public static String ELEMENTTYPE = "elementType";
    public static String ELEMENTTYPEID = "elementType.id";

    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
    }

    public List<String> getNameList() {
        return nameList;
    }

    public void setNameList(List<String> nameList) {
        this.nameList = nameList;
    }

    public List<String> getFloorList() {
        return floorList;
    }

    public void setFloorList(List<String> floorList) {
        this.floorList = floorList;
    }

    public List<ProjectDTO> getProjectDTOList() {
        return projectDTOList;
    }

    public void setProjectDTOList(List<ProjectDTO> projectDTOList) {
        this.projectDTOList = projectDTOList;
    }
    
    public List<ElementTypeDTO> getElementTypeDTOList() {
        return elementTypeDTOList;
    }

    public void setElementTypeDTOList(List<ElementTypeDTO> elementTypeDTOList) {
        this.elementTypeDTOList = elementTypeDTOList;
    }
    
    public Boolean getElementTypeNeeded() {
        return elementTypeNeeded;
    }

    public void setElementTypeNeeded(Boolean elementTypeNeeded) {
        this.elementTypeNeeded = elementTypeNeeded;
    }

    public Boolean getProjectNeeded() {
        return projectNeeded;
    }

    public void setProjectNeeded(Boolean projectNeeded) {
        this.projectNeeded = projectNeeded;
    }

    public List<Long> getElementTypeIdList() {
        return elementTypeIdList;
    }

    public void setElementTypeIdList(List<Long> elementTypeIdList) {
        this.elementTypeIdList = elementTypeIdList;
    }

    public List<Long> getProjectIdList() {
        return projectIdList;
    }

    public void setProjectIdList(List<Long> projectIdList) {
        this.projectIdList = projectIdList;
    }

}
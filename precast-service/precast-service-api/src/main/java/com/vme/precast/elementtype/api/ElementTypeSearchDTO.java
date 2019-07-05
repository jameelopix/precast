package com.vme.precast.elementtype.api;

import java.util.List;

import com.vme.precast.project.api.ProjectDTO;

import coliseum.service.BaseSearchDTO;

public class ElementTypeSearchDTO extends BaseSearchDTO {

    private static final long serialVersionUID = 1L;
    private List<Long> idList;
    private List<String> nameList;
    private List<ProjectDTO> projectDTOList;
    private List<Long> projectIdList;

    private Boolean projectNeeded;

    public static String ID = "id";
    public static String NAME = "name";
    public static String PROJECT = "project";
    public static String PROJECTID = "project.id";

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

    public List<ProjectDTO> getProjectDTOList() {
        return projectDTOList;
    }

    public void setProjectDTOList(List<ProjectDTO> projectDTOList) {
        this.projectDTOList = projectDTOList;
    }

    public List<Long> getProjectIdList() {
        return projectIdList;
    }

    public void setProjectIdList(List<Long> projectIdList) {
        this.projectIdList = projectIdList;
    }

    public Boolean getProjectNeeded() {
        return projectNeeded;
    }

    public void setProjectNeeded(Boolean projectNeeded) {
        this.projectNeeded = projectNeeded;
    }

}
package com.vme.precast.report.api;

import java.util.List;

import coliseum.service.BaseSearchDTO;

public class ReportSearchDTO extends BaseSearchDTO {

    private static final long serialVersionUID = 1L;
    private List<Long> projectIdList;
    private List<Long> elementIdList;
    private List<Long> elementTypeIdList;

    public List<Long> getProjectIdList() {
        return projectIdList;
    }

    public void setProjectIdList(List<Long> projectIdList) {
        this.projectIdList = projectIdList;
    }

    public List<Long> getElementIdList() {
        return elementIdList;
    }

    public void setElementIdList(List<Long> elementIdList) {
        this.elementIdList = elementIdList;
    }

    public List<Long> getElementTypeIdList() {
        return elementTypeIdList;
    }

    public void setElementTypeIdList(List<Long> elementTypeIdList) {
        this.elementTypeIdList = elementTypeIdList;
    }

}
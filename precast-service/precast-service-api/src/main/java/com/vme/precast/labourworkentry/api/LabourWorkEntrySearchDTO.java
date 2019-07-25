package com.vme.precast.labourworkentry.api;

import java.util.List;

import coliseum.service.BaseSearchDTO;

public class LabourWorkEntrySearchDTO extends BaseSearchDTO {

    private static final long serialVersionUID = 1L;
    private List<Long> idList;
    private List<String> workTypeList;
    private List<String> workDescList;
    private List<Double> quantityList;
    private List<String> unitList;
    private List<Long> subContractorIdList;
    private List<Long> projectIdList;
    private List<Long> elementTypeIdList;

    public static String ID = "id";
    public static String WORKTYPE = "workType";
    public static String WORKDESC = "workDesc";
    public static String QUANTITY = "quantity";
    public static String UNIT = "unit";
    public static String SUBCONTRACTOR = "subContractor";
    public static String SUBCONTRACTORID = "subContractorId";
    public static String PROJECT = "project";
    public static String PROJECTID = "projectId";
    public static String ELEMENTTYPE = "elementType";
    public static String ELEMENTTYPEID = "elementTypeId";

    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
    }

    public List<String> getWorkTypeList() {
        return workTypeList;
    }

    public void setWorkTypeList(List<String> workTypeList) {
        this.workTypeList = workTypeList;
    }

    public List<String> getWorkDescList() {
        return workDescList;
    }

    public void setWorkDescList(List<String> workDescList) {
        this.workDescList = workDescList;
    }

    public List<Double> getQuantityList() {
        return quantityList;
    }

    public void setQuantityList(List<Double> quantityList) {
        this.quantityList = quantityList;
    }

    public List<String> getUnitList() {
        return unitList;
    }

    public void setUnitList(List<String> unitList) {
        this.unitList = unitList;
    }

    public List<Long> getSubContractorIdList() {
        return subContractorIdList;
    }

    public void setSubContractorIdList(List<Long> subContractorIdList) {
        this.subContractorIdList = subContractorIdList;
    }

    public List<Long> getProjectIdList() {
        return projectIdList;
    }

    public void setProjectIdList(List<Long> projectIdList) {
        this.projectIdList = projectIdList;
    }

    public List<Long> getElementTypeIdList() {
        return elementTypeIdList;
    }

    public void setElementTypeIdList(List<Long> elementTypeIdList) {
        this.elementTypeIdList = elementTypeIdList;
    }
}
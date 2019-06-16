package com.vme.precast.costcentre.api;

import java.util.List;

import coliseum.service.BaseSearchDTO;

public class CostCentreSearchDTO extends BaseSearchDTO {

    private static final long serialVersionUID = 1L;
    private List<Long> idList;
    private List<String> nameList;

    public static String ID = "id";
    public static String NAME = "name";

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
}
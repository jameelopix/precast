package com.vme.precast.rawmaterial.api;

import java.util.List;

import coliseum.service.BaseSearchDTO;

public class RawMaterialSearchDTO extends BaseSearchDTO {

    private static final long serialVersionUID = 1L;
    private List<Long> idList;
    private List<String> nameList;
    private List<String> typeList;
    private List<String> unitList;

    public static String ID = "id";
    public static String NAME = "name";
    public static String TYPE = "type";
    public static String UNIT = "unit";

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

    public List<String> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<String> typeList) {
        this.typeList = typeList;
    }

    public List<String> getUnitList() {
        return unitList;
    }

    public void setUnitList(List<String> unitList) {
        this.unitList = unitList;
    }

}
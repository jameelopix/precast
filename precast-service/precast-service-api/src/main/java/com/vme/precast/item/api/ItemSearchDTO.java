package com.vme.precast.item.api;

import java.util.List;

import com.vme.precast.shared.UnitType;

import coliseum.service.BaseSearchDTO;

public class ItemSearchDTO extends BaseSearchDTO {

    private static final long serialVersionUID = 1L;
    private List<Long> idList;
    private List<String> nameList;
    private List<String> categoryList;
    private List<UnitType> unitTypeList;

    public static String ID = "id";
    public static String NAME = "name";
    public static String CATEGORY = "category";
    public static String UNITTYPE = "unitType";

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

    public List<String> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<String> categoryList) {
        this.categoryList = categoryList;
    }

    public List<UnitType> getUnitTypeList() {
        return unitTypeList;
    }

    public void setUnitTypeList(List<UnitType> unitTypeList) {
        this.unitTypeList = unitTypeList;
    }
}
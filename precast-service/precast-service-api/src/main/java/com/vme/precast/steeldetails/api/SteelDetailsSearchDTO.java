package com.vme.precast.steeldetails.api;

import java.util.List;

import com.vme.precast.element.api.ElementDTO;

import coliseum.service.BaseSearchDTO;

public class SteelDetailsSearchDTO extends BaseSearchDTO {

    private static final long serialVersionUID = 1L;
    private List<Long> idList;
    private List<String> rawMaterialNameList;
    private List<String> unitList;
    private List<Double> theoriticalQuantityList;
    private List<Double> actualQuantityList;
    private List<ElementDTO> elementDTOList;
    private List<Long> elementIdList;

    private Boolean elementNeeded;

    public static String ID = "id";
    public static String RAWMATERIALNAME = "rawMaterialName";
    public static String UNIT = "unit";
    public static String THEORITICALQUANTITY = "theoriticalQuantity";
    public static String ACTUALQUANTITY = "actualQuantity";
    public static String ELEMENT = "element";
    public static String ELEMENTID = "element.id";

    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
    }

    public List<String> getRawMaterialNameList() {
        return rawMaterialNameList;
    }

    public void setRawMaterialNameList(List<String> rawMaterialNameList) {
        this.rawMaterialNameList = rawMaterialNameList;
    }

    public List<String> getUnitList() {
        return unitList;
    }

    public void setUnitList(List<String> unitList) {
        this.unitList = unitList;
    }

    public List<Double> getTheoriticalQuantityList() {
        return theoriticalQuantityList;
    }

    public void setTheoriticalQuantityList(List<Double> theoriticalQuantityList) {
        this.theoriticalQuantityList = theoriticalQuantityList;
    }

    public List<Double> getActualQuantityList() {
        return actualQuantityList;
    }

    public void setActualQuantityList(List<Double> actualQuantityList) {
        this.actualQuantityList = actualQuantityList;
    }

    public List<ElementDTO> getElementDTOList() {
        return elementDTOList;
    }

    public void setElementDTOList(List<ElementDTO> elementDTOList) {
        this.elementDTOList = elementDTOList;
    }

    public Boolean getElementNeeded() {
        return elementNeeded;
    }

    public void setElementNeeded(Boolean elementNeeded) {
        this.elementNeeded = elementNeeded;
    }

    public List<Long> getElementIdList() {
        return elementIdList;
    }

    public void setElementIdList(List<Long> elementIdList) {
        this.elementIdList = elementIdList;
    }
}
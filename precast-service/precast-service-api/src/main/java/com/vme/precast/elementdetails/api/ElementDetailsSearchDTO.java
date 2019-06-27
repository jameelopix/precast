package com.vme.precast.elementdetails.api;

import java.util.List;

import com.vme.precast.element.api.ElementDTO;

import coliseum.service.BaseSearchDTO;

public class ElementDetailsSearchDTO extends BaseSearchDTO {

    private static final long serialVersionUID = 1L;
    private List<Long> idList;
    private List<String> mixDesignNameList;
    private List<Double> weightList;
    private List<Double> lengthList;
    private List<Double> widthList;
    private List<Double> thicknessList;
    private List<ElementDTO> elementDTOList;
    private List<Long> elementIdList;

    public static String ID = "id";
    public static String MIXDESIGNNAME = "mixDesignName";
    public static String WEIGHT = "weight";
    public static String LENGTH = "length";
    public static String WIDTH = "width";
    public static String THICKNESS = "thickness";
    public static String ELEMENT = "element";
    public static String ELEMENTID = "element.id";

    public List<Double> getWidthList() {
        return widthList;
    }

    public void setWidthList(List<Double> widthList) {
        this.widthList = widthList;
    }

    public List<Double> getThicknessList() {
        return thicknessList;
    }

    public void setThicknessList(List<Double> thicknessList) {
        this.thicknessList = thicknessList;
    }

    public List<ElementDTO> getElementDTOList() {
        return elementDTOList;
    }

    public void setElementDTOList(List<ElementDTO> elementDTOList) {
        this.elementDTOList = elementDTOList;
    }

    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
    }

    public List<String> getMixDesignNameList() {
        return mixDesignNameList;
    }

    public void setMixDesignNameList(List<String> mixDesignNameList) {
        this.mixDesignNameList = mixDesignNameList;
    }

    public List<Long> getElementIdList() {
        return elementIdList;
    }

    public void setElementIdList(List<Long> elementIdList) {
        this.elementIdList = elementIdList;
    }

    public List<Double> getWeightList() {
        return weightList;
    }

    public void setWeightList(List<Double> weightList) {
        this.weightList = weightList;
    }

    public List<Double> getLengthList() {
        return lengthList;
    }

    public void setLengthList(List<Double> lengthList) {
        this.lengthList = lengthList;
    }

}
package com.vme.precast.mixtureitem.api;

import java.util.List;

import com.vme.precast.mixture.api.MixtureDTO;

import coliseum.service.BaseSearchDTO;

public class MixtureItemSearchDTO extends BaseSearchDTO {

    private static final long serialVersionUID = 1L;
    private List<Long> idList;
    private List<MixtureDTO> mixtureDTOList;
    private List<Long> mixtureDTOIdList;
    private List<String> rawMaterialNameList;
    private List<String> unitList;
    private List<Double> quantityList;

    public static String ID = "id";
    public static String MIXTURE = "mixture";
    public static String MIXTUREID = "mixture.id";
    public static String RAWMATERIALNAME = "rawMaterialName";
    public static String UNIT = "unit";
    public static String QUANTITY = "quantity";

    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
    }

    public List<MixtureDTO> getMixtureDTOList() {
        return mixtureDTOList;
    }

    public void setMixtureDTOList(List<MixtureDTO> mixtureDTOList) {
        this.mixtureDTOList = mixtureDTOList;
    }

    public List<Long> getMixtureDTOIdList() {
        return mixtureDTOIdList;
    }

    public void setMixtureDTOIdList(List<Long> mixtureDTOIdList) {
        this.mixtureDTOIdList = mixtureDTOIdList;
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

    public List<Double> getQuantityList() {
        return quantityList;
    }

    public void setQuantityList(List<Double> quantityList) {
        this.quantityList = quantityList;
    }

}
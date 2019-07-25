package com.vme.precast.address.api;

import java.util.List;

import coliseum.service.BaseSearchDTO;

public class AddressSearchDTO extends BaseSearchDTO {

    private static final long serialVersionUID = 1L;
    private List<Long> idList;
    private List<String> addressLine1List;
    private List<String> addressLine2List;
    private List<String> landmarkList;
    private List<String> cityList;
    private List<String> stateList;
    private List<String> countryList;
    private List<String> mobNoList;
    private List<String> pincodeList;

    public static String ID = "id";
    public static String ADDRESSLINE1 = "addressLine1";
    public static String ADDRESSLINE2 = "addressLine2";
    public static String LANDMARK = "landmark";
    public static String CITY = "city";
    public static String STATE = "state";
    public static String COUNTRY = "country";
    public static String MOBNO = "mobNo";
    public static String PINCODE = "pincode";

    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
    }

    public List<String> getAddressLine1List() {
        return addressLine1List;
    }

    public void setAddressLine1List(List<String> addressLine1List) {
        this.addressLine1List = addressLine1List;
    }

    public List<String> getAddressLine2List() {
        return addressLine2List;
    }

    public void setAddressLine2List(List<String> addressLine2List) {
        this.addressLine2List = addressLine2List;
    }

    public List<String> getLandmarkList() {
        return landmarkList;
    }

    public void setLandmarkList(List<String> landmarkList) {
        this.landmarkList = landmarkList;
    }

    public List<String> getCityList() {
        return cityList;
    }

    public void setCityList(List<String> cityList) {
        this.cityList = cityList;
    }

    public List<String> getStateList() {
        return stateList;
    }

    public void setStateList(List<String> stateList) {
        this.stateList = stateList;
    }

    public List<String> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<String> countryList) {
        this.countryList = countryList;
    }

    public List<String> getMobNoList() {
        return mobNoList;
    }

    public void setMobNoList(List<String> mobNoList) {
        this.mobNoList = mobNoList;
    }

    public List<String> getPincodeList() {
        return pincodeList;
    }

    public void setPincodeList(List<String> pincodeList) {
        this.pincodeList = pincodeList;
    }

}
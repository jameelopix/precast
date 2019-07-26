package com.vme.precast.subcontractor.api;

import java.util.List;

import coliseum.service.BaseSearchDTO;

public class SubContractorSearchDTO extends BaseSearchDTO {

    private static final long serialVersionUID = 1L;
    private List<Long> idList;
    private List<String> codeList;
    private List<String> nameList;
    private List<Boolean> activeList;
    private List<Long> financialDetailIdList;
    private List<Long> addressIdList;

    public static String ID = "id";
    public static String NAME = "name";
    public static String CODE = "code";
    public static String ACTIVE = "active";
    public static String FINANCIALDETAIL = "financialDetail";
    public static String FINANCIALDETAILID = "financialDetailId";
    public static String ADDRESS = "address";
    public static String ADDRESSID = "addressId";

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

    public List<Boolean> getActiveList() {
        return activeList;
    }

    public void setActiveList(List<Boolean> activeList) {
        this.activeList = activeList;
    }

    public List<Long> getFinancialDetailIdList() {
        return financialDetailIdList;
    }

    public void setFinancialDetailIdList(List<Long> financialDetailIdList) {
        this.financialDetailIdList = financialDetailIdList;
    }

    public List<Long> getAddressIdList() {
        return addressIdList;
    }

    public void setAddressIdList(List<Long> addressIdList) {
        this.addressIdList = addressIdList;
    }

    public List<String> getCodeList() {
        return codeList;
    }

    public void setCodeList(List<String> codeList) {
        this.codeList = codeList;
    }
}
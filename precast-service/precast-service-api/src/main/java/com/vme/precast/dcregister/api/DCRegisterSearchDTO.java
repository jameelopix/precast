package com.vme.precast.dcregister.api;

import java.util.List;

import coliseum.service.BaseSearchDTO;

public class DCRegisterSearchDTO extends BaseSearchDTO {

    private static final long serialVersionUID = 1L;
    private List<Long> idList;
    private List<String> dcNoList;
    private List<String> grnNoList;
    private List<Long> vendorIdList;

    private Boolean vendorNeeded = false;

    public static String ID = "id";
    public static String VENDOR = "vendor";
    public static String DCNO = "dcNo";
    public static String GRNNO = "grnNo";
    public static String VENDORID = "vendorId";

    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
    }

    public List<String> getDcNoList() {
        return dcNoList;
    }

    public void setDcNoList(List<String> dcNoList) {
        this.dcNoList = dcNoList;
    }

    public List<String> getGrnNoList() {
        return grnNoList;
    }

    public void setGrnNoList(List<String> grnNoList) {
        this.grnNoList = grnNoList;
    }

    public List<Long> getVendorIdList() {
        return vendorIdList;
    }

    public void setVendorIdList(List<Long> vendorIdList) {
        this.vendorIdList = vendorIdList;
    }

    public Boolean getVendorNeeded() {
        return vendorNeeded;
    }

    public void setVendorNeeded(Boolean vendorNeeded) {
        this.vendorNeeded = vendorNeeded;
    }
}
package com.vme.precast.purchaseregister.api;

import java.util.List;

import coliseum.service.BaseSearchDTO;

public class PurchaseRegisterSearchDTO extends BaseSearchDTO {

    private static final long serialVersionUID = 1L;
    private List<Long> idList;
    private List<Long> vendorIdList;
    private List<String> weighBridgeNoList;

    private boolean vendorNeeded;

    public static String ID = "id";
    public static String VENDORID = "vendor.id";
    public static String VENDOR = "vendor";
    public static String WEIGHBRIDGENO = "weighBridgeNo";

    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
    }

    public List<String> getWeighBridgeNoList() {
        return weighBridgeNoList;
    }

    public void setWeighBridgeNoList(List<String> weighBridgeNoList) {
        this.weighBridgeNoList = weighBridgeNoList;
    }

    public List<Long> getVendorIdList() {
        return vendorIdList;
    }

    public void setVendorIdList(List<Long> vendorIdList) {
        this.vendorIdList = vendorIdList;
    }

    public boolean isVendorNeeded() {
        return vendorNeeded;
    }

    public void setVendorNeeded(boolean vendorNeeded) {
        this.vendorNeeded = vendorNeeded;
    }
}
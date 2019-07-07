package com.vme.precast.purchaseorder.api;

import java.util.Date;
import java.util.List;

import com.vme.precast.shared.PurchaseOrderStatus;
import com.vme.precast.vendor.api.VendorDTO;

import coliseum.service.BaseSearchDTO;

public class PurchaseOrderSearchDTO extends BaseSearchDTO {

    private static final long serialVersionUID = 1L;
    private List<Long> idList;
    private List<String> purchaseOrderNoList;
    private List<VendorDTO> vendorDTOList;
    private List<Long> vendorDTOIdList;
    private List<Date> purchaseDateList;
    private List<PurchaseOrderStatus> purchaseOrderStatusList;

    private Boolean vendorNeeded;
    
    public static String ID = "id";
    public static String PURCHASEORDERNO = "purchaseOrderNo";
    public static String VENDOR = "vendor";
    public static String VENDORID = "vendor.id";
    public static String PURCHASEDATE = "purchaseDate";
    public static String PURCHASEORDERSTATUS = "purchaseOrderStatus";

    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
    }

    public List<String> getPurchaseOrderNoList() {
        return purchaseOrderNoList;
    }

    public void setPurchaseOrderNoList(List<String> purchaseOrderNoList) {
        this.purchaseOrderNoList = purchaseOrderNoList;
    }

    public List<VendorDTO> getVendorDTOList() {
        return vendorDTOList;
    }

    public void setVendorDTOList(List<VendorDTO> vendorDTOList) {
        this.vendorDTOList = vendorDTOList;
    }

    public List<Long> getVendorDTOIdList() {
        return vendorDTOIdList;
    }

    public void setVendorDTOIdList(List<Long> vendorDTOIdList) {
        this.vendorDTOIdList = vendorDTOIdList;
    }

    public List<Date> getPurchaseDateList() {
        return purchaseDateList;
    }

    public void setPurchaseDateList(List<Date> purchaseDateList) {
        this.purchaseDateList = purchaseDateList;
    }

    public List<PurchaseOrderStatus> getPurchaseOrderStatusList() {
        return purchaseOrderStatusList;
    }

    public void setPurchaseOrderStatusList(List<PurchaseOrderStatus> purchaseOrderStatusList) {
        this.purchaseOrderStatusList = purchaseOrderStatusList;
    }

    public Boolean getVendorNeeded() {
        return vendorNeeded;
    }

    public void setVendorNeeded(Boolean vendorNeeded) {
        this.vendorNeeded = vendorNeeded;
    }

}
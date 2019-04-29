package com.vme.precast.purchaseorder.api;

import java.util.Date;
import java.util.List;

import com.vme.precast.shared.PurchaseOrderStatus;

import coliseum.service.BaseSearchDTO;

public class PurchaseOrderSearchDTO extends BaseSearchDTO {

    private static final long serialVersionUID = 1L;
    private List<Long> idList;
    private List<String> purchaseOrderNoList;
    private List<Date> purchaseDateList;
    private List<PurchaseOrderStatus> purchaseOrderStatusList;

    public static String ID = "id";
    public static String PURCHASEORDERNO = "purchaseOrderNo";
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
}
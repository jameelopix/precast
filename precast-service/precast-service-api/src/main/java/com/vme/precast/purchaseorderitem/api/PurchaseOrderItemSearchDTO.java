package com.vme.precast.purchaseorderitem.api;

import java.util.List;

import com.vme.precast.purchaseorder.api.PurchaseOrderDTO;

import coliseum.service.BaseSearchDTO;

public class PurchaseOrderItemSearchDTO extends BaseSearchDTO {

    private static final long serialVersionUID = 1L;
    private List<Long> idList;
    private List<String> itemNameList;
    private List<String> unitList;
    private List<Double> quantityList;
    private List<Double> rateList;
    private List<PurchaseOrderDTO> purchaseOrderDTOList;
    private List<Long> purchaseOrderDTOIdList;

    public static String ID = "id";
    public static String ITEMNAME = "itemName";
    public static String UNIT = "unit";
    public static String QUANTITY = "quantity";
    public static String RATE = "rate";
    public static String PURCHASEORDER = "purchaseOrder";
    public static String PURCHASEORDERID = "purchaseOrder.id";

    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
    }

    public List<String> getItemNameList() {
        return itemNameList;
    }

    public void setItemNameList(List<String> itemNameList) {
        this.itemNameList = itemNameList;
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

    public List<Double> getRateList() {
        return rateList;
    }

    public void setRateList(List<Double> rateList) {
        this.rateList = rateList;
    }

    public List<PurchaseOrderDTO> getPurchaseOrderDTOList() {
        return purchaseOrderDTOList;
    }

    public void setPurchaseOrderDTOList(List<PurchaseOrderDTO> purchaseOrderDTOList) {
        this.purchaseOrderDTOList = purchaseOrderDTOList;
    }

    public List<Long> getPurchaseOrderDTOIdList() {
        return purchaseOrderDTOIdList;
    }

    public void setPurchaseOrderDTOIdList(List<Long> purchaseOrderDTOIdList) {
        this.purchaseOrderDTOIdList = purchaseOrderDTOIdList;
    }
}
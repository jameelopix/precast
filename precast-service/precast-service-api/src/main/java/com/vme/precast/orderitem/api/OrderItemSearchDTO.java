package com.vme.precast.orderitem.api;

import java.util.List;

import com.vme.precast.purchaseorder.api.PurchaseOrderDTO;
import com.vme.precast.shared.UnitType;

import coliseum.service.BaseSearchDTO;

public class OrderItemSearchDTO extends BaseSearchDTO {

    private static final long serialVersionUID = 1L;
    private List<Long> idList;
    private List<String> itemNameList;
    private List<Double> quantityList;
    private List<Double> rateList;
    private List<UnitType> unitTypeList;
    private List<PurchaseOrderDTO> purchaseOrderDTOList;
    private List<Long> purchaseOrderIdList;
    private Boolean purchaseOrderNeeded = false;

    public static String ID = "id";
    public static String ITEMNAME = "itemName";
    public static String QUANTITY = "quantity";
    public static String RATE = "rate";
    public static String UNITTYPE = "unitType";
    public static String PURCHASEORDER = "purchaseOrder";
    public static String PURCHASEORDERID = "purchaseOrderId";

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

    public List<UnitType> getUnitTypeList() {
        return unitTypeList;
    }

    public void setUnitTypeList(List<UnitType> unitTypeList) {
        this.unitTypeList = unitTypeList;
    }

    public List<Long> getPurchaseOrderIdList() {
        return purchaseOrderIdList;
    }

    public void setPurchaseOrderIdList(List<Long> purchaseOrderIdList) {
        this.purchaseOrderIdList = purchaseOrderIdList;
    }

    public List<PurchaseOrderDTO> getPurchaseOrderDTOList() {
        return purchaseOrderDTOList;
    }

    public void setPurchaseOrderDTOList(List<PurchaseOrderDTO> purchaseOrderDTOList) {
        this.purchaseOrderDTOList = purchaseOrderDTOList;
    }

    public Boolean getPurchaseOrderNeeded() {
        return purchaseOrderNeeded;
    }

    public void setPurchaseOrderNeeded(Boolean purchaseOrderNeeded) {
        this.purchaseOrderNeeded = purchaseOrderNeeded;
    }
}
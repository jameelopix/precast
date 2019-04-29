package com.vme.precast.dcitem.api;

import java.util.List;

import coliseum.service.BaseSearchDTO;

public class DCItemSearchDTO extends BaseSearchDTO {

    private static final long serialVersionUID = 1L;
    private List<Long> idList;
    private List<Double> vendorQuantityList;
    private List<Double> weighBridgeQuantityList;
    private List<Double> deductionQuantityList;
    private List<Double> netQuantityList;
    private List<Long> orderItemIdList;
    private List<Long> dcRegisterIdList;

    public static String ID = "id";
    public static String DCREGISTER = "dcRegister";
    public static String ORDERITEM = "orderItem";
    public static String VENDORQUANTITY = "vendorQuantity";
    public static String WEIGHBRIDGEQUANTITY = "weighBridgeQuantity";
    public static String DEDUCTIONQUANTITY = "deductionQuantity";
    public static String NETQUANTITY = "netQuantity";
    public static String ORDERITEMID = "orderItemId";
    public static String DCREGISTERID = "dcRegisterId";

    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
    }

    public List<Double> getVendorQuantityList() {
        return vendorQuantityList;
    }

    public void setVendorQuantityList(List<Double> vendorQuantityList) {
        this.vendorQuantityList = vendorQuantityList;
    }

    public List<Double> getWeighBridgeQuantityList() {
        return weighBridgeQuantityList;
    }

    public void setWeighBridgeQuantityList(List<Double> weighBridgeQuantityList) {
        this.weighBridgeQuantityList = weighBridgeQuantityList;
    }

    public List<Double> getDeductionQuantityList() {
        return deductionQuantityList;
    }

    public void setDeductionQuantityList(List<Double> deductionQuantityList) {
        this.deductionQuantityList = deductionQuantityList;
    }

    public List<Double> getNetQuantityList() {
        return netQuantityList;
    }

    public void setNetQuantityList(List<Double> netQuantityList) {
        this.netQuantityList = netQuantityList;
    }

    public List<Long> getOrderItemIdList() {
        return orderItemIdList;
    }

    public void setOrderItemIdList(List<Long> orderItemIdList) {
        this.orderItemIdList = orderItemIdList;
    }

    public List<Long> getDcRegisterIdList() {
        return dcRegisterIdList;
    }

    public void setDcRegisterIdList(List<Long> dcRegisterIdList) {
        this.dcRegisterIdList = dcRegisterIdList;
    }

}
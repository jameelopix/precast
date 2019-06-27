package com.vme.precast.purchaseregisteritem.api;

import java.util.List;

import com.vme.precast.purchaseorderitem.api.PurchaseOrderItemDTO;
import com.vme.precast.purchaseregister.api.PurchaseRegisterDTO;

import coliseum.service.BaseSearchDTO;

public class PurchaseRegisterItemSearchDTO extends BaseSearchDTO {

    private static final long serialVersionUID = 1L;
    private List<Long> idList;
    private List<PurchaseRegisterDTO> purchaseRegisterDTOList;
    private List<Long> purchaseRegisterDTOIdList;
    private List<PurchaseOrderItemDTO> purchaseOrderItemDTOList;
    private List<Long> purchaseOrderItemIdDTOList;
    private List<Double> dcQuantityList;
    private List<String> dcUnitList;
    private List<Double> weighBridgeQuantityList;
    private List<String> weighBridgeUnitList;
    private List<Double> deductionQuantityList;
    private List<String> deductionUnitList;
    private List<Double> netQuantityList;
    private List<String> netUnitList;

    public static String ID = "id";
    public static String PURCHASEREGISTER = "purchaseRegister";
    public static String PURCHASEREGISTERID = "purchaseRegister.id";
    public static String PURCHASEORDERITEM = "purchaseOrderItem";
    public static String PURCHASEORDERITEMID = "purchaseOrderItem.id";
    public static String DCQUANTITY = "dcQuantity";
    public static String DCUNIT = "dcUnit";
    public static String WEIGHBRIDGEQUANTITY = "weighBridgeQuantity";
    public static String WEIGHBRIDGEUNIT = "weighBridgeUnit";
    public static String DEDUCTIONQUANTITY = "deductionQuantity";
    public static String DEDUCTIONUNIT = "deductionUnit";
    public static String NETQUANTITY = "netQuantity";
    public static String NETUNIT = "netUnit";

    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
    }

    public List<PurchaseRegisterDTO> getPurchaseRegisterDTOList() {
        return purchaseRegisterDTOList;
    }

    public void setPurchaseRegisterDTOList(List<PurchaseRegisterDTO> purchaseRegisterDTOList) {
        this.purchaseRegisterDTOList = purchaseRegisterDTOList;
    }

    public List<Long> getPurchaseRegisterDTOIdList() {
        return purchaseRegisterDTOIdList;
    }

    public void setPurchaseRegisterDTOIdList(List<Long> purchaseRegisterDTOIdList) {
        this.purchaseRegisterDTOIdList = purchaseRegisterDTOIdList;
    }

    public List<PurchaseOrderItemDTO> getPurchaseOrderItemDTOList() {
        return purchaseOrderItemDTOList;
    }

    public void setPurchaseOrderItemDTOList(List<PurchaseOrderItemDTO> purchaseOrderItemDTOList) {
        this.purchaseOrderItemDTOList = purchaseOrderItemDTOList;
    }

    public List<Long> getPurchaseOrderItemIdDTOList() {
        return purchaseOrderItemIdDTOList;
    }

    public void setPurchaseOrderItemIdDTOList(List<Long> purchaseOrderItemIdDTOList) {
        this.purchaseOrderItemIdDTOList = purchaseOrderItemIdDTOList;
    }

    public List<Double> getDcQuantityList() {
        return dcQuantityList;
    }

    public void setDcQuantityList(List<Double> dcQuantityList) {
        this.dcQuantityList = dcQuantityList;
    }

    public List<String> getDcUnitList() {
        return dcUnitList;
    }

    public void setDcUnitList(List<String> dcUnitList) {
        this.dcUnitList = dcUnitList;
    }

    public List<Double> getWeighBridgeQuantityList() {
        return weighBridgeQuantityList;
    }

    public void setWeighBridgeQuantityList(List<Double> weighBridgeQuantityList) {
        this.weighBridgeQuantityList = weighBridgeQuantityList;
    }

    public List<String> getWeighBridgeUnitList() {
        return weighBridgeUnitList;
    }

    public void setWeighBridgeUnitList(List<String> weighBridgeUnitList) {
        this.weighBridgeUnitList = weighBridgeUnitList;
    }

    public List<Double> getDeductionQuantityList() {
        return deductionQuantityList;
    }

    public void setDeductionQuantityList(List<Double> deductionQuantityList) {
        this.deductionQuantityList = deductionQuantityList;
    }

    public List<String> getDeductionUnitList() {
        return deductionUnitList;
    }

    public void setDeductionUnitList(List<String> deductionUnitList) {
        this.deductionUnitList = deductionUnitList;
    }

    public List<Double> getNetQuantityList() {
        return netQuantityList;
    }

    public void setNetQuantityList(List<Double> netQuantityList) {
        this.netQuantityList = netQuantityList;
    }

    public List<String> getNetUnitList() {
        return netUnitList;
    }

    public void setNetUnitList(List<String> netUnitList) {
        this.netUnitList = netUnitList;
    }
}
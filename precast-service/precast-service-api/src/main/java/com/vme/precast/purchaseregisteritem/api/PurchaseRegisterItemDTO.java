package com.vme.precast.purchaseregisteritem.api;

import com.vme.precast.purchaseorderitem.api.PurchaseOrderItemDTO;
import com.vme.precast.purchaseregister.api.PurchaseRegisterDTO;

import coliseum.service.BaseDTO;

public class PurchaseRegisterItemDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;
    private Long id;
    private PurchaseRegisterDTO purchaseRegisterDTO;
    private Long purchaseRegisterDTOId;
    private PurchaseOrderItemDTO purchaseOrderItemDTO;
    private Long purchaseOrderItemDTOId;
    private Double dcQuantity;
    private String dcUnit;
    private Double weighBridgeQuantity;
    private String weighBridgeUnit;
    private Double deductionQuantity;
    private String deductionUnit;
    private Double netQuantity;
    private String netUnit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PurchaseRegisterDTO getPurchaseRegisterDTO() {
        return purchaseRegisterDTO;
    }

    public void setPurchaseRegisterDTO(PurchaseRegisterDTO purchaseRegisterDTO) {
        this.purchaseRegisterDTO = purchaseRegisterDTO;
    }

    public Long getPurchaseRegisterDTOId() {
        return purchaseRegisterDTOId;
    }

    public void setPurchaseRegisterDTOId(Long purchaseRegisterDTOId) {
        this.purchaseRegisterDTOId = purchaseRegisterDTOId;
    }

    public PurchaseOrderItemDTO getPurchaseOrderItemDTO() {
        return purchaseOrderItemDTO;
    }

    public void setPurchaseOrderItemDTO(PurchaseOrderItemDTO purchaseOrderItemDTO) {
        this.purchaseOrderItemDTO = purchaseOrderItemDTO;
    }

    public Long getPurchaseOrderItemDTOId() {
        return purchaseOrderItemDTOId;
    }

    public void setPurchaseOrderItemDTOId(Long purchaseOrderItemDTOId) {
        this.purchaseOrderItemDTOId = purchaseOrderItemDTOId;
    }

    public Double getDcQuantity() {
        return dcQuantity;
    }

    public void setDcQuantity(Double dcQuantity) {
        this.dcQuantity = dcQuantity;
    }

    public String getDcUnit() {
        return dcUnit;
    }

    public void setDcUnit(String dcUnit) {
        this.dcUnit = dcUnit;
    }

    public Double getWeighBridgeQuantity() {
        return weighBridgeQuantity;
    }

    public void setWeighBridgeQuantity(Double weighBridgeQuantity) {
        this.weighBridgeQuantity = weighBridgeQuantity;
    }

    public String getWeighBridgeUnit() {
        return weighBridgeUnit;
    }

    public void setWeighBridgeUnit(String weighBridgeUnit) {
        this.weighBridgeUnit = weighBridgeUnit;
    }

    public Double getDeductionQuantity() {
        return deductionQuantity;
    }

    public void setDeductionQuantity(Double deductionQuantity) {
        this.deductionQuantity = deductionQuantity;
    }

    public String getDeductionUnit() {
        return deductionUnit;
    }

    public void setDeductionUnit(String deductionUnit) {
        this.deductionUnit = deductionUnit;
    }

    public Double getNetQuantity() {
        return netQuantity;
    }

    public void setNetQuantity(Double netQuantity) {
        this.netQuantity = netQuantity;
    }

    public String getNetUnit() {
        return netUnit;
    }

    public void setNetUnit(String netUnit) {
        this.netUnit = netUnit;
    }
}
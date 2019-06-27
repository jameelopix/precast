package com.vme.precast.purchaseorderitem.api;

import com.vme.precast.purchaseorder.api.PurchaseOrderDTO;

import coliseum.service.BaseDTO;

public class PurchaseOrderItemDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String itemName;
    private String unit;
    private Double quantity;
    private Double rate;
    private PurchaseOrderDTO purchaseOrderDTO;
    private Long purchaseOrderDTOId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public PurchaseOrderDTO getPurchaseOrderDTO() {
        return purchaseOrderDTO;
    }

    public void setPurchaseOrderDTO(PurchaseOrderDTO purchaseOrderDTO) {
        this.purchaseOrderDTO = purchaseOrderDTO;
    }

    public Long getPurchaseOrderDTOId() {
        return purchaseOrderDTOId;
    }

    public void setPurchaseOrderDTOId(Long purchaseOrderDTOId) {
        this.purchaseOrderDTOId = purchaseOrderDTOId;
    }
}
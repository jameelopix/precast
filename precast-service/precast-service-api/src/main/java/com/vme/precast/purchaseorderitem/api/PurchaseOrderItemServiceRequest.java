package com.vme.precast.purchaseorderitem.api;

import com.vme.precast.purchaseorder.api.PurchaseOrderServiceRequest;

import coliseum.service.BaseServiceRequest;

public class PurchaseOrderItemServiceRequest extends BaseServiceRequest {

    private static final long serialVersionUID = 1L;

    private PurchaseOrderItemDTO purchaseOrderItemDTO;

    private PurchaseOrderItemSearchDTO purchaseOrderItemSearchDTO;

    private PurchaseOrderServiceRequest purchaseOrderServiceRequest;

    public PurchaseOrderItemDTO getPurchaseOrderItemDTO() {
        return purchaseOrderItemDTO;
    }

    public void setPurchaseOrderItemDTO(PurchaseOrderItemDTO purchaseOrderItemDTO) {
        this.purchaseOrderItemDTO = purchaseOrderItemDTO;
    }

    public PurchaseOrderItemSearchDTO getPurchaseOrderItemSearchDTO() {
        return purchaseOrderItemSearchDTO;
    }

    public void setPurchaseOrderItemSearchDTO(PurchaseOrderItemSearchDTO purchaseOrderItemSearchDTO) {
        this.purchaseOrderItemSearchDTO = purchaseOrderItemSearchDTO;
    }

    public PurchaseOrderServiceRequest getPurchaseOrderServiceRequest() {
        return purchaseOrderServiceRequest;
    }

    public void setPurchaseOrderServiceRequest(PurchaseOrderServiceRequest purchaseOrderServiceRequest) {
        this.purchaseOrderServiceRequest = purchaseOrderServiceRequest;
    }
}

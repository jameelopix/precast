package com.vme.precast.orderitem.api;

import com.vme.precast.purchaseorder.api.PurchaseOrderServiceRequest;

import coliseum.service.BaseServiceRequest;

public class OrderItemServiceRequest extends BaseServiceRequest {

    private static final long serialVersionUID = 1L;

    private OrderItemDTO orderItemDTO;

    private OrderItemSearchDTO orderItemSearchDTO;

    private PurchaseOrderServiceRequest purchaseOrderServiceRequest;

    public OrderItemDTO getOrderItemDTO() {
        return orderItemDTO;
    }

    public void setOrderItemDTO(OrderItemDTO orderItemDTO) {
        this.orderItemDTO = orderItemDTO;
    }

    public OrderItemSearchDTO getOrderItemSearchDTO() {
        return orderItemSearchDTO;
    }

    public void setOrderItemSearchDTO(OrderItemSearchDTO orderItemSearchDTO) {
        this.orderItemSearchDTO = orderItemSearchDTO;
    }

    public PurchaseOrderServiceRequest getPurchaseOrderServiceRequest() {
        return purchaseOrderServiceRequest;
    }

    public void setPurchaseOrderServiceRequest(PurchaseOrderServiceRequest purchaseOrderServiceRequest) {
        this.purchaseOrderServiceRequest = purchaseOrderServiceRequest;
    }
}

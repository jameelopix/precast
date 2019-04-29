package com.vme.precast.dcitem.api;

import com.vme.precast.dcregister.api.DCRegisterDTO;
import com.vme.precast.orderitem.api.OrderItemDTO;

import coliseum.service.BaseDTO;

public class DCItemDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;
    private Long id;
    private DCRegisterDTO dcRegisterDTO;
    private OrderItemDTO orderItemDTO;
    private Double vendorQuantity;
    private Double weighBridgeQuantity;
    private Double deductionQuantity;
    private Double netQuantity;
    private Long orderItemId;
    private Long dcRegisterId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DCRegisterDTO getDcRegisterDTO() {
        return dcRegisterDTO;
    }

    public void setDcRegisterDTO(DCRegisterDTO dcRegisterDTO) {
        this.dcRegisterDTO = dcRegisterDTO;
    }

    public OrderItemDTO getOrderItemDTO() {
        return orderItemDTO;
    }

    public void setOrderItemDTO(OrderItemDTO orderItemDTO) {
        this.orderItemDTO = orderItemDTO;
    }

    public Double getVendorQuantity() {
        return vendorQuantity;
    }

    public void setVendorQuantity(Double vendorQuantity) {
        this.vendorQuantity = vendorQuantity;
    }

    public Double getWeighBridgeQuantity() {
        return weighBridgeQuantity;
    }

    public void setWeighBridgeQuantity(Double weighBridgeQuantity) {
        this.weighBridgeQuantity = weighBridgeQuantity;
    }

    public Double getDeductionQuantity() {
        return deductionQuantity;
    }

    public void setDeductionQuantity(Double deductionQuantity) {
        this.deductionQuantity = deductionQuantity;
    }

    public Double getNetQuantity() {
        return netQuantity;
    }

    public void setNetQuantity(Double netQuantity) {
        this.netQuantity = netQuantity;
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Long getDcRegisterId() {
        return dcRegisterId;
    }

    public void setDcRegisterId(Long dcRegisterId) {
        this.dcRegisterId = dcRegisterId;
    }
}
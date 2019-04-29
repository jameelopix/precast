package com.vme.precast.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import coliseum.jpa.domain.BaseEntity;

@Entity
public class DCItem extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private DCRegister dcRegister;

    @OneToOne(fetch = FetchType.LAZY)
    private OrderItem orderItem;

    private Double vendorQuantity;

    private Double weighBridgeQuantity;

    private Double deductionQuantity;

    private Double netQuantity;

    @Column(insertable = false, updatable = false, name = "orderItem_id")
    private Long orderItemId;

    @Column(insertable = false, updatable = false, name = "dcRegister_id")
    private Long dcRegisterId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DCRegister getDcRegister() {
        return dcRegister;
    }

    public void setDcRegister(DCRegister dcRegister) {
        this.dcRegister = dcRegister;
    }

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
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
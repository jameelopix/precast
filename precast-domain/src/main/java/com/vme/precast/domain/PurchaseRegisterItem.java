package com.vme.precast.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import coliseum.jpa.domain.BaseEntity;

@Entity
public class PurchaseRegisterItem extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private PurchaseRegister purchaseRegister;

    @Column(insertable = false, updatable = false, name = "purchaseRegister_id")
    private Long purchaseRegisterId;

    @ManyToOne(fetch = FetchType.LAZY)
    private PurchaseOrderItem purchaseOrderItem;

    @Column(insertable = false, updatable = false, name = "purchaseOrderItem_id")
    private Long purchaseOrderItemId;

    private Double dcQuantity;
    private String dcUnit;

    private Double weighBridgeQuantity;
    private String weighBridgeUnit;

    private Double deductionQuantity;
    private String deductionUnit;

    private Double netQuantity;
    private String netUnit;

    public PurchaseRegister getPurchaseRegister() {
        return purchaseRegister;
    }

    public void setPurchaseRegister(PurchaseRegister purchaseRegister) {
        this.purchaseRegister = purchaseRegister;
    }

    public Long getPurchaseRegisterId() {
        return purchaseRegisterId;
    }

    public void setPurchaseRegisterId(Long purchaseRegisterId) {
        this.purchaseRegisterId = purchaseRegisterId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PurchaseOrderItem getPurchaseOrderItem() {
        return purchaseOrderItem;
    }

    public void setPurchaseOrderItem(PurchaseOrderItem purchaseOrderItem) {
        this.purchaseOrderItem = purchaseOrderItem;
    }

    public Long getPurchaseOrderItemId() {
        return purchaseOrderItemId;
    }

    public void setPurchaseOrderItemId(Long purchaseOrderItemId) {
        this.purchaseOrderItemId = purchaseOrderItemId;
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
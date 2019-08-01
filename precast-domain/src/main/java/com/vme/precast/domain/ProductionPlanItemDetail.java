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
public class ProductionPlanItemDetail extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProductionPlanItem productionPlanItem;

    @Column(insertable = false, updatable = false, name = "productionPlanItem_id")
    private Long productionPlanItemId;

    private String rawMaterialName;

    private String unit;

    private Double theoriticalQuantity;

    private Double actualQuantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductionPlanItem getProductionPlanItem() {
        return productionPlanItem;
    }

    public void setProductionPlanItem(ProductionPlanItem productionPlanItem) {
        this.productionPlanItem = productionPlanItem;
    }

    public Long getProductionPlanItemId() {
        return productionPlanItemId;
    }

    public void setProductionPlanItemId(Long productionPlanItemId) {
        this.productionPlanItemId = productionPlanItemId;
    }

    public String getRawMaterialName() {
        return rawMaterialName;
    }

    public void setRawMaterialName(String rawMaterialName) {
        this.rawMaterialName = rawMaterialName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getTheoriticalQuantity() {
        return theoriticalQuantity;
    }

    public void setTheoriticalQuantity(Double theoriticalQuantity) {
        this.theoriticalQuantity = theoriticalQuantity;
    }

    public Double getActualQuantity() {
        return actualQuantity;
    }

    public void setActualQuantity(Double actualQuantity) {
        this.actualQuantity = actualQuantity;
    }
}
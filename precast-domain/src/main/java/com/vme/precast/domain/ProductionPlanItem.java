package com.vme.precast.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import coliseum.jpa.domain.BaseEntity;

@Entity
public class ProductionPlanItem extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProductionPlan productionPlan;

    @Column(insertable = false, updatable = false, name = "productionPlan_id")
    private Long productionPlanId;

    private int sequenceOrder;

    @Temporal(TemporalType.DATE)
    private Date castedDate;

    private String disapprovedReason;

    private boolean disapproved;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductionPlan getProductionPlan() {
        return productionPlan;
    }

    public void setProductionPlan(ProductionPlan productionPlan) {
        this.productionPlan = productionPlan;
    }

    public int getSequenceOrder() {
        return sequenceOrder;
    }

    public void setSequenceOrder(int sequenceOrder) {
        this.sequenceOrder = sequenceOrder;
    }

    public Date getCastedDate() {
        return castedDate;
    }

    public void setCastedDate(Date castedDate) {
        this.castedDate = castedDate;
    }

    public String getDisapprovedReason() {
        return disapprovedReason;
    }

    public void setDisapprovedReason(String disapprovedReason) {
        this.disapprovedReason = disapprovedReason;
    }

    public boolean isDisapproved() {
        return disapproved;
    }

    public void setDisapproved(boolean disapproved) {
        this.disapproved = disapproved;
    }
}
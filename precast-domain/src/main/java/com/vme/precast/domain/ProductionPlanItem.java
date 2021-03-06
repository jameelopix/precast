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
    private Date plannedDate;

    @Temporal(TemporalType.DATE)
    private Date castStartDate;

    @Temporal(TemporalType.DATE)
    private Date castEndDate;

    @Temporal(TemporalType.DATE)
    private Date deliveredDate;

    @Temporal(TemporalType.DATE)
    private Date erectedDate;

    private String disapprovedReason;

    private String disapprovedDesc;

    private Boolean disapproved;

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

    public Long getProductionPlanId() {
        return productionPlanId;
    }

    public void setProductionPlanId(Long productionPlanId) {
        this.productionPlanId = productionPlanId;
    }

    public int getSequenceOrder() {
        return sequenceOrder;
    }

    public void setSequenceOrder(int sequenceOrder) {
        this.sequenceOrder = sequenceOrder;
    }

    public Date getPlannedDate() {
        return plannedDate;
    }

    public void setPlannedDate(Date plannedDate) {
        this.plannedDate = plannedDate;
    }

    public Date getCastStartDate() {
        return castStartDate;
    }

    public void setCastStartDate(Date castStartDate) {
        this.castStartDate = castStartDate;
    }

    public Date getCastEndDate() {
        return castEndDate;
    }

    public void setCastEndDate(Date castEndDate) {
        this.castEndDate = castEndDate;
    }

    public Date getDeliveredDate() {
        return deliveredDate;
    }

    public void setDeliveredDate(Date deliveredDate) {
        this.deliveredDate = deliveredDate;
    }

    public Date getErectedDate() {
        return erectedDate;
    }

    public void setErectedDate(Date erectedDate) {
        this.erectedDate = erectedDate;
    }

    public String getDisapprovedReason() {
        return disapprovedReason;
    }

    public void setDisapprovedReason(String disapprovedReason) {
        this.disapprovedReason = disapprovedReason;
    }

    public String getDisapprovedDesc() {
        return disapprovedDesc;
    }

    public void setDisapprovedDesc(String disapprovedDesc) {
        this.disapprovedDesc = disapprovedDesc;
    }

    public Boolean getDisapproved() {
        return disapproved;
    }

    public void setDisapproved(Boolean disapproved) {
        this.disapproved = disapproved;
    }
}
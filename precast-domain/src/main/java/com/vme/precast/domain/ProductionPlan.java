package com.vme.precast.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.vme.precast.shared.ProductionPlanStatus;

import coliseum.jpa.domain.BaseEntity;

@Entity
public class ProductionPlan extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private Element element;

    private ProductionPlanStatus productionPlanStatus;

    @Temporal(TemporalType.DATE)
    private Date plannedDate;

    @Temporal(TemporalType.DATE)
    private Date deliveredDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public ProductionPlanStatus getProductionPlanStatus() {
        return productionPlanStatus;
    }

    public void setProductionPlanStatus(ProductionPlanStatus productionPlanStatus) {
        this.productionPlanStatus = productionPlanStatus;
    }

    public Date getPlannedDate() {
        return plannedDate;
    }

    public void setPlannedDate(Date plannedDate) {
        this.plannedDate = plannedDate;
    }

    public Date getDeliveredDate() {
        return deliveredDate;
    }

    public void setDeliveredDate(Date deliveredDate) {
        this.deliveredDate = deliveredDate;
    }
}
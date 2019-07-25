package com.vme.precast.productionplanitem.api;

import java.util.Date;

import com.vme.precast.productionplan.api.ProductionPlanDTO;

import coliseum.service.BaseDTO;

public class ProductionPlanItemDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;
    private Long id;
    private ProductionPlanDTO productionPlanDTO;
    private Long productionPlanId;
    private int sequenceOrder;
    private Date castedDate;
    private String disapprovedReason;
    private boolean disapproved;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductionPlanDTO getProductionPlanDTO() {
        return productionPlanDTO;
    }

    public void setProductionPlanDTO(ProductionPlanDTO productionPlanDTO) {
        this.productionPlanDTO = productionPlanDTO;
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
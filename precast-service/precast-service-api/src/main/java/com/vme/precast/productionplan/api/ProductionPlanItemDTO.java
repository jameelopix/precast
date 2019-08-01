package com.vme.precast.productionplan.api;

import java.util.Date;
import java.util.List;

import coliseum.service.BaseDTO;

public class ProductionPlanItemDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;
    private Long id;
    private ProductionPlanDTO productionPlanDTO;
    private Long productionPlanId;
    private int sequenceOrder;
    private Date plannedDate;
    private Date castStartDate;
    private Date castEndDate;
    private Date deliveredDate;
    private Date erectedDate;
    private String disapprovedReason;
    private String disapprovedDesc;
    private Boolean disapproved;

    private List<ProductionPlanItemDetailDTO> productionPlanItemDetailDTOList;

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

    public List<ProductionPlanItemDetailDTO> getProductionPlanItemDetailDTOList() {
        return productionPlanItemDetailDTOList;
    }

    public void setProductionPlanItemDetailDTOList(List<ProductionPlanItemDetailDTO> productionPlanItemDetailDTOList) {
        this.productionPlanItemDetailDTOList = productionPlanItemDetailDTOList;
    }
}
package com.vme.precast.productionplan.api;

import java.util.Date;

import com.vme.precast.element.api.ElementDTO;
import com.vme.precast.shared.ProductionPlanStatus;

import coliseum.service.BaseDTO;

public class ProductionPlanDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;
    private Long id;
    private ElementDTO elementDTO;
    private Long elementId;
    private ProductionPlanStatus productionPlanStatus;
    private Date plannedDate;
    private Date deliveredDate;
    private Date erectedDate;
    private int castedCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ElementDTO getElementDTO() {
        return elementDTO;
    }

    public void setElementDTO(ElementDTO elementDTO) {
        this.elementDTO = elementDTO;
    }

    public Long getElementId() {
        return elementId;
    }

    public void setElementId(Long elementId) {
        this.elementId = elementId;
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

    public int getCastedCount() {
        return castedCount;
    }

    public void setCastedCount(int castedCount) {
        this.castedCount = castedCount;
    }

    public Date getErectedDate() {
        return erectedDate;
    }

    public void setErectedDate(Date erectedDate) {
        this.erectedDate = erectedDate;
    }
}
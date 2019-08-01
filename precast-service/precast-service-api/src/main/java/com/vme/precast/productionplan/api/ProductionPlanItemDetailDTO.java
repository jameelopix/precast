package com.vme.precast.productionplan.api;

import coliseum.service.BaseDTO;

public class ProductionPlanItemDetailDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;
    private Long id;
    private ProductionPlanItemDTO productionPlanItemDTO;
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

    public ProductionPlanItemDTO getProductionPlanItemDTO() {
        return productionPlanItemDTO;
    }

    public void setProductionPlanItemDTO(ProductionPlanItemDTO productionPlanItemDTO) {
        this.productionPlanItemDTO = productionPlanItemDTO;
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
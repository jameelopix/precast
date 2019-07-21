package com.vme.precast.productionplan.api;

import com.vme.precast.element.api.ElementDTO;

import coliseum.service.BaseServiceRequest;

public class ProductionPlanServiceRequest extends BaseServiceRequest {

    private static final long serialVersionUID = 1L;

    private ProductionPlanDTO productionPlanDTO;

    private ElementDTO elementDTO;

    private ProductionPlanSearchDTO productionPlanSearchDTO;

    public ProductionPlanDTO getProductionPlanDTO() {
        return productionPlanDTO;
    }

    public void setProductionPlanDTO(ProductionPlanDTO productionPlanDTO) {
        this.productionPlanDTO = productionPlanDTO;
    }

    public ProductionPlanSearchDTO getProductionPlanSearchDTO() {
        return productionPlanSearchDTO;
    }

    public void setProductionPlanSearchDTO(ProductionPlanSearchDTO productionPlanSearchDTO) {
        this.productionPlanSearchDTO = productionPlanSearchDTO;
    }

    public ElementDTO getElementDTO() {
        return elementDTO;
    }

    public void setElementDTO(ElementDTO elementDTO) {
        this.elementDTO = elementDTO;
    }
}

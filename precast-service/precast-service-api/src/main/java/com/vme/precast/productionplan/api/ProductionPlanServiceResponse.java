package com.vme.precast.productionplan.api;

import java.util.List;

import coliseum.service.BaseServiceResponse;

public class ProductionPlanServiceResponse extends BaseServiceResponse {

    private static final long serialVersionUID = 1L;

    private List<ProductionPlanDTO> productionPlanDTOList;

    private ProductionPlanItemDTO productionPlanItemDTO;

    public List<ProductionPlanDTO> getProductionPlanDTOList() {
        return productionPlanDTOList;
    }

    public void setProductionPlanDTOList(List<ProductionPlanDTO> productionPlanDTOList) {
        this.productionPlanDTOList = productionPlanDTOList;
    }

    public ProductionPlanItemDTO getProductionPlanItemDTO() {
        return productionPlanItemDTO;
    }

    public void setProductionPlanItemDTO(ProductionPlanItemDTO productionPlanItemDTO) {
        this.productionPlanItemDTO = productionPlanItemDTO;
    }
}
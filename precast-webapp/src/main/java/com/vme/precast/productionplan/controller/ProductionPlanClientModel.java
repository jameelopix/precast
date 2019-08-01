package com.vme.precast.productionplan.controller;

import java.util.List;

import com.vme.precast.productionplan.api.ProductionPlanDTO;
import com.vme.precast.productionplan.api.ProductionPlanItemDTO;
import com.vme.precast.productionplan.api.ProductionPlanSearchDTO;

import coliseum.web.BaseClientModel;

public class ProductionPlanClientModel extends BaseClientModel {

    private static final long serialVersionUID = 1L;

    private ProductionPlanDTO productionPlanDTO;

    private ProductionPlanItemDTO productionPlanItemDTO;

    private ProductionPlanSearchDTO productionPlanSearchDTO;

    private List<ProductionPlanDTO> productionPlanDTOList;

    public ProductionPlanDTO getProductionPlanDTO() {
        return productionPlanDTO;
    }

    public void setProductionPlanDTO(ProductionPlanDTO productionPlanDTO) {
        this.productionPlanDTO = productionPlanDTO;
    }

    public List<ProductionPlanDTO> getProductionPlanDTOList() {
        return productionPlanDTOList;
    }

    public void setProductionPlanDTOList(List<ProductionPlanDTO> productionPlanDTOList) {
        this.productionPlanDTOList = productionPlanDTOList;
    }

    public ProductionPlanSearchDTO getProductionPlanSearchDTO() {
        return productionPlanSearchDTO;
    }

    public void setProductionPlanSearchDTO(ProductionPlanSearchDTO productionPlanSearchDTO) {
        this.productionPlanSearchDTO = productionPlanSearchDTO;
    }

    public ProductionPlanItemDTO getProductionPlanItemDTO() {
        return productionPlanItemDTO;
    }

    public void setProductionPlanItemDTO(ProductionPlanItemDTO productionPlanItemDTO) {
        this.productionPlanItemDTO = productionPlanItemDTO;
    }

}
package com.vme.precast.productionplanitem.api;

import coliseum.service.BaseServiceRequest;

public class ProductionPlanItemServiceRequest extends BaseServiceRequest {

 private static final long serialVersionUID = 1L;

 private ProductionPlanItemDTO productionPlanItemDTO;

 private ProductionPlanItemSearchDTO productionPlanItemSearchDTO;

 public ProductionPlanItemDTO getProductionPlanItemDTO() {
 return productionPlanItemDTO;
 }

 public void setProductionPlanItemDTO(ProductionPlanItemDTO productionPlanItemDTO) {
 this.productionPlanItemDTO = productionPlanItemDTO;
 }

 public ProductionPlanItemSearchDTO getProductionPlanItemSearchDTO() {
 return productionPlanItemSearchDTO;
 }

 public void setProductionPlanItemSearchDTO(ProductionPlanItemSearchDTO productionPlanItemSearchDTO) {
 this.productionPlanItemSearchDTO = productionPlanItemSearchDTO;
 }
}

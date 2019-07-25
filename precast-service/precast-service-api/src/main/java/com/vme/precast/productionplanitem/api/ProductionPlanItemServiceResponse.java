package com.vme.precast.productionplanitem.api;

import java.util.List;

import coliseum.service.BaseServiceResponse;

public class ProductionPlanItemServiceResponse extends BaseServiceResponse {

 private static final long serialVersionUID = 1L;

 private List<ProductionPlanItemDTO> productionPlanItemDTOList;

 public List<ProductionPlanItemDTO> getProductionPlanItemDTOList() {
 return productionPlanItemDTOList;
 }

 public void setProductionPlanItemDTOList(List<ProductionPlanItemDTO> productionPlanItemDTOList) {
 this.productionPlanItemDTOList = productionPlanItemDTOList;
 }
}
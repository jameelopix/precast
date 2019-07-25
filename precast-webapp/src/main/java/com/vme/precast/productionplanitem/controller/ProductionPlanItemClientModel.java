package com.vme.precast.productionplanitem.controller;

import java.util.List;

import com.vme.precast.productionplanitem.api.ProductionPlanItemDTO;
import com.vme.precast.productionplanitem.api.ProductionPlanItemSearchDTO;

import coliseum.web.BaseClientModel;

public class ProductionPlanItemClientModel extends BaseClientModel {

 private static final long serialVersionUID = 1L;

 private ProductionPlanItemDTO productionPlanItemDTO;

 private ProductionPlanItemSearchDTO productionPlanItemSearchDTO;

 private List<ProductionPlanItemDTO> productionPlanItemDTOList;

 public ProductionPlanItemDTO getProductionPlanItemDTO() {
 return productionPlanItemDTO;
 }

 public void setProductionPlanItemDTO(ProductionPlanItemDTO productionPlanItemDTO) {
 this.productionPlanItemDTO = productionPlanItemDTO;
 }

 public List<ProductionPlanItemDTO> getProductionPlanItemDTOList() {
 return productionPlanItemDTOList;
 }

 public void setProductionPlanItemDTOList(List<ProductionPlanItemDTO> productionPlanItemDTOList) {
 this.productionPlanItemDTOList = productionPlanItemDTOList;
 }

 public ProductionPlanItemSearchDTO getProductionPlanItemSearchDTO() {
 return productionPlanItemSearchDTO;
 }

 public void setProductionPlanItemSearchDTO(ProductionPlanItemSearchDTO productionPlanItemSearchDTO) {
 this.productionPlanItemSearchDTO = productionPlanItemSearchDTO;
 }

}
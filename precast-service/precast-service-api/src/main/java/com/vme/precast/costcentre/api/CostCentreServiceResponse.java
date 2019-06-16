package com.vme.precast.costcentre.api;

import java.util.List;

import coliseum.service.BaseServiceResponse;

public class CostCentreServiceResponse extends BaseServiceResponse {

 private static final long serialVersionUID = 1L;

 private List<CostCentreDTO> costCentreDTOList;

 public List<CostCentreDTO> getCostCentreDTOList() {
 return costCentreDTOList;
 }

 public void setCostCentreDTOList(List<CostCentreDTO> costCentreDTOList) {
 this.costCentreDTOList = costCentreDTOList;
 }
}
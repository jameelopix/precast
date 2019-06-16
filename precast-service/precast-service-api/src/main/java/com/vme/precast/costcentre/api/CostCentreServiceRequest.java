package com.vme.precast.costcentre.api;

import coliseum.service.BaseServiceRequest;

public class CostCentreServiceRequest extends BaseServiceRequest {

 private static final long serialVersionUID = 1L;

 private CostCentreDTO costCentreDTO;

 private CostCentreSearchDTO costCentreSearchDTO;

 public CostCentreDTO getCostCentreDTO() {
 return costCentreDTO;
 }

 public void setCostCentreDTO(CostCentreDTO costCentreDTO) {
 this.costCentreDTO = costCentreDTO;
 }

 public CostCentreSearchDTO getCostCentreSearchDTO() {
 return costCentreSearchDTO;
 }

 public void setCostCentreSearchDTO(CostCentreSearchDTO costCentreSearchDTO) {
 this.costCentreSearchDTO = costCentreSearchDTO;
 }
}

package com.vme.precast.productionplan.api;

import coliseum.service.ColiseumInterface;
import coliseum.service.ErrorDTO;

public interface ProductionPlanValidator extends ColiseumInterface {

 public ErrorDTO checkProductionPlanDuplicate(ProductionPlanServiceRequest productionPlanServiceRequest);
}

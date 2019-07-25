package com.vme.precast.productionplanitem.api;

import coliseum.service.ColiseumInterface;
import coliseum.service.ErrorDTO;

public interface ProductionPlanItemValidator extends ColiseumInterface {

 public ErrorDTO checkProductionPlanItemDuplicate(ProductionPlanItemServiceRequest productionPlanItemServiceRequest);
}

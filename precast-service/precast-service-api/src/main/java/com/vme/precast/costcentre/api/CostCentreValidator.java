package com.vme.precast.costcentre.api;

import coliseum.service.ColiseumInterface;
import coliseum.service.ErrorDTO;

public interface CostCentreValidator extends ColiseumInterface {

 public ErrorDTO checkCostCentreDuplicate(CostCentreServiceRequest costCentreServiceRequest);
}

package com.vme.precast.costcentre.api;

import coliseum.service.ColiseumInterface;

public interface CostCentreComponent extends ColiseumInterface {

 public CostCentreServiceResponse createCostCentre(CostCentreServiceRequest costCentreServiceRequest);

 public CostCentreServiceResponse getCostCentres(CostCentreServiceRequest costCentreServiceRequest);

 public CostCentreServiceResponse updateCostCentre(CostCentreServiceRequest costCentreServiceRequest);

 public CostCentreServiceResponse deleteCostCentre(CostCentreServiceRequest costCentreServiceRequest);
}

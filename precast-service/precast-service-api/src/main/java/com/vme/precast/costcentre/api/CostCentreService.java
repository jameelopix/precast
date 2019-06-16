package com.vme.precast.costcentre.api;

import coliseum.service.BaseService;
import coliseum.service.FlowDescriptor;

public interface CostCentreService extends BaseService {

    @FlowDescriptor(flow = "createcostcentre", request = "costCentreServiceRequest", response = "costCentreServiceResponse")
    public CostCentreServiceResponse createCostCentre(CostCentreServiceRequest costCentreServiceRequest);

    @FlowDescriptor(flow = "getcostcentres", request = "costCentreServiceRequest", response = "costCentreServiceResponse")
    public CostCentreServiceResponse getCostCentres(CostCentreServiceRequest costCentreServiceRequest);

    @FlowDescriptor(flow = "updatecostcentre", request = "costCentreServiceRequest", response = "costCentreServiceResponse")
    public CostCentreServiceResponse updateCostCentre(CostCentreServiceRequest costCentreServiceRequest);

    @FlowDescriptor(flow = "deletecostcentre", request = "costCentreServiceRequest", response = "costCentreServiceResponse")
    public CostCentreServiceResponse deleteCostCentre(CostCentreServiceRequest costCentreServiceRequest);
}
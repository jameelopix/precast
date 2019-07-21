package com.vme.precast.element.api;

import com.vme.precast.productionplan.api.ProductionPlanServiceRequest;

import coliseum.service.ColiseumInterface;

public interface ElementComponent extends ColiseumInterface {

    public ElementServiceResponse createElement(ElementServiceRequest elementServiceRequest);

    public ElementServiceResponse getElements(ElementServiceRequest elementServiceRequest);

    public ElementServiceResponse updateElement(ElementServiceRequest elementServiceRequest);

    public ElementServiceResponse deleteElement(ElementServiceRequest elementServiceRequest);

    public ProductionPlanServiceRequest createProductionPlanRequest(ElementServiceRequest elementServiceRequest,
            ElementServiceResponse elementServiceResponse);
}

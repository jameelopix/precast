package com.vme.precast.productionplan.api;

import coliseum.service.ColiseumInterface;

public interface ProductionPlanComponent extends ColiseumInterface {

    public ProductionPlanServiceResponse createProductionPlan(
            ProductionPlanServiceRequest productionPlanServiceRequest);

    public ProductionPlanServiceResponse getProductionPlans(ProductionPlanServiceRequest productionPlanServiceRequest);

    public ProductionPlanServiceResponse deleteProductionPlan(
            ProductionPlanServiceRequest productionPlanServiceRequest);

    public ProductionPlanServiceResponse getProductionPlanItems(
            ProductionPlanServiceRequest productionPlanServiceRequest);

    public ProductionPlanServiceResponse updateProductionPlanItem(
            ProductionPlanServiceRequest productionPlanServiceRequest);
}

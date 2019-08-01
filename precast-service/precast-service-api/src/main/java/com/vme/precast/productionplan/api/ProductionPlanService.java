package com.vme.precast.productionplan.api;

import coliseum.service.BaseService;

public interface ProductionPlanService extends BaseService {

    public ProductionPlanServiceResponse createProductionPlan(
            ProductionPlanServiceRequest productionPlanServiceRequest);

    public ProductionPlanServiceResponse getProductionPlans(ProductionPlanServiceRequest productionPlanServiceRequest);

    public ProductionPlanServiceResponse deleteProductionPlan(
            ProductionPlanServiceRequest productionPlanServiceRequest);

    public ProductionPlanServiceResponse getProductionPlanDetail(
            ProductionPlanServiceRequest productionPlanServiceRequest);

    public ProductionPlanServiceResponse updateProductionPlanDetail(
            ProductionPlanServiceRequest productionPlanServiceRequest);
}
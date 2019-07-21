package com.vme.precast.productionplan.api;

import coliseum.service.BaseService;
import coliseum.service.FlowDescriptor;

public interface ProductionPlanService extends BaseService {

 @FlowDescriptor(flow = "createproductionplan", request = "productionPlanServiceRequest", response = "productionPlanServiceResponse")
 public ProductionPlanServiceResponse createProductionPlan(ProductionPlanServiceRequest productionPlanServiceRequest);

 @FlowDescriptor(flow = "getproductionplans", request = "productionPlanServiceRequest", response = "productionPlanServiceResponse")
 public ProductionPlanServiceResponse getProductionPlans(ProductionPlanServiceRequest productionPlanServiceRequest);

 @FlowDescriptor(flow = "updateproductionplan", request = "productionPlanServiceRequest", response = "productionPlanServiceResponse")
 public ProductionPlanServiceResponse updateProductionPlan(ProductionPlanServiceRequest productionPlanServiceRequest);

 @FlowDescriptor(flow = "deleteproductionplan", request = "productionPlanServiceRequest", response = "productionPlanServiceResponse")
 public ProductionPlanServiceResponse deleteProductionPlan(ProductionPlanServiceRequest productionPlanServiceRequest);
}
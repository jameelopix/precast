package com.vme.precast.productionplanitem.api;

import coliseum.service.BaseService;
import coliseum.service.FlowDescriptor;

public interface ProductionPlanItemService extends BaseService {

 @FlowDescriptor(flow = "createproductionplanitem", request = "productionPlanItemServiceRequest", response = "productionPlanItemServiceResponse")
 public ProductionPlanItemServiceResponse createProductionPlanItem(ProductionPlanItemServiceRequest productionPlanItemServiceRequest);

 @FlowDescriptor(flow = "getproductionplanitems", request = "productionPlanItemServiceRequest", response = "productionPlanItemServiceResponse")
 public ProductionPlanItemServiceResponse getProductionPlanItems(ProductionPlanItemServiceRequest productionPlanItemServiceRequest);

 @FlowDescriptor(flow = "updateproductionplanitem", request = "productionPlanItemServiceRequest", response = "productionPlanItemServiceResponse")
 public ProductionPlanItemServiceResponse updateProductionPlanItem(ProductionPlanItemServiceRequest productionPlanItemServiceRequest);

 @FlowDescriptor(flow = "deleteproductionplanitem", request = "productionPlanItemServiceRequest", response = "productionPlanItemServiceResponse")
 public ProductionPlanItemServiceResponse deleteProductionPlanItem(ProductionPlanItemServiceRequest productionPlanItemServiceRequest);
}
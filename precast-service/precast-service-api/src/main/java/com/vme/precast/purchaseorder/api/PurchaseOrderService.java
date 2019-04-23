package com.vme.precast.purchaseorder.api;

import coliseum.service.BaseService;
import coliseum.service.FlowDescriptor;

public interface PurchaseOrderService extends BaseService {

 @FlowDescriptor(flow = "createpurchaseorder", request = "purchaseOrderServiceRequest", response = "purchaseOrderServiceResponse")
 public PurchaseOrderServiceResponse createPurchaseOrder(PurchaseOrderServiceRequest purchaseOrderServiceRequest);

 @FlowDescriptor(flow = "getpurchaseorders", request = "purchaseOrderServiceRequest", response = "purchaseOrderServiceResponse")
 public PurchaseOrderServiceResponse getPurchaseOrders(PurchaseOrderServiceRequest purchaseOrderServiceRequest);

 @FlowDescriptor(flow = "updatepurchaseorder", request = "purchaseOrderServiceRequest", response = "purchaseOrderServiceResponse")
 public PurchaseOrderServiceResponse updatePurchaseOrder(PurchaseOrderServiceRequest purchaseOrderServiceRequest);

 @FlowDescriptor(flow = "deletepurchaseorder", request = "purchaseOrderServiceRequest", response = "purchaseOrderServiceResponse")
 public PurchaseOrderServiceResponse deletePurchaseOrder(PurchaseOrderServiceRequest purchaseOrderServiceRequest);
}
package com.vme.precast.purchaseorderitem.api;

import coliseum.service.BaseService;
import coliseum.service.FlowDescriptor;

public interface PurchaseOrderItemService extends BaseService {

 @FlowDescriptor(flow = "createpurchaseorderitem", request = "purchaseOrderItemServiceRequest", response = "purchaseOrderItemServiceResponse")
 public PurchaseOrderItemServiceResponse createPurchaseOrderItem(PurchaseOrderItemServiceRequest purchaseOrderItemServiceRequest);

 @FlowDescriptor(flow = "getpurchaseorderitems", request = "purchaseOrderItemServiceRequest", response = "purchaseOrderItemServiceResponse")
 public PurchaseOrderItemServiceResponse getPurchaseOrderItems(PurchaseOrderItemServiceRequest purchaseOrderItemServiceRequest);

 @FlowDescriptor(flow = "updatepurchaseorderitem", request = "purchaseOrderItemServiceRequest", response = "purchaseOrderItemServiceResponse")
 public PurchaseOrderItemServiceResponse updatePurchaseOrderItem(PurchaseOrderItemServiceRequest purchaseOrderItemServiceRequest);

 @FlowDescriptor(flow = "deletepurchaseorderitem", request = "purchaseOrderItemServiceRequest", response = "purchaseOrderItemServiceResponse")
 public PurchaseOrderItemServiceResponse deletePurchaseOrderItem(PurchaseOrderItemServiceRequest purchaseOrderItemServiceRequest);
}
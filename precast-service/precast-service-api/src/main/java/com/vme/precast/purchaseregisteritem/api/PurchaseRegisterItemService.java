package com.vme.precast.purchaseregisteritem.api;

import coliseum.service.BaseService;
import coliseum.service.FlowDescriptor;

public interface PurchaseRegisterItemService extends BaseService {

 @FlowDescriptor(flow = "createpurchaseregisteritem", request = "purchaseRegisterItemServiceRequest", response = "purchaseRegisterItemServiceResponse")
 public PurchaseRegisterItemServiceResponse createPurchaseRegisterItem(PurchaseRegisterItemServiceRequest purchaseRegisterItemServiceRequest);

 @FlowDescriptor(flow = "getpurchaseregisteritems", request = "purchaseRegisterItemServiceRequest", response = "purchaseRegisterItemServiceResponse")
 public PurchaseRegisterItemServiceResponse getPurchaseRegisterItems(PurchaseRegisterItemServiceRequest purchaseRegisterItemServiceRequest);

 @FlowDescriptor(flow = "updatepurchaseregisteritem", request = "purchaseRegisterItemServiceRequest", response = "purchaseRegisterItemServiceResponse")
 public PurchaseRegisterItemServiceResponse updatePurchaseRegisterItem(PurchaseRegisterItemServiceRequest purchaseRegisterItemServiceRequest);

 @FlowDescriptor(flow = "deletepurchaseregisteritem", request = "purchaseRegisterItemServiceRequest", response = "purchaseRegisterItemServiceResponse")
 public PurchaseRegisterItemServiceResponse deletePurchaseRegisterItem(PurchaseRegisterItemServiceRequest purchaseRegisterItemServiceRequest);
}
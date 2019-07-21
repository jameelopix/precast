package com.vme.precast.purchaseregister.api;

import coliseum.service.BaseService;
import coliseum.service.FlowDescriptor;

public interface PurchaseRegisterService extends BaseService {

 @FlowDescriptor(flow = "createpurchaseregister", request = "purchaseRegisterServiceRequest", response = "purchaseRegisterServiceResponse")
 public PurchaseRegisterServiceResponse createPurchaseRegister(PurchaseRegisterServiceRequest purchaseRegisterServiceRequest);

 @FlowDescriptor(flow = "getpurchaseregisters", request = "purchaseRegisterServiceRequest", response = "purchaseRegisterServiceResponse")
 public PurchaseRegisterServiceResponse getPurchaseRegisters(PurchaseRegisterServiceRequest purchaseRegisterServiceRequest);

 @FlowDescriptor(flow = "updatepurchaseregister", request = "purchaseRegisterServiceRequest", response = "purchaseRegisterServiceResponse")
 public PurchaseRegisterServiceResponse updatePurchaseRegister(PurchaseRegisterServiceRequest purchaseRegisterServiceRequest);

 @FlowDescriptor(flow = "deletepurchaseregister", request = "purchaseRegisterServiceRequest", response = "purchaseRegisterServiceResponse")
 public PurchaseRegisterServiceResponse deletePurchaseRegister(PurchaseRegisterServiceRequest purchaseRegisterServiceRequest);
 
 @FlowDescriptor(flow = "approvePurchaseRegister", request = "purchaseRegisterServiceRequest", response = "purchaseRegisterServiceResponse")
 public PurchaseRegisterServiceResponse approvePurchaseRegister(PurchaseRegisterServiceRequest purchaseRegisterServiceRequest);
}
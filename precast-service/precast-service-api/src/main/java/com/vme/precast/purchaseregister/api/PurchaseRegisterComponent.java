package com.vme.precast.purchaseregister.api;

import coliseum.service.ColiseumInterface;

public interface PurchaseRegisterComponent extends ColiseumInterface {

 public PurchaseRegisterServiceResponse createPurchaseRegister(PurchaseRegisterServiceRequest purchaseRegisterServiceRequest);

 public PurchaseRegisterServiceResponse getPurchaseRegisters(PurchaseRegisterServiceRequest purchaseRegisterServiceRequest);

 public PurchaseRegisterServiceResponse updatePurchaseRegister(PurchaseRegisterServiceRequest purchaseRegisterServiceRequest);

 public PurchaseRegisterServiceResponse deletePurchaseRegister(PurchaseRegisterServiceRequest purchaseRegisterServiceRequest);
 
 public PurchaseRegisterServiceResponse approvePurchaseRegister(PurchaseRegisterServiceRequest purchaseRegisterServiceRequest);
}

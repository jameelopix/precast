package com.vme.precast.purchaseregisteritem.api;

import coliseum.service.ColiseumInterface;

public interface PurchaseRegisterItemComponent extends ColiseumInterface {

 public PurchaseRegisterItemServiceResponse createPurchaseRegisterItem(PurchaseRegisterItemServiceRequest purchaseRegisterItemServiceRequest);

 public PurchaseRegisterItemServiceResponse getPurchaseRegisterItems(PurchaseRegisterItemServiceRequest purchaseRegisterItemServiceRequest);

 public PurchaseRegisterItemServiceResponse updatePurchaseRegisterItem(PurchaseRegisterItemServiceRequest purchaseRegisterItemServiceRequest);

 public PurchaseRegisterItemServiceResponse deletePurchaseRegisterItem(PurchaseRegisterItemServiceRequest purchaseRegisterItemServiceRequest);
}
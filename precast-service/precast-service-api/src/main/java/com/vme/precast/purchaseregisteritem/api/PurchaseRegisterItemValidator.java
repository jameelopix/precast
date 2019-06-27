package com.vme.precast.purchaseregisteritem.api;

import coliseum.service.ColiseumInterface;
import coliseum.service.ErrorDTO;

public interface PurchaseRegisterItemValidator extends ColiseumInterface {

 public ErrorDTO checkPurchaseRegisterItemDuplicate(PurchaseRegisterItemServiceRequest purchaseRegisterItemServiceRequest);
}

package com.vme.precast.purchaseregister.api;

import coliseum.service.ColiseumInterface;
import coliseum.service.ErrorDTO;

public interface PurchaseRegisterValidator extends ColiseumInterface {

 public ErrorDTO checkPurchaseRegisterDuplicate(PurchaseRegisterServiceRequest purchaseRegisterServiceRequest);
}

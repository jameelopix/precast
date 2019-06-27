package com.vme.precast.purchaseorderitem.api;

import coliseum.service.ColiseumInterface;
import coliseum.service.ErrorDTO;

public interface PurchaseOrderItemValidator extends ColiseumInterface {

 public ErrorDTO checkPurchaseOrderItemDuplicate(PurchaseOrderItemServiceRequest purchaseOrderItemServiceRequest);
}

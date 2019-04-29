package com.vme.precast.purchaseorder.api;

import coliseum.service.ColiseumInterface;
import coliseum.service.ErrorDTO;

public interface PurchaseOrderValidator extends ColiseumInterface {

    public ErrorDTO checkPurchaseOrderDuplicate(PurchaseOrderServiceRequest purchaseOrderServiceRequest);

    public ErrorDTO isPurchaseOrderClosed(PurchaseOrderServiceRequest purchaseOrderServiceRequest);

    public ErrorDTO isPurchaseOrderIssued(PurchaseOrderServiceRequest purchaseOrderServiceRequest);
}

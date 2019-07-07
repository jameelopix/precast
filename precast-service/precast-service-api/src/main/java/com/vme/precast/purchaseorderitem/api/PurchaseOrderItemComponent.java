package com.vme.precast.purchaseorderitem.api;

import coliseum.service.ColiseumInterface;

public interface PurchaseOrderItemComponent extends ColiseumInterface {

    public PurchaseOrderItemServiceResponse createPurchaseOrderItem(
            PurchaseOrderItemServiceRequest purchaseOrderItemServiceRequest);

    public PurchaseOrderItemServiceResponse getPurchaseOrderItems(
            PurchaseOrderItemServiceRequest purchaseOrderItemServiceRequest);

    public PurchaseOrderItemServiceResponse updatePurchaseOrderItem(
            PurchaseOrderItemServiceRequest purchaseOrderItemServiceRequest);

    public PurchaseOrderItemServiceResponse deletePurchaseOrderItem(
            PurchaseOrderItemServiceRequest purchaseOrderItemServiceRequest);

    public PurchaseOrderItemServiceResponse preprocess(PurchaseOrderItemServiceRequest purchaseOrderItemServiceRequest);
}

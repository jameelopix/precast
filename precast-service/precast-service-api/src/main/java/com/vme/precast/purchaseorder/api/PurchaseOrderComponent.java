package com.vme.precast.purchaseorder.api;

import coliseum.service.ColiseumInterface;

public interface PurchaseOrderComponent extends ColiseumInterface {

    public PurchaseOrderServiceResponse createPurchaseOrder(PurchaseOrderServiceRequest purchaseOrderServiceRequest);

    public PurchaseOrderServiceResponse getPurchaseOrders(PurchaseOrderServiceRequest purchaseOrderServiceRequest);

    public PurchaseOrderServiceResponse updatePurchaseOrder(PurchaseOrderServiceRequest purchaseOrderServiceRequest);

    public PurchaseOrderServiceResponse deletePurchaseOrder(PurchaseOrderServiceRequest purchaseOrderServiceRequest);

    public PurchaseOrderServiceResponse issuePurchaseOrder(PurchaseOrderServiceRequest purchaseOrderServiceRequest);

    public PurchaseOrderServiceResponse closePurchaseOrder(PurchaseOrderServiceRequest purchaseOrderServiceRequest);
}

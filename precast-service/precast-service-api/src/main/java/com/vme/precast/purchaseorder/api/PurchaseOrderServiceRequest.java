package com.vme.precast.purchaseorder.api;

import coliseum.service.BaseServiceRequest;

public class PurchaseOrderServiceRequest extends BaseServiceRequest {

 private static final long serialVersionUID = 1L;

 private PurchaseOrderDTO purchaseOrderDTO;

 private PurchaseOrderSearchDTO purchaseOrderSearchDTO;

 public PurchaseOrderDTO getPurchaseOrderDTO() {
 return purchaseOrderDTO;
 }

 public void setPurchaseOrderDTO(PurchaseOrderDTO purchaseOrderDTO) {
 this.purchaseOrderDTO = purchaseOrderDTO;
 }

 public PurchaseOrderSearchDTO getPurchaseOrderSearchDTO() {
 return purchaseOrderSearchDTO;
 }

 public void setPurchaseOrderSearchDTO(PurchaseOrderSearchDTO purchaseOrderSearchDTO) {
 this.purchaseOrderSearchDTO = purchaseOrderSearchDTO;
 }
}

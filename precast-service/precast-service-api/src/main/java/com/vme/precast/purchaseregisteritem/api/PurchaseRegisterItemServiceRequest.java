package com.vme.precast.purchaseregisteritem.api;

import coliseum.service.BaseServiceRequest;

public class PurchaseRegisterItemServiceRequest extends BaseServiceRequest {

 private static final long serialVersionUID = 1L;

 private PurchaseRegisterItemDTO purchaseRegisterItemDTO;

 private PurchaseRegisterItemSearchDTO purchaseRegisterItemSearchDTO;

 public PurchaseRegisterItemDTO getPurchaseRegisterItemDTO() {
 return purchaseRegisterItemDTO;
 }

 public void setPurchaseRegisterItemDTO(PurchaseRegisterItemDTO purchaseRegisterItemDTO) {
 this.purchaseRegisterItemDTO = purchaseRegisterItemDTO;
 }

 public PurchaseRegisterItemSearchDTO getPurchaseRegisterItemSearchDTO() {
 return purchaseRegisterItemSearchDTO;
 }

 public void setPurchaseRegisterItemSearchDTO(PurchaseRegisterItemSearchDTO purchaseRegisterItemSearchDTO) {
 this.purchaseRegisterItemSearchDTO = purchaseRegisterItemSearchDTO;
 }
}

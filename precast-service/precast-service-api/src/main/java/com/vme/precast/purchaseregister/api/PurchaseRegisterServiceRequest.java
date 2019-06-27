package com.vme.precast.purchaseregister.api;

import coliseum.service.BaseServiceRequest;

public class PurchaseRegisterServiceRequest extends BaseServiceRequest {

 private static final long serialVersionUID = 1L;

 private PurchaseRegisterDTO purchaseRegisterDTO;

 private PurchaseRegisterSearchDTO purchaseRegisterSearchDTO;

 public PurchaseRegisterDTO getPurchaseRegisterDTO() {
 return purchaseRegisterDTO;
 }

 public void setPurchaseRegisterDTO(PurchaseRegisterDTO purchaseRegisterDTO) {
 this.purchaseRegisterDTO = purchaseRegisterDTO;
 }

 public PurchaseRegisterSearchDTO getPurchaseRegisterSearchDTO() {
 return purchaseRegisterSearchDTO;
 }

 public void setPurchaseRegisterSearchDTO(PurchaseRegisterSearchDTO purchaseRegisterSearchDTO) {
 this.purchaseRegisterSearchDTO = purchaseRegisterSearchDTO;
 }
}

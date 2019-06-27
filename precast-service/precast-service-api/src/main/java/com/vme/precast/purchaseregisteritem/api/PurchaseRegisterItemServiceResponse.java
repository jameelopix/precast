package com.vme.precast.purchaseregisteritem.api;

import java.util.List;

import coliseum.service.BaseServiceResponse;

public class PurchaseRegisterItemServiceResponse extends BaseServiceResponse {

 private static final long serialVersionUID = 1L;

 private List<PurchaseRegisterItemDTO> purchaseRegisterItemDTOList;

 public List<PurchaseRegisterItemDTO> getPurchaseRegisterItemDTOList() {
 return purchaseRegisterItemDTOList;
 }

 public void setPurchaseRegisterItemDTOList(List<PurchaseRegisterItemDTO> purchaseRegisterItemDTOList) {
 this.purchaseRegisterItemDTOList = purchaseRegisterItemDTOList;
 }
}
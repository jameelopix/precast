package com.vme.precast.purchaseregister.api;

import java.util.List;

import coliseum.service.BaseServiceResponse;

public class PurchaseRegisterServiceResponse extends BaseServiceResponse {

 private static final long serialVersionUID = 1L;

 private List<PurchaseRegisterDTO> purchaseRegisterDTOList;

 public List<PurchaseRegisterDTO> getPurchaseRegisterDTOList() {
 return purchaseRegisterDTOList;
 }

 public void setPurchaseRegisterDTOList(List<PurchaseRegisterDTO> purchaseRegisterDTOList) {
 this.purchaseRegisterDTOList = purchaseRegisterDTOList;
 }
}
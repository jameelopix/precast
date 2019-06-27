package com.vme.precast.purchaseorderitem.api;

import java.util.List;

import coliseum.service.BaseServiceResponse;

public class PurchaseOrderItemServiceResponse extends BaseServiceResponse {

 private static final long serialVersionUID = 1L;

 private List<PurchaseOrderItemDTO> purchaseOrderItemDTOList;

 public List<PurchaseOrderItemDTO> getPurchaseOrderItemDTOList() {
 return purchaseOrderItemDTOList;
 }

 public void setPurchaseOrderItemDTOList(List<PurchaseOrderItemDTO> purchaseOrderItemDTOList) {
 this.purchaseOrderItemDTOList = purchaseOrderItemDTOList;
 }
}
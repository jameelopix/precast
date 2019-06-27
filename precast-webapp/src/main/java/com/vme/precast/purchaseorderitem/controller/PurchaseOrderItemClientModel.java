package com.vme.precast.purchaseorderitem.controller;

import java.util.List;

import com.vme.precast.purchaseorderitem.api.PurchaseOrderItemDTO;
import com.vme.precast.purchaseorderitem.api.PurchaseOrderItemSearchDTO;

import coliseum.web.BaseClientModel;

public class PurchaseOrderItemClientModel extends BaseClientModel {

 private static final long serialVersionUID = 1L;

 private PurchaseOrderItemDTO purchaseOrderItemDTO;

 private PurchaseOrderItemSearchDTO purchaseOrderItemSearchDTO;

 private List<PurchaseOrderItemDTO> purchaseOrderItemDTOList;

 public PurchaseOrderItemDTO getPurchaseOrderItemDTO() {
 return purchaseOrderItemDTO;
 }

 public void setPurchaseOrderItemDTO(PurchaseOrderItemDTO purchaseOrderItemDTO) {
 this.purchaseOrderItemDTO = purchaseOrderItemDTO;
 }

 public List<PurchaseOrderItemDTO> getPurchaseOrderItemDTOList() {
 return purchaseOrderItemDTOList;
 }

 public void setPurchaseOrderItemDTOList(List<PurchaseOrderItemDTO> purchaseOrderItemDTOList) {
 this.purchaseOrderItemDTOList = purchaseOrderItemDTOList;
 }

 public PurchaseOrderItemSearchDTO getPurchaseOrderItemSearchDTO() {
 return purchaseOrderItemSearchDTO;
 }

 public void setPurchaseOrderItemSearchDTO(PurchaseOrderItemSearchDTO purchaseOrderItemSearchDTO) {
 this.purchaseOrderItemSearchDTO = purchaseOrderItemSearchDTO;
 }

}
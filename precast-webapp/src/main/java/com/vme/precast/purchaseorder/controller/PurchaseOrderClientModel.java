package com.vme.precast.purchaseorder.controller;

import java.util.List;

import com.vme.precast.purchaseorder.api.PurchaseOrderDTO;
import com.vme.precast.purchaseorder.api.PurchaseOrderSearchDTO;

import coliseum.web.BaseClientModel;

public class PurchaseOrderClientModel extends BaseClientModel {

 private static final long serialVersionUID = 1L;

 private PurchaseOrderDTO purchaseOrderDTO;

 private PurchaseOrderSearchDTO purchaseOrderSearchDTO;

 private List<PurchaseOrderDTO> purchaseOrderDTOList;

 public PurchaseOrderDTO getPurchaseOrderDTO() {
 return purchaseOrderDTO;
 }

 public void setPurchaseOrderDTO(PurchaseOrderDTO purchaseOrderDTO) {
 this.purchaseOrderDTO = purchaseOrderDTO;
 }

 public List<PurchaseOrderDTO> getPurchaseOrderDTOList() {
 return purchaseOrderDTOList;
 }

 public void setPurchaseOrderDTOList(List<PurchaseOrderDTO> purchaseOrderDTOList) {
 this.purchaseOrderDTOList = purchaseOrderDTOList;
 }

 public PurchaseOrderSearchDTO getPurchaseOrderSearchDTO() {
 return purchaseOrderSearchDTO;
 }

 public void setPurchaseOrderSearchDTO(PurchaseOrderSearchDTO purchaseOrderSearchDTO) {
 this.purchaseOrderSearchDTO = purchaseOrderSearchDTO;
 }

}
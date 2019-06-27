package com.vme.precast.purchaseregisteritem.controller;

import java.util.List;

import com.vme.precast.purchaseregisteritem.api.PurchaseRegisterItemDTO;
import com.vme.precast.purchaseregisteritem.api.PurchaseRegisterItemSearchDTO;

import coliseum.web.BaseClientModel;

public class PurchaseRegisterItemClientModel extends BaseClientModel {

 private static final long serialVersionUID = 1L;

 private PurchaseRegisterItemDTO purchaseRegisterItemDTO;

 private PurchaseRegisterItemSearchDTO purchaseRegisterItemSearchDTO;

 private List<PurchaseRegisterItemDTO> purchaseRegisterItemDTOList;

 public PurchaseRegisterItemDTO getPurchaseRegisterItemDTO() {
 return purchaseRegisterItemDTO;
 }

 public void setPurchaseRegisterItemDTO(PurchaseRegisterItemDTO purchaseRegisterItemDTO) {
 this.purchaseRegisterItemDTO = purchaseRegisterItemDTO;
 }

 public List<PurchaseRegisterItemDTO> getPurchaseRegisterItemDTOList() {
 return purchaseRegisterItemDTOList;
 }

 public void setPurchaseRegisterItemDTOList(List<PurchaseRegisterItemDTO> purchaseRegisterItemDTOList) {
 this.purchaseRegisterItemDTOList = purchaseRegisterItemDTOList;
 }

 public PurchaseRegisterItemSearchDTO getPurchaseRegisterItemSearchDTO() {
 return purchaseRegisterItemSearchDTO;
 }

 public void setPurchaseRegisterItemSearchDTO(PurchaseRegisterItemSearchDTO purchaseRegisterItemSearchDTO) {
 this.purchaseRegisterItemSearchDTO = purchaseRegisterItemSearchDTO;
 }

}
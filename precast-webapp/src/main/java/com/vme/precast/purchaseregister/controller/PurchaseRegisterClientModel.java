package com.vme.precast.purchaseregister.controller;

import java.util.List;

import com.vme.precast.purchaseregister.api.PurchaseRegisterDTO;
import com.vme.precast.purchaseregister.api.PurchaseRegisterSearchDTO;

import coliseum.web.BaseClientModel;

public class PurchaseRegisterClientModel extends BaseClientModel {

 private static final long serialVersionUID = 1L;

 private PurchaseRegisterDTO purchaseRegisterDTO;

 private PurchaseRegisterSearchDTO purchaseRegisterSearchDTO;

 private List<PurchaseRegisterDTO> purchaseRegisterDTOList;

 public PurchaseRegisterDTO getPurchaseRegisterDTO() {
 return purchaseRegisterDTO;
 }

 public void setPurchaseRegisterDTO(PurchaseRegisterDTO purchaseRegisterDTO) {
 this.purchaseRegisterDTO = purchaseRegisterDTO;
 }

 public List<PurchaseRegisterDTO> getPurchaseRegisterDTOList() {
 return purchaseRegisterDTOList;
 }

 public void setPurchaseRegisterDTOList(List<PurchaseRegisterDTO> purchaseRegisterDTOList) {
 this.purchaseRegisterDTOList = purchaseRegisterDTOList;
 }

 public PurchaseRegisterSearchDTO getPurchaseRegisterSearchDTO() {
 return purchaseRegisterSearchDTO;
 }

 public void setPurchaseRegisterSearchDTO(PurchaseRegisterSearchDTO purchaseRegisterSearchDTO) {
 this.purchaseRegisterSearchDTO = purchaseRegisterSearchDTO;
 }

}
package com.vme.precast.itemfreightamountdetails.api;

import coliseum.service.BaseServiceRequest;

public class ItemFreightAmountDetailsServiceRequest extends BaseServiceRequest {

 private static final long serialVersionUID = 1L;

 private ItemFreightAmountDetailsDTO itemFreightAmountDetailsDTO;

 private ItemFreightAmountDetailsSearchDTO itemFreightAmountDetailsSearchDTO;

 public ItemFreightAmountDetailsDTO getItemFreightAmountDetailsDTO() {
 return itemFreightAmountDetailsDTO;
 }

 public void setItemFreightAmountDetailsDTO(ItemFreightAmountDetailsDTO itemFreightAmountDetailsDTO) {
 this.itemFreightAmountDetailsDTO = itemFreightAmountDetailsDTO;
 }

 public ItemFreightAmountDetailsSearchDTO getItemFreightAmountDetailsSearchDTO() {
 return itemFreightAmountDetailsSearchDTO;
 }

 public void setItemFreightAmountDetailsSearchDTO(ItemFreightAmountDetailsSearchDTO itemFreightAmountDetailsSearchDTO) {
 this.itemFreightAmountDetailsSearchDTO = itemFreightAmountDetailsSearchDTO;
 }
}

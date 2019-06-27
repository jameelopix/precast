package com.vme.precast.itembasicamountdetails.api;

import coliseum.service.BaseServiceRequest;

public class ItemBasicAmountDetailsServiceRequest extends BaseServiceRequest {

 private static final long serialVersionUID = 1L;

 private ItemBasicAmountDetailsDTO itemBasicAmountDetailsDTO;

 private ItemBasicAmountDetailsSearchDTO itemBasicAmountDetailsSearchDTO;

 public ItemBasicAmountDetailsDTO getItemBasicAmountDetailsDTO() {
 return itemBasicAmountDetailsDTO;
 }

 public void setItemBasicAmountDetailsDTO(ItemBasicAmountDetailsDTO itemBasicAmountDetailsDTO) {
 this.itemBasicAmountDetailsDTO = itemBasicAmountDetailsDTO;
 }

 public ItemBasicAmountDetailsSearchDTO getItemBasicAmountDetailsSearchDTO() {
 return itemBasicAmountDetailsSearchDTO;
 }

 public void setItemBasicAmountDetailsSearchDTO(ItemBasicAmountDetailsSearchDTO itemBasicAmountDetailsSearchDTO) {
 this.itemBasicAmountDetailsSearchDTO = itemBasicAmountDetailsSearchDTO;
 }
}

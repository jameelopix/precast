package com.vme.precast.itemamountdetails.api;

import coliseum.service.BaseServiceRequest;

public class ItemAmountDetailsServiceRequest extends BaseServiceRequest {

 private static final long serialVersionUID = 1L;

 private ItemAmountDetailsDTO itemAmountDetailsDTO;

 private ItemAmountDetailsSearchDTO itemAmountDetailsSearchDTO;

 public ItemAmountDetailsDTO getItemAmountDetailsDTO() {
 return itemAmountDetailsDTO;
 }

 public void setItemAmountDetailsDTO(ItemAmountDetailsDTO itemAmountDetailsDTO) {
 this.itemAmountDetailsDTO = itemAmountDetailsDTO;
 }

 public ItemAmountDetailsSearchDTO getItemAmountDetailsSearchDTO() {
 return itemAmountDetailsSearchDTO;
 }

 public void setItemAmountDetailsSearchDTO(ItemAmountDetailsSearchDTO itemAmountDetailsSearchDTO) {
 this.itemAmountDetailsSearchDTO = itemAmountDetailsSearchDTO;
 }
}

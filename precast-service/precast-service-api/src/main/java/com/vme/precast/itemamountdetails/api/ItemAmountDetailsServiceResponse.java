package com.vme.precast.itemamountdetails.api;

import java.util.List;

import coliseum.service.BaseServiceResponse;

public class ItemAmountDetailsServiceResponse extends BaseServiceResponse {

 private static final long serialVersionUID = 1L;

 private List<ItemAmountDetailsDTO> itemAmountDetailsDTOList;

 public List<ItemAmountDetailsDTO> getItemAmountDetailsDTOList() {
 return itemAmountDetailsDTOList;
 }

 public void setItemAmountDetailsDTOList(List<ItemAmountDetailsDTO> itemAmountDetailsDTOList) {
 this.itemAmountDetailsDTOList = itemAmountDetailsDTOList;
 }
}
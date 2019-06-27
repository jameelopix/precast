package com.vme.precast.itembasicamountdetails.api;

import java.util.List;

import coliseum.service.BaseServiceResponse;

public class ItemBasicAmountDetailsServiceResponse extends BaseServiceResponse {

 private static final long serialVersionUID = 1L;

 private List<ItemBasicAmountDetailsDTO> itemBasicAmountDetailsDTOList;

 public List<ItemBasicAmountDetailsDTO> getItemBasicAmountDetailsDTOList() {
 return itemBasicAmountDetailsDTOList;
 }

 public void setItemBasicAmountDetailsDTOList(List<ItemBasicAmountDetailsDTO> itemBasicAmountDetailsDTOList) {
 this.itemBasicAmountDetailsDTOList = itemBasicAmountDetailsDTOList;
 }
}
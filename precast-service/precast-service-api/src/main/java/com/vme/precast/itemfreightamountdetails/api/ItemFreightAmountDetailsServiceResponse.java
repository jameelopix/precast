package com.vme.precast.itemfreightamountdetails.api;

import java.util.List;

import coliseum.service.BaseServiceResponse;

public class ItemFreightAmountDetailsServiceResponse extends BaseServiceResponse {

 private static final long serialVersionUID = 1L;

 private List<ItemFreightAmountDetailsDTO> itemFreightAmountDetailsDTOList;

 public List<ItemFreightAmountDetailsDTO> getItemFreightAmountDetailsDTOList() {
 return itemFreightAmountDetailsDTOList;
 }

 public void setItemFreightAmountDetailsDTOList(List<ItemFreightAmountDetailsDTO> itemFreightAmountDetailsDTOList) {
 this.itemFreightAmountDetailsDTOList = itemFreightAmountDetailsDTOList;
 }
}
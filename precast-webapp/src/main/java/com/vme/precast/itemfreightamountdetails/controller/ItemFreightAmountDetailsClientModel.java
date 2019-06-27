package com.vme.precast.itemfreightamountdetails.controller;

import java.util.List;

import com.vme.precast.itemfreightamountdetails.api.ItemFreightAmountDetailsDTO;
import com.vme.precast.itemfreightamountdetails.api.ItemFreightAmountDetailsSearchDTO;

import coliseum.web.BaseClientModel;

public class ItemFreightAmountDetailsClientModel extends BaseClientModel {

 private static final long serialVersionUID = 1L;

 private ItemFreightAmountDetailsDTO itemFreightAmountDetailsDTO;

 private ItemFreightAmountDetailsSearchDTO itemFreightAmountDetailsSearchDTO;

 private List<ItemFreightAmountDetailsDTO> itemFreightAmountDetailsDTOList;

 public ItemFreightAmountDetailsDTO getItemFreightAmountDetailsDTO() {
 return itemFreightAmountDetailsDTO;
 }

 public void setItemFreightAmountDetailsDTO(ItemFreightAmountDetailsDTO itemFreightAmountDetailsDTO) {
 this.itemFreightAmountDetailsDTO = itemFreightAmountDetailsDTO;
 }

 public List<ItemFreightAmountDetailsDTO> getItemFreightAmountDetailsDTOList() {
 return itemFreightAmountDetailsDTOList;
 }

 public void setItemFreightAmountDetailsDTOList(List<ItemFreightAmountDetailsDTO> itemFreightAmountDetailsDTOList) {
 this.itemFreightAmountDetailsDTOList = itemFreightAmountDetailsDTOList;
 }

 public ItemFreightAmountDetailsSearchDTO getItemFreightAmountDetailsSearchDTO() {
 return itemFreightAmountDetailsSearchDTO;
 }

 public void setItemFreightAmountDetailsSearchDTO(ItemFreightAmountDetailsSearchDTO itemFreightAmountDetailsSearchDTO) {
 this.itemFreightAmountDetailsSearchDTO = itemFreightAmountDetailsSearchDTO;
 }

}
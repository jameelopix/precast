package com.vme.precast.itembasicamountdetails.controller;

import java.util.List;

import com.vme.precast.itembasicamountdetails.api.ItemBasicAmountDetailsDTO;
import com.vme.precast.itembasicamountdetails.api.ItemBasicAmountDetailsSearchDTO;

import coliseum.web.BaseClientModel;

public class ItemBasicAmountDetailsClientModel extends BaseClientModel {

 private static final long serialVersionUID = 1L;

 private ItemBasicAmountDetailsDTO itemBasicAmountDetailsDTO;

 private ItemBasicAmountDetailsSearchDTO itemBasicAmountDetailsSearchDTO;

 private List<ItemBasicAmountDetailsDTO> itemBasicAmountDetailsDTOList;

 public ItemBasicAmountDetailsDTO getItemBasicAmountDetailsDTO() {
 return itemBasicAmountDetailsDTO;
 }

 public void setItemBasicAmountDetailsDTO(ItemBasicAmountDetailsDTO itemBasicAmountDetailsDTO) {
 this.itemBasicAmountDetailsDTO = itemBasicAmountDetailsDTO;
 }

 public List<ItemBasicAmountDetailsDTO> getItemBasicAmountDetailsDTOList() {
 return itemBasicAmountDetailsDTOList;
 }

 public void setItemBasicAmountDetailsDTOList(List<ItemBasicAmountDetailsDTO> itemBasicAmountDetailsDTOList) {
 this.itemBasicAmountDetailsDTOList = itemBasicAmountDetailsDTOList;
 }

 public ItemBasicAmountDetailsSearchDTO getItemBasicAmountDetailsSearchDTO() {
 return itemBasicAmountDetailsSearchDTO;
 }

 public void setItemBasicAmountDetailsSearchDTO(ItemBasicAmountDetailsSearchDTO itemBasicAmountDetailsSearchDTO) {
 this.itemBasicAmountDetailsSearchDTO = itemBasicAmountDetailsSearchDTO;
 }

}
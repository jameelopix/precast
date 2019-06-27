package com.vme.precast.itemamountdetails.controller;

import java.util.List;

import com.vme.precast.itemamountdetails.api.ItemAmountDetailsDTO;
import com.vme.precast.itemamountdetails.api.ItemAmountDetailsSearchDTO;

import coliseum.web.BaseClientModel;

public class ItemAmountDetailsClientModel extends BaseClientModel {

 private static final long serialVersionUID = 1L;

 private ItemAmountDetailsDTO itemAmountDetailsDTO;

 private ItemAmountDetailsSearchDTO itemAmountDetailsSearchDTO;

 private List<ItemAmountDetailsDTO> itemAmountDetailsDTOList;

 public ItemAmountDetailsDTO getItemAmountDetailsDTO() {
 return itemAmountDetailsDTO;
 }

 public void setItemAmountDetailsDTO(ItemAmountDetailsDTO itemAmountDetailsDTO) {
 this.itemAmountDetailsDTO = itemAmountDetailsDTO;
 }

 public List<ItemAmountDetailsDTO> getItemAmountDetailsDTOList() {
 return itemAmountDetailsDTOList;
 }

 public void setItemAmountDetailsDTOList(List<ItemAmountDetailsDTO> itemAmountDetailsDTOList) {
 this.itemAmountDetailsDTOList = itemAmountDetailsDTOList;
 }

 public ItemAmountDetailsSearchDTO getItemAmountDetailsSearchDTO() {
 return itemAmountDetailsSearchDTO;
 }

 public void setItemAmountDetailsSearchDTO(ItemAmountDetailsSearchDTO itemAmountDetailsSearchDTO) {
 this.itemAmountDetailsSearchDTO = itemAmountDetailsSearchDTO;
 }

}
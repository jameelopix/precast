package com.vme.precast.item.api;

import coliseum.service.BaseServiceRequest;

public class ItemServiceRequest extends BaseServiceRequest {

 private static final long serialVersionUID = 1L;

 private ItemDTO itemDTO;

 private ItemSearchDTO itemSearchDTO;

 public ItemDTO getItemDTO() {
 return itemDTO;
 }

 public void setItemDTO(ItemDTO itemDTO) {
 this.itemDTO = itemDTO;
 }

 public ItemSearchDTO getItemSearchDTO() {
 return itemSearchDTO;
 }

 public void setItemSearchDTO(ItemSearchDTO itemSearchDTO) {
 this.itemSearchDTO = itemSearchDTO;
 }
}

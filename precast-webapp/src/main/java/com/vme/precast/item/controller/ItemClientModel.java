package com.vme.precast.item.controller;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.vme.precast.item.api.ItemDTO;
import com.vme.precast.item.api.ItemSearchDTO;

import coliseum.web.BaseClientModel;

@Controller
public class ItemClientModel extends BaseClientModel {

	private static final long serialVersionUID = 1L;

	private ItemDTO itemDTO;

	private ItemSearchDTO itemSearchDTO;

	private List<ItemDTO> itemDTOList;

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

	public List<ItemDTO> getItemDTOList() {
		return itemDTOList;
	}

	public void setItemDTOList(List<ItemDTO> itemDTOList) {
		this.itemDTOList = itemDTOList;
	}
}
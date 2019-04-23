package com.vme.precast.item.api;

import java.util.List;

import coliseum.service.BaseServiceResponse;

public class ItemServiceResponse extends BaseServiceResponse {

	private static final long serialVersionUID = 1L;

	private List<ItemDTO> itemDTOList;

	public List<ItemDTO> getItemDTOList() {
		return itemDTOList;
	}

	public void setItemDTOList(List<ItemDTO> itemDTOList) {
		this.itemDTOList = itemDTOList;
	}
}
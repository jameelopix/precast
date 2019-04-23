package com.vme.precast.item.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vme.precast.item.api.ItemDTO;
import com.vme.precast.item.api.ItemService;
import com.vme.precast.item.api.ItemServiceRequest;
import com.vme.precast.item.api.ItemServiceResponse;

@Controller
public class ItemController {

	@Autowired
	ItemService itemService;

	@RequestMapping(value = "deleteItem", method = RequestMethod.POST)
	@ResponseBody
	public ItemClientModel deleteItem(@RequestBody ItemClientModel itemClientModel) {
		ItemServiceRequest itemServiceRequest = new ItemServiceRequest();
		for (Long id : itemClientModel.getIdsToDelete()) {
			ItemDTO itemDTO = new ItemDTO();
			itemDTO.setId(id);
			itemServiceRequest.setItemDTO(itemDTO);
			itemService.deleteItem(itemServiceRequest);
		}
		return null;
	}

	@RequestMapping(value = "createItem", method = RequestMethod.POST)
	@ResponseBody
	public ItemClientModel createItem(@Valid @RequestBody ItemClientModel itemClientModel) {
		return this.constructWidgetModel(itemService.createItem(this.constructServiceRequest(itemClientModel)));
	}

	@RequestMapping(value = "updateItem", method = RequestMethod.POST)
	@ResponseBody
	public ItemClientModel updateItem(@Valid @RequestBody ItemClientModel itemClientModel) {
		return this.constructWidgetModel(itemService.updateItem(this.constructServiceRequest(itemClientModel)));
	}

	@RequestMapping(value = "getItem", method = RequestMethod.POST)
	@ResponseBody
	public ItemClientModel getItem(@RequestBody ItemClientModel itemClientModel) {
		return this.constructWidgetModel(itemService.getItems(this.constructServiceRequest(itemClientModel)));
	}

	private ItemClientModel constructWidgetModel(ItemServiceResponse serviceResponse) {
		ItemClientModel itemClientModel = null;
		if (serviceResponse != null) {
			itemClientModel = new ItemClientModel();
			itemClientModel.setItemDTOList(serviceResponse.getItemDTOList());
			itemClientModel.setTotalRecords(serviceResponse.getTotalRecords());
		}
		return itemClientModel;
	}

	private ItemServiceRequest constructServiceRequest(ItemClientModel itemClientModel) {
		ItemServiceRequest itemServiceRequest = new ItemServiceRequest();
		itemServiceRequest.setItemDTO(itemClientModel.getItemDTO());
		itemServiceRequest.setItemSearchDTO(itemClientModel.getItemSearchDTO());
		itemServiceRequest.setRecordstoFetch(itemClientModel.getRecordstoFetch());
		itemServiceRequest.setPageIndex(itemClientModel.getPageIndex());
		return itemServiceRequest;
	}
}

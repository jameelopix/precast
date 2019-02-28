package com.vme.precast.steelitem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vme.precast.steelitem.api.SteelItemDTO;
import com.vme.precast.steelitem.api.SteelItemService;
import com.vme.precast.steelitem.api.SteelItemServiceRequest;
import com.vme.precast.steelitem.api.SteelItemServiceResponse;
import com.vme.precast.steelitem.model.SteelItemWidgetModel;

@Controller
public class SteelItemController {

	@Autowired
	SteelItemService steelItemService;

	@InitBinder
	public void jameel(WebDataBinder webDataBinder) {
		System.out.println("SteelItemController.jameel" + webDataBinder.toString());
	}

	@RequestMapping(value = "deleteSteelItem", method = RequestMethod.POST)
	@ResponseBody
	public SteelItemWidgetModel deleteSteelItem(@RequestBody SteelItemWidgetModel widgetModel) {
		SteelItemServiceRequest serviceRequest = new SteelItemServiceRequest();
		for (Long id : widgetModel.getIdsToDelete()) {
			SteelItemDTO steelItemDTO = new SteelItemDTO();
			steelItemDTO.setId(id);
			serviceRequest.setSteelItemDTO(steelItemDTO);
			steelItemService.deleteSteelItem(serviceRequest);
		}
		return null;
	}

	@RequestMapping(value = "createSteelItem", method = RequestMethod.POST)
	@ResponseBody
	public SteelItemWidgetModel createSteelItem(@Valid @RequestBody SteelItemWidgetModel widgetModel) {
		return this.constructWidgetModel(steelItemService.createSteelItem(this.constructServiceRequest(widgetModel)));
	}

	@RequestMapping(value = "updateSteelItem", method = RequestMethod.POST)
	@ResponseBody
	public SteelItemWidgetModel updateSteelItem(@Valid @RequestBody SteelItemWidgetModel widgetModel) {
		return this.constructWidgetModel(steelItemService.updateSteelItem(this.constructServiceRequest(widgetModel)));
	}

	@RequestMapping(value = "getSteelItem", method = RequestMethod.POST)
	@ResponseBody
	public SteelItemWidgetModel getSteelItem(@RequestBody SteelItemWidgetModel widgetModel) {
		return this.constructWidgetModel(steelItemService.getSteelItems(this.constructServiceRequest(widgetModel)));
	}

	private SteelItemWidgetModel constructWidgetModel(SteelItemServiceResponse serviceResponse) {
		SteelItemWidgetModel widgetModel = new SteelItemWidgetModel();
		widgetModel.setSteelItemDTOs(serviceResponse.getSteelItemDTOs());
		widgetModel.setTotalRecords(serviceResponse.getTotalRecords());
		return widgetModel;
	}

	private SteelItemServiceRequest constructServiceRequest(SteelItemWidgetModel widgetModel) {
		SteelItemServiceRequest serviceRequest = new SteelItemServiceRequest();
		serviceRequest.setSteelItemDTO(widgetModel.getSteelItemDTO());
		serviceRequest.setSteelItemSearchDTO(widgetModel.getSteelItemSearchDTO());
		serviceRequest.setRecordstoFetch(widgetModel.getRecordstoFetch());
		serviceRequest.setPageIndex(widgetModel.getPageIndex());
		return serviceRequest;
	}
}

package com.vme.precast.mixtureitem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vme.precast.mixtureitem.api.MixtureItemDTO;
import com.vme.precast.mixtureitem.api.MixtureItemService;
import com.vme.precast.mixtureitem.api.MixtureItemServiceRequest;
import com.vme.precast.mixtureitem.api.MixtureItemServiceResponse;
import com.vme.precast.mixtureitem.model.MixtureItemWidgetModel;

@Controller
public class MixtureItemController {

	@Autowired
	MixtureItemService mixtureService;

	@RequestMapping(value = "deleteMixtureItem", method = RequestMethod.POST)
	@ResponseBody
	public MixtureItemWidgetModel deleteMixtureItem(@RequestBody MixtureItemWidgetModel widgetModel) {
		MixtureItemServiceRequest serviceRequest = new MixtureItemServiceRequest();
		for (Long id : widgetModel.getIdsToDelete()) {
			MixtureItemDTO mixtureItemDTO = new MixtureItemDTO();
			mixtureItemDTO.setId(id);
			serviceRequest.setMixtureItemDTO(mixtureItemDTO);
			mixtureService.deleteMixtureItem(serviceRequest);
		}
		return null;
	}

	@RequestMapping(value = "createMixtureItem", method = RequestMethod.POST)
	@ResponseBody
	public MixtureItemWidgetModel createMixtureItem(@RequestBody MixtureItemWidgetModel widgetModel) {
		return this.constructWidgetModel(mixtureService.createMixtureItem(this.constructServiceRequest(widgetModel)));
	}

	@RequestMapping(value = "updateMixtureItem", method = RequestMethod.POST)
	@ResponseBody
	public MixtureItemWidgetModel updateMixtureItem(@RequestBody MixtureItemWidgetModel widgetModel) {
		return this.constructWidgetModel(mixtureService.updateMixtureItem(this.constructServiceRequest(widgetModel)));
	}

	@RequestMapping(value = "getMixtureItem", method = RequestMethod.POST)
	@ResponseBody
	public MixtureItemWidgetModel getMixtureItem(@RequestBody MixtureItemWidgetModel widgetModel) {
		return this.constructWidgetModel(mixtureService.getMixtureItems(this.constructServiceRequest(widgetModel)));
	}

	private MixtureItemWidgetModel constructWidgetModel(MixtureItemServiceResponse serviceResponse) {
		MixtureItemWidgetModel widgetModel = new MixtureItemWidgetModel();
		widgetModel.setMixtureItemDTOs(serviceResponse.getMixtureItemDTOs());
		widgetModel.setTotalRecords(serviceResponse.getTotalRecords());
		return widgetModel;
	}

	private MixtureItemServiceRequest constructServiceRequest(MixtureItemWidgetModel widgetModel) {
		MixtureItemServiceRequest serviceRequest = new MixtureItemServiceRequest();
		serviceRequest.setMixtureItemDTO(widgetModel.getMixtureItemDTO());
		serviceRequest.setMixtureItemSearchDTO(widgetModel.getMixtureItemSearchDTO());
		serviceRequest.setRecordstoFetch(widgetModel.getRecordstoFetch());
		serviceRequest.setPageIndex(widgetModel.getPageIndex());
		return serviceRequest;
	}
}

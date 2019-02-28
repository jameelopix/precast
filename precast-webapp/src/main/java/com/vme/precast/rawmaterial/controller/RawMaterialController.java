package com.vme.precast.rawmaterial.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vme.precast.rawmaterial.api.RawMaterialDTO;
import com.vme.precast.rawmaterial.api.RawMaterialService;
import com.vme.precast.rawmaterial.api.RawMaterialServiceRequest;
import com.vme.precast.rawmaterial.api.RawMaterialServiceResponse;
import com.vme.precast.rawmaterial.model.RawMaterialWidgetModel;

@Controller
public class RawMaterialController {

	@Autowired(required = true)
	RawMaterialService rawMaterialService;

	@InitBinder
	public void jameel(WebDataBinder webDataBinder) {
		System.out.println("RawMaterialController.jameel" + webDataBinder.toString());
	}

	@RequestMapping(value = "deleteRawMaterial", method = RequestMethod.POST)
	@ResponseBody
	public RawMaterialWidgetModel deleteRawMaterial(@RequestBody RawMaterialWidgetModel widgetModel) {
		RawMaterialServiceRequest serviceRequest = new RawMaterialServiceRequest();
		for (Long id : widgetModel.getIdsToDelete()) {
			RawMaterialDTO projectDTO = new RawMaterialDTO();
			projectDTO.setId(id);
			serviceRequest.setRawMaterialDTO(projectDTO);
			rawMaterialService.deleteRawMaterial(serviceRequest);
		}
		return null;
	}

	@RequestMapping(value = "createRawMaterial", method = RequestMethod.POST)
	@ResponseBody
	public RawMaterialWidgetModel createRawMaterial(@Valid @RequestBody RawMaterialWidgetModel widgetModel) {
		return this
				.constructWidgetModel(rawMaterialService.createRawMaterial(this.constructServiceRequest(widgetModel)));
	}

	@RequestMapping(value = "updateRawMaterial", method = RequestMethod.POST)
	@ResponseBody
	public RawMaterialWidgetModel updateRawMaterial(@Valid @RequestBody RawMaterialWidgetModel widgetModel) {
		return this
				.constructWidgetModel(rawMaterialService.updateRawMaterial(this.constructServiceRequest(widgetModel)));
	}

	@RequestMapping(value = "getRawMaterial", method = RequestMethod.POST)
	@ResponseBody
	public RawMaterialWidgetModel getRawMaterial(@RequestBody RawMaterialWidgetModel widgetModel) {
		return this.constructWidgetModel(rawMaterialService.getRawMaterials(this.constructServiceRequest(widgetModel)));
	}

	private RawMaterialWidgetModel constructWidgetModel(RawMaterialServiceResponse serviceResponse) {
		RawMaterialWidgetModel widgetModel = new RawMaterialWidgetModel();
		widgetModel.setRawMaterialDTOs(serviceResponse.getRawMaterialDTOs());
		widgetModel.setTotalRecords(serviceResponse.getTotalRecords());
		return widgetModel;
	}

	private RawMaterialServiceRequest constructServiceRequest(RawMaterialWidgetModel widgetModel) {
		RawMaterialServiceRequest serviceRequest = new RawMaterialServiceRequest();
		serviceRequest.setRawMaterialDTO(widgetModel.getRawMaterialDTO());
		serviceRequest.setRawMaterialSearchDTO(widgetModel.getRawMaterialSearchDTO());
		serviceRequest.setRecordstoFetch(widgetModel.getRecordstoFetch());
		serviceRequest.setPageIndex(widgetModel.getPageIndex());
		return serviceRequest;
	}
}

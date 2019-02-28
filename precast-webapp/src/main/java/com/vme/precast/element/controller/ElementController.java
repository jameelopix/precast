package com.vme.precast.element.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vme.precast.element.api.ElementDTO;
import com.vme.precast.element.api.ElementService;
import com.vme.precast.element.api.ElementServiceRequest;
import com.vme.precast.element.api.ElementServiceResponse;
import com.vme.precast.element.model.ElementWidgetModel;

@Controller
public class ElementController {

	@Autowired
	ElementService elementService;

	@RequestMapping(value = "deleteElement", method = RequestMethod.POST)
	@ResponseBody
	public ElementWidgetModel deleteElement(@RequestBody ElementWidgetModel widgetModel) {
		ElementServiceRequest serviceRequest = new ElementServiceRequest();
		for (Long id : widgetModel.getIdsToDelete()) {
			ElementDTO elementDTO = new ElementDTO();
			elementDTO.setId(id);
			serviceRequest.setElementDTO(elementDTO);
			elementService.deleteElement(serviceRequest);
		}
		return null;
	}

	@RequestMapping(value = "createElement", method = RequestMethod.POST)
	@ResponseBody
	public ElementWidgetModel createElement(@RequestBody ElementWidgetModel widgetModel) {
		return this.constructWidgetModel(elementService.createElement(this.constructServiceRequest(widgetModel)));
	}

	@RequestMapping(value = "updateElement", method = RequestMethod.POST)
	@ResponseBody
	public ElementWidgetModel updateElement(@RequestBody ElementWidgetModel widgetModel) {
		return this.constructWidgetModel(elementService.updateElement(this.constructServiceRequest(widgetModel)));
	}

	@RequestMapping(value = "getElement", method = RequestMethod.POST)
	@ResponseBody
	public ElementWidgetModel getElement(@RequestBody ElementWidgetModel widgetModel) {
		return this.constructWidgetModel(elementService.getElements(this.constructServiceRequest(widgetModel)));
	}

	private ElementWidgetModel constructWidgetModel(ElementServiceResponse serviceResponse) {
		ElementWidgetModel widgetModel = new ElementWidgetModel();
		widgetModel.setElementDTOs(serviceResponse.getElementDTOs());
		widgetModel.setTotalRecords(serviceResponse.getTotalRecords());
		return widgetModel;
	}

	private ElementServiceRequest constructServiceRequest(ElementWidgetModel widgetModel) {
		ElementServiceRequest serviceRequest = new ElementServiceRequest();
		serviceRequest.setElementDTO(widgetModel.getElementDTO());
		serviceRequest.setElementSearchDTO(widgetModel.getElementSearchDTO());
		serviceRequest.setRecordstoFetch(widgetModel.getRecordstoFetch());
		serviceRequest.setPageIndex(widgetModel.getPageIndex());
		return serviceRequest;
	}
}

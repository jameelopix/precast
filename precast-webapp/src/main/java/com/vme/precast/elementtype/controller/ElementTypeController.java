package com.vme.precast.elementtype.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vme.precast.elementtype.api.ElementTypeDTO;
import com.vme.precast.elementtype.api.ElementTypeService;
import com.vme.precast.elementtype.api.ElementTypeServiceRequest;
import com.vme.precast.elementtype.api.ElementTypeServiceResponse;
import com.vme.precast.elementtype.model.ElementTypeWidgetModel;

@Controller
public class ElementTypeController {

	@Autowired
	ElementTypeService elementService;

	@RequestMapping(value = "deleteElementType", method = RequestMethod.POST)
	@ResponseBody
	public ElementTypeWidgetModel deleteElementType(@RequestBody ElementTypeWidgetModel widgetModel) {
		ElementTypeServiceRequest serviceRequest = new ElementTypeServiceRequest();
		for (Long id : widgetModel.getIdsToDelete()) {
			ElementTypeDTO elementTypeDTO = new ElementTypeDTO();
			elementTypeDTO.setId(id);
			serviceRequest.setElementTypeDTO(elementTypeDTO);
			elementService.deleteElementType(serviceRequest);
		}
		return null;
	}

	@RequestMapping(value = "createElementType", method = RequestMethod.POST)
	@ResponseBody
	public ElementTypeWidgetModel createElementType(@RequestBody ElementTypeWidgetModel widgetModel) {
		return this.constructWidgetModel(elementService.createElementType(this.constructServiceRequest(widgetModel)));
	}

	@RequestMapping(value = "updateElementType", method = RequestMethod.POST)
	@ResponseBody
	public ElementTypeWidgetModel updateElementType(@RequestBody ElementTypeWidgetModel widgetModel) {
		return this.constructWidgetModel(elementService.updateElementType(this.constructServiceRequest(widgetModel)));
	}

	@RequestMapping(value = "getElementType", method = RequestMethod.POST)
	@ResponseBody
	public ElementTypeWidgetModel getElementType(@RequestBody ElementTypeWidgetModel widgetModel) {
		return this.constructWidgetModel(elementService.getElementTypes(this.constructServiceRequest(widgetModel)));
	}

	private ElementTypeWidgetModel constructWidgetModel(ElementTypeServiceResponse serviceResponse) {
		ElementTypeWidgetModel widgetModel = new ElementTypeWidgetModel();
		widgetModel.setElementTypeDTOs(serviceResponse.getElementTypeDTOs());
		widgetModel.setTotalRecords(serviceResponse.getTotalRecords());
		return widgetModel;
	}

	private ElementTypeServiceRequest constructServiceRequest(ElementTypeWidgetModel widgetModel) {
		ElementTypeServiceRequest serviceRequest = new ElementTypeServiceRequest();
		serviceRequest.setElementTypeDTO(widgetModel.getElementTypeDTO());
		serviceRequest.setElementTypeSearchDTO(widgetModel.getElementTypeSearchDTO());
		serviceRequest.setRecordstoFetch(widgetModel.getRecordstoFetch());
		serviceRequest.setPageIndex(widgetModel.getPageIndex());
		return serviceRequest;
	}
}

package com.vme.precast.labouractivity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vme.precast.labouractivity.api.LabourActivityDTO;
import com.vme.precast.labouractivity.api.LabourActivityService;
import com.vme.precast.labouractivity.api.LabourActivityServiceRequest;
import com.vme.precast.labouractivity.api.LabourActivityServiceResponse;
import com.vme.precast.labouractivity.model.LabourActivityWidgetModel;

@Controller
public class LabourActivityController {

	@Autowired
	LabourActivityService labourActivityService;

	@RequestMapping(value = "deleteLabourActivity", method = RequestMethod.POST)
	@ResponseBody
	public LabourActivityWidgetModel deleteLabourActivity(@RequestBody LabourActivityWidgetModel widgetModel) {
		LabourActivityServiceRequest serviceRequest = new LabourActivityServiceRequest();
		for (Long id : widgetModel.getIdsToDelete()) {
			LabourActivityDTO labourActivityDTO = new LabourActivityDTO();
			labourActivityDTO.setId(id);
			serviceRequest.setLabourActivityDTO(labourActivityDTO);
			labourActivityService.deleteLabourActivity(serviceRequest);
		}
		return null;
	}

	@RequestMapping(value = "createLabourActivity", method = RequestMethod.POST)
	@ResponseBody
	public LabourActivityWidgetModel createLabourActivity(@RequestBody LabourActivityWidgetModel widgetModel) {
		return this.constructWidgetModel(
				labourActivityService.createLabourActivity(this.constructServiceRequest(widgetModel)));
	}

	@RequestMapping(value = "updateLabourActivity", method = RequestMethod.POST)
	@ResponseBody
	public LabourActivityWidgetModel updateLabourActivity(@RequestBody LabourActivityWidgetModel widgetModel) {
		return this.constructWidgetModel(
				labourActivityService.updateLabourActivity(this.constructServiceRequest(widgetModel)));
	}

	@RequestMapping(value = "getLabourActivity", method = RequestMethod.POST)
	@ResponseBody
	public LabourActivityWidgetModel getLabourActivity(@RequestBody LabourActivityWidgetModel widgetModel) {
		return this.constructWidgetModel(
				labourActivityService.getLabourActivitys(this.constructServiceRequest(widgetModel)));
	}

	private LabourActivityWidgetModel constructWidgetModel(LabourActivityServiceResponse serviceResponse) {
		LabourActivityWidgetModel widgetModel = new LabourActivityWidgetModel();
		widgetModel.setLabourActivityDTOs(serviceResponse.getLabourActivityDTOs());
		widgetModel.setTotalRecords(serviceResponse.getTotalRecords());
		return widgetModel;
	}

	private LabourActivityServiceRequest constructServiceRequest(LabourActivityWidgetModel widgetModel) {
		LabourActivityServiceRequest serviceRequest = new LabourActivityServiceRequest();
		serviceRequest.setLabourActivityDTO(widgetModel.getLabourActivityDTO());
		serviceRequest.setLabourActivitySearchDTO(widgetModel.getLabourActivitySearchDTO());
		serviceRequest.setRecordstoFetch(widgetModel.getRecordstoFetch());
		serviceRequest.setPageIndex(widgetModel.getPageIndex());
		return serviceRequest;
	}
}

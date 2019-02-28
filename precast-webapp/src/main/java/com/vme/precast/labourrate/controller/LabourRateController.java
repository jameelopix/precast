package com.vme.precast.labourrate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vme.precast.labourrate.api.LabourRateDTO;
import com.vme.precast.labourrate.api.LabourRateService;
import com.vme.precast.labourrate.api.LabourRateServiceRequest;
import com.vme.precast.labourrate.api.LabourRateServiceResponse;
import com.vme.precast.labourrate.model.LabourRateWidgetModel;

@Controller
public class LabourRateController {

	@Autowired
	LabourRateService labourRateService;

	@RequestMapping(value = "deleteLabourRate", method = RequestMethod.POST)
	@ResponseBody
	public LabourRateWidgetModel deleteLabourRate(@RequestBody LabourRateWidgetModel widgetModel) {
		LabourRateServiceRequest serviceRequest = new LabourRateServiceRequest();
		for (Long id : widgetModel.getIdsToDelete()) {
			LabourRateDTO labourRateDTO = new LabourRateDTO();
			labourRateDTO.setId(id);
			serviceRequest.setLabourRateDTO(labourRateDTO);
			labourRateService.deleteLabourRate(serviceRequest);
		}
		return null;
	}

	@RequestMapping(value = "createLabourRate", method = RequestMethod.POST)
	@ResponseBody
	public LabourRateWidgetModel createLabourRate(@RequestBody LabourRateWidgetModel widgetModel) {
		return this.constructWidgetModel(labourRateService.createLabourRate(this.constructServiceRequest(widgetModel)));
	}

	@RequestMapping(value = "updateLabourRate", method = RequestMethod.POST)
	@ResponseBody
	public LabourRateWidgetModel updateLabourRate(@RequestBody LabourRateWidgetModel widgetModel) {
		return this.constructWidgetModel(labourRateService.updateLabourRate(this.constructServiceRequest(widgetModel)));
	}

	@RequestMapping(value = "getLabourRate", method = RequestMethod.POST)
	@ResponseBody
	public LabourRateWidgetModel getLabourRate(@RequestBody LabourRateWidgetModel widgetModel) {
		return this.constructWidgetModel(labourRateService.getLabourRates(this.constructServiceRequest(widgetModel)));
	}

	private LabourRateWidgetModel constructWidgetModel(LabourRateServiceResponse serviceResponse) {
		LabourRateWidgetModel widgetModel = new LabourRateWidgetModel();
		widgetModel.setLabourRateDTOs(serviceResponse.getLabourRateDTOs());
		widgetModel.setTotalRecords(serviceResponse.getTotalRecords());
		return widgetModel;
	}

	private LabourRateServiceRequest constructServiceRequest(LabourRateWidgetModel widgetModel) {
		LabourRateServiceRequest serviceRequest = new LabourRateServiceRequest();
		serviceRequest.setLabourRateDTO(widgetModel.getLabourRateDTO());
		serviceRequest.setLabourRateSearchDTO(widgetModel.getLabourRateSearchDTO());
		serviceRequest.setRecordstoFetch(widgetModel.getRecordstoFetch());
		serviceRequest.setPageIndex(widgetModel.getPageIndex());
		return serviceRequest;
	}
}

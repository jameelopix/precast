package com.vme.precast.castingactivity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vme.precast.castingactivity.api.CastingActivityDTO;
import com.vme.precast.castingactivity.api.CastingActivityService;
import com.vme.precast.castingactivity.api.CastingActivityServiceRequest;
import com.vme.precast.castingactivity.api.CastingActivityServiceResponse;
import com.vme.precast.castingactivity.model.CastingActivityWidgetModel;

@Controller
public class CastingActivityController {

	@Autowired
	CastingActivityService castingActivityService;

	@RequestMapping(value = "deleteCastingActivity", method = RequestMethod.POST)
	@ResponseBody
	public CastingActivityWidgetModel deleteCastingActivity(@RequestBody CastingActivityWidgetModel widgetModel) {
		CastingActivityServiceRequest serviceRequest = new CastingActivityServiceRequest();
		for (Long id : widgetModel.getIdsToDelete()) {
			CastingActivityDTO castingActivityDTO = new CastingActivityDTO();
			castingActivityDTO.setId(id);
			serviceRequest.setCastingActivityDTO(castingActivityDTO);
			castingActivityService.deleteCastingActivity(serviceRequest);
		}
		return null;
	}

	@RequestMapping(value = "createCastingActivity", method = RequestMethod.POST)
	@ResponseBody
	public CastingActivityWidgetModel createCastingActivity(@RequestBody CastingActivityWidgetModel widgetModel) {
		return this.constructWidgetModel(
				castingActivityService.createCastingActivity(this.constructServiceRequest(widgetModel)));
	}

	@RequestMapping(value = "updateCastingActivity", method = RequestMethod.POST)
	@ResponseBody
	public CastingActivityWidgetModel updateCastingActivity(@RequestBody CastingActivityWidgetModel widgetModel) {
		return this.constructWidgetModel(
				castingActivityService.updateCastingActivity(this.constructServiceRequest(widgetModel)));
	}

	@RequestMapping(value = "getCastingActivity", method = RequestMethod.POST)
	@ResponseBody
	public CastingActivityWidgetModel getCastingActivity(@RequestBody CastingActivityWidgetModel widgetModel) {
		return this.constructWidgetModel(
				castingActivityService.getCastingActivitys(this.constructServiceRequest(widgetModel)));
	}

	private CastingActivityWidgetModel constructWidgetModel(CastingActivityServiceResponse serviceResponse) {
		CastingActivityWidgetModel widgetModel = new CastingActivityWidgetModel();
		widgetModel.setCastingActivityDTOs(serviceResponse.getCastingActivityDTOs());
		widgetModel.setTotalRecords(serviceResponse.getTotalRecords());
		return widgetModel;
	}

	private CastingActivityServiceRequest constructServiceRequest(CastingActivityWidgetModel widgetModel) {
		CastingActivityServiceRequest serviceRequest = new CastingActivityServiceRequest();
		serviceRequest.setCastingActivityDTO(widgetModel.getCastingActivityDTO());
		serviceRequest.setCastingActivitySearchDTO(widgetModel.getCastingActivitySearchDTO());
		serviceRequest.setRecordstoFetch(widgetModel.getRecordstoFetch());
		serviceRequest.setPageIndex(widgetModel.getPageIndex());
		return serviceRequest;
	}
}

package com.vme.precast.mixture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vme.precast.mixture.api.MixtureDTO;
import com.vme.precast.mixture.api.MixtureService;
import com.vme.precast.mixture.api.MixtureServiceRequest;
import com.vme.precast.mixture.api.MixtureServiceResponse;
import com.vme.precast.mixture.model.MixtureWidgetModel;

@Controller
public class MixtureController {

	@Autowired
	MixtureService mixtureService;

	@RequestMapping(value = "deleteMixture", method = RequestMethod.POST)
	@ResponseBody
	public MixtureWidgetModel deleteMixture(@RequestBody MixtureWidgetModel widgetModel) {
		MixtureServiceRequest serviceRequest = new MixtureServiceRequest();
		for (Long id : widgetModel.getIdsToDelete()) {
			MixtureDTO mixtureDTO = new MixtureDTO();
			mixtureDTO.setId(id);
			serviceRequest.setMixtureDTO(mixtureDTO);
			mixtureService.deleteMixture(serviceRequest);
		}
		return null;
	}

	@RequestMapping(value = "createMixture", method = RequestMethod.POST)
	@ResponseBody
	public MixtureWidgetModel createMixture(@RequestBody MixtureWidgetModel widgetModel) {
		return this.constructWidgetModel(mixtureService.createMixture(this.constructServiceRequest(widgetModel)));
	}

	@RequestMapping(value = "updateMixture", method = RequestMethod.POST)
	@ResponseBody
	public MixtureWidgetModel updateMixture(@RequestBody MixtureWidgetModel widgetModel) {
		return this.constructWidgetModel(mixtureService.updateMixture(this.constructServiceRequest(widgetModel)));
	}

	@RequestMapping(value = "getMixture", method = RequestMethod.POST)
	@ResponseBody
	public MixtureWidgetModel getMixture(@RequestBody MixtureWidgetModel widgetModel) {
		return this.constructWidgetModel(mixtureService.getMixtures(this.constructServiceRequest(widgetModel)));
	}

	private MixtureWidgetModel constructWidgetModel(MixtureServiceResponse serviceResponse) {
		MixtureWidgetModel widgetModel = new MixtureWidgetModel();
		widgetModel.setMixtureDTOs(serviceResponse.getMixtureDTOs());
		widgetModel.setTotalRecords(serviceResponse.getTotalRecords());
		return widgetModel;
	}

	private MixtureServiceRequest constructServiceRequest(MixtureWidgetModel widgetModel) {
		MixtureServiceRequest serviceRequest = new MixtureServiceRequest();
		serviceRequest.setMixtureDTO(widgetModel.getMixtureDTO());
		serviceRequest.setMixtureSearchDTO(widgetModel.getMixtureSearchDTO());
		serviceRequest.setRecordstoFetch(widgetModel.getRecordstoFetch());
		serviceRequest.setPageIndex(widgetModel.getPageIndex());
		return serviceRequest;
	}
}

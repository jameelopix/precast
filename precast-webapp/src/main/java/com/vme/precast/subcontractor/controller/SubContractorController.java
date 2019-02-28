package com.vme.precast.subcontractor.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vme.precast.subcontractor.api.SubContractorDTO;
import com.vme.precast.subcontractor.api.SubContractorService;
import com.vme.precast.subcontractor.api.SubContractorServiceRequest;
import com.vme.precast.subcontractor.api.SubContractorServiceResponse;
import com.vme.precast.subcontractor.model.SubContractorWidgetModel;

@Controller
public class SubContractorController {

	@Autowired
	SubContractorService subContractorService;

	@InitBinder
	public void jameel(WebDataBinder webDataBinder) {
		System.out.println("SubContractorController.jameel" + webDataBinder.toString());
	}

	@RequestMapping(value = "deleteSubContractor", method = RequestMethod.POST)
	@ResponseBody
	public SubContractorWidgetModel deleteSubContractor(@RequestBody SubContractorWidgetModel widgetModel) {
		SubContractorServiceRequest serviceRequest = new SubContractorServiceRequest();
		for (Long id : widgetModel.getIdsToDelete()) {
			SubContractorDTO subContractorDTO = new SubContractorDTO();
			subContractorDTO.setId(id);
			serviceRequest.setSubContractorDTO(subContractorDTO);
			subContractorService.deleteSubContractor(serviceRequest);
		}
		return null;
	}

	@RequestMapping(value = "createSubContractor", method = RequestMethod.POST)
	@ResponseBody
	public SubContractorWidgetModel createSubContractor(@Valid @RequestBody SubContractorWidgetModel widgetModel) {
		return this.constructWidgetModel(
				subContractorService.createSubContractor(this.constructServiceRequest(widgetModel)));
	}

	@RequestMapping(value = "updateSubContractor", method = RequestMethod.POST)
	@ResponseBody
	public SubContractorWidgetModel updateSubContractor(@Valid @RequestBody SubContractorWidgetModel widgetModel) {
		return this.constructWidgetModel(
				subContractorService.updateSubContractor(this.constructServiceRequest(widgetModel)));
	}

	@RequestMapping(value = "getSubContractor", method = RequestMethod.POST)
	@ResponseBody
	public SubContractorWidgetModel getSubContractor(@RequestBody SubContractorWidgetModel widgetModel) {
		return this.constructWidgetModel(
				subContractorService.getSubContractors(this.constructServiceRequest(widgetModel)));
	}

	private SubContractorWidgetModel constructWidgetModel(SubContractorServiceResponse serviceResponse) {
		SubContractorWidgetModel widgetModel = new SubContractorWidgetModel();
		widgetModel.setSubContractorDTOs(serviceResponse.getSubContractorDTOs());
		widgetModel.setTotalRecords(serviceResponse.getTotalRecords());
		return widgetModel;
	}

	private SubContractorServiceRequest constructServiceRequest(SubContractorWidgetModel widgetModel) {
		SubContractorServiceRequest serviceRequest = new SubContractorServiceRequest();
		serviceRequest.setSubContractorDTO(widgetModel.getSubContractorDTO());
		serviceRequest.setSubContractorSearchDTO(widgetModel.getSubContractorSearchDTO());
		serviceRequest.setRecordstoFetch(widgetModel.getRecordstoFetch());
		serviceRequest.setPageIndex(widgetModel.getPageIndex());
		return serviceRequest;
	}
}

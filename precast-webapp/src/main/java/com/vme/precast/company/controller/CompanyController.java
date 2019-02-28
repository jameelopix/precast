package com.vme.precast.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vme.precast.company.api.CompanyDTO;
import com.vme.precast.company.api.CompanyService;
import com.vme.precast.company.api.CompanyServiceRequest;
import com.vme.precast.company.api.CompanyServiceResponse;

@Controller
public class CompanyController {

	@Autowired
	CompanyService companyService;

	@RequestMapping(value = "deleteCompany", method = RequestMethod.POST)
	@ResponseBody
	public CompanyWidgetModel deleteCompany(@RequestBody CompanyWidgetModel widgetModel) {
		CompanyServiceRequest serviceRequest = new CompanyServiceRequest();
		for (Long id : widgetModel.getIdsToDelete()) {
			CompanyDTO companyDTO = new CompanyDTO();
			companyDTO.setId(id);
			serviceRequest.setCompanyDTO(companyDTO);
			companyService.deleteCompany(serviceRequest);
		}
		return null;
	}

	@RequestMapping(value = "createCompany", method = RequestMethod.POST)
	@ResponseBody
	public CompanyWidgetModel createCompany(@RequestBody CompanyWidgetModel widgetModel) {
		return this.constructWidgetModel(companyService.createCompany(this.constructServiceRequest(widgetModel)));
	}

	@RequestMapping(value = "updateCompany", method = RequestMethod.POST)
	@ResponseBody
	public CompanyWidgetModel updateCompany(@RequestBody CompanyWidgetModel widgetModel) {
		return this.constructWidgetModel(companyService.updateCompany(this.constructServiceRequest(widgetModel)));
	}

	@RequestMapping(value = "getCompany", method = RequestMethod.POST)
	@ResponseBody
	public CompanyWidgetModel getCompany(@RequestBody CompanyWidgetModel widgetModel) {
		return this.constructWidgetModel(companyService.getCompanys(this.constructServiceRequest(widgetModel)));
	}

	private CompanyWidgetModel constructWidgetModel(CompanyServiceResponse serviceResponse) {
		CompanyWidgetModel widgetModel = new CompanyWidgetModel();
		widgetModel.setCompanyDTOs(serviceResponse.getCompanyDTOs());
		widgetModel.setTotalRecords(serviceResponse.getTotalRecords());
		return widgetModel;
	}

	private CompanyServiceRequest constructServiceRequest(CompanyWidgetModel widgetModel) {
		CompanyServiceRequest serviceRequest = new CompanyServiceRequest();
		serviceRequest.setCompanyDTO(widgetModel.getCompanyDTO());
		serviceRequest.setCompanySearchDTO(widgetModel.getCompanySearchDTO());
		serviceRequest.setRecordstoFetch(widgetModel.getRecordstoFetch());
		serviceRequest.setPageIndex(widgetModel.getPageIndex());
		return serviceRequest;
	}
}
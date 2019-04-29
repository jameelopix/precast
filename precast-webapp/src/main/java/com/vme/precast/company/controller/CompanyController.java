package com.vme.precast.company.controller;

import javax.validation.Valid;

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
    public CompanyClientModel deleteCompany(@RequestBody CompanyClientModel companyClientModel) {
        CompanyServiceRequest companyServiceRequest = new CompanyServiceRequest();
        for (Long id : companyClientModel.getIdsToDelete()) {
            CompanyDTO companyDTO = new CompanyDTO();
            companyDTO.setId(id);
            companyServiceRequest.setCompanyDTO(companyDTO);
            companyService.deleteCompany(companyServiceRequest);
        }
        return null;
    }

    @RequestMapping(value = "createCompany", method = RequestMethod.POST)
    @ResponseBody
    public CompanyClientModel createCompany(@Valid @RequestBody CompanyClientModel companyClientModel) {
        return this.constructClientModel(companyService.createCompany(this.constructServiceRequest(companyClientModel)));
    }

    @RequestMapping(value = "updateCompany", method = RequestMethod.POST)
    @ResponseBody
    public CompanyClientModel updateCompany(@Valid @RequestBody CompanyClientModel companyClientModel) {
        return this.constructClientModel(companyService.updateCompany(this.constructServiceRequest(companyClientModel)));
    }

    @RequestMapping(value = "getCompany", method = RequestMethod.POST)
    @ResponseBody
    public CompanyClientModel getCompany(@RequestBody CompanyClientModel companyClientModel) {
        return this.constructClientModel(companyService.getCompanys(this.constructServiceRequest(companyClientModel)));
    }

    private CompanyClientModel constructClientModel(CompanyServiceResponse companyServiceResponse) {
        CompanyClientModel companyClientModel = null;
        if (companyServiceResponse != null) {
            companyClientModel = new CompanyClientModel();
            companyClientModel.setCompanyDTOList(companyServiceResponse.getCompanyDTOList());
            companyClientModel.setTotalRecords(companyServiceResponse.getTotalRecords());
        }
        return companyClientModel;
    }

    private CompanyServiceRequest constructServiceRequest(CompanyClientModel companyClientModel) {
        CompanyServiceRequest companyServiceRequest = new CompanyServiceRequest();
        companyServiceRequest.setCompanyDTO(companyClientModel.getCompanyDTO());
        companyServiceRequest.setCompanySearchDTO(companyClientModel.getCompanySearchDTO());
        companyServiceRequest.setRecordstoFetch(companyClientModel.getRecordstoFetch());
        companyServiceRequest.setPageIndex(companyClientModel.getPageIndex());
        return companyServiceRequest;
    }
}
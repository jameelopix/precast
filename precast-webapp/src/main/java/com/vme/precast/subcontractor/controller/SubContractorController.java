package com.vme.precast.subcontractor.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vme.precast.subcontractor.api.SubContractorDTO;
import com.vme.precast.subcontractor.api.SubContractorService;
import com.vme.precast.subcontractor.api.SubContractorServiceRequest;
import com.vme.precast.subcontractor.api.SubContractorServiceResponse;

@Controller
public class SubContractorController {

    @Autowired
    SubContractorService subContractorService;

    @RequestMapping(value = "deleteSubContractor", method = RequestMethod.POST)
    @ResponseBody
    public SubContractorClientModel deleteSubContractor(@RequestBody SubContractorClientModel subContractorClientModel) {
        SubContractorServiceRequest subContractorServiceRequest = new SubContractorServiceRequest();
        for (Long id : subContractorClientModel.getIdsToDelete()) {
            SubContractorDTO subContractorDTO = new SubContractorDTO();
            subContractorDTO.setId(id);
            subContractorServiceRequest.setSubContractorDTO(subContractorDTO);
            subContractorService.deleteSubContractor(subContractorServiceRequest);
        }
        return null;
    }

    @RequestMapping(value = "createSubContractor", method = RequestMethod.POST)
    @ResponseBody
    public SubContractorClientModel createSubContractor(@Valid @RequestBody SubContractorClientModel subContractorClientModel) {
        return this.constructClientModel(subContractorService.createSubContractor(this.constructServiceRequest(subContractorClientModel)));
    }

    @RequestMapping(value = "updateSubContractor", method = RequestMethod.POST)
    @ResponseBody
    public SubContractorClientModel updateSubContractor(@Valid @RequestBody SubContractorClientModel subContractorClientModel) {
        return this.constructClientModel(subContractorService.updateSubContractor(this.constructServiceRequest(subContractorClientModel)));
    }

    @RequestMapping(value = "getSubContractor", method = RequestMethod.POST)
    @ResponseBody
    public SubContractorClientModel getSubContractor(@RequestBody SubContractorClientModel subContractorClientModel) {
        return this.constructClientModel(subContractorService.getSubContractors(this.constructServiceRequest(subContractorClientModel)));
    }

    private SubContractorClientModel constructClientModel(SubContractorServiceResponse subContractorServiceResponse) {
        SubContractorClientModel subContractorClientModel = null;
        if (subContractorServiceResponse != null) {
            subContractorClientModel = new SubContractorClientModel();
            subContractorClientModel.setSubContractorDTOList(subContractorServiceResponse.getSubContractorDTOList());
            subContractorClientModel.setTotalRecords(subContractorServiceResponse.getTotalRecords());
        }
        return subContractorClientModel;
    }

    private SubContractorServiceRequest constructServiceRequest(SubContractorClientModel subContractorClientModel) {
        SubContractorServiceRequest subContractorServiceRequest = new SubContractorServiceRequest();
        subContractorServiceRequest.setSubContractorDTO(subContractorClientModel.getSubContractorDTO());
        subContractorServiceRequest.setSubContractorSearchDTO(subContractorClientModel.getSubContractorSearchDTO());
        subContractorServiceRequest.setRecordstoFetch(subContractorClientModel.getRecordstoFetch());
        subContractorServiceRequest.setPageIndex(subContractorClientModel.getPageIndex());
        return subContractorServiceRequest;
    }
}
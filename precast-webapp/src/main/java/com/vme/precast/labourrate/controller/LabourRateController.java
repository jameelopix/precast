package com.vme.precast.labourrate.controller;

import javax.validation.Valid;

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

@Controller
public class LabourRateController {

    @Autowired
    LabourRateService labourRateService;

    @RequestMapping(value = "deleteLabourRate", method = RequestMethod.POST)
    @ResponseBody
    public LabourRateClientModel deleteLabourRate(@RequestBody LabourRateClientModel labourRateClientModel) {
        LabourRateServiceRequest labourRateServiceRequest = new LabourRateServiceRequest();
        for (Long id : labourRateClientModel.getIdsToDelete()) {
            LabourRateDTO labourRateDTO = new LabourRateDTO();
            labourRateDTO.setId(id);
            labourRateServiceRequest.setLabourRateDTO(labourRateDTO);
            labourRateService.deleteLabourRate(labourRateServiceRequest);
        }
        return null;
    }

    @RequestMapping(value = "createLabourRate", method = RequestMethod.POST)
    @ResponseBody
    public LabourRateClientModel createLabourRate(@Valid @RequestBody LabourRateClientModel labourRateClientModel) {
        return this.constructClientModel(labourRateService.createLabourRate(this.constructServiceRequest(labourRateClientModel)));
    }

    @RequestMapping(value = "updateLabourRate", method = RequestMethod.POST)
    @ResponseBody
    public LabourRateClientModel updateLabourRate(@Valid @RequestBody LabourRateClientModel labourRateClientModel) {
        return this.constructClientModel(labourRateService.updateLabourRate(this.constructServiceRequest(labourRateClientModel)));
    }

    @RequestMapping(value = "getLabourRate", method = RequestMethod.POST)
    @ResponseBody
    public LabourRateClientModel getLabourRate(@RequestBody LabourRateClientModel labourRateClientModel) {
        return this.constructClientModel(labourRateService.getLabourRates(this.constructServiceRequest(labourRateClientModel)));
    }

    private LabourRateClientModel constructClientModel(LabourRateServiceResponse labourRateServiceResponse) {
        LabourRateClientModel labourRateClientModel = null;
        if (labourRateServiceResponse != null) {
            labourRateClientModel = new LabourRateClientModel();
            labourRateClientModel.setLabourRateDTOList(labourRateServiceResponse.getLabourRateDTOList());
            labourRateClientModel.setTotalRecords(labourRateServiceResponse.getTotalRecords());
        }
        return labourRateClientModel;
    }

    private LabourRateServiceRequest constructServiceRequest(LabourRateClientModel labourRateClientModel) {
        LabourRateServiceRequest labourRateServiceRequest = new LabourRateServiceRequest();
        labourRateServiceRequest.setLabourRateDTO(labourRateClientModel.getLabourRateDTO());
        labourRateServiceRequest.setLabourRateSearchDTO(labourRateClientModel.getLabourRateSearchDTO());
        labourRateServiceRequest.setRecordstoFetch(labourRateClientModel.getRecordstoFetch());
        labourRateServiceRequest.setPageIndex(labourRateClientModel.getPageIndex());
        return labourRateServiceRequest;
    }
}
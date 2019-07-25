package com.vme.precast.labourworkentry.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vme.precast.labourworkentry.api.LabourWorkEntryDTO;
import com.vme.precast.labourworkentry.api.LabourWorkEntryService;
import com.vme.precast.labourworkentry.api.LabourWorkEntryServiceRequest;
import com.vme.precast.labourworkentry.api.LabourWorkEntryServiceResponse;

@Controller
public class LabourWorkEntryController {

    @Autowired
    LabourWorkEntryService labourWorkEntryService;

    @RequestMapping(value = "deleteLabourWorkEntry", method = RequestMethod.POST)
    @ResponseBody
    public LabourWorkEntryClientModel deleteLabourWorkEntry(@RequestBody LabourWorkEntryClientModel labourWorkEntryClientModel) {
        LabourWorkEntryServiceRequest labourWorkEntryServiceRequest = new LabourWorkEntryServiceRequest();
        for (Long id : labourWorkEntryClientModel.getIdsToDelete()) {
            LabourWorkEntryDTO labourWorkEntryDTO = new LabourWorkEntryDTO();
            labourWorkEntryDTO.setId(id);
            labourWorkEntryServiceRequest.setLabourWorkEntryDTO(labourWorkEntryDTO);
            labourWorkEntryService.deleteLabourWorkEntry(labourWorkEntryServiceRequest);
        }
        return null;
    }

    @RequestMapping(value = "createLabourWorkEntry", method = RequestMethod.POST)
    @ResponseBody
    public LabourWorkEntryClientModel createLabourWorkEntry(@Valid @RequestBody LabourWorkEntryClientModel labourWorkEntryClientModel) {
        return this.constructClientModel(labourWorkEntryService.createLabourWorkEntry(this.constructServiceRequest(labourWorkEntryClientModel)));
    }

    @RequestMapping(value = "updateLabourWorkEntry", method = RequestMethod.POST)
    @ResponseBody
    public LabourWorkEntryClientModel updateLabourWorkEntry(@Valid @RequestBody LabourWorkEntryClientModel labourWorkEntryClientModel) {
        return this.constructClientModel(labourWorkEntryService.updateLabourWorkEntry(this.constructServiceRequest(labourWorkEntryClientModel)));
    }

    @RequestMapping(value = "getLabourWorkEntry", method = RequestMethod.POST)
    @ResponseBody
    public LabourWorkEntryClientModel getLabourWorkEntry(@RequestBody LabourWorkEntryClientModel labourWorkEntryClientModel) {
        return this.constructClientModel(labourWorkEntryService.getLabourWorkEntrys(this.constructServiceRequest(labourWorkEntryClientModel)));
    }

    private LabourWorkEntryClientModel constructClientModel(LabourWorkEntryServiceResponse labourWorkEntryServiceResponse) {
        LabourWorkEntryClientModel labourWorkEntryClientModel = null;
        if (labourWorkEntryServiceResponse != null) {
            labourWorkEntryClientModel = new LabourWorkEntryClientModel();
            labourWorkEntryClientModel.setLabourWorkEntryDTOList(labourWorkEntryServiceResponse.getLabourWorkEntryDTOList());
            labourWorkEntryClientModel.setTotalRecords(labourWorkEntryServiceResponse.getTotalRecords());
        }
        return labourWorkEntryClientModel;
    }

    private LabourWorkEntryServiceRequest constructServiceRequest(LabourWorkEntryClientModel labourWorkEntryClientModel) {
        LabourWorkEntryServiceRequest labourWorkEntryServiceRequest = new LabourWorkEntryServiceRequest();
        labourWorkEntryServiceRequest.setLabourWorkEntryDTO(labourWorkEntryClientModel.getLabourWorkEntryDTO());
        labourWorkEntryServiceRequest.setLabourWorkEntrySearchDTO(labourWorkEntryClientModel.getLabourWorkEntrySearchDTO());
        labourWorkEntryServiceRequest.setRecordstoFetch(labourWorkEntryClientModel.getRecordstoFetch());
        labourWorkEntryServiceRequest.setPageIndex(labourWorkEntryClientModel.getPageIndex());
        return labourWorkEntryServiceRequest;
    }
}
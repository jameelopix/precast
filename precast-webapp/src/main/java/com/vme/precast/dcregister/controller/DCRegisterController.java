package com.vme.precast.dcregister.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vme.precast.dcregister.api.DCRegisterDTO;
import com.vme.precast.dcregister.api.DCRegisterService;
import com.vme.precast.dcregister.api.DCRegisterServiceRequest;
import com.vme.precast.dcregister.api.DCRegisterServiceResponse;

@Controller
public class DCRegisterController {

    @Autowired
    DCRegisterService dCRegisterService;

    @RequestMapping(value = "deleteDCRegister", method = RequestMethod.POST)
    @ResponseBody
    public DCRegisterClientModel deleteDCRegister(@RequestBody DCRegisterClientModel dCRegisterClientModel) {
        DCRegisterServiceRequest dCRegisterServiceRequest = new DCRegisterServiceRequest();
        for (Long id : dCRegisterClientModel.getIdsToDelete()) {
            DCRegisterDTO dCRegisterDTO = new DCRegisterDTO();
            dCRegisterDTO.setId(id);
            dCRegisterServiceRequest.setDCRegisterDTO(dCRegisterDTO);
            dCRegisterService.deleteDCRegister(dCRegisterServiceRequest);
        }
        return null;
    }

    @RequestMapping(value = "createDCRegister", method = RequestMethod.POST)
    @ResponseBody
    public DCRegisterClientModel createDCRegister(@Valid @RequestBody DCRegisterClientModel dCRegisterClientModel) {
        return this.constructClientModel(dCRegisterService.createDCRegister(this.constructServiceRequest(dCRegisterClientModel)));
    }

    @RequestMapping(value = "updateDCRegister", method = RequestMethod.POST)
    @ResponseBody
    public DCRegisterClientModel updateDCRegister(@Valid @RequestBody DCRegisterClientModel dCRegisterClientModel) {
        return this.constructClientModel(dCRegisterService.updateDCRegister(this.constructServiceRequest(dCRegisterClientModel)));
    }

    @RequestMapping(value = "getDCRegister", method = RequestMethod.POST)
    @ResponseBody
    public DCRegisterClientModel getDCRegister(@RequestBody DCRegisterClientModel dCRegisterClientModel) {
        return this.constructClientModel(dCRegisterService.getDCRegisters(this.constructServiceRequest(dCRegisterClientModel)));
    }

    private DCRegisterClientModel constructClientModel(DCRegisterServiceResponse dCRegisterServiceResponse) {
        DCRegisterClientModel dCRegisterClientModel = null;
        if (dCRegisterServiceResponse != null) {
            dCRegisterClientModel = new DCRegisterClientModel();
            dCRegisterClientModel.setDCRegisterDTOList(dCRegisterServiceResponse.getDCRegisterDTOList());
            dCRegisterClientModel.setTotalRecords(dCRegisterServiceResponse.getTotalRecords());
        }
        return dCRegisterClientModel;
    }

    private DCRegisterServiceRequest constructServiceRequest(DCRegisterClientModel dCRegisterClientModel) {
        DCRegisterServiceRequest dCRegisterServiceRequest = new DCRegisterServiceRequest();
        dCRegisterServiceRequest.setDCRegisterDTO(dCRegisterClientModel.getDCRegisterDTO());
        dCRegisterServiceRequest.setDCRegisterSearchDTO(dCRegisterClientModel.getDCRegisterSearchDTO());
        dCRegisterServiceRequest.setRecordstoFetch(dCRegisterClientModel.getRecordstoFetch());
        dCRegisterServiceRequest.setPageIndex(dCRegisterClientModel.getPageIndex());
        return dCRegisterServiceRequest;
    }
}
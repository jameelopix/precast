package com.vme.precast.dcitem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vme.precast.dcitem.api.DCItemDTO;
import com.vme.precast.dcitem.api.DCItemService;
import com.vme.precast.dcitem.api.DCItemServiceRequest;
import com.vme.precast.dcitem.api.DCItemServiceResponse;

@Controller
public class DCItemController {

    @Autowired
    DCItemService dCItemService;

    @RequestMapping(value = "deleteDCItem", method = RequestMethod.POST)
    @ResponseBody
    public DCItemClientModel deleteDCItem(@RequestBody DCItemClientModel dCItemClientModel) {
        DCItemServiceRequest dCItemServiceRequest = new DCItemServiceRequest();
        for (Long id : dCItemClientModel.getIdsToDelete()) {
            DCItemDTO dCItemDTO = new DCItemDTO();
            dCItemDTO.setId(id);
            dCItemServiceRequest.setDCItemDTO(dCItemDTO);
            dCItemService.deleteDCItem(dCItemServiceRequest);
        }
        return null;
    }

    @RequestMapping(value = "createDCItem", method = RequestMethod.POST)
    @ResponseBody
    public DCItemClientModel createDCItem(@Valid @RequestBody DCItemClientModel dCItemClientModel) {
        return this.constructClientModel(dCItemService.createDCItem(this.constructServiceRequest(dCItemClientModel)));
    }

    @RequestMapping(value = "updateDCItem", method = RequestMethod.POST)
    @ResponseBody
    public DCItemClientModel updateDCItem(@Valid @RequestBody DCItemClientModel dCItemClientModel) {
        return this.constructClientModel(dCItemService.updateDCItem(this.constructServiceRequest(dCItemClientModel)));
    }

    @RequestMapping(value = "getDCItem", method = RequestMethod.POST)
    @ResponseBody
    public DCItemClientModel getDCItem(@RequestBody DCItemClientModel dCItemClientModel) {
        return this.constructClientModel(dCItemService.getDCItems(this.constructServiceRequest(dCItemClientModel)));
    }

    private DCItemClientModel constructClientModel(DCItemServiceResponse dCItemServiceResponse) {
        DCItemClientModel dCItemClientModel = null;
        if (dCItemServiceResponse != null) {
            dCItemClientModel = new DCItemClientModel();
            dCItemClientModel.setDCItemDTOList(dCItemServiceResponse.getDCItemDTOList());
            dCItemClientModel.setTotalRecords(dCItemServiceResponse.getTotalRecords());
        }
        return dCItemClientModel;
    }

    private DCItemServiceRequest constructServiceRequest(DCItemClientModel dCItemClientModel) {
        DCItemServiceRequest dCItemServiceRequest = new DCItemServiceRequest();
        dCItemServiceRequest.setDCItemDTO(dCItemClientModel.getDCItemDTO());
        dCItemServiceRequest.setDCItemSearchDTO(dCItemClientModel.getDCItemSearchDTO());
        dCItemServiceRequest.setRecordstoFetch(dCItemClientModel.getRecordstoFetch());
        dCItemServiceRequest.setPageIndex(dCItemClientModel.getPageIndex());
        return dCItemServiceRequest;
    }
}
package com.vme.precast.partymaster.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vme.precast.partymaster.api.PartyMasterDTO;
import com.vme.precast.partymaster.api.PartyMasterService;
import com.vme.precast.partymaster.api.PartyMasterServiceRequest;
import com.vme.precast.partymaster.api.PartyMasterServiceResponse;

@Controller
public class PartyMasterController {

    @Autowired
    PartyMasterService partyMasterService;

    @RequestMapping(value = "deletePartyMaster", method = RequestMethod.POST)
    @ResponseBody
    public PartyMasterClientModel deletePartyMaster(@RequestBody PartyMasterClientModel partyMasterClientModel) {
        PartyMasterServiceRequest partyMasterServiceRequest = new PartyMasterServiceRequest();
        for (Long id : partyMasterClientModel.getIdsToDelete()) {
            PartyMasterDTO partyMasterDTO = new PartyMasterDTO();
            partyMasterDTO.setId(id);
            partyMasterServiceRequest.setPartyMasterDTO(partyMasterDTO);
            partyMasterService.deletePartyMaster(partyMasterServiceRequest);
        }
        return null;
    }

    @RequestMapping(value = "createPartyMaster", method = RequestMethod.POST)
    @ResponseBody
    public PartyMasterClientModel createPartyMaster(@Valid @RequestBody PartyMasterClientModel partyMasterClientModel) {
        return this.constructClientModel(partyMasterService.createPartyMaster(this.constructServiceRequest(partyMasterClientModel)));
    }

    @RequestMapping(value = "updatePartyMaster", method = RequestMethod.POST)
    @ResponseBody
    public PartyMasterClientModel updatePartyMaster(@Valid @RequestBody PartyMasterClientModel partyMasterClientModel) {
        return this.constructClientModel(partyMasterService.updatePartyMaster(this.constructServiceRequest(partyMasterClientModel)));
    }

    @RequestMapping(value = "getPartyMaster", method = RequestMethod.POST)
    @ResponseBody
    public PartyMasterClientModel getPartyMaster(@RequestBody PartyMasterClientModel partyMasterClientModel) {
        return this.constructClientModel(partyMasterService.getPartyMasters(this.constructServiceRequest(partyMasterClientModel)));
    }

    private PartyMasterClientModel constructClientModel(PartyMasterServiceResponse partyMasterServiceResponse) {
        PartyMasterClientModel partyMasterClientModel = null;
        if (partyMasterServiceResponse != null) {
            partyMasterClientModel = new PartyMasterClientModel();
            partyMasterClientModel.setPartyMasterDTOList(partyMasterServiceResponse.getPartyMasterDTOList());
            partyMasterClientModel.setTotalRecords(partyMasterServiceResponse.getTotalRecords());
        }
        return partyMasterClientModel;
    }

    private PartyMasterServiceRequest constructServiceRequest(PartyMasterClientModel partyMasterClientModel) {
        PartyMasterServiceRequest partyMasterServiceRequest = new PartyMasterServiceRequest();
        partyMasterServiceRequest.setPartyMasterDTO(partyMasterClientModel.getPartyMasterDTO());
        partyMasterServiceRequest.setPartyMasterSearchDTO(partyMasterClientModel.getPartyMasterSearchDTO());
        partyMasterServiceRequest.setRecordstoFetch(partyMasterClientModel.getRecordstoFetch());
        partyMasterServiceRequest.setPageIndex(partyMasterClientModel.getPageIndex());
        return partyMasterServiceRequest;
    }
}
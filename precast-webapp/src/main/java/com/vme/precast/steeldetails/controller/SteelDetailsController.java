package com.vme.precast.steeldetails.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vme.precast.steeldetails.api.SteelDetailsDTO;
import com.vme.precast.steeldetails.api.SteelDetailsService;
import com.vme.precast.steeldetails.api.SteelDetailsServiceRequest;
import com.vme.precast.steeldetails.api.SteelDetailsServiceResponse;

@Controller
public class SteelDetailsController {

    @Autowired
    SteelDetailsService steelDetailsService;

    @RequestMapping(value = "deleteSteelDetails", method = RequestMethod.POST)
    @ResponseBody
    public SteelDetailsClientModel deleteSteelDetails(@RequestBody SteelDetailsClientModel steelDetailsClientModel) {
        SteelDetailsServiceRequest steelDetailsServiceRequest = new SteelDetailsServiceRequest();
        for (Long id : steelDetailsClientModel.getIdsToDelete()) {
            SteelDetailsDTO steelDetailsDTO = new SteelDetailsDTO();
            steelDetailsDTO.setId(id);
            steelDetailsServiceRequest.setSteelDetailsDTO(steelDetailsDTO);
            steelDetailsService.deleteSteelDetails(steelDetailsServiceRequest);
        }
        return null;
    }

    @RequestMapping(value = "createSteelDetails", method = RequestMethod.POST)
    @ResponseBody
    public SteelDetailsClientModel createSteelDetails(@Valid @RequestBody SteelDetailsClientModel steelDetailsClientModel) {
        return this.constructClientModel(steelDetailsService.createSteelDetails(this.constructServiceRequest(steelDetailsClientModel)));
    }

    @RequestMapping(value = "updateSteelDetails", method = RequestMethod.POST)
    @ResponseBody
    public SteelDetailsClientModel updateSteelDetails(@Valid @RequestBody SteelDetailsClientModel steelDetailsClientModel) {
        return this.constructClientModel(steelDetailsService.updateSteelDetails(this.constructServiceRequest(steelDetailsClientModel)));
    }

    @RequestMapping(value = "getSteelDetails", method = RequestMethod.POST)
    @ResponseBody
    public SteelDetailsClientModel getSteelDetails(@RequestBody SteelDetailsClientModel steelDetailsClientModel) {
        return this.constructClientModel(steelDetailsService.getSteelDetailss(this.constructServiceRequest(steelDetailsClientModel)));
    }

    private SteelDetailsClientModel constructClientModel(SteelDetailsServiceResponse steelDetailsServiceResponse) {
        SteelDetailsClientModel steelDetailsClientModel = null;
        if (steelDetailsServiceResponse != null) {
            steelDetailsClientModel = new SteelDetailsClientModel();
            steelDetailsClientModel.setSteelDetailsDTOList(steelDetailsServiceResponse.getSteelDetailsDTOList());
            steelDetailsClientModel.setTotalRecords(steelDetailsServiceResponse.getTotalRecords());
        }
        return steelDetailsClientModel;
    }

    private SteelDetailsServiceRequest constructServiceRequest(SteelDetailsClientModel steelDetailsClientModel) {
        SteelDetailsServiceRequest steelDetailsServiceRequest = new SteelDetailsServiceRequest();
        steelDetailsServiceRequest.setSteelDetailsDTO(steelDetailsClientModel.getSteelDetailsDTO());
        steelDetailsServiceRequest.setSteelDetailsSearchDTO(steelDetailsClientModel.getSteelDetailsSearchDTO());
        steelDetailsServiceRequest.setRecordstoFetch(steelDetailsClientModel.getRecordstoFetch());
        steelDetailsServiceRequest.setPageIndex(steelDetailsClientModel.getPageIndex());
        return steelDetailsServiceRequest;
    }
}
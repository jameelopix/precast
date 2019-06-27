package com.vme.precast.elementdetails.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vme.precast.elementdetails.api.ElementDetailsDTO;
import com.vme.precast.elementdetails.api.ElementDetailsService;
import com.vme.precast.elementdetails.api.ElementDetailsServiceRequest;
import com.vme.precast.elementdetails.api.ElementDetailsServiceResponse;

@Controller
public class ElementDetailsController {

    @Autowired
    ElementDetailsService elementDetailsService;

    @RequestMapping(value = "deleteElementDetails", method = RequestMethod.POST)
    @ResponseBody
    public ElementDetailsClientModel deleteElementDetails(@RequestBody ElementDetailsClientModel elementDetailsClientModel) {
        ElementDetailsServiceRequest elementDetailsServiceRequest = new ElementDetailsServiceRequest();
        for (Long id : elementDetailsClientModel.getIdsToDelete()) {
            ElementDetailsDTO elementDetailsDTO = new ElementDetailsDTO();
            elementDetailsDTO.setId(id);
            elementDetailsServiceRequest.setElementDetailsDTO(elementDetailsDTO);
            elementDetailsService.deleteElementDetails(elementDetailsServiceRequest);
        }
        return null;
    }

    @RequestMapping(value = "createElementDetails", method = RequestMethod.POST)
    @ResponseBody
    public ElementDetailsClientModel createElementDetails(@Valid @RequestBody ElementDetailsClientModel elementDetailsClientModel) {
        return this.constructClientModel(elementDetailsService.createElementDetails(this.constructServiceRequest(elementDetailsClientModel)));
    }

    @RequestMapping(value = "updateElementDetails", method = RequestMethod.POST)
    @ResponseBody
    public ElementDetailsClientModel updateElementDetails(@Valid @RequestBody ElementDetailsClientModel elementDetailsClientModel) {
        return this.constructClientModel(elementDetailsService.updateElementDetails(this.constructServiceRequest(elementDetailsClientModel)));
    }

    @RequestMapping(value = "getElementDetails", method = RequestMethod.POST)
    @ResponseBody
    public ElementDetailsClientModel getElementDetails(@RequestBody ElementDetailsClientModel elementDetailsClientModel) {
        return this.constructClientModel(elementDetailsService.getElementDetailss(this.constructServiceRequest(elementDetailsClientModel)));
    }

    private ElementDetailsClientModel constructClientModel(ElementDetailsServiceResponse elementDetailsServiceResponse) {
        ElementDetailsClientModel elementDetailsClientModel = null;
        if (elementDetailsServiceResponse != null) {
            elementDetailsClientModel = new ElementDetailsClientModel();
            elementDetailsClientModel.setElementDetailsDTOList(elementDetailsServiceResponse.getElementDetailsDTOList());
            elementDetailsClientModel.setTotalRecords(elementDetailsServiceResponse.getTotalRecords());
        }
        return elementDetailsClientModel;
    }

    private ElementDetailsServiceRequest constructServiceRequest(ElementDetailsClientModel elementDetailsClientModel) {
        ElementDetailsServiceRequest elementDetailsServiceRequest = new ElementDetailsServiceRequest();
        elementDetailsServiceRequest.setElementDetailsDTO(elementDetailsClientModel.getElementDetailsDTO());
        elementDetailsServiceRequest.setElementDetailsSearchDTO(elementDetailsClientModel.getElementDetailsSearchDTO());
        elementDetailsServiceRequest.setRecordstoFetch(elementDetailsClientModel.getRecordstoFetch());
        elementDetailsServiceRequest.setPageIndex(elementDetailsClientModel.getPageIndex());
        return elementDetailsServiceRequest;
    }
}
package com.vme.precast.element.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vme.precast.element.api.ElementDTO;
import com.vme.precast.element.api.ElementService;
import com.vme.precast.element.api.ElementServiceRequest;
import com.vme.precast.element.api.ElementServiceResponse;

@Controller
public class ElementController {

    @Autowired
    ElementService elementService;

    @RequestMapping(value = "deleteElement", method = RequestMethod.POST)
    @ResponseBody
    public ElementClientModel deleteElement(@RequestBody ElementClientModel elementClientModel) {
        ElementServiceRequest elementServiceRequest = new ElementServiceRequest();
        for (Long id : elementClientModel.getIdsToDelete()) {
            ElementDTO elementDTO = new ElementDTO();
            elementDTO.setId(id);
            elementServiceRequest.setElementDTO(elementDTO);
            elementService.deleteElement(elementServiceRequest);
        }
        return null;
    }

    @RequestMapping(value = "createElement", method = RequestMethod.POST)
    @ResponseBody
    public ElementClientModel createElement(@Valid @RequestBody ElementClientModel elementClientModel) {
        return this.constructClientModel(elementService.createElement(this.constructServiceRequest(elementClientModel)));
    }

    @RequestMapping(value = "updateElement", method = RequestMethod.POST)
    @ResponseBody
    public ElementClientModel updateElement(@Valid @RequestBody ElementClientModel elementClientModel) {
        return this.constructClientModel(elementService.updateElement(this.constructServiceRequest(elementClientModel)));
    }

    @RequestMapping(value = "getElement", method = RequestMethod.POST)
    @ResponseBody
    public ElementClientModel getElement(@RequestBody ElementClientModel elementClientModel) {
        return this.constructClientModel(elementService.getElements(this.constructServiceRequest(elementClientModel)));
    }

    private ElementClientModel constructClientModel(ElementServiceResponse elementServiceResponse) {
        ElementClientModel elementClientModel = null;
        if (elementServiceResponse != null) {
            elementClientModel = new ElementClientModel();
            elementClientModel.setElementDTOList(elementServiceResponse.getElementDTOList());
            elementClientModel.setTotalRecords(elementServiceResponse.getTotalRecords());
        }
        return elementClientModel;
    }

    private ElementServiceRequest constructServiceRequest(ElementClientModel elementClientModel) {
        ElementServiceRequest elementServiceRequest = new ElementServiceRequest();
        elementServiceRequest.setElementDTO(elementClientModel.getElementDTO());
        elementServiceRequest.setElementSearchDTO(elementClientModel.getElementSearchDTO());
        elementServiceRequest.setRecordstoFetch(elementClientModel.getRecordstoFetch());
        elementServiceRequest.setPageIndex(elementClientModel.getPageIndex());
        return elementServiceRequest;
    }
}
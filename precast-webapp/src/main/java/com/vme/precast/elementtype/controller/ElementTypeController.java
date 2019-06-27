package com.vme.precast.elementtype.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vme.precast.elementtype.api.ElementTypeDTO;
import com.vme.precast.elementtype.api.ElementTypeService;
import com.vme.precast.elementtype.api.ElementTypeServiceRequest;
import com.vme.precast.elementtype.api.ElementTypeServiceResponse;

@Controller
public class ElementTypeController {

    @Autowired
    ElementTypeService elementTypeService;

    @RequestMapping(value = "deleteElementType", method = RequestMethod.POST)
    @ResponseBody
    public ElementTypeClientModel deleteElementType(@RequestBody ElementTypeClientModel elementTypeClientModel) {
        ElementTypeServiceRequest elementTypeServiceRequest = new ElementTypeServiceRequest();
        for (Long id : elementTypeClientModel.getIdsToDelete()) {
            ElementTypeDTO elementTypeDTO = new ElementTypeDTO();
            elementTypeDTO.setId(id);
            elementTypeServiceRequest.setElementTypeDTO(elementTypeDTO);
            elementTypeService.deleteElementType(elementTypeServiceRequest);
        }
        return null;
    }

    @RequestMapping(value = "createElementType", method = RequestMethod.POST)
    @ResponseBody
    public ElementTypeClientModel createElementType(@Valid @RequestBody ElementTypeClientModel elementTypeClientModel) {
        return this.constructClientModel(elementTypeService.createElementType(this.constructServiceRequest(elementTypeClientModel)));
    }

    @RequestMapping(value = "updateElementType", method = RequestMethod.POST)
    @ResponseBody
    public ElementTypeClientModel updateElementType(@Valid @RequestBody ElementTypeClientModel elementTypeClientModel) {
        return this.constructClientModel(elementTypeService.updateElementType(this.constructServiceRequest(elementTypeClientModel)));
    }

    @RequestMapping(value = "getElementType", method = RequestMethod.POST)
    @ResponseBody
    public ElementTypeClientModel getElementType(@RequestBody ElementTypeClientModel elementTypeClientModel) {
        return this.constructClientModel(elementTypeService.getElementTypes(this.constructServiceRequest(elementTypeClientModel)));
    }

    private ElementTypeClientModel constructClientModel(ElementTypeServiceResponse elementTypeServiceResponse) {
        ElementTypeClientModel elementTypeClientModel = null;
        if (elementTypeServiceResponse != null) {
            elementTypeClientModel = new ElementTypeClientModel();
            elementTypeClientModel.setElementTypeDTOList(elementTypeServiceResponse.getElementTypeDTOList());
            elementTypeClientModel.setTotalRecords(elementTypeServiceResponse.getTotalRecords());
        }
        return elementTypeClientModel;
    }

    private ElementTypeServiceRequest constructServiceRequest(ElementTypeClientModel elementTypeClientModel) {
        ElementTypeServiceRequest elementTypeServiceRequest = new ElementTypeServiceRequest();
        elementTypeServiceRequest.setElementTypeDTO(elementTypeClientModel.getElementTypeDTO());
        elementTypeServiceRequest.setElementTypeSearchDTO(elementTypeClientModel.getElementTypeSearchDTO());
        elementTypeServiceRequest.setRecordstoFetch(elementTypeClientModel.getRecordstoFetch());
        elementTypeServiceRequest.setPageIndex(elementTypeClientModel.getPageIndex());
        return elementTypeServiceRequest;
    }
}
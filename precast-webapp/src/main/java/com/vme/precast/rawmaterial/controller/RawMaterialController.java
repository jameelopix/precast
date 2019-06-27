package com.vme.precast.rawmaterial.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vme.precast.rawmaterial.api.RawMaterialDTO;
import com.vme.precast.rawmaterial.api.RawMaterialService;
import com.vme.precast.rawmaterial.api.RawMaterialServiceRequest;
import com.vme.precast.rawmaterial.api.RawMaterialServiceResponse;

@Controller
public class RawMaterialController {

    @Autowired
    RawMaterialService rawMaterialService;

    @RequestMapping(value = "deleteRawMaterial", method = RequestMethod.POST)
    @ResponseBody
    public RawMaterialClientModel deleteRawMaterial(@RequestBody RawMaterialClientModel rawMaterialClientModel) {
        RawMaterialServiceRequest rawMaterialServiceRequest = new RawMaterialServiceRequest();
        for (Long id : rawMaterialClientModel.getIdsToDelete()) {
            RawMaterialDTO rawMaterialDTO = new RawMaterialDTO();
            rawMaterialDTO.setId(id);
            rawMaterialServiceRequest.setRawMaterialDTO(rawMaterialDTO);
            rawMaterialService.deleteRawMaterial(rawMaterialServiceRequest);
        }
        return null;
    }

    @RequestMapping(value = "createRawMaterial", method = RequestMethod.POST)
    @ResponseBody
    public RawMaterialClientModel createRawMaterial(@Valid @RequestBody RawMaterialClientModel rawMaterialClientModel) {
        return this.constructClientModel(rawMaterialService.createRawMaterial(this.constructServiceRequest(rawMaterialClientModel)));
    }

    @RequestMapping(value = "updateRawMaterial", method = RequestMethod.POST)
    @ResponseBody
    public RawMaterialClientModel updateRawMaterial(@Valid @RequestBody RawMaterialClientModel rawMaterialClientModel) {
        return this.constructClientModel(rawMaterialService.updateRawMaterial(this.constructServiceRequest(rawMaterialClientModel)));
    }

    @RequestMapping(value = "getRawMaterial", method = RequestMethod.POST)
    @ResponseBody
    public RawMaterialClientModel getRawMaterial(@RequestBody RawMaterialClientModel rawMaterialClientModel) {
        return this.constructClientModel(rawMaterialService.getRawMaterials(this.constructServiceRequest(rawMaterialClientModel)));
    }

    private RawMaterialClientModel constructClientModel(RawMaterialServiceResponse rawMaterialServiceResponse) {
        RawMaterialClientModel rawMaterialClientModel = null;
        if (rawMaterialServiceResponse != null) {
            rawMaterialClientModel = new RawMaterialClientModel();
            rawMaterialClientModel.setRawMaterialDTOList(rawMaterialServiceResponse.getRawMaterialDTOList());
            rawMaterialClientModel.setTotalRecords(rawMaterialServiceResponse.getTotalRecords());
        }
        return rawMaterialClientModel;
    }

    private RawMaterialServiceRequest constructServiceRequest(RawMaterialClientModel rawMaterialClientModel) {
        RawMaterialServiceRequest rawMaterialServiceRequest = new RawMaterialServiceRequest();
        rawMaterialServiceRequest.setRawMaterialDTO(rawMaterialClientModel.getRawMaterialDTO());
        rawMaterialServiceRequest.setRawMaterialSearchDTO(rawMaterialClientModel.getRawMaterialSearchDTO());
        rawMaterialServiceRequest.setRecordstoFetch(rawMaterialClientModel.getRecordstoFetch());
        rawMaterialServiceRequest.setPageIndex(rawMaterialClientModel.getPageIndex());
        return rawMaterialServiceRequest;
    }
}
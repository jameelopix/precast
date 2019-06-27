package com.vme.precast.mixtureitem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vme.precast.mixtureitem.api.MixtureItemDTO;
import com.vme.precast.mixtureitem.api.MixtureItemService;
import com.vme.precast.mixtureitem.api.MixtureItemServiceRequest;
import com.vme.precast.mixtureitem.api.MixtureItemServiceResponse;

@Controller
public class MixtureItemController {

    @Autowired
    MixtureItemService mixtureItemService;

    @RequestMapping(value = "deleteMixtureItem", method = RequestMethod.POST)
    @ResponseBody
    public MixtureItemClientModel deleteMixtureItem(@RequestBody MixtureItemClientModel mixtureItemClientModel) {
        MixtureItemServiceRequest mixtureItemServiceRequest = new MixtureItemServiceRequest();
        for (Long id : mixtureItemClientModel.getIdsToDelete()) {
            MixtureItemDTO mixtureItemDTO = new MixtureItemDTO();
            mixtureItemDTO.setId(id);
            mixtureItemServiceRequest.setMixtureItemDTO(mixtureItemDTO);
            mixtureItemService.deleteMixtureItem(mixtureItemServiceRequest);
        }
        return null;
    }

    @RequestMapping(value = "createMixtureItem", method = RequestMethod.POST)
    @ResponseBody
    public MixtureItemClientModel createMixtureItem(@Valid @RequestBody MixtureItemClientModel mixtureItemClientModel) {
        return this.constructClientModel(mixtureItemService.createMixtureItem(this.constructServiceRequest(mixtureItemClientModel)));
    }

    @RequestMapping(value = "updateMixtureItem", method = RequestMethod.POST)
    @ResponseBody
    public MixtureItemClientModel updateMixtureItem(@Valid @RequestBody MixtureItemClientModel mixtureItemClientModel) {
        return this.constructClientModel(mixtureItemService.updateMixtureItem(this.constructServiceRequest(mixtureItemClientModel)));
    }

    @RequestMapping(value = "getMixtureItem", method = RequestMethod.POST)
    @ResponseBody
    public MixtureItemClientModel getMixtureItem(@RequestBody MixtureItemClientModel mixtureItemClientModel) {
        return this.constructClientModel(mixtureItemService.getMixtureItems(this.constructServiceRequest(mixtureItemClientModel)));
    }

    private MixtureItemClientModel constructClientModel(MixtureItemServiceResponse mixtureItemServiceResponse) {
        MixtureItemClientModel mixtureItemClientModel = null;
        if (mixtureItemServiceResponse != null) {
            mixtureItemClientModel = new MixtureItemClientModel();
            mixtureItemClientModel.setMixtureItemDTOList(mixtureItemServiceResponse.getMixtureItemDTOList());
            mixtureItemClientModel.setTotalRecords(mixtureItemServiceResponse.getTotalRecords());
        }
        return mixtureItemClientModel;
    }

    private MixtureItemServiceRequest constructServiceRequest(MixtureItemClientModel mixtureItemClientModel) {
        MixtureItemServiceRequest mixtureItemServiceRequest = new MixtureItemServiceRequest();
        mixtureItemServiceRequest.setMixtureItemDTO(mixtureItemClientModel.getMixtureItemDTO());
        mixtureItemServiceRequest.setMixtureItemSearchDTO(mixtureItemClientModel.getMixtureItemSearchDTO());
        mixtureItemServiceRequest.setRecordstoFetch(mixtureItemClientModel.getRecordstoFetch());
        mixtureItemServiceRequest.setPageIndex(mixtureItemClientModel.getPageIndex());
        return mixtureItemServiceRequest;
    }
}
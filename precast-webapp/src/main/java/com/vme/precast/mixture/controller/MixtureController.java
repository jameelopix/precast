package com.vme.precast.mixture.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vme.precast.mixture.api.MixtureDTO;
import com.vme.precast.mixture.api.MixtureService;
import com.vme.precast.mixture.api.MixtureServiceRequest;
import com.vme.precast.mixture.api.MixtureServiceResponse;

@Controller
public class MixtureController {

    @Autowired
    MixtureService mixtureService;

    @RequestMapping(value = "deleteMixture", method = RequestMethod.POST)
    @ResponseBody
    public MixtureClientModel deleteMixture(@RequestBody MixtureClientModel mixtureClientModel) {
        MixtureServiceRequest mixtureServiceRequest = new MixtureServiceRequest();
        for (Long id : mixtureClientModel.getIdsToDelete()) {
            MixtureDTO mixtureDTO = new MixtureDTO();
            mixtureDTO.setId(id);
            mixtureServiceRequest.setMixtureDTO(mixtureDTO);
            mixtureService.deleteMixture(mixtureServiceRequest);
        }
        return null;
    }

    @RequestMapping(value = "createMixture", method = RequestMethod.POST)
    @ResponseBody
    public MixtureClientModel createMixture(@Valid @RequestBody MixtureClientModel mixtureClientModel) {
        return this.constructClientModel(mixtureService.createMixture(this.constructServiceRequest(mixtureClientModel)));
    }

    @RequestMapping(value = "updateMixture", method = RequestMethod.POST)
    @ResponseBody
    public MixtureClientModel updateMixture(@Valid @RequestBody MixtureClientModel mixtureClientModel) {
        return this.constructClientModel(mixtureService.updateMixture(this.constructServiceRequest(mixtureClientModel)));
    }

    @RequestMapping(value = "getMixture", method = RequestMethod.POST)
    @ResponseBody
    public MixtureClientModel getMixture(@RequestBody MixtureClientModel mixtureClientModel) {
        return this.constructClientModel(mixtureService.getMixtures(this.constructServiceRequest(mixtureClientModel)));
    }

    private MixtureClientModel constructClientModel(MixtureServiceResponse mixtureServiceResponse) {
        MixtureClientModel mixtureClientModel = null;
        if (mixtureServiceResponse != null) {
            mixtureClientModel = new MixtureClientModel();
            mixtureClientModel.setMixtureDTOList(mixtureServiceResponse.getMixtureDTOList());
            mixtureClientModel.setTotalRecords(mixtureServiceResponse.getTotalRecords());
        }
        return mixtureClientModel;
    }

    private MixtureServiceRequest constructServiceRequest(MixtureClientModel mixtureClientModel) {
        MixtureServiceRequest mixtureServiceRequest = new MixtureServiceRequest();
        mixtureServiceRequest.setMixtureDTO(mixtureClientModel.getMixtureDTO());
        mixtureServiceRequest.setMixtureSearchDTO(mixtureClientModel.getMixtureSearchDTO());
        mixtureServiceRequest.setRecordstoFetch(mixtureClientModel.getRecordstoFetch());
        mixtureServiceRequest.setPageIndex(mixtureClientModel.getPageIndex());
        return mixtureServiceRequest;
    }
}
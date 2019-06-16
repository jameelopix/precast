package com.vme.precast.costcentre.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vme.precast.costcentre.api.CostCentreDTO;
import com.vme.precast.costcentre.api.CostCentreService;
import com.vme.precast.costcentre.api.CostCentreServiceRequest;
import com.vme.precast.costcentre.api.CostCentreServiceResponse;

@Controller
public class CostCentreController {

    @Autowired
    CostCentreService costCentreService;

    @RequestMapping(value = "deleteCostCentre", method = RequestMethod.POST)
    @ResponseBody
    public CostCentreClientModel deleteCostCentre(@RequestBody CostCentreClientModel costCentreClientModel) {
        CostCentreServiceRequest costCentreServiceRequest = new CostCentreServiceRequest();
        for (Long id : costCentreClientModel.getIdsToDelete()) {
            CostCentreDTO costCentreDTO = new CostCentreDTO();
            costCentreDTO.setId(id);
            costCentreServiceRequest.setCostCentreDTO(costCentreDTO);
            costCentreService.deleteCostCentre(costCentreServiceRequest);
        }
        return null;
    }

    @RequestMapping(value = "createCostCentre", method = RequestMethod.POST)
    @ResponseBody
    public CostCentreClientModel createCostCentre(@Valid @RequestBody CostCentreClientModel costCentreClientModel) {
        return this.constructClientModel(
                costCentreService.createCostCentre(this.constructServiceRequest(costCentreClientModel)));
    }

    @RequestMapping(value = "updateCostCentre", method = RequestMethod.POST)
    @ResponseBody
    public CostCentreClientModel updateCostCentre(@Valid @RequestBody CostCentreClientModel costCentreClientModel) {
        return this.constructClientModel(
                costCentreService.updateCostCentre(this.constructServiceRequest(costCentreClientModel)));
    }

    @RequestMapping(value = "getCostCentre", method = RequestMethod.POST)
    @ResponseBody
    public CostCentreClientModel getCostCentre(@RequestBody CostCentreClientModel costCentreClientModel) {
        return this.constructClientModel(
                costCentreService.getCostCentres(this.constructServiceRequest(costCentreClientModel)));
    }

    private CostCentreClientModel constructClientModel(CostCentreServiceResponse costCentreServiceResponse) {
        CostCentreClientModel costCentreClientModel = null;
        if (costCentreServiceResponse != null) {
            costCentreClientModel = new CostCentreClientModel();
            costCentreClientModel.setCostCentreDTOList(costCentreServiceResponse.getCostCentreDTOList());
            costCentreClientModel.setTotalRecords(costCentreServiceResponse.getTotalRecords());
        }
        return costCentreClientModel;
    }

    private CostCentreServiceRequest constructServiceRequest(CostCentreClientModel costCentreClientModel) {
        CostCentreServiceRequest costCentreServiceRequest = new CostCentreServiceRequest();
        costCentreServiceRequest.setCostCentreDTO(costCentreClientModel.getCostCentreDTO());
        costCentreServiceRequest.setCostCentreSearchDTO(costCentreClientModel.getCostCentreSearchDTO());
        costCentreServiceRequest.setRecordstoFetch(costCentreClientModel.getRecordstoFetch());
        costCentreServiceRequest.setPageIndex(costCentreClientModel.getPageIndex());
        return costCentreServiceRequest;
    }
}
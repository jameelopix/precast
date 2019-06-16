package com.vme.precast.costcentre.controller;

import java.util.List;

import com.vme.precast.costcentre.api.CostCentreDTO;
import com.vme.precast.costcentre.api.CostCentreSearchDTO;

import coliseum.web.BaseClientModel;

public class CostCentreClientModel extends BaseClientModel {

    private static final long serialVersionUID = 1L;

    private CostCentreDTO costCentreDTO;

    private CostCentreSearchDTO costCentreSearchDTO;

    private List<CostCentreDTO> costCentreDTOList;

    public CostCentreDTO getCostCentreDTO() {
        return costCentreDTO;
    }

    public void setCostCentreDTO(CostCentreDTO costCentreDTO) {
        this.costCentreDTO = costCentreDTO;
    }

    public List<CostCentreDTO> getCostCentreDTOList() {
        return costCentreDTOList;
    }

    public void setCostCentreDTOList(List<CostCentreDTO> costCentreDTOList) {
        this.costCentreDTOList = costCentreDTOList;
    }

    public CostCentreSearchDTO getCostCentreSearchDTO() {
        return costCentreSearchDTO;
    }

    public void setCostCentreSearchDTO(CostCentreSearchDTO costCentreSearchDTO) {
        this.costCentreSearchDTO = costCentreSearchDTO;
    }

}
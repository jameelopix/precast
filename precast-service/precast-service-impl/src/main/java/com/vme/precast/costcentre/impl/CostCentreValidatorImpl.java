package com.vme.precast.costcentre.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.costcentre.api.CostCentreServiceRequest;
import com.vme.precast.costcentre.api.CostCentreValidator;
import com.vme.precast.repository.CostCentreRepo;

import coliseum.service.ErrorDTO;

public class CostCentreValidatorImpl implements CostCentreValidator {
    @Autowired
    CostCentreRepo costCentreRepo;

    @Override
    public ErrorDTO checkCostCentreDuplicate(CostCentreServiceRequest costCentreServiceRequest) {
        return null;
    }
}
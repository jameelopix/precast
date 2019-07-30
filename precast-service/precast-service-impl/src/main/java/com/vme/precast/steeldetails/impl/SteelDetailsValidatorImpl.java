package com.vme.precast.steeldetails.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.domain.SteelDetails;
import com.vme.precast.repository.SteelDetailsRepo;
import com.vme.precast.steeldetails.api.SteelDetailsDTO;
import com.vme.precast.steeldetails.api.SteelDetailsSearchDTO;
import com.vme.precast.steeldetails.api.SteelDetailsServiceRequest;
import com.vme.precast.steeldetails.api.SteelDetailsValidator;

import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;
import coliseum.service.ErrorDTO;
import coliseum.service.FilterUtils;

public class SteelDetailsValidatorImpl implements SteelDetailsValidator {
    @Autowired
    SteelDetailsRepo steelDetailsRepo;

    @Override
    public ErrorDTO checkSteelDetailsDuplicate(SteelDetailsServiceRequest steelDetailsServiceRequest) {
        ErrorDTO errorDTO = null;
        SteelDetailsDTO steelDetailsDTO = steelDetailsServiceRequest.getSteelDetailsDTO();

        SearchObject searchObject = new SearchObject();
        List<Filter> filters = new ArrayList<>();
        FilterUtils.createEqualFilter(filters, SteelDetailsSearchDTO.ELEMENTID, steelDetailsDTO.getElementId());
        FilterUtils.createEqualFilter(filters, SteelDetailsSearchDTO.RAWMATERIALNAME,
                steelDetailsDTO.getRawMaterialName());
        if (CollectionUtils.isNotEmpty(filters)) {
            searchObject.setFilters(filters);
        }
        List<SteelDetails> steelDetailsList = steelDetailsRepo.search(searchObject);

        if (CollectionUtils.isNotEmpty(steelDetailsList)) {
            for (SteelDetails steelDetails : steelDetailsList) {
                if (!steelDetails.getId().equals(steelDetailsDTO.getId())) {
                    errorDTO = new ErrorDTO("ERR_VR_100", "Steel Information already exists!!!");
                    break;
                }
            }
        }
        return errorDTO;
    }
}
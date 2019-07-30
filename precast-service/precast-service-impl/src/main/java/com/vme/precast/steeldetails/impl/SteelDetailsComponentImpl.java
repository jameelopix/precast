package com.vme.precast.steeldetails.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.domain.Element;
import com.vme.precast.domain.SteelDetails;
import com.vme.precast.repository.ElementRepo;
import com.vme.precast.repository.SteelDetailsRepo;
import com.vme.precast.steeldetails.api.SteelDetailsComponent;
import com.vme.precast.steeldetails.api.SteelDetailsDTO;
import com.vme.precast.steeldetails.api.SteelDetailsSearchDTO;
import com.vme.precast.steeldetails.api.SteelDetailsServiceRequest;
import com.vme.precast.steeldetails.api.SteelDetailsServiceResponse;

import coliseum.jpa.Association;
import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;
import coliseum.service.AssociationUtils;
import coliseum.service.ConversionUtility;
import coliseum.service.FilterUtils;

public class SteelDetailsComponentImpl implements SteelDetailsComponent {
    @Autowired
    SteelDetailsRepo steelDetailsRepo;
    @Autowired
    ElementRepo elementRepo;

    @Autowired
    ConversionUtility conversionUtility;

    @Override
    public SteelDetailsServiceResponse createSteelDetails(SteelDetailsServiceRequest steelDetailsServiceRequest) {
        SteelDetailsDTO steelDetailsDTO = steelDetailsServiceRequest.getSteelDetailsDTO();
        SteelDetails steeldetails = (SteelDetails) conversionUtility.convert(steelDetailsDTO, SteelDetailsDTO.class,
                SteelDetails.class);
        if (steelDetailsDTO.getElementId() != null) {
            Element element = elementRepo.findById(steelDetailsDTO.getElementId()).get();
            steeldetails.setElement(element);
        }
        steelDetailsRepo.save(steeldetails);
        return null;
    }

    @Override
    public SteelDetailsServiceResponse getSteelDetailss(SteelDetailsServiceRequest steelDetailsServiceRequest) {
        List<SteelDetails> steelDetailsList = new ArrayList<>();
        List<Filter> filters = new ArrayList<>();
        SearchObject searchObject = new SearchObject();
        List<Association> associations = new ArrayList<>();

        SteelDetailsSearchDTO steelDetailsSearchDTO = steelDetailsServiceRequest.getSteelDetailsSearchDTO();
        if (steelDetailsSearchDTO != null) {
            List<Long> idList = steelDetailsSearchDTO.getIdList();
            List<String> rawMaterialNameList = steelDetailsSearchDTO.getRawMaterialNameList();
            List<Long> elementIdList = steelDetailsSearchDTO.getElementIdList();
            List<String> unitList = steelDetailsSearchDTO.getUnitList();
            List<Double> theoriticalQuantityList = steelDetailsSearchDTO.getTheoriticalQuantityList();

            FilterUtils.createEqualFilter(filters, SteelDetailsSearchDTO.ID, idList);
            FilterUtils.createEqualFilter(filters, SteelDetailsSearchDTO.RAWMATERIALNAME, rawMaterialNameList);
            FilterUtils.createEqualFilter(filters, SteelDetailsSearchDTO.UNIT, unitList);
            FilterUtils.createEqualFilter(filters, SteelDetailsSearchDTO.THEORITICALQUANTITY, theoriticalQuantityList);
            FilterUtils.createEqualFilter(filters, SteelDetailsSearchDTO.ELEMENTID, elementIdList);

            if (CollectionUtils.isNotEmpty(filters)) {
                searchObject.setFilters(filters);
            }

            AssociationUtils.createAssociation(associations, SteelDetailsSearchDTO.ELEMENT,
                    steelDetailsSearchDTO.getElementNeeded());

            if (CollectionUtils.isNotEmpty(associations)) {
                searchObject.setAssociations(associations);
            }
        }
        searchObject.setPageIndex(steelDetailsServiceRequest.getPageIndex());
        searchObject.setRecordstoFetch(steelDetailsServiceRequest.getRecordstoFetch());
        steelDetailsList = steelDetailsRepo.search(searchObject);

        List<SteelDetailsDTO> steelDetailsDTOList = new ArrayList<>();
        for (SteelDetails target : steelDetailsList) {
            steelDetailsDTOList.add(
                    (SteelDetailsDTO) conversionUtility.convert(target, SteelDetails.class, SteelDetailsDTO.class));
        }
        SteelDetailsServiceResponse steelDetailsServiceResponse = new SteelDetailsServiceResponse();
        steelDetailsServiceResponse.setSteelDetailsDTOList(steelDetailsDTOList);
        return steelDetailsServiceResponse;
    }

    @Override
    public SteelDetailsServiceResponse updateSteelDetails(SteelDetailsServiceRequest steelDetailsServiceRequest) {
        SteelDetailsDTO source = steelDetailsServiceRequest.getSteelDetailsDTO();

        SteelDetails target = steelDetailsRepo.findById(source.getId()).get();
        target.setRawMaterialName(source.getRawMaterialName());
        target.setUnit(source.getUnit());
        target.setTheoriticalQuantity(source.getTheoriticalQuantity());

        if (source.getElementId() != null && !source.getElementId().equals(target.getElementId())) {
            Element element = elementRepo.findById(source.getElementId()).get();
            target.setElement(element);
        }
        steelDetailsRepo.save(target);
        return null;
    }

    @Override
    public SteelDetailsServiceResponse deleteSteelDetails(SteelDetailsServiceRequest steelDetailsServiceRequest) {
        SteelDetailsDTO steelDetailsDTO = steelDetailsServiceRequest.getSteelDetailsDTO();
        steelDetailsRepo.deleteById(steelDetailsDTO.getId());
        return null;
    }
}
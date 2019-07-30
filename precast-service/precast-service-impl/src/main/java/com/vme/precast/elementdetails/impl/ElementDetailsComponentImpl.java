package com.vme.precast.elementdetails.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.domain.Element;
import com.vme.precast.domain.ElementDetails;
import com.vme.precast.elementdetails.api.ElementDetailsComponent;
import com.vme.precast.elementdetails.api.ElementDetailsDTO;
import com.vme.precast.elementdetails.api.ElementDetailsSearchDTO;
import com.vme.precast.elementdetails.api.ElementDetailsServiceRequest;
import com.vme.precast.elementdetails.api.ElementDetailsServiceResponse;
import com.vme.precast.repository.ElementDetailsRepo;
import com.vme.precast.repository.ElementRepo;

import coliseum.jpa.Association;
import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;
import coliseum.service.AssociationUtils;
import coliseum.service.ConversionUtility;
import coliseum.service.FilterUtils;

public class ElementDetailsComponentImpl implements ElementDetailsComponent {
    @Autowired
    ElementDetailsRepo elementDetailsRepo;

    @Autowired
    ElementRepo elementRepo;

    @Autowired
    ConversionUtility conversionUtility;

    @Override
    public ElementDetailsServiceResponse createElementDetails(
            ElementDetailsServiceRequest elementDetailsServiceRequest) {
        ElementDetailsDTO elementDetailsDTO = elementDetailsServiceRequest.getElementDetailsDTO();
        ElementDetails elementdetails = (ElementDetails) conversionUtility.convert(elementDetailsDTO,
                ElementDetailsDTO.class, ElementDetails.class);

        if (elementDetailsDTO.getElementId() != null) {
            Element element = elementRepo.findById(elementDetailsDTO.getElementId()).get();
            elementdetails.setElement(element);
        }
        elementDetailsRepo.save(elementdetails);
        return null;
    }

    @Override
    public ElementDetailsServiceResponse getElementDetailss(ElementDetailsServiceRequest elementDetailsServiceRequest) {
        List<ElementDetails> elementDetailsList = new ArrayList<>();
        List<Filter> filters = new ArrayList<>();
        SearchObject searchObject = new SearchObject();
        List<Association> associations = new ArrayList<>();

        ElementDetailsSearchDTO elementDetailsSearchDTO = elementDetailsServiceRequest.getElementDetailsSearchDTO();
        if (elementDetailsSearchDTO != null) {
            List<Long> ids = elementDetailsSearchDTO.getIdList();
            List<Double> weightList = elementDetailsSearchDTO.getWeightList();
            List<Double> lengthList = elementDetailsSearchDTO.getLengthList();
            List<Double> widthList = elementDetailsSearchDTO.getWidthList();
            List<Double> thicknessList = elementDetailsSearchDTO.getThicknessList();
            List<Double> theoriticalQuantityList = elementDetailsSearchDTO.getTheoriticalQuantityList();
            List<String> unitList = elementDetailsSearchDTO.getUnitList();
            List<String> mixDesignNameList = elementDetailsSearchDTO.getMixDesignNameList();
            List<Long> elementIdList = elementDetailsSearchDTO.getElementIdList();

            FilterUtils.createEqualFilter(filters, ElementDetailsSearchDTO.ID, ids);
            FilterUtils.createEqualFilter(filters, ElementDetailsSearchDTO.MIXDESIGNNAME, mixDesignNameList);
            FilterUtils.createEqualFilter(filters, ElementDetailsSearchDTO.WEIGHT, weightList);
            FilterUtils.createEqualFilter(filters, ElementDetailsSearchDTO.LENGTH, lengthList);
            FilterUtils.createEqualFilter(filters, ElementDetailsSearchDTO.WIDTH, widthList);
            FilterUtils.createEqualFilter(filters, ElementDetailsSearchDTO.THICKNESS, thicknessList);
            FilterUtils.createEqualFilter(filters, ElementDetailsSearchDTO.THEORITICALQUANTITY,
                    theoriticalQuantityList);
            FilterUtils.createEqualFilter(filters, ElementDetailsSearchDTO.UNIT, unitList);
            FilterUtils.createEqualFilter(filters, ElementDetailsSearchDTO.ELEMENTID, elementIdList);

            if (CollectionUtils.isNotEmpty(filters)) {
                searchObject.setFilters(filters);
            }

            AssociationUtils.createAssociation(associations, ElementDetailsSearchDTO.ELEMENT,
                    elementDetailsSearchDTO.getElementNeeded());

            if (CollectionUtils.isNotEmpty(associations)) {
                searchObject.setAssociations(associations);
            }
        }
        searchObject.setPageIndex(elementDetailsServiceRequest.getPageIndex());
        searchObject.setRecordstoFetch(elementDetailsServiceRequest.getRecordstoFetch());
        elementDetailsList = elementDetailsRepo.search(searchObject);

        List<ElementDetailsDTO> elementDetailsDTOList = new ArrayList<>();
        for (ElementDetails target : elementDetailsList) {
            elementDetailsDTOList.add((ElementDetailsDTO) conversionUtility.convert(target, ElementDetails.class,
                    ElementDetailsDTO.class));
        }
        ElementDetailsServiceResponse elementDetailsServiceResponse = new ElementDetailsServiceResponse();
        elementDetailsServiceResponse.setElementDetailsDTOList(elementDetailsDTOList);
        return elementDetailsServiceResponse;
    }

    @Override
    public ElementDetailsServiceResponse updateElementDetails(
            ElementDetailsServiceRequest elementDetailsServiceRequest) {
        ElementDetailsDTO source = elementDetailsServiceRequest.getElementDetailsDTO();

        ElementDetails target = elementDetailsRepo.findById(source.getId()).get();
        target.setMixDesignName(source.getMixDesignName());
        target.setWeight(source.getWeight());
        target.setLength(source.getLength());
        target.setWidth(source.getWidth());
        target.setThickness(source.getThickness());
        target.setTheoriticalQuantity(source.getTheoriticalQuantity());
        target.setUnit(source.getUnit());

        if (source.getElementId() != null && !source.getElementId().equals(target.getElementId())) {
            Element element = elementRepo.findById(source.getElementId()).get();
            target.setElement(element);
        }

        elementDetailsRepo.save(target);
        return null;
    }

    @Override
    public ElementDetailsServiceResponse deleteElementDetails(
            ElementDetailsServiceRequest elementDetailsServiceRequest) {
        ElementDetailsDTO elementDetailsDTO = elementDetailsServiceRequest.getElementDetailsDTO();
        elementDetailsRepo.deleteById(elementDetailsDTO.getId());
        return null;
    }
}
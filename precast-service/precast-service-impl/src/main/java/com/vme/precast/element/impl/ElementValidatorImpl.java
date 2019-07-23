package com.vme.precast.element.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.domain.Element;
import com.vme.precast.repository.ElementRepo;
import com.vme.precast.element.api.ElementDTO;
import com.vme.precast.element.api.ElementSearchDTO;
import com.vme.precast.element.api.ElementServiceRequest;
import com.vme.precast.element.api.ElementValidator;

import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;
import coliseum.service.ErrorDTO;
import coliseum.service.FilterUtils;

public class ElementValidatorImpl implements ElementValidator {
    @Autowired
    ElementRepo elementRepo;

    @Override
    public ErrorDTO checkElementDuplicate(ElementServiceRequest elementServiceRequest) {
        ErrorDTO errorDTO = null;
        ElementDTO elementDTO = elementServiceRequest.getElementDTO();

        SearchObject searchObject = new SearchObject();
        List<Filter> filters = new ArrayList<>();
        FilterUtils.createEqualFilter(filters, ElementSearchDTO.PROJECTID, elementDTO.getProjectId());
        FilterUtils.createEqualFilter(filters, ElementSearchDTO.NAME, elementDTO.getName());
        if (CollectionUtils.isNotEmpty(filters)) {
            searchObject.setFilters(filters);
        }
        List<Element> elementList = elementRepo.search(searchObject);

        if (CollectionUtils.isNotEmpty(elementList)) {
            for (Element element : elementList) {
                if (!element.getId().equals(elementDTO.getId())) {
                    errorDTO = new ErrorDTO("ERR_VR_100", "Element already exists!!!");
                    break;
                }
            }
        }
        return errorDTO;
    }
}
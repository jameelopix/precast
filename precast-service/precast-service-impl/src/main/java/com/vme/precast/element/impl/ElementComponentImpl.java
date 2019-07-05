package com.vme.precast.element.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.domain.Element;
import com.vme.precast.domain.ElementType;
import com.vme.precast.domain.Project;
import com.vme.precast.element.api.ElementComponent;
import com.vme.precast.element.api.ElementDTO;
import com.vme.precast.element.api.ElementSearchDTO;
import com.vme.precast.element.api.ElementServiceRequest;
import com.vme.precast.element.api.ElementServiceResponse;
import com.vme.precast.repository.ElementRepo;
import com.vme.precast.repository.ElementTypeRepo;
import com.vme.precast.repository.ProjectRepo;

import coliseum.jpa.Association;
import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;
import coliseum.service.AssociationUtils;
import coliseum.service.ConversionUtility;
import coliseum.service.FilterUtils;

public class ElementComponentImpl implements ElementComponent {
    @Autowired
    ElementRepo elementRepo;

    @Autowired
    ElementTypeRepo elementTypeRepo;

    @Autowired
    ProjectRepo projectRepo;

    @Autowired
    ConversionUtility conversionUtility;

    @Override
    public ElementServiceResponse createElement(ElementServiceRequest elementServiceRequest) {
        ElementDTO elementDTO = elementServiceRequest.getElementDTO();
        Element element = (Element) conversionUtility.convert(elementDTO, ElementDTO.class, Element.class);

        if (elementDTO.getProjectId() != null) {
            Project project = projectRepo.findById(elementDTO.getProjectId()).get();
            element.setProject(project);
        }
        if (elementDTO.getElementTypeId() != null) {
            ElementType elementType = elementTypeRepo.findById(elementDTO.getElementTypeId()).get();
            element.setElementType(elementType);
        }
        elementRepo.save(element);
        return null;
    }

    @Override
    public ElementServiceResponse getElements(ElementServiceRequest elementServiceRequest) {
        List<Element> elementList = new ArrayList<>();
        List<Filter> filters = new ArrayList<>();
        SearchObject searchObject = new SearchObject();
        List<Association> associations = new ArrayList<>();

        ElementSearchDTO elementSearchDTO = elementServiceRequest.getElementSearchDTO();
        if (elementSearchDTO != null) {
            List<Long> ids = elementSearchDTO.getIdList();
            List<String> nameList = elementSearchDTO.getNameList();
            List<String> floorList = elementSearchDTO.getFloorList();
            List<Long> elementTypeIdList = elementSearchDTO.getElementTypeIdList();
            List<Long> projectIdList = elementSearchDTO.getProjectIdList();

            FilterUtils.createEqualFilter(filters, ElementSearchDTO.ID, ids);
            FilterUtils.createEqualFilter(filters, ElementSearchDTO.NAME, nameList);
            FilterUtils.createEqualFilter(filters, ElementSearchDTO.FLOOR, floorList);
            FilterUtils.createEqualFilter(filters, ElementSearchDTO.ELEMENTTYPEID, elementTypeIdList);
            FilterUtils.createEqualFilter(filters, ElementSearchDTO.PROJECTID, projectIdList);

            if (CollectionUtils.isNotEmpty(filters)) {
                searchObject.setFilters(filters);
            }

            AssociationUtils.createAssociation(associations, ElementSearchDTO.PROJECT,
                    elementSearchDTO.getProjectNeeded());

            if (CollectionUtils.isNotEmpty(associations)) {
                searchObject.setAssociations(associations);
            }

            AssociationUtils.createAssociation(associations, ElementSearchDTO.ELEMENTTYPE,
                    elementSearchDTO.getElementTypeNeeded());

            if (CollectionUtils.isNotEmpty(associations)) {
                searchObject.setAssociations(associations);
            }
        }
        searchObject.setPageIndex(elementServiceRequest.getPageIndex());
        searchObject.setRecordstoFetch(elementServiceRequest.getRecordstoFetch());
        elementList = elementRepo.search(searchObject);

        List<ElementDTO> elementDTOList = new ArrayList<>();
        for (Element target : elementList) {
            elementDTOList.add((ElementDTO) conversionUtility.convert(target, Element.class, ElementDTO.class));
        }
        ElementServiceResponse elementServiceResponse = new ElementServiceResponse();
        elementServiceResponse.setElementDTOList(elementDTOList);
        return elementServiceResponse;
    }

    @Override
    public ElementServiceResponse updateElement(ElementServiceRequest elementServiceRequest) {
        ElementDTO source = elementServiceRequest.getElementDTO();

        Element target = elementRepo.findById(source.getId()).get();
        target.setName(source.getName());
        target.setFloor(source.getFloor());

        if (source.getElementTypeId() != null && !source.getElementTypeId().equals(target.getElementTypeId())) {
            ElementType elementType = elementTypeRepo.findById(source.getElementTypeId()).get();
            target.setElementType(elementType);
        }
        if (source.getProjectId() != null && !source.getProjectId().equals(target.getProjectId())) {
            Project project = projectRepo.findById(source.getProjectId()).get();
            target.setProject(project);
        }
        elementRepo.save(target);
        return null;
    }

    @Override
    public ElementServiceResponse deleteElement(ElementServiceRequest elementServiceRequest) {
        ElementDTO elementDTO = elementServiceRequest.getElementDTO();
        elementRepo.deleteById(elementDTO.getId());
        return null;
    }
}
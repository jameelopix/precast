package com.vme.precast.elementtype.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.domain.ElementType;
import com.vme.precast.domain.Project;
import com.vme.precast.elementtype.api.ElementTypeComponent;
import com.vme.precast.elementtype.api.ElementTypeDTO;
import com.vme.precast.elementtype.api.ElementTypeSearchDTO;
import com.vme.precast.elementtype.api.ElementTypeServiceRequest;
import com.vme.precast.elementtype.api.ElementTypeServiceResponse;
import com.vme.precast.repository.ElementTypeRepo;
import com.vme.precast.repository.ProjectRepo;

import coliseum.jpa.Association;
import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;
import coliseum.service.AssociationUtils;
import coliseum.service.ConversionUtility;
import coliseum.service.FilterUtils;

public class ElementTypeComponentImpl implements ElementTypeComponent {
    @Autowired
    ElementTypeRepo elementTypeRepo;

    @Autowired
    ProjectRepo projectRepo;

    @Autowired
    ConversionUtility conversionUtility;

    @Override
    public ElementTypeServiceResponse createElementType(ElementTypeServiceRequest elementTypeServiceRequest) {
        ElementTypeDTO elementTypeDTO = elementTypeServiceRequest.getElementTypeDTO();
        ElementType elementtype = (ElementType) conversionUtility.convert(elementTypeDTO, ElementTypeDTO.class,
                ElementType.class);

        if (elementTypeDTO.getProjectDTOId() != null) {
            Project project = projectRepo.findById(elementTypeDTO.getProjectDTOId()).get();
            elementtype.setProject(project);
        }
        elementTypeRepo.save(elementtype);
        return null;
    }

    @Override
    public ElementTypeServiceResponse getElementTypes(ElementTypeServiceRequest elementTypeServiceRequest) {
        List<ElementType> elementTypeList = new ArrayList<>();
        List<Filter> filters = new ArrayList<>();
        List<Association> associations = new ArrayList<>();
        SearchObject searchObject = new SearchObject();

        ElementTypeSearchDTO elementTypeSearchDTO = elementTypeServiceRequest.getElementTypeSearchDTO();
        if (elementTypeSearchDTO != null) {
            List<Long> ids = elementTypeSearchDTO.getIdList();
            List<String> nameList = elementTypeSearchDTO.getNameList();

            FilterUtils.createEqualFilter(filters, ElementTypeSearchDTO.ID, ids);
            FilterUtils.createEqualFilter(filters, ElementTypeSearchDTO.NAME, nameList);
            if (CollectionUtils.isNotEmpty(filters)) {
                searchObject.setFilters(filters);
            }

            AssociationUtils.createAssociation(associations, ElementTypeSearchDTO.PROJECT,
                    elementTypeSearchDTO.getProjectNeeded());

            if (CollectionUtils.isNotEmpty(associations)) {
                searchObject.setAssociations(associations);
            }
        }
        searchObject.setPageIndex(elementTypeServiceRequest.getPageIndex());
        searchObject.setRecordstoFetch(elementTypeServiceRequest.getRecordstoFetch());
        elementTypeList = elementTypeRepo.search(searchObject);

        List<ElementTypeDTO> elementTypeDTOList = new ArrayList<>();
        for (ElementType target : elementTypeList) {
            elementTypeDTOList
                    .add((ElementTypeDTO) conversionUtility.convert(target, ElementType.class, ElementTypeDTO.class));
        }
        ElementTypeServiceResponse elementTypeServiceResponse = new ElementTypeServiceResponse();
        elementTypeServiceResponse.setElementTypeDTOList(elementTypeDTOList);
        return elementTypeServiceResponse;
    }

    @Override
    public ElementTypeServiceResponse updateElementType(ElementTypeServiceRequest elementTypeServiceRequest) {
        ElementTypeDTO source = elementTypeServiceRequest.getElementTypeDTO();

        ElementType target = elementTypeRepo.findById(source.getId()).get();
        target.setName(source.getName());

        if (source.getProjectDTOId() != null && !source.getProjectDTOId().equals(target.getProjectId())) {
            Project project = projectRepo.findById(source.getProjectDTOId()).get();
            target.setProject(project);
        }
        elementTypeRepo.save(target);
        return null;
    }

    @Override
    public ElementTypeServiceResponse deleteElementType(ElementTypeServiceRequest elementTypeServiceRequest) {
        ElementTypeDTO elementTypeDTO = elementTypeServiceRequest.getElementTypeDTO();
        elementTypeRepo.deleteById(elementTypeDTO.getId());
        return null;
    }
}
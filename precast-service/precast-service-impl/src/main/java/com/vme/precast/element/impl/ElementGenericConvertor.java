package com.vme.precast.element.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import com.vme.precast.domain.Element;
import com.vme.precast.domain.ElementType;
import com.vme.precast.domain.Project;
import com.vme.precast.element.api.ElementDTO;
import com.vme.precast.elementtype.api.ElementTypeDTO;
import com.vme.precast.project.api.ProjectDTO;

import coliseum.jpa.RepoUtils;
import coliseum.service.ConversionUtility;

public class ElementGenericConvertor implements GenericConverter {

    @Autowired
    ConversionUtility conversionUtility;

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        Set<ConvertiblePair> convertiblePairs = new HashSet<>();
        convertiblePairs.add(new ConvertiblePair(Element.class, ElementDTO.class));
        convertiblePairs.add(new ConvertiblePair(ElementDTO.class, Element.class));
        return convertiblePairs;
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        Object target = null;
        if (sourceType.getType() == Element.class && targetType.getType() == ElementDTO.class) {
            target = this.convertToElementDTO((Element) source);
        }
        if (sourceType.getType() == ElementDTO.class && targetType.getType() == Element.class) {
            target = this.convertToElement((ElementDTO) source);
        }
        return target;
    }

    private Object convertToElement(ElementDTO source) {
        Element target = new Element();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setFloor(source.getFloor());
        return target;
    }

    private Object convertToElementDTO(Element source) {
        ElementDTO target = new ElementDTO();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setFloor(source.getFloor());

        if (RepoUtils.isNotProxy(source.getProject())) {
            target.setProjectDTO(
                    (ProjectDTO) conversionUtility.convert(source.getProject(), Project.class, ProjectDTO.class));
        }
        target.setProjectId(source.getProjectId());

        if (RepoUtils.isNotProxy(source.getElementType())) {
            target.setElementTypeDTO((ElementTypeDTO) conversionUtility.convert(source.getElementType(),
                    ElementType.class, ElementTypeDTO.class));
        }
        target.setElementTypeId(source.getElementTypeId());
        return target;
    }
}

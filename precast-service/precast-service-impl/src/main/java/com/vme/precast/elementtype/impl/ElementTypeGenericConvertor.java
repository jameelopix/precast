package com.vme.precast.elementtype.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import com.vme.precast.domain.ElementType;
import com.vme.precast.domain.Project;
import com.vme.precast.elementtype.api.ElementTypeDTO;
import com.vme.precast.project.api.ProjectDTO;

import coliseum.jpa.RepoUtils;
import coliseum.service.ConversionUtility;

public class ElementTypeGenericConvertor implements GenericConverter {

    @Autowired
    ConversionUtility conversionUtility;

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        Set<ConvertiblePair> convertiblePairs = new HashSet<>();
        convertiblePairs.add(new ConvertiblePair(ElementType.class, ElementTypeDTO.class));
        convertiblePairs.add(new ConvertiblePair(ElementTypeDTO.class, ElementType.class));
        return convertiblePairs;
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        Object target = null;
        if (sourceType.getType() == ElementType.class && targetType.getType() == ElementTypeDTO.class) {
            target = this.convertToElementTypeDTO((ElementType) source);
        }
        if (sourceType.getType() == ElementTypeDTO.class && targetType.getType() == ElementType.class) {
            target = this.convertToElementType((ElementTypeDTO) source);
        }
        return target;
    }

    private Object convertToElementType(ElementTypeDTO source) {
        ElementType target = new ElementType();
        target.setId(source.getId());
        target.setName(source.getName());
        return target;
    }

    private Object convertToElementTypeDTO(ElementType source) {
        ElementTypeDTO target = new ElementTypeDTO();
        target.setId(source.getId());
        target.setName(source.getName());

        if (RepoUtils.isNotProxy(source.getProject())) {
            target.setProjectDTO(
                    (ProjectDTO) conversionUtility.convert(source.getProject(), Project.class, ProjectDTO.class));
        }
        target.setProjectDTOId(source.getProjectId());
        return target;
    }
}

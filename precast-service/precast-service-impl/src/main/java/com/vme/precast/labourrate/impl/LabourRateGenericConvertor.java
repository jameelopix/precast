package com.vme.precast.labourrate.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import com.vme.precast.domain.ElementType;
import com.vme.precast.domain.LabourRate;
import com.vme.precast.domain.Project;
import com.vme.precast.elementtype.api.ElementTypeDTO;
import com.vme.precast.labourrate.api.LabourRateDTO;
import com.vme.precast.project.api.ProjectDTO;

import coliseum.jpa.RepoUtils;
import coliseum.service.ConversionUtility;

public class LabourRateGenericConvertor implements GenericConverter {

    @Autowired
    ConversionUtility conversionUtility;

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        Set<ConvertiblePair> convertiblePairs = new HashSet<>();
        convertiblePairs.add(new ConvertiblePair(LabourRate.class, LabourRateDTO.class));
        convertiblePairs.add(new ConvertiblePair(LabourRateDTO.class, LabourRate.class));
        return convertiblePairs;
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        Object target = null;
        if (sourceType.getType() == LabourRate.class && targetType.getType() == LabourRateDTO.class) {
            target = this.convertToLabourRateDTO((LabourRate) source);
        }
        if (sourceType.getType() == LabourRateDTO.class && targetType.getType() == LabourRate.class) {
            target = this.convertToLabourRate((LabourRateDTO) source);
        }
        return target;
    }

    private Object convertToLabourRate(LabourRateDTO source) {
        LabourRate target = new LabourRate();
        target.setId(source.getId());
        target.setWorkType(source.getWorkType());
        target.setWorkDesc(source.getWorkDesc());
        target.setRate(source.getRate());
        target.setUnit(source.getUnit());
        return target;
    }

    private Object convertToLabourRateDTO(LabourRate source) {
        LabourRateDTO target = new LabourRateDTO();
        target.setId(source.getId());
        target.setWorkType(source.getWorkType());
        target.setWorkDesc(source.getWorkDesc());
        target.setRate(source.getRate());
        target.setUnit(source.getUnit());

        if (RepoUtils.isNotProxy(source.getElementType())) {
            target.setElementTypeDTO((ElementTypeDTO) conversionUtility.convert(source.getElementType(),
                    ElementType.class, ElementTypeDTO.class));
        }
        target.setElementTypeId(source.getElementTypeId());

        if (RepoUtils.isNotProxy(source.getProject())) {
            target.setProjectDTO(
                    (ProjectDTO) conversionUtility.convert(source.getProject(), Project.class, ProjectDTO.class));
        }
        target.setProjectId(source.getProjectId());
        return target;
    }
}

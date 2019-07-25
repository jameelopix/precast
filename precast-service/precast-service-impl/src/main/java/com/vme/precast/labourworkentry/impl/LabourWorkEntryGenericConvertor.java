package com.vme.precast.labourworkentry.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import com.vme.precast.domain.ElementType;
import com.vme.precast.domain.LabourWorkEntry;
import com.vme.precast.domain.Project;
import com.vme.precast.domain.SubContractor;
import com.vme.precast.elementtype.api.ElementTypeDTO;
import com.vme.precast.labourworkentry.api.LabourWorkEntryDTO;
import com.vme.precast.project.api.ProjectDTO;
import com.vme.precast.subcontractor.api.SubContractorDTO;

import coliseum.jpa.RepoUtils;
import coliseum.service.ConversionUtility;

public class LabourWorkEntryGenericConvertor implements GenericConverter {

    @Autowired
    ConversionUtility conversionUtility;

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        Set<ConvertiblePair> convertiblePairs = new HashSet<>();
        convertiblePairs.add(new ConvertiblePair(LabourWorkEntry.class, LabourWorkEntryDTO.class));
        convertiblePairs.add(new ConvertiblePair(LabourWorkEntryDTO.class, LabourWorkEntry.class));
        return convertiblePairs;
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        Object target = null;
        if (sourceType.getType() == LabourWorkEntry.class && targetType.getType() == LabourWorkEntryDTO.class) {
            target = this.convertToLabourWorkEntryDTO((LabourWorkEntry) source);
        }
        if (sourceType.getType() == LabourWorkEntryDTO.class && targetType.getType() == LabourWorkEntry.class) {
            target = this.convertToLabourWorkEntry((LabourWorkEntryDTO) source);
        }
        return target;
    }

    private Object convertToLabourWorkEntry(LabourWorkEntryDTO source) {
        LabourWorkEntry target = new LabourWorkEntry();
        target.setId(source.getId());
        target.setWorkType(source.getWorkType());
        target.setWorkDesc(source.getWorkDesc());
        target.setQuantity(source.getQuantity());
        target.setUnit(source.getUnit());
        return target;
    }

    private Object convertToLabourWorkEntryDTO(LabourWorkEntry source) {
        LabourWorkEntryDTO target = new LabourWorkEntryDTO();
        target.setId(source.getId());
        target.setWorkType(source.getWorkType());
        target.setWorkDesc(source.getWorkDesc());
        target.setQuantity(source.getQuantity());
        target.setUnit(source.getUnit());

        if (RepoUtils.isNotProxy(source.getSubContractor())) {
            target.setSubContractorDTO((SubContractorDTO) conversionUtility.convert(source.getSubContractor(),
                    SubContractor.class, SubContractorDTO.class));
        }
        target.setSubContractorId(source.getSubContractorId());

        if (RepoUtils.isNotProxy(source.getProjectId())) {
            target.setProjectDTO(
                    (ProjectDTO) conversionUtility.convert(source.getProjectId(), Project.class, ProjectDTO.class));
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

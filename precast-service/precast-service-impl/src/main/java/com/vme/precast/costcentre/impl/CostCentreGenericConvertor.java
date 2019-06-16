package com.vme.precast.costcentre.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import com.vme.precast.costcentre.api.CostCentreDTO;
import com.vme.precast.domain.CostCentre;

public class CostCentreGenericConvertor implements GenericConverter {

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        Set<ConvertiblePair> convertiblePairs = new HashSet<>();
        convertiblePairs.add(new ConvertiblePair(CostCentre.class, CostCentreDTO.class));
        convertiblePairs.add(new ConvertiblePair(CostCentreDTO.class, CostCentre.class));
        return convertiblePairs;
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        Object target = null;
        if (sourceType.getType() == CostCentre.class && targetType.getType() == CostCentreDTO.class) {
            target = this.convertToCostCentreDTO((CostCentre) source);
        }
        if (sourceType.getType() == CostCentreDTO.class && targetType.getType() == CostCentre.class) {
            target = this.convertToCostCentre((CostCentreDTO) source);
        }
        return target;
    }

    private Object convertToCostCentre(CostCentreDTO source) {
        CostCentre target = new CostCentre();
        target.setId(source.getId());
        target.setName(source.getName());
        return target;
    }

    private Object convertToCostCentreDTO(CostCentre source) {
        CostCentreDTO target = new CostCentreDTO();
        target.setId(source.getId());
        target.setName(source.getName());
        return target;
    }
}

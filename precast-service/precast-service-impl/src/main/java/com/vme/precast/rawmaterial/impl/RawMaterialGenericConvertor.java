package com.vme.precast.rawmaterial.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import com.vme.precast.domain.RawMaterial;
import com.vme.precast.rawmaterial.api.RawMaterialDTO;

public class RawMaterialGenericConvertor implements GenericConverter {

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        Set<ConvertiblePair> convertiblePairs = new HashSet<>();
        convertiblePairs.add(new ConvertiblePair(RawMaterial.class, RawMaterialDTO.class));
        convertiblePairs.add(new ConvertiblePair(RawMaterialDTO.class, RawMaterial.class));
        return convertiblePairs;
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        Object target = null;
        if (sourceType.getType() == RawMaterial.class && targetType.getType() == RawMaterialDTO.class) {
            target = this.convertToRawMaterialDTO((RawMaterial) source);
        }
        if (sourceType.getType() == RawMaterialDTO.class && targetType.getType() == RawMaterial.class) {
            target = this.convertToRawMaterial((RawMaterialDTO) source);
        }
        return target;
    }

    private Object convertToRawMaterial(RawMaterialDTO source) {
        RawMaterial target = new RawMaterial();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setType(source.getType());
        target.setUnit(source.getUnit());
        return target;
    }

    private Object convertToRawMaterialDTO(RawMaterial source) {
        RawMaterialDTO target = new RawMaterialDTO();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setType(source.getType());
        target.setUnit(source.getUnit());
        return target;
    }
}

package com.vme.precast.steeldetails.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import com.vme.precast.domain.Element;
import com.vme.precast.domain.SteelDetails;
import com.vme.precast.element.api.ElementDTO;
import com.vme.precast.steeldetails.api.SteelDetailsDTO;

import coliseum.jpa.RepoUtils;
import coliseum.service.ConversionUtility;

public class SteelDetailsGenericConvertor implements GenericConverter {

    @Autowired
    ConversionUtility conversionUtility;

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        Set<ConvertiblePair> convertiblePairs = new HashSet<>();
        convertiblePairs.add(new ConvertiblePair(SteelDetails.class, SteelDetailsDTO.class));
        convertiblePairs.add(new ConvertiblePair(SteelDetailsDTO.class, SteelDetails.class));
        return convertiblePairs;
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        Object target = null;
        if (sourceType.getType() == SteelDetails.class && targetType.getType() == SteelDetailsDTO.class) {
            target = this.convertToSteelDetailsDTO((SteelDetails) source);
        }
        if (sourceType.getType() == SteelDetailsDTO.class && targetType.getType() == SteelDetails.class) {
            target = this.convertToSteelDetails((SteelDetailsDTO) source);
        }
        return target;
    }

    private Object convertToSteelDetails(SteelDetailsDTO source) {
        SteelDetails target = new SteelDetails();
        target.setId(source.getId());
        target.setRawMaterialName(source.getRawMaterialName());
        target.setUnit(source.getUnit());
        target.setTheoriticalQuantity(source.getTheoriticalQuantity());
        return target;
    }

    private Object convertToSteelDetailsDTO(SteelDetails source) {
        SteelDetailsDTO target = new SteelDetailsDTO();
        target.setId(source.getId());
        target.setRawMaterialName(source.getRawMaterialName());
        target.setUnit(source.getUnit());
        target.setTheoriticalQuantity(source.getTheoriticalQuantity());

        if (RepoUtils.isNotProxy(source.getElement())) {
            target.setElementDTO(
                    (ElementDTO) conversionUtility.convert(source.getElement(), Element.class, ElementDTO.class));
        }
        target.setElementId(source.getElementId());
        return target;
    }
}

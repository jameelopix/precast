package com.vme.precast.elementdetails.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import com.vme.precast.domain.Element;
import com.vme.precast.domain.ElementDetails;
import com.vme.precast.element.api.ElementDTO;
import com.vme.precast.elementdetails.api.ElementDetailsDTO;

import coliseum.jpa.RepoUtils;
import coliseum.service.ConversionUtility;

public class ElementDetailsGenericConvertor implements GenericConverter {

    @Autowired
    ConversionUtility conversionUtility;

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        Set<ConvertiblePair> convertiblePairs = new HashSet<>();
        convertiblePairs.add(new ConvertiblePair(ElementDetails.class, ElementDetailsDTO.class));
        convertiblePairs.add(new ConvertiblePair(ElementDetailsDTO.class, ElementDetails.class));
        return convertiblePairs;
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        Object target = null;
        if (sourceType.getType() == ElementDetails.class && targetType.getType() == ElementDetailsDTO.class) {
            target = this.convertToElementDetailsDTO((ElementDetails) source);
        }
        if (sourceType.getType() == ElementDetailsDTO.class && targetType.getType() == ElementDetails.class) {
            target = this.convertToElementDetails((ElementDetailsDTO) source);
        }
        return target;
    }

    private Object convertToElementDetails(ElementDetailsDTO source) {
        ElementDetails target = new ElementDetails();
        target.setId(source.getId());
        target.setMixDesignName(source.getMixDesignName());
        target.setWeight(source.getWeight());
        target.setLength(source.getLength());
        target.setWidth(source.getWidth());
        target.setThickness(source.getThickness());
        target.setTheoriticalQuantity(source.getTheoriticalQuantity());
        target.setUnit(source.getUnit());
        return target;
    }

    private Object convertToElementDetailsDTO(ElementDetails source) {
        ElementDetailsDTO target = new ElementDetailsDTO();
        target.setId(source.getId());
        target.setMixDesignName(source.getMixDesignName());
        target.setWeight(source.getWeight());
        target.setLength(source.getLength());
        target.setWidth(source.getWidth());
        target.setThickness(source.getThickness());
        target.setTheoriticalQuantity(source.getTheoriticalQuantity());
        target.setUnit(source.getUnit());

        if (RepoUtils.isNotProxy(source.getElement())) {
            target.setElementDTO(
                    (ElementDTO) conversionUtility.convert(source.getElement(), Element.class, ElementDTO.class));
        }
        target.setElementId(source.getElementId());
        return target;
    }
}

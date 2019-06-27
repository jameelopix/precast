package com.vme.precast.mixtureitem.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import com.vme.precast.domain.Mixture;
import com.vme.precast.domain.MixtureItem;
import com.vme.precast.mixture.api.MixtureDTO;
import com.vme.precast.mixtureitem.api.MixtureItemDTO;

import coliseum.jpa.RepoUtils;
import coliseum.service.ConversionUtility;

public class MixtureItemGenericConvertor implements GenericConverter {

    @Autowired
    ConversionUtility conversionUtility;

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        Set<ConvertiblePair> convertiblePairs = new HashSet<>();
        convertiblePairs.add(new ConvertiblePair(MixtureItem.class, MixtureItemDTO.class));
        convertiblePairs.add(new ConvertiblePair(MixtureItemDTO.class, MixtureItem.class));
        return convertiblePairs;
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        Object target = null;
        if (sourceType.getType() == MixtureItem.class && targetType.getType() == MixtureItemDTO.class) {
            target = this.convertToMixtureItemDTO((MixtureItem) source);
        }
        if (sourceType.getType() == MixtureItemDTO.class && targetType.getType() == MixtureItem.class) {
            target = this.convertToMixtureItem((MixtureItemDTO) source);
        }
        return target;
    }

    private Object convertToMixtureItem(MixtureItemDTO source) {
        MixtureItem target = new MixtureItem();
        target.setId(source.getId());
        target.setRawMaterialName(source.getRawMaterialName());
        target.setUnit(source.getUnit());
        target.setQuantity(source.getQuantity());
        return target;
    }

    private Object convertToMixtureItemDTO(MixtureItem source) {
        MixtureItemDTO target = new MixtureItemDTO();
        target.setId(source.getId());
        target.setRawMaterialName(source.getRawMaterialName());
        target.setUnit(source.getUnit());
        target.setQuantity(source.getQuantity());

        if (RepoUtils.isNotProxy(source.getMixture())) {
            target.setMixtureDTO(
                    (MixtureDTO) conversionUtility.convert(source.getMixture(), Mixture.class, MixtureDTO.class));
        }
        target.setMixtureDTOId(source.getMixtureId());
        return target;
    }
}

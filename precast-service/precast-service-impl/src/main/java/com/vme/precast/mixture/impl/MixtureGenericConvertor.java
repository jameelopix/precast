package com.vme.precast.mixture.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import com.vme.precast.domain.Mixture;
import com.vme.precast.mixture.api.MixtureDTO;

public class MixtureGenericConvertor implements GenericConverter {

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        Set<ConvertiblePair> convertiblePairs = new HashSet<>();
        convertiblePairs.add(new ConvertiblePair(Mixture.class, MixtureDTO.class));
        convertiblePairs.add(new ConvertiblePair(MixtureDTO.class, Mixture.class));
        return convertiblePairs;
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        Object target = null;
        if (sourceType.getType() == Mixture.class && targetType.getType() == MixtureDTO.class) {
            target = this.convertToMixtureDTO((Mixture) source);
        }
        if (sourceType.getType() == MixtureDTO.class && targetType.getType() == Mixture.class) {
            target = this.convertToMixture((MixtureDTO) source);
        }
        return target;
    }

    private Object convertToMixture(MixtureDTO source) {
        Mixture target = new Mixture();
        target.setId(source.getId());
        target.setName(source.getName());
        return target;
    }

    private Object convertToMixtureDTO(Mixture source) {
        MixtureDTO target = new MixtureDTO();
        target.setId(source.getId());
        target.setName(source.getName());
        return target;
    }
}

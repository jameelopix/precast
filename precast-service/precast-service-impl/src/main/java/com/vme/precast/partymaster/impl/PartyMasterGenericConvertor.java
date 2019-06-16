package com.vme.precast.partymaster.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import com.vme.precast.domain.PartyMaster;
import com.vme.precast.partymaster.api.PartyMasterDTO;

public class PartyMasterGenericConvertor implements GenericConverter {

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        Set<ConvertiblePair> convertiblePairs = new HashSet<>();
        convertiblePairs.add(new ConvertiblePair(PartyMaster.class, PartyMasterDTO.class));
        convertiblePairs.add(new ConvertiblePair(PartyMasterDTO.class, PartyMaster.class));
        return convertiblePairs;
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        Object target = null;
        if (sourceType.getType() == PartyMaster.class && targetType.getType() == PartyMasterDTO.class) {
            target = this.convertToPartyMasterDTO((PartyMaster) source);
        }
        if (sourceType.getType() == PartyMasterDTO.class && targetType.getType() == PartyMaster.class) {
            target = this.convertToPartyMaster((PartyMasterDTO) source);
        }
        return target;
    }

    private Object convertToPartyMaster(PartyMasterDTO source) {
        PartyMaster target = new PartyMaster();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setType(source.getType());
        return target;
    }

    private Object convertToPartyMasterDTO(PartyMaster source) {
        PartyMasterDTO target = new PartyMasterDTO();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setType(source.getType());
        return target;
    }
}
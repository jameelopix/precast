package com.vme.precast.accounthead.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import com.vme.precast.accounthead.api.AccountHeadDTO;
import com.vme.precast.domain.AccountHead;

public class AccountHeadGenericConvertor implements GenericConverter {

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        Set<ConvertiblePair> convertiblePairs = new HashSet<>();
        convertiblePairs.add(new ConvertiblePair(AccountHead.class, AccountHeadDTO.class));
        convertiblePairs.add(new ConvertiblePair(AccountHeadDTO.class, AccountHead.class));
        return convertiblePairs;
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        Object target = null;
        if (sourceType.getType() == AccountHead.class && targetType.getType() == AccountHeadDTO.class) {
            target = this.convertToAccountHeadDTO((AccountHead) source);
        }
        if (sourceType.getType() == AccountHeadDTO.class && targetType.getType() == AccountHead.class) {
            target = this.convertToAccountHead((AccountHeadDTO) source);
        }
        return target;
    }

    private Object convertToAccountHead(AccountHeadDTO source) {
        AccountHead target = new AccountHead();
        target.setId(source.getId());
        target.setName(source.getName());
        return target;
    }

    private Object convertToAccountHeadDTO(AccountHead source) {
        AccountHeadDTO target = new AccountHeadDTO();
        target.setId(source.getId());
        target.setName(source.getName());
        return target;
    }
}

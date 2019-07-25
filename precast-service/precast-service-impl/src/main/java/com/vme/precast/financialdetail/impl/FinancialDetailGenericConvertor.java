package com.vme.precast.financialdetail.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import com.vme.precast.domain.FinancialDetail;
import com.vme.precast.financialdetail.api.FinancialDetailDTO;

public class FinancialDetailGenericConvertor implements GenericConverter {

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        Set<ConvertiblePair> convertiblePairs = new HashSet<>();
        convertiblePairs.add(new ConvertiblePair(FinancialDetail.class, FinancialDetailDTO.class));
        convertiblePairs.add(new ConvertiblePair(FinancialDetailDTO.class, FinancialDetail.class));
        return convertiblePairs;
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        Object target = null;
        if (sourceType.getType() == FinancialDetail.class && targetType.getType() == FinancialDetailDTO.class) {
            target = this.convertToFinancialDetailDTO((FinancialDetail) source);
        }
        if (sourceType.getType() == FinancialDetailDTO.class && targetType.getType() == FinancialDetail.class) {
            target = this.convertToFinancialDetail((FinancialDetailDTO) source);
        }
        return target;
    }

    private Object convertToFinancialDetail(FinancialDetailDTO source) {
        FinancialDetail target = new FinancialDetail();
        target.setId(source.getId());
        target.setGst(source.getGst());
        target.setPan(source.getPan());
        return target;
    }

    private Object convertToFinancialDetailDTO(FinancialDetail source) {
        FinancialDetailDTO target = new FinancialDetailDTO();
        target.setId(source.getId());
        target.setGst(source.getGst());
        target.setPan(source.getPan());
        return target;
    }
}

package com.vme.precast.itemfreightamountdetails.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import com.vme.precast.domain.ItemAmountDetails;
import com.vme.precast.domain.ItemFreightAmountDetails;
import com.vme.precast.itemamountdetails.api.ItemAmountDetailsDTO;
import com.vme.precast.itemfreightamountdetails.api.ItemFreightAmountDetailsDTO;

import coliseum.jpa.RepoUtils;
import coliseum.service.ConversionUtility;

public class ItemFreightAmountDetailsGenericConvertor implements GenericConverter {

    @Autowired
    ConversionUtility conversionUtility;

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        Set<ConvertiblePair> convertiblePairs = new HashSet<>();
        convertiblePairs.add(new ConvertiblePair(ItemFreightAmountDetails.class, ItemFreightAmountDetailsDTO.class));
        convertiblePairs.add(new ConvertiblePair(ItemFreightAmountDetailsDTO.class, ItemFreightAmountDetails.class));
        return convertiblePairs;
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        Object target = null;
        if (sourceType.getType() == ItemFreightAmountDetails.class
                && targetType.getType() == ItemFreightAmountDetailsDTO.class) {
            target = this.convertToItemFreightAmountDetailsDTO((ItemFreightAmountDetails) source);
        }
        if (sourceType.getType() == ItemFreightAmountDetailsDTO.class
                && targetType.getType() == ItemFreightAmountDetails.class) {
            target = this.convertToItemFreightAmountDetails((ItemFreightAmountDetailsDTO) source);
        }
        return target;
    }

    private Object convertToItemFreightAmountDetails(ItemFreightAmountDetailsDTO source) {
        ItemFreightAmountDetails target = new ItemFreightAmountDetails();
        target.setId(source.getId());
        target.setAmount(source.getAmount());
        target.setTaxPercent(source.getTaxPercent());
        target.setTaxAmount(source.getTaxAmount());
        target.setTotal(source.getTotal());
        return target;
    }

    private Object convertToItemFreightAmountDetailsDTO(ItemFreightAmountDetails source) {
        ItemFreightAmountDetailsDTO target = new ItemFreightAmountDetailsDTO();
        target.setId(source.getId());
        target.setAmount(source.getAmount());
        target.setTaxPercent(source.getTaxPercent());
        target.setTaxAmount(source.getTaxAmount());
        target.setTotal(source.getTotal());

        if (RepoUtils.isNotProxy(source.getItemAmountDetails())) {
            target.setItemAmountDetailsDTO((ItemAmountDetailsDTO) conversionUtility
                    .convert(source.getItemAmountDetails(), ItemAmountDetails.class, ItemAmountDetailsDTO.class));
        }
        target.setItemAmountDetailsId(source.getItemAmountDetailsId());
        return target;
    }
}

package com.vme.precast.itembasicamountdetails.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import com.vme.precast.domain.ItemAmountDetails;
import com.vme.precast.domain.ItemBasicAmountDetails;
import com.vme.precast.domain.PurchaseRegisterItem;
import com.vme.precast.itemamountdetails.api.ItemAmountDetailsDTO;
import com.vme.precast.itembasicamountdetails.api.ItemBasicAmountDetailsDTO;
import com.vme.precast.purchaseregisteritem.api.PurchaseRegisterItemDTO;

import coliseum.jpa.RepoUtils;
import coliseum.service.ConversionUtility;

public class ItemBasicAmountDetailsGenericConvertor implements GenericConverter {

    @Autowired
    ConversionUtility conversionUtility;

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        Set<ConvertiblePair> convertiblePairs = new HashSet<>();
        convertiblePairs.add(new ConvertiblePair(ItemBasicAmountDetails.class, ItemBasicAmountDetailsDTO.class));
        convertiblePairs.add(new ConvertiblePair(ItemBasicAmountDetailsDTO.class, ItemBasicAmountDetails.class));
        return convertiblePairs;
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        Object target = null;
        if (sourceType.getType() == ItemBasicAmountDetails.class
                && targetType.getType() == ItemBasicAmountDetailsDTO.class) {
            target = this.convertToItemBasicAmountDetailsDTO((ItemBasicAmountDetails) source);
        }
        if (sourceType.getType() == ItemBasicAmountDetailsDTO.class
                && targetType.getType() == ItemBasicAmountDetails.class) {
            target = this.convertToItemBasicAmountDetails((ItemBasicAmountDetailsDTO) source);
        }
        return target;
    }

    private Object convertToItemBasicAmountDetails(ItemBasicAmountDetailsDTO source) {
        ItemBasicAmountDetails target = new ItemBasicAmountDetails();
        target.setId(source.getId());
        target.setRate(source.getRate());
        target.setAmount(source.getAmount());
        target.setTaxPercent(source.getTaxPercent());
        target.setTaxAmount(source.getTaxAmount());
        target.setTotal(source.getTotal());
        return target;
    }

    private Object convertToItemBasicAmountDetailsDTO(ItemBasicAmountDetails source) {
        ItemBasicAmountDetailsDTO target = new ItemBasicAmountDetailsDTO();
        target.setId(source.getId());
        target.setRate(source.getRate());
        target.setAmount(source.getAmount());
        target.setTaxPercent(source.getTaxPercent());
        target.setTaxAmount(source.getTaxAmount());
        target.setTotal(source.getTotal());

        if (RepoUtils.isNotProxy(source.getItemAmountDetails())) {
            target.setItemAmountDetailsDTO((ItemAmountDetailsDTO) conversionUtility
                    .convert(source.getItemAmountDetails(), ItemAmountDetails.class, ItemAmountDetailsDTO.class));
        }
        target.setItemAmountDetailsId(source.getItemAmountDetailsId());

        if (RepoUtils.isNotProxy(source.getPurchaseRegisterItem())) {
            target.setPurchaseRegisterItemDTO((PurchaseRegisterItemDTO) conversionUtility.convert(
                    source.getPurchaseRegisterItem(), PurchaseRegisterItem.class, PurchaseRegisterItemDTO.class));
        }
        target.setPurchaseRegisterItemId(source.getPurchaseRegisterItemId());
        return target;
    }
}

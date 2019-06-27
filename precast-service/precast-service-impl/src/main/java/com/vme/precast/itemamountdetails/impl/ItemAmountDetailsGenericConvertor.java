package com.vme.precast.itemamountdetails.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import com.vme.precast.domain.ItemAmountDetails;
import com.vme.precast.domain.Vendor;
import com.vme.precast.itemamountdetails.api.ItemAmountDetailsDTO;
import com.vme.precast.vendor.api.VendorDTO;

import coliseum.jpa.RepoUtils;
import coliseum.service.ConversionUtility;

public class ItemAmountDetailsGenericConvertor implements GenericConverter {

    @Autowired
    ConversionUtility conversionUtility;

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        Set<ConvertiblePair> convertiblePairs = new HashSet<>();
        convertiblePairs.add(new ConvertiblePair(ItemAmountDetails.class, ItemAmountDetailsDTO.class));
        convertiblePairs.add(new ConvertiblePair(ItemAmountDetailsDTO.class, ItemAmountDetails.class));
        return convertiblePairs;
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        Object target = null;
        if (sourceType.getType() == ItemAmountDetails.class && targetType.getType() == ItemAmountDetailsDTO.class) {
            target = this.convertToItemAmountDetailsDTO((ItemAmountDetails) source);
        }
        if (sourceType.getType() == ItemAmountDetailsDTO.class && targetType.getType() == ItemAmountDetails.class) {
            target = this.convertToItemAmountDetails((ItemAmountDetailsDTO) source);
        }
        return target;
    }

    private Object convertToItemAmountDetails(ItemAmountDetailsDTO source) {
        ItemAmountDetails target = new ItemAmountDetails();
        target.setId(source.getId());
        target.setDcNo(source.getDcNo());
        target.setTotal(source.getTotal());
        target.setInvoiceChecked(source.getInvoiceChecked());
        return target;
    }

    private Object convertToItemAmountDetailsDTO(ItemAmountDetails source) {
        ItemAmountDetailsDTO target = new ItemAmountDetailsDTO();
        target.setId(source.getId());
        target.setDcNo(source.getDcNo());
        target.setTotal(source.getTotal());
        target.setInvoiceChecked(source.getInvoiceChecked());

        if (RepoUtils.isNotProxy(source.getVendor())) {
            target.setVendorDTO(
                    (VendorDTO) conversionUtility.convert(source.getVendor(), Vendor.class, VendorDTO.class));
        }
        target.setVendorDTOId(source.getVendorId());
        return target;
    }
}
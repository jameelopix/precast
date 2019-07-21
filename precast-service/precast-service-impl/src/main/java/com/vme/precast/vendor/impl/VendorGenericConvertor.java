package com.vme.precast.vendor.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import com.vme.precast.domain.Vendor;
import com.vme.precast.vendor.api.VendorDTO;

public class VendorGenericConvertor implements GenericConverter {

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        Set<ConvertiblePair> convertiblePairs = new HashSet<>();
        convertiblePairs.add(new ConvertiblePair(Vendor.class, VendorDTO.class));
        convertiblePairs.add(new ConvertiblePair(VendorDTO.class, Vendor.class));
        return convertiblePairs;
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        Object target = null;
        if (sourceType.getType() == Vendor.class && targetType.getType() == VendorDTO.class) {
            target = this.convertToVendorDTO((Vendor) source);
        }
        if (sourceType.getType() == VendorDTO.class && targetType.getType() == Vendor.class) {
            target = this.convertToVendor((VendorDTO) source);
        }
        return target;
    }

    private Object convertToVendor(VendorDTO source) {
        Vendor target = new Vendor();
        target.setId(source.getId());
        target.setCode(source.getCode());
        target.setName(source.getName());
        return target;
    }

    private Object convertToVendorDTO(Vendor source) {
        VendorDTO target = new VendorDTO();
        target.setId(source.getId());
        target.setCode(source.getCode());
        target.setName(source.getName());
        return target;
    }
}
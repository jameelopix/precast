package com.vme.precast.dcregister.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import com.vme.precast.dcregister.api.DCRegisterDTO;
import com.vme.precast.domain.DCRegister;
import com.vme.precast.domain.PurchaseOrder;
import com.vme.precast.domain.Vendor;
import com.vme.precast.purchaseorder.api.PurchaseOrderDTO;
import com.vme.precast.vendor.api.VendorDTO;

import coliseum.jpa.RepoUtils;
import coliseum.service.ConversionUtility;

public class DCRegisterGenericConvertor implements GenericConverter {

    @Autowired
    ConversionUtility conversionUtility;

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        Set<ConvertiblePair> convertiblePairs = new HashSet<>();
        convertiblePairs.add(new ConvertiblePair(DCRegister.class, DCRegisterDTO.class));
        convertiblePairs.add(new ConvertiblePair(DCRegisterDTO.class, DCRegister.class));
        return convertiblePairs;
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        Object target = null;
        if (sourceType.getType() == DCRegister.class && targetType.getType() == DCRegisterDTO.class) {
            target = this.convertToDCRegisterDTO((DCRegister) source);
        }
        if (sourceType.getType() == DCRegisterDTO.class && targetType.getType() == DCRegister.class) {
            target = this.convertToDCRegister((DCRegisterDTO) source);
        }
        return target;
    }

    private Object convertToDCRegister(DCRegisterDTO source) {
        DCRegister target = new DCRegister();
        target.setId(source.getId());
        target.setDcNo(source.getDcNo());
        target.setGrnNo(source.getGrnNo());
        target.setVendorId(source.getVendorId());

        if (source.getVendorDTO() != null) {
            target.setVendor((Vendor) conversionUtility.convert(source.getVendorDTO(), VendorDTO.class, Vendor.class));
        }
        return target;
    }

    private Object convertToDCRegisterDTO(DCRegister source) {
        DCRegisterDTO target = new DCRegisterDTO();
        target.setId(source.getId());
        target.setDcNo(source.getDcNo());
        target.setGrnNo(source.getGrnNo());
        target.setVendorId(source.getVendorId());

        if (RepoUtils.isNotProxy(source.getVendor())) {
            target.setVendorDTO(
                    (VendorDTO) conversionUtility.convert(source.getVendor(), Vendor.class, VendorDTO.class));
        }
        return target;
    }
}

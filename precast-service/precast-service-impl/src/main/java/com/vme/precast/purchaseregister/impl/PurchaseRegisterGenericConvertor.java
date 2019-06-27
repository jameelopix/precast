package com.vme.precast.purchaseregister.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import com.vme.precast.domain.PurchaseRegister;
import com.vme.precast.domain.Vendor;
import com.vme.precast.purchaseregister.api.PurchaseRegisterDTO;
import com.vme.precast.vendor.api.VendorDTO;

import coliseum.jpa.RepoUtils;
import coliseum.service.ConversionUtility;

public class PurchaseRegisterGenericConvertor implements GenericConverter {

    @Autowired
    ConversionUtility conversionUtility;

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        Set<ConvertiblePair> convertiblePairs = new HashSet<>();
        convertiblePairs.add(new ConvertiblePair(PurchaseRegister.class, PurchaseRegisterDTO.class));
        convertiblePairs.add(new ConvertiblePair(PurchaseRegisterDTO.class, PurchaseRegister.class));
        return convertiblePairs;
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        Object target = null;
        if (sourceType.getType() == PurchaseRegister.class && targetType.getType() == PurchaseRegisterDTO.class) {
            target = this.convertToPurchaseRegisterDTO((PurchaseRegister) source);
        }
        if (sourceType.getType() == PurchaseRegisterDTO.class && targetType.getType() == PurchaseRegister.class) {
            target = this.convertToPurchaseRegister((PurchaseRegisterDTO) source);
        }
        return target;
    }

    private Object convertToPurchaseRegister(PurchaseRegisterDTO source) {
        PurchaseRegister target = new PurchaseRegister();
        target.setId(source.getId());
        target.setWeighBridgeNo(source.getWeighBridgeNo());
        return target;
    }

    private Object convertToPurchaseRegisterDTO(PurchaseRegister source) {
        PurchaseRegisterDTO target = new PurchaseRegisterDTO();
        target.setId(source.getId());
        target.setWeighBridgeNo(source.getWeighBridgeNo());

        if (RepoUtils.isNotProxy(source.getVendor())) {
            target.setVendorDTO(
                    (VendorDTO) conversionUtility.convert(source.getVendor(), Vendor.class, VendorDTO.class));
        }
        target.setVendorDTOId(source.getVendorId());
        return target;
    }
}

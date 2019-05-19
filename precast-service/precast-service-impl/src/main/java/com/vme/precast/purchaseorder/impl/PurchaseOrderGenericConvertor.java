package com.vme.precast.purchaseorder.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import com.vme.precast.domain.PurchaseOrder;
import com.vme.precast.domain.Vendor;
import com.vme.precast.purchaseorder.api.PurchaseOrderDTO;
import com.vme.precast.vendor.api.VendorDTO;

import coliseum.service.ConversionUtility;

public class PurchaseOrderGenericConvertor implements GenericConverter {

    @Autowired
    ConversionUtility conversionUtility;

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        Set<ConvertiblePair> convertiblePairs = new HashSet<>();
        convertiblePairs.add(new ConvertiblePair(PurchaseOrder.class, PurchaseOrderDTO.class));
        convertiblePairs.add(new ConvertiblePair(PurchaseOrderDTO.class, PurchaseOrder.class));
        return convertiblePairs;
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        Object target = null;
        if (sourceType.getType() == PurchaseOrder.class && targetType.getType() == PurchaseOrderDTO.class) {
            target = this.convertToPurchaseOrderDTO((PurchaseOrder) source);
        }
        if (sourceType.getType() == PurchaseOrderDTO.class && targetType.getType() == PurchaseOrder.class) {
            target = this.convertToPurchaseOrder((PurchaseOrderDTO) source);
        }
        return target;
    }

    private Object convertToPurchaseOrder(PurchaseOrderDTO source) {
        PurchaseOrder target = new PurchaseOrder();
        target.setId(source.getId());
        target.setPurchaseOrderNo(source.getPurchaseOrderNo());
        target.setPurchaseDate(source.getPurchaseDate());
        target.setPurchaseOrderStatus(source.getPurchaseOrderStatus());
//        if (source.getVendorDTO() != null) {
//            target.setVendor((Vendor) conversionUtility.convert(source.getVendorDTO(), VendorDTO.class, Vendor.class));
//        }
//        target.setVendorId(source.getVendorId());
        return target;
    }

    private Object convertToPurchaseOrderDTO(PurchaseOrder source) {
        PurchaseOrderDTO target = new PurchaseOrderDTO();
        target.setId(source.getId());
        target.setPurchaseOrderNo(source.getPurchaseOrderNo());
        target.setPurchaseDate(source.getPurchaseDate());
        target.setPurchaseOrderStatus(source.getPurchaseOrderStatus());
        if (source.getVendor() != null) {
            target.setVendorDTO(
                    (VendorDTO) conversionUtility.convert(source.getVendor(), Vendor.class, VendorDTO.class));
        }
        target.setVendorId(source.getVendorId());
        return target;
    }
}

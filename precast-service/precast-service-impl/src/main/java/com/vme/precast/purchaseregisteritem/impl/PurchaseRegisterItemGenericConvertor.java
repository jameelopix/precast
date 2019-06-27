package com.vme.precast.purchaseregisteritem.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import com.vme.precast.domain.PurchaseOrderItem;
import com.vme.precast.domain.PurchaseRegister;
import com.vme.precast.domain.PurchaseRegisterItem;
import com.vme.precast.purchaseorderitem.api.PurchaseOrderItemDTO;
import com.vme.precast.purchaseregister.api.PurchaseRegisterDTO;
import com.vme.precast.purchaseregisteritem.api.PurchaseRegisterItemDTO;

import coliseum.jpa.RepoUtils;
import coliseum.service.ConversionUtility;

public class PurchaseRegisterItemGenericConvertor implements GenericConverter {

    @Autowired
    ConversionUtility conversionUtility;

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        Set<ConvertiblePair> convertiblePairs = new HashSet<>();
        convertiblePairs.add(new ConvertiblePair(PurchaseRegisterItem.class, PurchaseRegisterItemDTO.class));
        convertiblePairs.add(new ConvertiblePair(PurchaseRegisterItemDTO.class, PurchaseRegisterItem.class));
        return convertiblePairs;
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        Object target = null;
        if (sourceType.getType() == PurchaseRegisterItem.class
                && targetType.getType() == PurchaseRegisterItemDTO.class) {
            target = this.convertToPurchaseRegisterItemDTO((PurchaseRegisterItem) source);
        }
        if (sourceType.getType() == PurchaseRegisterItemDTO.class
                && targetType.getType() == PurchaseRegisterItem.class) {
            target = this.convertToPurchaseRegisterItem((PurchaseRegisterItemDTO) source);
        }
        return target;
    }

    private Object convertToPurchaseRegisterItem(PurchaseRegisterItemDTO source) {
        PurchaseRegisterItem target = new PurchaseRegisterItem();
        target.setId(source.getId());
        target.setDcQuantity(source.getDcQuantity());
        target.setDcUnit(source.getDcUnit());
        target.setWeighBridgeQuantity(source.getWeighBridgeQuantity());
        target.setWeighBridgeUnit(source.getWeighBridgeUnit());
        target.setDeductionQuantity(source.getDeductionQuantity());
        target.setDeductionUnit(source.getDeductionUnit());
        target.setNetQuantity(source.getNetQuantity());
        target.setNetUnit(source.getNetUnit());
        return target;
    }

    private Object convertToPurchaseRegisterItemDTO(PurchaseRegisterItem source) {
        PurchaseRegisterItemDTO target = new PurchaseRegisterItemDTO();
        target.setId(source.getId());
        target.setDcQuantity(source.getDcQuantity());
        target.setDcUnit(source.getDcUnit());
        target.setWeighBridgeQuantity(source.getWeighBridgeQuantity());
        target.setWeighBridgeUnit(source.getWeighBridgeUnit());
        target.setDeductionQuantity(source.getDeductionQuantity());
        target.setDeductionUnit(source.getDeductionUnit());
        target.setNetQuantity(source.getNetQuantity());
        target.setNetUnit(source.getNetUnit());

        if (RepoUtils.isNotProxy(source.getPurchaseRegister())) {
            target.setPurchaseRegisterDTO((PurchaseRegisterDTO) conversionUtility.convert(source.getPurchaseRegister(),
                    PurchaseRegister.class, PurchaseRegisterDTO.class));
        }

        if (RepoUtils.isNotProxy(source.getPurchaseOrderItem())) {
            target.setPurchaseOrderItemDTO((PurchaseOrderItemDTO) conversionUtility
                    .convert(source.getPurchaseOrderItem(), PurchaseOrderItem.class, PurchaseOrderItemDTO.class));
        }
        return target;
    }
}

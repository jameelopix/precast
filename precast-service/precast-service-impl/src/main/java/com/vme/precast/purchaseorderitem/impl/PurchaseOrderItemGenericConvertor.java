package com.vme.precast.purchaseorderitem.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import com.vme.precast.domain.PurchaseOrder;
import com.vme.precast.domain.PurchaseOrderItem;
import com.vme.precast.purchaseorder.api.PurchaseOrderDTO;
import com.vme.precast.purchaseorderitem.api.PurchaseOrderItemDTO;

import coliseum.jpa.RepoUtils;
import coliseum.service.ConversionUtility;

public class PurchaseOrderItemGenericConvertor implements GenericConverter {

    @Autowired
    ConversionUtility conversionUtility;

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        Set<ConvertiblePair> convertiblePairs = new HashSet<>();
        convertiblePairs.add(new ConvertiblePair(PurchaseOrderItem.class, PurchaseOrderItemDTO.class));
        convertiblePairs.add(new ConvertiblePair(PurchaseOrderItemDTO.class, PurchaseOrderItem.class));
        return convertiblePairs;
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        Object target = null;
        if (sourceType.getType() == PurchaseOrderItem.class && targetType.getType() == PurchaseOrderItemDTO.class) {
            target = this.convertToPurchaseOrderItemDTO((PurchaseOrderItem) source);
        }
        if (sourceType.getType() == PurchaseOrderItemDTO.class && targetType.getType() == PurchaseOrderItem.class) {
            target = this.convertToPurchaseOrderItem((PurchaseOrderItemDTO) source);
        }
        return target;
    }

    private Object convertToPurchaseOrderItem(PurchaseOrderItemDTO source) {
        PurchaseOrderItem target = new PurchaseOrderItem();
        target.setId(source.getId());
        target.setItemName(source.getItemName());
        target.setUnit(source.getUnit());
        target.setQuantity(source.getQuantity());
        target.setRate(source.getRate());
        return target;
    }

    private Object convertToPurchaseOrderItemDTO(PurchaseOrderItem source) {
        PurchaseOrderItemDTO target = new PurchaseOrderItemDTO();
        target.setId(source.getId());
        target.setItemName(source.getItemName());
        target.setUnit(source.getUnit());
        target.setQuantity(source.getQuantity());
        target.setRate(source.getRate());

        if (RepoUtils.isNotProxy(source.getPurchaseOrder())) {
            target.setPurchaseOrderDTO((PurchaseOrderDTO) conversionUtility.convert(source.getPurchaseOrder(),
                    PurchaseOrder.class, PurchaseOrderDTO.class));
        }
        target.setPurchaseOrderDTOId(source.getPurchaseOrderId());
        return target;
    }
}

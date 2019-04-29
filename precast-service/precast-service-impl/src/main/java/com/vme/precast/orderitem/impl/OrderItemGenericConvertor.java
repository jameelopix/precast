package com.vme.precast.orderitem.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import com.vme.precast.domain.OrderItem;
import com.vme.precast.domain.PurchaseOrder;
import com.vme.precast.orderitem.api.OrderItemDTO;
import com.vme.precast.purchaseorder.api.PurchaseOrderDTO;

import coliseum.jpa.RepoUtils;
import coliseum.service.ConversionUtility;

public class OrderItemGenericConvertor implements GenericConverter {

    @Autowired
    ConversionUtility conversionUtility;

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        Set<ConvertiblePair> convertiblePairs = new HashSet<>();
        convertiblePairs.add(new ConvertiblePair(OrderItem.class, OrderItemDTO.class));
        convertiblePairs.add(new ConvertiblePair(OrderItemDTO.class, OrderItem.class));
        return convertiblePairs;
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        Object target = null;
        if (sourceType.getType() == OrderItem.class && targetType.getType() == OrderItemDTO.class) {
            target = this.convertToOrderItemDTO((OrderItem) source);
        }
        if (sourceType.getType() == OrderItemDTO.class && targetType.getType() == OrderItem.class) {
            target = this.convertToOrderItem((OrderItemDTO) source);
        }
        return target;
    }

    private Object convertToOrderItem(OrderItemDTO source) {
        OrderItem target = new OrderItem();
        target.setId(source.getId());
        target.setItemName(source.getItemName());
        target.setQuantity(source.getQuantity());
        target.setRate(source.getRate());
        target.setUnitType(source.getUnitType());
        if (source.getPurchaseOrderDTO() != null) {
            target.setPurchaseOrder((PurchaseOrder) conversionUtility.convert(source.getPurchaseOrderDTO(),
                    PurchaseOrderDTO.class, PurchaseOrder.class));
        }
        target.setPurchaseOrderId(source.getPurchaseOrderId());
        return target;
    }

    private Object convertToOrderItemDTO(OrderItem source) {
        OrderItemDTO target = new OrderItemDTO();
        target.setId(source.getId());
        target.setItemName(source.getItemName());
        target.setQuantity(source.getQuantity());
        target.setRate(source.getRate());
        target.setUnitType(source.getUnitType());

        if (RepoUtils.isNotProxy(source.getPurchaseOrder())) {
            target.setPurchaseOrderDTO((PurchaseOrderDTO) conversionUtility.convert(source.getPurchaseOrder(),
                    PurchaseOrder.class, PurchaseOrderDTO.class));
        }
        target.setPurchaseOrderId(source.getPurchaseOrderId());
        return target;
    }
}

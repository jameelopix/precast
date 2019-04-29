package com.vme.precast.dcitem.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import com.vme.precast.dcitem.api.DCItemDTO;
import com.vme.precast.dcregister.api.DCRegisterDTO;
import com.vme.precast.domain.DCItem;
import com.vme.precast.domain.DCRegister;
import com.vme.precast.domain.OrderItem;
import com.vme.precast.orderitem.api.OrderItemDTO;

import coliseum.jpa.RepoUtils;
import coliseum.service.ConversionUtility;

public class DCItemGenericConvertor implements GenericConverter {

    @Autowired
    ConversionUtility conversionUtility;

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        Set<ConvertiblePair> convertiblePairs = new HashSet<>();
        convertiblePairs.add(new ConvertiblePair(DCItem.class, DCItemDTO.class));
        convertiblePairs.add(new ConvertiblePair(DCItemDTO.class, DCItem.class));
        return convertiblePairs;
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        Object target = null;
        if (sourceType.getType() == DCItem.class && targetType.getType() == DCItemDTO.class) {
            target = this.convertToDCItemDTO((DCItem) source);
        }
        if (sourceType.getType() == DCItemDTO.class && targetType.getType() == DCItem.class) {
            target = this.convertToDCItem((DCItemDTO) source);
        }
        return target;
    }

    private Object convertToDCItem(DCItemDTO source) {
        DCItem target = new DCItem();
        target.setId(source.getId());
        target.setVendorQuantity(source.getVendorQuantity());
        target.setWeighBridgeQuantity(source.getWeighBridgeQuantity());
        target.setDeductionQuantity(source.getDeductionQuantity());
        target.setNetQuantity(source.getNetQuantity());
        target.setOrderItemId(source.getOrderItemId());
        target.setDcRegisterId(source.getDcRegisterId());

        if (source.getDcRegisterDTO() != null) {
            target.setDcRegister((DCRegister) conversionUtility.convert(source.getDcRegisterDTO(), DCRegisterDTO.class,
                    DCRegister.class));
        }
        if (source.getOrderItemDTO() != null) {
            target.setOrderItem((OrderItem) conversionUtility.convert(source.getOrderItemDTO(), OrderItemDTO.class,
                    OrderItem.class));
        }
        return target;
    }

    private Object convertToDCItemDTO(DCItem source) {
        DCItemDTO target = new DCItemDTO();
        target.setId(source.getId());
        target.setVendorQuantity(source.getVendorQuantity());
        target.setWeighBridgeQuantity(source.getWeighBridgeQuantity());
        target.setDeductionQuantity(source.getDeductionQuantity());
        target.setNetQuantity(source.getNetQuantity());
        target.setOrderItemId(source.getOrderItemId());
        target.setDcRegisterId(source.getDcRegisterId());

        if (RepoUtils.isNotProxy(source.getDcRegister())) {
            target.setDcRegisterDTO((DCRegisterDTO) conversionUtility.convert(source.getDcRegister(), DCRegister.class,
                    DCRegisterDTO.class));
        }
        if (RepoUtils.isNotProxy(source.getOrderItem())) {
            target.setOrderItemDTO((OrderItemDTO) conversionUtility.convert(source.getOrderItem(), OrderItem.class,
                    OrderItemDTO.class));
        }
        return target;
    }
}

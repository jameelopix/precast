package com.vme.precast.productionplanitem.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import com.vme.precast.domain.ProductionPlanItem;
import com.vme.precast.productionplanitem.api.ProductionPlanItemDTO;

public class ProductionPlanItemGenericConvertor implements GenericConverter {

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        Set<ConvertiblePair> convertiblePairs = new HashSet<>();
        convertiblePairs.add(new ConvertiblePair(ProductionPlanItem.class, ProductionPlanItemDTO.class));
        convertiblePairs.add(new ConvertiblePair(ProductionPlanItemDTO.class, ProductionPlanItem.class));
        return convertiblePairs;
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        Object target = null;
        if (sourceType.getType() == ProductionPlanItem.class && targetType.getType() == ProductionPlanItemDTO.class) {
            target = this.convertToProductionPlanItemDTO((ProductionPlanItem) source);
        }
        if (sourceType.getType() == ProductionPlanItemDTO.class && targetType.getType() == ProductionPlanItem.class) {
            target = this.convertToProductionPlanItem((ProductionPlanItemDTO) source);
        }
        return target;
    }

    private Object convertToProductionPlanItem(ProductionPlanItemDTO source) {
        ProductionPlanItem target = new ProductionPlanItem();
        target.setId(source.getId());
        target.setProductionPlan(source.getProductionPlan());
        target.setSequenceOrder(source.getSequenceOrder());
        target.setCastedDate(source.getCastedDate());
        target.setDisapprovedReason(source.getDisapprovedReason());
        target.setDisapproved(source.getDisapproved());

        return target;
    }

    private Object convertToProductionPlanItemDTO(ProductionPlanItem source) {
        ProductionPlanItemDTO target = new ProductionPlanItemDTO();
        target.setId(source.getId());
        target.setProductionPlan(source.getProductionPlan());
        target.setSequenceOrder(source.getSequenceOrder());
        target.setCastedDate(source.getCastedDate());
        target.setDisapprovedReason(source.getDisapprovedReason());
        target.setDisapproved(source.getDisapproved());

        return target;
    }
}
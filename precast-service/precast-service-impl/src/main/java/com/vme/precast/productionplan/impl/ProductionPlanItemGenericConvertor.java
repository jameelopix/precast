package com.vme.precast.productionplan.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import com.vme.precast.domain.ProductionPlan;
import com.vme.precast.domain.ProductionPlanItem;
import com.vme.precast.productionplan.api.ProductionPlanDTO;
import com.vme.precast.productionplan.api.ProductionPlanItemDTO;

import coliseum.jpa.RepoUtils;
import coliseum.service.ConversionUtility;

public class ProductionPlanItemGenericConvertor implements GenericConverter {

    @Autowired
    ConversionUtility conversionUtility;

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
        target.setSequenceOrder(source.getSequenceOrder());
        target.setPlannedDate(source.getPlannedDate());
        target.setCastStartDate(source.getCastStartDate());
        target.setCastEndDate(source.getCastEndDate());
        target.setDeliveredDate(source.getDeliveredDate());
        target.setErectedDate(source.getErectedDate());
        target.setDisapprovedReason(source.getDisapprovedReason());
        target.setDisapprovedDesc(source.getDisapprovedDesc());
        target.setDisapproved(source.getDisapproved());
        return target;
    }

    private Object convertToProductionPlanItemDTO(ProductionPlanItem source) {
        ProductionPlanItemDTO target = new ProductionPlanItemDTO();
        target.setId(source.getId());
        target.setSequenceOrder(source.getSequenceOrder());
        target.setPlannedDate(source.getPlannedDate());
        target.setCastStartDate(source.getCastStartDate());
        target.setCastEndDate(source.getCastEndDate());
        target.setDeliveredDate(source.getDeliveredDate());
        target.setErectedDate(source.getErectedDate());
        target.setDisapprovedReason(source.getDisapprovedReason());
        target.setDisapprovedDesc(source.getDisapprovedDesc());
        target.setDisapproved(source.getDisapproved());

        if (RepoUtils.isNotProxy(source.getProductionPlan())) {
            target.setProductionPlanDTO((ProductionPlanDTO) conversionUtility.convert(source.getProductionPlan(),
                    ProductionPlan.class, ProductionPlanDTO.class));
        }
        target.setProductionPlanId(source.getProductionPlanId());
        return target;
    }
}

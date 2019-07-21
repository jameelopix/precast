package com.vme.precast.productionplan.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import com.vme.precast.domain.Element;
import com.vme.precast.domain.ProductionPlan;
import com.vme.precast.element.api.ElementDTO;
import com.vme.precast.productionplan.api.ProductionPlanDTO;

import coliseum.jpa.RepoUtils;
import coliseum.service.ConversionUtility;

public class ProductionPlanGenericConvertor implements GenericConverter {

    @Autowired
    ConversionUtility conversionUtility;

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        Set<ConvertiblePair> convertiblePairs = new HashSet<>();
        convertiblePairs.add(new ConvertiblePair(ProductionPlan.class, ProductionPlanDTO.class));
        convertiblePairs.add(new ConvertiblePair(ProductionPlanDTO.class, ProductionPlan.class));
        return convertiblePairs;
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        Object target = null;
        if (sourceType.getType() == ProductionPlan.class && targetType.getType() == ProductionPlanDTO.class) {
            target = this.convertToProductionPlanDTO((ProductionPlan) source);
        }
        if (sourceType.getType() == ProductionPlanDTO.class && targetType.getType() == ProductionPlan.class) {
            target = this.convertToProductionPlan((ProductionPlanDTO) source);
        }
        return target;
    }

    private Object convertToProductionPlan(ProductionPlanDTO source) {
        ProductionPlan target = new ProductionPlan();
        target.setId(source.getId());
        target.setProductionPlanStatus(source.getProductionPlanStatus());
        target.setPlannedDate(source.getPlannedDate());
        target.setDeliveredDate(source.getDeliveredDate());

        if (source.getElementDTO() != null) {
            target.setElement(
                    (Element) conversionUtility.convert(source.getElementDTO(), ElementDTO.class, Element.class));
        }
        return target;
    }

    private Object convertToProductionPlanDTO(ProductionPlan source) {
        ProductionPlanDTO target = new ProductionPlanDTO();
        target.setId(source.getId());
        target.setProductionPlanStatus(source.getProductionPlanStatus());
        target.setPlannedDate(source.getPlannedDate());
        target.setDeliveredDate(source.getDeliveredDate());

        if (RepoUtils.isNotProxy(source.getElement())) {
            target.setElementDTO(
                    (ElementDTO) conversionUtility.convert(source.getElement(), Element.class, ElementDTO.class));
        }
        target.setElementId(source.getElement().getId());
        return target;
    }
}
package com.vme.precast.productionplan.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import com.vme.precast.domain.ProductionPlanItem;
import com.vme.precast.domain.ProductionPlanItemDetail;
import com.vme.precast.productionplan.api.ProductionPlanItemDTO;
import com.vme.precast.productionplan.api.ProductionPlanItemDetailDTO;

import coliseum.jpa.RepoUtils;
import coliseum.service.ConversionUtility;

public class ProductionPlanItemDetailGenericConvertor implements GenericConverter {

    @Autowired
    ConversionUtility conversionUtility;

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        Set<ConvertiblePair> convertiblePairs = new HashSet<>();
        convertiblePairs.add(new ConvertiblePair(ProductionPlanItemDetail.class, ProductionPlanItemDetailDTO.class));
        convertiblePairs.add(new ConvertiblePair(ProductionPlanItemDetailDTO.class, ProductionPlanItemDetail.class));
        return convertiblePairs;
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        Object target = null;
        if (sourceType.getType() == ProductionPlanItemDetail.class
                && targetType.getType() == ProductionPlanItemDetailDTO.class) {
            target = this.convertToProductionPlanItemDetailDTO((ProductionPlanItemDetail) source);
        }
        if (sourceType.getType() == ProductionPlanItemDetailDTO.class
                && targetType.getType() == ProductionPlanItemDetail.class) {
            target = this.convertToProductionPlanItemDetail((ProductionPlanItemDetailDTO) source);
        }
        return target;
    }

    private Object convertToProductionPlanItemDetail(ProductionPlanItemDetailDTO source) {
        ProductionPlanItemDetail target = new ProductionPlanItemDetail();
        target.setId(source.getId());
        target.setRawMaterialName(source.getRawMaterialName());
        target.setUnit(source.getUnit());
        target.setTheoriticalQuantity(source.getTheoriticalQuantity());
        target.setActualQuantity(source.getActualQuantity());
        return target;
    }

    private Object convertToProductionPlanItemDetailDTO(ProductionPlanItemDetail source) {
        ProductionPlanItemDetailDTO target = new ProductionPlanItemDetailDTO();
        target.setId(source.getId());
        target.setRawMaterialName(source.getRawMaterialName());
        target.setUnit(source.getUnit());
        target.setTheoriticalQuantity(source.getTheoriticalQuantity());
        target.setActualQuantity(source.getActualQuantity());

        if (RepoUtils.isNotProxy(source.getProductionPlanItem())) {
            target.setProductionPlanItemDTO((ProductionPlanItemDTO) conversionUtility
                    .convert(source.getProductionPlanItem(), ProductionPlanItem.class, ProductionPlanItemDTO.class));
        }
        target.setProductionPlanItemId(source.getProductionPlanItemId());
        return target;
    }
}

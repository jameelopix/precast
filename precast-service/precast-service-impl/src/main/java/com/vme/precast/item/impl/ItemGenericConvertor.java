package com.vme.precast.item.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import com.vme.precast.domain.Item;
import com.vme.precast.item.api.ItemDTO;

public class ItemGenericConvertor implements GenericConverter {

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        Set<ConvertiblePair> convertiblePairs = new HashSet<>();
        convertiblePairs.add(new ConvertiblePair(Item.class, ItemDTO.class));
        convertiblePairs.add(new ConvertiblePair(ItemDTO.class, Item.class));
        return convertiblePairs;
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        Object target = null;
        if (sourceType.getType() == Item.class && targetType.getType() == ItemDTO.class) {
            target = this.convertToItemDTO((Item) source);
        }
        if (sourceType.getType() == ItemDTO.class && targetType.getType() == Item.class) {
            target = this.convertToItem((ItemDTO) source);
        }
        return target;
    }

    private Object convertToItem(ItemDTO source) {
        Item target = new Item();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setCategory(source.getCategory());
        target.setUnitType(source.getUnitType());
        return target;
    }

    private Object convertToItemDTO(Item source) {
        ItemDTO target = new ItemDTO();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setCategory(source.getCategory());
        target.setUnitType(source.getUnitType());
        return target;
    }
}

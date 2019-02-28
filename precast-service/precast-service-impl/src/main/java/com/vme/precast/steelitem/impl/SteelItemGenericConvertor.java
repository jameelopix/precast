package com.vme.precast.steelitem.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.stereotype.Component;

import com.vme.precast.domain.SteelItem;
import com.vme.precast.steelitem.api.SteelItemDTO;

@Component
public class SteelItemGenericConvertor implements GenericConverter {

	@Override
	public Set<ConvertiblePair> getConvertibleTypes() {
		Set<ConvertiblePair> convertiblePairs = new HashSet<>();
		convertiblePairs.add(new ConvertiblePair(SteelItem.class, SteelItemDTO.class));
		convertiblePairs.add(new ConvertiblePair(SteelItemDTO.class, SteelItem.class));
		return convertiblePairs;
	}

	@Override
	public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
		Object target = null;
		if (sourceType.getType() == SteelItem.class && targetType.getType() == SteelItemDTO.class) {
			target = this.convertToSteelItemDTO((SteelItem) source);
		}
		if (sourceType.getType() == SteelItemDTO.class && targetType.getType() == SteelItem.class) {
			target = this.convertToSteelItem((SteelItemDTO) source);
		}
		return target;
	}

	private Object convertToSteelItem(SteelItemDTO source) {
		SteelItem target = new SteelItem();
		target.setId(source.getId());
		target.setTheoryQuantity(source.getTheoryQuantity());
		target.setActualQuantity(source.getActualQuantity());
		return target;
	}

	private Object convertToSteelItemDTO(SteelItem source) {
		SteelItemDTO target = new SteelItemDTO();
		target.setId(source.getId());
		target.setTheoryQuantity(source.getTheoryQuantity());
		target.setActualQuantity(source.getActualQuantity());
		target.setElementId(source.getElement().getId());
		target.setRawMaterialId(source.getRawMaterial().getId());
		return target;
	}
}

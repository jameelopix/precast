package com.vme.precast.mixtureitem.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.stereotype.Component;

import com.vme.precast.domain.MixtureItem;
import com.vme.precast.mixtureitem.api.MixtureItemDTO;

@Component
public class MixtureItemGenericConvertor implements GenericConverter {

//	ConversionService conversionService;
//
//	public MixtureItemGenericConvertor(ConversionService conversionService) {
//		this.conversionService = conversionService;
//	}

	@Override
	public Set<ConvertiblePair> getConvertibleTypes() {
		Set<ConvertiblePair> convertiblePairs = new HashSet<>();
		convertiblePairs.add(new ConvertiblePair(MixtureItem.class, MixtureItemDTO.class));
		convertiblePairs.add(new ConvertiblePair(MixtureItemDTO.class, MixtureItem.class));
		return convertiblePairs;
	}

	@Override
	public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
		Object target = null;
		if (MixtureItem.class.equals(sourceType.getType()) && MixtureItemDTO.class.equals(targetType.getType())) {
			target = this.convertToMixtureItemDTO((MixtureItem) source);
		} else if (MixtureItemDTO.class.equals(sourceType.getType())
				&& MixtureItem.class.equals(targetType.getType())) {
			target = this.convertToMixtureItem((MixtureItemDTO) source);
		}
		return target;
	}

	private Object convertToMixtureItem(MixtureItemDTO source) {
		MixtureItem target = new MixtureItem();
		target.setId(source.getId());
		target.setQuantity(source.getQuantity());
		return target;
	}

	private Object convertToMixtureItemDTO(MixtureItem source) {
		MixtureItemDTO target = new MixtureItemDTO();
		target.setId(source.getId());
		target.setQuantity(source.getQuantity());
		target.setRawMaterialId(source.getRawMaterial().getId());
		target.setMixtureId(source.getMixture().getId());
		return target;
	}
}

package com.vme.precast.mixture.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.stereotype.Component;

import com.vme.precast.domain.Mixture;
import com.vme.precast.mixture.api.MixtureDTO;

@Component
public class MixtureGenericConvertor implements GenericConverter {

//	ConversionService conversionService;
//
//	public MixtureGenericConvertor(ConversionService conversionService) {
//		this.conversionService = conversionService;
//	}

	@Override
	public Set<ConvertiblePair> getConvertibleTypes() {
		Set<ConvertiblePair> convertiblePairs = new HashSet<>();
		convertiblePairs.add(new ConvertiblePair(Mixture.class, MixtureDTO.class));
		convertiblePairs.add(new ConvertiblePair(MixtureDTO.class, Mixture.class));
		return convertiblePairs;
	}

	@Override
	public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
		Object target = null;
		if (Mixture.class.equals(sourceType.getType()) && MixtureDTO.class.equals(targetType.getType())) {
			target = this.convertToMixtureDTO((Mixture) source);
		} else if (MixtureDTO.class.equals(sourceType.getType()) && Mixture.class.equals(targetType.getType())) {
			target = this.convertToMixture((MixtureDTO) source);
		}
		return target;
	}

	private Object convertToMixture(MixtureDTO source) {
		Mixture target = new Mixture();
		target.setId(source.getId());
		target.setCode(source.getCode());
		return target;
	}

	private Object convertToMixtureDTO(Mixture source) {
		MixtureDTO target = new MixtureDTO();
		target.setId(source.getId());
		target.setCode(source.getCode());

//		Set<MixtureItemDTO> mixtureItemDTOs = new HashSet<>();
//		for (MixtureItem mixtureItem : source.getMixtureItems()) {
//			MixtureItemDTO mixtureItemDTO = conversionService.convert(mixtureItem, MixtureItemDTO.class);
//			mixtureItemDTOs.add(mixtureItemDTO);
//		}
		return target;
	}
}

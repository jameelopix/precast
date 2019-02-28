package com.vme.precast.castingactivity.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.stereotype.Component;

import com.vme.precast.castingactivity.api.CastingActivityDTO;
import com.vme.precast.domain.CastingActivity;

@Component
public class CastingActivityGenericConvertor implements GenericConverter {

	@Override
	public Set<ConvertiblePair> getConvertibleTypes() {
		Set<ConvertiblePair> convertiblePairs = new HashSet<>();
		convertiblePairs.add(new ConvertiblePair(CastingActivity.class, CastingActivityDTO.class));
		convertiblePairs.add(new ConvertiblePair(CastingActivityDTO.class, CastingActivity.class));
		return convertiblePairs;
	}

	@Override
	public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
		Object target = null;
		if (CastingActivity.class.equals(sourceType.getType())
				&& CastingActivityDTO.class.equals(targetType.getType())) {
			target = this.convertToCastingActivityDTO((CastingActivity) source);
		}
		if (CastingActivityDTO.class.equals(sourceType.getType())
				&& CastingActivity.class.equals(targetType.getType())) {
			target = this.convertToCastingActivity((CastingActivityDTO) source);
		}
		return target;
	}

	private Object convertToCastingActivity(CastingActivityDTO source) {
		CastingActivity target = new CastingActivity();
		target.setId(source.getId());
		target.setCastedDate(source.getCastedDate());
		target.setActualConcentreQuantity(source.getActualConcentreQuantity());
		return target;
	}

	private Object convertToCastingActivityDTO(CastingActivity source) {
		CastingActivityDTO target = new CastingActivityDTO();
		target.setId(source.getId());
		target.setElementId(source.getElement().getId());
		target.setCastedDate(source.getCastedDate());
		target.setActualConcentreQuantity(source.getActualConcentreQuantity());
		return target;
	}
}

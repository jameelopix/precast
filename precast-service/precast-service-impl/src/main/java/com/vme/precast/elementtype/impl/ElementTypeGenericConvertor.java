package com.vme.precast.elementtype.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.stereotype.Component;

import com.vme.precast.domain.ElementType;
import com.vme.precast.elementtype.api.ElementTypeDTO;

@Component
public class ElementTypeGenericConvertor implements GenericConverter {

	@Override
	public Set<ConvertiblePair> getConvertibleTypes() {
		Set<ConvertiblePair> convertiblePairs = new HashSet<>();
		convertiblePairs.add(new ConvertiblePair(ElementType.class, ElementTypeDTO.class));
		convertiblePairs.add(new ConvertiblePair(ElementTypeDTO.class, ElementType.class));
		return convertiblePairs;
	}

	@Override
	public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
		Object target = null;
		if (ElementType.class.equals(sourceType.getType()) && ElementTypeDTO.class.equals(targetType.getType())) {
			target = this.convertToElementTypeDTO((ElementType) source);
		}
		if (ElementTypeDTO.class.equals(sourceType.getType()) && ElementType.class.equals(targetType.getType())) {
			target = this.convertToElementType((ElementTypeDTO) source);
		}
		return target;
	}

	private Object convertToElementType(ElementTypeDTO source) {
		ElementType target = new ElementType();
		target.setId(source.getId());
		target.setName(source.getName());
		target.setProjectId(source.getProjectId());
		return target;
	}

	private Object convertToElementTypeDTO(ElementType source) {
		ElementTypeDTO target = new ElementTypeDTO();
		target.setId(source.getId());
		target.setName(source.getName());
		target.setProjectId(source.getProjectId());
		return target;
	}
}

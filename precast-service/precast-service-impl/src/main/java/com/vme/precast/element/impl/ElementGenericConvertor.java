package com.vme.precast.element.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.stereotype.Component;

import com.vme.precast.domain.Element;
import com.vme.precast.domain.SteelItem;
import com.vme.precast.element.api.ElementDTO;

@Component
public class ElementGenericConvertor implements GenericConverter {

//	ConversionService conversionService;
//
//	public ElementGenericConvertor(ConversionService conversionService) {
//		this.conversionService = conversionService;
//	}

	@Override
	public Set<ConvertiblePair> getConvertibleTypes() {
		Set<ConvertiblePair> convertiblePairs = new HashSet<>();
		convertiblePairs.add(new ConvertiblePair(Element.class, ElementDTO.class));
		convertiblePairs.add(new ConvertiblePair(ElementDTO.class, Element.class));
		return convertiblePairs;
	}

	@Override
	public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
		Object target = null;
		if (Element.class.equals(sourceType.getType()) && ElementDTO.class.equals(targetType.getType())) {
			target = this.convertToElementDTO((Element) source);
		}
		if (ElementDTO.class.equals(sourceType.getType()) && Element.class.equals(targetType.getType())) {
			target = this.convertToElement((ElementDTO) source);
		}
		return target;
	}

	private Object convertToElement(ElementDTO source) {
		Element target = new Element();
		target.setId(source.getId());
		target.setName(source.getName());
		target.setCode(source.getCode());
		target.setType(source.getType());

		target.setTheoryQuantity(source.getTheoryQuantity());
		target.setWeight(source.getWeight());
		target.setLength(source.getLength());
		target.setBreadth(source.getBreadth());
		target.setTheoryArea(source.getTheoryArea());
		target.setBillingConcreteQuantity(source.getBillingConcreteQuantity());
		return target;
	}

	private Object convertToElementDTO(Element source) {
		ElementDTO target = new ElementDTO();
		target.setId(source.getId());
		target.setName(source.getName());
		target.setCode(source.getCode());
		target.setType(source.getType());
		target.setTheoryQuantity(source.getTheoryQuantity());
		target.setWeight(source.getWeight());
		target.setLength(source.getLength());
		target.setBreadth(source.getBreadth());
		target.setTheoryArea(source.getTheoryArea());
		target.setBillingConcreteQuantity(source.getBillingConcreteQuantity());

		target.setProjectId(source.getProject().getId());
		target.setMixtureId(source.getMixture().getId());
		Set<Long> steelItemIds = new HashSet<>();
		if (source.getSteelItems() != null) {
			for (SteelItem steelItem : source.getSteelItems()) {
				steelItemIds.add(steelItem.getId());
			}
		}
		target.setSteelItemIds(steelItemIds);
		return target;
	}
}

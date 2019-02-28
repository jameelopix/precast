package com.vme.precast.labourrate.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.stereotype.Component;

import com.vme.precast.domain.LabourRate;
import com.vme.precast.labourrate.api.LabourRateDTO;

@Component
public class LabourRateGenericConvertor implements GenericConverter {

	@Override
	public Set<ConvertiblePair> getConvertibleTypes() {
		Set<ConvertiblePair> convertiblePairs = new HashSet<>();
		convertiblePairs.add(new ConvertiblePair(LabourRate.class, LabourRateDTO.class));
		convertiblePairs.add(new ConvertiblePair(LabourRateDTO.class, LabourRate.class));
		return convertiblePairs;
	}

	@Override
	public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
		Object target = null;
		if (LabourRate.class.equals(sourceType.getType()) && LabourRate.class.equals(targetType.getType())) {
			target = this.convertToLabourRateDTO((LabourRate) source);
		}
		if (LabourRateDTO.class.equals(sourceType.getType()) && LabourRate.class.equals(targetType.getType())) {
			target = this.convertToLabourRate((LabourRateDTO) source);
		}
		return target;
	}

	private Object convertToLabourRate(LabourRateDTO source) {
		LabourRate target = new LabourRate();
		target.setId(source.getId());
		target.setWorkType(source.getWorkType());
		target.setWorkDesc(source.getWorkDesc());

		target.setNatureOfWork(source.getNatureOfWork());
		target.setUnit(source.getUnit());
		target.setRate(source.getRate());
		return target;
	}

	private Object convertToLabourRateDTO(LabourRate source) {
		LabourRateDTO target = new LabourRateDTO();
		target.setId(source.getId());
		target.setWorkType(source.getWorkType());
		target.setWorkDesc(source.getWorkDesc());

		target.setNatureOfWork(source.getNatureOfWork());
		target.setUnit(source.getUnit());
		target.setRate(source.getRate());

		target.setProjectId(source.getProject().getId());
		target.setElementTypeId(source.getElementType().getId());
		return target;
	}
}

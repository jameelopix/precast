package com.vme.precast.labouractivity.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.stereotype.Component;

import com.vme.precast.domain.LabourActivity;
import com.vme.precast.labouractivity.api.LabourActivityDTO;

@Component
public class LabourActivityGenericConvertor implements GenericConverter {

	@Override
	public Set<ConvertiblePair> getConvertibleTypes() {
		Set<ConvertiblePair> convertiblePairs = new HashSet<>();
		convertiblePairs.add(new ConvertiblePair(LabourActivity.class, LabourActivityDTO.class));
		convertiblePairs.add(new ConvertiblePair(LabourActivityDTO.class, LabourActivity.class));
		return convertiblePairs;
	}

	@Override
	public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
		Object target = null;
		if (LabourActivity.class.equals(sourceType.getType()) && LabourActivityDTO.class.equals(targetType.getType())) {
			target = this.convertToLabourActivityDTO((LabourActivity) source);
		}
		if (LabourActivityDTO.class.equals(sourceType.getType()) && LabourActivity.class.equals(targetType.getType())) {
			target = this.convertToLabourActivity((LabourActivityDTO) source);
		}
		return target;
	}

	private Object convertToLabourActivity(LabourActivityDTO source) {
		LabourActivity target = new LabourActivity();
		target.setId(source.getId());
		target.setNatureOfWork(source.getNatureOfWork());
		target.setQuantity(source.getQuantity());
		return target;
	}

	private Object convertToLabourActivityDTO(LabourActivity source) {
		LabourActivityDTO target = new LabourActivityDTO();
		target.setId(source.getId());
		target.setCastingActivityId(source.getCastingActivity().getId());
		target.setSubContractorId(source.getSubContractor().getId());
		target.setNatureOfWork(source.getNatureOfWork());
		target.setQuantity(source.getQuantity());
		return target;
	}
}

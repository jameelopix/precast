package com.vme.precast.subcontractor.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.stereotype.Component;

import com.vme.precast.domain.SubContractor;
import com.vme.precast.subcontractor.api.SubContractorDTO;

@Component
public class SubContractorGenericConvertor implements GenericConverter {

	@Override
	public Set<ConvertiblePair> getConvertibleTypes() {
		Set<ConvertiblePair> convertiblePairs = new HashSet<>();
		convertiblePairs.add(new ConvertiblePair(SubContractor.class, SubContractorDTO.class));
		convertiblePairs.add(new ConvertiblePair(SubContractorDTO.class, SubContractor.class));
		return convertiblePairs;
	}

	@Override
	public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
		Object target = null;
		if (sourceType.getType() == SubContractor.class && targetType.getType() == SubContractorDTO.class) {
			target = this.convertToSubContractorDTO((SubContractor) source);
		}
		if (sourceType.getType() == SubContractorDTO.class && targetType.getType() == SubContractor.class) {
			target = this.convertToSubContractor((SubContractorDTO) source);
		}
		return target;
	}

	private Object convertToSubContractor(SubContractorDTO source) {
		SubContractor target = new SubContractor();
		target.setId(source.getId());
		target.setName(source.getName());
		target.setPanNumber(source.getPanNumber());
		target.setRetentionPercent(source.getRetentionPercent());
		target.setTdsPercent(source.getTdsPercent());
		return target;
	}

	private Object convertToSubContractorDTO(SubContractor source) {
		SubContractorDTO target = new SubContractorDTO();
		target.setId(source.getId());
		target.setName(source.getName());
		target.setPanNumber(source.getPanNumber());
		target.setRetentionPercent(source.getRetentionPercent());
		target.setTdsPercent(source.getTdsPercent());
		return target;
	}
}

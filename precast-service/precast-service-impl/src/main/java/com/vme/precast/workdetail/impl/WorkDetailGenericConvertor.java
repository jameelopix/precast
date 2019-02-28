package com.vme.precast.workdetail.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.stereotype.Component;

import com.vme.precast.domain.WorkDetail;
import com.vme.precast.workdetail.api.WorkDetailDTO;

@Component
public class WorkDetailGenericConvertor implements GenericConverter {

	@Override
	public Set<ConvertiblePair> getConvertibleTypes() {
		Set<ConvertiblePair> convertiblePairs = new HashSet<>();
		convertiblePairs.add(new ConvertiblePair(WorkDetail.class, WorkDetailDTO.class));
		convertiblePairs.add(new ConvertiblePair(WorkDetailDTO.class, WorkDetail.class));
		return convertiblePairs;
	}

	@Override
	public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
		Object target = null;
		if (sourceType.getType() == WorkDetail.class && targetType.getType() == WorkDetailDTO.class) {
			target = this.convertToWorkDetailDTO((WorkDetail) source);
		}
		if (sourceType.getType() == WorkDetailDTO.class && targetType.getType() == WorkDetail.class) {
			target = this.convertToWorkDetail((WorkDetailDTO) source);
		}
		return target;
	}

	private Object convertToWorkDetail(WorkDetailDTO source) {
		WorkDetail target = new WorkDetail();
		target.setId(source.getId());
		target.setProjectId(source.getProjectId());
		target.setElementTypeId(source.getElementTypeId());
		target.setWorkNature(source.getWorkNature());
		target.setWorkDesc(source.getWorkDesc());
		return target;
	}

	private Object convertToWorkDetailDTO(WorkDetail source) {
		WorkDetailDTO target = new WorkDetailDTO();
		target.setId(source.getId());
		target.setProjectId(source.getProjectId());
		target.setElementTypeId(source.getElementTypeId());
		target.setWorkNature(source.getWorkNature());
		target.setWorkDesc(source.getWorkDesc());
		return target;
	}
}
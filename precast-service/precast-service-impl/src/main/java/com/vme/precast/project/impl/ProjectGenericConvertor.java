package com.vme.precast.project.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.stereotype.Component;

import com.vme.precast.domain.Project;
import com.vme.precast.project.api.ProjectDTO;

@Component
public class ProjectGenericConvertor implements GenericConverter {

	@Override
	public Set<ConvertiblePair> getConvertibleTypes() {
		Set<ConvertiblePair> convertiblePairs = new HashSet<>();
		convertiblePairs.add(new ConvertiblePair(Project.class, ProjectDTO.class));
		convertiblePairs.add(new ConvertiblePair(ProjectDTO.class, Project.class));
		return convertiblePairs;
	}

	@Override
	public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
		Object target = null;
		if (sourceType.getType() == Project.class && targetType.getType() == ProjectDTO.class) {
			target = this.convertToProjectDTO((Project) source);
		}
		if (sourceType.getType() == ProjectDTO.class && targetType.getType() == Project.class) {
			target = this.convertToProject((ProjectDTO) source);
		}
		return target;
	}

	private Object convertToProject(ProjectDTO source) {
		Project target = new Project();
		target.setId(source.getId());
		target.setCode(source.getCode());
		target.setName(source.getName());
		target.setUnitType(source.getUnitType());
		target.setQuantity(source.getQuantity());
		target.setProductionRate(source.getProductionRate());
		target.setProductionAmount(source.getProductionAmount());
		target.setLogisticsRate(source.getLogisticsRate());
		target.setLogisticsAmount(source.getLogisticsAmount());
		target.setErectionRate(source.getErectionRate());
		target.setErectionAmount(source.getErectionAmount());
		target.setMiscAmount(source.getMiscAmount());
		target.setTotalAmount(source.getTotalAmount());
		return target;
	}

	private Object convertToProjectDTO(Project source) {
		ProjectDTO target = new ProjectDTO();
		target.setId(source.getId());
		target.setCode(source.getCode());
		target.setName(source.getName());
		target.setUnitType(source.getUnitType());
		target.setQuantity(source.getQuantity());
		target.setProductionRate(source.getProductionRate());
		target.setProductionAmount(source.getProductionAmount());
		target.setLogisticsRate(source.getLogisticsRate());
		target.setLogisticsAmount(source.getLogisticsAmount());
		target.setErectionRate(source.getErectionRate());
		target.setErectionAmount(source.getErectionAmount());
		target.setMiscAmount(source.getMiscAmount());
		target.setTotalAmount(source.getTotalAmount());
		return target;
	}
}

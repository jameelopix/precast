package com.vme.precast.company.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.stereotype.Component;

import com.vme.precast.company.api.CompanyDTO;
import com.vme.precast.domain.Company;

@Component
public class CompanyGenericConvertor implements GenericConverter {

	@Override
	public Set<ConvertiblePair> getConvertibleTypes() {
		Set<ConvertiblePair> convertiblePairs = new HashSet<>();
		convertiblePairs.add(new ConvertiblePair(Company.class, CompanyDTO.class));
		convertiblePairs.add(new ConvertiblePair(CompanyDTO.class, Company.class));
		return convertiblePairs;
	}

	@Override
	public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
		Object target = null;
		if (sourceType.getType() == Company.class && targetType.getType() == CompanyDTO.class) {
			target = this.convertToCompanyDTO((Company) source);
		}
		if (sourceType.getType() == CompanyDTO.class && targetType.getType() == Company.class) {
			target = this.convertToCompany((CompanyDTO) source);
		}
		return target;
	}

	private Object convertToCompany(CompanyDTO source) {
		Company target = new Company();
		target.setId(source.getId());
		target.setName(source.getName());
		target.setSelfCompany(source.getSelfCompany());
		target.setDisabled(source.getDisabled());
		return target;
	}

	private Object convertToCompanyDTO(Company source) {
		CompanyDTO target = new CompanyDTO();
		target.setId(source.getId());
		target.setName(source.getName());
		target.setSelfCompany(source.getSelfCompany());
		target.setDisabled(source.getDisabled());
		return target;
	}
}

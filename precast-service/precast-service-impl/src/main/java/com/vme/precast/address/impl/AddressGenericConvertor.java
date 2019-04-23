package com.vme.precast.address.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.stereotype.Component;

import com.vme.precast.domain.Address;
import com.vme.precast.address.api.AddressDTO;

@Component
public class AddressGenericConvertor implements GenericConverter {

	@Override
	public Set<ConvertiblePair> getConvertibleTypes() {
		Set<ConvertiblePair> convertiblePairs = new HashSet<>();
		convertiblePairs.add(new ConvertiblePair(Address.class, AddressDTO.class));
		convertiblePairs.add(new ConvertiblePair(AddressDTO.class, Address.class));
		return convertiblePairs;
	}

	@Override
	public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
		Object target = null;
		if (sourceType.getType() == Address.class && targetType.getType() == AddressDTO.class) {
			target = this.convertToAddressDTO((Address) source);
		}
		if (sourceType.getType() == AddressDTO.class && targetType.getType() == Address.class) {
			target = this.convertToAddress((AddressDTO) source);
		}
		return target;
	}

	private Object convertToAddress(AddressDTO source) {
		Address target = new Address();
		target.setId(source.getId());
		target.setAddressLine1(source.getAddressLine1());
		target.setAddressLine2(source.getAddressLine2());
		target.setPincode(source.getPincode());
		target.setState(source.getState());
		target.setCountry(source.getCountry());
		return target;
	}

	private Object convertToAddressDTO(Address source) {
		AddressDTO target = new AddressDTO();
		target.setId(source.getId());
		target.setAddressLine1(source.getAddressLine1());
		target.setAddressLine2(source.getAddressLine2());
		target.setPincode(source.getPincode());
		target.setState(source.getState());
		target.setCountry(source.getCountry());
		return target;
	}
}
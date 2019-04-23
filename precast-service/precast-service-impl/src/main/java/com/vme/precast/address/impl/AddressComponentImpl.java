package com.vme.precast.address.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import com.vme.precast.address.api.AddressComponent;
import com.vme.precast.address.api.AddressDTO;
import com.vme.precast.address.api.AddressSearchDTO;
import com.vme.precast.address.api.AddressServiceRequest;
import com.vme.precast.address.api.AddressServiceResponse;
import com.vme.precast.domain.Address;
import com.vme.precast.repository.AddressRepo;

import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;
import coliseum.service.FilterUtils;

@Component
public class AddressComponentImpl implements AddressComponent {
	@Autowired
	AddressRepo addressRepo;

	@Autowired
	ConversionService conversionService;

	@Override
	public AddressServiceResponse createAddress(AddressServiceRequest addressServiceRequest) {
		AddressDTO addressDTO = addressServiceRequest.getAddressDTO();
		Address address = conversionService.convert(addressDTO, Address.class);
		addressRepo.save(address);
		return null;
	}

	@Override
	public AddressServiceResponse getAddresss(AddressServiceRequest addressServiceRequest) {
		List<Address> addressList = new ArrayList<>();
		List<Filter> filters = new ArrayList<>();
		SearchObject searchObject = new SearchObject();

		AddressSearchDTO addressSearchDTO = addressServiceRequest.getAddressSearchDTO();
		if (addressSearchDTO != null) {
			List<Long> ids = addressSearchDTO.getIds();
			List<String> addressLine1List = addressSearchDTO.getAddressLine1s();
			List<String> addressLine2List = addressSearchDTO.getAddressLine2s();
			List<String> countryList = addressSearchDTO.getCountrys();
			List<String> stateList = addressSearchDTO.getStates();
			List<String> pincodeList = addressSearchDTO.getPincodes();

			FilterUtils.createEqualFilter(filters, AddressSearchDTO.ID, ids);
			FilterUtils.createEqualFilter(filters, AddressSearchDTO.ADDRESS_LINE_1, addressLine1List);
			FilterUtils.createEqualFilter(filters, AddressSearchDTO.ADDRESS_LINE_2, addressLine2List);
			FilterUtils.createEqualFilter(filters, AddressSearchDTO.COUNTRY, countryList);
			FilterUtils.createEqualFilter(filters, AddressSearchDTO.STATE, stateList);
			FilterUtils.createEqualFilter(filters, AddressSearchDTO.PIN_CODE, pincodeList);

			if (CollectionUtils.isNotEmpty(filters)) {
				searchObject.setFilters(filters);
			}
		}
		searchObject.setPageIndex(addressServiceRequest.getPageIndex());
		searchObject.setRecordstoFetch(addressServiceRequest.getRecordstoFetch());
		addressList = addressRepo.search(searchObject);

		List<AddressDTO> addressDTOList = new ArrayList<>();
		for (Address target : addressList) {
			addressDTOList.add(conversionService.convert(target, AddressDTO.class));
		}
		AddressServiceResponse addressServiceResponse = new AddressServiceResponse();
		addressServiceResponse.setAddressDTOList(addressDTOList);
		return addressServiceResponse;
	}

	@Override
	public AddressServiceResponse updateAddress(AddressServiceRequest addressServiceRequest) {
		AddressDTO source = addressServiceRequest.getAddressDTO();

		Address target = addressRepo.findById(source.getId()).get();
		target.setAddressLine1(source.getAddressLine1());
		target.setAddressLine2(source.getAddressLine2());
		target.setPincode(source.getPincode());
		target.setState(source.getState());
		target.setCountry(source.getCountry());

		addressRepo.save(target);
		return null;
	}

	@Override
	public AddressServiceResponse deleteAddress(AddressServiceRequest addressServiceRequest) {
		AddressDTO addressDTO = addressServiceRequest.getAddressDTO();
		addressRepo.deleteById(addressDTO.getId());
		return null;
	}
}
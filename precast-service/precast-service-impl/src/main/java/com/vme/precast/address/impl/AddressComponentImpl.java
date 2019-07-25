package com.vme.precast.address.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.domain.Address;
import com.vme.precast.repository.AddressRepo;
import com.vme.precast.address.api.AddressComponent;
import com.vme.precast.address.api.AddressDTO;
import com.vme.precast.address.api.AddressSearchDTO;
import com.vme.precast.address.api.AddressServiceRequest;
import com.vme.precast.address.api.AddressServiceResponse;

import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;
import coliseum.service.ConversionUtility;
import coliseum.service.FilterUtils;

public class AddressComponentImpl implements AddressComponent {
    @Autowired
    AddressRepo addressRepo;

    @Autowired
    ConversionUtility conversionUtility;

    @Override
    public AddressServiceResponse createAddress(AddressServiceRequest addressServiceRequest) {
        AddressDTO addressDTO = addressServiceRequest.getAddressDTO();
        Address address = (Address) conversionUtility.convert(addressDTO, AddressDTO.class, Address.class);
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
            List<Long> idList = addressSearchDTO.getIdList();
            List<String> addressLine1List = addressSearchDTO.getAddressLine1List();
            List<String> addressLine2List = addressSearchDTO.getAddressLine2List();
            List<String> landmarkList = addressSearchDTO.getLandmarkList();
            List<String> cityList = addressSearchDTO.getCityList();
            List<String> stateList = addressSearchDTO.getStateList();
            List<String> countryList = addressSearchDTO.getCountryList();
            List<String> mobNoList = addressSearchDTO.getMobNoList();
            List<String> pincodeList = addressSearchDTO.getPincodeList();

            FilterUtils.createEqualFilter(filters, AddressSearchDTO.ID, idList);
            FilterUtils.createEqualFilter(filters, AddressSearchDTO.ADDRESSLINE1, addressLine1List);
            FilterUtils.createEqualFilter(filters, AddressSearchDTO.ADDRESSLINE2, addressLine2List);
            FilterUtils.createEqualFilter(filters, AddressSearchDTO.LANDMARK, landmarkList);
            FilterUtils.createEqualFilter(filters, AddressSearchDTO.CITY, cityList);
            FilterUtils.createEqualFilter(filters, AddressSearchDTO.STATE, stateList);
            FilterUtils.createEqualFilter(filters, AddressSearchDTO.COUNTRY, countryList);
            FilterUtils.createEqualFilter(filters, AddressSearchDTO.MOBNO, mobNoList);
            FilterUtils.createEqualFilter(filters, AddressSearchDTO.PINCODE, pincodeList);

            if (CollectionUtils.isNotEmpty(filters)) {
                searchObject.setFilters(filters);
            }
        }
        searchObject.setPageIndex(addressServiceRequest.getPageIndex());
        searchObject.setRecordstoFetch(addressServiceRequest.getRecordstoFetch());
        addressList = addressRepo.search(searchObject);

        List<AddressDTO> addressDTOList = new ArrayList<>();
        for (Address target : addressList) {
            addressDTOList.add((AddressDTO) conversionUtility.convert(target, Address.class, AddressDTO.class));
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
        target.setLandmark(source.getLandmark());
        target.setCity(source.getCity());
        target.setState(source.getState());
        target.setCountry(source.getCountry());
        target.setMobNo(source.getMobNo());
        target.setPincode(source.getPincode());

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
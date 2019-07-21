package com.vme.precast.vendor.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.domain.Vendor;
import com.vme.precast.repository.VendorRepo;
import com.vme.precast.vendor.api.VendorDTO;
import com.vme.precast.vendor.api.VendorSearchDTO;
import com.vme.precast.vendor.api.VendorServiceRequest;
import com.vme.precast.vendor.api.VendorValidator;

import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;
import coliseum.service.ErrorDTO;
import coliseum.service.FilterUtils;

public class VendorValidatorImpl implements VendorValidator {
    @Autowired
    VendorRepo vendorRepo;

    @Override
    public ErrorDTO checkVendorDuplicate(VendorServiceRequest vendorServiceRequest) {
        ErrorDTO errorDTO = null;
        VendorDTO vendorDTO = vendorServiceRequest.getVendorDTO();

        SearchObject searchObject = new SearchObject();
        List<Filter> filters = new ArrayList<>();
        FilterUtils.createEqualFilter(filters, VendorSearchDTO.CODE, vendorDTO.getCode());
        if (CollectionUtils.isNotEmpty(filters)) {
            searchObject.setFilters(filters);
        }
        List<Vendor> vendorList = vendorRepo.search(searchObject);

        if (CollectionUtils.isNotEmpty(vendorList)) {
            for (Vendor vendor : vendorList) {
                if (!vendor.getId().equals(vendorDTO.getId())) {
                    errorDTO = new ErrorDTO("ERR_VR_100", "Vendor Code already exists!!!");
                    break;
                }
            }
        }
        return errorDTO;
    }
}
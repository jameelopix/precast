package com.vme.precast.vendor.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.domain.Vendor;
import com.vme.precast.repository.VendorRepo;
import com.vme.precast.vendor.api.VendorComponent;
import com.vme.precast.vendor.api.VendorDTO;
import com.vme.precast.vendor.api.VendorSearchDTO;
import com.vme.precast.vendor.api.VendorServiceRequest;
import com.vme.precast.vendor.api.VendorServiceResponse;

import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;
import coliseum.service.ConversionUtility;
import coliseum.service.FilterUtils;

public class VendorComponentImpl implements VendorComponent {
    @Autowired
    VendorRepo vendorRepo;

    @Autowired
    ConversionUtility conversionUtility;

    @Override
    public VendorServiceResponse createVendor(VendorServiceRequest vendorServiceRequest) {
        VendorDTO vendorDTO = vendorServiceRequest.getVendorDTO();
        Vendor vendor = (Vendor) conversionUtility.convert(vendorDTO, VendorDTO.class, Vendor.class);
        vendorRepo.save(vendor);
        return null;
    }

    @Override
    public VendorServiceResponse getVendors(VendorServiceRequest vendorServiceRequest) {
        List<Vendor> vendorList = new ArrayList<>();
        List<Filter> filters = new ArrayList<>();
        SearchObject searchObject = new SearchObject();

        VendorSearchDTO vendorSearchDTO = vendorServiceRequest.getVendorSearchDTO();
        if (vendorSearchDTO != null) {
            List<Long> idList = vendorSearchDTO.getIdList();
            List<String> nameList = vendorSearchDTO.getNameList();

            FilterUtils.createEqualFilter(filters, VendorSearchDTO.ID, idList);
            FilterUtils.createEqualFilter(filters, VendorSearchDTO.NAME, nameList);

            if (CollectionUtils.isNotEmpty(filters)) {
                searchObject.setFilters(filters);
            }
        }
        searchObject.setPageIndex(vendorServiceRequest.getPageIndex());
        searchObject.setRecordstoFetch(vendorServiceRequest.getRecordstoFetch());
        vendorList = vendorRepo.search(searchObject);

        List<VendorDTO> vendorDTOList = new ArrayList<>();
        for (Vendor target : vendorList) {
            vendorDTOList.add((VendorDTO) conversionUtility.convert(target, Vendor.class, VendorDTO.class));
        }
        VendorServiceResponse vendorServiceResponse = new VendorServiceResponse();
        vendorServiceResponse.setVendorDTOList(vendorDTOList);
        return vendorServiceResponse;
    }

    @Override
    public VendorServiceResponse updateVendor(VendorServiceRequest vendorServiceRequest) {
        VendorDTO source = vendorServiceRequest.getVendorDTO();

        Vendor target = vendorRepo.findById(source.getId()).get();
        target.setName(source.getName());

        vendorRepo.save(target);
        return null;
    }

    @Override
    public VendorServiceResponse deleteVendor(VendorServiceRequest vendorServiceRequest) {
        VendorDTO vendorDTO = vendorServiceRequest.getVendorDTO();
        vendorRepo.deleteById(vendorDTO.getId());
        return null;
    }
}
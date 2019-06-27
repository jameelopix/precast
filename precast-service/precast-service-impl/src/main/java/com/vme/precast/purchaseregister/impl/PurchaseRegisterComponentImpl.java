package com.vme.precast.purchaseregister.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.domain.PurchaseRegister;
import com.vme.precast.domain.Vendor;
import com.vme.precast.purchaseregister.api.PurchaseRegisterComponent;
import com.vme.precast.purchaseregister.api.PurchaseRegisterDTO;
import com.vme.precast.purchaseregister.api.PurchaseRegisterSearchDTO;
import com.vme.precast.purchaseregister.api.PurchaseRegisterServiceRequest;
import com.vme.precast.purchaseregister.api.PurchaseRegisterServiceResponse;
import com.vme.precast.repository.PurchaseRegisterRepo;
import com.vme.precast.repository.VendorRepo;

import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;
import coliseum.service.ConversionUtility;
import coliseum.service.FilterUtils;

public class PurchaseRegisterComponentImpl implements PurchaseRegisterComponent {
    @Autowired
    PurchaseRegisterRepo purchaseRegisterRepo;

    @Autowired
    VendorRepo vendorRepo;

    @Autowired
    ConversionUtility conversionUtility;

    @Override
    public PurchaseRegisterServiceResponse createPurchaseRegister(
            PurchaseRegisterServiceRequest purchaseRegisterServiceRequest) {
        PurchaseRegisterDTO purchaseRegisterDTO = purchaseRegisterServiceRequest.getPurchaseRegisterDTO();
        PurchaseRegister purchaseregister = (PurchaseRegister) conversionUtility.convert(purchaseRegisterDTO,
                PurchaseRegisterDTO.class, PurchaseRegister.class);
        if (purchaseRegisterDTO.getVendorDTOId() != null) {
            Vendor vendor = vendorRepo.findById(purchaseRegisterDTO.getVendorDTOId()).get();
            purchaseregister.setVendor(vendor);
        }
        purchaseRegisterRepo.save(purchaseregister);
        return null;
    }

    @Override
    public PurchaseRegisterServiceResponse getPurchaseRegisters(
            PurchaseRegisterServiceRequest purchaseRegisterServiceRequest) {
        List<PurchaseRegister> purchaseRegisterList = new ArrayList<>();
        List<Filter> filters = new ArrayList<>();
        SearchObject searchObject = new SearchObject();

        PurchaseRegisterSearchDTO purchaseRegisterSearchDTO = purchaseRegisterServiceRequest
                .getPurchaseRegisterSearchDTO();
        if (purchaseRegisterSearchDTO != null) {
            List<Long> idList = purchaseRegisterSearchDTO.getIdList();
            List<String> weighBridgeNoList = purchaseRegisterSearchDTO.getWeighBridgeNoList();
            List<Long> vendorIdList = purchaseRegisterSearchDTO.getVendorIdList();

            FilterUtils.createEqualFilter(filters, PurchaseRegisterSearchDTO.ID, idList);
            FilterUtils.createEqualFilter(filters, PurchaseRegisterSearchDTO.WEIGHBRIDGENO, weighBridgeNoList);
            FilterUtils.createEqualFilter(filters, PurchaseRegisterSearchDTO.VENDORID, vendorIdList);

            if (CollectionUtils.isNotEmpty(filters)) {
                searchObject.setFilters(filters);
            }
        }
        searchObject.setPageIndex(purchaseRegisterServiceRequest.getPageIndex());
        searchObject.setRecordstoFetch(purchaseRegisterServiceRequest.getRecordstoFetch());
        purchaseRegisterList = purchaseRegisterRepo.search(searchObject);

        List<PurchaseRegisterDTO> purchaseRegisterDTOList = new ArrayList<>();
        for (PurchaseRegister target : purchaseRegisterList) {
            purchaseRegisterDTOList.add((PurchaseRegisterDTO) conversionUtility.convert(target, PurchaseRegister.class,
                    PurchaseRegisterDTO.class));
        }
        PurchaseRegisterServiceResponse purchaseRegisterServiceResponse = new PurchaseRegisterServiceResponse();
        purchaseRegisterServiceResponse.setPurchaseRegisterDTOList(purchaseRegisterDTOList);
        return purchaseRegisterServiceResponse;
    }

    @Override
    public PurchaseRegisterServiceResponse updatePurchaseRegister(
            PurchaseRegisterServiceRequest purchaseRegisterServiceRequest) {
        PurchaseRegisterDTO source = purchaseRegisterServiceRequest.getPurchaseRegisterDTO();

        PurchaseRegister target = purchaseRegisterRepo.findById(source.getId()).get();
        target.setWeighBridgeNo(source.getWeighBridgeNo());
        if (source.getVendorDTOId() != null && !source.getVendorDTOId().equals(target.getVendorId())) {
            Vendor vendor = vendorRepo.findById(source.getVendorDTOId()).get();
            target.setVendor(vendor);
        }
        purchaseRegisterRepo.save(target);
        return null;
    }

    @Override
    public PurchaseRegisterServiceResponse deletePurchaseRegister(
            PurchaseRegisterServiceRequest purchaseRegisterServiceRequest) {
        PurchaseRegisterDTO purchaseRegisterDTO = purchaseRegisterServiceRequest.getPurchaseRegisterDTO();
        purchaseRegisterRepo.deleteById(purchaseRegisterDTO.getId());
        return null;
    }
}
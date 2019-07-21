package com.vme.precast.itemamountdetails.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.domain.ItemAmountDetails;
import com.vme.precast.domain.Vendor;
import com.vme.precast.itemamountdetails.api.ItemAmountDetailsComponent;
import com.vme.precast.itemamountdetails.api.ItemAmountDetailsDTO;
import com.vme.precast.itemamountdetails.api.ItemAmountDetailsSearchDTO;
import com.vme.precast.itemamountdetails.api.ItemAmountDetailsServiceRequest;
import com.vme.precast.itemamountdetails.api.ItemAmountDetailsServiceResponse;
import com.vme.precast.purchaseregister.api.PurchaseRegisterSearchDTO;
import com.vme.precast.repository.ItemAmountDetailsRepo;
import com.vme.precast.repository.VendorRepo;

import coliseum.jpa.Association;
import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;
import coliseum.service.AssociationUtils;
import coliseum.service.ConversionUtility;
import coliseum.service.FilterUtils;

public class ItemAmountDetailsComponentImpl implements ItemAmountDetailsComponent {
    @Autowired
    ItemAmountDetailsRepo itemAmountDetailsRepo;
    @Autowired
    VendorRepo vendorRepo;

    @Autowired
    ConversionUtility conversionUtility;

    @Override
    public ItemAmountDetailsServiceResponse createItemAmountDetails(
            ItemAmountDetailsServiceRequest itemAmountDetailsServiceRequest) {
        ItemAmountDetailsDTO itemAmountDetailsDTO = itemAmountDetailsServiceRequest.getItemAmountDetailsDTO();
        ItemAmountDetails itemamountdetails = (ItemAmountDetails) conversionUtility.convert(itemAmountDetailsDTO,
                ItemAmountDetailsDTO.class, ItemAmountDetails.class);

        if (itemAmountDetailsDTO.getVendorDTOId() != null) {
            Vendor vendor = vendorRepo.findById(itemAmountDetailsDTO.getVendorDTOId()).get();
            itemamountdetails.setVendor(vendor);
        }
        itemAmountDetailsRepo.save(itemamountdetails);
        return null;
    }

    @Override
    public ItemAmountDetailsServiceResponse getItemAmountDetailss(
            ItemAmountDetailsServiceRequest itemAmountDetailsServiceRequest) {
        List<ItemAmountDetails> itemAmountDetailsList = new ArrayList<>();
        List<Filter> filters = new ArrayList<>();
        SearchObject searchObject = new SearchObject();
        List<Association> associations = new ArrayList<>();

        ItemAmountDetailsSearchDTO itemAmountDetailsSearchDTO = itemAmountDetailsServiceRequest
                .getItemAmountDetailsSearchDTO();
        if (itemAmountDetailsSearchDTO != null) {
            List<Long> idList = itemAmountDetailsSearchDTO.getIdList();
            List<String> dcNoList = itemAmountDetailsSearchDTO.getDcNoList();
            List<Long> vendorDTOIdList = itemAmountDetailsSearchDTO.getVendorDTOIdList();
            List<Boolean> invoiceCheckedList = itemAmountDetailsSearchDTO.getInvoiceCheckedList();
            List<Double> totalList = itemAmountDetailsSearchDTO.getTotalList();

            FilterUtils.createEqualFilter(filters, ItemAmountDetailsSearchDTO.ID, idList);
            FilterUtils.createEqualFilter(filters, ItemAmountDetailsSearchDTO.DCNO, dcNoList);
            FilterUtils.createEqualFilter(filters, ItemAmountDetailsSearchDTO.INVOICECHECKED, invoiceCheckedList);
            FilterUtils.createEqualFilter(filters, ItemAmountDetailsSearchDTO.TOTAL, totalList);
            FilterUtils.createEqualFilter(filters, ItemAmountDetailsSearchDTO.VENDORID, vendorDTOIdList);

            if (CollectionUtils.isNotEmpty(filters)) {
                searchObject.setFilters(filters);
            }

            AssociationUtils.createAssociation(associations, ItemAmountDetailsSearchDTO.VENDOR,
                    itemAmountDetailsSearchDTO.isVendorNeeded());

            if (CollectionUtils.isNotEmpty(associations)) {
                searchObject.setAssociations(associations);
            }
        }
        searchObject.setPageIndex(itemAmountDetailsServiceRequest.getPageIndex());
        searchObject.setRecordstoFetch(itemAmountDetailsServiceRequest.getRecordstoFetch());
        itemAmountDetailsList = itemAmountDetailsRepo.search(searchObject);

        List<ItemAmountDetailsDTO> itemAmountDetailsDTOList = new ArrayList<>();
        for (ItemAmountDetails target : itemAmountDetailsList) {
            itemAmountDetailsDTOList.add((ItemAmountDetailsDTO) conversionUtility.convert(target,
                    ItemAmountDetails.class, ItemAmountDetailsDTO.class));
        }
        ItemAmountDetailsServiceResponse itemAmountDetailsServiceResponse = new ItemAmountDetailsServiceResponse();
        itemAmountDetailsServiceResponse.setItemAmountDetailsDTOList(itemAmountDetailsDTOList);
        return itemAmountDetailsServiceResponse;
    }

    @Override
    public ItemAmountDetailsServiceResponse updateItemAmountDetails(
            ItemAmountDetailsServiceRequest itemAmountDetailsServiceRequest) {
        ItemAmountDetailsDTO source = itemAmountDetailsServiceRequest.getItemAmountDetailsDTO();

        ItemAmountDetails target = itemAmountDetailsRepo.findById(source.getId()).get();
        target.setDcNo(source.getDcNo());
        target.setTotal(source.getTotal());
        target.setInvoiceChecked(source.getInvoiceChecked());

        if (source.getVendorDTOId() != null && !source.getVendorDTOId().equals(target.getVendorId())) {
            Vendor vendor = vendorRepo.findById(source.getVendorDTOId()).get();
            target.setVendor(vendor);
        }
        itemAmountDetailsRepo.save(target);
        return null;
    }

    @Override
    public ItemAmountDetailsServiceResponse deleteItemAmountDetails(
            ItemAmountDetailsServiceRequest itemAmountDetailsServiceRequest) {
        ItemAmountDetailsDTO itemAmountDetailsDTO = itemAmountDetailsServiceRequest.getItemAmountDetailsDTO();
        itemAmountDetailsRepo.deleteById(itemAmountDetailsDTO.getId());
        return null;
    }
}
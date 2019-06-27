package com.vme.precast.itembasicamountdetails.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.domain.ItemAmountDetails;
import com.vme.precast.domain.ItemBasicAmountDetails;
import com.vme.precast.domain.PurchaseRegisterItem;
import com.vme.precast.itembasicamountdetails.api.ItemBasicAmountDetailsComponent;
import com.vme.precast.itembasicamountdetails.api.ItemBasicAmountDetailsDTO;
import com.vme.precast.itembasicamountdetails.api.ItemBasicAmountDetailsSearchDTO;
import com.vme.precast.itembasicamountdetails.api.ItemBasicAmountDetailsServiceRequest;
import com.vme.precast.itembasicamountdetails.api.ItemBasicAmountDetailsServiceResponse;
import com.vme.precast.repository.ItemAmountDetailsRepo;
import com.vme.precast.repository.ItemBasicAmountDetailsRepo;
import com.vme.precast.repository.PurchaseRegisterItemRepo;

import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;
import coliseum.service.ConversionUtility;
import coliseum.service.FilterUtils;

public class ItemBasicAmountDetailsComponentImpl implements ItemBasicAmountDetailsComponent {
    @Autowired
    ItemBasicAmountDetailsRepo itemBasicAmountDetailsRepo;
    @Autowired
    PurchaseRegisterItemRepo purchaseRegisterItemRepo;
    @Autowired
    ItemAmountDetailsRepo itemAmountDetailsRepo;

    @Autowired
    ConversionUtility conversionUtility;

    @Override
    public ItemBasicAmountDetailsServiceResponse createItemBasicAmountDetails(
            ItemBasicAmountDetailsServiceRequest itemBasicAmountDetailsServiceRequest) {
        ItemBasicAmountDetailsDTO itemBasicAmountDetailsDTO = itemBasicAmountDetailsServiceRequest
                .getItemBasicAmountDetailsDTO();
        ItemBasicAmountDetails itembasicamountdetails = (ItemBasicAmountDetails) conversionUtility
                .convert(itemBasicAmountDetailsDTO, ItemBasicAmountDetailsDTO.class, ItemBasicAmountDetails.class);

        if (itemBasicAmountDetailsDTO.getPurchaseRegisterItemId() != null) {
            PurchaseRegisterItem purchaseRegisterItem = purchaseRegisterItemRepo
                    .findById(itemBasicAmountDetailsDTO.getPurchaseRegisterItemId()).get();
            itembasicamountdetails.setPurchaseRegisterItem(purchaseRegisterItem);
        }
        if (itemBasicAmountDetailsDTO.getItemAmountDetailsId() != null) {
            ItemAmountDetails itemAmountDetails = itemAmountDetailsRepo
                    .findById(itemBasicAmountDetailsDTO.getItemAmountDetailsId()).get();
            itembasicamountdetails.setItemAmountDetails(itemAmountDetails);
        }
        itemBasicAmountDetailsRepo.save(itembasicamountdetails);
        return null;
    }

    @Override
    public ItemBasicAmountDetailsServiceResponse getItemBasicAmountDetailss(
            ItemBasicAmountDetailsServiceRequest itemBasicAmountDetailsServiceRequest) {
        List<ItemBasicAmountDetails> itemBasicAmountDetailsList = new ArrayList<>();
        List<Filter> filters = new ArrayList<>();
        SearchObject searchObject = new SearchObject();

        ItemBasicAmountDetailsSearchDTO itemBasicAmountDetailsSearchDTO = itemBasicAmountDetailsServiceRequest
                .getItemBasicAmountDetailsSearchDTO();
        if (itemBasicAmountDetailsSearchDTO != null) {
            List<Long> ids = itemBasicAmountDetailsSearchDTO.getIdList();
            List<Double> rateList = itemBasicAmountDetailsSearchDTO.getRateList();
            List<Double> amountList = itemBasicAmountDetailsSearchDTO.getAmountList();
            List<Double> taxPercentList = itemBasicAmountDetailsSearchDTO.getTaxPercentList();
            List<Double> taxAmountList = itemBasicAmountDetailsSearchDTO.getTaxAmountList();
            List<Double> totalList = itemBasicAmountDetailsSearchDTO.getTotalList();

            FilterUtils.createEqualFilter(filters, ItemBasicAmountDetailsSearchDTO.ID, ids);
            FilterUtils.createEqualFilter(filters, ItemBasicAmountDetailsSearchDTO.RATE, rateList);
            FilterUtils.createEqualFilter(filters, ItemBasicAmountDetailsSearchDTO.AMOUNT, amountList);
            FilterUtils.createEqualFilter(filters, ItemBasicAmountDetailsSearchDTO.TAXPERCENT, taxPercentList);
            FilterUtils.createEqualFilter(filters, ItemBasicAmountDetailsSearchDTO.TAXAMOUNT, taxAmountList);
            FilterUtils.createEqualFilter(filters, ItemBasicAmountDetailsSearchDTO.TOTAL, totalList);

            if (CollectionUtils.isNotEmpty(filters)) {
                searchObject.setFilters(filters);
            }
        }
        searchObject.setPageIndex(itemBasicAmountDetailsServiceRequest.getPageIndex());
        searchObject.setRecordstoFetch(itemBasicAmountDetailsServiceRequest.getRecordstoFetch());
        itemBasicAmountDetailsList = itemBasicAmountDetailsRepo.search(searchObject);

        List<ItemBasicAmountDetailsDTO> itemBasicAmountDetailsDTOList = new ArrayList<>();
        for (ItemBasicAmountDetails target : itemBasicAmountDetailsList) {
            itemBasicAmountDetailsDTOList.add((ItemBasicAmountDetailsDTO) conversionUtility.convert(target,
                    ItemBasicAmountDetails.class, ItemBasicAmountDetailsDTO.class));
        }
        ItemBasicAmountDetailsServiceResponse itemBasicAmountDetailsServiceResponse = new ItemBasicAmountDetailsServiceResponse();
        itemBasicAmountDetailsServiceResponse.setItemBasicAmountDetailsDTOList(itemBasicAmountDetailsDTOList);
        return itemBasicAmountDetailsServiceResponse;
    }

    @Override
    public ItemBasicAmountDetailsServiceResponse updateItemBasicAmountDetails(
            ItemBasicAmountDetailsServiceRequest itemBasicAmountDetailsServiceRequest) {
        ItemBasicAmountDetailsDTO source = itemBasicAmountDetailsServiceRequest.getItemBasicAmountDetailsDTO();

        ItemBasicAmountDetails target = itemBasicAmountDetailsRepo.findById(source.getId()).get();
        target.setRate(source.getRate());
        target.setAmount(source.getAmount());
        target.setTaxPercent(source.getTaxPercent());
        target.setTaxAmount(source.getTaxAmount());
        target.setTotal(source.getTotal());

        if (source.getItemAmountDetailsId() != null
                && !source.getItemAmountDetailsId().equals(target.getItemAmountDetailsId())) {
            ItemAmountDetails itemAmountDetails = itemAmountDetailsRepo.findById(source.getItemAmountDetailsId()).get();
            target.setItemAmountDetails(itemAmountDetails);
        }
        if (source.getPurchaseRegisterItemId() != null
                && !source.getPurchaseRegisterItemId().equals(target.getPurchaseRegisterItemId())) {
            PurchaseRegisterItem purchaseRegisterItem = purchaseRegisterItemRepo
                    .findById(source.getPurchaseRegisterItemId()).get();
            target.setPurchaseRegisterItem(purchaseRegisterItem);
        }
        itemBasicAmountDetailsRepo.save(target);
        return null;
    }

    @Override
    public ItemBasicAmountDetailsServiceResponse deleteItemBasicAmountDetails(
            ItemBasicAmountDetailsServiceRequest itemBasicAmountDetailsServiceRequest) {
        ItemBasicAmountDetailsDTO itemBasicAmountDetailsDTO = itemBasicAmountDetailsServiceRequest
                .getItemBasicAmountDetailsDTO();
        itemBasicAmountDetailsRepo.deleteById(itemBasicAmountDetailsDTO.getId());
        return null;
    }
}
package com.vme.precast.itemfreightamountdetails.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.domain.ItemAmountDetails;
import com.vme.precast.domain.ItemFreightAmountDetails;
import com.vme.precast.itemfreightamountdetails.api.ItemFreightAmountDetailsComponent;
import com.vme.precast.itemfreightamountdetails.api.ItemFreightAmountDetailsDTO;
import com.vme.precast.itemfreightamountdetails.api.ItemFreightAmountDetailsSearchDTO;
import com.vme.precast.itemfreightamountdetails.api.ItemFreightAmountDetailsServiceRequest;
import com.vme.precast.itemfreightamountdetails.api.ItemFreightAmountDetailsServiceResponse;
import com.vme.precast.repository.ItemAmountDetailsRepo;
import com.vme.precast.repository.ItemFreightAmountDetailsRepo;

import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;
import coliseum.service.ConversionUtility;
import coliseum.service.FilterUtils;

public class ItemFreightAmountDetailsComponentImpl implements ItemFreightAmountDetailsComponent {
    @Autowired
    ItemFreightAmountDetailsRepo itemFreightAmountDetailsRepo;
    @Autowired
    ItemAmountDetailsRepo itemAmountDetailsRepo;

    @Autowired
    ConversionUtility conversionUtility;

    @Override
    public ItemFreightAmountDetailsServiceResponse createItemFreightAmountDetails(
            ItemFreightAmountDetailsServiceRequest itemFreightAmountDetailsServiceRequest) {
        ItemFreightAmountDetailsDTO itemFreightAmountDetailsDTO = itemFreightAmountDetailsServiceRequest
                .getItemFreightAmountDetailsDTO();
        ItemFreightAmountDetails itemfreightamountdetails = (ItemFreightAmountDetails) conversionUtility.convert(
                itemFreightAmountDetailsDTO, ItemFreightAmountDetailsDTO.class, ItemFreightAmountDetails.class);

        if (itemFreightAmountDetailsDTO.getItemAmountDetailsId() != null) {
            ItemAmountDetails itemAmountDetails = itemAmountDetailsRepo
                    .findById(itemFreightAmountDetailsDTO.getItemAmountDetailsId()).get();
            itemfreightamountdetails.setItemAmountDetails(itemAmountDetails);
        }
        itemFreightAmountDetailsRepo.save(itemfreightamountdetails);
        return null;
    }

    @Override
    public ItemFreightAmountDetailsServiceResponse getItemFreightAmountDetailss(
            ItemFreightAmountDetailsServiceRequest itemFreightAmountDetailsServiceRequest) {
        List<ItemFreightAmountDetails> itemFreightAmountDetailsList = new ArrayList<>();
        List<Filter> filters = new ArrayList<>();
        SearchObject searchObject = new SearchObject();

        ItemFreightAmountDetailsSearchDTO itemFreightAmountDetailsSearchDTO = itemFreightAmountDetailsServiceRequest
                .getItemFreightAmountDetailsSearchDTO();
        if (itemFreightAmountDetailsSearchDTO != null) {
            List<Long> ids = itemFreightAmountDetailsSearchDTO.getIdList();
            List<Double> amountList = itemFreightAmountDetailsSearchDTO.getAmountList();
            List<Double> taxPercentList = itemFreightAmountDetailsSearchDTO.getTaxPercentList();
            List<Double> taxAmountList = itemFreightAmountDetailsSearchDTO.getTaxAmountList();
            List<Double> totalList = itemFreightAmountDetailsSearchDTO.getTotalList();

            FilterUtils.createEqualFilter(filters, ItemFreightAmountDetailsSearchDTO.ID, ids);
            FilterUtils.createEqualFilter(filters, ItemFreightAmountDetailsSearchDTO.AMOUNT, amountList);
            FilterUtils.createEqualFilter(filters, ItemFreightAmountDetailsSearchDTO.TAXAMOUNT, taxAmountList);
            FilterUtils.createEqualFilter(filters, ItemFreightAmountDetailsSearchDTO.TAXPERCENT, taxPercentList);
            FilterUtils.createEqualFilter(filters, ItemFreightAmountDetailsSearchDTO.TOTAL, totalList);

            if (CollectionUtils.isNotEmpty(filters)) {
                searchObject.setFilters(filters);
            }
        }
        searchObject.setPageIndex(itemFreightAmountDetailsServiceRequest.getPageIndex());
        searchObject.setRecordstoFetch(itemFreightAmountDetailsServiceRequest.getRecordstoFetch());
        itemFreightAmountDetailsList = itemFreightAmountDetailsRepo.search(searchObject);

        List<ItemFreightAmountDetailsDTO> itemFreightAmountDetailsDTOList = new ArrayList<>();
        for (ItemFreightAmountDetails target : itemFreightAmountDetailsList) {
            itemFreightAmountDetailsDTOList.add((ItemFreightAmountDetailsDTO) conversionUtility.convert(target,
                    ItemFreightAmountDetails.class, ItemFreightAmountDetailsDTO.class));
        }
        ItemFreightAmountDetailsServiceResponse itemFreightAmountDetailsServiceResponse = new ItemFreightAmountDetailsServiceResponse();
        itemFreightAmountDetailsServiceResponse.setItemFreightAmountDetailsDTOList(itemFreightAmountDetailsDTOList);
        return itemFreightAmountDetailsServiceResponse;
    }

    @Override
    public ItemFreightAmountDetailsServiceResponse updateItemFreightAmountDetails(
            ItemFreightAmountDetailsServiceRequest itemFreightAmountDetailsServiceRequest) {
        ItemFreightAmountDetailsDTO source = itemFreightAmountDetailsServiceRequest.getItemFreightAmountDetailsDTO();

        ItemFreightAmountDetails target = itemFreightAmountDetailsRepo.findById(source.getId()).get();
        target.setAmount(source.getAmount());
        target.setTaxPercent(source.getTaxPercent());
        target.setTaxAmount(source.getTaxAmount());
        target.setTotal(source.getTotal());

        if (source.getItemAmountDetailsId() != null
                && !source.getItemAmountDetailsId().equals(target.getItemAmountDetailsId())) {
            ItemAmountDetails itemAmountDetails = itemAmountDetailsRepo.findById(source.getItemAmountDetailsId()).get();
            target.setItemAmountDetails(itemAmountDetails);
        }
        itemFreightAmountDetailsRepo.save(target);
        return null;
    }

    @Override
    public ItemFreightAmountDetailsServiceResponse deleteItemFreightAmountDetails(
            ItemFreightAmountDetailsServiceRequest itemFreightAmountDetailsServiceRequest) {
        ItemFreightAmountDetailsDTO itemFreightAmountDetailsDTO = itemFreightAmountDetailsServiceRequest
                .getItemFreightAmountDetailsDTO();
        itemFreightAmountDetailsRepo.deleteById(itemFreightAmountDetailsDTO.getId());
        return null;
    }
}
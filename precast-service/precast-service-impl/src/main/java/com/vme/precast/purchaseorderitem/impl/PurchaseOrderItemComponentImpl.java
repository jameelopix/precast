package com.vme.precast.purchaseorderitem.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.domain.PurchaseOrder;
import com.vme.precast.domain.PurchaseOrderItem;
import com.vme.precast.purchaseorder.api.PurchaseOrderDTO;
import com.vme.precast.purchaseorder.api.PurchaseOrderServiceRequest;
import com.vme.precast.purchaseorderitem.api.PurchaseOrderItemComponent;
import com.vme.precast.purchaseorderitem.api.PurchaseOrderItemDTO;
import com.vme.precast.purchaseorderitem.api.PurchaseOrderItemSearchDTO;
import com.vme.precast.purchaseorderitem.api.PurchaseOrderItemServiceRequest;
import com.vme.precast.purchaseorderitem.api.PurchaseOrderItemServiceResponse;
import com.vme.precast.repository.PurchaseOrderItemRepo;
import com.vme.precast.repository.PurchaseOrderRepo;

import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;
import coliseum.service.ConversionUtility;
import coliseum.service.FilterUtils;

public class PurchaseOrderItemComponentImpl implements PurchaseOrderItemComponent {
    @Autowired
    PurchaseOrderItemRepo purchaseOrderItemRepo;
    @Autowired
    PurchaseOrderRepo purchaseOrderRepo;

    @Autowired
    ConversionUtility conversionUtility;

    @Override
    public PurchaseOrderItemServiceResponse createPurchaseOrderItem(
            PurchaseOrderItemServiceRequest purchaseOrderItemServiceRequest) {
        PurchaseOrderItemDTO purchaseOrderItemDTO = purchaseOrderItemServiceRequest.getPurchaseOrderItemDTO();
        PurchaseOrderItem purchaseorderitem = (PurchaseOrderItem) conversionUtility.convert(purchaseOrderItemDTO,
                PurchaseOrderItemDTO.class, PurchaseOrderItem.class);

        if (purchaseOrderItemDTO.getPurchaseOrderDTOId() != null) {
            PurchaseOrder purchaseOrder = purchaseOrderRepo.findById(purchaseOrderItemDTO.getPurchaseOrderDTOId())
                    .get();
            purchaseorderitem.setPurchaseOrder(purchaseOrder);
        }
        purchaseOrderItemRepo.save(purchaseorderitem);
        return null;
    }

    @Override
    public PurchaseOrderItemServiceResponse getPurchaseOrderItems(
            PurchaseOrderItemServiceRequest purchaseOrderItemServiceRequest) {
        List<PurchaseOrderItem> purchaseOrderItemList = new ArrayList<>();
        List<Filter> filters = new ArrayList<>();
        SearchObject searchObject = new SearchObject();

        PurchaseOrderItemSearchDTO purchaseOrderItemSearchDTO = purchaseOrderItemServiceRequest
                .getPurchaseOrderItemSearchDTO();
        if (purchaseOrderItemSearchDTO != null) {
            List<Long> idList = purchaseOrderItemSearchDTO.getIdList();
            List<String> itemNameList = purchaseOrderItemSearchDTO.getItemNameList();
            List<String> unitList = purchaseOrderItemSearchDTO.getUnitList();
            List<Double> rateList = purchaseOrderItemSearchDTO.getRateList();
            List<Double> quantityList = purchaseOrderItemSearchDTO.getQuantityList();
            List<Long> purchaseOrderDTOIdList = purchaseOrderItemSearchDTO.getPurchaseOrderDTOIdList();

            FilterUtils.createEqualFilter(filters, PurchaseOrderItemSearchDTO.ID, idList);
            FilterUtils.createEqualFilter(filters, PurchaseOrderItemSearchDTO.ITEMNAME, itemNameList);
            FilterUtils.createEqualFilter(filters, PurchaseOrderItemSearchDTO.UNIT, unitList);
            FilterUtils.createEqualFilter(filters, PurchaseOrderItemSearchDTO.RATE, rateList);
            FilterUtils.createEqualFilter(filters, PurchaseOrderItemSearchDTO.QUANTITY, quantityList);
            FilterUtils.createEqualFilter(filters, PurchaseOrderItemSearchDTO.PURCHASEORDERID, purchaseOrderDTOIdList);

            if (CollectionUtils.isNotEmpty(filters)) {
                searchObject.setFilters(filters);
            }
        }
        searchObject.setPageIndex(purchaseOrderItemServiceRequest.getPageIndex());
        searchObject.setRecordstoFetch(purchaseOrderItemServiceRequest.getRecordstoFetch());
        purchaseOrderItemList = purchaseOrderItemRepo.search(searchObject);

        List<PurchaseOrderItemDTO> purchaseOrderItemDTOList = new ArrayList<>();
        for (PurchaseOrderItem target : purchaseOrderItemList) {
            purchaseOrderItemDTOList.add((PurchaseOrderItemDTO) conversionUtility.convert(target,
                    PurchaseOrderItem.class, PurchaseOrderItemDTO.class));
        }
        PurchaseOrderItemServiceResponse purchaseOrderItemServiceResponse = new PurchaseOrderItemServiceResponse();
        purchaseOrderItemServiceResponse.setPurchaseOrderItemDTOList(purchaseOrderItemDTOList);
        return purchaseOrderItemServiceResponse;
    }

    @Override
    public PurchaseOrderItemServiceResponse updatePurchaseOrderItem(
            PurchaseOrderItemServiceRequest purchaseOrderItemServiceRequest) {
        PurchaseOrderItemDTO source = purchaseOrderItemServiceRequest.getPurchaseOrderItemDTO();

        PurchaseOrderItem target = purchaseOrderItemRepo.findById(source.getId()).get();
        target.setItemName(source.getItemName());
        target.setUnit(source.getUnit());
        target.setQuantity(source.getQuantity());
        target.setRate(source.getRate());
        if (source.getPurchaseOrderDTOId() != null
                && !source.getPurchaseOrderDTOId().equals(target.getPurchaseOrderId())) {
            PurchaseOrder purchaseOrder = purchaseOrderRepo.findById(source.getPurchaseOrderDTOId()).get();
            target.setPurchaseOrder(purchaseOrder);
        }

        purchaseOrderItemRepo.save(target);
        return null;
    }

    @Override
    public PurchaseOrderItemServiceResponse deletePurchaseOrderItem(
            PurchaseOrderItemServiceRequest purchaseOrderItemServiceRequest) {
        PurchaseOrderItemDTO purchaseOrderItemDTO = purchaseOrderItemServiceRequest.getPurchaseOrderItemDTO();
        purchaseOrderItemRepo.deleteById(purchaseOrderItemDTO.getId());
        return null;
    }

    @Override
    public PurchaseOrderItemServiceResponse preprocess(
            PurchaseOrderItemServiceRequest purchaseOrderItemServiceRequest) {
        PurchaseOrderItemDTO purchaseOrderItemDTO = purchaseOrderItemServiceRequest.getPurchaseOrderItemDTO();

        Long purchaseOrderId = purchaseOrderItemDTO.getPurchaseOrderDTOId();
        if (purchaseOrderId == null) {
            purchaseOrderId = purchaseOrderItemRepo.findById(purchaseOrderItemDTO.getId()).get().getPurchaseOrderId();
        }

        PurchaseOrderServiceRequest purchaseOrderServiceRequest = new PurchaseOrderServiceRequest();
        PurchaseOrderDTO purchaseOrderDTO = new PurchaseOrderDTO();
        purchaseOrderDTO.setId(purchaseOrderId);
        purchaseOrderServiceRequest.setPurchaseOrderDTO(purchaseOrderDTO);

        purchaseOrderItemServiceRequest.setPurchaseOrderServiceRequest(purchaseOrderServiceRequest);
        return null;
    }
}
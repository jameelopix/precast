package com.vme.precast.purchaseregisteritem.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.domain.PurchaseOrderItem;
import com.vme.precast.domain.PurchaseRegister;
import com.vme.precast.domain.PurchaseRegisterItem;
import com.vme.precast.purchaseregisteritem.api.PurchaseRegisterItemComponent;
import com.vme.precast.purchaseregisteritem.api.PurchaseRegisterItemDTO;
import com.vme.precast.purchaseregisteritem.api.PurchaseRegisterItemSearchDTO;
import com.vme.precast.purchaseregisteritem.api.PurchaseRegisterItemServiceRequest;
import com.vme.precast.purchaseregisteritem.api.PurchaseRegisterItemServiceResponse;
import com.vme.precast.repository.PurchaseOrderItemRepo;
import com.vme.precast.repository.PurchaseRegisterItemRepo;
import com.vme.precast.repository.PurchaseRegisterRepo;

import coliseum.jpa.Association;
import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;
import coliseum.service.AssociationUtils;
import coliseum.service.ConversionUtility;
import coliseum.service.FilterUtils;

public class PurchaseRegisterItemComponentImpl implements PurchaseRegisterItemComponent {
    @Autowired
    PurchaseRegisterItemRepo purchaseRegisterItemRepo;
    @Autowired
    PurchaseOrderItemRepo purchaseOrderItemRepo;
    @Autowired
    PurchaseRegisterRepo purchaseRegisterRepo;

    @Autowired
    ConversionUtility conversionUtility;

    @Override
    public PurchaseRegisterItemServiceResponse createPurchaseRegisterItem(
            PurchaseRegisterItemServiceRequest purchaseRegisterItemServiceRequest) {
        PurchaseRegisterItemDTO purchaseRegisterItemDTO = purchaseRegisterItemServiceRequest
                .getPurchaseRegisterItemDTO();
        PurchaseRegisterItem purchaseregisteritem = (PurchaseRegisterItem) conversionUtility
                .convert(purchaseRegisterItemDTO, PurchaseRegisterItemDTO.class, PurchaseRegisterItem.class);

        if (purchaseRegisterItemDTO.getPurchaseOrderItemDTOId() != null) {
            PurchaseOrderItem purchaseOrderItem = purchaseOrderItemRepo
                    .findById(purchaseRegisterItemDTO.getPurchaseOrderItemDTOId()).get();
            purchaseregisteritem.setPurchaseOrderItem(purchaseOrderItem);
        }
        if (purchaseRegisterItemDTO.getPurchaseRegisterDTOId() != null) {
            PurchaseRegister purchaseRegister = purchaseRegisterRepo
                    .findById(purchaseRegisterItemDTO.getPurchaseRegisterDTOId()).get();
            purchaseregisteritem.setPurchaseRegister(purchaseRegister);
        }
        purchaseRegisterItemRepo.save(purchaseregisteritem);
        return null;
    }

    @Override
    public PurchaseRegisterItemServiceResponse getPurchaseRegisterItems(
            PurchaseRegisterItemServiceRequest purchaseRegisterItemServiceRequest) {
        List<PurchaseRegisterItem> purchaseRegisterItemList = new ArrayList<>();
        List<Filter> filters = new ArrayList<>();
        SearchObject searchObject = new SearchObject();
        List<Association> associations = new ArrayList<>();

        PurchaseRegisterItemSearchDTO purchaseRegisterItemSearchDTO = purchaseRegisterItemServiceRequest
                .getPurchaseRegisterItemSearchDTO();
        if (purchaseRegisterItemSearchDTO != null) {
            List<Long> idList = purchaseRegisterItemSearchDTO.getIdList();
            List<Long> purchaseOrderItemIdDTOList = purchaseRegisterItemSearchDTO.getPurchaseOrderItemIdDTOList();
            List<Long> purchaseRegisterDTOIdList = purchaseRegisterItemSearchDTO.getPurchaseRegisterDTOIdList();
            List<String> dcUnitList = purchaseRegisterItemSearchDTO.getDcUnitList();
            List<Double> dcQuantityList = purchaseRegisterItemSearchDTO.getDcQuantityList();
            List<String> deductionUnitList = purchaseRegisterItemSearchDTO.getDeductionUnitList();
            List<Double> deductionQuantityList = purchaseRegisterItemSearchDTO.getDeductionQuantityList();
            List<String> netUnitList = purchaseRegisterItemSearchDTO.getNetUnitList();
            List<Double> netQuantityList = purchaseRegisterItemSearchDTO.getNetQuantityList();
            List<String> weighBridgeUnitList = purchaseRegisterItemSearchDTO.getWeighBridgeUnitList();
            List<Double> weighBridgeQuantityList = purchaseRegisterItemSearchDTO.getWeighBridgeQuantityList();

            FilterUtils.createEqualFilter(filters, PurchaseRegisterItemSearchDTO.ID, idList);
            FilterUtils.createEqualFilter(filters, PurchaseRegisterItemSearchDTO.PURCHASEORDERITEMID,
                    purchaseOrderItemIdDTOList);
            FilterUtils.createEqualFilter(filters, PurchaseRegisterItemSearchDTO.PURCHASEREGISTERID,
                    purchaseRegisterDTOIdList);
            FilterUtils.createEqualFilter(filters, PurchaseRegisterItemSearchDTO.DCQUANTITY, dcQuantityList);
            FilterUtils.createEqualFilter(filters, PurchaseRegisterItemSearchDTO.DCUNIT, dcUnitList);
            FilterUtils.createEqualFilter(filters, PurchaseRegisterItemSearchDTO.DEDUCTIONQUANTITY,
                    deductionQuantityList);
            FilterUtils.createEqualFilter(filters, PurchaseRegisterItemSearchDTO.DEDUCTIONUNIT, deductionUnitList);
            FilterUtils.createEqualFilter(filters, PurchaseRegisterItemSearchDTO.NETQUANTITY, netQuantityList);
            FilterUtils.createEqualFilter(filters, PurchaseRegisterItemSearchDTO.NETUNIT, netUnitList);
            FilterUtils.createEqualFilter(filters, PurchaseRegisterItemSearchDTO.WEIGHBRIDGEQUANTITY,
                    weighBridgeQuantityList);
            FilterUtils.createEqualFilter(filters, PurchaseRegisterItemSearchDTO.WEIGHBRIDGEUNIT, weighBridgeUnitList);

            if (CollectionUtils.isNotEmpty(filters)) {
                searchObject.setFilters(filters);
            }

            AssociationUtils.createAssociation(associations, PurchaseRegisterItemSearchDTO.PURCHASEORDERITEM,
                    purchaseRegisterItemSearchDTO.getPurchaseOrderItemNeeded());

            if (CollectionUtils.isNotEmpty(associations)) {
                searchObject.setAssociations(associations);
            }
        }
        searchObject.setPageIndex(purchaseRegisterItemServiceRequest.getPageIndex());
        searchObject.setRecordstoFetch(purchaseRegisterItemServiceRequest.getRecordstoFetch());
        purchaseRegisterItemList = purchaseRegisterItemRepo.search(searchObject);

        List<PurchaseRegisterItemDTO> purchaseRegisterItemDTOList = new ArrayList<>();
        for (PurchaseRegisterItem target : purchaseRegisterItemList) {
            purchaseRegisterItemDTOList.add((PurchaseRegisterItemDTO) conversionUtility.convert(target,
                    PurchaseRegisterItem.class, PurchaseRegisterItemDTO.class));
        }
        PurchaseRegisterItemServiceResponse purchaseRegisterItemServiceResponse = new PurchaseRegisterItemServiceResponse();
        purchaseRegisterItemServiceResponse.setPurchaseRegisterItemDTOList(purchaseRegisterItemDTOList);
        return purchaseRegisterItemServiceResponse;
    }

    @Override
    public PurchaseRegisterItemServiceResponse updatePurchaseRegisterItem(
            PurchaseRegisterItemServiceRequest purchaseRegisterItemServiceRequest) {
        PurchaseRegisterItemDTO source = purchaseRegisterItemServiceRequest.getPurchaseRegisterItemDTO();

        PurchaseRegisterItem target = purchaseRegisterItemRepo.findById(source.getId()).get();
        target.setDcQuantity(source.getDcQuantity());
        target.setDcUnit(source.getDcUnit());
        target.setWeighBridgeQuantity(source.getWeighBridgeQuantity());
        target.setWeighBridgeUnit(source.getWeighBridgeUnit());
        target.setDeductionQuantity(source.getDeductionQuantity());
        target.setDeductionUnit(source.getDeductionUnit());
        target.setNetQuantity(source.getNetQuantity());
        target.setNetUnit(source.getNetUnit());
        if (source.getPurchaseOrderItemDTOId() != null
                && !source.getPurchaseOrderItemDTOId().equals(target.getPurchaseOrderItemId())) {
            PurchaseOrderItem purchaseOrderItem = purchaseOrderItemRepo.findById(source.getPurchaseOrderItemDTOId())
                    .get();
            target.setPurchaseOrderItem(purchaseOrderItem);
        }
        if (source.getPurchaseRegisterDTOId() != null
                && !source.getPurchaseRegisterDTOId().equals(target.getPurchaseRegisterId())) {
            PurchaseRegister purchaseRegister = purchaseRegisterRepo.findById(source.getPurchaseRegisterDTOId()).get();
            target.setPurchaseRegister(purchaseRegister);
        }
        purchaseRegisterItemRepo.save(target);
        return null;
    }

    @Override
    public PurchaseRegisterItemServiceResponse deletePurchaseRegisterItem(
            PurchaseRegisterItemServiceRequest purchaseRegisterItemServiceRequest) {
        PurchaseRegisterItemDTO purchaseRegisterItemDTO = purchaseRegisterItemServiceRequest
                .getPurchaseRegisterItemDTO();
        purchaseRegisterItemRepo.deleteById(purchaseRegisterItemDTO.getId());
        return null;
    }
}
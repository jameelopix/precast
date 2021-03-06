package com.vme.precast.purchaseorder.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.domain.PurchaseOrder;
import com.vme.precast.domain.Vendor;
import com.vme.precast.purchaseorder.api.PurchaseOrderComponent;
import com.vme.precast.purchaseorder.api.PurchaseOrderDTO;
import com.vme.precast.purchaseorder.api.PurchaseOrderSearchDTO;
import com.vme.precast.purchaseorder.api.PurchaseOrderServiceRequest;
import com.vme.precast.purchaseorder.api.PurchaseOrderServiceResponse;
import com.vme.precast.repository.PurchaseOrderRepo;
import com.vme.precast.repository.VendorRepo;
import com.vme.precast.shared.PurchaseOrderStatus;

import coliseum.jpa.Association;
import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;
import coliseum.service.AssociationUtils;
import coliseum.service.ConversionUtility;
import coliseum.service.FilterUtils;

public class PurchaseOrderComponentImpl implements PurchaseOrderComponent {
    @Autowired
    PurchaseOrderRepo purchaseOrderRepo;
    @Autowired
    VendorRepo vendorRepo;

    @Autowired
    ConversionUtility conversionUtility;

    @Override
    public PurchaseOrderServiceResponse createPurchaseOrder(PurchaseOrderServiceRequest purchaseOrderServiceRequest) {
        PurchaseOrderDTO purchaseOrderDTO = purchaseOrderServiceRequest.getPurchaseOrderDTO();
        PurchaseOrder purchaseorder = (PurchaseOrder) conversionUtility.convert(purchaseOrderDTO,
                PurchaseOrderDTO.class, PurchaseOrder.class);

        purchaseorder.setPurchaseOrderStatus(PurchaseOrderStatus.OPEN);
        if (purchaseOrderDTO.getVendorDTOId() != null) {
            Vendor vendor = vendorRepo.findById(purchaseOrderDTO.getVendorDTOId()).get();
            purchaseorder.setVendor(vendor);
        }
        purchaseOrderRepo.save(purchaseorder);
        return null;
    }

    @Override
    public PurchaseOrderServiceResponse getPurchaseOrders(PurchaseOrderServiceRequest purchaseOrderServiceRequest) {
        List<PurchaseOrder> purchaseOrderList = new ArrayList<>();
        List<Filter> filters = new ArrayList<>();
        SearchObject searchObject = new SearchObject();
        List<Association> associations = new ArrayList<>();

        PurchaseOrderSearchDTO purchaseOrderSearchDTO = purchaseOrderServiceRequest.getPurchaseOrderSearchDTO();
        if (purchaseOrderSearchDTO != null) {
            List<Long> idList = purchaseOrderSearchDTO.getIdList();
            List<String> purchaseOrderNoList = purchaseOrderSearchDTO.getPurchaseOrderNoList();
            List<Long> vendorDTOIdList = purchaseOrderSearchDTO.getVendorDTOIdList();
            List<PurchaseOrderStatus> purchaseOrderStatusList = purchaseOrderSearchDTO.getPurchaseOrderStatusList();
//            List<Long> addressIdList = purchaseOrderSearchDTO.getPurchaseDateList()

            FilterUtils.createEqualFilter(filters, PurchaseOrderSearchDTO.ID, idList);
            FilterUtils.createEqualFilter(filters, PurchaseOrderSearchDTO.VENDORID, vendorDTOIdList);
            FilterUtils.createEqualFilter(filters, PurchaseOrderSearchDTO.PURCHASEORDERNO, purchaseOrderNoList);
            FilterUtils.createEqualFilter(filters, PurchaseOrderSearchDTO.PURCHASEORDERSTATUS, purchaseOrderStatusList);

            if (CollectionUtils.isNotEmpty(filters)) {
                searchObject.setFilters(filters);
            }

            AssociationUtils.createAssociation(associations, PurchaseOrderSearchDTO.VENDOR,
                    purchaseOrderSearchDTO.getVendorNeeded());

            if (CollectionUtils.isNotEmpty(associations)) {
                searchObject.setAssociations(associations);
            }
        }
        searchObject.setPageIndex(purchaseOrderServiceRequest.getPageIndex());
        searchObject.setRecordstoFetch(purchaseOrderServiceRequest.getRecordstoFetch());
        purchaseOrderList = purchaseOrderRepo.search(searchObject);

        List<PurchaseOrderDTO> purchaseOrderDTOList = new ArrayList<>();
        for (PurchaseOrder target : purchaseOrderList) {
            purchaseOrderDTOList.add(
                    (PurchaseOrderDTO) conversionUtility.convert(target, PurchaseOrder.class, PurchaseOrderDTO.class));
        }
        PurchaseOrderServiceResponse purchaseOrderServiceResponse = new PurchaseOrderServiceResponse();
        purchaseOrderServiceResponse.setPurchaseOrderDTOList(purchaseOrderDTOList);
        return purchaseOrderServiceResponse;
    }

    @Override
    public PurchaseOrderServiceResponse updatePurchaseOrder(PurchaseOrderServiceRequest purchaseOrderServiceRequest) {
        PurchaseOrderDTO source = purchaseOrderServiceRequest.getPurchaseOrderDTO();

        PurchaseOrder target = purchaseOrderRepo.findById(source.getId()).get();
        target.setPurchaseOrderStatus(source.getPurchaseOrderStatus());
        target.setPurchaseOrderNo(source.getPurchaseOrderNo());
        target.setPurchaseDate(source.getPurchaseDate());
        if (source.getVendorDTOId() != null && !source.getVendorDTOId().equals(target.getVendorId())) {
            Vendor vendor = vendorRepo.findById(source.getVendorDTOId()).get();
            target.setVendor(vendor);
        }

        purchaseOrderRepo.save(target);
        return null;
    }

    @Override
    public PurchaseOrderServiceResponse deletePurchaseOrder(PurchaseOrderServiceRequest purchaseOrderServiceRequest) {
        PurchaseOrderDTO purchaseOrderDTO = purchaseOrderServiceRequest.getPurchaseOrderDTO();
        purchaseOrderRepo.deleteById(purchaseOrderDTO.getId());
        return null;
    }

    @Override
    public PurchaseOrderServiceResponse issuePurchaseOrder(PurchaseOrderServiceRequest purchaseOrderServiceRequest) {
        PurchaseOrderDTO source = purchaseOrderServiceRequest.getPurchaseOrderDTO();
        PurchaseOrder target = purchaseOrderRepo.findById(source.getId()).get();
        target.setPurchaseOrderStatus(PurchaseOrderStatus.ISSUED);
        purchaseOrderRepo.save(target);
        return null;
    }

    @Override
    public PurchaseOrderServiceResponse closePurchaseOrder(PurchaseOrderServiceRequest purchaseOrderServiceRequest) {
        PurchaseOrderDTO source = purchaseOrderServiceRequest.getPurchaseOrderDTO();
        PurchaseOrder target = purchaseOrderRepo.findById(source.getId()).get();
        target.setPurchaseOrderStatus(PurchaseOrderStatus.CLOSED);
        purchaseOrderRepo.save(target);
        return null;
    }
}
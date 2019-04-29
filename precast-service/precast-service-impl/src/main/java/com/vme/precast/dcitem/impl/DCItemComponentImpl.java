package com.vme.precast.dcitem.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.dcitem.api.DCItemComponent;
import com.vme.precast.dcitem.api.DCItemDTO;
import com.vme.precast.dcitem.api.DCItemSearchDTO;
import com.vme.precast.dcitem.api.DCItemServiceRequest;
import com.vme.precast.dcitem.api.DCItemServiceResponse;
import com.vme.precast.domain.DCItem;
import com.vme.precast.repository.DCItemRepo;

import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;
import coliseum.service.ConversionUtility;
import coliseum.service.FilterUtils;

public class DCItemComponentImpl implements DCItemComponent {
    @Autowired
    DCItemRepo dCItemRepo;

    @Autowired
    ConversionUtility conversionUtility;

    @Override
    public DCItemServiceResponse createDCItem(DCItemServiceRequest dCItemServiceRequest) {
        DCItemDTO dCItemDTO = dCItemServiceRequest.getDCItemDTO();
        DCItem dcitem = (DCItem) conversionUtility.convert(dCItemDTO, DCItemDTO.class, DCItem.class);
        dCItemRepo.save(dcitem);
        return null;
    }

    @Override
    public DCItemServiceResponse getDCItems(DCItemServiceRequest dCItemServiceRequest) {
        List<DCItem> dCItemList = new ArrayList<>();
        List<Filter> filters = new ArrayList<>();
        SearchObject searchObject = new SearchObject();

        DCItemSearchDTO dCItemSearchDTO = dCItemServiceRequest.getDCItemSearchDTO();
        if (dCItemSearchDTO != null) {
            List<Long> idList = dCItemSearchDTO.getIdList();
            List<Long> dcRegisterIdList = dCItemSearchDTO.getDcRegisterIdList();
            List<Long> orderItemIdList = dCItemSearchDTO.getOrderItemIdList();
            List<Double> vendorQuantityList = dCItemSearchDTO.getVendorQuantityList();
            List<Double> weighBridgeQuantityList = dCItemSearchDTO.getWeighBridgeQuantityList();
            List<Double> deductionQuantityList = dCItemSearchDTO.getDeductionQuantityList();
            List<Double> netQuantityList = dCItemSearchDTO.getNetQuantityList();

            FilterUtils.createEqualFilter(filters, DCItemSearchDTO.ID, idList);
            FilterUtils.createEqualFilter(filters, DCItemSearchDTO.DCREGISTERID, dcRegisterIdList);
            FilterUtils.createEqualFilter(filters, DCItemSearchDTO.ORDERITEMID, orderItemIdList);
            FilterUtils.createEqualFilter(filters, DCItemSearchDTO.VENDORQUANTITY, vendorQuantityList);
            FilterUtils.createEqualFilter(filters, DCItemSearchDTO.WEIGHBRIDGEQUANTITY, weighBridgeQuantityList);
            FilterUtils.createEqualFilter(filters, DCItemSearchDTO.DEDUCTIONQUANTITY, deductionQuantityList);
            FilterUtils.createEqualFilter(filters, DCItemSearchDTO.NETQUANTITY, netQuantityList);

            if (CollectionUtils.isNotEmpty(filters)) {
                searchObject.setFilters(filters);
            }
        }
        searchObject.setPageIndex(dCItemServiceRequest.getPageIndex());
        searchObject.setRecordstoFetch(dCItemServiceRequest.getRecordstoFetch());
        dCItemList = dCItemRepo.search(searchObject);

        List<DCItemDTO> dCItemDTOList = new ArrayList<>();
        for (DCItem target : dCItemList) {
            dCItemDTOList.add((DCItemDTO) conversionUtility.convert(target, DCItem.class, DCItemDTO.class));
        }
        DCItemServiceResponse dCItemServiceResponse = new DCItemServiceResponse();
        dCItemServiceResponse.setDCItemDTOList(dCItemDTOList);
        return dCItemServiceResponse;
    }

    @Override
    public DCItemServiceResponse updateDCItem(DCItemServiceRequest dCItemServiceRequest) {
        DCItemDTO source = dCItemServiceRequest.getDCItemDTO();

        DCItem target = dCItemRepo.findById(source.getId()).get();
        target.setVendorQuantity(source.getVendorQuantity());
        target.setWeighBridgeQuantity(source.getWeighBridgeQuantity());
        target.setDeductionQuantity(source.getDeductionQuantity());
        target.setNetQuantity(source.getNetQuantity());
        target.setOrderItemId(source.getOrderItemId());
        target.setDcRegisterId(source.getDcRegisterId());

        dCItemRepo.save(target);
        return null;
    }

    @Override
    public DCItemServiceResponse deleteDCItem(DCItemServiceRequest dCItemServiceRequest) {
        DCItemDTO dCItemDTO = dCItemServiceRequest.getDCItemDTO();
        dCItemRepo.deleteById(dCItemDTO.getId());
        return null;
    }
}
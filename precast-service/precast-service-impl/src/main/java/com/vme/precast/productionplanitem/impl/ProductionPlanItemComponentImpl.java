package com.vme.precast.productionplanitem.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.domain.ProductionPlanItem;
import com.vme.precast.repository.ProductionPlanItemRepo;
import com.vme.precast.productionplanitem.api.ProductionPlanItemComponent;
import com.vme.precast.productionplanitem.api.ProductionPlanItemDTO;
import com.vme.precast.productionplanitem.api.ProductionPlanItemSearchDTO;
import com.vme.precast.productionplanitem.api.ProductionPlanItemServiceRequest;
import com.vme.precast.productionplanitem.api.ProductionPlanItemServiceResponse;

import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;
import coliseum.service.ConversionUtility;
import coliseum.service.FilterUtils;

public class ProductionPlanItemComponentImpl implements ProductionPlanItemComponent {
    @Autowired
    ProductionPlanItemRepo productionPlanItemRepo;

    @Autowired
    ConversionUtility conversionUtility;

    @Override
    public ProductionPlanItemServiceResponse createProductionPlanItem(
            ProductionPlanItemServiceRequest productionPlanItemServiceRequest) {
        ProductionPlanItemDTO productionPlanItemDTO = productionPlanItemServiceRequest.getProductionPlanItemDTO();
        ProductionPlanItem productionplanitem = (ProductionPlanItem) conversionUtility.convert(productionPlanItemDTO,
                ProductionPlanItemDTO.class, ProductionPlanItem.class);
        productionPlanItemRepo.save(productionplanitem);
        return null;
    }

    @Override
    public ProductionPlanItemServiceResponse getProductionPlanItems(
            ProductionPlanItemServiceRequest productionPlanItemServiceRequest) {
        List<ProductionPlanItem> productionPlanItemList = new ArrayList<>();
        List<Filter> filters = new ArrayList<>();
        SearchObject searchObject = new SearchObject();

        ProductionPlanItemSearchDTO productionPlanItemSearchDTO = productionPlanItemServiceRequest
                .getProductionPlanItemSearchDTO();
        if (productionPlanItemSearchDTO != null) {
//            List<Long> ids = productionPlanItemSearchDTO.getIds();
//            List<String> nameList = productionPlanItemSearchDTO.getNameList();
//            List<Long> addressIdList = productionPlanItemSearchDTO.getAddressIdList();
//
//            FilterUtils.createEqualFilter(filters, ProductionPlanItemSearchDTO.ID, ids);
//            FilterUtils.createEqualFilter(filters, ProductionPlanItemSearchDTO.NAME, nameList);
//            FilterUtils.createEqualFilter(filters, ProductionPlanItemSearchDTO.ADDRESS_ID, addressIdList);

            if (CollectionUtils.isNotEmpty(filters)) {
                searchObject.setFilters(filters);
            }
        }
        searchObject.setPageIndex(productionPlanItemServiceRequest.getPageIndex());
        searchObject.setRecordstoFetch(productionPlanItemServiceRequest.getRecordstoFetch());
        productionPlanItemList = productionPlanItemRepo.search(searchObject);

        List<ProductionPlanItemDTO> productionPlanItemDTOList = new ArrayList<>();
        for (ProductionPlanItem target : productionPlanItemList) {
            productionPlanItemDTOList.add((ProductionPlanItemDTO) conversionUtility.convert(target,
                    ProductionPlanItem.class, ProductionPlanItemDTO.class));
        }
        ProductionPlanItemServiceResponse productionPlanItemServiceResponse = new ProductionPlanItemServiceResponse();
        productionPlanItemServiceResponse.setProductionPlanItemDTOList(productionPlanItemDTOList);
        return productionPlanItemServiceResponse;
    }

    @Override
    public ProductionPlanItemServiceResponse updateProductionPlanItem(
            ProductionPlanItemServiceRequest productionPlanItemServiceRequest) {
        ProductionPlanItemDTO source = productionPlanItemServiceRequest.getProductionPlanItemDTO();

        ProductionPlanItem target = productionPlanItemRepo.findById(source.getId()).get();
//        target.setName(source.getName());

        productionPlanItemRepo.save(target);
        return null;
    }

    @Override
    public ProductionPlanItemServiceResponse deleteProductionPlanItem(
            ProductionPlanItemServiceRequest productionPlanItemServiceRequest) {
        ProductionPlanItemDTO productionPlanItemDTO = productionPlanItemServiceRequest.getProductionPlanItemDTO();
        productionPlanItemRepo.deleteById(productionPlanItemDTO.getId());
        return null;
    }
}
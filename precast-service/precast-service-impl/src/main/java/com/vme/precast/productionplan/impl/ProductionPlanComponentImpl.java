package com.vme.precast.productionplan.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.domain.Element;
import com.vme.precast.domain.ProductionPlan;
import com.vme.precast.element.api.ElementDTO;
import com.vme.precast.productionplan.api.ProductionPlanComponent;
import com.vme.precast.productionplan.api.ProductionPlanDTO;
import com.vme.precast.productionplan.api.ProductionPlanSearchDTO;
import com.vme.precast.productionplan.api.ProductionPlanServiceRequest;
import com.vme.precast.productionplan.api.ProductionPlanServiceResponse;
import com.vme.precast.repository.ElementRepo;
import com.vme.precast.repository.ProductionPlanRepo;
import com.vme.precast.shared.ProductionPlanStatus;

import coliseum.jpa.Association;
import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;
import coliseum.service.ConversionUtility;
import coliseum.service.FilterUtils;

public class ProductionPlanComponentImpl implements ProductionPlanComponent {
    @Autowired
    ProductionPlanRepo productionPlanRepo;

    @Autowired
    ElementRepo elementRepo;

    @Autowired
    ConversionUtility conversionUtility;

    @Override
    public ProductionPlanServiceResponse createProductionPlan(
            ProductionPlanServiceRequest productionPlanServiceRequest) {
        ElementDTO elementDTO = productionPlanServiceRequest.getElementDTO();
        Element element = elementRepo.findById(elementDTO.getId()).get();

        ProductionPlan productionplan = new ProductionPlan();
        productionplan.setElement(element);
        productionplan.setProductionPlanStatus(ProductionPlanStatus.OPEN);
        productionplan.setCastedCount(0);
        productionPlanRepo.save(productionplan);
        return null;
    }

    @Override
    public ProductionPlanServiceResponse getProductionPlans(ProductionPlanServiceRequest productionPlanServiceRequest) {
        List<ProductionPlan> productionPlanList = new ArrayList<>();
        List<Filter> filters = new ArrayList<>();
        SearchObject searchObject = new SearchObject();
        List<Association> associations = new ArrayList<>();

        ProductionPlanSearchDTO productionPlanSearchDTO = productionPlanServiceRequest.getProductionPlanSearchDTO();
        if (productionPlanSearchDTO != null) {
            List<Long> idList = productionPlanSearchDTO.getIdList();
            List<Date> deliveredDateList = productionPlanSearchDTO.getDeliveredDateList();
            List<Date> plannedDateList = productionPlanSearchDTO.getPlannedDateList();
            List<Date> erectedDateList = productionPlanSearchDTO.getErectedDateList();
            List<Integer> castedCountList = productionPlanSearchDTO.getCastedCountList();
            List<Long> elementIdList = productionPlanSearchDTO.getElementIdList();
            List<ProductionPlanStatus> productionPlanStatusList = productionPlanSearchDTO.getProductionPlanStatusList();

            FilterUtils.createEqualFilter(filters, ProductionPlanSearchDTO.ID, idList);
            FilterUtils.createEqualFilter(filters, ProductionPlanSearchDTO.DELIVEREDDATE, deliveredDateList);
            FilterUtils.createEqualFilter(filters, ProductionPlanSearchDTO.PLANNEDDATE, plannedDateList);
            FilterUtils.createEqualFilter(filters, ProductionPlanSearchDTO.ERECTEDDATE, erectedDateList);
            FilterUtils.createEqualFilter(filters, ProductionPlanSearchDTO.CASTEDCOUNT, castedCountList);
            FilterUtils.createEqualFilter(filters, ProductionPlanSearchDTO.ELEMENTID, elementIdList);
            FilterUtils.createEqualFilter(filters, ProductionPlanSearchDTO.PRODUCTIONPLANSTATUS,
                    productionPlanStatusList);

            if (CollectionUtils.isNotEmpty(filters)) {
                searchObject.setFilters(filters);
            }

            if (productionPlanSearchDTO.isElementNeeded()) {
                Association purchasePlanAssociation = new Association();
                purchasePlanAssociation.setFieldName(ProductionPlanSearchDTO.ELEMENT);
                associations.add(purchasePlanAssociation);
            }

            if (CollectionUtils.isNotEmpty(associations)) {
                searchObject.setAssociations(associations);
            }
        }
        searchObject.setPageIndex(productionPlanServiceRequest.getPageIndex());
        searchObject.setRecordstoFetch(productionPlanServiceRequest.getRecordstoFetch());
        productionPlanList = productionPlanRepo.search(searchObject);

        List<ProductionPlanDTO> productionPlanDTOList = new ArrayList<>();
        for (ProductionPlan target : productionPlanList) {
            productionPlanDTOList.add((ProductionPlanDTO) conversionUtility.convert(target, ProductionPlan.class,
                    ProductionPlanDTO.class));
        }
        ProductionPlanServiceResponse productionPlanServiceResponse = new ProductionPlanServiceResponse();
        productionPlanServiceResponse.setProductionPlanDTOList(productionPlanDTOList);
        return productionPlanServiceResponse;
    }

    @Override
    public ProductionPlanServiceResponse updateProductionPlan(
            ProductionPlanServiceRequest productionPlanServiceRequest) {
        ProductionPlanDTO source = productionPlanServiceRequest.getProductionPlanDTO();

        ProductionPlan target = productionPlanRepo.findById(source.getId()).get();

        if (source.getPlannedDate() != null) {
            target.setPlannedDate(source.getPlannedDate());
        }
        if (source.getDeliveredDate() != null) {
            target.setDeliveredDate(source.getDeliveredDate());
        }
        if (source.getErectedDate() != null) {
            target.setErectedDate(source.getErectedDate());
        }

        productionPlanRepo.save(target);
        return null;
    }

    @Override
    public ProductionPlanServiceResponse deleteProductionPlan(
            ProductionPlanServiceRequest productionPlanServiceRequest) {
        ProductionPlanDTO productionPlanDTO = productionPlanServiceRequest.getProductionPlanDTO();
        productionPlanRepo.deleteById(productionPlanDTO.getId());
        return null;
    }
}
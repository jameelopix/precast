package com.vme.precast.productionplan.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.domain.Element;
import com.vme.precast.domain.ElementType;
import com.vme.precast.domain.ProductionPlan;
import com.vme.precast.domain.ProductionPlanItem;
import com.vme.precast.domain.ProductionPlanItemDetail;
import com.vme.precast.domain.Project;
import com.vme.precast.element.api.ElementDTO;
import com.vme.precast.productionplan.api.ProductionPlanComponent;
import com.vme.precast.productionplan.api.ProductionPlanDTO;
import com.vme.precast.productionplan.api.ProductionPlanItemDTO;
import com.vme.precast.productionplan.api.ProductionPlanItemDetailDTO;
import com.vme.precast.productionplan.api.ProductionPlanSearchDTO;
import com.vme.precast.productionplan.api.ProductionPlanServiceRequest;
import com.vme.precast.productionplan.api.ProductionPlanServiceResponse;
import com.vme.precast.repository.ElementRepo;
import com.vme.precast.repository.ElementTypeRepo;
import com.vme.precast.repository.ProductionPlanItemDetailRepo;
import com.vme.precast.repository.ProductionPlanItemRepo;
import com.vme.precast.repository.ProductionPlanRepo;
import com.vme.precast.repository.ProjectRepo;
import com.vme.precast.shared.ProductionPlanStatus;

import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;
import coliseum.service.ConversionUtility;
import coliseum.service.FilterUtils;

public class ProductionPlanComponentImpl implements ProductionPlanComponent {
    @Autowired
    ProductionPlanRepo productionPlanRepo;

    @Autowired
    ProductionPlanItemRepo productionPlanItemRepo;

    @Autowired
    ProductionPlanItemDetailRepo productionPlanItemDetailRepo;

    @Autowired
    ElementRepo elementRepo;

    @Autowired
    ElementTypeRepo elementTypeRepo;

    @Autowired
    ProjectRepo projectRepo;

    @Autowired
    ConversionUtility conversionUtility;

    @Override
    public ProductionPlanServiceResponse createProductionPlan(
            ProductionPlanServiceRequest productionPlanServiceRequest) {
        ElementDTO elementDTO = productionPlanServiceRequest.getElementDTO();

        ProductionPlan productionPlan = new ProductionPlan();
        productionPlan.setCastedCount(1);
        productionPlan.setProductionPlanStatus(ProductionPlanStatus.OPEN);

        if (elementDTO.getId() != null) {
            Element element = elementRepo.findById(elementDTO.getId()).get();
            productionPlan.setElement(element);
        }
        if (elementDTO.getElementTypeId() != null) {
            ElementType elementType = elementTypeRepo.findById(elementDTO.getElementTypeId()).get();
            productionPlan.setElementType(elementType);
        }
        if (elementDTO.getProjectId() != null) {
            Project project = projectRepo.findById(elementDTO.getProjectId()).get();
            productionPlan.setProject(project);
        }

        productionPlan = productionPlanRepo.save(productionPlan);

        ProductionPlanItem productionPlanItem = new ProductionPlanItem();
        productionPlanItem.setSequenceOrder(1);
        productionPlanItem.setProductionPlan(productionPlan);
        productionPlanItem.setPlannedDate(null);
        productionPlanItem.setDeliveredDate(null);
        productionPlanItem.setErectedDate(null);
        productionPlanItem.setCastEndDate(null);
        productionPlanItem.setCastStartDate(null);
        productionPlanItem.setDisapproved(null);
        productionPlanItem.setDisapprovedReason(null);
        productionPlanItem.setDisapprovedDesc(null);

//        productionPlan.setElementId(elementId);
        ProductionPlanDTO productionPlanDTO = productionPlanServiceRequest.getProductionPlanDTO();
        ProductionPlan productionplan = (ProductionPlan) conversionUtility.convert(productionPlanDTO,
                ProductionPlanDTO.class, ProductionPlan.class);

        if (productionPlanDTO.getElementId() != null) {
            Element element = elementRepo.findById(productionPlanDTO.getElementId()).get();
            productionplan.setElement(element);
        }
        productionPlanRepo.save(productionplan);
        return null;
    }

    @Override
    public ProductionPlanServiceResponse getProductionPlans(ProductionPlanServiceRequest productionPlanServiceRequest) {
        List<ProductionPlan> productionPlanList = new ArrayList<>();
        List<Filter> filters = new ArrayList<>();
        SearchObject searchObject = new SearchObject();

        ProductionPlanSearchDTO productionPlanSearchDTO = productionPlanServiceRequest.getProductionPlanSearchDTO();
        if (productionPlanSearchDTO != null) {
            List<Long> idList = productionPlanSearchDTO.getIdList();
            List<Integer> castedCountList = productionPlanSearchDTO.getCastedCountList();
            List<Long> elementIdList = productionPlanSearchDTO.getElementIdList();
            List<Long> projectIdList = productionPlanSearchDTO.getProjectIdList();
            List<Long> elementTypeIdList = productionPlanSearchDTO.getElementTypeIdList();
            List<ProductionPlanStatus> productionPlanStatusList = productionPlanSearchDTO.getProductionPlanStatusList();

            FilterUtils.createEqualFilter(filters, ProductionPlanSearchDTO.ID, idList);
            FilterUtils.createEqualFilter(filters, ProductionPlanSearchDTO.CASTEDCOUNT, castedCountList);
            FilterUtils.createEqualFilter(filters, ProductionPlanSearchDTO.ELEMENTID, elementIdList);
            FilterUtils.createEqualFilter(filters, ProductionPlanSearchDTO.PROJECTID, projectIdList);
            FilterUtils.createEqualFilter(filters, ProductionPlanSearchDTO.ELEMENTTYPEID, elementTypeIdList);
            FilterUtils.createEqualFilter(filters, ProductionPlanSearchDTO.PRODUCTIONPLANSTATUS,
                    productionPlanStatusList);

            if (CollectionUtils.isNotEmpty(filters)) {
                searchObject.setFilters(filters);
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
    public ProductionPlanServiceResponse deleteProductionPlan(
            ProductionPlanServiceRequest productionPlanServiceRequest) {
        ProductionPlanDTO productionPlanDTO = productionPlanServiceRequest.getProductionPlanDTO();
        productionPlanRepo.deleteById(productionPlanDTO.getId());
        return null;
    }

    @Override
    public ProductionPlanServiceResponse getProductionPlanItems(
            ProductionPlanServiceRequest productionPlanServiceRequest) {
        ProductionPlanServiceResponse productionPlanServiceResponse = new ProductionPlanServiceResponse();

        ProductionPlanSearchDTO productionPlanSearchDTO = productionPlanServiceRequest.getProductionPlanSearchDTO();
        if (productionPlanSearchDTO != null) {
            ProductionPlanItemDTO productionPlanItemDTO = this
                    .getProductionPlanItem(productionPlanSearchDTO.getProductionPlanId());

            productionPlanServiceResponse.setProductionPlanItemDTO(productionPlanItemDTO);
        }
        return productionPlanServiceResponse;
    }

    public ProductionPlanServiceResponse deleteProductionPlanItem(Long productionPlanId) {

//        ProductionPlanItemDTO productionPlanItemDTO = productionPlanItemServiceRequest.getProductionPlanItemDTO();
//        productionPlanItemRepo.deleteById(productionPlanItemDTO.getId());
        return null;
    }

    private ProductionPlanItemDTO getProductionPlanItem(Long productionPlanId) {
        SearchObject searchObject = new SearchObject();
        List<Filter> filters = new ArrayList<>();
        FilterUtils.createEqualFilter(filters, ProductionPlanSearchDTO.PRODUCTION_PLAN_ID, productionPlanId);

        if (CollectionUtils.isNotEmpty(filters)) {
            searchObject.setFilters(filters);
        }

        ProductionPlanItem productionPlanItem = productionPlanItemRepo.search(searchObject).get(0);

        List<ProductionPlanItemDetail> productionPlanItemDetailList = this
                .getProductionPlanItemDetail(productionPlanItem.getId());

        ProductionPlanItemDTO productionPlanItemDTO = (ProductionPlanItemDTO) conversionUtility
                .convert(productionPlanItem, ProductionPlanItem.class, ProductionPlanItemDTO.class);

        List<ProductionPlanItemDetailDTO> productionPlanItemDetailDTOList = new ArrayList<>();
        for (ProductionPlanItemDetail productionPlanItemDetail : productionPlanItemDetailList) {
            productionPlanItemDetailDTOList
                    .add((ProductionPlanItemDetailDTO) conversionUtility.convert(productionPlanItemDetail,
                            ProductionPlanItemDetail.class, ProductionPlanItemDetailDTO.class));
        }

        productionPlanItemDTO.setProductionPlanItemDetailDTOList(productionPlanItemDetailDTOList);
        return productionPlanItemDTO;
    }

    private List<ProductionPlanItemDetail> getProductionPlanItemDetail(Long productionPlanItemDetailId) {
        SearchObject searchObject = new SearchObject();
        List<Filter> filters = new ArrayList<>();
        FilterUtils.createEqualFilter(filters, ProductionPlanSearchDTO.PRODUCTION_PLAN_ITEM_ID,
                productionPlanItemDetailId);

        if (CollectionUtils.isNotEmpty(filters)) {
            searchObject.setFilters(filters);
        }

        List<ProductionPlanItemDetail> productionPlanItemDetailList = productionPlanItemDetailRepo.search(searchObject);
        return productionPlanItemDetailList;
    }

    @Override
    public ProductionPlanServiceResponse updateProductionPlanItem(
            ProductionPlanServiceRequest productionPlanServiceRequest) {
//        ProductionPlanItemDTO source = productionPlanItemServiceRequest.getProductionPlanItemDTO();
//
//        ProductionPlanItem target = productionPlanItemRepo.findById(source.getId()).get();
//        target.setName(source.getName());
//
//        productionPlanItemRepo.save(target);
        return null;
    }
}
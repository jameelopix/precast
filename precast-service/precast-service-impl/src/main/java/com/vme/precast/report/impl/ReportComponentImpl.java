package com.vme.precast.report.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.domain.Element;
import com.vme.precast.domain.ElementType;
import com.vme.precast.domain.ProductionPlan;
import com.vme.precast.domain.Project;
import com.vme.precast.element.api.ElementSearchDTO;
import com.vme.precast.productionplan.api.ProductionPlanSearchDTO;
import com.vme.precast.report.api.ProductionPlanReportDTO;
import com.vme.precast.report.api.ReportComponent;
import com.vme.precast.report.api.ReportSearchDTO;
import com.vme.precast.report.api.ReportServiceRequest;
import com.vme.precast.report.api.ReportServiceResponse;
import com.vme.precast.repository.ElementRepo;
import com.vme.precast.repository.ProductionPlanRepo;

import coliseum.jpa.Association;
import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;
import coliseum.service.AssociationUtils;
import coliseum.service.FilterUtils;

public class ReportComponentImpl implements ReportComponent {

    @Autowired
    ElementRepo elementRepo;

    @Autowired
    ProductionPlanRepo productionPlanRepo;

    @Override
    public ReportServiceResponse getReports(ReportServiceRequest reportServiceRequest) {
        switch (reportServiceRequest.getReportType()) {
        case "PRODUCTION_PLAN":
            return this.createProductionPlanReport(reportServiceRequest);
        default:
            break;
        }
        return null;
    }

    private ReportServiceResponse createProductionPlanReport(ReportServiceRequest reportServiceRequest) {
        List<Long> elementIds = new LinkedList<Long>();
        Map<Long, Element> elementMap = new HashMap<>();

        populateElementIds(reportServiceRequest.getReportSearchDTO(), elementIds, elementMap);

        List<ProductionPlanReportDTO> productionPlanReportDTOList = new LinkedList<>();
        if (!elementIds.isEmpty()) {
            List<ProductionPlan> productionPlanList = getProductionPlanList(elementIds);

            for (ProductionPlan productionPlan : productionPlanList) {
                Element element = elementMap.get(productionPlan.getElement().getId());
                ElementType elementType = element.getElementType();
                Project project = element.getProject();

                ProductionPlanReportDTO reportDTO = new ProductionPlanReportDTO();
                reportDTO.setId(productionPlan.getId());
                reportDTO.setProjectCode(project.getCode());
                reportDTO.setProjectName(project.getName());

                reportDTO.setElementTypeName(elementType.getName());

                reportDTO.setElementName(element.getName());
                reportDTO.setFloor(element.getFloor());

                reportDTO.setProductionPlanStatus(productionPlan.getProductionPlanStatus());
//                reportDTO.setDeliveredDate(productionPlan.getDeliveredDate());
//                reportDTO.setPlannedDate(productionPlan.getPlannedDate());

                productionPlanReportDTOList.add(reportDTO);
            }
        }

        ReportServiceResponse reportServiceResponse = new ReportServiceResponse();
        reportServiceResponse.setProductionPlanReportDTOList(productionPlanReportDTOList);
        return reportServiceResponse;
    }

    private void populateElementIds(ReportSearchDTO reportSearchDTO, List<Long> elementIds,
            Map<Long, Element> elementMap) {
        List<Long> projectIdList = reportSearchDTO.getProjectIdList();
        List<Long> elementTypeIdList = reportSearchDTO.getElementTypeIdList();
        List<Long> elementIdList = reportSearchDTO.getElementIdList();
        List<Element> elementList = getElementList(projectIdList, elementTypeIdList, elementIdList);

        for (Element element : elementList) {
            elementIds.add(element.getId());
            elementMap.put(element.getId(), element);
        }
    }

    private List<ProductionPlan> getProductionPlanList(List<Long> elementIdList) {
        List<Filter> filters = new ArrayList<>();
        SearchObject searchObject = new SearchObject();
        List<Association> associations = new ArrayList<>();

        FilterUtils.createEqualFilter(filters, ProductionPlanSearchDTO.ELEMENTID, elementIdList);

        if (CollectionUtils.isNotEmpty(filters)) {
            searchObject.setFilters(filters);
        }

        AssociationUtils.createAssociation(associations, ProductionPlanSearchDTO.ELEMENT, true);
        if (CollectionUtils.isNotEmpty(associations)) {
            searchObject.setAssociations(associations);
        }
        return productionPlanRepo.search(searchObject);
    }

    private List<Element> getElementList(List<Long> projectIdList, List<Long> elementTypeIdList,
            List<Long> elementIdList) {

        List<Filter> filters = new ArrayList<>();
        SearchObject searchObject = new SearchObject();
        List<Association> associations = new ArrayList<>();

        FilterUtils.createEqualFilter(filters, ElementSearchDTO.ELEMENTTYPEID, elementTypeIdList);
        FilterUtils.createEqualFilter(filters, ElementSearchDTO.PROJECTID, projectIdList);
        FilterUtils.createEqualFilter(filters, ElementSearchDTO.ID, elementIdList);

        if (CollectionUtils.isNotEmpty(filters)) {
            searchObject.setFilters(filters);
        }

        AssociationUtils.createAssociation(associations, ElementSearchDTO.PROJECT, true);
        if (CollectionUtils.isNotEmpty(associations)) {
            searchObject.setAssociations(associations);
        }

        AssociationUtils.createAssociation(associations, ElementSearchDTO.ELEMENTTYPE, true);
        if (CollectionUtils.isNotEmpty(associations)) {
            searchObject.setAssociations(associations);
        }
        return elementRepo.search(searchObject);
    }
}

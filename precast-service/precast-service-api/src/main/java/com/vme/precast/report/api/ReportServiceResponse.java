package com.vme.precast.report.api;

import java.util.List;

import coliseum.service.BaseServiceResponse;

public class ReportServiceResponse extends BaseServiceResponse {

    private static final long serialVersionUID = 1L;

    private List<ProductionPlanReportDTO> productionPlanReportDTOList;

    public List<ProductionPlanReportDTO> getProductionPlanReportDTOList() {
        return productionPlanReportDTOList;
    }

    public void setProductionPlanReportDTOList(List<ProductionPlanReportDTO> productionPlanReportDTOList) {
        this.productionPlanReportDTOList = productionPlanReportDTOList;
    }
}
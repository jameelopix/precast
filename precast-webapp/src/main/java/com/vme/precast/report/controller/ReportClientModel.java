package com.vme.precast.report.controller;

import java.util.List;

import com.vme.precast.report.api.ProductionPlanReportDTO;
import com.vme.precast.report.api.ReportSearchDTO;

import coliseum.web.BaseClientModel;

public class ReportClientModel extends BaseClientModel {

    private static final long serialVersionUID = 1L;

    private String reportType;

    private ReportSearchDTO reportSearchDTO;

    private List<ProductionPlanReportDTO> productionPlanReportDTOList;

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public ReportSearchDTO getReportSearchDTO() {
        return reportSearchDTO;
    }

    public void setReportSearchDTO(ReportSearchDTO reportSearchDTO) {
        this.reportSearchDTO = reportSearchDTO;
    }

    public List<ProductionPlanReportDTO> getProductionPlanReportDTOList() {
        return productionPlanReportDTOList;
    }

    public void setProductionPlanReportDTOList(List<ProductionPlanReportDTO> productionPlanReportDTOList) {
        this.productionPlanReportDTOList = productionPlanReportDTOList;
    }
}
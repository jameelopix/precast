package com.vme.precast.report.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vme.precast.report.api.ReportService;
import com.vme.precast.report.api.ReportServiceRequest;
import com.vme.precast.report.api.ReportServiceResponse;

@Controller
public class ReportController {

    @Autowired
    ReportService reportService;

    @RequestMapping(value = "getReports", method = RequestMethod.POST)
    @ResponseBody
    public ReportClientModel getReports(@RequestBody ReportClientModel reportClientModel) {
        return this.constructClientModel(reportService.getReports(this.constructServiceRequest(reportClientModel)));
    }

    private ReportClientModel constructClientModel(ReportServiceResponse reportServiceResponse) {
        ReportClientModel reportClientModel = null;
        if (reportServiceResponse != null) {
            reportClientModel = new ReportClientModel();
            reportClientModel.setProductionPlanReportDTOList(reportServiceResponse.getProductionPlanReportDTOList());
            reportClientModel.setTotalRecords(reportServiceResponse.getTotalRecords());
        }
        return reportClientModel;
    }

    private ReportServiceRequest constructServiceRequest(ReportClientModel reportClientModel) {
        ReportServiceRequest reportServiceRequest = new ReportServiceRequest();
        reportServiceRequest.setReportType(reportClientModel.getReportType());
        reportServiceRequest.setReportSearchDTO(reportClientModel.getReportSearchDTO());
        reportServiceRequest.setRecordstoFetch(reportClientModel.getRecordstoFetch());
        reportServiceRequest.setPageIndex(reportClientModel.getPageIndex());
        return reportServiceRequest;
    }
}
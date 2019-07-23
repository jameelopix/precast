package com.vme.precast.report.api;

import coliseum.service.BaseService;
import coliseum.service.FlowDescriptor;

public interface ReportService extends BaseService {

    @FlowDescriptor(flow = "getreports", request = "reportServiceRequest", response = "reportServiceResponse")
    public ReportServiceResponse getReports(ReportServiceRequest reportServiceRequest);

}
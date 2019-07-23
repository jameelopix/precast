package com.vme.precast.report.api;

import coliseum.service.ColiseumInterface;

public interface ReportComponent extends ColiseumInterface {

    public ReportServiceResponse getReports(ReportServiceRequest reportServiceRequest);
}

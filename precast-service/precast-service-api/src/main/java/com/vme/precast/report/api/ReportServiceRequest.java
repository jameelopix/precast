package com.vme.precast.report.api;

import coliseum.service.BaseServiceRequest;

public class ReportServiceRequest extends BaseServiceRequest {

    private static final long serialVersionUID = 1L;

    private String reportType;

    private ReportSearchDTO reportSearchDTO;

    public ReportSearchDTO getReportSearchDTO() {
        return reportSearchDTO;
    }

    public void setReportSearchDTO(ReportSearchDTO reportSearchDTO) {
        this.reportSearchDTO = reportSearchDTO;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }
}

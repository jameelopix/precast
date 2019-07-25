package com.vme.precast.financialdetail.api;

import coliseum.service.BaseDTO;

public class FinancialDetailDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String gst;
    private String pan;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGst() {
        return gst;
    }

    public void setGst(String gst) {
        this.gst = gst;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }
}
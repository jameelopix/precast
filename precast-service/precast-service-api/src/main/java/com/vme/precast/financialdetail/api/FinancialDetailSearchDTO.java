package com.vme.precast.financialdetail.api;

import java.util.List;

import coliseum.service.BaseSearchDTO;

public class FinancialDetailSearchDTO extends BaseSearchDTO {

    private static final long serialVersionUID = 1L;
    private List<Long> idList;
    private List<String> gstList;
    private List<String> panList;

    public static String ID = "id";
    public static String GST = "gst";
    public static String PAN = "pan";

    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
    }

    public List<String> getGstList() {
        return gstList;
    }

    public void setGstList(List<String> gstList) {
        this.gstList = gstList;
    }

    public List<String> getPanList() {
        return panList;
    }

    public void setPanList(List<String> panList) {
        this.panList = panList;
    }
}
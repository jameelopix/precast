package com.vme.precast.productionplanitem.api;

import java.util.Date;
import java.util.List;

import coliseum.service.BaseSearchDTO;

public class ProductionPlanItemSearchDTO extends BaseSearchDTO {

    private static final long serialVersionUID = 1L;
    private List<Long> idList;
    private List<Long> productionPlanIdList;
    private List<Integer> sequenceOrderList;
    private List<Date> castedDateList;
    private List<String> disapprovedReasonList;
    private List<Boolean> disapprovedList;

    public static String ID = "id";
    public static String PRODUCTIONPLAN = "productionPlan";
    public static String SEQUENCEORDER = "sequenceOrder";
    public static String CASTEDDATE = "castedDate";
    public static String DISAPPROVEDREASON = "disapprovedReason";
    public static String DISAPPROVED = "disapproved";

    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
    }

    public List<Long> getProductionPlanIdList() {
        return productionPlanIdList;
    }

    public void setProductionPlanIdList(List<Long> productionPlanIdList) {
        this.productionPlanIdList = productionPlanIdList;
    }

    public List<Integer> getSequenceOrderList() {
        return sequenceOrderList;
    }

    public void setSequenceOrderList(List<Integer> sequenceOrderList) {
        this.sequenceOrderList = sequenceOrderList;
    }

    public List<Date> getCastedDateList() {
        return castedDateList;
    }

    public void setCastedDateList(List<Date> castedDateList) {
        this.castedDateList = castedDateList;
    }

    public List<String> getDisapprovedReasonList() {
        return disapprovedReasonList;
    }

    public void setDisapprovedReasonList(List<String> disapprovedReasonList) {
        this.disapprovedReasonList = disapprovedReasonList;
    }

    public List<Boolean> getDisapprovedList() {
        return disapprovedList;
    }

    public void setDisapprovedList(List<Boolean> disapprovedList) {
        this.disapprovedList = disapprovedList;
    }
}
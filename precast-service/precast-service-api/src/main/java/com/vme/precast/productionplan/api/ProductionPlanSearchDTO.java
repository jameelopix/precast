package com.vme.precast.productionplan.api;

import java.util.Date;
import java.util.List;

import com.vme.precast.element.api.ElementDTO;
import com.vme.precast.shared.ProductionPlanStatus;

import coliseum.service.BaseSearchDTO;

public class ProductionPlanSearchDTO extends BaseSearchDTO {

    private static final long serialVersionUID = 1L;
    private List<Long> idList;
    private List<ElementDTO> elementDTOList;
    private List<Long> elementIdList;
    private List<ProductionPlanStatus> productionPlanStatusList;
    private List<Date> plannedDateList;
    private List<Date> deliveredDateList;
    private List<Date> erectedDateList;
    private List<Integer> castedCountList;

    private boolean elementNeeded;

    public static String ID = "id";
    public static String ELEMENT = "element";
    public static String ELEMENTID = "element.id";
    public static String PRODUCTIONPLANSTATUS = "productionPlanStatus";
    public static String PLANNEDDATE = "plannedDate";
    public static String DELIVEREDDATE = "deliveredDate";
    public static String ERECTEDDATE = "erectedDate";
    public static String CASTEDCOUNT = "castedCount";

    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
    }

    public List<ElementDTO> getElementDTOList() {
        return elementDTOList;
    }

    public void setElementDTOList(List<ElementDTO> elementDTOList) {
        this.elementDTOList = elementDTOList;
    }

    public List<Long> getElementIdList() {
        return elementIdList;
    }

    public void setElementIdList(List<Long> elementIdList) {
        this.elementIdList = elementIdList;
    }

    public List<ProductionPlanStatus> getProductionPlanStatusList() {
        return productionPlanStatusList;
    }

    public void setProductionPlanStatusList(List<ProductionPlanStatus> productionPlanStatusList) {
        this.productionPlanStatusList = productionPlanStatusList;
    }

    public List<Date> getPlannedDateList() {
        return plannedDateList;
    }

    public void setPlannedDateList(List<Date> plannedDateList) {
        this.plannedDateList = plannedDateList;
    }

    public List<Date> getDeliveredDateList() {
        return deliveredDateList;
    }

    public void setDeliveredDateList(List<Date> deliveredDateList) {
        this.deliveredDateList = deliveredDateList;
    }

    public boolean isElementNeeded() {
        return elementNeeded;
    }

    public void setElementNeeded(boolean elementNeeded) {
        this.elementNeeded = elementNeeded;
    }

    public List<Integer> getCastedCountList() {
        return castedCountList;
    }

    public void setCastedCountList(List<Integer> castedCountList) {
        this.castedCountList = castedCountList;
    }

    public List<Date> getErectedDateList() {
        return erectedDateList;
    }

    public void setErectedDateList(List<Date> erectedDateList) {
        this.erectedDateList = erectedDateList;
    }
}
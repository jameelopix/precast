package com.vme.precast.productionplan.api;

import java.util.List;

import com.vme.precast.shared.ProductionPlanStatus;

import coliseum.service.BaseSearchDTO;

public class ProductionPlanSearchDTO extends BaseSearchDTO {

    private static final long serialVersionUID = 1L;
    private List<Long> idList;
    private List<Long> elementIdList;
    private List<Long> projectIdList;
    private List<Long> elementTypeIdList;
    private List<ProductionPlanStatus> productionPlanStatusList;
    private List<Integer> castedCountList;

    public static String ID = "id";
    public static String ELEMENT = "element";
    public static String ELEMENTID = "elementId";
    public static String PROJECT = "project";
    public static String PROJECTID = "projectId";
    public static String ELEMENTTYPE = "elementType";
    public static String ELEMENTTYPEID = "elementTypeId";
    public static String PRODUCTIONPLANSTATUS = "productionPlanStatus";
    public static String CASTEDCOUNT = "castedCount";

    public static String PRODUCTION_PLAN_ID = "productionPlanId";
    public static String PRODUCTION_PLAN_ITEM_ID = "productionPlanItemId";

    private Long productionPlanId;
    private Long productionPlanItemId;

    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
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

    public List<Integer> getCastedCountList() {
        return castedCountList;
    }

    public void setCastedCountList(List<Integer> castedCountList) {
        this.castedCountList = castedCountList;
    }

    public List<Long> getElementTypeIdList() {
        return elementTypeIdList;
    }

    public void setElementTypeIdList(List<Long> elementTypeIdList) {
        this.elementTypeIdList = elementTypeIdList;
    }

    public List<Long> getProjectIdList() {
        return projectIdList;
    }

    public void setProjectIdList(List<Long> projectIdList) {
        this.projectIdList = projectIdList;
    }

    public Long getProductionPlanId() {
        return productionPlanId;
    }

    public void setProductionPlanId(Long productionPlanId) {
        this.productionPlanId = productionPlanId;
    }

    public Long getProductionPlanItemId() {
        return productionPlanItemId;
    }

    public void setProductionPlanItemId(Long productionPlanItemId) {
        this.productionPlanItemId = productionPlanItemId;
    }
}
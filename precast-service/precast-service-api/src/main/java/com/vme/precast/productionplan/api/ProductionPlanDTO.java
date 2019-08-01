package com.vme.precast.productionplan.api;

import com.vme.precast.element.api.ElementDTO;
import com.vme.precast.elementtype.api.ElementTypeDTO;
import com.vme.precast.project.api.ProjectDTO;
import com.vme.precast.shared.ProductionPlanStatus;

import coliseum.service.BaseDTO;

public class ProductionPlanDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;
    private Long id;
    private ElementDTO elementDTO;
    private Long elementId;
    private ProductionPlanStatus productionPlanStatus;
    private int castedCount;

    private ProjectDTO projectDTO;
    private Long projectId;
    private ElementTypeDTO elementTypeDTO;
    private Long elementTypeId;

    public ProjectDTO getProjectDTO() {
        return projectDTO;
    }

    public void setProjectDTO(ProjectDTO projectDTO) {
        this.projectDTO = projectDTO;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public ElementTypeDTO getElementTypeDTO() {
        return elementTypeDTO;
    }

    public void setElementTypeDTO(ElementTypeDTO elementTypeDTO) {
        this.elementTypeDTO = elementTypeDTO;
    }

    public Long getElementTypeId() {
        return elementTypeId;
    }

    public void setElementTypeId(Long elementTypeId) {
        this.elementTypeId = elementTypeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ElementDTO getElementDTO() {
        return elementDTO;
    }

    public void setElementDTO(ElementDTO elementDTO) {
        this.elementDTO = elementDTO;
    }

    public Long getElementId() {
        return elementId;
    }

    public void setElementId(Long elementId) {
        this.elementId = elementId;
    }

    public ProductionPlanStatus getProductionPlanStatus() {
        return productionPlanStatus;
    }

    public void setProductionPlanStatus(ProductionPlanStatus productionPlanStatus) {
        this.productionPlanStatus = productionPlanStatus;
    }

    public int getCastedCount() {
        return castedCount;
    }

    public void setCastedCount(int castedCount) {
        this.castedCount = castedCount;
    }
}
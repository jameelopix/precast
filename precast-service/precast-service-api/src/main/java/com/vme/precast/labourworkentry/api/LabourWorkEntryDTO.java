package com.vme.precast.labourworkentry.api;

import com.vme.precast.elementtype.api.ElementTypeDTO;
import com.vme.precast.project.api.ProjectDTO;
import com.vme.precast.subcontractor.api.SubContractorDTO;

import coliseum.service.BaseDTO;

public class LabourWorkEntryDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String workType;
    private String workDesc;
    private Double quantity;
    private String unit;
    private Long subContractorId;
    private Long projectId;
    private Long elementTypeId;
    private SubContractorDTO subContractorDTO;
    private ProjectDTO projectDTO;
    private ElementTypeDTO elementTypeDTO;

    public SubContractorDTO getSubContractorDTO() {
        return subContractorDTO;
    }

    public void setSubContractorDTO(SubContractorDTO subContractorDTO) {
        this.subContractorDTO = subContractorDTO;
    }

    public ProjectDTO getProjectDTO() {
        return projectDTO;
    }

    public void setProjectDTO(ProjectDTO projectDTO) {
        this.projectDTO = projectDTO;
    }

    public ElementTypeDTO getElementTypeDTO() {
        return elementTypeDTO;
    }

    public void setElementTypeDTO(ElementTypeDTO elementTypeDTO) {
        this.elementTypeDTO = elementTypeDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public String getWorkDesc() {
        return workDesc;
    }

    public void setWorkDesc(String workDesc) {
        this.workDesc = workDesc;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Long getSubContractorId() {
        return subContractorId;
    }

    public void setSubContractorId(Long subContractorId) {
        this.subContractorId = subContractorId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getElementTypeId() {
        return elementTypeId;
    }

    public void setElementTypeId(Long elementTypeId) {
        this.elementTypeId = elementTypeId;
    }
}
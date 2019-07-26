package com.vme.precast.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import coliseum.jpa.domain.BaseEntity;

@Entity
public class LabourWorkEntry extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String workType;

    private String workDesc;

    private Double quantity;

    private String unit;

    @ManyToOne(fetch = FetchType.LAZY)
    private SubContractor subContractor;

    @Column(insertable = false, updatable = false, name = "subContractor_id")
    private Long subContractorId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Project project;

    @Column(insertable = false, updatable = false, name = "project_id")
    private Long projectId;

    @ManyToOne(fetch = FetchType.LAZY)
    private ElementType elementType;

    @Column(insertable = false, updatable = false, name = "elementType_id")
    private Long elementTypeId;

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

    public SubContractor getSubContractor() {
        return subContractor;
    }

    public void setSubContractor(SubContractor subContractor) {
        this.subContractor = subContractor;
    }

    public Long getSubContractorId() {
        return subContractorId;
    }

    public void setSubContractorId(Long subContractorId) {
        this.subContractorId = subContractorId;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public ElementType getElementType() {
        return elementType;
    }

    public void setElementType(ElementType elementType) {
        this.elementType = elementType;
    }

    public Long getElementTypeId() {
        return elementTypeId;
    }

    public void setElementTypeId(Long elementTypeId) {
        this.elementTypeId = elementTypeId;
    }
}
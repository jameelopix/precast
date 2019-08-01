package com.vme.precast.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.vme.precast.shared.ProductionPlanStatus;

import coliseum.jpa.domain.BaseEntity;

@Entity
public class ProductionPlan extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private Element element;

    @Column(insertable = false, updatable = false, name = "element_id")
    private Long elementId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Project project;

    @Column(insertable = false, updatable = false, name = "project_id")
    private Long projectId;

    @ManyToOne(fetch = FetchType.LAZY)
    private ElementType elementType;

    @Column(insertable = false, updatable = false, name = "elementType_id")
    private Long elementTypeId;

    private ProductionPlanStatus productionPlanStatus;

    private int castedCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
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
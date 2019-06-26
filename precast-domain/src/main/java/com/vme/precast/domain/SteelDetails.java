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
public class SteelDetails extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String rawMaterialName;

    private String unit;

    private Double theoriticalQuantity;

    private Double actualQuantity;

    @ManyToOne(fetch = FetchType.LAZY)
    private Element element;

    @Column(insertable = false, updatable = false, name = "element_id")
    private Long elementId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRawMaterialName() {
        return rawMaterialName;
    }

    public void setRawMaterialName(String rawMaterialName) {
        this.rawMaterialName = rawMaterialName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getTheoriticalQuantity() {
        return theoriticalQuantity;
    }

    public void setTheoriticalQuantity(Double theoriticalQuantity) {
        this.theoriticalQuantity = theoriticalQuantity;
    }

    public Double getActualQuantity() {
        return actualQuantity;
    }

    public void setActualQuantity(Double actualQuantity) {
        this.actualQuantity = actualQuantity;
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
}
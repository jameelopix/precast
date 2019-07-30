package com.vme.precast.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import coliseum.jpa.domain.BaseEntity;

@Entity
public class ElementDetails extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String mixDesignName;

    private Double weight;

    private Double length;

    private Double width;

    private Double thickness;

    private Double theoriticalQuantity;

    private String unit;

    @OneToOne(fetch = FetchType.LAZY)
    private Element element;

    @Column(insertable = false, updatable = false, name = "element_id")
    private Long elementId;

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getThickness() {
        return thickness;
    }

    public void setThickness(Double thickness) {
        this.thickness = thickness;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMixDesignName() {
        return mixDesignName;
    }

    public void setMixDesignName(String mixDesignName) {
        this.mixDesignName = mixDesignName;
    }

    public Double getTheoriticalQuantity() {
        return theoriticalQuantity;
    }

    public void setTheoriticalQuantity(Double theoriticalQuantity) {
        this.theoriticalQuantity = theoriticalQuantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
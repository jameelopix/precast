package com.vme.precast.elementdetails.api;

import com.vme.precast.element.api.ElementDTO;

import coliseum.service.BaseDTO;

public class ElementDetailsDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String mixDesignName;
    private Double weight;
    private Double length;
    private Double width;
    private Double thickness;
    private Double theoriticalQuantity;
    private String unit;
    private ElementDTO elementDTO;
    private Long elementId;

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
package com.vme.precast.steeldetails.api;

import com.vme.precast.element.api.ElementDTO;

import coliseum.service.BaseDTO;

public class SteelDetailsDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;
    private String rawMaterialName;
    private String unit;
    private Double theoriticalQuantity;
    private Double actualQuantity;
    private ElementDTO elementDTO;
    private Long elementId;

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
}
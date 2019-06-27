package com.vme.precast.steeldetails.api;

import com.vme.precast.element.api.ElementDTO;

import coliseum.service.BaseDTO;

public class SteelDetailsDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String rawMaterialName;
    private String unit;
    private Double theoriticalQuantity;
    private Double actualQuantity;
    private ElementDTO elementDTO;
    private Long elementDTOId;

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

    public ElementDTO getElementDTO() {
        return elementDTO;
    }

    public void setElementDTO(ElementDTO elementDTO) {
        this.elementDTO = elementDTO;
    }

    public Long getElementDTOId() {
        return elementDTOId;
    }

    public void setElementDTOId(Long elementDTOId) {
        this.elementDTOId = elementDTOId;
    }
}
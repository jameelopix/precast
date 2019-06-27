package com.vme.precast.rawmaterial.api;

import coliseum.service.BaseDTO;

public class RawMaterialDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private String type;
    private String unit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

}
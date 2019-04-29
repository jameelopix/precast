package com.vme.precast.item.api;

import com.vme.precast.shared.UnitType;

import coliseum.service.BaseDTO;

public class ItemDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private String category;
    private UnitType unitType;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public UnitType getUnitType() {
        return unitType;
    }

    public void setUnitType(UnitType unitType) {
        this.unitType = unitType;
    }
}
package com.vme.precast.costcentre.api;

import coliseum.service.BaseDTO;

public class CostCentreDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;

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
}
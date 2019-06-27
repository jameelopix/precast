package com.vme.precast.mixtureitem.api;

import com.vme.precast.mixture.api.MixtureDTO;

import coliseum.service.BaseDTO;

public class MixtureItemDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;
    private Long id;
    private MixtureDTO mixtureDTO;
    private Long mixtureDTOId;
    private String rawMaterialName;
    private String unit;
    private Double quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MixtureDTO getMixtureDTO() {
        return mixtureDTO;
    }

    public void setMixtureDTO(MixtureDTO mixtureDTO) {
        this.mixtureDTO = mixtureDTO;
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

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Long getMixtureDTOId() {
        return mixtureDTOId;
    }

    public void setMixtureDTOId(Long mixtureDTOId) {
        this.mixtureDTOId = mixtureDTOId;
    }

}
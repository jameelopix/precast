package com.vme.precast.subcontractor.api;

import com.vme.precast.address.api.AddressDTO;
import com.vme.precast.financialdetail.api.FinancialDetailDTO;

import coliseum.service.BaseDTO;

public class SubContractorDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String code;
    private String name;
    private Boolean active;
    private FinancialDetailDTO financialDetailDTO;
    private Long financialDetailId;
    private AddressDTO addressDTO;
    private Long addressId;

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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public FinancialDetailDTO getFinancialDetailDTO() {
        return financialDetailDTO;
    }

    public void setFinancialDetailDTO(FinancialDetailDTO financialDetailDTO) {
        this.financialDetailDTO = financialDetailDTO;
    }

    public Long getFinancialDetailId() {
        return financialDetailId;
    }

    public void setFinancialDetailId(Long financialDetailId) {
        this.financialDetailId = financialDetailId;
    }

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
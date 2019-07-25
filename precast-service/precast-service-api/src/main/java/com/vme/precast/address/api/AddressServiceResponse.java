package com.vme.precast.address.api;

import java.util.List;

import coliseum.service.BaseServiceResponse;

public class AddressServiceResponse extends BaseServiceResponse {

    private static final long serialVersionUID = 1L;

    private List<AddressDTO> addressDTOList;

    public List<AddressDTO> getAddressDTOList() {
        return addressDTOList;
    }

    public void setAddressDTOList(List<AddressDTO> addressDTOList) {
        this.addressDTOList = addressDTOList;
    }
}
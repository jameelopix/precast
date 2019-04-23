package com.vme.precast.address.controller;

import java.util.List;

import com.vme.precast.address.api.AddressDTO;
import com.vme.precast.address.api.AddressSearchDTO;

import coliseum.web.BaseClientModel;

public class AddressClientModel extends BaseClientModel {

	private static final long serialVersionUID = 1L;

	private AddressDTO addressDTO;

	private AddressSearchDTO addressSearchDTO;

	private List<AddressDTO> addressDTOList;

	public AddressDTO getAddressDTO() {
		return addressDTO;
	}

	public void setAddressDTO(AddressDTO addressDTO) {
		this.addressDTO = addressDTO;
	}

	public AddressSearchDTO getAddressSearchDTO() {
		return addressSearchDTO;
	}

	public void setAddressSearchDTO(AddressSearchDTO addressSearchDTO) {
		this.addressSearchDTO = addressSearchDTO;
	}

	public List<AddressDTO> getAddressDTOList() {
		return addressDTOList;
	}

	public void setAddressDTOList(List<AddressDTO> addressDTOList) {
		this.addressDTOList = addressDTOList;
	}
}

package com.vme.precast.vendor.api;

import java.util.List;

import com.vme.precast.address.api.AddressDTO;

import coliseum.service.BaseDTO;

public class VendorDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private List<AddressDTO> addressDTOList;

	private List<Long> addressIdList;

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

	public List<AddressDTO> getAddressDTOList() {
		return addressDTOList;
	}

	public void setAddressDTOList(List<AddressDTO> addressDTOList) {
		this.addressDTOList = addressDTOList;
	}

	public List<Long> getAddressIdList() {
		return addressIdList;
	}

	public void setAddressIdList(List<Long> addressIdList) {
		this.addressIdList = addressIdList;
	}
}
package com.vme.precast.vendor.api;

import java.util.List;

import coliseum.service.BaseServiceResponse;

public class VendorServiceResponse extends BaseServiceResponse {

	private static final long serialVersionUID = 1L;

	private List<VendorDTO> vendorDTOList;

	public List<VendorDTO> getVendorDTOList() {
		return vendorDTOList;
	}

	public void setVendorDTOList(List<VendorDTO> vendorDTOList) {
		this.vendorDTOList = vendorDTOList;
	}
}
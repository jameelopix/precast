package com.vme.precast.vendor.api;

import java.util.List;

import coliseum.service.BaseSearchDTO;

public class VendorSearchDTO extends BaseSearchDTO {

	private static final long serialVersionUID = 1L;

	private List<String> nameList;

	private List<Long> addressIdList;

	public static String NAME = "name";
	public static String ADDRESS_ID = "address.id";

	public List<String> getNameList() {
		return nameList;
	}

	public void setNameList(List<String> nameList) {
		this.nameList = nameList;
	}

	public List<Long> getAddressIdList() {
		return addressIdList;
	}

	public void setAddressIdList(List<Long> addressIdList) {
		this.addressIdList = addressIdList;
	}
}
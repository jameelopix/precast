package com.vme.precast.address.api;

import java.util.List;

import coliseum.service.BaseSearchDTO;

public class AddressSearchDTO extends BaseSearchDTO {

	private static final long serialVersionUID = 1L;

	private List<String> addressLine1s;
	private List<String> addressLine2s;
	private List<String> pincodes;
	private List<String> states;
	private List<String> countrys;

	public static String ADDRESS_LINE_1 = "addressLine1";
	public static String ADDRESS_LINE_2 = "addressLine2";
	public static String PIN_CODE = "pincode";
	public static String STATE = "state";
	public static String COUNTRY = "country";

	public List<String> getAddressLine1s() {
		return addressLine1s;
	}

	public void setAddressLine1s(List<String> addressLine1s) {
		this.addressLine1s = addressLine1s;
	}

	public List<String> getAddressLine2s() {
		return addressLine2s;
	}

	public void setAddressLine2s(List<String> addressLine2s) {
		this.addressLine2s = addressLine2s;
	}

	public List<String> getPincodes() {
		return pincodes;
	}

	public void setPincodes(List<String> pincodes) {
		this.pincodes = pincodes;
	}

	public List<String> getStates() {
		return states;
	}

	public void setStates(List<String> states) {
		this.states = states;
	}

	public List<String> getCountrys() {
		return countrys;
	}

	public void setCountrys(List<String> countrys) {
		this.countrys = countrys;
	}
}
package com.vme.precast.company.api;

import java.util.List;

import coliseum.service.BaseSearchDTO;

public class CompanySearchDTO extends BaseSearchDTO {

	private static final long serialVersionUID = 1L;

	private List<String> names;

	private List<Boolean> selfCompanys;

	private List<Boolean> disableds;

	private List<Long> bankAccountIds;

	public List<String> getNames() {
		return names;
	}

	public List<Boolean> getSelfCompanys() {
		return selfCompanys;
	}

	public List<Boolean> getDisableds() {
		return disableds;
	}

	public List<Long> getBankAccountIds() {
		return bankAccountIds;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

	public void setSelfCompanys(List<Boolean> selfCompanys) {
		this.selfCompanys = selfCompanys;
	}

	public void setDisableds(List<Boolean> disableds) {
		this.disableds = disableds;
	}

	public void setBankAccountIds(List<Long> bankAccountIds) {
		this.bankAccountIds = bankAccountIds;
	}
}

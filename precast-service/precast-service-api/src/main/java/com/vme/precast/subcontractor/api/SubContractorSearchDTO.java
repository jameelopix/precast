package com.vme.precast.subcontractor.api;

import java.util.List;

import coliseum.service.BaseSearchDTO;

public class SubContractorSearchDTO extends BaseSearchDTO {

	private static final long serialVersionUID = 1L;

	private List<String> names;

	private List<String> panNumbers;

	private List<Double> retentionPercents;

	private List<Double> tdsPercents;

	public List<String> getNames() {
		return names;
	}

	public List<String> getPanNumbers() {
		return panNumbers;
	}

	public List<Double> getRetentionPercents() {
		return retentionPercents;
	}

	public List<Double> getTdsPercents() {
		return tdsPercents;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

	public void setPanNumbers(List<String> panNumbers) {
		this.panNumbers = panNumbers;
	}

	public void setRetentionPercents(List<Double> retentionPercents) {
		this.retentionPercents = retentionPercents;
	}

	public void setTdsPercents(List<Double> tdsPercents) {
		this.tdsPercents = tdsPercents;
	}

}

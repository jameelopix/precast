package com.vme.precast.subcontractor.api;

import coliseum.service.BaseDTO;

public class SubContractorDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	private String name;

	private String panNumber;

	private Double retentionPercent;

	private Double tdsPercent;

	public static String ID = "id";
	public static String NAME = "name";
	public static String PANNUMBER = "panNumber";
	public static String RETENTIONPERCENT = "retentionPercent";
	public static String TDSPERCENT = "tdsPercent";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public Double getRetentionPercent() {
		return retentionPercent;
	}

	public void setRetentionPercent(Double retentionPercent) {
		this.retentionPercent = retentionPercent;
	}

	public Double getTdsPercent() {
		return tdsPercent;
	}

	public void setTdsPercent(Double tdsPercent) {
		this.tdsPercent = tdsPercent;
	}
}

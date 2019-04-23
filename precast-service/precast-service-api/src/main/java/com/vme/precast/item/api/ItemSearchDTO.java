package com.vme.precast.item.api;

import java.util.List;

import com.vme.precast.shared.UnitType;

import coliseum.service.BaseSearchDTO;

public class ItemSearchDTO extends BaseSearchDTO {

	private static final long serialVersionUID = 1L;

	private List<String> names;

	private List<String> categorys;

	private List<UnitType> unitTypeList;

	public static String NAME = "name";
	public static String CATEGORY = "category";
	public static String UNIT_TYPE = "unitType";

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

	public List<String> getCategorys() {
		return categorys;
	}

	public void setCategorys(List<String> categorys) {
		this.categorys = categorys;
	}

	public List<UnitType> getUnitTypeList() {
		return unitTypeList;
	}

	public void setUnitTypeList(List<UnitType> unitTypeList) {
		this.unitTypeList = unitTypeList;
	}
}
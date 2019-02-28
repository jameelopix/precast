package com.vme.precast.rawmaterial.api;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import coliseum.service.BaseDTO;

public class RawMaterialDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	private Long id;

	@Size(min = 4, message = "Size should be greater or equal to {min}")
	private String name;

	@NotBlank(message = "{0} can't be blank")
	private String type;

	@NotBlank(message = "{0} can't be blank")
	private String unit;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

}

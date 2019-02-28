package com.vme.precast.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import coliseum.jpa.domain.BaseEntity;

@Entity
public class CastingActivity extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Element element;

	private Date castedDate;

	private Double actualConcentreQuantity;

	@OneToMany(mappedBy = "castingActivity")
	private Set<LabourActivity> labourActivitys;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Element getElement() {
		return element;
	}

	public void setElement(Element element) {
		this.element = element;
	}

	public Date getCastedDate() {
		return castedDate;
	}

	public void setCastedDate(Date castedDate) {
		this.castedDate = castedDate;
	}

	public Double getActualConcentreQuantity() {
		return actualConcentreQuantity;
	}

	public void setActualConcentreQuantity(Double actualConcentreQuantity) {
		this.actualConcentreQuantity = actualConcentreQuantity;
	}
}

package com.vme.precast.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import coliseum.jpa.domain.BaseEntity;

@Entity
public class Mixture extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String code;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "mixture")
	private Set<MixtureItem> mixtureItems;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Set<MixtureItem> getMixtureItems() {
		return mixtureItems;
	}

	public void setMixtureItems(Set<MixtureItem> mixtureItems) {
		this.mixtureItems = mixtureItems;
	}

}
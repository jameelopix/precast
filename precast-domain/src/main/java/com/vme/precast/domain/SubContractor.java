package com.vme.precast.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import coliseum.jpa.domain.BaseEntity;

@Entity
public class SubContractor extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Boolean active;

    @OneToOne(fetch = FetchType.LAZY)
    private FinancialDetail financialDetail;

    @Column(insertable = false, updatable = false, name = "financial_detail_id")
    private Long financialDetailId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Address address;

    @Column(insertable = false, updatable = false, name = "address_id")
    private Long addressId;

    public Long getId() {
        return id;
    }

    public FinancialDetail getFinancialDetail() {
        return financialDetail;
    }

    public void setFinancialDetail(FinancialDetail financialDetail) {
        this.financialDetail = financialDetail;
    }

    public Long getFinancialDetailId() {
        return financialDetailId;
    }

    public void setFinancialDetailId(Long financialDetailId) {
        this.financialDetailId = financialDetailId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
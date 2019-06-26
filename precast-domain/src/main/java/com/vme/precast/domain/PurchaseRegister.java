package com.vme.precast.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import coliseum.jpa.domain.BaseEntity;

@Entity
public class PurchaseRegister extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String vendorName;

    private String weighBridgeNo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getWeighBridgeNo() {
        return weighBridgeNo;
    }

    public void setWeighBridgeNo(String weighBridgeNo) {
        this.weighBridgeNo = weighBridgeNo;
    }
}
package com.vme.precast.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import coliseum.jpa.domain.BaseEntity;

@Entity
public class ItemFreightAmountDetails extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private ItemAmountDetails itemAmountDetails;

    @Column(insertable = false, updatable = false, name = "itemAmountDetails_id")
    private Long itemAmountDetailsId;

    private Double amount;
    private Double taxPercent;
    private Double taxAmount;
    private Double total;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ItemAmountDetails getItemAmountDetails() {
        return itemAmountDetails;
    }

    public void setItemAmountDetails(ItemAmountDetails itemAmountDetails) {
        this.itemAmountDetails = itemAmountDetails;
    }

    public Long getItemAmountDetailsId() {
        return itemAmountDetailsId;
    }

    public void setItemAmountDetailsId(Long itemAmountDetailsId) {
        this.itemAmountDetailsId = itemAmountDetailsId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getTaxPercent() {
        return taxPercent;
    }

    public void setTaxPercent(Double taxPercent) {
        this.taxPercent = taxPercent;
    }

    public Double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(Double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
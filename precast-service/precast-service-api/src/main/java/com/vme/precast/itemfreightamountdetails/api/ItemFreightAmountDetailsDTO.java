package com.vme.precast.itemfreightamountdetails.api;

import com.vme.precast.itemamountdetails.api.ItemAmountDetailsDTO;

import coliseum.service.BaseDTO;

public class ItemFreightAmountDetailsDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;
    private Long id;
    private ItemAmountDetailsDTO itemAmountDetailsDTO;
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

    public ItemAmountDetailsDTO getItemAmountDetailsDTO() {
        return itemAmountDetailsDTO;
    }

    public void setItemAmountDetailsDTO(ItemAmountDetailsDTO itemAmountDetailsDTO) {
        this.itemAmountDetailsDTO = itemAmountDetailsDTO;
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
package com.vme.precast.itemamountdetails.api;

import com.vme.precast.vendor.api.VendorDTO;

import coliseum.service.BaseDTO;

public class ItemAmountDetailsDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;
    private Long id;
    private VendorDTO vendorDTO;
    private Long vendorDTOId;
    private String dcNo;
    private Double total;
    private Boolean invoiceChecked;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public VendorDTO getVendorDTO() {
        return vendorDTO;
    }

    public void setVendorDTO(VendorDTO vendorDTO) {
        this.vendorDTO = vendorDTO;
    }

    public Long getVendorDTOId() {
        return vendorDTOId;
    }

    public void setVendorDTOId(Long vendorDTOId) {
        this.vendorDTOId = vendorDTOId;
    }

    public String getDcNo() {
        return dcNo;
    }

    public void setDcNo(String dcNo) {
        this.dcNo = dcNo;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getInvoiceChecked() {
        return invoiceChecked;
    }

    public void setInvoiceChecked(Boolean invoiceChecked) {
        this.invoiceChecked = invoiceChecked;
    }
}
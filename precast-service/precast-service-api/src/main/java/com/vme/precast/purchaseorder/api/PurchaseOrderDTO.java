package com.vme.precast.purchaseorder.api;

import java.util.Date;

import com.vme.precast.shared.PurchaseOrderStatus;
import com.vme.precast.vendor.api.VendorDTO;

import coliseum.service.BaseDTO;

public class PurchaseOrderDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String purchaseOrderNo;
    private Date purchaseDate;
    private PurchaseOrderStatus purchaseOrderStatus;
    private VendorDTO vendorDTO;
    private Long vendorId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPurchaseOrderNo() {
        return purchaseOrderNo;
    }

    public void setPurchaseOrderNo(String purchaseOrderNo) {
        this.purchaseOrderNo = purchaseOrderNo;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public PurchaseOrderStatus getPurchaseOrderStatus() {
        return purchaseOrderStatus;
    }

    public void setPurchaseOrderStatus(PurchaseOrderStatus purchaseOrderStatus) {
        this.purchaseOrderStatus = purchaseOrderStatus;
    }

    public VendorDTO getVendorDTO() {
        return vendorDTO;
    }

    public void setVendorDTO(VendorDTO vendorDTO) {
        this.vendorDTO = vendorDTO;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }
}
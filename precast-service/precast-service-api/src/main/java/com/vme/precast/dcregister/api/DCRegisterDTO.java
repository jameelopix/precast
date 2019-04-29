package com.vme.precast.dcregister.api;

import com.vme.precast.vendor.api.VendorDTO;

import coliseum.service.BaseDTO;

public class DCRegisterDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;
    private Long id;
    private VendorDTO vendorDTO;
    private String dcNo;
    private String grnNo;
    private Long vendorId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDcNo() {
        return dcNo;
    }

    public void setDcNo(String dcNo) {
        this.dcNo = dcNo;
    }

    public String getGrnNo() {
        return grnNo;
    }

    public void setGrnNo(String grnNo) {
        this.grnNo = grnNo;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public VendorDTO getVendorDTO() {
        return vendorDTO;
    }

    public void setVendorDTO(VendorDTO vendorDTO) {
        this.vendorDTO = vendorDTO;
    }
}
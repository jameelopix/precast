package com.vme.precast.purchaseregister.api;

import com.vme.precast.vendor.api.VendorDTO;

import coliseum.service.BaseDTO;

public class PurchaseRegisterDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;
    private Long id;
    private VendorDTO vendorDTO;
    private Long vendorDTOId;
    private String weighBridgeNo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWeighBridgeNo() {
        return weighBridgeNo;
    }

    public void setWeighBridgeNo(String weighBridgeNo) {
        this.weighBridgeNo = weighBridgeNo;
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

}
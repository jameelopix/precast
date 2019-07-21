package com.vme.precast.itemamountdetails.api;

import java.util.List;

import com.vme.precast.vendor.api.VendorDTO;

import coliseum.service.BaseSearchDTO;

public class ItemAmountDetailsSearchDTO extends BaseSearchDTO {

    private static final long serialVersionUID = 1L;
    private List<Long> idList;
    private List<VendorDTO> vendorDTOList;
    private List<Long> vendorDTOIdList;
    private List<String> dcNoList;
    private List<Double> totalList;
    private List<Boolean> invoiceCheckedList;

    private boolean vendorNeeded;

    public static String ID = "id";
    public static String VENDOR = "vendor";
    public static String VENDORID = "vendor.id";
    public static String DCNO = "dcNo";
    public static String TOTAL = "total";
    public static String INVOICECHECKED = "invoiceChecked";

    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
    }

    public List<VendorDTO> getVendorDTOList() {
        return vendorDTOList;
    }

    public void setVendorDTOList(List<VendorDTO> vendorDTOList) {
        this.vendorDTOList = vendorDTOList;
    }

    public List<Long> getVendorDTOIdList() {
        return vendorDTOIdList;
    }

    public void setVendorDTOIdList(List<Long> vendorDTOIdList) {
        this.vendorDTOIdList = vendorDTOIdList;
    }

    public List<String> getDcNoList() {
        return dcNoList;
    }

    public void setDcNoList(List<String> dcNoList) {
        this.dcNoList = dcNoList;
    }

    public List<Double> getTotalList() {
        return totalList;
    }

    public void setTotalList(List<Double> totalList) {
        this.totalList = totalList;
    }

    public List<Boolean> getInvoiceCheckedList() {
        return invoiceCheckedList;
    }

    public void setInvoiceCheckedList(List<Boolean> invoiceCheckedList) {
        this.invoiceCheckedList = invoiceCheckedList;
    }

    public boolean isVendorNeeded() {
        return vendorNeeded;
    }

    public void setVendorNeeded(boolean vendorNeeded) {
        this.vendorNeeded = vendorNeeded;
    }
}
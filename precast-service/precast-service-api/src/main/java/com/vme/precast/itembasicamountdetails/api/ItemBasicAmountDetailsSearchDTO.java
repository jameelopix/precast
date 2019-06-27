package com.vme.precast.itembasicamountdetails.api;

import java.util.List;

import com.vme.precast.itemamountdetails.api.ItemAmountDetailsDTO;
import com.vme.precast.purchaseregisteritem.api.PurchaseRegisterItemDTO;

import coliseum.service.BaseSearchDTO;

public class ItemBasicAmountDetailsSearchDTO extends BaseSearchDTO {

    private static final long serialVersionUID = 1L;
    private List<Long> idList;
    private List<ItemAmountDetailsDTO> itemAmountDetailsDTOList;
    private List<Long> itemAmountDetailsIdList;
    private List<PurchaseRegisterItemDTO> purchaseRegisterItemDTOList;
    private List<Long> purchaseRegisterItemIdList;
    private List<Double> rateList;
    private List<Double> amountList;
    private List<Double> taxPercentList;
    private List<Double> taxAmountList;
    private List<Double> totalList;

    public static String ID = "id";
    public static String ITEMAMOUNTDETAILS = "itemAmountDetails";
    public static String ITEMAMOUNTDETAILSID = "itemAmountDetails.id";
    public static String PURCHASEREGISTERITEM = "purchaseRegisterItem";
    public static String PURCHASEREGISTERITEMID = "purchaseRegisterItem.id";
    public static String RATE = "rate";
    public static String AMOUNT = "amount";
    public static String TAXPERCENT = "taxPercent";
    public static String TAXAMOUNT = "taxAmount";
    public static String TOTAL = "total";

    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
    }

    public List<ItemAmountDetailsDTO> getItemAmountDetailsDTOList() {
        return itemAmountDetailsDTOList;
    }

    public void setItemAmountDetailsDTOList(List<ItemAmountDetailsDTO> itemAmountDetailsDTOList) {
        this.itemAmountDetailsDTOList = itemAmountDetailsDTOList;
    }

    public List<Long> getItemAmountDetailsIdList() {
        return itemAmountDetailsIdList;
    }

    public void setItemAmountDetailsIdList(List<Long> itemAmountDetailsIdList) {
        this.itemAmountDetailsIdList = itemAmountDetailsIdList;
    }

    public List<PurchaseRegisterItemDTO> getPurchaseRegisterItemDTOList() {
        return purchaseRegisterItemDTOList;
    }

    public void setPurchaseRegisterItemDTOList(List<PurchaseRegisterItemDTO> purchaseRegisterItemDTOList) {
        this.purchaseRegisterItemDTOList = purchaseRegisterItemDTOList;
    }

    public List<Long> getPurchaseRegisterItemIdList() {
        return purchaseRegisterItemIdList;
    }

    public void setPurchaseRegisterItemIdList(List<Long> purchaseRegisterItemIdList) {
        this.purchaseRegisterItemIdList = purchaseRegisterItemIdList;
    }

    public List<Double> getRateList() {
        return rateList;
    }

    public void setRateList(List<Double> rateList) {
        this.rateList = rateList;
    }

    public List<Double> getAmountList() {
        return amountList;
    }

    public void setAmountList(List<Double> amountList) {
        this.amountList = amountList;
    }

    public List<Double> getTaxPercentList() {
        return taxPercentList;
    }

    public void setTaxPercentList(List<Double> taxPercentList) {
        this.taxPercentList = taxPercentList;
    }

    public List<Double> getTaxAmountList() {
        return taxAmountList;
    }

    public void setTaxAmountList(List<Double> taxAmountList) {
        this.taxAmountList = taxAmountList;
    }

    public List<Double> getTotalList() {
        return totalList;
    }

    public void setTotalList(List<Double> totalList) {
        this.totalList = totalList;
    }
}
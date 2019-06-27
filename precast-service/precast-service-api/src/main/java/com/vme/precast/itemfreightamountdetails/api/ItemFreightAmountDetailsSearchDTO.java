package com.vme.precast.itemfreightamountdetails.api;

import java.util.List;

import com.vme.precast.itemamountdetails.api.ItemAmountDetailsDTO;

import coliseum.service.BaseSearchDTO;

public class ItemFreightAmountDetailsSearchDTO extends BaseSearchDTO {

    private static final long serialVersionUID = 1L;
    private List<Long> idList;
    private List<ItemAmountDetailsDTO> itemAmountDetailsDTOList;
    private List<Long> itemAmountDetailsDTOIdList;
    private List<Double> amountList;
    private List<Double> taxPercentList;
    private List<Double> taxAmountList;
    private List<Double> totalList;

    public static String ID = "id";
    public static String ITEMAMOUNTDETAILS = "itemAmountDetails";
    public static String ITEMAMOUNTDETAILSID = "itemAmountDetailsId";
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

    public List<Long> getItemAmountDetailsDTOIdList() {
        return itemAmountDetailsDTOIdList;
    }

    public void setItemAmountDetailsDTOIdList(List<Long> itemAmountDetailsDTOIdList) {
        this.itemAmountDetailsDTOIdList = itemAmountDetailsDTOIdList;
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
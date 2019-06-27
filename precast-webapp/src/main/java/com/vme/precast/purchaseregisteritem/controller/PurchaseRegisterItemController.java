package com.vme.precast.purchaseregisteritem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vme.precast.purchaseregisteritem.api.PurchaseRegisterItemDTO;
import com.vme.precast.purchaseregisteritem.api.PurchaseRegisterItemService;
import com.vme.precast.purchaseregisteritem.api.PurchaseRegisterItemServiceRequest;
import com.vme.precast.purchaseregisteritem.api.PurchaseRegisterItemServiceResponse;

@Controller
public class PurchaseRegisterItemController {

    @Autowired
    PurchaseRegisterItemService purchaseRegisterItemService;

    @RequestMapping(value = "deletePurchaseRegisterItem", method = RequestMethod.POST)
    @ResponseBody
    public PurchaseRegisterItemClientModel deletePurchaseRegisterItem(@RequestBody PurchaseRegisterItemClientModel purchaseRegisterItemClientModel) {
        PurchaseRegisterItemServiceRequest purchaseRegisterItemServiceRequest = new PurchaseRegisterItemServiceRequest();
        for (Long id : purchaseRegisterItemClientModel.getIdsToDelete()) {
            PurchaseRegisterItemDTO purchaseRegisterItemDTO = new PurchaseRegisterItemDTO();
            purchaseRegisterItemDTO.setId(id);
            purchaseRegisterItemServiceRequest.setPurchaseRegisterItemDTO(purchaseRegisterItemDTO);
            purchaseRegisterItemService.deletePurchaseRegisterItem(purchaseRegisterItemServiceRequest);
        }
        return null;
    }

    @RequestMapping(value = "createPurchaseRegisterItem", method = RequestMethod.POST)
    @ResponseBody
    public PurchaseRegisterItemClientModel createPurchaseRegisterItem(@Valid @RequestBody PurchaseRegisterItemClientModel purchaseRegisterItemClientModel) {
        return this.constructClientModel(purchaseRegisterItemService.createPurchaseRegisterItem(this.constructServiceRequest(purchaseRegisterItemClientModel)));
    }

    @RequestMapping(value = "updatePurchaseRegisterItem", method = RequestMethod.POST)
    @ResponseBody
    public PurchaseRegisterItemClientModel updatePurchaseRegisterItem(@Valid @RequestBody PurchaseRegisterItemClientModel purchaseRegisterItemClientModel) {
        return this.constructClientModel(purchaseRegisterItemService.updatePurchaseRegisterItem(this.constructServiceRequest(purchaseRegisterItemClientModel)));
    }

    @RequestMapping(value = "getPurchaseRegisterItem", method = RequestMethod.POST)
    @ResponseBody
    public PurchaseRegisterItemClientModel getPurchaseRegisterItem(@RequestBody PurchaseRegisterItemClientModel purchaseRegisterItemClientModel) {
        return this.constructClientModel(purchaseRegisterItemService.getPurchaseRegisterItems(this.constructServiceRequest(purchaseRegisterItemClientModel)));
    }

    private PurchaseRegisterItemClientModel constructClientModel(PurchaseRegisterItemServiceResponse purchaseRegisterItemServiceResponse) {
        PurchaseRegisterItemClientModel purchaseRegisterItemClientModel = null;
        if (purchaseRegisterItemServiceResponse != null) {
            purchaseRegisterItemClientModel = new PurchaseRegisterItemClientModel();
            purchaseRegisterItemClientModel.setPurchaseRegisterItemDTOList(purchaseRegisterItemServiceResponse.getPurchaseRegisterItemDTOList());
            purchaseRegisterItemClientModel.setTotalRecords(purchaseRegisterItemServiceResponse.getTotalRecords());
        }
        return purchaseRegisterItemClientModel;
    }

    private PurchaseRegisterItemServiceRequest constructServiceRequest(PurchaseRegisterItemClientModel purchaseRegisterItemClientModel) {
        PurchaseRegisterItemServiceRequest purchaseRegisterItemServiceRequest = new PurchaseRegisterItemServiceRequest();
        purchaseRegisterItemServiceRequest.setPurchaseRegisterItemDTO(purchaseRegisterItemClientModel.getPurchaseRegisterItemDTO());
        purchaseRegisterItemServiceRequest.setPurchaseRegisterItemSearchDTO(purchaseRegisterItemClientModel.getPurchaseRegisterItemSearchDTO());
        purchaseRegisterItemServiceRequest.setRecordstoFetch(purchaseRegisterItemClientModel.getRecordstoFetch());
        purchaseRegisterItemServiceRequest.setPageIndex(purchaseRegisterItemClientModel.getPageIndex());
        return purchaseRegisterItemServiceRequest;
    }
}
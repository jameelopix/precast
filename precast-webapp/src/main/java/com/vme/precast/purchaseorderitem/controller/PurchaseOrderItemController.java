package com.vme.precast.purchaseorderitem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vme.precast.purchaseorderitem.api.PurchaseOrderItemDTO;
import com.vme.precast.purchaseorderitem.api.PurchaseOrderItemService;
import com.vme.precast.purchaseorderitem.api.PurchaseOrderItemServiceRequest;
import com.vme.precast.purchaseorderitem.api.PurchaseOrderItemServiceResponse;

@Controller
public class PurchaseOrderItemController {

    @Autowired
    PurchaseOrderItemService purchaseOrderItemService;

    @RequestMapping(value = "deletePurchaseOrderItem", method = RequestMethod.POST)
    @ResponseBody
    public PurchaseOrderItemClientModel deletePurchaseOrderItem(@RequestBody PurchaseOrderItemClientModel purchaseOrderItemClientModel) {
        PurchaseOrderItemServiceRequest purchaseOrderItemServiceRequest = new PurchaseOrderItemServiceRequest();
        for (Long id : purchaseOrderItemClientModel.getIdsToDelete()) {
            PurchaseOrderItemDTO purchaseOrderItemDTO = new PurchaseOrderItemDTO();
            purchaseOrderItemDTO.setId(id);
            purchaseOrderItemServiceRequest.setPurchaseOrderItemDTO(purchaseOrderItemDTO);
            purchaseOrderItemService.deletePurchaseOrderItem(purchaseOrderItemServiceRequest);
        }
        return null;
    }

    @RequestMapping(value = "createPurchaseOrderItem", method = RequestMethod.POST)
    @ResponseBody
    public PurchaseOrderItemClientModel createPurchaseOrderItem(@Valid @RequestBody PurchaseOrderItemClientModel purchaseOrderItemClientModel) {
        return this.constructClientModel(purchaseOrderItemService.createPurchaseOrderItem(this.constructServiceRequest(purchaseOrderItemClientModel)));
    }

    @RequestMapping(value = "updatePurchaseOrderItem", method = RequestMethod.POST)
    @ResponseBody
    public PurchaseOrderItemClientModel updatePurchaseOrderItem(@Valid @RequestBody PurchaseOrderItemClientModel purchaseOrderItemClientModel) {
        return this.constructClientModel(purchaseOrderItemService.updatePurchaseOrderItem(this.constructServiceRequest(purchaseOrderItemClientModel)));
    }

    @RequestMapping(value = "getPurchaseOrderItem", method = RequestMethod.POST)
    @ResponseBody
    public PurchaseOrderItemClientModel getPurchaseOrderItem(@RequestBody PurchaseOrderItemClientModel purchaseOrderItemClientModel) {
        return this.constructClientModel(purchaseOrderItemService.getPurchaseOrderItems(this.constructServiceRequest(purchaseOrderItemClientModel)));
    }

    private PurchaseOrderItemClientModel constructClientModel(PurchaseOrderItemServiceResponse purchaseOrderItemServiceResponse) {
        PurchaseOrderItemClientModel purchaseOrderItemClientModel = null;
        if (purchaseOrderItemServiceResponse != null) {
            purchaseOrderItemClientModel = new PurchaseOrderItemClientModel();
            purchaseOrderItemClientModel.setPurchaseOrderItemDTOList(purchaseOrderItemServiceResponse.getPurchaseOrderItemDTOList());
            purchaseOrderItemClientModel.setTotalRecords(purchaseOrderItemServiceResponse.getTotalRecords());
        }
        return purchaseOrderItemClientModel;
    }

    private PurchaseOrderItemServiceRequest constructServiceRequest(PurchaseOrderItemClientModel purchaseOrderItemClientModel) {
        PurchaseOrderItemServiceRequest purchaseOrderItemServiceRequest = new PurchaseOrderItemServiceRequest();
        purchaseOrderItemServiceRequest.setPurchaseOrderItemDTO(purchaseOrderItemClientModel.getPurchaseOrderItemDTO());
        purchaseOrderItemServiceRequest.setPurchaseOrderItemSearchDTO(purchaseOrderItemClientModel.getPurchaseOrderItemSearchDTO());
        purchaseOrderItemServiceRequest.setRecordstoFetch(purchaseOrderItemClientModel.getRecordstoFetch());
        purchaseOrderItemServiceRequest.setPageIndex(purchaseOrderItemClientModel.getPageIndex());
        return purchaseOrderItemServiceRequest;
    }
}
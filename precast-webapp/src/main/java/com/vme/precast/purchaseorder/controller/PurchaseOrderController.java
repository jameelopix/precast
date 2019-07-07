package com.vme.precast.purchaseorder.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vme.precast.purchaseorder.api.PurchaseOrderDTO;
import com.vme.precast.purchaseorder.api.PurchaseOrderService;
import com.vme.precast.purchaseorder.api.PurchaseOrderServiceRequest;
import com.vme.precast.purchaseorder.api.PurchaseOrderServiceResponse;

@Controller
public class PurchaseOrderController {

    @Autowired
    PurchaseOrderService purchaseOrderService;

    @RequestMapping(value = "deletePurchaseOrder", method = RequestMethod.POST)
    @ResponseBody
    public PurchaseOrderClientModel deletePurchaseOrder(
            @RequestBody PurchaseOrderClientModel purchaseOrderClientModel) {
        PurchaseOrderServiceRequest purchaseOrderServiceRequest = new PurchaseOrderServiceRequest();
        for (Long id : purchaseOrderClientModel.getIdsToDelete()) {
            PurchaseOrderDTO purchaseOrderDTO = new PurchaseOrderDTO();
            purchaseOrderDTO.setId(id);
            purchaseOrderServiceRequest.setPurchaseOrderDTO(purchaseOrderDTO);
            purchaseOrderService.deletePurchaseOrder(purchaseOrderServiceRequest);
        }
        return null;
    }

    @RequestMapping(value = "createPurchaseOrder", method = RequestMethod.POST)
    @ResponseBody
    public PurchaseOrderClientModel createPurchaseOrder(
            @Valid @RequestBody PurchaseOrderClientModel purchaseOrderClientModel) {
        return this.constructClientModel(
                purchaseOrderService.createPurchaseOrder(this.constructServiceRequest(purchaseOrderClientModel)));
    }

    @RequestMapping(value = "updatePurchaseOrder", method = RequestMethod.POST)
    @ResponseBody
    public PurchaseOrderClientModel updatePurchaseOrder(
            @Valid @RequestBody PurchaseOrderClientModel purchaseOrderClientModel) {
        return this.constructClientModel(
                purchaseOrderService.updatePurchaseOrder(this.constructServiceRequest(purchaseOrderClientModel)));
    }

    @RequestMapping(value = "getPurchaseOrder", method = RequestMethod.POST)
    @ResponseBody
    public PurchaseOrderClientModel getPurchaseOrder(@RequestBody PurchaseOrderClientModel purchaseOrderClientModel) {
        return this.constructClientModel(
                purchaseOrderService.getPurchaseOrders(this.constructServiceRequest(purchaseOrderClientModel)));
    }

    @RequestMapping(value = "issuePurchaseOrder", method = RequestMethod.POST)
    @ResponseBody
    public PurchaseOrderClientModel issuePurchaseOrder(
            @Valid @RequestBody PurchaseOrderClientModel purchaseOrderClientModel) {
        return this.constructClientModel(
                purchaseOrderService.issuePurchaseOrder(this.constructServiceRequest(purchaseOrderClientModel)));
    }

    @RequestMapping(value = "closePurchaseOrder", method = RequestMethod.POST)
    @ResponseBody
    public PurchaseOrderClientModel closePurchaseOrder(
            @Valid @RequestBody PurchaseOrderClientModel purchaseOrderClientModel) {
        return this.constructClientModel(
                purchaseOrderService.closePurchaseOrder(this.constructServiceRequest(purchaseOrderClientModel)));
    }

    private PurchaseOrderClientModel constructClientModel(PurchaseOrderServiceResponse purchaseOrderServiceResponse) {
        PurchaseOrderClientModel purchaseOrderClientModel = null;
        if (purchaseOrderServiceResponse != null) {
            purchaseOrderClientModel = new PurchaseOrderClientModel();
            purchaseOrderClientModel.setPurchaseOrderDTOList(purchaseOrderServiceResponse.getPurchaseOrderDTOList());
            purchaseOrderClientModel.setTotalRecords(purchaseOrderServiceResponse.getTotalRecords());
        }
        return purchaseOrderClientModel;
    }

    private PurchaseOrderServiceRequest constructServiceRequest(PurchaseOrderClientModel purchaseOrderClientModel) {
        PurchaseOrderServiceRequest purchaseOrderServiceRequest = new PurchaseOrderServiceRequest();
        purchaseOrderServiceRequest.setPurchaseOrderDTO(purchaseOrderClientModel.getPurchaseOrderDTO());
        purchaseOrderServiceRequest.setPurchaseOrderSearchDTO(purchaseOrderClientModel.getPurchaseOrderSearchDTO());
        purchaseOrderServiceRequest.setRecordstoFetch(purchaseOrderClientModel.getRecordstoFetch());
        purchaseOrderServiceRequest.setPageIndex(purchaseOrderClientModel.getPageIndex());
        return purchaseOrderServiceRequest;
    }
}
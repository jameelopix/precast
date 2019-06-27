package com.vme.precast.purchaseregister.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vme.precast.purchaseregister.api.PurchaseRegisterDTO;
import com.vme.precast.purchaseregister.api.PurchaseRegisterService;
import com.vme.precast.purchaseregister.api.PurchaseRegisterServiceRequest;
import com.vme.precast.purchaseregister.api.PurchaseRegisterServiceResponse;

@Controller
public class PurchaseRegisterController {

    @Autowired
    PurchaseRegisterService purchaseRegisterService;

    @RequestMapping(value = "deletePurchaseRegister", method = RequestMethod.POST)
    @ResponseBody
    public PurchaseRegisterClientModel deletePurchaseRegister(@RequestBody PurchaseRegisterClientModel purchaseRegisterClientModel) {
        PurchaseRegisterServiceRequest purchaseRegisterServiceRequest = new PurchaseRegisterServiceRequest();
        for (Long id : purchaseRegisterClientModel.getIdsToDelete()) {
            PurchaseRegisterDTO purchaseRegisterDTO = new PurchaseRegisterDTO();
            purchaseRegisterDTO.setId(id);
            purchaseRegisterServiceRequest.setPurchaseRegisterDTO(purchaseRegisterDTO);
            purchaseRegisterService.deletePurchaseRegister(purchaseRegisterServiceRequest);
        }
        return null;
    }

    @RequestMapping(value = "createPurchaseRegister", method = RequestMethod.POST)
    @ResponseBody
    public PurchaseRegisterClientModel createPurchaseRegister(@Valid @RequestBody PurchaseRegisterClientModel purchaseRegisterClientModel) {
        return this.constructClientModel(purchaseRegisterService.createPurchaseRegister(this.constructServiceRequest(purchaseRegisterClientModel)));
    }

    @RequestMapping(value = "updatePurchaseRegister", method = RequestMethod.POST)
    @ResponseBody
    public PurchaseRegisterClientModel updatePurchaseRegister(@Valid @RequestBody PurchaseRegisterClientModel purchaseRegisterClientModel) {
        return this.constructClientModel(purchaseRegisterService.updatePurchaseRegister(this.constructServiceRequest(purchaseRegisterClientModel)));
    }

    @RequestMapping(value = "getPurchaseRegister", method = RequestMethod.POST)
    @ResponseBody
    public PurchaseRegisterClientModel getPurchaseRegister(@RequestBody PurchaseRegisterClientModel purchaseRegisterClientModel) {
        return this.constructClientModel(purchaseRegisterService.getPurchaseRegisters(this.constructServiceRequest(purchaseRegisterClientModel)));
    }

    private PurchaseRegisterClientModel constructClientModel(PurchaseRegisterServiceResponse purchaseRegisterServiceResponse) {
        PurchaseRegisterClientModel purchaseRegisterClientModel = null;
        if (purchaseRegisterServiceResponse != null) {
            purchaseRegisterClientModel = new PurchaseRegisterClientModel();
            purchaseRegisterClientModel.setPurchaseRegisterDTOList(purchaseRegisterServiceResponse.getPurchaseRegisterDTOList());
            purchaseRegisterClientModel.setTotalRecords(purchaseRegisterServiceResponse.getTotalRecords());
        }
        return purchaseRegisterClientModel;
    }

    private PurchaseRegisterServiceRequest constructServiceRequest(PurchaseRegisterClientModel purchaseRegisterClientModel) {
        PurchaseRegisterServiceRequest purchaseRegisterServiceRequest = new PurchaseRegisterServiceRequest();
        purchaseRegisterServiceRequest.setPurchaseRegisterDTO(purchaseRegisterClientModel.getPurchaseRegisterDTO());
        purchaseRegisterServiceRequest.setPurchaseRegisterSearchDTO(purchaseRegisterClientModel.getPurchaseRegisterSearchDTO());
        purchaseRegisterServiceRequest.setRecordstoFetch(purchaseRegisterClientModel.getRecordstoFetch());
        purchaseRegisterServiceRequest.setPageIndex(purchaseRegisterClientModel.getPageIndex());
        return purchaseRegisterServiceRequest;
    }
}
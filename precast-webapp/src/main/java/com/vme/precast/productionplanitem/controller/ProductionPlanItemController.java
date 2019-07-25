package com.vme.precast.productionplanitem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vme.precast.productionplanitem.api.ProductionPlanItemDTO;
import com.vme.precast.productionplanitem.api.ProductionPlanItemService;
import com.vme.precast.productionplanitem.api.ProductionPlanItemServiceRequest;
import com.vme.precast.productionplanitem.api.ProductionPlanItemServiceResponse;

@Controller
public class ProductionPlanItemController {

    @Autowired
    ProductionPlanItemService productionPlanItemService;

    @RequestMapping(value = "deleteProductionPlanItem", method = RequestMethod.POST)
    @ResponseBody
    public ProductionPlanItemClientModel deleteProductionPlanItem(@RequestBody ProductionPlanItemClientModel productionPlanItemClientModel) {
        ProductionPlanItemServiceRequest productionPlanItemServiceRequest = new ProductionPlanItemServiceRequest();
        for (Long id : productionPlanItemClientModel.getIdsToDelete()) {
            ProductionPlanItemDTO productionPlanItemDTO = new ProductionPlanItemDTO();
            productionPlanItemDTO.setId(id);
            productionPlanItemServiceRequest.setProductionPlanItemDTO(productionPlanItemDTO);
            productionPlanItemService.deleteProductionPlanItem(productionPlanItemServiceRequest);
        }
        return null;
    }

    @RequestMapping(value = "createProductionPlanItem", method = RequestMethod.POST)
    @ResponseBody
    public ProductionPlanItemClientModel createProductionPlanItem(@Valid @RequestBody ProductionPlanItemClientModel productionPlanItemClientModel) {
        return this.constructClientModel(productionPlanItemService.createProductionPlanItem(this.constructServiceRequest(productionPlanItemClientModel)));
    }

    @RequestMapping(value = "updateProductionPlanItem", method = RequestMethod.POST)
    @ResponseBody
    public ProductionPlanItemClientModel updateProductionPlanItem(@Valid @RequestBody ProductionPlanItemClientModel productionPlanItemClientModel) {
        return this.constructClientModel(productionPlanItemService.updateProductionPlanItem(this.constructServiceRequest(productionPlanItemClientModel)));
    }

    @RequestMapping(value = "getProductionPlanItem", method = RequestMethod.POST)
    @ResponseBody
    public ProductionPlanItemClientModel getProductionPlanItem(@RequestBody ProductionPlanItemClientModel productionPlanItemClientModel) {
        return this.constructClientModel(productionPlanItemService.getProductionPlanItems(this.constructServiceRequest(productionPlanItemClientModel)));
    }

    private ProductionPlanItemClientModel constructClientModel(ProductionPlanItemServiceResponse productionPlanItemServiceResponse) {
        ProductionPlanItemClientModel productionPlanItemClientModel = null;
        if (productionPlanItemServiceResponse != null) {
            productionPlanItemClientModel = new ProductionPlanItemClientModel();
            productionPlanItemClientModel.setProductionPlanItemDTOList(productionPlanItemServiceResponse.getProductionPlanItemDTOList());
            productionPlanItemClientModel.setTotalRecords(productionPlanItemServiceResponse.getTotalRecords());
        }
        return productionPlanItemClientModel;
    }

    private ProductionPlanItemServiceRequest constructServiceRequest(ProductionPlanItemClientModel productionPlanItemClientModel) {
        ProductionPlanItemServiceRequest productionPlanItemServiceRequest = new ProductionPlanItemServiceRequest();
        productionPlanItemServiceRequest.setProductionPlanItemDTO(productionPlanItemClientModel.getProductionPlanItemDTO());
        productionPlanItemServiceRequest.setProductionPlanItemSearchDTO(productionPlanItemClientModel.getProductionPlanItemSearchDTO());
        productionPlanItemServiceRequest.setRecordstoFetch(productionPlanItemClientModel.getRecordstoFetch());
        productionPlanItemServiceRequest.setPageIndex(productionPlanItemClientModel.getPageIndex());
        return productionPlanItemServiceRequest;
    }
}
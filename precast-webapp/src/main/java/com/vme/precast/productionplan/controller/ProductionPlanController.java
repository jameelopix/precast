package com.vme.precast.productionplan.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vme.precast.productionplan.api.ProductionPlanDTO;
import com.vme.precast.productionplan.api.ProductionPlanService;
import com.vme.precast.productionplan.api.ProductionPlanServiceRequest;
import com.vme.precast.productionplan.api.ProductionPlanServiceResponse;

@Controller
public class ProductionPlanController {

    @Autowired
    ProductionPlanService productionPlanService;

    @RequestMapping(value = "deleteProductionPlan", method = RequestMethod.POST)
    @ResponseBody
    public ProductionPlanClientModel deleteProductionPlan(@RequestBody ProductionPlanClientModel productionPlanClientModel) {
        ProductionPlanServiceRequest productionPlanServiceRequest = new ProductionPlanServiceRequest();
        for (Long id : productionPlanClientModel.getIdsToDelete()) {
            ProductionPlanDTO productionPlanDTO = new ProductionPlanDTO();
            productionPlanDTO.setId(id);
            productionPlanServiceRequest.setProductionPlanDTO(productionPlanDTO);
            productionPlanService.deleteProductionPlan(productionPlanServiceRequest);
        }
        return null;
    }

    @RequestMapping(value = "createProductionPlan", method = RequestMethod.POST)
    @ResponseBody
    public ProductionPlanClientModel createProductionPlan(@Valid @RequestBody ProductionPlanClientModel productionPlanClientModel) {
        return this.constructClientModel(productionPlanService.createProductionPlan(this.constructServiceRequest(productionPlanClientModel)));
    }

    @RequestMapping(value = "updateProductionPlan", method = RequestMethod.POST)
    @ResponseBody
    public ProductionPlanClientModel updateProductionPlan(@Valid @RequestBody ProductionPlanClientModel productionPlanClientModel) {
        return this.constructClientModel(productionPlanService.updateProductionPlan(this.constructServiceRequest(productionPlanClientModel)));
    }

    @RequestMapping(value = "getProductionPlan", method = RequestMethod.POST)
    @ResponseBody
    public ProductionPlanClientModel getProductionPlan(@RequestBody ProductionPlanClientModel productionPlanClientModel) {
        return this.constructClientModel(productionPlanService.getProductionPlans(this.constructServiceRequest(productionPlanClientModel)));
    }

    private ProductionPlanClientModel constructClientModel(ProductionPlanServiceResponse productionPlanServiceResponse) {
        ProductionPlanClientModel productionPlanClientModel = null;
        if (productionPlanServiceResponse != null) {
            productionPlanClientModel = new ProductionPlanClientModel();
            productionPlanClientModel.setProductionPlanDTOList(productionPlanServiceResponse.getProductionPlanDTOList());
            productionPlanClientModel.setTotalRecords(productionPlanServiceResponse.getTotalRecords());
        }
        return productionPlanClientModel;
    }

    private ProductionPlanServiceRequest constructServiceRequest(ProductionPlanClientModel productionPlanClientModel) {
        ProductionPlanServiceRequest productionPlanServiceRequest = new ProductionPlanServiceRequest();
        productionPlanServiceRequest.setProductionPlanDTO(productionPlanClientModel.getProductionPlanDTO());
        productionPlanServiceRequest.setProductionPlanSearchDTO(productionPlanClientModel.getProductionPlanSearchDTO());
        productionPlanServiceRequest.setRecordstoFetch(productionPlanClientModel.getRecordstoFetch());
        productionPlanServiceRequest.setPageIndex(productionPlanClientModel.getPageIndex());
        return productionPlanServiceRequest;
    }
}
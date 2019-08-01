package com.vme.precast.productionplan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vme.precast.productionplan.api.ProductionPlanService;
import com.vme.precast.productionplan.api.ProductionPlanServiceRequest;
import com.vme.precast.productionplan.api.ProductionPlanServiceResponse;

@Controller
public class ProductionPlanController {

    @Autowired
    ProductionPlanService productionPlanService;

    @RequestMapping(value = "getProductionPlan", method = RequestMethod.POST)
    @ResponseBody
    public ProductionPlanClientModel getProductionPlan(
            @RequestBody ProductionPlanClientModel productionPlanClientModel) {
        return this.constructClientModel(
                productionPlanService.getProductionPlans(this.constructServiceRequest(productionPlanClientModel)));
    }

    @RequestMapping(value = "getProductionPlanDetail", method = RequestMethod.POST)
    @ResponseBody
    public ProductionPlanClientModel getProductionPlanDetail(
            @RequestBody ProductionPlanClientModel productionPlanClientModel) {
        return this.constructClientModel(
                productionPlanService.getProductionPlanDetail(this.constructServiceRequest(productionPlanClientModel)));
    }

    @RequestMapping(value = "updateProductionPlanDetail", method = RequestMethod.POST)
    @ResponseBody
    public ProductionPlanClientModel updateProductionPlanDetail(
            @RequestBody ProductionPlanClientModel productionPlanClientModel) {
        return this.constructClientModel(productionPlanService
                .updateProductionPlanDetail(this.constructServiceRequest(productionPlanClientModel)));
    }

    private ProductionPlanClientModel constructClientModel(
            ProductionPlanServiceResponse productionPlanServiceResponse) {
        ProductionPlanClientModel productionPlanClientModel = null;
        if (productionPlanServiceResponse != null) {
            productionPlanClientModel = new ProductionPlanClientModel();
            productionPlanClientModel
                    .setProductionPlanDTOList(productionPlanServiceResponse.getProductionPlanDTOList());
            productionPlanClientModel
                    .setProductionPlanItemDTO(productionPlanServiceResponse.getProductionPlanItemDTO());
            productionPlanClientModel.setTotalRecords(productionPlanServiceResponse.getTotalRecords());
        }
        return productionPlanClientModel;
    }

    private ProductionPlanServiceRequest constructServiceRequest(ProductionPlanClientModel productionPlanClientModel) {
        ProductionPlanServiceRequest productionPlanServiceRequest = new ProductionPlanServiceRequest();
        productionPlanServiceRequest.setProductionPlanDTO(productionPlanClientModel.getProductionPlanDTO());
        productionPlanServiceRequest.setProductionPlanItemDTO(productionPlanClientModel.getProductionPlanItemDTO());
        productionPlanServiceRequest.setProductionPlanSearchDTO(productionPlanClientModel.getProductionPlanSearchDTO());
        productionPlanServiceRequest.setRecordstoFetch(productionPlanClientModel.getRecordstoFetch());
        productionPlanServiceRequest.setPageIndex(productionPlanClientModel.getPageIndex());
        return productionPlanServiceRequest;
    }
}
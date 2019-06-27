package com.vme.precast.itemfreightamountdetails.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vme.precast.itemfreightamountdetails.api.ItemFreightAmountDetailsDTO;
import com.vme.precast.itemfreightamountdetails.api.ItemFreightAmountDetailsService;
import com.vme.precast.itemfreightamountdetails.api.ItemFreightAmountDetailsServiceRequest;
import com.vme.precast.itemfreightamountdetails.api.ItemFreightAmountDetailsServiceResponse;

@Controller
public class ItemFreightAmountDetailsController {

    @Autowired
    ItemFreightAmountDetailsService itemFreightAmountDetailsService;

    @RequestMapping(value = "deleteItemFreightAmountDetails", method = RequestMethod.POST)
    @ResponseBody
    public ItemFreightAmountDetailsClientModel deleteItemFreightAmountDetails(@RequestBody ItemFreightAmountDetailsClientModel itemFreightAmountDetailsClientModel) {
        ItemFreightAmountDetailsServiceRequest itemFreightAmountDetailsServiceRequest = new ItemFreightAmountDetailsServiceRequest();
        for (Long id : itemFreightAmountDetailsClientModel.getIdsToDelete()) {
            ItemFreightAmountDetailsDTO itemFreightAmountDetailsDTO = new ItemFreightAmountDetailsDTO();
            itemFreightAmountDetailsDTO.setId(id);
            itemFreightAmountDetailsServiceRequest.setItemFreightAmountDetailsDTO(itemFreightAmountDetailsDTO);
            itemFreightAmountDetailsService.deleteItemFreightAmountDetails(itemFreightAmountDetailsServiceRequest);
        }
        return null;
    }

    @RequestMapping(value = "createItemFreightAmountDetails", method = RequestMethod.POST)
    @ResponseBody
    public ItemFreightAmountDetailsClientModel createItemFreightAmountDetails(@Valid @RequestBody ItemFreightAmountDetailsClientModel itemFreightAmountDetailsClientModel) {
        return this.constructClientModel(itemFreightAmountDetailsService.createItemFreightAmountDetails(this.constructServiceRequest(itemFreightAmountDetailsClientModel)));
    }

    @RequestMapping(value = "updateItemFreightAmountDetails", method = RequestMethod.POST)
    @ResponseBody
    public ItemFreightAmountDetailsClientModel updateItemFreightAmountDetails(@Valid @RequestBody ItemFreightAmountDetailsClientModel itemFreightAmountDetailsClientModel) {
        return this.constructClientModel(itemFreightAmountDetailsService.updateItemFreightAmountDetails(this.constructServiceRequest(itemFreightAmountDetailsClientModel)));
    }

    @RequestMapping(value = "getItemFreightAmountDetails", method = RequestMethod.POST)
    @ResponseBody
    public ItemFreightAmountDetailsClientModel getItemFreightAmountDetails(@RequestBody ItemFreightAmountDetailsClientModel itemFreightAmountDetailsClientModel) {
        return this.constructClientModel(itemFreightAmountDetailsService.getItemFreightAmountDetailss(this.constructServiceRequest(itemFreightAmountDetailsClientModel)));
    }

    private ItemFreightAmountDetailsClientModel constructClientModel(ItemFreightAmountDetailsServiceResponse itemFreightAmountDetailsServiceResponse) {
        ItemFreightAmountDetailsClientModel itemFreightAmountDetailsClientModel = null;
        if (itemFreightAmountDetailsServiceResponse != null) {
            itemFreightAmountDetailsClientModel = new ItemFreightAmountDetailsClientModel();
            itemFreightAmountDetailsClientModel.setItemFreightAmountDetailsDTOList(itemFreightAmountDetailsServiceResponse.getItemFreightAmountDetailsDTOList());
            itemFreightAmountDetailsClientModel.setTotalRecords(itemFreightAmountDetailsServiceResponse.getTotalRecords());
        }
        return itemFreightAmountDetailsClientModel;
    }

    private ItemFreightAmountDetailsServiceRequest constructServiceRequest(ItemFreightAmountDetailsClientModel itemFreightAmountDetailsClientModel) {
        ItemFreightAmountDetailsServiceRequest itemFreightAmountDetailsServiceRequest = new ItemFreightAmountDetailsServiceRequest();
        itemFreightAmountDetailsServiceRequest.setItemFreightAmountDetailsDTO(itemFreightAmountDetailsClientModel.getItemFreightAmountDetailsDTO());
        itemFreightAmountDetailsServiceRequest.setItemFreightAmountDetailsSearchDTO(itemFreightAmountDetailsClientModel.getItemFreightAmountDetailsSearchDTO());
        itemFreightAmountDetailsServiceRequest.setRecordstoFetch(itemFreightAmountDetailsClientModel.getRecordstoFetch());
        itemFreightAmountDetailsServiceRequest.setPageIndex(itemFreightAmountDetailsClientModel.getPageIndex());
        return itemFreightAmountDetailsServiceRequest;
    }
}
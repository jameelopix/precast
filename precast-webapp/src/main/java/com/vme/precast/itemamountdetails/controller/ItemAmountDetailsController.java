package com.vme.precast.itemamountdetails.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vme.precast.itemamountdetails.api.ItemAmountDetailsDTO;
import com.vme.precast.itemamountdetails.api.ItemAmountDetailsService;
import com.vme.precast.itemamountdetails.api.ItemAmountDetailsServiceRequest;
import com.vme.precast.itemamountdetails.api.ItemAmountDetailsServiceResponse;

@Controller
public class ItemAmountDetailsController {

    @Autowired
    ItemAmountDetailsService itemAmountDetailsService;

    @RequestMapping(value = "deleteItemAmountDetails", method = RequestMethod.POST)
    @ResponseBody
    public ItemAmountDetailsClientModel deleteItemAmountDetails(@RequestBody ItemAmountDetailsClientModel itemAmountDetailsClientModel) {
        ItemAmountDetailsServiceRequest itemAmountDetailsServiceRequest = new ItemAmountDetailsServiceRequest();
        for (Long id : itemAmountDetailsClientModel.getIdsToDelete()) {
            ItemAmountDetailsDTO itemAmountDetailsDTO = new ItemAmountDetailsDTO();
            itemAmountDetailsDTO.setId(id);
            itemAmountDetailsServiceRequest.setItemAmountDetailsDTO(itemAmountDetailsDTO);
            itemAmountDetailsService.deleteItemAmountDetails(itemAmountDetailsServiceRequest);
        }
        return null;
    }

    @RequestMapping(value = "createItemAmountDetails", method = RequestMethod.POST)
    @ResponseBody
    public ItemAmountDetailsClientModel createItemAmountDetails(@Valid @RequestBody ItemAmountDetailsClientModel itemAmountDetailsClientModel) {
        return this.constructClientModel(itemAmountDetailsService.createItemAmountDetails(this.constructServiceRequest(itemAmountDetailsClientModel)));
    }

    @RequestMapping(value = "updateItemAmountDetails", method = RequestMethod.POST)
    @ResponseBody
    public ItemAmountDetailsClientModel updateItemAmountDetails(@Valid @RequestBody ItemAmountDetailsClientModel itemAmountDetailsClientModel) {
        return this.constructClientModel(itemAmountDetailsService.updateItemAmountDetails(this.constructServiceRequest(itemAmountDetailsClientModel)));
    }

    @RequestMapping(value = "getItemAmountDetails", method = RequestMethod.POST)
    @ResponseBody
    public ItemAmountDetailsClientModel getItemAmountDetails(@RequestBody ItemAmountDetailsClientModel itemAmountDetailsClientModel) {
        return this.constructClientModel(itemAmountDetailsService.getItemAmountDetailss(this.constructServiceRequest(itemAmountDetailsClientModel)));
    }

    private ItemAmountDetailsClientModel constructClientModel(ItemAmountDetailsServiceResponse itemAmountDetailsServiceResponse) {
        ItemAmountDetailsClientModel itemAmountDetailsClientModel = null;
        if (itemAmountDetailsServiceResponse != null) {
            itemAmountDetailsClientModel = new ItemAmountDetailsClientModel();
            itemAmountDetailsClientModel.setItemAmountDetailsDTOList(itemAmountDetailsServiceResponse.getItemAmountDetailsDTOList());
            itemAmountDetailsClientModel.setTotalRecords(itemAmountDetailsServiceResponse.getTotalRecords());
        }
        return itemAmountDetailsClientModel;
    }

    private ItemAmountDetailsServiceRequest constructServiceRequest(ItemAmountDetailsClientModel itemAmountDetailsClientModel) {
        ItemAmountDetailsServiceRequest itemAmountDetailsServiceRequest = new ItemAmountDetailsServiceRequest();
        itemAmountDetailsServiceRequest.setItemAmountDetailsDTO(itemAmountDetailsClientModel.getItemAmountDetailsDTO());
        itemAmountDetailsServiceRequest.setItemAmountDetailsSearchDTO(itemAmountDetailsClientModel.getItemAmountDetailsSearchDTO());
        itemAmountDetailsServiceRequest.setRecordstoFetch(itemAmountDetailsClientModel.getRecordstoFetch());
        itemAmountDetailsServiceRequest.setPageIndex(itemAmountDetailsClientModel.getPageIndex());
        return itemAmountDetailsServiceRequest;
    }
}
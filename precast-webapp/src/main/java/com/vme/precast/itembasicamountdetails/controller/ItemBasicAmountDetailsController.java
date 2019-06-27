package com.vme.precast.itembasicamountdetails.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vme.precast.itembasicamountdetails.api.ItemBasicAmountDetailsDTO;
import com.vme.precast.itembasicamountdetails.api.ItemBasicAmountDetailsService;
import com.vme.precast.itembasicamountdetails.api.ItemBasicAmountDetailsServiceRequest;
import com.vme.precast.itembasicamountdetails.api.ItemBasicAmountDetailsServiceResponse;

@Controller
public class ItemBasicAmountDetailsController {

    @Autowired
    ItemBasicAmountDetailsService itemBasicAmountDetailsService;

    @RequestMapping(value = "deleteItemBasicAmountDetails", method = RequestMethod.POST)
    @ResponseBody
    public ItemBasicAmountDetailsClientModel deleteItemBasicAmountDetails(@RequestBody ItemBasicAmountDetailsClientModel itemBasicAmountDetailsClientModel) {
        ItemBasicAmountDetailsServiceRequest itemBasicAmountDetailsServiceRequest = new ItemBasicAmountDetailsServiceRequest();
        for (Long id : itemBasicAmountDetailsClientModel.getIdsToDelete()) {
            ItemBasicAmountDetailsDTO itemBasicAmountDetailsDTO = new ItemBasicAmountDetailsDTO();
            itemBasicAmountDetailsDTO.setId(id);
            itemBasicAmountDetailsServiceRequest.setItemBasicAmountDetailsDTO(itemBasicAmountDetailsDTO);
            itemBasicAmountDetailsService.deleteItemBasicAmountDetails(itemBasicAmountDetailsServiceRequest);
        }
        return null;
    }

    @RequestMapping(value = "createItemBasicAmountDetails", method = RequestMethod.POST)
    @ResponseBody
    public ItemBasicAmountDetailsClientModel createItemBasicAmountDetails(@Valid @RequestBody ItemBasicAmountDetailsClientModel itemBasicAmountDetailsClientModel) {
        return this.constructClientModel(itemBasicAmountDetailsService.createItemBasicAmountDetails(this.constructServiceRequest(itemBasicAmountDetailsClientModel)));
    }

    @RequestMapping(value = "updateItemBasicAmountDetails", method = RequestMethod.POST)
    @ResponseBody
    public ItemBasicAmountDetailsClientModel updateItemBasicAmountDetails(@Valid @RequestBody ItemBasicAmountDetailsClientModel itemBasicAmountDetailsClientModel) {
        return this.constructClientModel(itemBasicAmountDetailsService.updateItemBasicAmountDetails(this.constructServiceRequest(itemBasicAmountDetailsClientModel)));
    }

    @RequestMapping(value = "getItemBasicAmountDetails", method = RequestMethod.POST)
    @ResponseBody
    public ItemBasicAmountDetailsClientModel getItemBasicAmountDetails(@RequestBody ItemBasicAmountDetailsClientModel itemBasicAmountDetailsClientModel) {
        return this.constructClientModel(itemBasicAmountDetailsService.getItemBasicAmountDetailss(this.constructServiceRequest(itemBasicAmountDetailsClientModel)));
    }

    private ItemBasicAmountDetailsClientModel constructClientModel(ItemBasicAmountDetailsServiceResponse itemBasicAmountDetailsServiceResponse) {
        ItemBasicAmountDetailsClientModel itemBasicAmountDetailsClientModel = null;
        if (itemBasicAmountDetailsServiceResponse != null) {
            itemBasicAmountDetailsClientModel = new ItemBasicAmountDetailsClientModel();
            itemBasicAmountDetailsClientModel.setItemBasicAmountDetailsDTOList(itemBasicAmountDetailsServiceResponse.getItemBasicAmountDetailsDTOList());
            itemBasicAmountDetailsClientModel.setTotalRecords(itemBasicAmountDetailsServiceResponse.getTotalRecords());
        }
        return itemBasicAmountDetailsClientModel;
    }

    private ItemBasicAmountDetailsServiceRequest constructServiceRequest(ItemBasicAmountDetailsClientModel itemBasicAmountDetailsClientModel) {
        ItemBasicAmountDetailsServiceRequest itemBasicAmountDetailsServiceRequest = new ItemBasicAmountDetailsServiceRequest();
        itemBasicAmountDetailsServiceRequest.setItemBasicAmountDetailsDTO(itemBasicAmountDetailsClientModel.getItemBasicAmountDetailsDTO());
        itemBasicAmountDetailsServiceRequest.setItemBasicAmountDetailsSearchDTO(itemBasicAmountDetailsClientModel.getItemBasicAmountDetailsSearchDTO());
        itemBasicAmountDetailsServiceRequest.setRecordstoFetch(itemBasicAmountDetailsClientModel.getRecordstoFetch());
        itemBasicAmountDetailsServiceRequest.setPageIndex(itemBasicAmountDetailsClientModel.getPageIndex());
        return itemBasicAmountDetailsServiceRequest;
    }
}
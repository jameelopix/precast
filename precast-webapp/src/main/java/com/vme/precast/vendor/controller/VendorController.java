package com.vme.precast.vendor.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vme.precast.vendor.api.VendorDTO;
import com.vme.precast.vendor.api.VendorService;
import com.vme.precast.vendor.api.VendorServiceRequest;
import com.vme.precast.vendor.api.VendorServiceResponse;

@Controller
public class VendorController {

    @Autowired
    VendorService vendorService;

    @RequestMapping(value = "deleteVendor", method = RequestMethod.POST)
    @ResponseBody
    public VendorClientModel deleteVendor(@RequestBody VendorClientModel vendorClientModel) {
        VendorServiceRequest vendorServiceRequest = new VendorServiceRequest();
        for (Long id : vendorClientModel.getIdsToDelete()) {
            VendorDTO vendorDTO = new VendorDTO();
            vendorDTO.setId(id);
            vendorServiceRequest.setVendorDTO(vendorDTO);
            vendorService.deleteVendor(vendorServiceRequest);
        }
        return null;
    }

    @RequestMapping(value = "createVendor", method = RequestMethod.POST)
    @ResponseBody
    public VendorClientModel createVendor(@Valid @RequestBody VendorClientModel vendorClientModel) {
        return this.constructWidgetModel(vendorService.createVendor(this.constructServiceRequest(vendorClientModel)));
    }

    @RequestMapping(value = "updateVendor", method = RequestMethod.POST)
    @ResponseBody
    public VendorClientModel updateVendor(@Valid @RequestBody VendorClientModel vendorClientModel) {
        return this.constructWidgetModel(vendorService.updateVendor(this.constructServiceRequest(vendorClientModel)));
    }

    @RequestMapping(value = "getVendor", method = RequestMethod.POST)
    @ResponseBody
    public VendorClientModel getVendor(@RequestBody VendorClientModel vendorClientModel) {
        return this.constructWidgetModel(vendorService.getVendors(this.constructServiceRequest(vendorClientModel)));
    }

    private VendorClientModel constructWidgetModel(VendorServiceResponse serviceResponse) {
        VendorClientModel vendorClientModel = null;
        if (serviceResponse != null) {
            vendorClientModel = new VendorClientModel();
            vendorClientModel.setVendorDTOList(serviceResponse.getVendorDTOList());
            vendorClientModel.setTotalRecords(serviceResponse.getTotalRecords());
        }
        return vendorClientModel;
    }

    private VendorServiceRequest constructServiceRequest(VendorClientModel vendorClientModel) {
        VendorServiceRequest vendorServiceRequest = new VendorServiceRequest();
        vendorServiceRequest.setVendorDTO(vendorClientModel.getVendorDTO());
        vendorServiceRequest.setVendorSearchDTO(vendorClientModel.getVendorSearchDTO());
        vendorServiceRequest.setRecordstoFetch(vendorClientModel.getRecordstoFetch());
        vendorServiceRequest.setPageIndex(vendorClientModel.getPageIndex());
        return vendorServiceRequest;
    }
}

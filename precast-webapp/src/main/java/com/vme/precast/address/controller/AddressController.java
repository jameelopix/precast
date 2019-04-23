package com.vme.precast.address.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vme.precast.address.api.AddressDTO;
import com.vme.precast.address.api.AddressService;
import com.vme.precast.address.api.AddressServiceRequest;
import com.vme.precast.address.api.AddressServiceResponse;

@Controller
public class AddressController {

	@Autowired
	AddressService addressService;

	@RequestMapping(value = "deleteAddress", method = RequestMethod.POST)
	@ResponseBody
	public AddressClientModel deleteAddress(@RequestBody AddressClientModel addressClientModel) {
		AddressServiceRequest addressServiceRequest = new AddressServiceRequest();
		for (Long id : addressClientModel.getIdsToDelete()) {
			AddressDTO addressDTO = new AddressDTO();
			addressDTO.setId(id);
			addressServiceRequest.setAddressDTO(addressDTO);
			addressService.deleteAddress(addressServiceRequest);
		}
		return null;
	}

	@RequestMapping(value = "createAddress", method = RequestMethod.POST)
	@ResponseBody
	public AddressClientModel createAddress(@Valid @RequestBody AddressClientModel addressClientModel) {
		return this
				.constructWidgetModel(addressService.createAddress(this.constructServiceRequest(addressClientModel)));
	}

	@RequestMapping(value = "updateAddress", method = RequestMethod.POST)
	@ResponseBody
	public AddressClientModel updateAddress(@Valid @RequestBody AddressClientModel addressClientModel) {
		return this
				.constructWidgetModel(addressService.updateAddress(this.constructServiceRequest(addressClientModel)));
	}

	@RequestMapping(value = "getAddress", method = RequestMethod.POST)
	@ResponseBody
	public AddressClientModel getAddress(@RequestBody AddressClientModel addressClientModel) {
		return this.constructWidgetModel(addressService.getAddresss(this.constructServiceRequest(addressClientModel)));
	}

	private AddressClientModel constructWidgetModel(AddressServiceResponse serviceResponse) {
		AddressClientModel addressClientModel = null;
		if (serviceResponse != null) {
			addressClientModel = new AddressClientModel();
			addressClientModel.setAddressDTOList(serviceResponse.getAddressDTOList());
			addressClientModel.setTotalRecords(serviceResponse.getTotalRecords());
		}
		return addressClientModel;
	}

	private AddressServiceRequest constructServiceRequest(AddressClientModel addressClientModel) {
		AddressServiceRequest addressServiceRequest = new AddressServiceRequest();
		addressServiceRequest.setAddressDTO(addressClientModel.getAddressDTO());
		addressServiceRequest.setAddressSearchDTO(addressClientModel.getAddressSearchDTO());
		addressServiceRequest.setRecordstoFetch(addressClientModel.getRecordstoFetch());
		addressServiceRequest.setPageIndex(addressClientModel.getPageIndex());
		return addressServiceRequest;
	}
}

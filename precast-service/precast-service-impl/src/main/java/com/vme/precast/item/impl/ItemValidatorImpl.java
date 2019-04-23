package com.vme.precast.item.impl;

import org.springframework.stereotype.Component;

import com.vme.precast.item.api.ItemServiceRequest;
import com.vme.precast.item.api.ItemValidator;

import coliseum.service.ErrorDTO;

@Component
public class ItemValidatorImpl implements ItemValidator {

	@Override
	public ErrorDTO checkItemDuplicate(ItemServiceRequest itemServiceRequest) {
		// TODO Auto-generated method stub
		return null;
	}
}

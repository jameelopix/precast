package com.vme.precast.element.impl;

import com.vme.precast.element.api.ElementServiceRequest;
import com.vme.precast.element.api.ElementValidator;

import coliseum.service.ErrorDTO;

public class ElementValidatorImpl implements ElementValidator {

	@Override
	public ErrorDTO checkElementDuplicate(ElementServiceRequest elementServiceRequest) {
		System.out.println("ElementValidatorImpl.checkElementDuplicate()");
		return null;
	}
}

package com.vme.precast.dcregister.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.dcregister.api.DCRegisterDTO;
import com.vme.precast.dcregister.api.DCRegisterSearchDTO;
import com.vme.precast.dcregister.api.DCRegisterServiceRequest;
import com.vme.precast.dcregister.api.DCRegisterValidator;
import com.vme.precast.domain.DCRegister;
import com.vme.precast.repository.DCRegisterRepo;

import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;
import coliseum.service.ErrorDTO;
import coliseum.service.FilterUtils;

public class DCRegisterValidatorImpl implements DCRegisterValidator {
    @Autowired
    DCRegisterRepo dCRegisterRepo;

    @Override
    public ErrorDTO checkDCRegisterDuplicate(DCRegisterServiceRequest dCRegisterServiceRequest) {
        ErrorDTO errorDTO = null;
        DCRegisterDTO dCRegisterDTO = dCRegisterServiceRequest.getDCRegisterDTO();

        SearchObject searchObject = new SearchObject();
        List<Filter> filters = new ArrayList<>();
        FilterUtils.createEqualFilter(filters, DCRegisterSearchDTO.VENDORID, dCRegisterDTO.getVendorId());
        FilterUtils.createEqualFilter(filters, DCRegisterSearchDTO.DCNO, dCRegisterDTO.getDcNo());
        if (CollectionUtils.isNotEmpty(filters)) {
            searchObject.setFilters(filters);
        }
        List<DCRegister> dCRegisterList = dCRegisterRepo.search(searchObject);

        if (CollectionUtils.isNotEmpty(dCRegisterList)) {
            for (DCRegister dCRegister : dCRegisterList) {
                if (!dCRegister.getId().equals(dCRegisterDTO.getId())) {
                    errorDTO = new ErrorDTO("ERR_DC_100", "DCNO already exists!!!");
                    break;
                }
            }
        }
        return errorDTO;
    }
}
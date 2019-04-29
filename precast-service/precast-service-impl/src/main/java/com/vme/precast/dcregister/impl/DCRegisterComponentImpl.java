package com.vme.precast.dcregister.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.domain.DCRegister;
import com.vme.precast.repository.DCRegisterRepo;
import com.vme.precast.dcregister.api.DCRegisterComponent;
import com.vme.precast.dcregister.api.DCRegisterDTO;
import com.vme.precast.dcregister.api.DCRegisterSearchDTO;
import com.vme.precast.dcregister.api.DCRegisterServiceRequest;
import com.vme.precast.dcregister.api.DCRegisterServiceResponse;

import coliseum.jpa.Association;
import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;
import coliseum.service.ConversionUtility;
import coliseum.service.FilterUtils;

public class DCRegisterComponentImpl implements DCRegisterComponent {
    @Autowired
    DCRegisterRepo dCRegisterRepo;

    @Autowired
    ConversionUtility conversionUtility;

    @Override
    public DCRegisterServiceResponse createDCRegister(DCRegisterServiceRequest dCRegisterServiceRequest) {
        DCRegisterDTO dCRegisterDTO = dCRegisterServiceRequest.getDCRegisterDTO();
        DCRegister dcregister = (DCRegister) conversionUtility.convert(dCRegisterDTO, DCRegisterDTO.class,
                DCRegister.class);
        dCRegisterRepo.save(dcregister);
        return null;
    }

    @Override
    public DCRegisterServiceResponse getDCRegisters(DCRegisterServiceRequest dCRegisterServiceRequest) {
        List<DCRegister> dCRegisterList = new ArrayList<>();
        List<Filter> filters = new ArrayList<>();
        List<Association> associations = new ArrayList<>();
        SearchObject searchObject = new SearchObject();

        DCRegisterSearchDTO dCRegisterSearchDTO = dCRegisterServiceRequest.getDCRegisterSearchDTO();
        if (dCRegisterSearchDTO != null) {
            List<Long> idList = dCRegisterSearchDTO.getIdList();
            List<String> dcNoList = dCRegisterSearchDTO.getDcNoList();
            List<String> grnNoList = dCRegisterSearchDTO.getGrnNoList();
            List<Long> vendorIdList = dCRegisterSearchDTO.getVendorIdList();

            FilterUtils.createEqualFilter(filters, DCRegisterSearchDTO.ID, idList);
            FilterUtils.createEqualFilter(filters, DCRegisterSearchDTO.DCNO, dcNoList);
            FilterUtils.createEqualFilter(filters, DCRegisterSearchDTO.GRNNO, grnNoList);
            FilterUtils.createEqualFilter(filters, DCRegisterSearchDTO.VENDORID, vendorIdList);

            if (CollectionUtils.isNotEmpty(filters)) {
                searchObject.setFilters(filters);
            }

            if (dCRegisterSearchDTO.getVendorNeeded()) {
                Association vendorAssociation = new Association();
                vendorAssociation.setFieldName(DCRegisterSearchDTO.VENDOR);
                associations.add(vendorAssociation);
            }

            if (CollectionUtils.isNotEmpty(associations)) {
                searchObject.setAssociations(associations);
            }
        }
        searchObject.setPageIndex(dCRegisterServiceRequest.getPageIndex());
        searchObject.setRecordstoFetch(dCRegisterServiceRequest.getRecordstoFetch());
        dCRegisterList = dCRegisterRepo.search(searchObject);

        List<DCRegisterDTO> dCRegisterDTOList = new ArrayList<>();
        for (DCRegister target : dCRegisterList) {
            dCRegisterDTOList
                    .add((DCRegisterDTO) conversionUtility.convert(target, DCRegister.class, DCRegisterDTO.class));
        }
        DCRegisterServiceResponse dCRegisterServiceResponse = new DCRegisterServiceResponse();
        dCRegisterServiceResponse.setDCRegisterDTOList(dCRegisterDTOList);
        return dCRegisterServiceResponse;
    }

    @Override
    public DCRegisterServiceResponse updateDCRegister(DCRegisterServiceRequest dCRegisterServiceRequest) {
        DCRegisterDTO source = dCRegisterServiceRequest.getDCRegisterDTO();

        DCRegister target = dCRegisterRepo.findById(source.getId()).get();
        target.setDcNo(source.getDcNo());
        target.setGrnNo(source.getGrnNo());
        target.setVendorId(source.getVendorId());

        dCRegisterRepo.save(target);
        return null;
    }

    @Override
    public DCRegisterServiceResponse deleteDCRegister(DCRegisterServiceRequest dCRegisterServiceRequest) {
        DCRegisterDTO dCRegisterDTO = dCRegisterServiceRequest.getDCRegisterDTO();
        dCRegisterRepo.deleteById(dCRegisterDTO.getId());
        return null;
    }
}
package com.vme.precast.partymaster.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.domain.PartyMaster;
import com.vme.precast.partymaster.api.PartyMasterComponent;
import com.vme.precast.partymaster.api.PartyMasterDTO;
import com.vme.precast.partymaster.api.PartyMasterSearchDTO;
import com.vme.precast.partymaster.api.PartyMasterServiceRequest;
import com.vme.precast.partymaster.api.PartyMasterServiceResponse;
import com.vme.precast.repository.PartyMasterRepo;

import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;
import coliseum.service.ConversionUtility;
import coliseum.service.FilterUtils;

public class PartyMasterComponentImpl implements PartyMasterComponent {
    @Autowired
    PartyMasterRepo partyMasterRepo;

    @Autowired
    ConversionUtility conversionUtility;

    @Override
    public PartyMasterServiceResponse createPartyMaster(PartyMasterServiceRequest partyMasterServiceRequest) {
        PartyMasterDTO partyMasterDTO = partyMasterServiceRequest.getPartyMasterDTO();
        PartyMaster partymaster = (PartyMaster) conversionUtility.convert(partyMasterDTO, PartyMasterDTO.class,
                PartyMaster.class);
        partyMasterRepo.save(partymaster);
        return null;
    }

    @Override
    public PartyMasterServiceResponse getPartyMasters(PartyMasterServiceRequest partyMasterServiceRequest) {
        List<PartyMaster> partyMasterList = new ArrayList<>();
        List<Filter> filters = new ArrayList<>();
        SearchObject searchObject = new SearchObject();

        PartyMasterSearchDTO partyMasterSearchDTO = partyMasterServiceRequest.getPartyMasterSearchDTO();
        if (partyMasterSearchDTO != null) {
            List<Long> ids = partyMasterSearchDTO.getIdList();
            List<String> nameList = partyMasterSearchDTO.getNameList();
            List<String> typeList = partyMasterSearchDTO.getTypeList();

            FilterUtils.createEqualFilter(filters, PartyMasterSearchDTO.ID, ids);
            FilterUtils.createEqualFilter(filters, PartyMasterSearchDTO.NAME, nameList);
            FilterUtils.createEqualFilter(filters, PartyMasterSearchDTO.TYPE, typeList);

            if (CollectionUtils.isNotEmpty(filters)) {
                searchObject.setFilters(filters);
            }
        }
        searchObject.setPageIndex(partyMasterServiceRequest.getPageIndex());
        searchObject.setRecordstoFetch(partyMasterServiceRequest.getRecordstoFetch());
        partyMasterList = partyMasterRepo.search(searchObject);

        List<PartyMasterDTO> partyMasterDTOList = new ArrayList<>();
        for (PartyMaster target : partyMasterList) {
            partyMasterDTOList
                    .add((PartyMasterDTO) conversionUtility.convert(target, PartyMaster.class, PartyMasterDTO.class));
        }
        PartyMasterServiceResponse partyMasterServiceResponse = new PartyMasterServiceResponse();
        partyMasterServiceResponse.setPartyMasterDTOList(partyMasterDTOList);
        return partyMasterServiceResponse;
    }

    @Override
    public PartyMasterServiceResponse updatePartyMaster(PartyMasterServiceRequest partyMasterServiceRequest) {
        PartyMasterDTO source = partyMasterServiceRequest.getPartyMasterDTO();

        PartyMaster target = partyMasterRepo.findById(source.getId()).get();
        target.setName(source.getName());
        target.setType(source.getType());

        partyMasterRepo.save(target);
        return null;
    }

    @Override
    public PartyMasterServiceResponse deletePartyMaster(PartyMasterServiceRequest partyMasterServiceRequest) {
        PartyMasterDTO partyMasterDTO = partyMasterServiceRequest.getPartyMasterDTO();
        partyMasterRepo.deleteById(partyMasterDTO.getId());
        return null;
    }
}
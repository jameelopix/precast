package com.vme.precast.mixture.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.domain.Mixture;
import com.vme.precast.mixture.api.MixtureComponent;
import com.vme.precast.mixture.api.MixtureDTO;
import com.vme.precast.mixture.api.MixtureSearchDTO;
import com.vme.precast.mixture.api.MixtureServiceRequest;
import com.vme.precast.mixture.api.MixtureServiceResponse;
import com.vme.precast.repository.MixtureRepo;

import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;
import coliseum.service.ConversionUtility;
import coliseum.service.FilterUtils;

public class MixtureComponentImpl implements MixtureComponent {
    @Autowired
    MixtureRepo mixtureRepo;

    @Autowired
    ConversionUtility conversionUtility;

    @Override
    public MixtureServiceResponse createMixture(MixtureServiceRequest mixtureServiceRequest) {
        MixtureDTO mixtureDTO = mixtureServiceRequest.getMixtureDTO();
        Mixture mixture = (Mixture) conversionUtility.convert(mixtureDTO, MixtureDTO.class, Mixture.class);
        mixtureRepo.save(mixture);
        return null;
    }

    @Override
    public MixtureServiceResponse getMixtures(MixtureServiceRequest mixtureServiceRequest) {
        List<Mixture> mixtureList = new ArrayList<>();
        List<Filter> filters = new ArrayList<>();
        SearchObject searchObject = new SearchObject();

        MixtureSearchDTO mixtureSearchDTO = mixtureServiceRequest.getMixtureSearchDTO();
        if (mixtureSearchDTO != null) {
            List<Long> ids = mixtureSearchDTO.getIdList();
            List<String> nameList = mixtureSearchDTO.getNameList();

            FilterUtils.createEqualFilter(filters, MixtureSearchDTO.ID, ids);
            FilterUtils.createEqualFilter(filters, MixtureSearchDTO.NAME, nameList);

            if (CollectionUtils.isNotEmpty(filters)) {
                searchObject.setFilters(filters);
            }
        }
        searchObject.setPageIndex(mixtureServiceRequest.getPageIndex());
        searchObject.setRecordstoFetch(mixtureServiceRequest.getRecordstoFetch());
        mixtureList = mixtureRepo.search(searchObject);

        List<MixtureDTO> mixtureDTOList = new ArrayList<>();
        for (Mixture target : mixtureList) {
            mixtureDTOList.add((MixtureDTO) conversionUtility.convert(target, Mixture.class, MixtureDTO.class));
        }
        MixtureServiceResponse mixtureServiceResponse = new MixtureServiceResponse();
        mixtureServiceResponse.setMixtureDTOList(mixtureDTOList);
        return mixtureServiceResponse;
    }

    @Override
    public MixtureServiceResponse updateMixture(MixtureServiceRequest mixtureServiceRequest) {
        MixtureDTO source = mixtureServiceRequest.getMixtureDTO();

        Mixture target = mixtureRepo.findById(source.getId()).get();
        target.setName(source.getName());

        mixtureRepo.save(target);
        return null;
    }

    @Override
    public MixtureServiceResponse deleteMixture(MixtureServiceRequest mixtureServiceRequest) {
        MixtureDTO mixtureDTO = mixtureServiceRequest.getMixtureDTO();
        mixtureRepo.deleteById(mixtureDTO.getId());
        return null;
    }
}
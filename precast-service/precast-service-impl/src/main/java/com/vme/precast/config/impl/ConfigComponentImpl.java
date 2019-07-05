package com.vme.precast.config.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.vme.precast.config.api.ConfigComponent;
import com.vme.precast.config.api.ConfigServiceRequest;
import com.vme.precast.config.api.ConfigServiceResponse;
import com.vme.precast.domain.Config;
import com.vme.precast.domain.ListConfig;
import com.vme.precast.domain.MapConfig;
import com.vme.precast.repository.ConfigRepo;
import com.vme.precast.repository.ListConfigRepo;
import com.vme.precast.repository.MapConfigRepo;

import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;
import coliseum.service.FilterUtils;

public class ConfigComponentImpl implements ConfigComponent {

    private static final String CODE = "code";

    @Autowired
    ConfigRepo configRepo;

    @Autowired
    ListConfigRepo listConfigRepo;

    @Autowired
    MapConfigRepo mapConfigRepo;

    @Override
    public ConfigServiceResponse getConfig(ConfigServiceRequest serviceRequest) {
        String code = serviceRequest.getCode();
        List<Filter> filters = new ArrayList<>();
        SearchObject searchObject = new SearchObject();

        FilterUtils.createEqualFilter(filters, CODE, code);

        if (!CollectionUtils.isEmpty(filters)) {
            searchObject.setFilters(filters);
        }

        List<Config> configList = configRepo.search(searchObject);
        String configValue = null;

        if (!CollectionUtils.isEmpty(configList)) {
            configValue = configList.get(0).getValue();
        }

        ConfigServiceResponse configServiceResponse = new ConfigServiceResponse();
        configServiceResponse.setCode(code);
        configServiceResponse.setValue(configValue);
        return configServiceResponse;
    }

    @Override
    public ConfigServiceResponse getConfigList(ConfigServiceRequest serviceRequest) {
        String code = serviceRequest.getCode();
        List<Filter> filters = new ArrayList<>();
        SearchObject searchObject = new SearchObject();

        FilterUtils.createEqualFilter(filters, CODE, code);

        if (!CollectionUtils.isEmpty(filters)) {
            searchObject.setFilters(filters);
        }

        List<ListConfig> listConfigs = listConfigRepo.search(searchObject);

        List<String> values = new ArrayList<>();
        for (ListConfig listConfig : listConfigs) {
            values.add(listConfig.getValue());
        }

        ConfigServiceResponse configServiceResponse = new ConfigServiceResponse();
        configServiceResponse.setCode(code);
        configServiceResponse.setValues(values);
        return configServiceResponse;
    }

    @Override
    public ConfigServiceResponse getConfigMap(ConfigServiceRequest serviceRequest) {
        String code = serviceRequest.getCode();
        List<Filter> filters = new ArrayList<>();
        SearchObject searchObject = new SearchObject();

        FilterUtils.createEqualFilter(filters, CODE, code);

        if (!CollectionUtils.isEmpty(filters)) {
            searchObject.setFilters(filters);
        }

        List<MapConfig> mapConfigs = mapConfigRepo.search(searchObject);

        Map<String, String> mapValues = new HashMap<>();
        for (MapConfig mapConfig : mapConfigs) {
            mapValues.put(mapConfig.getKey(), mapConfig.getValue());
        }

        ConfigServiceResponse configServiceResponse = new ConfigServiceResponse();
        configServiceResponse.setCode(code);
        configServiceResponse.setMapValues(mapValues);
        return configServiceResponse;
    }
}
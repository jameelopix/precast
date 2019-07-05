package com.vme.precast.config.api;

import coliseum.service.BaseService;
import coliseum.service.FlowDescriptor;

public interface ConfigService extends BaseService {

    @FlowDescriptor(flow = "getConfig", request = "configServiceRequest", response = "configServiceResponse")
    public ConfigServiceResponse getConfig(ConfigServiceRequest configServiceRequest);

    @FlowDescriptor(flow = "getConfigList", request = "configServiceRequest", response = "configServiceResponse")
    public ConfigServiceResponse getConfigList(ConfigServiceRequest configServiceRequest);

    @FlowDescriptor(flow = "getConfigMap", request = "configServiceRequest", response = "configServiceResponse")
    public ConfigServiceResponse getConfigMap(ConfigServiceRequest configServiceRequest);
}
package com.vme.precast.config.api;

import coliseum.service.ColiseumInterface;

public interface ConfigComponent extends ColiseumInterface {

    public ConfigServiceResponse getConfig(ConfigServiceRequest serviceRequest);

    public ConfigServiceResponse getConfigList(ConfigServiceRequest serviceRequest);

    public ConfigServiceResponse getConfigMap(ConfigServiceRequest serviceRequest);
}

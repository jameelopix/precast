package com.vme.precast.config.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vme.precast.config.api.ConfigService;
import com.vme.precast.config.api.ConfigServiceRequest;
import com.vme.precast.config.api.ConfigServiceResponse;

@Controller
public class ConfigController {

    @Autowired
    ConfigService configService;

    @RequestMapping(value = "getConfig", method = RequestMethod.POST)
    @ResponseBody
    public ConfigWidgetModel getConfig(@RequestBody ConfigWidgetModel widgetModel) {
        return this.constructWidgetModel(configService.getConfig(this.constructServiceRequest(widgetModel)));
    }

    @RequestMapping(value = "getConfigList", method = RequestMethod.POST)
    @ResponseBody
    public ConfigWidgetModel getConfigList(@RequestBody ConfigWidgetModel widgetModel) {
        return this.constructWidgetModel(configService.getConfigList(this.constructServiceRequest(widgetModel)));
    }

    @RequestMapping(value = "getConfigMap", method = RequestMethod.POST)
    @ResponseBody
    public ConfigWidgetModel getConfigMap(@RequestBody ConfigWidgetModel widgetModel) {
        return this.constructWidgetModel(configService.getConfigMap(this.constructServiceRequest(widgetModel)));
    }

    private ConfigWidgetModel constructWidgetModel(ConfigServiceResponse serviceResponse) {
        ConfigWidgetModel widgetModel = new ConfigWidgetModel();
        widgetModel.setValue(serviceResponse.getValue());
        widgetModel.setValues(serviceResponse.getValues());
        widgetModel.setMapValues(serviceResponse.getMapValues());
        return widgetModel;
    }

    private ConfigServiceRequest constructServiceRequest(ConfigWidgetModel widgetModel) {
        ConfigServiceRequest serviceRequest = new ConfigServiceRequest();
        serviceRequest.setCode(widgetModel.getCode());
        return serviceRequest;
    }
}
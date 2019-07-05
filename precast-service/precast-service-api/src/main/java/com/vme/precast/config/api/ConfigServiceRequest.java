package com.vme.precast.config.api;

import coliseum.service.BaseServiceRequest;

public class ConfigServiceRequest extends BaseServiceRequest {

    private static final long serialVersionUID = 1L;

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
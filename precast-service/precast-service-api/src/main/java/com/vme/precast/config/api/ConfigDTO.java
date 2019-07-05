package com.vme.precast.config.api;

import java.util.List;
import java.util.Map;

import coliseum.service.BaseDTO;

public class ConfigDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;

    private String code;

    private String value;

    private List<String> values;

    private Map<String, String> mapValues;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    public Map<String, String> getMapValues() {
        return mapValues;
    }

    public void setMapValues(Map<String, String> mapValues) {
        this.mapValues = mapValues;
    }

}
package com.vme.precast.element.api;

import java.util.List;

import coliseum.service.BaseServiceResponse;

public class ElementServiceResponse extends BaseServiceResponse {

    private static final long serialVersionUID = 1L;

    private List<ElementDTO> elementDTOList;

    private ElementDTO elementDTO;

    public List<ElementDTO> getElementDTOList() {
        return elementDTOList;
    }

    public void setElementDTOList(List<ElementDTO> elementDTOList) {
        this.elementDTOList = elementDTOList;
    }

    public ElementDTO getElementDTO() {
        return elementDTO;
    }

    public void setElementDTO(ElementDTO elementDTO) {
        this.elementDTO = elementDTO;
    }
}
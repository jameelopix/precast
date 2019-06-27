package com.vme.precast.steeldetails.api;

import coliseum.service.BaseServiceRequest;

public class SteelDetailsServiceRequest extends BaseServiceRequest {

 private static final long serialVersionUID = 1L;

 private SteelDetailsDTO steelDetailsDTO;

 private SteelDetailsSearchDTO steelDetailsSearchDTO;

 public SteelDetailsDTO getSteelDetailsDTO() {
 return steelDetailsDTO;
 }

 public void setSteelDetailsDTO(SteelDetailsDTO steelDetailsDTO) {
 this.steelDetailsDTO = steelDetailsDTO;
 }

 public SteelDetailsSearchDTO getSteelDetailsSearchDTO() {
 return steelDetailsSearchDTO;
 }

 public void setSteelDetailsSearchDTO(SteelDetailsSearchDTO steelDetailsSearchDTO) {
 this.steelDetailsSearchDTO = steelDetailsSearchDTO;
 }
}

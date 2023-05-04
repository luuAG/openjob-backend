package com.openjob.controller.shared.controller;

import com.openjob.constant.SuccessMessage;
import com.openjob.controller.shared.response.ResponseDTO;
import com.openjob.controller.shared.response.ResponseGenerator;
import com.openjob.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/location")
@RequiredArgsConstructor
public class LocationController  {
    private final LocationService locationService;

    @GetMapping("/province")
    public ResponseEntity<ResponseDTO> getProvinces(){
        return ResponseGenerator.generate(
                HttpStatus.OK.value(),
                Boolean.TRUE,
                SuccessMessage.FIND_ENTITY_SUCCESS,
                locationService.getProvinces()
        );
    }
    @GetMapping("/district/by-province/{province}")
    public ResponseEntity<ResponseDTO> getProvinces(@PathVariable String province){
        return ResponseGenerator.generate(
                HttpStatus.OK.value(),
                Boolean.TRUE,
                SuccessMessage.FIND_ENTITY_SUCCESS,
                locationService.getDistrictsByProvinceName(province)
        );
    }
    @GetMapping("/ward/by-province/{province}/by-district/{district}")
    public ResponseEntity<ResponseDTO> getProvinces(@PathVariable String province, @PathVariable String district){
        return ResponseGenerator.generate(
                HttpStatus.OK.value(),
                Boolean.TRUE,
                SuccessMessage.FIND_ENTITY_SUCCESS,
                locationService.getWardsByProvinceAndDistrict(province, district)
        );
    }
}

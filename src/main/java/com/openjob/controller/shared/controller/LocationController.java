package com.openjob.controller.shared.controller;

import com.openjob.model.dto.LocationDTO;
import com.openjob.model.entity.Location;
import com.openjob.model.mapper.LocationMapper;
import com.openjob.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/location")
@RequiredArgsConstructor
public class LocationController extends BaseController<Location, LocationDTO> {
    private final LocationService locationService;
    private final LocationMapper locationMapper;
    @Override
    public void init() {
        service = this.locationService;
        mapper = this.locationMapper;
    }
}

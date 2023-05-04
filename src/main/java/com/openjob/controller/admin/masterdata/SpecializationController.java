package com.openjob.controller.admin.masterdata;

import com.openjob.controller.shared.controller.BaseController;
import com.openjob.model.dto.shared.SpecializationDTO;
import com.openjob.model.entity.Specialization;
import com.openjob.model.mapper.SpecializationMapper;
import com.openjob.service.SpecializationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/specialization")
@RequiredArgsConstructor
public class SpecializationController extends BaseController<Specialization, SpecializationDTO> {
    private final SpecializationService specializationService;
    private final SpecializationMapper specializationMapper;
    @Override
    public void init() {
        service = this.specializationService;
        mapper = this.specializationMapper;
    }
}

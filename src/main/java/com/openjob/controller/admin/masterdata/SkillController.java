package com.openjob.controller.admin.masterdata;

import com.openjob.controller.shared.BaseController;
import com.openjob.model.dto.shared.SkillDTO;
import com.openjob.model.entity.Skill;
import com.openjob.model.mapper.SkillMapper;
import com.openjob.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/skill")
@RequiredArgsConstructor
public class SkillController extends BaseController<Skill, SkillDTO> {
    private final SkillService skillService;
    private final SkillMapper skillMapper;
    @Override
    public void init() {
        service = this.skillService;
        mapper = this.skillMapper;
    }
}

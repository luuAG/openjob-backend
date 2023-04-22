package com.openjob.controller.admin.candidate;

import com.openjob.controller.shared.controller.BaseController;
import com.openjob.model.dto.CandidateDTO;
import com.openjob.model.entity.Candidate;
import com.openjob.model.mapper.CandidateMapper;
import com.openjob.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/candidate")
@RequiredArgsConstructor
public class CandidateController extends BaseController<Candidate, CandidateDTO> {
    private final CandidateService candidateService;
    private final CandidateMapper candidateMapper;

    @Override
    public void init() {
        service = this.candidateService;
        mapper = this.candidateMapper;
    }
}

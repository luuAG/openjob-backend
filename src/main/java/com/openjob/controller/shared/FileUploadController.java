package com.openjob.controller.shared;

import com.openjob.constant.SuccessMessage;
import com.openjob.controller.shared.response.ResponseDTO;
import com.openjob.controller.shared.response.ResponseGenerator;
import com.openjob.model.dto.shared.FileUploadDTO;
import com.openjob.model.entity.Candidate;
import com.openjob.model.entity.Company;
import com.openjob.service.CandidateService;
import com.openjob.service.CompanyService;
import com.openjob.util.CloudinaryUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
public class FileUploadController {
    private final CloudinaryUtils cloudinaryUtils;
    private final CompanyService companyService;
    private final CandidateService candidateService;

    @PostMapping("/upload-avatar")
    public ResponseEntity<ResponseDTO> uploadUserAvatar(@ModelAttribute FileUploadDTO dto) throws IOException {
        // upload to cloudinary
        String returnUrl = cloudinaryUtils.upload(
                dto.getFile(),
                dto.getCategory().name().toLowerCase() + "/" +dto.getObjectId());
        // update avatarURL
        if (Objects.nonNull(returnUrl)){
            switch (dto.getCategory()){
                case COMPANY -> {
                    Company company = companyService.getById(dto.getObjectId());
                    company.setAvatarUrl(returnUrl);
                    companyService.saveUpdate(company, company.getId());
                }
                case CANDIDATE -> {
                    Candidate candidate = candidateService.getById(dto.getObjectId());
                    candidate.setAvatarUrl(returnUrl);
                    candidateService.saveUpdate(candidate, candidate.getId());
                }
            }
        }
        Map<String, String> returnObject = new HashMap<>();
        returnObject.put("url", returnUrl);
        return ResponseGenerator.generate(
                HttpStatus.OK.value(),
                Boolean.TRUE,
                SuccessMessage.UPDATE_ENTITY_SUCCESS,
                returnObject
        );
    }
}

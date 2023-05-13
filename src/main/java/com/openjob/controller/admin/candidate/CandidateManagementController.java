package com.openjob.controller.admin.candidate;

import com.openjob.constant.SuccessMessage;
import com.openjob.controller.shared.response.ResponseDTO;
import com.openjob.controller.shared.response.ResponseGenerator;
import com.openjob.model.dto.shared.CandidateDTO;
import com.openjob.model.mapper.CandidateMapper;
import com.openjob.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@RestController
@RequestMapping("/admin/candidate")
@RequiredArgsConstructor
public class CandidateManagementController {
    private final CandidateService candidateService;
    private final CandidateMapper candidateMapper;

    @GetMapping
    public ResponseEntity<ResponseDTO> getAllWithQuery(HttpServletRequest request) {
        return ResponseGenerator.generate(
                HttpStatus.OK.value(),
                Boolean.TRUE,
                SuccessMessage.FIND_ENTITY_SUCCESS,
                candidateService.getAll(request.getQueryString())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getById(@PathVariable String id) {
        return ResponseGenerator.generate(
                HttpStatus.OK.value(),
                Boolean.TRUE,
                SuccessMessage.FIND_ENTITY_SUCCESS,
                candidateService.getById(id)
        );
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> saveUpdate(@RequestBody CandidateDTO dto) {
        return ResponseGenerator.generate(
                HttpStatus.OK.value(),
                Boolean.TRUE,
                Objects.isNull(dto.getId()) ?
                        SuccessMessage.SAVE_ENTITY_SUCCESS :
                        SuccessMessage.UPDATE_ENTITY_SUCCESS,
                candidateService.saveUpdate(candidateMapper.toEntity(dto), dto.getId())
        );
    }

    @DeleteMapping("/soft-delete/{id}")
    public ResponseEntity<ResponseDTO> softDeleteById(@PathVariable String id) {
        return ResponseGenerator.generate(
                HttpStatus.OK.value(),
                Boolean.TRUE,
                SuccessMessage.DELETE_ENTITY_SUCCESS,
                candidateService.softDeleteById(id));
    }

    @PostMapping("/revert-soft-delete/{id}")
    public ResponseEntity<ResponseDTO> revertSoftDeleteById(@PathVariable String id) {
        return ResponseGenerator.generate(
                HttpStatus.OK.value(),
                Boolean.TRUE,
                SuccessMessage.REVERT_ENTITY_SUCCESS,
                candidateService.revertSoftDeleteById(id));
    }
}

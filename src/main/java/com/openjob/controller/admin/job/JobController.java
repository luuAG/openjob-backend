package com.openjob.controller.admin.job;

import com.openjob.constant.SuccessMessage;
import com.openjob.controller.shared.response.ResponseDTO;
import com.openjob.controller.shared.response.ResponseGenerator;
import com.openjob.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/admin/job")
@RequiredArgsConstructor
public class JobController {
    private final JobService jobService;

    @GetMapping
    public ResponseEntity<ResponseDTO> getAllWithQuery(HttpServletRequest request) {
        return ResponseGenerator.generate(
                HttpStatus.OK.value(),
                Boolean.TRUE,
                SuccessMessage.FIND_ENTITY_SUCCESS,
                jobService.getAll(request.getQueryString())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getById(@PathVariable String id) {
        return ResponseGenerator.generate(
                HttpStatus.OK.value(),
                Boolean.TRUE,
                SuccessMessage.FIND_ENTITY_SUCCESS,
                jobService.getById(id)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> deleteById(@PathVariable String id) {
        return ResponseGenerator.generate(
                HttpStatus.OK.value(),
                Boolean.TRUE,
                SuccessMessage.DELETE_ENTITY_SUCCESS,
                jobService.deleteById(id));
    }

    @DeleteMapping("/soft-delete/{id}")
    public ResponseEntity<ResponseDTO> softDeleteById(@PathVariable String id) {
        return ResponseGenerator.generate(
                HttpStatus.OK.value(),
                Boolean.TRUE,
                SuccessMessage.DELETE_ENTITY_SUCCESS,
                jobService.softDeleteById(id));
    }

    @PostMapping("/revert-soft-delete/{id}")
    public ResponseEntity<ResponseDTO> revertSoftDeleteById(@PathVariable String id) {
        return ResponseGenerator.generate(
                HttpStatus.OK.value(),
                Boolean.TRUE,
                SuccessMessage.REVERT_ENTITY_SUCCESS,
                jobService.revertSoftDeleteById(id));
    }

    @GetMapping("/by-company/{companyId}")
    public ResponseEntity<ResponseDTO> getByCompanyId(@PathVariable String companyId) {
        return ResponseGenerator.generate(
                HttpStatus.OK.value(),
                Boolean.TRUE,
                SuccessMessage.FIND_ENTITY_SUCCESS,
                jobService.getByCompanyId(companyId)
        );
    }


}

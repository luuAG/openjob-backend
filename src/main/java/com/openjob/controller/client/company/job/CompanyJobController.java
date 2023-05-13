package com.openjob.controller.client.company.job;

import com.openjob.constant.SuccessMessage;
import com.openjob.controller.shared.response.ResponseDTO;
import com.openjob.controller.shared.response.ResponseGenerator;
import com.openjob.model.dto.shared.JobDTO;
import com.openjob.model.entity.Company;
import com.openjob.model.mapper.JobMapper;
import com.openjob.service.CompanyService;
import com.openjob.service.JobService;
import com.openjob.service.PriceCalculationService;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.naming.InsufficientResourcesException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("/client/company/job")
@RequiredArgsConstructor
public class CompanyJobController {
    private final JobService jobService;
    private final PriceCalculationService priceCalculationService;
    private final CompanyService companyService;
    private final JobMapper jobMapper;

    @GetMapping("")
    public ResponseEntity<ResponseDTO> getAllJobWithQuery(HttpServletRequest request) {
        return ResponseGenerator.generate(
                HttpStatus.OK.value(),
                Boolean.TRUE,
                SuccessMessage.FIND_ENTITY_SUCCESS,
                jobService.getAll(request.getQueryString())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getJobById(@PathVariable String id) {
        return ResponseGenerator.generate(
                HttpStatus.OK.value(),
                Boolean.TRUE,
                SuccessMessage.FIND_ENTITY_SUCCESS,
                jobService.getById(id)
        );
    }

    @DeleteMapping("/disable/{id}")
    public ResponseEntity<ResponseDTO> disableById(@PathVariable String id) throws MessagingException, TemplateException, IOException {
        return ResponseGenerator.generate(
                HttpStatus.OK.value(),
                Boolean.TRUE,
                SuccessMessage.DELETE_ENTITY_SUCCESS,
                jobService.disable(id));
    }

    @PostMapping("/enable/{id}")
    public ResponseEntity<ResponseDTO> enableById(@PathVariable String id) throws MessagingException, TemplateException, IOException {
        return ResponseGenerator.generate(
                HttpStatus.OK.value(),
                Boolean.TRUE,
                SuccessMessage.REVERT_ENTITY_SUCCESS,
                jobService.enable(id));
    }

    @PostMapping("/calculate-price")
    public ResponseEntity<ResponseDTO> getJobPrice(@RequestBody JobDTO dto) {
        Company company = companyService.getById(dto.getCompanyId());
        return ResponseGenerator.generate(
                HttpStatus.OK.value(),
                Boolean.TRUE,
                "Success",
                priceCalculationService.calculateJobPrice(company, jobMapper.toEntity(dto))
        );
    }

    @PostMapping("/new")
    public ResponseEntity<ResponseDTO> createNewJob(@RequestBody JobDTO dto) throws InsufficientResourcesException {
        return ResponseGenerator.generate(
                HttpStatus.OK.value(),
                Boolean.TRUE,
                SuccessMessage.SAVE_ENTITY_SUCCESS,
                jobService.createNewJob(dto)
        );
    }

    @PostMapping("/edit")
    public ResponseEntity<ResponseDTO> editJob(@RequestBody JobDTO dto) throws MessagingException, TemplateException, IOException {
        return ResponseGenerator.generate(
                HttpStatus.OK.value(),
                Boolean.TRUE,
                SuccessMessage.REVERT_ENTITY_SUCCESS,
                jobService.editJob(dto));
    }

}

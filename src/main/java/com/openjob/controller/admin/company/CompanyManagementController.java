package com.openjob.controller.admin.company;

import com.openjob.constant.SuccessMessage;
import com.openjob.controller.shared.response.ResponseDTO;
import com.openjob.controller.shared.response.ResponseGenerator;
import com.openjob.model.dto.shared.CompanyDTO;
import com.openjob.model.dto.request.NewCompanyDTO;
import com.openjob.model.mapper.CompanyMapper;
import com.openjob.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequestMapping("/admin/company")
@RequiredArgsConstructor
public class CompanyManagementController {
    private final CompanyService companyService;
    private final CompanyMapper companyMapper;

    @GetMapping
    public ResponseEntity<ResponseDTO> getAllWithQuery(HttpServletRequest request) {
        return ResponseGenerator.generate(
                HttpStatus.OK.value(),
                Boolean.TRUE,
                SuccessMessage.FIND_ENTITY_SUCCESS,
                companyService.getAll(request.getQueryString())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getById(@PathVariable String id) {
        return ResponseGenerator.generate(
                HttpStatus.OK.value(),
                Boolean.TRUE,
                SuccessMessage.FIND_ENTITY_SUCCESS,
                companyService.getById(id)
        );
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> saveUpdate(@RequestBody  CompanyDTO dto) {
        return ResponseGenerator.generate(
                HttpStatus.OK.value(),
                Boolean.TRUE,
                Objects.isNull(dto.getId()) ?
                        SuccessMessage.SAVE_ENTITY_SUCCESS :
                        SuccessMessage.UPDATE_ENTITY_SUCCESS,
                companyService.saveUpdate(companyMapper.toEntity(dto), dto.getId())
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> deleteById(@PathVariable String id) {
        return ResponseGenerator.generate(
                HttpStatus.OK.value(),
                Boolean.TRUE,
                SuccessMessage.DELETE_ENTITY_SUCCESS,
                companyService.deleteById(id));
    }

    @DeleteMapping("/soft-delete/{id}")
    public ResponseEntity<ResponseDTO> softDeleteById(@PathVariable String id) {
        return ResponseGenerator.generate(
                HttpStatus.OK.value(),
                Boolean.TRUE,
                SuccessMessage.DELETE_ENTITY_SUCCESS,
                companyService.softDeleteById(id));
    }

    @PostMapping("/revert-soft-delete/{id}")
    public ResponseEntity<ResponseDTO> revertSoftDeleteById(@PathVariable String id) {
        return ResponseGenerator.generate(
                HttpStatus.OK.value(),
                Boolean.TRUE,
                SuccessMessage.REVERT_ENTITY_SUCCESS,
                companyService.revertSoftDeleteById(id));
    }

    @PostMapping("/new")
    public ResponseEntity<ResponseDTO> createNewCompanyAccount(@RequestBody @Valid NewCompanyDTO dto) {
        return ResponseGenerator.generate(
                HttpStatus.OK.value(),
                Boolean.TRUE,
                SuccessMessage.SAVE_ENTITY_SUCCESS,
                companyService.createNewCompanyAccount(dto)
        );
    }

    @PostMapping("/approve/{id}")
    public ResponseEntity<ResponseDTO> approveCompany(@PathVariable String id) {
        return ResponseGenerator.generate(
                HttpStatus.OK.value(),
                Boolean.TRUE,
                SuccessMessage.SAVE_ENTITY_SUCCESS,
                companyService.approveCompanyById(id)
        );
    }
}

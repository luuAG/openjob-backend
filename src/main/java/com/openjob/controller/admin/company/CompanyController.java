package com.openjob.controller.admin.company;

import com.openjob.constant.SuccessMessage;
import com.openjob.controller.shared.controller.BaseController;
import com.openjob.controller.shared.response.ResponseDTO;
import com.openjob.controller.shared.response.ResponseGenerator;
import com.openjob.model.dto.CompanyDTO;
import com.openjob.model.dto.NewCompanyDTO;
import com.openjob.model.entity.Company;
import com.openjob.model.mapper.AccountMapper;
import com.openjob.model.mapper.CompanyMapper;
import com.openjob.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/company")
@RequiredArgsConstructor
public class CompanyController extends BaseController<Company, CompanyDTO> {
    private final CompanyService companyService;
    private final CompanyMapper companyMapper;
    private final AccountMapper accountMapper;
    @Override
    public void init() {
        service = companyService;
        mapper = companyMapper;
    }

    @PostMapping("/new")
    public ResponseEntity<ResponseDTO> create(@RequestBody NewCompanyDTO dto) {
        return ResponseGenerator.generate(
                HttpStatus.OK.value(),
                Boolean.TRUE,
                SuccessMessage.SAVE_ENTITY_SUCCESS,
                mapper.toDTO(
                        companyService.create(
                                companyMapper.toEntity(dto.getCompany()),
                                accountMapper.toEntity(dto.getAccount())
                        )
                )
        );
    }

    @GetMapping("/existsByName/{companyName}")
    public ResponseEntity<ResponseDTO> checkExistByName(@PathVariable String companyName) {
        return ResponseGenerator.generate(
                HttpStatus.OK.value(),
                Boolean.TRUE,
                SuccessMessage.FIND_ENTITY_SUCCESS,
                companyService.existsByName(companyName)
        );
    }

    @PostMapping("/approve/{id}")
    public ResponseEntity<ResponseDTO> approveCompanyById(@PathVariable ObjectId id) {
        return ResponseGenerator.generate(
                HttpStatus.OK.value(),
                Boolean.TRUE,
                SuccessMessage.APPROVE_COMPANY_SUCCESS,
                companyService.approveCompanyById(id)
        );
    }
}

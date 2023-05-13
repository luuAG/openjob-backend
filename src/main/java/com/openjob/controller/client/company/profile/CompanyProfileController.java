package com.openjob.controller.client.company.profile;

import com.openjob.constant.SuccessMessage;
import com.openjob.controller.shared.response.ResponseDTO;
import com.openjob.controller.shared.response.ResponseGenerator;
import com.openjob.model.dto.shared.CompanyDTO;
import com.openjob.model.mapper.CompanyMapper;
import com.openjob.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/client/company/profile")
@RequiredArgsConstructor
public class CompanyProfileController {
    private final CompanyService companyService;
    private final CompanyMapper companyMapper;

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getById(@PathVariable String id) {
        return ResponseGenerator.generate(
                HttpStatus.OK.value(),
                Boolean.TRUE,
                SuccessMessage.FIND_ENTITY_SUCCESS,
                companyService.getById(id)
        );
    }
    @PostMapping("/update")
    public ResponseEntity<ResponseDTO> saveUpdateProfile(@RequestBody CompanyDTO dto) {
        return ResponseGenerator.generate(
                HttpStatus.OK.value(),
                Boolean.TRUE,
                Objects.isNull(dto.getId()) ?
                        SuccessMessage.SAVE_ENTITY_SUCCESS :
                        SuccessMessage.UPDATE_ENTITY_SUCCESS,
                companyService.saveUpdate(companyMapper.toEntity(dto), dto.getId())
        );
    }

}

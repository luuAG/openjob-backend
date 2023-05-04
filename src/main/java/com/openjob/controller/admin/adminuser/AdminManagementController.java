package com.openjob.controller.admin.adminuser;

import com.openjob.constant.SuccessMessage;
import com.openjob.controller.shared.response.ResponseDTO;
import com.openjob.controller.shared.response.ResponseGenerator;
import com.openjob.model.dto.base.BaseUserDTO;
import com.openjob.model.dto.request.NewAdminDTO;
import com.openjob.model.mapper.BaseUserMapper;
import com.openjob.service.BaseUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequestMapping("/admin/adminuser")
@RequiredArgsConstructor
public class AdminManagementController {
    private final BaseUserService baseUserService;
    private final BaseUserMapper baseUserMapper;

    @GetMapping
    public ResponseEntity<ResponseDTO> getAllWithQuery(HttpServletRequest request) {
        return ResponseGenerator.generate(
                HttpStatus.OK.value(),
                Boolean.TRUE,
                SuccessMessage.FIND_ENTITY_SUCCESS,
                baseUserService.getAll(request.getQueryString())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getById(@PathVariable String id) {
        return ResponseGenerator.generate(
                HttpStatus.OK.value(),
                Boolean.TRUE,
                SuccessMessage.FIND_ENTITY_SUCCESS,
                baseUserService.getById(id)
        );
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> saveUpdate(@RequestBody @Valid BaseUserDTO dto) {
        return ResponseGenerator.generate(
                HttpStatus.OK.value(),
                Boolean.TRUE,
                Objects.isNull(dto.getId()) ?
                        SuccessMessage.SAVE_ENTITY_SUCCESS :
                        SuccessMessage.UPDATE_ENTITY_SUCCESS,
                baseUserService.saveUpdate(baseUserMapper.toEntity(dto), dto.getId())
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> deleteById(@PathVariable String id) {
        return ResponseGenerator.generate(
                HttpStatus.OK.value(),
                Boolean.TRUE,
                SuccessMessage.DELETE_ENTITY_SUCCESS,
                baseUserService.deleteById(id));
    }

    @DeleteMapping("/soft-delete/{id}")
    public ResponseEntity<ResponseDTO> softDeleteById(@PathVariable String id) {
        return ResponseGenerator.generate(
                HttpStatus.OK.value(),
                Boolean.TRUE,
                SuccessMessage.DELETE_ENTITY_SUCCESS,
                baseUserService.softDeleteById(id));
    }

    @PostMapping("/revert-soft-delete/{id}")
    public ResponseEntity<ResponseDTO> revertSoftDeleteById(@PathVariable String id) {
        return ResponseGenerator.generate(
                HttpStatus.OK.value(),
                Boolean.TRUE,
                SuccessMessage.REVERT_ENTITY_SUCCESS,
                baseUserService.revertSoftDeleteById(id));
    }

    @PostMapping("/new")
    public ResponseEntity<ResponseDTO> createNewAdminAccount(@RequestBody @Valid NewAdminDTO dto) {
        return ResponseGenerator.generate(
                HttpStatus.OK.value(),
                Boolean.TRUE,
                SuccessMessage.SAVE_ENTITY_SUCCESS,
                baseUserService.createNewAdminAccount(dto)
        );
    }
}

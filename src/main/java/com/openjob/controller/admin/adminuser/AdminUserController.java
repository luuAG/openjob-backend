package com.openjob.controller.admin.adminuser;

import com.openjob.constant.SuccessMessage;
import com.openjob.controller.shared.controller.BaseController;
import com.openjob.controller.shared.response.ResponseDTO;
import com.openjob.controller.shared.response.ResponseGenerator;
import com.openjob.model.dto.NewAdminDTO;
import com.openjob.model.dto.base.BaseUserDTO;
import com.openjob.model.entity.base.BaseUser;
import com.openjob.model.mapper.AccountMapper;
import com.openjob.model.mapper.BaseUserMapper;
import com.openjob.service.BaseUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/adminuser")
public class AdminUserController extends BaseController<BaseUser, BaseUserDTO> {
    private final BaseUserService baseUserService;
    private final BaseUserMapper baseUserMapper;
    private final AccountMapper accountMapper;

    @Override
    public void init() {
        service = baseUserService;
        mapper = baseUserMapper;
    }

    @PostMapping("/new")
    public ResponseEntity<ResponseDTO> create(@RequestBody NewAdminDTO dto) {
        return ResponseGenerator.generate(
                HttpStatus.OK.value(),
                Boolean.TRUE,
                SuccessMessage.SAVE_ENTITY_SUCCESS,
                mapper.toDTO(
                        baseUserService.create(
                                baseUserMapper.toEntity(dto.getAdmin()),
                                accountMapper.toEntity(dto.getAccount())
                        )
                )
        );
    }
}

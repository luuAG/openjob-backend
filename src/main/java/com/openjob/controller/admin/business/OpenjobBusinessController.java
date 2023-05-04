package com.openjob.controller.admin.business;

import com.openjob.constant.SuccessMessage;
import com.openjob.controller.shared.response.ResponseDTO;
import com.openjob.controller.shared.response.ResponseGenerator;
import com.openjob.model.entity.OpenjobBusiness;
import com.openjob.service.OpenjobBusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/business")
@RequiredArgsConstructor
public class OpenjobBusinessController {
    private final OpenjobBusinessService service;

    @GetMapping
    public ResponseEntity<ResponseDTO> getBusiness() {
        return ResponseGenerator.generate(
                HttpStatus.OK.value(),
                Boolean.TRUE,
                SuccessMessage.FIND_ENTITY_SUCCESS,
                service.get()
        );
    }
    @PostMapping
    public ResponseEntity<ResponseDTO> updateBusiness(OpenjobBusiness openjobBusiness) {
        return ResponseGenerator.generate(
                HttpStatus.OK.value(),
                Boolean.TRUE,
                SuccessMessage.UPDATE_ENTITY_SUCCESS,
                service.update(openjobBusiness)
        );
    }

}

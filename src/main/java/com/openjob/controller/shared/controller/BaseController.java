package com.openjob.controller.shared.controller;

import com.openjob.constant.SuccessMessage;
import com.openjob.controller.shared.response.ResponseDTO;
import com.openjob.controller.shared.response.ResponseGenerator;
import com.openjob.model.dto.base.IdentifierDTO;
import com.openjob.model.mapper.BaseMapper;
import com.openjob.service.BaseService;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;


public abstract class BaseController<E, D> {
    protected BaseService<E, ObjectId> service;
    protected BaseMapper<E, D> mapper;

    @PostConstruct
    public abstract void init();

    @GetMapping
    public ResponseEntity<ResponseDTO> getAllWithQuery(HttpServletRequest request) {
        return ResponseGenerator.generate(
                HttpStatus.OK.value(),
                Boolean.TRUE,
                SuccessMessage.FIND_ENTITY_SUCCESS,
                mapper.toDTO(service.getAll(request.getQueryString()))
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getById(@PathVariable ObjectId id) {
        return ResponseGenerator.generate(
                HttpStatus.OK.value(),
                Boolean.TRUE,
                SuccessMessage.FIND_ENTITY_SUCCESS,
                mapper.toDTO(service.getById(id))
        );
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> saveUpdate(@RequestBody D dto) {
        return ResponseGenerator.generate(
                HttpStatus.OK.value(),
                Boolean.TRUE,
                Objects.isNull(((IdentifierDTO) dto).getId()) ?
                        SuccessMessage.SAVE_ENTITY_SUCCESS :
                        SuccessMessage.UPDATE_ENTITY_SUCCESS,
                mapper.toDTO(service.saveUpdate(mapper.toEntity(dto), ((IdentifierDTO) dto).getId()))
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> deleteById(@PathVariable ObjectId id) {
        return ResponseGenerator.generate(
                HttpStatus.OK.value(),
                Boolean.TRUE,
                SuccessMessage.DELETE_ENTITY_SUCCESS,
                service.deleteById(id));
    }

    @DeleteMapping("/soft-delete/{id}")
    public ResponseEntity<ResponseDTO> softDeleteById(@PathVariable ObjectId id) {
        return ResponseGenerator.generate(
                HttpStatus.OK.value(),
                Boolean.TRUE,
                SuccessMessage.DELETE_ENTITY_SUCCESS,
                service.softDeleteById(id));
    }

    @PostMapping("/revert-soft-delete/{id}")
    public ResponseEntity<ResponseDTO> revertSoftDeleteById(@PathVariable ObjectId id) {
        return ResponseGenerator.generate(
                HttpStatus.OK.value(),
                Boolean.TRUE,
                SuccessMessage.REVERT_ENTITY_SUCCESS,
                service.revertSoftDeleteById(id));
    }
}

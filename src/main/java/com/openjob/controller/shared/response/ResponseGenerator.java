package com.openjob.controller.shared.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseGenerator {
    public static ResponseEntity<ResponseDTO> generate(int code, Boolean status, String message, Object data) {
        ResponseDTO responseDTO = ResponseDTO.builder()
                .status(status)
                .message(message)
                .data(data)
                .build();
        return new ResponseEntity<>(responseDTO, HttpStatus.valueOf(code));
    }
}

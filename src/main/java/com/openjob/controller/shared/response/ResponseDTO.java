package com.openjob.controller.shared.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Builder
public class ResponseDTO {
    private Boolean status;
    private String message;
    private Object data;
}

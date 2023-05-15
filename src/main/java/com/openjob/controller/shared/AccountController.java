package com.openjob.controller.shared;

import com.openjob.constant.SuccessMessage;
import com.openjob.controller.shared.response.ResponseDTO;
import com.openjob.controller.shared.response.ResponseGenerator;
import com.openjob.model.dto.request.ForgotPasswordDTO;
import com.openjob.model.dto.request.ResetPasswordDTO;
import com.openjob.service.AccountService;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;


@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;


    @PostMapping("/forgot-password")
    public ResponseEntity<ResponseDTO> createForgotPasswordToken(ForgotPasswordDTO dto) throws MessagingException, TemplateException, IOException {
        return ResponseGenerator.generate(
                HttpStatus.OK.value(),
                Boolean.TRUE,
                SuccessMessage.UPDATE_ENTITY_SUCCESS,
                accountService.createForgotPasswordToken(dto.getEmail())
        );
    }

    @GetMapping("/reset-password")
    public ResponseEntity<ResponseDTO> verifyToken(@RequestParam String username, @RequestParam String token){
        return ResponseGenerator.generate(
                HttpStatus.OK.value(),
                Boolean.TRUE,
                "Token verified",
                accountService.verifyForgotPasswordToken(username, token)
        );
    }

    @PostMapping("/reset-password")
    public ResponseEntity<ResponseDTO> resetPassword(ResetPasswordDTO dto){
        return ResponseGenerator.generate(
                HttpStatus.OK.value(),
                Boolean.TRUE,
                SuccessMessage.UPDATE_ENTITY_SUCCESS,
                accountService.resetPassword(dto.getUsername(), dto.getPassword())
        );
    }
}

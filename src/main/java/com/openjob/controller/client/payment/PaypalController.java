package com.openjob.controller.client.payment;

import com.openjob.constant.SuccessMessage;
import com.openjob.controller.shared.response.ResponseDTO;
import com.openjob.controller.shared.response.ResponseGenerator;
import com.openjob.model.dto.request.PaymentDTO;
import com.openjob.service.PaypalService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client/paypal")
public class PaypalController {
    private final PaypalService paypalService;

    @Value("${server.base_url}")
    private String serverBaseUrl;
    private static final String CANCEL_URL = "/failure";
    private static final String SUCCESS_URL = "/success";

    @PostMapping("/pay")
    public RedirectView createPayment(@RequestBody PaymentDTO dto) {
        try {
            Payment payment = paypalService.createPayment(dto.getPrice(), dto.getCurrency(), dto.getMethod(),
                    dto.getIntent(), dto.getDescription(), serverBaseUrl + CANCEL_URL,
                    serverBaseUrl + SUCCESS_URL);
            for(Links link:payment.getLinks()) {
                if(link.getRel().equals("approval_url")) {
//                    return "redirect:"+link.getHref();
                    return new RedirectView(link.getHref());
                }
            }

        } catch (PayPalRESTException e) {
            e.printStackTrace();
        }
        return new RedirectView(serverBaseUrl + CANCEL_URL);
    }

    @GetMapping(value = CANCEL_URL)
    public String cancelPay() {
        return "cancel";
    }

    @PostMapping(value = SUCCESS_URL)
    public ResponseEntity<ResponseDTO> executePayment(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
        try {
            Payment payment = paypalService.executePayment(paymentId, payerId);
            System.out.println(payment.toJSON());
            if (payment.getState().equals("approved")) {
                return ResponseGenerator.generate(
                        HttpStatus.OK.value(),
                        Boolean.TRUE,
                        SuccessMessage.PAYMENT_SUCCESS,
                        null
                );
            }
        } catch (PayPalRESTException e) {
            System.out.println(e.getMessage());
        }
        return ResponseGenerator.generate(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                Boolean.FALSE,
                SuccessMessage.PAYMENT_FAILURE,
                null
        );
    }
}

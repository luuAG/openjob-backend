package com.openjob.controller.client.payment;

import com.openjob.model.dto.request.PaymentDTO;
import com.openjob.service.PaypalService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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
    public String createPayment(@ModelAttribute PaymentDTO dto) {
        try {
            Payment payment = paypalService.createPayment(dto.getPrice(), dto.getCurrency(), dto.getMethod(),
                    dto.getIntent(), dto.getDescription(), serverBaseUrl + "/client/paypal" + CANCEL_URL,
                    serverBaseUrl+ "/client/paypal" + SUCCESS_URL);
            for(Links link:payment.getLinks()) {
                if(link.getRel().equals("approval_url")) {
//                    return new RedirectView(link.getHref());
                    return link.getHref();
                }
            }

        } catch (PayPalRESTException e) {
            e.printStackTrace();
        }
        return null;
    }



    @PostMapping(value = SUCCESS_URL)
    public String executePayment(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
        try {
            Payment payment = paypalService.executePayment(paymentId, payerId);
            System.out.println(payment.toJSON());
            if (payment.getState().equals("approved")) {
                return "OK";
            }
        } catch (PayPalRESTException e) {
            System.out.println(e.getMessage());
        }
        return "Failed";
    }
}

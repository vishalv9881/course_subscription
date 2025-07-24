package com.example.subscription.system.controller;


import com.example.subscription.system.dto.SubscriptionPaymentRequestDto;
import com.example.subscription.system.dto.SubscriptionPaymentResponseDto;
import com.example.subscription.system.service.SubscriptionPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subscription-payments")
public class SubscriptionPaymentController {


    @Autowired
    private SubscriptionPaymentService subscriptionPaymentService;

    @PostMapping("/create/payment")
    public ResponseEntity<SubscriptionPaymentResponseDto> createSubscriptionPayment(
            @RequestBody SubscriptionPaymentRequestDto requestDto) {

        if (requestDto.getPlanId() == null || requestDto.getPlanId() == 0) {
            throw new IllegalArgumentException("Plan ID must not be null or zero");
        }

        SubscriptionPaymentResponseDto responseDto = subscriptionPaymentService.createSubscriptionPayment(requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }



}

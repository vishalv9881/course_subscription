package com.example.subscription.system.dto;

import com.example.subscription.system.entity.Subscription;
import com.example.subscription.system.enume.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionPaymentResponseDto {


    private Subscription subscription;


    private BigDecimal amount;


    private PaymentStatus paymentStatus;


    private String paymentMethod; // CREDIT_CARD, PAYPAL, etc.


    private String transactionId;


    private LocalDateTime paymentDate;


    private LocalDateTime billingPeriodStart;


    private LocalDateTime billingPeriodEnd;


    private LocalDateTime createdAt;


    public Long UserId;

    public Long id;
    private Long planId;
    private LocalDateTime nextBillingDate;

}

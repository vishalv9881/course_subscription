package com.example.subscription.system.dto;

import com.example.subscription.system.entity.Subscription;
import com.example.subscription.system.enume.PaymentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionPaymentRequestDto {

    private Long id;

    private Subscription subscription;


    private BigDecimal amount;


    private PaymentStatus paymentStatus;


    private String paymentMethod; // CREDIT_CARD, PAYPAL, etc.


    private String transactionId;


    private LocalDateTime paymentDate;


    private LocalDateTime billingPeriodStart;


    private LocalDateTime billingPeriodEnd;


    private LocalDateTime createdAt;
    private LocalDateTime nextBillingDate;

    public Long userId;

    public Long planId;


    private Long subscriptionId;




}

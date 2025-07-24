package com.example.subscription.system.dto;

import com.example.subscription.system.enume.PaymentStatus;
import com.example.subscription.system.enume.SubscriptionAction;
import lombok.*;

import java.math.BigDecimal;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionResponseDto {
    private Long id;
    private Long userId;
    private String planName;
    private SubscriptionAction action;
    private PaymentStatus paymentStatus;
    private Boolean autoRenew;
    private BigDecimal currentPrice;
    private String startDate;
    private String endDate;
    private String nextBillingDate;
    private Double amountPaid;
}
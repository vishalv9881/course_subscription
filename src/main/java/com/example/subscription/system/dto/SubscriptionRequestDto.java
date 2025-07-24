package com.example.subscription.system.dto;

import com.example.subscription.system.enume.PaymentStatus;
import com.example.subscription.system.enume.SubscriptionAction;
import jakarta.persistence.Column;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionRequestDto {
    private Long userId;
    private Long planId;
    private String startDate;
    private String endDate;
    private String action; // enum: CREATED, CANCELLED etc.
    private String paymentStatus; // enum: PENDING, COMPLETED, SUCCESS
    private Boolean autoRenew;
    private Double amountPaid;
    private String planName;
    private String description;
    private BigDecimal price;
    private Integer trialPeriodDays;

    private BigDecimal currentPrice;
    private LocalDate nextBillingDate;
    private  Long subscriptionPaymentId;

    public Long paymentId;

    @Column(name = "payment_date")
    private LocalDate paymentDate;
}

package com.example.subscription.system.dto;

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
public class SubscriptionPlanResponseDto {
    private Long id;
    private String planName;

    private String description;


    private BigDecimal price;


    private Integer trialPeriodDays;


    private LocalDateTime createdAt;
}

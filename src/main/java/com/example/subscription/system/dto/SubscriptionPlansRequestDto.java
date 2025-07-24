package com.example.subscription.system.dto;

import jakarta.persistence.Column;
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
public class SubscriptionPlansRequestDto {
      @Column(name = "plan_id")
    private  Long planId;
    private String planName;


    private String description;


    private BigDecimal price;


    private Integer trialPeriodDays;


    private LocalDateTime createdAt;
}

package com.example.subscription.system.translator;


import com.example.subscription.system.dto.SubscriptionPaymentRequestDto;
import com.example.subscription.system.dto.SubscriptionPaymentResponseDto;
import com.example.subscription.system.entity.SubscriptionPayment;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SubscriptionPaymentTranslator {

    public SubscriptionPayment translateToEntity(SubscriptionPaymentRequestDto dto) {

            SubscriptionPayment entity = new SubscriptionPayment();
            entity.setUserId(dto.getUserId());
            entity.setPlanId(dto.getPlanId());
            entity.setAmount(dto.getAmount());
            entity.setPaymentStatus(dto.getPaymentStatus());
            entity.setPaymentMethod(dto.getPaymentMethod());
            entity.setTransactionId(dto.getTransactionId());
            entity.setBillingPeriodStart(dto.getBillingPeriodStart());
            entity.setBillingPeriodEnd(dto.getBillingPeriodEnd());
            entity.setNextBillingDate(dto.getNextBillingDate());
            entity.setPaymentDate(LocalDateTime.now());
            return entity;
        }


        public SubscriptionPaymentResponseDto translateToDto(SubscriptionPayment entity) {
        SubscriptionPaymentResponseDto dto = new SubscriptionPaymentResponseDto();
        dto.setId(entity.getId());
        dto.setUserId(entity.getUserId());
        dto.setPlanId(entity.getPlanId());
        dto.setAmount(entity.getAmount());
        dto.setPaymentDate(entity.getPaymentDate());
        dto.setPaymentStatus(entity.getPaymentStatus());
        dto.setPaymentMethod(entity.getPaymentMethod());
        dto.setTransactionId(entity.getTransactionId());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setSubscription(entity.getSubscription());
        dto.setBillingPeriodStart(entity.getBillingPeriodStart());
        dto.setBillingPeriodEnd(entity.getBillingPeriodEnd());
        dto.setNextBillingDate(entity.getNextBillingDate());
        return dto;
    }


}

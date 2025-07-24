package com.example.subscription.system.translator;

import com.example.subscription.system.dto.SubscriptionPlanResponseDto;
import com.example.subscription.system.dto.SubscriptionPlansRequestDto;
import com.example.subscription.system.dto.SubscriptionResponseDto;
import com.example.subscription.system.entity.SubscriptionPlans;
import com.example.subscription.system.repository.SubscriptionPlanReository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SubscriptionPlanTranslator {


    @Autowired
    private SubscriptionPlanReository subscriptionPlanReository;

    public SubscriptionPlans translateToEntity(SubscriptionPlansRequestDto subscriptionPlansRequestDto) {
        SubscriptionPlans subscriptionPlan = new SubscriptionPlans();
        subscriptionPlan.setPlanName(subscriptionPlansRequestDto.getPlanName());
        subscriptionPlan.setDescription(subscriptionPlansRequestDto.getDescription());
        subscriptionPlan.setPrice(subscriptionPlansRequestDto.getPrice());
        subscriptionPlan.setTrialPeriodDays(subscriptionPlansRequestDto.getTrialPeriodDays());

        subscriptionPlan.setCreatedAt(LocalDateTime.now());

        subscriptionPlanReository.save(subscriptionPlan);
        return subscriptionPlan;
    }


    public SubscriptionPlanResponseDto translateToDto(SubscriptionPlans subscriptionPlans) {
        SubscriptionPlanResponseDto responseDto = new SubscriptionPlanResponseDto();
        responseDto.setPlanName(subscriptionPlans.getPlanName());
        responseDto.setDescription(subscriptionPlans.getDescription());
        responseDto.setPrice(subscriptionPlans.getPrice());
        responseDto.setTrialPeriodDays(subscriptionPlans.getTrialPeriodDays());
        responseDto.setCreatedAt(subscriptionPlans.getCreatedAt());
        responseDto.setId(subscriptionPlans.getId());
        return responseDto;
    }

}

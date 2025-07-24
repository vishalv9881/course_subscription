package com.example.subscription.system.service;

import com.example.subscription.system.dto.SubscriptionPlanResponseDto;
import com.example.subscription.system.dto.SubscriptionPlansRequestDto;
import com.example.subscription.system.entity.SubscriptionPlans;
import com.example.subscription.system.repository.SubscriptionPlanReository;
import com.example.subscription.system.translator.SubscriptionPlanTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class SubscriptionPlanService {

    @Autowired
    private SubscriptionPlanTranslator translator;
    @Autowired
    private SubscriptionPlanReository subscriptionPlanReository;

    public SubscriptionPlanResponseDto createSubscriptionPlan(SubscriptionPlansRequestDto dto) {
        SubscriptionPlans subscriptionPlans = translator.translateToEntity(dto);
        SubscriptionPlans saved = subscriptionPlanReository.save(subscriptionPlans);
        return translator.translateToDto(saved);
    }

    public SubscriptionPlanResponseDto getSubscriptionPlanById(Long id) {
        SubscriptionPlans subscriptionPlans = subscriptionPlanReository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Subscription Plan not found with id: " + id));
        return translator.translateToDto(subscriptionPlans);
    }

    public List<SubscriptionPlanResponseDto> getAllSubscriptionPlans() {
        List<SubscriptionPlans> subscriptionPlansList = subscriptionPlanReository.findAll();
        return subscriptionPlansList.stream()
                .map(translator::translateToDto)
                .collect(Collectors.toList());
    }

    public SubscriptionPlanResponseDto updateSubscriptionPlan(Long id, SubscriptionPlansRequestDto dto) {
        SubscriptionPlans existingPlan = subscriptionPlanReository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Subscription Plan not found with id: " + id));

        if (dto.getPlanName() != null && !dto.getPlanName().isEmpty()) {
            existingPlan.setPlanName(dto.getPlanName());
        }
        if (dto.getPrice() != null && dto.getPrice().compareTo(BigDecimal.ZERO) > 0) {
            existingPlan.setPrice(dto.getPrice());
        }
        if (dto.getDescription() != null && !dto.getDescription().isEmpty()) {
            existingPlan.setDescription(dto.getDescription());
        }

        SubscriptionPlans updatedPlan = subscriptionPlanReository.save(existingPlan);
        return translator.translateToDto(updatedPlan);
    }
    public void deleteSubscriptionPlan(Long id) {
        SubscriptionPlans existingPlan = subscriptionPlanReository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Subscription Plan not found with id: " + id));
        subscriptionPlanReository.delete(existingPlan);
    }
}

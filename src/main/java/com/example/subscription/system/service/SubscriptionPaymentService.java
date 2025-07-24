package com.example.subscription.system.service;

import com.example.subscription.system.dto.SubscriptionPaymentRequestDto;
import com.example.subscription.system.dto.SubscriptionPaymentResponseDto;
import com.example.subscription.system.entity.Subscription;
import com.example.subscription.system.entity.SubscriptionPayment;
import com.example.subscription.system.entity.SubscriptionPlans;
import com.example.subscription.system.exception.ResourceNotFoundException;
import com.example.subscription.system.repository.SubscriptionPaymentRepository;
import com.example.subscription.system.repository.SubscriptionPlanReository;
import com.example.subscription.system.repository.SubscriptionRepository;
import com.example.subscription.system.translator.SubscriptionPaymentTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubscriptionPaymentService {

    @Autowired
    private SubscriptionPaymentRepository subscriptionPaymentRepository;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private SubscriptionPlanReository subscriptionPlansRepository;

    @Autowired
    private SubscriptionPaymentTranslator subscriptionPaymentTranslator;

    public SubscriptionPaymentResponseDto createSubscriptionPayment(SubscriptionPaymentRequestDto dto) {
        if (dto.getPlanId() == null || dto.getPlanId() == 0) {
            throw new IllegalArgumentException("Plan ID must not be null or zero");
        }
        if (dto.getSubscriptionId() == null || dto.getSubscriptionId() == 0) {
            throw new IllegalArgumentException("Subscription ID must not be null or zero");
        }

        SubscriptionPlans plan = subscriptionPlansRepository.findById(dto.getPlanId())
                .orElseThrow(() -> new ResourceNotFoundException("Subscription Plan not found with id: " + dto.getPlanId()));

        Subscription subscription = subscriptionRepository.findById(dto.getSubscriptionId())
                .orElseThrow(() -> new ResourceNotFoundException("Subscription not found with id: " + dto.getSubscriptionId()));

        SubscriptionPayment payment = subscriptionPaymentTranslator.translateToEntity(dto);

        payment.setSubscription(subscription);
        payment.setPlanName(plan.getPlanName()); // Set plan name properly

        SubscriptionPayment saved = subscriptionPaymentRepository.save(payment);

        return subscriptionPaymentTranslator.translateToDto(saved);
    }

    public SubscriptionPaymentResponseDto getSubscriptionPaymentById(Long id) {
        SubscriptionPayment payment = subscriptionPaymentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Subscription Payment not found with id: " + id));
        return subscriptionPaymentTranslator.translateToDto(payment);
    }

    public void deleteSubscriptionPayment(Long id) {
        SubscriptionPayment payment = subscriptionPaymentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Subscription Payment not found with id: " + id));
        subscriptionPaymentRepository.delete(payment);
    }


}

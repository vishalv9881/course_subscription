package com.example.subscription.system.service;

import com.example.subscription.system.dto.SubscriptionRequestDto;
import com.example.subscription.system.dto.SubscriptionResponseDto;
import com.example.subscription.system.entity.Subscription;
import com.example.subscription.system.repository.SubscriptionRepository;
import com.example.subscription.system.translator.SubscriptionTranslator;
import com.example.subscription.system.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final SubscriptionTranslator translator;

    @Transactional
    public SubscriptionResponseDto createSubscription(SubscriptionRequestDto dto) {
        Subscription subscription = translator.dtoToEntity(dto);
        Subscription saved = subscriptionRepository.save(subscription);
        return translator.entityToDto(saved);
    }

}
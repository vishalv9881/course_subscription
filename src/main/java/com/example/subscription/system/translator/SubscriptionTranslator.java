package com.example.subscription.system.translator;

import com.example.subscription.system.dto.SubscriptionRequestDto;
import com.example.subscription.system.dto.SubscriptionResponseDto;
import com.example.subscription.system.entity.Subscription;
import com.example.subscription.system.entity.SubscriptionPlans;
import com.example.subscription.system.enume.PaymentStatus;
import com.example.subscription.system.enume.SubscriptionAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class SubscriptionTranslator {


@Autowired
private SubscriptionPlanTranslator subscriptionPlanTranslator;

    public Subscription dtoToEntity(SubscriptionRequestDto dto) {
        Subscription subscription = new Subscription();

        subscription.setUserId(dto.getUserId());

        if (dto.getAction() != null) {
            subscription.setAction(SubscriptionAction.valueOf(dto.getAction()));
        }

        if (dto.getPaymentStatus() != null) {
            subscription.setPaymentStatus(PaymentStatus.valueOf(dto.getPaymentStatus()));
        }

        subscription.setAutoRenew(dto.getAutoRenew());
        subscription.setCurrentPrice(dto.getCurrentPrice());
        subscription.setStartDate(LocalDate.parse(dto.getStartDate()));
        subscription.setEndDate(LocalDate.parse(dto.getEndDate()));
        subscription.setAmountPaid(dto.getAmountPaid());
        subscription.setCurrentPrice(dto.getCurrentPrice());

//        subscription.getSubscriptionPaymentId(subscriptionPaymentReository.getId());





        // Plan reference
        if (dto.getPlanId() != null) {
            SubscriptionPlans plan = new SubscriptionPlans();
            plan.setId(dto.getPlanId());
            subscription.setSubscriptionPlans(plan);
        }

        // Payment reference
//        if (dto.getPaymentId() != null) {
//            SubscriptionPayment payment = new SubscriptionPayment();
//            payment.setId(dto.getPaymentId());
//            subscription.setStartDate();ayment(payment);
//        }

        subscription.setNextBillingDate(dto.getNextBillingDate());

        return subscription;
    }

    public SubscriptionResponseDto entityToDto(Subscription subscription) {
        SubscriptionResponseDto dto = new SubscriptionResponseDto();

        dto.setId(subscription.getId());
        dto.setUserId(subscription.getUserId());

//        if (subscription.getAction() != null) {
//            dto.setAction(subscription.getAction().name());
//        }
//
//        if (subscription.getPaymentStatus() != null) {
//            dto.setPaymentStatus(subscription.getPaymentStatus().name());
//        }

        dto.setAutoRenew(subscription.getAutoRenew());
        dto.setCurrentPrice(subscription.getCurrentPrice());
        dto.setStartDate(String.valueOf(subscription.getStartDate()));
        dto.setEndDate(String.valueOf(subscription.getEndDate()));
        dto.setAmountPaid(subscription.getAmountPaid());

        if (subscription.getNextBillingDate() != null) {
            dto.setNextBillingDate(subscription.getNextBillingDate().toString());
        }


        return dto;
    }
}

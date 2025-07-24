package com.example.subscription.system.repository;

import com.example.subscription.system.entity.SubscriptionPlans;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface SubscriptionPlanReository extends JpaRepository<SubscriptionPlans,Long> {
    SubscriptionPlans findByPlanName(String planName);

    <T> ScopedValue<T> findByPrice(BigDecimal price);

}

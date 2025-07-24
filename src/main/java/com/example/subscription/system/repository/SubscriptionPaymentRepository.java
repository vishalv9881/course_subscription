package com.example.subscription.system.repository;

import com.example.subscription.system.entity.SubscriptionPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionPaymentRepository extends JpaRepository<SubscriptionPayment,Long> {
}

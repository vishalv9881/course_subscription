package com.example.subscription.system.repository;

import com.example.subscription.system.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubscriptionRepository extends JpaRepository<Subscription,Long> {

    List<Subscription> findByUserId(Long userId);

}

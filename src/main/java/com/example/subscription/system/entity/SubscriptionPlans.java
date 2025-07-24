package com.example.subscription.system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name = "subscription_plans")


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionPlans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String planName;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "trial_period_days")
    private Integer trialPeriodDays;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    public long getBillingCycle() {
        
        return 30;
    }


//    public void setPlanName(String planName) {
//        if (planName == null || planName.trim().isEmpty()) {
//            throw new IllegalStateException("Subscription plan is not set.");
//        }
//        this.planName = planName;
//    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public SubscriptionPlans orElseThrow(Object o) {
        if (o == null) {
            throw new IllegalStateException("Subscription plan is not set.");
        }
        return (SubscriptionPlans) o;
    }
}

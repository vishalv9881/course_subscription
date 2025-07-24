package com.example.subscription.system.entity;

import com.example.subscription.system.enume.PaymentStatus;
import com.example.subscription.system.enume.SubscriptionAction;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="subscriptions")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SubscriptionAction action;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status")
    private PaymentStatus paymentStatus;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subscription_plans_id")
    private SubscriptionPlans subscriptionPlans;


    private Boolean autoRenew;
    private BigDecimal currentPrice;
    private LocalDate nextBillingDate;

    private Double amountPaid;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "payment_date")
    private LocalDate paymentDate;




    private  Long subscriptionPaymentId;
}

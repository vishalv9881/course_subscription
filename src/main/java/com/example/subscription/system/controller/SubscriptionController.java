package com.example.subscription.system.controller;

import com.example.subscription.system.dto.SubscriptionRequestDto;
import com.example.subscription.system.dto.SubscriptionResponseDto;
import com.example.subscription.system.entity.Subscription;
import com.example.subscription.system.repository.SubscriptionRepository;
import com.example.subscription.system.service.SubscriptionService;
import com.example.subscription.system.translator.SubscriptionTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subscriptions")
@CrossOrigin(origins = "*")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;
    @Autowired
    SubscriptionRepository subscriptionRepository;

    @Autowired
    private SubscriptionTranslator subscriptionTranslator;


    @PostMapping("/create/subscription")
    public ResponseEntity<SubscriptionResponseDto> createSubscription(
            @RequestBody SubscriptionRequestDto requestDto) {

        SubscriptionResponseDto responseDto = subscriptionService.createSubscription(requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }




//    @GetMapping("/subscription/details/{id}")
//    public ResponseEntity<SubscriptionResponseDto> getSubscriptionDetails(@PathVariable Long id) {
//        Subscription subscription = subscriptionRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Subscription not found"));
//
//        // This will include payment and plan details if eagerly loaded
//        SubscriptionResponseDto dto = subscriptionTranslator.entityToDto(subscription);
//        return ResponseEntity.ok(dto);
//    }







//    @GetMapping("/{id}")
//    public ResponseEntity<SubscriptionResponseDto> getSubscriptionById(@PathVariable Long id) {
//        SubscriptionResponseDto responseDto = subscriptionService.getSubscriptionById(id);
//        return ResponseEntity.ok(responseDto);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteSubscription(@PathVariable Long id) {
//        subscriptionService.deleteSubscription(id);
//        return ResponseEntity.ok("Subscription deleted successfully");
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<SubscriptionResponseDto> updateSubscription(
//            @PathVariable Long id,
//            @RequestBody SubscriptionRequestDto requestDto) {
//        SubscriptionResponseDto responseDto = subscriptionService.updateSubscription(id, requestDto);
//        return ResponseEntity.ok(responseDto);
//    }
}

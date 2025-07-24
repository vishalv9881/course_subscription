package com.example.subscription.system.controller;


import com.example.subscription.system.dto.SubscriptionPlanResponseDto;
import com.example.subscription.system.dto.SubscriptionPlansRequestDto;
import com.example.subscription.system.service.SubscriptionPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/subscription-plans")
public class SubscriptionPlanConntroller {

    @Autowired
    private SubscriptionPlanService subscriptionPlanService;

    @PostMapping("/create/plan")
    public ResponseEntity<SubscriptionPlanResponseDto> createSubscriptionPlan(
            @RequestBody SubscriptionPlansRequestDto dto) {

        if (dto.getPlanName() == null || dto.getPlanName().isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        SubscriptionPlanResponseDto subscriptionPlanResponseDto = subscriptionPlanService.createSubscriptionPlan(dto);
        return new ResponseEntity<>(subscriptionPlanResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/get/plan/{id}")
    public ResponseEntity<SubscriptionPlanResponseDto> getSubscriptionPlanById(@PathVariable Long id) {
        SubscriptionPlanResponseDto subscriptionPlanResponseDto = subscriptionPlanService.getSubscriptionPlanById(id);
        if (subscriptionPlanResponseDto == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(subscriptionPlanResponseDto, HttpStatus.OK);
    }
    @GetMapping("/get/all/plans")
    public ResponseEntity<List<SubscriptionPlanResponseDto>> getAllSubscriptionPlans() {
        List<SubscriptionPlanResponseDto> subscriptionPlanResponseDtos = subscriptionPlanService.getAllSubscriptionPlans();
        if (((java.util.List<?>) subscriptionPlanResponseDtos).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(subscriptionPlanResponseDtos, HttpStatus.OK);
    }


    @PutMapping("/update/plan/{id}")
    public ResponseEntity<SubscriptionPlanResponseDto> updateSubscriptionPlan(
            @PathVariable Long id,
            @RequestBody SubscriptionPlansRequestDto dto) {

        if (dto.getPlanName() == null || dto.getPlanName().isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        SubscriptionPlanResponseDto updatedPlan = subscriptionPlanService.updateSubscriptionPlan(id, dto);
        if (updatedPlan == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedPlan, HttpStatus.OK);
    }



    @DeleteMapping("/delete/plan/{id}")
    public ResponseEntity<?> deleteSubscriptionPlan(@PathVariable Long id) {
        try {
            subscriptionPlanService.deleteSubscriptionPlan(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}

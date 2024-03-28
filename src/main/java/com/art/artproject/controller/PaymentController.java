package com.art.artproject.controller;

import com.art.artproject.domain.TalentResponse;
import com.art.artproject.dto.PaymentRequest;
import com.art.artproject.entity.Payment;
import com.art.artproject.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<TalentResponse> createPayment(@RequestParam Long user_id, @RequestParam Long card_id, @RequestBody PaymentRequest paymentRequest){
        Payment payment = paymentService.createPayment(user_id, card_id, paymentRequest);
        TalentResponse response =
                new TalentResponse<>(payment,"Success", HttpStatus.CREATED);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Payment>> showALl(){
        List<Payment> payments = paymentService.showALl();
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

}

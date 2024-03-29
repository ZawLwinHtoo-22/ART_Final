package com.art.artproject.service;

import com.art.artproject.dto.NewCardRequest;
import com.art.artproject.dto.PaymentRequest;
import com.art.artproject.entity.Card;
import com.art.artproject.entity.Payment;

import java.util.List;

public interface PaymentService {

    Payment createPayment(Long user_id,Long card_id, PaymentRequest paymentRequest);

    List<Payment> showALl();
}

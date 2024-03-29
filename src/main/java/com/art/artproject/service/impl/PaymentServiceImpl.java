package com.art.artproject.service.impl;

import com.art.artproject.dto.PaymentRequest;
import com.art.artproject.entity.Card;
import com.art.artproject.entity.Payment;
import com.art.artproject.entity.User;
import com.art.artproject.repo.CardRepo;
import com.art.artproject.repo.PaymentRepo;
import com.art.artproject.repo.UserRepo;
import com.art.artproject.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepo paymentRepo;

    @Autowired
    private CardRepo cardRepo;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserRepo userRepo;

    @Override
    public Payment createPayment(Long user_id, Long card_id, PaymentRequest paymentRequest) {

        Payment payment = mapper.map(paymentRequest, Payment.class);
        Optional<Card> card = cardRepo.findById(card_id);
        Optional<User> user = userRepo.findById(user_id);
        payment.setCard(card.get());
        payment.setUser(user.get());
        payment.setAmount(card.get().getPrice());
        return paymentRepo.save(payment);
    }

    @Override
    public List<Payment> showALl() {
        return paymentRepo.findAll();
    }
}

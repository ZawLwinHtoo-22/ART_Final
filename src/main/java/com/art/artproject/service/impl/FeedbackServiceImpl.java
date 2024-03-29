package com.art.artproject.service.impl;

import com.art.artproject.dto.NewFeedbackRequest;
import com.art.artproject.dto.UserResponse;
import com.art.artproject.entity.Feedback;
import com.art.artproject.entity.Payment;
import com.art.artproject.entity.User;
import com.art.artproject.repo.FeedbackRepo;
import com.art.artproject.repo.UserRepo;
import com.art.artproject.service.FeedbackService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackRepo feedbackRepo;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserRepo userRepo;


    @Override
    public Feedback giveFeedback( Long user_id, NewFeedbackRequest feedbackRequest) {
        Feedback feedback = mapper.map(feedbackRequest, Feedback.class);
        User user = userRepo.findById(user_id).get();
        feedback.setUser(user);
        return feedbackRepo.save(feedback);
    }
}

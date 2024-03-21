package com.art.artproject.service.impl;

import com.art.artproject.dto.NewFeedbackRequest;
import com.art.artproject.dto.UserResponse;
import com.art.artproject.entity.Feedback;
import com.art.artproject.entity.User;
import com.art.artproject.repo.FeedbackRepo;
import com.art.artproject.repo.UserRepo;
import com.art.artproject.service.FeedbackService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackRepo feedbackRepo;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserRepo userRepo;


    @Override
    public Feedback save(NewFeedbackRequest feedbackRequest) {
        Feedback feedback = NewFeedbackRequest.getFeedback (feedbackRequest);
        User user = userRepo.findById(feedbackRequest.getUserID())
                .orElseThrow(() -> new IllegalArgumentException("Invalid ID  " + feedbackRequest.getId()));
        feedback.setUser(user);
        return feedbackRepo.save(feedback);
    }
}

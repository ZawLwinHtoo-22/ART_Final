package com.art.artproject.service;

import com.art.artproject.dto.NewFeedbackRequest;
import com.art.artproject.entity.Feedback;
import jakarta.transaction.Transactional;

public interface FeedbackService {

    Feedback giveFeedback(Long user_id, NewFeedbackRequest feedbackRequest);
}

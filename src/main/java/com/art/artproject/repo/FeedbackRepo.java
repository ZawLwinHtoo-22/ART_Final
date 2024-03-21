package com.art.artproject.repo;

import com.art.artproject.dto.NewFeedbackRequest;
import com.art.artproject.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepo extends JpaRepository<Feedback, Long> {
}

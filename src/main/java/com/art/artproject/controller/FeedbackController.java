package com.art.artproject.controller;

import com.art.artproject.domain.TalentResponse;
import com.art.artproject.dto.NewFeedbackRequest;
import com.art.artproject.entity.Feedback;
import com.art.artproject.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("/feedback")
    public ResponseEntity<Feedback> saveFeedback(@RequestBody NewFeedbackRequest feedbackRequest) {
        Feedback feedback = feedbackService.save(feedbackRequest);
        return new ResponseEntity<>(feedback, HttpStatus.CREATED);
    }

//    @PostMapping
//    public ResponseEntity<Book> saveBook(@RequestBody BookRequest bookRequest) {
//        Book book = bookService.save(bookRequest);
//        return new ResponseEntity<>(book, HttpStatus.CREATED);
//    }

}

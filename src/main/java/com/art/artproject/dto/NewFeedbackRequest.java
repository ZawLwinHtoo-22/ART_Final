package com.art.artproject.dto;

import com.art.artproject.entity.Feedback;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewFeedbackRequest {

    private Long id;
    private String comment;
    private Long userID;

    public static Feedback getFeedback(NewFeedbackRequest feedbackRequest) {
        return new Feedback()
                .builder()
                .id(feedbackRequest.getId())
                .comment(feedbackRequest.getComment())
                .build();


    }


}

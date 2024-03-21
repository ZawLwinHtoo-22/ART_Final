package com.art.artproject.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
public class TalentResponse<T> {
    private String message;
    private HttpStatus httpStatus;
    private LocalDateTime date;
    private T data;
    private Integer httpStatusCode;

    public TalentResponse(T data, String message, HttpStatus httpStatus ) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.httpStatusCode=httpStatus.value();
        this.date = LocalDateTime.now();
        this.data = data;
    }

}
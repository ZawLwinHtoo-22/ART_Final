package com.art.artproject.dto;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewCardRequest {
    private String image;
    private String imageTitle;
    private Double price;
    private String description;
    private Long user_id;
    private Long category_id;
}

package com.art.artproject.dto;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class NewCardRequest {

    private String imageFile;
    private String imageTitle;
    private Double price;
    private String description;
    private Long category_id;
}

package com.art.artproject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FavouriteRequest {

    private Long user_id;
    private Boolean favourite;
}

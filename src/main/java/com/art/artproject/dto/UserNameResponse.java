package com.art.artproject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserNameResponse {
    private String userName;

    public UserNameResponse(String userName) {
        this.userName = userName;
    }

}

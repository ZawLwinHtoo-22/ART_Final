package com.art.artproject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserValidateRequest {

    private String mail;
    private String password;
}

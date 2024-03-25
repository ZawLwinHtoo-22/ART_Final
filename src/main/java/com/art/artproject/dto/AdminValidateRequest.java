package com.art.artproject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminValidateRequest {

    private String mail;
    private String password;

}

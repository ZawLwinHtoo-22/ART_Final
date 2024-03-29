package com.art.artproject.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OTPValidateRequest {

    private String mail;
    private String otp;
}

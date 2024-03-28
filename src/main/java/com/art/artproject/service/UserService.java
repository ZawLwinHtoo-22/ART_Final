package com.art.artproject.service;

import com.art.artproject.domain.OTPValidateRequest;
import com.art.artproject.dto.*;
import com.art.artproject.entity.Feedback;
import com.art.artproject.entity.User;
import com.art.artproject.entity.UserInfo;

import java.util.List;

public interface UserService {
    UserResponse registerUser(NewUserRequest request);

    UserInfo validateUser(UserValidateRequest request);

    List<User> showAll();

    void verifyMailToRegister(String mail);

    boolean validateOTP(OTPValidateRequest request);
}

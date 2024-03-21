package com.art.artproject.service;

import com.art.artproject.dto.NewFeedbackRequest;
import com.art.artproject.dto.NewUserRequest;
import com.art.artproject.dto.UserResponse;
import com.art.artproject.dto.UserValidateRequest;
import com.art.artproject.entity.Feedback;
import com.art.artproject.entity.User;
import com.art.artproject.entity.UserInfo;

import java.util.List;

public interface UserService {
    UserResponse registerUser(NewUserRequest request);

    UserInfo validateUser(UserValidateRequest request);


    List<User> showAll();

}

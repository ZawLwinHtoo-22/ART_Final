package com.art.artproject.service.impl;

import com.art.artproject.dto.NewFeedbackRequest;
import com.art.artproject.dto.NewUserRequest;
import com.art.artproject.dto.UserResponse;
import com.art.artproject.dto.UserValidateRequest;
import com.art.artproject.entity.Feedback;
import com.art.artproject.entity.User;
import com.art.artproject.entity.UserInfo;
import com.art.artproject.repo.UserRepo;
import com.art.artproject.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper mapper;

    @Override
    public UserResponse registerUser(NewUserRequest request) {
        User user=User.of(request);
        return mapper.map(userRepo.save(user),UserResponse.class);
    }

    @Override
    public UserInfo validateUser(UserValidateRequest request) {
        final User user = userRepo
                .findUsersByMail(request.getMail())
                .orElseThrow( () -> new RuntimeException("No User"));

        return UserInfo.of(user);

    }


    public List<User> showAll() {
        return userRepo.findAll();
    }
}
